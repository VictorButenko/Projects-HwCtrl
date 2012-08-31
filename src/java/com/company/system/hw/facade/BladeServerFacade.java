/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.system.hw.facade;

import com.company.system.hw.mapping.servers.sysX.BladeServer;
import com.company.system.projects.facade.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ---GPL---
 */
@Stateless
public class BladeServerFacade extends AbstractFacade<BladeServer> {
    @PersistenceContext(unitName = "Projects-HwCtrlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BladeServerFacade() {
        super(BladeServer.class);
    }

    @Override
    public BladeServer findInstanceByUniqueField(Object uniqueField) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
