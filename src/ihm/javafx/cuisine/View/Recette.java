/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.javafx.cuisine.View;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author thoma
 */
public class Recette {
    
    private String nom;
    //private ObservableList<String> itemsRecette;
    
    public Recette(){
       this.nom = new String();
       //itemsRecette = FXCollections.observableArrayList();
       //itemsRecette.add("liste vide");
    }
    
    /*public ObservableList getItemsRcette()
    {
        return itemsRecette;
    }
    public void setItemsRecette(String newRecette)
    {
        itemsRecette.add(newRecette);
    }
    
    public String getnom(int i){
        return itemsRecette.get(i);
    }*/
    
    public String getnom(int i){
        return nom;
    }
    public void setnom(String nom_){
         this.nom = nom_;
    }
    
}
