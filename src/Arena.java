import universo.Persona;

import java.util.List;
import java.util.Vector;

public class Arena {

    private List<Persona> elementi = new Vector<Persona>();


    public Arena(){
        ;
    }


    public void add(){

        elementi.add( new Persona() );

    }

    public void bulk_add(int n){

        for(int i = 0; i<n; i++){

            elementi.add( new Persona() );

        }

    }

    public int get_size(){

        return elementi.size();

    }



}
