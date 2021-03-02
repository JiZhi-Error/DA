package com.tencent.mm.plugin.finder.viewmodel.hometab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import kotlin.a.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/hometab/FinderHomeTabProvider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "()V", "plugin-finder_release"})
public final class c extends FinderTabProvider {
    public c() {
        AppMethodBeat.i(256105);
        setFragments(j.ac(new FinderFollowTabFragment(), new FinderFriendTabFragment(), new FinderMachineTabFragment()));
        setTabContainer(new b());
        setTabs(j.ac(new a(R.string.d_r, 3), new a(R.string.d_s, 1), new a(R.string.d_u, 4)));
        setTabViewAction(new d());
        AppMethodBeat.o(256105);
    }
}
