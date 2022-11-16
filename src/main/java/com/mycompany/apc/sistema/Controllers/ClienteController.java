/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apc.sistema.Controllers;

import com.mycompany.apc.sistema.Models.Cliente;
import com.mycompany.apc.sistema.Models.ClienteDAO;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author johan
 */
public class ClienteController {
    ClienteDAO clienteDAO = new ClienteDAO();
    
    public void listarClientes(JComboBox<String> clienteSelect){        
        List<Cliente> lista = clienteDAO.ListarClientes();
        for(int i = 0; i < lista.size(); i++){
            System.out.println("" + lista.get(i).getNombre());
            clienteSelect.addItem(lista.get(i).getNombre());
        }                
    }
    
    public boolean guardarCliente(String nombre, String direccion, String telefono, String tipoCliente){
        
       boolean insertar = clienteDAO.guardarCliente(nombre, direccion, telefono, tipoCliente);
       if(insertar){
           JOptionPane.showMessageDialog(null, "EL cliente "+nombre+" se ha registrado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);           
           return true;
       }else{
           JOptionPane.showMessageDialog(null, "Error al registrar","Error", JOptionPane.ERROR_MESSAGE);
           return false;
       }
        
    }
    
}
