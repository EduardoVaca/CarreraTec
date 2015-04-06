/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Imagenes;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Edu
 */
public class bgImagen extends JPanel
{
    
    public bgImagen()
    {
        
    }
    @Override
    public void paintComponent(Graphics g)
    {
        g.drawImage(Imagenes.Singleton().imagen("fondomenu.jpg"), 0, 0, this);
    }
}

