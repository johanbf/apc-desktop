/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apc.sistema.Controllers;

import com.mycompany.apc.sistema.Models.Usuario;
import com.mycompany.apc.sistema.Models.UsuarioDAO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author johan
 */
public class UsuarioController {
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public boolean validarSesion(String usuario, String password){
        if(usuario.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(null, "El usuario y la contraseña son campos oblicatorios");
            return false;
        }else{
            boolean validar = usuarioDAO.validarSesion(usuario, password);
            if(validar){
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
                return false;
            }
        }
    }
    
    public void ListarUsuarios(){
        List<Usuario> lista = usuarioDAO.ListarUsuarios();
        for(int i = 0; i < lista.size(); i++){
            System.out.println("Usurio id " + lista.get(i).getId());
        }
    }    
}
