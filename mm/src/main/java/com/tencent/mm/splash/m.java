package com.tencent.mm.splash;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.splash.o;

public final class m {
    private static o.a NMA;
    private static boolean NMx = false;
    private static a NMy;
    private static boolean NMz = false;
    private static String cQi;
    private static Application gNz;

    public interface a {
        void WW();

        void a(Application application, String str);

        void a(o.a aVar);
    }

    static /* synthetic */ void Pn(String str) {
        AppMethodBeat.i(40688);
        bin(str);
        AppMethodBeat.o(40688);
    }

    public static void a(Application application, String str, final String str2) {
        boolean z = true;
        AppMethodBeat.i(40683);
        gNz = application;
        cQi = str;
        h.a(new o() {
            /* class com.tencent.mm.splash.m.AnonymousClass1 */

            @Override // com.tencent.mm.splash.o
            public final void d(o.a aVar) {
                AppMethodBeat.i(40682);
                Log.i("MicroMsg.SplashInit", "do one more thing");
                o.a unused = m.NMA = aVar;
                m.Pn(str2);
                m.gyy();
                AppMethodBeat.o(40682);
            }
        });
        h.gyq().mStartTimestamp = System.currentTimeMillis();
        if (!application.getPackageName().equals(str)) {
            h.c("MicroMsg.SplashInit", "not main process(%s), no hack, do fallback.", str);
        } else if (!h.o(application)) {
            h.gyq().idkey(675, 5, 1);
            h.jC(application);
            h.c("MicroMsg.SplashInit", "hack failed, do fallback logic.", new Object[0]);
        } else {
            z = false;
            h.gyl();
        }
        NMx = z;
        if (h.NLG != null) {
            h.NLG.WV();
        }
        if (z) {
            if (a.jw(application)) {
                try {
                    a.jy(application);
                    boolean jA = a.jA(application);
                    h.c("MicroMsg.SplashInit", "block checking dex opt result: %s", Boolean.valueOf(jA));
                    if (!jA) {
                        h.c("MicroMsg.SplashInit", "dexopt service return failed or timeout. kill self.", new Object[0]);
                        h.eCp();
                    }
                } catch (InterruptedException e2) {
                    RuntimeException runtimeException = new RuntimeException(e2);
                    AppMethodBeat.o(40683);
                    throw runtimeException;
                }
            }
            a.jx(application);
        }
        if (g.zF || z) {
            bin(str2);
        }
        AppMethodBeat.o(40683);
    }

    private static void bin(String str) {
        AppMethodBeat.i(40684);
        if (NMy != null) {
            AppMethodBeat.o(40684);
            return;
        }
        a bio = bio(str);
        bio.a(gNz, cQi);
        NMy = bio;
        AppMethodBeat.o(40684);
    }

    public static void gyy() {
        AppMethodBeat.i(40685);
        if (NMz && NMA != null) {
            NMy.a(NMA);
        }
        AppMethodBeat.o(40685);
    }

    public static void gyz() {
        AppMethodBeat.i(40686);
        h.c("MicroMsg.SplashInit", "applicationOnCreate", new Object[0]);
        h.gyh();
        NMz = true;
        if (NMx) {
            NMy.WW();
            AppMethodBeat.o(40686);
            return;
        }
        gyy();
        AppMethodBeat.o(40686);
    }

    private static a bio(String str) {
        AppMethodBeat.i(40687);
        try {
            a aVar = (a) Class.forName(str).newInstance();
            AppMethodBeat.o(40687);
            return aVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SplashInit", e2, "%s has problem!", str);
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(40687);
            throw runtimeException;
        }
    }
}
