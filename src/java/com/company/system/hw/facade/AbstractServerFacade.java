/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.system.hw.facade;

import com.company.system.hw.mapping.servers.AbstractServer;
import com.company.system.projects.facade.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ---GPL---
 */
@Stateless
public class AbstractServerFacade extends AbstractFacade<AbstractServer> {
    @PersistenceContext(unitName = "Projects-HwCtrlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AbstractServerFacade() {
        super(AbstractServer.class);
    }

    @Override
    public AbstractServer findInstanceByUniqueField(Object uniqueField) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
//    public List<AbstractServer> findAllPhysicalServer() {
//        Query query = em.createNamedQuery("AbstractServer.findAll");
//        return (List<AbstractServer>)query.getResultList();
//    }
    
}
