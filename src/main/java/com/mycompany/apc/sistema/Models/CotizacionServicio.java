/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apc.sistema.Models;

/**
 *
 * @author johan
 */
public class CotizacionServicio {
    private Cotizacion idCotizacion;
    private Servicio idServicio;

    public CotizacionServicio(Cotizacion idCotizacion, Servicio idServicio) {
        this.idCotizacion = idCotizacion;
        this.idServicio = idServicio;
    }

    public Cotizacion getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Cotizacion idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }
    
}
