package universo;

import java.util.List;
import java.util.Vector;


public class Universo {

    private int LifeLimit;
    private List<Persona> elementi = new Vector<>();

    // Dio
    public Universo(){

        this.LifeLimit = 500;

        for(int i = 0; i<1000; i++){

            elementi.add( new Persona() );

        }
    }

    public Universo(int n){

        this.LifeLimit = n/2;

        for(int i = 0; i<n; i++){

            elementi.add( new Persona() );

        }
    }

    public Universo(int n, int LifeLimit){

        if(LifeLimit > n){
            this.LifeLimit = n/2;
        }
        else{
            this.LifeLimit = LifeLimit;
        }


        for(int i = 0; i<n; i++){

            elementi.add( new Persona() );

        }
    }



    public void add_life(){
        this.LifeLimit += 1;
    }

    public List<Persona> get_active_universe(){
        return elementi.subList(0, this.LifeLimit);
    }

    public int get_size(){

        return elementi.subList(0, this.LifeLimit).size();

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
