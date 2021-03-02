package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
final class FinderMsgContract$MsgPresenter$msgUpdateListener$1$callback$1 extends q implements a<x> {
    final /* synthetic */ long tZG;
    final /* synthetic */ FinderMsgContract$MsgPresenter$msgUpdateListener$1 uYv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderMsgContract$MsgPresenter$msgUpdateListener$1$callback$1(FinderMsgContract$MsgPresenter$msgUpdateListener$1 finderMsgContract$MsgPresenter$msgUpdateListener$1, long j2) {
        super(0);
        this.uYv = finderMsgContract$MsgPresenter$msgUpdateListener$1;
        this.tZG = j2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.g.a.a
    public final /* synthetic */ x invoke() {
        WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.a> wxRecyclerAdapter;
        AppMethodBeat.i(249878);
        Log.i(this.uYv.uYu.TAG, "msgUpdateListener event id " + this.tZG);
        int i2 = 0;
        for (Object obj : this.uYv.uYu.kgc) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            if (((com.tencent.mm.plugin.finder.model.a) obj).uNF.field_id == this.tZG) {
                Log.i(this.uYv.uYu.TAG, "msgUpdateListener event index ".concat(String.valueOf(i2)));
                FinderMsgContract.MsgViewCallback msgViewCallback = this.uYv.uYu.uYo;
                if (!(msgViewCallback == null || (wxRecyclerAdapter = msgViewCallback.tFp) == null)) {
                    wxRecyclerAdapter.ci(i2);
                    i2 = i3;
                }
            }
            i2 = i3;
        }
        x xVar = x.SXb;
        AppMethodBeat.o(249878);
        return xVar;
    }
}
