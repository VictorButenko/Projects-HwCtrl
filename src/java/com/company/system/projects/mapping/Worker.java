    
package com.company.system.projects.mapping;

import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 *
 * @author ---GPL---
 *
 * The Entity for WORKERs table
 */
@Entity
@Table(name = "WORKERS")
@NamedQueries({
    @NamedQuery(name = "Worker.findAll", query = "SELECT c FROM Worker c"),
    @NamedQuery(name = "Worker.findByEmail", query = "SELECT e FROM Worker e WHERE e.email = :email"),
    @NamedQuery(name = "Worker.findById", query = "SELECT e FROM Worker e WHERE e.id = :id")})
public class Worker  extends  AbstractPerson  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //THere is my code ================================================================Look down
    
    @Size(min = 1, max = 30)
    @Column(name = "DEPARTMENT", nullable = false)
    private String department;
    
    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE, 
         CascadeType.REFRESH, CascadeType.DETACH}, mappedBy = "worker")
    private Collection<Erid> eridCollection;    


    //Constructors
    public Worker() {
    }
    public Worker(String department) {
        super();
        this.department = department;
    }

    //Getters/Setters
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    
    @Override
    public Collection<Erid> getEridCollection() {
        return eridCollection;
    }
    public void setEridCollection(Collection<Erid> eridCollection) {
        this.eridCollection = eridCollection;
    }
    
    
    //THere is my code ================================================================Look up
    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

   
}
