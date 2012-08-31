/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.system.hardware;

/**
 *
 * @author pavel
 */
class NIC {
    private String macaddress;
    private int VLAN;
    private String model;

    public void setVLAN(int VLAN) {
        this.VLAN = VLAN;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getVLAN() {
        return VLAN;
    }

    public String getMacaddress() {
        return macaddress;
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }
    private int speed;
    
}
