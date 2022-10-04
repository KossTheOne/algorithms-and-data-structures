package ua.koss.binarytree;

import ua.koss.binarytree.model.BinaryTree;
import ua.koss.binarytree.model.Person;
import ua.koss.binarytree.runner.ProgramRunner;
import ua.koss.binarytree.service.NameService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ProgramRunner programRunner = new ProgramRunner(
                new NameService(),
                new BinaryTree<>(),
                new Person[20]
        );
        programRunner.run();
    }
}