public class IfElse {
    /*
    public static int abs(int x){
        if (x < 0) {return -x;};
        return x;
    }

    public static int safeDiv(int x, int y) {
        if (y == 0) {
            return y;
        }
        return x / y;
    }


    */
    /*    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите число: ");
            int x  = scanner.nextInt();
            int result = abs(x);
            System.out.print(result);
        }*/
    /*

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число x: ");
        int x  = scanner.nextInt();

        System.out.print("Введите число x: ");
        int y  = scanner.nextInt();

        int resultSafeDiv =  safeDiv(x,y);
        System.out.println("Результат деления x на y: " + resultSafeDiv);
    }*/

    /*    public static String age(int x) {
            int lastTwoDigits = x % 100;
            if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
                return "Лет";}

            int lastDigit = x % 10;
            if (lastDigit == 1) {
                return "год";
            } else if (lastDigit >= 2 && lastDigit <= 4) {
                return  "года";
            } else {
                return "Лет";
            }
        }*/

    /*    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Введите число: ");
            int x = sc.nextInt();
            String result = age(x);
            System.out.println(x + " "+ result);
        }*/


    /*public static String day(int x) {
        switch (x) {
            case 1:
                return "Понедельник";
            case 2:
                return "Вторник";
            case 3:
                return "Среда";
            case 4:
                return "Четверг";
            case 5:
                return "Пятница";
            case 6:
                return "Суббота";
            case 7:
                return "Воскресенье";
            default:
                return "это не день недели";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число: ");
        int x = sc.nextInt();
        String result = day(x);
        System.out.println(result);
    }*/

    public static void printDays(String x) {
        switch (x) {
            case "понедельник":
                System.out.println("понедельник");
            case "вторник":
                System.out.println("вторник");
            case "среда":
                System.out.println("среда");
            case "четверг":
                System.out.println("четверг");
            case "пятница":
                System.out.println("пятница");
            case "суббота":
                System.out.println("суббота");
            case "воскресенье":
                System.out.println("воскресенье");
                break;
            default:
                System.out.println("это не день недели");
        }
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите день недели: ");
//        String inputDay = scanner.nextLine().toLowerCase().trim();
//        printDays(inputDay);
//
//
//    }

//    public static int max(int x, int y){
//        return x > y ? x : y;
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Введите число x: ");
//        int x = sc.nextInt();
//
//        System.out.print("Введите число y: ");
//        int y = sc.nextInt();
//
//        int result = max(x,y);
//        System.out.println("Самое большое число: " + result);
//    }

//    public static String makeDecision(int x, int y) {
//        if (x > y) {
//            return x + " > " + y;
//        } else if (x < y) {
//            return x + " < " + y;
//        } else {
//            return x + " == " + y;
//        }
//    }

//    public static int max3(int x, int y, int z){
//        if (x > y && x > z){return x;}
//        else if (y > x && y > z){return y;}
//        return z;
//    }
//
//        public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Введите число x: ");
//        int x = sc.nextInt();
//
//        System.out.print("Введите число y: ");
//        int y = sc.nextInt();
//
//        System.out.print("Введите число z: ");
//        int z = sc.nextInt();
//
//        int result = max3(x,y,z);
//        System.out.println("Самое большое число: " + result);
//    }

//    public static String listNums(int x){
//        for (int i = 0; i < x; i++){
//            System.out.print(i + " ");
//        }
//        return "";
//    }

//    public static String reverseListNums(int x){
//        for (int i = x; i >= 0; i--) {
//            System.out.print(i + " ");
//        }
//        return "";
//    }

//    public static String chet(int x){
//        for(int i = 0; i <=x; i += 2){
//            System.out.print(i + " ");
//
//        }
//        return "";
//    }
//    public static int pow(int x, int y){
//        int result = 1;
//        for (int i = 0; i < y;i++){
//            result *= x;
//        }
//        System.out.print(result);
//        return result;
//    }
//    public static int numLen(long x){
//        int count = 1;
//        while (x >= 10){
//            count++;
//            x /= 10;
//        }
//        System.out.println(count);
//        return count;
//    }
//    public static boolean equalNum(int x){
//        int lastDigit = x % 10;
//        int lastLastDigit = x / 10;
//        boolean result = true;
//
//        while (lastLastDigit != 0) {
//            result = result && (lastLastDigit % 10 == lastDigit);
//            lastLastDigit = lastLastDigit / 10;
//        }
//        System.out.print(result);
//        return result;
//    }

//    public static void square(int x) {
//        for (int i = 0; i < x; i++) {
//            for (int j = 0; j < x; j++) {
//                System.out.print('*');
//            }
//            System.out.println();
//        }
//    }
public static void leftTriangle(int x) {
    for (int i = 1; i <= x; i++) {
        for (int j = 0; j < i; j++) {
            System.out.print('*');
        }
        System.out.println();
    }
}

    public static void guessGame() {
        int randomNum = 3;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int x;

        do {
            System.out.println("What number am I thinking (0 to 9)? :");
            x = sc.nextInt();

            if (x != randomNum) {
                System.out.println("No, try again");
            } else {
                System.out.println("Yes, it's " + randomNum);
            }
        } while (x != randomNum);
    }

    public static void main(String[] args) {
        guessGame();
    }
}