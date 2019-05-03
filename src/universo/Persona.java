package universo;

import Errors.FullVectorException;
import GlobalVar.Variabile;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.Random;
import java.util.List;
import java.util.Vector;
import java.util.Map.Entry;

public class Persona {
    // Variabili statiche (globali)
    private static int master_id = 0;

    private boolean is_alive = true; // Variabile per indicare se l'utente è in vita
    private int TTL; // Time to live, tempo di vita da Variabile.MinVita a 365 cicli
    private int id; // ID di identitificazione da 0 a infinito

    // Conoscenti
    private List< Entry<Persona, Integer> > Relation_board = new Vector<>();

    // Messaggi
    private List<Integer> Messaggi = new Vector<>();

    // Feedback
    private List<Integer> Feedback = new Vector<>();


    // Alla creazione dell'utente
    public Persona(){
        Random rand = new Random();

        // Assegno un numero univoco da 0 a infinito all'utente creato
        this.id = master_id++;

        // Genero un numero che indica quanto tempo vive l'utente
        this.TTL = rand.nextInt((365-Variabile.MinVita)) + Variabile.MinVita; // [Variabile.MinVita - 365]

        for (int i = 0; i< Variabile.MaxNumConoscenti; i++){
            this.Relation_board.add( null );
        }

        // Inserisco nella lista delle relazioni, alla posizione 0 l'utente stesso
        this.Relation_board.add( 0,new SimpleEntry<>(this,0) );

    }

    // Printa le informazioni dell'utente
    public void get_info(){
        System.out.println("In vita: " + is_alive + "\nID: " + id + "\nTTL: " + TTL);
    }

    // Aggiungi conoscente nelle relazioni
    public synchronized void add_acquaintances(Persona conoscente) throws FullVectorException {

        // Se l'utente è vivo
        if (this.is_alive) {
            Random rand = new Random();

            int i = rand.nextInt((Variabile.MaxNumConoscenti-1)) + 1;

            boolean check = true;
            for (i = 1; i<Variabile.MaxNumConoscenti; i++){
                if (Relation_board.get(i) != null){
                    i = rand.nextInt((Variabile.MaxNumConoscenti-1)) + 1;
                }
                else{
                    check = !check;
                    break;
                }
            }
            if (check){
                throw new Errors.FullVectorException("Conoscenti Pieni");
            }



            // Aggiungi la coppia <Utente posizione> alla lista dei conoscenti
            if (conoscente.is_alive()) {
                int j = conoscente.run_acquaintances(this, i);

                Relation_board.add(i, new SimpleEntry<>(conoscente, j));


            }

        }
    }

    // Aggiungi al conoscente la relazione alla posizione j di <Persona,i> ritorna j
    public synchronized int run_acquaintances(Persona conoscente, int i) throws FullVectorException {
        Random rand = new Random();

        int j = rand.nextInt((Variabile.MaxNumConoscenti-1)) + 1;

        boolean check = true;
        for (i = 1; i<Variabile.MaxNumConoscenti; i++){
            if (Relation_board.get(i) != null){
                i = rand.nextInt((Variabile.MaxNumConoscenti-1)) + 1;
            }
            else{
                check = !check;
                break;
            }
        }
        if (check){
            throw new Errors.FullVectorException("Conoscenti Pieni");
        }



        Relation_board.add(j, new SimpleEntry<>(conoscente, i));

        return j;
    }

    // Mostra la lista delle relazioni che l'utente ha
    public List< Entry<Persona, Integer> > get_Relations(){
        return Relation_board;
    }


    /*
    * finire queste funzioni per il dialogo delle persone
    *
    */
    public void Parla(){

    }

    public void Rispondi(){

    }

    public void Risposta(){

    }


    // Modifica dei valori nel Tempo
    public synchronized void tempo_trascorso(){

        // Se l'utente è vivo
        if (this.is_alive){

            // Diminuisci il suo tempo di vita
            this.TTL -= 1;

            // Se l'utente ha finito il suo tempo
            if (this.TTL <= 0){
                // Segna come morto
                this.is_alive = false;

                // Annuncia il decesso
                System.out.println("Utente " + this.id + " è morto");
            }

        }

    }

    // Restituisce true o false se l'utente è vivo o meno
    public boolean is_alive(){
        return is_alive;
    }

}
