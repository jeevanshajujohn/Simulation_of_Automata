package AutomataNodes;

import java.util.ArrayList;
import java.util.Scanner;

public class RelationsList {
    static ArrayList<Relation> relationsList;

    public static void setRelationsList(Scanner scanner) {
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

    static void createRelation(Scanner scanner) {
        System.out.println("Enter the initial state: ");
        String s1 = checkStateForRelation(scanner);
        System.out.println("Enter the final state: ");
        String s2 = checkStateForRelation(scanner);
        System.out.println("Enter the relation between the states: " );
        String t = checkTransitionForRelation(scanner);

        relationsList.add(new Relation(new State(s1), new State(s2), new Transition(t)));
    }

    public static String checkTransitionForRelation(Scanner scanner) {
        while (true) {
            String s1 = scanner.nextLine();
            boolean hasTransition = false;

            for(Transition currentTransition: TransitionList.transitionList)
                if(currentTransition.equals(new Transition(s1)))
                    hasTransition = true;


            if (hasTransition)
                return s1;
            else
                System.out.println("Enter a valid  transition: ");
        }
    }

    public static String checkStateForRelation(Scanner scanner) {
        while (true) {
            String s1 = scanner.nextLine();
            boolean hasState = false;
            for(State currentState: StatesList.stateList)
                if(currentState.equals(new State(s1)))
                    hasState = true;


            if (hasState)
                return s1;
            else
                System.out.println("Enter a valid state: ");
        }
    }

}