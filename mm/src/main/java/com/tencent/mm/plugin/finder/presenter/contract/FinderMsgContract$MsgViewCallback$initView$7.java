package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "invoke"})
final class FinderMsgContract$MsgViewCallback$initView$7 extends q implements b<Void, Integer> {
    final /* synthetic */ FinderMsgContract.MsgViewCallback uYD;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderMsgContract$MsgViewCallback$initView$7(FinderMsgContract.MsgViewCallback msgViewCallback) {
        super(1);
        this.uYD = msgViewCallback;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ Integer invoke(Void r9) {
        AppMethodBeat.i(249898);
        FinderMsgContract.MsgPresenter b2 = FinderMsgContract.MsgViewCallback.b(this.uYD);
        FinderMsgContract finderMsgContract = FinderMsgContract.uYn;
        Integer valueOf = Integer.valueOf(b2.a(MAlarmHandler.NEXT_FIRE_INTERVAL, FinderMsgContract.dlX(), false, true));
        AppMethodBeat.o(249898);
        return valueOf;
    }
}
