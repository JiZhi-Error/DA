package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f.v;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;

public final class t implements q {
    private m biA;
    private u bnh;
    private boolean bsr;

    @Override // com.google.android.exoplayer2.c.f.q
    public final void a(u uVar, g gVar, v.d dVar) {
        AppMethodBeat.i(92285);
        this.bnh = uVar;
        dVar.uW();
        this.biA = gVar.dV(dVar.getTrackId());
        this.biA.f(Format.k(dVar.uX(), "application/x-scte35"));
        AppMethodBeat.o(92285);
    }

    @Override // com.google.android.exoplayer2.c.f.q
    public final void t(com.google.android.exoplayer2.i.m mVar) {
        long j2 = -9223372036854775807L;
        AppMethodBeat.i(92286);
        if (!this.bsr) {
            if (this.bnh.xs() == -9223372036854775807L) {
                AppMethodBeat.o(92286);
                return;
            } else {
                this.biA.f(Format.d("application/x-scte35", this.bnh.xs()));
                this.bsr = true;
            }
        }
        int xd = mVar.xd();
        this.biA.a(mVar, xd);
        m mVar2 = this.biA;
        u uVar = this.bnh;
        if (uVar.bHG != -9223372036854775807L) {
            j2 = uVar.bHG;
        } else if (uVar.bqk != MAlarmHandler.NEXT_FIRE_INTERVAL) {
            j2 = uVar.bqk;
        }
        mVar2.a(j2, 1, xd, 0, null);
        AppMethodBeat.o(92286);
    }
}
