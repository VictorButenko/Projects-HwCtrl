/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.system.hardware;

/**
 *
 * @author pavel
 */
abstract class BlockDevices {
    
    private int capacity;
    private BlockDeviceType type;
    private int speed = 0;

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setType(BlockDeviceType type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSpeed() {
        return speed;
    }

    public BlockDeviceType getType() {
        return type;
    }
    
}
