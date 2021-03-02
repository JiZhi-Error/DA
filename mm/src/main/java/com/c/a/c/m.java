package com.c.a.c;

final class m<T> implements p<T> {
    m() {
    }

    @Override // com.c.a.c.p
    public final int aG(T t) {
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }

    @Override // com.c.a.c.p
    public final boolean equals(T t, T t2) {
        if (t != null) {
            return t.equals(t2);
        }
        return t2 == null;
    }
}
