/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package formulariostortilleria;

import vistas.Inicio;
import vistas.Inventario;
import vistas.Principal;
import vistas.Proveedor;
import vistas.Usuarios;
import vistas.Ventas;

/**
 *
 * @author ramirohb
 */
public class FormulariosTortilleria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Inicio principal = new Inicio();
        principal.setVisible(true);
        
        Inventario inv1 = new Inventario();
        Principal p1 = new Principal();
        Proveedor pro1 = new Proveedor();
        Usuarios usu = new Usuarios();
        Ventas ven = new Ventas();
    }
    
}
