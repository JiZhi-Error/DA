package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Set;

public class y {
    private static volatile boolean kEC = false;
    private static volatile boolean kED = false;
    private static final Set<a> kEE = new HashSet();

    public interface a {
        void brW();

        void brX();
    }

    static {
        AppMethodBeat.i(43976);
        AppMethodBeat.o(43976);
    }

    public static boolean btj() {
        boolean z;
        synchronized (y.class) {
            z = kED;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r2 == false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        r8.brW();
        com.tencent.matrix.trace.core.AppMethodBeat.o(43974);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandXWebPreloader[preload]", "start init");
        r1 = android.os.Process.getThreadPriority(android.os.Process.myTid());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        com.tencent.mm.sdk.platformtools.MMHandlerThread.setCurrentPriority(-2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        if (com.tencent.xweb.WebView.hasInited() == false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        btk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        r0 = new com.tencent.mm.pointers.PBool();
        com.tencent.mm.cr.d.a(com.tencent.xweb.WebView.c.WV_KIND_CW, new com.tencent.mm.plugin.appbrand.y.AnonymousClass1());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0067, code lost:
        if (r0.value == false) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0069, code lost:
        btk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        com.tencent.mm.sdk.platformtools.MMHandlerThread.setCurrentPriority(r1);
        com.tencent.matrix.trace.core.AppMethodBeat.o(43974);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0075, code lost:
        monitor-enter(com.tencent.mm.plugin.appbrand.y.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        com.tencent.mm.plugin.appbrand.y.kED = false;
        com.tencent.mm.plugin.appbrand.y.kEC = false;
        r0 = new java.util.HashSet(com.tencent.mm.plugin.appbrand.y.kEE);
        com.tencent.mm.plugin.appbrand.y.kEE.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0088, code lost:
        monitor-exit(com.tencent.mm.plugin.appbrand.y.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0089, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandXWebPreloader[preload]", "notifyPreloadFailed callbacks[%d]", java.lang.Integer.valueOf(r0.size()));
        r2 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a8, code lost:
        if (r2.hasNext() == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00aa, code lost:
        ((com.tencent.mm.plugin.appbrand.y.a) r2.next()).brX();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b5, code lost:
        com.tencent.mm.sdk.platformtools.MMHandlerThread.setCurrentPriority(r1);
        com.tencent.matrix.trace.core.AppMethodBeat.o(43974);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00bb, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00be, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(43974);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c4, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.tencent.mm.plugin.appbrand.y.a r8) {
        /*
        // Method dump skipped, instructions count: 197
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.y.a(com.tencent.mm.plugin.appbrand.y$a):void");
    }

    private static void btk() {
        HashSet<a> hashSet;
        AppMethodBeat.i(43975);
        synchronized (y.class) {
            try {
                kED = true;
                kEC = false;
                hashSet = new HashSet(kEE);
                kEE.clear();
            } finally {
                AppMethodBeat.o(43975);
            }
        }
        Log.i("MicroMsg.AppBrandXWebPreloader[preload]", "notifyPreloadDone callbacks[%d]", Integer.valueOf(hashSet.size()));
        for (a aVar : hashSet) {
            aVar.brW();
        }
    }
}
