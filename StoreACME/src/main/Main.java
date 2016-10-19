package main;

import models.*;
import views.*;
import controllers.*;
import javax.swing.JPanel;

public class Main {
    
    ModelClientes modelClientes;
    ViewClientes viewClientes;
    ControllerClientes controllerClientes;
    
    ModelProveedores modelProveedores;
    ViewProveedores viewProveedores;
    ControllerProveedores controllerProveedores;
    
    ModelProductos modelProductos;
    ViewProductos viewProductos;
    ControllerProductos controllerProductos;
    
    
    public static void main ( String [] car) {
        
        ModelClientes modelClientes = new ModelClientes();
        ViewClientes viewClientes = new ViewClientes();
        ControllerClientes controllerClientes = new ControllerClientes(viewClientes,modelClientes);
        
        ModelProductos modelProductos = new ModelProductos();
        ViewProductos viewProductos = new ViewProductos();
        ControllerProductos controllerProductos = new ControllerProductos( viewProductos , modelProductos);
        
        ModelProveedores modelProveedores = new ModelProveedores();
        ViewProveedores viewProveedores = new ViewProveedores();
        
        JPanel views [] = new JPanel [3];
        
        views [0] = viewClientes;
        views [1] = viewProveedores;
        views [2] = viewProductos;
        
        ViewMain viewMain = new ViewMain();
        ControllerMain controllerMain = new ControllerMain(viewMain, views);
    }  
}