package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.search.i;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFollowListNormalFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFollowListTopicFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "isExitTopic", "", "()Z", "setExitTopic", "(Z)V", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Provider", "Tab", "TabContainer", "plugin-finder_release"})
public final class FinderFollowListTabUIC extends FinderTabUIC {
    boolean wwm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFollowListTabUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255522);
        AppMethodBeat.o(255522);
    }

    @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC
    public final IFinderTabProvider cXB() {
        AppMethodBeat.i(255519);
        a aVar = new a();
        AppMethodBeat.o(255519);
        return aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListTabUIC$Provider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListTabUIC;)V", "plugin-finder_release"})
    public final class a extends FinderTabProvider {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
            AppMethodBeat.i(255516);
            setTabContainer(new c());
            setTabViewAction(new com.tencent.mm.plugin.finder.view.tabcomp.e());
            LinkedList linkedList = new LinkedList();
            linkedList.add(new b(R.string.da9));
            if (FinderFollowListTabUIC.this.wwm) {
                linkedList.add(new b(R.string.dae));
            }
            setTabs(linkedList);
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add(new FinderFollowListNormalFragment());
            if (FinderFollowListTabUIC.this.wwm) {
                linkedList2.add(new FinderFollowListTopicFragment());
            }
            setFragments(linkedList2);
            AppMethodBeat.o(255516);
        }
    }

    @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC, com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(255520);
        super.onCreate(bundle);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.drt()) {
            AppCompatActivity activity = getActivity();
            if (activity == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255520);
                throw tVar;
            }
            ((MMActivity) activity).addIconOptionMenu(0, R.raw.icons_outlined_search, new d(this));
        }
        AppCompatActivity activity2 = getActivity();
        if (activity2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255520);
            throw tVar2;
        }
        ((MMActivity) activity2).setBackBtn(new e(this));
        AppMethodBeat.o(255520);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class d implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderFollowListTabUIC wwn;

        d(FinderFollowListTabUIC finderFollowListTabUIC) {
            this.wwn = finderFollowListTabUIC;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(255517);
            i iVar = i.vvu;
            i.a(null);
            Intent intent = new Intent();
            intent.putExtra("need_history", false);
            if (this.wwn.dIM() == 0) {
                intent.putExtra("request_type", 3);
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.A(this.wwn.getActivity(), intent);
            } else {
                intent.putExtra("request_type", 4);
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.B(this.wwn.getActivity(), intent);
            }
            AppMethodBeat.o(255517);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class e implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderFollowListTabUIC wwn;

        e(FinderFollowListTabUIC finderFollowListTabUIC) {
            this.wwn = finderFollowListTabUIC;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(255518);
            this.wwn.getActivity().finish();
            AppMethodBeat.o(255518);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(255521);
        super.onResume();
        AppMethodBeat.o(255521);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListTabUIC$TabContainer;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabContainer;", "()V", "getLayoutId", "", "plugin-finder_release"})
    public static final class c extends com.tencent.mm.plugin.finder.view.tabcomp.d {
        @Override // com.tencent.mm.plugin.finder.view.tabcomp.d, com.tencent.mm.plugin.finder.view.tabcomp.g
        public final int getLayoutId() {
            return R.layout.abk;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListTabUIC$Tab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "titleId", "", "(I)V", "getLayoutId", "getTabMargin", "", "plugin-finder_release"})
    public static final class b extends com.tencent.mm.plugin.finder.view.tabcomp.c {
        public b(int i2) {
            super(i2);
        }

        @Override // com.tencent.mm.plugin.finder.view.tabcomp.c, com.tencent.mm.plugin.finder.view.tabcomp.a
        public final int getLayoutId() {
            return R.layout.abm;
        }

        @Override // com.tencent.mm.plugin.finder.view.tabcomp.a
        public final int[] cXC() {
            return new int[]{0, 16};
        }
    }
}
