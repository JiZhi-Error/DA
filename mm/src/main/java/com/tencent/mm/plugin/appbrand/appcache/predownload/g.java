package com.tencent.mm.plugin.appbrand.appcache.predownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.regex.Pattern;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/QRCodeDataPatternForWxa;", "", "()V", "PATTERN", "Ljava/util/regex/Pattern;", "getPATTERN", "()Ljava/util/regex/Pattern;", "TAG", "", "isMatched", "", "qbarString", "plugin-appbrand-integration_release"})
public final class g {
    public static final g kPi = new g();

    static {
        AppMethodBeat.i(228018);
        AppMethodBeat.o(228018);
    }

    private g() {
    }

    static Pattern bwN() {
        Pattern pattern;
        AppMethodBeat.i(228017);
        try {
            String a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_android_appbrand_scan_preload_wxaattr_b4_a8key_pattern, "");
            Log.i("MicroMsg.AppBrand.QRCodeDataPatternForWxa", "get by config, get pattern ".concat(String.valueOf(a2)));
            String str = a2;
            if (str == null || str.length() == 0) {
                pattern = null;
            } else {
                pattern = Pattern.compile(a2);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrand.QRCodeDataPatternForWxa", "get by config, get exception ".concat(String.valueOf(e2)));
            pattern = null;
        }
        AppMethodBeat.o(228017);
        return pattern;
    }
}
