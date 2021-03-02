package a;

public final class g extends RuntimeException {
    public g(Exception exc) {
        super("An exception was thrown by an Executor", exc);
    }
}
