import AutomataNodes.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean breakStatement = false;
        chooseAutomata(sc);
        while(!breakStatement){
            int menuChoice;
            System.out.println("Enter 1 for checking the validity of string \nEnter 2 to check if given NFA is also a DFA \nEnter 3 to exit");
            menuChoice = sc.nextInt();
            sc.nextLine();
            switch (menuChoice) {
                case 1:
                    RelationFunctions.checkForMultipleValidStrings(sc);
                    break;

                case 2:
                    System.out.println(RelationFunctions.checkIfFiniteOrNonFinite());
                    break;

                case 3:
                    breakStatement = true;
                    break;

                default:
                    System.out.println("Enter a valid option: ");
            }
        }
    }
    public static void chooseAutomata(Scanner scanner){
        System.out.println("Enter 1 for NFA, Enter 2 for DFA: ");
        while(true) {
            int DFA = scanner.nextInt();
            scanner.nextLine();
            if(DFA == 1) {
                NFA.createNFA(scanner);
                break;
            }

            else if (DFA == 2) {
                NFA.forceCreateDFA(scanner);
                break;
            }

            else{
                System.out.println("Choose a valid option:");
            }
        }

    }
}