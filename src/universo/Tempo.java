package universo;

import GlobalVar.Variabile;

import java.util.concurrent.TimeUnit;

public class Tempo extends Thread implements InterfaceTempo {

    private final Universo universo;

    public Tempo(Universo mondo){

        universo = mondo;

    }

    // Tempo
    @Override
    public boolean Tempo(){
        // Contatore delle persone vive nell'universo attivo
        int persone_vive  = 0;

        // Aspetta il Delay
        try {
            TimeUnit.MILLISECONDS.sleep( Variabile.DelayTempo );
        }
        catch (InterruptedException e){}

        // for-each utenti attivi, nell'universo attivo, diminuisci il loro TTL
        for(Persona io : universo.get_active_universe() ) {

            io.tempo_trascorso(); // diminuisci il temp di vita dell'utente di 1 tick

            // Conta se ci sono almeno 'Variabile.MinNumLife' persone vive
            if( persone_vive <= Variabile.MinNumLife && io.is_alive() ) {
                persone_vive += 1;
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


    @Override
    public void run(){

        while(Tempo()){

            // Eventi del mondo
            // Casualità

        }

    }

}
