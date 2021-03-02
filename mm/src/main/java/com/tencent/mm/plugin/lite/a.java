package com.tencent.mm.plugin.lite;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.liteapp.a;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.plugin.lite.b.h;
import com.tencent.mm.plugin.lite.jsapi.a.b;
import com.tencent.mm.plugin.lite.jsapi.a.c;
import com.tencent.mm.plugin.lite.jsapi.a.e;
import com.tencent.mm.plugin.lite.jsapi.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.wxa.c;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/lite/LiteAppProcessProfileInit;", "", "()V", "Companion", "luggage-lite-app_release"})
public final class a {
    private static String TAG = "MicroMsg.LiteAppProcessProfileInit";
    private static boolean isInit;
    private static Map<String, String> yDO = new HashMap();
    public static final C1457a yDP = new C1457a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0004J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u000bH\u0002J\u0006\u0010\"\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/lite/LiteAppProcessProfileInit$Companion;", "", "()V", "CALL_FROM_APP_UI", "", "CALL_FROM_APP_UI_HAD_INIT", "CALL_FROM_PROFILE_EXEC", "CALL_FROM_PROFILE_EXEC_HAD_INIT", "CALL_FROM_PROXY_UI", "CALL_FROM_PROXY_UI_HAD_INIT", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "isInit", "", "()Z", "setInit", "(Z)V", "qrUrlQueryMap", "", "getQrUrlQueryMap", "()Ljava/util/Map;", "setQrUrlQueryMap", "(Ljava/util/Map;)V", "copyLibs", "", "dstLibPath", "doInit", "callFrom", "preloadEngine", "readMetaFromAssets", "setBaseLibPath", "luggage-lite-app_release"})
    /* renamed from: com.tencent.mm.plugin.lite.a$a  reason: collision with other inner class name */
    public static final class C1457a {
        private C1457a() {
        }

        public /* synthetic */ C1457a(byte b2) {
            this();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ7\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ7\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ7\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ7\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/lite/LiteAppProcessProfileInit$Companion$preloadEngine$1", "Lcom/tencent/liteapp/log/IWxaLiteAppLog;", "d", "", "TAG", "", "format", "objects", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "i", "v", "w", "luggage-lite-app_release"})
        /* renamed from: com.tencent.mm.plugin.lite.a$a$a  reason: collision with other inner class name */
        public static final class C1458a implements com.tencent.liteapp.b.a {
            C1458a() {
            }

            @Override // com.tencent.liteapp.b.a
            public final void i(String str, String str2, Object... objArr) {
                boolean z = true;
                AppMethodBeat.i(198953);
                p.h(str2, "format");
                p.h(objArr, "objects");
                if (!(objArr.length == 0)) {
                    z = false;
                }
                if (!z) {
                    Log.i(str, String.format(str2, Arrays.copyOf(objArr, objArr.length)));
                    AppMethodBeat.o(198953);
                    return;
                }
                Log.i(str, str2);
                AppMethodBeat.o(198953);
            }

            @Override // com.tencent.liteapp.b.a
            public final void w(String str, String str2, Object... objArr) {
                boolean z = true;
                AppMethodBeat.i(198954);
                p.h(str2, "format");
                p.h(objArr, "objects");
                if (!(objArr.length == 0)) {
                    z = false;
                }
                if (!z) {
                    Log.w(str, String.format(str2, Arrays.copyOf(objArr, objArr.length)));
                    AppMethodBeat.o(198954);
                    return;
                }
                Log.w(str, str2);
                AppMethodBeat.o(198954);
            }

            @Override // com.tencent.liteapp.b.a
            public final void v(String str, String str2, Object... objArr) {
                boolean z = true;
                AppMethodBeat.i(198955);
                p.h(str2, "format");
                p.h(objArr, "objects");
                if (!(objArr.length == 0)) {
                    z = false;
                }
                if (!z) {
                    Log.v(str, String.format(str2, Arrays.copyOf(objArr, objArr.length)));
                    AppMethodBeat.o(198955);
                    return;
                }
                Log.v(str, str2);
                AppMethodBeat.o(198955);
            }

            @Override // com.tencent.liteapp.b.a
            public final void e(String str, String str2, Object... objArr) {
                boolean z = true;
                AppMethodBeat.i(198956);
                p.h(str2, "format");
                p.h(objArr, "objects");
                if (!(objArr.length == 0)) {
                    z = false;
                }
                if (!z) {
                    Log.e(str, String.format(str2, Arrays.copyOf(objArr, objArr.length)));
                    AppMethodBeat.o(198956);
                    return;
                }
                Log.e(str, str2);
                AppMethodBeat.o(198956);
            }

            @Override // com.tencent.liteapp.b.a
            public final void d(String str, String str2, Object... objArr) {
                boolean z = true;
                AppMethodBeat.i(198957);
                p.h(str2, "format");
                p.h(objArr, "objects");
                if (!(objArr.length == 0)) {
                    z = false;
                }
                if (!z) {
                    Log.d(str, String.format(str2, Arrays.copyOf(objArr, objArr.length)));
                    AppMethodBeat.o(198957);
                    return;
                }
                Log.d(str, str2);
                AppMethodBeat.o(198957);
            }
        }

        public static void ecv() {
            String str;
            String str2 = null;
            AppMethodBeat.i(198959);
            f.ecC();
            WxaLiteAppInfo aCT = f.aCT(LiteAppCenter.LITE_APP_BASE_LIB);
            String str3 = aCT != null ? aCT.cri : null;
            if (aCT != null) {
                str2 = aCT.md5;
            }
            String aw = h.aw(LiteAppCenter.LITE_APP_BASE_LIB, str3, str2);
            o oVar = new o(aw);
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            String baseLibVersionByPath = LiteAppCenter.getBaseLibVersionByPath(s.k(aw, false));
            String baseLibVersionByString = LiteAppCenter.getBaseLibVersionByString(ecw());
            Log.i(a.TAG, "base lib localVersion:" + baseLibVersionByPath + ", assetsVersion:" + baseLibVersionByString);
            if (LiteAppCenter.versionGreater(baseLibVersionByString, baseLibVersionByPath)) {
                Log.i(a.TAG, "copy base lib " + baseLibVersionByString + " to " + aw);
                p.g(aw, "pkgPath");
                aCQ(aw);
                str = LiteAppCenter.getBaseLibVersionByPath(aw);
            } else {
                str = baseLibVersionByPath;
            }
            if (aCT != null) {
                String baseLibVersionByPath2 = LiteAppCenter.getBaseLibVersionByPath(aCT.path);
                String str4 = aCT.path;
                if (!LiteAppCenter.versionGreater(str, baseLibVersionByPath2)) {
                    aw = str4;
                }
                Log.i(a.TAG, "preload base lib localVersion:" + str + ", dbVersion:" + baseLibVersionByPath2 + ", path:" + aw);
                c.setPath(s.k(aw, false));
                AppMethodBeat.o(198959);
                return;
            }
            Log.i(a.TAG, "preload base lib use local, path:".concat(String.valueOf(aw)));
            c.setPath(s.k(aw, false));
            AppMethodBeat.o(198959);
        }

        private static String ecw() {
            AppMethodBeat.i(198961);
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            InputStream open = context.getAssets().open("meta.json");
            p.g(open, "MMApplicationContext.get…().assets.open(kMetaFile)");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            String str = new String(bArr, d.UTF_8);
            open.close();
            AppMethodBeat.o(198961);
            return str;
        }

        private static void aCQ(String str) {
            AppMethodBeat.i(198962);
            String[] strArr = {"flutter-view.runtime.js", "meta.json"};
            for (int i2 = 0; i2 < 2; i2++) {
                try {
                    String str2 = strArr[i2];
                    o oVar = new o(str + '/' + str2);
                    if (oVar.exists()) {
                        oVar.delete();
                    }
                    Context context = MMApplicationContext.getContext();
                    p.g(context, "MMApplicationContext.getContext()");
                    InputStream open = context.getAssets().open(str2);
                    p.g(open, "MMApplicationContext.get…t().assets.open(fileName)");
                    OutputStream ap = s.ap(oVar);
                    p.g(ap, "VFSFileOp.openWrite(dstLibFile)");
                    byte[] bArr = new byte[1024];
                    z.d dVar = new z.d();
                    while (true) {
                        int read = open.read(bArr);
                        dVar.SYE = read;
                        if (read == -1) {
                            break;
                        }
                        ap.write(bArr, 0, dVar.SYE);
                    }
                    open.close();
                    ap.close();
                } catch (Exception e2) {
                    Log.printErrStackTrace(a.TAG, e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(198962);
        }

        public final boolean Pv(int i2) {
            AppMethodBeat.i(198958);
            Log.i(a.TAG, "doInit");
            f.ecC();
            if (!f.ecx()) {
                Log.i(a.TAG, "isLiteAppEnable = false");
                AppMethodBeat.o(198958);
                return false;
            } else if (!a.isInit) {
                j.load("wechatxlog");
                j.load(Mars.libMarsMM);
                j.load("andromeda");
                j.load("wechatlv");
                j.load("flutter");
                Log.i(a.TAG, "preloadEngine");
                c.addJsApi("triggerTestEvent", g.class);
                c.addJsApi("login", b.class);
                c.addJsApi("session", com.tencent.mm.plugin.lite.jsapi.a.d.class);
                c.addJsApi("startWebView", com.tencent.mm.plugin.lite.jsapi.a.f.class);
                c.addJsApi("openUserProfile", com.tencent.mm.plugin.lite.jsapi.b.b.class);
                c.addJsApi("doGoToRecVideoList", com.tencent.mm.plugin.lite.jsapi.b.a.class);
                c.addJsApi(com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f.NAME, com.tencent.mm.plugin.lite.jsapi.a.a.class);
                c.addJsApi("sendAppMessage", c.class);
                c.addJsApi(com.tencent.mm.plugin.appbrand.jsapi.share.l.NAME, e.class);
                com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.luggage.a.a.class);
                p.g(af, "MMKernel.service(ILuggageGameService::class.java)");
                c.addJsApi(((com.tencent.mm.plugin.game.luggage.a.a) af).dTm());
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                a.b bVar = new a.b(context, "liteApp");
                C1458a aVar = new C1458a();
                p.h(aVar, "log");
                com.tencent.liteapp.b.b.a(aVar);
                a.C0147a aVar2 = com.tencent.liteapp.a.cqJ;
                p.h(bVar, "config");
                p.h(bVar, "<set-?>");
                com.tencent.liteapp.a.cqI = bVar;
                Context context2 = a.C0147a.KA().mAppContext;
                p.h(context2, "<set-?>");
                com.tencent.liteapp.a.appContext = context2;
                String packageName = a.C0147a.KA().mAppContext.getPackageName();
                p.g(packageName, "this.config.mAppContext.packageName");
                p.h(packageName, "<set-?>");
                com.tencent.liteapp.a.packageName = packageName;
                LiteAppCenter.updateDisplayParam(a.C0147a.getAppContext());
                a.b KA = a.C0147a.KA();
                KA.cqO.a(new c.a(KA.mAppContext).a(new com.tencent.liteapp.a.a()).a(new com.tencent.wxa.a.c()).brB(KA.cqK).a(new a.b.C0149a(KA)).a(new a.b.C0150b()).hrK());
                KA.cqO.init();
                Log.d(a.TAG, "start init lvcpp");
                boolean isDarkMode = ao.isDarkMode();
                c.init();
                c.updateDarkMode(isDarkMode);
                Context context3 = MMApplicationContext.getContext();
                Point az = ao.az(context3);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Object systemService = context3.getSystemService("window");
                if (systemService == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.WindowManager");
                    AppMethodBeat.o(198958);
                    throw tVar;
                }
                ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
                int ay = au.ay(context3);
                int aD = au.aD(context3);
                int i3 = displayMetrics.densityDpi;
                int i4 = az.x;
                int i5 = az.y;
                float f2 = displayMetrics.density;
                float f3 = 48.0f * f2;
                Log.i(a.TAG, "SetDisplayParams w=%d h=%d screen=%d,%d, density=%f dpi=%d, statusBar=%d actionBarHeight:%f, navigationBarHeight:%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(az.x), Integer.valueOf(az.y), Float.valueOf(f2), Integer.valueOf(i3), Integer.valueOf(ay), Float.valueOf(f3), Integer.valueOf(aD));
                c.setDisplayParams(((float) i4) / f2, ((float) i5) / f2, ((float) az.x) / f2, ((float) az.y) / f2, i3, f2, f3 / f2, ((float) ay) / f2, ((float) aD) / f2);
                ecv();
                Log.i(a.TAG, "end init lvcpp");
                a.isInit = true;
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1404, i2);
                AppMethodBeat.o(198958);
                return false;
            } else {
                switch (i2) {
                    case 0:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1404, 1);
                        break;
                    case 2:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1404, 3);
                        break;
                }
                AppMethodBeat.o(198958);
                return true;
            }
        }
    }

    static {
        AppMethodBeat.i(198963);
        AppMethodBeat.o(198963);
    }
}
