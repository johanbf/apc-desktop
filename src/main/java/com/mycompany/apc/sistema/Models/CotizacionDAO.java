/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apc.sistema.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author johan
 */
public class CotizacionDAO {
    Conexion conectar = Conexion.getInstance();
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet rows;
    
    public Cotizacion obtenerCorrelativo(){
        try {
            con = conectar.conectar();
            preparedStatement = con.prepareStatement("SELECT * FROM `cotizacion` ORDER BY `id` DESC LIMIT 1");
            rows = preparedStatement.executeQuery();
            while (rows.next()) {
                Cotizacion cotizacion = new Cotizacion();
                cotizacion.setId(Integer.parseInt( rows.getString("id")));
                return cotizacion;
            }
            rows.close();
            conectar.cerrarConexion();
            return null;
        } catch (Exception e) {
            System.out.println("Error al recuperar consulta "+e);
            return null;
        }
    }
    
}
