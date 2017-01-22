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
import objet_metiers.Message;
import objet_metiers.Particulier;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Yohann
 */
public class ValiderMessage extends ActionSupport implements SessionAware{
    private String objet;
    private String corps;
    private Map<String, Object> session;
    private Session uneSession;
    private Transaction tx;

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
    
    @Override
    public String execute() throws Exception {
        uneSession = HibernateUtil.currentSession();
        tx = uneSession.beginTransaction();
        
        Message message = new Message();
        message.setObjet(objet);
        message.setCorps(corps);
        message.setAbonne((Abonne)session.get("unAbon"));
        uneSession.save(message);
        tx.commit();
        
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
