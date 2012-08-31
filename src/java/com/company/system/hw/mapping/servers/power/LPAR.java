
package com.company.system.hw.mapping.servers.power;

import javax.persistence.*;

/**
 * The <code>LPAR</code> class for System Power servers. 
 * Extends <code>SystemPower</code> class. 
 * Logical Partition Access Resources
 * 
 * @author ---GPL--- ---GPL---
 * @author You
 */
@Entity
@Table(name = "LPAR")
public class LPAR extends SystemPower {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;   
    
    //ID getter/setter
    @Override
    public Integer getId() {return id;}
    @Override
    public void setId(Integer id) {this.id = id;}
    
}
