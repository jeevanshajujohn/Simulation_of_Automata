package AutomataNodes;

import java.util.Objects;

public class Relation {
    static int counter = 1;
    State fromState;
    State toState;
    Transition connection;
    int RelationID;

    Relation(State fs, State ts, Transition con) {
        fromState = fs;
        toState = ts;
        connection = con;
        RelationID = counter + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relation relation = (Relation) o;
        return RelationID == relation.RelationID && Objects.equals(fromState, relation.fromState) && Objects.equals(toState, relation.toState) && Objects.equals(connection, relation.connection);
    }

    public boolean partialEqualityCheckForFirstStateAndTransition(Object o){
        if(o == null || getClass() !=  o.getClass()) return false;
        Relation relation = (Relation) o;
        return Objects.equals(fromState, relation.fromState) && Objects.equals(relation.connection, connection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromState, toState, connection, RelationID);
    }
}
