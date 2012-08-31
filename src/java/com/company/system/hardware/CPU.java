/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.system.hardware;

/**
 *
 * @author pavel
 */
class CPU {
    
    private int cores;
    private String model;

    public void setCores(int cores) {
        this.cores = cores;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }
    private String type;

    public int getCores() {
        return cores;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }
    
}
