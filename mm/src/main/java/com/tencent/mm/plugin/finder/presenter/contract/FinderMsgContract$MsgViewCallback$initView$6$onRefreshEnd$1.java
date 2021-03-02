package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
final class FinderMsgContract$MsgViewCallback$initView$6$onRefreshEnd$1 implements Runnable {
    final /* synthetic */ FinderMsgContract$MsgViewCallback$initView$6 uYG;

    FinderMsgContract$MsgViewCallback$initView$6$onRefreshEnd$1(FinderMsgContract$MsgViewCallback$initView$6 finderMsgContract$MsgViewCallback$initView$6) {
        this.uYG = finderMsgContract$MsgViewCallback$initView$6;
    }

    public final void run() {
        AppMethodBeat.i(249893);
        FinderMsgContract.MsgViewCallback.g(this.uYG.uYD).setItemAnimator(new v());
        AppMethodBeat.o(249893);
    }
}
