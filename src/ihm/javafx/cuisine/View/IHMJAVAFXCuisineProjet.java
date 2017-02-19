package ihm.javafx.cuisine.View;

import ihm.javafx.cuisine.model.ListRecette;
import ihm.javafx.cuisine.model.Recette;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 *
 * @author thoma
 */
public class IHMJAVAFXCuisineProjet extends Application {
    private Parent parent;
    private Stage primaryStage;
    
    public void load(String file, Stage stage) throws IOException {        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(file));
        parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("EZCuisine");
        load("FXMLListRecette.fxml", primaryStage);
    }
    
    public void listRecette(ActionEvent e) throws IOException{
        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        load("FXMLListRecette.fxml", stage);
    }
    public void recette(ActionEvent e) throws IOException{
        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        load("FXMLRecette.fxml", stage);
    }
    public void recette(MouseEvent e) throws IOException{
        Stage stage = (Stage) ((ListView) e.getSource()).getScene().getWindow();
        load("FXMLRecette.fxml", stage);
    }
    
   
    public static void main(String[] args) {
        launch(args);
    }
    
}