package com.tencent.mm.plugin.finder.view.tabcomp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.view.HardTouchableLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010 \u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabContainer;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "()V", "finderTabLayout", "Landroid/support/design/widget/TabLayout;", "getFinderTabLayout", "()Landroid/support/design/widget/TabLayout;", "setFinderTabLayout", "(Landroid/support/design/widget/TabLayout;)V", "fragmentViewPager", "Landroid/support/v4/view/ViewPager;", "getFragmentViewPager", "()Landroid/support/v4/view/ViewPager;", "setFragmentViewPager", "(Landroid/support/v4/view/ViewPager;)V", "layoutContainer", "Lcom/tencent/mm/view/HardTouchableLayout;", "getLayoutContainer", "()Lcom/tencent/mm/view/HardTouchableLayout;", "setLayoutContainer", "(Lcom/tencent/mm/view/HardTouchableLayout;)V", "tabBackBtn", "Landroid/view/View;", "getTabBackBtn", "()Landroid/view/View;", "setTabBackBtn", "(Landroid/view/View;)V", "getBackBtn", "getLayoutId", "", "getTabLayout", "getTabLayoutContainer", "getViewPager", "onLayoutInflated", "", "window", "Landroid/view/Window;", "plugin-finder_release"})
public class d implements g {
    private View wtD;
    private TabLayout wtv;
    private HardTouchableLayout wtw;
    private ViewPager wtx;

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.g
    public int getLayoutId() {
        return R.layout.al_;
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.g
    public final void c(Window window) {
        AppMethodBeat.i(255302);
        p.h(window, "window");
        this.wtD = window.findViewById(R.id.xq);
        this.wtv = (TabLayout) window.findViewById(R.id.ift);
        this.wtx = (ViewPager) window.findViewById(R.id.j7c);
        this.wtw = (HardTouchableLayout) window.findViewById(R.id.ifu);
        AppMethodBeat.o(255302);
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.g
    public final TabLayout dHJ() {
        return this.wtv;
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.g
    public final HardTouchableLayout dHK() {
        return this.wtw;
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.g
    public final ViewPager dHL() {
        return this.wtx;
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.g
    public View getBackBtn() {
        return this.wtD;
    }
}
