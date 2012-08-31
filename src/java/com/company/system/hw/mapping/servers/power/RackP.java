
package com.company.system.hw.mapping.servers.power;

import com.company.system.hw.mapping.MM;
import com.company.system.hw.mapping.PhysicalProperties;
import com.company.system.hw.mapping.servers.PhysicalRackServerInterface;
import javax.persistence.*;

/**
 * The <code>RackP</code> class for System Power servers. 
 * Extends <code>SystemPower</code> class. 
 * Rack Power Server
 * Implements <code>PhysicalRackServerInterface</code> 
 *
 * @author ---GPL--- ---GPL---
 * @author You
 */
@Entity
@Table(name = "RACKP")
public class RackP extends SystemPower implements PhysicalRackServerInterface {
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
    public RackP() {}

    /**
     * Constructor 
     * 
     * @param id
     * @param physicalServer
     * @param mgmtIP 
     */
    public RackP(Integer id, PhysicalProperties physicalServer, MM mgmtIP) {
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
    // My code end =========================================================================
    
    //ID getter/setter
    @Override
    public Integer getId() {return id;}
    @Override
    public void setId(Integer id) {this.id = id;}
    
}
