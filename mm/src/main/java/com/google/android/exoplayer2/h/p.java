package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.h.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;

public final class p extends s.a {
    private final w<? super g> bEI;
    private final boolean bFs;
    private final int bFt;
    private final int bFu;
    private final String userAgent;

    public p(String str) {
        this(str, null);
    }

    public p(String str, w<? super g> wVar) {
        this(str, wVar, false);
    }

    public p(String str, w<? super g> wVar, boolean z) {
        this.userAgent = str;
        this.bEI = wVar;
        this.bFt = TXRecordCommon.AUDIO_SAMPLERATE_8000;
        this.bFu = TXRecordCommon.AUDIO_SAMPLERATE_8000;
        this.bFs = z;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.h.s.a
    public final /* synthetic */ s a(s.f fVar) {
        AppMethodBeat.i(93078);
        o oVar = new o(this.userAgent, this.bEI, this.bFt, this.bFu, this.bFs, fVar);
        AppMethodBeat.o(93078);
        return oVar;
    }
}
