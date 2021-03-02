package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryHistoryLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.ao;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryHistoryContract;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.g;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter$onAttach$1$1"})
public final class FinderLotteryHistoryContract$Presenter$onAttach$$inlined$run$lambda$1 extends q implements b<IResponse<bo>, x> {
    final /* synthetic */ FinderLotteryHistoryContract.Presenter uYd;
    final /* synthetic */ FinderLiveLotteryHistoryLoader uYe;
    final /* synthetic */ BaseFinderLotteryContract.ViewCallback uYf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLotteryHistoryContract$Presenter$onAttach$$inlined$run$lambda$1(FinderLiveLotteryHistoryLoader finderLiveLotteryHistoryLoader, FinderLotteryHistoryContract.Presenter presenter, BaseFinderLotteryContract.ViewCallback viewCallback) {
        super(1);
        this.uYe = finderLiveLotteryHistoryLoader;
        this.uYd = presenter;
        this.uYf = viewCallback;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
        IResponse<bo> iResponse2;
        ao aoVar;
        RefreshLoadMoreLayout rlLayout;
        AppMethodBeat.i(249858);
        IResponse<bo> iResponse3 = iResponse;
        p.h(iResponse3, LocaleUtil.ITALIAN);
        BaseFinderLotteryContract.ViewCallback viewCallback = this.uYd.uWf;
        if (!(viewCallback == null || (rlLayout = viewCallback.getRlLayout()) == null)) {
            rlLayout.setEnableLoadMore(iResponse3.getHasMore());
        }
        if (this.uYe.scene == 1 && this.uYd.getAdapter().RqM.size() == 0) {
            if (!(iResponse3 instanceof FinderLiveLotteryHistoryLoader.c)) {
                iResponse2 = null;
            } else {
                iResponse2 = iResponse3;
            }
            FinderLiveLotteryHistoryLoader.c cVar = (FinderLiveLotteryHistoryLoader.c) iResponse2;
            if (!(cVar == null || (aoVar = cVar.tWa) == null)) {
                this.uYd.getAdapter().a((g) aoVar, (g.b) true);
            }
        }
        x xVar = x.SXb;
        AppMethodBeat.o(249858);
        return xVar;
    }
}
