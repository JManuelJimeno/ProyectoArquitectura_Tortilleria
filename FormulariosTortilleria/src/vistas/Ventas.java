package vistas;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Manuel Jimeno
 */
public class Ventas extends javax.swing.JFrame {

    Connection conexion = null;
    String url = "jdbc:mysql://127.0.0.1:3306/proyectotortillas";
    String usuario = "root";
    String password = "";
    
    public Ventas() {
        initComponents();
        TextPrompt fecha = new TextPrompt("Fecha", txtFecha);                    
        TextPrompt cantidad = new TextPrompt("Cantidad", txtCantidadV);
        llenarCombo();
        llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboProveedor = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        txtFecha = new javax.swing.JTextField();
        comboFPago = new javax.swing.JComboBox<>();
        btnAgregarInv = new javax.swing.JButton();
        btnEliminarInv = new javax.swing.JButton();
        btnModificarInv = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        txtCantidadV = new javax.swing.JTextField();
        comboProductoV = new javax.swing.JComboBox<>();
        comboUsuarios = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaVentas);

        txtFecha.setToolTipText("Producto");

        comboFPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta" }));

        btnAgregarInv.setText("Agregar");
        btnAgregarInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarInvActionPerformed(evt);
            }
        });

        btnEliminarInv.setText("Eliminar");
        btnEliminarInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarInvActionPerformed(evt);
            }
        });

        btnModificarInv.setText("Modificar");
        btnModificarInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarInvActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        comboProductoV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProductoVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboProductoV, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCantidadV, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboFPago, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnAgregarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(286, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboProductoV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarInv)
                    .addComponent(btnModificarInv)
                    .addComponent(btnAgregarInv)
                    .addComponent(btnRegresar))
                .addGap(47, 47, 47))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(142, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void limpiar(){
        txtFecha.setText("");        
        txtCantidadV.setText("");
    }
    
    private void btnAgregarInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarInvActionPerformed
        
        try{
            String idProducto = (String) comboProductoV.getSelectedItem();
            System.out.println(idProducto);
            String[] idProd = idProducto.split("-");
            System.out.println(idProd[0]);
        
            String precio = consultar("producto", "precio", "idProducto='" + idProd[0] + "'");
            String pre = precio.replace(",", "");
            float monto = (Float.parseFloat(txtCantidadV.getText())) * (Float.parseFloat(pre));
        
            String ventasSentencia = "null,'"+txtFecha.getText()+"',"+monto+",'"+comboFPago.getSelectedItem()+"'";
            String insertar = insertar("ventas", ventasSentencia);
            System.out.println(insertar);
        
            String idVenta = consultar("ventas", "idVentas", "monto='" + monto + "'");   
            String idV = idVenta.replace(",", "");
                        
            String auxVentas = "null, "+idV+","+idProd[0]+","+txtCantidadV.getText();
            String insertar2 = insertar("auxpv", auxVentas);
            System.out.println(insertar2);
        
            String idUser = (String) comboUsuarios.getSelectedItem();
            System.out.println(idUser);
            String[] idU = idUser.split("-");
            System.out.println(idU[0]);
            String auxUV = "null, "+idU[0]+","+idV;
            String insertar3 = insertar("auxuv", auxUV);
            System.out.println(insertar3);
        
            llenarTabla();
            limpiar();
            JOptionPane.showMessageDialog(null, "Insertado existosamente!");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error en la insercion!");
        }
                
        
    }//GEN-LAST:event_btnAgregarInvActionPerformed

    private void btnEliminarInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarInvActionPerformed
        // TODO add your handling code here:
        int fila = tablaVentas.getSelectedRow();
        String valor = tablaVentas.getValueAt(fila, 0).toString();
        System.out.println(valor);
        String condicion = "idVentas="+valor;
        try{
            eliminar("ventas", condicion);
            llenarTabla();
            System.out.println("Metodo");
            JOptionPane.showMessageDialog(null, "Registro eliminado!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro!");
        }
    }//GEN-LAST:event_btnEliminarInvActionPerformed

    private void btnModificarInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarInvActionPerformed
        // TODO add your handling code here:}
        int fila = tablaVentas.getSelectedRow();
        int valor = Integer.parseInt(this.tablaVentas.getValueAt(fila, 0).toString());        
        String fecha = tablaVentas.getValueAt(fila, 1).toString();
        float monto = Float.parseFloat(tablaVentas.getValueAt(fila, 2).toString());
        String formaPago = tablaVentas.getValueAt(fila, 3).toString();
        String condicion = "idVentas="+valor;
        String campos = "fecha='"+fecha+"',monto="+monto+",formaPago='"+formaPago+"'";
        try{            
            modificar("ventas", campos, condicion);
            llenarTabla();
            JOptionPane.showMessageDialog(null, "Registro modificado!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error de modificacion!");
        }
    }//GEN-LAST:event_btnModificarInvActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        Principal prin = new Principal();
        prin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void comboProductoVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProductoVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProductoVActionPerformed

    public void llenarCombo(){
        String[] datos = new String[2];
        String[] datos2 = new String[2];
        String texto;
        String texto2;
        try {
        conexion = DriverManager.getConnection(url, usuario, password);

        // 2. Crear statement y ejecutar consulta
        Statement stmt = conexion.createStatement();
        Statement stmt2 = conexion.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT idProducto, nombre FROM producto");
        ResultSet rs2 = stmt2.executeQuery("SELECT idUsuario, usuario FROM usuario");

        // 3. Iterar sobre los resultados
        while (rs.next()) {
            datos[0] = rs.getString(1);
            datos[1] = rs.getString(2);
            texto = datos[0]+"-"+datos[1];
            comboProductoV.addItem(texto);
        }
        
        while(rs2.next()){
            datos2[0] = rs2.getString(1);
            datos2[1] = rs2.getString(2);
            texto2 = datos2[0]+"-"+datos2[1];
            comboUsuarios.addItem(texto2);
        }

        // 4. Cerrar recursos
        rs2.close();
        rs.close();
        stmt.close();
        stmt2.close();
        conexion.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }
  }
    

    
    public void llenarTabla(){
        try {
      conexion = DriverManager.getConnection(url, usuario, password);

      // 2. Crear statement y ejecutar consulta
      Statement stmt = conexion.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT v.*, p.nombre, a.cantidad FROM ventas v, producto p, auxpv a WHERE v.idVentas AND v.idVentas = a.idVentasy");

      // 3. Crear modelo de datos
      DefaultTableModel modelo = new DefaultTableModel();
      modelo.addColumn("ID");
      modelo.addColumn("Fecha");
      modelo.addColumn("Monto");
      modelo.addColumn("FormaPago");
      modelo.addColumn("Nombre Producto");
      modelo.addColumn("Cantidad");

      // 4. Agregar datos al modelo
      while (rs.next()) {
        Object[] fila = new Object[7];
        fila[0] = rs.getInt("idVentas");
        fila[1] = rs.getString("fecha");
        fila[2] = rs.getString("monto");
        fila[3] = rs.getString("formaPago");
        fila[4] = rs.getString("p.nombre");
        fila[5] = rs.getString("a.cantidad");
        modelo.addRow(fila);
      }

      // 5. Crear JTable y establecer modelo
      tablaVentas.setModel(modelo);

      

      // 7. Cerrar recursos
      rs.close();
      stmt.close();
      conexion.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarInv;
    public javax.swing.JButton btnEliminarInv;
    public javax.swing.JButton btnModificarInv;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboFPago;
    private javax.swing.JComboBox<String> comboProductoV;
    private javax.swing.JComboBox<String> comboProveedor;
    private javax.swing.JComboBox<String> comboUsuarios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JTextField txtCantidadV;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables

    private static String eliminar(java.lang.String nombreTabla, java.lang.String condicion) {
        pkg.webservice.WSTortilleria_Service service = new pkg.webservice.WSTortilleria_Service();
        pkg.webservice.WSTortilleria port = service.getWSTortilleriaPort();
        return port.eliminar(nombreTabla, condicion);
    }

    private static String consultar(java.lang.String nombreTabla, java.lang.String datos, java.lang.String condicion) {
        pkg.webservice.WSTortilleria_Service service = new pkg.webservice.WSTortilleria_Service();
        pkg.webservice.WSTortilleria port = service.getWSTortilleriaPort();
        return port.consultar(nombreTabla, datos, condicion);
    }

    private static String insertar(java.lang.String nombreTabla, java.lang.String campos) {
        pkg.webservice.WSTortilleria_Service service = new pkg.webservice.WSTortilleria_Service();
        pkg.webservice.WSTortilleria port = service.getWSTortilleriaPort();
        return port.insertar(nombreTabla, campos);
    }

    private static String modificar(java.lang.String nombreTabla, java.lang.String campos, java.lang.String condicion) {
        pkg.webservice.WSTortilleria_Service service = new pkg.webservice.WSTortilleria_Service();
        pkg.webservice.WSTortilleria port = service.getWSTortilleriaPort();
        return port.modificar(nombreTabla, campos, condicion);
    }
}
