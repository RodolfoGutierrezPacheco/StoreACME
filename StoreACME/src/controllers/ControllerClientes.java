package controllers;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import lib.Conection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.ViewClientes;
import models.ModelClientes;

public class ControllerClientes implements ActionListener {
    
    public ViewClientes viewClientes;
    public ModelClientes modelClientes;
    private Statement st;
    private ResultSet rs;
    
    Conection conection = new Conection();
    Connection cn = conection.conexion();
    
    public ControllerClientes(ViewClientes viewClientes, ModelClientes modelClientes) {
        
        this.viewClientes = viewClientes;
        this.modelClientes = modelClientes;
        
        this.viewClientes.jbtn_next.addActionListener(this);
        this.viewClientes.jbtn_agregar.addActionListener(this);
        this.viewClientes.jbtn_borrar.addActionListener(this);
        this.viewClientes.jbtn_editar.addActionListener(this);
        this.viewClientes.jbtn_buscar.addActionListener(this);
    }
    
    public void Conectar() {

        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda_acme?user=root");
            st = cn.createStatement();
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }   
    }
    
    void Guardar(){
        
        try {
            PreparedStatement ps = cn.prepareStatement("INSERT INTO clientes (nombre,ap_paterno,ap_materno,telefono,email,rfc,calle,numero,colonia,ciudad,estado) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1,  viewClientes.jtf_nombre.getText());
                ps.setString(2,  viewClientes.jtf_apPaterno.getText());
                ps.setString(3,  viewClientes.jtf_apMaterno.getText());
                ps.setString(4,  viewClientes.jtf_telefono.getText());
                ps.setString(5,  viewClientes.jtf_email.getText());
                ps.setString(6,  viewClientes.jtf_rfc.getText());
                ps.setString(7,  viewClientes.jtf_calle.getText());
                ps.setString(8,  viewClientes.jtf_numero.getText());
                ps.setString(9,  viewClientes.jtf_colonia.getText());
                ps.setString(10, viewClientes.jtf_ciudad.getText());
                ps.setString(11, viewClientes.jtf_estado.getText());
                ps.executeUpdate();               
        }catch (Exception e){
           
            System.out.print(e.getMessage());
        }
        
        viewClientes.jtf_nombre.setText("");
        viewClientes.jtf_apPaterno.setText("");
        viewClientes.jtf_apMaterno.setText("");
        viewClientes.jtf_telefono.setText("");
        viewClientes.jtf_email.setText("");
        viewClientes.jtf_rfc.setText("");
        viewClientes.jtf_calle.setText("");
        viewClientes.jtf_numero.setText("");
        viewClientes.jtf_colonia.setText("");
        viewClientes.jtf_ciudad.setText("");
        viewClientes.jtf_estado.setText("");       
    }
    
    void mostrardatos (String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Ap Paterno");
        modelo.addColumn("Ap Materno");
        modelo.addColumn("Telefono");
        modelo.addColumn("Email");
        modelo.addColumn("RFC");
        modelo.addColumn("Calle");
        modelo.addColumn("No");
        modelo.addColumn("Colonia");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Estado");
        
        viewClientes.jt_clientes.setModel(modelo);
        String sql = "";
        
        if (valor.equals(""))
        {
            sql= "Select  * From clientes";
        }
        else {
            sql="Select * From  clientes Where id_cliente='"+valor+"'";
        }
        
        String [] datos = new String [12];
        
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM clientes");
                while (rs.next()){
                    datos [0] = rs.getString(1);
                    datos [1] = rs.getString(2);
                    datos [2] = rs.getString(3);
                    datos [3] = rs.getString(4);
                    datos [4] = rs.getString(5);
                    datos [5] = rs.getString(6);
                    datos [6] = rs.getString(7);
                    datos [7] = rs.getString(8);
                    datos [8] = rs.getString(9);
                    datos [9] = rs.getString(10);
                    datos [10] = rs.getString(11);
                    datos [11] = rs.getString(12);
                    
                    modelo.addRow(datos);
                }
                viewClientes.jt_clientes.setModel(modelo);
            }catch (SQLException ex) {
                Logger.getLogger(ControllerClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if (e.getSource() == viewClientes.jbtn_agregar){
            
            if(viewClientes.jtf_nombre.getText().equals("") || viewClientes.jtf_apPaterno.getText().equals("")||
               viewClientes.jtf_apMaterno.getText().equals("") || viewClientes.jtf_telefono.getText().equals("") ||
               viewClientes.jtf_email.getText().equals("") || viewClientes.jtf_rfc.getText().equals("") ||
               viewClientes.jtf_calle.getText().equals("") || viewClientes.jtf_numero.getText().equals("") ||
               viewClientes.jtf_colonia.getText().equals("") || viewClientes.jtf_ciudad.getText().equals("") ||
               viewClientes.jtf_estado.getText().equals("")) {
            
                JOptionPane.showMessageDialog(null, " No has llenado todos tus campos");
            }else{
                Guardar();
                mostrardatos("");
            }
        }
    }
}