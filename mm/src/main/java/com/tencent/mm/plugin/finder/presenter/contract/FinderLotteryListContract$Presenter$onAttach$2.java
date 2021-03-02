package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.aq;
import com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryListContract;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.view.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.HashSet;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH\u0016J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter$onAttach$2", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "exposedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getExposedSet", "()Ljava/util/HashSet;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
public final class FinderLotteryListContract$Presenter$onAttach$2 extends e.a {
    private final HashSet<Long> tDu = new HashSet<>();
    final /* synthetic */ FinderLotteryListContract.Presenter uYj;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FinderLotteryListContract$Presenter$onAttach$2(FinderLotteryListContract.Presenter presenter) {
        this.uYj = presenter;
        AppMethodBeat.i(249870);
        AppMethodBeat.o(249870);
    }

    @Override // com.tencent.mm.view.e.a
    public final void b(View view, List<? extends RecyclerView.v> list) {
        AppMethodBeat.i(249869);
        p.h(view, "parent");
        p.h(list, "exposedHolders");
        for (T t : list) {
            if (t instanceof h) {
                Object hgv = t.hgv();
                if ((hgv instanceof aq) && !this.tDu.contains(Long.valueOf((long) ((aq) hgv).hashCode()))) {
                    d dVar = d.vdp;
                    d.b dnK = d.dnK();
                    String aUg = z.aUg();
                    p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                    String str = ((aq) hgv).uOC.username;
                    if (str == null) {
                        str = "";
                    }
                    dnK.ah(aUg, str, "");
                    d dVar2 = d.vdp;
                    d.b dnK2 = d.dnK();
                    FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                    BaseFinderLotteryContract.ViewCallback viewCallback = this.uYj.uWf;
                    if (viewCallback == null) {
                        p.hyc();
                    }
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(viewCallback.activity);
                    dnK2.a(fH != null ? fH.dIx() : null, 4);
                    this.tDu.add(Long.valueOf((long) ((aq) hgv).hashCode()));
                }
            }
        }
        AppMethodBeat.o(249869);
    }
}
