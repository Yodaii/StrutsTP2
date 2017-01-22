/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet_metiers;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Yohann
 */
public class Annuaire {
    private String nom;
    private Set<Abonne> listeAbonne = new HashSet<>();
    
    public Annuaire(){}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public Set<Abonne> getListeAbonne(){
        return listeAbonne;
    }
    
    public void setListeAbonne(Set<Abonne> listeAbonne) {
        this.listeAbonne = listeAbonne;
    }
}
