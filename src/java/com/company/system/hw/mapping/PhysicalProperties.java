
package com.company.system.hw.mapping;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Embeddable class <code>PhysicalProperties</code> encapsulates information
 * about physical Rack Servers. The fields of this class will be saved in 
 * the appropriate Entities like fields.
 * 
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
    
    /** The serial number of the server. Should be unique*/
    @Column(name = "SERIAL", nullable = false, unique = true)
    private String serial;
    
    
    // Void constructor is necessary for entities
    public PhysicalProperties() {
    }

    //Constructor
    public PhysicalProperties(String room, String rack, 
            int startUnit, int endUnit, String serial) {
        super();
        this.room = room;
        this.rack = rack;
        this.startUnit = startUnit;
        this.endUnit = endUnit;
        this.serial  = serial;
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

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    
}
