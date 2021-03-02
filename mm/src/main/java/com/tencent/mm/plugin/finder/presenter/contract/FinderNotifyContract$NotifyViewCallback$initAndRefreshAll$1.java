package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "invoke"})
public final class FinderNotifyContract$NotifyViewCallback$initAndRefreshAll$1 extends q implements b<Void, x> {
    final /* synthetic */ FinderNotifyContract.NotifyViewCallback uZd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderNotifyContract$NotifyViewCallback$initAndRefreshAll$1(FinderNotifyContract.NotifyViewCallback notifyViewCallback) {
        super(1);
        this.uZd = notifyViewCallback;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(Void r10) {
        AppMethodBeat.i(249936);
        FinderNotifyContract.NotifyPresenter notifyPresenter = this.uZd.uZa;
        FinderNotifyContract finderNotifyContract = FinderNotifyContract.uYK;
        int dlX = FinderNotifyContract.dlX();
        int size = notifyPresenter.uYR.size();
        for (int i2 = 0; i2 < size; i2++) {
            notifyPresenter.a(MAlarmHandler.NEXT_FIRE_INTERVAL, dlX, i2, false, true);
        }
        x xVar = x.SXb;
        AppMethodBeat.o(249936);
        return xVar;
    }
}
