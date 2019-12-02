//Task4.java
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        try {
            ClassTextFile ctf = new ClassTextFile("parlay.txt");
            Scanner in = new Scanner(new File("parlay.txt"));
            Parlay obj = ctf.getObj(in);
            System.out.println(obj.getHorse() + " " + obj.getSum());
            ClassSText cs = new ClassSText("parlay.txt");
            cs.writeObject(new Parlay("h1", 100));
            cs.writeObject(new Parlay("h2", 1));
            cs.writeObject(new Parlay("h3", 80));
            System.out.println(cs.readObject().getHorse());
            cs.readAll();
            cs.print();
        }catch(IOException | ClassNotFoundException e)
        {
            System.out.println(e.toString());
        }
    }
}
