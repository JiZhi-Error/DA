package com.b.a.a;

import android.location.Location;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i {
    static i chY;
    float anchorX;
    float anchorY;
    double chZ;
    double cia;
    float cib;
    float cic;
    float cid;
    float cie;
    boolean cif = false;

    i() {
    }

    /* access modifiers changed from: package-private */
    public final void a(double d2, double d3, float f2, float f3, float f4, float f5) {
        double d4;
        double d5;
        AppMethodBeat.i(88023);
        float[] fArr = new float[1];
        if (d3 > 179.0d) {
            d4 = -1.0E-5d;
        } else {
            d4 = 1.0E-5d;
        }
        Location.distanceBetween(d2, d3, d2, d3 + d4, fArr);
        this.cie = fArr[0];
        if (d2 > 89.0d) {
            d5 = -1.0E-5d;
        } else {
            d5 = 1.0E-5d;
        }
        Location.distanceBetween(d5 + d2, d3, d2, d3, fArr);
        this.cid = fArr[0];
        this.chZ = d2;
        this.cia = d3;
        this.anchorX = f3;
        this.anchorY = f4;
        this.cic = f2;
        this.cib = f5;
        this.cif = true;
        AppMethodBeat.o(88023);
    }
}
