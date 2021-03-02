package com.tencent.mm.plugin.festival.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0018\u00010\u0004H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveVisitorFragment;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-festival_release"})
public final class FestivalFinderLiveVisitorFragment extends UIComponentFragment {
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(262597);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(262597);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        AppMethodBeat.i(262598);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
        AppMethodBeat.o(262598);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(262596);
        Set<Class<? extends UIComponent>> of = ak.setOf(FestivalFinderLiveVisitorUIC.class);
        AppMethodBeat.o(262596);
        return of;
    }
}
