package ua.koss.sorting.algorithms.bubblesort;

import java.util.Arrays;

public class BubbleSort<T extends Comparable<T>> {

    public T[] sortMyArray(T[] arrayToSort) {
        T[] copiedArray = Arrays.copyOf(arrayToSort, arrayToSort.length);

        long start_time = System.nanoTime();
        T[] sortedArray = getSortedArray(copiedArray);
        long end_time = System.nanoTime();

        double difference = (end_time - start_time) / 1e6;
        System.out.printf("Time spent on sort operation: %s seconds%n", difference);

        return sortedArray;
    }

    private T[] getSortedArray(T[] arrayToSort) {
        T temp;
        for (int i = 0; i < arrayToSort.length; i++) {
            for (int j = 1; j < (arrayToSort.length - i); j++) {
                if (arrayToSort[j - 1].compareTo(arrayToSort[j]) > 0) {
                    temp = arrayToSort[j - 1];
                    arrayToSort[j - 1] = arrayToSort[j];
                    arrayToSort[j] = temp;
                }
            }
        }
        return arrayToSort;
    }
}
