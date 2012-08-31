
package com.company.system.hw.mapping;

import com.company.system.hw.mapping.servers.power.HMC;
import com.company.system.hw.mapping.servers.power.RackP;
import com.company.system.hw.mapping.servers.storage.SSD;
import com.company.system.hw.mapping.servers.storage.SwitchStorage;
import com.company.system.hw.mapping.servers.sysX.BladeCenter;
import com.company.system.hw.mapping.servers.sysX.RackX;
import com.company.system.projects.mapping.AbstractEntity;
import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * MM (Management module) class for different types of servers:
 * AMM     - Advanced Management Module - BladeCenter (SystemX)
 * IMM     - Integrated MM - Rack Server (System X Server)
 * HMC     - Hardware Management Console - System P (Power)
 * SMC     - Storage Management Console - SSD (Storwize)
 * VIOS    - Virtual I/O Server  - System P
 * BROCADE - SAN Switch MM.(Switch Storage)
 * 
 * One-to-One one-directianal mapping to some servers is used here.
 * 
 * @author ---GPL---
 * @version 1.0
 */
@Entity
@Table(name = "MM")
@NamedQueries( {
    @NamedQuery(name = "MM.findAll", query = "SELECT e FROM MM e"),
    @NamedQuery(name = "MM.findMmByIp", query = "SELECT e FROM MM e WHERE e.ipaddr = :ipaddr"),
    @NamedQuery(name = "MM.findById", query = "SELECT e FROM MM e WHERE e.id = :id")})
public  class MM extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    /** Emum types of the possible protocols*/
    public enum Protocol {SSH, TELNET, HTTP };
    /** Types of the MM (according to servers)*/
    public enum TypeMM {AMM, IMM, HMC, SMC, VIOS, BROCADE};
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**IP Address of the server. Should be unique*/
    @Pattern(regexp = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$")
    @Column(name = "IPADDR", nullable = false, unique = true)
    private String ipaddr;
    
    /**Type of the protocol (Enumeration : SSH, HTTP, TELNET)*/
    @Enumerated(EnumType.STRING)
    @Column(name = "PROTOCOL", nullable = false)
    private Protocol protocol;
    
    /** Type of the Management Module (Consule)*/
    @Enumerated(EnumType.STRING)
    @Column(name = "TypeMM", nullable = false)
    private TypeMM typeMm;
    
    /**User name to Log In*/
    @Column(name = "USERNAME", nullable = false)
    private String username;
    
    /**Password to Log In*/ 
    //TODO - Хранить пароли в защищенном виде !!!!!!
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    
    
    //One-To-One One-directional Maping
    @OneToOne(mappedBy = "mgmtIP") private BladeCenter bc;
    @OneToOne(mappedBy = "mgmtIP") private RackX rackX;
    @OneToOne(mappedBy = "mgmtIP") private HMC hmc;
    @OneToOne(mappedBy = "mgmtIP") private RackP rackP;
    @OneToOne(mappedBy = "mgmtIP") private SSD ssd;
    @OneToOne(mappedBy = "mgmtIP") private SwitchStorage switchStorage;
    
    
    //Constructors - Every entity has to have a default constructor
    public MM () { }

    /**
     * MM's constructor
     * 
     * @param id       - The Primary Key field (AUTO_GENERATED)
     * @param ipaddr   - The MM's IP address
     * @param protocol - The enum (protocol) - SSH, TELNET, HTTP
     * @param typeMm   - The enum (MM's type) - AMM, IMM, HMC, SMC, BROCADE
     * @param username - UserName for remote control
     * @param password - Password for remote control
     */
    public MM(Integer id, String ipaddr, Protocol protocol, 
            TypeMM typeMm, String username, String password) {
        super();
        this.id          = id;
        this.ipaddr      = ipaddr;
        this.protocol    = protocol;
        this.typeMm      = typeMm;
        this.username    = username;
        this.password    = password;
    }
        
    
    // Getters and Setters 
    public String getProtocol() { return (protocol == null) ? null : protocol.name(); }
    public void setProtocol(String protocol) { this.protocol = Protocol.valueOf(protocol);}

    public String getTypeMm() {return (typeMm == null) ? null : typeMm.name();}
    public void setTypeMm(String typeMm) {this.typeMm = TypeMM.valueOf(typeMm);}
    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BladeCenter getServer() {
        return bc;
    }

    public void setServer(BladeCenter bc) {
        this.bc = bc;
    }

    public BladeCenter getBc() {
        return bc;
    }

    public void setBc(BladeCenter bc) {
        this.bc = bc;
    }

    public HMC getHmc() {
        return hmc;
    }

    public void setHmc(HMC hmc) {
        this.hmc = hmc;
    }

    public RackP getRackP() {
        return rackP;
    }

    public void setRackP(RackP rackP) {
        this.rackP = rackP;
    }

    public RackX getRackX() {
        return rackX;
    }

    public void setRackX(RackX rackX) {
        this.rackX = rackX;
    }

    public SSD getSsd() {
        return ssd;
    }

    public void setSsd(SSD ssd) {
        this.ssd = ssd;
    }

    public SwitchStorage getSwitchStorage() {
        return switchStorage;
    }

    public void setSwitchStorage(SwitchStorage switchStorage) {
        this.switchStorage = switchStorage;
    }

       
    //---------------------My Code -------------------UP---------------------------------------
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MM)) {
            return false;
        }
        MM other = (MM) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        } 
        if ((this.ipaddr == null && other.ipaddr != null) || (this.ipaddr != null && !this.ipaddr.equals(other.ipaddr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("toString() - MM ");
         builder.append(MM.class).append(" [ ID = :").append(id).append(":, IP = :").
                 append(ipaddr).append(":, Protocol = :").append(protocol.toString()).append(":]");
        return builder.toString();
    }
    
}
