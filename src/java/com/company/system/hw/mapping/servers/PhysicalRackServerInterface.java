
package com.company.system.hw.mapping.servers;

import com.company.system.hw.mapping.MM;
import com.company.system.hw.mapping.PhysicalProperties;

/**
 * The <code>PhysicalRackServerInterface</code> is the interface
 * for realizing by some classes which represents <b>NOT virtual</b>
 * servers. Foricing having RackServer field in the class.
 *
 * Will be implemented by:
 * <b>System X </b>:
 *    <code>BladeCenter</code> ;
 *    <code>RackX</code>;
 * <b>Power System</b>:
 *    <code>HMC</code>;
 *    <code>RackP</code>;
 *    <code>VIOS</code>;
 * <b> System Storage</b>:
 *    <code>SSD</code>;
 *    <code>SwitchStorage</code>.
 */
public interface PhysicalRackServerInterface {
    
    /**
     * Methods are using to force to have the PhysicalProperties field
     * 
     * @param physicalServer - <code>PhysicalProperties</code>
     */
    public void setPhysicalServer(PhysicalProperties physicalServer);
    public PhysicalProperties getPhysicalServer();
    
    /**
     * Methods using to force some Servers have MM.
     * 
     * @param mgmtIP 
     */
    public void setMgmtIP(MM mgmtIP);
    public MM getMgmtIP();
    
    /**
     * Getters/Setters for ServerName paramanter
     * 
     * @param name 
     */
    public void setName(String name);
    public String getName();
    

    
}