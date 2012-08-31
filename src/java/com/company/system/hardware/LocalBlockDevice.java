

package com.company.system.hardware;

/**
 *
 * @author pavel
 */
public class LocalBlockDevice extends BlockDevices {
    private String model;

    public String getModel() {
        return model;
    }

    public String getStorageinterface() {
        return storageinterface;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setStorageinterface(String storageinterface) {
        this.storageinterface = storageinterface;
    }
    // TODO: enum here
    private String storageinterface;
}
