/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.javafx.cuisine.View;

import ihm.javafx.cuisine.model.Recette;
import java.io.IOException;
import javafx.scene.image.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 *
 * @author thoma
 */
public class FXMLListRecetteController  {
    
    IHMJAVAFXCuisineProjet fenetre = new IHMJAVAFXCuisineProjet();//objet pour faire la liaison
    public static List<Recette> listR = new ArrayList<Recette>();
    public static List<String> listNom = new ArrayList<String>();
    public static List<String> listListe = new ArrayList<String>();
    public static Recette recetteActuelle = null;
    
    @FXML ComboBox listListes;
    @FXML TextField creerListeText;
    @FXML TextField searchText;
    @FXML
    private ListView listrecette;
    
    static int indiceRecetteAct = 0;
    static int unique = 0;
    int i = 0;
            
    @FXML
    private void creerRecetteBouton(ActionEvent event) throws IOException {
        recetteActuelle = null;
        fenetre.recette(event);//ouverture de la fenetre de recette
    }
    @FXML
    private void creerListe(ActionEvent event) throws IOException{
        String text = creerListeText.getText();
        if((text !=null) && !(text.isEmpty())){
            if(!listListe.contains(text)){
                listListe.add(text);
            }else{
                creerListeText.setText("Erreur, existe déjà");
            }
        }else{
            creerListeText.setText("Mettre un nom valide ici");
        }
        creerListeText.setText("");
        listListes.setItems(FXCollections.observableArrayList(listListe));
    }
    
    @FXML
    private void trierNomBouton(ActionEvent event) throws IOException {
        List<Recette> tmpList = new ArrayList<Recette>();
        tmpList = listR;
        Collections.sort(tmpList, new Comparator<Recette>(){
            public int compare(Recette o1, Recette o2){
                return o1.getNom().compareTo(o2.getNom());
            }
        });
        listNom.clear();
        for(Recette r : tmpList){
            listNom.add(r.getNom()+"\t\t"+r.getDuree());
        }
        listrecette.setItems(FXCollections.observableArrayList(listNom));
    }
    @FXML
    private void trierTempsBouton(ActionEvent event) throws IOException {
        List<Recette> tmpList = new ArrayList<Recette>();
        tmpList = listR;
        Collections.sort(tmpList, new Comparator<Recette>(){
            public int compare(Recette o1, Recette o2){
                String[] s1 = o1.getDuree().split(" ");
                String[] s2 = o2.getDuree().split(" ");
                if(s1.length >=3 && s2.length >= 3){
                    int d1, d2;
                    d1 = Integer.parseInt(s1[2]);
                    d2 = Integer.parseInt(s2[2]);
                    return d1 < d2 ? -1 : 1;
                }
                return 0;
            }
        });
        listNom.clear();
        for(Recette r : tmpList){
            listNom.add(r.getNom()+"\t\t"+r.getDuree());
        }
        listrecette.setItems(FXCollections.observableArrayList(listNom));
    }
    
    @FXML
    private void search(ActionEvent e){
        String text = searchText.getText();
        List<String> toDisplay = new ArrayList<String>();
        if((text !=null) && !(text.isEmpty())){
            for(Recette recette : listR){
                if(recette.getAllListe().contains(text)||recette.getAllIngredients().contains(text)||
                        recette.getAllMateriels().contains(text)||recette.getNom().contains(text)){
                    toDisplay.add(recette.getNom() + "\t\t" + recette.getDuree());
                }
            }
            listrecette.setItems( FXCollections.observableArrayList(toDisplay) );
        }
    }
    
    @FXML
    private void listClick(MouseEvent event) throws IOException{
        String click = (String)listrecette.getSelectionModel().getSelectedItem();
        if(click != null){
            String[] clickSplit = click.split("\t\t");
            int indice = 0;
            for(Recette r : listR){
                indice++;
                if(r.getNom().equals(clickSplit[0])&&r.getDuree().equals(clickSplit[1])){
                    recetteActuelle = r;
                    indiceRecetteAct = indice -1;
                }
            }
            fenetre.recette(event);
        }
    }
    
    public static void ajoutRecette(Recette recette){
        for(String s : recette.getListe()){
            if(!listListe.contains(s)){
                listListe.add(s);
            }
        }
        listR.add(recette);
        listNom.add(recette.getNom() + "\t\t" + recette.getDuree());
    }
    
    public static void modifRecette(Recette recette){
        for(String s : recette.getListe()){
            if(!listListe.contains(s)){
                listListe.add(s);
            }
        }
        listR.set(indiceRecetteAct, recette);
        listNom.set(indiceRecetteAct, recette.getNom() + "\t\t" + recette.getDuree());
    }
    
    public static void supprRecette(){
        listNom.remove(indiceRecetteAct);
        listR.remove(indiceRecetteAct);
        indiceRecetteAct = -1;
        recetteActuelle = null;
    }
    
    public void initialize() {//Initialisation est création d'une recette de gateau
        if(unique == 0){
            List<String> ing = new ArrayList<String>();
            List<String> mat = new ArrayList<String>();
            List<String> lis = new ArrayList<String>();
            ing.add("Oeuf 4");
            ing.add("Farine 90g");
            ing.add("Sucre 150g");
            ing.add("Chocolat 150g");
            mat.add("Spatule");
            mat.add("Fouet");
            lis.add("Dessert");
            lis.add("Gouter");
            lis.add("Matin");
            listListe.addAll(lis);
            String pic = "http://images.bigoven.com/image/upload/t_recipe-256/unbelievable-passover-chocolate-chi.jpg";
            String temps = "Temps : 30 minutes";
        
            Recette r1 = new Recette("Cookie", ing, mat, lis, temps, pic, "Extraire les jaunes d'oeufs\nMélanger tout\nFaire cuire 7 minutes au four à 180C.");
            listListe.add("Toutes");
            listListes.setItems(FXCollections.observableArrayList(listListe));
            listR.add(r1);
            listNom.add(r1.getNom() + "\t\t" + r1.getDuree());
            unique ++;
        }
        listrecette.setItems( FXCollections.observableArrayList(listNom) );
        listListes.setItems(FXCollections.observableArrayList(listListe));
        listListes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue != null){
                    List<String> toDisplay = new ArrayList<String>();
                    if(newValue.equals("Toutes")){
                        listrecette.setItems( FXCollections.observableArrayList(listNom) );
                    }else{
                        //List<Recette> selectR = listR;
                        for(Recette recette : listR){
                            if(recette.getAllListe().contains(newValue)){
                                toDisplay.add(recette.getNom() + "\t\t" + recette.getDuree());
                            }
                        }
                        listrecette.setItems( FXCollections.observableArrayList(toDisplay) );
                    }
                }
        }
});
    }  
    
    private static String getResource(String filename)
    {
        return FXMLListRecetteController.class.getResource(filename).toString();
    }
    
    
}
