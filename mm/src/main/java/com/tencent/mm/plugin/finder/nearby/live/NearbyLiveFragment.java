package com.tencent.mm.plugin.finder.nearby.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.ui.f;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "()V", "getClickTabContextId", "", "getCommentScene", "", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onMenuClick", "plugin-finder_release"})
public final class NearbyLiveFragment extends AbsNearByFragment {
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.ui.component.UIComponentFragment
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(249055);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(249055);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        AppMethodBeat.i(249056);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
        AppMethodBeat.o(249056);
    }

    public NearbyLiveFragment() {
        super(R.string.fb6, 1001);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(249051);
        Set<Class<? extends UIComponent>> of = ak.setOf((Object[]) new Class[]{FinderReporterUIC.class, NearbyLiveUIC.class});
        AppMethodBeat.o(249051);
        return of;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final void dll() {
        AppMethodBeat.i(249052);
        super.dll();
        if (getActivity() == null) {
            Log.w("MicroMsg.UIComponentFragment", "onActionbarClick()");
            AppMethodBeat.o(249052);
            return;
        }
        d dVar = ((NearbyLiveUIC) component(NearbyLiveUIC.class)).uRj;
        if (dVar == null) {
            p.btv("liveFriendsPresenter");
        }
        if (dVar != null) {
            dVar.onActionbarClick(false);
            AppMethodBeat.o(249052);
            return;
        }
        AppMethodBeat.o(249052);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final void dlm() {
        AppMethodBeat.i(249053);
        super.dlm();
        if (getActivity() == null) {
            Log.w("MicroMsg.UIComponentFragment", "onActionbarDoubleClick()");
            AppMethodBeat.o(249053);
            return;
        }
        d dVar = ((NearbyLiveUIC) component(NearbyLiveUIC.class)).uRj;
        if (dVar == null) {
            p.btv("liveFriendsPresenter");
        }
        if (dVar != null) {
            dVar.onActionbarClick(true);
            AppMethodBeat.o(249053);
            return;
        }
        AppMethodBeat.o(249053);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final void dlk() {
        AppMethodBeat.i(249054);
        super.dlk();
        if (getActivity() == null) {
            Log.w("MicroMsg.UIComponentFragment", "onMenuClick()");
            AppMethodBeat.o(249054);
            return;
        }
        f fVar = ((NearbyLiveUIC) component(NearbyLiveUIC.class)).uRi;
        if (fVar == null) {
            p.btv("livePostHelper");
        }
        fVar.prepare();
        k kVar = k.vkd;
        k.a(s.af.ENTER_PAGE_EXPLORE);
        AppMethodBeat.o(249054);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final int getCommentScene() {
        return 76;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final int ddN() {
        return 3;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final String ack() {
        return "1001";
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
    public final String afB() {
        return "76-1001";
    }
}
