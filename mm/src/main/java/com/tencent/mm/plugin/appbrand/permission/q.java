package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.config.l;
import java.util.Arrays;
import java.util.List;

public final class q {
    private static final List<String> nxL = Arrays.asList("scope.userLocation", "scope.camera");

    static {
        AppMethodBeat.i(147668);
        AppMethodBeat.o(147668);
    }

    public static boolean a(String str, l lVar) {
        AppMethodBeat.i(147666);
        if (!nxL.contains(str)) {
            AppMethodBeat.o(147666);
            return false;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -653473286:
                if (str.equals("scope.userLocation")) {
                    c2 = 0;
                    break;
                }
                break;
            case -21617665:
                if (str.equals("scope.camera")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                boolean z = lVar.leA;
                AppMethodBeat.o(147666);
                return z;
            case 1:
                AppMethodBeat.o(147666);
                return true;
            default:
                AppMethodBeat.o(147666);
                return false;
        }
    }

    public static String a(String str, AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(147667);
        char c2 = 65535;
        switch (str.hashCode()) {
            case -21617665:
                if (str.equals("scope.camera")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                String string = appBrandRuntime.mContext.getString(R.string.a0l);
                AppMethodBeat.o(147667);
                return string;
            default:
                b.e WW = appBrandRuntime.getAppConfig().WW(str);
                if (WW == null) {
                    AppMethodBeat.o(147667);
                    return null;
                }
                String str2 = WW.desc;
                AppMethodBeat.o(147667);
                return str2;
        }
    }
}
