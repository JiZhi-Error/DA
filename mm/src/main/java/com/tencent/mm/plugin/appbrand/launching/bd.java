package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.util.Pair;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.launching.be;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

/* access modifiers changed from: package-private */
public final class bd {
    static boolean a(WxaAttributes wxaAttributes, ActivityStarterIpcDelegate activityStarterIpcDelegate) {
        AppMethodBeat.i(47358);
        if (1 == wxaAttributes.bAp().cyu) {
            AppBrand404PageUI.a(activityStarterIpcDelegate);
            i.T(wxaAttributes.field_appId, 14, 1);
            AppMethodBeat.o(47358);
            return false;
        }
        AppMethodBeat.o(47358);
        return true;
    }

    private static String aci(String str) {
        AppMethodBeat.i(180317);
        String str2 = null;
        com.tencent.mm.plugin.appbrand.appcache.bd a2 = n.buL().a(str, 10001, "versionMd5", "pkgPath");
        if (a2 != null && !Util.isNullOrNil(a2.field_pkgPath) && s.YS(a2.field_pkgPath) && !Util.isNullOrNil(a2.field_versionMd5) && a2.field_pkgPath.equals(s.bhK(a2.field_pkgPath))) {
            str2 = a2.field_versionMd5;
        }
        AppMethodBeat.o(180317);
        return str2;
    }

    static boolean a(String str, boolean z, aa aaVar) {
        AppMethodBeat.i(227116);
        Pair<Integer, String> bNQ = new be(str, aci(str), z).bNQ();
        int intValue = ((Integer) bNQ.first).intValue();
        String str2 = (String) bNQ.second;
        Log.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", str, Integer.valueOf(intValue), Boolean.valueOf(z));
        be.a ym = be.a.ym(intValue);
        if (ym == null) {
            switch (intValue) {
                case -13003:
                    if (aaVar.bNh()) {
                        b(str2, aaVar);
                    }
                    i.T(str, 12, 3);
                    AppMethodBeat.o(227116);
                    return false;
                case -13002:
                    ax.a((int) R.string.k2, aaVar);
                    i.T(str, 13, 3);
                    AppMethodBeat.o(227116);
                    return false;
                default:
                    if (z) {
                        AppMethodBeat.o(227116);
                        return true;
                    }
                    ax.a(MMApplicationContext.getResources().getString(R.string.pd, 3, Integer.valueOf(intValue)), aaVar);
                    AppMethodBeat.o(227116);
                    return false;
            }
        } else if (z) {
            AppMethodBeat.o(227116);
            return true;
        } else {
            switch (ym) {
                case Ok:
                    AppMethodBeat.o(227116);
                    return true;
                case Timeout:
                    ax.a((int) R.string.k1, aaVar);
                    i.T(str, 13, 3);
                    AppMethodBeat.o(227116);
                    return false;
                default:
                    ax.a((int) R.string.k0, aaVar);
                    i.T(str, 13, 3);
                    AppMethodBeat.o(227116);
                    return false;
            }
        }
    }

    private static void b(String str, aa aaVar) {
        AppMethodBeat.i(227117);
        if (Util.isNullOrNil(str)) {
            ax.a((int) R.string.k3, aaVar);
            AppMethodBeat.o(227117);
            return;
        }
        c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", str).putExtra("forceHideShare", true));
        AppMethodBeat.o(227117);
    }
}
