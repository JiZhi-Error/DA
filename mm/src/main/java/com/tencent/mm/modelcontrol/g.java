package com.tencent.mm.modelcontrol;

public final class g implements Comparable {
    public int iSY;
    public int iSZ;
    public int iTa;
    public int iTb;
    public int iTc;
    public int iTd;
    public int iTe;

    public g(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.iSY = i2;
        this.iSZ = i3;
        this.iTa = i4;
        this.iTb = i5;
        this.iTc = i6;
        this.iTd = i7;
        this.iTe = i8;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        if (obj != null && (obj instanceof g)) {
            return this.iSY - ((g) obj).iSY;
        }
        return 0;
    }
}
