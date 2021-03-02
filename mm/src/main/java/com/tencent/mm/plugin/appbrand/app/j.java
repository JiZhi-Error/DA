package com.tencent.mm.plugin.appbrand.app;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;

public final class j {
    private static boolean kII = false;

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: com.tencent.mm.kernel.c */
    /* JADX WARN: Multi-variable type inference failed */
    public static f UJ(String str) {
        f fVar;
        AppMethodBeat.i(44132);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(44132);
            return null;
        }
        try {
            Class<?> cls = Class.forName(str);
            if (f.class.isAssignableFrom(cls)) {
                synchronized (cls) {
                    try {
                        fVar = (f) g.aAd().ah(cls);
                        if (fVar == null || com.tencent.mm.kernel.f.bx(fVar)) {
                            fVar = g.aAd().ad(cls);
                            fVar.execute(g.aAe().azG());
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(44132);
                        throw th;
                    }
                }
                AppMethodBeat.o(44132);
                return fVar;
            }
            Log.e("MicroMsg.AppBrand.MMKernelPluginsInstallHelper", "class string %s, not a Plugin", str);
            AppMethodBeat.o(44132);
            return null;
        } catch (ClassCastException | ClassNotFoundException e2) {
            Log.e("MicroMsg.AppBrand.MMKernelPluginsInstallHelper", "plugin %s not found. e=%s", str, e2);
        }
    }

    public static void bur() {
        AppMethodBeat.i(44133);
        synchronized (com.tencent.mm.plugin.e.f.class) {
            try {
                if (!kII) {
                    new com.tencent.mm.plugin.e.f().execute(g.aAe().azG());
                    kII = true;
                }
            } finally {
                AppMethodBeat.o(44133);
            }
        }
    }
}
