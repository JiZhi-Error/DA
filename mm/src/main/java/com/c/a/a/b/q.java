package com.c.a.a.b;

import java.util.Iterator;

public abstract class q<E> implements Iterator<E> {
    protected q() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
