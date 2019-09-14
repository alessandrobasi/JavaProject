package gui;

import universo.Persona;
import universo.Universo;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Game extends JPanel {

    public Game() {
        setBorder(BorderFactory.createLineBorder(Color.black));

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Shape shape = new Rectangle2D.Float(50,50,1,1);
        g2.fill(shape);
    }

    public void posizionaUtenti(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        for(Persona io : Universo.get_active_universe()){

            Shape shape = new Rectangle2D.Float(io.BoardX, io.BoardY, 40, 40);
            // Draw Text
            g.drawString(Integer.toString((Integer) io.get_info().get(1))  ,io.BoardX+15,io.BoardY+50);

            g2.fill(shape);
        }









    }

}
