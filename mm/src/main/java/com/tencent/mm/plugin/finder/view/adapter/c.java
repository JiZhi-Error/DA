package com.tencent.mm.plugin.finder.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFragmentPagerAdapter;", "Landroid/support/v4/app/FragmentPagerAdapter;", "fm", "Landroid/support/v4/app/FragmentManager;", "fragments", "", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/FragmentManager;Ljava/util/List;)V", "getCount", "", "getItem", "position", "plugin-finder_release"})
public final class c extends i {
    private final List<Fragment> fragments;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends android.support.v4.app.Fragment> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(g gVar, List<? extends Fragment> list) {
        super(gVar);
        p.h(gVar, "fm");
        p.h(list, "fragments");
        AppMethodBeat.i(255154);
        this.fragments = list;
        AppMethodBeat.o(255154);
    }

    @Override // android.support.v4.app.i
    public final Fragment getItem(int i2) {
        AppMethodBeat.i(255152);
        Fragment fragment = this.fragments.get(i2);
        AppMethodBeat.o(255152);
        return fragment;
    }

    @Override // android.support.v4.view.q
    public final int getCount() {
        AppMethodBeat.i(255153);
        int size = this.fragments.size();
        AppMethodBeat.o(255153);
        return size;
    }
}
