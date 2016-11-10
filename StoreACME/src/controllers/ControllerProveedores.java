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
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    mostrarDatos("");
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
     int fila=viewProveedores.jt_tablaProveedores.getSelectedRow();
     String dao=(String)viewProveedores.jt_tablaProveedores.getValueAt(fila, 0);
        PreparedStatement preparedStatement=cn.prepareStatement(sql);
        
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
        
        preparedStatement.setString(1, dao);
        int n=preparedStatement.executeUpdate();
        
        if(n>0) {
            JOptionPane.showMessageDialog(viewProveedores, "Modificacion realizada con exito");
        }
     
    }
    catch(Exception modificar)  {
        JOptionPane.showMessageDialog(viewProveedores, "Algo salio mal "+modificar.getMessage());
    }
    guardar();
    limpiar();
}

void eliminar() {
    try {
        int fila=viewProveedores.jt_tablaProveedores.getSelectedRow();
        String sql="DELETE * FROM proveedores WHERE id_cliente"+viewProveedores.jt_tablaProveedores.getValueAt(fila, 0);
        st=cn.createStatement();
        int n=st.executeUpdate(sql);
        if(n>0) {
            guardar();
            JOptionPane.showMessageDialog(viewProveedores, "Registro borreado con exito");
        }
        
    }
    catch(Exception eliminar)   {
        JOptionPane.showMessageDialog(viewProveedores, "Algo salio mal al eliminar datos "+eliminar.getMessage());
    }
}

void mostrarDatos(String valor) {
    DefaultTableModel tableModel=new DefaultTableModel();
    tableModel.addColumn("id_proveedor");
    tableModel.addColumn("nombre");
    tableModel.addColumn("ap_paterno");
    tableModel.addColumn("ap_materno");
    tableModel.addColumn("rfc");
    tableModel.addColumn("calle");
    tableModel.addColumn("colonia");
    tableModel.addColumn("ciudad");
    tableModel.addColumn("estado");
    tableModel.addColumn("nombre_contacto");
    tableModel.addColumn("telefono");
    tableModel.addColumn("e_mail");
    
    viewProveedores.jt_tablaProveedores.setModel(tableModel);
    String sql="";
    if(valor.equals(""))    {
        sql="SELECT * FROM proveedores";
    }
    else    {
        sql="SELECT * FROM proveedores WHERE id_proveedor'"+valor+"'";
    }
    String[] datos=new String[12];
    
    try {
        Statement statement=cn.createStatement();
        ResultSet resultSet=st.executeQuery("SELECT * FROM proveedores");
        
        while(resultSet.next()) {
            datos[0]=resultSet.getString(1);
            datos[1]=resultSet.getString(2);
            datos[2]=resultSet.getString(3);
            datos[3]=resultSet.getString(4);
            datos[4]=resultSet.getString(5);
            datos[5]=resultSet.getString(6);
            datos[6]=resultSet.getString(7);
            datos[7]=resultSet.getString(8);
            datos[8]=resultSet.getString(9);
            datos[9]=resultSet.getString(10);
            datos[10]=resultSet.getString(11);
            datos[11]=resultSet.getString(12);
            datos[12]=resultSet.getString(13);
            
            tableModel.addRow(datos);   
        }
        viewProveedores.jt_tablaProveedores.setModel(tableModel);       
    }
    catch(SQLException mDatos)  {
        Logger.getLogger(ControllerClientes.class.getName()).log(Level.SEVERE,null, mDatos);
    }
    
}
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewProveedores.jb_agregar)   {
            if(viewProveedores.jtf_nombreProveedor.getText().equals("")||viewProveedores.jtf_apPaterno.getText().equals("")||viewProveedores.jtf_apPaterno.getText().equals("")||viewProveedores.jtf_rfc.getText().equals("")||viewProveedores.jtf_calle.getText().equals("")||viewProveedores.jtf_colonia.getText().equals("")||viewProveedores.jtf_estado.getText().equals("")||viewProveedores.jtf_nombreContacto.getText().equals("")||viewProveedores.jtf_telefono.getText().equals("")||viewProveedores.jtf_email.getText().equals(""))   {
                JOptionPane.showMessageDialog(viewProveedores, "Llena por completo los campos "+e);
            }
            else    {
                guardar();
                mostrarDatos("");
                limpiar();
            }
        }
        if(e.getSource()==viewProveedores.jb_eliminar)   {
            modificar();
        }

        if(e.getSource()==viewProveedores.jb_guardar)   {
            guardar();
            mostrarDatos("");
        }
        if(e.getSource()==viewProveedores.jb_editar)    {
            guardar();
            mostrarDatos("");
            limpiar();
        }
        if(e.getSource()==viewProveedores.jb_buscar)   {

                    
        }
    }
}














