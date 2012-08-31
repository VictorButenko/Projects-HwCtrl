package com.company.system.projects.mapping;

import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author ---GPL---
 *
 * The class for mapping LEAD Technical consultants
 */
@Entity
@Table(name = "LEAD_TC")
@NamedQueries({
    @NamedQuery(name = "LeadTc.findAll", query = "SELECT c FROM LeadTc c"),
    @NamedQuery(name = "LeadTc.findByEmail", query = "SELECT e FROM LeadTc e WHERE e.email = :email"),
    @NamedQuery(name = "LeadTc.findById", query = "SELECT e FROM LeadTc e WHERE e.id = :id")})
public class LeadTc extends AbstractPerson {

    //Mapping to the Erid table
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE, 
         CascadeType.REFRESH, CascadeType.DETACH}, mappedBy = "leadTc")
    private Collection<Erid> eridCollection;

    //Constructors
    public LeadTc() {
        super();
    }

    //getters/setters
    @Override
    public Collection<Erid> getEridCollection() {
        return eridCollection;
    }

    public void setEridCollection(Collection<Erid> eridCollection) {
        this.eridCollection = eridCollection;
    }
    
    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
