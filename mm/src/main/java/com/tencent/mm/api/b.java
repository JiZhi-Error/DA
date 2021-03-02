package com.tencent.mm.api;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b {
    private static String[] dhp = null;
    private static Boolean dhq = null;

    public static String u(String str, int i2) {
        AppMethodBeat.i(116344);
        String a2 = a(str, i2, true);
        AppMethodBeat.o(116344);
        return a2;
    }

    public static String a(String str, int i2, boolean z) {
        AppMethodBeat.i(116345);
        String l = l(str, z && iD(i2));
        AppMethodBeat.o(116345);
        return l;
    }

    public static String l(String str, boolean z) {
        AppMethodBeat.i(116346);
        if (Ut() && z) {
            str = fn(str);
        } else if (t.bcZ()) {
            str = fk(str);
        }
        AppMethodBeat.o(116346);
        return str;
    }

    private static boolean iD(int i2) {
        return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
    }

    private static void Us() {
        AppMethodBeat.i(116347);
        try {
            String value = ((a) g.af(a.class)).aqJ().getValue("BizEnableWxPicUrl");
            Log.i("MicroMsg.BizImageStrategy", "alvinluo initCdnUrlList, urlList: %s", value);
            if (!Util.isNullOrNil(value)) {
                dhp = value.split(";");
                Log.d("MicroMsg.BizImageStrategy", "alvinluo initCdnUrlList, CDN_URL_LIST.length: %d", Integer.valueOf(dhp.length));
            }
            AppMethodBeat.o(116347);
        } catch (com.tencent.mm.model.b e2) {
            Log.w("MicroMsg.BizImageStrategy", "alvinluo initCdnUrlList fail, AccountNotReady");
            AppMethodBeat.o(116347);
        } catch (Exception e3) {
            Log.d("MicroMsg.BizImageStrategy", "alvinluo initCdnUrlList error: %s", e3.getMessage());
            AppMethodBeat.o(116347);
        }
    }

    private static boolean ff(String str) {
        AppMethodBeat.i(116348);
        if (dhp != null && dhp.length > 0 && !Util.isNullOrNil(str)) {
            for (String str2 : dhp) {
                if (str.startsWith(str2)) {
                    AppMethodBeat.o(116348);
                    return true;
                }
            }
        }
        AppMethodBeat.o(116348);
        return false;
    }

    private static String fk(String str) {
        AppMethodBeat.i(116349);
        if (dhp == null || dhp.length == 0) {
            Log.d("MicroMsg.BizImageStrategy", "addWebpURLIfNecessary, cdn url is null");
            Us();
        }
        if (!ff(str)) {
            Log.d("MicroMsg.BizImageStrategy", "addWebpURLIfNecessary, is not cdn url");
            AppMethodBeat.o(116349);
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("wxtype");
            if (Util.isNullOrNil(queryParameter)) {
                AppMethodBeat.o(116349);
                return str;
            }
            String lowerCase = queryParameter.toLowerCase();
            if (lowerCase.equals("gif") || lowerCase.contains("gif")) {
                AppMethodBeat.o(116349);
                return str;
            }
            String queryParameter2 = parse.getQueryParameter("tp");
            if (!Util.isNullOrNil(queryParameter2) && queryParameter2.equals("webp")) {
                AppMethodBeat.o(116349);
                return str;
            } else if (!Util.isNullOrNil(lowerCase)) {
                String uri = parse.buildUpon().appendQueryParameter("tp", "webp").build().toString();
                AppMethodBeat.o(116349);
                return uri;
            } else {
                AppMethodBeat.o(116349);
                return str;
            }
        } catch (Exception e2) {
            AppMethodBeat.o(116349);
            return str;
        }
    }

    public static boolean fm(String str) {
        AppMethodBeat.i(116350);
        try {
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(116350);
                return false;
            } else if (!ff(str)) {
                AppMethodBeat.o(116350);
                return false;
            } else {
                String queryParameter = Uri.parse(str).getQueryParameter("tp");
                if (Util.isNullOrNil(queryParameter) || !queryParameter.equals("webp")) {
                    AppMethodBeat.o(116350);
                    return false;
                }
                AppMethodBeat.o(116350);
                return true;
            }
        } catch (Exception e2) {
            AppMethodBeat.o(116350);
            return false;
        }
    }

    private static String fn(String str) {
        AppMethodBeat.i(116351);
        if (dhp == null || dhp.length == 0) {
            Log.d("MicroMsg.BizImageStrategy", "addWXPicURLIfNecessary, cdn url is null");
            Us();
        }
        if (!ff(str)) {
            Log.d("MicroMsg.BizImageStrategy", "addWXPicURLIfNecessary, is not cdn url");
            AppMethodBeat.o(116351);
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("wxtype");
            if (queryParameter != null) {
                String lowerCase = queryParameter.toLowerCase();
                if (lowerCase.equals("gif") || lowerCase.contains("gif")) {
                    AppMethodBeat.o(116351);
                    return str;
                }
            }
            String queryParameter2 = parse.getQueryParameter("tp");
            if (Util.isNullOrNil(queryParameter2) || !queryParameter2.equals("wxpic")) {
                String uri = parse.buildUpon().appendQueryParameter("tp", "wxpic").build().toString();
                AppMethodBeat.o(116351);
                return uri;
            }
            AppMethodBeat.o(116351);
            return str;
        } catch (Exception e2) {
            AppMethodBeat.o(116351);
            return str;
        }
    }

    public static boolean fo(String str) {
        AppMethodBeat.i(116352);
        try {
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(116352);
                return false;
            } else if (!ff(str)) {
                AppMethodBeat.o(116352);
                return false;
            } else {
                String queryParameter = Uri.parse(str).getQueryParameter("tp");
                if (Util.isNullOrNil(queryParameter) || !queryParameter.equals("wxpic")) {
                    AppMethodBeat.o(116352);
                    return false;
                }
                AppMethodBeat.o(116352);
                return true;
            }
        } catch (Exception e2) {
            AppMethodBeat.o(116352);
            return false;
        }
    }

    public static boolean Ut() {
        AppMethodBeat.i(116353);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
            AppMethodBeat.o(116353);
            return true;
        }
        if (dhq == null) {
            Uu();
        }
        boolean booleanValue = dhq.booleanValue();
        AppMethodBeat.o(116353);
        return booleanValue;
    }

    public static void Uu() {
        AppMethodBeat.i(116354);
        dhq = Boolean.valueOf(Uv());
        AppMethodBeat.o(116354);
    }

    private static boolean Uv() {
        boolean z;
        AppMethodBeat.i(116355);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
            AppMethodBeat.o(116355);
            return true;
        }
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_img_hevc, 0);
        if (a2 == 1) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.BizImageStrategy", "alvinluo updateWxPicOpenStatus config: %d, isOpen: %b", Integer.valueOf(a2), Boolean.valueOf(z));
        AppMethodBeat.o(116355);
        return z;
    }
}
