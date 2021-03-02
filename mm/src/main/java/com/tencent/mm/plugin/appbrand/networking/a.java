package com.tencent.mm.plugin.appbrand.networking;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiArgsCheckUtil;", "", "()V", "TAG", "", "isValidCgiArgs", "", "appId", "userName", "plugin-appbrand-integration_release"})
public final class a {
    public static final a njw = new a();

    static {
        AppMethodBeat.i(229061);
        AppMethodBeat.o(229061);
    }

    private a() {
    }

    public static final boolean eA(String str, String str2) {
        boolean z;
        AppMethodBeat.i(229060);
        if (!(((b) g.af(b.class)).a(b.a.clicfg_app_brand_cgi_valid_check, 1) == 1)) {
            AppMethodBeat.o(229060);
            return true;
        }
        String nullAs = Util.nullAs(str, "");
        if (nullAs == null) {
            p.hyc();
        }
        String nullAs2 = Util.nullAs(str2, "");
        if (nullAs2 == null) {
            p.hyc();
        }
        if (!(str == null && str2 == null) && (!n.aL(nullAs) || (!n.aL(nullAs2) && n.nm(nullAs2, "@app") && nullAs2.length() >= 5))) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Log.e("MicroMsg.AppBrandCgiArgsCheckUtil", "isValidCgiArgs: invalid cgi args appId [" + str + "] userName [" + str2 + "] stack [" + android.util.Log.getStackTraceString(new Throwable()) + ']');
            h.INSTANCE.dN(369, 34);
        }
        AppMethodBeat.o(229060);
        return z;
    }
}
