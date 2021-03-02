package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.live.widget.v;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveWeCoinHotConstract;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", ch.COL_USERNAME, "", "invoke", "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback$initView$4$2"})
public final class FinderLiveWeCoinHotConstract$ViewCallback$initView$$inlined$apply$lambda$1 extends q implements b<String, x> {
    final /* synthetic */ v USB;
    final /* synthetic */ FinderLiveWeCoinHotConstract.ViewCallback uXY;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLiveWeCoinHotConstract$ViewCallback$initView$$inlined$apply$lambda$1(v vVar, FinderLiveWeCoinHotConstract.ViewCallback viewCallback) {
        super(1);
        this.USB = vVar;
        this.uXY = viewCallback;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(String str) {
        AppMethodBeat.i(261269);
        String str2 = str;
        String str3 = str2;
        if (str3 == null || str3.length() == 0) {
            Log.e(this.USB.TAG, "gotoProfileCallback username:".concat(String.valueOf(str2)));
        } else if (this.uXY.uXX != null) {
            FinderLiveWeCoinHotConstract.Presenter.bD(this.uXY.activity, str2);
        }
        x xVar = x.SXb;
        AppMethodBeat.o(261269);
        return xVar;
    }
}
