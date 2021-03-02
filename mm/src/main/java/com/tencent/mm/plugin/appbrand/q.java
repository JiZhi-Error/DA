package com.tencent.mm.plugin.appbrand;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.ma;
import com.tencent.mm.g.b.a.nb;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.ad.h;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.game.preload.d;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.jsapi.EventLocationBackgroundStateChanged;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.jsapi.file.b;
import com.tencent.mm.plugin.appbrand.jsapi.media.a;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify;
import com.tencent.mm.plugin.appbrand.launching.g;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.launching.v;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper;
import com.tencent.mm.plugin.appbrand.message.WxaAppMsgChannel;
import com.tencent.mm.plugin.appbrand.networking.g;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.ba;
import com.tencent.mm.plugin.appbrand.page.bs;
import com.tencent.mm.plugin.appbrand.page.bw;
import com.tencent.mm.plugin.appbrand.page.e;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.performance.b;
import com.tencent.mm.plugin.appbrand.permission.j;
import com.tencent.mm.plugin.appbrand.permission.k;
import com.tencent.mm.plugin.appbrand.permission.m;
import com.tencent.mm.plugin.appbrand.permission.o;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.g;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.model.n;
import com.tencent.mm.plugin.appbrand.report.model.r;
import com.tencent.mm.plugin.appbrand.report.p;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.d;
import com.tencent.mm.plugin.appbrand.report.x;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.a;
import com.tencent.mm.plugin.appbrand.task.a.a;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.plugin.appbrand.ui.ab;
import com.tencent.mm.plugin.appbrand.ui.ae;
import com.tencent.mm.plugin.appbrand.ui.v;
import com.tencent.mm.plugin.appbrand.utils.u;
import com.tencent.mm.plugin.appbrand.widget.dialog.AppBrandGameEvaluateOptionView;
import com.tencent.mm.plugin.appbrand.widget.dialog.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.ajt;
import com.tencent.mm.protocal.protobuf.cxp;
import com.tencent.mm.protocal.protobuf.emo;
import com.tencent.mm.protocal.protobuf.ffc;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.s;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.xweb.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class q extends d implements c.a, com.tencent.mm.plugin.appbrand.launching.q {
    public static final boolean kDg = (WeChatEnvironment.hasDebugger() || DebuggerShell.bAx() || com.tencent.mm.protocal.d.KyR || com.tencent.mm.protocal.d.KyS);
    private final f kDA = new f() {
        /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass15 */

        private boolean aL(String str, int i2) {
            AppMethodBeat.i(226199);
            if (q.this.kDi == null) {
                Log.e("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeController checkTokenOk with reason[%s], get NULL mRemoteController from runtime", str);
                AppMethodBeat.o(226199);
                return true;
            } else if (i2 == q.this.kDi.hashCode()) {
                AppMethodBeat.o(226199);
                return true;
            } else {
                AppMethodBeat.o(226199);
                return false;
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.task.f
        public final void vA(int i2) {
            AppMethodBeat.i(226200);
            if (aL("finish", i2)) {
                q.this.finish();
            }
            AppMethodBeat.o(226200);
        }

        @Override // com.tencent.mm.plugin.appbrand.task.f
        public final void vB(int i2) {
            AppMethodBeat.i(226201);
            if (aL("close", i2) && q.this.mResumed) {
                q.this.close();
            }
            AppMethodBeat.o(226201);
        }

        @Override // com.tencent.mm.plugin.appbrand.task.f
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(226202);
            if (aL("onNetworkChange", i2)) {
                com.tencent.mm.plugin.appbrand.networking.d dVar = (com.tencent.mm.plugin.appbrand.networking.d) q.this.af(com.tencent.mm.plugin.appbrand.networking.d.class);
                if (dVar instanceof g) {
                    ((g) dVar).bPO();
                }
            }
            AppMethodBeat.o(226202);
        }
    };
    private final Queue<Runnable> kDB = new LinkedBlockingQueue();
    private com.tencent.mm.plugin.appbrand.platform.window.f kDC;
    public final com.tencent.mm.plugin.appbrand.jsapi.w.a kDh = new com.tencent.mm.plugin.appbrand.jsapi.w.a();
    protected AppBrandRemoteTaskController kDi;
    private volatile n kDj;
    public o kDk;
    public boolean kDl;
    private int kDm = 0;
    private boolean kDn;
    private final List<aj> kDo = new LinkedList();
    private MTimerHandler kDp = null;
    volatile m kDq;
    private Configuration kDr;
    private com.tencent.mm.plugin.appbrand.floatball.c kDs;
    private com.tencent.mm.plugin.appbrand.q.c kDt;
    public h kDu;
    private com.tencent.luggage.sdk.d.f<AppBrandInitConfigWC> kDv;
    private p kDw;
    private e kDx;
    r kDy;
    private com.tencent.mm.plugin.appbrand.k.b kDz;

    @Override // com.tencent.luggage.sdk.d.d
    public final /* synthetic */ AppBrandSysConfigLU OM() {
        AppMethodBeat.i(43940);
        AppBrandSysConfigWC bsB = bsB();
        AppMethodBeat.o(43940);
        return bsB;
    }

    @Override // com.tencent.luggage.sdk.d.d, com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public final /* synthetic */ l OT() {
        AppMethodBeat.i(43942);
        AppBrandSysConfigWC bsB = bsB();
        AppMethodBeat.o(43942);
        return bsB;
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public final /* synthetic */ bw getDecorWidgetFactory() {
        AppMethodBeat.i(226238);
        e bsn = bsn();
        AppMethodBeat.o(226238);
        return bsn;
    }

    @Override // com.tencent.luggage.sdk.g.c.a
    public final String Pb() {
        AppMethodBeat.i(43885);
        String str = "AppBrandRuntimeWC@" + hashCode();
        AppMethodBeat.o(43885);
        return str;
    }

    public String toString() {
        AppMethodBeat.i(43886);
        String format = String.format(Locale.ENGLISH, "[AppBrandRuntimeWC::%s::%s::%d::@%d]", this.mAppId, bsm(), Integer.valueOf(this.kAq.eix), Integer.valueOf(hashCode()));
        AppMethodBeat.o(43886);
        return format;
    }

    public final e bsn() {
        AppMethodBeat.i(226210);
        if (this.kDx == null) {
            com.tencent.mm.plugin.appbrand.page.g gVar = com.tencent.mm.plugin.appbrand.page.g.nnK;
            this.kDx = com.tencent.mm.plugin.appbrand.page.g.b(com.tencent.mm.plugin.appbrand.task.g.iD(((AppBrandInitConfigWC) super.ON()).NA()));
        }
        e eVar = this.kDx;
        AppMethodBeat.o(226210);
        return eVar;
    }

    static {
        AppMethodBeat.i(43955);
        AppMethodBeat.o(43955);
    }

    public q(AppBrandRuntimeContainerWC appBrandRuntimeContainerWC) {
        super((ak) appBrandRuntimeContainerWC);
        AppMethodBeat.i(174681);
        a((ak) appBrandRuntimeContainerWC);
        bso();
        AppMethodBeat.o(174681);
    }

    public q(com.tencent.mm.plugin.appbrand.platform.window.c cVar) {
        super(cVar);
        AppMethodBeat.i(226211);
        a((ak) null);
        bso();
        AppMethodBeat.o(226211);
    }

    private void bso() {
        AppMethodBeat.i(226212);
        Assert.assertTrue("AppBrandRuntimeWC's initial context should be AppBrandRuntimePersistentContextWrapper", this.mContext instanceof com.tencent.mm.plugin.appbrand.ui.n);
        this.kDk = new o();
        this.kDw = new p();
        this.kAU = kDg;
        AppMethodBeat.o(226212);
    }

    public final ICommLibReader bqZ() {
        AppMethodBeat.i(261621);
        ICommLibReader gt = gt(false);
        AppMethodBeat.o(261621);
        return gt;
    }

    private ICommLibReader gt(boolean z) {
        AppMethodBeat.i(43890);
        ICommLibReader iCommLibReader = (ICommLibReader) super.af(ICommLibReader.class);
        if (iCommLibReader != null || !z) {
            AppMethodBeat.o(43890);
            return iCommLibReader;
        }
        ICommLibReader.a aVar = new ICommLibReader.a();
        AppMethodBeat.o(43890);
        throw aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public final void a(ak akVar) {
        AppMethodBeat.i(43891);
        AppBrandRuntimeContainerWC appBrandRuntimeContainerWC = (AppBrandRuntimeContainerWC) akVar;
        super.a((ak) appBrandRuntimeContainerWC);
        if (appBrandRuntimeContainerWC == null) {
            this.kAM = null;
            this.mContext = com.tencent.mm.plugin.appbrand.ui.n.eo(MMApplicationContext.getContext());
            if (((com.tencent.mm.plugin.appbrand.service.c) super.NY()) != null) {
                ((com.tencent.mm.plugin.appbrand.service.c) super.NY()).b(null);
            }
            if (((x) super.brh()) != null) {
                y.c((x) super.brh());
            }
            if (this.kAx != null) {
                this.kAx.ek(MMApplicationContext.getContext());
            }
            this.kDv = new com.tencent.luggage.sdk.d.e();
            gu(true);
            if (((AppBrandInitConfigWC) super.ON()) != null && !isDestroyed()) {
                this.kDi.M(this);
            }
            AppMethodBeat.o(43891);
            return;
        }
        ((com.tencent.mm.plugin.appbrand.ui.n) this.mContext).setBaseContext(AndroidContextUtil.castActivityOrNull(appBrandRuntimeContainerWC.mContext));
        if (this.kAx != null) {
            this.kAx.ek((Context) Objects.requireNonNull(AndroidContextUtil.castActivityOrNull(appBrandRuntimeContainerWC.mContext)));
        }
        if (getWindowAndroid().bsj()) {
            this.kDv = new com.tencent.mm.plugin.appbrand.ui.d(this, AndroidContextUtil.castActivityOrNull(this.mContext), getWindowAndroid().getOrientationHandler(), super.getWindowAndroid());
        } else {
            this.kDv = new com.tencent.luggage.sdk.d.e();
        }
        if (((com.tencent.mm.plugin.appbrand.service.c) super.NY()) != null) {
            ((com.tencent.mm.plugin.appbrand.service.c) super.NY()).b(getWindowAndroid());
        }
        ag bsz = bsz();
        if (bsz != null) {
            bsz.b(getWindowAndroid());
            ((x) super.brh()).j(bsz);
        }
        this.kDr = new Configuration(AppBrandUI.H(appBrandRuntimeContainerWC.kCd.getActivity()));
        gu(true);
        if (this.kDs == null && this.mInitialized) {
            Log.i("MicroMsg.AppBrandRuntimeWC", "setRuntimeContainer != NULL, appId:%s, retry initFloatBallHelper", this.mAppId);
            bsw();
        }
        if (this.kDt == null && this.mInitialized) {
            Log.i("MicroMsg.AppBrandRuntimeWC", "setRuntimeContainer != NULL, appId:%s, retry initMultiTaskHelper", this.mAppId);
            bsx();
        }
        AppMethodBeat.o(43891);
    }

    private void gu(boolean z) {
        AppMethodBeat.i(226214);
        Log.i("MicroMsg.AppBrandRuntimeWC", "createRemoteController(force:%b), appId:%s, mRemoteController:%s", Boolean.valueOf(z), this.mAppId, this.kDi);
        if (this.kDi == null || z) {
            if (this.kDi != null) {
                this.kDi.bDK();
            }
            if ((getWindowAndroid() instanceof com.tencent.mm.plugin.appbrand.platform.window.b.a) || this.kAl == null) {
                this.kDi = new AppBrandRemoteTaskController();
                this.kDi.a(this.kDA);
                AppMethodBeat.o(226214);
                return;
            }
            this.kDi = new AppBrandRemoteTaskController();
            this.kDi.a(((AppBrandRuntimeContainerWC) Objects.requireNonNull((AppBrandRuntimeContainerWC) this.kAl)).kCd, this.kDA);
        }
        AppMethodBeat.o(226214);
    }

    public final b bsp() {
        if (this.kDt != null) {
            return this.kDt.nhs;
        }
        return null;
    }

    public com.tencent.mm.plugin.appbrand.k.b bsq() {
        AppMethodBeat.i(174683);
        if (this.kDz == null && !isDestroyed()) {
            this.kDz = new com.tencent.mm.plugin.appbrand.k.b() {
                /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass1 */
                private HandOffMP kDD = com.tencent.mm.plugin.appbrand.k.a.y(q.this);

                {
                    AppMethodBeat.i(174653);
                    AppMethodBeat.o(174653);
                }

                @Override // com.tencent.mm.plugin.appbrand.k.b
                public final void Uo(String str) {
                    AppMethodBeat.i(174654);
                    this.kDD.setAppEntryPage(str);
                    ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.kDD);
                    AppMethodBeat.o(174654);
                }

                @Override // com.tencent.mm.plugin.appbrand.k.b
                public final void bsP() {
                    AppMethodBeat.i(174655);
                    ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).del(this.kDD.getKey());
                    AppMethodBeat.o(174655);
                }

                @Override // com.tencent.mm.plugin.appbrand.k.b
                public final void aK(String str, int i2) {
                    AppMethodBeat.i(226178);
                    this.kDD.setHandOffType(i2);
                    this.kDD.setAppEntryPage(str);
                    ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).f(this.kDD);
                    AppMethodBeat.o(226178);
                }
            };
        }
        com.tencent.mm.plugin.appbrand.k.b bVar = this.kDz;
        AppMethodBeat.o(174683);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public final void brI() {
        AppMethodBeat.i(174684);
        if (com.tencent.mm.plugin.appbrand.ui.r.am(this)) {
            AppMethodBeat.o(174684);
            return;
        }
        super.brI();
        AppMethodBeat.o(174684);
    }

    private void bst() {
        AppMethodBeat.i(43896);
        if (!kDg) {
            AppMethodBeat.o(43896);
            return;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) android.support.v4.content.b.a(this.mContext, AccessibilityManager.class);
            if (accessibilityManager == null || accessibilityManager.isTouchExplorationEnabled()) {
                AppMethodBeat.o(43896);
                return;
            }
            this.kAt.setContentDescription(this.mAppId + ":" + ((AppBrandInitConfigWC) super.ON()).brandName);
            AppMethodBeat.o(43896);
        } catch (Exception e2) {
            AppMethodBeat.o(43896);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public final void close() {
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        com.tencent.mm.plugin.appbrand.game.f.a aVar;
        AppMethodBeat.i(43897);
        Log.i("MicroMsg.AppBrandRuntimeWC", "close() appId:%s, stack:%s", this.mAppId, android.util.Log.getStackTraceString(new Throwable()));
        try {
            if (!(h.Uc(this.mAppId) != h.d.CLOSE || (aVar = (com.tencent.mm.plugin.appbrand.game.f.a) ((x) super.brh()).getPageView().S(com.tencent.mm.plugin.appbrand.game.f.a.class)) == null || aVar.bDj() == null)) {
                com.tencent.mm.plugin.appbrand.game.f.b bDj = aVar.bDj();
                Log.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: triggerMakeCanvasBitmap");
                if (bDj.lsZ == null || bDj.bDl() == null || Util.isNullOrNil(bDj.lsZ.Nzf) || !bDj.lsZ.NyX || bDj.ltb == null) {
                    Log.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: should not do make canvas bitmap!");
                } else if (bDj.bDm()) {
                    bDj.bDl().MR();
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandRuntimeWC", e2, "hy: triggerMakeCanvasBitmap error!", new Object[0]);
        }
        OpenBusinessViewUtil.A(this);
        if (((AppBrandInitConfigWC) super.ON()).leh != null) {
            this.kAH.a(new c.a() {
                /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass12 */

                @Override // com.tencent.mm.plugin.appbrand.a.c.a
                public final void a(String str, com.tencent.mm.plugin.appbrand.a.b bVar) {
                    AppMethodBeat.i(226196);
                    if (com.tencent.mm.plugin.appbrand.a.b.BACKGROUND == bVar) {
                        q.this.kAH.b(this);
                        q.this.bsC().leh.hY(AndroidContextUtil.castActivityOrNull(q.this.mContext) != null && AndroidContextUtil.castActivityOrNull(q.this.mContext).isFinishing());
                    }
                    AppMethodBeat.o(226196);
                }
            });
        }
        if (bsr() || af.p(this)) {
            super.close();
            AppMethodBeat.o(43897);
            return;
        }
        AnonymousClass16 r9 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass16 */

            public final void run() {
                boolean z;
                boolean z2;
                boolean z3 = true;
                AppMethodBeat.i(174674);
                if (q.this.kDt != null) {
                    com.tencent.mm.plugin.appbrand.q.c cVar = q.this.kDt;
                    q qVar = q.this;
                    Log.i("MicroMsg.AppBrandMultiTaskLogic", "close, runtime:%s", qVar.mAppId);
                    int b2 = com.tencent.mm.plugin.appbrand.floatball.b.b(h.Uc(qVar.mAppId));
                    if (cVar.nhs == null || !cVar.nhs.O(b2, true)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    Log.i("MicroMsg.AppBrandMultiTaskLogic", "close, result:%s", Boolean.valueOf(z2));
                    if (z2) {
                        AppMethodBeat.o(174674);
                        return;
                    }
                }
                if (q.this.kDs != null) {
                    com.tencent.mm.plugin.appbrand.floatball.c cVar2 = q.this.kDs;
                    q qVar2 = q.this;
                    Log.i("MicroMsg.AppBrandFloatBallLogic", "close, runtime:%s", qVar2.mAppId);
                    int b3 = com.tencent.mm.plugin.appbrand.floatball.b.b(h.Uc(qVar2.mAppId));
                    boolean z4 = cVar2.lqy != null && cVar2.lqy.bCL();
                    if (cVar2.lqz == null || !cVar2.lqz.bCL()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    Log.i("MicroMsg.AppBrandFloatBallLogic", "close, voip:%s, voip1v1:%s", Boolean.valueOf(z4), Boolean.valueOf(z));
                    if (z4) {
                        cVar2.lqy.a(AndroidContextUtil.castActivityOrNull(qVar2.mContext), 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00c1: INVOKE  
                              (wrap: com.tencent.mm.plugin.appbrand.floatball.f : 0x00b4: IGET  (r0v14 com.tencent.mm.plugin.appbrand.floatball.f) = (r4v0 'cVar2' com.tencent.mm.plugin.appbrand.floatball.c) com.tencent.mm.plugin.appbrand.floatball.c.lqy com.tencent.mm.plugin.appbrand.floatball.f)
                              (wrap: android.app.Activity : 0x00b8: INVOKE  (r2v4 android.app.Activity) = 
                              (wrap: android.content.Context : 0x00b6: IGET  (r2v3 android.content.Context) = (r5v0 'qVar2' com.tencent.mm.plugin.appbrand.q) com.tencent.mm.plugin.appbrand.AppBrandRuntime.mContext android.content.Context)
                             type: STATIC call: com.tencent.mm.sdk.system.AndroidContextUtil.castActivityOrNull(android.content.Context):android.app.Activity)
                              (wrap: com.tencent.mm.plugin.appbrand.floatball.c$2 : 0x00be: CONSTRUCTOR  (r3v6 com.tencent.mm.plugin.appbrand.floatball.c$2) = (r4v0 'cVar2' com.tencent.mm.plugin.appbrand.floatball.c), (r6v1 'b3' int) call: com.tencent.mm.plugin.appbrand.floatball.c.2.<init>(com.tencent.mm.plugin.appbrand.floatball.c, int):void type: CONSTRUCTOR)
                             type: VIRTUAL call: com.tencent.mm.plugin.appbrand.floatball.f.a(android.content.Context, com.tencent.mm.plugin.appbrand.floatball.f$a):void in method: com.tencent.mm.plugin.appbrand.q.16.run():void, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00be: CONSTRUCTOR  (r3v6 com.tencent.mm.plugin.appbrand.floatball.c$2) = (r4v0 'cVar2' com.tencent.mm.plugin.appbrand.floatball.c), (r6v1 'b3' int) call: com.tencent.mm.plugin.appbrand.floatball.c.2.<init>(com.tencent.mm.plugin.appbrand.floatball.c, int):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.q.16.run():void, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 24 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.floatball.c, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 30 more
                            */
                        /*
                        // Method dump skipped, instructions count: 258
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.q.AnonymousClass16.run():void");
                    }
                };
                com.tencent.mm.plugin.appbrand.widget.dialog.f fVar = new com.tencent.mm.plugin.appbrand.widget.dialog.f((com.tencent.mm.plugin.appbrand.service.c) super.NY());
                if (fVar.lrj == null) {
                    z = false;
                } else {
                    ffc ffc = fVar.lrj.nGg;
                    if (ffc == null || ffc.NAv == null || ffc.NAv.size() < 3) {
                        Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: no config");
                        z = false;
                    } else {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1237, 0, 1, false);
                        fVar.mEO = (int) (System.currentTimeMillis() - p.Um(this.mAppId).lastResumeTime);
                        if (fVar.mEO < ffc.NAx * 1000) {
                            Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: time limit");
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1237, 1, 1, false);
                            z = false;
                        } else {
                            z = true;
                        }
                    }
                }
                if (this == null || bsB() == null || AndroidContextUtil.castActivityOrNull(this.mContext) == null) {
                    Log.w("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "invalid close state");
                    z2 = false;
                } else {
                    AppBrandSysConfigWC bsB = bsB();
                    if (!bsB.leI) {
                        Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "can not show evaluate dialog");
                        z2 = false;
                    } else {
                        long j2 = p.Um(this.mAppId).lastResumeTime;
                        long currentTimeMillis = System.currentTimeMillis();
                        Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "app time lastResumeTime:%s, closeTime:%s, leastTime:%s", Long.valueOf(j2), Long.valueOf(currentTimeMillis), Integer.valueOf(bsB.leK));
                        if ((currentTimeMillis - j2) / 1000 < ((long) bsB.leK)) {
                            Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "time not enough to show evaluate dialog");
                            z2 = false;
                        } else {
                            AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.ON();
                            fVar.userName = appBrandInitConfigWC.username;
                            if (Util.isNullOrNil(fVar.userName)) {
                                Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "username is null, can not show evaluate dialog");
                                z2 = false;
                            } else {
                                Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.mContext);
                                String str2 = appBrandInitConfigWC.appId;
                                String str3 = appBrandInitConfigWC.brandName;
                                boolean z4 = bsB.leJ;
                                fVar.dialog = com.tencent.mm.plugin.appbrand.widget.dialog.f.z(castActivityOrNull, true);
                                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(fVar.dialog.getContext()).inflate(R.layout.dr, (ViewGroup) null, false);
                                fVar.dialog.setContentView(linearLayout);
                                Point az = ao.az(fVar.dialog.getContext());
                                int min = Math.min(az.x, az.y);
                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(min, -2);
                                layoutParams.gravity = 1;
                                linearLayout.setLayoutParams(layoutParams);
                                Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "createEvaluateDialog, dialog width:%d", Integer.valueOf(min));
                                fVar.HZZ = (TextView) fVar.dialog.findViewById(R.id.c55);
                                fVar.Iaa = (LinearLayout) fVar.dialog.findViewById(R.id.c56);
                                fVar.Iab = (LinearLayout) fVar.dialog.findViewById(R.id.c53);
                                TextView textView = (TextView) fVar.dialog.findViewById(R.id.c52);
                                if (z4) {
                                    textView.setVisibility(0);
                                    textView.setOnClickListener(new View.OnClickListener(castActivityOrNull, str2, str3) {
                                        /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass15 */
                                        final /* synthetic */ String kqs;
                                        final /* synthetic */ String val$appId;
                                        final /* synthetic */ Context val$context;

                                        {
                                            this.val$context = r2;
                                            this.val$appId = r3;
                                            this.kqs = r4;
                                        }

                                        public final void onClick(View view) {
                                            int i2;
                                            AppMethodBeat.i(49879);
                                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                            bVar.bm(view);
                                            a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                            f.this.eJ(4, 1);
                                            if (f.this.GhC != null) {
                                                i2 = (int) f.this.GhC.getRating();
                                            } else {
                                                i2 = 0;
                                            }
                                            f fVar = f.this;
                                            Context context = this.val$context;
                                            String str = this.val$appId;
                                            String str2 = this.kqs;
                                            if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.r.class) != null) {
                                                com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
                                                gVar.appId = "wxbfac0b7aca45dd68";
                                                gVar.username = "gh_af145dc05189@app";
                                                gVar.iOo = 0;
                                                gVar.scene = 1147;
                                                gVar.kHw = String.format("/pages/edit/edit.html?appid=%s&appName=%s&score=%s", str, str2, Integer.valueOf(i2));
                                                gVar.kHB = new ValueCallback<String>() {
                                                    /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass4 */

                                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                                    @Override // android.webkit.ValueCallback
                                                    public final /* synthetic */ void onReceiveValue(String str) {
                                                        AppMethodBeat.i(49868);
                                                        String str2 = str;
                                                        Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "onReceiveValue, value:%s", str2);
                                                        if (!Util.isNullOrNil(str2)) {
                                                            try {
                                                                String optString = new JSONObject(str2).optString("type", "");
                                                                if (!Util.isNullOrNil(optString) && optString.equalsIgnoreCase("ok")) {
                                                                    Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "onReceiveValue, type:ok");
                                                                    f.this.eJ(5, 1);
                                                                    f.this.dismiss();
                                                                }
                                                                AppMethodBeat.o(49868);
                                                                return;
                                                            } catch (JSONException e2) {
                                                                Log.printErrStackTrace("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", e2, "launchCommentApplication exception:%s", e2);
                                                            }
                                                        }
                                                        AppMethodBeat.o(49868);
                                                    }
                                                };
                                                ((com.tencent.mm.plugin.appbrand.service.r) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.r.class)).a(context, gVar);
                                            }
                                            a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                            AppMethodBeat.o(49879);
                                        }
                                    });
                                } else {
                                    textView.setVisibility(8);
                                    textView.setOnClickListener(null);
                                }
                                ((TextView) fVar.dialog.findViewById(R.id.c59)).setOnClickListener(new View.OnClickListener(castActivityOrNull) {
                                    /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass16 */
                                    final /* synthetic */ Context val$context;

                                    {
                                        this.val$context = r2;
                                    }

                                    public final void onClick(View view) {
                                        AppMethodBeat.i(49880);
                                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                        bVar.bm(view);
                                        a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                        if (f.this.GhC != null) {
                                            int rating = (int) f.this.GhC.getRating();
                                            f fVar = f.this;
                                            emo emo = new emo();
                                            emo.username = fVar.userName;
                                            emo.NkL = 3;
                                            emo.NkM = new ajt();
                                            emo.NkM.score = rating;
                                            fVar.Gga = rating;
                                            Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "saveEvaluateScore, userName:%s, score:%d", fVar.userName, Integer.valueOf(rating));
                                            fVar.a(emo);
                                            Toast.makeText(this.val$context, this.val$context.getString(R.string.kv), 0).show();
                                            f.this.GfH = true;
                                            f.this.dismiss();
                                        }
                                        a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(49880);
                                    }
                                });
                                fVar.GhC = (RatingBar) fVar.dialog.findViewById(R.id.c57);
                                fVar.GhC.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                                    /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass17 */

                                    public final void onRatingChanged(RatingBar ratingBar, float f2, boolean z) {
                                        AppMethodBeat.i(49881);
                                        f fVar = f.this;
                                        if (!fVar.GfH) {
                                            fVar.GfH = true;
                                            fVar.awx((int) f2);
                                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(fVar.oqv, "alpha", 1.0f, 0.0f);
                                            ofFloat.addListener(new AnimatorListenerAdapter() {
                                                /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass6 */

                                                public final void onAnimationEnd(Animator animator) {
                                                    AppMethodBeat.i(49870);
                                                    f.this.oqv.setVisibility(8);
                                                    AppMethodBeat.o(49870);
                                                }
                                            });
                                            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(fVar.Iaa, "alpha", 1.0f, 0.0f);
                                            ofFloat2.addListener(new AnimatorListenerAdapter() {
                                                /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass7 */

                                                public final void onAnimationEnd(Animator animator) {
                                                    AppMethodBeat.i(49871);
                                                    f.this.Iaa.setVisibility(8);
                                                    AppMethodBeat.o(49871);
                                                }
                                            });
                                            AnimatorSet animatorSet = new AnimatorSet();
                                            animatorSet.playTogether(ofFloat, ofFloat2);
                                            animatorSet.setDuration(200L);
                                            animatorSet.setInterpolator(new AccelerateInterpolator());
                                            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(fVar.HZZ, "alpha", 0.0f, 1.0f);
                                            ofFloat3.addListener(new AnimatorListenerAdapter() {
                                                /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass8 */

                                                public final void onAnimationStart(Animator animator) {
                                                    AppMethodBeat.i(49872);
                                                    f.this.HZZ.setAlpha(0.0f);
                                                    f.this.HZZ.setVisibility(0);
                                                    AppMethodBeat.o(49872);
                                                }
                                            });
                                            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(fVar.Iab, "alpha", 0.0f, 1.0f);
                                            ofFloat4.addListener(new AnimatorListenerAdapter() {
                                                /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass9 */

                                                public final void onAnimationStart(Animator animator) {
                                                    AppMethodBeat.i(49873);
                                                    f.this.Iab.setAlpha(0.0f);
                                                    f.this.Iab.setVisibility(0);
                                                    AppMethodBeat.o(49873);
                                                }
                                            });
                                            AnimatorSet animatorSet2 = new AnimatorSet();
                                            animatorSet2.playTogether(ofFloat3, ofFloat4);
                                            animatorSet2.setDuration(200L);
                                            animatorSet2.setInterpolator(new AccelerateInterpolator());
                                            AnimatorSet animatorSet3 = new AnimatorSet();
                                            animatorSet3.playSequentially(animatorSet, animatorSet2);
                                            animatorSet3.start();
                                            AppMethodBeat.o(49881);
                                            return;
                                        }
                                        fVar.awx((int) f2);
                                        if (f2 < 1.0f) {
                                            fVar.GhC.setRating(1.0f);
                                        }
                                        AppMethodBeat.o(49881);
                                    }
                                });
                                fVar.oqv = (TextView) fVar.dialog.findViewById(R.id.c54);
                                if (!Util.isNullOrNil(str3)) {
                                    fVar.oqv.setVisibility(0);
                                    fVar.oqv.setText(castActivityOrNull.getString(R.string.kt, str3));
                                } else {
                                    fVar.oqv.setVisibility(8);
                                }
                                ((ImageView) fVar.dialog.findViewById(R.id.c51)).setOnClickListener(new View.OnClickListener() {
                                    /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass18 */

                                    public final void onClick(View view) {
                                        AppMethodBeat.i(49882);
                                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                        bVar.bm(view);
                                        a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                        Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "user clicked dialog close button");
                                        f.this.GfH = false;
                                        f.this.dismiss();
                                        a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(49882);
                                    }
                                });
                                ViewGroup viewGroup = (ViewGroup) linearLayout.getParent();
                                if (viewGroup != null) {
                                    viewGroup.setOnClickListener(new View.OnClickListener() {
                                        /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass19 */

                                        public final void onClick(View view) {
                                            AppMethodBeat.i(49883);
                                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                            bVar.bm(view);
                                            a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                            Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "user clicked dialog outside");
                                            f.this.GfH = false;
                                            f.this.dismiss();
                                            a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                            AppMethodBeat.o(49883);
                                        }
                                    });
                                    linearLayout.setOnClickListener(new View.OnClickListener() {
                                        /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass20 */

                                        public final void onClick(View view) {
                                            AppMethodBeat.i(49884);
                                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                            bVar.bm(view);
                                            a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                            Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "user clicked dialog inside");
                                            a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                            AppMethodBeat.o(49884);
                                        }
                                    });
                                }
                                fVar.dialog = fVar.dialog;
                                fVar.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass1 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(49865);
                                        Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "user cancel evaluate dialog");
                                        f.this.GfH = false;
                                        AppMethodBeat.o(49865);
                                    }
                                });
                                fVar.dialog.setOnDismissListener(new DialogInterface.OnDismissListener(r9) {
                                    /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass12 */
                                    final /* synthetic */ Runnable val$runnable;

                                    {
                                        this.val$runnable = r2;
                                    }

                                    public final void onDismiss(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(49876);
                                        Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "user dismiss evaluate dialog");
                                        if (!f.this.GfH) {
                                            f fVar = f.this;
                                            emo emo = new emo();
                                            emo.username = fVar.userName;
                                            emo.NkL = 4;
                                            Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "reportSkipEvaluate, userName:%s", fVar.userName);
                                            fVar.a(emo);
                                        }
                                        Runnable runnable = this.val$runnable;
                                        if (runnable != null) {
                                            MMHandlerThread.postToMainThreadDelayed(runnable, 100);
                                        }
                                        AppMethodBeat.o(49876);
                                    }
                                });
                                fVar.GfH = false;
                                bsB.leI = false;
                                if (this == null) {
                                    str = null;
                                } else {
                                    str = this.mAppId;
                                }
                                fVar.appId = str;
                                if (Util.isNullOrNil(fVar.appId)) {
                                    Log.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "saveEvaluateReport, no app id");
                                } else {
                                    AppBrandInitConfigWC appBrandInitConfigWC2 = (AppBrandInitConfigWC) super.ON();
                                    fVar.sessionId = "";
                                    if (appBrandInitConfigWC2 != null) {
                                        fVar.sessionId = appBrandInitConfigWC2.cym;
                                    }
                                    fVar.scene = 1000;
                                    if (!(appBrandInitConfigWC2 == null || appBrandInitConfigWC2.cyA == null)) {
                                        fVar.scene = appBrandInitConfigWC2.cyA.scene;
                                    }
                                    fVar.dCx = "";
                                    if (!(((com.tencent.mm.plugin.appbrand.service.c) super.NY()) == null || ((com.tencent.mm.plugin.appbrand.service.c) super.NY()).bsz() == null)) {
                                        fVar.dCx = ((com.tencent.mm.plugin.appbrand.service.c) super.NY()).bsz().lBI;
                                    }
                                }
                                fVar.eJ(1, 1);
                                fVar.show();
                                z2 = true;
                            }
                        }
                    }
                }
                if (z2) {
                    if (z) {
                        Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: WA dialog first");
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1237, 2, 1, false);
                    }
                    z3 = true;
                } else if (z) {
                    Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "need show game evaluate dialog");
                    ffc ffc2 = fVar.lrj.nGg;
                    fVar.lrj.nGg = null;
                    fVar.dialog = com.tencent.mm.plugin.appbrand.widget.dialog.f.z(AndroidContextUtil.castActivityOrNull(this.mContext), false);
                    LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(fVar.dialog.getContext()).inflate(R.layout.dw, (ViewGroup) null, false);
                    fVar.dialog.setContentView(linearLayout2);
                    Point az2 = ao.az(fVar.dialog.getContext());
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(Math.min(az2.x, az2.y), linearLayout2.getLayoutParams().height);
                    layoutParams2.gravity = 1;
                    linearLayout2.setLayoutParams(layoutParams2);
                    TextView textView2 = (TextView) linearLayout2.findViewById(R.id.ipm);
                    textView2.setText(ffc2.Title);
                    TextView textView3 = (TextView) linearLayout2.findViewById(R.id.c54);
                    textView3.setText(ffc2.NAu);
                    ImageView imageView = (ImageView) linearLayout2.findViewById(R.id.c51);
                    f.AnonymousClass21 r0 = new AppBrandGameEvaluateOptionView.a(textView2, textView3, imageView, linearLayout2, this, r9, ffc2) {
                        /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass21 */
                        final /* synthetic */ LinearLayout ISV;
                        final /* synthetic */ ffc Iad;
                        final /* synthetic */ TextView Iae;
                        final /* synthetic */ TextView IhV;
                        final /* synthetic */ ImageView IhW;
                        final /* synthetic */ q kzl;
                        final /* synthetic */ Runnable oqD;

                        {
                            this.Iae = r2;
                            this.IhV = r3;
                            this.IhW = r4;
                            this.ISV = r5;
                            this.kzl = r6;
                            this.oqD = r7;
                            this.Iad = r8;
                        }

                        @Override // com.tencent.mm.plugin.appbrand.widget.dialog.AppBrandGameEvaluateOptionView.a
                        public final void a(cxp cxp) {
                            AppMethodBeat.i(49885);
                            this.Iae.setVisibility(4);
                            this.IhV.setVisibility(8);
                            this.IhW.setVisibility(4);
                            this.ISV.findViewById(R.id.g57).setVisibility(8);
                            f fVar = f.this;
                            q qVar = this.kzl;
                            LinearLayout linearLayout = this.ISV;
                            Runnable runnable = this.oqD;
                            ffc ffc = this.Iad;
                            if (!fVar.Iac) {
                                ImageView imageView = (ImageView) linearLayout.findViewById(R.id.ill);
                                imageView.setAlpha(0.0f);
                                imageView.setScaleX(0.48076922f);
                                imageView.setScaleY(0.48076922f);
                                imageView.setRotation(24.0f);
                                imageView.setVisibility(0);
                                TextView textView = (TextView) linearLayout.findViewById(R.id.ilm);
                                textView.setText(ffc.NAw);
                                textView.setAlpha(0.0f);
                                textView.setVisibility(0);
                                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                                ofFloat.setDuration(300L);
                                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(imageView, textView) {
                                    /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass10 */
                                    final /* synthetic */ ImageView oqE;
                                    final /* synthetic */ TextView oqF;

                                    {
                                        this.oqE = r2;
                                        this.oqF = r3;
                                    }

                                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                        AppMethodBeat.i(49874);
                                        this.oqE.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                        this.oqF.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                        AppMethodBeat.o(49874);
                                    }
                                });
                                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.48076922f, 1.0f);
                                ofFloat2.setDuration(300L);
                                ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(imageView) {
                                    /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass11 */
                                    final /* synthetic */ ImageView oqE;

                                    {
                                        this.oqE = r2;
                                    }

                                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                        AppMethodBeat.i(49875);
                                        this.oqE.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                        this.oqE.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                        AppMethodBeat.o(49875);
                                    }
                                });
                                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "rotation", 24.0f, 0.0f);
                                ofFloat3.setDuration(1300L);
                                AnimatorSet animatorSet = new AnimatorSet();
                                animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
                                animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
                                animatorSet.addListener(new Animator.AnimatorListener(runnable) {
                                    /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass13 */
                                    final /* synthetic */ Runnable oqD;

                                    {
                                        this.oqD = r2;
                                    }

                                    public final void onAnimationStart(Animator animator) {
                                    }

                                    public final void onAnimationEnd(Animator animator) {
                                        AppMethodBeat.i(49877);
                                        f.this.dismiss();
                                        this.oqD.run();
                                        AppMethodBeat.o(49877);
                                    }

                                    public final void onAnimationCancel(Animator animator) {
                                    }

                                    public final void onAnimationRepeat(Animator animator) {
                                    }
                                });
                                animatorSet.start();
                                fVar.a(qVar, false, cxp, ffc);
                            }
                            AppMethodBeat.o(49885);
                        }
                    };
                    ((AppBrandGameEvaluateOptionView) linearLayout2.findViewById(R.id.g4y)).a(0, ffc2, r0);
                    ((AppBrandGameEvaluateOptionView) linearLayout2.findViewById(R.id.g4z)).a(1, ffc2, r0);
                    ((AppBrandGameEvaluateOptionView) linearLayout2.findViewById(R.id.g50)).a(2, ffc2, r0);
                    fVar.dialog.setOnCancelListener(new DialogInterface.OnCancelListener(this, ffc2, r9) {
                        /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass2 */
                        final /* synthetic */ ffc Iad;
                        final /* synthetic */ q kzl;
                        final /* synthetic */ Runnable oqD;

                        {
                            this.kzl = r2;
                            this.Iad = r3;
                            this.oqD = r4;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(49866);
                            f.a(f.this, this.kzl, this.Iad);
                            this.oqD.run();
                            AppMethodBeat.o(49866);
                        }
                    });
                    imageView.setOnClickListener(new View.OnClickListener(this, ffc2, r9) {
                        /* class com.tencent.mm.plugin.appbrand.widget.dialog.f.AnonymousClass3 */
                        final /* synthetic */ ffc Iad;
                        final /* synthetic */ q kzl;
                        final /* synthetic */ Runnable oqD;

                        {
                            this.kzl = r2;
                            this.Iad = r3;
                            this.oqD = r4;
                        }

                        public final void onClick(View view) {
                            AppMethodBeat.i(49867);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            f.a(f.this, this.kzl, this.Iad);
                            f.this.dismiss();
                            this.oqD.run();
                            a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(49867);
                        }
                    });
                    fVar.dialog = fVar.dialog;
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1237, 4, 1, false);
                    fVar.show();
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    r9.run();
                }
                AppMethodBeat.o(43897);
            }

            public final void bsu() {
                AppMethodBeat.i(43898);
                Log.i("MicroMsg.AppBrandRuntimeWC", "callSuperClose appId:%s", this.mAppId);
                super.close();
                AppMethodBeat.o(43898);
            }

            @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
            public final void finish() {
                AppMethodBeat.i(43899);
                Log.i("MicroMsg.AppBrandRuntimeWC", "finish appId[%s] type[%d] hash[%d] stacktrace=%s", this.mAppId, Integer.valueOf(this.kAq.eix), Integer.valueOf(hashCode()), android.util.Log.getStackTraceString(new Throwable()));
                if (k.e(this) || this.kAl == null) {
                    i(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass18 */

                        public final void run() {
                            AppMethodBeat.i(43877);
                            q.this.dispatchDestroy();
                            AppMethodBeat.o(43877);
                        }
                    }, 0);
                    AppMethodBeat.o(43899);
                    return;
                }
                super.finish();
                if (this.kDs != null) {
                    this.kDs.w(this);
                }
                if (this.kDt != null) {
                    com.tencent.mm.plugin.appbrand.q.c.w(this);
                }
                AppMethodBeat.o(43899);
            }

            @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
            public final void a(AppBrandInitConfig appBrandInitConfig, String str) {
                AppMethodBeat.i(226217);
                if (appBrandInitConfig == null) {
                    ((AppBrandInitConfigWC) super.ON()).resetSession();
                    ((AppBrandInitConfigWC) super.ON()).startTime = Util.nowMilliSecond();
                    ((AppBrandInitConfigWC) super.ON()).lef = new AppBrandRuntimeReloadReportBundle(((AppBrandInitConfigWC) super.ON()).ldW.kEY, str);
                    ((AppBrandInitConfigWC) super.ON()).ldW = new QualitySession(com.tencent.mm.plugin.appbrand.utils.b.zF(((AppBrandInitConfigWC) super.ON()).uin), (AppBrandInitConfigWC) super.ON(), ON().cyA);
                    ((AppBrandInitConfigWC) super.ON()).dC(((AppBrandInitConfigWC) super.ON()).ldW.kEY);
                }
                super.ag(ICommLibReader.class);
                super.a(appBrandInitConfig, str);
                AppMethodBeat.o(226217);
            }

            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
            public final void onConfigurationChanged(Configuration configuration) {
                AppMethodBeat.i(43903);
                super.onConfigurationChanged(configuration);
                com.tencent.mm.plugin.appbrand.jsapi.y.h.a(configuration, this.mAppId);
                this.kDr = new Configuration(configuration);
                this.kDv.onConfigurationChanged(configuration);
                AppMethodBeat.o(43903);
            }

            @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
            public final boolean bry() {
                AppMethodBeat.i(43904);
                if (NA()) {
                    AppMethodBeat.o(43904);
                    return false;
                } else if (com.tencent.mm.protocal.d.KyO <= 654314239) {
                    AppMethodBeat.o(43904);
                    return false;
                } else if (!com.tencent.mm.protocal.d.KyP || ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_init_service_before_page, false)) {
                    AppMethodBeat.o(43904);
                    return true;
                } else {
                    AppMethodBeat.o(43904);
                    return false;
                }
            }

            /* access modifiers changed from: protected */
            public final void bsv() {
                AppMethodBeat.i(43905);
                b(com.tencent.mm.plugin.appbrand.networking.c.class, com.tencent.mm.plugin.appbrand.networking.h.njF);
                b(j.class, new m(this));
                b(k.class, o.nxJ);
                b(com.tencent.mm.plugin.appbrand.jsapi.media.e.class, com.tencent.mm.plugin.appbrand.jsapi.media.p.meq);
                ag(com.tencent.mm.plugin.appbrand.networking.d.class);
                b(com.tencent.mm.plugin.appbrand.networking.d.class, new g(this));
                b(com.tencent.mm.plugin.appbrand.jsapi.base.g.class, new ab());
                b(com.tencent.mm.plugin.appbrand.widget.g.class, com.tencent.mm.plugin.appbrand.widget.h.ols);
                b(com.tencent.mm.plugin.appbrand.jsapi.z.b.class, com.tencent.mm.plugin.appbrand.luggage.b.c.nac);
                b(com.tencent.luggage.sdk.f.a.class, com.tencent.mm.plugin.appbrand.app.g.kIF);
                b(ba.class, new ah(this));
                b(a.AbstractC0675a.class, new a.AbstractC0675a() {
                    /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass19 */

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.media.a.AbstractC0675a
                    public final void a(final Context context, final Runnable runnable, final Runnable runnable2) {
                        AppMethodBeat.i(226203);
                        if (!com.tencent.mm.plugin.appbrand.utils.ag.LB()) {
                            q.this.i(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass19.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(174677);
                                    com.tencent.mm.platformtools.p.a(context, runnable, runnable2);
                                    AppMethodBeat.o(174677);
                                }
                            }, 0);
                            AppMethodBeat.o(226203);
                            return;
                        }
                        com.tencent.mm.platformtools.p.a(context, runnable, runnable2);
                        AppMethodBeat.o(226203);
                    }
                });
                p.Uj(this.mAppId);
                AppMethodBeat.o(43905);
            }

            private void bsw() {
                AppMethodBeat.i(226218);
                if (bsr() || bb.r(this)) {
                    Log.w("MicroMsg.AppBrandRuntimeWC", "initFloatBallHelper appId[%s], skip fakeNative", this.mAppId);
                    AppMethodBeat.o(226218);
                    return;
                }
                if (this.kDs != null) {
                    Log.i("MicroMsg.AppBrandRuntimeWC", "initFloatBallHelper, destroy");
                    this.kDs.w(this);
                }
                this.kDs = new com.tencent.mm.plugin.appbrand.floatball.c();
                this.kDs.v(this);
                AppMethodBeat.o(226218);
            }

            private void bsx() {
                AppMethodBeat.i(226219);
                if (bsr() || bb.r(this)) {
                    Log.w("MicroMsg.AppBrandRuntimeWC", "initMultiTaskHelper appId[%s], skip fakeNative", this.mAppId);
                    AppMethodBeat.o(226219);
                    return;
                }
                if (this.kDt != null) {
                    Log.i("MicroMsg.AppBrandRuntimeWC", "initMultiTaskHelper, destroy");
                    com.tencent.mm.plugin.appbrand.q.c.w(this);
                }
                this.kDt = new com.tencent.mm.plugin.appbrand.q.c();
                this.kDt.v(this);
                AppMethodBeat.o(226219);
            }

            /* access modifiers changed from: protected */
            public final void bsy() {
                AppMethodBeat.i(43907);
                com.tencent.luggage.sdk.g.c.a("clearDuplicatedInstanceOnAppCreate", new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(174656);
                        q TQ = a.TQ(q.this.mAppId);
                        if (!(TQ == null || q.this == TQ)) {
                            Log.i("MicroMsg.AppBrandRuntimeWC", "clearDuplicatedInstanceOnAppCreate duplicated[%d] this[%d]", Integer.valueOf(TQ.hashCode()), Integer.valueOf(hashCode()));
                            TQ.bsH();
                        }
                        AppBrandRemoteTaskController appBrandRemoteTaskController = q.this.kDi;
                        String str = q.this.mAppId;
                        appBrandRemoteTaskController.nPd = AppBrandRemoteTaskController.a.CLEAR_DUPLICATED;
                        appBrandRemoteTaskController.mAppId = str;
                        AppBrandMainProcessService.a(appBrandRemoteTaskController);
                        AppMethodBeat.o(174656);
                    }
                });
                AppMethodBeat.o(43907);
            }

            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
            public final void brv() {
                AppMethodBeat.i(43908);
                Log.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] onPostInit appId[%s]", this.mAppId);
                MMToClientEvent.e((com.tencent.mm.plugin.appbrand.service.c) super.NY());
                MMToClientEvent.YY("Common_IPC_appid");
                x.a.bUB().ce(this.mAppId, ON().cyA.scene);
                if (((com.tencent.mm.plugin.appbrand.service.c) super.NY()).bqZ().compareTo(gt(false)) != 0) {
                    IllegalStateException illegalStateException = new IllegalStateException(String.format(Locale.ENGLISH, "onPostInit appId[%s] mismatch libReader, self[%s] service[%s]", this.mAppId, gt(false).bvb(), ((com.tencent.mm.plugin.appbrand.service.c) super.NY()).bqZ().bvb()));
                    AppMethodBeat.o(43908);
                    throw illegalStateException;
                }
                super.brv();
                AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.ON();
                this.kDk.I(0, System.currentTimeMillis() - appBrandInitConfigWC.startTime);
                com.tencent.mm.plugin.appbrand.performance.c.b(this.mAppId, "ActivityCreate", ((AppBrandInitConfigWC) super.ON()).startTime, System.currentTimeMillis());
                p pVar = this.kDw;
                kotlin.g.b.p.h(appBrandInitConfigWC, "initConfig");
                if (!pVar.nHI && appBrandInitConfigWC.cyz == com.tencent.luggage.sdk.launching.b.PRE_RENDER) {
                    pVar.nHI = true;
                }
                MMToClientEvent.a(this.mAppId, new MMToClientEvent.c() {
                    /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass3 */

                    @Override // com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c
                    public final void cq(Object obj) {
                        AppMethodBeat.i(226179);
                        if (obj instanceof AppBrandAuthorizeUI.AuthStateChangedByUserEvent) {
                            Log.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], AuthStateChangedByUserEvent", q.this.mAppId);
                            com.tencent.mm.plugin.appbrand.permission.a.a.aer(q.this.mAppId);
                            AppBrandBackgroundRunningMonitor.a(q.this, (AppBrandAuthorizeUI.AuthStateChangedByUserEvent) obj);
                        }
                        AppMethodBeat.o(226179);
                    }
                });
                MMToClientEvent.a("Common_IPC_appid", new MMToClientEvent.c() {
                    /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass4 */

                    @Override // com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c
                    public final void cq(Object obj) {
                        AppMethodBeat.i(226180);
                        if (obj instanceof GetOnLineInfoInfoResult) {
                            Log.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], GetOnLineInfoInfoResult", q.this.mAppId);
                            p.Un(q.this.mAppId).jjN = ((GetOnLineInfoInfoResult) obj).jjN;
                            p.Un(q.this.mAppId).jjS = ((GetOnLineInfoInfoResult) obj).jjS;
                            p.Un(q.this.mAppId).kDf = ((GetOnLineInfoInfoResult) obj).kDf;
                        }
                        AppMethodBeat.o(226180);
                    }
                });
                MMToClientEvent.a(this.mAppId, new MMToClientEvent.c() {
                    /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass5 */

                    @Override // com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c
                    public final void cq(Object obj) {
                        AppMethodBeat.i(226181);
                        if (obj instanceof EventLocationBackgroundStateChanged) {
                            if (!((EventLocationBackgroundStateChanged) obj).kYn) {
                                Log.i("MicroMsg.AppBrandRuntimeWC", "locationBackgroundStateChanged, not listening, appId[%s]", q.this.mAppId);
                                q.this.kAH.kQM.a(d.a.ON_STOP_BACKGROUND_LOCATION_LISTENING);
                            }
                            AppMethodBeat.o(226181);
                        } else if (obj instanceof WxaAppMsgChannel) {
                            Log.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], WxaAppMsgChannel msg", q.this.mAppId);
                            com.tencent.mm.plugin.appbrand.jsapi.m.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.m.a();
                            com.tencent.mm.plugin.appbrand.service.c bsE = q.this.bsE();
                            WxaAppMsgChannel wxaAppMsgChannel = (WxaAppMsgChannel) obj;
                            Log.i("MicroMsg.onReceiveMsgChannelJsApiEvent", "dispatch msg channel to web ， msgContent:%s", wxaAppMsgChannel.dWG);
                            HashMap hashMap = new HashMap();
                            hashMap.put("msgId", wxaAppMsgChannel.msgId);
                            hashMap.put("sendTime", Long.valueOf(wxaAppMsgChannel.lhG));
                            hashMap.put("msgType", Integer.valueOf(wxaAppMsgChannel.msgType));
                            hashMap.put("msgContent", wxaAppMsgChannel.dWG);
                            aVar.g(bsE);
                            Log.i("MicroMsg.onReceiveMsgChannelJsApiEvent", "dispatch wxa msg channel");
                            aVar.L(hashMap).bEo();
                            AppMethodBeat.o(226181);
                        } else {
                            if (obj instanceof AppBrandVoIP1v1FloatBallEvent) {
                                Log.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], AppBrandVoIP1v1FloatBallEvent msg", q.this.mAppId);
                                if (((AppBrandVoIP1v1FloatBallEvent) obj).dRq == 1) {
                                    com.tencent.mm.plugin.appbrand.jsapi.openvoice.q.bIi();
                                }
                            }
                            AppMethodBeat.o(226181);
                        }
                    }
                });
                new g.a(this, (byte) 0);
                this.kDk.I(8, System.currentTimeMillis() - appBrandInitConfigWC.startTime);
                vx(2);
                com.tencent.mm.plugin.appbrand.pip.f fVar = this.kAQ;
                if (fVar != null) {
                    fVar.nDw = com.tencent.mm.plugin.appbrand.pip.k.nDP;
                    fVar.bTG();
                    fVar.nDy = com.tencent.mm.plugin.appbrand.pip.g.INSTANCE;
                }
                ((com.tencent.mm.plugin.appbrand.service.c) super.NY()).b(getWindowAndroid());
                ag bsz = bsz();
                if (bsz != null) {
                    bsz.b(getWindowAndroid());
                }
                AppMethodBeat.o(43908);
            }

            @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
            public final ab brK() {
                AppMethodBeat.i(226221);
                ab brK = super.brK();
                AppMethodBeat.o(226221);
                return brK;
            }

            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
            public final void brq() {
                AppMethodBeat.i(226222);
                super.brq();
                com.tencent.mm.plugin.appbrand.report.quality.b.I(this);
                AppMethodBeat.o(226222);
            }

            @Override // com.tencent.luggage.sdk.d.d, com.tencent.mm.plugin.appbrand.AppBrandRuntime
            public void onReady() {
                int i2;
                int aeJ;
                QualitySessionRuntime qualitySessionRuntime;
                int i3;
                QualitySessionRuntime qualitySessionRuntime2;
                ac acVar;
                AppMethodBeat.i(43909);
                super.onReady();
                p.Un(this.mAppId).lastResumeTime = System.currentTimeMillis();
                if (this.kDm != 0) {
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.kDm);
                    this.kDm = 0;
                }
                long currentTimeMillis = System.currentTimeMillis() - ((AppBrandInitConfigWC) super.ON()).startTime;
                i.a(currentTimeMillis, this.kDl, NA());
                Log.i("MicroMsg.AppBrandRuntimeWC", "onReady reportStartupTime: appId:%s, nickname:%s, cost:%dms, download:%b, isGame:%b", this.mAppId, ((AppBrandInitConfigWC) super.ON()).brandName, Long.valueOf(currentTimeMillis), Boolean.valueOf(this.kDl), Boolean.valueOf(NA()));
                long currentTimeMillis2 = System.currentTimeMillis() - ((AppBrandInitConfigWC) super.ON()).startTime;
                this.kDk.I(5, currentTimeMillis2);
                o oVar = this.kDk;
                boolean z = this.kDl;
                boolean z2 = ((AppBrandInitConfigWC) super.ON()).cyy;
                boolean z3 = ((AppStartupPerformanceReportBundle) av(AppStartupPerformanceReportBundle.class)).mSG;
                String str = this.mAppId;
                oVar.cR = 0;
                oVar.mType = 0;
                if (bsB() != null) {
                    oVar.cR = bsB().leE.pkgVersion;
                    oVar.mType = bsB().leE.kNW + 1;
                }
                oVar.kCH = z ? 1 : 0;
                if (NA()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                oVar.kCM = i2;
                oVar.mScene = ON().cyA.scene;
                oVar.kCK = z2;
                oVar.kCL = z3;
                StringBuilder sb = new StringBuilder();
                int i4 = 0;
                while (true) {
                    if (i4 >= oVar.kCG.length) {
                        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.ON();
                        if (appBrandInitConfigWC != null) {
                            aeJ = appBrandInitConfigWC.cyo;
                        } else {
                            aeJ = com.tencent.mm.plugin.appbrand.report.j.aeJ(str);
                            Log.i("MicroMsg.AppBrandRuntimeStartupReporter", "getServiceTypeForReport null = initConfig! appServiceType:%s", Integer.valueOf(aeJ));
                        }
                        int i5 = aeJ + 1000;
                        Log.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: %s, %s, Download: %s, Preload: %s, appServiceType: %s", str, sb.toString(), Boolean.valueOf(z), Boolean.valueOf(com.tencent.mm.plugin.appbrand.task.e.k(com.tencent.mm.plugin.appbrand.task.g.iD(NA()))), Integer.valueOf(i5));
                        oVar.g(str, 1, 0, i5);
                        oVar.g(str, 2, 1, i5);
                        oVar.g(str, 3, 2, i5);
                        oVar.g(str, 4, 3, i5);
                        oVar.g(str, 6, 4, i5);
                        oVar.g(str, 7, 5, i5);
                        oVar.g(str, 23, 6, i5);
                        oVar.g(str, 24, 7, i5);
                        oVar.g(str, 25, 8, i5);
                        oVar.g(str, 26, 9, i5);
                        oVar.g(str, 27, 10, i5);
                        oVar.g(str, 28, 11, i5);
                        oVar.g(str, 29, 12, i5);
                        oVar.g(str, 30, 13, i5);
                        oVar.g(str, 31, 14, i5);
                        com.tencent.mm.appbrand.v8.x.a(4, oVar.kCG[5], oVar.kCM == 1 ? oVar.kCJ : oVar.kCI, str, oVar.kCH, oVar.kCM, gt(false).bvd());
                    } else if (oVar.kCG[i4] < 0) {
                        Log.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: abort, illegal value: %d, %d", Integer.valueOf(i4), Long.valueOf(oVar.kCG[i4]));
                        break;
                    } else {
                        sb.append(oVar.kCG[i4]);
                        sb.append(",");
                        i4++;
                    }
                }
                AppBrandPerformanceManager.a(this, 202, currentTimeMillis2);
                com.tencent.mm.plugin.appbrand.performance.c.Bo(((AppBrandInitConfigWC) super.ON()).startTime);
                com.tencent.mm.plugin.appbrand.report.quality.b.a(this.mAppId, this);
                if (DebuggerShell.bAx() && this.kDp == null) {
                    this.kDp = new MTimerHandler(b.a.INST.bSR().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                        /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass14 */

                        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                        public final boolean onTimerExpired() {
                            AppMethodBeat.i(226198);
                            com.tencent.mm.plugin.appbrand.performance.b.h(q.this);
                            AppMethodBeat.o(226198);
                            return true;
                        }
                    }, true);
                    this.kDp.startTimer(1000);
                }
                if (NA()) {
                    com.tencent.mm.plugin.appbrand.game.preload.e.bDw().dX(2001, (int) (Util.nowMilliSecond() - ((AppBrandInitConfigWC) super.ON()).startTime));
                }
                com.tencent.mm.plugin.appbrand.ui.recommend.e.Q(this);
                if (((AppBrandInitConfigWC) super.ON()).cyz != com.tencent.luggage.sdk.launching.b.PRE_RENDER) {
                    this.kDi.iC(false);
                }
                if (OK() != null) {
                    s.f(((com.tencent.mm.plugin.appbrand.appstorage.o) OK().az(com.tencent.mm.plugin.appbrand.appstorage.o.class)).kSr + "/dir.lock", new byte[1], 1);
                }
                QualitySessionRuntime aeU = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId);
                if (aeU != null && !NA()) {
                    com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
                    kotlin.g.b.p.h(this, "runtime");
                    nb nbVar = new nb();
                    QualitySessionRuntime aeU2 = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId);
                    if (aeU2 != null) {
                        nbVar.eWb = nbVar.x("InstanceId", aeU2.kEY, true);
                        nbVar.eJx = nbVar.x("AppId", aeU2.appId, true);
                        nbVar.eXc = (long) aeU2.nLk;
                        nbVar.ffU = nb.a.mN(aeU2.nJE);
                        nbVar.eYW = (long) aeU2.apptype;
                        nbVar.erW = (long) aeU2.scene;
                        com.tencent.mm.plugin.appbrand.page.x xVar = (com.tencent.mm.plugin.appbrand.page.x) super.brh();
                        kotlin.g.b.p.g(xVar, "runtime.pageContainer");
                        t currentPage = xVar.getCurrentPage();
                        if (currentPage != null) {
                            acVar = currentPage.getCurrentPageView();
                        } else {
                            acVar = null;
                        }
                        if (!(acVar instanceof ag)) {
                            acVar = null;
                        }
                        nbVar.evl = com.tencent.mm.plugin.appbrand.report.quality.d.z((ag) acVar);
                        qualitySessionRuntime2 = aeU2;
                    } else {
                        qualitySessionRuntime2 = null;
                    }
                    com.tencent.mm.plugin.appbrand.report.quality.d.a(qualitySessionRuntime2, "Null session with " + this.mAppId);
                    nbVar.eZK = aeU.bVg();
                    nbVar.bfK();
                }
                if (aeU != null) {
                    com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
                    kotlin.g.b.p.h(this, "runtime");
                    ma maVar = new ma();
                    QualitySessionRuntime aeU3 = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId);
                    if (aeU3 != null) {
                        maVar.eWb = maVar.x("InstanceId", aeU3.kEY, true);
                        maVar.eJx = maVar.x("AppId", aeU3.appId, true);
                        maVar.eXc = (long) aeU3.nLk;
                        maVar.faN = ma.a.mm(aeU3.nJE);
                        maVar.eYW = (long) aeU3.apptype;
                        maVar.erW = (long) aeU3.scene;
                        com.tencent.mm.plugin.appbrand.service.c cVar = (com.tencent.mm.plugin.appbrand.service.c) super.NY();
                        switch (com.tencent.mm.plugin.appbrand.report.quality.e.$EnumSwitchMapping$0[com.tencent.mm.plugin.appbrand.report.e.d(cVar != null ? cVar.getJsRuntime() : null).ordinal()]) {
                            case 1:
                                i3 = 1;
                                break;
                            case 2:
                                i3 = 2;
                                break;
                            case 3:
                                i3 = 3;
                                break;
                            case 4:
                                i3 = 4;
                                break;
                            case 5:
                                i3 = 5;
                                break;
                            case 6:
                                i3 = 6;
                                break;
                            default:
                                i3 = -1;
                                break;
                        }
                        maVar.evl = (long) i3;
                        qualitySessionRuntime = aeU3;
                    } else {
                        qualitySessionRuntime = null;
                    }
                    com.tencent.mm.plugin.appbrand.report.quality.d.a(qualitySessionRuntime, "Null session with " + this.mAppId);
                    maVar.eZK = aeU.bVg();
                    maVar.bfK();
                }
                com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup);
                com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup_Game);
                com.tencent.mm.plugin.appbrand.keylogger.c.f(KSProcessWeAppLaunch.class, this.mAppId);
                com.tencent.mm.plugin.appbrand.report.quality.k.cj(this.mAppId, 1);
                AppMethodBeat.o(43909);
            }

            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
            public final void bru() {
                AppMethodBeat.i(43910);
                super.bru();
                String qVar = toString();
                ConcurrentLinkedQueue<AppBrandRuntime.b> concurrentLinkedQueue = this.kAW;
                if (concurrentLinkedQueue == null || concurrentLinkedQueue.size() <= 0) {
                    Log.i("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, no pending processes", qVar);
                } else {
                    Iterator<AppBrandRuntime.b> it = concurrentLinkedQueue.iterator();
                    while (it.hasNext()) {
                        Log.i("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, process[%s]", qVar, it.next().toString());
                    }
                }
                vx(11);
                com.tencent.mm.plugin.appbrand.keylogger.c.c(this.mAppId, KSProcessWeAppLaunch.stepPrepareResourceTimeout);
                AppMethodBeat.o(43910);
            }

            @Override // com.tencent.luggage.sdk.d.d, com.tencent.mm.plugin.appbrand.AppBrandRuntime
            public final void onResume() {
                AppMethodBeat.i(43911);
                super.onResume();
                p.Un(this.mAppId).lastResumeTime = System.currentTimeMillis();
                if (this.kDs != null) {
                    com.tencent.mm.plugin.appbrand.floatball.c cVar = this.kDs;
                    Log.i("MicroMsg.AppBrandFloatBallLogic", "resume, runtime:%s", this.mAppId);
                    if (cVar.lqw != null) {
                        cVar.lqw.bCA();
                    }
                    if (cVar.lqx != null) {
                        cVar.lqx.bCA();
                    }
                    if (cVar.lqy != null) {
                        cVar.lqy.bCA();
                    }
                    if (cVar.lqA != null) {
                        cVar.lqA.bCA();
                    }
                    if (cVar.lqz != null) {
                        cVar.lqz.bCA();
                    }
                }
                if (this.kDt != null) {
                    com.tencent.mm.plugin.appbrand.q.c cVar2 = this.kDt;
                    Log.i("MicroMsg.AppBrandMultiTaskLogic", "resume, runtime:%s", this.mAppId);
                    if (cVar2.nhs != null) {
                        cVar2.nhs.bCA();
                        if (((AppBrandInitConfigWC) super.ON()).kHP != null) {
                            cVar2.nhs.a(((AppBrandInitConfigWC) super.ON()).kHP.kHu);
                            Log.i("MicroMsg.AppBrandMultiTaskLogic", "setMultiTaskCommonInfo not null");
                        } else {
                            cVar2.nhs.a((ach) null);
                            Log.i("MicroMsg.AppBrandMultiTaskLogic", "setMultiTaskCommonInfo null enter scene:%d", Integer.valueOf(ON().cyA.scene));
                            if (ON().cyA.scene == 1089 || ON().cyA.scene == 1104) {
                                cVar2.nhs.AbJ = Boolean.TRUE;
                            } else {
                                cVar2.nhs.AbJ = Boolean.FALSE;
                            }
                        }
                    }
                }
                com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.k.a(this.mAppId, brs(), ON().cyA);
                a.setRuntime(this);
                com.tencent.mm.plugin.appbrand.e.a.Q(this);
                this.kDi.O(this);
                if (this.kAK) {
                    ((com.tencent.mm.plugin.appbrand.page.x) super.brh()).getReporter().bOD();
                }
                x.a.bUB().ce(this.mAppId, ON().cyA.scene);
                u a2 = u.a(this, new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(43870);
                        AppBrandSysConfigWC bsB = q.this.bsB();
                        WxaMenuHelper.GetCopyPathMenuExpireTimeTask getCopyPathMenuExpireTimeTask = new WxaMenuHelper.GetCopyPathMenuExpireTimeTask(q.this.mAppId);
                        AppBrandMainProcessService.b(getCopyPathMenuExpireTimeTask);
                        bsB.czc = WxaMenuHelper.GetCopyPathMenuExpireTimeTask.a(getCopyPathMenuExpireTimeTask);
                        AppMethodBeat.o(43870);
                    }
                });
                keep(a2);
                com.tencent.f.h.RTc.b(a2, "getCopyPathMenuExpireTime");
                com.tencent.mm.plugin.appbrand.ipc.b.connect();
                if (bsz() != null) {
                    bsq().Uo(bsz().lBI);
                    AppMethodBeat.o(43911);
                    return;
                }
                Log.w("MicroMsg.AppBrandRuntimeWC", "onResume, try upsertHandOff but get NULL PageView, appId:%s", this.mAppId);
                AppMethodBeat.o(43911);
            }

            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
            public final void onPause() {
                AppMethodBeat.i(43912);
                super.onPause();
                AppBrandRemoteTaskController appBrandRemoteTaskController = this.kDi;
                appBrandRemoteTaskController.nPd = AppBrandRemoteTaskController.a.NOTIFY_PAUSE;
                AppBrandMainProcessService.a(appBrandRemoteTaskController);
                if (this.kDs != null) {
                    com.tencent.mm.plugin.appbrand.floatball.c cVar = this.kDs;
                    Log.i("MicroMsg.AppBrandFloatBallLogic", "pause, runtime:%s", this.mAppId);
                    if (cVar.lqw != null) {
                        cVar.lqw.aGj();
                    }
                    if (cVar.lqx != null) {
                        cVar.lqx.aGj();
                    }
                    if (cVar.lqy != null) {
                        cVar.lqy.aGj();
                    }
                    if (cVar.lqA != null) {
                        cVar.lqA.aGj();
                    }
                    if (cVar.lqz != null) {
                        cVar.lqz.aGj();
                    }
                }
                if (this.kDt != null) {
                    com.tencent.mm.plugin.appbrand.q.c cVar2 = this.kDt;
                    Log.i("MicroMsg.AppBrandMultiTaskLogic", "pause, runtime:%s", this.mAppId);
                    if (cVar2.nhs != null) {
                        cVar2.nhs.aGj();
                    }
                }
                bsq().bsP();
                AppMethodBeat.o(43912);
            }

            @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
            public final boolean brJ() {
                AppMethodBeat.i(43913);
                boolean z = !isInBackStack() && !a.a(this);
                Log.i("MicroMsg.AppBrandRuntimeWC", "[wxa_reload]recycleRuntime %s, recycle[%b]", toString(), Boolean.valueOf(z));
                if (z) {
                    finish();
                }
                AppMethodBeat.o(43913);
                return z;
            }

            /* access modifiers changed from: package-private */
            public final void bsA() {
                AppMethodBeat.i(43915);
                gv(false);
                AppMethodBeat.o(43915);
            }

            private void gv(boolean z) {
                AppMethodBeat.i(226223);
                if (this.kDi != null) {
                    Log.i("MicroMsg.AppBrandRuntimeWC", "notifyRemovedToMMTaskManager(isForDestroy:%b), appId:%s", Boolean.valueOf(z), this.mAppId);
                    this.kDi.aeZ(this.mAppId);
                    if (z) {
                        this.kDi.bDK();
                        this.kDi = null;
                        AppMethodBeat.o(226223);
                        return;
                    }
                } else {
                    Log.e("MicroMsg.AppBrandRuntimeWC", "notifyRemovedToMMTaskManager(isForDestroy:%b), appId:%s, mRemoteController==NULL", Boolean.valueOf(z), this.mAppId);
                }
                AppMethodBeat.o(226223);
            }

            /* access modifiers changed from: package-private */
            public final class b extends AppBrandRuntime.b {
                volatile AppBrandPrepareTask kDV;
                volatile boolean kDW;

                private b() {
                    this.kDW = false;
                }

                /* synthetic */ b(q qVar, byte b2) {
                    this();
                }

                @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime.b
                public final void prepare() {
                    AppMethodBeat.i(43883);
                    Log.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| ResourcePrepareProcess.prepare() appId:%s", q.this.mAppId);
                    com.tencent.mm.plugin.appbrand.launching.g.a(q.this, new kotlin.g.a.b<ICommLibReader, kotlin.x>() {
                        /* class com.tencent.mm.plugin.appbrand.q.b.AnonymousClass1 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // kotlin.g.a.b
                        public final /* synthetic */ kotlin.x invoke(ICommLibReader iCommLibReader) {
                            AppMethodBeat.i(43882);
                            kotlin.x bsT = bsT();
                            AppMethodBeat.o(43882);
                            return bsT;
                        }

                        private kotlin.x bsT() {
                            AppMethodBeat.i(162153);
                            if (!b.this.kDW) {
                                try {
                                    b.this.kDV = q.b(q.this, b.this);
                                } catch (NullPointerException e2) {
                                    if (!q.this.isDestroyed()) {
                                        AppMethodBeat.o(162153);
                                        throw e2;
                                    }
                                }
                            }
                            kotlin.x xVar = kotlin.x.SXb;
                            AppMethodBeat.o(162153);
                            return xVar;
                        }
                    });
                    AppMethodBeat.o(43883);
                }

                @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime.b
                public final void interrupt() {
                    AppMethodBeat.i(43884);
                    this.kDW = true;
                    AppBrandPrepareTask appBrandPrepareTask = this.kDV;
                    if (appBrandPrepareTask != null) {
                        appBrandPrepareTask.interrupt();
                    }
                    AppMethodBeat.o(43884);
                }
            }

            @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
            public final void brk() {
                boolean z;
                AppMethodBeat.i(226225);
                com.tencent.mm.plugin.appbrand.config.b appConfig = getAppConfig();
                String d2 = bg.d(this, "/app-config.json");
                if (Util.isNullOrNil(d2)) {
                    Iterator<ModulePkgInfo> it = bsB().leE.kNZ.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            d2 = d2;
                            break;
                        }
                        ModulePkgInfo next = it.next();
                        if (next.independent) {
                            d2 = bg.d(this, next.name + (next.name.endsWith(FilePathGenerator.ANDROID_DIR_SEP) ? "" : FilePathGenerator.ANDROID_DIR_SEP) + "app-config.json");
                            if (!Util.isNullOrNil(d2)) {
                                break;
                            }
                        } else {
                            d2 = d2;
                        }
                    }
                }
                String d3 = bg.d(this, "/app-config-darkmode.json");
                if (TextUtils.isEmpty(d3)) {
                    d3 = "{}";
                }
                com.tencent.mm.plugin.appbrand.config.b b2 = com.tencent.mm.plugin.appbrand.config.b.b(this.mAppId, d2, d3, Boolean.parseBoolean(gt(true).UN("pruneWxConfigByPage")), NA());
                if (!NA()) {
                    b2.lbP.cBG = ((AppBrandInitConfigWC) super.ON()).cBG;
                    b2.lbP.lcd = true;
                } else if (!b2.lbR.booleanValue()) {
                    b2.lbP.cBG = ((AppBrandInitConfigWC) super.ON()).cyv.lgT;
                }
                if (bb.r(this)) {
                    b2.lbP.cBG = "portrait";
                }
                b(b2);
                bsG();
                if (NA()) {
                    com.tencent.mm.plugin.appbrand.game.preload.d bDu = com.tencent.mm.plugin.appbrand.game.preload.d.bDu();
                    if (bDu.hasInit) {
                        bDu.ltU.ltP.addAll(bDu.kGW.kAA);
                        bDu.ltS = (com.tencent.mm.plugin.appbrand.s.a) bDu.kGW.av(com.tencent.mm.plugin.appbrand.s.a.class);
                        bDu.ltT = bDu.kGW.OK();
                        com.tencent.mm.plugin.appbrand.s.m mVar = bDu.ltR;
                        com.tencent.mm.plugin.appbrand.s.a aVar = (com.tencent.mm.plugin.appbrand.s.a) mVar.lqg.av(com.tencent.mm.plugin.appbrand.s.a.class);
                        mVar.nhP = aVar.cyM;
                        mVar.mGo = aVar.nhM;
                        mVar.nhR = com.tencent.mm.plugin.appbrand.s.j.a(aVar);
                    }
                    Q(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass9 */

                        public final void run() {
                            AppMethodBeat.i(162152);
                            try {
                                com.tencent.mm.plugin.appbrand.game.preload.d bDu = com.tencent.mm.plugin.appbrand.game.preload.d.bDu();
                                if (bDu.ltW) {
                                    if (!bDu.hasInit) {
                                        Log.e("MicroMsg.WAGamePreloadManager", "hasn't init!");
                                        AppMethodBeat.o(162152);
                                        return;
                                    } else if (bDu.kGW != null) {
                                        if (bDu.kGW.getAppConfig() == null) {
                                            Log.e("MicroMsg.WAGamePreloadManager", "downloadPreloadFiles getAppConfig null!");
                                            AppMethodBeat.o(162152);
                                            return;
                                        }
                                        JSONArray jSONArray = bDu.kGW.getAppConfig().lbT;
                                        if (jSONArray != null) {
                                            com.tencent.mm.plugin.appbrand.game.preload.e.bDw().dX(3000, jSONArray.length());
                                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                                try {
                                                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                                                    if (jSONObject != null) {
                                                        String optString = jSONObject.optString("url");
                                                        String optString2 = jSONObject.optString("path");
                                                        if (!Util.isNullOrNil(optString) && !Util.isNullOrNil(optString2)) {
                                                            if (bDu.ltT.Vj(optString2) == com.tencent.mm.plugin.appbrand.appstorage.m.OK) {
                                                                Log.i("MicroMsg.WAGamePreloadManager", "predownload path %s has exists!", optString2);
                                                            } else {
                                                                bDu.ltV.add(optString);
                                                                d.AnonymousClass2 r6 = 
                                                                /*  JADX ERROR: Method code generation error
                                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00b7: CONSTRUCTOR  (r6v0 'r6' com.tencent.mm.plugin.appbrand.game.preload.d$2) = 
                                                                      (r10v0 'bDu' com.tencent.mm.plugin.appbrand.game.preload.d)
                                                                      (r0v13 'optString' java.lang.String)
                                                                      (r2v4 'optString2' java.lang.String)
                                                                     call: com.tencent.mm.plugin.appbrand.game.preload.d.2.<init>(com.tencent.mm.plugin.appbrand.game.preload.d, java.lang.String, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.q.9.run():void, file: classes3.dex
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:210)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
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
                                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.game.preload.d, state: GENERATED_AND_UNLOADED
                                                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                                    	... 65 more
                                                                    */
                                                                /*
                                                                // Method dump skipped, instructions count: 295
                                                                */
                                                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.q.AnonymousClass9.run():void");
                                                            }
                                                        });
                                                    }
                                                    if (Util.isNullOrNil(this.mAppId) || getAppConfig() == null) {
                                                        Log.i("MicroMsg.AppBrandBackgroundConfigStorage", "updateBackgroundConfigs, runtime or appId or appConfig is null");
                                                    } else {
                                                        String str = this.mAppId;
                                                        com.tencent.mm.plugin.appbrand.config.b appConfig2 = getAppConfig();
                                                        boolean sE = j.a.sE(bsB().leE.kNW);
                                                        boolean contains = appConfig2.lbS.contains(FirebaseAnalytics.b.LOCATION);
                                                        MultiProcessMMKV.getMMKV("appbrand_background_config").encode(String.format("%s_location_background_required", str), contains);
                                                        b.e WW = appConfig2.WW("scope.userLocation");
                                                        if (WW == null || Util.isNullOrNil(WW.desc)) {
                                                            MultiProcessMMKV.getMMKV("appbrand_background_config").remove(String.format("%s_permission_location_desc", str));
                                                            z = false;
                                                        } else {
                                                            MultiProcessMMKV.getMMKV("appbrand_background_config").encode(String.format("%s_permission_location_desc", str), WW.desc);
                                                            z = true;
                                                        }
                                                        Log.i("MicroMsg.AppBrandBackgroundConfigStorage", "updateBackgroundConfigs, appId:%s, isDebug:%s, isLocationBackgroundRequired:%s, hasPermissionLocationDesc:%s", str, Boolean.valueOf(sE), Boolean.valueOf(contains), Boolean.valueOf(z));
                                                    }
                                                    if (!(appConfig == null || ((com.tencent.mm.plugin.appbrand.service.c) super.NY()) == null)) {
                                                        new com.tencent.mm.plugin.appbrand.jsapi.c.a().Zh(((com.tencent.mm.plugin.appbrand.service.c) super.NY()).Or().toString()).h(NY()).bEo();
                                                    }
                                                    AppMethodBeat.o(226225);
                                                }

                                                public final AppBrandSysConfigWC bsB() {
                                                    AppMethodBeat.i(43918);
                                                    AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) d(AppBrandSysConfigWC.class, false);
                                                    AppMethodBeat.o(43918);
                                                    return appBrandSysConfigWC;
                                                }

                                                public final AppBrandInitConfigWC bsC() {
                                                    AppMethodBeat.i(261623);
                                                    AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.ON();
                                                    AppMethodBeat.o(261623);
                                                    return appBrandInitConfigWC;
                                                }

                                                public final com.tencent.mm.plugin.appbrand.page.x bsD() {
                                                    AppMethodBeat.i(261624);
                                                    com.tencent.mm.plugin.appbrand.page.x xVar = (com.tencent.mm.plugin.appbrand.page.x) super.brh();
                                                    AppMethodBeat.o(261624);
                                                    return xVar;
                                                }

                                                public final com.tencent.mm.plugin.appbrand.service.c bsE() {
                                                    AppMethodBeat.i(261625);
                                                    com.tencent.mm.plugin.appbrand.service.c cVar = (com.tencent.mm.plugin.appbrand.service.c) super.NY();
                                                    AppMethodBeat.o(261625);
                                                    return cVar;
                                                }

                                                @Override // com.tencent.luggage.sdk.d.d, com.tencent.mm.plugin.appbrand.AppBrandRuntime
                                                public com.tencent.mm.plugin.appbrand.p.a OR() {
                                                    AppMethodBeat.i(43922);
                                                    com.tencent.mm.plugin.appbrand.p.a OR = super.OR();
                                                    AppMethodBeat.o(43922);
                                                    return OR;
                                                }

                                                public final void S(final Runnable runnable) {
                                                    AppMethodBeat.i(43923);
                                                    i(new Runnable() {
                                                        /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass11 */

                                                        public final void run() {
                                                            AppMethodBeat.i(174672);
                                                            if (q.this.isDestroyed()) {
                                                                Log.i("MicroMsg.AppBrandRuntimeWC", "startPrepareOrientation, finished appId[%s]", q.this.mAppId);
                                                                AppMethodBeat.o(174672);
                                                                return;
                                                            }
                                                            q.a(q.this, new e.a() {
                                                                /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass11.AnonymousClass1 */

                                                                @Override // com.tencent.mm.plugin.appbrand.platform.window.e.a
                                                                public final void a(e.b bVar, boolean z) {
                                                                    AppMethodBeat.i(226195);
                                                                    Log.i("MicroMsg.AppBrandRuntimeWC", "startPrepareOrientation, onOrientationChanged appId[%s], orientation[%s] success[%b]", q.this.mAppId, bVar, Boolean.valueOf(z));
                                                                    if (runnable != null) {
                                                                        runnable.run();
                                                                    }
                                                                    AppMethodBeat.o(226195);
                                                                }
                                                            }, q.o(q.this));
                                                            AppMethodBeat.o(174672);
                                                        }
                                                    }, 0);
                                                    AppMethodBeat.o(43923);
                                                }

                                                @Override // com.tencent.luggage.sdk.d.d
                                                public final boolean b(AppBrandInitConfig appBrandInitConfig) {
                                                    AppMethodBeat.i(43925);
                                                    AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) appBrandInitConfig;
                                                    AppBrandStatObject appBrandStatObject = appBrandInitConfigWC.cyA;
                                                    if (this.kDn || appBrandStatObject.scene == 1099) {
                                                        Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] mShouldRelaunchCausedByFunctionalPageOpen[%b] newScene[%d]", this.mAppId, Boolean.valueOf(this.kDn), Integer.valueOf(appBrandStatObject.scene));
                                                        this.kDn = appBrandStatObject.scene == 1099;
                                                        AppMethodBeat.o(43925);
                                                        return true;
                                                    } else if (TextUtils.isEmpty(appBrandInitConfigWC.kHw) && af.p(this)) {
                                                        Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] enterPath[%s], old is gameFunctionalPage", this.mAppId, appBrandInitConfigWC.kHw);
                                                        AppMethodBeat.o(43925);
                                                        return true;
                                                    } else if (1038 == appBrandStatObject.scene) {
                                                        Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. appId[%s], reason=1038 back from other MiniProgram", this.mAppId);
                                                        AppMethodBeat.o(43925);
                                                        return false;
                                                    } else {
                                                        for (aj ajVar : this.kDo) {
                                                            Boolean b2 = ajVar.b(appBrandInitConfigWC);
                                                            if (b2 != null) {
                                                                boolean booleanValue = b2.booleanValue();
                                                                AppMethodBeat.o(43925);
                                                                return booleanValue;
                                                            }
                                                        }
                                                        if (!TextUtils.isEmpty(appBrandInitConfigWC.kHw)) {
                                                            Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] enterPath[%s]", this.mAppId, appBrandInitConfigWC.kHw);
                                                            AppMethodBeat.o(43925);
                                                            return true;
                                                        } else if (((AppBrandInitConfigWC) super.ON()).kHL.isEnable() != appBrandInitConfigWC.kHL.isEnable()) {
                                                            Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] halfScreenConfig enable change to:%b", this.mAppId, Boolean.valueOf(appBrandInitConfigWC.kHL.isEnable()));
                                                            AppMethodBeat.o(43925);
                                                            return true;
                                                        } else if (org.apache.commons.b.a.contains(new int[]{1001, 1003, TXLiteAVCode.EVT_CAMERA_REMOVED, 1038, 1056, 1080, 1083, 1089, 1090, 1103, 1104, FaceManager.FACE_ACQUIRED_LEFT, FaceManager.FACE_ACQUIRED_RIGHT, FaceManager.FACE_WITH_EYES_CLOSED, 1131, 1019, FaceManager.FACE_ACQUIRED_BRIGHT, 1127, 1134, 1187}, appBrandStatObject.scene)) {
                                                            Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. keepNoRelaunch appId[%s] newScene[%d]", this.mAppId, Integer.valueOf(appBrandStatObject.scene));
                                                            AppMethodBeat.o(43925);
                                                            return false;
                                                        } else if (1030 != appBrandStatObject.scene || !TextUtils.isEmpty(appBrandInitConfigWC.kHw)) {
                                                            Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] fallback logic", this.mAppId);
                                                            AppMethodBeat.o(43925);
                                                            return true;
                                                        } else {
                                                            Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. special for monkey test appId[%s]", this.mAppId);
                                                            AppMethodBeat.o(43925);
                                                            return false;
                                                        }
                                                    }
                                                }

                                                @Override // com.tencent.luggage.sdk.d.d
                                                public final boolean OQ() {
                                                    AppMethodBeat.i(261626);
                                                    boolean OQ = super.OQ();
                                                    AppMethodBeat.o(261626);
                                                    return OQ;
                                                }

                                                /* access modifiers changed from: protected */
                                                @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
                                                public ab bro() {
                                                    int i2;
                                                    AppMethodBeat.i(43928);
                                                    if (NA()) {
                                                        com.tencent.mm.plugin.appbrand.game.preload.e bDw = com.tencent.mm.plugin.appbrand.game.preload.e.bDw();
                                                        bDw.luk = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_game_predownload, false) ? 1 : 0;
                                                        Log.i("MicroMsg.WAGamePreloadStatisManager", "misPreload:%d", Integer.valueOf(bDw.luk));
                                                        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.ON();
                                                        bDw.luf = appBrandInitConfigWC.appId;
                                                        bDw.lug = appBrandInitConfigWC.appVersion;
                                                        bDw.luh = appBrandInitConfigWC.eix;
                                                        bDw.lui = appBrandInitConfigWC.cyo + 1000;
                                                        bDw.luj = appBrandInitConfigWC.ldW.kEY;
                                                        switch (bDw.luh) {
                                                            case 0:
                                                                bDw.luh = 1;
                                                                break;
                                                            case 1:
                                                                bDw.luh = 2;
                                                                break;
                                                            case 2:
                                                                bDw.luh = 3;
                                                                break;
                                                        }
                                                        if (ON().cyA != null) {
                                                            bDw.mScene = ON().cyA.scene;
                                                        }
                                                        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_game_splashscreen, false)) {
                                                            i2 = 1;
                                                        } else {
                                                            i2 = 0;
                                                        }
                                                        bDw.lum = i2;
                                                        Log.i("MicroMsg.WAGamePreloadStatisManager", "mHasSplashScreen:%d", Integer.valueOf(bDw.lum));
                                                    }
                                                    ab a2 = com.tencent.mm.plugin.appbrand.ui.k.a(AndroidContextUtil.castActivityOrNull(this.mContext), this);
                                                    a2.eo(((AppBrandInitConfigWC) super.ON()).iconUrl, ((AppBrandInitConfigWC) super.ON()).brandName);
                                                    if (a2 instanceof ae) {
                                                        ((ae) a2).setCanShowHideAnimation(false);
                                                    }
                                                    if (a2 instanceof com.tencent.mm.plugin.appbrand.ui.m) {
                                                        if (TextUtils.isEmpty(((AppBrandInitConfigWC) super.ON()).ldT)) {
                                                            ((com.tencent.mm.plugin.appbrand.ui.m) a2).setLoadingIconVisibility(false);
                                                        } else {
                                                            ((com.tencent.mm.plugin.appbrand.ui.m) a2).setLoadingIconVisibility(true);
                                                        }
                                                    }
                                                    AppMethodBeat.o(43928);
                                                    return a2;
                                                }

                                                @Override // com.tencent.luggage.sdk.d.d
                                                public final v OP() {
                                                    AppMethodBeat.i(43930);
                                                    com.tencent.mm.plugin.appbrand.performance.b.E(this);
                                                    List<kv_14609> list = ((AppStartupPerformanceReportBundle) av(AppStartupPerformanceReportBundle.class)).mSx;
                                                    if (!Util.isNullOrNil(list)) {
                                                        long j2 = 0;
                                                        for (kv_14609 kv_14609 : list) {
                                                            j2 = Math.max(j2, kv_14609.nJF);
                                                        }
                                                        com.tencent.mm.plugin.appbrand.performance.b.a(this, j2);
                                                    }
                                                    if (DebuggerShell.bAx()) {
                                                        AppMethodBeat.o(43930);
                                                        return null;
                                                    }
                                                    v OP = super.OP();
                                                    AppMethodBeat.o(43930);
                                                    return OP;
                                                }

                                                public final void bsG() {
                                                    boolean z;
                                                    AppMethodBeat.i(43931);
                                                    AppBrandSysConfigWC bsB = bsB();
                                                    com.tencent.mm.plugin.appbrand.config.n.bw(this.mAppId, bsB.cza);
                                                    com.tencent.mm.plugin.appbrand.config.n.bx(this.mAppId, bsB.czb);
                                                    this.kAA.add(com.tencent.mm.plugin.appbrand.config.f.a(this));
                                                    this.kAA.add(com.tencent.mm.plugin.appbrand.config.f.a(bsB));
                                                    this.kAA.add(com.tencent.mm.plugin.appbrand.config.f.b(bsB));
                                                    this.kAA.add(com.tencent.mm.plugin.appbrand.config.f.b(this));
                                                    com.tencent.mm.plugin.appbrand.performance.a c2 = com.tencent.mm.plugin.appbrand.config.f.c(bsB);
                                                    c2.nwy |= DebuggerShell.bAx();
                                                    boolean z2 = c2.nwz;
                                                    if (BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger()) {
                                                        z = true;
                                                    } else {
                                                        z = false;
                                                    }
                                                    c2.nwz = z | z2;
                                                    this.kAA.add(c2);
                                                    AppMethodBeat.o(43931);
                                                }

                                                @Override // com.tencent.luggage.sdk.d.d, com.tencent.mm.plugin.appbrand.AppBrandRuntime
                                                public final void OO() {
                                                    AppMethodBeat.i(43934);
                                                    super.OO();
                                                    Log.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] onInitBeforeComponentsInstalled, appId[%s] mPendingPermissionUpdateTasks.size=%d", this.mAppId, Integer.valueOf(this.kDB.size()));
                                                    while (!this.kDB.isEmpty()) {
                                                        this.kDB.remove().run();
                                                    }
                                                    com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepPrepareRuntime);
                                                    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup);
                                                    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup_Game);
                                                    AppMethodBeat.o(43934);
                                                }

                                                class a implements Runnable {
                                                    private final AtomicBoolean kDO = new AtomicBoolean(false);
                                                    final /* synthetic */ Runnable val$runnable;

                                                    /* JADX WARN: Incorrect args count in method signature: ()V */
                                                    a(Runnable runnable) {
                                                        this.val$runnable = runnable;
                                                        AppMethodBeat.i(43871);
                                                        AppMethodBeat.o(43871);
                                                    }

                                                    public final void run() {
                                                        AppMethodBeat.i(43872);
                                                        if (!this.kDO.getAndSet(true)) {
                                                            Log.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] addPendingPermissionUpdateTask run()");
                                                            this.val$runnable.run();
                                                        }
                                                        AppMethodBeat.o(43872);
                                                    }
                                                }

                                                public final void T(Runnable runnable) {
                                                    AppMethodBeat.i(43935);
                                                    a aVar = new a(runnable);
                                                    this.kDB.add(aVar);
                                                    super.O(aVar);
                                                    AppMethodBeat.o(43935);
                                                }

                                                /* access modifiers changed from: protected */
                                                public final void c(s sVar) {
                                                    AppMethodBeat.i(226231);
                                                    Log.i("MicroMsg.AppBrandRuntimeWC", "onServiceProvidedBeforeRealInit, appId:%s, preloadedService:%s", this.mAppId, sVar);
                                                    AppMethodBeat.o(226231);
                                                }

                                                /* access modifiers changed from: protected */
                                                @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
                                                public final void bre() {
                                                    boolean z;
                                                    e.b aeE;
                                                    AppMethodBeat.i(226232);
                                                    bsF();
                                                    AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.ON();
                                                    if (appBrandInitConfigWC != null) {
                                                        this.kDv.a(appBrandInitConfigWC);
                                                    }
                                                    this.kDu = new com.tencent.mm.plugin.appbrand.ad.h(this);
                                                    com.tencent.mm.plugin.appbrand.ad.h hVar = this.kDu;
                                                    if (hVar.kGW.brL()) {
                                                        hVar.kGX = com.tencent.mm.plugin.appbrand.task.e.j(com.tencent.mm.plugin.appbrand.task.g.iD(((AppBrandInitConfigWC) super.ON()).NA()));
                                                        Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, appId:%s, may show ad, preloadedService:%s", hVar.kGW.mAppId, hVar.kGX);
                                                        if (hVar.kGX != null) {
                                                            if (hVar.kGW.NA()) {
                                                                AppBrandInitConfigWC appBrandInitConfigWC2 = (AppBrandInitConfigWC) super.ON();
                                                                if (appBrandInitConfigWC2 == null || !((aeE = e.b.aeE(appBrandInitConfigWC2.cBG)) == e.b.LANDSCAPE_SENSOR || aeE == e.b.LANDSCAPE_LEFT || aeE == e.b.LANDSCAPE_RIGHT)) {
                                                                    z = false;
                                                                } else {
                                                                    z = true;
                                                                }
                                                                if (z) {
                                                                    Log.w("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, appId:%s, landscape game, add check show ad prepare process", hVar.kGW.mAppId);
                                                                    hVar.kHb = new com.tencent.mm.plugin.appbrand.ad.i();
                                                                    hVar.kGW.a(hVar.kHb);
                                                                }
                                                            }
                                                            hVar.btT();
                                                            hVar.kGX.kEc = hVar.kGW;
                                                            hVar.kGX.kEa = true;
                                                            com.tencent.mm.plugin.appbrand.ad.a.f fVar = new com.tencent.mm.plugin.appbrand.ad.a.f();
                                                            fVar.source = "launch";
                                                            fVar.a(hVar.kGX, (Context) null);
                                                            hVar.kGY = 8;
                                                            com.tencent.mm.plugin.appbrand.ad.e.a(hVar.kGW, com.tencent.mm.plugin.appbrand.task.e.m(com.tencent.mm.plugin.appbrand.task.g.iD(hVar.kGW.NA())), true);
                                                        } else {
                                                            com.tencent.mm.plugin.appbrand.ad.e.a(hVar.kGW, com.tencent.mm.plugin.appbrand.task.e.m(com.tencent.mm.plugin.appbrand.task.g.iD(hVar.kGW.NA())), false);
                                                            hVar.btT();
                                                            Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, appId:%s, can not show ad", hVar.kGW.mAppId);
                                                            hVar.kGY = 0;
                                                        }
                                                    } else {
                                                        com.tencent.mm.plugin.appbrand.ad.e.a(hVar.kGW, com.tencent.mm.plugin.appbrand.task.e.m(com.tencent.mm.plugin.appbrand.task.g.iD(hVar.kGW.NA())), false);
                                                        hVar.btT();
                                                        Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, appId:%s, can not show ad", hVar.kGW.mAppId);
                                                        hVar.kGY = 0;
                                                    }
                                                    p pVar = this.kDw;
                                                    AppBrandInitConfigWC appBrandInitConfigWC3 = (AppBrandInitConfigWC) super.ON();
                                                    kotlin.g.b.p.h(appBrandInitConfigWC3, "initConfig");
                                                    if (appBrandInitConfigWC3.kHL.isEnable()) {
                                                        p.pl(0);
                                                        if (appBrandInitConfigWC3.cyz != com.tencent.luggage.sdk.launching.b.PRE_RENDER) {
                                                            p.pl(5);
                                                        }
                                                    }
                                                    pVar.nHJ = appBrandInitConfigWC3.kHL.isEnable();
                                                    AppMethodBeat.o(226232);
                                                }

                                                public final boolean bsI() {
                                                    boolean z;
                                                    if (this.kDu == null) {
                                                        return false;
                                                    }
                                                    com.tencent.mm.plugin.appbrand.ad.h hVar = this.kDu;
                                                    if (hVar.kHb != null) {
                                                        z = hVar.kHb.chu;
                                                    } else {
                                                        z = false;
                                                    }
                                                    if (z) {
                                                        return true;
                                                    }
                                                    return false;
                                                }

                                                public final int bsJ() {
                                                    if (this.kDu != null) {
                                                        return this.kDu.kGY;
                                                    }
                                                    return 9;
                                                }

                                                public static int bsK() {
                                                    AppMethodBeat.i(226233);
                                                    int btI = com.tencent.mm.plugin.appbrand.ad.b.btI();
                                                    AppMethodBeat.o(226233);
                                                    return btI;
                                                }

                                                public static int bsL() {
                                                    AppMethodBeat.i(226234);
                                                    int btI = com.tencent.mm.plugin.appbrand.ad.b.btI();
                                                    AppMethodBeat.o(226234);
                                                    return btI;
                                                }

                                                public final void onEnterAnimationComplete() {
                                                    AppMethodBeat.i(174690);
                                                    if (isDestroyed() || this.SO) {
                                                        AppMethodBeat.o(174690);
                                                        return;
                                                    }
                                                    QualitySessionRuntime aeU = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId);
                                                    if (aeU != null) {
                                                        aeU.nLs = Util.nowMilliSecond();
                                                    }
                                                    ab brK = super.brK();
                                                    if (brK instanceof ae) {
                                                        ((ae) brK).setCanShowHideAnimation(true);
                                                    }
                                                    if (brK instanceof com.tencent.mm.plugin.appbrand.ui.m) {
                                                        ((com.tencent.mm.plugin.appbrand.ui.m) brK).setLoadingIconVisibility(true);
                                                    }
                                                    if (AndroidContextUtil.castActivityOrNull(this.mContext) != null) {
                                                        com.tencent.mm.ui.statusbar.c.bt(AndroidContextUtil.castActivityOrNull(this.mContext)).requestApplyInsets();
                                                    }
                                                    if (((AppBrandInitConfigWC) super.ON()).leh != null) {
                                                        ((AppBrandInitConfigWC) super.ON()).leh.mXx.b(new IPCVoid());
                                                    }
                                                    AppMethodBeat.o(174690);
                                                }

                                                public final String bsm() {
                                                    AppMethodBeat.i(226209);
                                                    if (((AppBrandInitConfigWC) super.ON()) == null) {
                                                        AppMethodBeat.o(226209);
                                                        return "NULL";
                                                    }
                                                    String str = ((AppBrandInitConfigWC) super.ON()).brandName;
                                                    AppMethodBeat.o(226209);
                                                    return str;
                                                }

                                                public final void a(ICommLibReader iCommLibReader) {
                                                    AppMethodBeat.i(43888);
                                                    if (gt(false) != null) {
                                                        IllegalStateException illegalStateException = new IllegalStateException("Duplicated call!!");
                                                        AppMethodBeat.o(43888);
                                                        throw illegalStateException;
                                                    } else if (iCommLibReader == null) {
                                                        NullPointerException nullPointerException = new NullPointerException();
                                                        AppMethodBeat.o(43888);
                                                        throw nullPointerException;
                                                    } else {
                                                        super.b(ICommLibReader.class, iCommLibReader);
                                                        AppMethodBeat.o(43888);
                                                    }
                                                }

                                                public final boolean NA() {
                                                    AppMethodBeat.i(261622);
                                                    boolean NA = ((AppBrandInitConfigWC) super.ON()).NA();
                                                    AppMethodBeat.o(261622);
                                                    return NA;
                                                }

                                                public final boolean bsr() {
                                                    AppMethodBeat.i(43893);
                                                    boolean z = ((AppBrandInitConfigWC) super.ON()).ldN;
                                                    AppMethodBeat.o(43893);
                                                    return z;
                                                }

                                                public final boolean bss() {
                                                    AppMethodBeat.i(43894);
                                                    boolean z = ((AppBrandInitConfigWC) super.ON()).ldK;
                                                    AppMethodBeat.o(43894);
                                                    return z;
                                                }

                                                public final void R(final Runnable runnable) {
                                                    AppMethodBeat.i(226216);
                                                    this.kAH.a(new c.a() {
                                                        /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass17 */

                                                        @Override // com.tencent.mm.plugin.appbrand.a.c.a
                                                        public final void a(String str, com.tencent.mm.plugin.appbrand.a.b bVar) {
                                                            AppMethodBeat.i(43875);
                                                            if (com.tencent.mm.plugin.appbrand.a.b.DESTROYED == bVar) {
                                                                runnable.run();
                                                            }
                                                            AppMethodBeat.o(43875);
                                                        }
                                                    });
                                                    finish();
                                                    AppMethodBeat.o(226216);
                                                }

                                                /* access modifiers changed from: protected */
                                                @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
                                                public s brw() {
                                                    com.tencent.mm.plugin.appbrand.service.c cVar;
                                                    String str;
                                                    AppMethodBeat.i(43901);
                                                    if (!super.OQ()) {
                                                        com.tencent.mm.plugin.appbrand.service.c brT = this.kDq != null ? this.kDq.brT() : null;
                                                        if (brT != null) {
                                                            Object[] objArr = new Object[3];
                                                            objArr[0] = this.mAppId;
                                                            if (NA()) {
                                                                str = "WAGame";
                                                            } else {
                                                                str = "WAService";
                                                            }
                                                            objArr[1] = str;
                                                            objArr[2] = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId).nLz.name();
                                                            Log.i("MicroMsg.AppBrandRuntimeWC", "[%s][%s] [applaunch] [preload] createService preloaded, reason=%s", objArr);
                                                        }
                                                        if (brT == null) {
                                                            Object[] objArr2 = new Object[2];
                                                            objArr2[0] = this.mAppId;
                                                            objArr2[1] = NA() ? "WAGame" : "WAService";
                                                            Log.i("MicroMsg.AppBrandRuntimeWC", "[%s][%s] [applaunch] [preload] createService got no preloaded", objArr2);
                                                            if ((BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG || DebuggerShell.bAx()) && com.tencent.mm.plugin.appbrand.task.b.bVE()) {
                                                                IllegalStateException illegalStateException = new IllegalStateException("[ForcePreload] enabled, but not preload");
                                                                AppMethodBeat.o(43901);
                                                                throw illegalStateException;
                                                            }
                                                            cVar = NA() ? new com.tencent.mm.plugin.appbrand.game.c() : new com.tencent.mm.plugin.appbrand.service.c();
                                                        } else {
                                                            cVar = brT;
                                                        }
                                                    } else if (NA()) {
                                                        cVar = com.tencent.mm.plugin.appbrand.task.e.h(com.tencent.mm.plugin.appbrand.task.g.iD(true));
                                                        if (cVar == null && this.kDq != null) {
                                                            cVar = this.kDq.brT();
                                                        }
                                                        if (cVar == null) {
                                                            cVar = new com.tencent.mm.plugin.appbrand.game.c();
                                                        } else {
                                                            com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId).nLz = com.tencent.mm.plugin.appbrand.report.quality.j.PreloadOnProcessCreated;
                                                        }
                                                    } else {
                                                        cVar = new com.tencent.mm.plugin.appbrand.service.c(com.tencent.luggage.sdk.b.a.c.j.cBs);
                                                    }
                                                    AppMethodBeat.o(43901);
                                                    return cVar;
                                                }

                                                /* access modifiers changed from: protected */
                                                @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
                                                public w brx() {
                                                    com.tencent.mm.plugin.appbrand.game.f.c xVar;
                                                    ag brU;
                                                    AppMethodBeat.i(43902);
                                                    Context context = this.mContext;
                                                    try {
                                                        com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId).nLB = Util.nowMilliSecond();
                                                    } catch (Throwable th) {
                                                    }
                                                    if (NA()) {
                                                        xVar = new com.tencent.mm.plugin.appbrand.game.f.c(context, this);
                                                    } else {
                                                        xVar = new com.tencent.mm.plugin.appbrand.page.x(context, this);
                                                    }
                                                    xVar.setDecorWidgetFactory(bsn());
                                                    if (!NA()) {
                                                        xVar.a(com.tencent.mm.plugin.appbrand.page.b.i.WITH_CONFIRM_DIALOG, new com.tencent.mm.plugin.appbrand.page.b.a());
                                                    }
                                                    xVar.a(com.tencent.mm.plugin.appbrand.page.b.i.SILENT, new com.tencent.mm.plugin.appbrand.page.b.b());
                                                    if (!(this.kDq == null || (brU = this.kDq.brU()) == null)) {
                                                        if (!(brU == null || xVar.getRuntime() == null)) {
                                                            if (brU.bqZ().compareTo(xVar.getRuntime().gt(false)) != 0) {
                                                                IllegalStateException illegalStateException = new IllegalStateException(String.format(Locale.ENGLISH, "stashPreloadedPageView appId[%s] mismatch libReader, runtime[%s] page[%s]", xVar.getAppId(), xVar.getRuntime().gt(false).bvb(), brU.bqZ().bvb()));
                                                                AppMethodBeat.o(43902);
                                                                throw illegalStateException;
                                                            }
                                                            synchronized (xVar.nqk) {
                                                                try {
                                                                    xVar.nqk.addLast(brU);
                                                                } catch (Throwable th2) {
                                                                    AppMethodBeat.o(43902);
                                                                    throw th2;
                                                                }
                                                            }
                                                        }
                                                        if (brU instanceof bs) {
                                                            xVar.setWAAutoWebViewJs(((bs) brU).nuB);
                                                        }
                                                    }
                                                    AppMethodBeat.o(43902);
                                                    return xVar;
                                                }

                                                /* access modifiers changed from: protected */
                                                @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
                                                public void onCreate() {
                                                    QualitySession qualitySession;
                                                    AppMethodBeat.i(43906);
                                                    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepPrepareRuntime);
                                                    gu(false);
                                                    bsy();
                                                    com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
                                                    AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.ON();
                                                    if (!(appBrandInitConfigWC == null || (qualitySession = appBrandInitConfigWC.ldW) == null)) {
                                                        com.tencent.mm.ac.d.i(new d.b(a.bqV(), qualitySession, appBrandInitConfigWC));
                                                    }
                                                    a.setRuntime(this);
                                                    com.tencent.mm.plugin.appbrand.e.a.Q(this);
                                                    bst();
                                                    this.kDm = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, WXHardCoderJNI.hcMiniProgramLaunchDelay, WXHardCoderJNI.hcMiniProgramLaunchCPU, WXHardCoderJNI.hcMiniProgramLaunchIO, WXHardCoderJNI.hcMiniProgramLaunchThr ? Process.myTid() : 0, WXHardCoderJNI.hcMiniProgramLaunchTimeout, 801, WXHardCoderJNI.hcMiniProgramLaunchAction, "MicroMsg.AppBrandRuntimeWC");
                                                    Log.i("MicroMsg.AppBrandRuntimeWC", "onCreate %s, scene:%d, instanceId:%s, sessionId:%s", this, Integer.valueOf(ON().cyA.scene), ((AppBrandInitConfigWC) super.ON()).cyn, ((AppBrandInitConfigWC) super.ON()).cym);
                                                    super.onCreate();
                                                    bsv();
                                                    if (NA()) {
                                                        com.tencent.luggage.sdk.d.g gVar = com.tencent.luggage.sdk.d.g.cCq;
                                                        v.a.C0742a aVar = v.a.mTH;
                                                        com.tencent.luggage.sdk.d.g.OW();
                                                        com.tencent.mm.plugin.appbrand.game.preload.d bDu = com.tencent.mm.plugin.appbrand.game.preload.d.bDu();
                                                        bDu.kGW = this;
                                                        bDu.ltU = new com.tencent.mm.plugin.appbrand.game.preload.c(this);
                                                        bDu.hasInit = true;
                                                        bDu.ltW = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_game_predownload, false);
                                                        bDu.ltX = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_download_cronet, false);
                                                        bDu.ltR = new com.tencent.mm.plugin.appbrand.s.m(bDu.ltU, bDu.ltX);
                                                        bDu.ltY = new AtomicInteger(0);
                                                        bDu.ltZ = new AtomicInteger(0);
                                                        bDu.lua = new AtomicInteger(0);
                                                        bDu.lub = new AtomicInteger(0);
                                                        com.tencent.mm.plugin.appbrand.game.preload.d.bDu().bu(((AppBrandInitConfigWC) super.ON()).kHK);
                                                    } else {
                                                        com.tencent.luggage.sdk.d.g gVar2 = com.tencent.luggage.sdk.d.g.cCq;
                                                        v.a.C0742a aVar2 = v.a.mTH;
                                                        com.tencent.luggage.sdk.d.g.OV();
                                                    }
                                                    com.tencent.mm.plugin.appbrand.report.quality.b.H(this);
                                                    com.tencent.mm.plugin.appbrand.report.quality.o oVar = com.tencent.mm.plugin.appbrand.report.quality.o.nMe;
                                                    com.tencent.mm.plugin.appbrand.report.quality.o.eI(this.mAppId, com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId).kEY);
                                                    com.tencent.mm.plugin.appbrand.report.quality.g.a(this, false, com.tencent.mm.plugin.appbrand.utils.b.afF(((AppBrandInitConfigWC) super.ON()).ldT));
                                                    com.tencent.luggage.game.e.a Nn = com.tencent.luggage.game.e.a.Nn();
                                                    String str = this.mAppId;
                                                    boolean NA = NA();
                                                    Nn.appId = str;
                                                    Log.i("MicroMsg.MBNiReporter", "hy: appId:%s,isGame:%s", str, Boolean.valueOf(NA));
                                                    if (NA) {
                                                        h.a(str, Nn.cxI);
                                                    }
                                                    Nn.cxA = new ArrayList<>();
                                                    if (NA) {
                                                        Nn.cxE = 1004;
                                                    } else {
                                                        Nn.cxE = 1000;
                                                    }
                                                    com.tencent.mm.plugin.s.a.a(this.mAppId, ((AppBrandInitConfigWC) super.ON()).ldQ);
                                                    a(new AppBrandRuntime.b() {
                                                        /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass20 */
                                                        private volatile g.b kDS;

                                                        @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime.b
                                                        public final void prepare() {
                                                            AppMethodBeat.i(226205);
                                                            com.tencent.mm.plugin.appbrand.keylogger.c.a(q.this.mAppId, KSProcessWeAppLaunch.stepWaitForCommLibConfirm);
                                                            this.kDS = com.tencent.mm.plugin.appbrand.launching.g.a(q.this, new kotlin.g.a.b<ICommLibReader, kotlin.x>() {
                                                                /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass20.AnonymousClass1 */

                                                                /* Return type fixed from 'java.lang.Object' to match base method */
                                                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                                                @Override // kotlin.g.a.b
                                                                public final /* synthetic */ kotlin.x invoke(ICommLibReader iCommLibReader) {
                                                                    AppMethodBeat.i(226204);
                                                                    if (q.this.kDi != null) {
                                                                        q.this.kDi.O(q.this);
                                                                        this.KY();
                                                                        com.tencent.mm.plugin.appbrand.keylogger.c.b(q.this.mAppId, KSProcessWeAppLaunch.stepWaitForCommLibConfirm);
                                                                    }
                                                                    kotlin.x xVar = kotlin.x.SXb;
                                                                    AppMethodBeat.o(226204);
                                                                    return xVar;
                                                                }
                                                            });
                                                            AppMethodBeat.o(226205);
                                                        }

                                                        @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime.b
                                                        public final void interrupt() {
                                                            AppMethodBeat.i(226206);
                                                            if (this.kDS != null) {
                                                                this.kDS.interrupt();
                                                            }
                                                            AppMethodBeat.o(226206);
                                                        }
                                                    });
                                                    a(new AppBrandRuntime.b() {
                                                        /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass21 */

                                                        @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime.b
                                                        public final void prepare() {
                                                            AppMethodBeat.i(226207);
                                                            q.a(q.this, this);
                                                            AppMethodBeat.o(226207);
                                                        }
                                                    });
                                                    a(new b(this, (byte) 0));
                                                    m mVar = new m(this);
                                                    this.kDq = mVar;
                                                    a(mVar);
                                                    this.kDi.N(this);
                                                    com.tencent.mm.plugin.appbrand.media.record.c.onCreate();
                                                    com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.s(this);
                                                    com.tencent.mm.plugin.appbrand.backgroundfetch.i.s(this);
                                                    com.tencent.mm.plugin.appbrand.utils.g.S(this);
                                                    OpenBusinessViewUtil.z(this);
                                                    AppBrandBackgroundRunningMonitor.t(this);
                                                    this.kDj = new n();
                                                    this.kDj.nJu = Util.currentTicks();
                                                    this.kDy = new r();
                                                    r rVar = this.kDy;
                                                    String str2 = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId).kEY;
                                                    String str3 = this.mAppId;
                                                    long j2 = (long) (((AppBrandInitConfigWC) super.ON()).cyo + 1000);
                                                    kotlin.g.b.p.h(str2, "instanceId");
                                                    kotlin.g.b.p.h(str3, "appId");
                                                    rVar.nKk = Long.valueOf(System.currentTimeMillis());
                                                    rVar.sessionId = str2;
                                                    rVar.appId = str3;
                                                    rVar.nKj = Long.valueOf(j2);
                                                    com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.k.a(this.mAppId, brs(), ON().cyA);
                                                    this.kDn = ON().cyA.scene == 1099;
                                                    if (bsr()) {
                                                        this.kDo.add(new ae((AppBrandInitConfigWC) super.ON()));
                                                    }
                                                    this.kDo.add(new ar((AppBrandInitConfigWC) super.ON(), this));
                                                    this.kAH.a(new c.a() {
                                                        /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass22 */

                                                        @Override // com.tencent.mm.plugin.appbrand.a.c.a
                                                        public final void a(String str, com.tencent.mm.plugin.appbrand.a.b bVar) {
                                                            AppMethodBeat.i(226208);
                                                            if (com.tencent.mm.plugin.appbrand.a.b.SUSPEND == bVar) {
                                                                q.this.kDh.moZ.mpa.clear();
                                                                com.tencent.mm.plugin.appbrand.report.quality.k.cj(str, 4);
                                                            }
                                                            AppMethodBeat.o(226208);
                                                        }
                                                    });
                                                    if (this.kAl != null) {
                                                        bsw();
                                                    } else {
                                                        Log.w("MicroMsg.AppBrandRuntimeWC", "onCreate appId:%s, skip initFloatBallHelper(), maybe under preRender mode", this.mAppId);
                                                    }
                                                    if (this.kAl != null) {
                                                        bsx();
                                                    } else {
                                                        Log.w("MicroMsg.AppBrandRuntimeWC", "onCreate appId:%s, skip initMultiTaskHelper(), maybe under preRender mode", this.mAppId);
                                                    }
                                                    QualitySessionRuntime aeU = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId);
                                                    if (aeU != null) {
                                                        aeU.nLl = Util.nowMilliSecond() - ((AppBrandInitConfigWC) super.ON()).startTime;
                                                    }
                                                    if (j.a.vP(this.kAq.eix)) {
                                                        String str4 = this.mAppId;
                                                        Log.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "invoke appId:%s", str4);
                                                        if (BuildInfo.IS_FLAVOR_BLUE) {
                                                            String b2 = com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_appbrand_check_demoinfo_default", "1", true, true);
                                                            Log.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "xSwitch xSwitchStr:%s", b2);
                                                            if (TextUtils.equals(b2, "1")) {
                                                                XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(str4), a.C0797a.class, new com.tencent.mm.ipcinvoker.d<IPCBoolean>(str4) {
                                                                    /* class com.tencent.mm.plugin.appbrand.task.a.a.AnonymousClass1 */
                                                                    final /* synthetic */ String val$appId;

                                                                    {
                                                                        this.val$appId = r1;
                                                                    }

                                                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                                                    @Override // com.tencent.mm.ipcinvoker.d
                                                                    public final /* synthetic */ void bn(IPCBoolean iPCBoolean) {
                                                                        AppMethodBeat.i(227530);
                                                                        IPCBoolean iPCBoolean2 = iPCBoolean;
                                                                        if (iPCBoolean2 == null || !iPCBoolean2.value) {
                                                                            Log.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "XIPCInvoker fail appId:%s", this.val$appId);
                                                                            com.tencent.mm.plugin.appbrand.p.Un(this.val$appId).kDe = false;
                                                                            AppMethodBeat.o(227530);
                                                                            return;
                                                                        }
                                                                        Log.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "XIPCInvoker success appId:%s", this.val$appId);
                                                                        com.tencent.mm.plugin.appbrand.p.Un(this.val$appId).kDe = true;
                                                                        AppMethodBeat.o(227530);
                                                                    }
                                                                });
                                                            }
                                                        }
                                                    }
                                                    if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_open_handoff_android, false)) {
                                                        String str5 = this.mAppId;
                                                        Log.i("MicroMsg.AppBrand.AppBrandCheckOnlineStatusTask", "invoke appId:%s", str5);
                                                        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(""), a.C0796a.class, new com.tencent.mm.ipcinvoker.d<GetOnLineInfoInfoResult>(str5) {
                                                            /* class com.tencent.mm.plugin.appbrand.task.a.AnonymousClass1 */
                                                            final /* synthetic */ String val$appId;

                                                            {
                                                                this.val$appId = r1;
                                                            }

                                                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                                            @Override // com.tencent.mm.ipcinvoker.d
                                                            public final /* synthetic */ void bn(GetOnLineInfoInfoResult getOnLineInfoInfoResult) {
                                                                AppMethodBeat.i(227434);
                                                                GetOnLineInfoInfoResult getOnLineInfoInfoResult2 = getOnLineInfoInfoResult;
                                                                if (getOnLineInfoInfoResult2 != null) {
                                                                    com.tencent.mm.plugin.appbrand.p.Un(this.val$appId).jjN = getOnLineInfoInfoResult2.jjN;
                                                                    com.tencent.mm.plugin.appbrand.p.Un(this.val$appId).jjS = getOnLineInfoInfoResult2.jjS;
                                                                    com.tencent.mm.plugin.appbrand.p.Un(this.val$appId).kDf = getOnLineInfoInfoResult2.kDf;
                                                                }
                                                                AppMethodBeat.o(227434);
                                                            }
                                                        });
                                                    }
                                                    MultiProcessMMKV.getMMKV(this.mAppId + "_wxa_voip").putBoolean("isCameraStart", false);
                                                    com.tencent.mm.plugin.cloudvoip.cloudvoice.d.m.czc();
                                                    Log.i("MicroMsg.AppBrandRuntimeWC", "reset appId:%s isCameraStart false", this.mAppId);
                                                    AppMethodBeat.o(43906);
                                                }

                                                public ag bsz() {
                                                    AppMethodBeat.i(226220);
                                                    if (((com.tencent.mm.plugin.appbrand.page.x) super.brh()) == null) {
                                                        AppMethodBeat.o(226220);
                                                        return null;
                                                    } else if (((com.tencent.mm.plugin.appbrand.page.x) super.brh()).getCurrentPage() == null) {
                                                        AppMethodBeat.o(226220);
                                                        return null;
                                                    } else {
                                                        ag agVar = (ag) ((com.tencent.mm.plugin.appbrand.page.x) super.brh()).getCurrentPage().getCurrentPageView();
                                                        AppMethodBeat.o(226220);
                                                        return agVar;
                                                    }
                                                }

                                                @Override // com.tencent.luggage.sdk.d.d, com.tencent.mm.plugin.appbrand.AppBrandRuntime
                                                public final void onDestroy() {
                                                    int i2 = 1;
                                                    AppMethodBeat.i(43914);
                                                    if (((AppBrandInitConfigWC) super.ON()).leh != null) {
                                                        ((AppBrandInitConfigWC) super.ON()).leh.hY(AndroidContextUtil.castActivityOrNull(this.mContext) != null && AndroidContextUtil.castActivityOrNull(this.mContext).isFinishing());
                                                    }
                                                    super.onDestroy();
                                                    MMToClientEvent.f((com.tencent.mm.plugin.appbrand.service.c) super.NY());
                                                    MMToClientEvent.YZ("Common_IPC_appid");
                                                    com.tencent.mm.plugin.appbrand.e.a.R(this);
                                                    com.tencent.mm.plugin.appbrand.report.quality.b.J(this);
                                                    if (this.kDm != 0) {
                                                        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.kDm);
                                                        this.kDm = 0;
                                                    }
                                                    if (DebuggerShell.bAx()) {
                                                        if (this.kDp != null) {
                                                            this.kDp.stopTimer();
                                                        }
                                                        com.tencent.f.h.RTc.aX(new Runnable() {
                                                            /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass7 */

                                                            public final void run() {
                                                                AppMethodBeat.i(160525);
                                                                AppBrandPerformanceManager.h(q.this);
                                                                AppMethodBeat.o(160525);
                                                            }
                                                        });
                                                        com.tencent.mm.plugin.appbrand.performance.b.aei(this.mAppId);
                                                        String str = this.mAppId;
                                                        String[] strArr = {"Needjs", "Needwebviewjs"};
                                                        for (int i3 = 0; i3 < 2; i3++) {
                                                            String str2 = str + "-" + strArr[i3];
                                                            String string = MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.ForceOpenAppNotify.TestInjectJsPath", 2).getString(str2, null);
                                                            if (!TextUtils.isEmpty(string)) {
                                                                s.deleteFile(string);
                                                            }
                                                            MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.ForceOpenAppNotify.TestInjectJsPath", 2).remove(str2);
                                                        }
                                                    }
                                                    if (NA()) {
                                                        com.tencent.mm.plugin.appbrand.game.preload.d.x(this);
                                                    }
                                                    AppBrandMusicClientService appBrandMusicClientService = AppBrandMusicClientService.ncV;
                                                    appBrandMusicClientService.ncU.clear();
                                                    appBrandMusicClientService.ncW = "";
                                                    p.remove(this.mAppId);
                                                    com.tencent.mm.plugin.appbrand.media.record.c.onDestroy();
                                                    gv(true);
                                                    if (this.kDx != null) {
                                                        this.kDx.nnF.clear();
                                                    }
                                                    a.b(this);
                                                    n nVar = this.kDj;
                                                    if (nVar != null) {
                                                        nVar.sessionId = ((AppBrandInitConfigWC) super.ON()).cym;
                                                        p.Um(this.mAppId);
                                                        nVar.networkType = i.getNetworkType(MMApplicationContext.getContext());
                                                        nVar.appId = this.mAppId;
                                                        nVar.appVersion = bsB() == null ? ((AppBrandInitConfigWC) super.ON()).appVersion : bsB().leE.pkgVersion;
                                                        nVar.dCv = this.kAq.eix + 1;
                                                        nVar.scene = ON().cyA.scene;
                                                        nVar.nJw = nVar.nJv ? 1 : 0;
                                                        if (!WebView.isX5()) {
                                                            i2 = 0;
                                                        }
                                                        nVar.nJx = i2;
                                                        nVar.nJy = Util.ticksToNow(nVar.nJu);
                                                        nVar.nJz = Util.nowMilliSecond();
                                                        nVar.username = ((AppBrandInitConfigWC) super.ON()).username;
                                                        QualitySessionRuntime aeU = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId);
                                                        nVar.nJA = (long) aeU.apptype;
                                                        nVar.kEY = aeU.kEY;
                                                        nVar.report();
                                                        com.tencent.mm.plugin.appbrand.ui.recommend.e.P(this);
                                                    }
                                                    this.kDj = null;
                                                    this.kDl = false;
                                                    this.kDq = null;
                                                    if (this.kDu != null) {
                                                        com.tencent.mm.plugin.appbrand.ad.h hVar = this.kDu;
                                                        Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "onDestroy");
                                                        hVar.UD("onDestroy");
                                                        hVar.kHb = null;
                                                        this.kDu = null;
                                                    }
                                                    this.kDB.clear();
                                                    this.kDo.clear();
                                                    com.tencent.mm.plugin.appbrand.jsapi.w.a aVar = this.kDh;
                                                    aVar.moZ.mpa.clear();
                                                    SparseArray<com.tencent.mm.plugin.appbrand.jsapi.w.b> sparseArray = aVar.moY;
                                                    synchronized (sparseArray) {
                                                        try {
                                                            sparseArray.clear();
                                                            kotlin.x xVar = kotlin.x.SXb;
                                                        } catch (Throwable th) {
                                                            AppMethodBeat.o(43914);
                                                            throw th;
                                                        }
                                                    }
                                                    com.tencent.mm.plugin.appbrand.jsapi.ag.b.d.release();
                                                    k.Ue(this.mAppId);
                                                    AppMethodBeat.o(43914);
                                                }

                                                /* access modifiers changed from: protected */
                                                @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
                                                public final void brB() {
                                                    AppMethodBeat.i(43916);
                                                    MMToClientEvent.e((com.tencent.mm.plugin.appbrand.service.c) super.NY());
                                                    MMToClientEvent.YY("Common_IPC_appid");
                                                    this.kDi.N(this);
                                                    AppMethodBeat.o(43916);
                                                }

                                                /* access modifiers changed from: protected */
                                                @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
                                                public final boolean N(Runnable runnable) {
                                                    AppMethodBeat.i(226224);
                                                    if (super.brK() instanceof aa) {
                                                        i(runnable, 3000);
                                                        AppMethodBeat.o(226224);
                                                        return true;
                                                    } else if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_game_splashscreen, false)) {
                                                        boolean z = getAppConfig().lbV;
                                                        Log.w("MicroMsg.AppBrandRuntimeWC", "manualHideSplash:%b", Boolean.valueOf(z));
                                                        AppMethodBeat.o(226224);
                                                        return z;
                                                    } else {
                                                        AppMethodBeat.o(226224);
                                                        return false;
                                                    }
                                                }

                                                @Override // com.tencent.luggage.sdk.d.d, com.tencent.mm.plugin.appbrand.AppBrandRuntime
                                                public final void a(AppBrandInitConfig appBrandInitConfig) {
                                                    AppMethodBeat.i(43924);
                                                    AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.ON();
                                                    AppBrandInitConfigWC appBrandInitConfigWC2 = (AppBrandInitConfigWC) appBrandInitConfig;
                                                    if (appBrandInitConfigWC != appBrandInitConfig && appBrandInitConfigWC2.cyA.scene == 1038) {
                                                        appBrandInitConfigWC2.ldS = null;
                                                    }
                                                    if (appBrandInitConfigWC.leg) {
                                                        appBrandInitConfigWC2.leg = true;
                                                    }
                                                    super.a(appBrandInitConfig);
                                                    boolean z = ((AppBrandInitConfigWC) super.ON()).launchMode != appBrandInitConfigWC.launchMode && (((AppBrandInitConfigWC) super.ON()).launchMode == 1 || appBrandInitConfigWC.launchMode == 1);
                                                    if (z) {
                                                        brC();
                                                    }
                                                    Log.i("MicroMsg.AppBrandRuntimeWC", "updateConfig %s, willRestart[%b], willRelaunch[%b], destroyed[%b], scene[%d], lastLaunchMode[%d], currentLaunchMode[%d], instanceId[%s], sessionId[%s]", this, Boolean.valueOf(this.kAJ), Boolean.valueOf(this.kAK), Boolean.valueOf(isDestroyed()), Integer.valueOf(ON().cyA.scene), Integer.valueOf(appBrandInitConfigWC.launchMode), Integer.valueOf(((AppBrandInitConfigWC) super.ON()).launchMode), ((AppBrandInitConfigWC) appBrandInitConfig).cyn, ((AppBrandInitConfigWC) appBrandInitConfig).cym);
                                                    OpenBusinessViewUtil.z(this);
                                                    if (!this.kAJ && !isDestroyed()) {
                                                        if (!org.apache.commons.b.g.equals(appBrandInitConfigWC2.cyn, appBrandInitConfigWC.cyn)) {
                                                            if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED) {
                                                                Assert.fail("updateConfig instanceId should not have been changed");
                                                            } else {
                                                                Log.e("MicroMsg.AppBrandRuntimeWC", "updateConfig %s, newConfig.instanceId changed, reset [%s]->[%s]", this, appBrandInitConfigWC2.cyn, appBrandInitConfigWC.cyn);
                                                                appBrandInitConfigWC2.dC(appBrandInitConfigWC.cyn);
                                                            }
                                                        }
                                                        ((QualitySessionRuntime) Objects.requireNonNull(com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId))).nLm = false;
                                                        com.tencent.mm.plugin.appbrand.report.quality.g.a(this, true, com.tencent.mm.plugin.appbrand.utils.b.afF(((AppBrandInitConfigWC) super.ON()).ldT));
                                                        com.tencent.mm.plugin.s.a.b(this.mAppId, ((AppBrandInitConfigWC) super.ON()).ldQ);
                                                        for (aj ajVar : this.kDo) {
                                                            ajVar.c((AppBrandInitConfigWC) super.ON());
                                                        }
                                                        if (((com.tencent.mm.plugin.appbrand.page.x) super.brh()) != null) {
                                                            com.tencent.mm.plugin.appbrand.page.x xVar = (com.tencent.mm.plugin.appbrand.page.x) super.brh();
                                                            xVar.getReporter().resetSession();
                                                            xVar.nqb = false;
                                                            xVar.nqc = false;
                                                            xVar.nqd = false;
                                                            xVar.nqi = null;
                                                        }
                                                        AppBrandInitConfigWC appBrandInitConfigWC3 = (AppBrandInitConfigWC) super.ON();
                                                        AppBrandSysConfigWC bsB = bsB();
                                                        AppBrandStatObject appBrandStatObject = ON().cyA;
                                                        Log.i("MicroMsg.AppBrandTaskUsageRecorder", "updateUsage, appId %s, type %d", appBrandInitConfigWC3.appId, Integer.valueOf(appBrandInitConfigWC3.eix));
                                                        AppBrandMainProcessService.a(new AppBrandTaskUsageRecorder.UpdateTask(new AppBrandTaskUsageRecorder.LaunchCheckParams(appBrandInitConfigWC3, appBrandStatObject, bsB.leE.pkgVersion, gt(false).bvd(), appBrandInitConfigWC3.cym, appBrandInitConfigWC3.ldW)));
                                                        bst();
                                                        bsF();
                                                        AppBrandInitConfigWC appBrandInitConfigWC4 = (AppBrandInitConfigWC) super.ON();
                                                        if (appBrandInitConfigWC4 != null) {
                                                            this.kDv.b(appBrandInitConfigWC4);
                                                        }
                                                        p pVar = this.kDw;
                                                        kotlin.g.b.p.h(appBrandInitConfigWC2, "newConfig");
                                                        if (appBrandInitConfigWC2.kHL.isEnable()) {
                                                            p.pl(1);
                                                            if (appBrandInitConfigWC2.cyz != com.tencent.luggage.sdk.launching.b.PRE_RENDER) {
                                                                p.pl(6);
                                                                if (pVar.nHI) {
                                                                    p.pl(8);
                                                                }
                                                                if (!pVar.nHK) {
                                                                    p.pl(7);
                                                                    if (pVar.nHI) {
                                                                        p.pl(9);
                                                                    }
                                                                    pVar.nHK = true;
                                                                }
                                                            }
                                                        }
                                                        if (z) {
                                                            p.pl(4);
                                                        }
                                                        if (!(pVar.nHJ == appBrandInitConfigWC2.kHL.isEnable() || appBrandInitConfigWC2.cyz == com.tencent.luggage.sdk.launching.b.PRE_RENDER)) {
                                                            if (appBrandInitConfigWC2.kHL.isEnable()) {
                                                                p.pl(3);
                                                            } else {
                                                                p.pl(2);
                                                            }
                                                        }
                                                        if (appBrandInitConfigWC2.cyz != com.tencent.luggage.sdk.launching.b.PRE_RENDER) {
                                                            pVar.nHJ = appBrandInitConfigWC2.kHL.isEnable();
                                                        }
                                                    }
                                                    AppMethodBeat.o(43924);
                                                }

                                                private void bsF() {
                                                    AppMethodBeat.i(226229);
                                                    if (((AppBrandInitConfigWC) super.ON()).leg && AndroidContextUtil.castActivityOrNull(this.mContext) != null) {
                                                        this.kDv = new com.tencent.mm.plugin.appbrand.o.a(this, AndroidContextUtil.castActivityOrNull(this.mContext), super.getWindowAndroid());
                                                        if (((com.tencent.mm.plugin.appbrand.service.c) super.NY()) != null) {
                                                            ((com.tencent.mm.plugin.appbrand.service.c) super.NY()).b(getWindowAndroid());
                                                        }
                                                        ag bsz = bsz();
                                                        if (bsz != null) {
                                                            bsz.b(getWindowAndroid());
                                                        }
                                                    }
                                                    AppMethodBeat.o(226229);
                                                }

                                                private void vx(int i2) {
                                                    AppMethodBeat.i(43929);
                                                    o.a(i2, (AppBrandInitConfigWC) super.ON());
                                                    AppMethodBeat.o(43929);
                                                }

                                                @Override // com.tencent.mm.plugin.appbrand.launching.q
                                                public final void vy(int i2) {
                                                    AppMethodBeat.i(43932);
                                                    ab brK = super.brK();
                                                    if (brK instanceof com.tencent.mm.plugin.appbrand.launching.q) {
                                                        ((com.tencent.mm.plugin.appbrand.launching.q) brK).vy(i2);
                                                    }
                                                    AppMethodBeat.o(43932);
                                                }

                                                public final void bsH() {
                                                    AppMethodBeat.i(43933);
                                                    this.kAO = false;
                                                    if (this.kAl != null) {
                                                        this.kAl.A(this);
                                                    }
                                                    finish();
                                                    if (this.kAl instanceof AppBrandRuntimeContainerWC) {
                                                        ((AppBrandRuntimeContainerWC) this.kAl).OH();
                                                    }
                                                    AppMethodBeat.o(43933);
                                                }

                                                public final int bsM() {
                                                    AppMethodBeat.i(163908);
                                                    if (((AppBrandInitConfigWC) super.ON()) != null) {
                                                        int i2 = ((AppBrandInitConfigWC) super.ON()).ldZ;
                                                        AppMethodBeat.o(163908);
                                                        return i2;
                                                    }
                                                    AppMethodBeat.o(163908);
                                                    return -1;
                                                }

                                                @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
                                                public final com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid() {
                                                    com.tencent.mm.plugin.appbrand.platform.window.c windowAndroid;
                                                    AppMethodBeat.i(226235);
                                                    if (this.kAl == null || (windowAndroid = this.kAl.getWindowAndroid()) == null) {
                                                        com.tencent.mm.plugin.appbrand.platform.window.c windowAndroid2 = super.getWindowAndroid();
                                                        AppMethodBeat.o(226235);
                                                        return windowAndroid2;
                                                    } else if (this.kDv == null || !(this.kDv instanceof com.tencent.mm.plugin.appbrand.platform.window.g) || (!((com.tencent.mm.plugin.appbrand.platform.window.g) this.kDv).OD() && !(this.kDv instanceof com.tencent.mm.plugin.appbrand.o.a))) {
                                                        AppMethodBeat.o(226235);
                                                        return windowAndroid;
                                                    } else {
                                                        if (!(this.kDC != null && this.kDC.nEu == windowAndroid && this.kDC.nEv == this.kDv)) {
                                                            this.kDC = new com.tencent.mm.plugin.appbrand.platform.window.f(windowAndroid, (com.tencent.mm.plugin.appbrand.platform.window.g) this.kDv);
                                                        }
                                                        com.tencent.mm.plugin.appbrand.platform.window.f fVar = this.kDC;
                                                        AppMethodBeat.o(226235);
                                                        return fVar;
                                                    }
                                                }

                                                public final boolean bsN() {
                                                    AppMethodBeat.i(226236);
                                                    boolean isEnable = ((AppBrandInitConfigWC) super.ON()).kHL.isEnable();
                                                    AppMethodBeat.o(226236);
                                                    return isEnable;
                                                }

                                                public final boolean bsO() {
                                                    AppMethodBeat.i(226237);
                                                    boolean z = ((AppBrandInitConfigWC) super.ON()).kHL.lfm;
                                                    AppMethodBeat.o(226237);
                                                    return z;
                                                }

                                                @Override // com.tencent.luggage.sdk.d.d
                                                public final /* bridge */ /* synthetic */ AppBrandInitConfigLU ON() {
                                                    AppMethodBeat.i(43939);
                                                    AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.ON();
                                                    AppMethodBeat.o(43939);
                                                    return appBrandInitConfigWC;
                                                }

                                                @Override // com.tencent.luggage.sdk.d.d, com.tencent.mm.plugin.appbrand.AppBrandRuntime
                                                public final /* synthetic */ com.tencent.mm.plugin.appbrand.appstorage.q OL() {
                                                    AppMethodBeat.i(43941);
                                                    com.tencent.luggage.a.e.a(com.tencent.mm.plugin.appbrand.appstorage.r.class, new b.a());
                                                    com.tencent.mm.plugin.appbrand.jsapi.file.b bVar = new com.tencent.mm.plugin.appbrand.jsapi.file.b(this, com.tencent.mm.plugin.appbrand.config.f.a(bsB()));
                                                    AppMethodBeat.o(43941);
                                                    return bVar;
                                                }

                                                @Override // com.tencent.luggage.sdk.d.d, com.tencent.mm.plugin.appbrand.AppBrandRuntime
                                                public final /* synthetic */ AppBrandInitConfig OU() {
                                                    AppMethodBeat.i(43943);
                                                    AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.ON();
                                                    AppMethodBeat.o(43943);
                                                    return appBrandInitConfigWC;
                                                }

                                                @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
                                                public final /* bridge */ /* synthetic */ w brh() {
                                                    AppMethodBeat.i(43945);
                                                    com.tencent.mm.plugin.appbrand.page.x xVar = (com.tencent.mm.plugin.appbrand.page.x) super.brh();
                                                    AppMethodBeat.o(43945);
                                                    return xVar;
                                                }

                                                @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime
                                                public final /* bridge */ /* synthetic */ s NY() {
                                                    AppMethodBeat.i(43946);
                                                    com.tencent.mm.plugin.appbrand.service.c cVar = (com.tencent.mm.plugin.appbrand.service.c) super.NY();
                                                    AppMethodBeat.o(43946);
                                                    return cVar;
                                                }

                                                static /* synthetic */ void a(q qVar, final AppBrandRuntime.b bVar) {
                                                    AppMethodBeat.i(226239);
                                                    com.tencent.mm.plugin.appbrand.keylogger.c.a(qVar.mAppId, KSProcessWeAppLaunch.stepPrepareMainProcess);
                                                    com.tencent.mm.plugin.appbrand.ipc.b.w(new kotlin.g.a.a<kotlin.x>() {
                                                        /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass8 */

                                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                                        @Override // kotlin.g.a.a
                                                        public final /* synthetic */ kotlin.x invoke() {
                                                            AppMethodBeat.i(226182);
                                                            bVar.KY();
                                                            com.tencent.mm.plugin.appbrand.keylogger.c.b(q.this.mAppId, KSProcessWeAppLaunch.stepPrepareMainProcess);
                                                            kotlin.x xVar = kotlin.x.SXb;
                                                            AppMethodBeat.o(226182);
                                                            return xVar;
                                                        }
                                                    });
                                                    AppMethodBeat.o(226239);
                                                }

                                                static /* synthetic */ AppBrandPrepareTask b(q qVar, final AppBrandRuntime.b bVar) {
                                                    AppMethodBeat.i(43948);
                                                    Log.i("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "register runtime(%s %d), destroyed %b", qVar.mAppId, Integer.valueOf(qVar.kAq.eix), Boolean.valueOf(qVar.isDestroyed()));
                                                    if (!qVar.isDestroyed()) {
                                                        ILaunchWxaAppInfoNotify.a.AnonymousClass1 r0 = 
                                                        /*  JADX ERROR: Method code generation error
                                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0035: CONSTRUCTOR  (r0v23 'r0' com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify$a$1) = (r12v0 'qVar' com.tencent.mm.plugin.appbrand.q) call: com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.a.1.<init>(com.tencent.mm.plugin.appbrand.q):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.q.b(com.tencent.mm.plugin.appbrand.q, com.tencent.mm.plugin.appbrand.AppBrandRuntime$b):com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask, file: classes3.dex
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify, state: GENERATED_AND_UNLOADED
                                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                            	... 19 more
                                                            */
                                                        /*
                                                        // Method dump skipped, instructions count: 265
                                                        */
                                                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.q.b(com.tencent.mm.plugin.appbrand.q, com.tencent.mm.plugin.appbrand.AppBrandRuntime$b):com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask");
                                                    }

                                                    static /* synthetic */ void j(q qVar) {
                                                        AppMethodBeat.i(226240);
                                                        qVar.cCn = new com.tencent.mm.plugin.appbrand.permission.p(qVar);
                                                        AppMethodBeat.o(226240);
                                                    }

                                                    static /* synthetic */ void gw(boolean z) {
                                                        AppMethodBeat.i(226241);
                                                        com.tencent.mm.plugin.appbrand.game.preload.d.bDu();
                                                        com.tencent.mm.plugin.appbrand.game.preload.d.hf(z);
                                                        AppMethodBeat.o(226241);
                                                    }

                                                    static /* synthetic */ b.d o(q qVar) {
                                                        AppMethodBeat.i(226242);
                                                        AnonymousClass13 r2 = new kotlin.g.a.b<String, kotlin.x>() {
                                                            /* class com.tencent.mm.plugin.appbrand.q.AnonymousClass13 */

                                                            /* Return type fixed from 'java.lang.Object' to match base method */
                                                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                                            @Override // kotlin.g.a.b
                                                            public final /* synthetic */ kotlin.x invoke(String str) {
                                                                AppMethodBeat.i(226197);
                                                                Log.e("MicroMsg.AppBrandRuntimeWC", "getCurrentPageConfig returns null, appId[%s], reason[%s]", q.this.mAppId, str);
                                                                kotlin.x xVar = kotlin.x.SXb;
                                                                AppMethodBeat.o(226197);
                                                                return xVar;
                                                            }
                                                        };
                                                        if (qVar.isDestroyed()) {
                                                            r2.invoke("destroyed");
                                                            AppMethodBeat.o(226242);
                                                            return null;
                                                        } else if (!qVar.mInitialized) {
                                                            com.tencent.mm.plugin.appbrand.config.b appConfig = qVar.getAppConfig();
                                                            if (appConfig == null) {
                                                                r2.invoke("NULL appConfig");
                                                                AppMethodBeat.o(226242);
                                                                return null;
                                                            }
                                                            b.d WV = appConfig.WV(com.tencent.luggage.h.l.dM(qVar.brs()));
                                                            AppMethodBeat.o(226242);
                                                            return WV;
                                                        } else {
                                                            com.tencent.mm.plugin.appbrand.page.x xVar = (com.tencent.mm.plugin.appbrand.page.x) super.brh();
                                                            if (xVar == null) {
                                                                r2.invoke("NULL pageContainer");
                                                                AppMethodBeat.o(226242);
                                                                return null;
                                                            }
                                                            t currentPage = xVar.getCurrentPage();
                                                            if (currentPage == null) {
                                                                r2.invoke("NULL currentPage");
                                                                AppMethodBeat.o(226242);
                                                                return null;
                                                            }
                                                            b.d pageConfig = currentPage.getPageConfig();
                                                            AppMethodBeat.o(226242);
                                                            return pageConfig;
                                                        }
                                                    }

                                                    static /* synthetic */ void a(q qVar, e.a aVar, b.d dVar) {
                                                        e.b aeE;
                                                        AppMethodBeat.i(226243);
                                                        if (qVar.isDestroyed()) {
                                                            Log.i("MicroMsg.AppBrandRuntimeWC", "mayRequestOrientation mFinished is true return,mAppId:%s", qVar.mAppId);
                                                            AppMethodBeat.o(226243);
                                                            return;
                                                        }
                                                        if (qVar.NA()) {
                                                            aeE = e.b.aeE(qVar.getAppConfig().lbP.cBG);
                                                        } else if (dVar != null) {
                                                            aeE = e.b.aeE(dVar.lcB);
                                                        } else if (qVar.kAU) {
                                                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("page config should not be NULL!!");
                                                            AppMethodBeat.o(226243);
                                                            throw illegalArgumentException;
                                                        } else {
                                                            aeE = null;
                                                        }
                                                        com.tencent.mm.plugin.appbrand.platform.window.e orientationHandler = qVar.getWindowAndroid().getOrientationHandler();
                                                        if (aeE == null) {
                                                            aeE = e.b.PORTRAIT;
                                                        }
                                                        orientationHandler.a(aeE, aVar);
                                                        AppMethodBeat.o(226243);
                                                    }
                                                }
