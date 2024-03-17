package AutomataNodes;

import java.util.*;

public class TransitionList {
    public static ArrayList<Transition> transitionList;

    public static void setTransitionList(Scanner scanner) {
        transitionList = new ArrayList<>();
        while (true) {
            System.out.println("Enter the next needed Transitions: ");
            String nextInput = scanner.nextLine();

            if (nextInput.toLowerCase(Locale.ROOT).equals("exit"))
                break;

            Transition temp = new Transition(nextInput);
            transitionList.add(temp);
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
}
