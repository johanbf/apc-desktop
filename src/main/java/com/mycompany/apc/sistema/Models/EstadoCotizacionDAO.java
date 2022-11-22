/*z
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apc.sistema.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johan
 */
public class EstadoCotizacionDAO {
    Conexion conectar = Conexion.getInstance();
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet rows;
    
    public List listaCotizacion(){
        List<EstadoCotizacion> estadoCotizacions = new ArrayList<>();
        try {
            con = conectar.conectar();
            preparedStatement = con.prepareStatement("SELECT * FROM estado_cotizacion");
            rows = preparedStatement.executeQuery();
            while (rows.next()) {
                EstadoCotizacion estadoCotizacion = new EstadoCotizacion();
                estadoCotizacion.setId(rows.getInt("id"));
                estadoCotizacion.setNombre_ec(rows.getString("nombre"));
                estadoCotizacions.add(estadoCotizacion);                   
            }
            rows.close();
            conectar.cerrarConexion();
            return estadoCotizacions;
        } catch (Exception e) {
            System.out.println("Error al recuperar consulta "+e);
            return null;
        }
    }
    
     public EstadoCotizacion estadoNombre(String nombre){
        try {
            con = conectar.conectar();
            preparedStatement = con.prepareStatement("SELECT * FROM estado_cotizacion WHERE nombre = ?");
            preparedStatement.setString(1, nombre);
            rows = preparedStatement.executeQuery();
            while (rows.next()) {
                EstadoCotizacion cotizacion = new EstadoCotizacion();
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
     
    public EstadoCotizacion estadoId(int id){
        try {
            con = conectar.conectar();
            preparedStatement = con.prepareStatement("SELECT * FROM estado_cotizacion WHERE id = ?");
            preparedStatement.setInt(1, id);
            rows = preparedStatement.executeQuery();
            while (rows.next()) {
                EstadoCotizacion cotizacion = new EstadoCotizacion();
                cotizacion.setId(Integer.parseInt( rows.getString("id")));
                cotizacion.setNombre_ec(rows.getString("nombre"));
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
