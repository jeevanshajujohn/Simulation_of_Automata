package AutomataNodes;

import java.util.Locale;
import java.util.Objects;

public class State {
    String data;

    State(String nextInput) {
        data = nextInput.toUpperCase(Locale.of(nextInput));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(data, state.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
