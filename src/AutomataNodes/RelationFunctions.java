package AutomataNodes;

import java.util.Arrays;

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
            for (Relation rel : RelationsList.relationsList) {
                if(rel.fromState.equals(preState)) {
                    for(State state: NFA.finalState){
                        if(state.equals(rel.toState)){
                            if(new Transition(String.valueOf(arr[0])).equals(rel.connection)) {
                                return true;
                            }
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
