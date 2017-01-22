/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import objet_metiers.Abonne;
import objet_metiers.Annuaire;
import objet_metiers.Entreprise;
import objet_metiers.Particulier;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Yohann
 */
public class Desinscription extends ActionSupport implements SessionAware{
    private Map<String, Object> session;
    private Session uneSession;
    private Transaction tx;
    
    public String execute() throws Exception {
        uneSession = (Session)session.get("session");
        tx = uneSession.beginTransaction();
        Abonne abo = (Abonne)session.get("unAbon");
        
        if(abo instanceof Particulier){
            uneSession.delete((Particulier)abo);
        }else{
            uneSession.delete((Entreprise)abo);
        }
        tx.commit();
        session.clear();
        return SUCCESS;
    }
    
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
