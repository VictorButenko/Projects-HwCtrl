
package com.company.system.hw.mapping.servers;

import com.company.system.projects.mapping.Erid;

/**
 * The interface for mapping Projects <--> 'virtuals Hw (VM, Lpar, etc..)
 * (Many-to-One mapping)
 * Should be realized by (VM, LPAR, BS, RackX, RackP).
 * 
 * @see Erid
 */
public interface EridMappingInterface {
    
    public Erid getErid();
    public void setErid(Erid erid);
    
}
