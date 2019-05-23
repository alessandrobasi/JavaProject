package gui;

import GlobalVar.Variabile;
import universo.Tempo;
import universo.Universo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private static JFrame f = new JFrame("A Social Game System (SGS)");//creating instance of JFrame



    private static JLabel Empty = new JLabel();



    private static void setFrameOption(JFrame frame){
        frame.setPreferredSize(new Dimension(512,512));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
    }


    public static void main(String[] args) {

        setFrameOption(f);

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

        setFrameOption(gioco);

        // START GAME
        // Creazione universo
        // ( Grandezza universo, Numero di persone attive )
        Universo mondo1 = new Universo(Variabile.Utenti, Variabile.UtentiAttivi);

        System.out.println("Persone attive: " + mondo1.get_size() );

        Tempo mondo = new Tempo(mondo1);
        mondo.setName("tempo");

        // Big Bang
        mondo.start();

        f.setVisible(false);

        // DA CONTINUARE
        // https://stackoverflow.com/questions/11424180/drawing-with-graphics-and-with-widgets-in-japplet-swing
        gioco.add(new JLabel("Da finire"));


        gioco.pack();
        gioco.setVisible(true);

    }



}
