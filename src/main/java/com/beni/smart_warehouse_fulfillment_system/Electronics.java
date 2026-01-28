/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beni.smart_warehouse_fulfillment_system;

/**
 *
 * @author bendz
 */
public class Electronics extends InventoryItem {
    private int wattage;
    
    public Electronics(String id, String name, double baseVolume,int hazardLevel,int wattage) {
        super(id, name, baseVolume, hazardLevel);
        this.wattage=wattage;
    }
    
    @Override
    public double calculateStorageInsurance() {
        return this.getVolume()+this.wattage*2;
    }

  
    
    @Override
    public String toString() {
        return super.toString()+ " Watt: "+this.wattage;
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }
    
}
