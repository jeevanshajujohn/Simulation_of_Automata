package AutomataNodes;

import java.util.*;

public class TransitionList {
    public static ArrayList<Transition> transitionList;

    public static void setTransitionList(Scanner scanner) {
        transitionList = new ArrayList<>();
        while (true) {
            System.out.println("Enter the next needed Transitions, type 'exit' to exit: ");
            String nextInput = scanner.nextLine();

            if (nextInput.toLowerCase(Locale.ROOT).equals("exit"))
                break;

            boolean uniqueStateChecker = true;

            Transition temp = new Transition(nextInput);

            for (Transition transition: transitionList){
                if(transition.equals(temp)){
                    uniqueStateChecker = false;
                    break;
                }
            }
            if (uniqueStateChecker) {
                transitionList.add(temp);
            }
            else
                System.out.println("Enter a unique Transition!");
        }
    }

    public static boolean checkIfInTransitionList(char temp) {
        boolean hasTransition = false;
        for (Transition transition: TransitionList.transitionList)
            if(transition.data.equals(String.valueOf(temp))) {
                hasTransition = true;
                break;
            }
        return hasTransition;
    }

    public static boolean ifTransitionValidForRelation(Transition transition, Relation relation){
        return transition.equals(relation.connection);
    }
}
