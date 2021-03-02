package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.view.h;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.hometab.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000  2\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u0011J\b\u0010\u0014\u001a\u00020\bH\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0011J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u0018R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeNewUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragmentChangeListener", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "isCreated", "", "isFromSns", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getActiveFragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "getActiveView", "Landroid/view/View;", "getCurrentTabType", "", "getFragmentByTabType", "tabType", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onStop", "selectType", "setCurrentTabType", "type", "args", "Companion", "plugin-finder_release"})
public final class FinderHomeNewUIC extends UIComponent {
    public static final a wxe = new a((byte) 0);
    private boolean dbG;
    private final FinderHomeTabStateVM tlCache;
    private boolean wxc;
    private h wxd = new b(this);

    static {
        AppMethodBeat.i(255613);
        AppMethodBeat.o(255613);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderHomeNewUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255612);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
        p.g(viewModel, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
        this.tlCache = (FinderHomeTabStateVM) viewModel;
        AppMethodBeat.o(255612);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeNewUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeNewUIC$fragmentChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", FirebaseAnalytics.b.INDEX, "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"})
    public static final class b implements h {
        final /* synthetic */ FinderHomeNewUIC wxf;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(FinderHomeNewUIC finderHomeNewUIC) {
            this.wxf = finderHomeNewUIC;
        }

        @Override // com.tencent.mm.plugin.finder.view.h
        public final void onPageScrollStateChanged(int i2) {
        }

        @Override // com.tencent.mm.plugin.finder.view.h
        public final void a(boolean z, int i2, FinderHomeTabFragment finderHomeTabFragment) {
            AppMethodBeat.i(255602);
            p.h(finderHomeTabFragment, "fragment");
            AppMethodBeat.o(255602);
        }

        @Override // com.tencent.mm.plugin.finder.view.h
        public final void D(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(255603);
            this.wxf.tlCache.wtW = i5;
            this.wxf.tlCache.UVM = i5;
            AppMethodBeat.o(255603);
        }

        @Override // com.tencent.mm.plugin.finder.view.h
        public final void onPageScrolled(int i2, float f2, int i3) {
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        int dHR;
        AppMethodBeat.i(255607);
        super.onCreate(bundle);
        com.tencent.mm.ac.d.i(c.wxg);
        int intExtra = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
        com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder) ah).getRedDotManager().Iw(intExtra);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        com.tencent.mm.plugin.finder.storage.c.dsk();
        if (getActivity().getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false)) {
            dHR = 3;
        } else {
            dHR = this.tlCache.dHR();
        }
        a.C1354a aVar = com.tencent.mm.plugin.finder.viewmodel.hometab.a.wBL;
        int MK = a.C1354a.MK(dHR);
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        TabLayout tabLayout = ((FinderHomeTabUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeTabUIC.class)).wAv;
        if (tabLayout != null) {
            tabLayout.post(new d(this, MK));
        }
        StringBuilder append = new StringBuilder("[selectType] lastTabType=").append(this.tlCache.dHR()).append(" index=");
        a.C1354a aVar3 = com.tencent.mm.plugin.finder.viewmodel.hometab.a.wBL;
        Log.i("Finder.HomeUIC", append.append(a.C1354a.MK(dHR)).append(" tabType=").append(dHR).toString());
        as asVar = as.uOL;
        as.startTimer();
        this.dbG = true;
        this.wxc = getIntent().getLongExtra("key_finder_post_local_id", -1) != -1 && getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);
        AppMethodBeat.o(255607);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateAfter(Bundle bundle) {
        AppMethodBeat.i(255608);
        super.onCreateAfter(bundle);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((FinderHomeTabUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeTabUIC.class)).wxj.add(this.wxd);
        int dHR = this.tlCache.dHR();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("Source", 1);
        a.C1354a aVar2 = com.tencent.mm.plugin.finder.viewmodel.hometab.a.wBL;
        int MK = a.C1354a.MK(dHR);
        if (MK >= 0) {
            com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
            ((FinderHomeTabUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeTabUIC.class)).getFragments().get(MK).Ew = bundle2;
            this.tlCache.wtW = dHR;
            this.tlCache.UVM = dHR;
            com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
            ((FinderHomeTabUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeTabUIC.class)).aw(MK, false);
        }
        AppMethodBeat.o(255608);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onStop() {
        AppMethodBeat.i(255609);
        super.onStop();
        if (getActivity().isFinishing()) {
            com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            ((PluginFinder) ah).getRedDotManager().daB();
        }
        AppMethodBeat.o(255609);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(255610);
        super.onDestroy();
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        FinderHomeTabFragment activeFragment = ((FinderHomeTabUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeTabUIC.class)).getActiveFragment();
        if (activeFragment != null) {
            this.tlCache.a(activeFragment.dLS, FinderHomeTabStateVM.c.SOURCE_EXIT);
            this.tlCache.Mp(activeFragment.dLS);
        }
        as asVar = as.uOL;
        as.stopTimer();
        com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder) ah).getRedDotManager().daC();
        AppMethodBeat.o(255610);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        AppMethodBeat.i(255611);
        if (this.wxc) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.addFlags(536870912);
            intent.putExtra("preferred_tab", 2);
            com.tencent.mm.br.c.f(getActivity(), ".ui.LauncherUI", intent);
            getActivity().overridePendingTransition(MMFragmentActivity.a.ogo, MMFragmentActivity.a.ogp);
            AppMethodBeat.o(255611);
            return true;
        }
        AppMethodBeat.o(255611);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeNewUIC$selectType$1$1"})
    static final class d implements Runnable {
        final /* synthetic */ FinderHomeNewUIC wxf;
        final /* synthetic */ int wxh;

        d(FinderHomeNewUIC finderHomeNewUIC, int i2) {
            this.wxf = finderHomeNewUIC;
            this.wxh = i2;
        }

        public final void run() {
            AppMethodBeat.i(255606);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderHomeTabUIC) com.tencent.mm.ui.component.a.b(this.wxf.getActivity()).get(FinderHomeTabUIC.class)).aw(this.wxh, false);
            AppMethodBeat.o(255606);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        public static final c wxg = new c();

        static {
            AppMethodBeat.i(255605);
            AppMethodBeat.o(255605);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(255604);
            Log.i("Finder.HomeUIC", "initialize packageInfo:%s", BuildInfo.info());
            x xVar = x.SXb;
            AppMethodBeat.o(255604);
            return xVar;
        }
    }
}
