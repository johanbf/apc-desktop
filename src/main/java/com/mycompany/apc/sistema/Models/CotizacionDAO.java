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
    
    public String crearCotizacion(String correlativo,int id_cliente, int id_estado, String nombre, String fecha_inicio, String fecha_fin){
        try {
            con = conectar.conectar();
            preparedStatement = con.prepareStatement("INSERT INTO `cotizacion`(`correlativo`, `id_cliente`, `id_estado`, `nombre`, `fecha_inicio`, `fecha_fin`, `costo_total`) VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setString(1, correlativo);
            preparedStatement.setInt(2, id_cliente);
            preparedStatement.setInt(3, id_estado);
            preparedStatement.setString(4, nombre);
            preparedStatement.setString(5, fecha_inicio);
            preparedStatement.setString(6, fecha_fin);
            preparedStatement.setInt(7, 0);            
            preparedStatement.execute();            
            rows.close();
            conectar.cerrarConexion();
            return correlativo;
        } catch (Exception e) {
            System.out.println("Error al recuperar consulta "+e);
            return null;
        }
    }
    
    public List listarCotizaciones(){
        List<Cotizacion> cotizaciones = new ArrayList<>();
        try {
            con = conectar.conectar();
            preparedStatement = con.prepareStatement("SELECT * FROM `cotizacion` ORDER BY `id` DESC");
            rows = preparedStatement.executeQuery();
            while (rows.next()) {
                Cotizacion cotizacion = new Cotizacion();
                ClienteDAO clienteDAO = new ClienteDAO();
                EstadoCotizacionDAO estadoCotizacionDAO = new EstadoCotizacionDAO();
                Cliente cliente = clienteDAO.clienteId(Integer.parseInt(rows.getString("id_cliente")));
                EstadoCotizacion estadoCotizacion = estadoCotizacionDAO.estadoId(Integer.parseInt(rows.getString("id_estado")));
                cotizacion.setId(Integer.parseInt( rows.getString("id")));
                cotizacion.setCorrelativo(rows.getString("correlativo"));
                cotizacion.setId_cliente(cliente);
                cotizacion.setNombre_ec(estadoCotizacion);
                cotizacion.setNombre(rows.getString("nombre"));
                cotizacion.setFecha_fin(rows.getString("fecha_fin"));
                cotizacion.setFecha_inicio(rows.getString("fecha_inicio"));
                cotizaciones.add(cotizacion);
            }
            rows.close();
            conectar.cerrarConexion();
            return cotizaciones;
        } catch (Exception e) {
            System.out.println("Error al recuperar consulta "+e);
            return null;
        }
    }
 
    public Cotizacion cotizacionCorrelativo(String correlativo){
        try {
            con = conectar.conectar();
            preparedStatement = con.prepareStatement("SELECT * FROM cotizacion WHERE correlativo = ?");
            preparedStatement.setString(1, correlativo);
            rows = preparedStatement.executeQuery();
            while (rows.next()) {                
                Cotizacion cotizacion = new Cotizacion();
                ClienteDAO clienteDAO = new ClienteDAO();
                EstadoCotizacionDAO estadoCotizacionDAO = new EstadoCotizacionDAO();
                Cliente cliente = clienteDAO.clienteId(Integer.parseInt(rows.getString("id_cliente")));
                EstadoCotizacion estadoCotizacion = estadoCotizacionDAO.estadoId(Integer.parseInt(rows.getString("id_estado")));
                cotizacion.setId(Integer.parseInt(rows.getString("id")));
                cotizacion.setNombre(rows.getString("nombre"));
                cotizacion.setId_cliente(cliente);
                cotizacion.setNombre_ec(estadoCotizacion);
                cotizacion.setNombre(rows.getString("nombre"));
                cotizacion.setFecha_fin(rows.getString("fecha_fin"));
                cotizacion.setFecha_inicio(rows.getString("fecha_inicio"));
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
