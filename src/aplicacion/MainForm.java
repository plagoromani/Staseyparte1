/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.awt.Font;
import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;



/**
 *
 * @author jota
 */
public class MainForm extends javax.swing.JFrame{

    private static Usuario u;
    JPanel[] anuncios;

    public static Usuario getU() {
        return u;
    }

    public static void setU(Usuario u) {
        MainForm.u = u;
    }

    public MainForm() {
        initComponents();
        user_btn.setText(u.getNickName());
        anuncios = diseñarAnuncio();
        for (JPanel p : anuncios) {
            anunciosDisplay.add(p.getName(),p);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        user_btn = new javax.swing.JButton();
        anunciosDisplay = new javax.swing.JTabbedPane();
        anuncioNuevo_btn = new javax.swing.JButton();
        refresh_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stacey 2.0");
        setBackground(new java.awt.Color(123, 141, 142));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(123, 141, 142));

        user_btn.setAutoscrolls(true);
        user_btn.setMaximumSize(new java.awt.Dimension(60, 16));
        user_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_btnActionPerformed(evt);
            }
        });

        anuncioNuevo_btn.setText("Nuevo anuncio");
        anuncioNuevo_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anuncioNuevo_btnActionPerformed(evt);
            }
        });

        refresh_btn.setText("Refrescar");
        refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(anuncioNuevo_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(refresh_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(user_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(anunciosDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(user_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(anuncioNuevo_btn)
                        .addComponent(refresh_btn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(anunciosDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void user_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_btnActionPerformed
        UserData form = new UserData();
        form.setVisible(true);
    }//GEN-LAST:event_user_btnActionPerformed

    private void anuncioNuevo_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anuncioNuevo_btnActionPerformed
        newAnuncio ob = new newAnuncio();
        ob.setVisible(true);
    }//GEN-LAST:event_anuncioNuevo_btnActionPerformed

    private void refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_btnActionPerformed
        anuncios = diseñarAnuncio();
        anunciosDisplay.removeAll();
        for (JPanel p : anuncios) {
            anunciosDisplay.add(p.getName(),p);
        }
    }//GEN-LAST:event_refresh_btnActionPerformed

    public static  JPanel[] diseñarAnuncio() {
        JPanel[] paneles = new JPanel[Anuncio.getAnuncios().size()];
        JLabel[] titulos = new JLabel[Anuncio.getAnuncios().size()];
        JTextArea[] descripcion = new JTextArea[Anuncio.getAnuncios().size()];
        JLabel[] imagenes = new JLabel[Anuncio.getAnuncios().size()];
        ImageIcon img;
        JLabel[] precios = new JLabel[Anuncio.getAnuncios().size()];
        JLabel[] propietarios = new JLabel[Anuncio.getAnuncios().size()];
        
        Anuncio a;
        for (int i = 0; i < paneles.length; i++) {
            imagenes[i]=new JLabel();
            a=Anuncio.getAnuncios().get(i);
            try {
                img=new ImageIcon(new URL(a.getImagen()));
                imagenes[i]=new JLabel(img);
            } catch (MalformedURLException ex) {
                imagenes[i].setText("La imagen no se ha podido cargar");
            }
            //Instancio componentes
            paneles[i]=new JPanel(null);
            propietarios[i]=new JLabel();
            titulos[i]=new JLabel();
            descripcion[i]=new JTextArea();
            precios[i]=new JLabel();
            //Modifico propiedades
            paneles[i].setName(a.getTitulo());
            titulos[i].setText(a.getTitulo());
            titulos[i].setBounds(0, 10, 630, 40);
            titulos[i].setHorizontalAlignment(SwingConstants.CENTER);
            descripcion[i].setText(a.getDescripcion());
            descripcion[i].setBackground(new Color(241, 169, 78 ));
            descripcion[i].setEditable(false);
            descripcion[i].setLineWrap(true);
            propietarios[i].setText("Creado por "+a.getPropietario().getNickName());
            propietarios[i].setBounds(430, 400, 150, 40);
            propietarios[i].setForeground(new Color(93, 76, 70));
            titulos[i].setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
            titulos[i].setForeground(new Color(	93, 76, 70  ));
            paneles[i].setBackground(new Color(	241, 169, 78 ));
            descripcion[i].setBounds(35, 250, 550, 100);
            imagenes[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            imagenes[i].setBounds(160, 60, 300, 180);
            precios[i].setText(String.valueOf(a.getAlquiler())+" €/mes");
            precios[i].setFont(new Font(Font.SANS_SERIF,Font.BOLD,34));
            precios[i].setHorizontalAlignment(SwingConstants.CENTER);
            precios[i].setForeground(new Color(228, 86, 65));
            precios[i].setBounds(0, 350, 630, 50);
            paneles[i].add(titulos[i]);
            paneles[i].add(imagenes[i]);
            paneles[i].add(precios[i]);
            paneles[i].add(propietarios[i]);
            paneles[i].add(descripcion[i]);
            
        }
        
        return paneles;
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anuncioNuevo_btn;
    private javax.swing.JTabbedPane anunciosDisplay;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton refresh_btn;
    private javax.swing.JButton user_btn;
    // End of variables declaration//GEN-END:variables

    
}
