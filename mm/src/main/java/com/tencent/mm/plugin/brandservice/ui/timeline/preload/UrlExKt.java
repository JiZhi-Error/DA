package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.dei;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.i;
import kotlin.n.k;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\f\u001a\u00020\r\u001a\u001a\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002\u001a\u001c\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0001\u001a#\u0010\u0012\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0013\"\u00020\u0002¢\u0006\u0002\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002\u001a\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0002H\u0002\u001a\f\u0010\u0018\u001a\u00020\u0017*\u00020\u0002H\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003\"\u0015\u0010\u0005\u001a\u00020\u0002*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, hxF = {"isMpArticleUrl", "", "", "(Ljava/lang/String;)Z", "isMpUrl", "withProtocol", "getWithProtocol", "(Ljava/lang/String;)Ljava/lang/String;", "clearShortUrl", "rawUrl", "ignoreHashTag", "appendStats", "session", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "appendUrlParam", "param", "value", "clearUrlParam", "clearUrlParams", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "getUrlParam", "getUrlParamPairRegex", "Lkotlin/text/Regex;", "getUrlParamRegex", "plugin-brandservice_release"})
public final class UrlExKt {
    public static /* synthetic */ String clearShortUrl$default(String str, boolean z, int i2, Object obj) {
        AppMethodBeat.i(195641);
        if ((i2 & 2) != 0) {
            z = false;
        }
        String clearShortUrl = clearShortUrl(str, z);
        AppMethodBeat.o(195641);
        return clearShortUrl;
    }

    public static final String clearShortUrl(String str, boolean z) {
        AppMethodBeat.i(195640);
        p.h(str, "rawUrl");
        String[] strArr = {"sessionid", "subscene", "scene", "ascene", "enterid", "clicktime", "fasttmpl_type", "fasttmpl_fullversion", "fasttmpl_flag", "realreporttime", "reporttime"};
        for (int i2 = 0; i2 < 11; i2++) {
            str = clearUrlParam(str, strArr[i2], z);
        }
        String a2 = n.a(str, '?', '&');
        AppMethodBeat.o(195640);
        return a2;
    }

    public static final String appendStats(String str, dei dei) {
        AppMethodBeat.i(195642);
        p.h(str, "$this$appendStats");
        p.h(dei, "session");
        if (!n.e(str, WeChatHosts.domainString(R.string.e20))) {
            AppMethodBeat.o(195642);
            return str;
        }
        int i2 = 0;
        if (dei.MJr) {
            i2 = 1;
        }
        if (dei.MJs) {
            i2 |= 2;
        }
        if (dei.MJt) {
            i2 |= 4;
        }
        if (dei.MJu) {
            i2 |= 8;
        }
        if (dei.MJv) {
            i2 |= 16;
        }
        if (dei.MJw) {
            i2 |= 32;
        }
        String appendUrlParam = appendUrlParam(appendUrlParam(appendUrlParam(appendUrlParam(appendUrlParam(str, "sessionid", String.valueOf(dei.id)), "subscene", String.valueOf(dei.pHw)), "scene", String.valueOf(dei.pmM)), "ascene", String.valueOf(dei.MJq)), "fasttmpl_type", String.valueOf(dei.pCV));
        String str2 = dei.hFF;
        p.g(str2, "session.uid");
        String appendUrlParam2 = appendUrlParam(appendUrlParam(appendUrlParam(appendUrlParam, "fasttmpl_fullversion", str2), "fasttmpl_flag", String.valueOf(i2)), "realreporttime", String.valueOf(MMSlotKt.now()));
        AppMethodBeat.o(195642);
        return appendUrlParam2;
    }

    private static final k getUrlParamRegex(String str) {
        AppMethodBeat.i(6758);
        k kVar = new k("(?<=" + str + "=).+?(?=&)");
        AppMethodBeat.o(6758);
        return kVar;
    }

    private static final k getUrlParamPairRegex(String str) {
        AppMethodBeat.i(6759);
        k kVar = new k("(?<=[?|&])" + str + "=.+?(?:&|$)");
        AppMethodBeat.o(6759);
        return kVar;
    }

    public static final String getUrlParam(String str, String str2) {
        AppMethodBeat.i(6760);
        p.h(str, "$this$getUrlParam");
        p.h(str2, "param");
        i a2 = k.a(getUrlParamRegex(str2), str);
        if (a2 != null) {
            String value = a2.getValue();
            AppMethodBeat.o(6760);
            return value;
        }
        AppMethodBeat.o(6760);
        return null;
    }

    public static final boolean isMpUrl(String str) {
        AppMethodBeat.i(6761);
        p.h(str, "$this$isMpUrl");
        if (n.J(str, HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + FilePathGenerator.ANDROID_DIR_SEP, false) || n.J(str, HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e20) + FilePathGenerator.ANDROID_DIR_SEP, false)) {
            AppMethodBeat.o(6761);
            return true;
        }
        AppMethodBeat.o(6761);
        return false;
    }

    public static final boolean isMpArticleUrl(String str) {
        AppMethodBeat.i(6762);
        p.h(str, "$this$isMpArticleUrl");
        if (n.J(str, HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/s?", false) || n.J(str, HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e20) + "/s?", false) || n.J(str, HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/s/", false) || n.J(str, HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e20) + "/s/", false)) {
            AppMethodBeat.o(6762);
            return true;
        }
        AppMethodBeat.o(6762);
        return false;
    }

    public static final String appendUrlParam(String str, String str2, String str3) {
        String str4;
        String str5;
        AppMethodBeat.i(6763);
        p.h(str, "$this$appendUrlParam");
        p.h(str2, "param");
        p.h(str3, "value");
        List<String> a2 = n.a(str, new String[]{"#"});
        String str6 = a2.get(0);
        if (!n.a((CharSequence) str6, (CharSequence) "?", false)) {
            str4 = str6 + "?";
        } else {
            str4 = str6;
        }
        if (n.e(str4, str2 + '=')) {
            str5 = getUrlParamRegex(str2).f(str4, str3);
        } else {
            str5 = str4 + (n.nm(str4, "?") ? "" : "&") + str2 + '=' + str3;
        }
        if (a2.size() > 1) {
            String str7 = str5 + '#' + a2.get(1);
            AppMethodBeat.o(6763);
            return str7;
        }
        AppMethodBeat.o(6763);
        return str5;
    }

    public static /* synthetic */ String clearUrlParam$default(String str, String str2, boolean z, int i2, Object obj) {
        AppMethodBeat.i(195644);
        if ((i2 & 2) != 0) {
            z = false;
        }
        String clearUrlParam = clearUrlParam(str, str2, z);
        AppMethodBeat.o(195644);
        return clearUrlParam;
    }

    public static final String clearUrlParam(String str, String str2, boolean z) {
        String str3;
        AppMethodBeat.i(195643);
        p.h(str, "$this$clearUrlParam");
        p.h(str2, "param");
        if (z) {
            str3 = str;
        } else {
            str3 = n.a(str, new String[]{"#"}).get(0);
        }
        String f2 = getUrlParamPairRegex(str2).f(str3, "");
        if (!n.nm(f2, "&") || n.nm(str3, "&")) {
            AppMethodBeat.o(195643);
            return f2;
        }
        String a2 = n.a(f2, '&');
        AppMethodBeat.o(195643);
        return a2;
    }

    public static final String clearUrlParams(String str, String... strArr) {
        AppMethodBeat.i(195645);
        p.h(str, "$this$clearUrlParams");
        p.h(strArr, "param");
        try {
            Uri parse = Uri.parse(str);
            p.g(parse, ShareConstants.MEDIA_URI);
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            p.g(queryParameterNames, "uri.queryParameterNames");
            ArrayList arrayList = new ArrayList();
            for (T t : queryParameterNames) {
                if (!e.contains(strArr, t)) {
                    arrayList.add(t);
                }
            }
            List<String> n = j.n(arrayList);
            ArrayList arrayList2 = new ArrayList(j.a(n, 10));
            for (String str2 : n) {
                arrayList2.add(str2 + '=' + parse.getQueryParameter(str2));
            }
            str = parse.getScheme() + "://" + parse.getHost() + parse.getPath() + '?' + j.a(arrayList2, "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 62);
        } catch (Exception e2) {
            Log.e("String", "clearUrlParams:" + e2.getMessage() + ", " + strArr + ", " + str);
        }
        if (str == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(195645);
            throw tVar;
        }
        AppMethodBeat.o(195645);
        return str;
    }

    public static final String getWithProtocol(String str) {
        AppMethodBeat.i(6765);
        p.h(str, "$this$withProtocol");
        if (n.J(str, "http", false)) {
            AppMethodBeat.o(6765);
            return str;
        } else if (n.a((CharSequence) str, (CharSequence) "view.inews.qq.com", false)) {
            String concat = HttpWrapperBase.PROTOCAL_HTTPS.concat(String.valueOf(str));
            AppMethodBeat.o(6765);
            return concat;
        } else {
            String concat2 = HttpWrapperBase.PROTOCAL_HTTP.concat(String.valueOf(str));
            AppMethodBeat.o(6765);
            return concat2;
        }
    }
}
