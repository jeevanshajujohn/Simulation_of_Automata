package AutomataNodes;

import java.util.Arrays;

public class RelationFunctions{
    public static boolean checkIfValidString(String initString) {
        char[] splitString = initString.toCharArray();
        for(char element:splitString){
            if(TransitionList.checkIfInTransitionList(element))
                return false;
        }
        return recursiveChecker(splitString, NFA.initialState);
    }
    public static boolean recursiveChecker(char[] arr, State preState){
        boolean check = false;
        if(arr.length == 1){
            for (Relation rel : RelationsList.relationsList) {
                if(rel.fromState.equals(preState)) {
                    if (Arrays.stream(NFA.finalState).anyMatch(n -> n == rel.toState)){
                        if(new Transition(String.valueOf(arr[0])).equals(rel.connection)) {
                            return true;
                        }
                    }
                }
            }
        }
        else
            for(Relation rel : RelationsList.relationsList){
                if(rel.fromState.equals(preState)){
                    if(new Transition(String.valueOf(arr[0])).equals(rel.connection)){
                        char[] newArr = Arrays.copyOfRange(arr, 1, arr.length);
                        check = recursiveChecker(newArr, rel.toState);
                    }
                }
            }
        return check;
    }
}
