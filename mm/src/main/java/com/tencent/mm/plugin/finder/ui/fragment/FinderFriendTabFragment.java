package com.tencent.mm.plugin.finder.ui.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderActionBarOverlayUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFullFeedGuideUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineUIC;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFriendTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "plugin-finder_release"})
public final class FinderFriendTabFragment extends FinderHomeTabFragment {
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252890);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252890);
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        AppMethodBeat.i(252891);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
        AppMethodBeat.o(252891);
    }

    public FinderFriendTabFragment() {
        super(R.string.d_s, 1);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(252888);
        HashSet ae = ak.ae(FinderTimelineUIC.class, FinderActionBarOverlayUIC.class, FinderStreamPartialExposeUIC.class, FinderHorizontalVideoPreviewUIC.class);
        if (y.a(y.vXH, 1, 0, 2)) {
            ae.add(FinderFullFeedGuideUIC.class);
        }
        HashSet hashSet = ae;
        AppMethodBeat.o(252888);
        return hashSet;
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment
    public final void dlm() {
        AppMethodBeat.i(252889);
        super.dlm();
        ((FinderActionBarOverlayUIC) component(FinderActionBarOverlayUIC.class)).dHX();
        ((FinderTimelineUIC) component(FinderTimelineUIC.class)).dHX();
        AppMethodBeat.o(252889);
    }
}
