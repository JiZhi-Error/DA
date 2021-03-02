package com.tencent.mm.plugin.festival.finder;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.festival.model.u;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.h;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 C2\u00020\u0001:\u0001CB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020$H\u0002J\"\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020$2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\u0006H\u0016J\u0012\u00100\u001a\u00020&2\b\u00101\u001a\u0004\u0018\u00010.H\u0016J\u0010\u00102\u001a\u00020&2\u0006\u00103\u001a\u000204H\u0016J\u0012\u00105\u001a\u00020&2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020&H\u0016J\u0012\u00109\u001a\u00020&2\b\u0010:\u001a\u0004\u0018\u00010.H\u0016J\b\u0010;\u001a\u00020&H\u0016J\b\u0010<\u001a\u00020&H\u0016J\b\u0010=\u001a\u00020&H\u0016J\b\u0010>\u001a\u00020&H\u0016J\u0006\u0010?\u001a\u00020&J\b\u0010@\u001a\u00020&H\u0002J\b\u0010A\u001a\u00020&H\u0002J\b\u0010B\u001a\u00020&H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R#\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8FX\u0002¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b \u0010!¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveVisitorUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "activeFinish", "", "callOnce", "floatBallHelper", "Lcom/tencent/mm/plugin/festival/model/FestivalPageFloatBallHelper;", "getFloatBallHelper", "()Lcom/tencent/mm/plugin/festival/model/FestivalPageFloatBallHelper;", "floatBallHelper$delegate", "Lkotlin/Lazy;", "isKeyBoardShow", "isPaused", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "presenter", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePresenter;", "swipeBack", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "unInitTask", "Ljava/lang/Runnable;", "viewCallback", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveViewCallback;", "window", "Landroid/view/Window;", "kotlin.jvm.PlatformType", "getWindow", "()Landroid/view/Window;", "window$delegate", "getLayoutId", "", "initBusiness", "", "keyboardChange", "show", "height", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "setWindowStyle", "uninitBusiness", "uninitBusinessCheck", "Companion", "plugin-festival_release"})
public final class FestivalFinderLiveVisitorUIC extends UIComponent {
    public static final a Uvs = new a((byte) 0);
    private aq Uvp;
    private FestivalFinderLiveViewCallback Uvq;
    private final f Uvr = g.ah(new b(this));
    private h gyh;
    private boolean hwq;
    private boolean isPaused;
    private Runnable vPT;
    private boolean vPU;
    private boolean vPV;
    private final f wyC = g.ah(new e(this));

    static {
        AppMethodBeat.i(262665);
        AppMethodBeat.o(262665);
    }

    private final u gEV() {
        AppMethodBeat.i(262649);
        u uVar = (u) this.Uvr.getValue();
        AppMethodBeat.o(262649);
        return uVar;
    }

    private Window getWindow() {
        AppMethodBeat.i(262650);
        Window window = (Window) this.wyC.getValue();
        AppMethodBeat.o(262650);
        return window;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FestivalFinderLiveVisitorUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(262664);
        AppMethodBeat.o(262664);
    }

    public static final /* synthetic */ void b(FestivalFinderLiveVisitorUIC festivalFinderLiveVisitorUIC) {
        AppMethodBeat.i(262667);
        festivalFinderLiveVisitorUIC.dAn();
        AppMethodBeat.o(262667);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveVisitorUIC$Companion;", "", "()V", "TAG", "", "plugin-festival_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.cdq;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        boolean z;
        Long l;
        LiveConfig dfu;
        awe awe;
        Lifecycle lifecycle = null;
        AppMethodBeat.i(262651);
        super.onCreate(bundle);
        if (getActivity() instanceof MMActivity) {
            AppCompatActivity activity = getActivity();
            if (activity == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(262651);
                throw tVar;
            }
            ((MMActivity) activity).setSelfNavigationBarVisible(8);
        }
        getWindow().addFlags(2097280);
        getWindow().addFlags(67108864);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(67108864);
            Resources resources = getContext().getResources();
            p.g(resources, "context.resources");
            if (resources.getConfiguration().orientation == 2) {
                Window window = getWindow();
                p.g(window, "window");
                View decorView = window.getDecorView();
                p.g(decorView, "window.decorView");
                decorView.setSystemUiVisibility(3846);
            } else {
                Window window2 = getWindow();
                p.g(window2, "window");
                View decorView2 = window2.getDecorView();
                p.g(decorView2, "window.decorView");
                decorView2.setSystemUiVisibility(1792);
            }
            getWindow().addFlags(Integer.MIN_VALUE);
            Window window3 = getWindow();
            p.g(window3, "window");
            window3.setStatusBarColor(0);
            Window window4 = getWindow();
            p.g(window4, "window");
            window4.setNavigationBarColor(0);
        }
        getWindow().setFormat(-3);
        getWindow().setSoftInputMode(51);
        FinderLiveConfig finderLiveConfig = (FinderLiveConfig) getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
        at atVar = at.Uuv;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = at.dfZ();
        Long valueOf = (dfZ == null || (awe = dfZ.liveInfo) == null) ? null : Long.valueOf(awe.liveId);
        StringBuilder sb = new StringBuilder("[LiveLifecycle] onCreate configProvider is null:");
        if (finderLiveConfig == null) {
            z = true;
        } else {
            z = false;
        }
        Log.i("FestivalFinderLiveVisitorUIC", sb.append(z).append(",config liveId:").append((finderLiveConfig == null || (dfu = finderLiveConfig.dfu()) == null) ? null : Long.valueOf(dfu.getLiveId())).append(", across_live ").append(valueOf).toString());
        if (finderLiveConfig != null) {
            LiveConfig dfu2 = finderLiveConfig.dfu();
            if (dfu2 != null) {
                l = Long.valueOf(dfu2.getLiveId());
            } else {
                l = null;
            }
            if (!p.j(l, valueOf)) {
                at atVar2 = at.Uuv;
                com.tencent.mm.plugin.finder.live.viewmodel.d dVar = new com.tencent.mm.plugin.finder.live.viewmodel.d();
                dVar.a(finderLiveConfig);
                at.b(dVar);
                AppCompatActivity activity2 = getActivity();
                if (activity2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(262651);
                    throw tVar2;
                }
                this.Uvp = new aq((MMActivity) activity2);
                View findViewById = getRootView().findViewById(R.id.k1i);
                p.g(findViewById, "rootView.findViewById(R.id.pluginLayout)");
                FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout = (FestivalFinderLiveVisitorPluginLayout) findViewById;
                AppCompatActivity activity3 = getActivity();
                if (activity3 == null) {
                    t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(262651);
                    throw tVar3;
                }
                MMActivity mMActivity = (MMActivity) activity3;
                Fragment fragment = getFragment();
                if (fragment != null) {
                    lifecycle = fragment.getLifecycle();
                }
                aq aqVar = this.Uvp;
                if (aqVar == null) {
                    p.hyc();
                }
                this.Uvq = new FestivalFinderLiveViewCallback(festivalFinderLiveVisitorPluginLayout, mMActivity, lifecycle, aqVar, false);
                aq aqVar2 = this.Uvp;
                if (aqVar2 == null) {
                    p.hyc();
                }
                FestivalFinderLiveViewCallback festivalFinderLiveViewCallback = this.Uvq;
                if (festivalFinderLiveViewCallback == null) {
                    p.hyc();
                }
                aqVar2.a(festivalFinderLiveViewCallback);
                gEV().G(24, com.tencent.mm.plugin.ball.f.b.dhB());
                AppMethodBeat.o(262651);
            }
        }
        at atVar3 = at.Uuv;
        com.tencent.mm.plugin.finder.live.viewmodel.d dfY = at.dfY();
        if (dfY == null) {
            p.hyc();
        }
        at atVar4 = at.Uuv;
        dfY.Jq(at.dga());
        AppCompatActivity activity4 = getActivity();
        if (activity4 == null) {
            t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(262651);
            throw tVar4;
        }
        this.Uvp = new aq((MMActivity) activity4);
        View findViewById2 = getRootView().findViewById(R.id.k1i);
        p.g(findViewById2, "rootView.findViewById(R.id.pluginLayout)");
        FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout2 = (FestivalFinderLiveVisitorPluginLayout) findViewById2;
        AppCompatActivity activity5 = getActivity();
        if (activity5 == null) {
            t tVar5 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(262651);
            throw tVar5;
        }
        MMActivity mMActivity2 = (MMActivity) activity5;
        Fragment fragment2 = getFragment();
        if (fragment2 != null) {
            lifecycle = fragment2.getLifecycle();
        }
        aq aqVar3 = this.Uvp;
        if (aqVar3 == null) {
            p.hyc();
        }
        this.Uvq = new FestivalFinderLiveViewCallback(festivalFinderLiveVisitorPluginLayout2, mMActivity2, lifecycle, aqVar3, true);
        aq aqVar4 = this.Uvp;
        if (aqVar4 == null) {
            p.hyc();
        }
        FestivalFinderLiveViewCallback festivalFinderLiveViewCallback2 = this.Uvq;
        if (festivalFinderLiveViewCallback2 == null) {
            p.hyc();
        }
        aqVar4.a(festivalFinderLiveViewCallback2);
        gEV().G(24, com.tencent.mm.plugin.ball.f.b.dhB());
        AppMethodBeat.o(262651);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onStart() {
        AppMethodBeat.i(262652);
        Log.i("FestivalFinderLiveVisitorUIC", "[LiveLifecycle]onStart ".concat(String.valueOf(this)));
        super.onStart();
        u.a aVar = u.UyT;
        u.atR(toString());
        gEV().aGf();
        com.tencent.mm.plugin.ball.f.f.cjk();
        AppMethodBeat.o(262652);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        View decorView;
        AppMethodBeat.i(262653);
        Log.i("FestivalFinderLiveVisitorUIC", "[LiveLifecycle]onResume " + this + ',');
        super.onResume();
        Activity context = getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(262653);
            throw tVar;
        }
        Window window = context.getWindow();
        if (!(window == null || (decorView = window.getDecorView()) == null)) {
            decorView.post(new d(this));
        }
        Log.i("FestivalFinderLiveVisitorUIC", "initBusiness");
        FestivalFinderLiveViewCallback festivalFinderLiveViewCallback = this.Uvq;
        if (festivalFinderLiveViewCallback != null) {
            Log.i("MicroMsg.FestivalFinderLiveViewCallback", "[LiveLifecycle]onInit ".concat(String.valueOf(festivalFinderLiveViewCallback)));
            AppMethodBeat.o(262653);
            return;
        }
        AppMethodBeat.o(262653);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ FestivalFinderLiveVisitorUIC Uvt;

        d(FestivalFinderLiveVisitorUIC festivalFinderLiveVisitorUIC) {
            this.Uvt = festivalFinderLiveVisitorUIC;
        }

        public final void run() {
            AppMethodBeat.i(262647);
            if (this.Uvt.gyh == null) {
                FestivalFinderLiveVisitorUIC festivalFinderLiveVisitorUIC = this.Uvt;
                Activity context = this.Uvt.getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(262647);
                    throw tVar;
                }
                festivalFinderLiveVisitorUIC.gyh = new h(context);
                h hVar = this.Uvt.gyh;
                if (hVar != null) {
                    hVar.setKeyboardHeightObserver(new com.tencent.mm.ui.tools.g(this) {
                        /* class com.tencent.mm.plugin.festival.finder.FestivalFinderLiveVisitorUIC.d.AnonymousClass1 */
                        final /* synthetic */ d Uvu;

                        {
                            this.Uvu = r1;
                        }

                        @Override // com.tencent.mm.ui.tools.g
                        public final void y(int i2, boolean z) {
                            AppMethodBeat.i(262646);
                            Log.i("FestivalFinderLiveVisitorUIC", "onKeyboardHeightChanged, height:" + i2 + ", isResized:" + z);
                            FestivalFinderLiveVisitorUIC.a(this.Uvu.Uvt, i2 > 0, i2);
                            AppMethodBeat.o(262646);
                        }
                    });
                }
            }
            h hVar2 = this.Uvt.gyh;
            if (hVar2 != null) {
                hVar2.start();
                AppMethodBeat.o(262647);
                return;
            }
            AppMethodBeat.o(262647);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(262654);
        Log.i("FestivalFinderLiveVisitorUIC", "[LiveLifecycle]onPause " + this + ", " + this.vPT);
        super.onPause();
        this.isPaused = true;
        h hVar = this.gyh;
        if (hVar != null) {
            hVar.close();
        }
        Runnable runnable = this.vPT;
        if (runnable != null) {
            runnable.run();
        }
        this.vPT = null;
        AppMethodBeat.o(262654);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onStop() {
        AppMethodBeat.i(262655);
        Log.i("FestivalFinderLiveVisitorUIC", "[LiveLifecycle]onStop ".concat(String.valueOf(this)));
        super.onStop();
        String festivalFinderLiveVisitorUIC = toString();
        u.a aVar = u.UyT;
        if (Util.isEqual(festivalFinderLiveVisitorUIC, u.diD())) {
            at atVar = at.Uuv;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = at.dfZ();
            if (dfZ == null || dfZ.uDS) {
                gEV().nA(false);
            } else {
                gEV().nA(true);
            }
            com.tencent.mm.plugin.ball.f.f.cji();
        }
        AppMethodBeat.o(262655);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(262656);
        Log.i("FestivalFinderLiveVisitorUIC", "[LiveLifecycle]onDestroy ".concat(String.valueOf(this)));
        super.onDestroy();
        if (!this.vPU) {
            dAn();
        }
        aq aqVar = this.Uvp;
        if (aqVar != null) {
            aqVar.onDetach();
            AppMethodBeat.o(262656);
            return;
        }
        AppMethodBeat.o(262656);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        AppMethodBeat.i(262657);
        Log.i("FestivalFinderLiveVisitorUIC", "[LiveLifecycle]onBackPressed ".concat(String.valueOf(this)));
        FestivalFinderLiveViewCallback festivalFinderLiveViewCallback = this.Uvq;
        if (festivalFinderLiveViewCallback != null) {
            boolean onBackPress = festivalFinderLiveViewCallback.UuE.onBackPress();
            AppMethodBeat.o(262657);
            return onBackPress;
        }
        AppMethodBeat.o(262657);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(262658);
        super.onNewIntent(intent);
        FestivalFinderLiveViewCallback festivalFinderLiveViewCallback = this.Uvq;
        if (festivalFinderLiveViewCallback != null) {
            festivalFinderLiveViewCallback.UuE.onNewIntent(intent);
            AppMethodBeat.o(262658);
            return;
        }
        AppMethodBeat.o(262658);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        String str;
        AppMethodBeat.i(262659);
        FestivalFinderLiveViewCallback festivalFinderLiveViewCallback = this.Uvq;
        if (festivalFinderLiveViewCallback != null) {
            festivalFinderLiveViewCallback.UuE.onActivityResult(i2, i3, intent);
        }
        if (i3 == -1) {
            if (i2 == 1005) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (intent != null) {
                    arrayList = intent.getStringArrayListExtra("SendMsgUsernames");
                    p.g(arrayList, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
                }
                if (!arrayList.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    String str2 = "";
                    Iterator<String> it = arrayList.iterator();
                    while (true) {
                        str = str2;
                        if (!it.hasNext()) {
                            break;
                        }
                        str2 = str + it.next() + ';';
                    }
                    if (n.nm(str, ";")) {
                        int length = str.length() - 1;
                        if (str == null) {
                            t tVar = new t("null cannot be cast to non-null type java.lang.String");
                            AppMethodBeat.o(262659);
                            throw tVar;
                        }
                        str = str.substring(0, length);
                        p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    m.vli.a(str, s.ba.Chat);
                    AppMethodBeat.o(262659);
                    return;
                }
            } else if (i2 == 1006) {
                m.vli.a((String) null, s.ba.Timeline);
            }
        }
        AppMethodBeat.o(262659);
    }

    private final void dAn() {
        AppMethodBeat.i(262660);
        if (this.vPV) {
            AppMethodBeat.o(262660);
            return;
        }
        dei();
        this.vPV = true;
        AppMethodBeat.o(262660);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onBeforeFinish(Intent intent) {
        AppMethodBeat.i(262661);
        super.onBeforeFinish(intent);
        if (this.isPaused) {
            dei();
        } else {
            this.vPT = new c(this);
        }
        this.vPU = true;
        AppMethodBeat.o(262661);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ FestivalFinderLiveVisitorUIC Uvt;

        c(FestivalFinderLiveVisitorUIC festivalFinderLiveVisitorUIC) {
            this.Uvt = festivalFinderLiveVisitorUIC;
        }

        public final void run() {
            AppMethodBeat.i(262645);
            FestivalFinderLiveVisitorUIC.b(this.Uvt);
            AppMethodBeat.o(262645);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(262662);
        p.h(configuration, "newConfig");
        Log.i("FestivalFinderLiveVisitorUIC", "[LiveLifecycle]onConfigurationChanged orientation:" + configuration.orientation);
        super.onConfigurationChanged(configuration);
        AppMethodBeat.o(262662);
    }

    private final void dei() {
        AppMethodBeat.i(262663);
        Log.i("FestivalFinderLiveVisitorUIC", "uninitBusiness");
        FestivalFinderLiveViewCallback festivalFinderLiveViewCallback = this.Uvq;
        if (festivalFinderLiveViewCallback != null) {
            festivalFinderLiveViewCallback.deR();
            AppMethodBeat.o(262663);
            return;
        }
        AppMethodBeat.o(262663);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/festival/model/FestivalPageFloatBallHelper;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<u> {
        final /* synthetic */ FestivalFinderLiveVisitorUIC Uvt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FestivalFinderLiveVisitorUIC festivalFinderLiveVisitorUIC) {
            super(0);
            this.Uvt = festivalFinderLiveVisitorUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ u invoke() {
            AppMethodBeat.i(262644);
            AppCompatActivity activity = this.Uvt.getActivity();
            if (activity == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(262644);
                throw tVar;
            }
            u uVar = new u(new com.tencent.mm.plugin.ball.a.e((MMActivity) activity));
            AppMethodBeat.o(262644);
            return uVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/Window;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends q implements kotlin.g.a.a<Window> {
        final /* synthetic */ FestivalFinderLiveVisitorUIC Uvt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FestivalFinderLiveVisitorUIC festivalFinderLiveVisitorUIC) {
            super(0);
            this.Uvt = festivalFinderLiveVisitorUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Window invoke() {
            AppMethodBeat.i(262648);
            Window window = this.Uvt.getActivity().getWindow();
            AppMethodBeat.o(262648);
            return window;
        }
    }

    public static final /* synthetic */ void a(FestivalFinderLiveVisitorUIC festivalFinderLiveVisitorUIC, boolean z, int i2) {
        AppMethodBeat.i(262666);
        if (festivalFinderLiveVisitorUIC.hwq != z) {
            festivalFinderLiveVisitorUIC.hwq = z;
            FestivalFinderLiveViewCallback festivalFinderLiveViewCallback = festivalFinderLiveVisitorUIC.Uvq;
            if (festivalFinderLiveViewCallback != null) {
                festivalFinderLiveViewCallback.UuE.keyboardChange(z, i2);
                AppMethodBeat.o(262666);
                return;
            }
        }
        AppMethodBeat.o(262666);
    }
}
