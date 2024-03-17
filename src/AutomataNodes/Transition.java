package AutomataNodes;

import java.util.Locale;
import java.util.Objects;

public class Transition {
    String data;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transition that = (Transition) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    Transition(String nextInput) {
        data = nextInput.toLowerCase(Locale.of(nextInput));
    }
}
