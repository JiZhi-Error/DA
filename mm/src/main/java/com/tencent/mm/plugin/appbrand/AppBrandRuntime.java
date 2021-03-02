package com.tencent.mm.plugin.appbrand;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.ad.k;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.p.a;
import com.tencent.mm.plugin.appbrand.page.bw;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.e;
import com.tencent.mm.plugin.appbrand.page.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.pip.f;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.s.i;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.ab;
import com.tencent.mm.plugin.appbrand.ui.ac;
import com.tencent.mm.plugin.appbrand.ui.af;
import com.tencent.mm.plugin.appbrand.utils.p;
import com.tencent.mm.plugin.appbrand.utils.u;
import com.tencent.mm.plugin.appbrand.widget.AppBrandGlobalNativeWidgetContainerView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.smtt.sdk.WebView;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.x;

public class AppBrandRuntime implements p<com.tencent.mm.vending.e.a> {
    public volatile boolean SO;
    public e jCK;
    @TargetApi(21)
    public final ConcurrentLinkedDeque<m> kAA;
    public final au kAB;
    private final ConcurrentSkipListSet<aq> kAC;
    final av kAD;
    private final LinkedHashSet<n> kAE;
    private final z kAF;
    private com.tencent.mm.plugin.appbrand.utils.e kAG;
    public volatile com.tencent.mm.plugin.appbrand.a.c kAH;
    public com.tencent.mm.plugin.appbrand.p.a kAI;
    protected boolean kAJ;
    public boolean kAK;
    private boolean kAL;
    public ap kAM;
    public boolean kAN;
    public boolean kAO;
    public boolean kAP;
    public f kAQ;
    private AppBrandPipContainerView kAR;
    private AppBrandGlobalNativeWidgetContainerView kAS;
    public j kAT;
    public boolean kAU;
    private LinkedList<b> kAV;
    ConcurrentLinkedQueue<b> kAW;
    private final AppBrandMainProcessService.a kAX;
    private final MTimerHandler kAY;
    private final Deque<Runnable> kAZ;
    public ak kAl;
    private com.tencent.mm.plugin.appbrand.platform.window.c kAm;
    private final MMHandler kAn;
    private final ba kAo;
    AppBrandRuntime kAp;
    public volatile AppBrandInitConfig kAq;
    private volatile s kAr;
    private volatile w kAs;
    public com.tencent.mm.plugin.appbrand.widget.c kAt;
    protected ab kAu;
    public e kAv;
    public com.tencent.mm.plugin.appbrand.ad.f kAw;
    public com.tencent.mm.plugin.appbrand.page.capsulebar.e kAx;
    private volatile Boolean kAy;
    private volatile q kAz;
    public SparseArray<Set<al>> kBa;
    public volatile String mAppId;
    public Context mContext;
    private boolean mDestroyed;
    public volatile boolean mInitialized;
    public boolean mResumed;

    /* access modifiers changed from: package-private */
    public interface a {
        void done();
    }

    private AppBrandRuntime(Context context) {
        AppMethodBeat.i(219196);
        this.kAy = null;
        this.kAz = null;
        this.kAA = new ConcurrentLinkedDeque<m>() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue, java.util.Deque, java.util.concurrent.ConcurrentLinkedDeque
            public final /* synthetic */ boolean add(m mVar) {
                AppMethodBeat.i(134442);
                m mVar2 = mVar;
                boolean add = super.add(mVar2);
                if (mVar2 instanceof l) {
                    Log.i("MicroMsg.AppBrandRuntime", "mConfigs.add(AppBrandSysConfig[%s]) appId[%s], ret[%b]", mVar2.getClass().getName(), AppBrandRuntime.this.mAppId, Boolean.valueOf(add));
                    bg.b(AppBrandRuntime.this, true);
                }
                AppMethodBeat.o(134442);
                return add;
            }
        };
        this.kAB = new au();
        this.kAC = new ConcurrentSkipListSet<>(new Comparator<aq>() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass12 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(aq aqVar, aq aqVar2) {
                AppMethodBeat.i(219187);
                aq aqVar3 = aqVar;
                aq aqVar4 = aqVar2;
                if (aqVar3 == aqVar4) {
                    AppMethodBeat.o(219187);
                    return 0;
                }
                int hashCode = aqVar3.hashCode() - aqVar4.hashCode();
                AppMethodBeat.o(219187);
                return hashCode;
            }
        });
        this.kAD = new av();
        this.kAE = new LinkedHashSet<>();
        this.kAF = new z();
        this.mResumed = false;
        this.kAN = false;
        this.kAO = true;
        this.kAU = false;
        this.kAV = new LinkedList<>();
        this.kAW = null;
        this.kAX = new AppBrandMainProcessService.a() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass11 */
            private volatile boolean kBf = false;

            @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a
            public final void Uf(String str) {
                AppMethodBeat.i(219186);
                if (this.kBf) {
                    AppBrandRuntime.s(AppBrandRuntime.this);
                }
                this.kBf = false;
                AppMethodBeat.o(219186);
            }

            @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a
            public final void onDisconnected(String str) {
                this.kBf = true;
            }
        };
        this.kAY = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass13 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(219188);
                Log.i("MicroMsg.AppBrandRuntime", "onResourcePrepareTimeout appId[%s]", AppBrandRuntime.this.mAppId);
                AppBrandRuntime.this.bru();
                AppMethodBeat.o(219188);
                return false;
            }
        }, false);
        this.kAZ = new LinkedBlockingDeque();
        this.kBa = new SparseArray<>();
        this.mContext = context;
        this.kAn = new MMHandler(Looper.getMainLooper());
        this.kAo = new ba();
        this.kAt = new com.tencent.mm.plugin.appbrand.widget.c(this.mContext);
        this.kAt.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.jCK = new e(this.mContext);
        this.kAv = new e(this.mContext);
        this.kAG = new com.tencent.mm.plugin.appbrand.utils.e();
        this.kAP = false;
        AppMethodBeat.o(219196);
    }

    protected AppBrandRuntime(com.tencent.mm.plugin.appbrand.platform.window.c cVar) {
        this(cVar.getContext());
        AppMethodBeat.i(219197);
        this.kAl = null;
        this.kAm = cVar;
        AppMethodBeat.o(219197);
    }

    public AppBrandRuntime(ak akVar) {
        this(akVar.getContext());
        AppMethodBeat.i(176500);
        this.kAl = akVar;
        this.kAm = null;
        AppMethodBeat.o(176500);
    }

    @Override // com.tencent.mm.vending.e.b
    public void keep(com.tencent.mm.vending.e.a aVar) {
        AppMethodBeat.i(134473);
        this.kAo.keep(aVar);
        AppMethodBeat.o(134473);
    }

    @Override // com.tencent.mm.plugin.appbrand.utils.p
    public final void a(com.tencent.mm.vending.e.a aVar) {
        AppMethodBeat.i(160924);
        this.kAo.a(aVar);
        AppMethodBeat.o(160924);
    }

    public void a(ak akVar) {
        AppMethodBeat.i(219198);
        this.kAl = akVar;
        if (this.kAl != null) {
            this.kAB.b(this.kAl);
            AppMethodBeat.o(219198);
            return;
        }
        this.kAB.btq();
        AppMethodBeat.o(219198);
    }

    /* access modifiers changed from: protected */
    public final void c(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(134474);
        if (appBrandInitConfig == null) {
            Log.i("MicroMsg.AppBrandRuntime", "null current config, ignored");
            AppMethodBeat.o(134474);
            return;
        }
        Log.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| init start config:%s", appBrandInitConfig);
        this.kAq = appBrandInitConfig;
        this.mAppId = appBrandInitConfig.appId;
        this.kAH = new com.tencent.mm.plugin.appbrand.a.c(this);
        this.kAH.kQM.start();
        this.kAH.a(new c.a() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass17 */

            @Override // com.tencent.mm.plugin.appbrand.a.c.a
            public final void a(String str, com.tencent.mm.plugin.appbrand.a.b bVar) {
                String str2;
                AppMethodBeat.i(219190);
                AppBrandRuntime appBrandRuntime = AppBrandRuntime.this;
                HashMap hashMap = new HashMap();
                switch (p.AnonymousClass1.kRf[bVar.ordinal()]) {
                    case 1:
                        str2 = "background";
                        break;
                    case 2:
                        str2 = "active";
                        break;
                    case 3:
                        str2 = "suspend";
                        break;
                    default:
                        AppMethodBeat.o(219190);
                        return;
                }
                hashMap.put("status", str2);
                new com.tencent.mm.plugin.appbrand.page.p().L(hashMap).g(appBrandRuntime.NY()).bEo();
                AppMethodBeat.o(219190);
            }
        });
        this.mInitialized = false;
        synchronized (this) {
            try {
                this.mDestroyed = false;
            } catch (Throwable th) {
                AppMethodBeat.o(134474);
                throw th;
            }
        }
        this.SO = false;
        this.kAJ = false;
        this.kAK = false;
        this.kAL = false;
        Log.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| init end appId:%s", this.mAppId);
        AppMethodBeat.o(134474);
    }

    public final void brd() {
        AppMethodBeat.i(134475);
        this.mResumed = true;
        long currentTicks = Util.currentTicks();
        Log.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| launch start appId:%s", this.mAppId);
        bre();
        com.tencent.luggage.sdk.g.c.a("AppBrandRuntimeProfile| onCreatePrivate" + this.mAppId, new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass18 */

            public final void run() {
                AppMethodBeat.i(219191);
                AppBrandRuntime.f(AppBrandRuntime.this);
                AppMethodBeat.o(219191);
            }
        });
        com.tencent.luggage.sdk.g.c.a("AppBrandRuntimeProfile| prepare(AllDoneInitNotify)" + this.mAppId, new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass19 */

            public final void run() {
                AppMethodBeat.i(134463);
                AppBrandRuntime.a(AppBrandRuntime.this, new c(AppBrandRuntime.this, (byte) 0));
                AppMethodBeat.o(134463);
            }
        });
        com.tencent.luggage.sdk.g.c.a("AppBrandRuntimeProfile| showSplash " + this.mAppId, new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass20 */

            public final void run() {
                AppMethodBeat.i(134464);
                AppBrandRuntime.this.brp();
                AppMethodBeat.o(134464);
            }
        });
        this.kAY.startTimer(10000);
        Log.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| launch end appId:%s, cost:%dms", this.mAppId, Long.valueOf(Util.currentTicks() - currentTicks));
        AppMethodBeat.o(134475);
    }

    /* access modifiers changed from: protected */
    public void bre() {
    }

    class c implements a, com.tencent.mm.vending.e.a {
        private final String kBt;
        volatile boolean kBu;

        private c() {
            AppMethodBeat.i(134470);
            this.kBt = "MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify";
            Log.i("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "<init> appId[%s] hash[%d]", AppBrandRuntime.this.mAppId, Integer.valueOf(hashCode()));
            AppBrandRuntime.this.keep(this);
            this.kBu = false;
            AppMethodBeat.o(134470);
        }

        /* synthetic */ c(AppBrandRuntime appBrandRuntime, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime.a
        public final void done() {
            AppMethodBeat.i(134471);
            if (!this.kBu) {
                AppBrandRuntime.this.i(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.c.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(134469);
                        if (!c.this.kBu) {
                            AppBrandRuntime.this.kAW = null;
                            AppBrandRuntime.h(AppBrandRuntime.this);
                            AppMethodBeat.o(134469);
                            return;
                        }
                        Log.e("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "PrepareAllDoneInitNotify.done() hash[%d] check2 dead appId[%s]", Integer.valueOf(hashCode()), AppBrandRuntime.this.mAppId);
                        AppMethodBeat.o(134469);
                    }
                }, 0);
                AppMethodBeat.o(134471);
                return;
            }
            Log.e("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "PrepareAllDoneInitNotify.done() hash[%d] check1 dead appId[%s]", Integer.valueOf(hashCode()), AppBrandRuntime.this.mAppId);
            AppMethodBeat.o(134471);
        }

        @Override // com.tencent.mm.vending.e.a
        public final void dead() {
            this.kBu = true;
        }
    }

    public static abstract class b {
        a kBs;

        public abstract void prepare();

        public void interrupt() {
        }

        public void KY() {
            if (this.kBs != null) {
                this.kBs.done();
            }
        }
    }

    public final void a(b bVar) {
        AppMethodBeat.i(134476);
        this.kAV.add(bVar);
        AppMethodBeat.o(134476);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007a, code lost:
        if (r8.ldK == r7.kAq.ldK) goto L_0x007c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig r8) {
        /*
        // Method dump skipped, instructions count: 126
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.AppBrandRuntime.d(com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig):void");
    }

    /* access modifiers changed from: protected */
    public void a(AppBrandInitConfig appBrandInitConfig) {
        this.kAq = appBrandInitConfig;
    }

    public final String getAppId() {
        return this.mAppId;
    }

    public final int brf() {
        return this.kAq.eix;
    }

    public final AppBrandRuntime brg() {
        AppMethodBeat.i(134478);
        if (this.kAl == null) {
            AppMethodBeat.o(134478);
            return null;
        }
        AppBrandRuntime u = this.kAl.u(this);
        AppMethodBeat.o(134478);
        return u;
    }

    public final boolean isInBackStack() {
        AppMethodBeat.i(134479);
        if (this.kAl == null || !this.kAl.v(this)) {
            AppMethodBeat.o(134479);
            return false;
        }
        AppMethodBeat.o(134479);
        return true;
    }

    public s NY() {
        return this.kAr;
    }

    public w brh() {
        return this.kAs;
    }

    public final ak bri() {
        return this.kAl;
    }

    public bw getDecorWidgetFactory() {
        return null;
    }

    public final Context getAppContext() {
        return this.mContext;
    }

    public final Activity getContext() {
        AppMethodBeat.i(259543);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.mContext);
        AppMethodBeat.o(259543);
        return castActivityOrNull;
    }

    public com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid() {
        AppMethodBeat.i(176502);
        if (this.kAl == null) {
            Object[] objArr = new Object[2];
            objArr[0] = this.mAppId;
            objArr[1] = this.kAm == null ? null : this.kAm.getClass().getName();
            Log.e("MicroMsg.AppBrandRuntime", "getWindowAndroid getRuntimeContainer is NULL appId[%s], return default %s", objArr);
            if (this.kAm != null) {
                com.tencent.mm.plugin.appbrand.platform.window.c cVar = this.kAm;
                AppMethodBeat.o(176502);
                return cVar;
            }
            o oVar = new o();
            this.kAm = oVar;
            AppMethodBeat.o(176502);
            return oVar;
        }
        com.tencent.mm.plugin.appbrand.platform.window.c windowAndroid = this.kAl.getWindowAndroid();
        AppMethodBeat.o(176502);
        return windowAndroid;
    }

    public final void a(com.tencent.mm.plugin.appbrand.platform.window.c cVar) {
        this.kAm = cVar;
    }

    public final com.tencent.mm.plugin.appbrand.widget.c brj() {
        return this.kAt;
    }

    public AppBrandInitConfig OU() {
        return this.kAq;
    }

    public final void ct(View view) {
        AppMethodBeat.i(219200);
        az.RemoteDebugFloatView.a(this, view);
        AppMethodBeat.o(219200);
    }

    public l OT() {
        AppMethodBeat.i(134481);
        l lVar = (l) av(l.class);
        AppMethodBeat.o(134481);
        return lVar;
    }

    public final com.tencent.mm.plugin.appbrand.config.b getAppConfig() {
        AppMethodBeat.i(134482);
        com.tencent.mm.plugin.appbrand.config.b bVar = (com.tencent.mm.plugin.appbrand.config.b) d(com.tencent.mm.plugin.appbrand.config.b.class, false);
        AppMethodBeat.o(134482);
        return bVar;
    }

    public void brk() {
    }

    public final com.tencent.mm.plugin.appbrand.a.c brl() {
        return this.kAH;
    }

    /* access modifiers changed from: protected */
    public com.tencent.mm.plugin.appbrand.p.a OR() {
        AppMethodBeat.i(134484);
        a.c cVar = new a.c();
        AppMethodBeat.o(134484);
        return cVar;
    }

    public q getFileSystem() {
        return this.kAz;
    }

    public final void brm() {
        AppMethodBeat.i(134485);
        if (this.kAz == null) {
            this.kAz = OL();
        }
        AppMethodBeat.o(134485);
    }

    /* access modifiers changed from: protected */
    public q OL() {
        AppMethodBeat.i(134486);
        com.tencent.mm.plugin.appbrand.appstorage.w wVar = new com.tencent.mm.plugin.appbrand.appstorage.w(this);
        AppMethodBeat.o(134486);
        return wVar;
    }

    public final com.tencent.mm.plugin.appbrand.widget.dialog.m getDialogContainer() {
        return this.jCK;
    }

    public final com.tencent.mm.plugin.appbrand.widget.dialog.m brn() {
        return this.kAv;
    }

    /* access modifiers changed from: protected */
    public ab bro() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final void brp() {
        String simpleName;
        AppMethodBeat.i(134487);
        if (this.kAu != null) {
            com.tencent.mm.plugin.appbrand.ui.l.a(this.kAu);
            this.kAu = null;
        }
        ab bro = bro();
        if (bro == null) {
            AppMethodBeat.o(134487);
            return;
        }
        bro.eo(OU().iconUrl, OU().brandName);
        final View view = bro.getView();
        az.LoadingSplash.a(this, view);
        this.kAu = bro;
        Object[] objArr = new Object[2];
        objArr[0] = this.mAppId;
        if (this.kAu == null) {
            simpleName = BuildConfig.COMMAND;
        } else {
            simpleName = this.kAu.getClass().getSimpleName();
        }
        objArr[1] = simpleName;
        Log.i("MicroMsg.AppBrandRuntime", "showSplash[AppBrandSplashAd], appId:%s, splash:%s", objArr);
        view.setClickable(true);
        this.kAt.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass22 */

            public final void onChildViewAdded(View view, View view2) {
            }

            public final void onChildViewRemoved(View view, View view2) {
                AppMethodBeat.i(219195);
                if (view2 == view && !AppBrandRuntime.this.isDestroyed()) {
                    AnonymousClass1 r0 = new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass22.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(219194);
                            if (AppBrandRuntime.this.mResumed) {
                                AppBrandRuntime.this.brh().setActuallyVisible(true);
                                AppMethodBeat.o(219194);
                                return;
                            }
                            AppBrandRuntime.this.kAH.a(new c.a() {
                                /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass22.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.appbrand.a.c.a
                                public final void a(String str, com.tencent.mm.plugin.appbrand.a.b bVar) {
                                    AppMethodBeat.i(219193);
                                    if (com.tencent.mm.plugin.appbrand.a.b.kQH == bVar) {
                                        AppBrandRuntime.this.brh().setActuallyVisible(true);
                                        AppBrandRuntime.this.kAH.b(this);
                                    }
                                    AppMethodBeat.o(219193);
                                }
                            });
                            AppMethodBeat.o(219194);
                        }
                    };
                    AppBrandRuntime.this.brq();
                    if (AppBrandRuntime.this.brh() == null) {
                        AppBrandRuntime.this.O(r0);
                        AppMethodBeat.o(219195);
                        return;
                    }
                    r0.run();
                }
                AppMethodBeat.o(219195);
            }
        });
        AppMethodBeat.o(134487);
    }

    /* access modifiers changed from: protected */
    public void brq() {
    }

    public final void brr() {
        AppMethodBeat.i(134488);
        if (isDestroyed()) {
            if (this.kAu != null) {
                com.tencent.mm.plugin.appbrand.ui.l.a(this.kAu);
            }
            this.kAu = null;
            AppMethodBeat.o(134488);
        } else if (this.kAu == null) {
            AppMethodBeat.o(134488);
        } else {
            Log.printInfoStack("MicroMsg.AppBrandRuntime", "hideSplash[AppBrandSplashAd], splash:%s", this.kAu.getClass().getSimpleName());
            AnonymousClass23 r1 = new kotlin.g.a.a<x>() {
                /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass23 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* bridge */ /* synthetic */ x invoke() {
                    AppBrandRuntime.this.kAu = null;
                    return null;
                }
            };
            if (this.kAu instanceof af) {
                Log.i("MicroMsg.AppBrandRuntime", "[weishi] hideSplash, hideLoadingSplashFromRuntime");
                ((af) this.kAu).B(r1);
                AppMethodBeat.o(134488);
                return;
            }
            this.kAu.z(r1);
            AppMethodBeat.o(134488);
        }
    }

    public final String brs() {
        AppMethodBeat.i(134489);
        if (this.kAq == null) {
            AppMethodBeat.o(134489);
            return "";
        } else if (!Util.isNullOrNil(this.kAq.kHw)) {
            String str = this.kAq.kHw;
            AppMethodBeat.o(134489);
            return str;
        } else if (getAppConfig() == null) {
            AppMethodBeat.o(134489);
            return "";
        } else {
            String bzI = getAppConfig().bzI();
            AppMethodBeat.o(134489);
            return bzI;
        }
    }

    public final <T extends m> T d(Class<T> cls, boolean z) {
        T t;
        AppMethodBeat.i(134490);
        m mVar = null;
        Iterator<m> descendingIterator = this.kAA.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                break;
            }
            m next = descendingIterator.next();
            if (cls.isInstance(next)) {
                mVar = next;
                break;
            }
        }
        if (mVar != null || !z) {
            t = (T) mVar;
        } else {
            try {
                t = (T) ((m) org.a.a.bF(cls).hPX().object);
                if (t != null) {
                    try {
                        this.kAA.add(t);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.AppBrandRuntime", "Make sure %s has default constructor", cls.getName());
                        AppMethodBeat.o(134490);
                        return t;
                    }
                }
            } catch (Exception e3) {
                t = (T) mVar;
                Log.e("MicroMsg.AppBrandRuntime", "Make sure %s has default constructor", cls.getName());
                AppMethodBeat.o(134490);
                return t;
            }
        }
        AppMethodBeat.o(134490);
        return t;
    }

    public final <T extends m> T av(Class<T> cls) {
        AppMethodBeat.i(134491);
        T t = (T) d(cls, !this.kAU);
        AppMethodBeat.o(134491);
        return t;
    }

    public final <T extends n> T aw(Class<T> cls) {
        AppMethodBeat.i(134492);
        if (cls == null) {
            AppMethodBeat.o(134492);
            return null;
        }
        synchronized (this.kAE) {
            try {
                Iterator<n> it = this.kAE.iterator();
                while (it.hasNext()) {
                    T t = (T) it.next();
                    if (cls.isInstance(t)) {
                        return t;
                    }
                }
                AppMethodBeat.o(134492);
                return null;
            } finally {
                AppMethodBeat.o(134492);
            }
        }
    }

    public final boolean a(n nVar) {
        AppMethodBeat.i(134493);
        if (nVar == null) {
            AppMethodBeat.o(134493);
            return false;
        }
        synchronized (this.kAE) {
            try {
                this.kAE.add(nVar);
            } catch (Throwable th) {
                AppMethodBeat.o(134493);
                throw th;
            }
        }
        AppMethodBeat.o(134493);
        return true;
    }

    public final boolean b(n nVar) {
        AppMethodBeat.i(219201);
        if (nVar == null) {
            AppMethodBeat.o(219201);
            return false;
        }
        synchronized (this.kAE) {
            try {
                this.kAE.remove(nVar);
            } catch (Throwable th) {
                AppMethodBeat.o(219201);
                throw th;
            }
        }
        AppMethodBeat.o(219201);
        return true;
    }

    public final <T extends com.tencent.mm.kernel.c.a> T af(Class<T> cls) {
        AppMethodBeat.i(134494);
        com.tencent.mm.kernel.c.a ap = this.kAF.ap(cls);
        if (ap != null) {
            T cast = cls.cast(ap);
            AppMethodBeat.o(134494);
            return cast;
        } else if (cls == g.class) {
            T cast2 = cls.cast(g.olr);
            AppMethodBeat.o(134494);
            return cast2;
        } else {
            T t = (T) V(cls);
            AppMethodBeat.o(134494);
            return t;
        }
    }

    /* access modifiers changed from: protected */
    public <T extends com.tencent.mm.kernel.c.a> T V(Class<T> cls) {
        return null;
    }

    public final <T extends com.tencent.mm.kernel.c.a, N extends T> void b(Class<T> cls, N n) {
        AppMethodBeat.i(134495);
        this.kAF.b(cls, n);
        AppMethodBeat.o(134495);
    }

    public final void ag(Class<? extends com.tencent.mm.kernel.c.a> cls) {
        AppMethodBeat.i(134496);
        this.kAF.ag(cls);
        AppMethodBeat.o(134496);
    }

    public final boolean isDestroyed() {
        boolean z;
        synchronized (this) {
            z = this.mDestroyed;
        }
        return z;
    }

    public final boolean isFinishing() {
        return this.SO;
    }

    public final boolean brt() {
        return this.mInitialized;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(final Configuration configuration) {
        AppMethodBeat.i(176503);
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass2 */

            public final boolean queueIdle() {
                AppMethodBeat.i(176491);
                AppBrandRuntime.a(AppBrandRuntime.this, configuration);
                AppMethodBeat.o(176491);
                return false;
            }
        });
        if (this.kAQ != null) {
            f fVar = this.kAQ;
            Log.i(fVar.cDW, "onConfigurationChanged: newConfig: ".concat(String.valueOf(configuration)));
            if (fVar.nDg != null) {
                com.tencent.mm.plugin.appbrand.pip.b bVar = fVar.nDg;
                Log.i(bVar.cDW, "onConfigurationChanged");
                if (!bVar.nCc) {
                    Log.d(bVar.cDW, "onConfigurationChanged, false == mHandleStarted");
                    AppMethodBeat.o(176503);
                    return;
                }
                bVar.nBZ.a(bVar.cwK, new g.a() {
                    /* class com.tencent.mm.plugin.appbrand.pip.b.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.g.a
                    public final void ef(int i2, int i3) {
                        AppMethodBeat.i(219497);
                        if (b.this.mJZ) {
                            Log.i(b.this.cDW, "onConfigurationChanged, onVideoPositionGot, released");
                            AppMethodBeat.o(219497);
                            return;
                        }
                        b.this.kAR.a(b.a(b.this, i2, i3, null));
                        AppMethodBeat.o(219497);
                    }
                });
            }
        }
        AppMethodBeat.o(176503);
    }

    /* access modifiers changed from: protected */
    public void OO() {
    }

    /* access modifiers changed from: protected */
    public void brv() {
    }

    /* access modifiers changed from: protected */
    public s brw() {
        AppMethodBeat.i(134497);
        s sVar = new s();
        AppMethodBeat.o(134497);
        return sVar;
    }

    /* access modifiers changed from: protected */
    public w brx() {
        AppMethodBeat.i(134498);
        w wVar = new w(this.mContext, this);
        AppMethodBeat.o(134498);
        return wVar;
    }

    public boolean bry() {
        return false;
    }

    private void brz() {
        AppMethodBeat.i(134499);
        com.tencent.luggage.sdk.g.c.a(this.mAppId + ":performInitPageContainer", new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(134447);
                AppBrandRuntime.this.kAs = AppBrandRuntime.this.brx();
                AppBrandRuntime.this.kAs.setOnReadyListener(new w.f() {
                    /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass5.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.page.w.f
                    public final void brP() {
                        AppMethodBeat.i(176492);
                        AppBrandRuntime.m(AppBrandRuntime.this);
                        AppBrandRuntime.a(AppBrandRuntime.this, (Configuration) null);
                        AppMethodBeat.o(176492);
                    }
                });
                az.AppBrandPageContainer.a(AppBrandRuntime.this, AppBrandRuntime.this.kAs);
                AppBrandRuntime.this.kAs.init(AppBrandRuntime.this.kAq.kHw);
                AppMethodBeat.o(134447);
            }
        });
        AppMethodBeat.o(134499);
    }

    private void brA() {
        AppMethodBeat.i(134500);
        com.tencent.luggage.sdk.g.c.a(this.mAppId + ":performInitService", new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(134448);
                com.tencent.mm.plugin.appbrand.keylogger.c.a(AppBrandRuntime.this.mAppId, KSProcessWeAppLaunch.stepServiceInit);
                com.tencent.mm.plugin.appbrand.keylogger.c.a(AppBrandRuntime.this.mAppId, KSProcessWeAppLaunch.stepServiceInit_Game);
                AppBrandRuntime.this.kAr.init();
                AppMethodBeat.o(134448);
            }
        });
        AppMethodBeat.o(134500);
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        AppMethodBeat.i(134501);
        AppMethodBeat.o(134501);
    }

    /* access modifiers changed from: protected */
    public boolean N(Runnable runnable) {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void a(aw awVar) {
        AppMethodBeat.i(219204);
        av avVar = this.kAD;
        if (avVar.kFB.get()) {
            AppMethodBeat.o(219204);
            return;
        }
        avVar.kFA.add(awVar);
        AppMethodBeat.o(219204);
    }

    /* access modifiers changed from: protected */
    public final void dispatchPause() {
        AppMethodBeat.i(176504);
        if (!this.mInitialized) {
            AppMethodBeat.o(176504);
        } else if (isDestroyed()) {
            AppMethodBeat.o(176504);
        } else {
            Log.i("MicroMsg.AppBrandRuntime", "onPause: %s", this.mAppId);
            this.mResumed = false;
            onPause();
            this.kAH.kQM.a(d.a.TO_BACKGROUND);
            this.kAr.Mx();
            this.kAs.onBackground();
            h.TX(this.mAppId);
            h.a(this.mAppId, h.b.ON_PAUSE);
            Log.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onPause");
            try {
                ScreenShotUtil.setScreenShotCallback(MMApplicationContext.getContext(), null);
                AppMethodBeat.o(176504);
            } catch (SecurityException e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandUserCaptureScreenMonitor", e2, "[NOT CRASH] pause set null callback", new Object[0]);
                AppMethodBeat.o(176504);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
    }

    /* access modifiers changed from: protected */
    public final void dispatchResume() {
        AppMethodBeat.i(176508);
        if (!this.mInitialized) {
            AppMethodBeat.o(176508);
            return;
        }
        Log.i("MicroMsg.AppBrandRuntime", "onResume: %s", this.mAppId);
        if (isDestroyed() || this.kAJ) {
            this.mResumed = true;
            a((AppBrandInitConfig) null, "");
            AppMethodBeat.o(176508);
            return;
        }
        this.mResumed = true;
        h.Ub(this.mAppId);
        h.TY(this.mAppId);
        h.a(this.mAppId, h.b.ON_RESUME);
        boolean z = this.kAK;
        this.kAs.onForeground();
        this.kAH.kQM.a(d.a.TO_FOREGROUND, "onRuntimeResume");
        this.kAr.bX(z);
        onResume();
        if (z) {
            this.kAs.ax(brs(), true);
        }
        com.tencent.mm.plugin.appbrand.utils.e eVar = this.kAG;
        Log.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onResume");
        try {
            ScreenShotUtil.setScreenShotCallback(MMApplicationContext.getContext(), eVar.ogG);
        } catch (SecurityException e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandUserCaptureScreenMonitor", e2, "[NOT CRASH] resume set callback", new Object[0]);
        }
        brI();
        this.kAJ = false;
        this.kAK = false;
        AppMethodBeat.o(176508);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
    }

    /* access modifiers changed from: protected */
    public void brB() {
    }

    /* access modifiers changed from: protected */
    public final void onBackPressed() {
        AppMethodBeat.i(219206);
        if (this.kAu != null) {
            h.a(this.mAppId, h.d.BACK);
            finish();
        } else if (this.kAv.onBackPressed()) {
            AppMethodBeat.o(219206);
            return;
        } else if (this.jCK.onBackPressed()) {
            AppMethodBeat.o(219206);
            return;
        } else if (this.kAs != null) {
            this.kAs.onBackPressed();
            AppMethodBeat.o(219206);
            return;
        }
        AppMethodBeat.o(219206);
    }

    /* access modifiers changed from: package-private */
    public final void dispatchDestroy() {
        com.tencent.mm.plugin.appbrand.jsapi.websocket.d remove;
        AppMethodBeat.i(176506);
        boolean isDestroyed = isDestroyed();
        Log.i("MicroMsg.AppBrandRuntime", "dispatchDestroy, finished?[%b] initialized?[%b]", Boolean.valueOf(isDestroyed), Boolean.valueOf(this.mInitialized));
        if (isDestroyed) {
            AppMethodBeat.o(176506);
            return;
        }
        synchronized (this) {
            try {
                this.mDestroyed = true;
            } finally {
                AppMethodBeat.o(176506);
            }
        }
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.kAW;
        this.kAW = null;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            Log.i("MicroMsg.AppBrandRuntime", "cancelAllPrepareProcesses empty list appId[%s]", this.mAppId);
        } else {
            Log.i("MicroMsg.AppBrandRuntime", "cancelAllPrepareProcesses size[%d] appId[%s]", Integer.valueOf(concurrentLinkedQueue.size()), this.mAppId);
            while (!concurrentLinkedQueue.isEmpty()) {
                concurrentLinkedQueue.poll().interrupt();
            }
        }
        onDestroy();
        ba baVar = this.kAo;
        for (com.tencent.mm.vending.e.a aVar : baVar.kFT) {
            aVar.dead();
        }
        baVar.kFT.clear();
        this.kAz = null;
        com.tencent.mm.plugin.appbrand.media.a.a.Zl(this.mAppId);
        AppBrandMainProcessService.b(this.kAX);
        h.TV(this.mAppId);
        h.a(this.mAppId, h.b.ON_DESTROY);
        com.tencent.luggage.h.g.aM(AndroidContextUtil.castActivityOrNull(this.mContext));
        com.tencent.mm.plugin.appbrand.a.c cVar = this.kAH;
        d dVar = cVar.kQM;
        if (!dVar.kQV.get()) {
            Log.printErrStackTrace(dVar.TAG, new Throwable(), "Illegal internal state, stop() called before start()", new Object[0]);
        } else {
            dVar.kQW.set(true);
            if (dVar.bwX()) {
                Log.e(dVar.TAG, "stop() called, but still isInConstruction");
                dVar.quit();
            } else {
                dVar.quitNow();
            }
            dVar.a(com.tencent.mm.plugin.appbrand.a.b.DESTROYED);
        }
        synchronized (cVar.kQN) {
            try {
                cVar.kQN.clear();
            } finally {
                AppMethodBeat.o(176506);
            }
        }
        this.kAM = null;
        com.tencent.mm.plugin.appbrand.s.f bPA = com.tencent.mm.plugin.appbrand.s.f.bPA();
        String str = this.mAppId;
        if (bPA.nhY.containsKey(str)) {
            com.tencent.mm.plugin.appbrand.s.d remove2 = bPA.nhY.remove(str);
            synchronized (remove2.nia) {
                try {
                    remove2.nia.clear();
                } catch (Throwable th) {
                    AppMethodBeat.o(176506);
                    throw th;
                }
            }
            remove2.nic.clear();
            remove2.nib.clear();
        }
        com.tencent.mm.plugin.appbrand.s.c bPx = com.tencent.mm.plugin.appbrand.s.c.bPx();
        String str2 = this.mAppId;
        if (bPx.nhY.containsKey(str2)) {
            bPx.nhY.remove(str2).release();
        }
        i bPC = i.bPC();
        String str3 = this.mAppId;
        if (bPC.nhY.containsKey(str3)) {
            bPC.nhY.remove(str3).release();
        }
        com.tencent.mm.plugin.appbrand.s.l bPF = com.tencent.mm.plugin.appbrand.s.l.bPF();
        String str4 = this.mAppId;
        if (bPF.nhY.containsKey(str4) && (remove = bPF.nhY.remove(str4)) != null) {
            remove.release();
        }
        h.Ua(this.mAppId);
        this.kAt.setOnHierarchyChangeListener(null);
        this.kAt.removeAllViewsInLayout();
        this.jCK.cbm();
        this.kAv.cbm();
        if (this.kAx != null) {
            com.tencent.mm.plugin.appbrand.page.capsulebar.e eVar = this.kAx;
            if (eVar.nvi != null) {
                com.tencent.mm.plugin.appbrand.page.capsulebar.d dVar2 = eVar.nvi;
                if (dVar2 == null) {
                    kotlin.g.b.p.btv("capsuleBarView");
                }
                if (dVar2.nvg != null) {
                    dVar2.nvg.animate().cancel();
                }
                dVar2.removeAllViews();
            }
            if (eVar.nvk != null) {
                com.tencent.mm.plugin.appbrand.page.capsulebar.h hVar = eVar.nvk;
                if (hVar == null) {
                    kotlin.g.b.p.btv("blinkWrapper");
                }
                hVar.clearAnimation();
            }
        }
        this.kAy = null;
        if (this.kAw != null) {
            this.kAw.removeAllViews();
            this.kAw = null;
        }
        if (this.mInitialized) {
            this.kAr.cleanup();
            this.kAr = null;
            this.kAs.cleanup();
            this.kAs = null;
        }
        this.kAA.clear();
        synchronized (this.kAE) {
            try {
                this.kAE.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        bg.N(this);
        this.kAF.unregisterAll();
        this.kAZ.clear();
        this.kAn.removeCallbacksAndMessages(null);
        this.kAY.stopTimer();
        this.kBa.clear();
        z.af(this);
        this.kAC.clear();
        av avVar = this.kAD;
        avVar.kFA.clear();
        avVar.kFB.set(false);
        AppMethodBeat.o(176506);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        AppMethodBeat.i(134504);
        AppMethodBeat.o(134504);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(134507);
        super.finalize();
        this.kAn.removeCallbacksAndMessages(null);
        AppMethodBeat.o(134507);
    }

    public void finish() {
        AppMethodBeat.i(134508);
        if (isDestroyed()) {
            Log.w("MicroMsg.AppBrandRuntime", "finish but destroyed, appId[%s]", this.mAppId);
            AppMethodBeat.o(134508);
            return;
        }
        this.SO = true;
        com.tencent.luggage.h.g.aM(AndroidContextUtil.castActivityOrNull(this.mContext));
        i(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(176493);
                if (AppBrandRuntime.this.kAl == null) {
                    AppBrandRuntime.this.dispatchDestroy();
                    AppMethodBeat.o(176493);
                    return;
                }
                AppBrandRuntime.this.kAl.w(AppBrandRuntime.this);
                AppMethodBeat.o(176493);
            }
        }, 0);
        AppMethodBeat.o(134508);
    }

    /* access modifiers changed from: package-private */
    public final void b(AppBrandInitConfig appBrandInitConfig, Object obj) {
        AppMethodBeat.i(176507);
        a(appBrandInitConfig, obj);
        AppMethodBeat.o(176507);
    }

    /* access modifiers changed from: protected */
    public void a(AppBrandInitConfig appBrandInitConfig, Object obj) {
    }

    public final void R(final Object obj) {
        AppMethodBeat.i(176509);
        i(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(219185);
                if (!AppBrandRuntime.this.mInitialized || AppBrandRuntime.this.isDestroyed()) {
                    if (AppBrandRuntime.this.kAl == null) {
                        AppBrandRuntime.this.dispatchDestroy();
                        AppMethodBeat.o(219185);
                        return;
                    }
                    AppBrandRuntime.this.kAl.w(AppBrandRuntime.this);
                    AppMethodBeat.o(219185);
                } else if (AppBrandRuntime.this.kAl == null) {
                    AppBrandRuntime.this.dispatchPause();
                    AppMethodBeat.o(219185);
                } else {
                    AppBrandRuntime.this.kAl.a(AppBrandRuntime.this, obj);
                    AppMethodBeat.o(219185);
                }
            }
        }, 0);
        AppMethodBeat.o(176509);
    }

    /* access modifiers changed from: protected */
    public final void brC() {
        AppMethodBeat.i(134513);
        this.kAJ = true;
        Log.d("MicroMsg.AppBrandRuntime", "setWillRestart");
        AppMethodBeat.o(134513);
    }

    /* access modifiers changed from: protected */
    public final boolean brD() {
        return this.kAJ;
    }

    /* access modifiers changed from: protected */
    public final boolean brF() {
        return this.kAK;
    }

    public final boolean brG() {
        AppMethodBeat.i(134514);
        if (!this.kAO) {
            AppMethodBeat.o(134514);
            return false;
        }
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.mContext);
        if (castActivityOrNull != null && castActivityOrNull.isFinishing()) {
            AppMethodBeat.o(134514);
            return false;
        } else if (this.kAs == null || this.kAs.getCurrentPage() == null || this.kAs.getCurrentPage().mSwiping) {
            AppMethodBeat.o(134514);
            return false;
        } else {
            AppMethodBeat.o(134514);
            return true;
        }
    }

    public final void gs(boolean z) {
        AppMethodBeat.i(219209);
        this.kAN = z;
        t currentPage = brh() == null ? null : brh().getCurrentPage();
        if (currentPage != null) {
            currentPage.bQP();
        }
        AppMethodBeat.o(219209);
    }

    /* access modifiers changed from: package-private */
    public final void brH() {
        AppMethodBeat.i(134515);
        this.kAH.kQM.a(d.a.ON_DETACH_FROM_STACK);
        h.TW(this.mAppId);
        AppMethodBeat.o(134515);
    }

    public void brI() {
        AppMethodBeat.i(176510);
        Q(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass14 */

            public final void run() {
                final c.a aVar;
                AppMethodBeat.i(134456);
                final com.tencent.mm.plugin.appbrand.platform.window.c windowAndroid = AppBrandRuntime.this.getWindowAndroid();
                if (windowAndroid == null) {
                    AppMethodBeat.o(134456);
                    return;
                }
                com.tencent.mm.plugin.appbrand.config.b appConfig = AppBrandRuntime.this.getAppConfig();
                if (appConfig == null) {
                    aVar = new c.a(AppBrandRuntime.this.OU().brandName);
                } else {
                    aVar = new c.a(AppBrandRuntime.this.OU().brandName, null, com.tencent.mm.plugin.appbrand.ac.g.cu(appConfig.bzF().lci, WebView.NIGHT_MODE_COLOR));
                }
                windowAndroid.setWindowDescription(aVar);
                com.tencent.mm.modelappbrand.a.b.aXY().a(new b.c() {
                    /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass14.AnonymousClass1 */

                    @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.b.c
                    public final void I(Bitmap bitmap) {
                        AppMethodBeat.i(219189);
                        windowAndroid.setWindowDescription(new c.a(aVar.label, bitmap, aVar.colorPrimary));
                        AppMethodBeat.o(219189);
                    }
                }, AppBrandRuntime.this.OU().iconUrl, com.tencent.mm.modelappbrand.a.g.iJB);
                AppMethodBeat.o(134456);
            }
        });
        AppMethodBeat.o(176510);
    }

    public boolean brJ() {
        AppMethodBeat.i(134517);
        if (this.kAH.kQM.bwY() == com.tencent.mm.plugin.appbrand.a.b.SUSPEND) {
            dispatchDestroy();
            AppMethodBeat.o(134517);
            return true;
        }
        AppMethodBeat.o(134517);
        return false;
    }

    public final void P(Runnable runnable) {
        AppMethodBeat.i(259544);
        i(runnable, 0);
        AppMethodBeat.o(259544);
    }

    public final void i(Runnable runnable, long j2) {
        AppMethodBeat.i(134520);
        if (runnable == null) {
            AppMethodBeat.o(134520);
        } else if (isDestroyed()) {
            Log.w("MicroMsg.AppBrandRuntime", "scheduleToUiThreadDelayed() but finished, stackTrace = %s", android.util.Log.getStackTraceString(new Throwable()));
            AppMethodBeat.o(134520);
        } else {
            if (j2 < 0) {
                j2 = 0;
            }
            if (!MMHandlerThread.isMainThread() || 0 != j2) {
                u a2 = u.a(this.kAo, runnable);
                keep(a2);
                this.kAn.postDelayed(a2, j2);
                AppMethodBeat.o(134520);
                return;
            }
            runnable.run();
            AppMethodBeat.o(134520);
        }
    }

    public final void Q(Runnable runnable) {
        AppMethodBeat.i(219211);
        if (isDestroyed()) {
            AppMethodBeat.o(219211);
            return;
        }
        u a2 = u.a(this.kAo, runnable);
        keep(a2);
        com.tencent.f.h.RTc.o(a2, 0);
        AppMethodBeat.o(219211);
    }

    /* access modifiers changed from: protected */
    public ab brK() {
        return this.kAu;
    }

    public final boolean isResumed() {
        return this.mResumed;
    }

    public final void a(final int i2, final int i3, final al alVar) {
        AppMethodBeat.i(178506);
        Log.i("MicroMsg.AppBrandRuntime", "addKeyEventObserver");
        i(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass15 */

            public final void run() {
                AppMethodBeat.i(134457);
                Log.i("MicroMsg.AppBrandRuntime", "addKeyEventObserver#scheduled");
                alVar.kEW = i3;
                alVar.kEV = i2;
                boolean z = AppBrandRuntime.this.kBa.get(alVar.kEV) != null;
                Set copyOnWriteArraySet = z ? (Set) AppBrandRuntime.this.kBa.get(alVar.kEV) : new CopyOnWriteArraySet();
                copyOnWriteArraySet.add(alVar);
                if (!z) {
                    AppBrandRuntime.this.kBa.put(alVar.kEV, copyOnWriteArraySet);
                }
                AppMethodBeat.o(134457);
            }
        }, 0);
        AppMethodBeat.o(178506);
    }

    public final void a(final al alVar) {
        AppMethodBeat.i(134522);
        i(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass16 */

            public final void run() {
                AppMethodBeat.i(176497);
                Set set = (Set) AppBrandRuntime.this.kBa.get(alVar.kEV);
                if (set != null) {
                    set.remove(alVar);
                }
                AppMethodBeat.o(176497);
            }
        }, 0);
        AppMethodBeat.o(134522);
    }

    public final com.tencent.mm.plugin.appbrand.ad.f getRuntimeAdViewContainer() {
        String simpleName;
        AppMethodBeat.i(176513);
        com.tencent.mm.plugin.appbrand.ad.f fVar = null;
        if (this.kAu instanceof ac) {
            Log.d("MicroMsg.AppBrandRuntime", "getRuntimeAdViewContainer, appId:%s, use AdLoadingSplash RuntimeAdViewContainer", this.mAppId);
            fVar = ((ac) this.kAu).getRuntimeAdViewContainer();
        } else if (this.kAw != null) {
            Log.d("MicroMsg.AppBrandRuntime", "getRuntimeAdViewContainer, appId:%s, use secondaryRuntimeAdViewContainer", this.mAppId);
            fVar = this.kAw;
        }
        Object[] objArr = new Object[3];
        objArr[0] = fVar;
        objArr[1] = this.mAppId;
        if (this.kAu == null) {
            simpleName = BuildConfig.COMMAND;
        } else {
            simpleName = this.kAu.getClass().getSimpleName();
        }
        objArr[2] = simpleName;
        Log.i("MicroMsg.AppBrandRuntime", "getRuntimeAdViewContainer:%s, appId:%s, splash:%s", objArr);
        AppMethodBeat.o(176513);
        return fVar;
    }

    public final boolean brL() {
        AppMethodBeat.i(219212);
        if (this.kAy == null) {
            this.kAy = Boolean.valueOf(((k) com.tencent.luggage.a.e.M(k.class)).H(this));
        }
        boolean booleanValue = this.kAy.booleanValue();
        AppMethodBeat.o(219212);
        return booleanValue;
    }

    public final boolean brM() {
        boolean z;
        String simpleName;
        AppMethodBeat.i(219213);
        if (this.kAu instanceof ac) {
            z = ((ac) this.kAu).brM();
        } else {
            z = false;
        }
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = this.mAppId;
        if (this.kAu == null) {
            simpleName = BuildConfig.COMMAND;
        } else {
            simpleName = this.kAu.getClass().getSimpleName();
        }
        objArr[2] = simpleName;
        Log.i("MicroMsg.AppBrandRuntime", "isShowingSplashAd[AppBrandSplashAd]:%s, appId:%s, splash:%s", objArr);
        AppMethodBeat.o(219213);
        return z;
    }

    public final void brN() {
        this.kAu = null;
    }

    public final void brO() {
        this.kAP = true;
    }

    public final void b(com.tencent.mm.plugin.appbrand.config.b bVar) {
        AppMethodBeat.i(134483);
        this.kAA.add(bVar);
        AppMethodBeat.o(134483);
    }

    /* access modifiers changed from: protected */
    public void bru() {
        AppMethodBeat.i(219202);
        this.kAD.bru();
        AppMethodBeat.o(219202);
    }

    /* access modifiers changed from: protected */
    public final void a(aq aqVar) {
        AppMethodBeat.i(219203);
        if (this.mInitialized) {
            aqVar.btr();
            AppMethodBeat.o(219203);
            return;
        }
        this.kAC.add(aqVar);
        AppMethodBeat.o(219203);
    }

    /* access modifiers changed from: protected */
    public void onReady() {
        AppMethodBeat.i(219205);
        this.kAr.getJsRuntime().evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.log('xxx ntrans ntrans_init_service start'); }\n", null);
        this.kAr.getJsRuntime().evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.serviceId = ntrans.id; }\n", null);
        AppMethodBeat.o(219205);
    }

    /* access modifiers changed from: protected */
    public void a(AppBrandInitConfig appBrandInitConfig, String str) {
        AppMethodBeat.i(219207);
        if (!this.mResumed) {
            Log.i("MicroMsg.AppBrandRuntime", "reload but !isResumed, destroy and update config, appId:%s, reason:%s", this.mAppId, str);
            dispatchDestroy();
            if (appBrandInitConfig != null) {
                this.kAq = appBrandInitConfig;
            }
            AppMethodBeat.o(219207);
            return;
        }
        Log.i("MicroMsg.AppBrandRuntime", "reload --START-- appId:%s, reason:%s stacktrace=%s", this.mAppId, str, android.util.Log.getStackTraceString(new Throwable()));
        dispatchPause();
        dispatchDestroy();
        if (appBrandInitConfig == null) {
            appBrandInitConfig = OU();
        }
        c(appBrandInitConfig);
        brd();
        Log.i("MicroMsg.AppBrandRuntime", "reload --END-- appId:%s", this.mAppId);
        AppMethodBeat.o(219207);
    }

    public void close() {
        AppMethodBeat.i(134511);
        com.tencent.luggage.h.g.aM(AndroidContextUtil.castActivityOrNull(this.mContext));
        R(null);
        AppMethodBeat.o(134511);
    }

    /* access modifiers changed from: protected */
    public final void brE() {
        AppMethodBeat.i(219208);
        if (this.kAJ) {
            Log.w("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s, ignore by willRestart", this.mAppId);
            AppMethodBeat.o(219208);
            return;
        }
        this.kAK = true;
        Log.i("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s", this.mAppId);
        AppMethodBeat.o(219208);
    }

    public final void O(Runnable runnable) {
        AppMethodBeat.i(134518);
        if (this.SO || isDestroyed()) {
            Log.w("MicroMsg.AppBrandRuntime", "runOnRuntimeInitialized runtime[%s] finishing, stack %s", this.mAppId, android.util.Log.getStackTraceString(new Throwable()));
            AppMethodBeat.o(134518);
        } else if (this.mInitialized) {
            i(runnable, 0);
            AppMethodBeat.o(134518);
        } else {
            this.kAZ.offerLast(runnable);
            AppMethodBeat.o(134518);
        }
    }

    static /* synthetic */ void f(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(160927);
        Log.i("MicroMsg.AppBrandRuntime", "appOnCreate: %s, %s", appBrandRuntime.kAq.brandName, appBrandRuntime.kAq.appId);
        AppBrandMainProcessService.a(appBrandRuntime.kAX);
        appBrandRuntime.b(com.tencent.mm.plugin.appbrand.jsapi.base.g.class, new aa());
        appBrandRuntime.b(com.tencent.mm.plugin.appbrand.networking.d.class, new com.tencent.mm.plugin.appbrand.networking.f(appBrandRuntime));
        appBrandRuntime.b(com.tencent.mm.plugin.appbrand.f.b.class, new com.tencent.mm.plugin.appbrand.luggage.b.l(appBrandRuntime));
        appBrandRuntime.b(com.tencent.mm.plugin.appbrand.f.a.class, new com.tencent.mm.plugin.appbrand.luggage.b.k(appBrandRuntime));
        appBrandRuntime.onCreate();
        com.tencent.mm.plugin.appbrand.media.a.a.onCreate(appBrandRuntime.mAppId);
        appBrandRuntime.kAH.kQM.a(d.a.TO_FOREGROUND, "onRuntimeCreate");
        h.Ub(appBrandRuntime.mAppId);
        h.TU(appBrandRuntime.mAppId);
        h.a(appBrandRuntime.mAppId, h.b.ON_CREATE);
        appBrandRuntime.brI();
        AppMethodBeat.o(160927);
    }

    static /* synthetic */ void a(AppBrandRuntime appBrandRuntime, final a aVar) {
        AppMethodBeat.i(176515);
        final ConcurrentLinkedQueue<b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>(appBrandRuntime.kAV);
        appBrandRuntime.kAW = concurrentLinkedQueue;
        appBrandRuntime.kAV = new LinkedList<>();
        Iterator<b> it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            final b next = it.next();
            next.kBs = new a() {
                /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass21 */

                @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime.a
                public final void done() {
                    AppMethodBeat.i(219192);
                    if (!concurrentLinkedQueue.remove(next)) {
                        Log.e("MicroMsg.AppBrandRuntime", "AppBrandRuntime[%s].prepare() duplicate ready() called, PrepareProcess[%s]", AppBrandRuntime.this.mAppId, next);
                        AppMethodBeat.o(219192);
                        return;
                    }
                    Log.i("MicroMsg.AppBrandRuntime", "AppBrandRuntime[%s].prepare() PrepareProcess[%s] done", AppBrandRuntime.this.mAppId, next);
                    if (concurrentLinkedQueue.isEmpty()) {
                        aVar.done();
                    }
                    AppMethodBeat.o(219192);
                }
            };
            next.prepare();
        }
        AppMethodBeat.o(176515);
    }

    static /* synthetic */ void h(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(219214);
        if (!appBrandRuntime.isDestroyed()) {
            if (appBrandRuntime.mInitialized) {
                Log.e("MicroMsg.AppBrandRuntime", "initRuntime, mInitialized TRUE !!!  go check callee %s", Util.stackTraceToString(new Throwable()));
                AppMethodBeat.o(219214);
                return;
            }
            Log.i("MicroMsg.AppBrandRuntime", "initRuntime %s", appBrandRuntime.mAppId);
            new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(134446);
                    if (AppBrandRuntime.this.isDestroyed()) {
                        AppMethodBeat.o(134446);
                        return;
                    }
                    AppBrandRuntime.i(AppBrandRuntime.this);
                    AppBrandRuntime.this.mInitialized = true;
                    AppBrandRuntime.k(AppBrandRuntime.this);
                    AppBrandRuntime.l(AppBrandRuntime.this);
                    AppMethodBeat.o(134446);
                }
            }.run();
        }
        AppMethodBeat.o(219214);
    }

    static /* synthetic */ void a(AppBrandRuntime appBrandRuntime, Configuration configuration) {
        AppMethodBeat.i(219215);
        if (appBrandRuntime.kAs == null) {
            AppMethodBeat.o(219215);
            return;
        }
        t currentPage = appBrandRuntime.kAs.getCurrentPage();
        if (currentPage == null) {
            AppMethodBeat.o(219215);
            return;
        }
        com.tencent.mm.plugin.appbrand.widget.actionbar.d bRj = currentPage.getCurrentPageView().bRj();
        if (!(appBrandRuntime.kAR == null || bRj == null)) {
            int height = bRj.getHeight();
            Log.d("MicroMsg.AppBrandRuntime", "adjustPipContainerViewPositionRange, actionBarContainerHeight: ".concat(String.valueOf(height)));
            AppBrandPipContainerView appBrandPipContainerView = appBrandRuntime.kAR;
            appBrandPipContainerView.okw = Integer.valueOf(height - AppBrandPipContainerView.oko);
            if (configuration != null) {
                View view = (View) appBrandPipContainerView.getParent();
                if (view == null) {
                    Log.d("MicroMsg.AppBrand.AppBrandPipContainerView", "adjustOnConfigurationChanged, null == parentView");
                    AppMethodBeat.o(219215);
                    return;
                }
                appBrandPipContainerView.oky = new Point(view.getWidth(), view.getHeight());
                Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "adjustOnConfigurationChanged, mParentViewSize: " + appBrandPipContainerView.oky);
                appBrandPipContainerView.inq = AppBrandPipContainerView.az(appBrandPipContainerView.getContext());
                Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "adjustOnConfigurationChanged, mScreenSize: " + appBrandPipContainerView.inq);
                if (appBrandPipContainerView.mCurOrientation != configuration.orientation) {
                    appBrandPipContainerView.mCurOrientation = configuration.orientation;
                    int minX = appBrandPipContainerView.getMinX();
                    int zL = appBrandPipContainerView.zL(appBrandPipContainerView.getWidth());
                    int minY = appBrandPipContainerView.getMinY();
                    int zM = appBrandPipContainerView.zM(appBrandPipContainerView.getHeight());
                    float x = appBrandPipContainerView.getX();
                    float f2 = ((float) minY) + (appBrandPipContainerView.okC * ((float) (zM - minY)));
                    int max = (int) Math.max(Math.min(x, (float) zL), (float) minX);
                    int max2 = (int) Math.max(Math.min(f2, (float) zM), (float) minY);
                    int targetPositionXWhenOrientationChanged = appBrandPipContainerView.getTargetPositionXWhenOrientationChanged();
                    int eE = appBrandPipContainerView.eE(max2, appBrandPipContainerView.getHeight());
                    Log.d("MicroMsg.AppBrand.AppBrandPipContainerView", "adjustOnConfigurationChanged, x: %f, y: %f, startPositionX: %d, startPositionY: %d, targetPositionX: %d, targetPositionY: %d", Float.valueOf(x), Float.valueOf(f2), Integer.valueOf(max), Integer.valueOf(max2), Integer.valueOf(targetPositionXWhenOrientationChanged), Integer.valueOf(eE));
                    appBrandPipContainerView.z(max, max2, targetPositionXWhenOrientationChanged, eE);
                }
            }
        }
        AppMethodBeat.o(219215);
    }

    static /* synthetic */ void i(AppBrandRuntime appBrandRuntime) {
        bw.a aVar;
        AppMethodBeat.i(219216);
        Log.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| initRuntimeImpl appId:%s", appBrandRuntime.mAppId);
        appBrandRuntime.brm();
        appBrandRuntime.OO();
        appBrandRuntime.kAr = appBrandRuntime.brw();
        appBrandRuntime.kAr.d(appBrandRuntime);
        appBrandRuntime.kAI = appBrandRuntime.OR();
        appBrandRuntime.kAS = new AppBrandGlobalNativeWidgetContainerView(appBrandRuntime.mContext);
        appBrandRuntime.kAT = new j(appBrandRuntime.kAS);
        az.GlobalNativeWidgetContainerView.a(appBrandRuntime, appBrandRuntime.kAS);
        appBrandRuntime.kAx = new com.tencent.mm.plugin.appbrand.page.capsulebar.e(appBrandRuntime);
        com.tencent.mm.plugin.appbrand.page.capsulebar.e eVar = appBrandRuntime.kAx;
        bw decorWidgetFactory = eVar.kGM.getDecorWidgetFactory();
        if (decorWidgetFactory == null) {
            aVar = new bw.a();
        } else {
            aVar = decorWidgetFactory;
        }
        kotlin.g.b.p.g(aVar, "runtime.decorWidgetFacto…tFactory.DefaultFactory()");
        Context context = eVar.kGM.mContext;
        kotlin.g.b.p.g(context, "runtime.appContext");
        View d2 = aVar.d(context, com.tencent.mm.plugin.appbrand.page.capsulebar.d.class);
        kotlin.g.b.p.g(d2, "widgetFactory.onCreateWi…eBarImplView::class.java)");
        eVar.nvi = (com.tencent.mm.plugin.appbrand.page.capsulebar.d) d2;
        AppBrandRuntime appBrandRuntime2 = eVar.kGM;
        com.tencent.mm.plugin.appbrand.page.capsulebar.d dVar = eVar.nvi;
        if (dVar == null) {
            kotlin.g.b.p.btv("capsuleBarView");
        }
        AppBrandOptionButton optionBtn = dVar.getOptionBtn();
        kotlin.g.b.p.g(optionBtn, "capsuleBarView.optionBtn");
        com.tencent.mm.plugin.appbrand.page.capsulebar.h hVar = new com.tencent.mm.plugin.appbrand.page.capsulebar.h(optionBtn);
        eVar.nvk = hVar;
        com.tencent.luggage.sdk.g.g gVar = com.tencent.luggage.sdk.g.g.cCM;
        com.tencent.luggage.sdk.g.g.a(eVar.kGM, new e.c(eVar));
        com.tencent.mm.plugin.appbrand.page.capsulebar.a a2 = a.C0775a.a(appBrandRuntime2, hVar);
        kotlin.g.b.p.g(a2, "AppBrandCapsuleBarBlinkH…}\n            }\n        )");
        eVar.nvl = a2;
        View d3 = aVar.d(context, com.tencent.mm.plugin.appbrand.page.capsulebar.c.class);
        kotlin.g.b.p.g(d3, "widgetFactory.onCreateWi…tainerLayout::class.java)");
        eVar.nvh = (com.tencent.mm.plugin.appbrand.page.capsulebar.c) d3;
        com.tencent.mm.plugin.appbrand.page.capsulebar.c cVar = eVar.nvh;
        if (cVar == null) {
            kotlin.g.b.p.btv("capsuleBarContainerLayout");
        }
        com.tencent.mm.plugin.appbrand.page.capsulebar.d dVar2 = eVar.nvi;
        if (dVar2 == null) {
            kotlin.g.b.p.btv("capsuleBarView");
        }
        cVar.addView(dVar2);
        j jVar = eVar.kGM.kAT;
        com.tencent.mm.plugin.appbrand.page.capsulebar.c cVar2 = eVar.nvh;
        if (cVar2 == null) {
            kotlin.g.b.p.btv("capsuleBarContainerLayout");
        }
        jVar.a(cVar2);
        boolean bry = appBrandRuntime.bry();
        Log.i("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| initRuntimeImpl appId:%s, initServiceBeforePage:%b", appBrandRuntime.mAppId, Boolean.valueOf(bry));
        if (bry) {
            appBrandRuntime.brA();
            appBrandRuntime.brz();
        } else {
            appBrandRuntime.brz();
            appBrandRuntime.brA();
        }
        appBrandRuntime.kAQ = new f(appBrandRuntime.mContext, appBrandRuntime);
        f fVar = appBrandRuntime.kAQ;
        if (fVar.kAR == null) {
            fVar.kAR = new AppBrandPipContainerView(fVar.mContext);
            fVar.kAR.setVisibility(4);
            fVar.kAR.setOnCloseButtonClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(219512);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/pip/AppBrandPipManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i(f.this.cDW, "onCloseButtonClick");
                    if (f.this.nDn) {
                        Log.w(f.this.cDW, "onCloseButtonClick when mPipClickProcessing, return");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/pip/AppBrandPipManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(219512);
                    } else if (f.this.nDr) {
                        Log.w(f.this.cDW, "onCloseButtonClick when mIsTransfering, return");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/pip/AppBrandPipManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(219512);
                    } else {
                        if (!(f.this.nDl == null || f.this.nDy == null)) {
                            f.this.nDy.a(f.this.nDl.nBX, e.nCW);
                        }
                        f.a(f.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/pip/AppBrandPipManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(219512);
                    }
                }
            });
            fVar.kAR.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass7 */

                public final void onClick(View view) {
                    AppMethodBeat.i(219544);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/pip/AppBrandPipManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i(f.this.cDW, "onClick, mIsPipVideoRelatedPagePushed: " + f.this.nDk + ", mPipVideoRelatedPage: " + f.s(f.this.nDj));
                    if (f.this.nDr) {
                        Log.i(f.this.cDW, "onClick when mIsTransfering, return");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/pip/AppBrandPipManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(219544);
                        return;
                    }
                    if (!f.this.nDn && f.this.nDj != null) {
                        if (f.this.nDk) {
                            f.this.kAs.b(f.this.nDj, "scene_other");
                        } else {
                            f.this.kAs.adC(f.this.nDj.getCurrentUrl());
                        }
                        f.this.nDn = true;
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/pip/AppBrandPipManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(219544);
                }
            });
            fVar.bTG();
        }
        appBrandRuntime.kAR = fVar.kAR;
        az.PipContainer.a(appBrandRuntime, appBrandRuntime.kAR);
        ViewGroup.LayoutParams layoutParams = appBrandRuntime.kAR.getLayoutParams();
        layoutParams.width = AppBrandPipContainerView.oka;
        layoutParams.height = AppBrandPipContainerView.okb;
        appBrandRuntime.kAR.setLayoutParams(layoutParams);
        az.LegacyDialogContainer.a(appBrandRuntime, appBrandRuntime.jCK);
        appBrandRuntime.jCK.setShouldBringSelfToFrontWhenDialogShown(false);
        az.AuthorizeDialogContainer.a(appBrandRuntime, appBrandRuntime.kAv);
        appBrandRuntime.kAv.setShouldBringSelfToFrontWhenDialogShown(false);
        com.tencent.mm.plugin.appbrand.utils.e eVar2 = appBrandRuntime.kAG;
        eVar2.lqg = appBrandRuntime.kAr;
        Log.i("MicroMsg.AppBrandUserCaptureScreenMonitor", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        try {
            ScreenShotUtil.setScreenShotCallback(MMApplicationContext.getContext(), eVar2.ogG);
        } catch (SecurityException e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandUserCaptureScreenMonitor", e2, "[NOT CRASH] init set callback", new Object[0]);
        }
        appBrandRuntime.brI();
        appBrandRuntime.brv();
        AppMethodBeat.o(219216);
    }

    static /* synthetic */ void k(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(176518);
        while (!appBrandRuntime.kAZ.isEmpty()) {
            appBrandRuntime.i(appBrandRuntime.kAZ.removeFirst(), 0);
        }
        AppMethodBeat.o(176518);
    }

    static /* synthetic */ void l(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(219217);
        appBrandRuntime.kAY.stopTimer();
        AppMethodBeat.o(219217);
    }

    static /* synthetic */ void m(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(176520);
        appBrandRuntime.O(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(134449);
                AnonymousClass1 r0 = new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass7.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(219183);
                        AppBrandRuntime.this.brr();
                        AppMethodBeat.o(219183);
                    }
                };
                if (!AppBrandRuntime.this.N(r0)) {
                    r0.run();
                }
                com.tencent.luggage.sdk.g.c.a("onReady", new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass7.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(219184);
                        AppBrandRuntime.this.onReady();
                        LinkedList linkedList = new LinkedList(AppBrandRuntime.this.kAC);
                        AppBrandRuntime.this.kAC.clear();
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            ((aq) it.next()).btr();
                        }
                        AppMethodBeat.o(219184);
                    }
                });
                AppMethodBeat.o(134449);
            }
        });
        AppMethodBeat.o(176520);
    }

    static /* synthetic */ void s(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(219218);
        Log.i("MicroMsg.AppBrandRuntime", "onServiceReconnected: %s", appBrandRuntime.mAppId);
        if (appBrandRuntime.mInitialized) {
            appBrandRuntime.brB();
            h.TZ(appBrandRuntime.mAppId);
            AppMethodBeat.o(219218);
            return;
        }
        Log.e("MicroMsg.AppBrandRuntime", "Main Process Restarted, start prepare again");
        appBrandRuntime.i(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntime.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(134450);
                AppBrandRuntime.this.a((AppBrandInitConfig) null, "performServiceReconnected");
                AppMethodBeat.o(134450);
            }
        }, 0);
        AppMethodBeat.o(219218);
    }
}
