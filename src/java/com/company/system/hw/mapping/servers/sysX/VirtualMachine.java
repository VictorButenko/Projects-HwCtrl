
package com.company.system.hw.mapping.servers.sysX;

import javax.persistence.*;

/**
 * The <code>VirtualMachine</code> class for System X servers. 
 * Extends <code>SystemX</code> class. 
 * 
 * @author ---GPL--- ---GPL---
 * @author You
 */
@Entity
@Table(name = "VM")
public class VirtualMachine extends SystemX {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public VirtualMachine() {
    }

    public VirtualMachine(Integer id) {
        super();
        this.id = id;
    }
    
    
    
    
    //ID getter/setter
    @Override
    public Integer getId() {return id;}
    @Override
    public void setId(Integer id) {this.id = id;}
    
}
