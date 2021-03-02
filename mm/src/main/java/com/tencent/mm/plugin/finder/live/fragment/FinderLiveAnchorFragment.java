package com.tencent.mm.plugin.finder.live.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveAnchorSecDeviceUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveAnchorUIC;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\u0018\u00010\tH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveAnchorFragment;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "()V", "isSecondaryDevice", "", "()Z", "setSecondaryDevice", "(Z)V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder_release"})
public final class FinderLiveAnchorFragment extends UIComponentFragment {
    private HashMap _$_findViewCache;
    public boolean uhI;

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245978);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245978);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        AppMethodBeat.i(245979);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
        AppMethodBeat.o(245979);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(245977);
        if (this.uhI) {
            Set<Class<? extends UIComponent>> of = ak.setOf(FinderLiveAnchorSecDeviceUIC.class);
            AppMethodBeat.o(245977);
            return of;
        }
        Set<Class<? extends UIComponent>> of2 = ak.setOf(FinderLiveAnchorUIC.class);
        AppMethodBeat.o(245977);
        return of2;
    }
}
