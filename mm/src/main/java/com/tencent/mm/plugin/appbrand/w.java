package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Locale;

public enum w {
    ;
    
    private static final String kEt = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/wxawap/wapreportwxadevlog?action=complain_feedback&appid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d&screenshot_localId=%s&sessionid=%s&business_appid=%s&msgid=%s#wechat_redirect");
    private static final String kEu = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect");
    private static final String kEv = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/mp/waverifyinfo?action=get&appid=%s#wechat_redirect");
    private static final String kEw = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/mp/waerrpage?appid=%s&type=upgrade&upgradetype=%d#wechat_redirect");

    static {
        AppMethodBeat.i(226244);
        AppMethodBeat.o(226244);
    }

    public static w valueOf(String str) {
        AppMethodBeat.i(43967);
        w wVar = (w) Enum.valueOf(w.class, str);
        AppMethodBeat.o(43967);
        return wVar;
    }

    public static String Up(String str) {
        AppMethodBeat.i(43968);
        String format = String.format(Locale.US, HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/mp/waerrpage?appid=%s&type=overseas#wechat_redirect", str);
        AppMethodBeat.o(43968);
        return format;
    }

    public static String a(WxaExposedParams wxaExposedParams) {
        AppMethodBeat.i(43969);
        String str = "";
        if (wxaExposedParams == null || Util.isNullOrNil(wxaExposedParams.appId)) {
            Log.e("MicroMsg.AppBrandUrlBuilders", "buildFeedbackUrl fail, null or nil appId");
            AppMethodBeat.o(43969);
        } else {
            try {
                str = String.format(kEt, wxaExposedParams.appId, q.encode(Util.nullAsNil(wxaExposedParams.pageId), MimeTypeUtil.ContentType.DEFAULT_CHARSET), Integer.valueOf(wxaExposedParams.from), Integer.valueOf(Util.nullAsInt(Integer.valueOf(wxaExposedParams.kNW), -1)), Integer.valueOf(Util.nullAsInt(Integer.valueOf(wxaExposedParams.pkgVersion), -1)), q.encode(Util.nullAsNil(wxaExposedParams.lhp), MimeTypeUtil.ContentType.DEFAULT_CHARSET), Util.nullAsNil(wxaExposedParams.sessionId), q.encode(Util.nullAsNil(wxaExposedParams.lhq), MimeTypeUtil.ContentType.DEFAULT_CHARSET), q.encode(Util.nullAsNil(wxaExposedParams.msgId), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                AppMethodBeat.o(43969);
            } catch (UnsupportedEncodingException e2) {
                Log.e("MicroMsg.AppBrandUrlBuilders", "buildFeedbackUrl encode fail, invalid arguments");
                AppMethodBeat.o(43969);
            }
        }
        return str;
    }

    public static String b(WxaExposedParams wxaExposedParams) {
        AppMethodBeat.i(43970);
        String str = "";
        if (wxaExposedParams == null || Util.isNullOrNil(wxaExposedParams.appId)) {
            Log.e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl fail, null or nil appId");
            AppMethodBeat.o(43970);
        } else {
            try {
                str = String.format(kEu, wxaExposedParams.appId, q.encode(Util.nullAsNil(wxaExposedParams.pageId), MimeTypeUtil.ContentType.DEFAULT_CHARSET), Integer.valueOf(wxaExposedParams.from), Integer.valueOf(Util.nullAsInt(Integer.valueOf(wxaExposedParams.kNW), -1)), Integer.valueOf(Util.nullAsInt(Integer.valueOf(wxaExposedParams.pkgVersion), -1)));
                AppMethodBeat.o(43970);
            } catch (UnsupportedEncodingException e2) {
                Log.e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl encode fail, invalid arguments");
                AppMethodBeat.o(43970);
            }
        }
        return str;
    }

    public static String Uq(String str) {
        AppMethodBeat.i(43971);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.AppBrandUrlBuilders", "buildEntityUrl fail, null or nil appId");
            AppMethodBeat.o(43971);
            return "";
        }
        String format = String.format(kEv, str);
        AppMethodBeat.o(43971);
        return format;
    }

    public static String cl(String str, String str2) {
        String str3;
        AppMethodBeat.i(43973);
        URI uri = new URI(str);
        String query = uri.getQuery();
        if (query == null) {
            str3 = str2;
        } else {
            str3 = query + "&" + str2;
        }
        String uri2 = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), str3, uri.getFragment()).toString();
        AppMethodBeat.o(43973);
        return uri2;
    }

    public static String Ur(String str) {
        AppMethodBeat.i(43972);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.AppBrandUrlBuilders", "buildLowVersionUrl fail, invalid arguments");
            AppMethodBeat.o(43972);
            return "";
        }
        String format = String.format(Locale.US, kEw, str, 3);
        AppMethodBeat.o(43972);
        return format;
    }
}
