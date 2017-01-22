/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import objet_metiers.Abonne;
import objet_metiers.Annuaire;
import objet_metiers.Entreprise;
import objet_metiers.Particulier;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Yohann
 */
public class ValiderInscriptionEntr extends ActionSupport implements SessionAware {

    private String identifiant;
    private String motdepasse;
    private String raisonSociale;
    private String annuaire;
    private Map<String, Object> session;
    private Session uneSession;

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

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getAnnuaire() {
        return annuaire;
    }

    public void setAnnuaire(String annuaire) {
        this.annuaire = annuaire;
    }

    @Override
    public String execute() throws Exception {
        uneSession = HibernateUtil.currentSession();
        Abonne unAbon = (Abonne) uneSession.get(Abonne.class, identifiant);
        if (unAbon != null) {
            addActionError("L'abonné existe déjà !");
            return INPUT;
        }

        try {
            uneSession.getTransaction().begin();
            Annuaire annu = (Annuaire) uneSession.get(Annuaire.class, annuaire);
            Entreprise uneEntr = new Entreprise();
            uneEntr.setIdentifiant(identifiant);
            uneEntr.setMotdepasse(motdepasse);
            uneEntr.setRaisonSociale(raisonSociale);
            uneEntr.setAnnuaire(annu);
            uneSession.save(uneEntr);
            uneSession.getTransaction().commit();

            session.put("annuaire", annu);
            session.put("unAbon", uneEntr);
            session.put("session", uneSession);
        } catch(RuntimeException e){
            uneSession.getTransaction().rollback();
        }
        
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
