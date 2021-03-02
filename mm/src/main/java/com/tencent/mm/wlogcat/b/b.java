package com.tencent.mm.wlogcat.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.xlog.app.XLogSetup;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b {
    private static final b RwF = new b();
    private Runnable RwD = new Runnable() {
        /* class com.tencent.mm.wlogcat.b.b.AnonymousClass1 */

        /* JADX WARNING: Removed duplicated region for block: B:39:0x00e4 A[SYNTHETIC, Splitter:B:39:0x00e4] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00e9 A[Catch:{ Exception -> 0x0115 }] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00ee A[Catch:{ Exception -> 0x0115 }] */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x012a A[SYNTHETIC, Splitter:B:60:0x012a] */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x012f A[Catch:{ Exception -> 0x013b }] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0134 A[Catch:{ Exception -> 0x013b }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 352
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.wlogcat.b.b.AnonymousClass1.run():void");
        }
    };
    private final long RwG = Util.MILLSECONDS_OF_MINUTE;
    private final long RwH = 524288000;
    private final long RwI = 6442450944L;
    private boolean RwJ = true;
    private boolean RwK = true;
    private Runnable RwL = new Runnable() {
        /* class com.tencent.mm.wlogcat.b.b.AnonymousClass2 */

        public final void run() {
            boolean z;
            o[] het;
            AppMethodBeat.i(224056);
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_logcat, 1) == 1) {
                b.this.RwK = true;
                if (!b.this.RwJ) {
                    Log.e("MicroMsg.LogcatCatcher", "checker not safe!");
                    AppMethodBeat.o(224056);
                } else if (!b.hik()) {
                    Log.e("MicroMsg.LogcatCatcher", "no space!");
                    b.this.RwJ = false;
                    AppMethodBeat.o(224056);
                } else {
                    String hij = b.hij();
                    if (hij.isEmpty()) {
                        Log.e("MicroMsg.LogcatCatcher", "errorCheck nameprefix empty!");
                        AppMethodBeat.o(224056);
                        return;
                    }
                    String str = hij + "_" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".xlog";
                    o oVar = new o(XLogSetup.logPath);
                    if (!oVar.isDirectory() || (het = oVar.het()) == null) {
                        z = true;
                    } else {
                        z = true;
                        for (o oVar2 : het) {
                            if (oVar2.getName().contains(str)) {
                                long length = oVar2.length();
                                Log.i("MicroMsg.LogcatCatcher", "checker find target file:%s, size:%s", str, String.valueOf(length));
                                if (length > 524288000) {
                                    Log.e("MicroMsg.LogcatCatcher", "maybe error! stop!");
                                    z = false;
                                }
                            }
                        }
                    }
                    b.this.RwN.removeCallbacks(b.this.RwL);
                    if (z) {
                        b.this.RwN.postDelayed(b.this.RwL, Util.MILLSECONDS_OF_MINUTE);
                        AppMethodBeat.o(224056);
                        return;
                    }
                    b.this.RwJ = false;
                    h.INSTANCE.n(1504, 2, 1);
                    AppMethodBeat.o(224056);
                }
            } else {
                b.this.RwK = false;
                Log.e("MicroMsg.LogcatCatcher", "no need to work");
                AppMethodBeat.o(224056);
            }
        }
    };
    public HandlerThread RwM = new HandlerThread("LogcatCatcher");
    public Handler RwN = null;

    static {
        AppMethodBeat.i(224062);
        AppMethodBeat.o(224062);
    }

    private b() {
        AppMethodBeat.i(224058);
        AppMethodBeat.o(224058);
    }

    public static b hii() {
        return RwF;
    }

    private static long cyO() {
        long j2;
        AppMethodBeat.i(224059);
        try {
            StatFs statFs = new StatFs(com.tencent.mm.loader.j.b.aKD());
            j2 = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Exception e2) {
            j2 = 0;
        }
        if (j2 <= 0) {
            AppMethodBeat.o(224059);
            return 1;
        }
        AppMethodBeat.o(224059);
        return j2;
    }

    static /* synthetic */ String hij() {
        AppMethodBeat.i(224060);
        String processName = MMApplicationContext.getProcessName();
        if (MMApplicationContext.isMainProcess()) {
            AppMethodBeat.o(224060);
            return "LOGCATMM";
        } else if (processName.endsWith(":push")) {
            AppMethodBeat.o(224060);
            return "LOGCATPUSH";
        } else if (processName.endsWith(":tools")) {
            AppMethodBeat.o(224060);
            return "LOGCATTOOLS";
        } else if (processName.endsWith(":toolsmp")) {
            AppMethodBeat.o(224060);
            return "LOGCATTOOLSMP";
        } else if (processName.endsWith(":appbrand0")) {
            AppMethodBeat.o(224060);
            return "LOGCATAPPBRAND0";
        } else if (processName.endsWith(":appbrand1")) {
            AppMethodBeat.o(224060);
            return "LOGCATAPPBRAND1";
        } else if (processName.endsWith(":appbrand2")) {
            AppMethodBeat.o(224060);
            return "LOGCATAPPBRAND2";
        } else if (processName.endsWith(":appbrand3")) {
            AppMethodBeat.o(224060);
            return "LOGCATAPPBRAND3";
        } else if (processName.endsWith(":appbrand4")) {
            AppMethodBeat.o(224060);
            return "LOGCATAPPBRAND4";
        } else {
            AppMethodBeat.o(224060);
            return "";
        }
    }

    static /* synthetic */ boolean hik() {
        boolean z;
        AppMethodBeat.i(224061);
        long cyO = cyO();
        StringBuilder append = new StringBuilder("gree space:").append(cyO).append(" |6442450944|");
        if (cyO >= 6442450944L) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.LogcatCatcher", append.append(z).toString());
        if (cyO >= 6442450944L) {
            AppMethodBeat.o(224061);
            return true;
        }
        AppMethodBeat.o(224061);
        return false;
    }
}
