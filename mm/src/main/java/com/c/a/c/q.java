package com.c.a.c;

public final class q<T> implements p<T> {
    @Override // com.c.a.c.p
    public final int aG(T t) {
        return System.identityHashCode(t);
    }

    @Override // com.c.a.c.p
    public final boolean equals(T t, T t2) {
        return t == t2;
    }
}
