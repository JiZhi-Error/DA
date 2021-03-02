package com.tencent.mm.ui.widget.cedit.edit;

public final class c {
    long QLo;
    float QLp;
    float QLq;
    long QLr;
    boolean QLs;
    int QLt = 0;
    boolean QLu;
    boolean QLv;
    boolean QLw;
    float ovM;
    float ovN;

    public final boolean haT() {
        return this.QLt == 2 || this.QLt == 3;
    }

    public static boolean a(float f2, float f3, float f4, float f5, int i2) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        return (f6 * f6) + (f7 * f7) <= ((float) (i2 * i2));
    }
}
