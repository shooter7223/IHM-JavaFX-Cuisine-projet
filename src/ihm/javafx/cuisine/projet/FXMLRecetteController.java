/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.javafx.cuisine.projet;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author Elisabeth
 */
public class FXMLRecetteController implements Initializable {

    /**
     * Initializes the controller class.
    */
    @FXML
    /*Recupération des objets du fxml*/
    private TextArea Ingredients;
    private Button ModifRecetteButton;
    private Button SaveRecetteButton;
    
    @FXML
    public void modifRecette(ActionEvent e){
        //ModifRecetteButton.setVisible(false);
        SaveRecetteButton.setVisible(true);
        //Ingredients.setEditable(true);
    }
    
    public void saveRecette(ActionEvent e){
        ModifRecetteButton.setVisible(true);
        SaveRecetteButton.setDisable(true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
