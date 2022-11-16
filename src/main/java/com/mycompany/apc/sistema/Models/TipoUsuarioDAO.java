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
public class TipoUsuarioDAO {
    Conexion conectar = Conexion.getInstance();
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet rows;
    
    public TipoUsuario tipoUsuarioId(int id){
        
        try {
            con = conectar.conectar();
            preparedStatement = con.prepareStatement("SELECT * FROM tipo_usuario WHERE id = ?");
            preparedStatement.setInt(1, id);
            rows = preparedStatement.executeQuery();
            while (rows.next()) {
                TipoUsuario tipoUsuario = new TipoUsuario();
                tipoUsuario.setId(Integer.parseInt( rows.getString("id")));
                tipoUsuario.setNombre(rows.getString("nombre"));
                return tipoUsuario;
            }
            conectar.cerrarConexion();
            return null;
        } catch (Exception e) {
            System.out.println("Error al recuperar consulta "+e);
            return null;
        }        
    }
}
