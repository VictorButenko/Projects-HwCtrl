/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.system.hardware;

import java.util.ArrayList;

/**
 *
 * @author pavel
 */
class BladeCenter implements RackServer {
    private ArrayList<BladeServer> blades;

    public void setBlades(ArrayList<BladeServer> blades){
        this.blades = blades;
    }

    public ArrayList<BladeServer> getBlades(){
        return blades;
    }
    // FIXME
    // Move from entity to facade?
    // or something else?
    public void rescanBlades(){
        // rescan blades here
    }

    @Override
    public void setRack(String rack) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setStartUnit(int unit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setEndUnit(int unit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setMgmtIP(String ip) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
