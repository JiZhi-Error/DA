package com.google.android.exoplayer2.h.a;

import com.google.android.exoplayer2.h.a.d;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.r;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e implements g.a {
    private final a bFT;
    private final d.a bGc;
    private final g.a bGn;
    private final g.a bGo;
    private final f.a bGp;
    private final int flags;

    @Override // com.google.android.exoplayer2.h.g.a
    public final /* synthetic */ g wG() {
        AppMethodBeat.i(92975);
        d wR = wR();
        AppMethodBeat.o(92975);
        return wR;
    }

    public e(a aVar, g.a aVar2) {
        this(aVar, aVar2, (byte) 0);
    }

    private e(a aVar, g.a aVar2, byte b2) {
        this(aVar, aVar2, (char) 0);
    }

    private e(a aVar, g.a aVar2, char c2) {
        this(aVar, aVar2, new r(), new c(aVar, 2097152), 0, null);
        AppMethodBeat.i(196062);
        AppMethodBeat.o(196062);
    }

    public e(a aVar, g.a aVar2, g.a aVar3, f.a aVar4, int i2, d.a aVar5) {
        this.bFT = aVar;
        this.bGn = aVar2;
        this.bGo = aVar3;
        this.bGp = aVar4;
        this.flags = i2;
        this.bGc = aVar5;
    }

    public final d wR() {
        AppMethodBeat.i(92974);
        d dVar = new d(this.bFT, this.bGn.wG(), this.bGo.wG(), this.bGp != null ? this.bGp.wF() : null, this.flags, this.bGc);
        AppMethodBeat.o(92974);
        return dVar;
    }
}
