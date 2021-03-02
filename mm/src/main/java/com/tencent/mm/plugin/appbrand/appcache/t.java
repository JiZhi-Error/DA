package com.tencent.mm.plugin.appbrand.appcache;

import android.os.SystemClock;
import com.eclipsesource.a.a;
import com.eclipsesource.a.b;
import com.eclipsesource.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.n.n;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001e\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0004H\u0016J \u0010\u0017\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u001c\u0010\u0019\u001a\u00020\u0011*\u00020\u001a2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/IndexStorageMM;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionPagePathIndexStorage;", "()V", "DIR_PATH", "", "getDIR_PATH", "()Ljava/lang/String;", "INDEX_FILE_SUFFIX", "TAG", "FILE_PATH", "appId", "appVersion", "", "PARSE_FILE_NAME", "Lkotlin/Pair;", "name", "checkIsPageIndexExisted", "", "checkIsPagePathIncluded", "pagePath", "cleanExpiredIndex", "", "removeIndexByAppId", "updatePageIndex", "pagesJson", "checkIsAppVersionAvailable", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrStorage;", "plugin-appbrand-integration_release"})
public final class t implements bp {
    public static final t kKS = new t();

    static {
        AppMethodBeat.i(227985);
        AppMethodBeat.o(227985);
    }

    private t() {
    }

    private static String bvC() {
        AppMethodBeat.i(227976);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        String azM = aAh.azM();
        p.g(azM, "accPath");
        if (!n.nm(azM, FilePathGenerator.ANDROID_DIR_SEP)) {
            azM = azM + FilePathGenerator.ANDROID_DIR_SEP;
        }
        String str = azM + "appbrand/pagesidx/";
        FilePathGenerator.checkMkdir(str);
        AppMethodBeat.o(227976);
        return str;
    }

    private static String aP(String str, int i2) {
        AppMethodBeat.i(227977);
        String absolutePath = new o(bvC(), str + '_' + i2 + ".idx").getAbsolutePath();
        p.g(absolutePath, "VFSFile(DIR_PATH, \"${app…LE_SUFFIX}\").absolutePath");
        AppMethodBeat.o(227977);
        return absolutePath;
    }

    private static kotlin.o<String, Integer> UY(String str) {
        kotlin.o<String, Integer> oVar;
        AppMethodBeat.i(227978);
        List<String> a2 = n.a((CharSequence) n.c(str, (CharSequence) ".idx"), new char[]{'_'});
        try {
            oVar = new kotlin.o<>(a2.get(0), Integer.valueOf(Integer.parseInt(a2.get(1))));
        } catch (Exception e2) {
            oVar = null;
        }
        AppMethodBeat.o(227978);
        return oVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.bp
    public final boolean o(String str, int i2, String str2) {
        String str3;
        String str4;
        boolean z;
        boolean z2;
        AppMethodBeat.i(227979);
        p.h(str, "appId");
        p.h(str2, "pagePath");
        if (!g.aAf().azp()) {
            Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "checkIsPagePathIncluded(appId:" + str + ", appVersion:" + i2 + ", pagePath:" + str2 + "), account().hasInitialized()==FALSE");
            AppMethodBeat.o(227979);
            return false;
        }
        String dM = com.tencent.luggage.h.l.dM(str2);
        if (dM == null) {
            str3 = "";
        } else {
            str3 = dM;
        }
        String c2 = n.c(str3, (CharSequence) ".html");
        if (c2.length() == 0) {
            AppMethodBeat.o(227979);
            return false;
        }
        try {
            str4 = s.boY(aP(str, i2));
        } catch (IOException e2) {
            str4 = "";
        }
        String str5 = str4;
        if (str5 == null || str5.length() == 0) {
            AppMethodBeat.o(227979);
            return false;
        }
        try {
            String str6 = "checkIsPagePathIncluded(pagesJson.length=" + str4.length() + ')';
            long elapsedRealtime = SystemClock.elapsedRealtime();
            h aR = a.aR(str4);
            if (aR instanceof com.eclipsesource.a.e) {
                z2 = ((com.eclipsesource.a.e) aR).aU(c2) != null;
            } else if (aR instanceof b) {
                z2 = j.a((Iterable) aR, a.aQ(c2));
            } else {
                z2 = false;
            }
            Boolean valueOf = Boolean.valueOf(z2);
            String obj = valueOf.toString();
            if (obj == null) {
                obj = "";
            }
            boolean LB = ag.LB();
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (elapsedRealtime2 <= 32 || !LB) {
                Log.i("Luggage.Utils.Profile", "runProfiled:log:" + str6 + " cost " + elapsedRealtime2 + " ms result:" + obj + " isMainThread: " + LB + ' ');
            } else {
                Log.w("Luggage.Utils.Profile", "block main thread and skip " + ((int) (elapsedRealtime2 / 16)) + " frames! runProfiled:log:" + str6 + " cost " + elapsedRealtime2 + " ms result:" + obj + " isMainThread: " + LB + ' ');
            }
            z = valueOf.booleanValue();
        } catch (Exception e3) {
            Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "checkIsPagePathIncluded(appId:" + str + ", appVersion:" + i2 + ", pagePath:" + str2 + "), parse pagesJson failed by " + e3);
            z = false;
        }
        AppMethodBeat.o(227979);
        return z;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.bp
    public final boolean aQ(String str, int i2) {
        AppMethodBeat.i(227980);
        p.h(str, "appId");
        if (!g.aAf().azp()) {
            Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "checkIsPageIndexExisted(appId:" + str + ", appVersion:" + i2 + "), account().hasInitialized()==FALSE");
            AppMethodBeat.o(227980);
            return false;
        }
        boolean YS = s.YS(aP(str, i2));
        AppMethodBeat.o(227980);
        return YS;
    }

    public static void p(String str, int i2, String str2) {
        AppMethodBeat.i(227981);
        p.h(str, "appId");
        p.h(str2, "pagesJson");
        if (!g.aAf().azp()) {
            Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "updatePageIndex(appId:" + str + ", appVersion:" + i2 + "), account().hasInitialized()==FALSE");
            AppMethodBeat.o(227981);
            return;
        }
        try {
            String str3 = "updatePageIndex(appId:" + str + ", appVersion:" + i2 + ", pagesJson.length=" + str2.length() + ')';
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String aP = aP(str, i2);
            byte[] bytes = str2.getBytes(d.UTF_8);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            String obj = Integer.valueOf(s.C(aP, bytes)).toString();
            if (obj == null) {
                obj = "";
            }
            boolean LB = ag.LB();
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (elapsedRealtime2 <= 32 || !LB) {
                Log.i("Luggage.Utils.Profile", "runProfiled:log:" + str3 + " cost " + elapsedRealtime2 + " ms result:" + obj + " isMainThread: " + LB + ' ');
                AppMethodBeat.o(227981);
                return;
            }
            Log.w("Luggage.Utils.Profile", "block main thread and skip " + ((int) (elapsedRealtime2 / 16)) + " frames! runProfiled:log:" + str3 + " cost " + elapsedRealtime2 + " ms result:" + obj + " isMainThread: " + LB + ' ');
            AppMethodBeat.o(227981);
        } catch (IOException e2) {
            Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "updatePageIndex(appId:" + str + ", appVersion:" + i2 + "), writeFile failed by " + e2);
            AppMethodBeat.o(227981);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.bp
    public final void bvD() {
        AppMethodBeat.i(227982);
        if (!g.aAf().azp()) {
            Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "cleanExpiredIndex(), account().hasInitialized()==FALSE");
            AppMethodBeat.o(227982);
            return;
        }
        o oVar = new o(bvC());
        if (!oVar.exists() || !oVar.isDirectory()) {
            try {
                oVar.delete();
                AppMethodBeat.o(227982);
            } catch (Exception e2) {
                AppMethodBeat.o(227982);
            }
        } else {
            z zVar = (z) com.tencent.mm.plugin.appbrand.app.n.W(z.class);
            if (zVar == null) {
                AppMethodBeat.o(227982);
                return;
            }
            v vVar = (v) com.tencent.mm.plugin.appbrand.app.n.W(v.class);
            if (vVar == null) {
                AppMethodBeat.o(227982);
                return;
            }
            o[] het = oVar.het();
            if (het != null) {
                for (o oVar2 : het) {
                    p.g(oVar2, "file");
                    String name = oVar2.getName();
                    if (!(name == null || name.length() == 0)) {
                        String name2 = oVar2.getName();
                        p.g(name2, "file.name");
                        kotlin.o<String, Integer> UY = UY(name2);
                        if (UY != null) {
                            A a2 = UY.first;
                            int intValue = UY.second.intValue();
                            if (!a(zVar, a2, intValue) && !a(vVar, a2, intValue)) {
                                oVar2.delete();
                            }
                        }
                    }
                }
                AppMethodBeat.o(227982);
                return;
            }
            AppMethodBeat.o(227982);
        }
    }

    private static boolean a(x xVar, String str, int i2) {
        WxaAttributes.WxaVersionInfo bAp;
        AppMethodBeat.i(227983);
        WxaAttributes e2 = xVar.e(str, "versionInfo");
        if (e2 == null || (bAp = e2.bAp()) == null || bAp.appVersion != i2) {
            AppMethodBeat.o(227983);
            return false;
        }
        AppMethodBeat.o(227983);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.bp
    public final void UZ(String str) {
        A a2;
        AppMethodBeat.i(227984);
        p.h(str, "appId");
        if (!g.aAf().azp()) {
            Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "removeIndexByAppId(" + str + "), account().hasInitialized()==FALSE");
            AppMethodBeat.o(227984);
            return;
        }
        o oVar = new o(bvC());
        if (!oVar.exists() || !oVar.isDirectory()) {
            try {
                oVar.delete();
                AppMethodBeat.o(227984);
            } catch (Exception e2) {
                AppMethodBeat.o(227984);
            }
        } else {
            o[] het = oVar.het();
            if (het != null) {
                for (o oVar2 : het) {
                    p.g(oVar2, "file");
                    String name = oVar2.getName();
                    if (!(name == null || name.length() == 0)) {
                        String name2 = oVar2.getName();
                        p.g(name2, "file.name");
                        kotlin.o<String, Integer> UY = UY(name2);
                        if (UY != null) {
                            a2 = UY.first;
                        } else {
                            a2 = null;
                        }
                        if (p.j(str, a2)) {
                            oVar2.delete();
                        }
                    }
                }
                AppMethodBeat.o(227984);
                return;
            }
            AppMethodBeat.o(227984);
        }
    }
}
