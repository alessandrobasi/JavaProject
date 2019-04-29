package universo;

import GlobalVar.Variabile;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class Universo {
    
    // Lista di tutte le persone (all'inizio vuota)
    List<Persona> elementi = new Vector<>();
    

    // Dio ( Spazio )  Costruttori per creare l'universo e inizializzare la lista di utenti (Default: 1000 / di cui attivi: 500 )
    public Universo(){
        // Creazione utenti
        for(int i = 0; i < Variabile.Utenti; i++){

            elementi.add( new Persona() );

        }
    }

    public Universo(int n){
        // Creazione utenti
        Variabile.Utenti = n;
        Variabile.UtentiAttivi = n/2;


        for(int i = 0; i < Variabile.Utenti; i++){

            elementi.add( new Persona() );

        }
    }

    public Universo(int n, int LifeLimit){
        // Creazione utenti

        // Verifico se i numero immessi sono superiori a 0
        // se non è superiore a 0 impostalo a 1000
        if ( !(n > 0) ){
            Variabile.Utenti = 1000;
        }
        else {
            // Altrimenti assegnalo a Utenti
            Variabile.Utenti = n;
        }

        // Se il numero di utenti in vita è inferiore a 0
        // impostalo alla metà degli utenti
        if ( !(LifeLimit > 0) ) {
            Variabile.UtentiAttivi = Variabile.Utenti/2;
        }

        // Se il numero di utenti attivi supera quello degli utenti totali
        // ridimensiona il numero di utenti attivi
        if(LifeLimit > n){
            Variabile.UtentiAttivi = Variabile.Utenti/2;
        }
        else{
            Variabile.UtentiAttivi = LifeLimit;
        }



        for(int i = 0; i < Variabile.Utenti; i++){

            elementi.add( new Persona() );

        }
    }

    // Tempo
    public boolean Tempo(){
        // Contatore delle persone vive nell'universo attivo
        int persone_vive  = 0;

        // Aspetta 500 milli secondi
        try {
            TimeUnit.MILLISECONDS.sleep( Variabile.DelayTempo );
        }
        catch (InterruptedException e){}

        for(Persona io : get_active_universe()){ // for-each utenti attivi, diminuisci il TTL
            io.tempo_trascorso(); // diminuisci il temp di vita di ogni utente di 1
            if( persone_vive <= Variabile.MinNumLife && io.is_alive() ){ // conta se ci sono almeno 'num_minimo_persone' persone vive
                persone_vive+=1;
            }
        }

        // End game
        // Se c'è una sola persona il gioco finisce
        if(persone_vive < Variabile.MinNumLife ){
            System.out.println("Gioco finito, il mondo è morto, non ci sono abbastanza persone");
            return false;
        }

        // Continue game
        // Se ci sono 'num_minimo_persone' o più persone il gioco continua
        return true;

    }



    public void add_life(){
        Variabile.UtentiAttivi += 1;
    }

    public List<Persona> get_active_universe(){
        return elementi.subList(0, Variabile.UtentiAttivi );
    }

    public int get_size(){

        return elementi.subList(0, Variabile.UtentiAttivi ).size();

    }

    public Persona get_persona(int i){
        try{
            return get_active_universe().get(i);
        }
        catch (IndexOutOfBoundsException  e){
            return get_active_universe().get(0);
        }

    }



}
