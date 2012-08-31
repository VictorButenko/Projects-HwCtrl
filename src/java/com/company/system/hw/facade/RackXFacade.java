/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.system.hw.facade;

import com.company.system.hw.mapping.servers.sysX.RackX;
import com.company.system.projects.facade.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ---GPL---
 */
@Stateless
public class RackXFacade extends AbstractFacade<RackX> {
    @PersistenceContext(unitName = "Projects-HwCtrlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RackXFacade() {
        super(RackX.class);
    }

    @Override
    public RackX findInstanceByUniqueField(Object uniqueField) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
