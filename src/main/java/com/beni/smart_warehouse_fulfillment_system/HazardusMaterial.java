/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beni.smart_warehouse_fulfillment_system;

import java.util.Objects;

/**
 *
 * @author beni
 */
public class HazardusMaterial extends InventoryItem{
    private String safteyProtocol;
    
    public HazardusMaterial(String id, String name, double baseVolume,int hazardLevel,String safteyProtocol){
        Objects.requireNonNull(safteyProtocol, "Saftey protocol ne more biti null");
        super(id,name,baseVolume,hazardLevel);
        this.safteyProtocol=safteyProtocol;
    }

    @Override
    public double calculateStorageInsurance() {
        return (this.getVolume()* this.getHazardLevel())+100;
    }
    @Override
    public String toString(){
        return super.toString()+" Saftey protocol: "+this.safteyProtocol+" TOTAL INSURANCE: "+this.calculateStorageInsurance();
    }

    public String getSafteyProtocol() {
        return safteyProtocol;
    }

    public void setSafteyProtocol(String safteyProtocol) {
        Objects.requireNonNull(safteyProtocol, "Saftey protol ne more biti null");
        this.safteyProtocol = safteyProtocol;
    }
    
}
