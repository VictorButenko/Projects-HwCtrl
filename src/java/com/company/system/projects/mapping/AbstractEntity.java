
package com.company.system.projects.mapping;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author ---GPL---
 * 
 * The abstract class for other entities
 *
 * The 'TABLE_PER_CLASS' temlate creates a table for every entity (except
 * Abstracts). These tables have subfields and their own fields.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id;}
}
