package com.tencent.mm.plugin.performance;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.support.v4.app.v;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.battery.BackgroundActivationsListener;
import com.tencent.mm.plugin.expansions.a;
import com.tencent.mm.plugin.expt.PluginExpt;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.performance.a.d;
import com.tencent.mm.plugin.performance.c.a;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.performance.elf.b;
import com.tencent.mm.plugin.performance.jectl.JeVersion;
import com.tencent.mm.plugin.performance.watchdogs.ThreadWatchDog;
import com.tencent.mm.plugin.performance.watchdogs.c;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.toolkit.frontia.a.c;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.wxperf.fd.FDDumpBridge;
import com.tencent.wxperf.jni.HookManager;
import com.tencent.wxperf.jni.memory.MemoryHook;
import com.tencent.wxperf.jni.pthread.PthreadHook;
import java.util.ArrayList;

public class PluginPerformance extends f implements o, c, d, ApplicationLifeCycle {
    private static final String TAG = "MicroMsg.PluginPerformance";
    a mForegroundKilledDetector;
    private a threadPoolProfiler = new a();

    public PluginPerformance() {
        AppMethodBeat.i(184687);
        AppMethodBeat.o(184687);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(124900);
        alias(d.class);
        AppMethodBeat.o(124900);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(124901);
        dependsOn(PluginReport.class);
        dependsOn(PluginExpt.class);
        dependsOn(com.tencent.mm.plugin.zero.a.d.class);
        AppMethodBeat.o(124901);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(124903);
        if (MMApplicationContext.isPushProcess()) {
            b bVar = b.AUL;
            try {
                bVar.ded = b.bF(((float) ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_process_enable, 0)) / 10000.0f);
                com.tencent.mm.plugin.performance.elf.b.AUF = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_process_check_time, 1200000L);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ProcessElf", e2, "", new Object[0]);
                com.tencent.mm.plugin.performance.elf.b.AUF = 1200000;
                bVar.ded = com.tencent.mm.plugin.performance.elf.b.DEBUG;
            }
            Log.i("MicroMsg.ProcessElf", "[call] isEnable:%b CHECK_TIME:%s", Boolean.valueOf(bVar.ded), Long.valueOf(com.tencent.mm.plugin.performance.elf.b.eCr()));
            if (bVar.ded) {
                com.tencent.mm.plugin.performance.elf.b.AUg.removeCallbacks(com.tencent.mm.plugin.performance.elf.b.AUN);
                com.tencent.mm.plugin.performance.elf.b.AUg.postDelayed(com.tencent.mm.plugin.performance.elf.b.AUN, com.tencent.mm.plugin.performance.elf.b.eCr());
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("ACTION_ELF_CHECK_RESPONSE");
            intentFilter.addAction("com.tencent.mm.MMUIModeManager");
            MMApplicationContext.getContext().registerReceiver(com.tencent.mm.plugin.performance.elf.b.AUM, intentFilter);
        }
        gVar.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.ad.a());
        setupMemoryWatchDog();
        gVar.ca.registerActivityLifecycleCallbacks(new ThreadWatchDog());
        com.tencent.mm.plugin.performance.watchdogs.a eCE = com.tencent.mm.plugin.performance.watchdogs.a.eCE();
        try {
            eCE.AWe = FDDumpBridge.getFDLimit();
            Log.i("MicroMsg.FDWatchDog", "FdLimit = %s", Integer.valueOf(eCE.AWe));
            int i2 = 230;
            if (eCE.AWe <= 1024) {
                i2 = 231;
            } else if (eCE.AWe <= 2048) {
                i2 = 232;
            } else if (eCE.AWe <= 4096) {
                i2 = TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS;
            }
            e.INSTANCE.idkeyStat(1031, (long) i2, 1, false);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.FDWatchDog", th, "get resource limit err", new Object[0]);
            e.INSTANCE.idkeyStat(1031, 251, 1, false);
        }
        h.RTc.o(eCE, 1800000);
        com.tencent.mm.plugin.performance.watchdogs.d eCN = com.tencent.mm.plugin.performance.watchdogs.d.eCN();
        if (!MMApplicationContext.isMainProcess()) {
            Log.e("MicroMsg.ProcessWatchDog", "NOT main process");
        } else {
            h.RTc.o(eCN, eCN.cQp ? 300000 : 1800000);
        }
        setupWxperf();
        setupBitmapDecodeCanary(gVar);
        this.mForegroundKilledDetector = a.aJO(gVar.mProcessName);
        a aVar = this.mForegroundKilledDetector;
        aVar.mState = aVar.cQe.decodeInt("state", 0);
        Log.d("MicroMsg.ForegroundKilledDetect", "%s: CHECK LAST STATE = %s", aVar.mProcessName, Integer.toBinaryString(aVar.mState));
        if (aVar.eBw() && aVar.eBx() && !aVar.eBy()) {
            Log.e("MicroMsg.ForegroundKilledDetect", "%s: LAST STATE ERROR: %s", aVar.mProcessName, Integer.toBinaryString(aVar.mState));
            com.tencent.mm.kernel.g.aAi().a(new com.tencent.mm.kernel.api.g() {
                /* class com.tencent.mm.plugin.performance.a.AnonymousClass1 */

                @Override // com.tencent.mm.kernel.api.g
                public final void WY() {
                    AppMethodBeat.i(176885);
                    ArrayList<IDKey> arrayList = new ArrayList<>();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(1313);
                    iDKey.SetKey(BuildInfo.IS_ARM64 ? 1 : 0);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(1313);
                    iDKey2.SetKey(a.eBA());
                    iDKey2.SetValue(1);
                    arrayList.add(iDKey2);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.b(arrayList, false);
                    com.tencent.mm.kernel.g.aAi().b(this);
                    AppMethodBeat.o(176885);
                }

                @Override // com.tencent.mm.kernel.api.g
                public final void cQ(boolean z) {
                }
            });
        }
        aVar.Uo(1);
        aVar.Uo(2);
        aVar.Uo(4);
        aVar.eBz();
        this.mForegroundKilledDetector.onAppForeground("boot");
        gVar.ca.registerActivityLifecycleCallbacks(this.mForegroundKilledDetector);
        CrashReportFactory.addCrashReportExtraMessageGetter(this.mForegroundKilledDetector);
        AppMethodBeat.o(124903);
    }

    private void setupMemoryWatchDog() {
        long j2;
        AppMethodBeat.i(201006);
        com.tencent.mm.plugin.performance.watchdogs.c eCH = com.tencent.mm.plugin.performance.watchdogs.c.eCH();
        eCH.AXb = eCH.aJf.getMemoryClass();
        eCH.AXc = eCH.aJf.getLargeMemoryClass();
        ((Application) MMApplicationContext.getContext()).registerActivityLifecycleCallbacks(eCH);
        eCH.AXl = System.currentTimeMillis();
        i iVar = h.RTc;
        if (eCH.cPB) {
            j2 = 300000;
        } else {
            j2 = 1800000;
        }
        iVar.a(eCH, j2, "MicroMsg.MemoryWatchDog");
        double random = Math.random();
        if (random >= 1.0d / ((double) ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_boot_memory_watchdog_sample_rate, 100000))) {
            Log.i(TAG, "NOT report memory info after boot (%s)", Double.valueOf(random));
            AppMethodBeat.o(201006);
            return;
        }
        Log.i(TAG, "will repot memory info after boot (%s)", Double.valueOf(random));
        com.tencent.mm.kernel.g.aAi().a(new com.tencent.mm.kernel.api.g() {
            /* class com.tencent.mm.plugin.performance.PluginPerformance.AnonymousClass1 */

            @Override // com.tencent.mm.kernel.api.g
            public final void WY() {
                AppMethodBeat.i(200999);
                h.RTc.o(new Runnable() {
                    /* class com.tencent.mm.plugin.performance.PluginPerformance.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(124897);
                        c.a S = com.tencent.mm.plugin.performance.watchdogs.c.eCH().S(true, 0);
                        Object[] array = c.eBB().toArray();
                        StringBuilder sb = new StringBuilder();
                        if (S.AXH != null && S.AXH.length > 0) {
                            sb.append("allProcess:");
                            c.a[] aVarArr = S.AXH;
                            for (c.a aVar : aVarArr) {
                                sb.append(aVar.pid).append("-").append(aVar.processName).append("-pss:").append(aVar.AXF).append(";");
                            }
                        }
                        int i2 = -1;
                        if (array != null && (i2 = array.length) > 0) {
                            sb.append("loaded so:");
                            for (Object obj : array) {
                                sb.append(obj).append(";");
                            }
                        }
                        com.tencent.mm.plugin.performance.watchdogs.b.a(32, S.AXx - S.AXy, S.AXv, (long) S.AXq, (long) S.AXF, (long) S.AXG, sb.toString(), i2, -2, -2, -1, S.AXE.totalMem);
                        AppMethodBeat.o(124897);
                    }
                }, 10000);
                com.tencent.mm.kernel.g.aAi().b(this);
                AppMethodBeat.o(200999);
            }

            @Override // com.tencent.mm.kernel.api.g
            public final void cQ(boolean z) {
            }
        });
        AppMethodBeat.o(201006);
    }

    private void setupWxperf() {
        AppMethodBeat.i(201007);
        com.tencent.mm.plugin.expansions.a.a(new a.b() {
            /* class com.tencent.mm.plugin.performance.PluginPerformance.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.expansions.a.b
            public final void a(c.a aVar) {
                AppMethodBeat.i(201000);
                MemoryHook memoryHook = (MemoryHook) ((com.tencent.mm.plugin.performance.diagnostic.b.b) com.tencent.mm.plugin.performance.a.a.INSTANCE.aT(com.tencent.mm.plugin.performance.diagnostic.b.b.class)).eBJ();
                PthreadHook pthreadHook = (PthreadHook) ((com.tencent.mm.plugin.performance.diagnostic.c.b) com.tencent.mm.plugin.performance.a.a.INSTANCE.aT(com.tencent.mm.plugin.performance.diagnostic.c.b.class)).eBJ();
                try {
                    Log.i(PluginPerformance.TAG, "memoryHook = %s, pthreadHook = %s, eglHook = %s", memoryHook, pthreadHook, "eglHookStub");
                    HookManager.Syn.a(memoryHook).a(pthreadHook).hrZ();
                } catch (Throwable th) {
                    Log.printErrStackTrace(PluginPerformance.TAG, th, "Hook error", new Object[0]);
                }
                if (MMApplicationContext.isMainProcess()) {
                    JeVersion.eCv();
                }
                AppMethodBeat.o(201000);
            }
        });
        AppMethodBeat.o(201007);
    }

    private void setupBitmapDecodeCanary(final g gVar) {
        AppMethodBeat.i(124904);
        MMBitmapFactory.setDecodeCanary(new com.tencent.mm.graphics.a() {
            /* class com.tencent.mm.plugin.performance.PluginPerformance.AnonymousClass3 */

            @Override // com.tencent.mm.graphics.a
            public final void a(final BitmapFactory.Options options, final int i2) {
                int i3 = 2;
                AppMethodBeat.i(201002);
                Log.e(PluginPerformance.TAG, "WARNING: bitmap decode oversize \n(%s B/%s B), [w:%s, h:%s]", Integer.valueOf(i2), 20971520L, Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                Throwable th = new Throwable();
                Log.printErrStackTrace(PluginPerformance.TAG, th, "bitmap stacktrace", new Object[0]);
                if (i2 > 52428800) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(18613, gVar.mProcessName, android.util.Log.getStackTraceString(th).replace('\n', ';').replace("\t", ""), Integer.valueOf(i2));
                } else if (i2 > 31457280) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1230, i3);
                if (WeChatEnvironment.hasDebugger()) {
                    h.RTc.aV(new Runnable() {
                        /* class com.tencent.mm.plugin.performance.PluginPerformance.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(201001);
                            Toast.makeText(MMApplicationContext.getContext(), String.format("WARNING: large bitmap decode \n(%s B), [w:%s, h:%s]", Integer.valueOf(i2), Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight)), 1).show();
                            AppMethodBeat.o(201001);
                        }
                    });
                }
                AppMethodBeat.o(201002);
            }
        });
        AppMethodBeat.o(124904);
    }

    @Override // com.tencent.mm.kernel.b.f
    public String toString() {
        return "plugin-performance";
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        boolean z;
        AppMethodBeat.i(124905);
        if (MMApplicationContext.isMainProcess()) {
            com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.performance.PluginPerformance.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(201003);
                    ((MainProcessChecker) com.tencent.mm.plugin.performance.elf.a.aU(MainProcessChecker.class)).start();
                    AppMethodBeat.o(201003);
                }
            }, 2000);
            if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED || com.tencent.mm.protocal.d.KyR || ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_app_background_fallback_notify_enable2, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            AppForegroundDelegate.djW = z;
        }
        AppMethodBeat.o(124905);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
    }

    @Override // com.tencent.mm.app.o
    public void onAppForeground(String str) {
        AppMethodBeat.i(124906);
        com.tencent.mm.plugin.performance.elf.a.aU(MainProcessChecker.class).cy(true);
        com.tencent.mm.plugin.performance.watchdogs.c.eCH().cy(true);
        com.tencent.mm.plugin.performance.watchdogs.d.eCN().cQp = true;
        if (this.mForegroundKilledDetector != null) {
            this.mForegroundKilledDetector.onAppForeground(str);
        }
        stopBackgroundActivationsListener(MMApplicationContext.getContext());
        AppMethodBeat.o(124906);
    }

    @Override // com.tencent.mm.app.o
    public void onAppBackground(String str) {
        AppMethodBeat.i(124907);
        com.tencent.mm.plugin.performance.elf.a.aU(MainProcessChecker.class).cy(false);
        com.tencent.mm.plugin.performance.watchdogs.c.eCH().cy(false);
        com.tencent.mm.plugin.performance.watchdogs.d.eCN().cQp = false;
        if (this.mForegroundKilledDetector != null) {
            this.mForegroundKilledDetector.onAppBackground(str);
        }
        startBackgroundActivationsListener(MMApplicationContext.getContext());
        AppMethodBeat.o(124907);
    }

    public com.tencent.mm.plugin.performance.c.a getThreadPoolProfiler() {
        return this.threadPoolProfiler;
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onCreate() {
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onLowMemory() {
        AppMethodBeat.i(201008);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.performance.PluginPerformance.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(201004);
                Log.e(PluginPerformance.TAG, "onLowMemory -> dump memory");
                Log.i(PluginPerformance.TAG, "[onLowMemory] %s", com.tencent.mm.plugin.performance.watchdogs.c.eCH().S(true, 0));
                AppMethodBeat.o(201004);
            }
        });
        AppMethodBeat.o(201008);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onTrimMemory(final int i2) {
        AppMethodBeat.i(201009);
        if (i2 <= 15) {
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.plugin.performance.PluginPerformance.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(201005);
                    Log.e(PluginPerformance.TAG, "onTrimMemory level:%d -> dump memory", Integer.valueOf(i2));
                    Log.i(PluginPerformance.TAG, "[onTrimMemory] %s", com.tencent.mm.plugin.performance.watchdogs.c.eCH().S(true, 0));
                    AppMethodBeat.o(201005);
                }
            });
        }
        AppMethodBeat.o(201009);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onTerminate() {
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onBaseContextAttached(Context context) {
    }

    private void setupBackgroundActivationsListener(Context context) {
        AppMethodBeat.i(201010);
        if (!WeChatEnvironment.hasDebugger()) {
            AppMethodBeat.o(201010);
            return;
        }
        isNotificationListenerEnabled(context);
        AppMethodBeat.o(201010);
    }

    private void startBackgroundActivationsListener(Context context) {
        AppMethodBeat.i(201011);
        if (!WeChatEnvironment.hasDebugger()) {
            AppMethodBeat.o(201011);
        } else if (!isNotificationListenerEnabled(context)) {
            AppMethodBeat.o(201011);
        } else {
            try {
                context.startService(new Intent(context, BackgroundActivationsListener.class));
                AppMethodBeat.o(201011);
            } catch (Exception e2) {
                AppMethodBeat.o(201011);
            }
        }
    }

    private void stopBackgroundActivationsListener(Context context) {
        AppMethodBeat.i(201012);
        if (!WeChatEnvironment.hasDebugger()) {
            AppMethodBeat.o(201012);
        } else if (!isNotificationListenerEnabled(context)) {
            AppMethodBeat.o(201012);
        } else {
            try {
                context.stopService(new Intent(context, BackgroundActivationsListener.class));
                AppMethodBeat.o(201012);
            } catch (Exception e2) {
                AppMethodBeat.o(201012);
            }
        }
    }

    private static boolean isNotificationListenerEnabled(Context context) {
        AppMethodBeat.i(201013);
        try {
            boolean contains = v.Q(context).contains(context.getPackageName());
            AppMethodBeat.o(201013);
            return contains;
        } catch (Exception e2) {
            AppMethodBeat.o(201013);
            return false;
        }
    }

    private void dryRunBackgroundActivationForTest(Context context) {
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(124902);
        com.tencent.mm.ci.c.OvX = new com.tencent.mm.ci.a() {
            /* class com.tencent.mm.plugin.performance.b.AnonymousClass1 */

            @Override // com.tencent.mm.ci.a
            public final boolean aJP(String str) {
                AppMethodBeat.i(124908);
                boolean a2 = aa.a(str, z.aTY(), true, false);
                AppMethodBeat.o(124908);
                return a2;
            }
        };
        com.tencent.mm.plugin.performance.a.a.INSTANCE.a(com.tencent.mm.plugin.performance.diagnostic.c.ATi);
        com.tencent.mm.plugin.performance.a.a.INSTANCE.a(new com.tencent.mm.plugin.performance.diagnostic.b.b());
        com.tencent.mm.plugin.performance.a.a.INSTANCE.a(new com.tencent.mm.plugin.performance.diagnostic.a.c());
        com.tencent.mm.plugin.performance.a.a.INSTANCE.a(new com.tencent.mm.plugin.performance.diagnostic.c.b());
        com.tencent.mm.plugin.performance.diagnostic.b.alive();
        com.tencent.mm.plugin.performance.c.a aVar = this.threadPoolProfiler;
        boolean aBb = gVar.aBb();
        Log.i("ThreadPool.Profiler", "[open] isProcessMain=".concat(String.valueOf(aBb)));
        if (com.tencent.mm.plugin.performance.c.a.cWq && aBb) {
            MMHandler mMHandler = new MMHandler("reportStatistics");
            mMHandler.postDelayed(new a.k(aVar, mMHandler), 1800000);
            AppForegroundDelegate.INSTANCE.a(aVar);
            aVar.AVs.startTimer(600000, 600000);
        }
        AppForegroundDelegate appForegroundDelegate = AppForegroundDelegate.INSTANCE;
        com.tencent.mm.plugin.performance.c.a aVar2 = aVar;
        synchronized (appForegroundDelegate.djX) {
            try {
                appForegroundDelegate.djX.add(aVar2);
            } catch (Throwable th) {
                AppMethodBeat.o(124902);
                throw th;
            }
        }
        com.tencent.f.d.RSQ = aVar.AVl;
        com.tencent.f.d.RSR = aVar.AVj;
        com.tencent.f.a.RSx = aVar.AVk;
        AppMethodBeat.o(124902);
    }
}
