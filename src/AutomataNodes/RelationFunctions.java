package AutomataNodes;

import java.util.Arrays;
import java.util.Scanner;

public class RelationFunctions{
    static boolean stringValidityChecker = false;
    public static boolean checkIfValidStringInputted(String initString) {
        char[] splitString = initString.toCharArray();
        for(char element:splitString){
            if(!TransitionList.checkIfInTransitionList(element))
                return false;
        }
        return recursiveCheckerForStringValidity(splitString, NFA.initialState);
    }
    public static boolean recursiveCheckerForStringValidity(char[] arr, State preState){
        if(arr.length == 0){
            if(NFA.ifNextStateInFinalStateArray(NFA.initialState))
                return true;
        }
        else if(arr.length == 1){
            for (Relation rel : RelationsList.relationsList)
                if(RelationsList.ifInitStateInRelationsList(rel, preState) && NFA.ifNextStateInFinalStateArray(rel.toState) && TransitionList.ifTransitionValidForRelation(new Transition(String.valueOf(arr[0])), rel))
                        return true;
        }
        else
            for(Relation rel : RelationsList.relationsList){
                if(RelationsList.ifInitStateInRelationsList(rel, preState) && TransitionList.ifTransitionValidForRelation(new Transition(String.valueOf(arr[0])), rel)){
                    char[] newArr = Arrays.copyOfRange(arr, 1, arr.length);
                        stringValidityChecker = recursiveCheckerForStringValidity(newArr, rel.toState);
                }
            }
        return stringValidityChecker;
    }

    public static void checkForMultipleValidStrings(Scanner sc){
        while (true){
            System.out.println("Enter a string: ");
            stringValidityChecker = false;
            String checkString = sc.nextLine();
            if(checkString.equalsIgnoreCase("exit"))
                break;
            else
            if(RelationFunctions.checkIfValidStringInputted(checkString))
                System.out.println("Valid string");
            else
                System.out.println("Invalid string");
        }
    }
    public static boolean checkIfFiniteOrNonFinite(){
        boolean validityIdentifier = false;
        for(State state: StatesList.stateList){
            for(Transition transition: TransitionList.transitionList){
                Relation newRelation = new Relation(state,  null, transition);
                for(Relation relation: RelationsList.relationsList){
                    if(newRelation.partialEqualityCheckForFirstStateAndTransition(relation)){
                        validityIdentifier = true;
                        break;
                    }
                }
                if(!validityIdentifier){
                    return false;
                }
            }
        }
        return validityIdentifier;
    }
}
