package AutomataNodes;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class StatesList {
    public static ArrayList<State> stateList;

    public static void setStateList(Scanner scanner) {
        stateList = new ArrayList<>();
        while (true) {
            System.out.println("Enter the next needed State, type 'exit' to exit: ");
            String nextInput = scanner.nextLine();

            if (nextInput.toLowerCase(Locale.ROOT).equals("exit"))
                break;

            State temp = new State(nextInput);
            stateList.add(temp);
        }
    }

    public static boolean checkIfInStateList(String temp){
    boolean hasState = false;
        for (State state: StatesList.stateList)
            if(state.data.equals(String.valueOf(temp))) {
                hasState = true;
                break;
            }
        return hasState;
    }
}
