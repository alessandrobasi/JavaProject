package universo;

import GlobalVar.Variabile;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class Universo {
    
    
    List<Persona> elementi = new Vector<>();
    

    // Dio ( Spazio )
    public Universo(){

        for(int i = 0; i<1000; i++){

            elementi.add( new Persona() );

        }
    }

    public Universo(int n){


        Variabile.UtentiAttivi = n/2;

        for(int i = 0; i<n; i++){

            elementi.add( new Persona() );

        }
    }

    public Universo(int n, int LifeLimit){

        if(LifeLimit > n){
            Variabile.UtentiAttivi = n/2;
        }
        else{
            Variabile.UtentiAttivi = LifeLimit;
        }


        for(int i = 0; i<n; i++){

            elementi.add( new Persona() );

        }
    }

    // Tempo
    public boolean Tempo(){

        int persone_vive  = 0;

        try {
            TimeUnit.MILLISECONDS.sleep(500);
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
