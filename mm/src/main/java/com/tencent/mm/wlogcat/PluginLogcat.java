package com.tencent.mm.wlogcat;

import android.os.Handler;
import com.tencent.f.h;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wlogcat.a.a;
import com.tencent.mm.wlogcat.b.c;
import com.tencent.mm.xlog.app.XLogSetup;

public class PluginLogcat extends f implements a {
    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(224048);
        alias(a.class);
        AppMethodBeat.o(224048);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(224049);
        dependsOnRoot();
        AppMethodBeat.o(224049);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(224050);
        c hil = c.hil();
        if (Log.getImpl().getClass() != Xlog.class) {
            Log.e("MicroMsg.StartupLogcatCatcher", "impl is not xlog!");
        } else {
            Log.i("MicroMsg.StartupLogcatCatcher", "Log.consoleLogOpen:" + XLogSetup.isLogcatOpen);
            if (!XLogSetup.isLogcatOpen.booleanValue()) {
                int a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_logcat_startup, 0);
                Log.i("MicroMsg.StartupLogcatCatcher", "is need work :".concat(String.valueOf(a2)));
                if (a2 != 0) {
                    h.RTc.b(hil.RwD, "LogcatCatcher");
                }
            }
        }
        com.tencent.mm.wlogcat.b.b hii = com.tencent.mm.wlogcat.b.b.hii();
        if (Log.getImpl().getClass() != Xlog.class) {
            Log.e("MicroMsg.LogcatCatcher", "impl is not xlog!");
            AppMethodBeat.o(224050);
            return;
        }
        Log.i("MicroMsg.LogcatCatcher", "Log.consoleLogOpen:" + XLogSetup.isLogcatOpen);
        if (!XLogSetup.isLogcatOpen.booleanValue()) {
            int a3 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_logcat, 0);
            Log.i("MicroMsg.LogcatCatcher", "work clicfg_logcat:%d", Integer.valueOf(a3));
            if (a3 == 1 && !d.KyS) {
                int a4 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_logcat_alpha, 0);
                if (d.KyR || a4 != 0) {
                    Log.i("MicroMsg.LogcatCatcher", "is need work :".concat(String.valueOf(a3)));
                    if (a3 != 0) {
                        hii.RwM.start();
                        hii.RwN = new Handler(hii.RwM.getLooper());
                        hii.RwN.post(new Runnable() {
                            /* class com.tencent.mm.wlogcat.b.b.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(224057);
                                b.this.RwL.run();
                                h.RTc.b(b.this.RwD, "LogcatCatcher");
                                AppMethodBeat.o(224057);
                            }
                        });
                    }
                } else {
                    Log.i("MicroMsg.LogcatCatcher", "id alpha false");
                    AppMethodBeat.o(224050);
                    return;
                }
            }
        }
        AppMethodBeat.o(224050);
    }
}
