package com.tencent.mm.ui.indicator;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private int QkY;
    private int QkZ;
    private int[] Qla;
    private int[] Qlb;
    private int count = 100;

    public a(int i2, int i3) {
        AppMethodBeat.i(205314);
        this.QkY = i2;
        this.QkZ = i3;
        this.Qla = aoi(i2);
        this.Qlb = aoi(i3);
        AppMethodBeat.o(205314);
    }

    public final int getColor(int i2) {
        AppMethodBeat.i(205315);
        int[] iArr = new int[4];
        for (int i3 = 0; i3 < this.Qlb.length; i3++) {
            iArr[i3] = (int) (((double) this.Qla[i3]) + (((((double) (this.Qlb[i3] - this.Qla[i3])) * 1.0d) / ((double) this.count)) * ((double) i2)));
        }
        int argb = Color.argb(iArr[0], iArr[1], iArr[2], iArr[3]);
        AppMethodBeat.o(205315);
        return argb;
    }

    private static int[] aoi(int i2) {
        AppMethodBeat.i(205316);
        int[] iArr = {Color.alpha(i2), Color.red(i2), Color.green(i2), Color.blue(i2)};
        AppMethodBeat.o(205316);
        return iArr;
    }
}
