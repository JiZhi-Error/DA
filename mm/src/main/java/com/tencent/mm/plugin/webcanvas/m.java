package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.abe;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.service.u;
import com.tencent.mm.plugin.appbrand.service.v;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.deg;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.Result;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019*\u0001\u001d\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0004H\u0002J\u0010\u0010C\u001a\u00020A2\b\b\u0002\u0010D\u001a\u00020\u0018J+\u0010E\u001a\u00020\u00182\u0006\u0010F\u001a\u00020G2\u0006\u0010B\u001a\u00020\u00042\b\u0010H\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010IJ\u000e\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040!H\u0002J\u0010\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010B\u001a\u00020\u0004J\u001a\u0010M\u001a\u0004\u0018\u00010\u00042\u0006\u0010B\u001a\u00020\u00042\b\b\u0002\u0010N\u001a\u00020&J\u0010\u0010O\u001a\u0004\u0018\u00010\u00042\u0006\u0010B\u001a\u00020\u0004J\u0006\u0010P\u001a\u00020\u0004J\u000e\u0010Q\u001a\u00020&2\u0006\u0010B\u001a\u00020\u0004J\"\u0010R\u001a\u00020\u00182\u0006\u0010B\u001a\u00020\u00042\b\u0010S\u001a\u0004\u0018\u00010\u00042\u0006\u0010T\u001a\u00020&H\u0002J\u0016\u0010U\u001a\u00020\u00182\u0006\u0010V\u001a\u0002092\u0006\u0010W\u001a\u000209J\u0006\u0010X\u001a\u00020AJ\b\u0010Y\u001a\u00020AH\u0002J\u0006\u0010Z\u001a\u00020AJ\u000e\u0010Z\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0004J\u0018\u0010[\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\\\u001a\u00020\u000fJ\u0006\u0010]\u001a\u00020AJ\u0006\u0010^\u001a\u00020AJ\u001a\u0010_\u001a\u00020\u00182\u0006\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\\\u001a\u00020\u000fH\u0002J\n\u0010`\u001a\u00020\u0004*\u00020\u0004J\n\u0010a\u001a\u00020\u0004*\u00020\u0004J\n\u0010b\u001a\u00020\u0004*\u00020\u0004J\n\u0010c\u001a\u00020\u0004*\u00020\u0004J\u0012\u0010d\u001a\u00020\u0004*\u0002092\u0006\u0010S\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040!8FX\u0002¢\u0006\f\n\u0004\b$\u0010\u0016\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8FX\u0002¢\u0006\f\n\u0004\b)\u0010\u0016\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b-\u0010\u0016\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b0\u0010\u0016\u001a\u0004\b/\u0010,R\u001b\u00101\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b3\u0010\u0016\u001a\u0004\b2\u0010,R\u001b\u00104\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b6\u0010\u0016\u001a\u0004\b5\u0010,R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0015\u00108\u001a\u00020&*\u0002098F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0015\u0010<\u001a\u00020&*\u0002098F¢\u0006\u0006\u001a\u0004\b=\u0010;R\u0015\u0010>\u001a\u00020&*\u0002098F¢\u0006\u0006\u001a\u0004\b?\u0010;\u0002\u0004\n\u0002\b\u0019¨\u0006e"}, hxF = {"Lcom/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic;", "", "()V", "KEY_PREFETCHER_BIZ_APPIDS", "", "KEY_WEB_CANVAS_LAST_CLEAR_PKG_TIME", "KEY_WEB_CANVAS_LAST_DOWNLOAD_PKG_BY_GET_DATA_TIME", "KEY_WEB_CANVAS_PREVIEW_PKG_MD5", "TAG", "WEB_CANVAS_PKG_PATH", "getWEB_CANVAS_PKG_PATH", "()Ljava/lang/String;", "adPrefetchAppId", "bizPkgAppId", "lastTriggerPreDownloadTime", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "pkgDownloadOpen", "", "getPkgDownloadOpen", "()Z", "pkgDownloadOpen$delegate", "pkgUpdateEventListener", "com/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$pkgUpdateEventListener$1", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$pkgUpdateEventListener$1;", "prefetchBasePkgAppId", "prefetchBizPkgAppIds", "Ljava/util/LinkedList;", "getPrefetchBizPkgAppIds", "()Ljava/util/LinkedList;", "prefetchBizPkgAppIds$delegate", "previewMode", "", "getPreviewMode", "()I", "previewMode$delegate", "triggerDownLoadPkgInterval", "getTriggerDownLoadPkgInterval", "()J", "triggerDownLoadPkgInterval$delegate", "triggerDownLoadPkgOnGetDataInterval", "getTriggerDownLoadPkgOnGetDataInterval", "triggerDownLoadPkgOnGetDataInterval$delegate", "triggerDownLoadPrefetchPkgInterval", "getTriggerDownLoadPrefetchPkgInterval", "triggerDownLoadPrefetchPkgInterval$delegate", "webPrefetchPkgInterval", "getWebPrefetchPkgInterval", "webPrefetchPkgInterval$delegate", "wxaPkgAppId", "minBasePkgVersion", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getMinBasePkgVersion", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "minClientVersion", "getMinClientVersion", "version", "getVersion", "checkPreviewVersion", "", "appId", "clearInvalidPkg", "force", "fetchBizPrefetchPkg", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "userName", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBizAppIds", "getPkgInfo", "Lcom/tencent/mm/protocal/protobuf/CanvasPkgInfo;", "getPreviewPkgPath", "pkgType", "getReleasePkgPath", "getWebCanvasCachePath", "getWxaPkgVersion", "isPkgValid", "path", "wxaVersion", "isWxaPkgSupport", "bizPkg", "wxaPkg", "regPkgUpdateEventListener", "saveBizAppIds", "triggerPreDownload", "triggerPreDownloadBizPrefetchPkg", "interval", "triggerPreDownloadByGetData", "triggerPreDownloadPrefetchBasePkg", "triggerPreDownloadPrefetchPkg", "lastDownloadTime", "lastUsePathKey", "lastUseTimeKey", "pkgInfoKey", "readFile", "webview-sdk_release"})
public final class m {
    private static final kotlin.f IAA = kotlin.g.ah(i.IAM);
    private static final kotlin.f IAB = kotlin.g.ah(f.IAK);
    private static final kotlin.f IAC = kotlin.g.ah(k.IAO);
    private static final kotlin.f IAD = kotlin.g.ah(l.IAP);
    private static final kotlin.f IAE = kotlin.g.ah(j.IAN);
    private static final g IAF = new g();
    public static final m IAG = new m();
    private static final String IAy = (com.tencent.mm.loader.j.b.aKB() + "/WebCanvasPkg");
    private static final kotlin.f IAz = kotlin.g.ah(h.IAL);
    private static final kotlin.f VgC = kotlin.g.ah(o.VgD);
    private static final kotlin.f iBW = kotlin.g.ah(e.IAJ);
    private static long pmU;

    private static MultiProcessMMKV aTI() {
        AppMethodBeat.i(224730);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) iBW.getValue();
        AppMethodBeat.o(224730);
        return multiProcessMMKV;
    }

    public static LinkedList<String> fWI() {
        AppMethodBeat.i(224725);
        LinkedList<String> linkedList = (LinkedList) IAz.getValue();
        AppMethodBeat.o(224725);
        return linkedList;
    }

    public static int fWJ() {
        AppMethodBeat.i(224731);
        int intValue = ((Number) IAA.getValue()).intValue();
        AppMethodBeat.o(224731);
        return intValue;
    }

    private static boolean fWK() {
        AppMethodBeat.i(224732);
        boolean booleanValue = ((Boolean) IAB.getValue()).booleanValue();
        AppMethodBeat.o(224732);
        return booleanValue;
    }

    private static long fWL() {
        AppMethodBeat.i(224733);
        long longValue = ((Number) IAD.getValue()).longValue();
        AppMethodBeat.o(224733);
        return longValue;
    }

    private static long fWM() {
        AppMethodBeat.i(224734);
        long longValue = ((Number) IAE.getValue()).longValue();
        AppMethodBeat.o(224734);
        return longValue;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "filePath", "", "invoke"})
    public static final class a implements u.b {
        final /* synthetic */ String kPQ;

        a(String str) {
            this.kPQ = str;
        }

        @Override // com.tencent.mm.plugin.appbrand.service.u.b
        public final /* synthetic */ void a(bd bdVar, String str) {
            AppMethodBeat.i(224698);
            p.h(bdVar, "record");
            p.h(str, "filePath");
            Log.i("MicroMsg.WebCanvasStorageLogic", "checkPreviewVersion(appId:" + this.kPQ + "), onSuccess(path:" + str + ')');
            AppMethodBeat.o(224698);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "filePath", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.webcanvas.m$m  reason: collision with other inner class name */
    public static final class C1937m implements u.b {
        final /* synthetic */ String kPQ;

        C1937m(String str) {
            this.kPQ = str;
        }

        @Override // com.tencent.mm.plugin.appbrand.service.u.b
        public final /* synthetic */ void a(bd bdVar, String str) {
            AppMethodBeat.i(224722);
            p.h(bdVar, "record");
            p.h(str, "filePath");
            Log.i("MicroMsg.WebCanvasStorageLogic", "triggerPreDownload(appId:" + this.kPQ + "), onSuccess(path:" + str + ')');
            AppMethodBeat.o(224722);
        }
    }

    static {
        AppMethodBeat.i(224755);
        AppMethodBeat.o(224755);
    }

    private m() {
    }

    public static final /* synthetic */ LinkedList a(m mVar) {
        AppMethodBeat.i(224757);
        LinkedList<String> fWQ = mVar.fWQ();
        AppMethodBeat.o(224757);
        return fWQ;
    }

    public static final /* synthetic */ boolean a(m mVar, String str, String str2, int i2) {
        AppMethodBeat.i(224758);
        boolean al = al(str, str2, i2);
        AppMethodBeat.o(224758);
        return al;
    }

    public static final /* synthetic */ MultiProcessMMKV fWT() {
        AppMethodBeat.i(224756);
        MultiProcessMMKV aTI = aTI();
        AppMethodBeat.o(224756);
        return aTI;
    }

    public static String fWG() {
        return IAy;
    }

    public static String fWH() {
        AppMethodBeat.i(224724);
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        String sb2 = sb.append(aAh.getAccPath()).append("webcanvascache/").toString();
        if (!s.YS(sb2)) {
            s.boN(sb2);
        }
        AppMethodBeat.o(224724);
        return sb2;
    }

    public static String aWD(String str) {
        AppMethodBeat.i(224726);
        p.h(str, "$this$pkgInfoKey");
        String concat = "webcanvas_pkg_info_".concat(String.valueOf(str));
        AppMethodBeat.o(224726);
        return concat;
    }

    public static String aWE(String str) {
        AppMethodBeat.i(224727);
        p.h(str, "$this$lastUsePathKey");
        String concat = "webcanvas_last_use_pkg_path_".concat(String.valueOf(str));
        AppMethodBeat.o(224727);
        return concat;
    }

    public static String aWF(String str) {
        AppMethodBeat.i(224728);
        p.h(str, "$this$lastUseTimeKey");
        String concat = "webcanvas_last_use_pkg_time_".concat(String.valueOf(str));
        AppMethodBeat.o(224728);
        return concat;
    }

    private static String aWG(String str) {
        AppMethodBeat.i(224729);
        p.h(str, "$this$lastDownloadTime");
        String str2 = str + "-lastDownLoawnTime";
        AppMethodBeat.o(224729);
        return str2;
    }

    public final String aWH(String str) {
        AppMethodBeat.i(224735);
        p.h(str, "appId");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(224735);
            return null;
        }
        tu aWJ = aWJ(str);
        if (aWJ == null) {
            Log.i("MicroMsg.WebCanvasStorageLogic", "geReleasePkgPath pkgInfo is null");
            AppMethodBeat.o(224735);
            return null;
        } else if (!s.YS(aWJ.path)) {
            Log.i("MicroMsg.WebCanvasStorageLogic", "geReleasePkgPath pkgInfo " + aWJ.path + " not exist");
            AppMethodBeat.o(224735);
            return null;
        } else {
            Log.i("MicroMsg.WebCanvasStorageLogic", "geReleasePkgPath appId=" + str + ", md5=" + aWJ.md5 + " download version= " + aWJ.version + " path=" + aWJ.path);
            aTI().encode(aWE(str), new com.tencent.mm.vfs.o(aWJ.path).getAbsolutePath());
            aTI().encode(aWF(str), System.currentTimeMillis());
            String str2 = aWJ.path;
            AppMethodBeat.o(224735);
            return str2;
        }
    }

    public static /* synthetic */ String aWI(String str) {
        String str2;
        Integer num;
        String str3;
        AppMethodBeat.i(224736);
        p.h(str, "appId");
        bd H = ((v) com.tencent.mm.kernel.g.af(v.class)).H(str, 2, 0);
        StringBuilder append = new StringBuilder("getPreviewPkgPath appId=").append(str).append(", pkgType=2, md5=");
        if (H != null) {
            str2 = H.field_versionMd5;
        } else {
            str2 = null;
        }
        StringBuilder append2 = append.append(str2).append(" download version= ");
        if (H != null) {
            num = Integer.valueOf(H.field_version);
        } else {
            num = null;
        }
        StringBuilder append3 = append2.append(num).append(" path=");
        if (H != null) {
            str3 = H.field_pkgPath;
        } else {
            str3 = null;
        }
        Log.i("MicroMsg.WebCanvasStorageLogic", append3.append(str3).toString());
        if (H != null) {
            String str4 = H.field_pkgPath;
            AppMethodBeat.o(224736);
            return str4;
        }
        AppMethodBeat.o(224736);
        return null;
    }

    private static String a(com.tencent.mm.plugin.appbrand.appcache.p pVar, String str) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(224737);
        p.h(pVar, "$this$readFile");
        p.h(str, "path");
        InputStream UR = pVar.UR(str);
        try {
            InputStream inputStream = UR;
            p.g(inputStream, LocaleUtil.ITALIAN);
            String str2 = new String(kotlin.f.a.U(inputStream), kotlin.n.d.UTF_8);
            kotlin.f.b.a(UR, null);
            AppMethodBeat.o(224737);
            return str2;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            kotlin.f.b.a(UR, th2);
            AppMethodBeat.o(224737);
            throw th;
        }
    }

    private static int a(com.tencent.mm.plugin.appbrand.appcache.p pVar) {
        AppMethodBeat.i(224738);
        p.h(pVar, "$this$version");
        int optInt = new com.tencent.mm.ab.i(a(pVar, "/meta.json")).optInt("version");
        AppMethodBeat.o(224738);
        return optInt;
    }

    private static boolean al(String str, String str2, int i2) {
        AppMethodBeat.i(224739);
        if (!s.YS(str2)) {
            Log.w("MicroMsg.WebCanvasStorageLogic", "isPkgValid file not exit ".concat(String.valueOf(str2)));
            switch (str.hashCode()) {
                case -1635202514:
                    if (str.equals("wx97b7aebac2183fd2")) {
                        l lVar = l.IAx;
                        l.LV(49);
                        break;
                    }
                    break;
                case -1154368401:
                    if (str.equals("wxfedb0854e2b1820d")) {
                        l lVar2 = l.IAx;
                        l.LV(42);
                        break;
                    }
                    break;
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(20780, str, Integer.valueOf(i2), 0, 3);
            AppMethodBeat.o(224739);
            return false;
        }
        try {
            WxaPkg wxaPkg = new WxaPkg(str2);
            wxaPkg.bvf();
            WxaPkg wxaPkg2 = wxaPkg;
            p.h(wxaPkg2, "$this$minClientVersion");
            int optInt = new com.tencent.mm.ab.i(a(wxaPkg2, "/meta.json")).optInt("minAndroidClientVersion");
            int a2 = a(wxaPkg);
            wxaPkg.close();
            Log.i("MicroMsg.WebCanvasStorageLogic", "isPkgValid appId=" + str + ", minClientVersion=0x%x, localClientVersion=0x%x", Integer.valueOf(optInt), Integer.valueOf(com.tencent.mm.protocal.d.KyO));
            if (optInt <= com.tencent.mm.protocal.d.KyO) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(20780, str, Integer.valueOf(i2), Integer.valueOf(a2), 0);
                AppMethodBeat.o(224739);
                return true;
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(20780, str, Integer.valueOf(i2), Integer.valueOf(a2), 1);
            Log.w("MicroMsg.WebCanvasStorageLogic", "isPkgValid minClientVersion check fail");
            switch (str.hashCode()) {
                case -1635202514:
                    if (str.equals("wx97b7aebac2183fd2")) {
                        l lVar3 = l.IAx;
                        l.LV(50);
                        break;
                    }
                    break;
                case -1154368401:
                    if (str.equals("wxfedb0854e2b1820d")) {
                        l lVar4 = l.IAx;
                        l.LV(43);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(224739);
            return false;
        } catch (Exception e2) {
            Log.e("MicroMsg.WebCanvasStorageLogic", "isPkgValid ex " + e2.getMessage());
        }
    }

    public static void fWN() {
        AppMethodBeat.i(224740);
        IAF.alive();
        AppMethodBeat.o(224740);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$pkgUpdateEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/WxaPkgDownloadCompleteNotifyEvent;", "callback", "", "event", "webview-sdk_release"})
    public static final class g extends IListener<abe> {
        g() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(abe abe) {
            AppMethodBeat.i(224711);
            boolean a2 = a(abe);
            AppMethodBeat.o(224711);
            return a2;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00a9  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean a(com.tencent.mm.g.a.abe r10) {
            /*
            // Method dump skipped, instructions count: 506
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webcanvas.m.g.a(com.tencent.mm.g.a.abe):boolean");
        }
    }

    public static tu aWJ(String str) {
        Object obj;
        byte[] decodeBytes;
        boolean z = true;
        AppMethodBeat.i(224741);
        p.h(str, "appId");
        MultiProcessMMKV aTI = aTI();
        p.g(aTI, "mmkv");
        String aWD = aWD(str);
        if (aTI.containsKey(aWD) && (decodeBytes = aTI.decodeBytes(aWD)) != null) {
            if (decodeBytes.length == 0) {
                z = false;
            }
            if (z) {
                try {
                    Object newInstance = tu.class.newInstance();
                    ((com.tencent.mm.bw.a) newInstance).parseFrom(decodeBytes);
                    obj = (com.tencent.mm.bw.a) newInstance;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", e2, "decode ProtoBuffer", new Object[0]);
                }
                tu tuVar = (tu) obj;
                AppMethodBeat.o(224741);
                return tuVar;
            }
        }
        obj = null;
        tu tuVar2 = (tu) obj;
        AppMethodBeat.o(224741);
        return tuVar2;
    }

    public final int aWK(String str) {
        AppMethodBeat.i(224742);
        p.h(str, "appId");
        tu aWJ = aWJ(str);
        if (aWJ != null) {
            int i2 = aWJ.version;
            AppMethodBeat.o(224742);
            return i2;
        }
        AppMethodBeat.o(224742);
        return 0;
    }

    public static boolean a(com.tencent.mm.plugin.appbrand.appcache.p pVar, com.tencent.mm.plugin.appbrand.appcache.p pVar2) {
        AppMethodBeat.i(224743);
        p.h(pVar, "bizPkg");
        p.h(pVar2, "wxaPkg");
        try {
            p.h(pVar, "$this$minBasePkgVersion");
            int optInt = new com.tencent.mm.ab.i(a(pVar, "/meta.json")).optInt("minAndroidBasePkgVersion");
            int a2 = a(pVar2);
            Log.i("MicroMsg.WebCanvasStorageLogic", "isPkgValid minBasePkgVersion=" + optInt + ", wxaPkgVersionn=" + a2);
            if (optInt <= a2) {
                AppMethodBeat.o(224743);
                return true;
            }
            Log.w("MicroMsg.WebCanvasStorageLogic", "isWxaPkgSupport minBasePkgVersion check fail");
            l lVar = l.IAx;
            l.LV(59);
            AppMethodBeat.o(224743);
            return false;
        } catch (Exception e2) {
            Log.e("MicroMsg.WebCanvasStorageLogic", "isWxaPkgSupport ex " + e2.getMessage());
        }
    }

    public final void fWO() {
        AppMethodBeat.i(224744);
        if (System.currentTimeMillis() - pmU < fWM()) {
            AppMethodBeat.o(224744);
            return;
        }
        pmU = System.currentTimeMillis();
        if (!fWK()) {
            AppMethodBeat.o(224744);
            return;
        }
        l lVar = l.IAx;
        l.LV(40);
        aWN("wxfedb0854e2b1820d");
        aWN("wxf337cbaa27790d8e");
        a(this, "wxa06c02b5c00ff39b");
        if (fWJ() == 1) {
            aWO("wxfedb0854e2b1820d");
            aWO("wxf337cbaa27790d8e");
        }
        AppMethodBeat.o(224744);
    }

    public static Object b(com.tencent.mm.plugin.ad.a aVar, String str, kotlin.d.d<? super Boolean> dVar) {
        AppMethodBeat.i(263534);
        kotlin.d.h hVar = new kotlin.d.h(kotlin.d.a.b.e(dVar));
        kotlin.d.h hVar2 = hVar;
        d dVar2 = new d(hVar2, str, aVar);
        IAG.cn(str, ((Number) VgC.getValue()).longValue());
        if (s.YS(IAG.aWH(str))) {
            com.tencent.mm.plugin.report.service.h hVar3 = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr = new Object[7];
            objArr[0] = aVar.ICs;
            objArr[1] = Integer.valueOf(aVar.hDa);
            objArr[2] = 1;
            objArr[3] = "";
            String str2 = aVar.ICt.LQV;
            if (str2 == null) {
                str2 = "";
            }
            objArr[4] = str2;
            objArr[5] = 1;
            objArr[6] = Integer.valueOf(aVar.hDa);
            hVar3.a(21074, objArr);
            Boolean bool = Boolean.TRUE;
            Result.Companion companion = Result.Companion;
            hVar2.resumeWith(Result.m46constructorimpl(bool));
        } else {
            Log.i("MicroMsg.WebCanvasStorageLogic", "fetchBizPrefetchPkg pkg not exist, wait for download complete. appId=".concat(String.valueOf(str)));
            com.tencent.mm.plugin.report.service.h hVar4 = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr2 = new Object[7];
            objArr2[0] = aVar.ICs;
            objArr2[1] = Integer.valueOf(aVar.hDa);
            objArr2[2] = 1;
            objArr2[3] = "";
            String str3 = aVar.ICt.LQV;
            if (str3 == null) {
                str3 = "";
            }
            objArr2[4] = str3;
            objArr2[5] = 3;
            objArr2[6] = Integer.valueOf(aVar.hDa);
            hVar4.a(21074, objArr2);
            dVar2.invoke();
        }
        Object hxK = hVar.hxK();
        if (hxK == kotlin.d.a.a.COROUTINE_SUSPENDED) {
            p.h(dVar, "frame");
        }
        AppMethodBeat.o(263534);
        return hxK;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"checkDownloadResult", "", "invoke", "com/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$fetchBizPrefetchPkg$2$1"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ String nwh;
        final /* synthetic */ kotlin.d.d pEq;
        final /* synthetic */ com.tencent.mm.plugin.ad.a pEr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(kotlin.d.d dVar, String str, com.tencent.mm.plugin.ad.a aVar) {
            super(0);
            this.pEq = dVar;
            this.nwh = str;
            this.pEr = aVar;
        }

        @Override // kotlin.g.a.a
        public final void invoke() {
            AppMethodBeat.i(224705);
            ((u) com.tencent.mm.kernel.g.af(u.class)).a(this.nwh, 0, new u.b(this) {
                /* class com.tencent.mm.plugin.webcanvas.m.d.AnonymousClass1 */
                final /* synthetic */ d IAI;

                {
                    this.IAI = r1;
                }

                @Override // com.tencent.mm.plugin.appbrand.service.u.b
                public final /* synthetic */ void a(bd bdVar, String str) {
                    AppMethodBeat.i(224702);
                    p.h(bdVar, "record");
                    p.h(str, "filePath");
                    Log.i("MicroMsg.WebCanvasStorageLogic", "fetchBizPrefetchPkg(appId:" + this.IAI.nwh + "), onSuccess(path:" + str + ')');
                    if (s.YS(str)) {
                        Log.i("MicroMsg.WebCanvasStorageLogic", "fetchBizPrefetchPkg download success. appId=" + this.IAI.nwh);
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                        Object[] objArr = new Object[7];
                        objArr[0] = this.IAI.pEr.ICs;
                        objArr[1] = Integer.valueOf(this.IAI.pEr.hDa);
                        objArr[2] = 1;
                        objArr[3] = "";
                        String str2 = this.IAI.pEr.ICt.LQV;
                        if (str2 == null) {
                            str2 = "";
                        }
                        objArr[4] = str2;
                        objArr[5] = 1;
                        objArr[6] = Integer.valueOf(this.IAI.pEr.hDa);
                        hVar.a(21074, objArr);
                        kotlin.d.d dVar = this.IAI.pEq;
                        Boolean bool = Boolean.TRUE;
                        Result.Companion companion = Result.Companion;
                        dVar.resumeWith(Result.m46constructorimpl(bool));
                        AppMethodBeat.o(224702);
                        return;
                    }
                    kotlin.d.d dVar2 = this.IAI.pEq;
                    Boolean bool2 = Boolean.FALSE;
                    Result.Companion companion2 = Result.Companion;
                    dVar2.resumeWith(Result.m46constructorimpl(bool2));
                    AppMethodBeat.o(224702);
                }
            }, new u.a(this) {
                /* class com.tencent.mm.plugin.webcanvas.m.d.AnonymousClass2 */
                final /* synthetic */ d IAI;

                {
                    this.IAI = r1;
                }

                @Override // com.tencent.mm.plugin.appbrand.service.u.a
                public final /* synthetic */ void onError(int i2, String str) {
                    AppMethodBeat.i(224703);
                    Log.e("MicroMsg.WebCanvasStorageLogic", "triggerPreDownload(appId:" + this.IAI.nwh + "), onError(errCode:" + i2 + ", errMsg:" + str + ')');
                    kotlin.d.d dVar = this.IAI.pEq;
                    Boolean bool = Boolean.FALSE;
                    Result.Companion companion = Result.Companion;
                    dVar.resumeWith(Result.m46constructorimpl(bool));
                    AppMethodBeat.o(224703);
                }
            });
            AppMethodBeat.o(224705);
        }
    }

    private static /* synthetic */ void a(m mVar, String str) {
        AppMethodBeat.i(263536);
        mVar.cn(str, fWL());
        AppMethodBeat.o(263536);
    }

    private void cn(String str, long j2) {
        AppMethodBeat.i(263535);
        p.h(str, "appId");
        if (!fWI().contains(str)) {
            fWI().add(str);
            fWR();
        }
        if (fWJ() == 1) {
            aWO("wx97b7aebac2183fd2");
            aWO(str);
            AppMethodBeat.o(263535);
            return;
        }
        fWP();
        co(str, j2);
        AppMethodBeat.o(263535);
    }

    public final void fWP() {
        AppMethodBeat.i(224747);
        if (b(this, "wx97b7aebac2183fd2")) {
            l lVar = l.IAx;
            l.LV(54);
        }
        AppMethodBeat.o(224747);
    }

    private static /* synthetic */ boolean b(m mVar, String str) {
        AppMethodBeat.i(263538);
        boolean co = co(str, fWL());
        AppMethodBeat.o(263538);
        return co;
    }

    private static boolean co(String str, long j2) {
        AppMethodBeat.i(263537);
        long j3 = aTI().getLong(aWG(str), 0);
        long currentTimeMillis = System.currentTimeMillis();
        long abs = Math.abs(currentTimeMillis - j3);
        if ((fWJ() != 0 || abs >= j2) && (fWJ() == 0 || abs >= 10000)) {
            Log.d("MicroMsg.WebCanvasStorageLogic", "triggerPreDownloadPrefetchPkg ".concat(String.valueOf(str)));
            aTI().encode(aWG(str), currentTimeMillis);
            aWN(str);
            AppMethodBeat.o(263537);
            return true;
        }
        Log.d("MicroMsg.WebCanvasStorageLogic", "triggerPreDownloadPrefetchPkg return " + fWJ());
        AppMethodBeat.o(263537);
        return false;
    }

    private final synchronized LinkedList<String> fWQ() {
        Object obj;
        LinkedList<String> linkedList;
        byte[] decodeBytes;
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(224749);
            MultiProcessMMKV aTI = aTI();
            p.g(aTI, "mmkv");
            if (aTI.containsKey("KPrefetcherBizAppIds") && (decodeBytes = aTI.decodeBytes("KPrefetcherBizAppIds")) != null) {
                if (decodeBytes.length == 0) {
                    z = false;
                }
                if (z) {
                    try {
                        Object newInstance = deg.class.newInstance();
                        ((com.tencent.mm.bw.a) newInstance).parseFrom(decodeBytes);
                        obj = (com.tencent.mm.bw.a) newInstance;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", e2, "decode ProtoBuffer", new Object[0]);
                    }
                    deg deg = (deg) obj;
                    if (deg == null || (linkedList = deg.MJp) == null) {
                        linkedList = new LinkedList<>();
                    }
                    Log.d("MicroMsg.WebCanvasStorageLogic", "getBizAppIds size " + linkedList.size());
                    AppMethodBeat.o(224749);
                }
            }
            obj = null;
            deg deg2 = (deg) obj;
            linkedList = new LinkedList<>();
            Log.d("MicroMsg.WebCanvasStorageLogic", "getBizAppIds size " + linkedList.size());
            AppMethodBeat.o(224749);
        }
        return linkedList;
    }

    private final synchronized void fWR() {
        AppMethodBeat.i(224750);
        try {
            MultiProcessMMKV aTI = aTI();
            deg deg = new deg();
            deg.MJp = fWI();
            aTI.encode("KPrefetcherBizAppIds", deg.toByteArray());
            AppMethodBeat.o(224750);
        } catch (Exception e2) {
            Log.e("MicroMsg.WebCanvasStorageLogic", "saveBizAppIds ex " + e2.getMessage());
            AppMethodBeat.o(224750);
        }
    }

    public final void fWS() {
        AppMethodBeat.i(224751);
        if (!fWK()) {
            AppMethodBeat.o(224751);
            return;
        }
        long j2 = aTI().getLong("webcanvas_last_download_pkg_by_get_data_time", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - j2) < ((Number) IAC.getValue()).longValue()) {
            AppMethodBeat.o(224751);
            return;
        }
        l lVar = l.IAx;
        l.LV(45);
        aTI().encode("webcanvas_last_download_pkg_by_get_data_time", currentTimeMillis);
        fWO();
        AppMethodBeat.o(224751);
    }

    private static void aWN(String str) {
        AppMethodBeat.i(224752);
        p.h(str, "appId");
        ((u) com.tencent.mm.kernel.g.af(u.class)).a(str, 0, new C1937m(str), new n(str));
        AppMethodBeat.o(224752);
    }

    private static void aWO(String str) {
        AppMethodBeat.i(224753);
        ((u) com.tencent.mm.kernel.g.af(u.class)).a(str, 2, new a(str), new b(str));
        AppMethodBeat.o(224753);
    }

    public static void yK(boolean z) {
        AppMethodBeat.i(224754);
        long decodeLong = aTI().decodeLong("webcanvas_last_clear_pkg_time", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long abs = Math.abs(currentTimeMillis - decodeLong);
        if (z || abs >= Util.MILLSECONDS_OF_DAY) {
            aTI().encode("webcanvas_last_clear_pkg_time", currentTimeMillis);
            com.tencent.f.h.RTc.o(c.IAH, 10000);
            AppMethodBeat.o(224754);
            return;
        }
        Log.d("MicroMsg.WebCanvasStorageLogic", "clearInvalidPkg delta ".concat(String.valueOf(abs)));
        AppMethodBeat.o(224754);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        public static final c IAH = new c();

        static {
            AppMethodBeat.i(224701);
            AppMethodBeat.o(224701);
        }

        c() {
        }

        public final void run() {
            com.tencent.mm.vfs.o[] het;
            AppMethodBeat.i(224700);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> ac = kotlin.a.j.ac("wxf337cbaa27790d8e", "wxfedb0854e2b1820d", "wx97b7aebac2183fd2");
            m mVar = m.IAG;
            ac.addAll(m.fWI());
            for (String str : ac) {
                StringBuilder sb = new StringBuilder();
                m mVar2 = m.IAG;
                com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(sb.append(m.fWG()).append('/').append(str).append('/').toString());
                m mVar3 = m.IAG;
                MultiProcessMMKV fWT = m.fWT();
                m mVar4 = m.IAG;
                String decodeString = fWT.decodeString(m.aWE(str), "");
                m mVar5 = m.IAG;
                MultiProcessMMKV fWT2 = m.fWT();
                m mVar6 = m.IAG;
                long decodeLong = fWT2.decodeLong(m.aWF(str), 0);
                String aWH = m.IAG.aWH(str);
                if (oVar.exists() && oVar.isDirectory() && (het = oVar.het()) != null) {
                    for (com.tencent.mm.vfs.o oVar2 : het) {
                        p.g(oVar2, "file");
                        if (Util.isEqual(oVar2.getAbsolutePath(), decodeString) || Util.isEqual(oVar2.getAbsolutePath(), aWH)) {
                            m mVar7 = m.IAG;
                            if (m.fWI().contains(str) && (!p.j("wxa06c02b5c00ff39b", str)) && decodeLong != 0 && currentTimeMillis - decodeLong > 2592000000L) {
                                oVar2.delete();
                                Log.i("MicroMsg.WebCanvasStorageLogic", "clearInvalidPkg on timeout appId=" + str + ", path=" + oVar2.getAbsolutePath() + '}');
                                l lVar = l.IAx;
                                l.LV(121);
                            }
                        } else {
                            oVar2.delete();
                            Log.i("MicroMsg.WebCanvasStorageLogic", "clearInvalidPkg appId=" + str + ", path=" + oVar2.getAbsolutePath() + '}');
                            l lVar2 = l.IAx;
                            l.LV(120);
                        }
                    }
                }
            }
            AppMethodBeat.o(224700);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "", "invoke"})
    static final class h extends q implements kotlin.g.a.a<LinkedList<String>> {
        public static final h IAL = new h();

        static {
            AppMethodBeat.i(224713);
            AppMethodBeat.o(224713);
        }

        h() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinkedList<String> invoke() {
            AppMethodBeat.i(224712);
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(m.a(m.IAG));
            AppMethodBeat.o(224712);
            return linkedList;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final e IAJ = new e();

        static {
            AppMethodBeat.i(224707);
            AppMethodBeat.o(224707);
        }

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(224706);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("WebCanvasStorage");
            AppMethodBeat.o(224706);
            return mmkv;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends q implements kotlin.g.a.a<Integer> {
        public static final i IAM = new i();

        static {
            AppMethodBeat.i(224715);
            AppMethodBeat.o(224715);
        }

        i() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(224714);
            m mVar = m.IAG;
            Integer valueOf = Integer.valueOf(m.fWT().decodeInt("BizTimeLineAdPreviewMode", 0));
            AppMethodBeat.o(224714);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<Boolean> {
        public static final f IAK = new f();

        static {
            AppMethodBeat.i(224709);
            AppMethodBeat.o(224709);
        }

        f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
            if (r0 != false) goto L_0x003a;
         */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Boolean invoke() {
            /*
                r7 = this;
                r6 = 224708(0x36dc4, float:3.14883E-40)
                r1 = 1
                r2 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                boolean r0 = com.tencent.mm.sdk.platformtools.BuildInfo.DEBUG
                if (r0 != 0) goto L_0x003a
                boolean r0 = com.tencent.mm.sdk.platformtools.BuildInfo.IS_FLAVOR_RED
                if (r0 != 0) goto L_0x003a
                boolean r0 = com.tencent.mm.sdk.platformtools.WeChatEnvironment.hasDebugger()
                if (r0 != 0) goto L_0x003a
                java.lang.Class<com.tencent.mm.plugin.expt.b.b> r0 = com.tencent.mm.plugin.expt.b.b.class
                com.tencent.mm.kernel.c.a r0 = com.tencent.mm.kernel.g.af(r0)
                com.tencent.mm.plugin.expt.b.b r0 = (com.tencent.mm.plugin.expt.b.b) r0
                com.tencent.mm.plugin.expt.b.b$a r3 = com.tencent.mm.plugin.expt.b.b.a.clicfg_open_biz_time_line_canvas_download_pkg_v2
                int r0 = r0.a(r3, r2)
                if (r0 != r1) goto L_0x0043
                r0 = r1
            L_0x0027:
                java.lang.String r3 = "MicroMsg.WebCanvasStorageLogic"
                java.lang.String r4 = "pkgDownloadOpen "
                java.lang.String r5 = java.lang.String.valueOf(r0)
                java.lang.String r4 = r4.concat(r5)
                com.tencent.mm.sdk.platformtools.Log.i(r3, r4)
                if (r0 == 0) goto L_0x003b
            L_0x003a:
                r2 = r1
            L_0x003b:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return r0
            L_0x0043:
                r0 = r2
                goto L_0x0027
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webcanvas.m.f.invoke():java.lang.Object");
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends q implements kotlin.g.a.a<Long> {
        public static final k IAO = new k();

        static {
            AppMethodBeat.i(224719);
            AppMethodBeat.o(224719);
        }

        k() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Long invoke() {
            AppMethodBeat.i(224718);
            long a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_trigger_download_pkg_on_get_data_interval, Util.MILLSECONDS_OF_DAY);
            Log.i("MicroMsg.WebCanvasStorageLogic", "download pkg on get data interval ".concat(String.valueOf(a2)));
            Long valueOf = Long.valueOf(a2);
            AppMethodBeat.o(224718);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class l extends q implements kotlin.g.a.a<Long> {
        public static final l IAP = new l();

        static {
            AppMethodBeat.i(224721);
            AppMethodBeat.o(224721);
        }

        l() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Long invoke() {
            AppMethodBeat.i(224720);
            long a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_trigger_download_prefetch_pkg_interval, Util.MILLSECONDS_OF_DAY);
            Log.i("MicroMsg.WebCanvasStorageLogic", "download prefetch pkg on interval ".concat(String.valueOf(a2)));
            Long valueOf = Long.valueOf(a2);
            AppMethodBeat.o(224720);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends q implements kotlin.g.a.a<Long> {
        public static final j IAN = new j();

        static {
            AppMethodBeat.i(224717);
            AppMethodBeat.o(224717);
        }

        j() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Long invoke() {
            AppMethodBeat.i(224716);
            long a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_trigger_download_pkg_interval, Util.MILLSECONDS_OF_HOUR);
            Log.i("MicroMsg.WebCanvasStorageLogic", "download pkg interval ".concat(String.valueOf(a2)));
            Long valueOf = Long.valueOf(a2);
            AppMethodBeat.o(224716);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class o extends q implements kotlin.g.a.a<Long> {
        public static final o VgD = new o();

        static {
            AppMethodBeat.i(263533);
            AppMethodBeat.o(263533);
        }

        o() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Long invoke() {
            AppMethodBeat.i(263532);
            long a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_web_prefetch_download_pkg_interval, Util.MILLSECONDS_OF_HOUR);
            Log.i("MicroMsg.WebCanvasStorageLogic", "download prefetch pkg on interval ".concat(String.valueOf(a2)));
            Long valueOf = Long.valueOf(a2);
            AppMethodBeat.o(263532);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "errCode", "", "errMsg", "", "invoke"})
    public static final class n implements u.a {
        final /* synthetic */ String kPQ;

        n(String str) {
            this.kPQ = str;
        }

        @Override // com.tencent.mm.plugin.appbrand.service.u.a
        public final /* synthetic */ void onError(int i2, String str) {
            AppMethodBeat.i(224723);
            Log.e("MicroMsg.WebCanvasStorageLogic", "triggerPreDownload(appId:" + this.kPQ + "), onError(errCode:" + i2 + ", errMsg:" + str + ')');
            AppMethodBeat.o(224723);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "errCode", "", "errMsg", "", "invoke"})
    public static final class b implements u.a {
        final /* synthetic */ String kPQ;

        b(String str) {
            this.kPQ = str;
        }

        @Override // com.tencent.mm.plugin.appbrand.service.u.a
        public final /* synthetic */ void onError(int i2, String str) {
            AppMethodBeat.i(224699);
            Log.e("MicroMsg.WebCanvasStorageLogic", "checkPreviewVersion(appId:" + this.kPQ + "), onError(errCode:" + i2 + ", errMsg:" + str + ')');
            AppMethodBeat.o(224699);
        }
    }
}
