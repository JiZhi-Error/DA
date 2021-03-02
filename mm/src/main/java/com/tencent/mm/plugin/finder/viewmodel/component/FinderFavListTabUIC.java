package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFavFeedFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFavMegaVideoFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.e;
import com.tencent.mm.plugin.finder.view.tabcomp.f;
import com.tencent.mm.plugin.finder.view.tabcomp.g;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\n¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFavListTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "addMegaVideoFragment", "", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "removeMegaVideoFragment", "clearCache", "plugin-finder_release"})
public final class FinderFavListTabUIC extends FinderTabUIC {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFavListTabUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255492);
        AppMethodBeat.o(255492);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavListTabUIC$generateProvider$1", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "fragments", "", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "isDynamic", "", "tabContainer", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "tabViewAction", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "tabs", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "plugin-finder_release"})
    public static final class b implements IFinderTabProvider {
        b() {
        }

        @Override // com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider
        public final List<FinderHomeTabFragment> fragments() {
            AppMethodBeat.i(255483);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new FinderFavFeedFragment());
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dvJ().value().intValue() == 1) {
                arrayList.add(new FinderFavMegaVideoFragment());
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(255483);
            return arrayList2;
        }

        @Override // com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider
        public final g tabContainer() {
            AppMethodBeat.i(255484);
            com.tencent.mm.plugin.finder.view.tabcomp.b bVar = new com.tencent.mm.plugin.finder.view.tabcomp.b();
            AppMethodBeat.o(255484);
            return bVar;
        }

        @Override // com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider
        public final List<com.tencent.mm.plugin.finder.view.tabcomp.a> tabs() {
            AppMethodBeat.i(255485);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.tencent.mm.plugin.finder.view.tabcomp.c((int) R.string.d_w));
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dvJ().value().intValue() == 1) {
                arrayList.add(new com.tencent.mm.plugin.finder.view.tabcomp.c((int) R.string.d_v));
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(255485);
            return arrayList2;
        }

        @Override // com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider
        public final f tabViewAction() {
            AppMethodBeat.i(255486);
            e eVar = new e();
            AppMethodBeat.o(255486);
            return eVar;
        }

        @Override // com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider
        public final boolean isDynamic() {
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC
    public final IFinderTabProvider cXB() {
        AppMethodBeat.i(255488);
        b bVar = new b();
        AppMethodBeat.o(255488);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC, com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(255489);
        super.onCreate(bundle);
        if (l.a.a(com.tencent.mm.plugin.finder.storage.data.l.vGw, 12).isEmpty()) {
            nR(false);
        }
        dnx();
        AppMethodBeat.o(255489);
    }

    public final void nR(boolean z) {
        AppMethodBeat.i(255490);
        d.h(new c(this, z));
        AppMethodBeat.o(255490);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        AppMethodBeat.i(255491);
        boolean onBackPressed = getActiveFragment().onBackPressed();
        AppMethodBeat.o(255491);
        return onBackPressed;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderFavListTabUIC wvY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FinderFavListTabUIC finderFavListTabUIC) {
            super(0);
            this.wvY = finderFavListTabUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(255482);
            if (!this.wvY.MJ(101)) {
                this.wvY.a((FinderTabUIC) new com.tencent.mm.plugin.finder.view.tabcomp.c((int) R.string.d_v), (com.tencent.mm.plugin.finder.view.tabcomp.a) new FinderFavMegaVideoFragment());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(255482);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean vcK;
        final /* synthetic */ FinderFavListTabUIC wvY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderFavListTabUIC finderFavListTabUIC, boolean z) {
            super(0);
            this.wvY = finderFavListTabUIC;
            this.vcK = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(255487);
            this.wvY.gw(101, -1);
            if (this.vcK) {
                l.a aVar = com.tencent.mm.plugin.finder.storage.data.l.vGw;
                String aUg = z.aUg();
                p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                l.a.a(12, aUg, new LinkedList());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(255487);
            return xVar;
        }
    }
}
