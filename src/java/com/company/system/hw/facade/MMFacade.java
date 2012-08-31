/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.system.hw.facade;

import com.company.system.hw.mapping.MM;
import com.company.system.projects.facade.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author ---GPL---
 */
@Stateless
public class MMFacade extends AbstractFacade<MM> {
    @PersistenceContext(unitName = "Projects-HwCtrlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MMFacade() {
        super(MM.class);
    }

    /**
     * Find MM by IP 
     * 
     * @param ipAddress
     * @return MM by IP
     * @return null if it such IP wasn't found
     */
    @Override
    public MM findInstanceByUniqueField(Object uniqueField) {
        String ipAddress = uniqueField.toString();
        try {
            return (MM)getEntityManager().createNamedQuery(
                    "MM.findMmByIp").setParameter(
                    "ipaddr", ipAddress).getSingleResult();
        } catch (PersistenceException e) {  //if MM with such IP wasn't found
            return null;
        }
    }
    
        
}
