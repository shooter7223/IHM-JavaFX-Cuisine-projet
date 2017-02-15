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
 * @author thoma
 */
public class Recette 
{
    public String nom = null;
    public String materiels = null;
    public String listes = null;
    public String tempsCuisson = null;
    public String description = null;
    public List<Image> image = new ArrayList<Image>();
    
    public Recette(){}
        
    
}
