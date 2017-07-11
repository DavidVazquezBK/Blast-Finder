/*
 * Coded by David Vazquez using NetBeans.
 */
package ui.misc;

import jdbc.Conexion;
import POJO.CategoriaPOJO;
import POJO.MaterialPOJO;
import POJO.ProductoPOJO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Cursor;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import utilidades.QRCodeFactory;

/**
 *
 * @author BurnKill
 */
public class GeneradorQR extends javax.swing.JPanel {

    ArrayList<CategoriaPOJO> categorias;
    ArrayList<ProductoPOJO> productos;
    ArrayList<MaterialPOJO> materiales;
    Properties props;

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
    Date date = new Date();

    /**
     * Creates new form GeneradorQR
     */
    public GeneradorQR() {
        initComponents();

        props = new Properties();
        try {
            InputStream inputStream = GeneradorQR.class.getResourceAsStream("/config/prefs.properties");
            props.load(inputStream);
            inputStream.close();
            if (Boolean.valueOf(props.getProperty("usarRuta"))) {
                jTextField1.setText(props.getProperty("ruta"));
            } else {
                jTextField1.setText(null);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "¡Archivo de configuración inexistente! Inicializando", "Error", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Archivo de configuración no encontrado: " + ex);
        }

        this.productos = new ArrayList<ProductoPOJO>();
        this.categorias = new ArrayList<CategoriaPOJO>();
        this.materiales = new ArrayList<MaterialPOJO>();

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement st = con.prepareStatement("SELECT * FROM categoria");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                CategoriaPOJO categoriaPOJO = new CategoriaPOJO();

                categoriaPOJO.setIdCategoria(rs.getInt(1));
                categoriaPOJO.setNombre(rs.getString(2));
                categoriaPOJO.setIniciales(rs.getString(3));

                categorias.add(categoriaPOJO);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement st = con.prepareStatement("SELECT * FROM producto");
            ResultSet rs2 = st.executeQuery();
            while (rs2.next()) {
                ProductoPOJO productoPOJO = new ProductoPOJO();
                productoPOJO.setIdProducto(rs2.getInt(1));
                productoPOJO.setNombre(rs2.getString(2));
                productoPOJO.setCategoria_idCategoria(rs2.getInt(3));
                productoPOJO.setIniciales(rs2.getString(4));

                productos.add(productoPOJO);
            }
            rs2.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement st = con.prepareStatement("SELECT * FROM material");
            ResultSet rs3 = st.executeQuery();

            while (rs3.next()) {
                MaterialPOJO materialPOJO = new MaterialPOJO();

                materialPOJO.setIdMaterial(rs3.getInt(1));
                materialPOJO.setNotas(rs3.getString(2));
                materialPOJO.setProducto_idProducto(rs3.getInt(3));
                materialPOJO.setNombre(rs3.getString(4));

                materiales.add(materialPOJO);
            }

            rs3.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        cargaModoCategorias();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTree5 = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        imagen = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        documento = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();

        jFileChooser1.setAccessory(jButton1);
        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoría", "Producto" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Clasificar por:");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Todos los materiales"));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree5.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane5.setViewportView(jTree5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Material(es) seleccionado(s)"));

        jList1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jList1PropertyChange(evt);
            }
        });
        jScrollPane6.setViewportView(jList1);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/derecha.png"))); // NOI18N
        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/izquierda.png"))); // NOI18N
        jButton4.setText("Retirar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap())
        );

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check.png"))); // NOI18N
        jButton5.setText("Crear etiquetas");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuración"));

        jButton1.setText("Buscar...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);

        jLabel3.setText("Carpeta de exportación:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PNG", "JPEG", "GIF" }));

        jLabel4.setText("Formato de archivo:");

        jLabel2.setText("Resolución");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(500, 0, 10000, 1));

        jLabel5.setText("Horizontal:");

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(500, 0, 10000, 1));

        jLabel7.setText("Vertical:");

        javax.swing.GroupLayout imagenLayout = new javax.swing.GroupLayout(imagen);
        imagen.setLayout(imagenLayout);
        imagenLayout.setHorizontalGroup(
            imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(imagenLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner2)
                        .addGap(8, 8, 8))
                    .addGroup(imagenLayout.createSequentialGroup()
                        .addGroup(imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(imagenLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(imagenLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))))
        );
        imagenLayout.setVerticalGroup(
            imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Imagen", new javax.swing.ImageIcon(getClass().getResource("/img/img.png")), imagen); // NOI18N
        imagen.getAccessibleContext().setAccessibleName("");

        jLabel8.setText("Tamaño de hoja:");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tabloide", "Carta" }));

        jLabel6.setText("Horizontal:");

        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(300, 0, 10000, 1));

        jLabel9.setText("Vertical:");

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(300, 0, 10000, 1));

        jLabel10.setText("Resolución");

        javax.swing.GroupLayout documentoLayout = new javax.swing.GroupLayout(documento);
        documento.setLayout(documentoLayout);
        documentoLayout.setHorizontalGroup(
            documentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(documentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(documentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(documentoLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(documentoLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner4))
                    .addGroup(documentoLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        documentoLayout.setVerticalGroup(
            documentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(documentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(documentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(documentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PDF", new javax.swing.ImageIcon(getClass().getResource("/img/doc.png")), documento); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1)
                        .addGap(7, 7, 7))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addGap(16, 16, 16))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        cargaJTree();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jList1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jList1PropertyChange
        cambiaEstadoBotonAceptar();
    }//GEN-LAST:event_jList1PropertyChange

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Checar si ya está en la lista
        DefaultMutableTreeNode nodoSeleccionado = (DefaultMutableTreeNode) jTree5.getLastSelectedPathComponent();
        if (Objects.nonNull(nodoSeleccionado)) {
            if (nodoSeleccionado.getUserObject() instanceof MaterialPOJO) {
                //Obtener nodo seleccionado
                DefaultMutableTreeNode nodoSeleccionado2 = (DefaultMutableTreeNode) jTree5.getLastSelectedPathComponent();
                //Obtener material seleccionado
                MaterialPOJO materialSeleccionado = (MaterialPOJO) nodoSeleccionado2.getUserObject();
                //Si la lista está vacía, se agrega el material, si no, se buscan coincidencias
                if (jList1.getModel().getSize() == 0) {
                    //                    System.out.println("Lista vacia, agregando...");
                    agrega(materialSeleccionado);
                    //Que hacer si la lista tiene mas de 0 materiales
                } else if (jList1.getModel().getSize() > 0) {
                    //Obtener modelo de jList, en el cual hay que buscar coincidencias de material
                    ListModel listModel1 = jList1.getModel();
                    //Comparar cada material con el seleccionado
                    boolean listo;
                    listo = true;
                    for (int i = 0; i < jList1.getModel().getSize(); i++) {
                        if (((MaterialPOJO) listModel1.getElementAt(i)).getIdMaterial() == materialSeleccionado.getIdMaterial()) {
                            listo = false;
                        }
                    }
                    if (listo) {
                        agrega(materialSeleccionado);
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jList1.getModel().getSize() > 0) {
            //Crear modelo nuevo
            DefaultListModel<MaterialPOJO> defaultListModel = new DefaultListModel<MaterialPOJO>();
            //Obtener modelo de jList1
            ListModel listModel = jList1.getModel();
            //Agregar registros de jList al modelo nuevo
            for (int i = 0; i < jList1.getModel().getSize(); i++) {
                defaultListModel.addElement((MaterialPOJO) listModel.getElementAt(i));
            }
            //Eliminar
            defaultListModel.remove(jList1.getSelectedIndex());
            //Definir nuevo modelo
            jList1.setModel((ListModel) defaultListModel);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (jTabbedPane1.getSelectedIndex() == 0) {
            exportaImagenes();
        } else {
            try {
                exportaDocumento(jComboBox5.getSelectedIndex());
            } catch (DocumentException ex) {
                muestraError(ex);
            } catch (FileNotFoundException ex) {
                muestraError(ex);
            } catch (WriterException ex) {
                muestraError(ex);
            } catch (IOException ex) {
                muestraError(ex);
            } catch (Exception ex) {
                muestraError(ex);
            }

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jFileChooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            if (jFileChooser1.getSelectedFile().isDirectory()) {
                jTextField1.setText("" + jFileChooser1.getSelectedFile());
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un directorio", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        cambiaEstadoBotonAceptar();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel documento;
    private javax.swing.JPanel imagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTree jTree5;
    // End of variables declaration//GEN-END:variables

    private void cargaJTree() {
        switch (jComboBox1.getSelectedIndex()) {
            case 0: {
                cargaModoCategorias();
                break;

            }

            case 1: {
                cargaModoProductos();
                break;
            }

        }
    }

    private void cargaModoCategorias() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Categorías");
        for (int i = 0; i < categorias.size(); i++) {
            // Agregar CategoriasPOJO al root
            DefaultMutableTreeNode categoria = new DefaultMutableTreeNode();
            categoria.setUserObject(categorias.get(i));

            //Agregar materiales a cada categoria
            try {
                Connection con = Conexion.getConnection();
                PreparedStatement st = con.prepareStatement("SELECT * FROM material WHERE material.Producto_idProducto in (SELECT producto.idProducto FROM producto WHERE producto.Categoria_idCategoria = " + categorias.get(i).getIdCategoria() + ")");
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    categoria.add(new DefaultMutableTreeNode(new MaterialPOJO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4))));

                }
                rs.close();
                st.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MaterialVista.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Agregar cada categoria al root
            root.add(categoria);
        }

        jTree5.setModel(new DefaultTreeModel(root));
    }

    private void cargaModoProductos() {

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Productos");
        for (int i = 0; i < productos.size(); i++) {
            // Agregar ProductosPOJO al root
            DefaultMutableTreeNode producto = new DefaultMutableTreeNode();
            producto.setUserObject(productos.get(i));

            //Agregar materiales a cada categoria
            try {
                Connection con = Conexion.getConnection();
                PreparedStatement st = con.prepareStatement("SELECT * FROM material WHERE material.Producto_idProducto=" + productos.get(i).getIdProducto());
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    producto.add(new DefaultMutableTreeNode(new MaterialPOJO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4))));

                }
                rs.close();
                st.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MaterialVista.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Agregar cada categoria al root
            root.add(producto);
        }

        jTree5.setModel(new DefaultTreeModel(root));
    }

    private void cambiaEstadoBotonAceptar() {
        if (jList1.getModel().getSize() > 0 && !jTextField1.getText().isEmpty()) {
            jButton5.setEnabled(true);
        } else {
            jButton5.setEnabled(false);
        }
    }

    public void agrega(MaterialPOJO materialSeleccionado) {
        //Crear modelo nuevo
        DefaultListModel<MaterialPOJO> defaultListModel = new DefaultListModel<MaterialPOJO>();
        //Obtener modelo de jList1
        ListModel listModel = jList1.getModel();
        //Agregar registros de jList al modelo nuevo
        for (int i = 0; i < jList1.getModel().getSize(); i++) {
            defaultListModel.addElement((MaterialPOJO) listModel.getElementAt(i));
        }
        //Agregar material seleccionado
        defaultListModel.addElement(materialSeleccionado);
        //Definir nuevo modelo
        jList1.setModel((ListModel) defaultListModel);
    }

    public void exportaImagenes() {

        //Poner cursor de espera
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        //Donde almacenar materiales seleccionados
        MaterialPOJO[] materialesSeleccionado = new MaterialPOJO[jList1.getModel().getSize()];
        //Obtener modelo de jList1 para obtener cada objeto
        ListModel listModel = jList1.getModel();
        //Almacenar cada objeto casteado a su posición en materialesSeleccionado
        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        boolean fl = false;
        for (int i = 0; i < materialesSeleccionado.length; i++) {
            materialesSeleccionado[i] = (MaterialPOJO) listModel.getElementAt(i);
            try {
                QRCodeFactory.createQRCode(materialesSeleccionado[i].getNombre(),
                        jTextField1.getText() + File.separator + materialesSeleccionado[i].getNombre() + "." + jComboBox3.getSelectedItem().toString(),
                        "UTF-8",
                        hintMap,
                        (Integer) jSpinner2.getValue(),
                        (Integer) jSpinner1.getValue()
                );
                fl = true;
            } catch (WriterException ex) {
                ex.printStackTrace();
                Logger.getLogger(GeneradorQR.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.INFORMATION_MESSAGE);
                fl = false;
                break;
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.INFORMATION_MESSAGE);
                fl = false;
                break;
            }
        }
        if (fl) {
            JOptionPane.showMessageDialog(this, "Etiquetas generadas correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
            jList1.setModel(new DefaultListModel<String>());
        }
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        } finally {
            setCursor(Cursor.getDefaultCursor());
        }
    }

    private void exportaDocumento(int tamano) throws DocumentException, FileNotFoundException, WriterException, IOException, Exception {
        //Nota: el tamano empieza desde 0 
        //Poner cursor de espera
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        //Donde almacenar materiales seleccionados
        MaterialPOJO[] materialesSeleccionado = new MaterialPOJO[jList1.getModel().getSize()];
        //Obtener modelo de jList1 para obtener cada objeto
        ListModel listModel = jList1.getModel();
        //Bandera por si sucede algún error
        boolean bien = false;
        //Obtener POJOs de materiales seleccionados
        for (int i = 0; i < materialesSeleccionado.length; i++) {
            materialesSeleccionado[i] = (MaterialPOJO) listModel.getElementAt(i);
        }
        //Inicializar documento
        Document document = null;
        //Asignar tamano de documento
        switch (jComboBox5.getSelectedIndex()) {
            case 0:
                document = new Document(PageSize.TABLOID);
                break;
            case 1:
                document = new Document(PageSize.LETTER);
                break;
            default:
                throw new Exception("Error setteando documento");
        }
        //Inicializar documento y abrirlo
        PdfWriter.getInstance(document,
                new FileOutputStream(
                        jTextField1.getText() + File.separator + materialesSeleccionado.length + " Material(es), " + dateFormat.format(date) + ".pdf"));
        document.open();
        //Preparar variables para exportar QR
        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        //Anadir cada imagen al documento
        for (int i = 0; i < materialesSeleccionado.length; i++) {
            BufferedImage bufferedImage = getBufferedImageFromQR(materialesSeleccionado[i].getNombre(), hintMap, (Integer) jSpinner3.getValue(), (Integer) jSpinner4.getValue());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            Image iTextImage = Image.getInstance(baos.toByteArray());
            document.add(iTextImage);

            //Crear el titulo de cada QR
            Paragraph p = new Paragraph(materialesSeleccionado[i].getNombre(), new Font(FontFamily.HELVETICA, 22));
            p.setAlignment(Element.ALIGN_LEFT);
            document.add(p);
            bien = true;
        }
        //Terminar
        document.close();

        if (bien) {
            JOptionPane.showMessageDialog(this, "Etiquetas generadas correctamente", "Error", JOptionPane.INFORMATION_MESSAGE);
            jList1.setModel(new DefaultListModel<String>());
        }
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        } finally {
            setCursor(Cursor.getDefaultCursor());
        }
    }

    public static BufferedImage getBufferedImageFromQR(String qrCodeData, Map hintMap, int qrCodeheight, int qrCodewidth) throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes("UTF-8"), "UTF-8"), BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
        return MatrixToImageWriter.toBufferedImage(matrix);
    }

    private void muestraError(Exception ex) {
        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        } finally {
            setCursor(Cursor.getDefaultCursor());
        }
        JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
