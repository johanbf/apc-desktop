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
public class TipoClienteDAO {
    Conexion conectar = Conexion.getInstance();
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet rows;
    
    public TipoCliente tipoClienteId(int id){
        
        try {
            con = conectar.conectar();
            preparedStatement = con.prepareStatement("SELECT * FROM tipo_cliente WHERE id = ?");
            preparedStatement.setInt(1, id);
            rows = preparedStatement.executeQuery();
            while (rows.next()) {
                TipoCliente tipoCliente = new TipoCliente();
                tipoCliente.setId(Integer.parseInt( rows.getString("id")));
                tipoCliente.setNombre(rows.getString("nombre"));
                return tipoCliente;
            }
            rows.close();
            conectar.cerrarConexion();
            return null;
        } catch (Exception e) {
            System.out.println("Error al recuperar consulta "+e);
            return null;
        }        
    }
    
    public TipoCliente tipoClienteNombre(String nombre){
        try {
            con = conectar.conectar();
            preparedStatement = con.prepareStatement("SELECT * FROM tipo_cliente WHERE nombre = ?");
            preparedStatement.setString(1, nombre);
            rows = preparedStatement.executeQuery();
            while (rows.next()) {
                TipoCliente tipoCliente = new TipoCliente();
                tipoCliente.setId(Integer.parseInt( rows.getString("id")));
                tipoCliente.setNombre(rows.getString("nombre"));
                return tipoCliente;
            }
            rows.close();
            conectar.cerrarConexion();
            return null;
        } catch (Exception e) {
            System.out.println("Error al recuperar consulta "+e);
            return null;
        }
    }
    
    public List listarTipoClientes(){
        List<TipoCliente> tipoClientes = new ArrayList<>();
        try {
            con = conectar.conectar();
            preparedStatement = con.prepareStatement("SELECT * FROM tipo_cliente");
            rows = preparedStatement.executeQuery();
            while (rows.next()) {
                TipoCliente tipoCliente = new TipoCliente();
                tipoCliente.setId(Integer.parseInt( rows.getString("id")));
                tipoCliente.setNombre(rows.getString("nombre"));
                tipoClientes.add(tipoCliente);
            }
            rows.close();
            conectar.cerrarConexion();
            return tipoClientes;
        } catch (Exception e) {
             System.out.println("Error al recuperar consulta "+e);
            return null;
        }
    }
}
