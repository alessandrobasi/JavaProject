package universo;

import Errors.FullVectorException;
import GlobalVar.Variabile;
import Relation_board.Relation_board;

import java.security.PublicKey;

public class Start {



    public static void main(String[] args){

        Persona numero1 = new Persona();

        Persona numero2 = new Persona();

        numero1.get_info();

        numero2.get_info();

        try {
            numero1.add_acquaintances(numero2);
        }
        catch (FullVectorException e){
            ;
        }

        numero1.Parla();
        numero2.Parla();

        System.out.println( numero1.get_Relations() );

        System.out.println( numero1.get_Messaggi() );

        System.out.println( numero2.get_Relations() );



        System.out.println( numero2.get_Messaggi() );

    }

}
