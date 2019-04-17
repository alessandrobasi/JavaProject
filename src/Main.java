public class Main {


    public static void main(String[] args){

        int Utenti = 99;

        for(int i = 0; i< args.length; i++){
            if(args[i].startsWith("-")){
                switch (args[i]){

                    case "-U":
                        try{
                            Utenti = Integer.parseInt(args[i+1]);
                        }
                        catch (NumberFormatException e){
                            ;
                        }
                        break;
                    default:
                        continue;

                }
            }
            else {
                continue;
            }

        }


        Arena round = new Arena();

        round.bulk_add(Utenti);

        System.out.println( round.get_size() );




    }

}
