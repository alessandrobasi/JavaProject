package universo;

public class Main {


    public static void main(String[] args){


        // Creazione universo
        // ( Grandezza universo, Numero di persone attive )
        Universo mondo1 = new Universo(1000,20);



        System.out.println( mondo1.get_size() );
        mondo1.add_life();

        System.out.println( mondo1.get_size() );




    }

}
