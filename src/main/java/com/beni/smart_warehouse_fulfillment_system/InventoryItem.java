/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beni.smart_warehouse_fulfillment_system;

import java.awt.Stroke;
import java.util.Objects;

/**
 *
 * @author bendz
 */
public abstract class InventoryItem implements Storable<String> {
    private  String id;
    private String name;
    private double baseVolume;
    private int hazardLevel;
    
    public abstract double calculateStorageInsurance();
    
    public InventoryItem(String id, String name, double baseVolume,int hazardLevel){
        Objects.requireNonNull(id, "id ne more biti null");
        Objects.requireNonNull(name,"Ime ne more biti null");
        
        this.id=id;
        this.name=name;
        this.baseVolume=baseVolume;
        this.hazardLevel=hazardLevel;
    }
    @Override
    public String toString() {
        return "ID: "+this.id+" ime: "+this.name+" base volume: "+this.baseVolume+" hazardLevel: "+this.hazardLevel;
    }
    public String getIdentification() { //overriding from interface
        return id;
    }

    public void setId(String id) {
        Objects.requireNonNull(id,"id ne more biti null");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Objects.requireNonNull(name,"Ime ne more biti null");
        this.name = name;
    }

    public double getVolume() {//overriding from interface
        return baseVolume;
    }

    public void setVolume(double baseVolume) {
        this.baseVolume = baseVolume;
    }

    public int getHazardLevel() {//overriding from interface
        return hazardLevel;
    }

    public void setHazardLevel(int hazardLevel) {
        this.hazardLevel = hazardLevel;
    }
    
}
