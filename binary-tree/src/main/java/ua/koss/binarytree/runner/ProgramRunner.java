package ua.koss.binarytree.runner;

import ua.koss.binarytree.model.BinaryTree;
import ua.koss.binarytree.model.Person;
import ua.koss.binarytree.service.NameService;

import java.io.IOException;

public class ProgramRunner {
    private final NameService nameService;
    private final BinaryTree<Person> bt;
    private final Person[] randomPersons;

    public ProgramRunner(NameService nameService, BinaryTree<Person> bt, Person[] randomPersons) {
        this.nameService = nameService;
        this.bt = bt;
        this.randomPersons = randomPersons;
    }

    public void run() throws IOException {
        for (int i = 0; i < randomPersons.length; i++) {
            randomPersons[i] = nameService.getRandomPerson();
            bt.add(randomPersons[i]);
        }

        executeSearchOperations();
        executeRemoveOperations();
    }

    private void executeSearchOperations() {
        System.out.println("Search operations -----------------------------------------------------");
        long startTimeSearch = System.nanoTime();
        System.out.println(bt.search(randomPersons[4]));
        System.out.println(bt.search(randomPersons[8]));
        System.out.println(bt.search(randomPersons[7]));
        System.out.println(bt.search(randomPersons[13]));
        System.out.println(bt.search(randomPersons[14]));
        System.out.println(bt.search(randomPersons[17]));
        System.out.println(bt.search(randomPersons[19]));

        long endTimeSearch = System.nanoTime();
        double difference_search = (endTimeSearch - startTimeSearch) / 1e6;

        System.out.println("----------------------------------------------------------------------");
        System.out.printf("Time spent on Search operations: %s seconds%n", difference_search );
    }

    private void executeRemoveOperations() {
        System.out.println("Remove operations -----------------------------------------------------");
        long start_time_remove = System.nanoTime();
        System.out.println(bt.remove(randomPersons[19]));
        System.out.println(bt.remove(randomPersons[17]));
        System.out.println(bt.remove(randomPersons[14]));
        System.out.println(bt.remove(randomPersons[13]));
        System.out.println(bt.remove(randomPersons[8]));
        System.out.println(bt.remove(randomPersons[7]));
        System.out.println(bt.remove(randomPersons[4]));

        long end_time_remove = System.nanoTime();
        double difference_remove = (end_time_remove - start_time_remove) / 1e6;

        System.out.println("----------------------------------------------------------------------");
        System.out.printf("Time spent on remove operations: %s seconds%n", difference_remove );
    }
}
