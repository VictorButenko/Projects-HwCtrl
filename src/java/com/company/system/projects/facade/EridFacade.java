/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.system.projects.facade;

import com.company.system.projects.mapping.Erid;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author ---GPL---
 * 
 * SessionBean for Erid table
 */
@Stateless
public class EridFacade extends AbstractFacade<Erid> {
    @PersistenceContext(unitName = "Projects-HwCtrlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EridFacade() {
        super(Erid.class);
    }

    /**
     * Method creates and returns Erid instance
     * @param erid (Integer)
     * @return 'Select Erid.erid FROM Erid WHERE erid = newErid'
     */
    @Override
    public Erid findInstanceByUniqueField(Object uniqueField) {
        String stringErid = uniqueField.toString(); 
        try {
            Integer erid = (Integer) Integer.parseInt(stringErid);
              return (Erid) em.createNamedQuery(
                "Erid.findByErid").setParameter("erid", erid).getSingleResult();
              
        } catch (PersistenceException e) { //if such erid wasn't found
            System.err.println("Persistance Exception !! Erid wasn't found maybe.");
            return null;
        } catch (NumberFormatException e) { //If StringErid can't be convert to Integer
            System.err.println("Error of casting formats ! NumberFormatException");
            return null;
        }
    }
   
}
