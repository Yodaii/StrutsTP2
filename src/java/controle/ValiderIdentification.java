/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import static com.opensymphony.xwork2.Action.INPUT;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import objet_metiers.Abonne;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import util.HibernateUtil;

public class ValiderIdentification extends ActionSupport implements SessionAware {

    private String identifiant;
    private String motdepasse;
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

    public String execute() throws Exception {
        uneSession = HibernateUtil.currentSession();
        Abonne unAbon = (Abonne) uneSession.get(Abonne.class, identifiant);
        if (unAbon == null || !unAbon.getMotdepasse().equals(motdepasse)) {
            return INPUT;
        }
        session.put("unAbon", unAbon);
        session.put("annuaire", unAbon.getAnnuaire());
        session.put("session", uneSession);
        
        if(unAbon.isEstAdmin()){
            return "admin";
        }else{
            return "abonne";
        }
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
