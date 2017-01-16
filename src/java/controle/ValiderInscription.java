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
import objet_metiers.Particulier;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Yohann
 */
public class ValiderInscription extends ActionSupport implements ModelDriven, SessionAware{
    private Particulier unPart = new Particulier();
    private Map<String, Object> session;
    private Session uneSession;
    private Transaction tx;
    
    @Override
    public Object getModel() {
        return unPart;
    }
    
    public Particulier getUnPart() {
        return unPart;
    }

    public void setUnPart(Particulier unPart) {
        this.unPart = unPart;
    }
    
    @Override
    public String execute() throws Exception {
        uneSession = HibernateUtil.currentSession();
        Abonne unAbon = (Abonne) uneSession.get(Abonne.class, unPart.getIdentifiant());
        if (unAbon!=null)   
         { addActionError("L'abonné existe déjà !");
            return INPUT;
        }
        
        tx = uneSession.beginTransaction();
        
        uneSession.save(unPart);
        tx.commit();
        
        session.put("unAbon", unPart);
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
