package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.e;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.report.service.h;

public final class o {
    int cR;
    long[] kCG = new long[15];
    int kCH;
    int kCI = 0;
    int kCJ = 0;
    boolean kCK;
    boolean kCL;
    int kCM;
    int mScene;
    int mType;

    public static void a(int i2, AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(226176);
        a(i2, appBrandInitConfigWC.appId, appBrandInitConfigWC.appVersion, appBrandInitConfigWC.eix, appBrandInitConfigWC.NA());
        AppMethodBeat.o(226176);
    }

    public static void a(int i2, String str, int i3, int i4, boolean z) {
        AppMethodBeat.i(226177);
        int i5 = 369;
        if (z) {
            i5 = e.CTRL_INDEX;
        }
        try {
            h.INSTANCE.idkeyStat((long) i5, (long) i2, 1, false);
            i.b(str, i3, i4, i5, i2);
            AppMethodBeat.o(226177);
        } catch (Exception e2) {
            AppMethodBeat.o(226177);
        }
    }

    public o() {
        int i2 = 1;
        AppMethodBeat.i(43853);
        this.kCJ = com.tencent.mm.plugin.appbrand.task.e.k(g.WAGAME) ? 1 : 0;
        this.kCI = !com.tencent.mm.plugin.appbrand.task.e.k(g.WASERVICE) ? 0 : i2;
        AppMethodBeat.o(43853);
    }

    public final void I(int i2, long j2) {
        if (i2 < this.kCG.length && this.kCG[i2] == 0) {
            this.kCG[i2] = j2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void g(String str, int i2, int i3, int i4) {
        int i5;
        int i6 = 1;
        AppMethodBeat.i(43854);
        int i7 = this.kCM == 1 ? this.kCJ : this.kCI;
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[17];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(this.cR);
        objArr[2] = Integer.valueOf(this.mType);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = "";
        objArr[5] = "";
        objArr[6] = Long.valueOf(this.kCG[i3]);
        objArr[7] = Integer.valueOf(this.kCH);
        objArr[8] = Integer.valueOf(i7);
        objArr[9] = Integer.valueOf(this.mScene);
        if (this.kCK) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        objArr[10] = Integer.valueOf(i5);
        if (!this.kCL) {
            i6 = 0;
        }
        objArr[11] = Integer.valueOf(i6);
        objArr[12] = Integer.valueOf(i4);
        objArr[13] = 0;
        objArr[14] = 0;
        objArr[15] = 0;
        objArr[16] = Integer.valueOf(this.kCM);
        hVar.a(13886, objArr);
        AppMethodBeat.o(43854);
    }
}
