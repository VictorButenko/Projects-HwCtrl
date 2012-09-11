/**
 * Package for storage JPA Entities for ORM with DataBase
 * 
 */
package com.company.system.projects.mapping;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author ---GPL---
 * 
 * ERID Entity for mapping to DataBase
 * Class Erid persists some information about the project and 
 * keeps foreign keys for other tables (worker, leadTc, partner)
 * 
 */
@Entity
@Table(name="Erid")
@NamedQueries({
    @NamedQuery(name = "Erid.findAll", query = "SELECT c FROM Erid c"),
    @NamedQuery(name = "Erid.findByErid", query = "SELECT e FROM Erid e WHERE e.erid = :erid"),
    @NamedQuery(name = "Erid.findById", query   = "SELECT e FROM Erid e WHERE e.id = :id")})
public class Erid extends AbstractEntity {
    
    private static final long serialVersionUID = 1L;
    
    //Here we add our fields (and methods) 
    //=================================================================================================================
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    /** The main value for projects. It consists from digits and should be taken from RedMine*/
    @Column(name = "ERID", unique = true, nullable = false)
    private Integer erid; 
    
    /** The code name of the projects. It should be taken from RedMine */
    @Column(name="CODE_NAME", nullable = false)
    private String codeName;      
    
    /** The short description of the project.  It should be taken from RedMine*/
    @Column(name="DESCRIPTION", nullable = false)
    private String description;   
    
    /** It shows the state in which the project is.  It should be taken from RedMine */
    @Column(name="STATUS", nullable = false)
    private String status;
    
    /** The planned start date of the project */
    @Column(name="START_PLANNED_DATE")
    @Temporal(TemporalType.DATE)
    private Date startPlannedDate;
    
    /** The planned finish date of the project */
    @Column(name="FINISH_PLANNED_DATE")
    @Temporal(TemporalType.DATE)
    private Date finishPlannedDate;
    
    /** The actual  start date of the project */
    @Column(name="START_FACT_DATE")
    @Temporal(TemporalType.DATE)
    private Date startFactDate;
    
    /** The actual finish date of the project */
    @Column(name="FINISH_FACT_DATE")
    @Temporal(TemporalType.DATE)
    private Date finishFactDate;
    
//    @JoinColumn(name = "SIEBEL", referencedColumnName = "ID")
//    @ManyToOne
//    private Siebel siebelId;
    
    /** The foreign key to the table 'Partner': id-->id */
    @JoinColumn(name = "PARTNER", referencedColumnName = "ID")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Partner partner;
    
     /** The foreign key to the table 'Worker': id-->id */
    @JoinColumn(name = "WORKER", referencedColumnName = "ID")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Worker worker;
    
     /** The foreign key to the table 'LeadTc': id-->id */
    @JoinColumn(name = "LEADTC", referencedColumnName = "ID")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private LeadTc leadTc;
    //=================================================================================================================
    
   
    /** The empty constructor is necessary for Entity Beans */
    public Erid() {
    }

    /** The constructor for Erid Entity Bean.
     * @param id
     * @param erid  
     * @param codeName 
     * @param partnerId
     * @param description 
     * @param startPlannedDate
     * @param status
     * @param startFactDate
     * @param finishPlannedDate
     * @param finishFactDate
     * @param WorkerId
     * @param leadTc  
     */
    public Erid(Integer id, Integer erid, String codeName, String description, String status,
            Date startPlannedDate, Date finishPlannedDate, Date startFactDate, Date finishFactDate,
            Partner partnerId, Worker WorkerId, LeadTc leadTc) {
        super();
        this.id = id;
        this.erid = erid;
        this.codeName = codeName;
        this.description = description;
        this.status = status;
        this.startPlannedDate = startPlannedDate;
        this.finishPlannedDate = finishPlannedDate;
        this.startFactDate = startFactDate;
        this.finishFactDate = finishFactDate;
        this.partner = partnerId;
        this.worker = WorkerId;
        this.leadTc = leadTc;
    }

    //Getters and Setters
    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    public Integer getErid() {
        return erid;
    }

    public void setErid(Integer erid) {
        this.erid = erid;
    }

    public Date getFinishFactDate() {
        return finishFactDate;
    }

    public void setFinishFactDate(Date finishFactDate) {
        this.finishFactDate = finishFactDate;
    }

    public Date getFinishPlannedDate() {
        return finishPlannedDate;
    }

    public void setFinishPlannedDate(Date finishPlannedDate) {
        this.finishPlannedDate = finishPlannedDate;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public LeadTc getLeadTc() {
        return leadTc;
    }

    public void setLeadTc(LeadTc leadTc) {
        this.leadTc = leadTc;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    
    public Date getStartFactDate() {
        return startFactDate;
    }

    public void setStartFactDate(Date startFactDate) {
        this.startFactDate = startFactDate;
    }

    public Date getStartPlannedDate() {
        return startPlannedDate;
    }

    public void setStartPlannedDate(Date startPlannedDate) {
        this.startPlannedDate = startPlannedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
 
    //==========Auto-generated methods=========================================================================
    
    @Override
    public Integer getId() { return id; }
    @Override
    public void setId(Integer id) { this.id = id;}
    
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /** In this standart method We're adding Erid (it should be unique too)*/
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Erid)) {
            return false;
        }
        Erid other = (Erid) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        } 
        if ((this.erid == null && other.erid != null) || (this.erid != null && !this.erid.equals(other.erid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("toString() - Erid ");
        builder.append("[ id = ").append(id).append(" , erid = ").append(erid).append(
                ", Code Name = ").append(codeName).append(" ]");
        return builder.toString();
    }
    
}
