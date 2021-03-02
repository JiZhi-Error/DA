package com.tencent.mm.plugin.finder.viewmodel.notifytab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.ui.fragment.FinderNotifyFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.e;
import kotlin.a.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/notifytab/FinderNotifyTabProvider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "()V", "plugin-finder_release"})
public final class c extends FinderTabProvider {
    public c() {
        AppMethodBeat.i(256111);
        FinderNotifyFragment finderNotifyFragment = new FinderNotifyFragment();
        finderNotifyFragment.dLS = 0;
        FinderNotifyFragment finderNotifyFragment2 = new FinderNotifyFragment();
        finderNotifyFragment2.dLS = 1;
        FinderNotifyFragment finderNotifyFragment3 = new FinderNotifyFragment();
        finderNotifyFragment3.dLS = 2;
        setFragments(j.ac(finderNotifyFragment, finderNotifyFragment2, finderNotifyFragment3));
        setTabContainer(new b());
        setTabs(j.ac(new a(R.string.d3v), new a(R.string.d3t), new a(R.string.d3u)));
        setTabViewAction(new e());
        AppMethodBeat.o(256111);
    }
}
