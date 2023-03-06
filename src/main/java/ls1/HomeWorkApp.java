//commit test
// п.п 1 
package ls1;

public class HomeWorkApp {
    // п.п 2
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNambers();
    }

    // п.п 3
    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // п.п 4
    static void checkSumSign() {
        int a;
        a = 12;
        int b;
        b = 24;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // п.п 5
    static void printColor() {
        int value = 100;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 & value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    // п.п 6
    static void compareNambers() {
        int a = 15;
        int b = 45;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}

