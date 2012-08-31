package com.company.system.projects.mapping;

import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 *
 * @author ---GPL---
 *
 * The table for COMPANY's partners
 *
 */
@Entity
@Table(name = "PARTNER")
@NamedQueries({
    @NamedQuery(name = "Partner.findAll", query = "SELECT c FROM Partner c"),
    @NamedQuery(name = "Partner.findByEmail", query = "SELECT e FROM Partner e WHERE e.email = :email"),
    @NamedQuery(name = "Partner.findById", query = "SELECT e FROM Partner e WHERE e.id = :id")})
public class Partner extends AbstractPerson {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    //THEre is my code
    @Size(min = 1, max = 30)
    @Column(name = "COMPANY", nullable = false)
    private String company;
    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE, 
         CascadeType.REFRESH, CascadeType.DETACH}, mappedBy = "partner")
    private Collection<Erid> eridCollection;
    
    //Constructors
    public Partner (){
    }
    public Partner (String company) {
        super();
        this.company = company;
    }
    
    //Getters/Setters

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    
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
