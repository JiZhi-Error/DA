package com.tencent.mm.plugin.appbrand.report.quality;

import android.text.TextUtils;
import com.eclipsesource.v8.V8;
import com.tencent.f.h;
import com.tencent.luggage.game.c.h;
import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.g.b.a.mc;
import com.tencent.mm.g.b.a.md;
import com.tencent.mm.g.b.a.me;
import com.tencent.mm.g.b.a.mg;
import com.tencent.mm.g.b.a.mh;
import com.tencent.mm.g.b.a.mi;
import com.tencent.mm.g.b.a.mq;
import com.tencent.mm.g.b.a.mx;
import com.tencent.mm.g.b.a.na;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.quality.f;
import com.tencent.mm.plugin.appbrand.report.t;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class b {
    static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());
    private static final c nKo = new c();
    private static final HashMap<String, QualitySessionRuntime> nKp = new HashMap<>();
    private static final a nKq = new a();

    public static class a {
        boolean nKv = false;
    }

    static {
        AppMethodBeat.i(48198);
        AppMethodBeat.o(48198);
    }

    public static void H(final q qVar) {
        long j2;
        QualitySessionRuntime qualitySessionRuntime;
        AppMethodBeat.i(48189);
        Log.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] startSession appId = [%s] runtime.hashCode = [%d]", qVar.mAppId, Integer.valueOf(qVar.hashCode()));
        QualitySession qualitySession = qVar.bsC().ldW;
        if (qualitySession == null) {
            Log.e("MicroMsg.AppBrandQualitySystem", "startSession with NULL qualityReportSession in InitConfig");
            qualitySession = new QualitySession(com.tencent.mm.plugin.appbrand.utils.b.zF(qVar.bsC().uin), qVar.bsC(), qVar.ON().cyA);
            qVar.bsC().ldW = qualitySession;
        }
        final QualitySessionRuntime g2 = g.g(qualitySession);
        g2.kGW = qVar;
        g2.cuy = qVar.NA();
        g2.nLo = System.currentTimeMillis();
        a.aeT(g2.kEY);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.report.quality.b.AnonymousClass2 */

            public final void run() {
                int i2;
                AppMethodBeat.i(48185);
                QualitySessionRuntime qualitySessionRuntime = g2;
                h.a aVar = (h.a) c.a("MemoryInspector.getMemoryMB", 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0016: CHECK_CAST (r0v2 'aVar' com.tencent.luggage.game.c.h$a) = (com.tencent.luggage.game.c.h$a) (wrap: java.lang.Object : 0x0012: INVOKE  (r0v1 java.lang.Object) = 
                      ("MemoryInspector.getMemoryMB")
                      (wrap: com.tencent.luggage.game.c.h$1 : 0x000f: CONSTRUCTOR  (r3v0 com.tencent.luggage.game.c.h$1) = 
                      (wrap: com.tencent.luggage.game.c.h : 0x0008: SGET  (r0v0 com.tencent.luggage.game.c.h) =  com.tencent.luggage.game.c.h.cvz com.tencent.luggage.game.c.h)
                     call: com.tencent.luggage.game.c.h.1.<init>(com.tencent.luggage.game.c.h):void type: CONSTRUCTOR)
                     type: STATIC call: com.tencent.luggage.sdk.g.c.a(java.lang.String, kotlin.g.a.a):java.lang.Object) in method: com.tencent.mm.plugin.appbrand.report.quality.b.2.run():void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  (r0v1 java.lang.Object) = 
                      ("MemoryInspector.getMemoryMB")
                      (wrap: com.tencent.luggage.game.c.h$1 : 0x000f: CONSTRUCTOR  (r3v0 com.tencent.luggage.game.c.h$1) = 
                      (wrap: com.tencent.luggage.game.c.h : 0x0008: SGET  (r0v0 com.tencent.luggage.game.c.h) =  com.tencent.luggage.game.c.h.cvz com.tencent.luggage.game.c.h)
                     call: com.tencent.luggage.game.c.h.1.<init>(com.tencent.luggage.game.c.h):void type: CONSTRUCTOR)
                     type: STATIC call: com.tencent.luggage.sdk.g.c.a(java.lang.String, kotlin.g.a.a):java.lang.Object in method: com.tencent.mm.plugin.appbrand.report.quality.b.2.run():void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:290)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 14 more
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: CONSTRUCTOR  (r3v0 com.tencent.luggage.game.c.h$1) = 
                      (wrap: com.tencent.luggage.game.c.h : 0x0008: SGET  (r0v0 com.tencent.luggage.game.c.h) =  com.tencent.luggage.game.c.h.cvz com.tencent.luggage.game.c.h)
                     call: com.tencent.luggage.game.c.h.1.<init>(com.tencent.luggage.game.c.h):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.report.quality.b.2.run():void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 18 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.luggage.game.c.h, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 24 more
                    */
                /*
                    this = this;
                    r4 = 48185(0xbc39, float:6.7522E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                    com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime r1 = r3
                    com.tencent.luggage.game.c.h r0 = com.tencent.luggage.game.c.h.INST
                    java.lang.String r2 = "MemoryInspector.getMemoryMB"
                    com.tencent.luggage.game.c.h$1 r3 = new com.tencent.luggage.game.c.h$1
                    r3.<init>()
                    java.lang.Object r0 = com.tencent.luggage.sdk.g.c.a(r2, r3)
                    com.tencent.luggage.game.c.h$a r0 = (com.tencent.luggage.game.c.h.a) r0
                    if (r0 != 0) goto L_0x0021
                    r0 = 0
                L_0x001b:
                    r1.nLu = r0
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                    return
                L_0x0021:
                    int r0 = r0.cvD
                    goto L_0x001b
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.report.quality.b.AnonymousClass2.run():void");
            }
        });
        if (1 == qVar.bsC().ldX) {
            j2 = 2;
            qualitySessionRuntime = g2;
        } else if (qVar.bsC().ldU) {
            j2 = 0;
            qualitySessionRuntime = g2;
        } else {
            j2 = 1;
            qualitySessionRuntime = g2;
        }
        qualitySessionRuntime.nLC = j2;
        synchronized (nKp) {
            try {
                if ($assertionsDisabled || nKp.get(qVar.mAppId) == null) {
                    nKp.put(g2.appId, g2);
                } else {
                    AssertionError assertionError = new AssertionError();
                    AppMethodBeat.o(48189);
                    throw assertionError;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(48189);
                throw th;
            }
        }
        com.tencent.mm.plugin.appbrand.h.a(qVar.mAppId, new h.c() {
            /* class com.tencent.mm.plugin.appbrand.report.quality.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onDestroy() {
                AppMethodBeat.i(48184);
                Log.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] closeSession appId = [%s] runtime.hashCode = [%d]", qVar.mAppId, Integer.valueOf(qVar.hashCode()));
                b.L(qVar);
                AppMethodBeat.o(48184);
            }
        });
        AppMethodBeat.o(48189);
    }

    public static QualitySessionRuntime aeU(String str) {
        AppMethodBeat.i(48190);
        QualitySessionRuntime aC = aC(str, true);
        AppMethodBeat.o(48190);
        return aC;
    }

    private static QualitySessionRuntime aC(String str, boolean z) {
        QualitySessionRuntime qualitySessionRuntime;
        AppMethodBeat.i(48191);
        synchronized (nKp) {
            try {
                qualitySessionRuntime = nKp.get(str);
            } finally {
                AppMethodBeat.o(48191);
            }
        }
        if (qualitySessionRuntime == null) {
            String format = String.format(Locale.US, "QualitySession not open. appId=%s", str);
            if (!z || (!BuildInfo.DEBUG && !BuildInfo.IS_FLAVOR_RED)) {
                Log.printErrStackTrace("MicroMsg.AppBrandQualitySystem", new Throwable(), format, new Object[0]);
            } else {
                IllegalStateException illegalStateException = new IllegalStateException(format);
                AppMethodBeat.o(48191);
                throw illegalStateException;
            }
        }
        return qualitySessionRuntime;
    }

    public static c bUZ() {
        return nKo;
    }

    public static void a(final String str, final com.tencent.mm.plugin.appbrand.report.b bVar) {
        AppMethodBeat.i(48193);
        m.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.report.quality.b.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(48187);
                QualitySessionRuntime aeU = b.aeU(str);
                if (aeU == null || bVar == null) {
                    Log.i("MicroMsg.AppBrandQualitySystem", "hy: not need do sample");
                } else {
                    if (!(bVar.nGd == null || bVar.nGd.Nza == 0)) {
                        Log.i("MicroMsg.AppBrandQualitySystem", "hy: need do sample, type: %d, sampleInterval: %d", Integer.valueOf(bVar.nGd.Nza), Integer.valueOf(bVar.nGd.Nzb));
                        f.a aVar = null;
                        switch (bVar.nGd.Nza) {
                            case 1:
                                aVar = f.a.Light;
                                break;
                            case 2:
                                aVar = f.a.Full;
                                break;
                            default:
                                Log.e("MicroMsg.AppBrandQualitySystem", "hy: invalid type!!");
                                break;
                        }
                        if (aVar != null) {
                            aeU.nLw.a(aeU, bVar.nGd.Nzb, aVar, true);
                        }
                    }
                    if (bVar.nGf != null && bVar.nGf.NyX) {
                        com.tencent.luggage.game.e.a Nn = com.tencent.luggage.game.e.a.Nn();
                        boolean z = bVar.nGf.NyX;
                        int i2 = bVar.nGf.NyY;
                        double d2 = bVar.nGf.NyZ;
                        try {
                            Log.i("MicroMsg.MBNiReporter", "setConfig shouldDoSample:%b,maxSampleNum:%d,sampleRate:%f", Boolean.valueOf(z), Integer.valueOf(i2), Double.valueOf(d2));
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.MBNiReporter", e2, "setConfig Exception", new Object[0]);
                        }
                        Nn.cxB = z;
                        Nn.cxC = i2;
                        Nn.cxD = d2;
                        AppMethodBeat.o(48187);
                        return;
                    }
                }
                AppMethodBeat.o(48187);
            }
        });
        AppMethodBeat.o(48193);
    }

    public static void a(d dVar, String str, int i2, String str2, int i3, long j2, int i4, m.c cVar) {
        int i5;
        long j3;
        boolean z;
        long j4;
        long j5;
        long j6;
        long j7;
        AppMethodBeat.i(227387);
        String appId = dVar.getAppId();
        QualitySessionRuntime aC = aC(appId, true);
        if (aC == null) {
            AppMethodBeat.o(227387);
            return;
        }
        Log.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject appId = [%s] session.runtime.hashCode = [%d] runtimeHashCode = [%d] name = [%s].", appId, Integer.valueOf(aC.kGW.hashCode()), Integer.valueOf(i4), str);
        if (i4 != aC.kGW.hashCode()) {
            Log.e("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject runtime hashCode mismatch");
            if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                IllegalStateException illegalStateException = new IllegalStateException("[RED_FLAVOR_ONLY] [APPBRAND] onUserScriptInject runtime hashCode mismatch");
                AppMethodBeat.o(227387);
                throw illegalStateException;
            }
            AppMethodBeat.o(227387);
            return;
        }
        mg mgVar = new mg();
        mgVar.eJx = mgVar.x("AppId", aC.appId, true);
        mgVar.eWb = mgVar.x("InstanceId", aC.kEY, true);
        mgVar.fbC = (long) aC.nJE;
        mgVar.eYW = (long) aC.apptype;
        mgVar.eXc = (long) aC.nLk;
        mgVar.erW = (long) aC.scene;
        mgVar.vR(j2);
        mgVar.ajd();
        mgVar.vQ(mgVar.fae - mgVar.fad);
        mgVar.fbD = (long) i2;
        mgVar.fbE = mgVar.x("filePath", str, true);
        e d2 = e.d(dVar.getJsRuntime());
        switch (d2) {
            case WebViewX5:
                i5 = 102;
                break;
            case WebViewXW:
                i5 = 103;
                break;
            case WebViewSystem:
                i5 = 104;
                break;
            case NodeJS:
                i5 = 6;
                break;
            case J2V8:
                i5 = 5;
                break;
            case NativeScript:
                i5 = 4;
                break;
            case WebViewBased:
                i5 = 3;
                break;
            case MMV8:
                i5 = 2;
                break;
            case X5:
                i5 = 1;
                break;
            default:
                i5 = 0;
                break;
        }
        mgVar.fbF = (long) i5;
        if (cVar == null || cVar.codeCacheStatus < 0 || cVar.codeCacheStatus >= v.mNV.length) {
            j3 = 4;
        } else {
            j3 = (long) v.mNV[cVar.codeCacheStatus];
        }
        mgVar.fbG = j3;
        if (dVar instanceof com.tencent.mm.plugin.appbrand.service.c) {
            z = ((com.tencent.mm.plugin.appbrand.service.c) dVar).cBj.Mj();
        } else if (dVar instanceof ag) {
            z = ((ag) dVar).bsE().cBj.Mj();
        } else {
            z = false;
        }
        if (z) {
            j4 = 1;
        } else {
            j4 = 0;
        }
        mgVar.fbH = j4;
        if (cVar != null) {
            j5 = cVar.flatJSCompileCost;
        } else {
            j5 = 0;
        }
        mgVar.fbI = j5;
        if (org.apache.commons.b.a.contains(e.nGR, d2)) {
            mgVar.zv(V8.getV8Version());
        } else if (dVar.getJsRuntime() instanceof bb) {
            mgVar.zv(new StringBuilder().append(c.bVa()).toString());
        }
        mgVar.fbJ = mgVar.x("pluginAppid", str2, true);
        mgVar.fbK = mgVar.x("pluginVersion", String.valueOf(i3), true);
        mgVar.bfK();
        if (dVar instanceof s) {
            com.tencent.mm.plugin.appbrand.jsapi.q.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.q.a();
            aVar.setName("evaluateJavaScript");
            aVar.startTime = mgVar.fad;
            aVar.endTime = mgVar.fae;
            aVar.r(DownloadInfo.FILENAME, mgVar.fbE);
            aVar.r("size", Long.valueOf(mgVar.fbD));
            aVar.d((s) dVar);
        }
        if (!aC.nLv.nKv && (str.endsWith("app-service.js") || "game.js".equals(str))) {
            aC.nLv.nKv = true;
            aC.nLq = System.currentTimeMillis();
            q qVar = aC.kGW;
            mh mhVar = new mh();
            QualitySessionRuntime aC2 = aC(appId, true);
            if (aC2 != null) {
                mhVar.eJx = mhVar.x("AppId", aC2.appId, true);
                mhVar.eWb = mhVar.x("InstanceId", aC2.kEY, true);
                mhVar.fbL = mh.a.mt(aC2.nJE);
                mhVar.eYW = (long) aC2.apptype;
                mhVar.eXc = (long) aC2.nLk;
                mhVar.erW = (long) aC2.scene;
                mhVar.vT(aC2.nLn);
                mhVar.aje();
                mhVar.vS(mhVar.fae - aC2.nLn);
                mhVar.fbm = mhVar.x("path", com.tencent.mm.compatible.util.q.encode(qVar.brs()), true);
                if (qVar.kDl) {
                    j6 = 1;
                } else {
                    j6 = 0;
                }
                mhVar.eZN = j6;
                if (aC2.nLt != null) {
                    if (aC2.nLt.bNr()) {
                        j7 = 1;
                    } else {
                        j7 = 0;
                    }
                    mhVar.fbn = j7;
                } else if (BuildInfo.DEBUG) {
                    IllegalStateException illegalStateException2 = new IllegalStateException("StartupBundle not registered.");
                    AppMethodBeat.o(227387);
                    throw illegalStateException2;
                }
                mhVar.eZK = aC2.bVg();
                mhVar.exq = mhVar.x("networkType", t.el(MMApplicationContext.getContext()), true);
                mhVar.fbo = aC2.nLC;
                mhVar.fbM = aC2.bVj();
                mhVar.bfK();
            }
            if (DebuggerShell.bAx()) {
                com.tencent.mm.plugin.appbrand.performance.c.b(appId, "JsInject", mgVar.fad, mgVar.fae);
            }
        }
        AppMethodBeat.o(227387);
    }

    public static void a(String str, final AppBrandSysConfigWC appBrandSysConfigWC, AppStartupPerformanceReportBundle appStartupPerformanceReportBundle, q qVar) {
        mx.c cVar;
        mx.b bVar;
        long j2;
        mx.d dVar;
        AppMethodBeat.i(48192);
        final QualitySessionRuntime aC = aC(str, true);
        if (aC == null) {
            AppMethodBeat.o(48192);
            return;
        }
        aC.nLp = System.currentTimeMillis();
        aC.nLt = appStartupPerformanceReportBundle;
        aC.nLn = qVar.bsC().startTime;
        AppStartupPerformanceReportBundle appStartupPerformanceReportBundle2 = (AppStartupPerformanceReportBundle) qVar.d(AppStartupPerformanceReportBundle.class, false);
        if (appStartupPerformanceReportBundle2 == null) {
            Log.e("MicroMsg.AppBrandQualitySystem", "ReportBundle == null in resourceReady");
        } else {
            mx mxVar = new mx();
            QualitySessionRuntime aC2 = aC(str, true);
            if (aC2 != null) {
                mxVar.eJx = mxVar.x("AppId", aC2.appId, true);
                mxVar.eWb = mxVar.x("InstanceId", aC2.kEY, true);
                mxVar.ffg = mx.a.mJ(aC2.nJE);
                mxVar.eYW = (long) aC2.apptype;
                mxVar.erW = (long) aC2.scene;
                mxVar.eXc = (long) aC2.nLk;
                mxVar.xm(qVar.bsC().startTime);
                mxVar.ajm();
                mxVar.xl(mxVar.fae - qVar.bsC().startTime);
                mxVar.ffo = appStartupPerformanceReportBundle2.mSA - appStartupPerformanceReportBundle2.mSz;
                mxVar.ffp = appStartupPerformanceReportBundle2.mSC - appStartupPerformanceReportBundle2.mSB;
                mxVar.ffq = aC2.nLl;
                mxVar.ffr = (long) appStartupPerformanceReportBundle2.mSF;
                AppBrandSysConfigWC bsB = qVar.bsB();
                AppBrandInitConfigWC bsC = qVar.bsC();
                if (appStartupPerformanceReportBundle2.mSG) {
                    cVar = mx.c.sync;
                } else {
                    cVar = mx.c.unsync;
                }
                mxVar.ffi = cVar;
                if (bsC.cyy) {
                    bVar = mx.b.sync;
                } else {
                    bVar = mx.b.unsync;
                }
                mxVar.ffj = bVar;
                if (qVar.kDl) {
                    j2 = 1;
                } else {
                    j2 = 0;
                }
                mxVar.ffk = j2;
                long j3 = 0;
                if (!com.tencent.mm.vfs.s.YS(bsB.leE.pkgPath)) {
                    Iterator<ModulePkgInfo> it = bsB.leE.kNZ.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ModulePkgInfo next = it.next();
                        if (com.tencent.mm.vfs.s.YS(next.pkgPath)) {
                            j3 = com.tencent.mm.vfs.s.boW(next.pkgPath);
                            break;
                        }
                    }
                } else {
                    j3 = com.tencent.mm.vfs.s.boW(bsB.leE.pkgPath);
                }
                if (!qVar.kDl) {
                    j3 = 0;
                }
                mxVar.ffh = j3;
                mxVar.eJb = (long) g.getNetworkType();
                mxVar.fbo = aC2.nLC;
                mxVar.eZK = aC2.bVg();
                mxVar.xn(aC2.nLt.mSy - aC2.nLt.mSe);
                if (appStartupPerformanceReportBundle2.mSH) {
                    dVar = mx.d.sync;
                } else {
                    dVar = mx.d.unsync;
                }
                mxVar.ffs = dVar;
                mxVar.fft = appStartupPerformanceReportBundle2.mSE - appStartupPerformanceReportBundle2.mSD;
                mxVar.fbM = aC2.bVj();
                mxVar.bfK();
                if (DebuggerShell.bAx()) {
                    com.tencent.mm.plugin.appbrand.performance.c.b(mxVar.eJx, "ResourcePrepare", mxVar.fad, mxVar.fae);
                }
            }
        }
        com.tencent.mm.plugin.appbrand.ac.m.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.report.quality.b.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(48186);
                if (aC.kGW.isDestroyed()) {
                    AppMethodBeat.o(48186);
                    return;
                }
                if (!aC.cuy) {
                    f fVar = aC.nLw;
                    QualitySessionRuntime qualitySessionRuntime = aC;
                    AppBrandSysConfigWC appBrandSysConfigWC = appBrandSysConfigWC;
                    Log.i("MicroMsg.AppBrandRuntimeEventReporter", "AppBrandRuntimeEventReporter.mayStartDependOnClientSampleRate");
                    int i2 = qualitySessionRuntime.kGW.bsC().uin;
                    double d2 = appBrandSysConfigWC.czd.ldg;
                    double nextDouble = new Random(((long) i2) ^ System.nanoTime()).nextDouble();
                    boolean bAx = DebuggerShell.bAx();
                    boolean z = nextDouble <= d2 || bAx;
                    Log.i("MicroMsg.AppBrandRuntimeEventReporter", "shouldEnableReport() returned: [%b], localRandom = [%f] serverPercent = [%f] monkeyMode[%b]", Boolean.valueOf(z), Double.valueOf(nextDouble), Double.valueOf(d2), Boolean.valueOf(bAx));
                    if (z) {
                        synchronized (fVar) {
                            try {
                                fVar.a(qualitySessionRuntime, appBrandSysConfigWC.czd.ldh, f.a.Full, false);
                            } finally {
                                AppMethodBeat.o(48186);
                            }
                        }
                        return;
                    }
                }
                AppMethodBeat.o(48186);
            }
        });
        AppMethodBeat.o(48192);
    }

    public static void a(String str, q qVar) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        AppMethodBeat.i(48194);
        QualitySessionRuntime aC = aC(str, true);
        if (aC == null) {
            Log.e("MicroMsg.AppBrandQualitySystem", "onAppBrandInitReady appId[%s] NULL session", str);
            AppMethodBeat.o(48194);
            return;
        }
        Log.i("MicroMsg.AppBrandQualitySystem", "onAppBrandInitReady appId[%s]", str);
        aC.nLE = null;
        mi miVar = new mi();
        QualitySessionRuntime aC2 = aC(str, true);
        if (aC2 != null) {
            miVar.eJx = miVar.x("AppId", aC2.appId, true);
            miVar.eWb = miVar.x("InstanceId", aC2.kEY, true);
            miVar.fbR = mi.a.mu(aC2.nJE);
            miVar.eYW = (long) aC2.apptype;
            miVar.eXc = (long) aC2.nLk;
            miVar.erW = (long) aC2.scene;
            miVar.vV(qVar.bsC().startTime);
            miVar.ajf();
            miVar.vU(miVar.fae - miVar.fad);
            try {
                miVar.fbm = miVar.x("path", com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(qVar.bsD().getCurrentUrl())), true);
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrandQualitySystem", "launchToInitReady appId %s getCurrentUrl npe = %s", str, e2);
            }
            if (aC2.nLG) {
                j4 = 1;
            } else {
                j4 = 0;
            }
            miVar.eZN = j4;
            if (aC2.nLt != null) {
                if (aC2.nLt.bNr()) {
                    j8 = 1;
                } else {
                    j8 = 0;
                }
                miVar.fbn = j8;
            } else if (BuildInfo.DEBUG) {
                IllegalStateException illegalStateException = new IllegalStateException("StartupBundle not registered.");
                AppMethodBeat.o(48194);
                throw illegalStateException;
            }
            miVar.eZK = aC2.bVg();
            miVar.fbU = (long) ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_preload_so, 0);
            miVar.fbv = 0;
            miVar.exq = miVar.x("networkType", t.el(MMApplicationContext.getContext()), true);
            WxaRuntimeModulePluginListMap wxaRuntimeModulePluginListMap = qVar.bsB().leE.kOb;
            if (wxaRuntimeModulePluginListMap != null) {
                List<WxaPluginPkgInfo> Vz = wxaRuntimeModulePluginListMap.Vz(ModulePkgInfo.MAIN_MODULE_NAME);
                if (Vz != null && Vz.size() > 0) {
                    miVar.fbw = 1;
                }
            } else {
                miVar.fbw = 0;
            }
            miVar.fbo = aC2.nLC;
            if (aC2.bVh()) {
                j5 = 1;
            } else {
                j5 = 0;
            }
            miVar.fbx = j5;
            miVar.fbe = (long) qVar.bsJ();
            if (qVar.bsC().ldY) {
                j6 = 1;
            } else {
                j6 = 0;
            }
            miVar.fbT = j6;
            ICommLibReader bqZ = qVar.bqZ();
            if (bqZ != null) {
                miVar.fbS = miVar.x("libVersion", bqZ.bvb(), true);
            } else {
                Log.w("MicroMsg.AppBrandQualitySystem", "launchToInitReady report with NULL libReader, appId[%s]", qVar.mAppId);
            }
            miVar.fbp = aC2.nLs;
            miVar.fbM = aC2.bVj();
            miVar.bfK();
            if (DebuggerShell.bAx()) {
                Object[] objArr = new Object[2];
                objArr[0] = "";
                if (aC2.nLG) {
                    j7 = 1;
                } else {
                    j7 = 0;
                }
                objArr[1] = Long.valueOf(j7);
                com.tencent.mm.plugin.appbrand.performance.c.a(miVar.eJx, "Native", "startupDone", miVar.fad, miVar.fae, String.format("{ \"appMd5\": \"%s\", \"isDownloadCode\": %d }", objArr));
            }
        }
        na naVar = new na();
        QualitySessionRuntime aC3 = aC(str, true);
        if (aC3 != null) {
            aC3.nLr = System.currentTimeMillis();
            naVar.eJx = naVar.x("AppId", aC3.appId, true);
            naVar.eWb = naVar.x("InstanceId", aC3.kEY, true);
            naVar.ffP = na.a.mM(aC3.nJE);
            naVar.eYW = (long) aC3.apptype;
            naVar.eXc = (long) aC3.nLk;
            naVar.erW = (long) aC3.scene;
            naVar.xx(aC3.nLp);
            naVar.ajo();
            naVar.xw(naVar.fae - aC3.nLp);
            naVar.eZK = aC3.bVg();
            try {
                naVar.fbm = naVar.x("path", com.tencent.mm.compatible.util.q.encode(qVar.bsD().getCurrentUrl()), true);
            } catch (Exception e3) {
            }
            naVar.fbv = 0;
            naVar.exq = naVar.x("networkType", t.el(MMApplicationContext.getContext()), true);
            naVar.fbo = aC3.nLC;
            if (aC3.bVh()) {
                j3 = 1;
            } else {
                j3 = 0;
            }
            naVar.fbx = j3;
            naVar.fbM = aC3.bVj();
            naVar.bfK();
            if (DebuggerShell.bAx()) {
                com.tencent.mm.plugin.appbrand.performance.c.b(naVar.eJx, "ResourcePrepareToStartUpDone", naVar.fad, naVar.fae);
            }
        }
        me meVar = new me();
        QualitySessionRuntime aC4 = aC(str, true);
        if (aC4 != null) {
            meVar.eJx = meVar.x("AppId", aC4.appId, true);
            meVar.eWb = meVar.x("InstanceId", aC4.kEY, true);
            meVar.fbu = me.a.ms(aC4.nJE);
            meVar.eYW = (long) aC4.apptype;
            meVar.eXc = (long) aC4.nLk;
            meVar.erW = (long) aC4.scene;
            meVar.vP(aC4.nLq);
            meVar.ajc();
            meVar.vO(meVar.fae - aC4.nLq);
            meVar.eZK = aC4.bVg();
            try {
                meVar.fbm = meVar.x("path", com.tencent.mm.compatible.util.q.encode(qVar.bsD().getCurrentUrl()), true);
            } catch (Exception e4) {
            }
            meVar.fbv = 0;
            meVar.exq = meVar.x("networkType", t.el(MMApplicationContext.getContext()), true);
            WxaRuntimeModulePluginListMap wxaRuntimeModulePluginListMap2 = qVar.bsB().leE.kOb;
            if (wxaRuntimeModulePluginListMap2 != null) {
                List<WxaPluginPkgInfo> Vz2 = wxaRuntimeModulePluginListMap2.Vz(ModulePkgInfo.MAIN_MODULE_NAME);
                if (Vz2 != null && Vz2.size() > 0) {
                    meVar.fbw = 1;
                }
            } else {
                meVar.fbw = 0;
            }
            meVar.fbo = aC4.nLC;
            if (aC4.bVh()) {
                j2 = 1;
            } else {
                j2 = 0;
            }
            meVar.fbx = j2;
            meVar.bfK();
        }
        long nowMilliSecond = Util.nowMilliSecond();
        if (DebuggerShell.bAx()) {
            com.tencent.mm.plugin.appbrand.performance.c.b(str, "FirstRender", aC.nLq, nowMilliSecond);
        }
        if (aC.apptype == 1004) {
            AppBrandPerformanceManager.a(qVar, 205, nowMilliSecond - aC.nLq);
        }
        AppMethodBeat.o(48194);
    }

    public static void I(q qVar) {
        long j2;
        long j3 = 1;
        AppMethodBeat.i(227386);
        QualitySessionRuntime aC = aC(qVar.mAppId, true);
        if (aC == null) {
            Log.e("MicroMsg.AppBrandQualitySystem", "onAppBrandSplashViewRemoved appId[%s] NULL session", qVar.mAppId);
            AppMethodBeat.o(227386);
            return;
        }
        md mdVar = new md();
        mdVar.eWb = mdVar.x("InstanceId", aC.kEY, true);
        mdVar.eJx = mdVar.x("AppId", aC.appId, true);
        mdVar.eXc = (long) aC.nLk;
        mdVar.fbl = md.a.mr(aC.nJE);
        mdVar.eYW = (long) aC.apptype;
        mdVar.vM(qVar.bsC().startTime);
        mdVar.vN(Util.nowMilliSecond());
        mdVar.vL(mdVar.fae - mdVar.fad);
        mdVar.fbm = mdVar.x("path", com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(qVar.brs())), true);
        if (aC.nLG) {
            j2 = 1;
        } else {
            j2 = 0;
        }
        mdVar.eZN = j2;
        if (aC.nLt == null || !aC.nLt.bNr()) {
            j3 = 0;
        }
        mdVar.fbn = j3;
        mdVar.eZK = aC.bVg();
        mdVar.fbo = aC.nLC;
        long nowMilliSecond = Util.nowMilliSecond();
        if (aC.nLs <= 0 || nowMilliSecond <= aC.nLs) {
            mdVar.fbp = 0;
        } else {
            mdVar.fbp = nowMilliSecond;
        }
        mdVar.bfK();
        AppMethodBeat.o(227386);
    }

    public static void J(q qVar) {
        long j2;
        long j3;
        long j4;
        long j5;
        AppMethodBeat.i(48195);
        QualitySessionRuntime aC = aC(qVar.mAppId, false);
        if (aC == null) {
            AppMethodBeat.o(48195);
            return;
        }
        mc mcVar = aC.nLE;
        if (mcVar != null) {
            mcVar.zp(aC.kEY);
            mcVar.zq(aC.appId);
            mcVar.eXc = (long) aC.nLk;
            mcVar.fba = mc.a.mq(aC.nJE);
            mcVar.eYW = (long) aC.apptype;
            mcVar.erW = (long) aC.scene;
            mcVar.zr(qVar.bsC().username);
            if (aC.nLG) {
                j2 = 1;
            } else {
                j2 = 0;
            }
            mcVar.eZN = j2;
            mcVar.eZK = aC.bVg();
            mcVar.zs(i.getNetworkType(MMApplicationContext.getContext()));
            if (qVar.bsC().cyy) {
                j3 = 1;
            } else {
                j3 = 0;
            }
            mcVar.fbb = j3;
            if (aC.nLF) {
                j4 = 1;
            } else {
                j4 = 0;
            }
            mcVar.fbc = j4;
            mcVar.vJ(qVar.bsC().startTime);
            mcVar.aiX();
            mcVar.vH(mcVar.fae - mcVar.fad);
            if (aC.nLH) {
                j5 = 1;
            } else {
                j5 = 0;
            }
            mcVar.fbg = j5;
            if (aC.nLt != null) {
                mcVar.fbd = 1;
            } else {
                mcVar.fbd = 0;
            }
            mcVar.fbe = (long) qVar.bsJ();
            mcVar.fbf = (long) q.bsK();
            mcVar.bfK();
        }
        AppMethodBeat.o(48195);
    }

    public static void K(q qVar) {
        long j2;
        AppMethodBeat.i(160613);
        QualitySessionRuntime aC = aC(qVar.mAppId, true);
        if (aC == null) {
            AppMethodBeat.o(160613);
            return;
        }
        com.tencent.mm.plugin.appbrand.ad.c cVar = p.Um(qVar.mAppId).kCO;
        mq mqVar = new mq();
        mqVar.eWb = mqVar.x("InstanceId", aC.kEY, true);
        mqVar.eJx = mqVar.x("AppId", aC.appId, true);
        mqVar.eXc = (long) aC.nLk;
        mqVar.fdo = mq.a.mB(aC.nJE);
        mqVar.eYW = (long) aC.apptype;
        mqVar.erW = (long) aC.scene;
        mqVar.wA(cVar.kGs);
        mqVar.wB(cVar.kGv);
        mqVar.wz(cVar.kGv - cVar.kGs);
        mqVar.fbe = (long) qVar.bsJ();
        mqVar.fdp = cVar.kGs;
        mqVar.fdq = cVar.kGv;
        mqVar.fdr = cVar.kGv - cVar.kGs;
        mqVar.fds = cVar.kGx;
        mqVar.fdt = cVar.kGy;
        mqVar.fdu = cVar.kGy - cVar.kGx;
        mqVar.fdv = cVar.kGz;
        mqVar.fdw = cVar.kGA;
        mqVar.fdx = cVar.kGA - cVar.kGz;
        mqVar.fbf = (long) q.bsK();
        mqVar.fdC = cVar.kGu - cVar.kGt;
        mqVar.fdy = cVar.kGt;
        mqVar.fdz = cVar.kGt - cVar.kGs;
        mqVar.fdA = cVar.kGu;
        mqVar.fdB = cVar.kGv - cVar.kGu;
        mqVar.fdD = qVar.bsM();
        mqVar.fdE = cVar.kGB;
        mqVar.fdF = (long) cVar.kGw;
        mqVar.fdG = cVar.kGD;
        mqVar.fdH = cVar.kGE;
        mqVar.fdI = cVar.kGF;
        mqVar.fdJ = cVar.kGG;
        mqVar.fdK = cVar.kGG - cVar.kGD;
        mqVar.fdL = cVar.kGF - cVar.kGE;
        mqVar.fdN = (long) q.bsK();
        mqVar.fdM = (long) q.bsL();
        mqVar.fdO = 1;
        if (qVar.bqZ() != null) {
            j2 = (long) qVar.bqZ().bvd();
        } else {
            j2 = 0;
        }
        mqVar.fdP = j2;
        mqVar.bfK();
        AppMethodBeat.o(160613);
    }

    static /* synthetic */ void L(q qVar) {
        QualitySessionRuntime aC;
        AppMethodBeat.i(48197);
        String str = qVar.mAppId;
        if (TextUtils.isEmpty(str) || (aC = aC(str, false)) == null || aC.kGW != qVar) {
            AppMethodBeat.o(48197);
            return;
        }
        aC.nLw.destroy();
        synchronized (nKp) {
            try {
                nKp.put(str, null);
            } finally {
                AppMethodBeat.o(48197);
            }
        }
    }
}
