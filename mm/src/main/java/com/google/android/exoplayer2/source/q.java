package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class q {
    private int aHK;
    public final Format[] bwD;
    public final int length;

    public q(Format... formatArr) {
        AppMethodBeat.i(92720);
        a.checkState(formatArr.length > 0);
        this.bwD = formatArr;
        this.length = formatArr.length;
        AppMethodBeat.o(92720);
    }

    public final int j(Format format) {
        for (int i2 = 0; i2 < this.bwD.length; i2++) {
            if (format == this.bwD[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public final int hashCode() {
        AppMethodBeat.i(92721);
        if (this.aHK == 0) {
            this.aHK = Arrays.hashCode(this.bwD) + JsApiGetABTestConfig.CTRL_INDEX;
        }
        int i2 = this.aHK;
        AppMethodBeat.o(92721);
        return i2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92722);
        if (this == obj) {
            AppMethodBeat.o(92722);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(92722);
            return false;
        } else {
            q qVar = (q) obj;
            if (this.length != qVar.length || !Arrays.equals(this.bwD, qVar.bwD)) {
                AppMethodBeat.o(92722);
                return false;
            }
            AppMethodBeat.o(92722);
            return true;
        }
    }
}
