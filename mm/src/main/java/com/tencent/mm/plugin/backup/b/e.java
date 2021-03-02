package com.tencent.mm.plugin.backup.b;

public final class e {
    public int oJc = -100;
    public int oJd;
    public int oJe;
    public int oJf;
    public long oJg;
    public long oJh;
    public long oJi;
    public long oJj;
    public long oJk;
    public long oJl;
    public long oJm;
    public long oJn;

    public final void S(int i2, int i3, int i4) {
        this.oJc = i2;
        this.oJd = i3;
        this.oJe = i4;
    }

    public final void a(int i2, int i3, int i4, long j2, long j3, long j4, long j5) {
        this.oJc = i2;
        this.oJd = i3;
        this.oJe = i4;
        this.oJg = j2;
        this.oJj = j3;
        this.oJh = j4;
        this.oJi = j5;
    }

    public final int ceV() {
        double d2;
        if (this.oJj == 0) {
            return 1;
        }
        double d3 = (double) ((this.oJg * 100) / this.oJj);
        if (d3 <= 5.0d) {
            d2 = d3 * 4.0d;
        } else {
            d2 = (((d3 - 5.0d) * 80.0d) / 95.0d) + 20.0d;
        }
        return (int) d2;
    }
}
