/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.system.hw.managedbeans;

import com.company.system.projects.facade.AbstractFacade;
import com.company.system.projects.managedbeans.ButtonsListenersInterface;
import com.company.system.projects.mapping.AbstractEntity;
import javax.faces.context.FacesContext;

/**
 *
 * @author ---GPL---
 */
public class ServerListener implements ButtonsListenersInterface {

    @Override
    public String saveRecord(FacesContext facesContext, 
                    AbstractFacade ejb, AbstractEntity entity, String samePage) {
        
        return null;
        
    }

    @Override
    public String createRecord(String creatingPage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteRecord(AbstractEntity entity, AbstractFacade ejb, FacesContext facesContext) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
