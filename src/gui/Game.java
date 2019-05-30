package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Game extends JPanel {

    public Game() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    /*
    public void paint(Graphics g) {
        Shape shape = new Rectangle2D.Float(100, 50, 80, 80);

        Graphics2D g2 = (Graphics2D) g;

        g2.fill(shape);
    }
    */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw Text
        g.drawString("This is my custom Panel!",10,20);

        Shape shape = new Rectangle2D.Float(100, 50, 80, 80);

        Graphics2D g2 = (Graphics2D) g;

        g2.fill(shape);
    }

}
