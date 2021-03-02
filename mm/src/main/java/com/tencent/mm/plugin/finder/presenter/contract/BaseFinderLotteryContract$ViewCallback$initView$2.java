package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
public final class BaseFinderLotteryContract$ViewCallback$initView$2 extends q implements a<x> {
    final /* synthetic */ BaseFinderLotteryContract.ViewCallback uWk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseFinderLotteryContract$ViewCallback$initView$2(BaseFinderLotteryContract.ViewCallback viewCallback) {
        super(0);
        this.uWk = viewCallback;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.g.a.a
    public final /* synthetic */ x invoke() {
        AppMethodBeat.i(249675);
        this.uWk.uWj.uWg.requestRefresh();
        x xVar = x.SXb;
        AppMethodBeat.o(249675);
        return xVar;
    }
}
