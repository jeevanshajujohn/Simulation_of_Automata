package AutomataNodes;

import java.util.ArrayList;
import java.util.Scanner;

public class NFA{
    static boolean isDFA;
    static State initialState;
    static State[] finalState;
    static ArrayList<Relation> relations = RelationsList.relationsList;
    public static void createNFA(Scanner scanner){
        isDFA = false;
        StatesList.setStateList(scanner);
        TransitionList.setTransitionList(scanner);
        RelationsList.setRelationsListForNFA(scanner);
        setStartState(scanner);
        setFinalStates(scanner);
    }
    static void setStartState(Scanner scanner){
        System.out.println("Enter the Start state: ");
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
    static void setFinalStates(Scanner scanner){
        System.out.println("Enter the no of Final states: ");
        int noOfFinalStates = Integer.parseInt(scanner.nextLine());
        finalState = new State[noOfFinalStates];
        for (int i = 0; i < noOfFinalStates; i++) {
            System.out.println("Enter a Final state: ");
            String s = scanner.nextLine();
            if(StatesList.checkIfInStateList(s))
                finalState[i] = new State(s);
            else{
                System.out.println("Enter a valid state!!");
                i--;
            }
        }
    }
    public static boolean ifNextStateInFinalStateArray(State checkState){
        for(State state: finalState)
            if(state.equals(checkState))
                return true;
        return false;
    }

    public static void forceCreateDFA(Scanner scanner){
            isDFA = true;
            StatesList.setStateList(scanner);
            TransitionList.setTransitionList(scanner);
            RelationsList.setRelationsListForDFA(scanner);
            setStartState(scanner);
            setFinalStates(scanner);
    }
}
