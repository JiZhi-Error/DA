package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.sdk.platformtools.Util;

public final class g {
    public final int bHa;
    public final int bHb;
    public final int bHc;
    public final int bHd;
    public final long bHe;
    public final int bsU;
    public final int channels;
    public final int sampleRate;

    public g(byte[] bArr) {
        AppMethodBeat.i(93135);
        l lVar = new l(bArr);
        lVar.setPosition(r.CTRL_INDEX);
        this.bHa = lVar.em(16);
        this.bHb = lVar.em(16);
        this.bHc = lVar.em(24);
        this.bHd = lVar.em(24);
        this.sampleRate = lVar.em(20);
        this.channels = lVar.em(3) + 1;
        this.bsU = lVar.em(5) + 1;
        this.bHe = (((long) lVar.em(32)) & Util.MAX_32BIT_VALUE) | ((((long) lVar.em(4)) & 15) << 32);
        AppMethodBeat.o(93135);
    }
}
