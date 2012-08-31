
package com.company.system.hw.managedbeans;

import com.company.system.hw.facade.MMFacade;
import com.company.system.hw.mapping.MM;
import com.company.system.hw.mapping.MM.Protocol;
import com.company.system.hw.mapping.MM.TypeMM;
import com.company.system.other.GoToPage;
import com.company.system.projects.managedbeans.ButtonsListenersInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 * Managed Bean for JSF. Entity is enjected there by CDI.
 * MM - Management Module
 * 
 * @author ---GPL---
 */
@ManagedBean(name = "mMBean")
@RequestScoped
public class MMBean implements Serializable {

    /** Inject Session Bean*/
    @EJB
    private MMFacade       ejb; 
    private MM             mm;          // Management Module
    private List<MM>       mmList;      // List of the MM's
    private List<Protocol> protocols;   // Protocols of the MM's (from enum)
    private List<TypeMM>   typesMm;     // Types of the MM (from enum)
    //Field to throw messages into browser in case of errors (if the same ERID already exists, e.g.)
    private FacesContext facesContext = FacesContext.getCurrentInstance();
    //Field for realizing 'Strategy' Pattern. Add some functionality
    private ButtonsListenersInterface buttonListener = new MmListener();
    
    /**
     * Creates a new instance of MMBean
     */
    public MMBean() {
        typesMm   = new ArrayList<TypeMM>();
        protocols = new ArrayList<Protocol>();
        mmList    = new ArrayList<MM>();
        mm        = new MM();
    }

    
    //Getters and Setters 
    public MM getMm() {
        return mm;
    }

    public void setMm(MM mm) {
        this.mm = mm;
    }

    /** Get the list of the MM's*/
    public List<MM> getMmList() {
        mmList = ejb.findAll();
        return mmList;
    }

    //Copy and return all protocols from enum [] to ArrayList
    public List<Protocol> getProtocols() {
        protocols.addAll(Arrays.asList(Protocol.values()));
        return protocols;
    }

    public void setProtocols(List<Protocol> protocols) {
        this.protocols = protocols;
    }

    //Copy and return all types from enum [] to ArrayList
    public List<TypeMM> getTypesMm() {
        typesMm.addAll(Arrays.asList(TypeMM.values()));
        return typesMm;
    }

    public void setTypesMm(List<TypeMM> typesMm) {
        this.typesMm = typesMm;
    }
    
    
    /**
     * Method saves the record of MM in the DB
     *
     * @return .xhtml or theSame page. Depends on result of saving
     */
    public String saveRecord() {
        return buttonListener.saveRecord(
                facesContext, ejb, mm, GoToPage.forwardMM);
    }

}
