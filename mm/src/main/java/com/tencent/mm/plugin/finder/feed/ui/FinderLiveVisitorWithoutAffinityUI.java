package com.tencent.mm.plugin.finder.feed.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.k;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.live.fragment.FinderLiveVisitorFragment;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.a;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@a(32)
@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\fH\u0014J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0014J\b\u0010\u001e\u001a\u00020\u0014H\u0014J\b\u0010\u001f\u001a\u00020\u0014H\u0014J\b\u0010 \u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020\u0014H\u0014J\b\u0010\"\u001a\u00020\u0014H\u0016J\b\u0010#\u001a\u00020\u0014H\u0002J\b\u0010\t\u001a\u00020\u0014H\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveVisitorWithoutAffinityUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "fragment", "Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveVisitorFragment;", "getFragment", "()Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveVisitorFragment;", "setFragment", "(Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveVisitorFragment;)V", "lastOrientation", "", "swipeBack", "", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "commitFragment", "", "finish", "getLayoutId", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "resetFragment", "setOrUnsetFullScreen", "orientation", "plugin-finder_release"})
public final class FinderLiveVisitorWithoutAffinityUI extends MMFinderUI {
    private final String TAG = "FinderLiveVisitorWithoutAffinityUI";
    private HashMap _$_findViewCache;
    private int lastOrientation = -1;
    private FinderLiveVisitorFragment ubI;
    public boolean ubn;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245409);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245409);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245408);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245408);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(245398);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_context_id");
        String stringExtra2 = getIntent().getStringExtra("key_click_tab_context_id");
        if (!TextUtils.isEmpty(stringExtra)) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).sGQ = stringExtra;
        }
        if (!TextUtils.isEmpty(stringExtra2)) {
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).sGE = stringExtra2;
        }
        getIntent().putExtra("KEY_PARAMS_RESET_LIVE", false);
        dej();
        Log.i(this.TAG, "[onCreate]");
        AppMethodBeat.o(245398);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStart() {
        AppMethodBeat.i(245399);
        super.onStart();
        Log.i(this.TAG, "[onStart]");
        AppMethodBeat.o(245399);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(245400);
        super.onResume();
        Log.i(this.TAG, "[onResume]");
        AppMethodBeat.o(245400);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(245401);
        super.onPause();
        Log.i(this.TAG, "[onPause]");
        AppMethodBeat.o(245401);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStop() {
        AppMethodBeat.i(245402);
        super.onStop();
        Log.i(this.TAG, "[onStop]");
        AppMethodBeat.o(245402);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(245403);
        super.onDestroy();
        Log.i(this.TAG, "[onDestroy]");
        m.vli.a(s.at.CloseTypeFull);
        AppMethodBeat.o(245403);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(245404);
        p.h(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Log.i(this.TAG, "[onConfigurationChanged] lastOrientation：" + this.lastOrientation + ",newConfig.orientation:" + configuration.orientation);
        if (this.lastOrientation != configuration.orientation) {
            this.lastOrientation = configuration.orientation;
            getIntent().putExtra("KEY_PARAMS_RESET_LIVE", true);
            dej();
            m.vli.KJ(configuration.orientation);
        }
        LocaleUtil.initLanguage(MMApplicationContext.getContext());
        AppMethodBeat.o(245404);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.aft;
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
    public final void onSwipeBack() {
        AppMethodBeat.i(245405);
        super.onSwipeBack();
        this.ubn = true;
        AppMethodBeat.o(245405);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(245406);
        FinderLiveVisitorFragment finderLiveVisitorFragment = this.ubI;
        if (finderLiveVisitorFragment != null) {
            Iterator<T> it = finderLiveVisitorFragment.uiComponents.iterator();
            while (it.hasNext()) {
                it.next().onBeforeFinish(getIntent());
            }
        }
        super.finish();
        AppMethodBeat.o(245406);
    }

    private final void dej() {
        AppMethodBeat.i(245407);
        this.ubI = new FinderLiveVisitorFragment();
        FinderLiveVisitorFragment finderLiveVisitorFragment = this.ubI;
        if (finderLiveVisitorFragment != null) {
            k beginTransaction = getSupportFragmentManager().beginTransaction();
            p.g(beginTransaction, "supportFragmentManager.beginTransaction()");
            beginTransaction.b(R.id.d9o, finderLiveVisitorFragment);
            beginTransaction.commitNow();
            AppMethodBeat.o(245407);
            return;
        }
        AppMethodBeat.o(245407);
    }
}
