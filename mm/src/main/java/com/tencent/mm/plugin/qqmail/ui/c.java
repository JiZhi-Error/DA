package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bu;
import com.tencent.mm.sdk.event.EventCenter;

public final class c implements i {
    private static long BwQ = 0;
    private a BwR;
    private Activity dKq;

    public static abstract class a {
        public abstract void eGt();

        public abstract void eGu();
    }

    public c(Activity activity) {
        AppMethodBeat.i(123141);
        g.aAg().hqi.a(138, this);
        this.dKq = activity;
        AppMethodBeat.o(123141);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(123142);
        this.BwR = aVar;
        final nb nbVar = new nb();
        nbVar.dSL.dKq = this.dKq;
        nbVar.dSL.dSN = new Runnable() {
            /* class com.tencent.mm.plugin.qqmail.ui.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(123139);
                if (nbVar.dSM.dFE) {
                    c.a(c.this);
                    AppMethodBeat.o(123139);
                    return;
                }
                if (c.this.BwR != null) {
                    c.this.BwR.eGu();
                }
                AppMethodBeat.o(123139);
            }
        };
        EventCenter.instance.asyncPublish(nbVar, Looper.myLooper());
        AppMethodBeat.o(123142);
    }

    public final void release() {
        AppMethodBeat.i(123143);
        g.aAg().hqi.b(138, this);
        AppMethodBeat.o(123143);
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        AppMethodBeat.i(123144);
        release();
        super.finalize();
        AppMethodBeat.o(123144);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(123145);
        if (i2 == 0 && i3 == 0) {
            if (this.BwR != null) {
                this.BwR.eGt();
                this.BwR = null;
            }
        } else if (this.BwR != null) {
            this.BwR.eGu();
            this.BwR = null;
        }
        BwQ = System.currentTimeMillis();
        AppMethodBeat.o(123145);
    }

    static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(123146);
        if (System.currentTimeMillis() - BwQ > 600000) {
            if (g.aAf().azp()) {
                g.azz().a(new bu(new bu.a() {
                    /* class com.tencent.mm.plugin.qqmail.ui.c.AnonymousClass2 */

                    @Override // com.tencent.mm.model.bu.a
                    public final void a(com.tencent.mm.network.g gVar) {
                        AppMethodBeat.i(123140);
                        if (gVar == null) {
                            AppMethodBeat.o(123140);
                            return;
                        }
                        gVar.aZh().a(new byte[0], new byte[0], new byte[0], gVar.aZh().getUin());
                        com.tencent.mm.plugin.qqmail.a.a.jRu.WZ();
                        AppMethodBeat.o(123140);
                    }
                }), 0);
                AppMethodBeat.o(123146);
                return;
            }
        } else if (cVar.BwR != null) {
            cVar.BwR.eGu();
        }
        AppMethodBeat.o(123146);
    }
}
