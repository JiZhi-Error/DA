package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.h;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public final class z {
    private static final b.l nqx = new b.d();
    private static final h<AppBrandRuntime, String> nqy = new h<>();

    static {
        AppMethodBeat.i(135112);
        AppMethodBeat.o(135112);
    }

    public static Bitmap k(AppBrandRuntime appBrandRuntime, String str) {
        AppMethodBeat.i(135111);
        if (appBrandRuntime == null) {
            AppMethodBeat.o(135111);
            return null;
        }
        String Wd = n.Wd(str);
        if (Util.isNullOrNil(Wd)) {
            AppMethodBeat.o(135111);
            return null;
        }
        String str2 = (appBrandRuntime.hashCode() + 35) + Wd;
        nqy.r(appBrandRuntime, str2);
        Bitmap EP = nqx.EP(str2);
        if (EP == null || EP.isRecycled()) {
            InputStream f2 = bg.f(appBrandRuntime, Wd);
            if (f2 != null) {
                try {
                    if (f2.available() > 0) {
                        Bitmap decodeStream = BitmapUtil.decodeStream(f2);
                        if (decodeStream == null || decodeStream.isRecycled()) {
                            if (f2 != null) {
                                Util.qualityClose(f2);
                            }
                            AppMethodBeat.o(135111);
                            return null;
                        }
                        nqx.put(str2, decodeStream);
                        if (f2 != null) {
                            Util.qualityClose(f2);
                        }
                        AppMethodBeat.o(135111);
                        return decodeStream;
                    }
                } catch (IOException e2) {
                    Log.e("MicroMsg.AppBrandPageIconCache", "try decode icon e = %s", e2);
                    if (f2 != null) {
                        Util.qualityClose(f2);
                    }
                } catch (Throwable th) {
                    if (f2 != null) {
                        Util.qualityClose(f2);
                    }
                    AppMethodBeat.o(135111);
                    throw th;
                }
            }
            if (f2 != null) {
                Util.qualityClose(f2);
            }
            AppMethodBeat.o(135111);
            return null;
        }
        AppMethodBeat.o(135111);
        return EP;
    }

    public static void af(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(219429);
        Set<String> cN = nqy.cN(appBrandRuntime);
        if (cN != null) {
            for (String str : cN) {
                nqx.remove(str);
            }
        }
        AppMethodBeat.o(219429);
    }
}
