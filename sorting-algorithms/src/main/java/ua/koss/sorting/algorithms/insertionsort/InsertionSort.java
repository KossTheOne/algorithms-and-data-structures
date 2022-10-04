package ua.koss.sorting.algorithms.insertionsort;

import java.util.Arrays;

public class InsertionSort<T extends Comparable<T>> {

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
        for (int i = 1; i < arrayToSort.length; i++) {
            T key = arrayToSort[i];
            int j = i -1;
            while ((j>-1) && key.compareTo(arrayToSort[j]) < 0){
                arrayToSort[j+1] = arrayToSort[j];
                j--;
            }
            arrayToSort[j+1] = key;

        }
        return arrayToSort;
    }
}
