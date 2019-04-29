
/*
 * A Social Game System (SGS)
 *
 * Argomenti programma:
 *
 * -?          : Mostra l'help
 * -U [numero] : Imposta un valore per il numero massimo di utenti nell'iniverso     ( Default: 1000 )
 * -L [numero] : Imposta un valore per il numero di utenti attivi all'avvio          ( Default: 500  )
 *
 *///A Social Game System (SGS)

import universo.Universo;
import GlobalVar.Variabile;

public class Main {

    public static void main(String[] args){

        // Program Arguments
        // -U [Numero] : Utenti da mettere nell'arena
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
                    case "-?":
                        System.out.println("Argomenti disponibili\n"+"-? : Mostra questo help\n"+"-U : Utenti da mettere nell'arena\n");
                        return;
                    default:
                        break;

                }
            }

        }



        // Creazione universo
        // ( Grandezza universo, Numero di persone attive )
        Universo mondo1 = new Universo(Variabile.Utenti, Variabile.UtentiAttivi);



        System.out.println( mondo1.get_size() );

        //mondo1.get_persona(2).get_info();



        while(mondo1.Tempo()){



        }

    }

}
