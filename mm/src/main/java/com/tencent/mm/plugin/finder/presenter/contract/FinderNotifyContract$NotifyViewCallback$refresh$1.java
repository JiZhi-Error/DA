package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
public final class FinderNotifyContract$NotifyViewCallback$refresh$1 extends q implements a<x> {
    final /* synthetic */ FinderNotifyContract.NotifyViewCallback uZd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderNotifyContract$NotifyViewCallback$refresh$1(FinderNotifyContract.NotifyViewCallback notifyViewCallback) {
        super(0);
        this.uZd = notifyViewCallback;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.g.a.a
    public final /* synthetic */ x invoke() {
        AppMethodBeat.i(249947);
        this.uZd.uZa.am(this.uZd.uZc, true);
        this.uZd.uZa.JW(this.uZd.uZc);
        x xVar = x.SXb;
        AppMethodBeat.o(249947);
        return xVar;
    }
}
