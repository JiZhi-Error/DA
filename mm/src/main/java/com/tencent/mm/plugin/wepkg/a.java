package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgPreloadFile;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.model.h;
import com.tencent.mm.plugin.wepkg.model.i;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebResourceResponse;
import java.util.Map;

public final class a {
    private static h JLr;
    private static boolean JLs = false;

    public static void cCf() {
        AppMethodBeat.i(110511);
        vC();
        AppMethodBeat.o(110511);
    }

    public static void bbZ(String str) {
        AppMethodBeat.i(110512);
        if (gkm().equals(str)) {
            JLs = true;
        }
        AppMethodBeat.o(110512);
    }

    public static void cT(String str, boolean z) {
        AppMethodBeat.i(110513);
        if (gkm().equals(str) && (JLs || d.gkr() == 0)) {
            JLs = false;
            if (z) {
                vC();
            }
        }
        AppMethodBeat.o(110513);
    }

    public static void vC() {
        AppMethodBeat.i(110514);
        Log.i("MicroMsg.CommJsLoader", "load");
        j.a(gkm(), new com.tencent.mm.plugin.wepkg.model.a() {
            /* class com.tencent.mm.plugin.wepkg.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wepkg.model.a
            public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                AppMethodBeat.i(110509);
                WepkgVersion wepkgVersion = ((WepkgCrossProcessTask) baseWepkgProcessTask).JNh;
                if (wepkgVersion == null) {
                    Log.e("MicroMsg.CommJsLoader", "wepkgVersion is null");
                    h unused = a.JLr = null;
                    AppMethodBeat.o(110509);
                } else if (wepkgVersion.version == null) {
                    Log.e("MicroMsg.CommJsLoader", "version is null");
                    h unused2 = a.JLr = null;
                    AppMethodBeat.o(110509);
                } else if (a.JLr != null && wepkgVersion.version.equals(a.JLr.JNh.version)) {
                    AppMethodBeat.o(110509);
                } else if (!wepkgVersion.JNV) {
                    Log.e("MicroMsg.CommJsLoader", "bigPackage is not ready");
                    h unused3 = a.JLr = null;
                    AppMethodBeat.o(110509);
                } else {
                    g a2 = i.a(a.gkm(), wepkgVersion.version, wepkgVersion.pkgPath, wepkgVersion.md5, wepkgVersion.JNT);
                    if (a2 == null || Util.isNullOrNil(wepkgVersion.pkgPath) || !s.YS(wepkgVersion.pkgPath)) {
                        Log.e("MicroMsg.CommJsLoader", "path not exist");
                        h unused4 = a.JLr = null;
                        AppMethodBeat.o(110509);
                        return;
                    }
                    h unused5 = a.JLr = new h(wepkgVersion, a2, (Map<String, WepkgPreloadFile>) null);
                    AppMethodBeat.o(110509);
                }
            }
        });
        AppMethodBeat.o(110514);
    }

    public static WebResourceResponse bca(String str) {
        AppMethodBeat.i(110515);
        if (d.gkt() != 0 || JLr == null) {
            Log.e("MicroMsg.CommJsLoader", "nativeJsCache is null");
            AppMethodBeat.o(110515);
            return null;
        }
        WebResourceResponse bcB = JLr.bcB(str);
        if (bcB != null) {
            AppMethodBeat.o(110515);
            return bcB;
        }
        AppMethodBeat.o(110515);
        return null;
    }

    public static String gkn() {
        if (JLr == null || JLr.JNh == null) {
            return "";
        }
        return JLr.JNh.version;
    }

    public static String gkm() {
        String str;
        AppMethodBeat.i(110510);
        if (com.tencent.mm.plugin.game.commlib.a.xvl != null) {
            if (com.tencent.mm.plugin.game.commlib.a.xvl.CommJsLib != null) {
                str = com.tencent.mm.plugin.game.commlib.a.xvl.CommJsLib.xJD;
            }
            str = null;
        } else {
            com.tencent.mm.plugin.game.commlib.a.dSS();
            str = null;
        }
        if (!Util.isNullOrNil(str)) {
            AppMethodBeat.o(110510);
            return str;
        }
        AppMethodBeat.o(110510);
        return "commlib";
    }
}
