/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.javafx.cuisine.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.ReadOnlyListWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author thoma
 */
public class ListRecette {
    private ReadOnlyListWrapper<Recette> listeRecette = new ReadOnlyListWrapper<>();
    private final DoubleProperty valeur = new SimpleDoubleProperty();
    
    public ListRecette() {
        ObservableList<Recette> list = FXCollections.observableArrayList();
        listeRecette = new ReadOnlyListWrapper<>(list);
    }
    
    public double getValeur() {
        return valeur.get();
    }

    public void setValeur(double value) {
        valeur.set(value);
    }

    public DoubleProperty valeurProperty() {
        return valeur;
    }
    
    public ObservableList getListeRecette() {
        return listeRecette.get();
    }

    public ReadOnlyListProperty listeActionProperty() {
        return listeRecette.getReadOnlyProperty();
    }
    
    public void ajouterRecette(Recette recette) {
        listeRecette.add(recette);
        //valeur.set(valeur.get() + recette.getRecette());
    }
    
}
