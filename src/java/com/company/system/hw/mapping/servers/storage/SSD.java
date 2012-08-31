
package com.company.system.hw.mapping.servers.storage;

import com.company.system.hw.mapping.MM;
import com.company.system.hw.mapping.PhysicalProperties;
import com.company.system.hw.mapping.servers.PhysicalRackServerInterface;
import javax.persistence.*;

/**
 * The <code>SSD</code> class for System Storage servers. 
 * Extends <code>SystemStorage</code> class. 
 * Implements <code>PhysicalRackServerInterface</code>
 * System Storage Data
 * 
 * @author ---GPL--- ---GPL---
 * @author You
 */
@Entity
@Table(name = "SSD")
public class SSD extends SystemStorage implements PhysicalRackServerInterface {
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
    public SSD() {}

    /**
     * Constructor 
     * 
     * @param id
     * @param physicalServer
     * @param mgmtIP 
     */
    public SSD(Integer id, PhysicalProperties physicalServer, MM mgmtIP) {
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
