package com.tencent.mm.plugin.finder.nearby.live.square.tab;

import android.animation.AnimatorSet;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.nearby.live.d;
import com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareGuideUIC;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0014J\b\u0010\u0010\u001a\u00020\fH\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0016\u0010\u0013\u001a\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabPresenter;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Landroid/support/v4/app/Fragment;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/support/v4/app/Fragment;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "getCommentScene", "", "getHeaderInfo", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getLocalTypeFlag", "getTabType", "onDetach", "", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
public final class b extends d {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(MMActivity mMActivity, Fragment fragment, bbn bbn, axj axj) {
        super(mMActivity, bbn);
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(fragment, "fragment");
        p.h(bbn, "contextObj");
        AppMethodBeat.i(249240);
        this.fragment = fragment;
        this.uQK = axj;
        AppMethodBeat.o(249240);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.live.d, com.tencent.mm.plugin.finder.nearby.live.b.a
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(249238);
        p.h(cVar, "reason");
        super.onRefreshEnd(cVar);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        if (aAh.azQ().getBoolean(ar.a.USERINFO_FIRST_SHOW_NEARBY_LIVE_SQUARE_SCROLL_GUIDE_BOOLEAN_SYNC, true)) {
            a aVar = a.PRN;
            Fragment fragment = this.fragment;
            if (fragment == null) {
                p.hyc();
            }
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                p.hyc();
            }
            p.g(parentFragment, "fragment!!.parentFragment!!");
            com.tencent.mm.plugin.finder.nearby.guide.a aVar2 = ((NearbyLiveSquareGuideUIC) a.of(parentFragment).get(NearbyLiveSquareGuideUIC.class)).uRs;
            AnimatorSet animatorSet = aVar2.uQy;
            if (animatorSet != null) {
                animatorSet.setStartDelay(100);
            }
            AnimatorSet animatorSet2 = aVar2.uQy;
            if (animatorSet2 != null) {
                animatorSet2.start();
            }
            e aAh2 = g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_FIRST_SHOW_NEARBY_LIVE_SQUARE_SCROLL_GUIDE_BOOLEAN_SYNC, Boolean.FALSE);
        }
        AppMethodBeat.o(249238);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.live.d, com.tencent.mm.plugin.finder.presenter.base.a
    public final void onDetach() {
        AppMethodBeat.i(249239);
        a aVar = a.PRN;
        Fragment fragment = this.fragment;
        if (fragment == null) {
            p.hyc();
        }
        Fragment parentFragment = fragment.getParentFragment();
        if (parentFragment == null) {
            p.hyc();
        }
        p.g(parentFragment, "fragment!!.parentFragment!!");
        AnimatorSet animatorSet = ((NearbyLiveSquareGuideUIC) a.of(parentFragment).get(NearbyLiveSquareGuideUIC.class)).uRs.uQy;
        if (animatorSet != null && animatorSet.isRunning()) {
            animatorSet.pause();
            animatorSet.cancel();
        }
        super.onDetach();
        AppMethodBeat.o(249239);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.live.d, com.tencent.mm.plugin.finder.nearby.live.b.a
    public final int getCommentScene() {
        return this.ttO.tCE;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.live.d
    public final int getTabType() {
        axj axj = this.uQK;
        return (axj != null ? axj.LHQ : 0) + 1001;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.live.d
    public final int dlq() {
        axj axj = this.uQK;
        return (axj != null ? axj.LHQ : 0) + 15;
    }
}
