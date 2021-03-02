package com.tencent.mm.plugin.report;

import android.annotation.SuppressLint;
import android.app.Application;
import com.tencent.matrix.d;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a;
import com.tencent.mm.app.o;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.g.b.a.g;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.report.service.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public class PluginReport extends f implements o, c, c {
    private y Cxs;
    private a.AbstractC0239a Cxt = new a.AbstractC0239a() {
        /* class com.tencent.mm.plugin.report.PluginReport.AnonymousClass1 */

        @Override // com.tencent.mm.a.a.AbstractC0239a
        public final void cg(int i2, int i3) {
            AppMethodBeat.i(224150);
            try {
                g gVar = new g();
                gVar.ejz = gVar.x("ProcessName", MMApplicationContext.getProcessName(), true);
                gVar.ejy = (long) i2;
                gVar.ejA = (long) i3;
                gVar.ejB = gVar.x("Stack", getStack(), true);
                gVar.bfK();
                AppMethodBeat.o(224150);
            } catch (Exception e2) {
                Log.e("Matrix.PluginReport", "AlarmHelper.IReportCrash Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                AppMethodBeat.o(224150);
            }
        }

        @Override // com.tencent.mm.a.a.AbstractC0239a
        @SuppressLint({"RestrictedApi"})
        public final String getStack() {
            AppMethodBeat.i(224151);
            try {
                String throwableStack = com.tencent.matrix.a.c.c.getThrowableStack(new Throwable());
                AppMethodBeat.o(224151);
                return throwableStack;
            } catch (Exception e2) {
                Log.e("Matrix.PluginReport", "getStack() %s", e2.getMessage());
                String mMStack = Util.getStack().toString();
                AppMethodBeat.o(224151);
                return mMStack;
            }
        }
    };

    public PluginReport() {
        AppMethodBeat.i(186000);
        AppMethodBeat.o(186000);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(143774);
        alias(c.class);
        AppMethodBeat.o(143774);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(143775);
        if (MMApplicationContext.isMainProcess()) {
            dependsOn(s.class);
        }
        AppMethodBeat.o(143775);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(143776);
        if (MMApplicationContext.isMainProcess()) {
            Log.i("Matrix.PluginReport", "load matrixmrs so");
            PluginReport.class.getClassLoader();
            j.Ed("matrixmrs");
            this.Cxs = new y(k.class);
            com.tencent.mm.kernel.g.a(y.class, new e(this.Cxs));
        }
        e eVar = e.INSTANCE;
        h hVar = h.INSTANCE;
        Log.i("MicroMsg.ReportService", "instance set %s", hVar);
        eVar.Cxw = hVar;
        AppMethodBeat.o(143776);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(143777);
        com.tencent.matrix.c.a((Application) MMApplicationContext.getContext(), d.INSTANCE);
        if (a.dgB == null) {
            a.dgB = this.Cxt;
        }
        AppMethodBeat.o(143777);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(143778);
        d dVar = d.INSTANCE;
        com.tencent.mm.kernel.g.aAf();
        long uin = (long) com.tencent.mm.kernel.a.getUin();
        if (dVar.isInitialized) {
            Log.i("MatrixDelegate", "[onAccountReady] uin=".concat(String.valueOf(uin)));
            Assert.assertTrue(MMApplicationContext.isMainProcess());
            com.tencent.matrix.report.h hVar = dVar.cPJ;
            MrsLogic.setUin(uin);
            hVar.isInit = true;
        }
        AppMethodBeat.o(143778);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
    }

    @Override // com.tencent.mm.kernel.b.f
    public String toString() {
        return "plugin-report";
    }

    @Override // com.tencent.mm.app.o
    public void onAppForeground(String str) {
    }

    @Override // com.tencent.mm.app.o
    public void onAppBackground(String str) {
    }
}
