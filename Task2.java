import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    private static Entry[] entries;

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            FileController controller = new FileController("file.txt");
            System.out.print("Enter count of entries: ");
            int count = scanner.nextInt();
            if(count <= 0)
            {
                System.out.println("Incorrect count");
                System.exit(1);
            }
            entries = new Entry[count];
            scanner.nextLine();
            for(int i = 0; i < count; i++)
            {
                System.out.println("Введите имя, фамилию, номер телефона, адрес и дату рождения записи номер " + i);
                String tmp = scanner.nextLine();
                String[] fields = tmp.split(" ");
                entries[i] = new Entry(fields[0], fields[1], fields[2], fields[3],fields[4]);
                System.out.println("Объекс создан: " + entries[i].getName() + " " + entries[i].getS_name() + " " +
                        entries[i].getPhoneNumber() + " " + entries[i].getAddress() + " " + entries[i].getBirthDate());
                controller.writeObject(entries[i]);
            }
            ArrayList<Entry> list = controller.readObjects();
            System.out.println("Результат:");
            ArrayList<String> s_names = new ArrayList<>();
            ArrayList<Entry> res = new ArrayList<>();
            for(int i = 0; i < list.size(); i++)
            {
                String s_name = list.get(i).getS_name();
                String name = list.get(i).getName();
                for(int j = i + 1; j < list.size(); j++)
                {
                    if(list.get(j).getS_name().equals(s_name) && !list.get(j).getName().equals(name) && !s_names.contains(s_name))
                    {
                        s_names.add(s_name);
                        System.out.println(list.get(i).getName() + " " + list.get(i).getS_name() + " " + list.get(i).getPhoneNumber() + " " +
                                list.get(i).getAddress() + " " + list.get(i).getBirthDate());
                        System.out.println(list.get(j).getName() + " " + list.get(j).getS_name() + " " + list.get(j).getPhoneNumber() + " " +
                                list.get(j).getAddress() + " " + list.get(j).getBirthDate());
                        res.add(list.get(i));
                        res.add(list.get(j));
                    }
                }
            }
            System.out.println("Введите номер записи в которой заменить фамилию: ");
            int num = scanner.nextInt() - 1;
            System.out.println("Введите новую фамилию:");
            scanner.nextLine();
            String newSname = scanner.nextLine();
            controller.rfFile(num, newSname, res);
            System.out.println("Введите имя и фамилию:");
            String[] ns = scanner.nextLine().split(" ");
            getNumberByName(ns[0], ns[1]);
            System.out.println("Введите номера записей:");
            isAdressEqual(entries[scanner.nextInt() - 1], entries[scanner.nextInt() - 1]);
        }catch (IOException e)
        {
            System.out.println(e.toString());
        }
    }

    public static void getNumberByName(String name, String s_name)
    {
        boolean res = false;
        for(Entry e : entries)
        {
            if(e.getName().equals(name) && e.getS_name().equals(s_name))
            {
                System.out.println("Номер телефона " + name +  " " + s_name  + " : " + e.getPhoneNumber());
                res = true;
                break;
            }
        }
        if(!res)
        {
            System.out.println("Совпадений не найдено");
        }
    }

    public static void isAdressEqual(Entry e1, Entry e2)
    {
        if(e1.getAddress().equals(e2.getAddress()))
            System.out.println(e1.getName() + " " + e1.getS_name() + " и " + e2.getName() + " " + e2.getS_name() + " проживают по одному адресу.");
        else
            System.out.println(e1.getName() + " " + e1.getS_name() + " и " + e2.getName() + " " + e2.getS_name() + " не проживают по одному адресу.");
    }
}
