import AutomataNodes.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NFA.createNFA(sc);
        System.out.println(RelationFunctions.checkIfValidString("abbaa"));
        System.out.println("Hello world!");
    }
}