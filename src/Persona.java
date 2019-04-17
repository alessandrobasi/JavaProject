public class Persona {

    private static int master_id = 0;

    private int id;

    public Persona(){
        this.id = master_id++;
    }

    public void get_info(){
        System.out.println(id);
    }

}
