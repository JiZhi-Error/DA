package com.tencent.mm.plugin.e;

import android.content.Intent;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.o;
import com.tencent.mm.ak.t;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMAppMgr;

public final class e extends a {
    private aw iDw;

    public e(aw awVar) {
        this.iDw = awVar;
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
        AppMethodBeat.i(22638);
        bg.a(this.iDw, new t.a() {
            /* class com.tencent.mm.plugin.e.e.AnonymousClass1 */

            @Override // com.tencent.mm.ak.t.a
            public final void a(t tVar, boolean z) {
                AppMethodBeat.i(22637);
                if (z && !tVar.foreground) {
                    if (!e.ckQ()) {
                        Log.w("MicroMsg.MMCoreInitTask", "can't kill the working process");
                        AppMethodBeat.o(22637);
                        return;
                    }
                    MMAppMgr.gIT();
                    Log.appenderClose();
                    Mars.onSingalCrash(0);
                    Log.e("MicroMsg.MMCoreInitTask", "now killing the working process....");
                    if (com.tencent.mm.platformtools.a.bln()) {
                        Log.e("MicroMsg.MMCoreInitTask", "address book syncing, wait a minute please");
                        AppMethodBeat.o(22637);
                        return;
                    }
                    c.bs(new Intent(MMApplicationContext.getContext(), NotifyReceiver.NotifyService.class));
                    o.H(new Runnable() {
                        /* class com.tencent.mm.plugin.e.e.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(22636);
                            AppMethodBeat.o(22636);
                        }
                    });
                }
                AppMethodBeat.o(22637);
            }

            @Override // com.tencent.mm.ak.t.a
            public final void a(t tVar) {
            }
        });
        AppMethodBeat.o(22638);
    }

    static /* synthetic */ boolean ckQ() {
        AppMethodBeat.i(22639);
        if (com.tencent.mm.ay.a.bec()) {
            AppMethodBeat.o(22639);
            return false;
        }
        xq xqVar = new xq();
        xqVar.edR.edT = true;
        EventCenter.instance.publish(xqVar);
        if (!Util.isNullOrNil(xqVar.edS.edV)) {
            AppMethodBeat.o(22639);
            return false;
        }
        AppMethodBeat.o(22639);
        return true;
    }
}
