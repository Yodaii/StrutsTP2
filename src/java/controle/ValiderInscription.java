/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import objet_metiers.Abonne;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Yohann
 */
public class ValiderInscription extends ActionSupport implements ModelDriven, SessionAware{
    private Abonne unAbon = new Abonne();
    private Map<String, Object> session;
    
    @Override
    public Object getModel() {
        return unAbon;
    }
    
    public Abonne getUnAbon() {
        return unAbon;
    }

    public void setUnAbon(Abonne unAbon) {
        this.unAbon = unAbon;
    }
    
    @Override
    public String execute() throws Exception {
        Session uneSession = HibernateUtil.currentSession();
        
        Abonne unAbon2 = (Abonne)uneSession.get(Abonne.class, unAbon.getIdentifiant());
        
        if(unAbon2!=null){
            return INPUT;
        }
        
        Transaction tx = uneSession.beginTransaction();
        
        uneSession.save(unAbon);
        tx.commit();
        
        session.put("unAbon", unAbon);
        System.out.println("Ajout dans l'annuaire de l'abonne " + unAbon.getNom());
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
