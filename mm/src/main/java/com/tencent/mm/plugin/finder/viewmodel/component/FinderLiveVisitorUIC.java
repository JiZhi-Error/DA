package com.tencent.mm.plugin.finder.viewmodel.component;

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
import com.tencent.mm.ac.f;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.finder.live.FinderLiveViewCallback;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.view.j;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 E2\u00020\u0001:\u0001EB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\"\u001a\u00020\u000fH\u0016J\b\u0010#\u001a\u0004\u0018\u00010\u001aJ\b\u0010$\u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u000fH\u0002J\"\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\u0006H\u0016J\u0012\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00101\u001a\u00020%2\u0006\u00102\u001a\u000203H\u0016J\u0012\u00104\u001a\u00020%2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u00020%H\u0016J\u0012\u00108\u001a\u00020%2\b\u00109\u001a\u0004\u0018\u00010-H\u0016J\b\u0010:\u001a\u00020%H\u0016J\u0012\u0010;\u001a\u00020%2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010<\u001a\u00020%H\u0016J\u0012\u0010=\u001a\u00020%2\b\u0010>\u001a\u0004\u0018\u000106H\u0016J\b\u0010?\u001a\u00020%H\u0016J\b\u0010@\u001a\u00020%H\u0016J\u0006\u0010A\u001a\u00020%J\b\u0010B\u001a\u00020%H\u0002J\b\u0010C\u001a\u00020%H\u0002J\b\u0010D\u001a\u00020%H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R#\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8FX\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f¨\u0006F"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveVisitorUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "activeFinish", "", "callOnce", "finderLivePageFloatBallHelper", "Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "isKeyBoardShow", "isPaused", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "lastKeyBoardHeight", "", "presenter", "Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter;", "swipeBack", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "unInitTask", "Ljava/lang/Runnable;", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;", "window", "Landroid/view/Window;", "kotlin.jvm.PlatformType", "getWindow", "()Landroid/view/Window;", "window$delegate", "Lkotlin/Lazy;", "getLayoutId", "getViewCallback", "initBusiness", "", "keyboardChange", "show", "height", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onSwipeBack", "setWindowStyle", "uninitBusiness", "uninitBusinessCheck", "Companion", "plugin-finder_release"})
public class FinderLiveVisitorUIC extends UIComponent {
    public static final a wyD = new a((byte) 0);
    private h gyh;
    private int hgz;
    private boolean hwq;
    private boolean isPaused;
    private com.tencent.mm.plugin.finder.live.d ubD;
    private FinderLiveViewCallback ubE;
    private j ubm;
    private Runnable vPT;
    private boolean vPU;
    private boolean vPV;
    private final f wyC = g.ah(new d(this));

    static {
        AppMethodBeat.i(255820);
        AppMethodBeat.o(255820);
    }

    private Window getWindow() {
        AppMethodBeat.i(255803);
        Window window = (Window) this.wyC.getValue();
        AppMethodBeat.o(255803);
        return window;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveVisitorUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(255819);
        AppMethodBeat.o(255819);
    }

    public static final /* synthetic */ void b(FinderLiveVisitorUIC finderLiveVisitorUIC) {
        AppMethodBeat.i(255822);
        finderLiveVisitorUIC.dAn();
        AppMethodBeat.o(255822);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveVisitorUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public int getLayoutId() {
        return R.layout.af9;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onCreate(Bundle bundle) {
        boolean z;
        ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.c> arrayList;
        com.tencent.mm.plugin.finder.live.viewmodel.c cVar;
        LiveConfig liveConfig;
        String str;
        ArrayList<LiveConfig> arrayList2;
        LiveConfig liveConfig2;
        LiveConfig dfu;
        LiveConfig dfu2;
        awe awe;
        AppMethodBeat.i(255804);
        super.onCreate(bundle);
        if (getActivity() instanceof MMActivity) {
            AppCompatActivity activity = getActivity();
            if (activity == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255804);
                throw tVar;
            }
            ((MMActivity) activity).setSelfNavigationBarVisible(8);
        }
        getWindow().addFlags(2097280);
        getWindow().addFlags(67108864);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(1024);
            getWindow().clearFlags(512);
            getWindow().clearFlags(67108864);
            Resources resources = getContext().getResources();
            p.g(resources, "context.resources");
            if (resources.getConfiguration().orientation == 2) {
                Window window = getWindow();
                p.g(window, "window");
                View decorView = window.getDecorView();
                p.g(decorView, "window.decorView");
                decorView.setSystemUiVisibility(7942);
                getWindow().addFlags(1024);
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
        boolean booleanExtra = getIntent().getBooleanExtra("KEY_PARAMS_RESET_LIVE", false);
        o oVar = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
        long j2 = (dfZ == null || (awe = dfZ.liveInfo) == null) ? 0 : awe.liveId;
        StringBuilder append = new StringBuilder("[LiveLifecycle] onCreate comeFromReset:").append(booleanExtra).append(",configProvider is null:");
        if (finderLiveConfig == null) {
            z = true;
        } else {
            z = false;
        }
        Log.i("Finder.FinderLiveVisitorUIC", append.append(z).append(",config liveId:").append((finderLiveConfig == null || (dfu2 = finderLiveConfig.dfu()) == null) ? null : Long.valueOf(dfu2.getLiveId())).append(", across_live ").append(j2).toString());
        if (finderLiveConfig != null && (((dfu = finderLiveConfig.dfu()) == null || dfu.getLiveId() != j2) && !booleanExtra)) {
            o oVar2 = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.d dVar = new com.tencent.mm.plugin.finder.live.viewmodel.d();
            dVar.a(finderLiveConfig);
            o.b(dVar);
            this.ubD = new com.tencent.mm.plugin.finder.live.d();
            View findViewById = getRootView().findViewById(R.id.cxa);
            p.g(findViewById, "rootView.findViewById(R.id.finder_live_rf)");
            RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) findViewById;
            AppCompatActivity activity2 = getActivity();
            if (activity2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255804);
                throw tVar2;
            }
            MMActivity mMActivity = (MMActivity) activity2;
            Fragment fragment = getFragment();
            FinderLiveViewCallback finderLiveViewCallback = new FinderLiveViewCallback(refreshLoadMoreLayout, mMActivity, fragment != null ? fragment.getLifecycle() : null, this.ubD, false);
            com.tencent.mm.plugin.finder.live.d dVar2 = this.ubD;
            if (dVar2 != null) {
                dVar2.a(finderLiveViewCallback);
            }
            this.ubE = finderLiveViewCallback;
        } else if (j2 != 0) {
            o oVar3 = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.d dfY = o.dfY();
            if (dfY != null) {
                o oVar4 = o.ujN;
                dfY.Jq(o.dga());
            }
            o oVar5 = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.d dfY2 = o.dfY();
            if (!(dfY2 == null || (arrayList = dfY2.uCu) == null || (cVar = (com.tencent.mm.plugin.finder.live.viewmodel.c) kotlin.a.j.kt(arrayList)) == null || (liveConfig = cVar.uCr) == null)) {
                if (finderLiveConfig == null || (arrayList2 = finderLiveConfig.uiu) == null || (liveConfig2 = (LiveConfig) kotlin.a.j.kt(arrayList2)) == null || (str = liveConfig2.aFR()) == null) {
                    str = "";
                }
                liveConfig.bxe(str);
            }
            this.ubD = new com.tencent.mm.plugin.finder.live.d();
            View findViewById2 = getRootView().findViewById(R.id.cxa);
            p.g(findViewById2, "rootView.findViewById(R.id.finder_live_rf)");
            RefreshLoadMoreLayout refreshLoadMoreLayout2 = (RefreshLoadMoreLayout) findViewById2;
            AppCompatActivity activity3 = getActivity();
            if (activity3 == null) {
                t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255804);
                throw tVar3;
            }
            MMActivity mMActivity2 = (MMActivity) activity3;
            Fragment fragment2 = getFragment();
            FinderLiveViewCallback finderLiveViewCallback2 = new FinderLiveViewCallback(refreshLoadMoreLayout2, mMActivity2, fragment2 != null ? fragment2.getLifecycle() : null, this.ubD, true);
            com.tencent.mm.plugin.finder.live.d dVar3 = this.ubD;
            if (dVar3 != null) {
                dVar3.a(finderLiveViewCallback2);
            }
            this.ubE = finderLiveViewCallback2;
        } else {
            f.a.a(com.tencent.mm.plugin.finder.utils.c.vVc, "liveVisitorUIParamsInvalid", false, false, null, 28);
            Log.i("Finder.FinderLiveVisitorUIC", "onCreate err stack:" + Util.getStack());
        }
        AppCompatActivity activity4 = getActivity();
        if (activity4 == null) {
            t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255804);
            throw tVar4;
        }
        this.ubm = new j(new e((MMActivity) activity4));
        j jVar = this.ubm;
        if (jVar != null) {
            jVar.G(21, com.tencent.mm.plugin.ball.f.b.cjf());
            AppMethodBeat.o(255804);
            return;
        }
        AppMethodBeat.o(255804);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(255805);
        super.onSaveInstanceState(bundle);
        StringBuilder append = new StringBuilder("[LiveLifecycle] onSaveInstanceState ").append(this).append(" curData:");
        o oVar = o.ujN;
        Log.i("Finder.FinderLiveVisitorUIC", append.append(o.dfZ()).toString());
        o oVar2 = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
        if (dfZ != null) {
            LiveConfig aBR = new LiveConfig.a().qo(LiveConfig.hvU).zt(dfZ.liveInfo.liveId).Gd(dfZ.hwg).zu(dfZ.hFK).Gg(dfZ.hwd).Gh(dfZ.desc).aBR();
            p.g(aBR, "builder.toWhere(LiveConf…\n                .build()");
            FinderLiveConfig finderLiveConfig = new FinderLiveConfig();
            finderLiveConfig.uiu.add(aBR);
            if (bundle != null) {
                bundle.putParcelable("KEY_PARAMS_CONFIG", finderLiveConfig);
                AppMethodBeat.o(255805);
                return;
            }
            AppMethodBeat.o(255805);
            return;
        }
        AppMethodBeat.o(255805);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onRestoreInstanceState(Bundle bundle) {
        long j2;
        LiveConfig dfu;
        awe awe;
        Lifecycle lifecycle = null;
        AppMethodBeat.i(255806);
        super.onRestoreInstanceState(bundle);
        FinderLiveConfig finderLiveConfig = bundle != null ? (FinderLiveConfig) bundle.getParcelable("KEY_PARAMS_CONFIG") : null;
        FinderLiveConfig finderLiveConfig2 = (FinderLiveConfig) getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
        o oVar = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
        if (dfZ == null || (awe = dfZ.liveInfo) == null) {
            j2 = 0;
        } else {
            j2 = awe.liveId;
        }
        Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle] onRestoreInstanceState " + this + " configProvider:" + finderLiveConfig2 + " restoreConfigProvider:" + finderLiveConfig + " curLiveId:" + j2);
        if (finderLiveConfig2 == null && j2 == 0 && finderLiveConfig != null && ((dfu = finderLiveConfig.dfu()) == null || dfu.getLiveId() != 0)) {
            o oVar2 = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.d dVar = new com.tencent.mm.plugin.finder.live.viewmodel.d();
            dVar.a(finderLiveConfig);
            o.b(dVar);
            this.ubD = new com.tencent.mm.plugin.finder.live.d();
            View findViewById = getRootView().findViewById(R.id.cxa);
            p.g(findViewById, "rootView.findViewById(R.id.finder_live_rf)");
            RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) findViewById;
            AppCompatActivity activity = getActivity();
            if (activity == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255806);
                throw tVar;
            }
            MMActivity mMActivity = (MMActivity) activity;
            Fragment fragment = getFragment();
            if (fragment != null) {
                lifecycle = fragment.getLifecycle();
            }
            FinderLiveViewCallback finderLiveViewCallback = new FinderLiveViewCallback(refreshLoadMoreLayout, mMActivity, lifecycle, this.ubD, false);
            com.tencent.mm.plugin.finder.live.d dVar2 = this.ubD;
            if (dVar2 != null) {
                dVar2.a(finderLiveViewCallback);
            }
            this.ubE = finderLiveViewCallback;
        }
        AppMethodBeat.o(255806);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onStart() {
        AppMethodBeat.i(255807);
        StringBuilder append = new StringBuilder("[LiveLifecycle]onStart ").append(this).append(", activateUIKey:");
        j.a aVar = j.uzS;
        Log.i("Finder.FinderLiveVisitorUIC", append.append(j.uzR).toString());
        super.onStart();
        j.a aVar2 = j.uzS;
        j.uzR = toString();
        j jVar = this.ubm;
        if (jVar != null) {
            jVar.aGf();
        }
        com.tencent.mm.plugin.ball.f.f.cjk();
        AppMethodBeat.o(255807);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onResume() {
        View decorView;
        AppMethodBeat.i(255808);
        Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle]onResume " + this + ',');
        super.onResume();
        Activity context = getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(255808);
            throw tVar;
        }
        Window window = context.getWindow();
        if (!(window == null || (decorView = window.getDecorView()) == null)) {
            decorView.post(new c(this));
        }
        Log.i("Finder.FinderLiveVisitorUIC", "initBusiness");
        FinderLiveViewCallback finderLiveViewCallback = this.ubE;
        if (finderLiveViewCallback != null) {
            finderLiveViewCallback.MC();
            AppMethodBeat.o(255808);
            return;
        }
        AppMethodBeat.o(255808);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ FinderLiveVisitorUIC wyE;

        c(FinderLiveVisitorUIC finderLiveVisitorUIC) {
            this.wyE = finderLiveVisitorUIC;
        }

        public final void run() {
            AppMethodBeat.i(255801);
            if (this.wyE.gyh == null) {
                FinderLiveVisitorUIC finderLiveVisitorUIC = this.wyE;
                Activity context = this.wyE.getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(255801);
                    throw tVar;
                }
                finderLiveVisitorUIC.gyh = new h(context);
                h hVar = this.wyE.gyh;
                if (hVar != null) {
                    hVar.setKeyboardHeightObserver(new com.tencent.mm.ui.tools.g(this) {
                        /* class com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveVisitorUIC.c.AnonymousClass1 */
                        final /* synthetic */ c wyF;

                        {
                            this.wyF = r1;
                        }

                        @Override // com.tencent.mm.ui.tools.g
                        public final void y(int i2, boolean z) {
                            AppMethodBeat.i(255800);
                            Log.i("Finder.FinderLiveVisitorUIC", "onKeyboardHeightChanged, height:" + i2 + ", isResized:" + z);
                            FinderLiveVisitorUIC.a(this.wyF.wyE, i2 > 0, i2);
                            AppMethodBeat.o(255800);
                        }
                    });
                }
            }
            h hVar2 = this.wyE.gyh;
            if (hVar2 != null) {
                hVar2.start();
                AppMethodBeat.o(255801);
                return;
            }
            AppMethodBeat.o(255801);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onPause() {
        AppMethodBeat.i(255809);
        Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle]onPause " + this + ", " + this.vPT);
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
        AppMethodBeat.o(255809);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onStop() {
        AppMethodBeat.i(255810);
        StringBuilder append = new StringBuilder("[LiveLifecycle]onStop ").append(this).append(", activateUIKey:");
        j.a aVar = j.uzS;
        Log.i("Finder.FinderLiveVisitorUIC", append.append(j.uzR).toString());
        super.onStop();
        String finderLiveVisitorUIC = toString();
        j.a aVar2 = j.uzS;
        if (Util.isEqual(finderLiveVisitorUIC, j.uzR)) {
            o oVar = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
            if (dfZ == null || dfZ.uDS) {
                j jVar = this.ubm;
                if (jVar != null) {
                    jVar.nA(false);
                }
            } else {
                j jVar2 = this.ubm;
                if (jVar2 != null) {
                    jVar2.nA(true);
                }
            }
            com.tencent.mm.plugin.ball.f.f.cji();
        }
        AppMethodBeat.o(255810);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onDestroy() {
        AppMethodBeat.i(255811);
        Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle]onDestroy ".concat(String.valueOf(this)));
        super.onDestroy();
        if (!this.vPU) {
            dAn();
        }
        com.tencent.mm.plugin.finder.live.d dVar = this.ubD;
        if (dVar != null) {
            dVar.onDetach();
        }
        j jVar = this.ubm;
        if (jVar != null) {
            jVar.onDestroy();
            AppMethodBeat.o(255811);
            return;
        }
        AppMethodBeat.o(255811);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public boolean onBackPressed() {
        AppMethodBeat.i(255812);
        Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle]onBackPressed ".concat(String.valueOf(this)));
        FinderLiveViewCallback finderLiveViewCallback = this.ubE;
        if (finderLiveViewCallback != null) {
            boolean onBackPressed = finderLiveViewCallback.onBackPressed();
            AppMethodBeat.o(255812);
            return onBackPressed;
        }
        AppMethodBeat.o(255812);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(255813);
        super.onNewIntent(intent);
        FinderLiveViewCallback finderLiveViewCallback = this.ubE;
        if (finderLiveViewCallback != null) {
            finderLiveViewCallback.onNewIntent(intent);
            AppMethodBeat.o(255813);
            return;
        }
        AppMethodBeat.o(255813);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        String str;
        AppMethodBeat.i(255814);
        FinderLiveViewCallback finderLiveViewCallback = this.ubE;
        if (finderLiveViewCallback != null) {
            finderLiveViewCallback.onActivityResult(i2, i3, intent);
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
                            AppMethodBeat.o(255814);
                            throw tVar;
                        }
                        str = str.substring(0, length);
                        p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    m.vli.a(str, s.ba.Chat);
                    AppMethodBeat.o(255814);
                    return;
                }
            } else if (i2 == 1006) {
                m.vli.a((String) null, s.ba.Timeline);
            }
        }
        AppMethodBeat.o(255814);
    }

    private final void dAn() {
        AppMethodBeat.i(255815);
        if (this.vPV) {
            AppMethodBeat.o(255815);
            return;
        }
        dei();
        this.vPV = true;
        AppMethodBeat.o(255815);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onBeforeFinish(Intent intent) {
        AppMethodBeat.i(255816);
        super.onBeforeFinish(intent);
        if (this.isPaused) {
            dei();
        } else {
            this.vPT = new b(this);
        }
        this.vPU = true;
        AppMethodBeat.o(255816);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ FinderLiveVisitorUIC wyE;

        b(FinderLiveVisitorUIC finderLiveVisitorUIC) {
            this.wyE = finderLiveVisitorUIC;
        }

        public final void run() {
            AppMethodBeat.i(255799);
            FinderLiveVisitorUIC.b(this.wyE);
            AppMethodBeat.o(255799);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(255817);
        p.h(configuration, "newConfig");
        Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle]onConfigurationChanged orientation:" + configuration.orientation);
        super.onConfigurationChanged(configuration);
        AppMethodBeat.o(255817);
    }

    private final void dei() {
        AppMethodBeat.i(255818);
        Log.i("Finder.FinderLiveVisitorUIC", "uninitBusiness");
        FinderLiveViewCallback finderLiveViewCallback = this.ubE;
        if (finderLiveViewCallback != null) {
            finderLiveViewCallback.deR();
            AppMethodBeat.o(255818);
            return;
        }
        AppMethodBeat.o(255818);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/Window;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.a<Window> {
        final /* synthetic */ FinderLiveVisitorUIC wyE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderLiveVisitorUIC finderLiveVisitorUIC) {
            super(0);
            this.wyE = finderLiveVisitorUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Window invoke() {
            AppMethodBeat.i(255802);
            Window window = this.wyE.getActivity().getWindow();
            AppMethodBeat.o(255802);
            return window;
        }
    }

    public static final /* synthetic */ void a(FinderLiveVisitorUIC finderLiveVisitorUIC, boolean z, int i2) {
        AppMethodBeat.i(255821);
        if (!(finderLiveVisitorUIC.hwq == z && finderLiveVisitorUIC.hgz == i2)) {
            finderLiveVisitorUIC.hgz = i2;
            finderLiveVisitorUIC.hwq = z;
            FinderLiveViewCallback finderLiveViewCallback = finderLiveVisitorUIC.ubE;
            if (finderLiveViewCallback != null) {
                finderLiveViewCallback.keyboardChange(z, i2);
                AppMethodBeat.o(255821);
                return;
            }
        }
        AppMethodBeat.o(255821);
    }
}
