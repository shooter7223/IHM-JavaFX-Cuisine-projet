/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.javafx.cuisine.projet;

import java.util.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Duration;

/**
 *
 * @author Elisabeth
 */
public class Recette {
    private String nom;
    private List<String> ingredients = new ArrayList<String>();
    private List<String> materiels = new ArrayList<String>();
    private List<String> liste = new ArrayList<String>();
    private Duration duree;
    private List<String> pictures = new ArrayList<String>();
    
    public Recette(String n, List<String> i, List<String> m, List<String> l, double d, List<String> p){
        nom = n;
        ingredients = i;
        materiels = m;
        liste = l;
        duree.minutes(d);
        pictures = p;
    }
    
    public Recette(String n, List<String> i, List<String> m, List<String> l, double d){
        nom = n;
        ingredients = i;
        materiels = m;
        liste = l;
        duree.minutes(d);
    }
    
    /*Methods*/
    List<String> getIngredients(){
        return ingredients;
    }
    
    String getAllIngredients(){
        String all = "Ingredients : \n";
        for(String i : ingredients){
            all+= i + '\n';
        }
        return all;
    }
    
    void setAddIngredient(String s){
        if(!(s.contains("ngredient")&&s.contains("ngrédient")))
            ingredients.add(s);
    }
    
    List<String> getMateriels(){
        return ingredients;
    }
    
    String getAllMateriels(){
        String all = "Matériels : \n";
        for(String i : materiels){
            all+= i + '\n';
        }
        return all;
    }
    
    void setAddMateriel(String s){
        if(!(s.contains("ateriel")&&s.contains("atériel")))
            materiels.add(s);
    }
    
        List<String> getListe(){
        return ingredients;
    }
    
    String getAllListe(){
        String all = "Listes : \n";
        for(String i : liste){
            all+= i + '\n';
        }
        return all;
    }
    
    void setAddListe(String s){
        if(!(s.contains("liste")&&s.contains("Liste")))
            materiels.add(s);
    }
   
    String getNom(){
        return nom;
    }
    
    void setNom(String n){
        nom = n;
    }
    
    List<String> getPictures(){
        return pictures;
    }
    
    String getMainPicture(){
        /*if(pictures != null){
            return pictures.get(0);
        }
        else
            return "erreur, image manquante";*/
        return pictures.get(0);
    }
    
    void setAddPicture(String s){
        pictures.add(s);
    }
}
