
package com.company.system.hw.mapping;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Embeddable class <code>PhysicalProperties</code> encapsulates information
 * about physical Rack Servers. The fields of this class will be saved in 
 * the appropriate Entities like fields.
 * 
 * @author ---GPL--- ---GPL---
 * @author You
 */
@Embeddable
public class PhysicalProperties implements Serializable   {
    
    
    @Column(name = "ROOM", nullable = false)
    /** The room where server is*/
    private String room;   
    
    @Column(name = "RACK", nullable = false)
    /** The rack where server is*/
    private String rack;
    
    /** The server is placed from <code>startUnit</code> to <code>endUnit</code>*/
    @Column(name = "STARTUNIT", nullable = false)
    private int startUnit;
    @Column(name = "ENDUNIT", nullable = false)
    private int endUnit;

    
    // Void constructor is necessary for entities
    public PhysicalProperties() {
    }

    //Constructor
    public PhysicalProperties(String room, String rack, 
            int startUnit, int endUnit) {
        super();
        this.room = room;
        this.rack = rack;
        this.startUnit = startUnit;
        this.endUnit = endUnit;
    }
    
    //Getters and Setters
    public int getEndUnit() {
        return endUnit;
    }

    public void setEndUnit(int endUnit) {
        this.endUnit = endUnit;
    }

    public String getRack() {
        return rack;
    }

    public void setRack(String rack) {
        this.rack = rack;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getStartUnit() {
        return startUnit;
    }

    public void setStartUnit(int startUnit) {
        this.startUnit = startUnit;
    }

}
