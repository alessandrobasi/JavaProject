package GlobalVar;

public class Variabile {

    /*
     * Variabili globali per la classe Universo
     *
     */
    // Utenti totali di Default
    public static int Utenti = 1000;  // -U
    // Utenti Attivi di Default
    public static int UtentiAttivi = 500;  // -L

    // Numero minimo di utenti per far esistere l'Universo
    public static int MinNumLife = 2;

    /*
     * Variabili globali per la classe Persona
     *
     */
    // Tempo di vita minimo di un utente
    public static int MinVita = 40;
    // Numero massimo di conoscenti che una Persona può avere
    public static int MaxNumConoscenti = 10;  // -C


    /*
     * Variabili globali di utlità
     *
     */
    // Delay del Tempo
    public static int DelayTempo = 500;   // -T

    public Variabile(){}

}
