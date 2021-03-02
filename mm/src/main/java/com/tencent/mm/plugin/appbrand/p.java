package com.tencent.mm.plugin.appbrand;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad.c;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class p {
    private static final Map<String, p> hno = new a();
    private static final p kCN = new p();
    public volatile int jjN = -1;
    public volatile int jjS = 0;
    public c kCO = new c();
    public volatile String kCP;
    public final AtomicInteger kCQ = new AtomicInteger();
    public final AtomicBoolean kCR = new AtomicBoolean(false);
    public i.a kCS = null;
    public volatile String kCT;
    public volatile String kCU;
    public volatile boolean kCV;
    public volatile boolean kCW;
    public volatile boolean kCX;
    public volatile String kCY;
    public volatile int kCZ;
    public volatile boolean kDa = false;
    public volatile boolean kDb = false;
    public volatile boolean kDc = false;
    public volatile boolean kDd = false;
    public volatile boolean kDe = false;
    public volatile boolean kDf = false;
    public volatile long lastResumeTime;

    static {
        AppMethodBeat.i(134573);
        AppMethodBeat.o(134573);
    }

    private p() {
        AppMethodBeat.i(134566);
        AppMethodBeat.o(134566);
    }

    public static p Uj(String str) {
        AppMethodBeat.i(134567);
        p Uk = Uk(str);
        AppMethodBeat.o(134567);
        return Uk;
    }

    private static p Uk(String str) {
        p pVar;
        AppMethodBeat.i(134568);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(134568);
            return null;
        }
        synchronized (hno) {
            try {
                pVar = hno.get(str);
                if (pVar == null) {
                    pVar = new p();
                    hno.put(str, pVar);
                }
            } finally {
                AppMethodBeat.o(134568);
            }
        }
        return pVar;
    }

    private static p Ul(String str) {
        p pVar;
        AppMethodBeat.i(134569);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(134569);
            return null;
        }
        synchronized (hno) {
            try {
                pVar = hno.get(str);
            } finally {
                AppMethodBeat.o(134569);
            }
        }
        return pVar;
    }

    static void remove(String str) {
        AppMethodBeat.i(134570);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(134570);
            return;
        }
        synchronized (hno) {
            try {
                hno.remove(str);
            } finally {
                AppMethodBeat.o(134570);
            }
        }
    }

    public static p Um(String str) {
        AppMethodBeat.i(134571);
        p Ul = Ul(str);
        if (Ul == null) {
            p pVar = kCN;
            AppMethodBeat.o(134571);
            return pVar;
        }
        AppMethodBeat.o(134571);
        return Ul;
    }

    public static p Un(String str) {
        AppMethodBeat.i(134572);
        p Uk = Uk(str);
        AppMethodBeat.o(134572);
        return Uk;
    }
}
