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
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Yohann
 */
public class GetMessagesAnnuaire extends ActionSupport implements SessionAware{
    private Map<String, Object> session;
    private Session uneSession;
    
    public String execute() throws Exception {
        uneSession = HibernateUtil.currentSession();
        Annuaire annuaire = (Annuaire)session.get("annuaire");
        
        String hql = "SELECT m FROM Message m, Abonne a WHERE a  = m.abonne AND a.annuaire=:annuaire ORDER BY m.id desc";
        Query query = uneSession.createQuery(hql);
        query.setParameter("annuaire", annuaire);
        session.put("messages", query.list());
        
        hql = "SELECT a FROM Abonne a WHERE a.annuaire=:annuaire";
        query = uneSession.createQuery(hql);
        query.setParameter("annuaire", annuaire);
        session.put("abonnes", query.list());
        
        return SUCCESS;
    }
    
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
