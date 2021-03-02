package com.tencent.mm.plugin.appbrand.widget.c;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private int orp;
    private int orq;
    private int orr;
    private int ors;
    private int ort;
    private int oru;
    private int orv;
    private int orw;

    public a(int i2, int i3) {
        AppMethodBeat.i(153229);
        this.orp = Color.red(i2);
        this.orq = Color.green(i2);
        this.orr = Color.blue(i2);
        this.ors = Color.alpha(i2);
        this.ort = Color.red(i3);
        this.oru = Color.green(i3);
        this.orv = Color.blue(i3);
        this.orw = Color.alpha(i3);
        AppMethodBeat.o(153229);
    }

    public final int aW(float f2) {
        AppMethodBeat.i(153230);
        int argb = Color.argb((int) (((double) this.ors) + ((double) (((float) (this.orw - this.ors)) * f2)) + 0.5d), (int) (((double) this.orp) + ((double) (((float) (this.ort - this.orp)) * f2)) + 0.5d), (int) (((double) this.orq) + ((double) (((float) (this.oru - this.orq)) * f2)) + 0.5d), (int) (((double) this.orr) + ((double) (((float) (this.orv - this.orr)) * f2)) + 0.5d));
        AppMethodBeat.o(153230);
        return argb;
    }
}
