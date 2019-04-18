
/*
 * A Social Game System (SGS)
 *
 *
 *
 */

import universo.Universo;

public class Main {


    public static void main(String[] args){

        int Utenti = 1000;
        int Limite = 500;

        // Program Arguments
        // -U [Numero] : Utenti da mettere nell'arena
        for(int i = 0; i< args.length; i++){
            if(args[i].startsWith("-")){
                switch (args[i]){

                    case "-U":
                        try{
                            Utenti = Integer.parseInt(args[i+1]);
                        }
                        catch (NumberFormatException e){
                            Utenti = 99;
                        }
                        break;
                    case "-L":
                        try{
                            Limite = Integer.parseInt(args[i+1]);
                        }
                        catch (NumberFormatException e){
                            Limite = Utenti/2;
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
        Universo mondo1 = new Universo(Utenti,Limite);



        System.out.println( mondo1.get_size() );
        mondo1.add_life();

        System.out.println( mondo1.get_size() );




    }

}
