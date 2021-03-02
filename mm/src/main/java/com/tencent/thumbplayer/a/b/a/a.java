package com.tencent.thumbplayer.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.c;
import com.tencent.thumbplayer.api.TPOptionalParam;

public final class a {
    public int[] RYt;
    public int RYu = 2;
    public int RYv = 2;
    public boolean RYw = false;

    public a(c cVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(188994);
        if (cVar == null) {
            AppMethodBeat.o(188994);
            return;
        }
        TPOptionalParam aqR = cVar.aqR(210);
        if (aqR == null || aqR.getParamType() != 4) {
            TPOptionalParam aqR2 = cVar.aqR(202);
            if (aqR2 != null && aqR2.getParamType() == 2) {
                long j2 = aqR2.getParamLong().value;
                if (j2 <= 0 || j2 >= 5) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    this.RYv = (int) aqR2.getParamLong().value;
                }
            }
            TPOptionalParam aqR3 = cVar.aqR(203);
            if (aqR3 != null && aqR3.getParamType() == 2) {
                long j3 = aqR3.getParamLong().value;
                if ((j3 <= 0 || j3 >= 5) ? false : z2) {
                    this.RYu = (int) aqR3.getParamLong().value;
                }
            }
            int i2 = this.RYv;
            int i3 = this.RYu;
            if (i2 == 3 && i3 == 3) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("can not soft with systemplayer");
                AppMethodBeat.o(188994);
                throw illegalArgumentException;
            }
            AppMethodBeat.o(188994);
            return;
        }
        this.RYt = aqR.getParamQueueInt().queueValue;
        this.RYw = true;
        AppMethodBeat.o(188994);
    }
}
