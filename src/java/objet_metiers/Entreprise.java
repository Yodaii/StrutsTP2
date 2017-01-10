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
public class Entreprise extends Abonne{
    private String identifiant;
    private String raisonSociale;
    
    public Entreprise(){}
    
    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSocial) {
        this.raisonSociale = raisonSocial;
    }
}
