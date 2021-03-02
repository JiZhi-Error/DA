package com.tencent.mm.plugin.finder.nearby.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "()V", "getClickTabContextId", "", "getCommentScene", "", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onMenuClick", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder_release"})
public final class NearbyVideoFragment extends AbsNearByFragment {
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.ui.component.UIComponentFragment
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(249391);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(249391);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        AppMethodBeat.i(249392);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
        AppMethodBeat.o(249392);
    }

    public NearbyVideoFragment() {
        super(R.string.fb8, 1002);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(249385);
        Set<Class<? extends UIComponent>> of = ak.setOf((Object[]) new Class[]{FinderReporterUIC.class, NearbyVideoUIC.class});
        AppMethodBeat.o(249385);
        return of;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final void dll() {
        AppMethodBeat.i(249386);
        super.dll();
        NearbyVideoPresenter nearbyVideoPresenter = ((NearbyVideoUIC) component(NearbyVideoUIC.class)).uTB;
        if (nearbyVideoPresenter != null) {
            nearbyVideoPresenter.onActionbarClick(false);
            AppMethodBeat.o(249386);
            return;
        }
        AppMethodBeat.o(249386);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final void dlm() {
        AppMethodBeat.i(249387);
        super.dlm();
        NearbyVideoPresenter nearbyVideoPresenter = ((NearbyVideoUIC) component(NearbyVideoUIC.class)).uTB;
        if (nearbyVideoPresenter != null) {
            nearbyVideoPresenter.onActionbarClick(true);
            AppMethodBeat.o(249387);
            return;
        }
        AppMethodBeat.o(249387);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final void dlk() {
        AppMethodBeat.i(249388);
        super.dlk();
        AppMethodBeat.o(249388);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final void onUserVisibleFocused() {
        AppMethodBeat.i(249389);
        super.onUserVisibleFocused();
        d dVar = d.uTq;
        d.b(this);
        AppMethodBeat.o(249389);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.ui.component.UIComponentFragment
    public final void onUserVisibleUnFocused() {
        AppMethodBeat.i(249390);
        super.onUserVisibleUnFocused();
        d dVar = d.uTq;
        d.c(this);
        AppMethodBeat.o(249390);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final int getCommentScene() {
        return 15;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final int ddN() {
        return 3;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final String ack() {
        return "1002";
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final String afB() {
        return "15-1002";
    }
}
