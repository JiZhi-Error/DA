package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryAnchorAllHistoryContract;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
public final class FinderLotteryAnchorAllHistoryContract$Presenter$onAttach$1 extends q implements b<IResponse<bo>, x> {
    final /* synthetic */ FinderLotteryAnchorAllHistoryContract.Presenter uYa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLotteryAnchorAllHistoryContract$Presenter$onAttach$1(FinderLotteryAnchorAllHistoryContract.Presenter presenter) {
        super(1);
        this.uYa = presenter;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
        RefreshLoadMoreLayout rlLayout;
        AppMethodBeat.i(249849);
        IResponse<bo> iResponse2 = iResponse;
        p.h(iResponse2, LocaleUtil.ITALIAN);
        BaseFinderLotteryContract.ViewCallback viewCallback = this.uYa.uWf;
        if (!(viewCallback == null || (rlLayout = viewCallback.getRlLayout()) == null)) {
            rlLayout.setEnableLoadMore(iResponse2.getHasMore());
        }
        x xVar = x.SXb;
        AppMethodBeat.o(249849);
        return xVar;
    }
}
