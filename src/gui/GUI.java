package gui;

import GlobalVar.Variabile;
import universo.Tempo;
import universo.Universo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GUI extends JFrame {

    private static JFrame f = new JFrame("A Social Game System (SGS)");//creating instance of JFrame

    private static JPanel controls = new JPanel();

    private static JLabel Empty = new JLabel();



    private static void setFrameOption(JFrame frame){
        //frame.setPreferredSize(new Dimension(512,512));


        frame.setSize(new Dimension(512,512));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        frame.setResizable(false);

    }


    public static void main(String[] args) {

        setFrameOption(f);

        //controls.setBackground(Color.red);

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


        f.add(controls,0);

        f.setVisible(true);
    }

    private static void Setting(){


        controls.removeAll();

        controls.setLayout(new GridLayout(4,1,100,50));

        controls.updateUI();

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

        JButton avviaGioco = new JButton("Avvia Gioco");

        avviaGioco.setSize(new Dimension(3, 3));

        avviaGioco.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Avvia gioco");
                // TODO: Prendere informazioni immesse nei campi

                Variabile.Utenti = Integer.parseInt(NumeroMaxUtenti.getText());
                Variabile.UtentiAttivi = Integer.parseInt(NumeroUtentiAttivi.getText());

                Gioco();

            }
        });

        controls.add(Testo, BorderLayout.CENTER);
        controls.add(Empty, BorderLayout.CENTER);

        controls.add(UtentiMassimi, BorderLayout.CENTER);
        controls.add(NumeroMaxUtenti, BorderLayout.CENTER);

        controls.add(UtentiAttivi, BorderLayout.CENTER);
        controls.add(NumeroUtentiAttivi, BorderLayout.CENTER);

        controls.add(avviaGioco, BorderLayout.CENTER);

    }


    private static JLabel Notizie = new JLabel();

    private static JScrollPane NotizieLista = new JScrollPane(Notizie);

    public static void AppendToNotizie(String testo){

        String temp = Notizie.getText().replace("<html>", "");
        temp = temp.replace("</html>","");

        Notizie.setText( "<html>" + temp + "<br/>" + testo + "</html>" );

        JScrollBar vertical = NotizieLista.getVerticalScrollBar();
        vertical.setValue( vertical.getMaximum());

    }


    //public static JPanel game = new JPanel();

    public static Game game;

    private static void Gioco(){


        controls.removeAll();

        controls.revalidate();

        controls.updateUI();


        f.remove(controls);

        f.setSize(new Dimension(1024, 512));

        f.setLayout(new BorderLayout());

        controls.setLayout(new GridBagLayout());

        game = new Game();
        f.add(game, BorderLayout.CENTER);

        System.out.println(get_size());


        // START GAME
        // Creazione universo
        // ( Grandezza universo, Numero di persone attive )
        Universo mondo1 = new Universo(Variabile.Utenti, Variabile.UtentiAttivi);
        Tempo mondo = new Tempo(mondo1);
        mondo.setName("tempo");
        // Big Bang
        mondo.start();

        // TODO: DA CONTINUARE
        // https://stackoverflow.com/questions/11424180/drawing-with-graphics-and-with-widgets-in-japplet-swing


        f.add(new JLabel("<html> Da finire </html>", SwingConstants.CENTER ), BorderLayout.PAGE_START , 0 );



        NotizieLista.setPreferredSize(new Dimension(200, 250));
        NotizieLista.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        f.add(NotizieLista, BorderLayout.WEST ,0);
        start_game();

        Notizie.setText("Persone attive: " + mondo1.get_size());

        mondo1.posizionaUtenti();

        game.posizionaUtenti(game.getGraphics());

        game.getGraphics().drawRect(10,10,10,10);


    }

    public static Vector<Integer> get_size(){
        Vector<Integer> grandezza = new Vector<>();
        // TODO: sistemare game.getSize()
        //grandezza.add(game.getSize().width);  // X
        //grandezza.add(game.getSize().height); // y
        grandezza.add(824);
        grandezza.add(512);

        return grandezza;
    }

    private static void start_game(){

        game.paintComponent(game.getGraphics());
        //System.out.println(get_size());




    }

}
