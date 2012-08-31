/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.system.projects.facade;

import com.company.system.projects.mapping.Partner;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author ---GPL---
 * 
 * This class is an Stateless EJB which is able to be inject (for JSF). CDI
 */
@Stateless
public class PartnerFacade extends AbstractFacade<Partner> {
    
    @PersistenceContext(unitName = "Projects-HwCtrlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PartnerFacade() {
        super(Partner.class);
    }
    
    /**
     * Methods return Partner from the database with the same email (if it exists)
     * @param Partner.email
    * @return Partner if the such LeadTc Partner in the db
     * @return Partner if there isn't the Partner with the same email
     */
     @Override
     public Partner findInstanceByUniqueField(Object uniqueField) {
         String email = uniqueField.toString();
         try {
              return (Partner) em.createNamedQuery(
                 "Partner.findByEmail").setParameter("email", email).getSingleResult();
         } catch (PersistenceException e) {         //if such partner already exists
             return null;
         }
        
    }
    
}
