package ua.koss.sorting.algorithms.insertionsort;

import ua.koss.binarytree.model.Person;
import ua.koss.binarytree.service.NameService;

import java.io.IOException;
import java.util.Arrays;

public class InsertionSortRunner {
    private final int DEFAULT_ARRAY_LENGTH = 10;

    public void run() throws IOException {
        integerArraySort();
        personArraySort();
    }

    private void integerArraySort () {
        System.out.println("Integer array --------------------------------------------------");
        int[] intArray = {15,12,2,31,44,11,12,19,55,20};
        InsertionSort<Integer> integerInsertionSort = new InsertionSort<>();
        Integer[] arrayToSort = Arrays.stream(intArray).boxed().toArray(Integer[]::new);
        Integer[] sortedArray = integerInsertionSort.sortMyArray(arrayToSort);
        printResult(arrayToSort, sortedArray);
    }

    private void personArraySort() throws IOException {
        System.out.println("Person array --------------------------------------------------");
        NameService nameService = new NameService();
        Person[] persons = new Person[DEFAULT_ARRAY_LENGTH];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = nameService.getRandomPerson();
        }
        InsertionSort<Person> personInsertionSort = new InsertionSort<>();
        Person[] sortedPersons = personInsertionSort.sortMyArray(persons);
        printResult(persons, sortedPersons);
    }

    private void printResult(Object[] before, Object[] after) {
        System.out.println("before -> " + Arrays.toString(before));
        System.out.println("after -> " + Arrays.toString(after));
    }


}
