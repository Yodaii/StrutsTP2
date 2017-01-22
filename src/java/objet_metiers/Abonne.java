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
public class Abonne {
    private String identifiant;
    private String motdepasse;
    private boolean estAdmin;
    private Annuaire annuaire;
    private Set<Message> lesMessages = new HashSet<>();
    
    public Abonne(){}

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public boolean isEstAdmin() {
        return estAdmin;
    }

    public void setEstAdmin(boolean estAdmin) {
        this.estAdmin = estAdmin;
    }

    public Annuaire getAnnuaire() {
        return annuaire;
    }

    public void setAnnuaire(Annuaire annuaire) {
        this.annuaire = annuaire;
    }
    
    public Set<Message> getLesMessages() {
        return lesMessages;
    }

    public void setLesMessages(Set<Message> lesMessages) {
        this.lesMessages = lesMessages;
    }
}