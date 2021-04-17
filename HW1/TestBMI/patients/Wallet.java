import java.util.Scanner;
import java.util.Random;

public class Wallet {

    int id = 0;
    String name = "hey";

    public Wallet() {
        this(0,"" );
    }

    public Wallet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int getId(){
        return this.id;
    }

    private String getName(){
        return this.name;
    }




    public static void main(String[] args){


        //System.out.println(wal1);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter one string value for name:\n");
        String Name = sc.nextLine();
        Random rand = new Random();

        int ID = (rand.nextInt(100)+100)*5;
        Wallet wal1 = new Wallet(ID, Name);

        System.out.printf("\n%s%d\n","ID: ",wal1.getId());
        System.out.printf("\n%s%s\n","Name: ",wal1.getName());
    }


}