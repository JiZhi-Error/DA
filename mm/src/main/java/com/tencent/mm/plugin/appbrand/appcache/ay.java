package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.jsapi.y.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import org.json.JSONObject;

public final class ay {
    public static final int VERSION;
    public static final String[] kMx;
    static final a kMy;
    private static Boolean kMz = null;

    /* access modifiers changed from: package-private */
    public enum a {
        CUSTOM,
        DEVELOP,
        STABLE;

        public static a valueOf(String str) {
            AppMethodBeat.i(139827);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(139827);
            return aVar;
        }

        static {
            AppMethodBeat.i(139828);
            AppMethodBeat.o(139828);
        }
    }

    static {
        int i2 = -1;
        AppMethodBeat.i(139836);
        try {
            String bwd = bwd();
            if (!Util.isNullOrNil(bwd) && s.YS(bwd)) {
                i2 = new JSONObject(s.boY(bwd)).optInt("version");
            }
        } catch (Exception e2) {
        }
        if (i2 > 0) {
            VERSION = i2;
            kMx = com.tencent.luggage.j.a.cDE;
            kMy = a.STABLE;
        } else {
            VERSION = d.CTRL_INDEX;
            kMx = com.tencent.luggage.j.a.cDE;
            kMy = a.STABLE;
        }
        AppMethodBeat.o(139836);
    }

    public static void bwc() {
        AppMethodBeat.i(139829);
        s.deleteFile(bwd());
        AppMethodBeat.o(139829);
    }

    static String bwd() {
        AppMethodBeat.i(139830);
        String z = aa.z(new o(MMApplicationContext.getContext().getCacheDir().getAbsolutePath() + "/MockLibInfo.json").her());
        AppMethodBeat.o(139830);
        return z;
    }

    public static boolean bwe() {
        AppMethodBeat.i(139831);
        if (kMz == null) {
            kMz = Boolean.FALSE;
        }
        boolean booleanValue = kMz.booleanValue();
        AppMethodBeat.o(139831);
        return booleanValue;
    }

    public static void gI(boolean z) {
        AppMethodBeat.i(139832);
        MultiProcessMMKV.getMMKV("__appbrand_comm_lib__prefs").putBoolean("disable_develop_lib", z).commit();
        AppMethodBeat.o(139832);
    }

    public static InputStream openRead(String str) {
        AppMethodBeat.i(139833);
        String We = n.We(str);
        switch (kMy) {
            case CUSTOM:
                InputStream Vf = Vf("wxa_library/custom".concat(String.valueOf(We)));
                AppMethodBeat.o(139833);
                return Vf;
            case DEVELOP:
                InputStream Vf2 = Vf("wxa_library/develop".concat(String.valueOf(We)));
                AppMethodBeat.o(139833);
                return Vf2;
            default:
                InputStream Vf3 = Vf("wxa_library".concat(String.valueOf(We)));
                AppMethodBeat.o(139833);
                return Vf3;
        }
    }

    private static InputStream Vf(String str) {
        AppMethodBeat.i(139834);
        try {
            InputStream open = MMApplicationContext.getContext().getAssets().open(str, 3);
            AppMethodBeat.o(139834);
            return open;
        } catch (Exception e2) {
            Log.v("MicroMsg.AppBrand.WxaLocalLibPkg", "openRead file( %s ) failed, exp = %s", str, e2);
            AppMethodBeat.o(139834);
            return null;
        }
    }

    public static WxaPkgWrappingInfo bwf() {
        AppMethodBeat.i(139835);
        WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
        wxaPkgWrappingInfo.pkgVersion = VERSION;
        wxaPkgWrappingInfo.kNY = true;
        AppMethodBeat.o(139835);
        return wxaPkgWrappingInfo;
    }
}
