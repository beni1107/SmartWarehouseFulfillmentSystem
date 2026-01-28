/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.beni.smart_warehouse_fulfillment_system;

/**
 *
 * @author bendz
 * @param <T>
 */
public interface Storable<T> {
    
     public T getIdentification();
     public double getVolume();
     public int getHazardLevel();
    
}
