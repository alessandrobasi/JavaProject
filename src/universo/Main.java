package universo;

import Errors.FullVectorException;
import Relation_board.Relation_board;

public class Main {


    public static void main(String[] args){

        Persona numero1 = new Persona();

        Persona numero2 = new Persona();

        numero1.get_info(true);

        numero2.get_info(true);


        try {
            numero1.add_acquaintances(numero2);
        } catch (FullVectorException e) {

        }

        Relation_board board1 = new Relation_board(numero1);
        Relation_board board2 = new Relation_board(numero2);


        /*

        // Creazione universo
        // ( Grandezza universo, Numero di persone attive )
        Universo mondo1 = new Universo(1000,20);



        System.out.println( mondo1.get_size() );
        mondo1.add_life();

        System.out.println( mondo1.get_size() );


        */

    }

}