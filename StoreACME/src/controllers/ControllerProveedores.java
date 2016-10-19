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

/**
 *
 * @author r3n0
 */
public class ControllerProveedores implements ActionListener {
    ViewProveedores viewProveedores;
    ModelProveedores modelProveedores;
    
public ControllerProveedores (ModelProveedores modelProveedores, ViewProveedores viewProveedores)   {
    this.modelProveedores = modelProveedores;
    this.viewProveedores = viewProveedores;    
    
    this.viewProveedores.jb_agregar.addActionListener(this);
    this.viewProveedores.jb_buscar.addActionListener(this);
    this.viewProveedores.jb_editar.addActionListener(this);
    this.viewProveedores.jb_eliminar.addActionListener(this);
}
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
