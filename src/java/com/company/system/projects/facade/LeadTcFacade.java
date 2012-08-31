
package com.company.system.projects.facade;

import com.company.system.projects.mapping.LeadTc;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author ---GPL---
 * 
 * * This class is an Stateless EJB which is able to be inject (for JSF). CDI
 */
@Stateless
public class LeadTcFacade extends AbstractFacade<LeadTc> {
    
    @PersistenceContext(unitName = "Projects-HwCtrlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LeadTcFacade() {
        super(LeadTc.class);
    }

    /**
     * Methods return LeadTc from the database with the same email (if it exists)
     * @param LeadTc.email
      * @return LeadTc if the such LeadTc exists in the db
     * @return LeadTc if there isn't the LeadTc with the same email
     */
     @Override
     public LeadTc findInstanceByUniqueField(Object uniqueField) {
         String email = uniqueField.toString();
         try {
              return (LeadTc) em.createNamedQuery(
                 "LeadTc.findByEmail").setParameter("email", email).getSingleResult();
         } catch (PersistenceException e) {  //if such worker wasn't found
             return null;
         }
    }
    
}
