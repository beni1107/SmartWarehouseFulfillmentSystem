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
public class WarehouseCapacityException extends Exception {
    private double amountOver;
    
    public WarehouseCapacityException(String message, double amount) {
        Objects.requireNonNull(message, "Message ne more biti null");
        super(message);
        this.amountOver=amount;
    }
}
