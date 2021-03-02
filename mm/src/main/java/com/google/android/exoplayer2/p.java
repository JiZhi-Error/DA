package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class p {
    public static final p bdM = new p(1.0f, 1.0f);
    public final float bdN;
    public final int bdO;
    public final float pitch;

    static {
        AppMethodBeat.i(92512);
        AppMethodBeat.o(92512);
    }

    public p(float f2, float f3) {
        AppMethodBeat.i(92509);
        this.bdN = f2;
        this.pitch = f3;
        this.bdO = Math.round(1000.0f * f2);
        AppMethodBeat.o(92509);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92510);
        if (this == obj) {
            AppMethodBeat.o(92510);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(92510);
            return false;
        } else {
            p pVar = (p) obj;
            if (this.bdN == pVar.bdN && this.pitch == pVar.pitch) {
                AppMethodBeat.o(92510);
                return true;
            }
            AppMethodBeat.o(92510);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(92511);
        int floatToRawIntBits = ((Float.floatToRawIntBits(this.bdN) + JsApiGetABTestConfig.CTRL_INDEX) * 31) + Float.floatToRawIntBits(this.pitch);
        AppMethodBeat.o(92511);
        return floatToRawIntBits;
    }
}
