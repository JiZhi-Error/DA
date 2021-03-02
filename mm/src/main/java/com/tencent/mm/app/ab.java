package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.svg.a.e;
import com.tencent.mm.svg.b.c;

public final class ab {
    private static Class<?> dmm = null;
    private static Application dmn;
    private static String mPackageName = null;
    private static Resources sResources;

    public static void ab(Class<?> cls) {
        dmm = cls;
    }

    public static void gm(String str) {
        mPackageName = str;
    }

    public static void WH() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(19470);
        Log.i("MicroMsg.SVGInit", "SVG initSVGPreload");
        e.a(new c.a() {
            /* class com.tencent.mm.app.ab.AnonymousClass1 */

            @Override // com.tencent.mm.svg.b.c.a
            public final void w(String str, String str2, Object... objArr) {
                AppMethodBeat.i(19465);
                Log.w(str, str2, objArr);
                AppMethodBeat.o(19465);
            }

            @Override // com.tencent.mm.svg.b.c.a
            public final void i(String str, String str2, Object... objArr) {
                AppMethodBeat.i(19466);
                Log.i(str, str2, objArr);
                AppMethodBeat.o(19466);
            }

            @Override // com.tencent.mm.svg.b.c.a
            public final void e(String str, String str2, Object... objArr) {
                AppMethodBeat.i(19467);
                Log.e(str, str2, objArr);
                AppMethodBeat.o(19467);
            }

            @Override // com.tencent.mm.svg.b.c.a
            public final void d(String str, String str2, Object... objArr) {
                AppMethodBeat.i(19468);
                Log.d(str, str2, objArr);
                AppMethodBeat.o(19468);
            }

            @Override // com.tencent.mm.svg.b.c.a
            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                AppMethodBeat.i(19469);
                Log.printErrStackTrace(str, th, str2, objArr);
                AppMethodBeat.o(19469);
            }
        });
        e.ab(dmm);
        e.a(dmn, sResources, mPackageName);
        try {
            if (dmn.getBaseContext().getResources().getDrawable(R.raw.actionbar_icon) != null) {
                z = true;
            } else {
                z = false;
            }
            b aBh = b.aBh();
            if (z) {
                z2 = false;
            }
            aBh.htN = z2;
            AppMethodBeat.o(19470);
        } catch (Throwable th) {
            b.aBh().htN = true;
            AppMethodBeat.o(19470);
            throw th;
        }
    }

    public static void a(Application application, Resources resources) {
        AppMethodBeat.i(19471);
        e.c(application, mPackageName);
        dmn = application;
        sResources = resources;
        AppMethodBeat.o(19471);
    }
}
