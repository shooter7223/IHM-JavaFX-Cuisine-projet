/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.javafx.cuisine.View;

import ihm.javafx.cuisine.model.Recette;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author Elisabeth
 */
public class FXMLRecetteController {
    IHMJAVAFXCuisineProjet fenetre = new IHMJAVAFXCuisineProjet();//objet pour faire la liaison
    /**
     * Initializes the controller class.
    */
    @FXML
    private TextArea IngredientDisplay;
    @FXML
    private TextArea MaterielDisplay;
    @FXML
    private TextArea ListeDisplay;
    @FXML
    private TextArea TempsDisplay;
    @FXML
    private Button modifRecetteButton;
    @FXML
    private Button saveRecetteButton;
    @FXML private Button retourButton;
    @FXML
    private TextArea InstrucTextArea;
    @FXML
    private ImageView ImagePrincipale;
    @FXML
    private Image testImg;
    @FXML private TextField nomField;
    @FXML private TextField imgText;
    
    private boolean newRecette;
    
    @FXML
    public void modifRecette(ActionEvent e){
        saveRecetteButton.setVisible(true);
        modifRecetteButton.setVisible(false);
        modifEdition(true);
    }
    @FXML
    public void retourButton(ActionEvent event) throws IOException {
        FXMLListRecetteController.recetteActuelle = null;
        fenetre.listRecette(event);
    }
    
    @FXML
    public void saveRecette(ActionEvent event) throws IOException{
        modifRecetteButton.setVisible(true);
        saveRecetteButton.setVisible(false);
        modifEdition(false);
        List<String> ing = new ArrayList<String>();
        List<String> mat = new ArrayList<String>();
        List<String> lis = new ArrayList<String>();
        ing = ajoutListe(IngredientDisplay.getText().split(", "), ing);
        mat = ajoutListe(MaterielDisplay.getText().split(", "), mat);
        lis = ajoutListe(ListeDisplay.getText().split(", "), lis);
        Recette r = new Recette(nomField.getText(), ing, mat, lis, TempsDisplay.getText(), imgText.getText(), InstrucTextArea.getText());
        if(newRecette){
            FXMLListRecetteController.ajoutRecette(r);
            fenetre.listRecette(event);
        }else{
            FXMLListRecetteController.modifRecette(r);
        }
        
    }
    private List ajoutListe(String[] tabString, List<String> arrString){
        for(int i = 0; i < tabString.length; i++){
            arrString.add(tabString[i]);
        }
        return arrString;
    }
    
    @FXML
    public void supprRecette(ActionEvent event) throws IOException{
        FXMLListRecetteController.supprRecette();
        fenetre.listRecette(event);
    }
    
    public void modifEdition(boolean bool){
        nomField.setEditable(bool);
        imgText.setEditable(bool);
        IngredientDisplay.setEditable(bool);
        InstrucTextArea.setEditable(bool);
        TempsDisplay.setEditable(bool);
        ListeDisplay.setEditable(bool);
        MaterielDisplay.setEditable(bool);
    }
    
    @FXML
    public void InitRecette(Recette r){
        nomField.setText(r.getNom());
        TempsDisplay.setText(r.getDuree());
        InstrucTextArea.setText(r.getInstructions());
        IngredientDisplay.setText(r.getAllIngredients());
        MaterielDisplay.setText(r.getAllMateriels());
        ListeDisplay.setText(r.getAllListe());
        if(r.getPicture() != null && !(r.getPicture().isEmpty())){
            System.out.println("img");
            imgText.setText(r.getPicture());
            Image pic = new Image(r.getPicture());
            ImagePrincipale.setImage(pic);
        }
    }
    
    
    public void initialize() {
        // TODO
       if(FXMLListRecetteController.recetteActuelle != null){
           modifEdition(false);
           InitRecette(FXMLListRecetteController.recetteActuelle);
       }else{
           saveRecetteButton.setVisible(true);
           modifRecetteButton.setVisible(false);
           nomField.setText("Entrez le nom");
           modifEdition(true);
           newRecette = true;
       }
    }  
    
}