package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
final class FinderMsgContract$MsgPresenter$onSceneEnd$1$runnable$1 implements Runnable {
    final /* synthetic */ boolean uYw;
    final /* synthetic */ FinderMsgContract.MsgViewCallback uYx;

    FinderMsgContract$MsgPresenter$onSceneEnd$1$runnable$1(boolean z, FinderMsgContract.MsgViewCallback msgViewCallback) {
        this.uYw = z;
        this.uYx = msgViewCallback;
    }

    public final void run() {
        AppMethodBeat.i(249880);
        if (this.uYw) {
            this.uYx.o(c.a.a(this.uYx).getString(R.string.d0n), c.a.a(this.uYx).getColor(R.color.BW_0_Alpha_0_9), true);
        }
        this.uYx.dcQ().apS(0);
        AppMethodBeat.o(249880);
    }
}
