package controllers;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import lib.Conection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.ViewClientes;
import models.ModelClientes;

public class ControllerClientes implements ActionListener {
    
    public ViewClientes viewClientes;
    public ModelClientes modelClientes;
    
    public ControllerClientes(ViewClientes viewClientes, ModelClientes modelClientes) {
        
        this.viewClientes = viewClientes;
        this.modelClientes = modelClientes;
        
        this.viewClientes.jbtn_agregar.addActionListener(this);
        this.viewClientes.jbtn_borrar.addActionListener(this);
        this.viewClientes.jbtn_editar.addActionListener(this);
        this.viewClientes.jbtn_buscar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == this.viewClientes.jbtn_agregar){
            
            try {
                this.viewClientes.jtf_nombre.getText();
                this.viewClientes.jtf_apPaterno.getText();
                this.viewClientes.jtf_apMaterno.getText();
                this.viewClientes.jtf_telefono.getText();
                this.viewClientes.jtf_email.getText();
                this.viewClientes.jtf_rfc.getText();
                this.viewClientes.jtf_calle.getText();
                this.viewClientes.jtf_numero.getText();
                this.viewClientes.jtf_colonia.getText();
                this.viewClientes.jtf_ciudad.getText();
                this.viewClientes.jtf_estado.getText();
                
                String sql = "insert into clientes values (nombre, ap_paterno, ap_materno, telefono, email, rfc, calle, numero, colonia, ciudad, estado ('" + viewClientes.jtf_nombre.getText() + "','" + viewClientes.jtf_apPaterno.getText() + "','" + viewClientes.jtf_apMaterno.getText() + "','" + viewClientes.jtf_telefono.getText() + "','" + viewClientes.jtf_email.getText() + "','" + viewClientes.jtf_rfc.getText() + "','" + viewClientes.jtf_calle.getText() + "','" + viewClientes.jtf_numero.getText() + "','" + viewClientes.jtf_colonia.getText() + "','" + viewClientes.jtf_ciudad.getText() + "','" + viewClientes.jtf_estado.getText()+ "');";              
                System.out.println(sql);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Por favor llena todos los campos" + err.getLocalizedMessage());
            }
        }   
            
        if (e.getSource () == this.viewClientes.jbtn_borrar) {
            
        }
            
        if (e.getSource () == this.viewClientes.jbtn_editar)
            try {
                this.viewClientes.jtf_nombre.getText();
                this.viewClientes.jtf_apPaterno.getText();
                this.viewClientes.jtf_apMaterno.getText();
                this.viewClientes.jtf_telefono.getText();
                this.viewClientes.jtf_email.getText();
                this.viewClientes.jtf_rfc.getText();
                this.viewClientes.jtf_calle.getText();
                this.viewClientes.jtf_numero.getText();
                this.viewClientes.jtf_colonia.getText();
                this.viewClientes.jtf_ciudad.getText();
                this.viewClientes.jtf_estado.getText();
                
                String sql = "insert into clientes (nombre, ap_paterno, ap_materno, telefono, email, rfc, calle, numero, colonia, ciudad, estado values ('" + viewClientes.jtf_nombre.getText() + "','" + viewClientes.jtf_apPaterno.getText() + "','" + viewClientes.jtf_apMaterno.getText() + "','" + viewClientes.jtf_telefono.getText() + "','" + viewClientes.jtf_email.getText() + "','" + viewClientes.jtf_rfc.getText() + "','" + viewClientes.jtf_calle.getText() + "','" + viewClientes.jtf_numero.getText() + "','" + viewClientes.jtf_colonia.getText() + "','" + viewClientes.jtf_ciudad.getText() + "','" + viewClientes.jtf_estado.getText()+ "');";                
                System.out.println(sql);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Por favor llena todos los campos" + err.getLocalizedMessage());
            }
        
        if (e.getSource () == this.viewClientes.jbtn_buscar) {
            
        }
        
        if (e.getSource () == this.viewClientes.jbtn_guardar) {
            
        }
        
        if (e.getSource () == this.viewClientes.jbtn_first) {
            
        }
        
        if (e.getSource () == this.viewClientes.jbtn_previous) {
            
        }
        
        if(e.getSource () == this.viewClientes.jbtn_next) {

        }
        
        if (e.getSource () == this.viewClientes.jbtn_latest) {
            
        }                 
    }
}