package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\rJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransferABTest;", "", "()V", "ABTEST_NEED_TRANSFER", "", "ABTEST_PHASES", "ABTEST_SWITCH", "PHASES_FINISH", "", "PHASES_ROLLBACK", "PHASES_TEST", "TAG", "isNeedTransfer", "", "isPerformanceReportOn", "phases", "isFinishPhases", "isRollbackPhases", "isTestPhases", "load", "", "onABTestUpdate", "plugin-appbrand-integration_release"})
public final class f {
    private static volatile boolean kRW;
    private static volatile int kRX = 1;
    private static volatile boolean kRY;
    public static final f kRZ;

    static {
        AppMethodBeat.i(50219);
        f fVar = new f();
        kRZ = fVar;
        fVar.vC();
        AppMethodBeat.o(50219);
    }

    private f() {
    }

    public final synchronized void vC() {
        AppMethodBeat.i(50218);
        Log.i("MicroMsg.AppBrandKVStorageTransferABTest", "[load]");
        c Fu = d.aXu().Fu("100478");
        c Fu2 = d.aXu().Fu("100483");
        p.g(Fu, "transferTest");
        if (Fu.isValid()) {
            kRW = Util.getBoolean(Fu.gzz().get("needTransfer"), false);
            kRX = Util.getInt(Fu.gzz().get("phases"), 1);
        }
        p.g(Fu2, "performanceReportSwitchTest");
        if (Fu2.isValid()) {
            kRY = Util.getBoolean(Fu2.gzz().get("switch"), false);
        }
        Log.i("MicroMsg.AppBrandKVStorageTransferABTest", "[load] isNeedTransfer=" + kRW + "  phases=" + kRX);
        Log.i("MicroMsg.AppBrandKVStorageTransferABTest", "[load] isPerformanceReportOn=" + kRY);
        AppMethodBeat.o(50218);
    }

    public final synchronized boolean bxi() {
        return kRX == 3;
    }

    public final synchronized boolean bxj() {
        return kRX == 2;
    }

    public final synchronized boolean bxk() {
        return kRY;
    }

    public final synchronized boolean bxl() {
        return kRW;
    }
}
