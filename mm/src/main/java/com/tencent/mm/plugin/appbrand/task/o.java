package com.tencent.mm.plugin.appbrand.task;

import android.os.SystemClock;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.n;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;

/* access modifiers changed from: package-private */
public final class o extends AppBrandMainProcessService.a {
    final String mProcessName;
    final n nQA;
    long nQB = 0;
    boolean nQC;

    public o(n nVar, String str) {
        this.nQA = nVar;
        this.mProcessName = str;
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a
    public final void Uf(String str) {
        AppMethodBeat.i(227527);
        if (!this.mProcessName.equals(str)) {
            AppMethodBeat.o(227527);
            return;
        }
        this.nQA.nQw.set(true);
        if (this.nQB == 0) {
            this.nQB = SystemClock.elapsedRealtime();
        }
        Log.i("MicroMsg.ClientProcessStateListener", "onConnected: ".concat(String.valueOf(str)));
        AppMethodBeat.o(227527);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a
    public final void onDisconnected(final String str) {
        AppMethodBeat.i(227528);
        h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.task.o.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(227526);
                o oVar = o.this;
                String str = str;
                if (oVar.mProcessName.equals(str)) {
                    AppBrandMainProcessService.b(oVar);
                    oVar.nQA.nQw.set(false);
                    long elapsedRealtime = (long) ((int) ((SystemClock.elapsedRealtime() - oVar.nQB) / 1000));
                    if (elapsedRealtime < 0 || oVar.nQB == 0) {
                        Log.e("MicroMsg.ClientProcessStateListener", "onDied: name = [%s], got a invalid time [%s] - [%s] = [%s]", oVar.nQA.nQm, String.valueOf(SystemClock.elapsedRealtime()), String.valueOf(oVar.nQB), String.valueOf(elapsedRealtime));
                    } else if (!oVar.nQC || !oVar.nQA.bWp()) {
                        oVar.Bp(elapsedRealtime);
                    } else {
                        if (elapsedRealtime <= 60) {
                            e.INSTANCE.idkeyStat(365, 6, 1, false);
                        } else if (elapsedRealtime <= 120) {
                            e.INSTANCE.idkeyStat(365, 7, 1, false);
                        } else if (elapsedRealtime <= 300) {
                            e.INSTANCE.idkeyStat(365, 8, 1, false);
                        } else if (elapsedRealtime <= 600) {
                            e.INSTANCE.idkeyStat(365, 9, 1, false);
                        } else if (elapsedRealtime <= 1200) {
                            e.INSTANCE.idkeyStat(365, 10, 1, false);
                        } else {
                            e.INSTANCE.idkeyStat(365, 11, 1, false);
                        }
                        n nVar = new n();
                        nVar.ekD = 1000 * elapsedRealtime;
                        a.C0792a aVar = a.nKn;
                        nVar.hS(a.C0792a.getFlags());
                        nVar.ekE = 3;
                        nVar.bfK();
                        Log.d("MicroMsg.ClientProcessStateListener", "onDisconnected: [%s]" + nVar.abW(), str);
                    }
                    oVar.nQB = 0;
                }
                AppMethodBeat.o(227526);
            }
        });
        AppMethodBeat.o(227528);
    }

    /* access modifiers changed from: package-private */
    public final void Bp(long j2) {
        AppMethodBeat.i(227529);
        for (AppBrandRemoteTaskController appBrandRemoteTaskController : this.nQA.bWx()) {
            if (appBrandRemoteTaskController == null) {
                AppMethodBeat.o(227529);
                return;
            }
            String str = appBrandRemoteTaskController.mAppId;
            if (str != null && !str.isEmpty()) {
                n nVar = new n();
                nVar.hR(appBrandRemoteTaskController.mAppId);
                nVar.ekD = System.currentTimeMillis() - this.nQA.afp(appBrandRemoteTaskController.mAppId);
                nVar.ekC = (long) appBrandRemoteTaskController.appType;
                a.C0792a aVar = a.nKn;
                nVar.hS(a.C0792a.getFlags());
                nVar.ekE = 0;
                nVar.hT(appBrandRemoteTaskController.nPi);
                nVar.bfK();
            }
        }
        Log.i("MicroMsg.ClientProcessStateListener", "onDied: name = [%s], alive = [%d]seconds", this.nQA.nQm, Long.valueOf(j2));
        AppMethodBeat.o(227529);
    }
}
