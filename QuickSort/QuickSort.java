package ru.kpfu.itis.group108;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class QuickSort {
    static int counter = 0;
    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        int support = array[middle];
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < support) {
                i++;
                counter++;
            }
            while (array[j] > support) {
                j--;
                counter++;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);
        if (high > i)
            quickSort(array, i, high);
    }
    public static void main(String[] args) throws FileNotFoundException {
        int order = 0;
        File file = new File("src/ru/kpfu/itis/group108/Arrays");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] numbersString = line.split(" ");
            int[] numbers = new int[numbersString.length];
            int index = 0;
            for (String number: numbersString) {
                numbers[index++] = Integer.parseInt(number);
            }
            order++;
            System.out.println(order + " array");
            System.out.println("The original array:");
            System.out.println(Arrays.toString(numbers));
            int low = 0;
            int high = numbers.length - 1;
            long lStartTime = System.nanoTime();
            quickSort(numbers, low, high);
            long lEndTime = System.nanoTime();
            double output = lEndTime - lStartTime;
            System.out.println("Array after sorting:");
            System.out.println(Arrays.toString(numbers));
            System.out.println("Time in milliseconds = " + output /
                    1000000);
            System.out.println("Number of iterations = " +
                    QuickSort.counter);
            System.out.println();
        }
        scanner.close();
    }
}