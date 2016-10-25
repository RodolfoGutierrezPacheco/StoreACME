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
public class ControllerProductos implements ActionListener{
    public ViewProductos viewProductos;
    public ModelProductos modelProductos;
    
   public ControllerProductos (ViewProductos viewClientes, ModelProductos modelClientes) {
        
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
                this.viewProductos.jtf_precio_compra.getText();
                this.viewProductos.jtf_precio_venta.getText();
                this.viewProductos.jtf_productos_existentes.getText();
                this.viewProductos.jtf_descripcion.getText();
                
                
                
                String sql = "insert into productos values (producto, marca, descripcion, precio_compra, precio_venta, productos_existentes ('" + viewProductos.jtf_producto.getText() + "','" + viewProductos.jtf_marca.getText() + "','" + viewProductos.jtf_precio_compra.getText() + "','" + viewProductos.jtf_precio_venta.getText() + "','" + viewProductos.jtf_productos_existentes.getText() + "','" + viewProductos.jtf_descripcion.getText()  + "','" + "');";              
                System.out.println(sql);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Por favor llena todos los campos adecuadamente" + err.getLocalizedMessage());
            }
       
        }
        else if (e.getSource() == this.viewProductos.jbtn_borrar){
            
            
            
    }
    
    else if (e.getSource() == this.viewProductos.jbtn_buscar){
                this.viewProductos.jtf_producto.getText();
                this.viewProductos.jtf_marca.getText();
                this.viewProductos.jtf_precio_compra.getText();
                this.viewProductos.jtf_precio_venta.getText();
                this.viewProductos.jtf_productos_existentes.getText();
                this.viewProductos.jtf_descripcion.getText();
            
            
    }
    else if (e.getSource() == this.viewProductos.jbtn_buscar){
                this.viewProductos.jtf_producto.getText();
                this.viewProductos.jtf_marca.getText();
                this.viewProductos.jtf_precio_compra.getText();
                this.viewProductos.jtf_precio_venta.getText();
                this.viewProductos.jtf_productos_existentes.getText();
                this.viewProductos.jtf_descripcion.getText();
            
            
    }        
        
    else if (e.getSource() == this.viewProductos.jbtn_editar){
                this.viewProductos.jtf_producto.getText();
                this.viewProductos.jtf_marca.getText();
                this.viewProductos.jtf_precio_compra.getText();
                this.viewProductos.jtf_precio_venta.getText();
                this.viewProductos.jtf_productos_existentes.getText();
                this.viewProductos.jtf_descripcion.getText();    
        
            }
        
         public void eliminarRegistros(){
        try{ 
           st.executeUpdate("delete from tabla1 where id_tabla1="+this.jtf_id_tabla1.getText());

           this.primerRegistro();

       } catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        } 

    }
     private void guadarRegistro() {        
       try{ 
             this.viewProductos.jtf_producto.getText();
                this.viewProductos.jtf_marca.getText();
                this.viewProductos.jtf_precio_compra.getText();
                this.viewProductos.jtf_precio_venta.getText();
                this.viewProductos.jtf_productos_existentes.getText();
                this.viewProductos.jtf_descripcion.getText();

            st.executeUpdate("Insert into productos (producto,marca,descripcion,precio_compra,precio_venta,productos_existentes,)"+" values ('"+ viewProductos.jtf_producto.getText() + "','" + viewProductos.jtf_marca.getText()+"','"+viewProductos.jtf_descripcion.getText() + "','" + viewProductos.jtf_precio_venta.getText()+"','"+viewProductos.jtf_precio_compra+"','"+viewProductos.jtf_productos_existentes);"); 

            this.primerRegistro();

        } catch(SQLException err)         { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        } 

    }     
         
    }
}




