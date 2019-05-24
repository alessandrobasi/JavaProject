package universo;

import java.util.List;

public interface InterfaceUniverso {
    // Incrementa l'universo attivo di 1 (Aggiungi un nuovo utente)
    void add_life();

    // Ritorna gli utenti attivi dell'universo
    List<Persona> get_active_universe();

    // Ritorna il numero di utenti attivi
    int get_size();

    // Ritorna la classe della persona contenuta nell'universo attivo all'indice i
    // se l'indice non è presente nell'universo attivo, genera un eccezione
    Persona get_persona(int i) throws NullPointerException;
}
