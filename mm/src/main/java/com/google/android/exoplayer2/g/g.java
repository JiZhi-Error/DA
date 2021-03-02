package com.google.android.exoplayer2.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class g {
    private int aHK;
    public final f[] bED;
    public final int length;

    public g(f... fVarArr) {
        AppMethodBeat.i(92949);
        this.bED = fVarArr;
        this.length = fVarArr.length;
        AppMethodBeat.o(92949);
    }

    public final f[] wB() {
        AppMethodBeat.i(92950);
        f[] fVarArr = (f[]) this.bED.clone();
        AppMethodBeat.o(92950);
        return fVarArr;
    }

    public final int hashCode() {
        AppMethodBeat.i(92951);
        if (this.aHK == 0) {
            this.aHK = Arrays.hashCode(this.bED) + JsApiGetABTestConfig.CTRL_INDEX;
        }
        int i2 = this.aHK;
        AppMethodBeat.o(92951);
        return i2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92952);
        if (this == obj) {
            AppMethodBeat.o(92952);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(92952);
            return false;
        } else {
            boolean equals = Arrays.equals(this.bED, ((g) obj).bED);
            AppMethodBeat.o(92952);
            return equals;
        }
    }
}
