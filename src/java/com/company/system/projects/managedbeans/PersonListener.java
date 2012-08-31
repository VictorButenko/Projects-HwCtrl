
package com.company.system.projects.managedbeans;

import com.company.system.other.GoToPage;
import com.company.system.projects.facade.AbstractFacade;
import com.company.system.projects.mapping.AbstractEntity;
import com.company.system.projects.mapping.AbstractPerson;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *  
 * The class incapsulates CRUD methods: save(), delete(), create() for all Persons
 * Using the pattern 'Strategy'. 
 * 
 * @author ---GPL---
 * @version 1.0
 */
public class PersonListener implements ButtonsListenersInterface {

    
    /** 
     * Saves the Person and redirect to the page 'main'
     * If the same E-mail already exist - Throw message
     * 
     * @param facesContext - for throwing messages to the client
     * @param ejb - SessionBean
     * @param person - Concrete person
     * @param personList - The List<> of the persons
     * @param samePage - Page for forwarding in the case of the failure
     * @param mainPage - Page for redirecting in the case of success
     * @return  - main.xhtml in the case of success
     * @return  - the Same page if it wasn't saved
     */
    @Override
    public String saveRecord(FacesContext facesContext, AbstractFacade ejb,
        AbstractEntity entity, String samePage) {
        
        AbstractPerson person = (AbstractPerson)entity;
        if (isSameEmailExists(ejb, person)) {
            throwMessage(facesContext, "EMAIL", person);
            return samePage;
            
        } else {
            ejb.create(person);
            return GoToPage.main;
        }
    }
    
    /**
     * Method is checking email for uniqueness
     * 
     * @param ejb - SessionBean PersonFacade
     * @param person - Person instance (Worker, Partner, LeadTc..)
     * 
     * @return true if  new email isn't unique (The same email exists in the db)
     * @return false if new email is unique.
     */
     private boolean isSameEmailExists(AbstractFacade ejb, AbstractPerson person) {
         
         String email = person.getEmail(); // Get AbstractPerson.email from the instance
         boolean isExist = ejb.isFieldExist(email);  // Check if the same email exists
         return isExist;
         
    }

     /**
      * Redirecting a client to the creatingPage
      * @param creatingPage - page.xhtml
      * @return page for creating a new Person
      */
    @Override
    public String createRecord(String creatingPage) {
        return creatingPage;
    }

    /**
     * The method deletes the selected row from the table
     * If a client didn't choose anything, 
     * or if the same Person is associated with the PROJECT(ERID)
     * appropriate message will appear.
     * 
     * @param person
     * @param ejb - Session Bean
     * @param facesContext  for throwing messages to a client
     */
    @Override
    public void deleteRecord(AbstractEntity entity, AbstractFacade ejb, FacesContext facesContext) {
        
        AbstractPerson person = (AbstractPerson)entity;
        //If a client didn't choose an worker
        if (person == null) {
            throwMessage(facesContext, "WARN", person);
        //If the worker is associated with ERID by ForeignKey
        } else if (isWorkerBusy(person)) {
            throwMessage(facesContext, "ERROR", person);
        } else {
            //remove Worker from the table
            ejb.remove(person);
            throwMessage(facesContext, "INFO", person);
        }   
    }
    
     //Method throw the appropriate message (For buttons) FIXME: I don't like this throwing
     private void throwMessage (FacesContext facesContext, String message, AbstractPerson person) {
         
         if (message.equalsIgnoreCase("WARN")) {
              facesContext.addMessage(null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_WARN , "You haven't choosen a Person to delete", "Choose one"));
         } else if (message.equalsIgnoreCase("ERROR")) {
             facesContext.addMessage(null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Person can't be deleted", "He's assosiated with the project"));
         } else if (message.equalsIgnoreCase("INFO")) {
             facesContext.addMessage(null, 
                    new FacesMessage(
                    FacesMessage.SEVERITY_INFO, 
                    "Person "+person.getFirstName()+" "+person.getLastName()+" was successfully removed",
                    "from the dataBase"));           
         } else if (message.equals("EMAIL")) {
             facesContext.addMessage(null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Duplicates Error !", "The same EMAIL already exists!"));
         }
     }

    /** Auxiliary method for checking, if the selected person
      is already using in the project (erid). 
      @return true, if the same person exist in the ERID table*/
    private boolean isWorkerBusy(AbstractPerson person) {
        if (person.getEridCollection().isEmpty()) {
            return false;
        }
        return true;
    }
 
}
