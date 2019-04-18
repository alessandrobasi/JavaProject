package universo;

import java.util.Random;
import java.util.List;
import java.util.Vector;

public class Persona {

    private static int master_id = 0;

    private int TTL;
    private int id;
    private List<Persona> acquaintances = new Vector<>();


    public Persona(){
        Random rand = new Random();

        this.id = master_id++;
        this.TTL = rand.nextInt(330) + 35; // [35 - 365]

        this.acquaintances.add(this);

    }


    public void get_info(){
        System.out.println("ID: " + id);
    }

}
