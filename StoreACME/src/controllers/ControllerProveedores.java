/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelProveedores;
import views.ViewProveedores;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import lib.Conection;

/**
 *
 * @author r3n0
 */
public class ControllerProveedores implements ActionListener {
    ViewProveedores viewProveedores;
    ModelProveedores modelProveedores;
    DefaultTableModel model;
    private Statement st;
    private ResultSet rs;
    Conection conection=new Conection();
    Connection cn = conection.conexion();
    
public ControllerProveedores (ModelProveedores modelProveedores, ViewProveedores viewProveedores)   {
    this.modelProveedores = modelProveedores;
    this.viewProveedores = viewProveedores;    
    
    this.viewProveedores.jtf_id.setVisible(false);
    mostrarDatos("");
    
    this.viewProveedores.jb_agregar.addActionListener(this);
    this.viewProveedores.jb_buscar.addActionListener(this);
    this.viewProveedores.jb_editar.addActionListener(this);
    this.viewProveedores.jb_eliminar.addActionListener(this);
}

void editar()   {
    try {
        int filaSeleccionada;
        filaSeleccionada=viewProveedores.jt_tablaProveedores.getSelectedRow();
        if(filaSeleccionada==-1)    {
        }
        else    {
            DefaultTableModel tableModel=(DefaultTableModel)viewProveedores.jt_tablaProveedores.getModel();
            
            String id=(String)tableModel.getValueAt(filaSeleccionada, 0);
            String nombre=(String)tableModel.getValueAt(filaSeleccionada, 1);
            String ap_paterno=(String)tableModel.getValueAt(filaSeleccionada, 2);
            String ap_materno=(String)tableModel.getValueAt(filaSeleccionada, 3);
            String rfc=(String)tableModel.getValueAt(filaSeleccionada, 4);
            String calle=(String)tableModel.getValueAt(filaSeleccionada, 5);
            String no_calle=(String)tableModel.getValueAt(filaSeleccionada, 6);
            String colonia=(String)tableModel.getValueAt(filaSeleccionada, 7);
            String ciudad=(String)tableModel.getValueAt(filaSeleccionada, 8);
            String estado=(String)tableModel.getValueAt(filaSeleccionada, 9);
            String nombre_contacto=(String)tableModel.getValueAt(filaSeleccionada, 10);
            String telefono=(String)tableModel.getValueAt(filaSeleccionada, 11);
            String email=(String)tableModel.getValueAt(filaSeleccionada, 12);
            
            viewProveedores.jtf_id.setText(id);
            viewProveedores.jtf_nombreProveedor.setText(nombre);
            viewProveedores.jtf_apPaterno.setText(ap_paterno);
            viewProveedores.jtf_apMaterno.setText(ap_materno);
            viewProveedores.jtf_rfc.setText(rfc);
            viewProveedores.jtf_calle.setText(calle);
            viewProveedores.jtf_noCalle.setText(no_calle);
            viewProveedores.jtf_colonia.setText(colonia);
            viewProveedores.jtf_ciudad.setText(ciudad);
            viewProveedores.jtf_estado.setText(estado);
            viewProveedores.jtf_nombreContacto.setText(nombre_contacto);
            viewProveedores.jtf_telefono.setText(telefono);
            viewProveedores.jtf_email.setText(email);
            
        }  
    }
    catch(Exception editar)   {
        JOptionPane.showMessageDialog(viewProveedores, "ERROR, " + editar);
    }
    limpiar();
    guardar();
    mostrardatos("");
}

void limpiar()  {
    viewProveedores.jtf_id.setText("");
    viewProveedores.jtf_nombreProveedor.setText("");
    viewProveedores.jtf_apPaterno.setText("");
    viewProveedores.jtf_apMaterno.setText("");
    viewProveedores.jtf_rfc.setText("");
    viewProveedores.jtf_calle.setText("");
    viewProveedores.jtf_noCalle.setText("");
    viewProveedores.jtf_colonia.setText("");
    viewProveedores.jtf_ciudad.setText("");
    viewProveedores.jtf_estado.setText("");
    viewProveedores.jtf_nombreContacto.setText("");
    viewProveedores.jtf_telefono.setText("");
    viewProveedores.jtf_email.setText("");
}

void actualizar()   {
    try {
        PreparedStatement preparedStatement=cn.prepareStatement("UPDATE clientes SET nombre='" +viewProveedores.jtf_nombreProveedor.getText()+"', ap_paterno='"+viewProveedores.jtf_apPaterno.getText()+"', ap_materno='"+viewProveedores.jtf_apMaterno.getText()+"', rfc='"+viewProveedores.jtf_rfc.getText()+"', calle='"+viewProveedores.jtf_calle.getText()+"', no_calle='"+viewProveedores.jtf_noCalle.getText()+"', colonia='"+viewProveedores.jtf_colonia.getText()+"', ciudad='"+viewProveedores.jtf_ciudad.getText()+"', estado='"+viewProveedores.jtf_estado.getText()+"', nombre_contacto='"+viewProveedores.jtf_nombreContacto.getText()+"', telefono='"+viewProveedores.jtf_telefono.getText()+"', email='"+viewProveedores.jtf_email.getText()+"'WHERE id_proveedor="+viewProveedores.jtf_id.getText()+"'");
        preparedStatement.executeUpdate();
    }
    catch(Exception actualizar)   {
        
    }
}

void guardar()  {
    try {
        PreparedStatement preparedStatement=cn.prepareStatement("INSERT INTO proveedores (nombre, ap_paterno, ap_materno, rfc, calle, no_calle, colonia, ciudad, estado, nombre_contacto, telefono, e_mail) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        
        preparedStatement.setString(1, viewProveedores.jtf_nombreProveedor.getText());
        preparedStatement.setString(2, viewProveedores.jtf_apPaterno.getText());
        preparedStatement.setString(3, viewProveedores.jtf_apMaterno.getText());
        preparedStatement.setString(4, viewProveedores.jtf_rfc.getText());
        preparedStatement.setString(5, viewProveedores.jtf_calle.getText());
        preparedStatement.setString(6, viewProveedores.jtf_noCalle.getText());
        preparedStatement.setString(7, viewProveedores.jtf_colonia.getText());
        preparedStatement.setString(8, viewProveedores.jtf_ciudad.getText());
        preparedStatement.setString(9, viewProveedores.jtf_estado.getText());
        preparedStatement.setString(10, viewProveedores.jtf_nombreContacto.getText());
        preparedStatement.setString(11, viewProveedores.jtf_telefono.getText());
        preparedStatement.setString(12, viewProveedores.jtf_email.getText());
        
        int n=preparedStatement.executeUpdate();
        if(n>0) {
            JOptionPane.showMessageDialog(viewProveedores, "DATOS ALMACENADOS");
        } 
    }
    catch(Exception guardar)    {
        JOptionPane.showMessageDialog(null, "Error" + guardar.getMessage());
            System.out.print(guardar.getMessage());
    }
}

void modificar()    {
    try {
     String sql="UPDATE proveedores nombre=?, ap_paterno=?, ap_materno=?, rfc=?, calle=?, no_calle=?, colonia=?, ciudad=?, estado=?, nombre_contacto=?, telefono=?, e_mail=?"+ "WHERE id_proveedor=?";   
     
     
     
    }
}
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}














