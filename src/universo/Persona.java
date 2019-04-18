package universo;

import java.util.Random;

public class Persona {

    private static int master_id = 0;

    private int TTL;
    private int id;

    Random rand = new Random();

    public Persona(){
        this.id = master_id++;
        this.TTL = rand.nextInt(330) + 35; // [35 - 365]
    }


    public void get_info(){
        System.out.println("ID: " + id);
    }

}
