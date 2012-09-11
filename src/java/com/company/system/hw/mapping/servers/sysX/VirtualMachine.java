
package com.company.system.hw.mapping.servers.sysX;

import com.company.system.hw.mapping.servers.EridMappingInterface;
import com.company.system.projects.mapping.Erid;
import javax.persistence.*;

/**
 * The <code>VirtualMachine</code> class for System X servers. 
 * Extends <code>SystemX</code> class. 
 * 
 */
@Entity
@Table(name = "VM")
public class VirtualMachine extends SystemX implements EridMappingInterface {
    private static final long serialVersionUID = 1L;
    
    /**Necessary constructor for Entity */
    public VirtualMachine () { }
    
     public VirtualMachine(Integer id, Erid erid) {
        super();
        this.id = id;
        this.erid = erid;
    }
    
    // INSERT CONSTRUCTOR
    @JoinColumn(name = "ERID", referencedColumnName = "erid")
    @ManyToOne (cascade = CascadeType.PERSIST) //TODO ? Only persist ??
    private Erid erid;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

   
    
    //ID getter/setter
    @Override
    public Integer getId() {return id;}
    @Override
    public void setId(Integer id) {this.id = id;}

    @Override
    public Erid getErid() {
        return erid;
    }

    @Override
    public void setErid(Erid erid) {
        this.erid = erid;
    }
    
}
