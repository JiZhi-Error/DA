package com.tencent.mm.plugin.finder.ui.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.sample.FinderSampleTabUI;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0003\f\r\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0018\u00010\u0004H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0002¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleDynamicTabUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "selectTab", "Companion", "FinderDynamicSampleTabUIC", "FinderDynamicTabProvider", "plugin-finder_release"})
public final class FinderSampleDynamicTabUI extends MMFinderUI {
    public static final a vRD = new a((byte) 0);
    private HashMap _$_findViewCache;

    static {
        AppMethodBeat.i(253026);
        AppMethodBeat.o(253026);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(253028);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(253028);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(253027);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(253027);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleDynamicTabUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(253024);
        Set<Class<? extends UIComponent>> of = ak.setOf(FinderDynamicSampleTabUIC.class);
        AppMethodBeat.o(253024);
        return of;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(253025);
        super.onCreate(bundle);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((FinderDynamicSampleTabUIC) com.tencent.mm.ui.component.a.b(this).get(FinderDynamicSampleTabUIC.class)).aw(1, false);
        getContentView().postDelayed(new c(this), 4000);
        getContentView().postDelayed(new d(this), 10000);
        getContentView().postDelayed(new e(this), 15000);
        getContentView().postDelayed(new f(this), 20000);
        AppMethodBeat.o(253025);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ FinderSampleDynamicTabUI vRE;

        c(FinderSampleDynamicTabUI finderSampleDynamicTabUI) {
            this.vRE = finderSampleDynamicTabUI;
        }

        public final void run() {
            AppMethodBeat.i(253020);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            FinderSampleTabUI.FinderSampleTabFragment finderSampleTabFragment = new FinderSampleTabUI.FinderSampleTabFragment();
            finderSampleTabFragment.title = 201;
            ((FinderDynamicSampleTabUIC) com.tencent.mm.ui.component.a.b(this.vRE).get(FinderDynamicSampleTabUIC.class)).a((FinderTabUIC) 1, (int) new com.tencent.mm.plugin.finder.view.tabcomp.c("A1"), (com.tencent.mm.plugin.finder.view.tabcomp.a) finderSampleTabFragment, (FinderHomeTabFragment) false);
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            FinderSampleTabUI.FinderSampleTabFragment finderSampleTabFragment2 = new FinderSampleTabUI.FinderSampleTabFragment();
            finderSampleTabFragment2.title = 202;
            ((FinderDynamicSampleTabUIC) com.tencent.mm.ui.component.a.b(this.vRE).get(FinderDynamicSampleTabUIC.class)).a((FinderTabUIC) 2, (int) new com.tencent.mm.plugin.finder.view.tabcomp.c("A2"), (com.tencent.mm.plugin.finder.view.tabcomp.a) finderSampleTabFragment2, (FinderHomeTabFragment) false);
            AppMethodBeat.o(253020);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ FinderSampleDynamicTabUI vRE;

        d(FinderSampleDynamicTabUI finderSampleDynamicTabUI) {
            this.vRE = finderSampleDynamicTabUI;
        }

        public final void run() {
            AppMethodBeat.i(253021);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            FinderSampleTabUI.FinderSampleTabFragment finderSampleTabFragment = new FinderSampleTabUI.FinderSampleTabFragment();
            finderSampleTabFragment.title = 301;
            ((FinderDynamicSampleTabUIC) com.tencent.mm.ui.component.a.b(this.vRE).get(FinderDynamicSampleTabUIC.class)).a((FinderTabUIC) new com.tencent.mm.plugin.finder.view.tabcomp.c("B1"), (com.tencent.mm.plugin.finder.view.tabcomp.a) finderSampleTabFragment);
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            FinderSampleTabUI.FinderSampleTabFragment finderSampleTabFragment2 = new FinderSampleTabUI.FinderSampleTabFragment();
            finderSampleTabFragment2.title = 302;
            ((FinderDynamicSampleTabUIC) com.tencent.mm.ui.component.a.b(this.vRE).get(FinderDynamicSampleTabUIC.class)).a((FinderTabUIC) new com.tencent.mm.plugin.finder.view.tabcomp.c("B2"), (com.tencent.mm.plugin.finder.view.tabcomp.a) finderSampleTabFragment2);
            com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
            FinderSampleTabUI.FinderSampleTabFragment finderSampleTabFragment3 = new FinderSampleTabUI.FinderSampleTabFragment();
            finderSampleTabFragment3.title = 303;
            ((FinderDynamicSampleTabUIC) com.tencent.mm.ui.component.a.b(this.vRE).get(FinderDynamicSampleTabUIC.class)).a((FinderTabUIC) new com.tencent.mm.plugin.finder.view.tabcomp.c("B3"), (com.tencent.mm.plugin.finder.view.tabcomp.a) finderSampleTabFragment3);
            AppMethodBeat.o(253021);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ FinderSampleDynamicTabUI vRE;

        e(FinderSampleDynamicTabUI finderSampleDynamicTabUI) {
            this.vRE = finderSampleDynamicTabUI;
        }

        public final void run() {
            AppMethodBeat.i(253022);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderDynamicSampleTabUIC) com.tencent.mm.ui.component.a.b(this.vRE).get(FinderDynamicSampleTabUIC.class)).gx(3, -1);
            AppMethodBeat.o(253022);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ FinderSampleDynamicTabUI vRE;

        f(FinderSampleDynamicTabUI finderSampleDynamicTabUI) {
            this.vRE = finderSampleDynamicTabUI;
        }

        public final void run() {
            AppMethodBeat.i(253023);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderDynamicSampleTabUIC) com.tencent.mm.ui.component.a.b(this.vRE).get(FinderDynamicSampleTabUIC.class)).gx(0, -1);
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            ((FinderDynamicSampleTabUIC) com.tencent.mm.ui.component.a.b(this.vRE).get(FinderDynamicSampleTabUIC.class)).dIN();
            com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
            ((FinderDynamicSampleTabUIC) com.tencent.mm.ui.component.a.b(this.vRE).get(FinderDynamicSampleTabUIC.class)).dIN();
            AppMethodBeat.o(253023);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleDynamicTabUI$FinderDynamicSampleTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "plugin-finder_release"})
    public static final class FinderDynamicSampleTabUIC extends FinderTabUIC {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FinderDynamicSampleTabUIC(AppCompatActivity appCompatActivity) {
            super(appCompatActivity);
            p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            AppMethodBeat.i(253019);
            Log.i("Finder.FinderTabUIC", "FinderBizTabUIC init cons");
            AppMethodBeat.o(253019);
        }

        @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC
        public final IFinderTabProvider cXB() {
            AppMethodBeat.i(253018);
            Log.i("Finder.FinderTabUIC", "FinderBizTabUIC generateProvider");
            b bVar = new b();
            AppMethodBeat.o(253018);
            return bVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleDynamicTabUI$FinderDynamicTabProvider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "()V", "isDynamic", "", "plugin-finder_release"})
    public static final class b extends FinderTabProvider {
        @Override // com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider, com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider
        public final boolean isDynamic() {
            return true;
        }
    }
}
