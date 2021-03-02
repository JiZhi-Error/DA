package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class bu extends q implements m {
    private long begin;
    private i callback;
    private final a iFh;
    private final String iFi;

    public interface a {
        void a(g gVar);
    }

    public bu(a aVar) {
        this(aVar, null);
    }

    public bu(a aVar, String str) {
        AppMethodBeat.i(132255);
        Log.i("MicroMsg.NetSceneLocalProxy", "init LocalProxy task:%s [%s] ", str, Util.getStack());
        this.iFh = aVar;
        this.iFi = str;
        AppMethodBeat.o(132255);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 0;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(132256);
        prepareDispatcher(gVar);
        this.callback = iVar;
        this.begin = Util.currentTicks();
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.model.bu.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(132253);
                bu.this.onGYNetEnd(0, 0, 0, null, null, null);
                AppMethodBeat.o(132253);
            }

            public final String toString() {
                AppMethodBeat.i(132254);
                String str = super.toString() + "|doScene";
                AppMethodBeat.o(132254);
                return str;
            }
        });
        AppMethodBeat.o(132256);
        return 0;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(132257);
        if (this.iFh != null) {
            Log.d("MicroMsg.NetSceneLocalProxy", "local proxy [%s] end, cost=%d", this.iFi, Long.valueOf(Util.ticksToNow(this.begin)));
            this.iFh.a(super.dispatcher());
        }
        this.callback.onSceneEnd(0, 0, null, this);
        AppMethodBeat.o(132257);
    }
}
