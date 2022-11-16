/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apc.sistema.Controllers;

import com.mycompany.apc.sistema.Models.TipoCliente;
import com.mycompany.apc.sistema.Models.TipoClienteDAO;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author johan
 */
public class TipoClienteController{

    TipoClienteDAO tipoClienteDAO = new TipoClienteDAO();
    
    public void listarTipoClientes(JComboBox<String> selectTipoCliente){
        List<TipoCliente> lista = tipoClienteDAO.listarTipoClientes();
        for(int i = 0; i < lista.size(); i++){           
            selectTipoCliente.addItem(lista.get(i).getNombre());
        }     
    }
    
}
