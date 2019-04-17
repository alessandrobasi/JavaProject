public class Main {


    public static void main(String[] args){

        int Utenti = 99;

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
                    case "-?":
                        System.out.println("Argomenti disponibili\n"+"-? : Mostra questo help\n"+"-U : Utenti da mettere nell'arena\n");
                        break;
                    default:
                        break;

                }
            }

        }


        // Creazione arena
        Arena round = new Arena();

        // Aggiunta utenti
        // Numero di default: 99
        // Numero variabile:  Utenti
        round.bulk_add(Utenti);

        //
        System.out.println( round.get_size() );




    }

}
