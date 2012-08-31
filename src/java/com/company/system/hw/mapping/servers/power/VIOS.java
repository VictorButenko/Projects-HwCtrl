
package com.company.system.hw.mapping.servers.power;

import javax.persistence.*;

/**
 * The <code>VIOS</code> class for System Power servers. 
 * Extends <code>SystemPower</code> class. 
 * Virtual Input/Output System
 * 
 * @author ---GPL--- ---GPL---
 * @author You
 */
@Entity
@Table(name = "VIOS")
@NamedQueries( {
    @NamedQuery(name = "VIOS.findAll", query = "SELECT e FROM VIOS e"),
    @NamedQuery(name = "VIOS.findById", query = "SELECT e FROM VIOS e WHERE e.id = :id")})
public class VIOS extends SystemPower {
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
