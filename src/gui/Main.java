package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private static JFrame f = new JFrame("A Social Game System (SGS)");//creating instance of JFrame

    private static JLabel Empty = new JLabel();

    public static void main(String[] args) {

        f.setPreferredSize(new Dimension(512,512));

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setLayout(new FlowLayout(FlowLayout.CENTER));

        Home();

    }

    private static void Home(){

        JPanel controls = new JPanel();

        //controls.setPreferredSize(new Dimension(512,512));

        controls.setLayout(new GridLayout(3,0,100,100));



        JButton avviaGioco = new JButton("Avvia Gioco");
        avviaGioco.setSize(new Dimension(3, 3));

        avviaGioco.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("bottone cliccato");
                Gioco();

            }
        });

        JLabel TestoBenvenuto = new JLabel();
        TestoBenvenuto.setText("" +
                "<html>" +
                "A Social Game System (SGS)" +
                "<br/>" +
                "Creato da: " +
                "</html>"
        );


        controls.add(Empty, BorderLayout.CENTER);
        controls.add(TestoBenvenuto, BorderLayout.CENTER);
        controls.add(avviaGioco, BorderLayout.CENTER);


        f.add(controls);


        f.pack();
        f.setVisible(true);
    }


    private static void Gioco(){

        JFrame gioco = new JFrame("A Social Game System (SGS)");

        f.setVisible(false);
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
        gioco.add(controls);

        //f.addComponentsToPane(f.getContentPane());
        //Display the window.
        gioco.pack();
        gioco.setVisible(true);

    }



}
