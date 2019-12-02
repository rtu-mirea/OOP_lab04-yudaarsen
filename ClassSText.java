//ClassSText.java
import java.io.*;
import java.util.LinkedList;

public class ClassSText {
    private File path;
    private LinkedList<Parlay> list;
    private FileOutputStream out;
    private ObjectOutputStream o_out;
    private FileInputStream in;
    private ObjectInputStream o_in;

    public ClassSText(String path) throws IOException {
        this.path = new File(path);
        out = new FileOutputStream(this.path);
        o_out = new ObjectOutputStream(out);
        in = new FileInputStream(this.path);
        o_in = new ObjectInputStream(in);
        list = new LinkedList<>();
    }

    public void writeObject(Parlay parlay) throws IOException
    {
        o_out.writeObject(parlay);
    }

    public Parlay readObject() throws ClassNotFoundException, IOException
    {
        return (Parlay)o_in.readObject();
    }

    public Parlay getParlay(int index)
    {
        return list.get(index);
    }

    public void writeAll() throws IOException
    {
        for(Parlay p : list)
        {
            writeObject(p);
        }
    }

    public void readAll() throws IOException, ClassNotFoundException {
        try {
            while (true) {
                list.add(readObject());
            }
        } catch (EOFException e)
        {
            System.out.println("All objects are read");
        }
    }

    public LinkedList<Parlay> getList()
    {
        return list;
    }

    public void print()
    {
        for(Parlay p : list)
        {
            System.out.println(p.getHorse() + " " + p.getSum());
        }
    }
}
