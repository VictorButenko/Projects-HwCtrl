/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.system.hardware;

/**
 *
 * @author pavel
 */
public abstract class StorageSystem implements RackServer{
    protected String serial;
    protected String rack;
    protected int startunit;
    protected int endunit;
    protected String mgmtip;
    
    
    
}
