package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract;
import com.tencent.mm.plugin.finder.view.animation.a;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
final class FinderBlockListContract$BlockListViewCallback$initView$5$onRefreshEnd$1 implements Runnable {
    final /* synthetic */ FinderBlockListContract$BlockListViewCallback$initView$5 uWA;

    FinderBlockListContract$BlockListViewCallback$initView$5$onRefreshEnd$1(FinderBlockListContract$BlockListViewCallback$initView$5 finderBlockListContract$BlockListViewCallback$initView$5) {
        this.uWA = finderBlockListContract$BlockListViewCallback$initView$5;
    }

    public final void run() {
        AppMethodBeat.i(249698);
        FinderBlockListContract.BlockListViewCallback.e(this.uWA.uWu).setItemAnimator(new a());
        AppMethodBeat.o(249698);
    }
}
