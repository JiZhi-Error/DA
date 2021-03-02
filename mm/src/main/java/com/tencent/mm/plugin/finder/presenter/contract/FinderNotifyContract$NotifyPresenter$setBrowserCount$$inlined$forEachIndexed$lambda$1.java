package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract;
import com.tencent.mm.view.recyclerview.a;
import com.tencent.mm.view.recyclerview.k;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "v", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "invoke", "com/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter$setBrowserCount$1$1"})
final class FinderNotifyContract$NotifyPresenter$setBrowserCount$$inlined$forEachIndexed$lambda$1 extends q implements m<Long, k, x> {
    final /* synthetic */ FinderNotifyContract.NotifyPresenter uYS;
    final /* synthetic */ long uYX;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderNotifyContract$NotifyPresenter$setBrowserCount$$inlined$forEachIndexed$lambda$1(long j2, FinderNotifyContract.NotifyPresenter notifyPresenter) {
        super(2);
        this.uYX = j2;
        this.uYS = notifyPresenter;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.g.a.m
    public final /* synthetic */ x invoke(Long l, k kVar) {
        AppMethodBeat.i(249913);
        l.longValue();
        k kVar2 = kVar;
        p.h(kVar2, "v");
        a aVar = kVar2.Rrp;
        if (aVar instanceof com.tencent.mm.plugin.finder.model.a) {
            if (aVar.lT() < this.uYX || this.uYX == 0) {
                switch (((com.tencent.mm.plugin.finder.model.a) aVar).uNF.field_type) {
                    case 1:
                        dc a2 = FinderNotifyContract.NotifyPresenter.a(this.uYS);
                        a2.iT(a2.aeX() + 1);
                        break;
                    case 2:
                        dc a3 = FinderNotifyContract.NotifyPresenter.a(this.uYS);
                        a3.iU(a3.aeY() + 1);
                        break;
                    case 3:
                        dc a4 = FinderNotifyContract.NotifyPresenter.a(this.uYS);
                        a4.iV(a4.aeZ() + 1);
                        break;
                    case 5:
                        dc a5 = FinderNotifyContract.NotifyPresenter.a(this.uYS);
                        a5.iW(a5.afa() + 1);
                        break;
                }
                dc a6 = FinderNotifyContract.NotifyPresenter.a(this.uYS);
                a6.iO(a6.aeS() + 1);
            } else {
                switch (((com.tencent.mm.plugin.finder.model.a) aVar).uNF.field_type) {
                    case 1:
                        dc a7 = FinderNotifyContract.NotifyPresenter.a(this.uYS);
                        a7.iP(a7.aeT() + 1);
                        break;
                    case 2:
                        dc a8 = FinderNotifyContract.NotifyPresenter.a(this.uYS);
                        a8.iQ(a8.aeU() + 1);
                        break;
                    case 3:
                        dc a9 = FinderNotifyContract.NotifyPresenter.a(this.uYS);
                        a9.iR(a9.aeV() + 1);
                        break;
                    case 5:
                        dc a10 = FinderNotifyContract.NotifyPresenter.a(this.uYS);
                        a10.iS(a10.aeW() + 1);
                        break;
                }
                dc a11 = FinderNotifyContract.NotifyPresenter.a(this.uYS);
                a11.iN(a11.aeR() + 1);
            }
            dc a12 = FinderNotifyContract.NotifyPresenter.a(this.uYS);
            a12.iM(a12.aeQ() + 1);
        }
        x xVar = x.SXb;
        AppMethodBeat.o(249913);
        return xVar;
    }
}
