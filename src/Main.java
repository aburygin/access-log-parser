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
                int googlebotCount = 0;
                int yandexbotCount = 0;
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

                    String[] quotes = line.split("\"");
                    if (quotes.length >= 6) {
                        String userAgent = quotes[quotes.length - 1].trim();

                        if (userAgent.startsWith(" ")) {
                            userAgent = userAgent.substring(1);
                        }

                        String botName = extractBotName(userAgent);
                        if ("Googlebot".equals(botName)) {
                            googlebotCount++;
                        } else if ("YandexBot".equals(botName)) {
                            yandexbotCount++;
                        }
                    }
                }

                reader.close();
                fileReader.close();

                if (totalLines > 0) {
                    double googlebotPercentage = (double) googlebotCount / totalLines * 100;
                    double yandexbotPercentage = (double) yandexbotCount / totalLines * 100;

                    System.out.println("Результаты анализа:");
                    System.out.println("Общее количество запросов: " + totalLines);
                    System.out.println("Запросов от Googlebot: " + googlebotCount + " (" + String.format("%.2f", googlebotPercentage) + "%)");
                    System.out.println("Запросов от YandexBot: " + yandexbotCount + " (" + String.format("%.2f", yandexbotPercentage) + "%)");
                } else {
                    System.out.println("Файл пуст");
                }

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

    private static String extractBotName(String userAgent) {
        try {
            int startBracket = userAgent.indexOf('(');
            int endBracket = userAgent.indexOf(')', startBracket);

            if (startBracket != -1 && endBracket != -1) {
                String firstBrackets = userAgent.substring(startBracket + 1, endBracket);

                String[] parts = firstBrackets.split(";");
                if (parts.length >= 2) {
                    String fragment = parts[1].trim();

                    int slashIndex = fragment.indexOf('/');
                    if (slashIndex != -1) {
                        String botName = fragment.substring(0, slashIndex).trim();
                        return botName;
                    }
                }
            }
        } catch (Exception e) {
            //test, teststeseqe123231
        }
        return null;
    }
}