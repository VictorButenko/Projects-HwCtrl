
package com.company.system.hw.mapping.servers.sysX;

import com.company.system.hw.mapping.servers.AbstractServer;
import javax.persistence.*;

/**
 * The <code>SystemX</code> class for System X servers. 
 * Extends <code>AbstractServer</code> class. 
 * The same table in the DB shouldn't be used directly - only descendants
 * 
 * @author ---GPL--- ---GPL---
 * @author You
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public   class SystemX extends AbstractServer {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;   
    
    //Every Entity has to have an empty constructor
    public SystemX () {}

    public SystemX(Integer id) {
        super();
        this.id = id;
    }
    
    
    
    //-------------------------------another constructor ??
    
    
    
    //ID getter/setter
    @Override
    public Integer getId() {return id;}
    @Override
    public void setId(Integer id) {this.id = id;}
    
    
    
}
