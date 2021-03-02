package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.bd;
import com.tencent.mm.plugin.finder.model.be;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.storage.ar;
import com.tencent.mm.view.recyclerview.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$initView$4", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-finder_release"})
public final class FinderMsgContract$MsgViewCallback$initView$4 implements com.tencent.mm.view.recyclerview.l {
    final /* synthetic */ FinderMsgContract.MsgViewCallback uYD;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FinderMsgContract$MsgViewCallback$initView$4(FinderMsgContract.MsgViewCallback msgViewCallback) {
        this.uYD = msgViewCallback;
    }

    @Override // com.tencent.mm.view.recyclerview.l
    public final void a(RecyclerView recyclerView, j jVar) {
        bbn bbn;
        AppMethodBeat.i(249891);
        p.h(recyclerView, "recyclerView");
        p.h(jVar, "data");
        for (T t : jVar.Rrn) {
            if (t.Rrp.cxn() == be.class.getName().hashCode()) {
                e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_MSG_SYSTEM_INT_SYNC, 0);
                if (i2 > 0) {
                    k kVar = k.vfA;
                    FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(FinderMsgContract.MsgViewCallback.d(this.uYD));
                    k.a("5", 4, 1, 5, 0, i2, (String) null, (String) null, 0, fH != null ? fH.dIx() : null, 0, 0, 3520);
                }
                a ah = g.ah(PluginFinder.class);
                p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
                com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah).getRedDotManager().asX("NotificitionCenterNotify");
                a ah2 = g.ah(PluginFinder.class);
                p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
                bdo asW = ((PluginFinder) ah2).getRedDotManager().asW("NotificitionCenterNotify");
                if (!(asX == null || asW == null)) {
                    com.tencent.mm.plugin.finder.report.j jVar2 = com.tencent.mm.plugin.finder.report.j.vft;
                    FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                    FinderReporterUIC fH2 = FinderReporterUIC.a.fH(FinderMsgContract.MsgViewCallback.d(this.uYD));
                    if (fH2 != null) {
                        bbn = fH2.dIx();
                    } else {
                        bbn = null;
                    }
                    com.tencent.mm.plugin.finder.report.j.a("5", asX, asW, 1, bbn, 0, 0, 96);
                }
            }
            com.tencent.mm.view.recyclerview.a aVar3 = t.Rrp;
            if (aVar3.cxn() == bd.class.getName().hashCode() && (aVar3 instanceof bd) && ((bd) aVar3).uNF.field_notify != null) {
                h.INSTANCE.kvStat(20849, ((bd) aVar3).uNF.field_notify.subType + ",1," + d.zs(((bd) aVar3).uNF.field_id));
            }
        }
        AppMethodBeat.o(249891);
    }
}
