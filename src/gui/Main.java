package gui;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private static JFrame f = new JFrame("A Social Game System (SGS)");//creating instance of JFrame

    public static void main(String[] args) {

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Home();
    }

    private static void Home(){

        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(2,0,50,50));



        JButton button = new JButton("Button 2 (CENTER)");
        button.setPreferredSize(new Dimension(512, 512));
        JLabel TestoBenvenuto = new JLabel();
        TestoBenvenuto.setText(
                "" +
                        "<html>" +
                        "<div style='text-align: center;'>" +
                        "A Social Game System (SGS)" +
                        "</div>" +
                        "</html>"
        );

        controls.add(TestoBenvenuto);
        controls.add(button);
        f.setLayout(new FlowLayout());

        f.add(controls, BorderLayout.CENTER);


        f.pack();
        f.setVisible(true);
    }


    private static void Griglia(){
        /*
        JButton b = new JButton("click");//creating instance of JButton
        b.setBounds(0,0,100, 40);//x axis, y axis, width, height

        f.add(b);//adding button in JFrame

        f.setSize(500,500);//400 width and 500 height


        //new FlowLayout();

        f.setLayout(null);//using no layout managers

        f.setVisible(true);//making the frame visible
        */

        //Create and set up the window.


        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(2,3));

        JButton b = new JButton("click");//creating instance of JButton
        b.setBounds(0,0,100, 40);//x axis, y axis, width, height

        controls.add(b);
        controls.add(new JButton("Button 1"));
        controls.add(new JButton("Button 2"));
        controls.add(new JButton("Button 3"));
        controls.add(new JButton("Long-Named Button 4"));
        controls.add(new JButton("5"));
        controls.add(new JButton("5.1"));

        //Set up the content pane.
        f.add(controls);

        //f.addComponentsToPane(f.getContentPane());
        //Display the window.
        f.pack();
        f.setVisible(true);

    }



}
