package com.google.android.exoplayer2.i;

import android.os.SystemClock;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s implements i {
    private long bHD;
    private long bHE;
    private p bcs = p.bdM;
    private boolean started;

    public final void start() {
        AppMethodBeat.i(93198);
        if (!this.started) {
            this.bHE = SystemClock.elapsedRealtime();
            this.started = true;
        }
        AppMethodBeat.o(93198);
    }

    public final void stop() {
        AppMethodBeat.i(93199);
        if (this.started) {
            ah(tV());
            this.started = false;
        }
        AppMethodBeat.o(93199);
    }

    public final void ah(long j2) {
        AppMethodBeat.i(93200);
        this.bHD = j2;
        if (this.started) {
            this.bHE = SystemClock.elapsedRealtime();
        }
        AppMethodBeat.o(93200);
    }

    public final void a(i iVar) {
        AppMethodBeat.i(93201);
        ah(iVar.tV());
        this.bcs = iVar.tZ();
        AppMethodBeat.o(93201);
    }

    @Override // com.google.android.exoplayer2.i.i
    public final long tV() {
        AppMethodBeat.i(93202);
        long j2 = this.bHD;
        if (this.started) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.bHE;
            if (this.bcs.bdN == 1.0f) {
                j2 += b.w(elapsedRealtime);
            } else {
                j2 += elapsedRealtime * ((long) this.bcs.bdO);
            }
        }
        AppMethodBeat.o(93202);
        return j2;
    }

    @Override // com.google.android.exoplayer2.i.i
    public final p c(p pVar) {
        AppMethodBeat.i(93203);
        if (this.started) {
            ah(tV());
        }
        this.bcs = pVar;
        AppMethodBeat.o(93203);
        return pVar;
    }

    @Override // com.google.android.exoplayer2.i.i
    public final p tZ() {
        return this.bcs;
    }
}
