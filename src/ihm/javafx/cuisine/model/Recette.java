/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.javafx.cuisine.model;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elisabeth
 */
  
    public class Recette {
    private String nom;
    private List<String> ingredients = new ArrayList<String>();
    private List<String> materiels = new ArrayList<String>();
    private List<String> liste = new ArrayList<String>();
    private String duree;
    private String picture;
    private String instructions;

 
    
    public Recette(String n, List<String> i, List<String> m, List<String> l, String d, String p, String ins){
        nom = n;
        setAddIngredients(i);
        setAddMateriels(m);
        setAddListes(l);
        duree = d;
        picture = p;
        instructions = ins;
    }
    
    public Recette(String n, List<String> i, List<String> m, List<String> l, String d, String ins){
        nom = n;
        setAddIngredients(i);
        setAddMateriels(m);
        setAddListes(l);
        duree = d;
        instructions = ins;
    }
    
    /*Methods*/
    public List<String> getIngredients(){
        return ingredients;
    }
    
    public String getAllIngredients(){
    String all = "Ingredients : ";
        for(String i : ingredients){
            all+= i + ", ";
        }
        return all;
    }
    
    public void setAddIngredients(List<String> list){
        for(String s : list){
            if(!(s.contains("ngredient")||s.contains("ngrédient")||s.contains(":"))){
                ingredients.add(s);
            }else{
                String[] splitS = s.split(" ");
                if(splitS.length == 3){
                    ingredients.add(splitS[2]);
                }
            }
        }
    }
    
    public List<String> getMateriels(){
        return materiels;
    }
    
    public String getAllMateriels(){
        String all = "Matériels : ";
        for(String i : materiels){
            all+= i + ", ";
        }
        return all;
    }
    
    public void setAddMateriels(List<String> list){
        for(String s : list){
            if(!(s.contains("ateriel")||s.contains("atériel")||s.contains(":"))){
                materiels.add(s);
            }else{
                String[] splitS = s.split(" ");
                if(splitS.length == 3){
                    materiels.add(splitS[2]);
                }
            }
        }
    }
    
    public List<String> getListe(){
        return liste;
    }
    
    public String getAllListe(){
        String all = "Listes : ";
        for(String i : liste){
            all+= i + ", ";
        }
        return all;
    }
    
    public void setAddListes(List<String> list){
        for(String s : list){
            if(!(s.contains("liste")||s.contains("Liste")||s.contains(":"))){
                liste.add(s);
            }else{
                String[] splitS = s.split(" ");
                if(splitS.length == 3){
                    liste.add(splitS[2]);
                }
            }
        }
    }
   
    public String getNom(){
        return nom;
    }
    
    public void setNom(String n){
        nom = n;
    }
    
    public String getPicture(){
        return picture;
    }
    
    public void setPicture(String p){
        picture = p;
    }
    
    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
        
    }
    
    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String intructions) {
        this.instructions = intructions;
    }
}
