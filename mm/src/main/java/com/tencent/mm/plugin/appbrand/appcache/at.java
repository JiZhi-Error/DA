package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.platformtools.Log;

public final class at {
    private static a kMg;
    private static ICommLibReader kMh = null;

    public interface a {
        void b(ICommLibReader iCommLibReader);
    }

    public static void a(a aVar) {
        kMg = aVar;
    }

    static void c(ICommLibReader iCommLibReader) {
        AppMethodBeat.i(90567);
        synchronized (at.class) {
            try {
                kMh = iCommLibReader;
            } finally {
                AppMethodBeat.o(90567);
            }
        }
        if (kMg != null) {
            kMg.b(iCommLibReader);
        }
    }

    public static ICommLibReader bvT() {
        ICommLibReader iCommLibReader;
        AppMethodBeat.i(184407);
        synchronized (at.class) {
            try {
                iCommLibReader = kMh;
            } catch (Throwable th) {
                AppMethodBeat.o(184407);
                throw th;
            }
        }
        Log.i("MicroMsg.AppBrand.WxaCommLibPreloadSessionInMM", "getCurrentAcceptedCommLibReader [%s], stacktrace=%s", iCommLibReader, android.util.Log.getStackTraceString(new Throwable()));
        AppMethodBeat.o(184407);
        return iCommLibReader;
    }
}
