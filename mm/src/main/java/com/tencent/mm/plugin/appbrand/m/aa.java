package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.ah;

public final class aa {
    private static Boolean mNW;
    private static Boolean mNX;
    private static Boolean mNY;

    public static synchronized boolean q(s sVar) {
        boolean z = false;
        synchronized (aa.class) {
            AppMethodBeat.i(204364);
            if (sVar == null) {
                h.INSTANCE.dN(1355, 6);
                Log.i("Luggage.NativeTransLogic", "isServiceOpen component null");
                AppMethodBeat.o(204364);
            } else {
                boolean g2 = g(sVar);
                boolean bMI = bMI();
                if (bMI && g2) {
                    h.INSTANCE.dN(1355, 4);
                } else if (bMI && !g2) {
                    h.INSTANCE.dN(1355, 5);
                }
                Log.i("Luggage.NativeTransLogic", "isServiceOpen isExprOpen:%b isLibMatch:%b", Boolean.valueOf(bMI()), Boolean.valueOf(g2));
                if (!g2 || !bMI) {
                    AppMethodBeat.o(204364);
                } else {
                    AppMethodBeat.o(204364);
                    z = true;
                }
            }
        }
        return z;
    }

    public static synchronized boolean f(ac acVar) {
        boolean z = true;
        synchronized (aa.class) {
            AppMethodBeat.i(204365);
            boolean bMI = bMI();
            if (mNW == null) {
                mNW = Boolean.valueOf(ah.htd());
            }
            boolean booleanValue = mNW.booleanValue();
            boolean g2 = g(acVar);
            if (bMI && booleanValue && g2) {
                h.INSTANCE.dN(1355, 0);
            } else if (bMI && !booleanValue) {
                h.INSTANCE.dN(1355, 1);
            } else if (bMI && !g2) {
                h.INSTANCE.dN(1355, 2);
            } else if (bMI && !g2 && !booleanValue) {
                h.INSTANCE.dN(1355, 3);
            }
            Log.i("Luggage.NativeTransLogic", "isWebViewOpen exprOpen:%b webviewMatch:%b libMatch:%b", Boolean.valueOf(bMI), Boolean.valueOf(booleanValue), Boolean.valueOf(g2));
            if (!bMI || !booleanValue || !g2) {
                AppMethodBeat.o(204365);
                z = false;
            } else {
                AppMethodBeat.o(204365);
            }
        }
        return z;
    }

    private static boolean g(d dVar) {
        AppMethodBeat.i(204366);
        if (mNX == null) {
            mNX = Boolean.valueOf(Boolean.parseBoolean(dVar.bqZ().UN("nativeTrans")));
        }
        boolean booleanValue = mNX.booleanValue();
        AppMethodBeat.o(204366);
        return booleanValue;
    }

    private static boolean bMI() {
        AppMethodBeat.i(204367);
        if (mNY == null) {
            mNY = Boolean.valueOf(((b) g.af(b.class)).a(b.a.clicfg_appbrand_enable_native_trans, false));
        }
        boolean booleanValue = mNY.booleanValue();
        AppMethodBeat.o(204367);
        return booleanValue;
    }

    public static void a(i iVar, int i2, String str) {
        AppMethodBeat.i(204368);
        Log.i("Luggage.NativeTransLogic", "initNativeTransComponentId componentId: %d appId:%s , stack: %s", Integer.valueOf(i2), str, android.util.Log.getStackTraceString(new Throwable()));
        iVar.evaluateJavascript("console.log('initNativeTransComponentId. ntrans:' + typeof ntrans + ' componentId :" + i2 + "')", null);
        iVar.evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.id = " + i2 + "; }", null);
        AppMethodBeat.o(204368);
    }

    public static void a(i iVar, int i2, int i3, String str) {
        AppMethodBeat.i(204369);
        Log.i("Luggage.NativeTransLogic", "initNativeTransServiceId serviceId:%d, componentId:%d, appId:%s, stack:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, android.util.Log.getStackTraceString(new Throwable()));
        iVar.evaluateJavascript("console.log('initNativeTransServiceId. ntrans:' + typeof ntrans + ' componentId :" + i3 + "')", null);
        iVar.evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.serviceId = " + i2 + "; }", null);
        AppMethodBeat.o(204369);
    }
}
