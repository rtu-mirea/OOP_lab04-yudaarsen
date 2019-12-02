import java.io.*;
import java.util.ArrayList;

public class FileController {
    private FileOutputStream out;
    private FileInputStream in;

    public FileController(String fileName) throws IOException
    {
        File file = new File(fileName);
        if(!file.exists())
            file.createNewFile();
        else
            System.out.println("Файл " + fileName + " существует.");
        out = new FileOutputStream(file);
        in = new FileInputStream(file);
    }

    public void writeObject(Entry entry) throws IOException
    {
        String line = entry.getName() + ";" + entry.getS_name() + ";" + entry.getPhoneNumber() + ";" +
                entry.getAddress() + ";" + entry.getBirthDate() + "\n";
        out.write(line.getBytes("utf8"));
    }

    public ArrayList<Entry> readObjects() throws IOException
    {
        ArrayList<Entry> list = new ArrayList<>();
        int c;
        StringBuilder line = new StringBuilder();
        while((c = in.read()) != -1)
        {
            if((char)c == '\n')
            {
                String[] lines = line.toString().split(";");
                list.add(new Entry(lines[0], lines[1], lines[2], lines[3], lines[4]));
                line.delete(0, line.length());
            }
            else
            {
                line.append((char)c);
            }
        }
        return list;
    }

    public void dispose() throws IOException
    {
        out.close();
        in.close();
    }

    public void rfFile(int num, String newSName, ArrayList<Entry> entries) throws IOException
    {
        RandomAccessFile file = new RandomAccessFile("tmp.txt", "rw");
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < entries.size(); i++)
        {
            str.append(entries.get(i).getName() + ";" + entries.get(i).getS_name() + ";" + entries.get(i).getPhoneNumber() + ";" +
                    entries.get(i).getAddress() + ";" + entries.get(i).getBirthDate() + "\n");
        }
        file.write(str.toString().getBytes("utf8"));
        int pos = str.toString().indexOf(entries.get(num).getName() + ";" + entries.get(num).getS_name());
        str.replace(pos + (entries.get(num).getName() + ";").length(),
                pos + (entries.get(num).getName() + ";" + entries.get(num).getS_name()).length(), newSName);
        file.seek(0);
        file.setLength(str.length());
        file.write(str.toString().getBytes("utf8"), 0, (int)file.length());
        file.close();
    }
}
