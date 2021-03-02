package com.tencent.luggage.game.g;

import android.app.Activity;
import android.os.Build;
import android.view.WindowInsets;
import com.tencent.luggage.game.d.a.a.b;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.n;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ap;

public class a {

    /* renamed from: com.tencent.luggage.game.g.a$a  reason: collision with other inner class name */
    public static class C0173a {
        volatile boolean done = false;
    }

    public static void a(C0173a aVar, Runnable runnable) {
        AppMethodBeat.i(130704);
        if (aVar == null) {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(130704);
            throw illegalStateException;
        } else if (aVar.done) {
            AppMethodBeat.o(130704);
        } else {
            boolean z = false;
            synchronized (a.class) {
                try {
                    if (!aVar.done) {
                        z = true;
                        aVar.done = true;
                    }
                } finally {
                    AppMethodBeat.o(130704);
                }
            }
            if (z) {
                runnable.run();
            }
        }
    }

    public static int b(d dVar) {
        WindowInsets bo;
        int stableInsetTop;
        AppMethodBeat.i(222892);
        if (!(dVar.NP() == null || dVar.S(com.tencent.luggage.game.d.a.a.a.class) == null)) {
            if (((b) dVar.S(b.class)) == null || !(dVar.kEb instanceof o)) {
                Log.printErrStackTrace("MicroMsg.WAGameCommonUtil", new com.tencent.luggage.game.d.a.a.d(), "hy: not game service", new Object[0]);
            } else if (Build.VERSION.SDK_INT >= 21) {
                Activity ay = dVar.ay(Activity.class);
                if (!(ay == null || (bo = ap.bo(ay)) == null || (stableInsetTop = bo.getStableInsetTop()) <= 0)) {
                    int zB = g.zB(stableInsetTop);
                    AppMethodBeat.o(222892);
                    return zB;
                }
            } else {
                int D = n.D(dVar.getContext(), 0);
                if (D > 0) {
                    int zB2 = g.zB(D);
                    AppMethodBeat.o(222892);
                    return zB2;
                }
            }
        }
        AppMethodBeat.o(222892);
        return 0;
    }
}
