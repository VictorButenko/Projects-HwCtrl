
package com.company.system.projects.managedbeans;

import com.company.system.projects.facade.AbstractFacade;
import com.company.system.projects.mapping.AbstractEntity;
import javax.faces.context.FacesContext;

/**
 * The interface for the Managed Beans. It helps to programm using interfaces,
 * not classes. 
 * Pattern 'Strategy' is using here.
 * 
 * @author ---GPL---
 * @version 1.0
 */
public interface ButtonsListenersInterface {
    
    //The method to save the new person in the Data Base
     public String saveRecord(FacesContext facesContext, AbstractFacade ejb,
                              AbstractEntity entity, String samePage); 
     //THe method for redirecting to the new page for creating the new Person
     public String createRecord(String creatingPage);
     //The method deletes the Selected Row
     public void deleteRecord(AbstractEntity entity, AbstractFacade ejb, FacesContext facesContext);

}
