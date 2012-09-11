/*
 * %W% %E%
 *
 * Copyright (c) 2012, COMPANY. All rights reserved.
 */
package com.company.system.hw.mapping.servers;

import com.company.system.projects.mapping.AbstractEntity;
import javax.persistence.*;

/**
 * The <code>AbstractServer<code> class is the root of the HardWare hierarchy.
 * 
 * <p>
 * 
 * Abstract server. The root of the HardWare hierarchy.
 * The 'TABLE_PER_CLASS' hierarchy temlate creates a table for every entity (except
 * Abstracts). These tables have subfields and their own fields.
 * 
 * Relations of the MM.type and Servers (for persisting in the DB) :
 * BladeCenter <---> AMM;
 * RackX <---> IMM;
 * HMC <---> HMC;
 * SSD <---> SMC;
 * SwitchStorage <---> Brocade.
 * 
 * @author ---GPL--- ---GPL---
 * @author You
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQueries({
    @NamedQuery(name = "AbstractServer.findAll", query = "SELECT c FROM AbstractServer c")
})
public abstract class AbstractServer extends AbstractEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
     // My part of the code =============================DOWN===================================
     
    /** The name of the server*/
    @Column(name = "NAME", nullable = false)
    private String name;
    
    
    //Constructors - Every entity has to have a default constructor
    public AbstractServer() { }

    public AbstractServer(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    //Getters/Setters
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    // My part of the code ============================== UP ===================================
    
    //ID getter/setter
    @Override
    public Integer getId() {return id;}
    @Override
    public void setId(Integer id) {this.id = id;}
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AbstractServer)) {
            return false;
        }
        AbstractServer other = (AbstractServer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("toString() - Server ");
         builder.append(AbstractServer.class).append(" [ ID = :").append(id).append(":]");
        return builder.toString();
    }
    
}
