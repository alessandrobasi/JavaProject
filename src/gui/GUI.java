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

    private static JPanel controls = new JPanel();

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

        controls.setLayout(new GridLayout(3,0,100,100));



        JButton impostazioni = new JButton("Avvia Gioco");
        impostazioni.setSize(new Dimension(3, 3));

        impostazioni.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Impostazioni");
                Setting();

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
        controls.add(impostazioni, BorderLayout.CENTER);


        f.add(controls);


        f.pack();
        f.setVisible(true);
    }

    private static void Setting(){


        controls.removeAll();

        controls.setLayout(new GridLayout(4,1,100,50));

        controls.updateUI();

        JButton avviaGioco = new JButton("Avvia Gioco");

        avviaGioco.setSize(new Dimension(3, 3));

        avviaGioco.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Avvia gioco");
                // TODO: Prendere informazioni immesse nei campi
                Gioco();

            }
        });

        JLabel Testo = new JLabel();
        Testo.setText("" +
                "<html>" +
                "Impostazioni" +
                "</html>"
        );

        JLabel UtentiMassimi = new JLabel();
        UtentiMassimi.setText("" +
                "Utenti massimi");

        JTextField NumeroMaxUtenti = new JTextField("1000",9);

        JLabel UtentiAttivi = new JLabel();
        UtentiAttivi.setText("" +
                "Utenti attivi");

        JTextField NumeroUtentiAttivi = new JTextField("500",5);



        controls.add(Testo, BorderLayout.CENTER);
        controls.add(Empty, BorderLayout.CENTER);

        controls.add(UtentiMassimi, BorderLayout.CENTER);
        controls.add(NumeroMaxUtenti, BorderLayout.CENTER);

        controls.add(UtentiAttivi, BorderLayout.CENTER);
        controls.add(NumeroUtentiAttivi, BorderLayout.CENTER);

        controls.add(avviaGioco, BorderLayout.CENTER);

    }

    private static JLabel Notizie = new JLabel();

    public static void AppendToNotizie(String testo){

        String temp = Notizie.getText().replace("<html>", "");
        temp = temp.replace("</html>","");

        Notizie.setText( "<html>" + temp + "<br/>" + testo + "</html>" );

    }

    private static void Gioco(){

        controls.removeAll();
        controls.setLayout(new GridLayout(1,1,1,1));
        controls.updateUI();

        // START GAME
        // Creazione universo
        // ( Grandezza universo, Numero di persone attive )
        Universo mondo1 = new Universo(Variabile.Utenti, Variabile.UtentiAttivi);

        //System.out.println("Persone attive: " + mondo1.get_size() );

        Tempo mondo = new Tempo(mondo1);
        mondo.setName("tempo");

        // Big Bang
        mondo.start();

        // TODO: DA CONTINUARE
        // https://stackoverflow.com/questions/11424180/drawing-with-graphics-and-with-widgets-in-japplet-swing
        controls.add(new JLabel("Da finire"));

        Notizie.setText("Persone attive: " + mondo1.get_size());

        controls.add(Notizie);

    }



}
