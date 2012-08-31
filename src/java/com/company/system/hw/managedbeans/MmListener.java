/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.system.hw.managedbeans;

import com.company.system.hw.mapping.MM;
import com.company.system.other.GoToPage;
import com.company.system.projects.facade.AbstractFacade;
import com.company.system.projects.managedbeans.ButtonsListenersInterface;
import com.company.system.projects.mapping.AbstractEntity;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * The class incapsulates some methods for MM: save, create.
 * Using pattern 'Strategy'
 * 
 * 
 * @author ---GPL--- ---GPL---
 * @version 1.0
 */
class MmListener implements ButtonsListenersInterface {

    
   /**
    * Saves the new MM in the DB and redirect client to the main.xhtml
    * in the case of successfull saving
    * 
    * @param facesContext - for throwing messages to the client
    * @param ejb          - SessionBean (MmFacade)
    * @param entity       - Entity Bean
    * @param samePage     - createMM.xhtml
    * @return             - main.xhtml in the case of success
    * @return             - samePage.
    */
    @Override
    public String saveRecord(FacesContext facesContext, AbstractFacade ejb, 
                    AbstractEntity entity, String samePage) {
        MM mm = (MM) entity;
        if (isSameMMExist(ejb, mm)) {
            throwMessage(facesContext,"DuplicateError");
            return samePage;
        } else {
            ejb.create(mm);
            return GoToPage.createBC;
        }
    }
    
    /**
     * Method is checking MM for uniqueness
     * 
     * @param ejb
     * @param mm
     * @return true, if the save Mm.IPaddr already exists in the DB
     * @return fasle, if it doesn't exist.
     */
    private boolean isSameMMExist(AbstractFacade ejb, MM mm) {
        String ipaddr   = mm.getIpaddr();
        boolean isExist = ejb.isFieldExist(ipaddr);
        return isExist;
    }

    /**
     * Method throw the appropriate message to the MM tab
     * 
     * @param facesContext
     * @param duplicate_Error 
     */
    private void throwMessage(FacesContext facesContext, String duplicateError) {
        if (duplicateError.equalsIgnoreCase("DuplicateError")) {
            facesContext.addMessage(null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Duplicates Error !", "The same IP already exists!"));
        }
    }
    
 /** Redirecting a client to the creatingPage
  * 
  * @param creatingPage - createMM.xhtml
  * @return page for creating a new Server
 */
    @Override
    public String createRecord(String creatingPage) {
        return creatingPage;
    }

    //-----------------------DOESN'T REALIZED---------------------------------------------
    @Override
    @Deprecated
    public void deleteRecord(AbstractEntity entity, AbstractFacade ejb, 
                    FacesContext facesContext) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
 //----------------------------------We can't use them----------------------------------------------

}
