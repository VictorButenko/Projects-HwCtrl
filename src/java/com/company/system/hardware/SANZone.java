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
public class SANZone {

    private String name;
    private LinkedList<WWN> members;

    public LinkedList<WWN> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }

    public void setMembers(LinkedList<WWN> members) {
        this.members = members;
    }

    public void setName(String name) {
        this.name = name;
    }
}
