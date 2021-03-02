package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
final class FinderNotifyContract$NotifyPresenter$refreshEmpty$runnable$1 implements Runnable {
    final /* synthetic */ int puW;
    final /* synthetic */ FinderNotifyContract.NotifyPresenter uYS;
    final /* synthetic */ FinderNotifyContract.NotifyViewCallback uYW;

    FinderNotifyContract$NotifyPresenter$refreshEmpty$runnable$1(FinderNotifyContract.NotifyPresenter notifyPresenter, int i2, FinderNotifyContract.NotifyViewCallback notifyViewCallback) {
        this.uYS = notifyPresenter;
        this.puW = i2;
        this.uYW = notifyViewCallback;
    }

    public final void run() {
        AppMethodBeat.i(249912);
        if (this.uYS.JV(this.puW).isEmpty()) {
            this.uYW.o(c.a.a(this.uYW).getString(R.string.d0n), c.a.a(this.uYW).getColor(R.color.BW_0_Alpha_0_9), true);
        }
        AppMethodBeat.o(249912);
    }
}
