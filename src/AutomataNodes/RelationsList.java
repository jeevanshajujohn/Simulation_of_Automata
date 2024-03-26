package AutomataNodes;

import java.util.ArrayList;
import java.util.Scanner;

public class RelationsList {
    static ArrayList<Relation> relationsList;

    public static void setRelationsListForNFA(Scanner scanner) {
        relationsList = new ArrayList<>();

        while (true) {
            System.out.println("Enter 'yes' to add a relation, enter 'exit' to exit");
            String moreRelations = scanner.nextLine().toLowerCase();
            if (moreRelations.equals("yes"))
                createRelation(scanner);
            else if (moreRelations.equals("exit"))
                break;
            else
                System.out.println("Enter a valid option: ");
        }
    }

    public static void setRelationsListForDFA(Scanner scanner){
        relationsList = new ArrayList<>();
        for(State state: StatesList.stateList){
            for(Transition transition: TransitionList.transitionList){
                createRelation(state, transition, scanner);
            }
        }
    }

    static void createRelation(Scanner scanner) {
        System.out.println("Enter the initial state: ");
        String initState = checkStateForCreatingARelation(scanner);
        System.out.println("Enter the final state: ");
        String nextState = checkStateForCreatingARelation(scanner);
        System.out.println("Enter the relation between the states: ");
        String t = checkTransitionForCreatingARelation(scanner);
        Relation newRelation = new Relation(new State(initState), new State(nextState), new Transition(t));
        for (Relation relation : relationsList){
            if(relation.equals(newRelation)){
                System.out.println("Enter a Unique Relation");
                return;
            }
        }
        relationsList.add(newRelation);
    }


    static void createRelation(State initState, Transition transition, Scanner scanner){
        System.out.println("Enter the Final state for state " + initState.data + " with the transition " + transition.data + " : ");
        String nextState = checkStateForCreatingARelation(scanner);
        Relation newRelation = new Relation(initState, new State(nextState), transition);
        for (Relation relation : relationsList){
            if(relation.equals(newRelation)){
                System.out.println("Enter a Unique Relation");
                return;
            }
        }
        relationsList.add(newRelation);

    }

    public static String checkTransitionForCreatingARelation(Scanner scanner) {
        while (true) {
            String s1 = scanner.nextLine();
            boolean hasTransition = false;

            for(Transition currentTransition: TransitionList.transitionList)
                if(currentTransition.equals(new Transition(s1)))
                    hasTransition = true;

            if (hasTransition)
                return s1;
            else
                System.out.println("Enter a valid transition: ");
        }
    }

    public static String checkStateForCreatingARelation(Scanner scanner) {
        while (true) {
            String s1 = scanner.nextLine();
            boolean hasState = false;
            for (State currentState : StatesList.stateList)
                if (currentState.equals(new State(s1)))
                    hasState = true;
            if (hasState)
                return s1;
            else
                System.out.println("Enter a valid state: ");
        }
    }


    public static boolean ifInitStateInRelationsList(Relation relation, State state){
        return relation.fromState.equals(state);
    }
}
