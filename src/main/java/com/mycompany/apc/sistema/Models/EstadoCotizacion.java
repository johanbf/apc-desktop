/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apc.sistema.Models;
 
/**
 *
 * @author johan
 */
public class EstadoCotizacion {
    private int id;
    private String nombre_ec;

    public EstadoCotizacion() {
    }

    public EstadoCotizacion(int id, String nombre_ec) {
        this.id = id;
        this.nombre_ec = nombre_ec;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_ec() {
        return nombre_ec;
    }

    public void setNombre_ec(String nombre_ec) {
        this.nombre_ec = nombre_ec;
    }
}
