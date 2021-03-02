package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.ad;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import com.tencent.xweb.ag;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import kotlin.f.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.n.n;
import kotlin.t;
import org.apache.commons.b.g;
import org.xwalk.core.BuildConfig;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\f\u0010\u000e\u001a\u00020\u0006*\u00020\u0006H\u0002J\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u0006*\u00020\u0006H\u0002J\f\u0010\u0010\u001a\u00020\u0006*\u00020\u0006H\u0002J\f\u0010\u0011\u001a\u00020\u0006*\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderXWebCodeCacheImpl;", "Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewRendererWC;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewRendererWC;)V", "checkScriptSerialized", "", "scriptName", "scriptSource", "onScriptCodeCacheProvided", "", "name", "provideScript", "resourceName", "contentMD5", "fileMD5", "stripParentFilePath", "urlEncode", "Companion", "plugin-appbrand-integration_release"})
public class bj extends bi {
    private static final String[] ntt = {"app-wxss.js", "page-frame.html"};
    public static final a ntu = new a((byte) 0);
    private final af nts;

    public static final String cc(String str, int i2) {
        AppMethodBeat.i(50950);
        String cc = a.cc(str, i2);
        AppMethodBeat.o(50950);
        return cc;
    }

    public static final String yR(int i2) {
        AppMethodBeat.i(50949);
        String yR = a.yR(i2);
        AppMethodBeat.o(50949);
        return yR;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0012H\u0007J\u0011\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderXWebCodeCacheImpl$Companion;", "", "()V", "DIR_NAME", "", "LIB_MAGIC_WORD", "MAIN_MODULE_APP_SCRIPTS", "", "[Ljava/lang/String;", "SPLITTER", "", "TAG", "codeCacheDir", "getCodeCacheDir", "()Ljava/lang/String;", "generateAppScriptSerializeNamePrefix", "appId", "version", "", "generateSdkScriptSerializeNamePrefix", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", AssistantStore.DownloadInfos.DownloadInfoColumns.VERSIONCODE, "mkdirs", "path", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String Mo() {
            AppMethodBeat.i(50939);
            a aVar = bj.ntu;
            String str = ad.bDt() + "/page_scripts";
            s.boN(str);
            AppMethodBeat.o(50939);
            return str;
        }

        public static String yR(int i2) {
            AppMethodBeat.i(50940);
            String[] strArr = {BuildConfig.INSTALL_TYPE, "v".concat(String.valueOf(i2))};
            String a2 = g.a((Object[]) strArr, '-', strArr.length);
            p.g(a2, "StringUtils.join(arrayOf…$versionCode\"), SPLITTER)");
            AppMethodBeat.o(50940);
            return a2;
        }

        public static String cc(String str, int i2) {
            AppMethodBeat.i(50941);
            p.h(str, "appId");
            String[] strArr = {str, "v".concat(String.valueOf(i2))};
            String a2 = g.a((Object[]) strArr, '-', strArr.length);
            p.g(a2, "StringUtils.join(arrayOf…, \"v$version\"), SPLITTER)");
            AppMethodBeat.o(50941);
            return a2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bj(af afVar) {
        super(afVar);
        p.h(afVar, "renderer");
        AppMethodBeat.i(50947);
        this.nts = afVar;
        AppMethodBeat.o(50947);
    }

    static {
        AppMethodBeat.i(50948);
        com.tencent.mm.plugin.appbrand.utils.s.afK("//XWEB_SCRIPT:");
        String str = ad.bDt() + "/page";
        if (s.YS(str)) {
            s.dy(str, true);
        }
        AppMethodBeat.o(50948);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bi, com.tencent.mm.plugin.appbrand.page.be
    public final String adT(String str) {
        boolean z;
        String str2;
        AppMethodBeat.i(50942);
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            AppMethodBeat.o(50942);
            return null;
        }
        String adT = super.adT(str);
        String str4 = adT;
        if (str4 == null || str4.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (p.j("WAWebview.js", str)) {
                h.INSTANCE.dN(370, 71);
            }
            AppMethodBeat.o(50942);
            return null;
        }
        String eF = eF(str, adT);
        if (eF != null) {
            StringBuilder append = new StringBuilder("provideScript use XWEBScript appId[").append(this.nts.getAppId()).append("] name[").append(str).append("], path[");
            int b2 = n.b((CharSequence) eF, '/');
            if (b2 > 0) {
                int length = eF.length();
                if (eF == null) {
                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(50942);
                    throw tVar;
                }
                str2 = eF.substring(b2, length);
                p.g(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                str2 = eF;
            }
            Log.i("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", append.append(str2).append(']').toString());
            ag agVar = new ag(3, 0, this.nts.bRI());
            agVar.ob(eF, com.tencent.mm.plugin.appbrand.utils.s.bZs());
            agVar.bsr(adT);
            String agVar2 = agVar.toString();
            AppMethodBeat.o(50942);
            return agVar2;
        }
        AppMethodBeat.o(50942);
        return adT;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x013d, code lost:
        if ((!kotlin.g.b.p.j(r7, r5)) != false) goto L_0x013f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String eF(java.lang.String r17, java.lang.String r18) {
        /*
        // Method dump skipped, instructions count: 934
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.page.bj.eF(java.lang.String, java.lang.String):java.lang.String");
    }

    public void adR(String str) {
        AppMethodBeat.i(50944);
        p.h(str, "name");
        AppMethodBeat.o(50944);
    }

    private static String adU(String str) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(50945);
        Charset charset = d.UTF_8;
        if (str == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(50945);
            throw tVar;
        }
        byte[] bytes = str.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            String b2 = com.tencent.mm.b.g.b(byteArrayInputStream, 16384);
            p.g(b2, "MD5.getMD5(inputStream, 16*1024)");
            b.a(byteArrayInputStream, null);
            AppMethodBeat.o(50945);
            return b2;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(byteArrayInputStream, th2);
            AppMethodBeat.o(50945);
            throw th;
        }
    }
}
