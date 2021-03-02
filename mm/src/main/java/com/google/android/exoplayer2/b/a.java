package com.google.android.exoplayer2.b;

public abstract class a {
    public int flags;

    public void clear() {
        this.flags = 0;
    }

    public final boolean uc() {
        return dL(Integer.MIN_VALUE);
    }

    public final boolean ud() {
        return dL(4);
    }

    public final boolean ue() {
        return dL(1);
    }

    public final void dK(int i2) {
        this.flags |= i2;
    }

    /* access modifiers changed from: protected */
    public final boolean dL(int i2) {
        return (this.flags & i2) == i2;
    }
}
