/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apc.sistema.Models;

/**
 *
 * @author johan
 */
public class Cotizacion {
    private int id;
    private String correlativo, nombre; 
    private String fecha_inicio,fecha_fin; 
    private Cliente id_cliente;   
    private EstadoCotizacion nombre_ec;
    private double costo_total;

    public Cotizacion() {
    }

    public Cotizacion(int id, String correlativo, String nombre, String fecha_inicio, String fecha_fin, Cliente id_cliente, EstadoCotizacion nombre_ec, double costo_total) {
        this.id = id;
        this.correlativo = correlativo;
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.id_cliente = id_cliente;
        this.nombre_ec = nombre_ec;
        this.costo_total = costo_total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    public EstadoCotizacion getNombre_ec() {
        return nombre_ec;
    }

    public void setNombre_ec(EstadoCotizacion nombre_ec) {
        this.nombre_ec = nombre_ec;
    }

    public double getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(double costo_total) {
        this.costo_total = costo_total;
    }
}
