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
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author arthu
 */
public class ValiderAnnuaire extends ActionSupport implements ModelDriven, SessionAware{
    private Annuaire unAnnuaire = new Annuaire();
    private Map<String, Object> session;
    private Session uneSession;
    private Transaction tx;
    
    @Override
    public Object getModel() {
        return unAnnuaire;
    }
    
    public Annuaire getUnAnnu() {
        return unAnnuaire;
    }

    public void setUnAnnu(Annuaire unAnnu) {
        this.unAnnuaire = unAnnu;
    }
    
    @Override
    public String execute() throws Exception {
        uneSession = HibernateUtil.currentSession();
        Annuaire unAnnu = (Annuaire) uneSession.get(Annuaire.class, unAnnuaire.getNom());
        if (unAnnu!=null)   
         { addActionError("L'annuaire existe déjà !");
            return INPUT;
        }
        
        tx = uneSession.beginTransaction();
        
        uneSession.save(unAnnu);
        tx.commit();
        
        session.put("unAbon", unAnnu);
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
