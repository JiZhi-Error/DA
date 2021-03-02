package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
public final class FinderBlockListContract$BlockListViewCallback$initView$2 implements Runnable {
    final /* synthetic */ FinderBlockListContract.BlockListViewCallback uWu;

    public FinderBlockListContract$BlockListViewCallback$initView$2(FinderBlockListContract.BlockListViewCallback blockListViewCallback) {
        this.uWu = blockListViewCallback;
    }

    public final void run() {
        AppMethodBeat.i(249692);
        FinderBlockListContract.BlockListViewCallback.b(this.uWu);
        AppMethodBeat.o(249692);
    }
}
