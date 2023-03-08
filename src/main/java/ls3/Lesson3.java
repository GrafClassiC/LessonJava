package ls3;

import java.util.Arrays;

public class Lesson3 {
    public static void firstTask(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else if (arr[i] == 1) {
                arr[i] = 0;
            }
        }
        System.out.println("First task:");
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    public static void secondTask() {
        int[] emptyArray = new int[100];
        for (int i = 0; i < emptyArray.length; i++) {
            emptyArray[i] = i + 1;
        }
        System.out.println("Second task:");
        System.out.println(Arrays.toString(emptyArray));
        System.out.println();
    }

    public static void thirdTask() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println("thirtTask");
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    public static int[] fifthTask(int len, int initialValue) {
        int[] result = new int[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = initialValue;
        }

        return result;
    }

    public static void fourthTask() {
        int[][] arr = {
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
        };
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                }
            }
        }

        System.out.println("Fourth task:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();

    }

    public static void main(String[] args) {
        // п.1.1
        firstTask(new int[]{0, 1, 0, 0, 0, 0, 1, 1});

        // п.1.2
        secondTask();

        // п.1.3
        thirdTask();

        // п.1.4
        fourthTask();

        // п.1.5
        int[] res = fifthTask(10, -1);
        System.out.println("Fifth task:");
        System.out.println(Arrays.toString(res));
        System.out.println();

    }

}
