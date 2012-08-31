/**
 * The package with entities. 
 * ORM
 */
package com.company.system.projects.mapping;

import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

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
public abstract class AbstractPerson extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // My part of the code =======================================================================down
    @Size(min = 1, max = 20)
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    @Size(min = 1, max = 20)
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
    @Size(min = 1, max = 30)
    @Column(name = "POSITION", nullable = false)
    private String position;
    @Size(min = 1, max = 30)
    @Column(name = "EMAIL", unique = true, nullable = false )    
    @Email
    private String email;
    @Size(min = 1, max = 20)
    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;
    
    
    //Constructors - Every entity has to have a default constructor
    public AbstractPerson () {}

    public AbstractPerson(Integer id, String firstName, String lastName,
            String position, String email, String phoneNumber) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    //Method should be realized in the subclasses
    public abstract Collection<Erid> getEridCollection();
   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    // ** The standart method should check EMAIL. It should be unique.*/
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AbstractPerson)) {
            return false;
        }
        AbstractPerson other = (AbstractPerson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }
    
     @Override
    public String toString() {
         StringBuilder builder = new StringBuilder("toString() - Person ");
         builder.append(AbstractPerson.class).append(" [ ID = :").append(id).append(":, First Name = :").
                 append(firstName).append(":, Last Name = :").append(lastName).append(":, E-mail = :")
                 .append(email).append(":]");
        return builder.toString();
     }
}
