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
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 *
 * @author thoma
 */
public class FXMLListRecetteController  {
    
    IHMJAVAFXCuisineProjet fenetre = new IHMJAVAFXCuisineProjet();//objet pour faire la liaison
    public List<Recette> listR = new ArrayList<Recette>();
    
    @FXML
    private ListView listrecette;
    
    
    int i = 0;
            
    @FXML
    private void creerRecetteBouton(ActionEvent event) throws IOException {
       fenetre.recette(event);//ouverture de la fenetre de recette
    }
    
    
    
    public void initialize() {//Initialisation est création d'une recette de gateau
        // TODO
        Recette r1 = new Recette();
        r1.nom = "Gateau leger au chocolat";
        r1.listes ="-150g de chocolat noir à croquer \n-80g de farine \n-100g de sucre \n-4 oeufs \n-1 sachet de levure chimique \n";
        Image i1;
        i1 = new Image(getResource("dc080e6d-74bd-4765-9b8a-bcba7e386f65_normal.jpg"));
        r1.image.add(i1);
        r1.tempsCuisson = "35 minutes";
        listR.add(r1);
        
        listrecette.setItems( FXCollections.observableArrayList(listR) );
        
    }  
    
    private static String getResource(String filename)
    {
        return FXMLListRecetteController.class.getResource(filename).toString();
    }
    
    
}
