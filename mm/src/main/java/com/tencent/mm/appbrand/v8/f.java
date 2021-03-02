package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.ILoadLibraryDelegate;
import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class f {
    private static boolean dpt = false;

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(216874);
        Xz();
        AppMethodBeat.o(216874);
    }

    static {
        AppMethodBeat.i(144000);
        V8.setLoadLibraryDelegate(new ILoadLibraryDelegate() {
            /* class com.tencent.mm.appbrand.v8.f.AnonymousClass1 */

            @Override // com.eclipsesource.v8.ILoadLibraryDelegate
            public final void loadLibrary(String str) {
                AppMethodBeat.i(143996);
                try {
                    Util.nowMilliSecond();
                    f.access$000();
                    h.class.getClassLoader();
                    j.Ed("mmskia");
                    h.class.getClassLoader();
                    j.Ed("canvas");
                    h.class.getClassLoader();
                    j.Ed("skia-canvas");
                    h.class.getClassLoader();
                    j.Ed("skia-canvas-log-bridge");
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.JSRuntimeCreator", e2, "", new Object[0]);
                    if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED) {
                        AppMethodBeat.o(143996);
                        throw e2;
                    }
                }
                Log.i("MicroMsg.JSRuntimeCreator", "load so done");
                AppMethodBeat.o(143996);
            }
        });
        AppMethodBeat.o(144000);
    }

    public static h b(IJSRuntime.Config config) {
        AppMethodBeat.i(143997);
        h e2 = h.e(config);
        AppMethodBeat.o(143997);
        return e2;
    }

    public static y c(IJSRuntime.Config config) {
        AppMethodBeat.i(143998);
        y f2 = y.f(config);
        AppMethodBeat.o(143998);
        return f2;
    }

    public static y d(IJSRuntime.Config config) {
        AppMethodBeat.i(143999);
        y a2 = b.a(config);
        AppMethodBeat.o(143999);
        return a2;
    }

    public static long getNativeTransManager() {
        AppMethodBeat.i(216872);
        Xz();
        long nativeTransManager = V8.getNativeTransManager();
        AppMethodBeat.o(216872);
        return nativeTransManager;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r2 = com.tencent.mm.sdk.platformtools.Util.nowMilliSecond();
        com.tencent.mm.appbrand.v8.h.class.getClassLoader();
        com.tencent.mm.compatible.util.j.Ed("mmv8");
        com.tencent.mm.appbrand.v8.h.class.getClassLoader();
        com.tencent.mm.compatible.util.j.Ed("mmnode");
        com.tencent.mm.appbrand.v8.h.class.getClassLoader();
        com.tencent.mm.compatible.util.j.Ed("mmj2v8");
        com.tencent.mm.appbrand.v8.x.a(6, com.tencent.mm.sdk.platformtools.Util.nowMilliSecond() - r2, -1, null, -1, -1, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0050, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JSRuntimeCreator", "loadJSRuntimeSo done");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005b, code lost:
        monitor-enter(com.tencent.mm.appbrand.v8.f.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        com.tencent.mm.appbrand.v8.f.dpt = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005f, code lost:
        monitor-exit(com.tencent.mm.appbrand.v8.f.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006b, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.JSRuntimeCreator", r0, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007f, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(216873);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0082, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0083, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0085, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(216873);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0088, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void Xz() {
        /*
        // Method dump skipped, instructions count: 137
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.appbrand.v8.f.Xz():void");
    }
}
