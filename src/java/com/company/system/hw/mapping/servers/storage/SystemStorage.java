
package com.company.system.hw.mapping.servers.storage;

import com.company.system.hw.mapping.servers.AbstractServer;
import javax.persistence.*;

/**
 * The <code>SystemStorage</code> class for System Storage servers. 
 * Extends <code>AbstractServer</code> class. 
 * The same table in the DB shouldn't be used directly - only descendants
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  class SystemStorage extends AbstractServer {
    
     private static final long serialVersionUID = 1L;
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public SystemStorage() {
    }

    public SystemStorage(Integer id) {
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
    