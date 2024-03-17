package AutomataNodes;

import java.util.ArrayList;
import java.util.Scanner;

public class NFA{
    static State initialState;
    static State[] finalState;
    static ArrayList<Relation> relations = RelationsList.relationsList;
    public static void createNFA(Scanner scanner){
        StatesList.setStateList(scanner);
        TransitionList.setTransitionList(scanner);
        RelationsList.setRelationsList(scanner);
        setInitialState(scanner);
        setFinalState(scanner);
    }
    static void setInitialState(Scanner scanner){
        System.out.println("Enter the  initial state: ");
        while (true){
            String s = scanner.nextLine();
            if(StatesList.checkIfInStateList(s)){
                initialState = new State(s);
                break;
            }
            else
                System.out.println("Enter a valid state");
        }
    }
    static void setFinalState(Scanner scanner){
        System.out.println("Enter the no of final states: ");
        int noOfFinalStates = Integer.parseInt(scanner.nextLine());
        finalState = new State[noOfFinalStates];
        for (int i = 0; i < noOfFinalStates; i++) {
            System.out.println("Enter a final state: ");
            String s = scanner.nextLine();
            if(StatesList.checkIfInStateList(s))
                finalState[i] = new State(s);
            else{
                System.out.println("Enter a valid state!!");
                i--;
            }
        }
    }
}