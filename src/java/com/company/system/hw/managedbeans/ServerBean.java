package com.company.system.hw.managedbeans;

import com.company.system.hw.facade.AbstractServerFacade;
import com.company.system.hw.facade.MMFacade;
import com.company.system.hw.mapping.MM;
import com.company.system.hw.mapping.servers.AbstractServer;
import com.company.system.hw.mapping.servers.PhysicalRackServerInterface;
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
 * Managed Bean for JSF. Entity is enjected there by CDI. Class saves MM and a
 * concrete type of the servers depends on MM.type (AMM->BC, etc..)
 *
 */
@ManagedBean(name = "serverBean")
@RequestScoped
public class ServerBean implements Serializable {
    
    //-------START PART FOR MANAGMENT MODULE--------------------------------------------
    @EJB private MMFacade MmEjb;
    private MM mm;          // Management Module
    private List<MM> mmList;      // List of the MM's
    private List<MM.Protocol> protocols;   // Protocols of the MM's (from enum)
    private List<MM.TypeMM> typesMm;     // Types of the MM (from enum)
    //Field to throw messages into browser in case of errors (if the same ERID already exists, e.g.)
    private FacesContext facesContext = FacesContext.getCurrentInstance();
    //Field for realizing 'Strategy' Pattern. Add some functionality
    private ButtonsListenersInterface mmButtonListener = new MmListener();
    
    
     //Getters and Setters 
    public MM getMm() {
        return mm;
    }

    public void setMm(MM mm) {
        this.mm = mm;
    }

    /** Get the list of the MM's*/
    public List<MM> getMmList() {
        mmList = MmEjb.findAll();
        return mmList;
    }

    //Copy and return all protocols from enum [] to ArrayList
    public List<MM.Protocol> getProtocols() {
        protocols.addAll(Arrays.asList(MM.Protocol.values()));
        return protocols;
    }

    public void setProtocols(List<MM.Protocol> protocols) {
        this.protocols = protocols;
    }

    //Copy and return all types from enum [] to ArrayList
    public List<MM.TypeMM> getTypesMm() {
        typesMm.addAll(Arrays.asList(MM.TypeMM.values()));
        return typesMm;
    }

    public void setTypesMm(List<MM.TypeMM> typesMm) {
        this.typesMm = typesMm;
    }
    //-------END PART OF THE MANAGEMET MODULE-------------------------------------------
    

    //---------START PART OF THE SERVERS ----------------------------------------------
    
    //Inject AbstractEjb 
    @EJB private AbstractServerFacade abstrEjb;
    
    private AbstractServer server; //PhysicalRackServer(concreteness depends on MM.type)
    //The list of the servers
    private List<? extends AbstractServer> physicalServers;
    
    private ButtonsListenersInterface serverButtonListener = new ServerListener();

    // * Creates a new instance of ServerBean
    public ServerBean() {
        typesMm   = new ArrayList<MM.TypeMM>();
        protocols = new ArrayList<MM.Protocol>();
        mmList    = new ArrayList<MM>();
        mm        = new MM();

    }

    //Getters and setters
    public AbstractServer getServer() {
        return server;
    }

    public void setServer(AbstractServer server) {
        this.server = server;
    }
    

    
    /**
     * Method selects all of the servers, chooses only physical from there and
     * returns them.
     *
     * @return list of the Physical Servers
     */
    public List<? extends AbstractServer> getPhysicalServers() {

        physicalServers = abstrEjb.findAll(); //Select all Servers from the DB

        /* For every element of the serverList 
         * if the type if the element doesn't realize PhysicalRackServerInterface
         * then delete this element from the list. 
         */
        for (int i = 0; i < physicalServers.size(); i++) {
            if (!(physicalServers.get(i) instanceof PhysicalRackServerInterface)) {
                physicalServers.remove(i);
            }
        }
        return physicalServers;
    }

    public void setServerList(List<? extends AbstractServer> serverList) {
        this.physicalServers = serverList;
    }
    
    //---------END PART OF THE SERVERS -------------------------------------------------
}
