package com.tencent.liteapp;

import android.content.Context;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.liteapp.c.c;
import com.tencent.liteapp.c.d;
import com.tencent.liteapp.c.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.appbrand.jsapi.storage.f;
import com.tencent.mm.plugin.appbrand.jsapi.storage.n;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import com.tencent.wxa.c.a;
import java.util.Arrays;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/liteapp/WxaLiteApp;", "", "()V", "Companion", "Config", "wxa_lite_app_release"})
public final class a {
    private static final String TAG = TAG;
    public static Context appContext;
    public static b cqI;
    public static final C0147a cqJ = new C0147a((byte) 0);
    public static String packageName;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0004J\u0006\u0010#\u001a\u00020\u0018J\u0010\u0010$\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\"\u001a\u00020\u0004J\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010&J\u000e\u0010'\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000eJ \u0010(\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0004J\u0018\u0010(\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010+\u001a\u0004\u0018\u00010\u0004J(\u0010,\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020-J \u0010,\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020-J\u000e\u0010.\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u001cR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\u0016¨\u0006/"}, hxF = {"Lcom/tencent/liteapp/WxaLiteApp$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "config", "Lcom/tencent/liteapp/WxaLiteApp$Config;", "getConfig", "()Lcom/tencent/liteapp/WxaLiteApp$Config;", "setConfig", "(Lcom/tencent/liteapp/WxaLiteApp$Config;)V", AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, "getPackageName", "setPackageName", "(Ljava/lang/String;)V", "checkInit", "", "checkLiteApp", "Lcom/tencent/liteapp/mgr/UpdateStatus;", "app", "Lcom/tencent/liteapp/storage/WxaLiteAppInfo;", "checkLiteAppAsync", "callback", "Lcom/tencent/liteapp/mgr/IWxaLiteAppUpdaterCallback;", "deleteLiteApp", "", "appId", "fetchAll", "getLiteAppInfo", "getLiteAppList", "", "setup", "startLiteApp", "Lcom/tencent/liteapp/mgr/LauncherStatus;", "pagePath", SearchIntents.EXTRA_QUERY, "startLiteAppAsync", "Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncherCallback;", "updateLiteApp", "wxa_lite_app_release"})
    /* renamed from: com.tencent.liteapp.a$a  reason: collision with other inner class name */
    public static final class C0147a {
        private C0147a() {
        }

        public /* synthetic */ C0147a(byte b2) {
            this();
        }

        public static b KA() {
            AppMethodBeat.i(197909);
            b bVar = a.cqI;
            if (bVar == null) {
                p.btv("config");
            }
            AppMethodBeat.o(197909);
            return bVar;
        }

        public static Context getAppContext() {
            AppMethodBeat.i(197910);
            Context context = a.appContext;
            if (context == null) {
                p.btv("appContext");
            }
            AppMethodBeat.o(197910);
            return context;
        }
    }

    static {
        AppMethodBeat.i(197918);
        AppMethodBeat.o(197918);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001bJ\b\u0010<\u001a\u00020:H\u0002J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\tJ\u000e\u0010>\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001bJ\u000e\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020AJ\u000e\u00101\u001a\u00020\u00002\u0006\u0010B\u001a\u00020.J\u000e\u00107\u001a\u00020\u00002\u0006\u0010C\u001a\u000204J\u0006\u0010D\u001a\u00020:R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR*\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001b0!j\b\u0012\u0004\u0012\u00020\u001b`\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006E"}, hxF = {"Lcom/tencent/liteapp/WxaLiteApp$Config;", "", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dartEntryPoint", "", "(Landroid/content/Context;Ljava/lang/String;)V", "downloader", "Lcom/tencent/liteapp/mgr/IWxaLiteAppDownloader;", "getDownloader", "()Lcom/tencent/liteapp/mgr/IWxaLiteAppDownloader;", "setDownloader", "(Lcom/tencent/liteapp/mgr/IWxaLiteAppDownloader;)V", "launcher", "Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncher;", "getLauncher", "()Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncher;", "setLauncher", "(Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncher;)V", "mAppContext", "getMAppContext", "()Landroid/content/Context;", "mDartEntryPoint", "getMDartEntryPoint", "()Ljava/lang/String;", "plugin", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "getPlugin", "()Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "setPlugin", "(Lio/flutter/embedding/engine/plugins/FlutterPlugin;)V", "plugins", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getPlugins", "()Ljava/util/HashSet;", "setPlugins", "(Ljava/util/HashSet;)V", "router", "Lcom/tencent/wxa/WxaRouter;", "getRouter", "()Lcom/tencent/wxa/WxaRouter;", "setRouter", "(Lcom/tencent/wxa/WxaRouter;)V", "storage", "Lcom/tencent/liteapp/mgr/IWxaLiteAppStorage;", f.NAME, "()Lcom/tencent/liteapp/mgr/IWxaLiteAppStorage;", n.NAME, "(Lcom/tencent/liteapp/mgr/IWxaLiteAppStorage;)V", "updater", "Lcom/tencent/liteapp/mgr/IWxaLiteAppUpdater;", "getUpdater", "()Lcom/tencent/liteapp/mgr/IWxaLiteAppUpdater;", "setUpdater", "(Lcom/tencent/liteapp/mgr/IWxaLiteAppUpdater;)V", "addFlutterPlugin", "", "p", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "loader", "setFlutterPlugin", "setLogImp", "log", "Lcom/tencent/liteapp/log/IWxaLiteAppLog;", "s", "u", "setup", "wxa_lite_app_release"})
    public static final class b {
        public final String cqK;
        private com.tencent.liteapp.c.a cqL = new d();
        private com.tencent.liteapp.c.b cqM = new e();
        private c cqN = new com.tencent.liteapp.c.f();
        public com.tencent.wxa.c cqO;
        HashSet<io.flutter.embedding.engine.plugins.a> cqP;
        public final Context mAppContext;

        public b(Context context, String str) {
            p.h(context, "appContext");
            p.h(str, "dartEntryPoint");
            AppMethodBeat.i(197917);
            com.tencent.wxa.c hrH = com.tencent.wxa.c.hrH();
            p.g(hrH, "WxaRouter.getInstance()");
            this.cqO = hrH;
            this.cqP = new HashSet<>();
            this.mAppContext = context;
            this.cqK = str;
            AppMethodBeat.o(197917);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/liteapp/WxaLiteApp$Config$init$routerConfig$1", "Lcom/tencent/wxa/WxaPluginRegistryCallback;", "registerPlugins", "", "mEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "wxa_lite_app_release"})
        /* renamed from: com.tencent.liteapp.a$b$a  reason: collision with other inner class name */
        public static final class C0149a implements com.tencent.wxa.b {
            final /* synthetic */ b cqQ;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            public C0149a(b bVar) {
                this.cqQ = bVar;
            }

            @Override // com.tencent.wxa.b
            public final void a(io.flutter.embedding.engine.a aVar) {
                AppMethodBeat.i(197911);
                if (!(aVar == null || this.cqQ.cqP == null)) {
                    io.flutter.embedding.engine.plugins.b hwF = aVar.hwF();
                    HashSet<io.flutter.embedding.engine.plugins.a> hashSet = this.cqQ.cqP;
                    if (hashSet == null) {
                        p.hyc();
                    }
                    hwF.A(hashSet);
                }
                AppMethodBeat.o(197911);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ7\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ7\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ7\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ7\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000f"}, hxF = {"com/tencent/liteapp/WxaLiteApp$Config$init$routerConfig$2", "Lcom/tencent/wxa/log/WxaRouterLog$LogImp;", "d", "", "TAG", "", "format", "objects", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "i", "v", "w", "wxa_lite_app_release"})
        /* renamed from: com.tencent.liteapp.a$b$b  reason: collision with other inner class name */
        public static final class C0150b implements a.AbstractC2228a {
            @Override // com.tencent.wxa.c.a.AbstractC2228a
            public final void i(String str, String str2, Object... objArr) {
                boolean z = true;
                AppMethodBeat.i(197912);
                p.h(str2, "format");
                p.h(objArr, "objects");
                if (!(objArr.length == 0)) {
                    z = false;
                }
                if (!z) {
                    com.tencent.liteapp.b.b.i(str, String.format(str2, Arrays.copyOf(objArr, objArr.length)), new Object[0]);
                    AppMethodBeat.o(197912);
                    return;
                }
                com.tencent.liteapp.b.b.i(str, str2, new Object[0]);
                AppMethodBeat.o(197912);
            }

            @Override // com.tencent.wxa.c.a.AbstractC2228a
            public final void w(String str, String str2, Object... objArr) {
                boolean z = true;
                AppMethodBeat.i(197913);
                p.h(str2, "format");
                p.h(objArr, "objects");
                if (!(objArr.length == 0)) {
                    z = false;
                }
                if (!z) {
                    com.tencent.liteapp.b.b.w(str, String.format(str2, Arrays.copyOf(objArr, objArr.length)), new Object[0]);
                    AppMethodBeat.o(197913);
                    return;
                }
                com.tencent.liteapp.b.b.w(str, str2, new Object[0]);
                AppMethodBeat.o(197913);
            }

            @Override // com.tencent.wxa.c.a.AbstractC2228a
            public final void v(String str, String str2, Object... objArr) {
                boolean z = true;
                AppMethodBeat.i(197914);
                p.h(str2, "format");
                p.h(objArr, "objects");
                if (!(objArr.length == 0)) {
                    z = false;
                }
                if (!z) {
                    com.tencent.liteapp.b.b.v(str, String.format(str2, Arrays.copyOf(objArr, objArr.length)), new Object[0]);
                    AppMethodBeat.o(197914);
                    return;
                }
                com.tencent.liteapp.b.b.v(str, str2, new Object[0]);
                AppMethodBeat.o(197914);
            }

            @Override // com.tencent.wxa.c.a.AbstractC2228a
            public final void e(String str, String str2, Object... objArr) {
                boolean z = true;
                AppMethodBeat.i(197915);
                p.h(str2, "format");
                p.h(objArr, "objects");
                if (!(objArr.length == 0)) {
                    z = false;
                }
                if (!z) {
                    com.tencent.liteapp.b.b.e(str, String.format(str2, Arrays.copyOf(objArr, objArr.length)), new Object[0]);
                    AppMethodBeat.o(197915);
                    return;
                }
                com.tencent.liteapp.b.b.e(str, str2, new Object[0]);
                AppMethodBeat.o(197915);
            }

            @Override // com.tencent.wxa.c.a.AbstractC2228a
            public final void d(String str, String str2, Object... objArr) {
                boolean z = true;
                AppMethodBeat.i(197916);
                p.h(str2, "format");
                p.h(objArr, "objects");
                if (!(objArr.length == 0)) {
                    z = false;
                }
                if (!z) {
                    com.tencent.liteapp.b.b.d(str, String.format(str2, Arrays.copyOf(objArr, objArr.length)), new Object[0]);
                    AppMethodBeat.o(197916);
                    return;
                }
                com.tencent.liteapp.b.b.d(str, str2, new Object[0]);
                AppMethodBeat.o(197916);
            }
        }
    }
}
