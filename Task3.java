import java.io.*;
import java.nio.charset.Charset;

public class Task3 {
    public static void subtask1()
    {
        try {
            FileReader reader = new FileReader("T1.txt");
            FileWriter writer = new FileWriter("T2.txt");
            int c;
            while((c = reader.read()) != -1)
            {
                writer.write(c);
            }
            reader.close();
            writer.close();
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }

    public static void subtask2()
    {
        try
        {
            BufferedReader inb = new BufferedReader(new FileReader("A.txt"));
            BufferedWriter outb = new BufferedWriter(new FileWriter("B.txt"));
            char[] buffer = new char[128];
            while(inb.read(buffer) != -1)
            {
                System.out.println(new String(buffer));
                outb.write(buffer);
            }
            inb.close();
            outb.close();
        }catch(IOException e)
        {
            System.out.println(e.toString());
        }
    }

    public static void subtask3()
    {
        try
        {

            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("A_1.txt"), "Cp1251"));
            System.out.println(Charset.defaultCharset().name());
            String line;
            while((line = in.readLine()) != null)
            {
                System.out.println("Попытка чтения в windows-1251: "+line);
            }
            in = new BufferedReader(new InputStreamReader(new FileInputStream("A_1.txt"), "UTF8"));
            while((line = in.readLine()) != null)
            {
                System.out.println("Попытка чтения в UTF-8: "+line);
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        subtask1();
        subtask2();
        subtask3();
    }
}
