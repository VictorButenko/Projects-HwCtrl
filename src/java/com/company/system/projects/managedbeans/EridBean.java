
package com.company.system.projects.managedbeans;

import com.company.system.other.GoToPage;
import com.company.system.projects.facade.EridFacade;
import com.company.system.projects.mapping.Erid;
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
 * 
 * ManagedBean for Erid table. 
 * Using CDI for inject from entities.
 */
 @ManagedBean(name = "eridBean")
 @RequestScoped
 public class EridBean implements Serializable {
     
     //Session EJB Injection
     @EJB
     private EridFacade ejb;
     private Erid erid;
     private List<Erid> erids;
     //Field to throw messages into browser in case of errors (if the same ERID already exists, e.g.)
     private FacesContext facesContext = FacesContext.getCurrentInstance(); 
     //Field for realizing 'Strategy' Pattern. Add some functionality
     private ButtonsListenersInterface buttonListener = new EridListener(); //TODO: Через интерфейсы надо б !!!
    
     //Create the new Instance of the WorkerBean
    public EridBean() {
        erids = new ArrayList<Erid>();
        erid = new Erid();
    }

    //Get the list of erids
    public List<Erid> getErids() {
        erids = ejb.findAll();
        return erids;   
    }
    public Erid getErid() {
        return erid;
    }
    public void setErid(Erid erid) {
        this.erid = erid;
    }
    
    //Save Erid in the table. If such a ERID already exists,
    //there Warning will appear
    public String saveRecord() {
         return buttonListener.saveRecord(
                 facesContext, ejb, erid, GoToPage.forwardErid);
        
    }

    //Go to the creating EridPage
    public String createRecord() {
        return buttonListener.createRecord(GoToPage.createErid);
       
    }
    
}
