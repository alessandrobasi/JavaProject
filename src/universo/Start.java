package universo;

import Relation_board.Relation_board;

public class Start {



    public static void main(String[] args){

        Persona numero1 = new Persona();

        Persona numero2 = new Persona();

        numero1.get_info();

        numero2.get_info();


        numero1.add_acquaintances(numero2);

        Universo a = new Universo(10);

        System.out.println( a.get_size() );



    }

}
