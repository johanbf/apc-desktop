/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apc.sistema.Controllers;

import com.mycompany.apc.sistema.Models.Servicio;
import com.mycompany.apc.sistema.Models.ServicioDAO;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author johan
 */
public class ServicioController {
    
    ServicioDAO servicioDAO = new ServicioDAO();
    
    public void listarServicios(DefaultTableModel model, JTable tableServicio){
        List<Servicio> lista = servicioDAO.listarServicios();
        model = (DefaultTableModel) tableServicio.getModel();
        for(int i = 0; i < lista.size(); i++){
            String data[] = { String.valueOf(lista.get(i).getId()), lista.get(i).getNombre() };
            model.addRow(data);
        }
    }
    
    public boolean guardarServicio(String nombre){
        return servicioDAO.guardarServicio(nombre);
    }
    
}
