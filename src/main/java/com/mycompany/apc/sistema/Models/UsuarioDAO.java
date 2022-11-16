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
public class UsuarioDAO{
    
    Conexion conectar = Conexion.getInstance();
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet rows;
    
    public boolean validarSesion(String usuario, String password){
        try {
            con = conectar.conectar();
            preparedStatement = con.prepareStatement("SELECT * FROM usuario WHERE usuario = ? AND password = ?");
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, password);
            rows = preparedStatement.executeQuery();
            
            if(rows.next()){
                return true;
            }
            
        } catch (Exception e) {
            System.out.println("Error al recuperar consulta "+e);
            return false;
        }
        return false;
    }
    
    public List ListarUsuarios(){
        List<Usuario> usuarios =new ArrayList<>();
            try {
                con = conectar.conectar();
                preparedStatement = con.prepareStatement("SELECT * FROM usuario");
                rows = preparedStatement.executeQuery();
                while (rows.next()) {
                    Usuario usuario = new Usuario();
                    TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
                    usuario.setId(rows.getInt("id"));
                    usuario.setNombre(rows.getString("nombre"));
                    usuario.setUsuario(rows.getString("usuario"));
                    usuario.setPassword(rows.getString("password"));
                    usuario.setTipoUsuario(tipoUsuarioDAO.tipoUsuarioId(rows.getInt("id_tipo_usuario")));
                    usuarios.add(usuario);                   
                }
                rows.close();
                conectar.cerrarConexion();
                return usuarios;
            } catch (Exception e) {
                System.out.println("Error al recuperar consulta "+e);
                return null;
            }
    }
    
}
