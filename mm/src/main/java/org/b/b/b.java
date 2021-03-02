package org.b.b;

public class b extends RuntimeException {
    public b(String str, Exception exc) {
        super(str, exc);
    }

    public b(String str) {
        super(str, null);
    }
}
