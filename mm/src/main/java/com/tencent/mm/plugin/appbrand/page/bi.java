package com.tencent.mm.plugin.appbrand.page;

import android.util.Base64;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import kotlin.a.e;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl;", "Lcom/tencent/mm/plugin/appbrand/page/IMPPageScriptProvider;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "(Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;)V", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "getRuntime", "()Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "provideScript", "", "resourceName", "Companion", "luggage-wechat-full-sdk_release"})
public class bi implements be {
    @Deprecated
    public static final a ntr = new a((byte) 0);
    private final a<?> nto;

    static {
        AppMethodBeat.i(147977);
        AppMethodBeat.o(147977);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl$Companion;", "", "()V", "TAG", "", "luggage-wechat-full-sdk_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public bi(a<?> aVar) {
        p.h(aVar, "renderer");
        AppMethodBeat.i(147976);
        this.nto = aVar;
        AppMethodBeat.o(147976);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.be
    public String adT(String str) {
        String d2;
        boolean z;
        String str2;
        boolean z2;
        d NP;
        AppBrandSysConfigLU OM;
        AppMethodBeat.i(147975);
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            AppMethodBeat.o(147975);
            return null;
        }
        String[] strArr = com.tencent.luggage.sdk.b.a.d.czy;
        p.g(strArr, "IAppBrandComponentWxaSha…U.SCRIPTS_LIB_FOR_WEBVIEW");
        if (e.contains(strArr, str)) {
            Object S = this.nto.S(ICommLibReader.class);
            if (S == null) {
                p.hyc();
            }
            d2 = ((ICommLibReader) S).UM(str);
        } else if (p.j(str, "app-wxss.js")) {
            d NP2 = this.nto.NP();
            if (NP2 == null) {
                p.hyc();
            }
            d2 = bg.d(NP2, "app-wxss.js");
        } else if (p.j(str, "page-frame.html")) {
            d NP3 = this.nto.NP();
            if (NP3 == null) {
                p.hyc();
            }
            d2 = ad.adQ(bg.d(NP3, "page-frame.html"));
        } else if (p.j(str, this.nto.getURL())) {
            d NP4 = this.nto.NP();
            if (NP4 == null) {
                p.hyc();
            }
            String d3 = bg.d(NP4, str);
            String adP = ad.adP(d3);
            p.g(adP, "extractStyle(pageHtml)");
            Charset charset = kotlin.n.d.UTF_8;
            if (adP == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(147975);
                throw tVar;
            }
            byte[] bytes = adP.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(bytes, 2);
            String adO = ad.adO(d3);
            p.g(adO, "extractPage(pageHtml)");
            Charset charset2 = kotlin.n.d.UTF_8;
            if (adO == null) {
                t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(147975);
                throw tVar2;
            }
            byte[] bytes2 = adO.getBytes(charset2);
            p.g(bytes2, "(this as java.lang.String).getBytes(charset)");
            String encodeToString2 = Base64.encodeToString(bytes2, 2);
            String adQ = ad.adQ(d3);
            ae aeVar = ae.SYK;
            Locale locale = Locale.ENGLISH;
            p.g(locale, "Locale.ENGLISH");
            d2 = String.format(locale, "var style = document.createElement('style');style.innerHTML = atob(\"%s\");document.head.appendChild(style);var page = document.createElement('page');page.innerHTML = atob(\"%s\");document.body.appendChild(page);%s;", Arrays.copyOf(new Object[]{encodeToString, encodeToString2, adQ}, 3));
            p.g(d2, "java.lang.String.format(locale, format, *args)");
        } else {
            d2 = bg.d(this.nto.NP(), str);
        }
        Log.i("Luggage.WXA.MPPageScriptProviderDefaultImpl", "provideScript name[" + str + "] source.length[" + (d2 != null ? d2.length() : -1) + ']');
        String str4 = d2;
        if (str4 == null || str4.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            bi biVar = this;
            String[] strArr2 = com.tencent.luggage.sdk.b.a.d.czy;
            p.g(strArr2, "SCRIPTS_LIB_FOR_WEBVIEW");
            if (e.contains(strArr2, str) || !((NP = biVar.nto.NP()) == null || (OM = NP.OM()) == null || !OM.cyC)) {
                StringBuilder sb = new StringBuilder(com.tencent.luggage.sdk.b.a.d.czw);
                if (biVar.nto.NP() == null) {
                    sb.append("preload/");
                } else {
                    d NP5 = biVar.nto.NP();
                    if (NP5 == null) {
                        p.hyc();
                    }
                    StringBuilder append = sb.append(NP5.getAppId()).append(FilePathGenerator.ANDROID_DIR_SEP);
                    d NP6 = biVar.nto.NP();
                    if (NP6 == null) {
                        p.hyc();
                    }
                    append.append(NP6.OM().leE.pkgVersion()).append(FilePathGenerator.ANDROID_DIR_SEP);
                }
                str2 = sb.append(str).toString();
                p.g(str2, "builder.append(resourceName).toString()");
            } else {
                str2 = "";
            }
            p.g(str2, "run makeSourceURL@{\n    …      }\n                }");
            if (str2.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                AppMethodBeat.o(147975);
                return d2;
            }
            String str5 = d2 + "\n//# sourceURL=" + r.afJ(str2);
            AppMethodBeat.o(147975);
            return str5;
        }
        AppMethodBeat.o(147975);
        return null;
    }
}
