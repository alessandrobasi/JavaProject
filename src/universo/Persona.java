package universo;

import java.util.Random;
import java.util.List;
import java.util.Vector;

public class Persona {

    private static int master_id = 0;

    private boolean is_alive = true;
    private int TTL; // Time to live, tempo di vita da 35 a 365 cicli
    private int id; // ID di identitificazione da 0 a infinito
    private List<Persona> acquaintances = new Vector<>(); // Conoscenti


    public Persona(){
        Random rand = new Random();

        this.id = master_id++;
        this.TTL = rand.nextInt(330) + 35; // [35 - 365]

        this.acquaintances.add(this);

    }


    public void get_info(){
        System.out.println("ID: " + id + "\nTTL: " + TTL);
    }


    public void add_acquaintances(Persona conoscente){



    }


    public void tempo_trascorso(){

        if (this.is_alive){

            this.TTL -= 1;

            if (this.TTL <= 0){
                this.is_alive = false;
                System.out.println("Utente " + this.id + " è morto");
            }

        }

    }

    public boolean is_alive(){
        return is_alive;
    }

}
