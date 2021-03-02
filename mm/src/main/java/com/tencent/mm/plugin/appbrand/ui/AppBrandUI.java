package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.app.a;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.luggage.h.f;
import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.a.e;
import com.tencent.mm.plugin.appbrand.al;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.b;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.performance.h;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.platform.window.a.a;
import com.tencent.mm.plugin.appbrand.platform.window.a.i;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.k;
import com.tencent.mm.plugin.appbrand.task.l;
import com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped;
import com.tencent.mm.plugin.appbrand.ui.z;
import com.tencent.mm.plugin.appbrand.widget.input.am;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.AccessibilityUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.vendor.Meizu;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.x;

@a(7)
public class AppBrandUI extends BaseAppBrandUIClipped implements a.AbstractC0015a, f.e, b, com.tencent.mm.plugin.appbrand.platform.window.a.a, b.a {
    private static boolean nWY = false;
    private final k kCd = new k() {
        /* class com.tencent.mm.plugin.appbrand.ui.AppBrandUI.AnonymousClass10 */

        @Override // com.tencent.mm.plugin.appbrand.task.k
        public final FrameLayout bWl() {
            AppMethodBeat.i(227683);
            FrameLayout frameLayout = (FrameLayout) AppBrandUI.this.mContentView;
            AppMethodBeat.o(227683);
            return frameLayout;
        }

        @Override // com.tencent.mm.plugin.appbrand.task.k
        public final void a(k.a aVar) {
            AppMethodBeat.i(227685);
            q qVar = q.nXr;
            q.a(AppBrandUI.this, aVar);
            AppMethodBeat.o(227685);
        }

        @Override // com.tencent.mm.plugin.appbrand.task.k
        public final void finish() {
            AppMethodBeat.i(227684);
            AppBrandUI.this.finish();
            AppMethodBeat.o(227684);
        }

        @Override // com.tencent.mm.plugin.appbrand.task.k
        public final boolean bsc() {
            AppMethodBeat.i(227686);
            boolean bsc = AppBrandUI.this.bsc();
            AppMethodBeat.o(227686);
            return bsc;
        }

        @Override // com.tencent.mm.plugin.appbrand.task.k
        public final /* bridge */ /* synthetic */ Activity getActivity() {
            return AppBrandUI.this;
        }

        @Override // com.tencent.mm.plugin.appbrand.task.k
        public final /* synthetic */ Context getContext() {
            AppMethodBeat.i(227687);
            n eo = n.eo(AppBrandUI.this);
            AppMethodBeat.o(227687);
            return eo;
        }
    };
    String ldT = null;
    private LayoutInflater mLayoutInflater;
    private Resources mResources;
    @Keep
    AppBrandRuntimeContainerWC mRuntimeContainer;
    private final com.tencent.mm.plugin.appbrand.widget.input.a nWR = new com.tencent.mm.plugin.appbrand.widget.input.a(this);
    private final AppBrandUITranslucentWorkaroundDelegate nWS = new AppBrandUITranslucentWorkaroundDelegate(this);
    private boolean nWT = false;
    private e nWU;
    private boolean nWV = false;
    private boolean nWW = false;
    private Boolean nWX = null;
    private boolean nWZ = false;
    private boolean nXa = false;
    private boolean nXb = false;
    private boolean nXc = false;
    public boolean nXd = false;
    private w nXe;
    private d nXf = null;
    private boolean nXg = false;
    private final Set<a.AbstractC0786a> nXh = new HashSet();
    private Boolean nXi;
    private Configuration ntA = null;

    static /* synthetic */ void a(AppBrandUI appBrandUI, Bundle bundle) {
        AppMethodBeat.i(175082);
        super.onCreate(bundle);
        AppMethodBeat.o(175082);
    }

    static /* synthetic */ void g(AppBrandUI appBrandUI) {
        AppMethodBeat.i(227697);
        super.onResume();
        AppMethodBeat.o(227697);
    }

    public AppBrandUI() {
        boolean z = true;
        AppMethodBeat.i(48819);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        boolean z2 = false;
        for (StackTraceElement stackTraceElement : stackTrace) {
            if ("android.app.Instrumentation".equals(stackTraceElement.getClassName()) && "newActivity".equals(stackTraceElement.getMethodName())) {
                z2 = true;
            }
        }
        if (z2) {
            l lVar = l.nQh;
            l.b(this, "<init>");
            AppBrandProcessSuicideLogic.C(this);
            this.nWX = Boolean.valueOf(com.tencent.mm.plugin.appbrand.app.e.bun() ? false : z);
        }
        AppMethodBeat.o(48819);
    }

    public final String getLocalClassName() {
        AppMethodBeat.i(48820);
        if (getComponentName() != null) {
            String localClassName = super.getLocalClassName();
            AppMethodBeat.o(48820);
            return localClassName;
        }
        String packageName = MMApplicationContext.getPackageName();
        String name = getClass().getName();
        int length = packageName.length();
        if (!name.startsWith(packageName) || name.length() <= length || name.charAt(length) != '.') {
            AppMethodBeat.o(48820);
            return name;
        }
        String substring = name.substring(length + 1);
        AppMethodBeat.o(48820);
        return substring;
    }

    public void unbindService(ServiceConnection serviceConnection) {
        AppMethodBeat.i(227688);
        try {
            super.unbindService(serviceConnection);
            AppMethodBeat.o(227688);
        } catch (IllegalArgumentException e2) {
            Log.e("MicroMsg.AppBrandUI", "unbindService IllegalArgumentException %s", e2);
            AppMethodBeat.o(227688);
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        AppMethodBeat.i(227689);
        try {
            super.unregisterReceiver(broadcastReceiver);
            AppMethodBeat.o(227689);
        } catch (IllegalArgumentException e2) {
            Log.e("MicroMsg.AppBrandUI", "unregisterReceiver IllegalArgumentException %s", e2);
            AppMethodBeat.o(227689);
        }
    }

    public LayoutInflater getLayoutInflater() {
        AppMethodBeat.i(227690);
        if (this.mLayoutInflater != null) {
            LayoutInflater layoutInflater = this.mLayoutInflater;
            AppMethodBeat.o(227690);
            return layoutInflater;
        }
        LayoutInflater layoutInflater2 = (LayoutInflater) super.getSystemService("layout_inflater");
        this.mLayoutInflater = layoutInflater2;
        AppMethodBeat.o(227690);
        return layoutInflater2;
    }

    @Override // android.content.Context, android.view.ContextThemeWrapper, android.content.ContextWrapper, com.tencent.mm.ui.MMFragmentActivity, android.app.Activity
    public Object getSystemService(String str) {
        AppMethodBeat.i(48821);
        if (!"layout_inflater".equals(str)) {
            Object systemService = super.getSystemService(str);
            AppMethodBeat.o(48821);
            return systemService;
        } else if (this.mLayoutInflater != null) {
            LayoutInflater layoutInflater = this.mLayoutInflater;
            AppMethodBeat.o(48821);
            return layoutInflater;
        } else {
            LayoutInflater layoutInflater2 = (LayoutInflater) super.getSystemService(str);
            this.mLayoutInflater = layoutInflater2;
            AppMethodBeat.o(48821);
            return layoutInflater2;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public final Resources getResources() {
        AppMethodBeat.i(161868);
        if (this.mResources == null) {
            this.mResources = super.getResources();
        }
        Resources resources = this.mResources;
        AppMethodBeat.o(161868);
        return resources;
    }

    public final w bXx() {
        AppMethodBeat.i(48822);
        if (this.nXe == null) {
            this.nXe = new w(this);
        }
        w wVar = this.nXe;
        AppMethodBeat.o(48822);
        return wVar;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(final Bundle bundle) {
        boolean z;
        AppMethodBeat.i(48823);
        long currentTicks = Util.currentTicks();
        l lVar = l.nQh;
        l.b(this, "onCreate");
        setTheme(x.bXG());
        if (!DebuggerShell.bAx() && ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_disable_accessibility_anr, 0) > 0) {
            AccessibilityUtil.smartDisableAccessibility();
        }
        try {
            c.a("[AppBrandUILifeCycleSpeedProfile] AppBrandUI.super.onCreate", new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.AppBrandUI.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(48808);
                    AppBrandUI.a(AppBrandUI.this, bundle);
                    AppMethodBeat.o(48808);
                }
            });
            if (getIntent() == null) {
                Log.e("MicroMsg.AppBrandUI", "onCreate %d, null intent", Integer.valueOf(hashCode()));
                finish();
                AppMethodBeat.o(48823);
                return;
            }
            AppBrandInitConfigWC bsC = bsC();
            if (bsC != null) {
                if (bsC.kHL.kuZ) {
                    BaseAppBrandUIClipped.d(this, getResources().getColor(R.color.am));
                } else {
                    BaseAppBrandUIClipped.d(this, getResources().getColor(R.color.f3044b));
                }
            }
            Log.i("MicroMsg.AppBrandUI", "[AppBrandUILifeCycleSpeedProfile] onCreate %d, intent.flags = %d, super.onCreate() cost %dms", Integer.valueOf(hashCode()), Integer.valueOf(getIntent().getFlags()), Long.valueOf(Util.currentTicks() - currentTicks));
            this.nWV = true;
            c.a("[AppBrandUILifeCycleSpeedProfile] onCreate stuffs " + getLocalClassName(), new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.AppBrandUI.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(48811);
                    AppBrandUI.this.ntA = new Configuration(AppBrandUI.H(AppBrandUI.this));
                    AppBrandUI.this.nXa = false;
                    AppBrandUI.this.mRuntimeContainer = new AppBrandRuntimeContainerWC(AppBrandUI.this.kCd);
                    AppBrandRuntimeContainerWC appBrandRuntimeContainerWC = AppBrandUI.this.mRuntimeContainer;
                    n nVar = new n(AppBrandUI.this, AppBrandUI.this.mContentView);
                    appBrandRuntimeContainerWC.mContentView.removeView(nVar);
                    appBrandRuntimeContainerWC.mContentView.addView(nVar, appBrandRuntimeContainerWC.mContentView.getChildCount(), new ViewGroup.LayoutParams(-1, -1));
                    appBrandRuntimeContainerWC.kCh = nVar;
                    appBrandRuntimeContainerWC.mContentView.requestChildFocus(appBrandRuntimeContainerWC.kCh, appBrandRuntimeContainerWC.kCh);
                    com.tencent.mm.plugin.appbrand.widget.input.a aVar = AppBrandUI.this.nWR;
                    FrameLayout bWl = AppBrandUI.this.kCd.bWl();
                    if (!(aVar.activity == null || aVar.activity.getWindow() == null || bWl == null || bWl.getParent() == null || !(bWl.getParent() instanceof ViewGroup))) {
                        aVar.ory = true;
                        ViewGroup viewGroup = (ViewGroup) bWl.getParent();
                        if (Build.VERSION.SDK_INT < 20) {
                            Meizu.hideMeizuSmartBar(aVar.activity, viewGroup);
                            aVar.caO();
                        }
                        if (com.tencent.mm.plugin.appbrand.widget.input.a.orx && com.tencent.mm.plugin.appbrand.widget.input.a.eB(aVar.activity)) {
                            am.a(viewGroup, new am.a() {
                                /* class com.tencent.mm.plugin.appbrand.widget.input.a.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.appbrand.widget.input.am.a
                                public final void caR() {
                                    AppMethodBeat.i(136297);
                                    Log.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onRootViewResized");
                                    a.a(a.this);
                                    AppMethodBeat.o(136297);
                                }
                            });
                        }
                    }
                    AppBrandUI.this.nWU = new e(AppBrandUI.this) {
                        /* class com.tencent.mm.plugin.appbrand.ui.AppBrandUI.AnonymousClass3.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.appbrand.a.e
                        public final void bxc() {
                            AppMethodBeat.i(48809);
                            Log.i("MicroMsg.AppBrandUI", "onHomePressed %s", AppBrandUI.this.getLocalClassName());
                            AppBrandRuntime activeRuntime = AppBrandUI.this.mRuntimeContainer.getActiveRuntime();
                            if (activeRuntime == null) {
                                AppMethodBeat.o(48809);
                                return;
                            }
                            h.a(activeRuntime.mAppId, h.d.HOME_PRESSED);
                            AppMethodBeat.o(48809);
                        }

                        @Override // com.tencent.mm.plugin.appbrand.a.e
                        public final void bxd() {
                            AppMethodBeat.i(48810);
                            Log.i("MicroMsg.AppBrandUI", "onRecentAppsPressed %s", AppBrandUI.this.getLocalClassName());
                            AppBrandRuntime activeRuntime = AppBrandUI.this.mRuntimeContainer.getActiveRuntime();
                            if (activeRuntime == null) {
                                AppMethodBeat.o(48810);
                                return;
                            }
                            h.a(activeRuntime.mAppId, h.d.RECENT_APPS_PRESSED);
                            AppMethodBeat.o(48810);
                        }
                    };
                    e eVar = AppBrandUI.this.nWU;
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
                    try {
                        MMApplicationContext.getContext().registerReceiver(eVar.receiver, intentFilter);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.BaseAppBrandUIHomePressReceiver", "register screen off receiver e = ".concat(String.valueOf(e2)));
                    }
                    ao.aQ(AppBrandUI.this);
                    AppMethodBeat.o(48811);
                }
            });
            t.k(this);
            e(getIntent(), "onCreate");
            com.tencent.mm.plugin.appbrand.performance.h hVar = h.a.nxd;
            if (System.currentTimeMillis() % 100 == 1 || WeChatEnvironment.hasDebugger() || WeChatEnvironment.isMonkeyEnv() || BuildInfo.IS_FLAVOR_RED) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.i("MicroMsg.MemoryNegativeFeedbackReporter", "register");
                hVar.drH = 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0120: IPUT  
                      (wrap: com.tencent.mm.plugin.appbrand.performance.h$1 : 0x011d: CONSTRUCTOR  (r0v17 com.tencent.mm.plugin.appbrand.performance.h$1) = (r3v7 'hVar' com.tencent.mm.plugin.appbrand.performance.h) call: com.tencent.mm.plugin.appbrand.performance.h.1.<init>(com.tencent.mm.plugin.appbrand.performance.h):void type: CONSTRUCTOR)
                      (r3v7 'hVar' com.tencent.mm.plugin.appbrand.performance.h)
                     com.tencent.mm.plugin.appbrand.performance.h.drH android.content.ComponentCallbacks2 in method: com.tencent.mm.plugin.appbrand.ui.AppBrandUI.onCreate(android.os.Bundle):void, file: classes3.dex
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
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x011d: CONSTRUCTOR  (r0v17 com.tencent.mm.plugin.appbrand.performance.h$1) = (r3v7 'hVar' com.tencent.mm.plugin.appbrand.performance.h) call: com.tencent.mm.plugin.appbrand.performance.h.1.<init>(com.tencent.mm.plugin.appbrand.performance.h):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.ui.AppBrandUI.onCreate(android.os.Bundle):void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 28 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.performance.h, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 32 more
                    */
                /*
                // Method dump skipped, instructions count: 327
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ui.AppBrandUI.onCreate(android.os.Bundle):void");
            }

            private void bXy() {
                AppMethodBeat.i(48824);
                int stackSize = this.mRuntimeContainer == null ? -1 : this.mRuntimeContainer.getStackSize();
                Log.i("MicroMsg.AppBrandUI", "%s.closeIfNoActiveRuntimes %d,", getLocalClassName(), Integer.valueOf(stackSize));
                if (this.mRuntimeContainer instanceof AppBrandRuntimeContainerWC) {
                    this.mRuntimeContainer.OH();
                    AppMethodBeat.o(48824);
                    return;
                }
                if (stackSize <= 0) {
                    finish();
                }
                AppMethodBeat.o(48824);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
            public void onNewIntent(Intent intent) {
                boolean z = true;
                AppMethodBeat.i(48825);
                Log.i("MicroMsg.AppBrandUI", "onNewIntent %s, %d, isFinishing:%b", intent, Integer.valueOf(hashCode()), Boolean.valueOf(isFinishing()));
                l lVar = l.nQh;
                l.b(this, "onNewIntent");
                try {
                    super.onNewIntent(intent);
                    if (isFinishing()) {
                        AppMethodBeat.o(48825);
                        return;
                    }
                    this.nXg = true;
                    this.nWW = true;
                    if (intent != null && intent.getBooleanExtra("key_appbrand_bring_ui_to_front", false)) {
                        bXy();
                        AppMethodBeat.o(48825);
                    } else if (intent == null) {
                        AppMethodBeat.o(48825);
                    } else {
                        t.k(this);
                        if (intent.getParcelableExtra("key_appbrand_init_config") == null) {
                            z = false;
                        }
                        if (!z) {
                            com.tencent.luggage.sdk.d.d dVar = this.mRuntimeContainer == null ? null : (com.tencent.luggage.sdk.d.d) this.mRuntimeContainer.getActiveRuntime();
                            if (dVar == null || !com.tencent.mm.plugin.appbrand.h.b(dVar.mAppId, intent)) {
                                AppMethodBeat.o(48825);
                            } else {
                                AppMethodBeat.o(48825);
                            }
                        } else {
                            com.tencent.mm.ui.base.b.bp(this);
                            e(intent, "onNewIntent");
                            AppMethodBeat.o(48825);
                        }
                    }
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.AppBrandUI", th, "%s.onNewIntent", getLocalClassName());
                    bXy();
                    AppMethodBeat.o(48825);
                }
            }

            /* access modifiers changed from: package-private */
            public void M(Intent intent) {
                AppMethodBeat.i(48826);
                AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) intent.getParcelableExtra("key_appbrand_init_config");
                if (appBrandInitConfigWC == null) {
                    AppMethodBeat.o(48826);
                    return;
                }
                l(appBrandInitConfigWC);
                AppMethodBeat.o(48826);
            }

            private void e(Intent intent, String str) {
                AppMethodBeat.i(227691);
                try {
                    setIntent(intent);
                    c.a("AppBrandRuntimeContainerProfile| load", new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.ui.AppBrandUI.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(48812);
                            AppBrandUI.this.N(AppBrandUI.this.getIntent());
                            AppMethodBeat.o(48812);
                        }
                    });
                    AppMethodBeat.o(227691);
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandUI", "performLoadRuntime, scene=%s, e=%s", str, e2);
                    AppMethodBeat.o(227691);
                }
            }

            /* access modifiers changed from: protected */
            /* JADX WARNING: Removed duplicated region for block: B:7:0x001a A[ADDED_TO_REGION] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void N(android.content.Intent r15) {
                /*
                // Method dump skipped, instructions count: 948
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ui.AppBrandUI.N(android.content.Intent):void");
            }

            public static Pair<AppBrandInitConfigWC, AppBrandStatObject> P(Intent intent) {
                AppMethodBeat.i(48829);
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    NullPointerException nullPointerException = new NullPointerException("intent.getExtras() returns NULL");
                    AppMethodBeat.o(48829);
                    throw nullPointerException;
                }
                extras.setClassLoader(AppBrandInitConfigWC.class.getClassLoader());
                AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) extras.getParcelable("key_appbrand_init_config");
                extras.setClassLoader(AppBrandStatObject.class.getClassLoader());
                AppBrandStatObject appBrandStatObject = (AppBrandStatObject) extras.getParcelable("key_appbrand_stat_object");
                if (appBrandInitConfigWC == null) {
                    NullPointerException nullPointerException2 = new NullPointerException("config is NULL");
                    AppMethodBeat.o(48829);
                    throw nullPointerException2;
                } else if (appBrandStatObject == null) {
                    NullPointerException nullPointerException3 = new NullPointerException("stat is NULL");
                    AppMethodBeat.o(48829);
                    throw nullPointerException3;
                } else {
                    Pair<AppBrandInitConfigWC, AppBrandStatObject> create = Pair.create(appBrandInitConfigWC, appBrandStatObject);
                    AppMethodBeat.o(48829);
                    return create;
                }
            }

            public static Configuration H(Activity activity) {
                AppMethodBeat.i(48830);
                if (activity instanceof MMFragmentActivity) {
                    Configuration configuration = ((MMFragmentActivity) activity).getOriginalResources().getConfiguration();
                    AppMethodBeat.o(48830);
                    return configuration;
                } else if (activity instanceof MMBaseActivity) {
                    Configuration configuration2 = ((MMBaseActivity) activity).getOriginalResources().getConfiguration();
                    AppMethodBeat.o(48830);
                    return configuration2;
                } else {
                    Configuration configuration3 = activity.getResources().getConfiguration();
                    AppMethodBeat.o(48830);
                    return configuration3;
                }
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onConfigurationChanged(Configuration configuration) {
                boolean z;
                boolean z2;
                String str;
                boolean z3;
                AppMethodBeat.i(48831);
                Log.i("MicroMsg.AppBrandUI", "onConfigurationChanged newConfig: %s", Integer.valueOf(configuration.orientation));
                super.onConfigurationChanged(configuration);
                if (this.ntA != null) {
                    if (configuration.smallestScreenWidthDp == this.ntA.smallestScreenWidthDp || !AppBrandRuntimeWCAccessible.isGame(this.mRuntimeContainer.getActiveRuntime())) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        Log.i("MicroMsg.AppBrandUI", "onConfigurationChanged by fold or unfold, last.smallestScreenWidthDp[%d], new.smallestScreenWidthDp[%d]", Integer.valueOf(this.ntA.smallestScreenWidthDp), Integer.valueOf(configuration.smallestScreenWidthDp));
                        cp("multiWindowMode", 1);
                        AppMethodBeat.o(48831);
                        return;
                    }
                }
                if (this.ntA != null) {
                    Configuration configuration2 = this.ntA;
                    q qVar = (q) this.mRuntimeContainer.getActiveRuntime();
                    if (qVar == null || qVar.getAppConfig() == null) {
                        z = false;
                    } else {
                        z = qVar.getAppConfig().bzE();
                    }
                    boolean z4 = (configuration.uiMode & 48) != (configuration2.uiMode & 48);
                    boolean awN = ao.awN();
                    boolean awS = ao.awS();
                    Log.i("MicroMsg.AppBrandUI", "darkModeThemeChanged  isDarkModeSupportForCurrentWxa=%b  isNightModeEnableForWeChat=%b  isDarkModeFollowSystem=%b  nightModeChanged=%b", Boolean.valueOf(z), Boolean.valueOf(awN), Boolean.valueOf(awS), Boolean.valueOf(z4));
                    if (!z || !awN || !z4 || !awS) {
                        z2 = false;
                    } else {
                        StringBuilder sb = new StringBuilder("Theme change into ");
                        if (32 == (configuration.uiMode & 48)) {
                            str = "NIGHT";
                        } else {
                            str = "DAY";
                        }
                        Log.i("MicroMsg.AppBrandUI", sb.append(str).append(" mode").toString());
                        z2 = true;
                    }
                    if (z2) {
                        cp("darkModeTheme", 2);
                        AppMethodBeat.o(48831);
                        return;
                    }
                }
                this.ntA = new Configuration(configuration);
                com.tencent.mm.plugin.appbrand.widget.input.a aVar = this.nWR;
                if (configuration != null) {
                    Log.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onActivityConfigurationChanged, orientation %d", Integer.valueOf(configuration.orientation));
                    aVar.caN();
                }
                this.mRuntimeContainer.dispatchConfigurationChanged(configuration);
                AppBrandRuntime activeRuntime = this.mRuntimeContainer.getActiveRuntime();
                if (activeRuntime != null) {
                    try {
                        activeRuntime.brh().getCurrentPage().onConfigurationChanged(configuration);
                        AppMethodBeat.o(48831);
                        return;
                    } catch (NullPointerException e2) {
                    }
                }
                AppMethodBeat.o(48831);
            }

            private void cp(String str, int i2) {
                AppMethodBeat.i(48833);
                if (this.nXa || this.nXb) {
                    Log.i("MicroMsg.AppBrandUI", "has recreateProcess!");
                    AppMethodBeat.o(48833);
                    return;
                }
                if (i2 == 1) {
                    try {
                        this.nXb = true;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.AppBrandUI", e2, "recreate Activity exception", new Object[0]);
                        finish();
                        AppMethodBeat.o(48833);
                        return;
                    }
                } else if (i2 == 0) {
                    this.nXa = true;
                } else if (i2 == 2) {
                    this.nXc = true;
                }
                Pair<AppBrandInitConfigWC, AppBrandStatObject> P = P(getIntent());
                AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) P.first;
                appBrandInitConfigWC.ldO = Util.nowMilliSecond();
                appBrandInitConfigWC.startTime = Util.nowMilliSecond();
                Intent intent = getIntent();
                intent.putExtra("key_appbrand_init_config", appBrandInitConfigWC);
                intent.putExtra("key_appbrand_stat_object", (AppBrandStatObject) P.second);
                setIntent(intent);
                AppBrandProcessSuicideLogic.bup();
                Log.i("MicroMsg.AppBrandUI", "recreate Activity[%s] by %s", getClass().getSimpleName(), str);
                recreate();
                AppMethodBeat.o(48833);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.b
            public final void bHJ() {
                AppMethodBeat.i(227692);
                Log.i("MicroMsg.AppBrandUI", "forceEnableBackPress");
                this.nWZ = false;
                AppMethodBeat.o(227692);
            }

            public void onEnterAnimationComplete() {
                AppMethodBeat.i(48834);
                Log.i("MicroMsg.AppBrandUI", "onEnterAnimationComplete");
                this.nWZ = false;
                if (this.mRuntimeContainer != null) {
                    AppBrandRuntimeContainerWC appBrandRuntimeContainerWC = this.mRuntimeContainer;
                    if (appBrandRuntimeContainerWC.getStackSize() == 1) {
                        ((q) appBrandRuntimeContainerWC.getActiveRuntime()).onEnterAnimationComplete();
                    }
                }
                try {
                    s sVar = s.nXy;
                    s.eK(MainProcessIPCService.dkO, getClass().getCanonicalName());
                    String str = ((AppBrandInitConfigWC) P(getIntent()).first).ldP;
                    if (!TextUtils.isEmpty(str)) {
                        s sVar2 = s.nXy;
                        s.eK(str, getClass().getCanonicalName());
                    }
                    AppMethodBeat.o(48834);
                } catch (Throwable th) {
                    AppMethodBeat.o(48834);
                }
            }

            public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
                AppMethodBeat.i(48835);
                super.onWindowAttributesChanged(layoutParams);
                com.tencent.mm.plugin.appbrand.widget.input.a aVar = this.nWR;
                if (layoutParams != null) {
                    Log.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onActivityWindowAttributesChanged, oldFlags %d, newFlags %d", Integer.valueOf(aVar.orz), Integer.valueOf(layoutParams.flags));
                    if (layoutParams.flags != aVar.orz) {
                        aVar.orz = layoutParams.flags;
                        aVar.caN();
                    }
                }
                if (this.mRuntimeContainer != null) {
                    this.mRuntimeContainer.b(layoutParams);
                }
                AppMethodBeat.o(48835);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
                boolean z;
                AppMethodBeat.i(48836);
                AppBrandUITranslucentWorkaroundDelegate appBrandUITranslucentWorkaroundDelegate = this.nWS;
                if (appBrandUITranslucentWorkaroundDelegate.nXU) {
                    appBrandUITranslucentWorkaroundDelegate.nXV = true;
                    com.tencent.mm.ui.base.b.bp(appBrandUITranslucentWorkaroundDelegate.nXT);
                }
                boolean z2 = intent != null && (intent.getFlags() & 268435456) > 0;
                if (intent == null || !com.tencent.mm.plugin.appbrand.utils.f.d(intent.getComponent()).equals(com.tencent.mm.plugin.appbrand.utils.f.d(getComponentName()))) {
                    z = false;
                } else {
                    z = true;
                }
                boolean B = AppBrandProcessProxyUI.B(intent);
                boolean G = AppBrandLaunchProxyUI.G(intent);
                if (this.mRuntimeContainer.getActiveRuntime() != null) {
                    String str = ((com.tencent.luggage.sdk.d.d) this.mRuntimeContainer.getActiveRuntime()).mAppId;
                    if (G) {
                        com.tencent.mm.plugin.appbrand.h.a(str, h.d.LAUNCH_MINI_PROGRAM);
                    } else if ((!z2 || z || B) && h.d.HIDE == com.tencent.mm.plugin.appbrand.h.Uc(str)) {
                        com.tencent.mm.plugin.appbrand.h.a(str, h.d.LAUNCH_NATIVE_PAGE);
                    }
                }
                try {
                    ((q) this.mRuntimeContainer.getActiveRuntime()).bsD().getReporter().I(intent);
                } catch (Exception e2) {
                }
                try {
                    super.startActivityForResult(intent, i2, bundle);
                    AppMethodBeat.o(48836);
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.AppBrandUI", th, "startActivityForResult", new Object[0]);
                    AppMethodBeat.o(48836);
                }
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onStart() {
                AppMethodBeat.i(48837);
                l lVar = l.nQh;
                l.b(this, "onStart");
                super.onStart();
                Log.i("MicroMsg.AppBrandUIccf", "onStart");
                l lVar2 = l.nQh;
                l.b(this, "onStarted");
                AppMethodBeat.o(48837);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onStop() {
                AppMethodBeat.i(227693);
                l lVar = l.nQh;
                l.b(this, "onStop");
                super.onStop();
                AppMethodBeat.o(227693);
            }

            @Override // com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
            public void onWindowFocusChanged(boolean z) {
                AppMethodBeat.i(48838);
                AppMethodBeat.at(this, z);
                super.onWindowFocusChanged(z);
                Log.i("MicroMsg.AppBrandUI", "onWindowFocusChanged %b", Boolean.valueOf(z));
                if (!z) {
                    this.nXg = false;
                }
                AppMethodBeat.o(48838);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onResume() {
                int i2;
                AppMethodBeat.i(48839);
                l lVar = l.nQh;
                l.b(this, "onResume");
                try {
                    c.a("[AppBrandUILifeCycleSpeedProfile] AppBrandUI.super.onResume()", new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.ui.AppBrandUI.AnonymousClass7 */

                        public final void run() {
                            AppMethodBeat.i(227681);
                            AppBrandUI.g(AppBrandUI.this);
                            AppMethodBeat.o(227681);
                        }
                    });
                    Log.i("MicroMsg.AppBrandUI", "onResume %d", Integer.valueOf(hashCode()));
                    if (this.nWT) {
                        this.nWZ = false;
                    } else {
                        int i3 = Build.VERSION.SDK_INT;
                    }
                    if (!bsc() || this.nWV || this.nWW) {
                        i2 = 0;
                    } else {
                        i2 = 2;
                    }
                    q qVar = (q) this.mRuntimeContainer.getActiveRuntime();
                    if (qVar != null) {
                        Log.i("MicroMsg.AppBrandUI", "onResume, appId = %s, systemRecentsReason = %d", qVar.mAppId, Integer.valueOf(i2));
                        qVar.bsC().ldX = i2;
                    }
                    this.nWT = false;
                    this.nWW = false;
                    this.nWV = false;
                    this.mRuntimeContainer.onResume();
                    i F = i.F(this);
                    Log.d(F.lMQ, "onResume");
                    F.nFj.enable();
                    com.tencent.mm.plugin.appbrand.ad.e.I(this.mRuntimeContainer.getActiveRuntime());
                    try {
                        if (this.mRuntimeContainer.getActiveRuntime() != null) {
                            com.tencent.mm.modelstat.d.d(3, "AppBrandUI_" + ((com.tencent.luggage.sdk.d.d) this.mRuntimeContainer.getActiveRuntime()).mAppId, hashCode());
                        }
                    } catch (Throwable th) {
                        Log.printErrStackTrace("MicroMsg.AppBrandUI", th, "[oneliang]AppBrandUI click flow exception.", new Object[0]);
                    }
                    if (AppBrandRuntimeWCAccessible.isGame(this.mRuntimeContainer.getActiveRuntime())) {
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.jf("ce_mg", ((com.tencent.luggage.sdk.d.d) this.mRuntimeContainer.getActiveRuntime()).mAppId);
                    }
                    if (this.nXg) {
                        M(getIntent());
                    }
                    l lVar2 = l.nQh;
                    l.b(this, "onResumed");
                    AppMethodBeat.o(48839);
                } catch (BadParcelableException e2) {
                    Log.e("MicroMsg.AppBrandUI", "onResume BadParcelableException occurs, just finish");
                    finish();
                    AppMethodBeat.o(48839);
                }
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onPause() {
                AppMethodBeat.i(48840);
                l lVar = l.nQh;
                l.b(this, "onPause");
                super.onPause();
                AnonymousClass8 r1 = new kotlin.g.a.b<Boolean, x>() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandUI.AnonymousClass8 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ x invoke(Boolean bool) {
                        boolean z = true;
                        AppMethodBeat.i(227682);
                        Boolean bool2 = bool;
                        Log.i("MicroMsg.AppBrandUI", "onPause: isScreenOn = [%b]", bool2);
                        if (!bool2.booleanValue()) {
                            AppBrandUI.h(AppBrandUI.this);
                        }
                        AppBrandUI appBrandUI = AppBrandUI.this;
                        if (bool2.booleanValue()) {
                            z = false;
                        }
                        appBrandUI.nWT = z;
                        AppMethodBeat.o(227682);
                        return null;
                    }
                };
                p.h(this, "context");
                p.h(r1, "onScreenStatusGot");
                MMHandlerThread.postToMainThread(new z.a(this, r1));
                this.nWV = false;
                this.nWW = false;
                this.nWZ = true;
                AppBrandRuntimeContainerWC appBrandRuntimeContainerWC = this.mRuntimeContainer;
                Log.i("MicroMsg.AppBrandRuntimeContainer", "onPause tid = %d", Long.valueOf(Thread.currentThread().getId()));
                appBrandRuntimeContainerWC.runOnUiThread(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0054: INVOKE  
                      (r0v6 'appBrandRuntimeContainerWC' com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC)
                      (wrap: com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer$7 : 0x0051: CONSTRUCTOR  (r1v2 com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer$7) = (r0v6 'appBrandRuntimeContainerWC' com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC) call: com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer.7.<init>(com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer):void type: CONSTRUCTOR)
                     type: VIRTUAL call: com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer.runOnUiThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.appbrand.ui.AppBrandUI.onPause():void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0051: CONSTRUCTOR  (r1v2 com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer$7) = (r0v6 'appBrandRuntimeContainerWC' com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC) call: com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer.7.<init>(com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.ui.AppBrandUI.onPause():void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 14 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 20 more
                    */
                /*
                // Method dump skipped, instructions count: 271
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ui.AppBrandUI.onPause():void");
            }

            @Override // com.tencent.mm.plugin.appbrand.platform.window.a.a
            public final void a(a.AbstractC0786a aVar) {
                AppMethodBeat.i(227694);
                this.nXh.add(aVar);
                AppMethodBeat.o(227694);
            }

            @Override // com.tencent.mm.plugin.appbrand.platform.window.a.a
            public final void b(a.AbstractC0786a aVar) {
                AppMethodBeat.i(227695);
                this.nXh.remove(aVar);
                AppMethodBeat.o(227695);
            }

            @Override // com.tencent.mm.ui.MMFragmentActivity
            public void setRequestedOrientation(int i2) {
                AppMethodBeat.i(48841);
                if (this.nXh.size() > 0) {
                    LinkedList<a.AbstractC0786a> linkedList = new LinkedList(this.nXh);
                    for (a.AbstractC0786a aVar : linkedList) {
                        if (aVar.xM(i2)) {
                            Log.i("MicroMsg.AppBrandUI", "setRequestedOrientation name[%s], request[%d], hooks.size[%d] intercept by %s", getLocalClassName(), Integer.valueOf(i2), Integer.valueOf(linkedList.size()), aVar);
                            AppMethodBeat.o(48841);
                            return;
                        }
                    }
                }
                super.setRequestedOrientation(i2);
                Log.i("MicroMsg.AppBrandUI", "setRequestedOrientation name[%s], request[%d], stack %s", getLocalClassName(), Integer.valueOf(i2), android.util.Log.getStackTraceString(new Throwable()));
                AppMethodBeat.o(48841);
            }

            @Override // com.tencent.mm.ui.MMFragmentActivity
            public final void initActivityOpenAnimation(Intent intent) {
                AppBrandInitConfigWC appBrandInitConfigWC;
                AppBrandStatObject appBrandStatObject;
                AppMethodBeat.i(48842);
                if (intent != null && intent.getComponent() != null && intent.getComponent().getClassName().endsWith(getLocalClassName())) {
                    try {
                        appBrandInitConfigWC = (AppBrandInitConfigWC) intent.getParcelableExtra("key_appbrand_init_config");
                        try {
                            appBrandStatObject = (AppBrandStatObject) intent.getParcelableExtra("key_appbrand_stat_object");
                        } catch (Exception e2) {
                            appBrandStatObject = null;
                            try {
                                h(appBrandInitConfigWC, appBrandStatObject);
                                AppMethodBeat.o(48842);
                                return;
                            } catch (Exception e3) {
                                Log.e("MicroMsg.AppBrandUI", "initAppBrandUIOpenAnimation, e = %s", e3);
                            }
                        }
                    } catch (Exception e4) {
                        appBrandInitConfigWC = null;
                        appBrandStatObject = null;
                        h(appBrandInitConfigWC, appBrandStatObject);
                        AppMethodBeat.o(48842);
                        return;
                    }
                    if (!(appBrandStatObject == null || appBrandInitConfigWC == null)) {
                        h(appBrandInitConfigWC, appBrandStatObject);
                    }
                    AppMethodBeat.o(48842);
                    return;
                } else if (!(intent == null || intent.getComponent() == null || !com.tencent.mm.ui.base.b.bmb(com.tencent.mm.ui.base.b.e(intent.getComponent())))) {
                    com.tencent.mm.ui.base.b.ke(this);
                    AppMethodBeat.o(48842);
                    return;
                }
                super.initActivityOpenAnimation(intent);
                AppMethodBeat.o(48842);
            }

            @Override // com.tencent.mm.ui.MMFragmentActivity
            public void initActivityCloseAnimation() {
                AppMethodBeat.i(48843);
                ((ah) com.tencent.luggage.a.e.M(ah.class)).m(this);
                AppMethodBeat.o(48843);
            }

            private void l(AppBrandInitConfigWC appBrandInitConfigWC) {
                AppMethodBeat.i(48845);
                if (com.tencent.mm.plugin.appbrand.utils.b.afF(this.ldT)) {
                    overridePendingTransition(0, 0);
                    AppMethodBeat.o(48845);
                    return;
                }
                ((ah) com.tencent.luggage.a.e.M(ah.class)).a(this, appBrandInitConfigWC);
                AppMethodBeat.o(48845);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
            public void finish() {
                AppMethodBeat.i(48846);
                if (isFinishing() || isDestroyed()) {
                    AppMethodBeat.o(48846);
                    return;
                }
                l lVar = l.nQh;
                l.b(this, "finish");
                t.l(this);
                try {
                    if (this.mRuntimeContainer != null) {
                        this.mRuntimeContainer.bsl();
                        this.mRuntimeContainer.a(AppBrandRuntimeContainerWC.a.Finish);
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        super.finishAndRemoveTask();
                    } else {
                        super.finish();
                    }
                    if (!this.nXd) {
                        initActivityCloseAnimation();
                    }
                    AppMethodBeat.o(48846);
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandUI", "finish e = %s", e2);
                    getIntent().removeExtra("android.view.autofill.extra.RESTORE_SESSION_TOKEN");
                    super.finishAndRemoveTask();
                    AppMethodBeat.o(48846);
                } catch (Throwable th) {
                    Log.e("MicroMsg.AppBrandUI", "finish api27 fallback, thr = %s", th);
                    AppMethodBeat.o(48846);
                }
            }

            public final void bXz() {
                AppBrandRuntime activeRuntime;
                AppMethodBeat.i(227696);
                switch (getLifecycle().getCurrentState()) {
                    case STARTED:
                    case RESUMED:
                        Log.w("MicroMsg.AppBrandUI", "forceMoveTaskToBack, hash:%d, name:%s, state:%s, skip.", Integer.valueOf(hashCode()), getLocalClassName(), getLifecycle().getCurrentState());
                        AppMethodBeat.o(227696);
                        return;
                    default:
                        if (this.mRuntimeContainer == null || (activeRuntime = this.mRuntimeContainer.getActiveRuntime()) == null || activeRuntime.isDestroyed() || activeRuntime.SO) {
                            finish();
                            AppMethodBeat.o(227696);
                            return;
                        }
                        if (moveTaskToBack(false)) {
                            activeRuntime.kAH.kQM.a(d.a.ON_CONTAINER_FORCED_MOVE_TO_BACK);
                        }
                        AppMethodBeat.o(227696);
                        return;
                }
            }

            @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
            public final boolean moveTaskToBack(boolean z) {
                AppMethodBeat.i(48847);
                l lVar = l.nQh;
                l.b(this, String.format(Locale.ENGLISH, "moveTaskToBack(%b)", Boolean.valueOf(z)));
                Log.i("MicroMsg.AppBrandUI", "moveTaskToBack stack:" + android.util.Log.getStackTraceString(new Throwable()));
                t.l(this);
                try {
                    boolean moveTaskToBack = super.moveTaskToBack(z);
                    if (!this.nXd) {
                        initActivityCloseAnimation();
                    }
                    AppMethodBeat.o(48847);
                    return moveTaskToBack;
                } catch (NullPointerException e2) {
                    Log.e("MicroMsg.AppBrandUI", "moveTaskToBack() get exception %s, invoke finish()", e2);
                    finish();
                    AppMethodBeat.o(48847);
                    return true;
                }
            }

            @Override // com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onDestroy() {
                AppMethodBeat.i(48848);
                l lVar = l.nQh;
                l.b(this, "onDestroy");
                t.l(this);
                if (!this.nXa && !isChangingConfigurations() && this.mRuntimeContainer != null) {
                    this.mRuntimeContainer.a(AppBrandRuntimeContainerWC.a.OnDestroy);
                }
                if (this.mRuntimeContainer != null) {
                    this.mRuntimeContainer.cleanup();
                }
                if (this.nWU != null) {
                    try {
                        MMApplicationContext.getContext().unregisterReceiver(this.nWU.receiver);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.BaseAppBrandUIHomePressReceiver", "unregister screen off receiver e = ".concat(String.valueOf(e2)));
                    }
                }
                if (this.nXf != null) {
                    this.nXf.dismiss();
                }
                super.onDestroy();
                com.tencent.mm.plugin.appbrand.performance.h hVar = h.a.nxd;
                if (hVar.drH != null) {
                    unregisterComponentCallbacks(hVar.drH);
                }
                f.aL(this);
                AppMethodBeat.o(48848);
            }

            public boolean onTouchEvent(MotionEvent motionEvent) {
                return true;
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
            public void onBackPressed() {
                AppMethodBeat.i(48849);
                Log.i("MicroMsg.AppBrandUI", "onBackPressed %d, mEatOnBackPressed[%b]", Integer.valueOf(hashCode()), Boolean.valueOf(this.nWZ));
                if (this.nWZ) {
                    AppMethodBeat.o(48849);
                    return;
                }
                this.mRuntimeContainer.onBackPressed();
                AppMethodBeat.o(48849);
            }

            @Override // com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped
            public final void onCreateBeforeSetContentView() {
                AppMethodBeat.i(48850);
                super.onCreateBeforeSetContentView();
                com.tencent.mm.plugin.appbrand.widget.input.a aVar = this.nWR;
                if (aVar.activity == null || aVar.activity.getWindow() == null) {
                    AppMethodBeat.o(48850);
                    return;
                }
                aVar.activity.getWindow().setSoftInputMode(16);
                AppMethodBeat.o(48850);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
            public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                AppMethodBeat.i(48852);
                Iterator<RUNTIME> it = this.mRuntimeContainer.kCb.iterator();
                while (it.hasNext()) {
                    r.a(it.next().mAppId, i2, strArr, iArr);
                }
                f.aK(this).b(i2, iArr);
                AppMethodBeat.o(48852);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onActivityResult(int i2, int i3, Intent intent) {
                AppMethodBeat.i(48853);
                super.onActivityResult(i2, i3, intent);
                f.aK(this).onActivityResult(i2, i3, intent);
                if (intent != null && "jsapi_pay_onActivityResult".equals(intent.getStringExtra("key_jsapi_pay_onActivityResult")) && i3 == 5) {
                    com.tencent.mm.ui.base.h.a((Context) this, intent.getStringExtra("key_jsapi_pay_err_msg"), "", intent.getStringExtra("key_jsapi_pay_err_dialog_confirm"), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.appbrand.ui.AppBrandUI.AnonymousClass9 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                }
                AppMethodBeat.o(48853);
            }

            public final boolean bsc() {
                ActivityInfo activityInfo;
                boolean z = true;
                AppMethodBeat.i(48854);
                if (this.nXi != null) {
                    boolean booleanValue = this.nXi.booleanValue();
                    AppMethodBeat.o(48854);
                    return booleanValue;
                }
                try {
                    activityInfo = MMApplicationContext.getContext().getPackageManager().getActivityInfo(getComponentName(), 128);
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandUI", "runInStandaloneTask, resolve info e = %s", e2);
                    activityInfo = null;
                }
                if (activityInfo == null) {
                    AppMethodBeat.o(48854);
                    return true;
                }
                if (MMApplicationContext.getPackageName().equals(activityInfo.taskAffinity)) {
                    z = false;
                }
                Boolean valueOf = Boolean.valueOf(z);
                this.nXi = valueOf;
                boolean booleanValue2 = valueOf.booleanValue();
                AppMethodBeat.o(48854);
                return booleanValue2;
            }

            public final void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
                AppMethodBeat.i(48855);
                if (bsc()) {
                    try {
                        super.setTaskDescription(taskDescription);
                        AppMethodBeat.o(48855);
                        return;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.AppBrandUI", e2, "setTaskDescription ", new Object[0]);
                        if (taskDescription != null) {
                            try {
                                super.setTaskDescription(new ActivityManager.TaskDescription(taskDescription.getLabel(), (Bitmap) null, taskDescription.getPrimaryColor()));
                                AppMethodBeat.o(48855);
                                return;
                            } catch (Exception e3) {
                            }
                        }
                    }
                }
                AppMethodBeat.o(48855);
            }

            @Override // com.tencent.mm.ui.base.b.a
            public final void bXA() {
                this.nWS.nXU = true;
            }

            @Override // com.tencent.mm.ui.base.b.a
            public final void bXB() {
                this.nWS.nXU = false;
            }

            /* access modifiers changed from: protected */
            public void h(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
                AppMethodBeat.i(48844);
                appBrandInitConfigWC.cyA = appBrandStatObject;
                l(appBrandInitConfigWC);
                AppMethodBeat.o(48844);
            }

            @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
            public boolean dispatchKeyEvent(KeyEvent keyEvent) {
                AppBrandRuntime activeRuntime;
                boolean z;
                boolean z2;
                AppMethodBeat.i(180389);
                AppBrandRuntimeContainerWC appBrandRuntimeContainerWC = this.mRuntimeContainer;
                if (!(appBrandRuntimeContainerWC == null || (activeRuntime = appBrandRuntimeContainerWC.getActiveRuntime()) == null)) {
                    Set<al> set = activeRuntime.kBa.get(keyEvent.getKeyCode());
                    if (set == null) {
                        z = false;
                    } else {
                        z = false;
                        for (al alVar : set) {
                            if (alVar.kEW == -1 || alVar.kEW == keyEvent.getAction()) {
                                z2 = alVar.c(keyEvent) | z;
                            } else {
                                z2 = z;
                            }
                            z = z2;
                        }
                    }
                    if (z) {
                        AppMethodBeat.o(180389);
                        return true;
                    }
                }
                Log.d("MicroMsg.AppBrandUI", "onKeyDown: keyCode = [%d], keyAction =[%d]", Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction()));
                boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
                AppMethodBeat.o(180389);
                return dispatchKeyEvent;
            }

            static /* synthetic */ void h(AppBrandUI appBrandUI) {
                AppMethodBeat.i(227698);
                AppBrandRuntime activeRuntime = appBrandUI.mRuntimeContainer.getActiveRuntime();
                if (activeRuntime != null) {
                    activeRuntime.kAH.kQM.a(d.a.ON_SYSTEM_SCREEN_OFF);
                }
                AppMethodBeat.o(227698);
            }
        }
