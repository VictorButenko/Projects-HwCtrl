/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.system.hw.facade;

import com.company.system.hw.mapping.servers.storage.SSD;
import com.company.system.projects.facade.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ---GPL---
 */
@Stateless
public class SSDFacade extends AbstractFacade<SSD> {
    @PersistenceContext(unitName = "Projects-HwCtrlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SSDFacade() {
        super(SSD.class);
    }

    @Override
    public SSD findInstanceByUniqueField(Object uniqueField) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
