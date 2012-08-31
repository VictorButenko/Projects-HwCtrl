
package com.company.system.hw.mapping.servers.sysX;

import javax.persistence.*;

/**
 * The <code>BladeServer</code> class.  
 * Extends <code>SystemX</code> class. 
 * 
 * @author ---GPL--- ---GPL---
 * @author You
 */
@Entity
@Table(name = "BLADESERVER")
public class BladeServer extends SystemX {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public BladeServer() {
    }

    public BladeServer(Integer id) {
        super();
        this.id = id;
    }
    
    
    //ID getter/setter
    @Override
    public Integer getId() {return id;}
    @Override
    public void setId(Integer id) {this.id = id;}
    
}
