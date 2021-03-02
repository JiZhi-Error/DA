package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.net.Uri;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.t;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0012\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0018\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0019\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004J\b\u0010\u001e\u001a\u00020\u001fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageDownloadUtil;", "", "()V", "TAG", "", "enableImageBlankReport", "", "canReport", "scene", "", "canReportBlank", "getFormattedNetType", "context", "Landroid/content/Context;", "getImageTypeByContentType", DownloadInfo.CONTENTTYPE, "getRequestImageTypeByUrl", "url", "isJpeg", "isRequestJpeg", "isRequestWebp", "isRequestWxPic", "isResponseWebp", "isResponseWxPic", "isWebp", "isWxPic", "removeQueryParameter", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "key", "updateEnableImageBlankReport", "", "plugin-biz_release"})
public final class g {
    private static boolean Keu;
    public static final g Kev = new g();

    static {
        AppMethodBeat.i(124863);
        gpi();
        AppMethodBeat.o(124863);
    }

    private g() {
    }

    public static final void gpi() {
        boolean z;
        AppMethodBeat.i(124853);
        int a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_biz_timeline_img_blank_report, 0);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
            z = true;
        } else {
            z = a2 == 1;
        }
        Keu = z;
        Log.i("MicroMsg.BizImageDownloadUtil", "alvinluo updateEnableImageBlankReport config: %d, %b", Integer.valueOf(a2), Boolean.valueOf(Keu));
        AppMethodBeat.o(124853);
    }

    public static boolean beI(String str) {
        AppMethodBeat.i(124854);
        p.h(str, "url");
        if (!com.tencent.mm.api.b.Ut() || !com.tencent.mm.api.b.fo(str)) {
            AppMethodBeat.o(124854);
            return false;
        }
        AppMethodBeat.o(124854);
        return true;
    }

    public static boolean mA(String str, String str2) {
        AppMethodBeat.i(124855);
        p.h(str, "url");
        if (!t.bcZ() || !aQF(str2) || !com.tencent.mm.api.b.fm(str)) {
            AppMethodBeat.o(124855);
            return false;
        }
        AppMethodBeat.o(124855);
        return true;
    }

    public static boolean beJ(String str) {
        AppMethodBeat.i(124856);
        p.h(str, "url");
        if (!t.bcZ() || !com.tencent.mm.api.b.fm(str)) {
            AppMethodBeat.o(124856);
            return false;
        }
        AppMethodBeat.o(124856);
        return true;
    }

    public static boolean beK(String str) {
        AppMethodBeat.i(124857);
        String str2 = str;
        if ((str2 == null || str2.length() == 0) || !p.j(str, "image/wxpic")) {
            AppMethodBeat.o(124857);
            return false;
        }
        AppMethodBeat.o(124857);
        return true;
    }

    private static boolean aQF(String str) {
        AppMethodBeat.i(124858);
        String str2 = str;
        if ((str2 == null || str2.length() == 0) || !p.j(str, "image/webp")) {
            AppMethodBeat.o(124858);
            return false;
        }
        AppMethodBeat.o(124858);
        return true;
    }

    public static int beL(String str) {
        AppMethodBeat.i(124859);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(124859);
            return -1;
        } else if (beK(str)) {
            AppMethodBeat.o(124859);
            return 1;
        } else if (aQF(str)) {
            AppMethodBeat.o(124859);
            return 2;
        } else {
            AppMethodBeat.o(124859);
            return 0;
        }
    }

    public static boolean aif(int i2) {
        AppMethodBeat.i(124860);
        if (!com.tencent.mm.api.b.Ut() || !(i2 == 1 || i2 == 3 || i2 == 2)) {
            AppMethodBeat.o(124860);
            return false;
        }
        AppMethodBeat.o(124860);
        return true;
    }

    public static boolean aig(int i2) {
        return Keu && i2 == 1;
    }

    public static String iz(Context context) {
        AppMethodBeat.i(124861);
        if (!NetStatusUtil.isConnected(context)) {
            AppMethodBeat.o(124861);
            return "unknow";
        } else if (NetStatusUtil.is4G(context)) {
            AppMethodBeat.o(124861);
            return "4G";
        } else if (NetStatusUtil.is5G(context)) {
            AppMethodBeat.o(124861);
            return "5G";
        } else if (NetStatusUtil.isWifi(context)) {
            AppMethodBeat.o(124861);
            return "WiFi";
        } else if (NetStatusUtil.is3G(context)) {
            AppMethodBeat.o(124861);
            return "3G";
        } else if (NetStatusUtil.is2G(context)) {
            AppMethodBeat.o(124861);
            return "2G";
        } else {
            AppMethodBeat.o(124861);
            return FacebookRequestErrorClassification.KEY_OTHER;
        }
    }

    public static String b(Uri uri, String str) {
        AppMethodBeat.i(124862);
        p.h(uri, ShareConstants.MEDIA_URI);
        p.h(str, "key");
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Uri.Builder clearQuery = uri.buildUpon().clearQuery();
        for (String str2 : queryParameterNames) {
            if (!p.j(str2, str)) {
                clearQuery.appendQueryParameter(str2, uri.getQueryParameter(str2));
            }
        }
        String decode = URLDecoder.decode(clearQuery.build().toString(), ProtocolPackage.ServerEncoding);
        p.g(decode, "URLDecoder.decode(newUri…ld().toString(), \"utf-8\")");
        AppMethodBeat.o(124862);
        return decode;
    }
}
