package com.tencent.mm.plugin.finder.view.tabcomp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.sample.FinderSampleTabUI;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\t¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "()V", "fragments", "", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "getFragments", "()Ljava/util/List;", "setFragments", "(Ljava/util/List;)V", "tabContainer", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "getTabContainer", "()Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "setTabContainer", "(Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;)V", "tabViewAction", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "getTabViewAction", "()Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "setTabViewAction", "(Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;)V", "tabs", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "getTabs", "setTabs", "plugin-finder_release"})
public class FinderTabProvider implements IFinderTabProvider {
    private List<? extends FinderHomeTabFragment> fragments;
    private g tabContainer = new d();
    private f tabViewAction = new e();
    private List<? extends a> tabs = j.ac(new c("喜欢"), new c("点赞"), new c("提到"));

    public FinderTabProvider() {
        AppMethodBeat.i(255307);
        FinderSampleTabUI.FinderSampleTabFragment finderSampleTabFragment = new FinderSampleTabUI.FinderSampleTabFragment();
        finderSampleTabFragment.title = 101;
        FinderSampleTabUI.FinderSampleTabFragment finderSampleTabFragment2 = new FinderSampleTabUI.FinderSampleTabFragment();
        finderSampleTabFragment2.title = 102;
        FinderSampleTabUI.FinderSampleTabFragment finderSampleTabFragment3 = new FinderSampleTabUI.FinderSampleTabFragment();
        finderSampleTabFragment3.title = 103;
        this.fragments = j.ac(finderSampleTabFragment, finderSampleTabFragment2, finderSampleTabFragment3);
        AppMethodBeat.o(255307);
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider
    public boolean isDynamic() {
        return false;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment>, java.util.List<com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment> */
    public final List<FinderHomeTabFragment> getFragments() {
        return this.fragments;
    }

    public final void setFragments(List<? extends FinderHomeTabFragment> list) {
        AppMethodBeat.i(255303);
        p.h(list, "<set-?>");
        this.fragments = list;
        AppMethodBeat.o(255303);
    }

    public final g getTabContainer() {
        return this.tabContainer;
    }

    public final void setTabContainer(g gVar) {
        AppMethodBeat.i(255304);
        p.h(gVar, "<set-?>");
        this.tabContainer = gVar;
        AppMethodBeat.o(255304);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a>, java.util.List<com.tencent.mm.plugin.finder.view.tabcomp.a> */
    public final List<a> getTabs() {
        return this.tabs;
    }

    public final void setTabs(List<? extends a> list) {
        AppMethodBeat.i(255305);
        p.h(list, "<set-?>");
        this.tabs = list;
        AppMethodBeat.o(255305);
    }

    public final f getTabViewAction() {
        return this.tabViewAction;
    }

    public final void setTabViewAction(f fVar) {
        AppMethodBeat.i(255306);
        p.h(fVar, "<set-?>");
        this.tabViewAction = fVar;
        AppMethodBeat.o(255306);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment>, java.util.List<com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment> */
    @Override // com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider
    public List<FinderHomeTabFragment> fragments() {
        return this.fragments;
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider
    public g tabContainer() {
        return this.tabContainer;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a>, java.util.List<com.tencent.mm.plugin.finder.view.tabcomp.a> */
    @Override // com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider
    public List<a> tabs() {
        return this.tabs;
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider
    public f tabViewAction() {
        return this.tabViewAction;
    }
}
