package com.tencent.mm.plugin.appbrand.q;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class c {
    public b nhs;

    public final void v(final q qVar) {
        AppMethodBeat.i(227211);
        Log.i("MicroMsg.AppBrandMultiTaskLogic", "init, runtime:%s", qVar.mAppId);
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.q.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(227210);
                if (qVar.isDestroyed() || qVar.SO) {
                    Log.w("MicroMsg.AppBrandMultiTaskLogic", "initFloatBallHelper in work thread, but runtime finished");
                    AppMethodBeat.o(227210);
                    return;
                }
                d dVar = new d(AndroidContextUtil.castActivityOrNull(qVar.mContext), qVar);
                c.this.nhs = new b(dVar, qVar);
                c.this.nhs.G(1, g.eP(qVar.mAppId, qVar.kAq.eix));
                if (qVar.bsC().kHP != null) {
                    c.this.nhs.a(qVar.bsC().kHP.kHu);
                } else {
                    Log.e("MicroMsg.AppBrandMultiTaskLogic", "multiTaskData null! enter scene:%d", Integer.valueOf(qVar.ON().cyA.scene));
                    if (qVar.ON().cyA.scene == 1089 || qVar.ON().cyA.scene == 1104) {
                        c.this.nhs.AbJ = Boolean.TRUE;
                    } else {
                        c.this.nhs.AbJ = Boolean.FALSE;
                    }
                }
                qVar.O(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.q.c.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(227209);
                        if (c.this.nhs != null) {
                            c.this.nhs.bCA();
                        }
                        AppMethodBeat.o(227209);
                    }
                });
                AppMethodBeat.o(227210);
            }
        }, "MultiTaskHelperThread");
        AppMethodBeat.o(227211);
    }

    public static void w(q qVar) {
        AppMethodBeat.i(227212);
        Log.i("MicroMsg.AppBrandMultiTaskLogic", "destroy, runtime:%s", qVar.mAppId);
        AppMethodBeat.o(227212);
    }
}
