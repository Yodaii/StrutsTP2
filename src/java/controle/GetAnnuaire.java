/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import objet_metiers.Annuaire;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Yohann
 */
public class GetAnnuaire extends ActionSupport implements SessionAware{
    private Map<String, Object> session;
    private Session uneSession;
    
    public String execute() throws Exception {
        uneSession = HibernateUtil.currentSession();
        List<Annuaire> annuaires = (List<Annuaire>)uneSession.createCriteria(Annuaire.class).list();
        
        if(annuaires.isEmpty()){
            return INPUT;
        }else{
            List<String> nomAnnuaires = new ArrayList<>();
            for(Annuaire a : annuaires){
                nomAnnuaires.add(a.getNom());
            }
            session.put("annuaires", nomAnnuaires);
            return SUCCESS;
        }
    }
    
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
