package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.wr;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.network.p;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class r {
    private static boolean pfe = false;

    public static synchronized void eJ(final Context context) {
        synchronized (r.class) {
            AppMethodBeat.i(22382);
            if (pfe) {
                AppMethodBeat.o(22382);
            } else {
                pfe = true;
                g.aAg().a(new p.a() {
                    /* class com.tencent.mm.plugin.bbom.r.AnonymousClass1 */

                    @Override // com.tencent.mm.network.p
                    public final void onNetworkChange(int i2) {
                        AppMethodBeat.i(22381);
                        if (i2 == 4 || i2 == 6) {
                            r.ckq();
                            AppMethodBeat.o(22381);
                            return;
                        }
                        AppMethodBeat.o(22381);
                    }
                });
                AppMethodBeat.o(22382);
            }
        }
    }

    static /* synthetic */ void ckq() {
        AppMethodBeat.i(22383);
        if (!g.aAc() || a.azj()) {
            Log.w("MicroMsg.OnNetworkAvailableListener", "dealWithNetworkAvailable hasSetuin:" + g.aAc() + " isHold:" + a.azj());
            AppMethodBeat.o(22383);
            return;
        }
        o.bid().run();
        com.tencent.mm.modelvideo.o.bho().run();
        q.bcP().run();
        ao.gnh().run();
        if (ay.a.iDt != null) {
            ay.a.iDt.aVr();
        }
        EventCenter.instance.publish(new wr());
        AppMethodBeat.o(22383);
    }
}
