/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.javafx.cuisine.View;

import java.net.URL;
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
public class FXMLDocumentController implements Initializable {
    
    @FXML
    //private Recette recette = new Recette();
    private VBox ListRecette;
    int i = 0;
            
    @FXML
    private void creerRecetteBouton(ActionEvent event) {
       i++;
       String newRecette = "Nouvelle_recette";
       Label label = new Label();
       label.setText(newRecette);
       label.setId(Integer.toString(i));
       ListRecette.getChildren().add(label);
       
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    
}
