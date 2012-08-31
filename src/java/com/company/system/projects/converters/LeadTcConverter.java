
package com.company.system.projects.converters;

import com.company.system.projects.facade.LeadTcFacade;
import com.company.system.projects.mapping.AbstractPerson;
import com.company.system.projects.mapping.LeadTc;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Converter for LeadTC. Realize some concrete methods.
 * for 'Template Method' Pattern
 *
 * @author ---GPL---
 * @see AbstractConverter
 */
@FacesConverter("leadTcConverter")
public class LeadTcConverter extends AbstractConverter {

    /**
     * Method returns the leadTc by ID directly using JNDI 
     * @param id 
     * @return  Lead Tc (object)
     */
    @Override
    AbstractPerson findPersonById(Integer id) {
        LeadTc leadTc = leadTcFacade.find(id);
        return leadTc;
    }

    //** JNDI is directly using there. */
    private LeadTcFacade lookupLeadTcFacadeBean() {
        try {
            Context c = new InitialContext();
            return (LeadTcFacade) c.lookup("java:global/Projects-HwCtrl/LeadTcFacade!"+pathFacade+".LeadTcFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    //Sesion EJB LeadTcFacade
  private LeadTcFacade leadTcFacade = lookupLeadTcFacadeBean();
    
}
