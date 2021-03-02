package com.c.a.c;

final class t<T> implements s<T> {
    private final T[] cqH;
    private int pos;

    public t(T[] tArr) {
        this.cqH = tArr;
    }

    @Override // com.c.a.c.s
    public final boolean aD(T t) {
        T[] tArr = this.cqH;
        int i2 = this.pos;
        this.pos = i2 + 1;
        tArr[i2] = t;
        return true;
    }
}
