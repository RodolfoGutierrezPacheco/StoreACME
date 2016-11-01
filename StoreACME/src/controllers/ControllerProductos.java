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
    private Object Conn;
    private Object sent;
    
   public ControllerProductos (ViewProductos viewClientes, ModelProductos modelProductos) {
        
        this.viewProductos = viewProductos;
        this.modelProductos = modelProductos;
        
        this.viewProductos.jbtn_agregar.addActionListener(this);
        this.viewProductos.jbtn_agregar.addActionListener(this);
        this.viewProductos.jbtn_editar.addActionListener(this);
        this.viewProductos.jbtn_buscar.addActionListener(this);
   }
   
   
    
   
   
   private void limpiar(){
               this.viewProductos.jtf_producto.setText("");
               this.viewProductos.jtf_descripcion.setText(""); 
               this.viewProductos.jtf_precio_compra.setText(""); 
               this.viewProductos.jtf_precio_venta.setText(""); 
               this.viewProductos.jtf_productos_existentes.setText("");     
         }
     public void Habilitar(){
               this.viewProductos.jtf_producto.setEditable(true);
               this.viewProductos.jtf_descripcion.setEditable(true); 
               this.viewProductos.jtf_precio_compra.setEditable(true);
               this.viewProductos.jtf_precio_venta.setEditable(true); 
               this.viewProductos.jtf_productos_existentes.setEditable(true);
         
         
   
 }     
    public void Deshabilitar(){
               this.viewProductos.jtf_producto.setEditable(false);
               this.viewProductos.jtf_descripcion.setEditable(false); 
               this.viewProductos.jtf_precio_compra.setEditable(false);
               this.viewProductos.jtf_precio_venta.setEditable(false); 
               this.viewProductos.jtf_productos_existentes.setEditable(false); 
}      
    public void Llenar(){
    try{
        conection=Mysql.getConnection();
        String [] titles ={"Id","Nombre","Direccion", "Telefono", "Correo"};
        String sql="select * from productos";
        tabla=new DefaultTableModel(null, titles);
        sent=conection.createStatement();
        ResultSet rs=sent.executeQuery(sql);

        String filas []= new String [6];

        while(rs.next()){
            filas [0]=rs.getString("id");
            filas [1]=rs.getString("producto");
            filas [2]=rs.getString("descripcion");
            filas [3]=rs.getString("precio_compra");
            filas [4]=rs.getString("precio_venta");
            filas [5]=rs.getString("productos_existentes");
            tabla.addRow(filas);

        }
this.viewProductos.jT_tabla.setModel(tabla);
       
    }catch(Exception e){
e.printStackTrace();
    }
}
    
public void table(){
    String [] tabla = new String [6];
}
          
        @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == this.viewProductos.jbtn_agregar){
            try {
                
                jbtn_agregarActionPerformed();
                String sql = "insert into productos values (producto, marca, descripcion, precio_compra, precio_venta, productos_existentes ('" + viewProductos.jtf_producto.getText() + "','" + viewProductos.jtf_marca.getText() + "','" + viewProductos.jtf_precio_compra.getText() + "','" + viewProductos.jtf_precio_venta.getText() + "','" + viewProductos.jtf_productos_existentes.getText() + "','" + viewProductos.jtf_descripcion.getText()  + "','" + "');";              
                System.out.println(sql);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Por favor llena todos los campos adecuadamente" + err.getLocalizedMessage());
            }
       
        }
        else if (e.getSource() == this.viewProductos.jbtn_agregar){
              
            
            jbtn_guardarActionPerformed();
    }
    
    else if (e.getSource() == this.viewProductos.jbtn_buscar){
                
            
            jbtn_buscarActionPerformed();
    }
    else if (e.getSource() == this.viewProductos.jbtn_guardar){
                
            
            jbtn_guardarActionPerformed();
    }        
        
    else if (e.getSource() == this.viewProductos.jbtn_editar){
                    
                    jbtn_editarActionPerformed();
            }
        
        
    }
          private void jbtn_editarActionPerformed(){
                this.viewProductos.jtf_producto.setText("");
                this.viewProductos.jtf_precio_compra.setText("");
                this.viewProductos.jtf_precio_venta.setText("");
                this.viewProductos.jtf_productos_existentes.setText("");
                this.viewProductos.jtf_descripcion.setText("");    
                 
                this.viewProductos.jtf_producto.getText();
                this.viewProductos.jtf_precio_compra.getText();
                this.viewProductos.jtf_precio_venta.getText();
                this.viewProductos.jtf_productos_existentes.getText();
                this.viewProductos.jtf_descripcion.getText();
        }

          private void jbtn_borrarActionPerformed(){
         try{
             int fila=this.viewProductos.jT_tabla.getSelectedRow();
             String sql="delete from productos where id="+this.viewProductos.jT_tabla.getValueAt(fila,0);
             sent=Conn.createStatement();
             int n=sent.executeUpdate(sql);
             if(n>0){
             Llenar();
             JOptionPane.showMessageDialog(null, "datos eliminados");
             limpiar();
    }
}catch(Exception e){
    JOptionPane.showMessageDialog(null, "error"+e.getMessage());
}
        }
          
        private void jbtn_guardarActionPerformed(){                                          
        try{
        String sql="insert into productos ( idproductos,descripcion,precio_compra,precio_venta,productos_existentes)" +
        "Values (?,?,?,?) ";
             Statement connection=conection.prepareCall(sql);
             connection.setString(1, this.viewProductos.jtf_producto.getText());
             connection.setString(2, this.viewProductos.jtf_descripcion.getText());
             connection.setString(3, this.viewProductos.jtf_precio_compra.getText());
             connection.setString(4, this.viewProductos.jtf_precio_venta.getText());
             connection.setString(4, this.viewProductos.jtf_productos_existentes.getText());
                                                                                           {
            
                JOptionPane.showMessageDialog(null, " Favor de ingresar los datos");
            }

          int n=conection.executeUpdate();
         if(n>0)
          JOptionPane.showMessageDialog(null, "datos guardados");
          }catch(Exception e){
           JOptionPane.showMessageDialog(null, "error"+ e.getMessage());
           }
        
          Llenar();
          limpiar();
          Deshabilitar();
    }                                          

     
        
        private void jbtn_buscarActionPerformed(){
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("ID");
        tabla.addColumn("Producto");
        tabla.addColumn("Descripcion");
        tabla.addColumn("Precio compra");
        tabla.addColumn("Precio venta");
        tabla.addColumn("Productos existentes");
         
        String [] tabla = new String [6];
        
        Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM clientes");
                while (rs.next()){
                    tabla [0] = rs.getString(1);
                    tabla [1] = rs.getString(2);
                    tabla [2] = rs.getString(3);
                    tabla [3] = rs.getString(4);
                    tabla [4] = rs.getString(5);
                    tabla [5] = rs.getString(6);
                    
        }
     }
        private void jbtn_agregarActionPerformed(){
        limpiar();
        Habilitar();
        }
 
    private Statement cp;
    private ResultSet rs;
    Conection conection = new Conection ();
    Connection pt = conection.conexion();
   public void Conectar() {

        try {
            pt = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda_acme?user=root");
            cp = pt.createStatement();
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }   
    }
             
}