/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet_metiers;

/**
 *
 * @author Yohann
 */
public class Message {
    private int id;
    private String objet;
    private String corps;
    private Abonne abonne;
    
    public Message(){}

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }
}
