package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.app.o;
import com.tencent.mm.co.i;
import com.tencent.mm.g.a.abg;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as;
import com.tencent.mm.model.at;
import com.tencent.mm.model.y;
import com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.bp;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appcache.predownload.PreDownloadServiceExportAnyProcess;
import com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC;
import com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgStorageExportServiceIPC;
import com.tencent.mm.plugin.appbrand.appstorage.aa;
import com.tencent.mm.plugin.appbrand.appusage.ae;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ao;
import com.tencent.mm.plugin.appbrand.appusage.e;
import com.tencent.mm.plugin.appbrand.appusage.j;
import com.tencent.mm.plugin.appbrand.appusage.p;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataTokenStorageIPC;
import com.tencent.mm.plugin.appbrand.backgroundfetch.l;
import com.tencent.mm.plugin.appbrand.bg;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.debugger.k;
import com.tencent.mm.plugin.appbrand.jsapi.share.aa;
import com.tencent.mm.plugin.appbrand.keylogger.KeyStepBaseActivity;
import com.tencent.mm.plugin.appbrand.launching.bf;
import com.tencent.mm.plugin.appbrand.m.ac;
import com.tencent.mm.plugin.appbrand.menu.m;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.service.v;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.x;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.task.preload.AppBrandBatchPreloadController;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.plugin.appbrand.utils.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.DeprecatedThreadFactory;
import com.tencent.mm.ui.ap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Keep
public final class PluginAppBrand extends f implements b, c, at, com.tencent.mm.plugin.appbrand.api.c {
    private static final String[] PRELOAD_SO_NAME = {"gamelog_delegate", "mmv8", "mmnode", "mmj2v8", "mmskia", "canvas", "skia-canvas", "skia-canvas-log-bridge", "mmudp", "owl", "wcwss", "mmwcwss", "native-iv", "wechatsight_v7a"};
    public static final String TAG = "MicroMsg.PluginAppBrand[speedtest]";
    private final h singletonRegistry = new h();

    public PluginAppBrand() {
        AppMethodBeat.i(44152);
        AppMethodBeat.o(44152);
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.i(44164);
        fixProcessSharedStringFormatLocale();
        AppMethodBeat.o(44164);
    }

    @Override // com.tencent.mm.model.at
    public final List<as> getDataTransferList() {
        AppMethodBeat.i(44153);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new as() {
            /* class com.tencent.mm.plugin.appbrand.config.k.AnonymousClass1 */

            @Override // com.tencent.mm.model.as
            public final void transfer(int i2) {
                AppMethodBeat.i(44844);
                if (!rT(i2)) {
                    AppMethodBeat.o(44844);
                    return;
                }
                try {
                    Log.d("MicroMsg.AppBrandNewContactFixVersionStateTransfer", "doFix()");
                    n buz = n.buz();
                    if (buz != null) {
                        r.a buA = buz.buA();
                        n.buC();
                        buA.execSQL("WxaAttributesTable", String.format(Locale.US, "update %s set %s='' where %s is null or %s=''", "WxaAttributesTable", "syncVersion", "versionInfo", "versionInfo"));
                        AppMethodBeat.o(44844);
                        return;
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandNewContactFixVersionStateTransfer", "doFix e = %s", e2);
                }
                AppMethodBeat.o(44844);
            }

            @Override // com.tencent.mm.model.as
            public final boolean rT(int i2) {
                return i2 >= 637863936 && i2 <= 637863988;
            }

            @Override // com.tencent.mm.model.as
            public final String getTag() {
                return "MicroMsg.AppBrandNewContactFixVersionStateTransfer";
            }
        });
        linkedList.add(new ae());
        linkedList.add(new e());
        linkedList.add(new s());
        linkedList.add(new ac());
        linkedList.add(new m.a());
        AppMethodBeat.o(44153);
        return linkedList;
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
    }

    /* access modifiers changed from: package-private */
    public static final class a extends y implements o, b {
        private com.tencent.mm.plugin.appbrand.jsapi.appdownload.a kIK;
        private k kIL = new k();
        private com.tencent.mm.plugin.teenmode.a.c kIM = new com.tencent.mm.plugin.teenmode.a.c() {
            /* class com.tencent.mm.plugin.appbrand.app.PluginAppBrand.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.teenmode.a.c
            public final void onDataChanged() {
                AppMethodBeat.i(226318);
                boolean Vt = ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
                int fvp = ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvp();
                Log.i(PluginAppBrand.TAG, "onTeenModeDataChanged isTeenMode: %b, miniProgramOption: %d", Boolean.valueOf(Vt), Integer.valueOf(fvp));
                if (Vt && fvp != 1) {
                    com.tencent.mm.plugin.appbrand.task.h.bWb().bVX();
                }
                AppMethodBeat.o(226318);
            }
        };

        static /* synthetic */ void b(String str, z zVar) {
            AppMethodBeat.i(226324);
            a(str, zVar);
            AppMethodBeat.o(226324);
        }

        private a() {
            super(n.class);
            AppMethodBeat.i(44144);
            AppMethodBeat.o(44144);
        }

        static void bus() {
            AppMethodBeat.i(226321);
            synchronized (a.class) {
                try {
                    if (g.af(a.class) == null) {
                        g.a(a.class, new com.tencent.mm.kernel.c.e(new a()));
                    }
                } finally {
                    AppMethodBeat.o(226321);
                }
            }
        }

        static n but() {
            n nVar;
            AppMethodBeat.i(226322);
            synchronized (a.class) {
                try {
                    nVar = (n) at(n.class);
                } finally {
                    AppMethodBeat.o(226322);
                }
            }
            return nVar;
        }

        @Override // com.tencent.mm.model.y, com.tencent.mm.kernel.api.c
        public final void onAccountInitialized(e.c cVar) {
            AppMethodBeat.i(44145);
            super.onAccountInitialized(cVar);
            Log.d(PluginAppBrand.TAG, "onAccountInitialized, WAKeyStepKvLogger.ENABLE=%b", Boolean.valueOf(com.tencent.mm.plugin.appbrand.report.quality.o.bVk()));
            com.tencent.mm.plugin.appbrand.appcache.at.a(ar.kLY);
            if (BuildInfo.IS_FLAVOR_RED) {
                com.tencent.mm.plugin.appbrand.appusage.e eVar = new com.tencent.mm.plugin.appbrand.appusage.e();
                if (eVar.rT(d.KyO)) {
                    eVar.transfer(d.KyO);
                }
                ac acVar = new ac();
                if (acVar.rT(d.KyO)) {
                    acVar.transfer(d.KyO);
                }
            }
            if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
                j.bxQ().bxR();
            }
            g.a(com.tencent.mm.plugin.appbrand.appusage.c.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.c()));
            s sVar = new s();
            if (sVar.rT(d.KyO)) {
                sVar.transfer(d.KyO);
            }
            com.tencent.mm.plugin.appbrand.appusage.r rVar = new com.tencent.mm.plugin.appbrand.appusage.r();
            if (rVar.rT(d.KyO)) {
                rVar.transfer(d.KyO);
            }
            com.tencent.mm.plugin.appbrand.dynamic.widget.b.initialize();
            ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.message.f());
            ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.message.e());
            g.a(com.tencent.mm.plugin.appbrand.api.b.class, new com.tencent.mm.kernel.c.e(com.tencent.mm.plugin.appbrand.appcache.y.INSTANCE));
            g.a(ah.class, new com.tencent.mm.kernel.c.e(new p()));
            g.a(ag.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.f()));
            g.a(com.tencent.mm.modelappbrand.b.a.class, new com.tencent.mm.kernel.c.e(u.bth()));
            g.a(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundrunning.h()));
            g.a(com.tencent.mm.plugin.appbrand.backgroundfetch.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundfetch.e()));
            g.a(l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundfetch.h()));
            g.a(w.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appcache.predownload.d()));
            g.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
            g.a(v.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appcache.predownload.export.c()));
            g.a(com.tencent.mm.plugin.appbrand.service.u.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appcache.predownload.export.b()));
            ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.predownload.f.INSTANCE);
            ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("subscribesysmsg", com.tencent.mm.plugin.appbrand.message.d.INSTANCE);
            ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("weapp_pushmsg", com.tencent.mm.plugin.appbrand.message.a.INSTANCE);
            ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("WeAppPushCommand", com.tencent.mm.plugin.appbrand.message.h.INSTANCE);
            ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("wxaapp_msgchannel", com.tencent.mm.plugin.appbrand.message.b.INSTANCE);
            this.kIK = new com.tencent.mm.plugin.appbrand.jsapi.appdownload.a();
            com.tencent.mm.plugin.downloader.model.f.cBv();
            com.tencent.mm.plugin.downloader.model.c.a(this.kIK);
            ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("DebugAppCodeUpdated", this.kIL);
            g.a(com.tencent.mm.plugin.appbrand.service.f.class, new com.tencent.mm.kernel.c.e(new AppBrandMixExportLogicService()));
            g.a(com.tencent.mm.plugin.appbrand.launching.b.a.a.class, new com.tencent.mm.kernel.c.e(com.tencent.mm.plugin.appbrand.launching.b.a.mXV));
            com.tencent.mm.blink.b.ake().arrange(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.app.PluginAppBrand.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(226319);
                    a.b("FirstScreenArrangement", z.ACCOUNT_INIT);
                    AppMethodBeat.o(226319);
                }
            });
            com.tencent.mm.plugin.appbrand.appcache.h.a(new h.a() {
                /* class com.tencent.mm.plugin.appbrand.app.PluginAppBrand.a.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.appbrand.appcache.h.a
                public final com.tencent.mm.co.f<c.a<byz>> a(com.tencent.mm.plugin.appbrand.appcache.h hVar) {
                    AppMethodBeat.i(226320);
                    com.tencent.mm.co.f<c.a<byz>> b2 = com.tencent.mm.plugin.appbrand.launching.v.b(hVar);
                    AppMethodBeat.o(226320);
                    return b2;
                }
            });
            com.tencent.mm.plugin.appbrand.widget.recent.c cVar2 = com.tencent.mm.plugin.appbrand.widget.recent.c.oBT;
            com.tencent.mm.plugin.appbrand.widget.recent.c.ccR();
            com.tencent.mm.plugin.appbrand.appcache.w.setup();
            ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).a(this.kIM);
            com.tencent.mm.plugin.appbrand.launching.f.a.init();
            aa.init();
            com.tencent.mm.plugin.appbrand.ui.u.install(g.aAe().azG().ca);
            AppMethodBeat.o(44145);
        }

        private static void a(String str, z zVar) {
            AppMethodBeat.i(226323);
            Log.i(PluginAppBrand.TAG, "AppBrandCompatCore tryPreloadNextTaskProcess (both waservice and wagame) reason[%s]", str);
            com.tencent.mm.plugin.appbrand.task.h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.WASERVICE, zVar);
            com.tencent.mm.plugin.appbrand.task.h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.WAGAME, zVar);
            AppMethodBeat.o(226323);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(44147);
            a("onAppForeground:".concat(String.valueOf(str)), z.APP_FOREGROUND);
            AppMethodBeat.o(44147);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(44148);
            com.tencent.mm.plugin.appbrand.ipc.a.a aVar = com.tencent.mm.plugin.appbrand.ipc.a.a.lxe;
            com.tencent.mm.plugin.appbrand.ipc.a.a.bDV();
            com.tencent.mm.plugin.appbrand.shortlink.d dVar = com.tencent.mm.plugin.appbrand.shortlink.d.nNQ;
            com.tencent.mm.plugin.appbrand.shortlink.d.bVz();
            AppMethodBeat.o(44148);
        }

        @Override // com.tencent.mm.kernel.a.b.b
        public final void parallelsDependency() {
            AppMethodBeat.i(44149);
            com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bI(g.ah(com.tencent.mm.plugin.fts.a.n.class));
            AppMethodBeat.o(44149);
        }

        @Override // com.tencent.mm.model.y, com.tencent.mm.kernel.api.c
        public final void onAccountRelease() {
            AppMethodBeat.i(44150);
            g.ag(ah.class);
            g.ag(ag.class);
            g.ag(com.tencent.mm.plugin.appbrand.widget.recent.l.class);
            g.ag(com.tencent.mm.plugin.appbrand.backgroundfetch.k.class);
            g.ag(com.tencent.mm.plugin.appbrand.service.f.class);
            g.ag(l.class);
            g.ag(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class);
            g.ag(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class);
            g.ag(IAppBrandBatchPreloadController.class);
            g.ag(com.tencent.mm.plugin.appbrand.appusage.c.class);
            super.onAccountRelease();
            ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDU("link_view_wxapp");
            ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_view_wxapp");
            ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.predownload.f.INSTANCE);
            ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("subscribesysmsg", com.tencent.mm.plugin.appbrand.message.d.INSTANCE);
            ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("weapp_pushmsg", com.tencent.mm.plugin.appbrand.message.a.INSTANCE);
            com.tencent.mm.plugin.downloader.model.f.cBv();
            com.tencent.mm.plugin.downloader.model.c.b(this.kIK);
            ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("DebugAppCodeUpdated", this.kIL);
            ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("wxaapp_msgchannel", com.tencent.mm.plugin.appbrand.message.b.INSTANCE);
            com.tencent.mm.plugin.appbrand.x.a.bUc();
            com.tencent.mm.plugin.appbrand.widget.recent.c cVar = com.tencent.mm.plugin.appbrand.widget.recent.c.oBT;
            com.tencent.mm.plugin.appbrand.widget.recent.c.release();
            com.tencent.mm.plugin.appbrand.shortlink.b bVar = com.tencent.mm.plugin.appbrand.shortlink.b.nNN;
            com.tencent.mm.plugin.appbrand.shortlink.b.clearAll();
            AppMethodBeat.o(44150);
        }
    }

    /* access modifiers changed from: package-private */
    public final n getCore() {
        AppMethodBeat.i(44154);
        n but = a.but();
        AppMethodBeat.o(44154);
        return but;
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void installed() {
        AppMethodBeat.i(44155);
        Log.i(TAG, "installed()");
        alias(com.tencent.mm.plugin.appbrand.api.c.class);
        if (!isAppBrandProcess()) {
            new IListener<abg>() {
                /* class com.tencent.mm.plugin.appbrand.app.PluginAppBrand.AnonymousClass1 */

                {
                    AppMethodBeat.i(160572);
                    this.__eventId = abg.class.getName().hashCode();
                    AppMethodBeat.o(160572);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(abg abg) {
                    AppMethodBeat.i(44134);
                    com.tencent.mm.modelappbrand.u.i(PluginAppBrand.TAG, "recv XWebViewInitCompleteEvent", new Object[0]);
                    if (abg.eiA.success) {
                        if (MMApplicationContext.isToolsProcess()) {
                            com.tencent.mm.plugin.appbrand.dynamic.h.e.dI(MMApplicationContext.getContext());
                        } else if (MMApplicationContext.isMMProcess()) {
                            ((com.tencent.mm.plugin.appbrand.service.j) g.af(com.tencent.mm.plugin.appbrand.service.j.class)).buu();
                        }
                    }
                    AppMethodBeat.o(44134);
                    return false;
                }
            }.alive();
        }
        AppMethodBeat.o(44155);
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void dependency() {
        AppMethodBeat.i(44156);
        Log.i(TAG, "dependency()");
        if (MMApplicationContext.isMainProcess()) {
            dependsOn(com.tencent.mm.plugin.comm.a.a.class);
        }
        AppMethodBeat.o(44156);
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public final void parallelsDependency() {
        AppMethodBeat.i(226325);
        a.bus();
        com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bI(g.af(a.class));
        AppMethodBeat.o(226325);
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(44157);
        Log.i(TAG, "configure()");
        com.tencent.mm.ipcinvoker.extension.c.a(com.tencent.mm.plugin.appbrand.ui.c.a.a.oga);
        if (isAppBrandProcess()) {
            fixProcessSharedStringFormatLocale();
            gVar.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.ac.a() {
                /* class com.tencent.mm.plugin.appbrand.app.PluginAppBrand.AnonymousClass6 */

                @Override // com.tencent.mm.plugin.appbrand.ac.a
                public final void onActivityCreated(Activity activity, Bundle bundle) {
                    AppMethodBeat.i(44135);
                    PluginAppBrand.access$100();
                    AppMethodBeat.o(44135);
                }

                @Override // com.tencent.mm.plugin.appbrand.ac.a
                public final void onActivityStarted(Activity activity) {
                    AppMethodBeat.i(44136);
                    PluginAppBrand.access$100();
                    AppMethodBeat.o(44136);
                }
            });
            gVar.ca.registerComponentCallbacks(new ComponentCallbacks() {
                /* class com.tencent.mm.plugin.appbrand.app.PluginAppBrand.AnonymousClass7 */

                public final void onConfigurationChanged(Configuration configuration) {
                    AppMethodBeat.i(44137);
                    PluginAppBrand.access$100();
                    AppMethodBeat.o(44137);
                }

                public final void onLowMemory() {
                }
            });
            CrashReportFactory.addCrashReportExtraMessageGetter(com.tencent.mm.plugin.appbrand.e.a.lhw);
        }
        if (!MMApplicationContext.isMMProcess() && i.RwW == null) {
            i.RwW = new com.tencent.mm.vending.h.h(com.tencent.mm.co.d.b(new MMHandler(DeprecatedThreadFactory.createHandlerThread("WeChat.WORKER").getLooper())), "WeChat.WORKER");
            com.tencent.mm.vending.h.g.a("WeChat.WORKER", i.RwW);
        }
        com.tencent.mm.vfs.y.b("MixAudio", "MixAudio", 259200000, 103);
        com.tencent.mm.vfs.y.b("ExoVideoCache", "videocache", 259200000, 103);
        AppMethodBeat.o(44157);
    }

    private static void fixProcessSharedStringFormatLocale() {
        AppMethodBeat.i(44158);
        if (Build.VERSION.SDK_INT >= 24) {
            Locale.setDefault(Locale.Category.FORMAT, Locale.ENGLISH);
        }
        AppMethodBeat.o(44158);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(final com.tencent.mm.kernel.b.g gVar) {
        boolean z;
        AppMethodBeat.i(44159);
        Log.i(TAG, "execute() current process name = %s, isMainThread %b", g.aAe().azG().mProcessName, Boolean.valueOf(MMHandlerThread.isMainThread()));
        if (com.tencent.mm.plugin.appbrand.report.a.a.bUC()) {
            com.tencent.mm.plugin.appbrand.keylogger.c.a(new com.tencent.mm.plugin.appbrand.keylogger.g());
            com.tencent.mm.plugin.appbrand.keylogger.c.bMP();
        }
        com.tencent.mm.plugin.appbrand.keylogger.d.a(KSProcessWeAppLaunch.NAME, com.tencent.mm.plugin.appbrand.report.quality.o.nMe);
        g.a(IBSPatchJNIService.class, new com.tencent.mm.kernel.c.e(new BSPatchJNIWrapper()));
        g.a(com.tencent.mm.plugin.appbrand.service.r.class, new com.tencent.mm.kernel.c.e(new bf()));
        g.b(com.tencent.mm.plugin.appbrand.d.c.class, com.tencent.mm.plugin.appbrand.d.b.lbA);
        if (gVar.aBb()) {
            g.a(com.tencent.mm.plugin.appbrand.service.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.xweb_ext.video.c()));
            bp.a.d(gVar);
        }
        if (!isAppBrandProcess()) {
            g.a(com.tencent.mm.modelappbrand.g.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.dynamic.a.c()));
        }
        if (gVar.aBb()) {
            g.a(com.tencent.mm.modelappbrand.i.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.dynamic.a.d()));
        }
        if (gVar.aBb()) {
            g.a(com.tencent.mm.plugin.appbrand.service.n.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.report.c()));
        }
        g.a(com.tencent.mm.plugin.appbrand.service.s.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.launching.c.g()));
        g.b(com.tencent.mm.plugin.appbrand.appstorage.a.a.class, gVar.aBb() ? aa.b.INSTANCE : aa.a.INSTANCE);
        g.b(com.tencent.mm.plugin.appbrand.service.i.class, com.tencent.mm.plugin.appbrand.openmaterial.b.nkM);
        g.a(com.tencent.mm.plugin.appbrand.service.l.class, new com.tencent.mm.kernel.c.e(new h()));
        if (isAppBrandProcess()) {
            com.tencent.mm.plugin.webview.d.a aVar = com.tencent.mm.plugin.webview.d.a.IQX;
            com.tencent.mm.plugin.webview.d.a.gaR();
            Log.i(TAG, "init DefaultJsApiPool");
            com.tencent.mm.plugin.appbrand.game.c.b.LW();
            preloadRuntimeSoAsync();
            com.tencent.luggage.game.b.c.LV().cuE = new com.tencent.mm.plugin.appbrand.game.d.a();
            com.tencent.mm.plugin.appbrand.ac.g.bZj();
            com.tencent.xweb.s.a(com.tencent.mm.plugin.appbrand.xweb_ext.e.oGK);
        }
        com.tencent.luggage.sdk.g.c.a("WeChatMultiProcessInitDelegateImpl", new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.app.PluginAppBrand.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(44138);
                o oVar = new o(gVar);
                if (com.tencent.luggage.bridge.a.a.csR != null) {
                    Log.e("Luggage.LuggageBoot", "do not setup more than once.");
                    AppMethodBeat.o(44138);
                    return;
                }
                com.tencent.luggage.bridge.a.a.csR = oVar;
                oVar.a(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0025: INVOKE  
                      (r0v0 'oVar' com.tencent.mm.plugin.appbrand.app.o)
                      (wrap: com.tencent.luggage.bridge.a.a$1 : 0x0022: CONSTRUCTOR  (r1v2 com.tencent.luggage.bridge.a.a$1) =  call: com.tencent.luggage.bridge.a.a.1.<init>():void type: CONSTRUCTOR)
                     type: INTERFACE call: com.tencent.luggage.bridge.a.a.b.a(com.tencent.luggage.bridge.a.a$c):void in method: com.tencent.mm.plugin.appbrand.app.PluginAppBrand.8.run():void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0022: CONSTRUCTOR  (r1v2 com.tencent.luggage.bridge.a.a$1) =  call: com.tencent.luggage.bridge.a.a.1.<init>():void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.app.PluginAppBrand.8.run():void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 18 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.luggage.bridge.a.a, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 24 more
                    */
                /*
                    this = this;
                    r2 = 44138(0xac6a, float:6.185E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                    com.tencent.mm.plugin.appbrand.app.o r0 = new com.tencent.mm.plugin.appbrand.app.o
                    com.tencent.mm.kernel.b.g r1 = r14
                    r0.<init>(r1)
                    com.tencent.luggage.bridge.a.a$b r1 = com.tencent.luggage.bridge.a.a.csR
                    if (r1 == 0) goto L_0x001e
                    java.lang.String r0 = "Luggage.LuggageBoot"
                    java.lang.String r1 = "do not setup more than once."
                    com.tencent.mm.sdk.platformtools.Log.e(r0, r1)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                L_0x001d:
                    return
                L_0x001e:
                    com.tencent.luggage.bridge.a.a.csR = r0
                    com.tencent.luggage.bridge.a.a$1 r1 = new com.tencent.luggage.bridge.a.a$1
                    r1.<init>()
                    r0.a(r1)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                    goto L_0x001d
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.app.PluginAppBrand.AnonymousClass8.run():void");
            }
        });
        if (gVar.aBb()) {
            com.tencent.mm.plugin.appbrand.m.w.bMH();
            gVar.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.ac.a() {
                /* class com.tencent.mm.plugin.appbrand.app.PluginAppBrand.AnonymousClass9 */

                @Override // com.tencent.mm.plugin.appbrand.ac.a
                public final void onActivityCreated(Activity activity, Bundle bundle) {
                    AppMethodBeat.i(226313);
                    if ((activity instanceof KeyStepBaseActivity) && !com.tencent.mm.plugin.appbrand.report.a.a.bUC()) {
                        activity.finish();
                    }
                    AppMethodBeat.o(226313);
                }
            });
            com.tencent.mm.msgsubscription.api.b bVar = com.tencent.mm.msgsubscription.api.b.jza;
            com.tencent.mm.msgsubscription.api.b.a("name_wxa", new com.tencent.mm.msgsubscription.b.a(com.tencent.mm.msgsubscription.d.c.jAF) {
                /* class com.tencent.mm.plugin.appbrand.app.PluginAppBrand.AnonymousClass10 */

                @Override // com.tencent.mm.msgsubscription.b.a
                public final void a(Context context, int i2, String str, String str2) {
                    AppMethodBeat.i(226314);
                    Log.i(PluginAppBrand.TAG, "goToSettingManagerUI bizUsername: %s, nickname: %s", str, str2);
                    Intent intent = new Intent(context, BizSubscribeMsgManagerUI.class);
                    intent.putExtra("key_biz_username", str);
                    intent.putExtra("key_biz_nickname", str2);
                    intent.putExtra("key_biz_presenter_class", com.tencent.mm.msgsubscription.presenter.d.class.getName());
                    if (context instanceof Activity) {
                        ((Activity) context).startActivityForResult(intent, 100);
                        AppMethodBeat.o(226314);
                        return;
                    }
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/app/PluginAppBrand$6", "goToSettingManagerUI", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/app/PluginAppBrand$6", "goToSettingManagerUI", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(226314);
                }
            });
            g.aAi().a(new com.tencent.mm.kernel.api.g() {
                /* class com.tencent.mm.plugin.appbrand.app.PluginAppBrand.AnonymousClass11 */

                @Override // com.tencent.mm.kernel.api.g
                public final void WY() {
                    AppMethodBeat.i(44140);
                    com.tencent.mm.plugin.appbrand.ui.banner.d.bYb();
                    AppMethodBeat.o(44140);
                }

                @Override // com.tencent.mm.kernel.api.g
                public final void cQ(boolean z) {
                    AppMethodBeat.i(44141);
                    AppMethodBeat.o(44141);
                }
            });
            com.tencent.mm.plugin.x.c.INSTANCE.a(new com.tencent.mm.plugin.appbrand.bf());
            com.tencent.mm.plugin.x.c.INSTANCE.a(new bg());
            a.bus();
            g.a(com.tencent.mm.plugin.appbrand.widget.recent.l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.recent.h()));
            g.a(com.tencent.mm.modelappbrand.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.share.a.a()));
            g.a(com.tencent.mm.plugin.appbrand.ui.banner.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.ui.banner.a()));
            g.a(com.tencent.mm.plugin.appbrand.service.j.class, new com.tencent.mm.kernel.c.e(new l()));
            g.a(q.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.config.w()));
            g.a(t.class, new com.tencent.mm.kernel.c.e(new i()));
            g.a(com.tencent.mm.plugin.appbrand.api.e.class, new com.tencent.mm.kernel.c.e(new p()));
            g.a(com.tencent.mm.plugin.appbrand.widget.a.b.class, new com.tencent.mm.kernel.c.e(new q()));
            g.a(x.class, new com.tencent.mm.kernel.c.e(new ao()));
            g.a(com.tencent.mm.plugin.appbrand.service.p.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.game.d()));
            g.a(com.tencent.mm.modelappbrand.m.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.message.g()));
            g.a(com.tencent.mm.modelappbrand.l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.message.c()));
            g.a(com.tencent.mm.plugin.appbrand.service.m.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.utils.n()));
            g.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
            g.a(com.tencent.mm.plugin.appbrand.service.g.class, new com.tencent.mm.kernel.c.e(new d()));
            com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.b(), "//wagame", "//enable_appbrand_monkey_test", "//disable_appbrand_monkey_test", "//appbrand_monkey_bringtofront", "//appbrand_monkey_test_skip_appbrand_process_suicide", "//appbrand_predownload_trigger", "//callsearchshowoutwxaapp", "//getsearchshowoutwxaapp", "//appbrandtest", "//wxafts", "//wxatest", "//xweb_live", "//xweb_video_preload", "//xweb_video_ps", "//xweb_video_player", "//xweb_video_proxy", "//xweb_video_hls_proxy", "//xweb_hls_video_player", "//xweb_video", "//showad", "//allshowad", "//localwxalibrary");
            com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.dynamic.c.a(), "//widget");
            com.tencent.mm.plugin.appbrand.xweb_ext.b.LW();
            g.aAi().a(new com.tencent.mm.kernel.api.g() {
                /* class com.tencent.mm.plugin.appbrand.app.PluginAppBrand.AnonymousClass12 */

                @Override // com.tencent.mm.kernel.api.g
                public final void WY() {
                    AppMethodBeat.i(226315);
                    ((com.tencent.mm.modelappbrand.g) g.af(com.tencent.mm.modelappbrand.g.class)).initialize();
                    AppMethodBeat.o(226315);
                }

                @Override // com.tencent.mm.kernel.api.g
                public final void cQ(boolean z) {
                    AppMethodBeat.i(226316);
                    ((com.tencent.mm.modelappbrand.g) g.af(com.tencent.mm.modelappbrand.g.class)).shutdown();
                    ((com.tencent.mm.modelappbrand.g) g.af(com.tencent.mm.modelappbrand.g.class)).aXH().exit();
                    AppMethodBeat.o(226316);
                }
            });
            if (DebuggerShell.bAy()) {
                g.b(DebuggerShell.class, new DebuggerShell());
            }
            com.tencent.mm.plugin.appbrand.appcache.ae.a(new com.tencent.mm.plugin.appbrand.appcache.x());
            com.tencent.mm.plugin.appbrand.jsapi.video.b.init();
            com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().a(MMApplicationContext.getContext(), com.tencent.mm.plugin.appbrand.xweb_ext.video.b.cdM(), com.tencent.mm.plugin.appbrand.xweb_ext.video.b.cdO(), com.tencent.mm.plugin.appbrand.xweb_ext.video.a.cdL(), null);
            com.tencent.mm.pluginsdk.ui.span.l.Krg = new l.b() {
                /* class com.tencent.mm.plugin.appbrand.app.PluginAppBrand.AnonymousClass13 */

                @Override // com.tencent.mm.pluginsdk.ui.span.l.b
                public final boolean enable() {
                    AppMethodBeat.i(226317);
                    com.tencent.mm.plugin.appbrand.shortlink.d dVar = com.tencent.mm.plugin.appbrand.shortlink.d.nNQ;
                    boolean booleanValue = com.tencent.mm.plugin.appbrand.shortlink.d.bVA().invoke().booleanValue();
                    AppMethodBeat.o(226317);
                    return booleanValue;
                }
            };
        } else {
            if (isAppBrandProcess()) {
                com.tencent.mm.plugin.appbrand.debugger.b.setup();
                g.a(ah.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.o()));
                g.a(ag.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.g()));
                g.a(com.tencent.mm.plugin.appbrand.widget.recent.l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.recent.h()));
                g.a(com.tencent.mm.plugin.appbrand.backgroundfetch.k.class, new com.tencent.mm.kernel.c.e(new AppBrandBackgroundFetchDataStorageIPC()));
                g.a(com.tencent.mm.plugin.appbrand.backgroundfetch.l.class, new com.tencent.mm.kernel.c.e(new AppBrandBackgroundFetchDataTokenStorageIPC()));
                g.b(com.tencent.mm.plugin.flutter.a.a.class, new com.tencent.mm.plugin.flutter.b());
                g.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
                g.a(com.tencent.mm.plugin.appbrand.service.j.class, new com.tencent.mm.kernel.c.e(new m()));
                g.a(com.tencent.mm.plugin.appbrand.service.f.class, new com.tencent.mm.kernel.c.e(c.kIc));
                g.a(w.class, new com.tencent.mm.kernel.c.e(PreDownloadServiceExportAnyProcess.kOX));
                g.a(v.class, new com.tencent.mm.kernel.c.e(WxaPkgStorageExportServiceIPC.kQn));
                g.a(com.tencent.mm.plugin.appbrand.service.u.class, new com.tencent.mm.kernel.c.e(WxaPkgDownloaderExportServiceIPC.kQa));
                com.tencent.mm.plugin.appbrand.utils.h hVar = this.singletonRegistry;
                Application application = gVar.ca;
                Log.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.AppSingletonRegistry ");
                application.registerActivityLifecycleCallbacks(hVar);
                com.tencent.mm.plugin.appbrand.utils.h hVar2 = this.singletonRegistry;
                Application application2 = gVar.ca;
                hVar2.ogL = true;
                hVar2.app = application2;
                com.tencent.mm.plugin.appbrand.utils.h hVar3 = this.singletonRegistry;
                com.tencent.mm.plugin.appbrand.utils.a.a aVar2 = com.tencent.mm.plugin.appbrand.utils.a.a.INST;
                Log.i("MicroMsg.AppSingletonRegistry", "registerAppSingleton() called with: singleton = [%s]", aVar2);
                hVar3.ogJ.offer(aVar2);
                com.tencent.mm.plugin.appbrand.i.i(gVar.ca);
                ap.i(gVar.ca);
                com.tencent.mm.plugin.appbrand.luggage.b.c cVar = com.tencent.mm.plugin.appbrand.luggage.b.c.nac;
                Application application3 = gVar.ca;
                kotlin.g.b.p.h(application3, "app");
                application3.registerActivityLifecycleCallbacks(cVar);
                com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().a(MMApplicationContext.getContext(), com.tencent.mm.plugin.appbrand.xweb_ext.video.b.cdM(), com.tencent.mm.plugin.appbrand.xweb_ext.video.b.cdO(), com.tencent.mm.plugin.appbrand.xweb_ext.video.a.cdL(), null);
                com.tencent.mm.picker.c.a.jKQ = new k();
                com.tencent.mm.plugin.appbrand.jsapi.video.e.b.i iVar = com.tencent.mm.plugin.appbrand.jsapi.video.e.b.i.mCD;
                com.tencent.mm.plugin.appbrand.jsapi.video.e.b.i iVar2 = com.tencent.mm.plugin.appbrand.jsapi.video.e.b.i.mCD;
                boolean bKL = com.tencent.mm.plugin.appbrand.jsapi.video.e.b.i.bKL();
                com.tencent.mm.plugin.expt.b.b bVar2 = (com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class);
                if (bVar2 != null) {
                    z = bVar2.a(b.a.clicfg_android_xweb_video_exo_content_type_infer, bKL);
                    Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "useContentInferer, expt is ".concat(String.valueOf(z)));
                } else {
                    z = bKL;
                }
                com.tencent.mm.plugin.appbrand.jsapi.video.e.b.i.hS(z);
            }
            if (MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsMpProcess()) {
                g.a(com.tencent.mm.plugin.appbrand.service.f.class, new com.tencent.mm.kernel.c.e(c.kIc));
                g.a(w.class, new com.tencent.mm.kernel.c.e(PreDownloadServiceExportAnyProcess.kOX));
                g.a(com.tencent.mm.plugin.appbrand.service.j.class, new com.tencent.mm.kernel.c.e(new m()));
                g.a(IAppBrandBatchPreloadController.class, new com.tencent.mm.kernel.c.e(new AppBrandBatchPreloadController()));
                com.tencent.mm.plugin.appbrand.dynamic.widget.b.initialize();
                boolean z2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_native_video_proxy, 0) == 1;
                com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().a(MMApplicationContext.getContext(), z2, z2, com.tencent.mm.plugin.appbrand.xweb_ext.video.a.cdL(), new com.tencent.luggage.xweb_ext.extendplugin.component.video.a.a.a());
                g.a(v.class, new com.tencent.mm.kernel.c.e(WxaPkgStorageExportServiceIPC.kQn));
                g.a(com.tencent.mm.plugin.appbrand.service.u.class, new com.tencent.mm.kernel.c.e(WxaPkgDownloaderExportServiceIPC.kQa));
            }
            if (isAppBrandProcess()) {
                MMUncaughtExceptionHandler.addOnUncaughtExceptionListener(new MMUncaughtExceptionHandler.IOnUncaughtExceptionListener() {
                    /* class com.tencent.mm.plugin.appbrand.app.PluginAppBrand.AnonymousClass2 */

                    @Override // com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener
                    public final void uncaughtException(MMUncaughtExceptionHandler mMUncaughtExceptionHandler, String str, Throwable th) {
                        AppMethodBeat.i(226311);
                        if (Util.nullAsNil(str).contains(".plugin.appbrand")) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(365, 3, 1, false);
                            KVCommCrossProcessReceiver.eOD();
                        }
                        AppMethodBeat.o(226311);
                    }
                });
                AppBrandProcessSuicideLogic.c(gVar.ca);
                e.j(gVar.ca);
                try {
                    SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "pref_appbrand_process", 4);
                    String str = MMApplicationContext.getProcessName() + ":start_time";
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    if (sharedPreferences.contains(str)) {
                        edit.remove(str);
                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(365, 2, 1, false);
                    }
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(365, 4, 1, false);
                    edit.putLong(str, System.currentTimeMillis());
                    edit.commit();
                    Log.v("MicroMsg.AppBrandReporter", "onProcessStart");
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.AppBrandReporter", th, "onProcessStart()", new Object[0]);
                }
                KVCommCrossProcessReceiver.eOB();
                com.tencent.mm.plugin.appbrand.task.preload.h.c(gVar.ca);
                g.a(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundrunning.a()));
                copyWxaDecodeKeyFile();
                CdnLogic.InitSavePath("/data/user/0/" + gVar.getPackageName() + "/MicroMsg/CronetCache/appbrand/cache/", new CdnLogic.AppCallback() {
                    /* class com.tencent.mm.plugin.appbrand.app.PluginAppBrand.AnonymousClass3 */

                    @Override // com.tencent.mars.cdn.CdnLogic.AppCallback
                    public final void requestGetCDN(int i2) {
                    }

                    @Override // com.tencent.mars.cdn.CdnLogic.AppCallback
                    public final void reportFlow(int i2, int i3, int i4, int i5) {
                    }

                    @Override // com.tencent.mars.cdn.CdnLogic.AppCallback
                    public final String[] resolveHost(String str, boolean z, int[] iArr) {
                        return new String[0];
                    }

                    @Override // com.tencent.mars.cdn.CdnLogic.AppCallback
                    public final void onBadNetworkProbed() {
                    }
                });
            }
            if (isSupportProcess()) {
                com.tencent.mm.plugin.appbrand.dynamic.h.e.dI(MMApplicationContext.getContext());
                com.tencent.mm.ab.h.initialize();
            }
            if (MMApplicationContext.isToolsProcess()) {
                com.tencent.mm.ab.h.initialize();
            }
        }
        if (MMApplicationContext.isMainProcess() || MMApplicationContext.isAppBrandProcess()) {
            com.tencent.mm.plugin.appbrand.report.r.init();
        }
        AppMethodBeat.o(44159);
    }

    private void preloadRuntimeSoAsync() {
        AppMethodBeat.i(226326);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_preload_so, 0);
        Log.i(TAG, "preload so [%d]", Integer.valueOf(a2));
        if (a2 == 0) {
            AppMethodBeat.o(226326);
            return;
        }
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.app.PluginAppBrand.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(226312);
                Log.i(PluginAppBrand.TAG, "preload so start");
                MBRuntime.Ra();
                for (String str : PluginAppBrand.PRELOAD_SO_NAME) {
                    com.tencent.mm.compatible.util.j.load(str);
                }
                Log.i(PluginAppBrand.TAG, "preload so end");
                AppMethodBeat.o(226312);
            }
        });
        AppMethodBeat.o(226326);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public final String name() {
        return "plugin-appbrand";
    }

    static boolean isAppBrandProcess() {
        AppMethodBeat.i(44160);
        try {
            boolean startsWith = g.aAe().azG().mProcessName.startsWith(MMApplicationContext.getPackageName() + ":appbrand");
            AppMethodBeat.o(44160);
            return startsWith;
        } catch (Exception e2) {
            AppMethodBeat.o(44160);
            return false;
        }
    }

    static boolean isSupportProcess() {
        AppMethodBeat.i(44161);
        try {
            boolean equals = SupportProcessIPCService.dkO.equals(g.aAe().azG().mProcessName);
            AppMethodBeat.o(44161);
            return equals;
        } catch (Exception e2) {
            AppMethodBeat.o(44161);
            return false;
        }
    }

    public static SharedPreferences getProcessSharedPrefs() {
        AppMethodBeat.i(44162);
        MultiProcessMMKV VQ = f.kIs.VQ();
        AppMethodBeat.o(44162);
        return VQ;
    }

    @Deprecated
    private void initJSONABTestGetter() {
        AppMethodBeat.i(44163);
        com.tencent.mm.ab.h.a(new com.tencent.mm.ab.e() {
            /* class com.tencent.mm.plugin.appbrand.app.PluginAppBrand.AnonymousClass5 */
        });
        AppMethodBeat.o(44163);
    }

    private void copyWxaDecodeKeyFile() {
        AppMethodBeat.i(174699);
        String str = MMApplicationContext.getContext().getApplicationContext().getFilesDir().getAbsolutePath() + "/wasae.dat";
        if (!com.tencent.mm.vfs.s.YS(str) || !"43bff1e72298b0ea0b73e2960d3c97b8".equals(com.tencent.mm.vfs.s.bhK(str))) {
            Log.d(TAG, "copy key file ok: %b", Boolean.valueOf(FilesCopy.copyAssets(MMApplicationContext.getContext(), "wasae.dat", str)));
            AppMethodBeat.o(174699);
            return;
        }
        Log.d(TAG, "key file exist, skip copy");
        AppMethodBeat.o(174699);
    }
}
