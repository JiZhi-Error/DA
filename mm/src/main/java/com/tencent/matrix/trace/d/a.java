package com.tencent.matrix.trace.d;

public final class a {
    public int bCe;
    public int count = 1;
    public int dbJ;
    public int dbK;

    public a(int i2, int i3, int i4) {
        this.dbJ = i2;
        this.dbK = i3;
        this.bCe = i4;
    }

    public final String toString() {
        return this.bCe + "," + this.dbJ + "," + this.count + "," + this.dbK;
    }

    public final void bi(long j2) {
        this.count++;
        this.dbK = (int) (((long) this.dbK) + j2);
    }
}
