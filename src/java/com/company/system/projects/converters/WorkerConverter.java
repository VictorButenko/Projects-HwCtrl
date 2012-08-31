
package com.company.system.projects.converters;

import com.company.system.projects.facade.WorkerFacade;
import com.company.system.projects.mapping.AbstractPerson;
import com.company.system.projects.mapping.Worker;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Converter for Worker. Realize some concrete methods.
 * for 'Template Method' Pattern
 * 
 * @author ---GPL---
 */
@FacesConverter("workerConverter")
public class WorkerConverter extends AbstractConverter {
   

     /**
     * Method returns the worker by ID directly using JNDI 
     * @param id 
     * @return  Worker (object)
     */
    @Override
    AbstractPerson findPersonById(Integer id) {
        Worker worker = workerFacade.find(id);
        return worker;
    }

     //** JNDI is directly using there. */
    private WorkerFacade lookupWorkerFacadeBean() {
        try {
            Context c = new InitialContext();
            return (WorkerFacade) c.lookup("java:global/Projects-HwCtrl/WorkerFacade!"+pathFacade+".WorkerFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
      //Sesion EJB WorkerFacade
    private WorkerFacade workerFacade = lookupWorkerFacadeBean();
}
