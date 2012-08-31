
package com.company.system.projects.managedbeans;

import com.company.system.projects.facade.PartnerFacade;
import com.company.system.other.GoToPage;
import com.company.system.projects.mapping.Partner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ---GPL---
 * 
 *  Managed Bean class. It binds An JSF page with Entities,
 *  using SessionBean (via CDI).
 */
@ManagedBean(name = "partnerBean")
@RequestScoped
public class PartnerBean implements Serializable {
    
    //Call EJB
    @EJB
    private PartnerFacade ejb;
    private Partner partner;
    private List<Partner> partners;
     //Field to throw messages into browser in case of errors (if the same ERID already exists, e.g.)
    private FacesContext facesContext = FacesContext.getCurrentInstance(); 
    //Field for realizing 'Strategy' Pattern. Add some functionality
    private ButtonsListenersInterface buttonListener = new PersonListener();
    
    
    //Create the new instance of the PartnerBean
    public PartnerBean () {
        partner = new Partner ();
        partners = new ArrayList<Partner>();
    }

    //Getters and Setters
    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public List<Partner> getPartners() {
        partners = ejb.findAll();
        return partners;
    }

    // Saves the Partner and returns the string "main"
    //If the same E-mail already exist - Throw message
    public String saveRecord() {
        return buttonListener.saveRecord(
                facesContext, ejb, partner, GoToPage.forwardPartner);
    }

    //Redirecting to the page for creating a new Partner
    public String createRecord() {
        return buttonListener.createRecord(GoToPage.createPartner);
    }
    //Delete an Worker from db
    public void deleteRecord() {
        buttonListener.deleteRecord(partner, ejb, facesContext);
    }

}
