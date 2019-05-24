package universo;

import Errors.FullVectorException;

import java.util.List;
import java.util.Map;

public interface InterfacePersona {
    // Printa le informazioni dell'utente
    void get_info();

    // Aggiungi conoscente nelle relazioni
    void add_acquaintances(Persona conoscente) throws FullVectorException;

    // Aggiungi al conoscente la relazione alla posizione j di <Persona,i> ritorna j
    int run_acquaintances(Persona conoscente, int i) throws FullVectorException;

    // Ritorna la lista delle relazioni che l'utente ha  ????
    List<Map.Entry<Persona, Integer>> get_Relations();

    List< Integer > get_Messaggi();

    List< Integer > get_Feedback();

    // Invia messaggi (numero -> Relation.Utente -> Relation.Utente.Messaggi) ai suoi conoscenti
    void Parla();

    // L'utente prende il messaggio ricevuto (setta la posizione nella lista Messaggi) ed elabora una risposta
    void get_msg(int index, int msg);

    // Prende il messaggio (numero -> ELABORO -> this.Feedback) ricevuto e genera una risposta
    void Lavora_MSG(int index, int msg);

    // Prende il messaggio (Relation.Utente.Feedback -> numero -> this.Messaggi || ELABORO ) di risposta
    void Risposta();

    // Modifica dei valori nel Tempo
    void tempo_trascorso();

    // Restituisce true o false se l'utente è vivo o meno
    boolean is_alive();
}
