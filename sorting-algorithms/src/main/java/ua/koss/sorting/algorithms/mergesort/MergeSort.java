package ua.koss.sorting.algorithms.mergesort;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> {

    private void merge(T[] arrayToSort, T[] leftArray, T[] rightArray, int leftArrayLength, int right) {

        int i = 0, j = 0, k = 0;
        while (i < leftArrayLength && j < right) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                arrayToSort[k++] = leftArray[i++];
            } else {
                arrayToSort[k++] = rightArray[j++];
            }
        }
        while (i < leftArrayLength) {
            arrayToSort[k++] = leftArray[i++];
        }
        while (j < right) {
            arrayToSort[k++] = rightArray[j++];
        }
    }

    public void sort(T[] arrayToSort, int arrayLength) {
        if (arrayLength < 2) {
            return;
        }
        int mid = arrayLength / 2;
        T[] l = Arrays.copyOfRange(arrayToSort, 0, mid);
        T[] r = Arrays.copyOfRange(arrayToSort, mid, arrayLength);

        sort(l, mid);
        sort(r, arrayLength - mid);

        merge(arrayToSort, l, r, mid, arrayLength - mid);
    }
}
