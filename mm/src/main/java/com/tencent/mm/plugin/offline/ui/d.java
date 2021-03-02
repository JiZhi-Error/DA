package com.tencent.mm.plugin.offline.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class d extends IListener<xk> {
    private MMHandler mHandler = new MMHandler(Looper.getMainLooper());

    public d() {
        AppMethodBeat.i(66399);
        this.__eventId = xk.class.getName().hashCode();
        AppMethodBeat.o(66399);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(xk xkVar) {
        AppMethodBeat.i(66400);
        final xk xkVar2 = xkVar;
        if (g.aAc() && (xkVar2 instanceof xk)) {
            Log.i("MicroMsg.SyncOfflineTokenListener", "SyncOfflineTokenListener -> updateToken()");
            boolean z = xkVar2.edE.edF;
            final boolean z2 = xkVar2.edE.scene == 1;
            if (z2) {
                h.INSTANCE.idkeyStat(135, 25, 1, true);
            }
            if (z) {
                this.mHandler.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.offline.ui.d.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(66398);
                        if (g.aAc()) {
                            if (xkVar2.edE.edG) {
                                k.ezn();
                                i ezq = k.ezq();
                                int i2 = xkVar2.edE.edH;
                                ezq.hE(i2, i2);
                                AppMethodBeat.o(66398);
                                return;
                            }
                            k.ezn();
                            k.ezq().sx(z2);
                        }
                        AppMethodBeat.o(66398);
                    }
                }, 10000);
            } else if (xkVar2.edE.edG) {
                k.ezn();
                i ezq = k.ezq();
                int i2 = xkVar2.edE.edH;
                ezq.hE(i2, i2);
            } else {
                k.ezn();
                k.ezq().sx(z2);
            }
        }
        AppMethodBeat.o(66400);
        return false;
    }
}
