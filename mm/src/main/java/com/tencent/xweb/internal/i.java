package com.tencent.xweb.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.e;
import org.xwalk.core.Log;

public final class i {
    public double JIb = 1.0d;
    public double SDM;
    public double SDN;
    public double[] SDO = new double[0];

    public i() {
        AppMethodBeat.i(219071);
        AppMethodBeat.o(219071);
    }

    public final double H(double d2) {
        if (d2 < this.SDM || d2 > this.SDN) {
            return 0.0d;
        }
        if (this.SDO == null || this.SDO.length == 0) {
            return this.JIb;
        }
        if (this.SDO.length == 1) {
            return this.SDO[0];
        }
        if (d2 == this.SDN) {
            return this.SDO[this.SDO.length - 1];
        }
        int length = this.SDO.length - 1;
        double d3 = (this.SDN - this.SDM) / ((double) length);
        double d4 = d2 - this.SDM;
        for (int i2 = 0; i2 < length; i2++) {
            double d5 = ((double) i2) * d3;
            if (d4 <= ((double) (i2 + 1)) * d3) {
                return (((this.SDO[i2 + 1] - this.SDO[i2]) * (d4 - d5)) / d3) + this.SDO[i2];
            }
        }
        return this.SDO[this.SDO.length - 1];
    }

    public static i bsy(String str) {
        AppMethodBeat.i(219072);
        i iVar = new i();
        String[] split = str.replace("(", "-").replace(")", "").split("-");
        if (split == null || split.length < 2) {
            Log.e("getTimeRangeItem", "length error");
            AppMethodBeat.o(219072);
            return null;
        }
        double bsE = e.bsE(split[0]);
        if (bsE < 0.0d || bsE > 24.0d) {
            Log.e("getTimeRangeItem", "bind.rangeFrom.timeStart parse error");
            AppMethodBeat.o(219072);
            return null;
        }
        iVar.SDM = bsE;
        double bsE2 = e.bsE(split[1]);
        if (bsE2 < 0.0d || bsE2 > 24.0d) {
            Log.e("getTimeRangeItem", "bind.rangeFrom.timeEnd parse error");
            AppMethodBeat.o(219072);
            return null;
        }
        iVar.SDN = bsE2;
        if (split.length == 3) {
            e.a bsC = e.bsC(split[2]);
            if (!bsC.SEF) {
                Log.e("getTimeRangeItem", "scale parse error");
                AppMethodBeat.o(219072);
                return null;
            }
            double doubleValue = bsC.doubleValue();
            if (doubleValue < 0.0d || doubleValue > 1000000.0001d) {
                Log.e("getTimeRangeItem", "scale parse value error");
                AppMethodBeat.o(219072);
                return null;
            }
            iVar.JIb = doubleValue;
        } else if (split.length > 3) {
            double[] dArr = new double[(split.length - 2)];
            for (int i2 = 0; i2 + 2 < split.length; i2++) {
                e.a bsC2 = e.bsC(split[i2 + 2]);
                if (!bsC2.SEF) {
                    Log.e("getTimeRangeItem", "scales parse error");
                    AppMethodBeat.o(219072);
                    return null;
                }
                double doubleValue2 = bsC2.doubleValue();
                if (doubleValue2 < 0.0d || doubleValue2 > 1000000.0001d) {
                    Log.e("getTimeRangeItem", "scales parse value error");
                    AppMethodBeat.o(219072);
                    return null;
                }
                dArr[i2] = doubleValue2;
            }
            iVar.SDO = dArr;
        }
        AppMethodBeat.o(219072);
        return iVar;
    }
}
