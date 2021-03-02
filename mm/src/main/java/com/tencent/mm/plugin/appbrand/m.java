package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.bs;
import com.tencent.mm.plugin.appbrand.report.o;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.report.quality.j;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.service.y;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.utils.k;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.expansions.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.toolkit.frontia.a.c;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.e;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.xweb.WebView;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.x;

/* access modifiers changed from: package-private */
public final class m extends AppBrandRuntime.b {
    private volatile a kBA;
    volatile ag kBB;
    volatile c kBC;
    private final AtomicBoolean kBD = new AtomicBoolean(false);
    private final AtomicBoolean kBE = new AtomicBoolean(false);
    e<c> kBF;
    e<ag> kBG;
    final q kBw;
    private final k kBx;
    volatile boolean kBy = false;
    private volatile boolean kBz = false;

    m(q qVar) {
        AppMethodBeat.i(43832);
        this.kBw = qVar;
        this.kBx = new k(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(43799);
                if (!m.this.kBy) {
                    if (m.this.kBB == null) {
                        try {
                            b.aeU(m.this.kBw.mAppId).nLA = j.CreateOnRuntimeInit;
                        } catch (Exception e2) {
                        }
                    }
                    m.this.n("countDown == 0, notify process ready", new Object[0]);
                    m.this.KY();
                }
                AppMethodBeat.o(43799);
            }
        }, 2);
        AppMethodBeat.o(43832);
    }

    /* access modifiers changed from: package-private */
    public final void brQ() {
        AppMethodBeat.i(174647);
        if (!this.kBE.getAndSet(true)) {
            this.kBx.countDown();
        }
        AppMethodBeat.o(174647);
    }

    /* access modifiers changed from: package-private */
    public final void brR() {
        AppMethodBeat.i(174648);
        if (!this.kBD.getAndSet(true)) {
            this.kBx.countDown();
        }
        AppMethodBeat.o(174648);
    }

    /* access modifiers changed from: package-private */
    public final void n(String str, Object... objArr) {
        AppMethodBeat.i(43833);
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", brS() + str, objArr);
        AppMethodBeat.o(43833);
    }

    /* access modifiers changed from: package-private */
    public final void o(String str, Object... objArr) {
        AppMethodBeat.i(43834);
        Log.e("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", brS() + str, objArr);
        AppMethodBeat.o(43834);
    }

    private String brS() {
        AppMethodBeat.i(43835);
        String format = String.format(Locale.US, "Runtime[%s %d %s]~~%d~~ ", this.kBw.mAppId, Integer.valueOf(this.kBw.kAq.eix), g.iD(this.kBw.NA()).name(), Integer.valueOf(hashCode()));
        AppMethodBeat.o(43835);
        return format;
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime.b
    public final void interrupt() {
        AppMethodBeat.i(43836);
        o("interrupt()", new Object[0]);
        this.kBy = true;
        c brT = brT();
        if (brT != null) {
            try {
                brT.cleanup();
            } catch (Throwable th) {
                o("interrupt() cleanup service e=%s", th);
            }
        }
        if (this.kBF != null) {
            this.kBF.Dv(true);
        }
        ag brU = brU();
        if (brU != null) {
            try {
                brU.cleanup();
            } catch (Throwable th2) {
                o("interrupt() cleanup page e=%s", th2);
            }
        }
        if (this.kBG != null) {
            this.kBG.Dv(true);
        }
        AppMethodBeat.o(43836);
    }

    /* access modifiers changed from: package-private */
    public final c brT() {
        c cVar = this.kBC;
        this.kBC = null;
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public final ag brU() {
        ag agVar = this.kBB;
        this.kBB = null;
        return agVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime.b
    public final void prepare() {
        AppMethodBeat.i(43837);
        final k kVar = new k(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass12 */

            public final void run() {
                String str;
                String str2 = null;
                AppMethodBeat.i(43818);
                if (!m.this.kBy) {
                    m mVar = m.this;
                    if (mVar.kBw.OQ()) {
                        mVar.n("service countDown by remoteDebug", new Object[0]);
                        mVar.kBF = null;
                        mVar.brQ();
                    } else {
                        if (mVar.kBw.ON().cyA.scene == 1030 && DebuggerShell.bAx()) {
                            String cU = com.tencent.mm.plugin.appbrand.debugger.e.cU(mVar.kBw.mAppId, "Needjs");
                            if (!TextUtils.isEmpty(cU) && s.YS(cU)) {
                                try {
                                    str = s.boY(cU);
                                } catch (IOException e2) {
                                    Log.e("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", "beforeEvaluateScriptFile, try read WAAutoService.js, exception=%s", e2);
                                    str = null;
                                }
                                if (!TextUtils.isEmpty(str)) {
                                    mVar.kBF = (e) mVar.Ug("preloadMonkeyTestAppService").h(new com.tencent.mm.vending.c.a<c, Void>(str) {
                                        /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass21 */
                                        final /* synthetic */ String kBL;

                                        {
                                            this.kBL = r2;
                                        }

                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                        @Override // com.tencent.mm.vending.c.a
                                        public final /* synthetic */ c call(Void r5) {
                                            AppMethodBeat.i(43825);
                                            final com.tencent.mm.vending.g.b hdH = com.tencent.mm.vending.g.g.hdH();
                                            h.RTc.aZ(new Runnable() {
                                                /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass21.AnonymousClass1 */

                                                public final void run() {
                                                    AppMethodBeat.i(43823);
                                                    y yVar = new y(AnonymousClass21.this.kBL);
                                                    yVar.a(m.this.kBw.bqZ());
                                                    yVar.YU();
                                                    hdH.G(yVar);
                                                    AppMethodBeat.o(43823);
                                                }
                                            });
                                            AppMethodBeat.o(43825);
                                            return null;
                                        }
                                    }).a(d.LOGIC, new d.b<c>() {
                                        /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass20 */

                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                        @Override // com.tencent.mm.vending.g.d.b
                                        public final /* synthetic */ void bz(c cVar) {
                                            AppMethodBeat.i(43822);
                                            c cVar2 = cVar;
                                            m.this.kBC = cVar2;
                                            m.this.kBw.c(cVar2);
                                            m.this.n("preloadMonkeyTestAppService onTerminate", new Object[0]);
                                            m.this.brQ();
                                            AppMethodBeat.o(43822);
                                        }
                                    }).a(com.tencent.mm.vending.h.d.LOGIC, new d.a<Object>() {
                                        /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass19 */

                                        @Override // com.tencent.mm.vending.g.d.a
                                        public final void cn(Object obj) {
                                            AppMethodBeat.i(43821);
                                            m.this.kBC = null;
                                            m.this.o("preloadMonkeyTestAppService onInterrupt", new Object[0]);
                                            m.this.brQ();
                                            AppMethodBeat.o(43821);
                                        }
                                    });
                                }
                            }
                        }
                        mVar.kBF = (e) mVar.Ug("preloadAppService").h(new com.tencent.mm.vending.c.a<Boolean, Void>() {
                            /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass3 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.vending.c.a
                            public final /* synthetic */ Boolean call(Void r7) {
                                AppMethodBeat.i(TbsConfig.TBS_SDK_VERSIONCODE);
                                final com.tencent.mm.vending.g.b hdH = com.tencent.mm.vending.g.g.hdH();
                                boolean a2 = com.tencent.mm.plugin.appbrand.task.e.a(g.iD(m.this.kBw.NA()), new e.b() {
                                    /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass3.AnonymousClass1 */

                                    @Override // com.tencent.mm.plugin.appbrand.task.e.b
                                    public final void onReady() {
                                        AppMethodBeat.i(226136);
                                        hdH.G(Boolean.TRUE);
                                        AppMethodBeat.o(226136);
                                    }
                                }, "AppBrandRuntimeBoostStrategy.preloadAppService");
                                if (!a2) {
                                    hdH.G(Boolean.FALSE);
                                } else {
                                    com.tencent.mm.plugin.appbrand.keylogger.c.a(m.this.kBw.mAppId, KSProcessWeAppLaunch.stepWaitForAppServicePreloadDone);
                                }
                                Boolean valueOf = Boolean.valueOf(a2);
                                AppMethodBeat.o(TbsConfig.TBS_SDK_VERSIONCODE);
                                return valueOf;
                            }
                        }).g(new com.tencent.mm.vending.c.a<c, Boolean>() {
                            /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass2 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.vending.c.a
                            public final /* synthetic */ c call(Boolean bool) {
                                AppMethodBeat.i(43805);
                                c e2 = e(bool);
                                AppMethodBeat.o(43805);
                                return e2;
                            }

                            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0050, code lost:
                                if (r4 == null) goto L_0x0152;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
                                if (r15.booleanValue() != false) goto L_0x0063;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
                                com.tencent.mm.plugin.appbrand.keylogger.c.a(r14.kBH.kBw.mAppId, com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch.stepWaitForAppServicePreloadDone);
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:17:0x006b, code lost:
                                if (r14.kBH.kBw.bqZ() != null) goto L_0x0095;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:18:0x006d, code lost:
                                com.tencent.mm.vending.g.g.hdx().ej(new java.lang.RuntimeException("Runtime.getLibReader() == NULL"));
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
                                r4.cleanup();
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a5, code lost:
                                if (r4.bqZ().compareTo(r14.kBH.kBw.bqZ()) != 0) goto L_0x0137;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a7, code lost:
                                r0 = true;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
                                r14.kBH.n("preloadAppService, process preloaded, hasWait[%b] commLibMatched[%b]", r15, java.lang.Boolean.valueOf(r0));
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:30:0x00bb, code lost:
                                if (r0 == false) goto L_0x0152;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bd, code lost:
                                r3 = com.tencent.mm.plugin.appbrand.task.e.g(r5);
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c1, code lost:
                                if (r3 == null) goto L_0x011e;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c3, code lost:
                                com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
                                r5 = new com.tencent.mm.g.b.a.mw();
                                r0 = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(r6);
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:34:0x00cf, code lost:
                                if (r0 == null) goto L_0x011e;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d1, code lost:
                                r5.eJx = r5.x("AppId", r0.appId, true);
                                r5.eWb = r5.x("InstanceId", r0.kEY, true);
                                r5.ffa = com.tencent.mm.g.b.a.mw.a.mI(r0.nJE);
                                r5.eYW = (long) r0.apptype;
                                r5.eXc = (long) r0.nLk;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:36:0x00fd, code lost:
                                if (r3.endTime == com.tencent.mm.sdk.platformtools.MAlarmHandler.NEXT_FIRE_INTERVAL) goto L_0x0105;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:38:0x0103, code lost:
                                if (r3.nOC != com.tencent.mm.sdk.platformtools.MAlarmHandler.NEXT_FIRE_INTERVAL) goto L_0x013a;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:39:0x0105, code lost:
                                r0 = 0;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:40:0x0107, code lost:
                                r5.xj(r0);
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:41:0x010e, code lost:
                                if (r3.nOF == com.tencent.mm.sdk.platformtools.MAlarmHandler.NEXT_FIRE_INTERVAL) goto L_0x0116;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:43:0x0114, code lost:
                                if (r3.endTime != com.tencent.mm.sdk.platformtools.MAlarmHandler.NEXT_FIRE_INTERVAL) goto L_0x0140;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:44:0x0116, code lost:
                                r0 = 0;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:45:0x0118, code lost:
                                r5.xk(r0);
                                r5.bfK();
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
                                com.tencent.mm.plugin.appbrand.report.quality.b.aeU(r6).nLz = com.tencent.mm.plugin.appbrand.report.quality.j.PreloadOnProcessCreated;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:49:0x0137, code lost:
                                r0 = false;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:50:0x013a, code lost:
                                r0 = r3.endTime - r3.nOC;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:51:0x0140, code lost:
                                r0 = r3.endTime - r3.nOF;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:53:0x0147, code lost:
                                r14.kBH.o("preloadAppService, wait process preload done but get NULL session", new java.lang.Object[0]);
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:54:0x0152, code lost:
                                com.tencent.mm.plugin.appbrand.keylogger.c.a(r14.kBH.kBw.mAppId, com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch.stepWaitForAppServiceAheadPreloadDone);
                                r0 = com.tencent.mm.vending.g.g.hdH();
                                r14.kBH.n("preloadAppService ahead preload START", new java.lang.Object[0]);
                                r14.kBH.kBw.Q(new com.tencent.mm.plugin.appbrand.m.AnonymousClass2.AnonymousClass1(r14));
                                com.tencent.matrix.trace.core.AppMethodBeat.o(226135);
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
                                return null;
                             */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            private com.tencent.mm.plugin.appbrand.service.c e(java.lang.Boolean r15) {
                                /*
                                // Method dump skipped, instructions count: 387
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.m.AnonymousClass2.e(java.lang.Boolean):com.tencent.mm.plugin.appbrand.service.c");
                            }
                        }).a(com.tencent.mm.vending.h.d.LOGIC, new d.b<c>() {
                            /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass23 */

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.vending.g.d.b
                            public final /* synthetic */ void bz(c cVar) {
                                AppMethodBeat.i(226161);
                                c cVar2 = cVar;
                                m.this.kBw.c(cVar2);
                                m.this.kBC = cVar2;
                                m.this.n("service countDown", new Object[0]);
                                m.this.brQ();
                                AppMethodBeat.o(226161);
                            }
                        }).a(com.tencent.mm.vending.h.d.LOGIC, new d.a() {
                            /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass22 */

                            @Override // com.tencent.mm.vending.g.d.a
                            public final void cn(Object obj) {
                                AppMethodBeat.i(226160);
                                m.this.kBC = null;
                                m.this.o("service countDown by pipeline interrupted:%s", obj);
                                m.this.brQ();
                                AppMethodBeat.o(226160);
                            }
                        });
                    }
                    if (mVar.kBw.NA()) {
                        mVar.n("tryPreloadPageView ignore for game, countdown", new Object[0]);
                        mVar.kBG = null;
                        mVar.brR();
                    } else {
                        if (mVar.kBw.ON().cyA.scene == 1030 && DebuggerShell.bAx()) {
                            String cU2 = com.tencent.mm.plugin.appbrand.debugger.e.cU(mVar.kBw.mAppId, "Needwebviewjs");
                            if (!TextUtils.isEmpty(cU2) && s.YS(cU2)) {
                                try {
                                    str2 = s.boY(cU2);
                                } catch (IOException e3) {
                                    Log.e("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", "beforeEvaluateScriptFile, try read WAAutoWebView.js, exception=%s", e3);
                                }
                                if (!TextUtils.isEmpty(str2)) {
                                    mVar.kBG = mVar.Ug("tryPreloadMonkeyTestAppPageView").h(new com.tencent.mm.vending.c.a<Boolean, Void>() {
                                        /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass5 */

                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                        @Override // com.tencent.mm.vending.c.a
                                        public final /* synthetic */ Boolean call(Void r3) {
                                            AppMethodBeat.i(226139);
                                            com.tencent.mm.vending.g.g.a(m.a(m.this));
                                            Boolean bool = Boolean.FALSE;
                                            AppMethodBeat.o(226139);
                                            return bool;
                                        }
                                    }).b(new com.tencent.mm.vending.c.a<ag, Boolean>(str2) {
                                        /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass4 */
                                        final /* synthetic */ String kBL;

                                        {
                                            this.kBL = r2;
                                        }

                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                        @Override // com.tencent.mm.vending.c.a
                                        public final /* synthetic */ ag call(Boolean bool) {
                                            AppMethodBeat.i(226138);
                                            ag brV = brV();
                                            AppMethodBeat.o(226138);
                                            return brV;
                                        }

                                        private ag brV() {
                                            AppMethodBeat.i(226137);
                                            bs bsVar = new bs(this.kBL);
                                            bsVar.a(m.this.kBw.bqZ());
                                            bsVar.YU();
                                            try {
                                                b.aeU(m.this.kBw.mAppId).nLA = j.PreloadBeforeRuntimeInit;
                                            } catch (Exception e2) {
                                                m.this.o("doAheadPreloadPageView DONE but get NULL session", new Object[0]);
                                            }
                                            AppMethodBeat.o(226137);
                                            return bsVar;
                                        }
                                    });
                                }
                            }
                        }
                        mVar.kBG = mVar.Ug("tryPreloadPageView").h(new com.tencent.mm.vending.c.a<Boolean, Void>() {
                            /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass7 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.vending.c.a
                            public final /* synthetic */ Boolean call(Void r3) {
                                AppMethodBeat.i(43815);
                                com.tencent.mm.vending.g.g.a(m.a(m.this));
                                Boolean bool = Boolean.FALSE;
                                AppMethodBeat.o(43815);
                                return bool;
                            }
                        }).g(new com.tencent.mm.vending.c.a<ag, Boolean>() {
                            /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass6 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.vending.c.a
                            public final /* synthetic */ ag call(Boolean bool) {
                                f<_Ret> g2;
                                AppMethodBeat.i(43813);
                                m mVar = m.this;
                                if (mVar.kBy) {
                                    mVar.o("tryGetProcessPreloadedPageView EXPIRED return null", new Object[0]);
                                    g2 = null;
                                } else {
                                    mVar.n("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", "tryGetProcessPreloadedPageView, entered");
                                    g2 = mVar.Ug("tryGetProcessPreloadedPageView").h(new com.tencent.mm.vending.c.a<Boolean, Void>() {
                                        /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass14 */

                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                        @Override // com.tencent.mm.vending.c.a
                                        public final /* synthetic */ Boolean call(Void r7) {
                                            AppMethodBeat.i(226154);
                                            final com.tencent.mm.vending.g.b hdH = com.tencent.mm.vending.g.g.hdH();
                                            boolean a2 = com.tencent.mm.plugin.appbrand.task.e.a(g.WASERVICE, new e.b() {
                                                /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass14.AnonymousClass1 */

                                                @Override // com.tencent.mm.plugin.appbrand.task.e.b
                                                public final void onReady() {
                                                    AppMethodBeat.i(226153);
                                                    hdH.G(Boolean.TRUE);
                                                    AppMethodBeat.o(226153);
                                                }
                                            }, "AppBrandRuntimeBoostStrategy.tryGetProcessPreloadedPageView");
                                            if (!a2) {
                                                hdH.G(Boolean.FALSE);
                                            } else {
                                                com.tencent.mm.plugin.appbrand.keylogger.c.a(m.this.kBw.mAppId, KSProcessWeAppLaunch.stepWaitForWebViewPreloadDone);
                                            }
                                            Boolean valueOf = Boolean.valueOf(a2);
                                            AppMethodBeat.o(226154);
                                            return valueOf;
                                        }
                                    }).g(new com.tencent.mm.vending.c.a<ag, Boolean>(mVar.kBw.mAppId) {
                                        /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass13 */
                                        final /* synthetic */ String val$appId;

                                        {
                                            this.val$appId = r2;
                                        }

                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                        @Override // com.tencent.mm.vending.c.a
                                        public final /* synthetic */ ag call(Boolean bool) {
                                            AppMethodBeat.i(226152);
                                            ag f2 = f(bool);
                                            AppMethodBeat.o(226152);
                                            return f2;
                                        }

                                        private ag f(Boolean bool) {
                                            boolean z;
                                            AppMethodBeat.i(226151);
                                            if (m.this.kBy) {
                                                m.this.o("tryGetProcessPreloadedPageView process EXPIRED, hasWaited[%b]", bool);
                                                AppMethodBeat.o(226151);
                                                return null;
                                            }
                                            ag i2 = com.tencent.mm.plugin.appbrand.task.e.i(g.WASERVICE);
                                            m mVar = m.this;
                                            Object[] objArr = new Object[2];
                                            objArr[0] = bool;
                                            if (i2 != null) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                            objArr[1] = Boolean.valueOf(z);
                                            mVar.n("tryGetProcessPreloadedPageView hasWaited[%b] loaded[%b]", objArr);
                                            if (i2 != null) {
                                                if (!bool.booleanValue()) {
                                                    com.tencent.mm.plugin.appbrand.keylogger.c.a(m.this.kBw.mAppId, KSProcessWeAppLaunch.stepWaitForWebViewPreloadDone);
                                                }
                                                if (m.this.kBw.bqZ() == null) {
                                                    com.tencent.mm.vending.g.g.hdx().ej(new RuntimeException("Runtime.getLibReader() == NULL"));
                                                    i2.cleanup();
                                                    AppMethodBeat.o(226151);
                                                    return null;
                                                }
                                                boolean z2 = i2.bqZ().compareTo(m.this.kBw.bqZ()) == 0;
                                                m.this.n("tryGetProcessPreloadedPageView process preloaded, hasWaited[%b] commLibMatched[%b]", bool, Boolean.valueOf(z2));
                                                if (!z2) {
                                                    i2.cleanup();
                                                    com.tencent.mm.plugin.appbrand.keylogger.c.c(m.this.kBw.mAppId, KSProcessWeAppLaunch.stepWaitForWebViewPreloadDone);
                                                    AppMethodBeat.o(226151);
                                                    return null;
                                                }
                                                com.tencent.mm.plugin.appbrand.keylogger.c.b(m.this.kBw.mAppId, KSProcessWeAppLaunch.stepWaitForWebViewPreloadDone);
                                                try {
                                                    b.aeU(this.val$appId).nLA = j.PreloadOnProcessCreated;
                                                } catch (Exception e2) {
                                                    m.this.o("tryGetProcessPreloadedPageView process preloaded but get NULL session", new Object[0]);
                                                }
                                                AppMethodBeat.o(226151);
                                                return i2;
                                            }
                                            AppMethodBeat.o(226151);
                                            return null;
                                        }
                                    });
                                }
                                if (g2 != null) {
                                    com.tencent.mm.vending.g.g.a(g2);
                                }
                                AppMethodBeat.o(43813);
                                return null;
                            }
                        });
                    }
                    if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_preload_webview_before_runtime_init, 0) > 0) {
                        try {
                            mVar.a(a.X_CONFIG);
                            AppMethodBeat.o(43818);
                            return;
                        } catch (e.c e4) {
                            Log.printErrStackTrace("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", e4, "tryPreloadBeforeResourceDone(PreloadReason.X_CONFIG)", new Object[0]);
                        }
                    }
                }
                AppMethodBeat.o(43818);
            }
        }, 2);
        com.tencent.mm.plugin.appbrand.keylogger.c.a(this.kBw.mAppId, KSProcessWeAppLaunch.stepInstallLibraries);
        com.tencent.mm.plugin.expansions.a.a(new a.b() {
            /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass17 */

            @Override // com.tencent.mm.plugin.expansions.a.b
            public final void a(c.a aVar) {
                AppMethodBeat.i(43819);
                kVar.countDown();
                com.tencent.mm.plugin.appbrand.keylogger.c.b(m.this.kBw.mAppId, KSProcessWeAppLaunch.stepInstallLibraries);
                AppMethodBeat.o(43819);
            }
        });
        com.tencent.mm.plugin.appbrand.launching.g.a(this.kBw, new kotlin.g.a.b<ICommLibReader, x>() {
            /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass18 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(ICommLibReader iCommLibReader) {
                AppMethodBeat.i(43820);
                kVar.countDown();
                x xVar = x.SXb;
                AppMethodBeat.o(43820);
                return xVar;
            }
        });
        AppMethodBeat.o(43837);
    }

    /* access modifiers changed from: package-private */
    public final void a(final a aVar) {
        AppMethodBeat.i(43838);
        if (this.kBG == null || this.kBy) {
            n("tryPreloadBeforeResourceDone mPageViewPipeline null || mProcessExpired", new Object[0]);
            AppMethodBeat.o(43838);
        } else if (this.kBz) {
            n("tryPreloadBeforeResourceDone function already appended by reason[%s]", this.kBA);
            AppMethodBeat.o(43838);
        } else {
            n("tryPreloadBeforeResourceDone tryDoAheadPreloadPageView by reason[%s]", aVar);
            this.kBz = true;
            this.kBA = aVar;
            if (this.kBG.QZR) {
                n("mPageViewPipeline has stopped", new Object[0]);
                AppMethodBeat.o(43838);
                return;
            }
            this.kBG.c(new com.tencent.mm.vending.c.a<ag, ag>() {
                /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass9 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ ag call(ag agVar) {
                    AppMethodBeat.i(226148);
                    ag agVar2 = agVar;
                    if (agVar2 != null) {
                        AppMethodBeat.o(226148);
                        return agVar2;
                    }
                    if (!m.this.kBy) {
                        final com.tencent.mm.vending.g.b hdH = com.tencent.mm.vending.g.g.hdH();
                        AnonymousClass1 r1 = new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass9.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(226147);
                                if (m.this.kBy) {
                                    hdH.G(null);
                                    m.this.o("before doAheadPreloadPageView INTERRUPTED by runtime destroyed", new Object[0]);
                                    AppMethodBeat.o(226147);
                                    return;
                                }
                                m mVar = m.this;
                                mVar.n("doAheadPreloadPageView START", new Object[0]);
                                String str = mVar.kBw.mAppId;
                                com.tencent.mm.plugin.appbrand.keylogger.c.a(str, KSProcessWeAppLaunch.stepWaitForWebViewAheadPreloadDone);
                                mVar.Ug("doAheadPreloadPageView").b(new com.tencent.mm.vending.c.a<ag, Void>(str) {
                                    /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass15 */
                                    final /* synthetic */ String val$appId;

                                    {
                                        this.val$appId = r2;
                                    }

                                    /* Return type fixed from 'java.lang.Object' to match base method */
                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                    @Override // com.tencent.mm.vending.c.a
                                    public final /* synthetic */ ag call(Void r3) {
                                        AppMethodBeat.i(226156);
                                        ag brZ = brZ();
                                        AppMethodBeat.o(226156);
                                        return brZ;
                                    }

                                    private ag brZ() {
                                        ag agVar = null;
                                        AppMethodBeat.i(226155);
                                        if (com.tencent.mm.plugin.appbrand.task.e.bVR()) {
                                            m.this.n("doAheadPreloadPageView INTERRUPTED by kernel(%s)", WebView.getCurWebType().name());
                                            com.tencent.mm.plugin.appbrand.keylogger.c.c(this.val$appId, KSProcessWeAppLaunch.stepWaitForWebViewAheadPreloadDone);
                                            AppMethodBeat.o(226155);
                                        } else if (m.this.kBy) {
                                            m.this.o("doAheadPreloadPageView INTERRUPTED by runtime destroyed", new Object[0]);
                                            AppMethodBeat.o(226155);
                                        } else {
                                            ICommLibReader bqZ = m.this.kBw.bqZ();
                                            if (bqZ == null) {
                                                m.this.o("doAheadPreloadPageView get NULL LibReader from Runtime, WTF", new Object[0]);
                                                AppMethodBeat.o(226155);
                                            } else {
                                                agVar = new ag();
                                                agVar.a(bqZ);
                                                agVar.YU();
                                                try {
                                                    com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.val$appId).nLA = j.PreloadBeforeRuntimeInit;
                                                } catch (Exception e2) {
                                                    m.this.o("doAheadPreloadPageView DONE but get NULL session", new Object[0]);
                                                }
                                                m.this.n("doAheadPreloadPageView DONE", new Object[0]);
                                                com.tencent.mm.plugin.appbrand.keylogger.c.b(this.val$appId, KSProcessWeAppLaunch.stepWaitForWebViewAheadPreloadDone);
                                                AppMethodBeat.o(226155);
                                            }
                                        }
                                        return agVar;
                                    }
                                }).a(new d.b<ag>() {
                                    /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass9.AnonymousClass1.AnonymousClass2 */

                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                    @Override // com.tencent.mm.vending.g.d.b
                                    public final /* synthetic */ void bz(ag agVar) {
                                        AppMethodBeat.i(226146);
                                        hdH.G(agVar);
                                        AppMethodBeat.o(226146);
                                    }
                                }).a(new d.a() {
                                    /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass9.AnonymousClass1.AnonymousClass1 */

                                    @Override // com.tencent.mm.vending.g.d.a
                                    public final void cn(Object obj) {
                                        AppMethodBeat.i(226145);
                                        hdH.G(null);
                                        AppMethodBeat.o(226145);
                                    }
                                });
                                AppMethodBeat.o(226147);
                            }
                        };
                        if (aVar == a.X_CONFIG) {
                            m.this.kBw.i(r1, 0);
                        } else {
                            m.this.kBw.kAt.af(r1);
                        }
                    }
                    AppMethodBeat.o(226148);
                    return null;
                }
            });
            AppMethodBeat.o(43838);
        }
    }

    /* access modifiers changed from: package-private */
    public final f<Void> Ug(final String str) {
        AppMethodBeat.i(226162);
        f<Void> L = new f<Void>() {
            /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass16 */

            @Override // com.tencent.mm.co.f, com.tencent.mm.vending.g.c, com.tencent.mm.vending.g.e
            public final /* synthetic */ com.tencent.mm.vending.g.c b(com.tencent.mm.vending.e.b bVar) {
                AppMethodBeat.i(226159);
                f<Void> a2 = a(bVar);
                AppMethodBeat.o(226159);
                return a2;
            }

            @Override // com.tencent.mm.co.f
            public final f<Void> a(com.tencent.mm.vending.e.b bVar) {
                AppMethodBeat.i(226158);
                bVar.keep(new com.tencent.mm.vending.e.a() {
                    /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass16.AnonymousClass1 */

                    @Override // com.tencent.mm.vending.e.a
                    public final void dead() {
                        AppMethodBeat.i(226157);
                        m.this.n("pipeline(%s) will be stopped", str);
                        AppMethodBeat.o(226157);
                    }
                });
                f<Void> a2 = super.a(bVar);
                AppMethodBeat.o(226158);
                return a2;
            }
        }.a(this.kBw).L(new Object[0]);
        AppMethodBeat.o(226162);
        return L;
    }

    public enum a {
        SYNC_LAUNCH,
        SYNC_GET_CODE,
        SYNC_JSAPIINFO,
        X_CONFIG;

        public static a valueOf(String str) {
            AppMethodBeat.i(43830);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43830);
            return aVar;
        }

        static {
            AppMethodBeat.i(43831);
            AppMethodBeat.o(43831);
        }
    }

    static /* synthetic */ com.tencent.mm.vending.g.e a(m mVar) {
        AppMethodBeat.i(226163);
        f<_Ret> h2 = mVar.Ug("ensureXWebPreLoaded").h(new com.tencent.mm.vending.c.a<Boolean, Void>() {
            /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass8 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Boolean call(Void r8) {
                AppMethodBeat.i(43817);
                boolean btj = y.btj();
                m.this.n("ensureXWebPreLoaded xwebLoaded %b", Boolean.valueOf(btj));
                if (btj) {
                    Boolean bool = Boolean.TRUE;
                    AppMethodBeat.o(43817);
                    return bool;
                }
                final com.tencent.mm.vending.g.b hdH = com.tencent.mm.vending.g.g.hdH();
                com.tencent.mm.plugin.appbrand.keylogger.c.a(m.this.kBw.mAppId, KSProcessWeAppLaunch.stepPrepareWebView);
                final long currentTimeMillis = System.currentTimeMillis();
                m.this.kBw.Q(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass8.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(226143);
                        y.a(new y.a() {
                            /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass8.AnonymousClass1.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.appbrand.y.a
                            public final void brW() {
                                AppMethodBeat.i(226140);
                                com.tencent.mm.plugin.appbrand.keylogger.c.b(m.this.kBw.mAppId, KSProcessWeAppLaunch.stepPrepareWebView);
                                brY();
                                AppMethodBeat.o(226140);
                            }

                            @Override // com.tencent.mm.plugin.appbrand.y.a
                            public final void brX() {
                                AppMethodBeat.i(226141);
                                com.tencent.mm.plugin.appbrand.keylogger.c.c(m.this.kBw.mAppId, KSProcessWeAppLaunch.stepPrepareWebView);
                                brY();
                                AppMethodBeat.o(226141);
                            }

                            private void brY() {
                                AppMethodBeat.i(226142);
                                m.this.n("reportXWebPreInit mProcessExpired[%b]", Boolean.valueOf(m.this.kBy));
                                if (m.this.kBy) {
                                    AppMethodBeat.o(226142);
                                    return;
                                }
                                hdH.resume();
                                try {
                                    com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
                                    com.tencent.mm.plugin.appbrand.report.quality.c.a(false, m.this.kBw.mAppId, currentTimeMillis, o.bUx());
                                    m.this.kBw.kDk.I(2, System.currentTimeMillis() - currentTimeMillis);
                                    com.tencent.mm.plugin.appbrand.performance.c.b(m.this.kBw.mAppId, "X5Prepare", currentTimeMillis, System.currentTimeMillis());
                                    AppMethodBeat.o(226142);
                                } catch (Throwable th) {
                                    m.this.o("reportXWebPreInit exception stack %s", android.util.Log.getStackTraceString(th));
                                    AppMethodBeat.o(226142);
                                }
                            }
                        });
                        AppMethodBeat.o(226143);
                    }
                });
                m.this.kBw.i(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.m.AnonymousClass8.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(226144);
                        if (!m.this.kBw.SO && !m.this.kBw.isDestroyed()) {
                            Class[] clsArr = {com.tencent.mm.plugin.appbrand.widget.actionbar.b.class, com.tencent.mm.plugin.appbrand.widget.actionbar.d.class, com.tencent.mm.plugin.appbrand.widget.tabbar.a.class};
                            for (int i2 = 0; i2 < 3; i2++) {
                                m.this.kBw.bsn().aD(clsArr[i2]);
                            }
                        }
                        AppMethodBeat.o(226144);
                    }
                }, 0);
                Boolean bool2 = Boolean.FALSE;
                AppMethodBeat.o(43817);
                return bool2;
            }
        });
        AppMethodBeat.o(226163);
        return h2;
    }
}
