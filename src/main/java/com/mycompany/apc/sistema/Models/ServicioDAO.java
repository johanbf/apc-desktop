/*
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
public class ServicioDAO {
    Conexion conectar = Conexion.getInstance();
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet rows;

    public ServicioDAO() {
    }
    
    public boolean guardarServicio(String nombre){
        try {
            con = conectar.conectar();
            preparedStatement = con.prepareStatement("INSERT INTO `servicio`(`nombre`) VALUES (?)");
            preparedStatement.setString(1, nombre);
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al recuperar consulta "+e);
            return false;
        }
    }
    
    public List listarServicios(){
        List<Servicio> servicios = new ArrayList<>();
        try {
            con = conectar.conectar();
            preparedStatement = con.prepareStatement("SELECT * FROM servicio");
            rows = preparedStatement.executeQuery(); 
            while (rows.next()) {
                Servicio servicio = new Servicio();
                servicio.setId(rows.getInt("id"));
                servicio.setNombre(rows.getString("nombre"));
                servicios.add(servicio);
            }
            
            rows.close();
            conectar.cerrarConexion();
            return servicios;
        } catch (Exception e) {
            System.out.println("Error al recuperar consulta "+e);
            return null;
        }       
    }
    
}
