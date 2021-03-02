package com.tencent.mm.plugin.finder.activity.uic;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.activity.fragment.FinderActivityFragment;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.d;
import com.tencent.mm.plugin.finder.view.tabcomp.e;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u0010\u0011\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setCoveredStyle", "setNormalStyle", "setTabViews", "isCovered", "", "Provider", "Tab", "TabContainer", "plugin-finder_release"})
public final class FinderActivityTabUIC extends FinderTabUIC {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderActivityTabUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(242146);
        AppMethodBeat.o(242146);
    }

    @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC
    public final IFinderTabProvider cXB() {
        AppMethodBeat.i(242145);
        a aVar = new a();
        AppMethodBeat.o(242145);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC, com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(260148);
        super.onCreate(bundle);
        ViewPager viewPager = this.uO;
        if (viewPager instanceof FinderViewPager) {
            ((FinderViewPager) viewPager).setEnableViewPagerScroll(true);
        }
        AppMethodBeat.o(260148);
    }

    private final void Fp(boolean z) {
        AppMethodBeat.i(260151);
        int dIM = dIM();
        int i2 = 0;
        for (T t : getTabs()) {
            if (t instanceof b) {
                if (z) {
                    t.Fq(i2 == dIM);
                } else {
                    t.Fr(i2 == dIM);
                }
            }
            i2++;
        }
        AppMethodBeat.o(260151);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC$Provider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "(Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC;)V", "plugin-finder_release"})
    public final class a extends FinderTabProvider {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
            AppMethodBeat.i(242144);
            setTabContainer(new c());
            setTabViewAction(new e());
            LinkedList linkedList = new LinkedList();
            linkedList.add(new b(R.string.cgv));
            linkedList.add(new b(R.string.ch1));
            setTabs(linkedList);
            LinkedList linkedList2 = new LinkedList();
            FinderActivityFragment finderActivityFragment = new FinderActivityFragment();
            finderActivityFragment.dLS = 0;
            linkedList2.add(finderActivityFragment);
            FinderActivityFragment finderActivityFragment2 = new FinderActivityFragment();
            finderActivityFragment2.dLS = 1;
            linkedList2.add(finderActivityFragment2);
            setFragments(linkedList2);
            AppMethodBeat.o(242144);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC$TabContainer;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabContainer;", "()V", "getLayoutId", "", "plugin-finder_release"})
    public static final class c extends d {
        @Override // com.tencent.mm.plugin.finder.view.tabcomp.d, com.tencent.mm.plugin.finder.view.tabcomp.g
        public final int getLayoutId() {
            return R.layout.a9b;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC$Tab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "titleId", "", "(I)V", "isCovered", "", "getLayoutId", "getTabMargin", "", "setCoveredStyle", "", "isSelected", "setNormalStyle", "setTextColor", "isTabSelected", "plugin-finder_release"})
    public static final class b extends com.tencent.mm.plugin.finder.view.tabcomp.c {
        private boolean UHC;

        public b(int i2) {
            super(i2);
        }

        @Override // com.tencent.mm.plugin.finder.view.tabcomp.c, com.tencent.mm.plugin.finder.view.tabcomp.a
        public final int getLayoutId() {
            return R.layout.aj1;
        }

        @Override // com.tencent.mm.plugin.finder.view.tabcomp.a
        public final int[] cXC() {
            return new int[]{0, 6};
        }

        public final void Fq(boolean z) {
            AppMethodBeat.i(260146);
            this.UHC = true;
            pe(z);
            AppMethodBeat.o(260146);
        }

        public final void Fr(boolean z) {
            AppMethodBeat.i(260147);
            this.UHC = false;
            pe(z);
            AppMethodBeat.o(260147);
        }

        @Override // com.tencent.mm.plugin.finder.view.tabcomp.c
        public final void pe(boolean z) {
            AppMethodBeat.i(260145);
            TextView textView = this.titleTv;
            if (textView == null) {
                AppMethodBeat.o(260145);
            } else if (this.UHC) {
                if (z) {
                    Context context = textView.getContext();
                    p.g(context, "context");
                    textView.setTextColor(context.getResources().getColor(R.color.BW_100_Alpha_0_9));
                    AppMethodBeat.o(260145);
                    return;
                }
                Context context2 = textView.getContext();
                p.g(context2, "context");
                textView.setTextColor(context2.getResources().getColor(R.color.BW_100_Alpha_0_5));
                AppMethodBeat.o(260145);
            } else if (z) {
                Context context3 = textView.getContext();
                p.g(context3, "context");
                textView.setTextColor(context3.getResources().getColor(R.color.FG_0));
                AppMethodBeat.o(260145);
            } else {
                Context context4 = textView.getContext();
                p.g(context4, "context");
                textView.setTextColor(context4.getResources().getColor(R.color.FG_1));
                AppMethodBeat.o(260145);
            }
        }
    }

    public final void hSz() {
        AppMethodBeat.i(260149);
        TabLayout tabLayout = this.wAv;
        if (tabLayout != null) {
            tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.pg));
        }
        Fp(true);
        AppMethodBeat.o(260149);
    }

    public final void cXo() {
        AppMethodBeat.i(260150);
        TabLayout tabLayout = this.wAv;
        if (tabLayout != null) {
            tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.FG_0));
        }
        Fp(false);
        AppMethodBeat.o(260150);
    }
}
