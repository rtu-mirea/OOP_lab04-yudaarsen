//Task1.java

import java.io.File;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args)  {
        try {
            //Исследовать возможности класса File по созданию файлов (пустых) и папок программой. Применение конструктора и метода.
            File file1 = new File("MyFile1.txt");
            if (file1.createNewFile())
                System.out.println("Файл MyFile1.txt создан");
            else
                System.out.println("Файл MyFile1.txt не создан");
            File file2 = new File("C:\\MyFile2.txt");
            if (file2.createNewFile())
                System.out.println("Файл MyFile2.txt создан");
            else
                System.out.println("Файл MyFile2.txt не создан");
            File dir1 = new File("C:\\tmp_lab");
            dir1.mkdir();
            File file3 = new File("C:\\tmp_lab\\MyFile3.txt");
            if (file3.createNewFile())
                System.out.println("Файл MyFile3.txt создан");
            else
                System.out.println("Файл MyFile3.txt не создан");
            File dir3 = new File("C:\\tmp_lab\\tmp");
            dir3.mkdir();
            File file4 = new File("C:\\tmp_lab\\tmp\\MyFile4.txt");
            if (file4.createNewFile())
                System.out.println("Файл MyFile4.txt создан");
            else
                System.out.println("Файл MyFile4.txt не создан");
            //Получить параметры файлов методами класса File.
            //В пунктах задания использовать объекты, созданные в задании 1
            if(file1.isFile())
            {
                System.out.println(file1.getName() + "  " + file1.getParent());
            }
            if(dir1.isDirectory())
            {
                System.out.println(dir1.getName());
            }
            if(new File("MyFile1.txt").exists())
                System.out.println("MyFile1.txt существует в папке");
            else
                System.out.println("MyFile1.txt не существует в папке");
            System.out.println(file1.getAbsolutePath());
            System.out.println(file1.length() + " bytes");
            //Модификация файловой структуры приложения средствами класса File.
            File dir2 = new File("tmp");
            dir2.mkdir();
            for(String f : new File("").getAbsoluteFile().list())
            {
                System.out.println(f);
            }
            int count = 0;
            for(File f : new File("").getAbsoluteFile().listFiles())
            {
                if(f.isDirectory())
                    count++;
                System.out.println(f.getName());
            }
            System.out.println("Count of dirs is " + count);
            file4.delete();
            file3.delete();
            file2.delete();
            file1.delete();
            dir3.delete();
            dir2.delete();
            dir1.delete();
        }catch (IOException e)
        {
            System.out.println(e.toString());
        }

    }
}
