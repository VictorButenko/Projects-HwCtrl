/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.system.hardware;

import java.util.LinkedList;

/**
 *
 * @author pavel
 */
public class SystemXBladeCenter implements RackServer{

    private String rack;
    private int startunit;
    private int endunit;
    private LinkedList <BladeServer> blades;
    private String mgmtip;
    
    
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
        this.mgmtip  = ip;
    }
    
}
