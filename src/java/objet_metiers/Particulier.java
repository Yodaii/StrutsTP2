/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet_metiers;

import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Yohann
 */
public class Particulier extends Abonne{
    private String identifiant;
    private String nom;
    private String prenom;
    
    public Particulier(){}

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
