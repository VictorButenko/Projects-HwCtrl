
package com.company.system.projects.converters;

import com.company.system.projects.facade.PartnerFacade;
import com.company.system.projects.mapping.AbstractPerson;
import com.company.system.projects.mapping.Partner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * Converter for Partner.Realize some concrete methods.
 * for 'Template Method' Pattern
 * 
 * @author ---GPL---
 * @version 1.0
 */
@FacesConverter("partnerConverter")
public class PartnerConverter extends AbstractConverter {
    
    /**
     * Method returns the Partner by ID directly using JNDI 
     * @param id 
     * @return  Partner (object)
     */
    @Override
    AbstractPerson findPersonById(Integer id) {
        Partner partner = partnerFacade.find(id);
        return partner;
    }

    /** JNDI directly using here*/
    private PartnerFacade lookupPartnerFacadeBean() {
        try {
            Context c = new InitialContext();
            return (PartnerFacade) c.lookup("java:global/Projects-HwCtrl/PartnerFacade!"+pathFacade+".PartnerFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    //SessionBean for Partners
    private PartnerFacade partnerFacade = lookupPartnerFacadeBean();
    
    
    
}
