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
    
    public static void main ( String [] amh) {
        
        ModelClientes modelClientes = new ModelClientes();
        ViewClientes viewClientes = new ViewClientes();
        ControllerClientes controllerClientes = new ControllerClientes(viewClientes,modelClientes);
        
        ModelProveedores modelProveedores = new ModelProveedores();
        ViewProveedores viewProveedores = new ViewProveedores();
        
        JPanel views [] = new JPanel [2];
        
        views [0] = viewClientes;
        views [1] = viewProveedores;
        
        ViewMain viewMain = new ViewMain();
        ControllerMain controllerMain = new ControllerMain(viewMain, views);
    }  
}