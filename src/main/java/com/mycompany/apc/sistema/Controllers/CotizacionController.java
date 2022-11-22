/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apc.sistema.Controllers;

import com.mycompany.apc.sistema.Models.Cliente;
import com.mycompany.apc.sistema.Models.ClienteDAO;
import com.mycompany.apc.sistema.Models.Cotizacion;
import com.mycompany.apc.sistema.Models.CotizacionDAO;
import com.mycompany.apc.sistema.Models.EstadoCotizacion;
import com.mycompany.apc.sistema.Models.EstadoCotizacionDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author johan
 */
public class CotizacionController {
    CotizacionDAO cotizacionDAO = new CotizacionDAO();
    EstadoCotizacionDAO estadoCotizacionDAO = new EstadoCotizacionDAO();
    ClienteDAO clienteDao = new ClienteDAO();
    
    public String generarCorrelativo(){
        Cotizacion datoCorrelativo = cotizacionDAO.obtenerCorrelativo();
        if(datoCorrelativo != null){
            return "COT000"+datoCorrelativo.getId() + 1;
        }else{
            return "COT0001";
        }
    }
    
    public void listarEstadoCotizacion(JComboBox<String> selectEstadoCotizacion){
        List<EstadoCotizacion> lista = estadoCotizacionDAO.listaCotizacion();
        for(int i = 0; i < lista.size(); i++){
            selectEstadoCotizacion.addItem(lista.get(i).getNombre_ec());
        }
    }
    
    public String crearCotizacion(String cliente, String estado, String nombre, String fecha_inicio, String fecha_fin) {
        String correlativo = generarCorrelativo();
        Cliente clienteBusqueda = clienteDao.clienteNombre(cliente);
        EstadoCotizacion estadoCotizacionBusqueda = estadoCotizacionDAO.estadoNombre(estado);
        String crear = cotizacionDAO.crearCotizacion(correlativo, clienteBusqueda.getId(), estadoCotizacionBusqueda.getId(), nombre, fecha_inicio, fecha_fin);
        return crear;
    }
    
    public void listarCotizaciones(DefaultTableModel model,JTable ListaCotizaciones){
        List<Cotizacion> lista = cotizacionDAO.listarCotizaciones();
        model = (DefaultTableModel) ListaCotizaciones.getModel();
        for(int i = 0; i < lista.size(); i++){
            String data[] = { lista.get(i).getCorrelativo(), lista.get(i).getNombre(), lista.get(i).getId_cliente().getNombre(), lista.get(i).getNombre_ec().getNombre_ec(), lista.get(i).getFecha_inicio(), lista.get(i).getFecha_fin() };
            model.addRow(data);
        }
    }
    
    public Cotizacion cotizacionCorrelativo(String correlativo){
        CotizacionDAO cotizacionDAO = new CotizacionDAO();
        Cotizacion cotizacion = cotizacionDAO.cotizacionCorrelativo(correlativo);
        return cotizacion;
    }
    
    public void fechaListar(String fechaInicio, String fechaFin, JComboBox<String> fechaSelect){
        String[] arrFechaInicio = fechaInicio.split("-");
        String[] arrFechaFin = fechaFin.split("-");
        
        Calendar c1 = Calendar.getInstance();
        c1.set(Integer.parseInt(arrFechaInicio[0]), Integer.parseInt(arrFechaInicio[1])-1, Integer.parseInt(arrFechaInicio[2])); // Recuerda, en Java
        
        Calendar c2 = Calendar.getInstance();
        c2.set(Integer.parseInt(arrFechaFin[0]), Integer.parseInt(arrFechaFin[1])-1, Integer.parseInt(arrFechaFin[2]));
                
        while (!c1.after(c2)) { 
            SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
            fechaSelect.addItem(ff.format(c1.getTime()));
            //System.out.println(ff.format(c1.getTime()));
            c1.add(Calendar.DAY_OF_YEAR, 1);
        }
    }
            
}
