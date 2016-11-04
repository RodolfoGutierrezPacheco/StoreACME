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
    Conection conection=new Conection();
    Connection cn = conection.conexion();
    
public ControllerProveedores (ModelProveedores modelProveedores, ViewProveedores viewProveedores)   {
    this.modelProveedores = modelProveedores;
    this.viewProveedores = viewProveedores;    
    
    this.viewProveedores.jtf_id.setVisible(false);
    //mostrarDatos("");
    
    this.viewProveedores.jb_agregar.addActionListener(this);
    this.viewProveedores.jb_buscar.addActionListener(this);
    this.viewProveedores.jb_editar.addActionListener(this);
    this.viewProveedores.jb_eliminar.addActionListener(this);
}
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}














