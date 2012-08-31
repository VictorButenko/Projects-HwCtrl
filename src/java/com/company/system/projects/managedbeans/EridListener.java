
package com.company.system.projects.managedbeans;

import com.company.system.other.GoToPage;
import com.company.system.projects.facade.AbstractFacade;
import com.company.system.projects.mapping.AbstractEntity;
import com.company.system.projects.mapping.Erid;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * The class incapsulates some methods for ERID: save, create,  delete
 * Using pattern 'Strategy'
 * 
 * @author ---GPL---
 * @version 1.0
 */
public class EridListener implements ButtonsListenersInterface {
    
    /** Redirecting a client to the creatingPage
      * @param creatingPage - createErid.xhtml
      * @return page for creating a new ERID
      */
    @Override
    public String createRecord(String creatingPage) {
        return creatingPage;
    }
    
    /**
     * Saves the new ERID in the dataBase and redirect client to the main page
     * in the case of successfull saving
     * 
     * @param facesContext  - for throwing messages to the client
     * @param ejb           - SessionBean (EridFacade)
     * @param entity        - Entity Bean
     * @param samePage      - createErid.xhtml
     * @param mainpage      - main.xhtml
     * @return              - main.xhtml in the case of success
     * @return              - samePage.
     */
    @Override
    public String saveRecord(FacesContext facesContext, AbstractFacade ejb, AbstractEntity entity,
                                 String samePage) {
        
         Erid erid = (Erid) entity;
         if (isSameEridExist(ejb, erid)) {
            throwMessage(facesContext, "DuplicateError");
            return samePage;
        } else {
            ejb.create(erid);
            return GoToPage.main;
        }        
    }
    
    /**
     * Method is checking erid for uniqueness
     * 
     * @param ejb - SessionBean EridFacade
     * @param erid  - Erid instance
     * @return true if  new erid isn't unique (The same erid exists in the db)
     * @return false if new rid is unique.
     */
    private boolean isSameEridExist(AbstractFacade ejb, Erid erid) {
        Integer eridId = erid.getErid();            // Get Erid.erid from erid instance
        boolean isExist = ejb.isFieldExist(eridId);  //Check in the DB if the same erid exist
        return isExist;
    }

    /**
     * Method throw the appropriate message to the ERID tab
     * 
     * @param facesContext
     * @param duplicateError
     * @param erid 
     */
    private void throwMessage(FacesContext facesContext, String duplicateError) {
        if (duplicateError.equalsIgnoreCase("DuplicateError")) {
            facesContext.addMessage(null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Duplicates Error !", "The same ERID already exists!"));
        }
    }
    
    
    //-----------------------DOESN'T REALIZED---------------------------------------------
    @Override
    @Deprecated
    public void deleteRecord(AbstractEntity person, AbstractFacade ejb, FacesContext facesContext) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
     //----------------------------------We can't use them----------------------------------------------

}
