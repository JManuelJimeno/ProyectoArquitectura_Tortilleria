package vistas;


import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */



public class Inventario extends javax.swing.JFrame {

    Connection conexion = null;
    String url = "jdbc:mysql://127.0.0.1:3306/proyectotortillas";
    String usuario = "root";
    String password = "";
    
    public Inventario() {
        initComponents(); 
        llenarCombo();
        llenarTabla();
        TextPrompt producto = new TextPrompt("Producto", txtProducto);
        TextPrompt precio = new TextPrompt("Precio", txtPrecio);
        TextPrompt descripcion = new TextPrompt("Descripcion", txtADescripcion);
        TextPrompt infNut = new TextPrompt("Informacion Nutrimental", txtAInfNut);        
        TextPrompt cantidad = new TextPrompt("Cantidad", txtCantidad);
    }

    public void llenarCombo(){
        String[] datos = new String[2];
        String texto;
        try {
        conexion = DriverManager.getConnection(url, usuario, password);

        // 2. Crear statement y ejecutar consulta
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT idProveedor, nombre FROM proveedor");

        // 3. Iterar sobre los resultados
        while (rs.next()) {
            datos[0] = rs.getString(1);
            datos[1] = rs.getString(2);
            texto = datos[0]+"-"+datos[1];
            comboProveedor.addItem(texto);
        }

        // 4. Cerrar recursos
        rs.close();
        stmt.close();
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
      ResultSet rs = stmt.executeQuery("SELECT i.idInventario, p.nombre, p.precio, i.cantidad, p.descripcion, p.informacion, e.nombre FROM inventario i, producto p, proveedor e WHERE p.idProducto = i.idProductox AND i.idProveedorx = e.idProveedor");

      // 3. Crear modelo de datos
      DefaultTableModel modelo = new DefaultTableModel();
      modelo.addColumn("ID");
      modelo.addColumn("Nombre Producto");
      modelo.addColumn("Precio");
      modelo.addColumn("Cantidad");
      modelo.addColumn("Descripcion");
      modelo.addColumn("Infromacion Nutrimental");
      modelo.addColumn("Nombre de Proveedor");

      // 4. Agregar datos al modelo
      while (rs.next()) {
        Object[] fila = new Object[7];
        fila[0] = rs.getInt("i.idInventario");
        fila[1] = rs.getString("p.nombre");
        fila[2] = rs.getFloat("p.precio");
        fila[3] = rs.getInt("i.cantidad");
        fila[4] = rs.getString("p.descripcion");
        fila[5] = rs.getString("p.informacion");
        fila[6] = rs.getString("e.nombre");
        modelo.addRow(fila);
      }

      // 5. Crear JTable y establecer modelo
      tablaInventario.setModel(modelo);

      

      // 7. Cerrar recursos
      rs.close();
      stmt.close();
      conexion.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    }
    
    public void limpiar(){
        txtProducto.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        txtADescripcion.setText("");
        txtAInfNut.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInventario = new javax.swing.JTable();
        txtProducto = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtADescripcion = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtAInfNut = new javax.swing.JTextArea();
        comboProveedor = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        btnAgregarInv = new javax.swing.JButton();
        btnEliminarInv = new javax.swing.JButton();
        btnModificarInv = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        jTextField1.setText("Producto");

        jTextField2.setText("Precio");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Descripcion...");
        jScrollPane2.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("Informacion Nutirmental...");
        jScrollPane3.setViewportView(jTextArea2);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField5.setText("Cantidad");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaInventario);

        txtProducto.setToolTipText("Producto");

        txtADescripcion.setColumns(20);
        txtADescripcion.setRows(5);
        jScrollPane4.setViewportView(txtADescripcion);

        txtAInfNut.setColumns(20);
        txtAInfNut.setRows(5);
        jScrollPane5.setViewportView(txtAInfNut);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnModificarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(comboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarInv)
                    .addComponent(btnModificarInv)
                    .addComponent(btnAgregarInv)
                    .addComponent(btnRegresar))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        txtProducto.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnAgregarInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarInvActionPerformed
        try{
            String idProveedor = (String) comboProveedor.getSelectedItem();
            System.out.println(idProveedor);
            String[] idProv = idProveedor.split("-");
            System.out.println(idProv[0]);        
            String productoSentencia = "null,'"+txtProducto.getText()+"',"+Float.parseFloat(txtPrecio.getText())+",'"+txtADescripcion.getText()+"','"+txtAInfNut.getText()+"'";
            String insertar2 = insertar("producto", productoSentencia);        
            String idProducto = consultar("producto", "idProducto", "nombre='" + txtProducto.getText() + "'");
            String idProd = idProducto.replace(",", "");
            System.out.println(idProd);
            String inventarioSentencia = "null,"+ Integer.parseInt(idProd) +","+Integer.parseInt(txtCantidad.getText())+"," + idProv[0];
            String insertar = insertar("inventario", inventarioSentencia);                        
            System.out.println(insertar);
            System.out.println(insertar2);
            llenarTabla();
            limpiar();
            JOptionPane.showMessageDialog(null, "Insertado existosamente!");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error en la insercion!");
        } 
        
        
    }//GEN-LAST:event_btnAgregarInvActionPerformed

    private void btnEliminarInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarInvActionPerformed
        // TODO add your handling code here:
        int fila = tablaInventario.getSelectedRow();
       String valor = tablaInventario.getValueAt(fila, 0).toString();
       System.out.println(valor);
       String condicion = "idInventario="+valor;
       try{
           eliminar("inventario", condicion);
           llenarTabla();
           System.out.println("Metodo");
           JOptionPane.showMessageDialog(null, "Registro eliminado!");
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error al eliminar el registro!");
       }
    }//GEN-LAST:event_btnEliminarInvActionPerformed

    private void btnModificarInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarInvActionPerformed
        // TODO add your handling code here:}
        int fila = tablaInventario.getSelectedRow();                
        int valor = Integer.parseInt(this.tablaInventario.getValueAt(fila, 0).toString());
        String idProducto = tablaInventario.getValueAt(fila, 1).toString();
        String cantidad = tablaInventario.getValueAt(fila, 2).toString();
        String idProovedor = tablaInventario.getValueAt(fila, 3).toString();
        String condicion = "idInventario="+valor;
        String campos = "idProductox="+idProducto+",cantidad="+cantidad+",idProveedorx="+idProovedor;
        try{
            modificar("inventario", campos, condicion);
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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarInv;
    public javax.swing.JButton btnEliminarInv;
    public javax.swing.JButton btnModificarInv;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboProveedor;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable tablaInventario;
    private javax.swing.JTextArea txtADescripcion;
    private javax.swing.JTextArea txtAInfNut;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables

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

    private static String eliminar(java.lang.String nombreTabla, java.lang.String condicion) {
        pkg.webservice.WSTortilleria_Service service = new pkg.webservice.WSTortilleria_Service();
        pkg.webservice.WSTortilleria port = service.getWSTortilleriaPort();
        return port.eliminar(nombreTabla, condicion);
    }

    private static String modificar(java.lang.String nombreTabla, java.lang.String campos, java.lang.String condicion) {
        pkg.webservice.WSTortilleria_Service service = new pkg.webservice.WSTortilleria_Service();
        pkg.webservice.WSTortilleria port = service.getWSTortilleriaPort();
        return port.modificar(nombreTabla, campos, condicion);
    }        
    
}
