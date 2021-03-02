package com.tencent.mm.wlogcat.b;

import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.xlog.app.XLogSetup;

public final class a {
    private static a RwC = new a();
    private Runnable RwD = new Runnable() {
        /* class com.tencent.mm.wlogcat.b.a.AnonymousClass1 */

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0055 A[SYNTHETIC, Splitter:B:18:0x0055] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x005a A[Catch:{ Exception -> 0x0083 }] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x005f A[Catch:{ Exception -> 0x0083 }] */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x008e A[SYNTHETIC, Splitter:B:38:0x008e] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0093 A[Catch:{ Exception -> 0x009f }] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0098 A[Catch:{ Exception -> 0x009f }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 182
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.wlogcat.b.a.AnonymousClass1.run():void");
        }
    };

    static {
        AppMethodBeat.i(224054);
        AppMethodBeat.o(224054);
    }

    private a() {
        AppMethodBeat.i(224052);
        AppMethodBeat.o(224052);
    }

    public static a hig() {
        return RwC;
    }

    public final void hih() {
        AppMethodBeat.i(224053);
        if (Log.getImpl().getClass() != Xlog.class) {
            Log.e("MicroMsg.CrashLogcatCatcher", "impl is not xlog!");
            AppMethodBeat.o(224053);
            return;
        }
        Log.i("MicroMsg.CrashLogcatCatcher", "Log.consoleLogOpen:" + XLogSetup.isLogcatOpen);
        if (XLogSetup.isLogcatOpen.booleanValue()) {
            AppMethodBeat.o(224053);
            return;
        }
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_logcat_crash, 0);
        Log.i("MicroMsg.CrashLogcatCatcher", "is need work :".concat(String.valueOf(a2)));
        if (a2 == 0) {
            AppMethodBeat.o(224053);
            return;
        }
        this.RwD.run();
        AppMethodBeat.o(224053);
    }
}
