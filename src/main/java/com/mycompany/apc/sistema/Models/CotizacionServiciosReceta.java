/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apc.sistema.Models;

/**
 *
 * @author johan
 */
public class CotizacionServiciosReceta {
    private Recetas id_receta;
    private CotizacionServicio id_cotización_servicio;
    int factor_terico;
    int factor_produccion;

    public CotizacionServiciosReceta(Recetas id_receta, CotizacionServicio id_cotización_servicio, int factor_terico, int factor_produccion) {
        this.id_receta = id_receta;
        this.id_cotización_servicio = id_cotización_servicio;
        this.factor_terico = factor_terico;
        this.factor_produccion = factor_produccion;
    }    

    public Recetas getId_receta() {
        return id_receta;
    }

    public void setId_receta(Recetas id_receta) {
        this.id_receta = id_receta;
    }

    public CotizacionServicio getId_cotización_servicio() {
        return id_cotización_servicio;
    }

    public void setId_cotización_servicio(CotizacionServicio id_cotización_servicio) {
        this.id_cotización_servicio = id_cotización_servicio;
    }

    public int getFactor_terico() {
        return factor_terico;
    }

    public void setFactor_terico(int factor_terico) {
        this.factor_terico = factor_terico;
    }

    public int getFactor_produccion() {
        return factor_produccion;
    }

    public void setFactor_produccion(int factor_produccion) {
        this.factor_produccion = factor_produccion;
    }
        
}
