package com.tencent.mm.plugin.finder.feed.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.am;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineLbsUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0006\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineLbsUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderTimelineLbsUI extends MMFinderUI {
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245566);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245566);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245565);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245565);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(245559);
        super.onCreate(bundle);
        setMMTitle(R.string.d_t);
        com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder) ah).getRedDotManager().asV("finder_tl_nearby_tab");
        setBackBtn(new a(this));
        setTitleBarClickListener(new b(this), new c(this));
        AppMethodBeat.o(245559);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderTimelineLbsUI uda;

        a(FinderTimelineLbsUI finderTimelineLbsUI) {
            this.uda = finderTimelineLbsUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(245556);
            this.uda.finish();
            AppMethodBeat.o(245556);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ FinderTimelineLbsUI uda;

        b(FinderTimelineLbsUI finderTimelineLbsUI) {
            this.uda = finderTimelineLbsUI;
        }

        public final void run() {
            AppMethodBeat.i(245557);
            FinderTimelineLbsUI.a(this.uda);
            AppMethodBeat.o(245557);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ FinderTimelineLbsUI uda;

        c(FinderTimelineLbsUI finderTimelineLbsUI) {
            this.uda = finderTimelineLbsUI;
        }

        public final void run() {
            AppMethodBeat.i(245558);
            FinderTimelineLbsUI.b(this.uda);
            AppMethodBeat.o(245558);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(245560);
        Set<Class<? extends UIComponent>> of = ak.setOf(FinderTimelineLbsUIC.class);
        AppMethodBeat.o(245560);
        return of;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        AppMethodBeat.i(245561);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dst().value().intValue() == 1) {
            AppMethodBeat.o(245561);
            return 15;
        }
        AppMethodBeat.o(245561);
        return 34;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        AppMethodBeat.i(245562);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dst().value().intValue() == 1) {
            AppMethodBeat.o(245562);
            return 3;
        }
        AppMethodBeat.o(245562);
        return 5;
    }

    public static final /* synthetic */ void a(FinderTimelineLbsUI finderTimelineLbsUI) {
        AppMethodBeat.i(245563);
        FinderTimelineLbsUIC finderTimelineLbsUIC = (FinderTimelineLbsUIC) finderTimelineLbsUI.component(FinderTimelineLbsUIC.class);
        am amVar = finderTimelineLbsUIC.wAC;
        if (amVar != null) {
            amVar.onActionbarClick(false);
        }
        com.tencent.mm.plugin.finder.feed.ak akVar = finderTimelineLbsUIC.wAD;
        if (akVar != null) {
            akVar.onActionbarClick(false);
            AppMethodBeat.o(245563);
            return;
        }
        AppMethodBeat.o(245563);
    }

    public static final /* synthetic */ void b(FinderTimelineLbsUI finderTimelineLbsUI) {
        AppMethodBeat.i(245564);
        ((FinderTimelineLbsUIC) finderTimelineLbsUI.component(FinderTimelineLbsUIC.class)).dlm();
        AppMethodBeat.o(245564);
    }
}
