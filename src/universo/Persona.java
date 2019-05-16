package universo;

import Errors.FullVectorException;
import GlobalVar.Variabile;

import java.util.AbstractMap.SimpleEntry;
import java.util.Random;
import java.util.List;
import java.util.Vector;
import java.util.Map.Entry;

public class Persona {
    // Variabili statiche (globali)
    // ID univoco di ogni utente
    private static int master_id = 0;

    private boolean is_alive = true; // Variabile per indicare se l'utente è in vita
    private int TTL; // Time to live, tempo di vita da Variabile.MinVita a 365 cicli
    private final int id; // ID di identitificazione da 0 a infinito

    // Conoscenti dell'utente
    private List< Entry<Persona, Integer> > Relation_board = new Vector<>();

    // Messaggi ricevuti dagli utenti - Profili
    private List< Integer > Messaggi = new Vector<>();

    // Feedback - risposta ai messaggi degli utenti
    private List< Integer> Feedback = new Vector<>();


    // Alla creazione dell'utente
    public Persona(){

        Random rand = new Random();

        // Assegno un numero univoco da 0 a infinito all'utente creato
        this.id = master_id++;

        // Genero un numero che indica quanto tempo vive l'utente
        this.TTL = rand.nextInt((365-Variabile.MinVita)) + Variabile.MinVita; // [Variabile.MinVita - 365]

        for (int i = 0; i< Variabile.MaxNumConoscenti; i++){
            this.Relation_board.add( null );
            this.Messaggi.add( null );
            this.Feedback.add( null );
        }

        // Inserisco nella lista delle relazioni, alla posizione 0 il benessere dell'utente
        this.Relation_board.set( 0,new SimpleEntry<>(this,rand.nextInt(100)) );


        // Umore iniziale dell'utente numero casuale tra 10 e 100
        this.Messaggi.set(0, (rand.nextInt( 90 ) + 10 ) );


        // ???? Feedback di se stesso ????
        this.Feedback.set(0,null);

    }


    // Printa le informazioni dell'utente
    public void get_info(){

        System.out.println("" +
                "In vita: " + is_alive + "\n" +
                "ID univoco: " + id + "\n" +
                "Tempo di vita rimanente: " + TTL + "\n" +
                "Benessere: " + Relation_board.get(0).getValue() + "\n" +
                "Umore: " + Messaggi.get(0) + "\n" );

    }


    // Aggiungi conoscente nelle relazioni
    public synchronized void add_acquaintances(Persona conoscente) throws FullVectorException {

        // Se l'utente è vivo
        if (this.is_alive) {
            Random rand = new Random();

            int i = rand.nextInt((Variabile.MaxNumConoscenti-1)) + 1;

            boolean check = true;
            for (int k = 1; k<Variabile.MaxNumConoscenti; k++){
                if (Relation_board.get(i) != null){
                    i = rand.nextInt((Variabile.MaxNumConoscenti-1)) + 1;
                }
                else{
                    check = false;
                    break;
                }
            }
            if (check){
                throw new Errors.FullVectorException("Conoscenti Pieni");
            }



            // Aggiungi la coppia <Utente posizione> alla lista dei conoscenti
            if (conoscente.is_alive()) {
                int j = conoscente.run_acquaintances(this, i);

                Relation_board.set(i, new SimpleEntry<>(conoscente, j));


            }

        }
    }


    // Aggiungi al conoscente la relazione alla posizione j di <Persona,i> ritorna j
    public synchronized int run_acquaintances(Persona conoscente, int i) throws FullVectorException {
        Random rand = new Random();

        int j = rand.nextInt((Variabile.MaxNumConoscenti-1)) + 1;

        boolean check = true;
        for (int k = 1; k<Variabile.MaxNumConoscenti; k++){
            if (Relation_board.get(j) != null){
                j = rand.nextInt((Variabile.MaxNumConoscenti-1)) + 1;
            }
            else{
                check = false;
                break;
            }
        }
        if (check){
            throw new Errors.FullVectorException("Conoscenti Pieni");
        }



        Relation_board.set(j, new SimpleEntry<>(conoscente, i));

        return j;
    }


    // Ritorna la lista delle relazioni che l'utente ha  ????
    public List< Entry<Persona, Integer> > get_Relations(){
        return Relation_board;
    }

    public List< Integer > get_Messaggi(){
        return Messaggi;
    }

    /*
    * finire queste funzioni per il dialogo delle persone
    *
    */

    // Invia messaggi (numero -> Relation.Utente -> Relation.Utente.Messaggi) ai suoi conoscenti
    public void Parla(){

        Random rand = new Random();

        // Per ogni persona nella lista dei conoscenti manda un messaggio ad ogni conoscente,
        // il messaggio viene generato in base all'umore di chi invia il messaggio e un numero casuale per prendere il valore del msg
        for (Entry<Persona, Integer> coppia : Relation_board.subList(1,Variabile.MaxNumConoscenti) ){

            if (coppia != null){
                // Prendi la classe dell'utente da quella chiama la classe get_msg, gli viene passato l'index dell'utente che sta inviando il msg e il msg
                // il msg viene generato in base all'umore dell'utente che lo invia
                coppia.getKey().get_msg(coppia.getValue(), Umore.Gen( Relation_board.get(0).getValue(), rand.nextInt(100)) );

            }

        }

    }

    // L'utente prende il messaggio ricevuto (setta la posizione nella lista Messaggi) ed elabora una risposta
    public void get_msg(int index, int msg){
        Messaggi.set(index, msg);
        Lavora_MSG();
    }

    // Prende il messaggio (numero -> ELABORO -> this.Feedback) ricevuto
    public void Lavora_MSG(){

    }

    // Prende il messaggio (Relation.Utente.Feedback -> numero -> this.Messaggi || ELABORO ) di risposta
    public void Risposta(){

    }




    // Modifica dei valori nel Tempo
    public synchronized void tempo_trascorso(){

        // Se l'utente è vivo
        if (this.is_alive){

            // Diminuisci il suo tempo di vita
            this.TTL -= 1;

            // ???? Controlla per utenti morti nelle relazioni ????

            // Se l'utente ha finito il suo tempo
            if (this.TTL <= 0){
                // Segna come morto
                this.is_alive = false;

                // Annuncia il decesso
                System.out.println("Utente " + this.id + " è morto");

                // ???? Avvisa i conoscenti ????

            }

        }

    }

    // Restituisce true o false se l'utente è vivo o meno
    public boolean is_alive(){
        return is_alive;
    }

}
