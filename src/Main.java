
/*
 * A Social Game System (SGS)
 *
 * Argomenti programma:
 *
 * -?                : Mostra l'help
 * -U [numero]       : Imposta un valore per il numero massimo di utenti nell'iniverso     ( Default: 1000 )
 * -L [numero]       : Imposta un valore per il numero di utenti attivi all'avvio          ( Default: 500  )
 * -C [numero]       : Imposta un valore per il numero di conoscenti massimi               ( Default: 10   )
 * -T [millisecondi] : Imposta un valore per la lentezza del tempo                         ( Default: 500  )
 *
 *///A Social Game System (SGS)

import universo.Tempo;
import universo.Universo;
import GlobalVar.Variabile;

public class Main {

    public static void main(String[] args){

        // Program Arguments
        for(int i = 0; i< args.length; i++){

            if(args[i].startsWith("-")){
                switch (args[i]){

                    case "-U":
                        try{
                            Variabile.Utenti = Integer.parseInt(args[i+1]);
                        }
                        catch (NumberFormatException e){
                            Variabile.Utenti = 99;
                        }
                        break;
                    case "-L":
                        try{
                            Variabile.UtentiAttivi = Integer.parseInt(args[i+1]);
                        }
                        catch (NumberFormatException e){
                            Variabile.UtentiAttivi = Variabile.Utenti/2;
                        }
                        break;
                    case "-C":
                        try{
                            Variabile.MaxNumConoscenti = Integer.parseInt(args[i+1]);
                        }
                        catch (NumberFormatException e){
                            Variabile.MaxNumConoscenti = 10;
                        }
                        break;
                    case "-T":
                        try{
                            Variabile.DelayTempo = Integer.parseInt(args[i+1]);
                        }
                        catch (NumberFormatException e){
                            Variabile.DelayTempo = 500;
                        }
                        break;
                    case "-?":
                        System.out.println(" * \n" +
                                " * A Social Game System (SGS)\n" +
                                " *\n" +
                                " * Argomenti programma:\n" +
                                " *\n" +
                                " * -?                : Mostra l'help\n" +
                                " * -U [numero]       : Imposta un valore per il numero massimo di utenti nell'iniverso     ( Default: 1000 )\n" +
                                " * -L [numero]       : Imposta un valore per il numero di utenti attivi all'avvio          ( Default: 500  )\n" +
                                " * -C [numero]       : Imposta un valore per il numero di conoscenti massimi               ( Default: 10   )\n" +
                                " * -T [millisecondi] : Imposta un valore per la lentezza del tempo                         ( Default: 500  )\n" +
                                " * \n");
                        return;
                    default:
                        break;

                }
            }

        }



        // Creazione universo
        // ( Grandezza universo, Numero di persone attive )
        Universo mondo1 = new Universo(Variabile.Utenti, Variabile.UtentiAttivi);

        System.out.println("Persone attive: " + mondo1.get_size() );

        Tempo mondo = new Tempo(mondo1);
        mondo.setName("tempo");

        // Big Bang
        mondo.start();




    }

}
