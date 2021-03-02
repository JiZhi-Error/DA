package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
public final class FinderMsgContract$MsgViewCallback$showRefreshTip$1 extends q implements a<x> {
    final /* synthetic */ String hRn;
    final /* synthetic */ FinderMsgContract.MsgViewCallback uYD;
    final /* synthetic */ boolean uYH;
    final /* synthetic */ int uYI;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderMsgContract$MsgViewCallback$showRefreshTip$1(FinderMsgContract.MsgViewCallback msgViewCallback, String str, boolean z, int i2) {
        super(0);
        this.uYD = msgViewCallback;
        this.hRn = str;
        this.uYH = z;
        this.uYI = i2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.g.a.a
    public final /* synthetic */ x invoke() {
        AppMethodBeat.i(166556);
        if (!Util.isNullOrNil(this.hRn)) {
            FinderMsgContract.MsgViewCallback.i(this.uYD).setVisibility(0);
            FinderMsgContract.MsgViewCallback.i(this.uYD).setText(this.hRn);
            FinderMsgContract.MsgViewCallback.i(this.uYD).setClickable(this.uYH);
            FinderMsgContract.MsgViewCallback.i(this.uYD).setTextColor(this.uYI);
        } else {
            FinderMsgContract.MsgViewCallback.i(this.uYD).setVisibility(8);
        }
        x xVar = x.SXb;
        AppMethodBeat.o(166556);
        return xVar;
    }
}
