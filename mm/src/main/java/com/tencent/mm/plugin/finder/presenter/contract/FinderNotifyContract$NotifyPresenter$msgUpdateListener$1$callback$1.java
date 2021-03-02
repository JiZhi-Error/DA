package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
final class FinderNotifyContract$NotifyPresenter$msgUpdateListener$1$callback$1 extends q implements a<x> {
    final /* synthetic */ long tZG;
    final /* synthetic */ FinderNotifyContract$NotifyPresenter$msgUpdateListener$1 uYV;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderNotifyContract$NotifyPresenter$msgUpdateListener$1$callback$1(FinderNotifyContract$NotifyPresenter$msgUpdateListener$1 finderNotifyContract$NotifyPresenter$msgUpdateListener$1, long j2) {
        super(0);
        this.uYV = finderNotifyContract$NotifyPresenter$msgUpdateListener$1;
        this.tZG = j2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.g.a.a
    public final /* synthetic */ x invoke() {
        AppMethodBeat.i(249909);
        int i2 = 0;
        for (Object obj : this.uYV.uYS.uYO) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            int i4 = 0;
            for (Object obj2 : (ArrayList) obj) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    j.hxH();
                }
                if (((com.tencent.mm.plugin.finder.model.a) obj2).uNF.field_id == this.tZG) {
                    Log.i(this.uYV.uYS.TAG, "msgUpdateListener event index " + i4 + " tabIndex" + i2);
                    WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.a> wxRecyclerAdapter = ((FinderNotifyContract.NotifyViewCallback) this.uYV.uYS.uYN.get(i2)).tFp;
                    if (wxRecyclerAdapter != null) {
                        wxRecyclerAdapter.ci(i4);
                        i4 = i5;
                    }
                }
                i4 = i5;
            }
            i2 = i3;
        }
        x xVar = x.SXb;
        AppMethodBeat.o(249909);
        return xVar;
    }
}
