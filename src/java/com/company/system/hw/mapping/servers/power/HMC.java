
package com.company.system.hw.mapping.servers.power;

import com.company.system.hw.mapping.MM;
import com.company.system.hw.mapping.PhysicalProperties;
import com.company.system.hw.mapping.servers.PhysicalRackServerInterface;
import javax.persistence.*;

/**
 * The <code>HMC</code> class for System Power servers. 
 * Extends <code>SystemPower</code> class. 
 * Hardware Management Console (HMC)
 * Implements <code>PhysicalRackServerInterface</code>
 * 
 * @author ---GPL--- ---GPL---
 * @author You
 */
@Entity
@Table(name = "HMC")
public class HMC extends SystemPower implements PhysicalRackServerInterface {
   private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    /** Embeded class with properties of Physical Server (Room, Rack, Units)*/
    @Embedded
    private PhysicalProperties physicalServer;
    
    /**Management module's IP adress (FK) */
    @JoinColumn(name = "MGMTIP", referencedColumnName = "ipaddr")
    @OneToOne(cascade = CascadeType.ALL)
    private MM mgmtIP;

    
     /** The empty constructor is necessary for Entity Beans*/
    public HMC() {}

    /**
     * Constructor
     * 
     * @param id
     * @param physicalServer
     * @param mgmtIP 
     */
    public HMC(Integer id, PhysicalProperties physicalServer, MM mgmtIP) {
        super();
        this.id = id;
        this.physicalServer = physicalServer;
        this.mgmtIP = mgmtIP;
    }

    
    
    //Getters and Setters 
    @Override
    public MM getMgmtIP() {
        return mgmtIP;
    }
    @Override
    public void setMgmtIP(MM mgmtIP) {
        this.mgmtIP = mgmtIP;
    }
    
    @Override
    public void setPhysicalServer(PhysicalProperties physicalServer) {
        this.physicalServer = physicalServer;
    }
    @Override
    public PhysicalProperties getPhysicalServer() {
        return physicalServer;
    }
    
    @Override
    public Integer getId() {return id;}
    @Override
    public void setId(Integer id) {this.id = id;}
    
}
