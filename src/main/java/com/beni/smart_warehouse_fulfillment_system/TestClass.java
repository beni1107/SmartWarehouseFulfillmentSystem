/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beni.smart_warehouse_fulfillment_system;

import java.util.Collections;

/**
 *
 * @author bendz
 */
public class TestClass {
    
    public static void main(String[] args) {
    Warehouse<InventoryItem> wh = new Warehouse<>(100);
    try {
        wh.addItem(new Electronics("1","Samsung Phone",15,3,20));
        wh.addItem(new Perishables("2","Apples",5,4));
        wh.addItem(new HazardusMaterial("5","Kislina",20,5,"zelo nevarno"));
         wh.addItem(new Electronics("7","Apple Phone",12,4,5));
        wh.addItem(new Perishables("16","Berries",3,2));
        wh.addItem(new HazardusMaterial("15","Kislina solna",20,8,"zelo nevarno"));
         wh.addItem(new Electronics("18","Samsung Phone",2,2,20));
        wh.addItem(new Perishables("22","Bananas",1,1));
        wh.addItem(new HazardusMaterial("52","Prasek",3,6,"zelo nevarno"));
    }catch(WarehouseCapacityException e) {
        System.err.println(e.getMessage()+" Over by: "+e.getAmountOver());
    }
    wh.safetyAuditReport();
    wh.sortItems();
    wh.getInventory().stream().forEach(item -> System.out.println(item));
    
    
    }
   
 }
