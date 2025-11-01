import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
//C:\Users\ user\Desktop\учеба\access.log
//C:\Users\ user\Desktop\учеба\longAccess.log тут ждем ошибку



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

            // Читаем файлы, анализируем длину строк
            try {
                FileReader fileReader = new FileReader(path);
                BufferedReader reader = new BufferedReader(fileReader);

                int totalLines = 0;
                int longestLine = 0;
                int shortestLine = Integer.MAX_VALUE;
                String line;

                while ((line = reader.readLine()) != null) {
                    int length = line.length();


                    if (length > 1024) {
                        throw new LineTooLongException(
                                "Обнаружена строка длиннее 1024 символов. Длина строки: " + length +
                                        ". Строка номер: " + (totalLines + 1)
                        );
                    }

                    totalLines++;

                    if (length > longestLine) {
                        longestLine = length;
                    }

                    if (length < shortestLine) {
                        shortestLine = length;
                    }
                }

                reader.close();
                fileReader.close();


                System.out.println("Результаты:");
                System.out.println("Общее количество строк: " + totalLines);
                System.out.println("Длина самой длинной строки: " + longestLine);
                System.out.println("Длина самой короткой строки: " + shortestLine);

            } catch (LineTooLongException e) {
                System.out.println("ОШИБКА: " + e.getMessage());
                System.out.println("Завершаемся из-за слишком длинной строки.");
                break;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println("----------------------");
        }

        scanner.close();
    }
}