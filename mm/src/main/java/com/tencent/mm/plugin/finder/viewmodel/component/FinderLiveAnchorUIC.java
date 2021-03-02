package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout;
import com.tencent.mm.plugin.finder.live.view.j;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\fH\u0016J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020'J\u0018\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020$H\u0002J\"\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020$2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\nH\u0016J\u0012\u00102\u001a\u00020'2\b\u00103\u001a\u0004\u0018\u000100H\u0016J\u0012\u00104\u001a\u00020'2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u00020'H\u0016J\u0012\u00108\u001a\u00020'2\b\u00109\u001a\u0004\u0018\u000100H\u0016J\b\u0010:\u001a\u00020'H\u0016J\b\u0010;\u001a\u00020'H\u0016J\u0012\u0010<\u001a\u00020'2\b\u0010=\u001a\u0004\u0018\u000106H\u0016J\b\u0010>\u001a\u00020'H\u0016J\b\u0010?\u001a\u00020'H\u0016J\u0006\u0010@\u001a\u00020'J\b\u0010A\u001a\u00020'H\u0016J\u0010\u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020DH\u0002J\u0006\u0010E\u001a\u00020'J\b\u0010F\u001a\u00020'H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveAnchorUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "activeFinish", "", "anchorPluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "getAnchorPluginLayout", "()Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "setAnchorPluginLayout", "(Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;)V", "callOnce", "finderLivePageFloatBallHelper", "Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "getFinderLivePageFloatBallHelper", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "setFinderLivePageFloatBallHelper", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;)V", "isKeyBoardShow", "isPaused", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "swipeBack", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "unInitTask", "Ljava/lang/Runnable;", "getLayoutId", "", "getPluginLayout", "initBusiness", "", "initData", "keyboardChange", "show", "height", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onSwipeBack", "setWindowStyle", "setupLiveRoomData", "liveRoomData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "uninitBusiness", "uninitBusinessCheck", "plugin-finder_release"})
public class FinderLiveAnchorUIC extends UIComponent {
    final String TAG = "MicroMsg.FinderLiveAnchorWithoutAffinityUI";
    private h gyh;
    private boolean hwq;
    private boolean isPaused;
    j ubm;
    private Runnable vPT;
    private boolean vPU;
    private boolean vPV;
    FinderBaseLivePluginLayout wya;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveAnchorUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(255751);
        AppMethodBeat.o(255751);
    }

    public static final /* synthetic */ void b(FinderLiveAnchorUIC finderLiveAnchorUIC) {
        AppMethodBeat.i(255753);
        finderLiveAnchorUIC.dAn();
        AppMethodBeat.o(255753);
    }

    public void dIl() {
        AppMethodBeat.i(255736);
        if (getActivity() instanceof MMActivity) {
            AppCompatActivity activity = getActivity();
            if (activity == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255736);
                throw tVar;
            }
            ((MMActivity) activity).setSelfNavigationBarVisible(8);
        }
        getContext().getWindow().addFlags(2097280);
        getContext().getWindow().addFlags(67108864);
        if (Build.VERSION.SDK_INT >= 21) {
            getContext().getWindow().clearFlags(67108864);
            Window window = getContext().getWindow();
            p.g(window, "context.window");
            View decorView = window.getDecorView();
            p.g(decorView, "context.window.decorView");
            decorView.setSystemUiVisibility(1792);
            getContext().getWindow().addFlags(Integer.MIN_VALUE);
            Window window2 = getContext().getWindow();
            p.g(window2, "context.window");
            window2.setStatusBarColor(0);
            Window window3 = getContext().getWindow();
            p.g(window3, "context.window");
            window3.setNavigationBarColor(0);
        }
        getContext().getWindow().setFormat(-3);
        getContext().getWindow().setSoftInputMode(51);
        AppMethodBeat.o(255736);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public int getLayoutId() {
        return R.layout.af9;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(255737);
        super.onNewIntent(intent);
        FinderBaseLivePluginLayout finderBaseLivePluginLayout = this.wya;
        if (finderBaseLivePluginLayout != null) {
            finderBaseLivePluginLayout.onNewIntent(intent);
            AppMethodBeat.o(255737);
            return;
        }
        AppMethodBeat.o(255737);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ FinderLiveAnchorUIC wyb;

        b(FinderLiveAnchorUIC finderLiveAnchorUIC) {
            this.wyb = finderLiveAnchorUIC;
        }

        public final void run() {
            AppMethodBeat.i(261566);
            FinderBaseLivePluginLayout finderBaseLivePluginLayout = this.wyb.wya;
            if (finderBaseLivePluginLayout != null) {
                b.C0376b.a(finderBaseLivePluginLayout, b.c.hLR);
                AppMethodBeat.o(261566);
                return;
            }
            AppMethodBeat.o(261566);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(255739);
        super.onSaveInstanceState(bundle);
        String str = this.TAG;
        StringBuilder append = new StringBuilder("[LiveLifecycle] onSaveInstanceState ").append(this).append(" curData:");
        o oVar = o.ujN;
        Log.i(str, append.append(o.dfZ()).toString());
        o oVar2 = o.ujN;
        g dfZ = o.dfZ();
        if (dfZ != null) {
            LiveConfig aBR = new LiveConfig.a().qo(LiveConfig.hvT).zt(dfZ.liveInfo.liveId).Gd(dfZ.hwg).zu(dfZ.hFK).Gg(dfZ.hwd).Gh(dfZ.desc).aBR();
            p.g(aBR, "builder.toWhere(LiveConf…\n                .build()");
            FinderLiveConfig finderLiveConfig = new FinderLiveConfig();
            finderLiveConfig.uiu.add(aBR);
            if (bundle != null) {
                bundle.putParcelable("KEY_PARAMS_CONFIG", finderLiveConfig);
            }
            if (bundle != null) {
                awt awt = finderLiveConfig.uiv;
                bundle.putByteArray("KEY_PARAMS_NOTICE", awt != null ? awt.toByteArray() : null);
                AppMethodBeat.o(255739);
                return;
            }
            AppMethodBeat.o(255739);
            return;
        }
        AppMethodBeat.o(255739);
    }

    public FinderBaseLivePluginLayout dIk() {
        AppMethodBeat.i(255740);
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255740);
            throw tVar;
        }
        com.tencent.mm.plugin.finder.live.view.a aVar = new com.tencent.mm.plugin.finder.live.view.a((MMActivity) activity);
        AppMethodBeat.o(255740);
        return aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ FinderLiveAnchorUIC wyb;

        c(FinderLiveAnchorUIC finderLiveAnchorUIC) {
            this.wyb = finderLiveAnchorUIC;
        }

        public final void run() {
            AppMethodBeat.i(255735);
            if (this.wyb.gyh == null) {
                FinderLiveAnchorUIC finderLiveAnchorUIC = this.wyb;
                Activity context = this.wyb.getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(255735);
                    throw tVar;
                }
                finderLiveAnchorUIC.gyh = new h(context);
                h hVar = this.wyb.gyh;
                if (hVar != null) {
                    hVar.setKeyboardHeightObserver(new com.tencent.mm.ui.tools.g(this) {
                        /* class com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveAnchorUIC.c.AnonymousClass1 */
                        final /* synthetic */ c wyc;

                        {
                            this.wyc = r1;
                        }

                        @Override // com.tencent.mm.ui.tools.g
                        public final void y(int i2, boolean z) {
                            AppMethodBeat.i(255734);
                            Log.i(this.wyc.wyb.TAG, "onKeyboardHeightChanged, height:" + i2 + ", isResized:" + z);
                            FinderLiveAnchorUIC.a(this.wyc.wyb, i2 > 0, i2);
                            AppMethodBeat.o(255734);
                        }
                    });
                }
            }
            h hVar2 = this.wyb.gyh;
            if (hVar2 != null) {
                hVar2.start();
                AppMethodBeat.o(255735);
                return;
            }
            AppMethodBeat.o(255735);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(255747);
        super.onActivityResult(i2, i3, intent);
        FinderBaseLivePluginLayout finderBaseLivePluginLayout = this.wya;
        if (finderBaseLivePluginLayout != null) {
            finderBaseLivePluginLayout.onActivityResult(i2, i3, intent);
            AppMethodBeat.o(255747);
            return;
        }
        AppMethodBeat.o(255747);
    }

    private final void dAn() {
        AppMethodBeat.i(255748);
        if (this.vPV) {
            AppMethodBeat.o(255748);
            return;
        }
        dei();
        this.vPV = true;
        AppMethodBeat.o(255748);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onBeforeFinish(Intent intent) {
        AppMethodBeat.i(255750);
        super.onBeforeFinish(intent);
        if (this.isPaused) {
            dei();
        } else {
            this.vPT = new a(this);
        }
        this.vPU = true;
        AppMethodBeat.o(255750);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ FinderLiveAnchorUIC wyb;

        a(FinderLiveAnchorUIC finderLiveAnchorUIC) {
            this.wyb = finderLiveAnchorUIC;
        }

        public final void run() {
            AppMethodBeat.i(255732);
            FinderLiveAnchorUIC.b(this.wyb);
            AppMethodBeat.o(255732);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x016d  */
    @Override // com.tencent.mm.ui.component.UIComponent
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r13) {
        /*
        // Method dump skipped, instructions count: 759
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveAnchorUIC.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onStart() {
        AppMethodBeat.i(255741);
        String str = this.TAG;
        StringBuilder append = new StringBuilder("[LiveLifecycler]onStart ").append(this).append(", activateUIKey:");
        j.a aVar = j.uzS;
        Log.i(str, append.append(j.uzR).toString());
        super.onStart();
        j.a aVar2 = j.uzS;
        j.uzR = toString();
        FinderBaseLivePluginLayout finderBaseLivePluginLayout = this.wya;
        if (finderBaseLivePluginLayout != null) {
            finderBaseLivePluginLayout.start();
        }
        j jVar = this.ubm;
        if (jVar != null) {
            jVar.aGf();
        }
        f.cjk();
        AppMethodBeat.o(255741);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onResume() {
        AppMethodBeat.i(255742);
        Log.i(this.TAG, "[LiveLifecycler]onResume ".concat(String.valueOf(this)));
        super.onResume();
        FinderBaseLivePluginLayout finderBaseLivePluginLayout = this.wya;
        if (finderBaseLivePluginLayout != null) {
            finderBaseLivePluginLayout.resume();
        }
        FinderBaseLivePluginLayout finderBaseLivePluginLayout2 = this.wya;
        if (finderBaseLivePluginLayout2 != null) {
            finderBaseLivePluginLayout2.post(new c(this));
        }
        Log.i(this.TAG, "[LiveLifecycler]initBusiness ".concat(String.valueOf(this)));
        AppMethodBeat.o(255742);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onPause() {
        AppMethodBeat.i(255743);
        Log.i(this.TAG, "[LiveLifecycler]onPause ".concat(String.valueOf(this)));
        super.onPause();
        h hVar = this.gyh;
        if (hVar != null) {
            hVar.close();
        }
        FinderBaseLivePluginLayout finderBaseLivePluginLayout = this.wya;
        if (finderBaseLivePluginLayout != null) {
            finderBaseLivePluginLayout.pause();
        }
        this.isPaused = true;
        Runnable runnable = this.vPT;
        if (runnable != null) {
            runnable.run();
        }
        this.vPT = null;
        AppMethodBeat.o(255743);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onStop() {
        AppMethodBeat.i(255744);
        String str = this.TAG;
        StringBuilder append = new StringBuilder("[LiveLifecycler]onStop ").append(this).append(", activateUIKey:");
        j.a aVar = j.uzS;
        Log.i(str, append.append(j.uzR).toString());
        super.onStop();
        j.a aVar2 = j.uzS;
        if (Util.isEqual(j.uzR, toString())) {
            FinderBaseLivePluginLayout finderBaseLivePluginLayout = this.wya;
            if (finderBaseLivePluginLayout != null) {
                finderBaseLivePluginLayout.stop();
            }
            o oVar = o.ujN;
            g dfZ = o.dfZ();
            if (dfZ == null) {
                AppMethodBeat.o(255744);
                return;
            } else if (dfZ.uDS) {
                j jVar = this.ubm;
                if (jVar != null) {
                    jVar.aGj();
                }
                f.cji();
            }
        }
        AppMethodBeat.o(255744);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onDestroy() {
        AppMethodBeat.i(255745);
        Log.i(this.TAG, "[LiveLifecycler]onDestroy ".concat(String.valueOf(this)));
        super.onDestroy();
        j jVar = this.ubm;
        if (jVar != null) {
            jVar.onDestroy();
        }
        if (!this.vPU) {
            dAn();
        }
        AppMethodBeat.o(255745);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public boolean onBackPressed() {
        AppMethodBeat.i(255746);
        Log.i(this.TAG, "[LiveLifecycler]onBackPressed ".concat(String.valueOf(this)));
        FinderBaseLivePluginLayout finderBaseLivePluginLayout = this.wya;
        if (finderBaseLivePluginLayout != null) {
            boolean onBackPress = finderBaseLivePluginLayout.onBackPress();
            AppMethodBeat.o(255746);
            return onBackPress;
        }
        AppMethodBeat.o(255746);
        return false;
    }

    private void dei() {
        AppMethodBeat.i(255749);
        Log.i(this.TAG, "[LiveLifecycler]uninitBusiness ".concat(String.valueOf(this)));
        FinderBaseLivePluginLayout finderBaseLivePluginLayout = this.wya;
        if (finderBaseLivePluginLayout != null) {
            finderBaseLivePluginLayout.unMount();
            AppMethodBeat.o(255749);
            return;
        }
        AppMethodBeat.o(255749);
    }

    public static final /* synthetic */ void a(FinderLiveAnchorUIC finderLiveAnchorUIC, boolean z, int i2) {
        AppMethodBeat.i(255752);
        if (finderLiveAnchorUIC.hwq != z) {
            finderLiveAnchorUIC.hwq = z;
            FinderBaseLivePluginLayout finderBaseLivePluginLayout = finderLiveAnchorUIC.wya;
            if (finderBaseLivePluginLayout != null) {
                finderBaseLivePluginLayout.keyboardChange(z, i2);
                AppMethodBeat.o(255752);
                return;
            }
        }
        AppMethodBeat.o(255752);
    }
}
