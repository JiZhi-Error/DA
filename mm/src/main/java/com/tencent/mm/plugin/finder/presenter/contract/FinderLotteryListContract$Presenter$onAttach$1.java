package com.tencent.mm.plugin.finder.presenter.contract;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.ar;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryListContract;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.g;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "resp", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
public final class FinderLotteryListContract$Presenter$onAttach$1 extends q implements b<IResponse<bo>, x> {
    final /* synthetic */ FinderLotteryListContract.Presenter uYj;
    final /* synthetic */ BaseFinderLotteryContract.ViewCallback uYk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLotteryListContract$Presenter$onAttach$1(FinderLotteryListContract.Presenter presenter, BaseFinderLotteryContract.ViewCallback viewCallback) {
        super(1);
        this.uYj = presenter;
        this.uYk = viewCallback;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
        IResponse<bo> iResponse2;
        awi awi;
        List<bo> incrementList;
        RefreshLoadMoreLayout rlLayout;
        AppMethodBeat.i(249868);
        IResponse<bo> iResponse3 = iResponse;
        p.h(iResponse3, "resp");
        BaseFinderLotteryContract.ViewCallback viewCallback = this.uYj.uWf;
        if (!(viewCallback == null || (rlLayout = viewCallback.getRlLayout()) == null)) {
            rlLayout.setEnableLoadMore(iResponse3.getHasMore());
        }
        boolean z = this.uYj.getAdapter().hgt() == 0 && (incrementList = iResponse3.getIncrementList()) != null && incrementList.size() == 0;
        if (!(iResponse3 instanceof FinderLiveLotteryListLoader.c)) {
            iResponse2 = null;
        } else {
            iResponse2 = iResponse3;
        }
        FinderLiveLotteryListLoader.c cVar = (FinderLiveLotteryListLoader.c) iResponse2;
        if (!(cVar == null || (awi = cVar.tWe) == null)) {
            if (this.uYj.getAdapter().RqM.size() == 0) {
                this.uYj.getAdapter().a((g) new ar(awi, z), (g.b) true);
            }
            if (this.uYj.uYh != ((FinderLiveLotteryListLoader.c) iResponse3).tWf) {
                this.uYj.uYh = ((FinderLiveLotteryListLoader.c) iResponse3).tWf;
                this.uYj.getAdapter().notifyDataSetChanged();
            }
        }
        if (z) {
            d.h(new a<x>(this) {
                /* class com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryListContract$Presenter$onAttach$1.AnonymousClass2 */
                final /* synthetic */ FinderLotteryListContract$Presenter$onAttach$1 uYl;

                {
                    this.uYl = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(249867);
                    View findViewById = this.uYl.uYk.activity.findViewById(R.id.c3e);
                    p.g(findViewById, "activity.findViewById<View>(R.id.empty_view)");
                    findViewById.setVisibility(0);
                    x xVar = x.SXb;
                    AppMethodBeat.o(249867);
                    return xVar;
                }
            });
        }
        x xVar = x.SXb;
        AppMethodBeat.o(249868);
        return xVar;
    }
}
