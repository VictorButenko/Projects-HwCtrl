
package com.company.system.hw.mapping.servers.power;

import com.company.system.hw.mapping.servers.AbstractServer;
import javax.persistence.*;

/**
 * The <code>SystemPower</code> class for System Power servers. 
 * Extends <code>AbstractServer</code> class. 
 * The same table in the DB shouldn't be used directly - only descendants
 * 
 * @author ---GPL--- ---GPL---
 * @author You
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  class SystemPower extends AbstractServer {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public SystemPower() {}

    public SystemPower(Integer id) {
        super();
        this.id = id;
    }
    
    
    
    //ID getter/setter
    @Override
    public Integer getId() {return id;}
    @Override
    public void setId(Integer id) {this.id = id;}
   
         //FIXME: Something should be there, shouldn't it ? ??? 
    
}
