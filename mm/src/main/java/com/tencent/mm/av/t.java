package com.tencent.mm.av;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class t {
    private static String[] dhp = null;

    public static String OO(String str) {
        AppMethodBeat.i(150771);
        if (bcZ()) {
            str = fk(str);
        }
        AppMethodBeat.o(150771);
        return str;
    }

    public static boolean bcZ() {
        AppMethodBeat.i(150772);
        if (dhp == null) {
            Us();
        }
        if (Build.VERSION.SDK_INT < 14 || dhp == null || dhp.length <= 0 || ae.gKE.gHI != 1) {
            AppMethodBeat.o(150772);
            return false;
        }
        AppMethodBeat.o(150772);
        return true;
    }

    private static void Us() {
        AppMethodBeat.i(150773);
        try {
            String value = ((a) g.af(a.class)).aqJ().getValue("BizEnableWebpUrl");
            Log.i("MicroMsg.WebpUtil", "initCdnUrlList, urllist: %s", value);
            if (!Util.isNullOrNil(value)) {
                dhp = value.split(";");
                Log.d("MicroMsg.WebpUtil", "initCdnUrlList, CDN_URL_LIST.length: %d", Integer.valueOf(dhp.length));
            }
            AppMethodBeat.o(150773);
        } catch (b e2) {
            Log.w("MicroMsg.WebpUtil", "initCdnUrlList fail, AccountNotReady");
            AppMethodBeat.o(150773);
        } catch (Exception e3) {
            Log.d("MicroMsg.WebpUtil", "initCdnUrlList error: %s", e3.getMessage());
            AppMethodBeat.o(150773);
        }
    }

    private static boolean ff(String str) {
        AppMethodBeat.i(150774);
        if (dhp != null && dhp.length > 0 && !Util.isNullOrNil(str)) {
            for (String str2 : dhp) {
                if (str.startsWith(str2)) {
                    AppMethodBeat.o(150774);
                    return true;
                }
            }
        }
        AppMethodBeat.o(150774);
        return false;
    }

    private static String fk(String str) {
        AppMethodBeat.i(150775);
        if (dhp == null || dhp.length == 0) {
            Log.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, cdn url is null");
            Us();
        }
        if (!ff(str)) {
            Log.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, is not cdn url");
            AppMethodBeat.o(150775);
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("wxtype");
            if (Util.isNullOrNil(queryParameter)) {
                AppMethodBeat.o(150775);
                return str;
            }
            String lowerCase = queryParameter.toLowerCase();
            if (lowerCase.equals("gif") || lowerCase.contains("gif")) {
                AppMethodBeat.o(150775);
                return str;
            }
            String queryParameter2 = parse.getQueryParameter("tp");
            if (!Util.isNullOrNil(queryParameter2) && queryParameter2.equals("webp")) {
                AppMethodBeat.o(150775);
                return str;
            } else if (!Util.isNullOrNil(lowerCase)) {
                String uri = parse.buildUpon().appendQueryParameter("tp", "webp").build().toString();
                AppMethodBeat.o(150775);
                return uri;
            } else {
                AppMethodBeat.o(150775);
                return str;
            }
        } catch (Exception e2) {
            AppMethodBeat.o(150775);
            return str;
        }
    }

    public static boolean fm(String str) {
        AppMethodBeat.i(150776);
        try {
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(150776);
                return false;
            } else if (!ff(str)) {
                AppMethodBeat.o(150776);
                return false;
            } else {
                String queryParameter = Uri.parse(str).getQueryParameter("tp");
                if (Util.isNullOrNil(queryParameter) || !queryParameter.equals("webp")) {
                    AppMethodBeat.o(150776);
                    return false;
                }
                AppMethodBeat.o(150776);
                return true;
            }
        } catch (Exception e2) {
            AppMethodBeat.o(150776);
            return false;
        }
    }

    private static int bda() {
        AppMethodBeat.i(150777);
        Context context = MMApplicationContext.getContext();
        if (NetStatusUtil.isWifi(context)) {
            AppMethodBeat.o(150777);
            return 1;
        } else if (NetStatusUtil.is5G(context)) {
            AppMethodBeat.o(150777);
            return 5;
        } else if (NetStatusUtil.is4G(context)) {
            AppMethodBeat.o(150777);
            return 4;
        } else if (NetStatusUtil.is3G(context)) {
            AppMethodBeat.o(150777);
            return 3;
        } else if (NetStatusUtil.is2G(context)) {
            AppMethodBeat.o(150777);
            return 2;
        } else {
            AppMethodBeat.o(150777);
            return 0;
        }
    }

    public static String tt(int i2) {
        AppMethodBeat.i(150778);
        String format = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i2), Integer.valueOf(bda()), 2);
        AppMethodBeat.o(150778);
        return format;
    }

    public static String tu(int i2) {
        AppMethodBeat.i(150779);
        String format = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i2), Integer.valueOf(bda()), 1);
        AppMethodBeat.o(150779);
        return format;
    }

    public static String OP(String str) {
        AppMethodBeat.i(150780);
        try {
            if (!ff(str)) {
                AppMethodBeat.o(150780);
                return null;
            }
            String lowerCase = Uri.parse(str).getQueryParameter("wxtype").toLowerCase();
            if (Util.isNullOrNil(lowerCase)) {
                AppMethodBeat.o(150780);
                return null;
            }
            String lowerCase2 = lowerCase.toLowerCase();
            AppMethodBeat.o(150780);
            return lowerCase2;
        } catch (Exception e2) {
            AppMethodBeat.o(150780);
            return null;
        }
    }
}
