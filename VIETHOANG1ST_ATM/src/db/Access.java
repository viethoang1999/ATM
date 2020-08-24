/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Access {
    
            
            
    public static void CanleAcess(JFrame fr1, JFrame fr2){
        fr1.setVisible(true);
        fr2.dispose();
    }
    
    
    public static void setLocationJframeTopCenter(JFrame fr) {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screen.getWidth() - fr.getWidth()) / 2);
        fr.setLocation(x, 0);
    }
    
    public static void setLocationJframeCenter(JFrame fr) {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screen.getWidth() - fr.getWidth()) / 2);
        int y = (int) ((screen.getHeight() - fr.getHeight()) / 2);
        fr.setLocation(x, y);
    }


}
