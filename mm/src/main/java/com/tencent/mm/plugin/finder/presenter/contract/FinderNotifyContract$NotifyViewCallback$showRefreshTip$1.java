package com.tencent.mm.plugin.finder.presenter.contract;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
public final class FinderNotifyContract$NotifyViewCallback$showRefreshTip$1 extends q implements a<x> {
    final /* synthetic */ boolean uYH;
    final /* synthetic */ int uYI;
    final /* synthetic */ FinderNotifyContract.NotifyViewCallback uZd;
    final /* synthetic */ String uZg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderNotifyContract$NotifyViewCallback$showRefreshTip$1(FinderNotifyContract.NotifyViewCallback notifyViewCallback, String str, boolean z, int i2) {
        super(0);
        this.uZd = notifyViewCallback;
        this.uZg = str;
        this.uYH = z;
        this.uYI = i2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.g.a.a
    public final /* synthetic */ x invoke() {
        AppMethodBeat.i(249948);
        if (!Util.isNullOrNil(this.uZg)) {
            TextView f2 = FinderNotifyContract.NotifyViewCallback.f(this.uZd);
            if (f2 != null) {
                f2.setVisibility(0);
                f2.setText(this.uZg);
                f2.setClickable(this.uYH);
                f2.setTextColor(this.uYI);
            }
        } else {
            TextView f3 = FinderNotifyContract.NotifyViewCallback.f(this.uZd);
            if (f3 != null) {
                f3.setVisibility(8);
            }
        }
        x xVar = x.SXb;
        AppMethodBeat.o(249948);
        return xVar;
    }
}
