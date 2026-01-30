/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beni.smart_warehouse_fulfillment_system;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author bendz
 * @param <T>
 */
public class Warehouse <T extends InventoryItem>  {
    private List<T> inventory;
    private double maxVolume;
    
    public Warehouse(double maxVolume) {
        this.inventory=new ArrayList<>();
        this.maxVolume=maxVolume;
    }

    public void addItem (T item) throws WarehouseCapacityException {
        double currentLoad = this.inventory.stream().mapToDouble(T::getVolume).sum();
        
        double itemCurrentLoad = currentLoad + item.getVolume();
        if ( itemCurrentLoad > this.maxVolume) {
            throw new WarehouseCapacityException("Prevelik load", itemCurrentLoad-this.maxVolume);
        }
        if(item.getHazardLevel() > 8) {
           
               if(inventory.stream().anyMatch(x -> x instanceof Perishables)) {
                   throw new IncompatibleStorageException("Eror");
               }
           }
            this.inventory.add(item);
    }
    
    public void purgeExpired() {
        Iterator<T> it = inventory.iterator();
        while(it.hasNext()) {
            T currentItem = it.next();
            if(currentItem instanceof Perishables p) {
               if(p.getExpiryDate().isBefore(LocalDate.now())) {
                   it.remove();
               }
            }
        }
    }
    
    public void safetyAuditReport() {
        System.out.println("--- HIGH RISK INVENTORY REPORT ---");
    
    this.inventory.stream()
        .filter(item -> item.getHazardLevel() > 5)
        .forEach(item -> System.out.println("ALERT: " + item.getName() + 
                 " [Hazard Level: " + item.getHazardLevel() + "]"));
    
    System.out.println("----------------------------------");
    }
    
    public void sortItems() {
        Collections.sort(this.inventory);
    }
    public List<T> getInventory() {
        return Collections.unmodifiableList(inventory);
    }

    
    public double getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(double maxVolume) {
        this.maxVolume = maxVolume;
    }
    
    public void sortByHazardLevel() {
      inventory.sort((a, b) -> Integer.compare(b.getHazardLevel(), a.getHazardLevel()));
    }
    
}
