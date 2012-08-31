
package com.company.system.projects.managedbeans;

import com.company.system.other.GoToPage;
import com.company.system.projects.facade.WorkerFacade;
import com.company.system.projects.mapping.AbstractPerson;
import com.company.system.projects.mapping.Worker;
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
 * Managed Bean class. It binds An JSF page with Entities, using SessionBean (via CDI). 
 */
@ManagedBean(name = "workerBean")
@RequestScoped
public class WorkerBean implements Serializable {
    
    // Injects the WorkerFacade session bean using the @EJB annotations
    @EJB
    private WorkerFacade ejb;
    //Creates new fields
    private Worker worker;
    private List<? extends AbstractPerson> workers; 
    //Field to throw messages into browser in case of errors (if the same ERID already exists, e.g.)
    private FacesContext facesContext = FacesContext.getCurrentInstance();
    //Field for realizing 'Strategy' Pattern. Add some functionality
    private ButtonsListenersInterface buttonListener = new PersonListener();
    
    
 
   /*Create the new instance of WorkerBean */
    public WorkerBean() {
        workers = new ArrayList<Worker>();
        worker = new Worker();
    }

    //Get the list of the Workers from the DataBase
    public  List<? extends AbstractPerson> getWorkers() {
        workers = ejb.findAll();
        return workers;
    }
    //Set the list of the Workers 
    public void setWorkers(List<? extends AbstractPerson> workers) {
        this.workers = workers;
    }
    
 
    // A getter and a setter for workerBean
    public Worker getWorker() {
        return worker;
    }
    public void setWorker(Worker worker) {
        this.worker = worker;
    }
    
    //Save Worker in the DataBase and redirect a client to the main.xhtml
    //if the new Worker was successfully saved,
    //and throw error message if it wasn't
    public String saveRecord() {
        return buttonListener.saveRecord(
                facesContext, ejb, worker, GoToPage.forwardWorker);
    }
    
     /**The method for redirecting to the page for creating the new WORKER */
    public String createRecord() {
        return buttonListener.createRecord(GoToPage.createWorker);
    }

    //Delete an Worker from db
    public void deleteRecord() {
       buttonListener.deleteRecord(worker, ejb, facesContext); 
    }
    
   
}
