
package com.company.system.projects.managedbeans;

import com.company.system.other.GoToPage;
import com.company.system.projects.facade.LeadTcFacade;
import com.company.system.projects.mapping.LeadTc;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author ---GPL---
 * Managed Bean class. It binds An JSF page with Entities,
 * using SessionBean (via CDI).
 */
@ManagedBean(name = "leadtcBean")
@RequestScoped
public class LeadTcBean implements Serializable {

    // Injects the LeadTcFacade session bean using the @EJB annotations
    @EJB
    private LeadTcFacade ejb;
    //Create new fields     
    private List<LeadTc> leadTcList;
    private LeadTc leadTc;
    //Field to throw messages into browser in case of errors (if the same ERID already exists, e.g.)
     private FacesContext facesContext = FacesContext.getCurrentInstance(); 
    //Field for realizing 'Strategy' Pattern. Add some functionality
    private ButtonsListenersInterface buttonListener = new PersonListener();

    
    // * Create the new instance of LeadTcBean 
    public LeadTcBean() {
        leadTcList = new ArrayList<LeadTc>();
        leadTc = new LeadTc();
    }

   //Getters and Setters
     public LeadTc getLeadTc() {
        return leadTc;
    }

    public void setLeadTc(LeadTc leadTc) {
        this.leadTc = leadTc;
    }
     //Get the list of the Leat TC from the DataBase
    public List<LeadTc> getLeadTcList() {
        leadTcList = ejb.findAll();
        return leadTcList;
    }

    // Saves the Lead TC and returns the string "main"
    //If the same E-mail already exist - Throw message
    public String saveRecord() {
        return buttonListener.saveRecord(
                facesContext, ejb, leadTc, GoToPage.forwardLeadTc);
    }
    //The method for redirecting to the page for creating the new LeadTc
    public String createRecord() {
        return buttonListener.createRecord(GoToPage.createLTc);
    }
    // Remove an LeadTc from the db.
    public void deleteRecord() {
        buttonListener.deleteRecord(leadTc, ejb, facesContext);
    }
    
}
