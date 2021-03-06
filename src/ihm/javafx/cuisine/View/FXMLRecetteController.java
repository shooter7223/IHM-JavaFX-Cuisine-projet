/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.javafx.cuisine.View;

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
public class FXMLRecetteController implements Initializable {

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
    @FXML
    private TextArea InstrucTextArea;
    @FXML
    private ImageView ImagePrincipale;
    @FXML
    private Image testImg;
    
    @FXML
    public void modifRecette(ActionEvent e){
        saveRecetteButton.setVisible(true);
        modifRecetteButton.setVisible(false);
        modifEdition(true);
    }
    
    @FXML
    public void saveRecette(ActionEvent e){
        modifRecetteButton.setVisible(true);
        saveRecetteButton.setVisible(false);
        modifEdition(false);
    }
    
    @FXML
    public void supprRecette(ActionEvent e){
        //TODO
    }
    
    public void modifEdition(boolean bool){
        IngredientDisplay.setEditable(bool);
        InstrucTextArea.setEditable(bool);
        TempsDisplay.setEditable(bool);
        ListeDisplay.setEditable(bool);
        MaterielDisplay.setEditable(bool);
    }
    
    @FXML
    public void InitRecette(Recette r){
        IngredientDisplay.setText(r.getAllIngredients());
        MaterielDisplay.setText(r.getAllMateriels());
        ListeDisplay.setText(r.getAllListe());
        if(r.getPictures() != null){
            Image pic = new Image("file:smallCookie.png");
            ImagePrincipale.setImage(pic);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<String> ing = new ArrayList<String>();
        List<String> mat = new ArrayList<String>();
        List<String> lis = new ArrayList<String>();
        ing.add("oeuf");
        mat.add("spatule");
        lis.add("dessert");
        List<String> pic = new ArrayList<String>();
        pic.add("file:smallCookie.png");
        
        Recette re = new Recette("cookie", ing, mat, lis, 30.5, pic);
        InitRecette(re);
    }    
    
}