package com.tencent.mm.plugin.finder.presenter.contract;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
final class FinderNotifyContract$NotifyPresenter$loadDataAndRefresh$1 extends q implements a<x> {
    final /* synthetic */ int puW;
    final /* synthetic */ boolean tGv;
    final /* synthetic */ long tZG;
    final /* synthetic */ FinderNotifyContract.NotifyPresenter uYS;
    final /* synthetic */ int uYT;
    final /* synthetic */ boolean uYU;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderNotifyContract$NotifyPresenter$loadDataAndRefresh$1(FinderNotifyContract.NotifyPresenter notifyPresenter, long j2, int i2, int i3, boolean z, boolean z2) {
        super(0);
        this.uYS = notifyPresenter;
        this.tZG = j2;
        this.puW = i2;
        this.uYT = i3;
        this.uYU = z;
        this.tGv = z2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.g.a.a
    public final /* synthetic */ x invoke() {
        long j2 = 0;
        AppMethodBeat.i(249908);
        ArrayList a2 = FinderNotifyContract.NotifyPresenter.a(this.uYS, this.tZG, this.puW, this.uYT);
        Log.i(FinderNotifyContract.NotifyPresenter.b(this.uYS), "tobe mergeData from db data from DB:" + a2.size());
        FinderNotifyContract.NotifyPresenter.a(this.uYS, a2, this.puW);
        FinderNotifyContract.NotifyViewCallback b2 = FinderNotifyContract.NotifyPresenter.b(this.uYS, this.puW);
        if (b2 != null) {
            ArrayList arrayList = a2;
            boolean z = this.uYU;
            boolean z2 = this.tGv;
            p.h(arrayList, "msgList");
            z.d dVar = new z.d();
            dVar.SYE = b2.uZa.JV(b2.uZc).size();
            Log.i(b2.TAG, "presenter.getData(" + b2.uZc + ": " + b2.uZa.JV(b2.uZc).hashCode() + " --- " + b2.uZa.JV(b2.uZc) + ')');
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                FinderNotifyContract finderNotifyContract = FinderNotifyContract.uYK;
                long JU = uptimeMillis - FinderNotifyContract.JU(b2.uZc);
                c cVar = c.vCb;
                if (JU < c.dty().value().longValue()) {
                    c cVar2 = c.vCb;
                    j2 = c.dty().value().longValue() - JU;
                }
            }
            d.a(j2, new FinderNotifyContract$NotifyViewCallback$finishLoadMore$1(b2, z2, arrayList, dVar));
        }
        x xVar = x.SXb;
        AppMethodBeat.o(249908);
        return xVar;
    }
}
