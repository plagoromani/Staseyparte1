/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author jota
 */
public class Imagen extends javax.swing.JPanel{
    
    public Imagen(){
        this.setSize(300,400);
    }
    
    @Override
    public void paint(Graphics g){
        Dimension height = getSize();
        ImageIcon img = new ImageIcon(getClass().getResource("/Resources/Rosas+Pistolas_Espalda.jpg"));
        g.drawImage(img.getImage(), 0, 0, height.width,height.height,null);
        setOpaque(false);
        super.paintComponent(g);
    }
}
