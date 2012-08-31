/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.system.projects.facade;

import com.company.system.projects.mapping.Worker;
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
public class WorkerFacade extends AbstractFacade<Worker> {
   
    @PersistenceContext(unitName = "Projects-HwCtrlPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WorkerFacade() {
        super(Worker.class);
    }

    /**
     *  Methods return Worker from the database with the same email (if it exists)
     * @param Worker.email
     * @return Worker if the such imber exists in the db
     * @return null if there isn't the imber with the same email
     */
     @Override
     public Worker findInstanceByUniqueField(Object uniqueField) {
         String email = uniqueField.toString();
         try  {
             return  (Worker)getEntityManager().createNamedQuery(
                     "Worker.findByEmail").setParameter(
                     "email", email).getSingleResult();
             
         } catch (PersistenceException e) {   //if such worker wasn't found
             return null;
         }
    }
    

}
