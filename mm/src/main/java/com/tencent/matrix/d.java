package com.tencent.matrix;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.c.a.a;
import com.tencent.matrix.b;
import com.tencent.matrix.c;
import com.tencent.matrix.d.a.a;
import com.tencent.matrix.g.c;
import com.tencent.matrix.iocanary.a.a;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.report.g;
import com.tencent.matrix.report.h;
import com.tencent.matrix.resource.b;
import com.tencent.matrix.resource.b.a;
import com.tencent.matrix.resource.e.b;
import com.tencent.matrix.strategy.MatrixStrategyNotifyBroadcast;
import com.tencent.matrix.strategy.a;
import com.tencent.matrix.trace.a.b;
import com.tencent.matrix.trace.f.c;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.sqlitelint.SQLiteLint;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import com.tencent.sqlitelint.config.SQLiteLintConfig;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public enum d implements c.a {
    INSTANCE;
    
    private Application application;
    public h cPJ = null;
    private volatile boolean cPK = false;
    private final MultiProcessMMKV cPL = MultiProcessMMKV.getMMKV("MatrixDelegate");
    public a cPM;
    private final int cPN = 9;
    private boolean cPO = false;
    private volatile boolean cPP = false;
    public volatile boolean isInitialized = false;

    private d(String str) {
    }

    @Override // com.tencent.matrix.c.a
    public final void a(Application application2) {
        this.application = application2;
        this.cPM = new com.tencent.matrix.strategy.d();
    }

    @Override // com.tencent.matrix.c.a
    public final c.a RH() {
        return new c.a() {
            /* class com.tencent.matrix.d.AnonymousClass1 */

            @Override // com.tencent.matrix.g.c.a
            public final void v(String str, String str2, Object... objArr) {
                Log.v(str, str2, objArr);
            }

            @Override // com.tencent.matrix.g.c.a
            public final void i(String str, String str2, Object... objArr) {
                Log.i(str, str2, objArr);
            }

            @Override // com.tencent.matrix.g.c.a
            public final void w(String str, String str2, Object... objArr) {
                Log.w(str, str2, objArr);
            }

            @Override // com.tencent.matrix.g.c.a
            public final void d(String str, String str2, Object... objArr) {
                Log.d(str, str2, objArr);
            }

            @Override // com.tencent.matrix.g.c.a
            public final void e(String str, String str2, Object... objArr) {
                Log.e(str, str2, objArr);
            }

            @Override // com.tencent.matrix.g.c.a
            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                Log.printErrStackTrace(str, th, str2, objArr);
            }
        };
    }

    @Override // com.tencent.matrix.c.a
    public final h RI() {
        long j2 = 5;
        h.a aVar = new h.a(MMApplicationContext.getContext());
        aVar.cWo = Long.valueOf((long) com.tencent.mm.protocal.d.KyO);
        aVar.cWx = Boolean.valueOf(WeChatEnvironment.isMonkeyEnv());
        aVar.cWp = BuildInfo.REV;
        if (!BuildInfo.IS_FLAVOR_PURPLE && !BuildInfo.IS_FLAVOR_RED && !BuildInfo.DEBUG && !com.tencent.mm.protocal.d.KyR) {
            j2 = com.tencent.mm.protocal.d.KyP ? 3 : com.tencent.mm.protocal.d.KyQ ? 4 : -1;
        }
        aVar.cWr = Long.valueOf(j2);
        Objects.requireNonNull(aVar.context, "matrix report init, context is null");
        Objects.requireNonNull(aVar.cWo, "matrix report init, clientVersion is null");
        Objects.requireNonNull(aVar.cWp, "matrix report init, revision is null");
        Objects.requireNonNull(aVar.cWr, "matrix report init, publishType is null");
        this.cPJ = new h(aVar.context, aVar.cWo, aVar.cWp, aVar.cWx, aVar.cWr);
        Log.i("MatrixDelegate", "init matrix reporter. %s", this.cPJ);
        return this.cPJ;
    }

    @Override // com.tencent.matrix.c.a
    public final f RJ() {
        return new f();
    }

    @Override // com.tencent.matrix.c.a
    public final h.b RK() {
        return new g();
    }

    @Override // com.tencent.matrix.c.a
    public final o RL() {
        return new o() {
            /* class com.tencent.matrix.d.AnonymousClass2 */

            @Override // com.tencent.mm.app.o
            public final void onAppForeground(String str) {
                d.this.cy(true);
            }

            @Override // com.tencent.mm.app.o
            public final void onAppBackground(String str) {
                d.this.cy(false);
            }
        };
    }

    @Override // com.tencent.matrix.c.a
    public final void b(b bVar) {
        boolean z = false;
        Log.i("MatrixDelegate", "onFinalJob");
        int i2 = this.cPL.getInt("ENABLE_FPS_FLOAT", 0);
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(i2 == 1);
        objArr[1] = Integer.valueOf(i2);
        Log.i("MatrixDelegate", "[isEnableFpsFloat] enable=%s, value=%s", objArr);
        if (i2 == 1) {
            z = true;
        }
        if (z && e.RN()) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.matrix.d.AnonymousClass3 */

                public final void run() {
                    d.eh("ENABLE_FPS");
                    d.eh("ENABLE_FPS_FLOAT");
                }
            });
        }
        Application application2 = this.application;
        b bVar2 = (b) bVar.Y(b.class);
        if (bVar2 != null) {
            bVar2.cWQ.cZM = new b.AbstractC0231b() {
                /* class com.tencent.matrix.d.AnonymousClass6 */
                final HashSet<String> cPW = new HashSet<>();
                private final Set<String> cPX = new HashSet();
                private final double cPY = Math.random();

                /* JADX WARNING: Code restructure failed: missing block: B:15:0x00e0, code lost:
                    r0 = (com.tencent.matrix.resource.b) com.tencent.matrix.b.RG().Y(com.tencent.matrix.resource.b.class);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:16:0x00ec, code lost:
                    if (r0 != null) goto L_0x00fc;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:17:0x00ee, code lost:
                    com.tencent.mm.sdk.platformtools.Log.e("MatrixDelegate", "ResourcePlugin not found!");
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:22:0x00fe, code lost:
                    if (r0.cWQ != null) goto L_0x010b;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:23:0x0100, code lost:
                    com.tencent.mm.sdk.platformtools.Log.e("MatrixDelegate", "ActivityRefWatcher not found!");
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:24:0x010b, code lost:
                    r4 = java.lang.System.currentTimeMillis();
                    r3 = com.tencent.mm.vfs.o.X(new com.tencent.matrix.resource.e.d(com.tencent.mm.sdk.platformtools.MMApplicationContext.getContext()).Tj());
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:25:0x0120, code lost:
                    if (r3 != null) goto L_0x0124;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:26:0x0122, code lost:
                    return true;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
                    r0 = ((android.os.Environment.getExternalStorageDirectory().getFreeSpace() / 1024) / 1024) / 1024;
                    com.tencent.mm.sdk.platformtools.Log.i("MatrixDelegate", "freeSpace = %s GB", java.lang.Long.valueOf(r0));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:29:0x014c, code lost:
                    if (r0 <= 1) goto L_0x0159;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:30:0x014e, code lost:
                    android.os.Debug.dumpHprofData(com.tencent.mm.vfs.aa.z(r3.her()));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:34:0x019e, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:35:0x019f, code lost:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(18573, r13, "dump file error!", 0, 1, java.lang.Long.valueOf(r6), com.tencent.mm.sdk.platformtools.BuildInfo.BUILD_TAG);
                    com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MatrixDelegate", r0, "dump file error!", new java.lang.Object[0]);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
                    return false;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
                    return false;
                 */
                @Override // com.tencent.matrix.resource.e.b.AbstractC0231b
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final boolean G(final java.lang.String r13, final java.lang.String r14) {
                    /*
                    // Method dump skipped, instructions count: 538
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.d.AnonymousClass6.G(java.lang.String, java.lang.String):boolean");
                }

                @Override // com.tencent.matrix.resource.e.b.AbstractC0231b
                public final boolean H(String str, String str2) {
                    boolean z;
                    if ((!((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_matrix_resource_release_report_enable, true) || this.cPY >= 1.0d / ((double) ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_matrix_resource_release_report_rate, 100000))) && !WeChatEnvironment.hasDebugger()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        Log.i("MatrixDelegate", "not report");
                        return false;
                    }
                    Log.i("MatrixDelegate", "[onLeakLite] activity=%s isEnableDump=%s isSilence=%s", str, Boolean.valueOf(d.this.cPO), Boolean.valueOf(d.this.cPP));
                    Log.i("MatrixDelegate", "[onLeakLite] Activity dump [%s]", com.tencent.mm.ad.a.aBz());
                    if (!this.cPX.contains(str2)) {
                        Log.i("MatrixDelegate", "[onLeakLite] Activity report: %s", str2);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(18573, str, "release report", 0, 8);
                        this.cPX.add(str2);
                    }
                    return true;
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            AnonymousClass7 r3 = new BroadcastReceiver() {
                /* class com.tencent.matrix.d.AnonymousClass7 */

                public final void onReceive(Context context, Intent intent) {
                    boolean z;
                    if (Objects.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                        d.this.cPP = true;
                        d dVar = d.this;
                        if (BuildInfo.DEBUG || ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_open_dump_hprof, false)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        dVar.cPO = z;
                        Log.i("MatrixDelegate", "[ACTION_SCREEN_OFF] isEnableDump=%s", Boolean.valueOf(d.this.cPO));
                    }
                }
            };
            try {
                application2.getApplicationContext().registerReceiver(r3, intentFilter);
            } catch (Throwable th) {
                application2.getApplicationContext().unregisterReceiver(r3);
                application2.getApplicationContext().registerReceiver(r3, intentFilter);
            }
        }
        this.isInitialized = true;
        if (this.cPK) {
            cy(AppForegroundDelegate.INSTANCE.cPB);
        }
        if (MultiProcessMMKV.getDefault().decodeBool("clicfg_detect_dropframe", true)) {
            Log.i("MatrixDelegate", "start detecting dropFrame");
            com.tencent.matrix.trace.a aVar = (com.tencent.matrix.trace.a) b.RG().Y(com.tencent.matrix.trace.a.class);
            if (aVar == null) {
                Log.i("MatrixDelegate", "tracePlugin is null");
                return;
            }
            com.tencent.matrix.trace.f.c cVar = aVar.daF;
            if (cVar == null) {
                Log.i("MatrixDelegate", "frameTracer is null");
                return;
            }
            cVar.dco = new c.a() {
                /* class com.tencent.matrix.d.AnonymousClass4 */

                @Override // com.tencent.matrix.trace.f.c.a
                public final void a(final int i2, final String str, final long j2) {
                    com.tencent.f.h.RTc.aX(new Runnable() {
                        /* class com.tencent.matrix.d.AnonymousClass4.AnonymousClass1 */

                        /* JADX WARNING: Code restructure failed: missing block: B:18:0x009e, code lost:
                            if ((java.lang.System.currentTimeMillis() - r3.cWe.getLong("time")) < (r8 * 2)) goto L_0x00a0;
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            /*
                            // Method dump skipped, instructions count: 291
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.d.AnonymousClass4.AnonymousClass1.run():void");
                        }
                    });
                }
            };
            cVar.dcp = 9;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void cy(boolean z) {
        if (!this.isInitialized) {
            Log.w("MatrixDelegate", "[onAppForeground] but matrix is never initialized, delay to notify!");
            this.cPK = true;
            return;
        }
        if (MMApplicationContext.isMainProcess()) {
            MrsLogic.onForeground(z);
            if (!z) {
                com.tencent.f.h.RTc.b(new Runnable() {
                    /* class com.tencent.matrix.d.AnonymousClass5 */

                    public final void run() {
                        d.a(d.this);
                    }
                }, "MatrixDelegate");
            }
        }
        Iterator<com.tencent.matrix.e.b> it = b.RG().cqP.iterator();
        while (it.hasNext()) {
            com.tencent.matrix.e.b next = it.next();
            if (!(next instanceof com.tencent.matrix.trace.a)) {
                next.onForeground(z);
            }
        }
        this.cPP = !z;
    }

    /* access modifiers changed from: private */
    public static com.tencent.matrix.resource.analyzer.model.a a(com.tencent.mm.vfs.o oVar, String str) {
        com.tencent.matrix.resource.analyzer.model.d SY = com.tencent.matrix.resource.analyzer.model.c.m(Build.VERSION.SDK_INT, Build.MANUFACTURER).SY();
        try {
            return new com.tencent.matrix.resource.analyzer.a(str, SY).a(new com.tencent.matrix.resource.analyzer.model.g(oVar));
        } catch (IOException e2) {
            return com.tencent.matrix.resource.analyzer.model.a.a(e2, 0);
        }
    }

    @Override // com.tencent.matrix.c.a
    public final void a(Application application2, b.a aVar, f fVar) {
        boolean z;
        boolean z2;
        SQLiteLintConfig sQLiteLintConfig;
        boolean z3;
        a.b bVar;
        int i2;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        String str;
        boolean z8 = MMApplicationContext.isMainProcess() || MMApplicationContext.isToolsProcess() || MMApplicationContext.isAppBrandProcess();
        Log.i("MatrixDelegate", "[isEnableTracePlugin] isEnable=%s", Boolean.valueOf(z8));
        if (z8) {
            com.tencent.matrix.trace.a.a.Tu().daJ = true;
            b.a aVar2 = new b.a();
            aVar2.daS.cVx = fVar;
            int i3 = this.cPL.getInt(a.EnumC0131a.clicfg_matrix_trace_fps_enable.name(), 0);
            if (i3 == 1) {
                z4 = true;
            } else {
                z4 = i3 != -1 && (MMApplicationContext.isMainProcess() || MMApplicationContext.isToolsProcess() || MMApplicationContext.isAppBrandProcess());
            }
            Log.i("MatrixDelegate", "[isEnableFPS] isEnable=%s value=%s", Boolean.valueOf(z4), Integer.valueOf(i3));
            aVar2.daS.daK = z4;
            int i4 = this.cPL.getInt(a.EnumC0131a.clicfg_matrix_trace_evil_method_enable.name(), 0);
            if (i4 == 1) {
                z5 = true;
            } else {
                z5 = i4 != -1 && (MMApplicationContext.isMainProcess() || MMApplicationContext.isToolsProcess() || MMApplicationContext.isAppBrandProcess());
            }
            Log.i("MatrixDelegate", "[isEnableEvilMethod] isEnable=%s value=%s", Boolean.valueOf(z5), Integer.valueOf(i4));
            aVar2.daS.daL = z5;
            int i5 = this.cPL.getInt(a.EnumC0131a.clicfg_matrix_trace_startup_enable.name(), 0);
            if (i5 == 1) {
                z6 = true;
            } else {
                z6 = i5 != -1 && (MMApplicationContext.isMainProcess() || MMApplicationContext.isToolsProcess() || MMApplicationContext.isAppBrandProcess() || MMApplicationContext.isToolsMpProcess());
            }
            Log.i("MatrixDelegate", "[isEnableStartUp] isEnable=%s value=%s", Boolean.valueOf(z6), Integer.valueOf(i5));
            aVar2.daS.daM = z6;
            int i6 = this.cPL.getInt(a.EnumC0131a.clicfg_matrix_trace_anr_enable.name(), 0);
            if (i6 == 1) {
                z7 = true;
            } else {
                z7 = i6 != -1 && (MMApplicationContext.isMainProcess() || MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsMpProcess() || MMApplicationContext.isAppBrandProcess());
            }
            Log.i("MatrixDelegate", "[isEnableAnr] isEnable=%s value=%s", Boolean.valueOf(z7), Integer.valueOf(i6));
            aVar2.daS.daN = z7;
            if (MMApplicationContext.isMainProcess()) {
                str = "com.tencent.mm.app.WeChatSplashActivity;com.tencent.mm.plugin.account.ui.WelcomeActivity;";
            } else {
                str = "";
            }
            aVar2.daS.daP = str;
            aVar2.daS.cWq = true;
            aVar2.daS.daO = false;
            aVar.a(new com.tencent.matrix.trace.a(aVar2.daS));
            EventCenter.instance.add(new IListener<fp>() {
                /* class com.tencent.matrix.d.AnonymousClass8 */

                {
                    this.__eventId = fp.class.getName().hashCode();
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(fp fpVar) {
                    return RM();
                }

                private static boolean RM() {
                    try {
                        MultiProcessMMKV.getDefault().encode("clicfg_anr_report_all", ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_anr_report_all, true));
                        MultiProcessMMKV.getDefault().encode("clicfg_normal_report", ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_normal_report, false));
                        MultiProcessMMKV.getDefault().encode("clicfg_detect_dropframe", ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_detect_dropframe, true));
                        MultiProcessMMKV.getDefault().encode("clicfg_detect_syncbarrier_leak", ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_detect_syncbarrier_leak, false));
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MatrixDelegate", e2, "Cannot load A/B test", new Object[0]);
                    }
                    return true;
                }
            });
            this.cPJ.a(new com.tencent.matrix.b.a());
        }
        int i7 = this.cPL.getInt("ENABLE_BATTERY", 0);
        Log.i("MatrixDelegate", "[isEnableBatteryMonitor] value=%s", Integer.valueOf(i7));
        if (i7 == 1) {
            z = true;
        } else {
            z = i7 != -1 && (MMApplicationContext.isMainProcess() || MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsMpProcess() || MMApplicationContext.isAppBrandProcess() || MMApplicationContext.isPushProcess());
        }
        Log.i("MatrixDelegate", "[isEnableBatteryMonitor] isEnable=%s value=%s", Boolean.valueOf(z), Integer.valueOf(i7));
        if (z) {
            com.tencent.mm.plugin.expt.b.b bVar2 = (com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class);
            if (bVar2 != null) {
                i2 = bVar2.a(b.a.clicfg_battery_process_enable, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
            } else {
                i2 = 127;
            }
            if (MMApplicationContext.isMainProcess()) {
                z2 = (i2 & 1) == 1;
            } else if (MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsMpProcess()) {
                z2 = (i2 & 2) == 2;
            } else if (MMApplicationContext.isAppBrandProcess()) {
                z2 = (i2 & 4) == 4;
            } else if (MMApplicationContext.isPushProcess()) {
                z2 = (i2 & 8) == 8;
            } else {
                z2 = (i2 & 128) == 128;
            }
            Log.i("MatrixDelegate", "[isEnableBatteryMonitor] isEnable=%s cliCfg=%s", Boolean.valueOf(z2), Integer.toBinaryString(i2));
        } else {
            z2 = z;
        }
        if (z2) {
            aVar.a(com.tencent.matrix.c.a.Sz());
        }
        boolean z9 = MMApplicationContext.isMainProcess() || MMApplicationContext.isToolsProcess() || MMApplicationContext.isAppBrandProcess();
        Log.i("MatrixDelegate", "[isEnableActivityLeak] isEnable=%s", Boolean.valueOf(z9));
        if (z9) {
            Intent intent = new Intent();
            if (Util.getInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_matrix_activity_leak_silence_dump", AppEventsConstants.EVENT_PARAM_VALUE_NO, false, true), 0) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                Log.i("MatrixDelegate", "enable silence dump cause expt: clicfg_matrix_activity_leak_silence_dump");
                bVar = a.b.SILENCE_DUMP;
            } else if (WeChatEnvironment.isMonkeyEnv()) {
                Log.i("MatrixDelegate", "enable silence dump cause monkey");
                bVar = a.b.SILENCE_DUMP;
            } else if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
                Log.i("MatrixDelegate", "enable silence dump cause purple/red");
                bVar = a.b.SILENCE_DUMP;
            } else if (com.tencent.mm.protocal.d.KyR) {
                Log.i("MatrixDelegate", "enable silence dump cause alpha");
                bVar = a.b.SILENCE_DUMP;
            } else {
                bVar = a.b.NO_DUMP;
            }
            Log.i("MatrixDelegate", "Dump Activity Leak Mode=%s", bVar);
            intent.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.ui.matrix.ManualDumpActivity");
            a.C0229a aVar3 = new a.C0229a();
            aVar3.cVx = fVar;
            aVar3.cYG = bVar;
            aVar3.cYF = intent;
            aVar.a(new com.tencent.matrix.resource.b(new com.tencent.matrix.resource.b.a(aVar3.cVx, aVar3.cYG, aVar3.cYE, aVar3.cYF, (byte) 0)));
            com.tencent.matrix.resource.b.b(application2);
        }
        Log.i("MatrixDelegate", "[isEnableIOCanary] isEnable=%s", Boolean.TRUE);
        a.C0225a aVar4 = new a.C0225a();
        aVar4.cQF = fVar;
        aVar.a(new com.tencent.matrix.iocanary.a(new com.tencent.matrix.iocanary.a.a(aVar4.cQF, (byte) 0)));
        boolean isMonkeyEnv = WeChatEnvironment.isMonkeyEnv();
        Log.i("MatrixDelegate", "[isEnableSQLiteLint] isEnable=%s", Boolean.valueOf(isMonkeyEnv));
        if (isMonkeyEnv) {
            try {
                sQLiteLintConfig = new SQLiteLintConfig(SQLiteLint.SqlExecutionCallbackMode.CUSTOM_NOTIFY);
            } catch (Throwable th) {
                sQLiteLintConfig = new SQLiteLintConfig(SQLiteLint.SqlExecutionCallbackMode.CUSTOM_NOTIFY);
            }
            aVar.a(new SQLiteLintPlugin(sQLiteLintConfig));
        }
        if (MMApplicationContext.isMainProcess()) {
            a.C0220a aVar5 = new a.C0220a();
            aVar5.cVx = fVar;
            aVar.a(new com.tencent.matrix.d.a(new com.tencent.matrix.d.a.a(aVar5.cVx, (byte) 0)));
        }
        this.cPJ.a(new com.tencent.matrix.b.d());
        if (MultiProcessMMKV.getDefault().decodeBool("clicfg_detect_syncbarrier_leak", false)) {
            Log.i("MatrixDelegate", "SyncBarrierWatchDogPlus start");
            com.tencent.matrix.h.a.TR();
        }
    }

    static /* synthetic */ void eh(String str) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putExtra(str, true);
        MMApplicationContext.getContext();
        e.j(intent);
        MMApplicationContext.getContext().sendBroadcast(intent, MatrixStrategyNotifyBroadcast.dag);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: android.content.Intent */
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void a(d dVar) {
        com.tencent.matrix.g.c.i("MatrixDelegate", "schedule to check", new Object[0]);
        if (!b.isInstalled()) {
            com.tencent.matrix.g.c.i("MatrixDelegate", "matrix not installed", new Object[0]);
        } else if (dVar.cPM != null) {
            HashMap hashMap = new HashMap();
            Iterator<com.tencent.matrix.e.b> it = b.RG().cqP.iterator();
            while (it.hasNext()) {
                com.tencent.matrix.e.b next = it.next();
                if (next instanceof com.tencent.matrix.trace.a) {
                    hashMap.put("Trace_FPS", Boolean.valueOf(MrsLogic.isNeed2Report("Trace_FPS")));
                    hashMap.put("Trace_EvilMethod", Boolean.valueOf(MrsLogic.isNeed2Report("Trace_EvilMethod")));
                    hashMap.put("Trace_StartUp", Boolean.valueOf(MrsLogic.isNeed2Report("Trace_StartUp")));
                } else {
                    hashMap.put(next.getTag(), Boolean.valueOf(MrsLogic.isNeed2Report(next.getTag())));
                }
            }
            if (hashMap.size() > 0) {
                com.tencent.matrix.g.c.i("MatrixDelegate", "onStatusChange, map:%s", hashMap);
                if (dVar.cPM != null) {
                    dVar.cPM.p(hashMap);
                    Intent intent = new Intent();
                    intent.setAction("statusNotify");
                    ArrayList<String> arrayList = new ArrayList<>(hashMap.size());
                    ArrayList arrayList2 = new ArrayList(hashMap.size());
                    intent.putStringArrayListExtra("StatusChangeKey", arrayList);
                    intent.putIntegerArrayListExtra("StatusChangeValue", arrayList2);
                    for (Map.Entry entry : hashMap.entrySet()) {
                        arrayList.add(entry.getKey());
                        arrayList2.add(Integer.valueOf(((Boolean) entry.getValue()).booleanValue() ? 1 : 0));
                    }
                    MMApplicationContext.getContext().sendBroadcast(intent, MatrixStrategyNotifyBroadcast.dag);
                }
            }
        }
    }
}
