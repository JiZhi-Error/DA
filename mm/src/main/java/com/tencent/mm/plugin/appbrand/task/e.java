package com.tencent.mm.plugin.appbrand.task;

import android.os.MessageQueue;
import android.os.SystemClock;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.debugger.v;
import com.tencent.mm.plugin.appbrand.m.ad;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.o;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.utils.k;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.system.LooperCompat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x5.sdk.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import junit.framework.Assert;
import kotlin.x;

public class e {
    private static final a nOG = new a();
    private static final ConcurrentHashMap<g, HashSet<b>> nOH = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<g, Queue<ag>> nOI = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<g, Queue<s>> nOJ = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<g, AppBrandPreloadProfiler> nOK = new ConcurrentHashMap<>();
    private static volatile boolean nOL = false;
    private static volatile boolean nOM = false;
    private static volatile boolean nON = false;
    private static volatile int nOO = Integer.MAX_VALUE;

    public interface b {
        void onReady();
    }

    static /* synthetic */ void n(g gVar) {
        AppMethodBeat.i(227467);
        d(gVar);
        AppMethodBeat.o(227467);
    }

    static /* synthetic */ void p(g gVar) {
        AppMethodBeat.i(227470);
        e(gVar);
        AppMethodBeat.o(227470);
    }

    public enum c {
        NOT_PRELOAD,
        PRELOADING,
        PRELOADED_DOWNGRADE,
        PRELOADED_FULL;

        public static c valueOf(String str) {
            AppMethodBeat.i(48379);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(48379);
            return cVar;
        }

        static {
            AppMethodBeat.i(48380);
            AppMethodBeat.o(48380);
        }
    }

    static {
        AppMethodBeat.i(48405);
        nOI.put(g.WAGAME, new ConcurrentLinkedQueue());
        nOI.put(g.WASERVICE, new ConcurrentLinkedQueue());
        nOJ.put(g.WAGAME, new ConcurrentLinkedQueue());
        nOJ.put(g.WASERVICE, new ConcurrentLinkedQueue());
        nOH.put(g.WAGAME, new HashSet<>());
        nOH.put(g.WASERVICE, new HashSet<>());
        AppMethodBeat.o(48405);
    }

    private static synchronized void d(g gVar) {
        synchronized (e.class) {
            AppMethodBeat.i(227450);
            Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "reset() %s", android.util.Log.getStackTraceString(new Throwable()));
            nOG.a(gVar, c.NOT_PRELOAD);
            AppMethodBeat.o(227450);
        }
    }

    private static synchronized g[] bVO() {
        boolean z;
        boolean z2;
        g[] gVarArr;
        synchronized (e.class) {
            AppMethodBeat.i(227451);
            boolean z3 = nOJ.contains(g.WASERVICE) && !nOJ.get(g.WASERVICE).isEmpty();
            if (!nOJ.contains(g.WAGAME) || nOJ.get(g.WAGAME).isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            ArrayList arrayList = new ArrayList();
            if (z3) {
                arrayList.add(g.WASERVICE);
            }
            if (z) {
                arrayList.add(g.WAGAME);
            }
            if (arrayList.size() <= 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assert.assertTrue(z2);
            gVarArr = (g[]) arrayList.toArray(new g[0]);
            AppMethodBeat.o(227451);
        }
        return gVarArr;
    }

    public static synchronized g[] bVP() {
        g[] gVarArr;
        synchronized (e.class) {
            AppMethodBeat.i(227452);
            a aVar = nOG;
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<g, c> entry : aVar.nOV.entrySet()) {
                g key = entry.getKey();
                if (aVar.r(key)) {
                    arrayList.add(key);
                }
            }
            gVarArr = (g[]) arrayList.toArray(new g[0]);
            AppMethodBeat.o(227452);
        }
        return gVarArr;
    }

    public static void a(g gVar, b bVar, boolean z) {
        AppMethodBeat.i(227453);
        a(gVar, bVar, z, null, 2);
        AppMethodBeat.o(227453);
    }

    public static void a(g gVar, b bVar, boolean z, AppBrandPreloadProfiler appBrandPreloadProfiler, int i2) {
        c q;
        AppMethodBeat.i(227454);
        Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "AppBrandPreloader.preload serviceType = [%s] level = [%d], force[%b]", gVar.name(), Integer.valueOf(i2), Boolean.valueOf(z));
        if (gVar == g.NIL) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("can not preload with a specific service type");
            AppMethodBeat.o(227454);
            throw illegalArgumentException;
        }
        synchronized (e.class) {
            try {
                if (nOG.r(gVar) && z) {
                    d(gVar);
                }
                q = nOG.q(gVar);
                if (q == c.NOT_PRELOAD || q == c.PRELOADING || (q == c.PRELOADED_DOWNGRADE && i2 >= 2)) {
                    if (bVar != null) {
                        nOH.get(gVar).add(bVar);
                    }
                    nOG.a(gVar, c.PRELOADING);
                }
            } finally {
                AppMethodBeat.o(227454);
            }
        }
        if (q == c.PRELOADING) {
            Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preload: type [%s] is preloading, just return", gVar.name());
            AppMethodBeat.o(227454);
        } else if (q == c.PRELOADED_FULL || (q == c.PRELOADED_DOWNGRADE && i2 < 2)) {
            if (bVar != null) {
                Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preload: [%s] [%d] preload finished", gVar.name(), Integer.valueOf(i2));
                bVar.onReady();
            }
        } else {
            a(gVar, appBrandPreloadProfiler, i2);
            AppMethodBeat.o(227454);
        }
    }

    private static void a(final g gVar, AppBrandPreloadProfiler appBrandPreloadProfiler, final int i2) {
        AppMethodBeat.i(227455);
        if (appBrandPreloadProfiler == null) {
            appBrandPreloadProfiler = new AppBrandPreloadProfiler();
        }
        appBrandPreloadProfiler.level = i2;
        nOK.put(gVar, appBrandPreloadProfiler);
        h.INSTANCE.dN(915, gVar == g.WAGAME ? 5 : 0);
        Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "TRACE_ORDER:AppBrandProcessPreloader.java");
        if (i2 == 0) {
            a(i2, gVar);
            AppMethodBeat.o(227455);
            return;
        }
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.task.e.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(48370);
                try {
                    Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preInit start");
                    ((AppBrandPreloadProfiler) e.nOK.get(gVar)).startTime = SystemClock.elapsedRealtime();
                    com.tencent.mm.plugin.expansions.a.cMp();
                    MMHandlerThread.setCurrentPriority(-2);
                    try {
                        WxaCommLibRuntimeReader.vC();
                        ad.bDt();
                        if (gVar == g.WAGAME) {
                            e.access$200();
                            e.access$300();
                            Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[wagame] misc preload done");
                            return;
                        }
                        final k kVar = new k(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.task.e.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(227440);
                                e.b(i2, gVar);
                                AppMethodBeat.o(227440);
                            }
                        }, 2);
                        if (i2 >= 2) {
                            final AnonymousClass2 r1 = new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.task.e.AnonymousClass1.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(48369);
                                    MMHandlerThread.setCurrentPriority(-8);
                                    e.o(gVar);
                                    kVar.countDown();
                                    AppMethodBeat.o(48369);
                                }
                            };
                            if (y.btj()) {
                                Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "XWebPreloader preloaded, trigger preloadAppBrandRuntime");
                                MMHandlerThread.postToMainThread(r1);
                            } else {
                                final long currentTimeMillis = System.currentTimeMillis();
                                y.a(new y.a() {
                                    /* class com.tencent.mm.plugin.appbrand.task.e.AnonymousClass1.AnonymousClass3 */

                                    @Override // com.tencent.mm.plugin.appbrand.y.a
                                    public final void brW() {
                                        AppMethodBeat.i(227441);
                                        com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
                                        com.tencent.mm.plugin.appbrand.report.quality.c.a(true, (String) null, currentTimeMillis, o.bUx());
                                        MMHandlerThread.postToMainThread(r1);
                                        AppMethodBeat.o(227441);
                                    }

                                    @Override // com.tencent.mm.plugin.appbrand.y.a
                                    public final void brX() {
                                        AppMethodBeat.i(227442);
                                        Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "XWebPreloader onPreloadFailed, trigger preloadAppBrandRuntime");
                                        MMHandlerThread.postToMainThread(r1);
                                        AppMethodBeat.o(227442);
                                    }
                                });
                            }
                        } else {
                            Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "run: skip preload webView");
                            kVar.countDown();
                        }
                        com.tencent.f.h.RTc.b(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.task.e.AnonymousClass1.AnonymousClass4 */

                            public final void run() {
                                AppMethodBeat.i(227443);
                                e.p(gVar);
                                kVar.countDown();
                                AppMethodBeat.o(227443);
                            }
                        }, "MicroMsg.AppBrandProcessPreloader[applaunch][preload]_AppBrandServicePreloadWorker");
                        Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "misc preload done");
                        MMHandlerThread.setCurrentPriority(10);
                        AppMethodBeat.o(48370);
                    } catch (Throwable th) {
                        Log.e("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "skip preload runtime, load CommLib get exception %s", android.util.Log.getStackTraceString(th));
                        e.n(gVar);
                        Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "misc preload done");
                        MMHandlerThread.setCurrentPriority(10);
                        AppMethodBeat.o(48370);
                    }
                } catch (Throwable th2) {
                    e.n(gVar);
                    if (WeChatEnvironment.hasDebugger()) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.task.e.AnonymousClass1.AnonymousClass5 */

                            public final void run() {
                                throw th2;
                            }
                        });
                    } else {
                        Log.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", th2, "[NOT CRASH]", new Object[0]);
                    }
                } finally {
                    Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "misc preload done");
                    MMHandlerThread.setCurrentPriority(10);
                    AppMethodBeat.o(48370);
                }
            }
        }, "MicroMsg.AppBrandProcessPreloader[applaunch][preload]_ComponentsPreloadWorker");
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.task.e.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(48373);
                com.tencent.luggage.sdk.g.c.a("preload AppBrandUI classes", new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.task.e.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(227444);
                        Iterator<n> it = h.bWd().iterator();
                        while (it.hasNext()) {
                            n next = it.next();
                            if (Util.nullAsNil(next.nQm).equals(g.aAe().azG().mProcessName)) {
                                try {
                                    next.nQl.newInstance();
                                    if (next instanceof m) {
                                        ((m) next).nQi.newInstance();
                                    }
                                } catch (Throwable th) {
                                }
                            }
                        }
                        AppMethodBeat.o(227444);
                    }
                });
                AppMethodBeat.o(48373);
            }
        }, "MicroMsg.AppBrandProcessPreloader[applaunch][preload]_ExtraPreloadWorker");
        AppMethodBeat.o(227455);
    }

    public static synchronized void bVQ() {
        synchronized (e.class) {
            AppMethodBeat.i(48384);
            g[] bVO = bVO();
            for (g gVar : bVO) {
                if (k(gVar)) {
                    Queue<s> queue = nOJ.get(gVar);
                    if (queue != null) {
                        for (s sVar : queue) {
                            sVar.cleanup();
                        }
                    }
                    Queue<ag> queue2 = nOI.get(gVar);
                    if (queue2 != null) {
                        for (ag agVar : queue2) {
                            agVar.cleanup();
                        }
                    }
                    a(gVar, (b) null, true);
                }
            }
            AppMethodBeat.o(48384);
        }
    }

    private static void e(g gVar) {
        AppMethodBeat.i(227456);
        Queue<s> queue = nOJ.get(gVar);
        if (!queue.isEmpty()) {
            Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preload services skipped cause already cached");
            h.INSTANCE.dN(915, 34);
            AppMethodBeat.o(227456);
            return;
        }
        s sVar = (s) org.a.a.bF(gVar.nPH).hPX().object;
        sVar.a(WxaCommLibRuntimeReader.bvW());
        sVar.YU();
        queue.add(sVar);
        Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preloadService done in request[%s]", gVar);
        AppMethodBeat.o(227456);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00a8, code lost:
        if (r0 == false) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00aa, code lost:
        a(r10, (com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler) null, 2);
        com.tencent.matrix.trace.core.AppMethodBeat.o(227457);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e7, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(227457);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.tencent.mm.plugin.appbrand.task.g r10, com.tencent.mm.plugin.appbrand.task.e.b r11, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 238
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.task.e.a(com.tencent.mm.plugin.appbrand.task.g, com.tencent.mm.plugin.appbrand.task.e$b, java.lang.String):boolean");
    }

    public static com.tencent.mm.vending.g.c<Void> f(g gVar) {
        AppMethodBeat.i(227458);
        synchronized (e.class) {
            try {
                if (nOG.q(gVar) == c.PRELOADING) {
                    f<Void> hio = com.tencent.mm.co.g.hio();
                    final com.tencent.mm.vending.g.b hdx = hio.hdx();
                    hdx.hdw();
                    nOH.get(gVar).add(new b() {
                        /* class com.tencent.mm.plugin.appbrand.task.e.AnonymousClass3 */

                        @Override // com.tencent.mm.plugin.appbrand.task.e.b
                        public final void onReady() {
                            AppMethodBeat.i(48374);
                            hdx.resume();
                            AppMethodBeat.o(48374);
                        }
                    });
                    return hio;
                }
                f<Void> hio2 = com.tencent.mm.co.g.hio();
                AppMethodBeat.o(227458);
                return hio2;
            } finally {
                AppMethodBeat.o(227458);
            }
        }
    }

    public static AppBrandPreloadProfiler g(g gVar) {
        AppMethodBeat.i(227459);
        AppBrandPreloadProfiler appBrandPreloadProfiler = nOK.get(gVar);
        AppMethodBeat.o(227459);
        return appBrandPreloadProfiler;
    }

    public static com.tencent.mm.plugin.appbrand.service.c h(g gVar) {
        AppMethodBeat.i(227460);
        Assert.assertNotSame(gVar, g.NIL);
        h.INSTANCE.dN(915, gVar == g.WAGAME ? 12 : 10);
        com.tencent.mm.plugin.appbrand.service.c cVar = null;
        Queue<s> queue = nOJ.get(gVar);
        if (queue != null && !queue.isEmpty()) {
            cVar = (com.tencent.mm.plugin.appbrand.service.c) queue.poll();
            Assert.assertTrue(queue.isEmpty());
        }
        if (cVar != null) {
            h.INSTANCE.dN(915, gVar == g.WAGAME ? 7 : 2);
        }
        Log.d("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "getServices: ret = [%s]", cVar);
        AppMethodBeat.o(227460);
        return cVar;
    }

    public static ag i(g gVar) {
        AppMethodBeat.i(227461);
        Assert.assertNotSame(gVar, g.NIL);
        Queue<ag> queue = nOI.get(gVar);
        ag agVar = null;
        if (queue != null && !queue.isEmpty()) {
            agVar = queue.poll();
            Assert.assertTrue(queue.isEmpty());
        }
        Log.d("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "getPageView: [%s]", agVar);
        AppMethodBeat.o(227461);
        return agVar;
    }

    public static com.tencent.mm.plugin.appbrand.service.c j(g gVar) {
        AppMethodBeat.i(227462);
        Assert.assertNotSame(gVar, g.NIL);
        Queue<s> queue = nOJ.get(gVar);
        if (queue == null || queue.isEmpty()) {
            AppMethodBeat.o(227462);
            return null;
        }
        com.tencent.mm.plugin.appbrand.service.c cVar = (com.tencent.mm.plugin.appbrand.service.c) queue.peek();
        AppMethodBeat.o(227462);
        return cVar;
    }

    private static void a(int i2, final g gVar) {
        LinkedList<b> linkedList;
        AppMethodBeat.i(227463);
        Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preInit finished level:%d type [%s]", Integer.valueOf(i2), gVar.name());
        nOK.get(gVar).bVN();
        nOK.get(gVar);
        AppBrandPreloadProfiler.A(new kotlin.g.a.a<x>() {
            /* class com.tencent.mm.plugin.appbrand.task.e.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(227445);
                e.a((AppBrandPreloadProfiler) e.nOK.get(gVar), gVar);
                AppMethodBeat.o(227445);
                return null;
            }
        });
        h.INSTANCE.dN(915, gVar == g.WAGAME ? 6 : 1);
        synchronized (e.class) {
            if (i2 == 2) {
                try {
                    nOG.a(gVar, c.PRELOADED_FULL);
                } catch (Throwable th) {
                    AppMethodBeat.o(227463);
                    throw th;
                }
            } else {
                nOG.a(gVar, c.PRELOADED_DOWNGRADE);
            }
            linkedList = new LinkedList(nOH.get(gVar));
            nOH.get(gVar).clear();
        }
        for (b bVar : linkedList) {
            if (bVar != null) {
                bVar.onReady();
            }
        }
        LooperCompat.addMainLooperIdleHandler(new MessageQueue.IdleHandler() {
            /* class com.tencent.mm.plugin.appbrand.task.e.AnonymousClass5 */

            public final boolean queueIdle() {
                AppMethodBeat.i(48377);
                com.tencent.mm.plugin.appbrand.page.g gVar = com.tencent.mm.plugin.appbrand.page.g.nnK;
                com.tencent.mm.plugin.appbrand.page.g.a(gVar);
                AppMethodBeat.o(48377);
                return false;
            }
        });
        AppMethodBeat.o(227463);
    }

    public static synchronized boolean k(g gVar) {
        boolean r;
        synchronized (e.class) {
            AppMethodBeat.i(227464);
            r = nOG.r(gVar);
            AppMethodBeat.o(227464);
        }
        return r;
    }

    public static synchronized boolean l(g gVar) {
        ag agVar;
        boolean z;
        synchronized (e.class) {
            AppMethodBeat.i(227465);
            if (!k(gVar)) {
                AppMethodBeat.o(227465);
                z = true;
            } else {
                com.tencent.mm.plugin.appbrand.service.c j2 = j(gVar);
                Assert.assertNotSame(gVar, g.NIL);
                Queue<ag> queue = nOI.get(gVar);
                if (queue == null || queue.isEmpty()) {
                    agVar = null;
                } else {
                    agVar = queue.peek();
                }
                if (gVar == g.WAGAME) {
                    if (j2 == null) {
                        AppMethodBeat.o(227465);
                        z = true;
                    } else {
                        AppMethodBeat.o(227465);
                        z = false;
                    }
                } else if (gVar != g.WASERVICE) {
                    IllegalStateException illegalStateException = new IllegalStateException("not supported type: " + gVar.name());
                    AppMethodBeat.o(227465);
                    throw illegalStateException;
                } else if (j2 == null || agVar == null) {
                    AppMethodBeat.o(227465);
                    z = true;
                } else {
                    AppMethodBeat.o(227465);
                    z = false;
                }
            }
        }
        return z;
    }

    public static boolean bVR() {
        AppMethodBeat.i(48395);
        if (WebView.isSys()) {
            AppMethodBeat.o(48395);
            return true;
        }
        if (WebView.isX5()) {
            if (WebView.getUsingTbsCoreVersion(MMApplicationContext.getContext()) == 0) {
                Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "closeWAServiceClientPreload without x5");
                AppMethodBeat.o(48395);
                return true;
            } else if (!d.canOpenWebPlus(MMApplicationContext.getContext())) {
                Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "closeWAServiceClientPreload can not OpenWebPlus");
                AppMethodBeat.o(48395);
                return true;
            }
        }
        AppMethodBeat.o(48395);
        return false;
    }

    private static String a(long j2, String str, long j3, String str2) {
        AppMethodBeat.i(48397);
        if (j2 == MAlarmHandler.NEXT_FIRE_INTERVAL || j3 == MAlarmHandler.NEXT_FIRE_INTERVAL) {
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = j2 == MAlarmHandler.NEXT_FIRE_INTERVAL ? "?" : "ok";
            objArr[2] = str2;
            objArr[3] = j3 == MAlarmHandler.NEXT_FIRE_INTERVAL ? "?" : "ok";
            String safeFormatString = Util.safeFormatString("Unknown(%s=%s,%s=%s)", objArr);
            AppMethodBeat.o(48397);
            return safeFormatString;
        }
        String valueOf = String.valueOf(j3 - j2);
        AppMethodBeat.o(48397);
        return valueOf;
    }

    public static c m(g gVar) {
        AppMethodBeat.i(227466);
        c q = nOG.q(gVar);
        AppMethodBeat.o(227466);
        return q;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        final Map<g, c> nOV = new ConcurrentHashMap();

        public a() {
            AppMethodBeat.i(227446);
            this.nOV.put(g.WASERVICE, c.NOT_PRELOAD);
            this.nOV.put(g.WAGAME, c.NOT_PRELOAD);
            AppMethodBeat.o(227446);
        }

        public final c q(g gVar) {
            AppMethodBeat.i(227447);
            c cVar = this.nOV.get(gVar);
            AppMethodBeat.o(227447);
            return cVar;
        }

        public final void a(g gVar, c cVar) {
            AppMethodBeat.i(227448);
            this.nOV.put(gVar, cVar);
            AppMethodBeat.o(227448);
        }

        public final boolean r(g gVar) {
            AppMethodBeat.i(227449);
            c cVar = this.nOV.get(gVar);
            if (cVar == c.PRELOADED_FULL || cVar == c.PRELOADED_DOWNGRADE) {
                AppMethodBeat.o(227449);
                return true;
            }
            AppMethodBeat.o(227449);
            return false;
        }
    }

    static /* synthetic */ void access$200() {
        AppMethodBeat.i(48399);
        com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = a.C0356a.hnM;
        com.tencent.mm.storage.c Fu = com.tencent.mm.ipcinvoker.wx_extension.a.a.Fu("100413");
        if (Fu == null) {
            Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[PreloadWAGameABTest] item is null");
            AppMethodBeat.o(48399);
            return;
        }
        nON = Fu.isValid() && "1".equals(Fu.gzz().get("shouldOpen"));
        nOO = Util.getInt(Fu.gzz().get("preloadLibVersion"), Integer.MAX_VALUE);
        Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[PreloadWAGameABTest] sShouldPreloadWAGame:%b, sPreloadWxCommLibVersion :%d", Boolean.valueOf(nON), Integer.valueOf(nOO));
        AppMethodBeat.o(48399);
    }

    static /* synthetic */ void access$300() {
        boolean z;
        AppMethodBeat.i(48400);
        if (!v.bAY()) {
            Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[PreloadWAGameABTest] hardcode disable preload for remote debug");
            z = false;
        } else {
            if (b.bVE()) {
                Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[PreloadWAGameABTest] forcePreload");
            }
            z = true;
        }
        if (!z) {
            Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preloadNextRuntimeForWAGame disable preload");
            a(2, g.WAGAME);
            h.INSTANCE.dN(915, 32);
            AppMethodBeat.o(48400);
        } else if (com.tencent.mm.plugin.appbrand.a.bqU()) {
            Log.e("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preloadNextRuntimeForWAGame skip by hasRunningGames[TRUE]");
            h.INSTANCE.dN(915, 31);
            a(2, g.WAGAME);
            AppMethodBeat.o(48400);
        } else {
            try {
                e(g.WAGAME);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", e2, "preloadNextRuntimeOnUiThreadForWAGame exception.", new Object[0]);
            }
            a(2, g.WAGAME);
            AppMethodBeat.o(48400);
        }
    }

    static /* synthetic */ void b(int i2, g gVar) {
        AppMethodBeat.i(227468);
        a(i2, gVar);
        AppMethodBeat.o(227468);
    }

    static /* synthetic */ void o(g gVar) {
        AppMethodBeat.i(227469);
        if (bVR()) {
            Log.e("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preloadPageView tried but kernel incompatible");
            AppMethodBeat.o(227469);
            return;
        }
        Queue<ag> queue = nOI.get(gVar);
        if (!queue.isEmpty()) {
            Log.e("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preloadPageView skipped cause already cached");
            AppMethodBeat.o(227469);
        } else if (gVar == g.WAGAME) {
            Log.e("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preloadPageView skipped in request[%s]", gVar);
            AppMethodBeat.o(227469);
        } else {
            ag agVar = new ag();
            agVar.a(WxaCommLibRuntimeReader.bvW());
            agVar.YU();
            queue.add(agVar);
            Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "preloadPageView done");
            AppMethodBeat.o(227469);
        }
    }

    static /* synthetic */ void a(AppBrandPreloadProfiler appBrandPreloadProfiler, g gVar) {
        AppMethodBeat.i(48396);
        if (appBrandPreloadProfiler == null) {
            Log.e("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", "[PreloadProfile]" + "AppBrandPreloadProfiler == null");
            AppMethodBeat.o(48396);
            return;
        }
        StringBuilder append = new StringBuilder().append("[PreloadProfile]").append(" ");
        Object[] objArr = new Object[1];
        objArr[0] = gVar == null ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : gVar.name();
        StringBuilder append2 = append.append(Util.safeFormatString("Preload for [%s]Type | ", objArr));
        Object[] objArr2 = new Object[1];
        objArr2[0] = Long.valueOf(appBrandPreloadProfiler.nOC == MAlarmHandler.NEXT_FIRE_INTERVAL ? -1 : appBrandPreloadProfiler.nOC);
        Log.i("MicroMsg.AppBrandProcessPreloader[applaunch][preload]", append2.append(Util.safeFormatString("Preload request at [%d] | ", objArr2)).append(Util.safeFormatString("Process prepared cost [%s]ms | ", a(appBrandPreloadProfiler.nOC, "req", appBrandPreloadProfiler.nOE, "proc"))).append(Util.safeFormatString("Trans-thread prepared cost [%s]ms | ", a(appBrandPreloadProfiler.nOE, "proc", appBrandPreloadProfiler.startTime, "start"))).append(Util.safeFormatString("Preload prepared cost [%s]ms | ", a(appBrandPreloadProfiler.startTime, "start", appBrandPreloadProfiler.endTime, "end"))).append(Util.safeFormatString("All cost [%s]ms | ", a(appBrandPreloadProfiler.nOC, "req", appBrandPreloadProfiler.endTime, "end"))).append(Util.safeFormatString("level [%d] | ", Integer.valueOf(appBrandPreloadProfiler.level))).append(Util.safeFormatString("mem usage [%d]mb", Integer.valueOf(appBrandPreloadProfiler.nOD))).toString());
        AppMethodBeat.o(48396);
    }
}
