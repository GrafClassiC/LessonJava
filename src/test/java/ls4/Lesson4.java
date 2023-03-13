package ls4;

import java.util.Random;
import java.util.Scanner;

public class Lesson4{
//поле
    public static final int SIZE = 5;
// кол-во для победы
    public static final int DOTS_TO_WIN = 4;
// пустоты
    public static final char EMPTY_DOT = '☯';
    // ход игрока
    public static final char HUMAN = 'X';
    // 2-й игрок
    public static final char II = 'O';

    public static Scanner input = new Scanner(System.in);
    public static char[][] MAP;

    public static void initGameField() {
        MAP = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = EMPTY_DOT;
            }
        }
    }

    public static void printGameField() {
        for (int i = 0; i <= MAP.length; i++) {    //горизонтальная линия - координата X
            System.out.print(i == 0 ? "  " : i + " ");   // не выводим 0, заменяем
        }
        System.out.println();
        for (int i = 0; i < MAP.length; i++) {
            System.out.print((i + 1) + " ");            // вертикальная линия - координата Y
            for (int j = 0; j < MAP.length; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isCellAvailable(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE && MAP[y][x] == EMPTY_DOT;    // если x и y находятся в допустимых пределах И если ячейка не равна пустой, то возвращаем true
    }

    public static void player1Move() {
        int x, y;
        do {
            System.out.printf("Введите ход через пробел в формате X(= 1..%d) Y(= 1..%d):\n", SIZE, SIZE);
            x = Integer.valueOf(input.next()) - 1;
            y = Integer.valueOf(input.next()) - 1;
        } while (!isCellAvailable(x, y));
        MAP[y][x] = HUMAN;
    }

    public static void player2Move() {
        int x, y;
        do {
            x = new Random().nextInt(SIZE);
            y = new Random().nextInt(SIZE);
        } while (!isCellAvailable(x, y));
        System.out.println("ИИ походил в ячейку " + (x + 1) + " " + (y + 1));
        MAP[y][x] = II;
    }

    public static boolean isWin(char playerDot) {
        int hor, ver;
        int diagMain, diagReverse;
        for (int i = 0; i < SIZE; i++) {
            hor = 0;
            ver = 0;
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == playerDot) {                          // проверяем горизонтальные линии на возможную победу
                    hor++;
                } else if (MAP[i][j] != playerDot && hor < DOTS_TO_WIN) {
                    hor = 0;
                }
                if (MAP[j][i] == playerDot) {                          // проверяем вертикальные линии на возможную победу
                    ver++;
                }   else if (MAP[j][i] != playerDot && ver < DOTS_TO_WIN) {
                    ver = 0;
                }
            }
            if (hor >= DOTS_TO_WIN || ver >= DOTS_TO_WIN) {
                System.out.println("По горизонтали или вертикали " + hor + " " + ver);
                return true;
            }
        }

        for (int j = 0; j < SIZE; j++) {
            diagMain = 0;
            for (int i = 0; i < SIZE; i++) {
                int k = j + i;
                if (k < SIZE) {
                    if (MAP[i][k] == playerDot) {                      // проверяем главную диагональ от центральной оси вправо на возможную победу
                        diagMain++;
                    } else if (MAP[i][k] != playerDot && diagMain < DOTS_TO_WIN) {
                        diagMain = 0;
                    }
                }
                if (diagMain >= DOTS_TO_WIN) {
                    System.out.println("По главной диагонали от центральной оси вправо " + diagMain);
                    return true;
                }
            }
        }
        for (int j = 1; j < SIZE; j++) {
            diagMain = 0;
            for (int i = 0; i < SIZE; i++) {
                int k = j + i;
                if (k < SIZE) {
                    if (MAP[k][i] == playerDot) {                      // проверяем главную диагональ от центральной оси вниз на возможную победу
                        diagMain++;
                    } else if (MAP[k][i] != playerDot && diagMain < DOTS_TO_WIN) {
                        diagMain = 0;
                    }
                }
                if (diagMain >= DOTS_TO_WIN) {
                    System.out.println("По главной диагонали от центральной оси вниз " + diagMain);
                    return true;
                }
            }
        }
        for (int j = 0; j < SIZE; j++) {
            diagReverse = 0;
            for (int i = 0; i < SIZE; i++) {
                int k = (SIZE - 1) - i;
                int l = j + i;
                if (k >= 0 && l < SIZE) {
                    if (MAP[l][k] == playerDot) {                     // проверяем побочную диагональ от центральной оси вниз на возможную победу
                        diagReverse++;
                    } else if (MAP[l][k] != playerDot && diagReverse < DOTS_TO_WIN) {
                        diagReverse = 0;
                    }
                }
                if (diagReverse >= DOTS_TO_WIN) {
                    System.out.println("По побочной диагонали от центральной оси вниз " + diagReverse);
                    return true;
                }
            }
        }
        for (int j = 1; j < SIZE; j++) {
            diagReverse = 0;
            for (int i = 0; i < SIZE; i++) {
                int k = (SIZE - 1) - j - i;
                if (k >= 0) {
                    if (MAP[i][k] == playerDot) {     // проверяем побочную диагональ от центральной оси влево на возможную победу
                        diagReverse++;
                    } else if (MAP[i][k] != playerDot && diagReverse < DOTS_TO_WIN) {
                        diagReverse = 0;
                    }
                }
                if (diagReverse >= DOTS_TO_WIN) {
                    System.out.println("По побочной диагонали от центральной оси влево " + diagReverse);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isDraw() {                            // метод проверяет вариант ничьей
        for (char[] aGameField : MAP) {
            for (int j = 0; j < MAP.length; j++) {
                if (aGameField[j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        initGameField();                    // инициализируем игровое поле - создаём "пустой" двумерный массив
        System.out.printf("Цель игры - заполнить подряд линию по вертикали, горизонтали или диагонали из %d Ваш%s символ%s.\n", DOTS_TO_WIN, (DOTS_TO_WIN % 10 == 1 && DOTS_TO_WIN % 100 != 11) ? "его" : "их", (DOTS_TO_WIN % 10 == 1 && DOTS_TO_WIN % 100 != 11) ? "а" : "ов");
        printGameField();                   // выводим состояние начального поля в консоль

        switch (new Random().nextInt(2)) {
            case 0: {
                System.out.println("Ваш ход первый!");
                while (true) {
                    player1Move();
                    printGameField();
                    if (isWin(HUMAN)) {
                        System.out.println("Победил Игрок 1");
                        break;
                    }
                    if (isDraw()) {
                        System.out.println("Ничья");
                        break;
                    }
                    player2Move();
                    printGameField();
                    if (isWin(II)) {
                        System.out.println("Победил ИИ");
                        break;
                    }
                    if (isDraw()) {
                        System.out.println("Ничья");
                        break;
                    }
                }
                break;
            }
            case 1: {
                System.out.println("Первый ход за ИИ!");
                while (true) {
                    player2Move();
                    printGameField();
                    if (isWin(II)) {
                        System.out.println("Победил ИИ");
                        break;
                    }
                    if (isDraw()) {
                        System.out.println("Ничья");
                        break;
                    }
                    player1Move();
                    printGameField();
                    if (isWin(HUMAN)) {
                        System.out.println("Победил Игрок 1");
                        break;
                    }
                    if (isDraw()) {
                        System.out.println("Ничья");
                        break;
                    }
                }
            }
        }
    }
}