/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.system.hardware;

/**
 *
 * @author pavel
 */
public interface RackServer {
    
    
    public void setRack(String rack);
    public void setStartUnit(int unit);
    public void setEndUnit(int unit);
    public void setMgmtIP(String ip);
}
