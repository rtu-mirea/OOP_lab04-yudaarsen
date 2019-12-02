//ClassTextFile.java
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ClassTextFile {
    private File path;

    public ClassTextFile(String path) throws IOException {
        this.path = new File(path);
        if(!this.path.exists())
        {
            System.out.println("Файл не существует. Файл будет создан.");
            this.path.createNewFile();
        }
        else
        {
            System.out.println("Файл существует.");
        }
    }

    public Parlay getObj(Scanner scanner) {
        String horse = scanner.nextLine();
        int sum = scanner.nextInt();
        return new Parlay(horse, sum);
    }
}
