package com.tencent.mm.plugin.finder.ui.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0018\u00010\u0004H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFollowListNormalFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder_release"})
public final class FinderFollowListNormalFragment extends FinderHomeTabFragment {
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252879);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252879);
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        AppMethodBeat.i(252880);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
        AppMethodBeat.o(252880);
    }

    public FinderFollowListNormalFragment() {
        this.dLS = 201;
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(252878);
        Set<Class<? extends UIComponent>> of = ak.setOf(FinderFollowListUIC.class);
        AppMethodBeat.o(252878);
        return of;
    }
}
