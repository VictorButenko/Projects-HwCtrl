/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.system.hardware;

/**
 *
 * @author pavel
 */
public class SANSwitch extends StorageSystem{
    
    private SANSwitchConfig config;

    public void setConfig(SANSwitchConfig config) {
        this.config = config;
    }

    public void setEndunit(int endunit) {
        this.endunit = endunit;
    }

    public void setMgmtip(String mgmtip) {
        this.mgmtip = mgmtip;
    }

    

    public void setStartunit(int startunit) {
        this.startunit = startunit;
    }

    public SANSwitchConfig getConfig() {
        return config;
    }

    @Override
    public void setRack(String rack) {
        this.rack = rack;
    }

    @Override
    public void setStartUnit(int unit) {
        this.startunit = unit;
    }

    @Override
    public void setEndUnit(int unit) {
        this.endunit = unit;
    }

    @Override
    public void setMgmtIP(String ip) {
        this.mgmtip = ip;
    }
    
    
}
