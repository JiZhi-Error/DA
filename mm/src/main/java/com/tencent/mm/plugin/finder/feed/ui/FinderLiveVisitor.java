package com.tencent.mm.plugin.finder.feed.ui;

import android.arch.lifecycle.Lifecycle;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.finder.live.FinderLiveViewCallback;
import com.tencent.mm.plugin.finder.live.d;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.view.j;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0013H\u0002J\"\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\u0012\u0010\u001f\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0015H\u0014J\u0012\u0010#\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010%\u001a\u00020\u0015H\u0014J\b\u0010&\u001a\u00020\u0015H\u0014J\b\u0010'\u001a\u00020\u0015H\u0016J\b\u0010(\u001a\u00020\u0015H\u0014J\b\u0010)\u001a\u00020\u0015H\u0016J\b\u0010*\u001a\u00020\u0015H\u0002J\b\u0010+\u001a\u00020\u0015H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveVisitor;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "finderLivePageFloatBallHelper", "Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "isKeyBoardShow", "", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "presenter", "Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter;", "swipeBack", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;", "getLayoutId", "", "initBusiness", "", "keyboardChange", "show", "height", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "setWindowStyle", "uninitBusiness", "Companion", "plugin-finder_release"})
public abstract class FinderLiveVisitor extends MMFinderUI {
    public static final a ubF = new a((byte) 0);
    private HashMap _$_findViewCache;
    private h gyh;
    private boolean hwq;
    private d ubD;
    private FinderLiveViewCallback ubE;
    private j ubm;
    public boolean ubn;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveVisitor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.af9;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        FinderLiveViewCallback finderLiveViewCallback = this.ubE;
        if (finderLiveViewCallback != null) {
            finderLiveViewCallback.onNewIntent(intent);
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        LiveConfig dfu;
        awe awe;
        Log.i("Finder.FinderLiveVisitorUI", "[LiveLifecycle]onCreate " + this + ", lifecycleOwner:" + getLifecycle());
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        setSelfNavigationBarVisible(8);
        getWindow().addFlags(2097280);
        getWindow().addFlags(67108864);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(67108864);
            Window window = getWindow();
            p.g(window, "window");
            View decorView = window.getDecorView();
            p.g(decorView, "window.decorView");
            decorView.setSystemUiVisibility(1792);
            getWindow().addFlags(Integer.MIN_VALUE);
            Window window2 = getWindow();
            p.g(window2, "window");
            window2.setStatusBarColor(0);
            Window window3 = getWindow();
            p.g(window3, "window");
            window3.setNavigationBarColor(0);
        }
        getWindow().setFormat(-3);
        getWindow().setSoftInputMode(51);
        FinderLiveConfig finderLiveConfig = (FinderLiveConfig) getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
        o oVar = o.ujN;
        g dfZ = o.dfZ();
        long j2 = (dfZ == null || (awe = dfZ.liveInfo) == null) ? 0 : awe.liveId;
        Log.i("Finder.FinderLiveVisitorUI", "FinderLiveVisitorUI onCreate across_live ".concat(String.valueOf(j2)));
        if (finderLiveConfig != null && ((dfu = finderLiveConfig.dfu()) == null || dfu.getLiveId() != j2)) {
            o oVar2 = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.d dVar = new com.tencent.mm.plugin.finder.live.viewmodel.d();
            dVar.a(finderLiveConfig);
            o.b(dVar);
            this.ubD = new d();
            View findViewById = findViewById(R.id.cxa);
            p.g(findViewById, "findViewById(R.id.finder_live_rf)");
            RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) findViewById;
            FinderLiveVisitor finderLiveVisitor = this;
            Lifecycle lifecycle = getLifecycle();
            d dVar2 = this.ubD;
            if (dVar2 == null) {
                p.hyc();
            }
            this.ubE = new FinderLiveViewCallback(refreshLoadMoreLayout, finderLiveVisitor, lifecycle, dVar2, false);
            d dVar3 = this.ubD;
            if (dVar3 == null) {
                p.hyc();
            }
            FinderLiveViewCallback finderLiveViewCallback = this.ubE;
            if (finderLiveViewCallback == null) {
                p.hyc();
            }
            dVar3.a(finderLiveViewCallback);
        } else if (j2 != 0) {
            o oVar3 = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.d dfY = o.dfY();
            if (dfY != null) {
                o oVar4 = o.ujN;
                dfY.Jq(o.dga());
            }
            this.ubD = new d();
            View findViewById2 = findViewById(R.id.cxa);
            p.g(findViewById2, "findViewById(R.id.finder_live_rf)");
            RefreshLoadMoreLayout refreshLoadMoreLayout2 = (RefreshLoadMoreLayout) findViewById2;
            FinderLiveVisitor finderLiveVisitor2 = this;
            Lifecycle lifecycle2 = getLifecycle();
            d dVar4 = this.ubD;
            if (dVar4 == null) {
                p.hyc();
            }
            this.ubE = new FinderLiveViewCallback(refreshLoadMoreLayout2, finderLiveVisitor2, lifecycle2, dVar4, true);
            d dVar5 = this.ubD;
            if (dVar5 == null) {
                p.hyc();
            }
            FinderLiveViewCallback finderLiveViewCallback2 = this.ubE;
            if (finderLiveViewCallback2 == null) {
                p.hyc();
            }
            dVar5.a(finderLiveViewCallback2);
        } else {
            StringBuilder append = new StringBuilder("onCreate with invalid params [curLiveId:").append(j2).append(", FinderLiveService.curLiveRoomData:");
            o oVar5 = o.ujN;
            StringBuilder append2 = append.append(o.dfZ()).append(", FinderLiveService.liveData:");
            o oVar6 = o.ujN;
            Log.w("Finder.FinderLiveVisitorUI", append2.append(o.dfY()).append(']').toString());
        }
        this.ubm = new j(new e(this));
        j jVar = this.ubm;
        if (jVar != null) {
            jVar.G(21, com.tencent.mm.plugin.ball.f.b.cjf());
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        Log.i("Finder.FinderLiveVisitorUI", "[LiveLifecycle]onStart " + this + ", lifecycleOwner:" + getLifecycle());
        super.onStart();
        j jVar = this.ubm;
        if (jVar != null) {
            jVar.aGf();
        }
        f.cjk();
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        View decorView;
        Log.i("Finder.FinderLiveVisitorUI", "[LiveLifecycle]onResume " + this + ", lifecycleOwner:" + getLifecycle());
        super.onResume();
        AppCompatActivity context = getContext();
        if (context == null) {
            throw new t("null cannot be cast to non-null type android.app.Activity");
        }
        Window window = context.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.post(new b(this));
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ FinderLiveVisitor ubG;

        b(FinderLiveVisitor finderLiveVisitor) {
            this.ubG = finderLiveVisitor;
        }

        public final void run() {
            AppMethodBeat.i(245395);
            if (this.ubG.gyh == null) {
                FinderLiveVisitor finderLiveVisitor = this.ubG;
                AppCompatActivity context = this.ubG.getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(245395);
                    throw tVar;
                }
                finderLiveVisitor.gyh = new h(context);
                h hVar = this.ubG.gyh;
                if (hVar != null) {
                    hVar.setKeyboardHeightObserver(new com.tencent.mm.ui.tools.g(this) {
                        /* class com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitor.b.AnonymousClass1 */
                        final /* synthetic */ b ubH;

                        {
                            this.ubH = r1;
                        }

                        @Override // com.tencent.mm.ui.tools.g
                        public final void y(int i2, boolean z) {
                            AppMethodBeat.i(245394);
                            Log.i("Finder.FinderLiveVisitorUI", "onKeyboardHeightChanged, height:" + i2 + ", isResized:" + z);
                            FinderLiveVisitor.a(this.ubH.ubG, i2 > 0, i2);
                            AppMethodBeat.o(245394);
                        }
                    });
                }
            }
            h hVar2 = this.ubG.gyh;
            if (hVar2 != null) {
                hVar2.start();
                AppMethodBeat.o(245395);
                return;
            }
            AppMethodBeat.o(245395);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        Log.i("Finder.FinderLiveVisitorUI", "[LiveLifecycle]onPause " + this + ", lifecycleOwner:" + getLifecycle());
        super.onPause();
        h hVar = this.gyh;
        if (hVar != null) {
            hVar.close();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        Log.i("Finder.FinderLiveVisitorUI", "[LiveLifecycle]onStop " + this + ", lifecycleOwner:" + getLifecycle());
        super.onStop();
        o oVar = o.ujN;
        g dfZ = o.dfZ();
        if (dfZ != null && dfZ.uDS) {
            j jVar = this.ubm;
            if (jVar != null) {
                jVar.aGj();
            }
            f.cji();
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        Log.i("Finder.FinderLiveVisitorUI", "[LiveLifecycle]onDestroy " + this + ", lifecycleOwner:" + getLifecycle());
        super.onDestroy();
        d dVar = this.ubD;
        if (dVar != null) {
            dVar.onDetach();
        }
        j jVar = this.ubm;
        if (jVar != null) {
            jVar.onDestroy();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        Log.i("Finder.FinderLiveVisitorUI", "[LiveLifecycle]onBackPressed " + this + ", lifecycleOwner:" + getLifecycle());
        FinderLiveViewCallback finderLiveViewCallback = this.ubE;
        if (finderLiveViewCallback != null && !finderLiveViewCallback.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
    public void onSwipeBack() {
        super.onSwipeBack();
        this.ubn = true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        FinderLiveViewCallback finderLiveViewCallback = this.ubE;
        if (finderLiveViewCallback != null) {
            finderLiveViewCallback.onActivityResult(i2, i3, intent);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final void deh() {
        FinderLiveViewCallback finderLiveViewCallback = this.ubE;
        if (finderLiveViewCallback != null) {
            finderLiveViewCallback.MC();
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final void dei() {
        FinderLiveViewCallback finderLiveViewCallback = this.ubE;
        if (finderLiveViewCallback != null) {
            finderLiveViewCallback.deR();
        }
    }

    public static final /* synthetic */ void a(FinderLiveVisitor finderLiveVisitor, boolean z, int i2) {
        if (finderLiveVisitor.hwq != z) {
            finderLiveVisitor.hwq = z;
            FinderLiveViewCallback finderLiveViewCallback = finderLiveVisitor.ubE;
            if (finderLiveViewCallback != null) {
                finderLiveViewCallback.keyboardChange(z, i2);
            }
        }
    }
}
