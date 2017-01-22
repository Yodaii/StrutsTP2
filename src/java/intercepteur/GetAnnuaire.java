/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intercepteur;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import objet_metiers.Annuaire;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Yohann
 */
public class GetAnnuaire extends AbstractInterceptor{

    private Map<String, Object> session;
    private Session uneSession;

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        uneSession = HibernateUtil.currentSession();
        session = ai.getInvocationContext().getSession();
        List<Annuaire> annuaires = (List<Annuaire>)uneSession.createCriteria(Annuaire.class).list();
        
        if(annuaires.isEmpty()){
            return INPUT;
        }else{
            session.put("annuaires", annuaires);
            return SUCCESS;
        }
    }
}
