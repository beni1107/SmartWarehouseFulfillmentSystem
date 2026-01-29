/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beni.smart_warehouse_fulfillment_system;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author beni
 */
public class Perishables extends InventoryItem{
    
    LocalDate expiryDate;
    
    public Perishables (String id, String name, double baseVolume,int hazardLevel) {
        super(id,name,baseVolume,hazardLevel);
        LocalDate date = LocalDate.now();
        this.expiryDate = date.plusDays((int)((Math.random()*15)+1));
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    
    
    
    
    @Override
    public double calculateStorageInsurance() {
        LocalDate currentDate = LocalDate.now();
        
        long diff = ChronoUnit.DAYS.between(currentDate, this.expiryDate);
        if(diff < 3) {
            return this.getVolume()*4;
        }
        return this.getVolume();  
    }
    @Override
    public String toString() {
        return super.toString()+" exp. date: "+this.expiryDate+" TOTAL INSURANCE: "+this.calculateStorageInsurance();
    }
}
