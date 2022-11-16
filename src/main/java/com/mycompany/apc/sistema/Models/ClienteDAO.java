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
public class ClienteDAO {
    Conexion conectar = Conexion.getInstance();
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet rows;
    
    public List ListarClientes(){
        List<Cliente> clientes = new ArrayList<>();
        try {
            con = conectar.conectar();
            preparedStatement = con.prepareStatement("SELECT * FROM cliente");
            rows = preparedStatement.executeQuery(); 
            while (rows.next()) {
                Cliente cliente = new Cliente();
                TipoClienteDAO tcdao = new TipoClienteDAO();
                cliente.setId(rows.getInt("id"));
                cliente.setNombre(rows.getString("nombre"));
                cliente.setTelefono(Integer.parseInt(rows.getString("telefono")));
                cliente.setTipoCliente(tcdao.tipoClienteId(Integer.parseInt(rows.getString("id_tipo_cliente"))));
                clientes.add(cliente);
            }
            
            rows.close();
            conectar.cerrarConexion();
            return clientes;
        } catch (Exception e) {
            System.out.println("Error al recuperar consulta "+e);
            return null;
        }        
    }
    
    public boolean guardarCliente(String nombre, String direccion, String telefono, String tipoCliente){
        
        TipoClienteDAO tipoClienteDAO = new TipoClienteDAO();
        TipoCliente tipoClienteDato = tipoClienteDAO.tipoClienteNombre(tipoCliente);
        try {
            con = conectar.conectar();
            preparedStatement = con.prepareStatement("INSERT INTO `cliente`(`nombre`, `dirrecion`, `telefono`, `id_tipo_cliente`) VALUES (?,?,?,?)");
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, direccion);
            preparedStatement.setString(3, telefono);
            preparedStatement.setInt(4, tipoClienteDato.getId());
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al recuperar consulta "+e);
            return false;
        }
    }
}
