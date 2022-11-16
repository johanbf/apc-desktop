/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apc.sistema.Controllers;

import com.mycompany.apc.sistema.Models.Cotizacion;
import com.mycompany.apc.sistema.Models.CotizacionDAO;
import com.mycompany.apc.sistema.Models.EstadoCotizacion;
import com.mycompany.apc.sistema.Models.EstadoCotizacionDAO;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author johan
 */
public class CotizacionController {
    CotizacionDAO cotizacionDAO = new CotizacionDAO();
    EstadoCotizacionDAO estadoCotizacionDAO = new EstadoCotizacionDAO();
    
    public String generarCorrelativo(){
        Cotizacion datoCorrelativo = cotizacionDAO.obtenerCorrelativo();
        if(datoCorrelativo != null){
            return "COT000"+datoCorrelativo.getId() + 1;
        }else{
            return "COT0001";
        }
    }
    
    public void listarEstadoCotizacion(JComboBox<String> selectEstadoCotizacion){
        List<EstadoCotizacion> lista = estadoCotizacionDAO.listaCotizacion();
        for(int i = 0; i < lista.size(); i++){
            selectEstadoCotizacion.addItem(lista.get(i).getNombre_ec());
        }
    }
    
}
