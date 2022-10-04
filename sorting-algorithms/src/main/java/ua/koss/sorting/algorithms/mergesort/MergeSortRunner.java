package ua.koss.sorting.algorithms.mergesort;

import ua.koss.binarytree.model.Person;
import ua.koss.binarytree.service.NameService;

import java.io.IOException;
import java.util.Arrays;

public class MergeSortRunner {
    private final int DEFAULT_ARRAY_LENGTH = 10;

    public void run() throws IOException {
        integerArraySort();
        personArraySort();
    }

    private void integerArraySort() {
        System.out.println("Integer array --------------------------------------------------");
        int[] intArray = {15, 12, 2, 31, 44, 11, 12, 19, 55, 20};
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer[] arrayToSort = Arrays.stream(intArray).boxed().toArray(Integer[]::new);

        System.out.println(Arrays.toString(arrayToSort));

        mergeSort.sort(arrayToSort, arrayToSort.length);

        System.out.println(Arrays.toString(arrayToSort));
    }

    private void personArraySort() throws IOException {
        System.out.println("Person array --------------------------------------------------");
        NameService nameService = new NameService();
        Person[] persons = new Person[DEFAULT_ARRAY_LENGTH];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = nameService.getRandomPerson();
        }

        System.out.println(Arrays.toString(persons));

        MergeSort<Person> mergeSort = new MergeSort<>();
        mergeSort.sort(persons, persons.length);

        System.out.println(Arrays.toString(persons));
    }
}
