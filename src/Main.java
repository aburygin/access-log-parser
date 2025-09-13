import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int filePathCorrect = 0;

        while (true) {
            System.out.println("Введите путь до файла: ");
            String path = scanner.nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean fileIsDirectory = file.isDirectory();

            if (!fileExists || fileIsDirectory) {
                if (!fileExists) {
                    System.out.println("Файл не существует: " + path);
                } else {
                    System.out.println("Указанный путь ведет к папке: " + path);
                }
                System.out.println("----------------------");
                continue;
            }

            System.out.println("Путь указан верно");
            filePathCorrect++;
            System.out.println("Это файл номер " + filePathCorrect);
            System.out.println("----------------------");
        }
    }
}