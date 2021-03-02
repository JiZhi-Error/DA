package com.tencent.mm.plugin.sns.ad.widget.countdown;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.sns.ad.e.g;
import com.tencent.mm.plugin.sns.ad.i.e;
import com.tencent.mm.sdk.platformtools.Log;

public final class b implements g.a, d {
    private g DAs;
    private e.a DAt = new e.a();
    private c DAu;

    public b(long j2, long j3) {
        AppMethodBeat.i(202397);
        this.DAs = new g(j2, j3) {
            /* class com.tencent.mm.plugin.sns.ad.widget.countdown.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sns.ad.e.g
            public final boolean isValid() {
                AppMethodBeat.i(202395);
                boolean ap = e.ap(this.mStartTime, this.DsM);
                AppMethodBeat.o(202395);
                return ap;
            }

            @Override // com.tencent.mm.plugin.sns.ad.e.g
            public final long eWP() {
                AppMethodBeat.i(202396);
                long aWA = cl.aWA();
                AppMethodBeat.o(202396);
                return aWA;
            }
        };
        AppMethodBeat.o(202397);
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.countdown.d
    public final void a(c cVar) {
        this.DAu = cVar;
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.countdown.d
    public final void eYr() {
        AppMethodBeat.i(202398);
        Log.d("SnsAd.CountDownViewModel", "startCountDown is called");
        this.DAs.a(this);
        AppMethodBeat.o(202398);
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.countdown.d
    public final void eYs() {
        AppMethodBeat.i(202399);
        Log.d("SnsAd.CountDownViewModel", "stopCountDown is called");
        g gVar = this.DAs;
        if (gVar.DsO != null) {
            gVar.DsO.cancel();
            gVar.DsO = null;
        }
        gVar.DsP = null;
        AppMethodBeat.o(202399);
    }

    @Override // com.tencent.mm.plugin.sns.ad.e.g.a
    public final void IO(long j2) {
        AppMethodBeat.i(202400);
        e.a a2 = e.a(j2, this.DAt);
        c cVar = this.DAu;
        if (cVar != null) {
            cVar.b(j2, a2);
        }
        AppMethodBeat.o(202400);
    }
}
