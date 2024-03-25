package AutomataNodes;

import java.util.Arrays;
import java.util.Scanner;

public class RelationFunctions{
    static boolean check = false;
    public static boolean checkIfValidString(String initString) {
        char[] splitString = initString.toCharArray();
        for(char element:splitString){
            if(!TransitionList.checkIfInTransitionList(element))
                return false;
        }
        return recursiveChecker(splitString, NFA.initialState);
    }
    public static boolean recursiveChecker(char[] arr, State preState){
        if(arr.length == 1){
            for (Relation rel : RelationsList.relationsList)
                if(RelationsList.ifInitStateInRelationsList(rel, preState) && NFA.ifNextStateInFinalStateArray(rel.toState) && TransitionList.ifTransitionValidForRelation(new Transition(String.valueOf(arr[0])), rel))
                        return true;
        }
        else
            for(Relation rel : RelationsList.relationsList){
                if(RelationsList.ifInitStateInRelationsList(rel, preState) && TransitionList.ifTransitionValidForRelation(new Transition(String.valueOf(arr[0])), rel)){
                    char[] newArr = Arrays.copyOfRange(arr, 1, arr.length);
                        check = recursiveChecker(newArr, rel.toState);
                }
            }
        return check;
    }

    public static void checkForMultipleValidStrings(Scanner sc){
        while (true){
            check = false;
            String checkString = sc.nextLine();
            if(checkString.equalsIgnoreCase("exit"))
                break;
            else
            if(RelationFunctions.checkIfValidString(checkString))
                System.out.println("Valid string");
            else
                System.out.println("Invalid string");
        }
    }

}
