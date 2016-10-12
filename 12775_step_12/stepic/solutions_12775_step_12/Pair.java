package stepic.solutions_12775_step_12;

/**
 * Created by ipetrash on 12.10.2016.
 */
public class Pair <T, S> {
    private T first;
    private S second;

    private Pair(T first, S second) {
        this.first = first;
        this.second = second;
    }

    public static <T, S> Pair<T, S> of(T first, S second) {
        return new Pair<>(first, second);
    }

    public T getFirst() {
        return first;
    }
    S getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Pair)) {
            return false;
        }

        Pair <T, S> otherPair = (Pair <T, S>) obj;

        if (first == null && otherPair.first != null
                || second == null && otherPair.second != null) {
            return false;
        }

        if (first == null && otherPair.first == null
                && second == null && otherPair.second == null) {
            return true;
        }

        return first.equals(otherPair.first) && second.equals(otherPair.second);
    }

    @Override
    public int hashCode() {
        int hash1 = first == null ? 0 : first.hashCode();
        int hash2 = second == null ? 0 : second.hashCode();

        return hash1 ^ hash2;
    }
}
