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
public class ValiderInscriptionEntr extends ActionSupport implements ModelDriven, SessionAware{
    private Entreprise uneEntr = new Entreprise();
    private Map<String, Object> session;
    private Session uneSession;
    private Transaction tx;
    
    @Override
    public Object getModel() {
        return uneEntr;
    }
    
    public Entreprise getUneEntr() {
        return uneEntr;
    }

    public void setUneEntr(Entreprise uneEntr) {
        this.uneEntr = uneEntr;
    }
    
    @Override
    public String execute() throws Exception {
        uneSession = HibernateUtil.currentSession();
        Abonne unAbon = (Abonne) uneSession.get(Abonne.class, uneEntr.getIdentifiant());
        if (unAbon!=null)   
         { addActionError("L'abonné existe déjà !");
            return INPUT;
        }
        
        tx = uneSession.beginTransaction();
        
        uneSession.save(uneEntr);
        tx.commit();
        
        session.put("uneEntr", uneEntr);
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
