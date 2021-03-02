package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.finder.live.view.j;
import com.tencent.mm.plugin.finder.live.viewmodel.FinderLivePostUIC;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.h;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;
import kotlin.t;

@com.tencent.mm.ui.base.a(32)
@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u0018\u0010\u0014\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u0016\u0018\u00010\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\"\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u0019H\u0016J\u0012\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0019H\u0014J\u0012\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010 H\u0014J\b\u0010(\u001a\u00020\u0019H\u0014J\b\u0010)\u001a\u00020\u0019H\u0014J\b\u0010*\u001a\u00020\u0019H\u0016J\b\u0010+\u001a\u00020\u0019H\u0014J\b\u0010,\u001a\u00020\u0019H\u0016J\b\u0010-\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveAnchorUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "anchorPluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveAnchorPluginLayout;", "finderLivePageFloatBallHelper", "Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "isKeyBoardShow", "", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "swipeBack", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "keyboardChange", "", "show", "height", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "setWindowStyle", "plugin-finder_release"})
public final class FinderLiveAnchorUI extends MMFinderUI {
    private final String TAG = "MicroMsg.FinderLiveAnchorUI";
    private HashMap _$_findViewCache;
    private h gyh;
    private boolean hwq;
    private com.tencent.mm.plugin.finder.live.view.a ubl;
    private j ubm;
    public boolean ubn;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245336);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245336);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245335);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245335);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.af9;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(245323);
        Set<Class<? extends UIComponent>> of = ak.setOf(FinderLivePostUIC.class);
        AppMethodBeat.o(245323);
        return of;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(245324);
        super.onNewIntent(intent);
        com.tencent.mm.plugin.finder.live.view.a aVar = this.ubl;
        if (aVar != null) {
            aVar.onNewIntent(intent);
            AppMethodBeat.o(245324);
            return;
        }
        AppMethodBeat.o(245324);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0178  */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r14) {
        /*
        // Method dump skipped, instructions count: 526
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStart() {
        AppMethodBeat.i(245326);
        super.onStart();
        com.tencent.mm.plugin.finder.live.view.a aVar = this.ubl;
        if (aVar != null) {
            aVar.start();
        }
        j jVar = this.ubm;
        if (jVar != null) {
            jVar.aGf();
        }
        f.cjk();
        AppMethodBeat.o(245326);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(245327);
        super.onResume();
        com.tencent.mm.plugin.finder.live.view.a aVar = this.ubl;
        if (aVar != null) {
            aVar.resume();
        }
        com.tencent.mm.plugin.finder.live.view.a aVar2 = this.ubl;
        if (aVar2 != null) {
            aVar2.post(new a(this));
            AppMethodBeat.o(245327);
            return;
        }
        AppMethodBeat.o(245327);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ FinderLiveAnchorUI ubo;

        a(FinderLiveAnchorUI finderLiveAnchorUI) {
            this.ubo = finderLiveAnchorUI;
        }

        public final void run() {
            AppMethodBeat.i(245322);
            if (this.ubo.gyh == null) {
                FinderLiveAnchorUI finderLiveAnchorUI = this.ubo;
                AppCompatActivity context = this.ubo.getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(245322);
                    throw tVar;
                }
                finderLiveAnchorUI.gyh = new h(context);
                h hVar = this.ubo.gyh;
                if (hVar != null) {
                    hVar.setKeyboardHeightObserver(new g(this) {
                        /* class com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI.a.AnonymousClass1 */
                        final /* synthetic */ a ubp;

                        {
                            this.ubp = r1;
                        }

                        @Override // com.tencent.mm.ui.tools.g
                        public final void y(int i2, boolean z) {
                            AppMethodBeat.i(245321);
                            Log.i(this.ubp.ubo.TAG, "onKeyboardHeightChanged, height:" + i2 + ", isResized:" + z);
                            FinderLiveAnchorUI.a(this.ubp.ubo, i2 > 0, i2);
                            AppMethodBeat.o(245321);
                        }
                    });
                }
            }
            h hVar2 = this.ubo.gyh;
            if (hVar2 != null) {
                hVar2.start();
                AppMethodBeat.o(245322);
                return;
            }
            AppMethodBeat.o(245322);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(245328);
        super.onPause();
        h hVar = this.gyh;
        if (hVar != null) {
            hVar.close();
        }
        com.tencent.mm.plugin.finder.live.view.a aVar = this.ubl;
        if (aVar != null) {
            aVar.pause();
            AppMethodBeat.o(245328);
            return;
        }
        AppMethodBeat.o(245328);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStop() {
        AppMethodBeat.i(245329);
        super.onStop();
        com.tencent.mm.plugin.finder.live.view.a aVar = this.ubl;
        if (aVar != null) {
            aVar.stop();
        }
        j jVar = this.ubm;
        if (jVar != null) {
            jVar.aGj();
        }
        f.cji();
        AppMethodBeat.o(245329);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(245330);
        super.onDestroy();
        com.tencent.mm.plugin.finder.live.view.a aVar = this.ubl;
        if (aVar != null) {
            aVar.unMount();
        }
        j jVar = this.ubm;
        if (jVar != null) {
            jVar.onDestroy();
            AppMethodBeat.o(245330);
            return;
        }
        AppMethodBeat.o(245330);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(245331);
        com.tencent.mm.plugin.finder.live.view.a aVar = this.ubl;
        if (aVar != null) {
            if (!aVar.onBackPress()) {
                super.onBackPressed();
            }
            AppMethodBeat.o(245331);
            return;
        }
        AppMethodBeat.o(245331);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
    public final void onSwipeBack() {
        AppMethodBeat.i(245332);
        super.onSwipeBack();
        this.ubn = true;
        AppMethodBeat.o(245332);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(245333);
        super.onActivityResult(i2, i3, intent);
        com.tencent.mm.plugin.finder.live.view.a aVar = this.ubl;
        if (aVar != null) {
            aVar.onActivityResult(i2, i3, intent);
            AppMethodBeat.o(245333);
            return;
        }
        AppMethodBeat.o(245333);
    }

    public static final /* synthetic */ void a(FinderLiveAnchorUI finderLiveAnchorUI, boolean z, int i2) {
        AppMethodBeat.i(245334);
        if (finderLiveAnchorUI.hwq != z) {
            finderLiveAnchorUI.hwq = z;
            com.tencent.mm.plugin.finder.live.view.a aVar = finderLiveAnchorUI.ubl;
            if (aVar != null) {
                aVar.keyboardChange(z, i2);
                AppMethodBeat.o(245334);
                return;
            }
        }
        AppMethodBeat.o(245334);
    }
}
