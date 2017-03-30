/*
 * Coded by David Vazquez using NetBeans.
 */
package ui;

import com.alee.laf.WebLookAndFeel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author BurnKill
 */
public class Principal extends javax.swing.JFrame {

    static SplashScreen mySplash;
    static Graphics2D splashGraphics;
    static Rectangle2D.Double splashTextArea;
    static Rectangle2D.Double splashProgressArea;
    static Font font;

    public Principal() {
        initComponents();
//TODO poner icono de aplicación
//        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("C:\\Users\\BurnKill\\Desktop\\icon.png")));

        this.setLocationRelativeTo(null);
        agregarPestaña(new Inicio(), "Inicio");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminMenuSeleccion = new javax.swing.JDialog();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();

        adminMenuSeleccion.setTitle("Menu de administración");
        adminMenuSeleccion.setResizable(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tag.png"))); // NOI18N
        jButton1.setText("Categorías");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/material.png"))); // NOI18N
        jButton3.setText("Materiales");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/movimientos.png"))); // NOI18N
        jButton4.setText("Movimientos");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/producto.png"))); // NOI18N
        jButton5.setText("Productos");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ubicacion.png"))); // NOI18N
        jButton6.setText("Ubicaciones");

        javax.swing.GroupLayout adminMenuSeleccionLayout = new javax.swing.GroupLayout(adminMenuSeleccion.getContentPane());
        adminMenuSeleccion.getContentPane().setLayout(adminMenuSeleccionLayout);
        adminMenuSeleccionLayout.setHorizontalGroup(
            adminMenuSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminMenuSeleccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminMenuSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        adminMenuSeleccionLayout.setVerticalGroup(
            adminMenuSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminMenuSeleccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(39, 39, 39)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Blast Finder - Instituto Franklin de Veracruz");

        jToolBar1.setFloatable(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/administracion.png"))); // NOI18N
        jButton2.setText("Administración");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Inicio");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        adminMenuSeleccion.setSize(131 + 30, 219 + 30);
        adminMenuSeleccion.setLocationRelativeTo(adminMenuSeleccion.getParent());
        adminMenuSeleccion.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        splashInit();
        appInit();

        if (mySplash != null) // check if we really had a spash screen
        {
            mySplash.close();   // we're done with it
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WebLookAndFeel.install();
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog adminMenuSeleccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
 private static void splashInit() {

        mySplash = SplashScreen.getSplashScreen();

        if (mySplash != null) {
            Dimension ssDim = mySplash.getSize();
            int height = ssDim.height;
            int width = ssDim.width;
            splashTextArea = new Rectangle2D.Double(15., height * 0.88, width * .45, 32.);
            splashProgressArea = new Rectangle2D.Double(width * .55, height * .92, width * .4, 12);
            splashGraphics = mySplash.createGraphics();
            font = new Font("Cinzel", Font.PLAIN, 14);
            splashGraphics.setFont(font);
            splashText("Starting");
            splashProgress(0);
        }
    }

    private static void appInit() {
        for (int i = 1; i <= 2; i++) {
            int pctDone = i * 10;
            splashText("Doing task #" + i);
            splashProgress(pctDone);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                break;
            }
        }
    }

    /**
     * Display text in status area of Splash. Note: no validation it will fit.
     *
     * @param str - text to be displayed
     */
    public static void splashText(String str) {
        if (mySplash != null && mySplash.isVisible()) {
            splashGraphics.setPaint(Color.LIGHT_GRAY);
            splashGraphics.fill(splashTextArea);
            splashGraphics.setPaint(Color.BLACK);
            splashGraphics.drawString(str, (int) (splashTextArea.getX() + 10), (int) (splashTextArea.getY() + 15));
            mySplash.update();
        }
    }

    /**
     * Display a (very) basic progress bar
     *
     * @param pct how much of the progress bar to display 0-100
     */
    public static void splashProgress(int pct) {
        if (mySplash != null && mySplash.isVisible()) {

            splashGraphics.setPaint(Color.WHITE);
            splashGraphics.fill(splashProgressArea);

            splashGraphics.setPaint(Color.BLUE);
            splashGraphics.draw(splashProgressArea);

            int x = (int) splashProgressArea.getMinX();
            int y = (int) splashProgressArea.getMinY();
            int wid = (int) splashProgressArea.getWidth();
            int hgt = (int) splashProgressArea.getHeight();

            int doneWidth = Math.round(pct * wid / 100.f);
            doneWidth = Math.max(0, Math.min(doneWidth, wid - 1));

            splashGraphics.setPaint(Color.GREEN);
            splashGraphics.fillRect(x, y + 1, doneWidth, hgt - 1);

            mySplash.update();
        }
    }

    public void agregarPestaña(JPanel JPanel, String nombreTab) {
        boolean fl = false;
        int tabSeleccionado = 0;
        try {
            for (int i = 0; i < jTabbedPane1.getTabCount(); i++) {
                if (jTabbedPane1.getTitleAt(i).equals(nombreTab)) {
                    fl = true;
                    tabSeleccionado = i;
                }
            }
            if (fl) {
                jTabbedPane1.setSelectedIndex(tabSeleccionado);
            } else {
                jTabbedPane1.add(nombreTab, JPanel);
                jTabbedPane1.setSelectedIndex(jTabbedPane1.getTabCount() - 1);
                if (jTabbedPane1.getComponentCount() > 1) {

                    //FALTA AGREGAR BOTON DE ELIMINAR
//                    eliminarPestania.setEnabled(true);
                }
            }
        } catch (Exception e) {
            System.out.println("Agregando pestaña: " + e);
        }

    }

}
