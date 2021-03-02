package com.tencent.mm.plugin.appbrand.jsapi.ag;

import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;

public final class b {
    public static int abL(String str) {
        AppMethodBeat.i(215795);
        h.d Uc = h.Uc(str);
        int i2 = 1;
        if (Uc == h.d.LAUNCH_NATIVE_PAGE) {
            i2 = 2;
        } else if (Uc == h.d.BACK) {
            i2 = 3;
        } else if (Uc == h.d.CLOSE) {
            i2 = 4;
        } else if (Uc == h.d.LAUNCH_MINI_PROGRAM) {
            i2 = 5;
        } else if (Uc == h.d.HOME_PRESSED) {
            i2 = 6;
        } else if (Uc == h.d.RECENT_APPS_PRESSED) {
            i2 = 7;
        } else if (Uc == h.d.HANG) {
            i2 = 8;
        }
        AppMethodBeat.o(215795);
        return i2;
    }

    public static AppBrandRuntime y(a aVar) {
        AppMethodBeat.i(215796);
        if (aVar instanceof com.tencent.mm.plugin.appbrand.h.b) {
            f NN = aVar.NN();
            if (NN instanceof ac) {
                AppBrandRuntime runtime = ((ac) NN).getRuntime();
                AppMethodBeat.o(215796);
                return runtime;
            } else if (NN instanceof s) {
                AppBrandRuntime runtime2 = ((s) NN).getRuntime();
                AppMethodBeat.o(215796);
                return runtime2;
            } else {
                AppMethodBeat.o(215796);
                return null;
            }
        } else {
            AppMethodBeat.o(215796);
            return null;
        }
    }
}
