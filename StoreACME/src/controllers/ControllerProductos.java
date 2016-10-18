/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import lib.Conection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.ViewProductos;
import models.ModelProductos;
/**
 *
 * @author BLABPC23
 */
public class ControllerProductos {
    public ViewProductos viewProductos;
    public ModelProductos modelProductos;
    
   public ControllerProductos(ViewProductos viewClientes, ModelProductos modelClientes) {
        
        this.viewProductos = viewClientes;
        this.modelProductos = modelClientes;
        
        this.viewProductos.jbtn_agregar.addActionListener(this);
        this.viewProductos.jbtn_borrar.addActionListener(this);
        this.viewProductos.jbtn_editar.addActionListener(this);
        this.viewProductos.jbtn_buscar.addActionListener(this);
   }
        @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == this.viewProductos.jbtn_agregar){
            try {
                this.viewProductos.jtf_producto.getText();
                this.viewProductos.jtf_marca.getText();
                this.viewProductos.jtf_.getText();
                this.viewProductos.jtf_.getText();
                this.viewProductos.jtf_email.getText();
                this.viewProductos.jtf_rfc.getText();
                this.viewProductos.jtf_calle.getText();
                
                String sql = "insert into clientes values (nombre, ap_paterno, ap_materno, telefono, email, rfc, calle, numero, colonia, ciudad, estado ('" + viewClientes.jtf_nombre.getText() + "','" + viewClientes.jtf_apPaterno.getText() + "','" + viewClientes.jtf_apMaterno.getText() + "','" + viewClientes.jtf_telefono.getText() + "','" + viewClientes.jtf_email.getText() + "','" + viewClientes.jtf_rfc.getText() + "','" + viewClientes.jtf_calle.getText() + "','" + viewClientes.jtf_numero.getText() + "','" + viewClientes.jtf_colonia.getText() + "','" + viewClientes.jtf_ciudad.getText() + "','" + viewClientes.jtf_estado.getText()+ "');";              
                System.out.println(sql);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Por favor llena todos los campos adecuadamente" + err.getLocalizedMessage());
            }
    
        }
    }

}
