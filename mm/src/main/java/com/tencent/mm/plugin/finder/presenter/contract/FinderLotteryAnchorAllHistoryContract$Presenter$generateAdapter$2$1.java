package com.tencent.mm.plugin.finder.presenter.contract;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.an;
import com.tencent.mm.plugin.finder.model.ap;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderLotteryAnchorAllHistoryContract$Presenter$generateAdapter$2$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
public final class FinderLotteryAnchorAllHistoryContract$Presenter$generateAdapter$2$1 implements g.c<h> {
    FinderLotteryAnchorAllHistoryContract$Presenter$generateAdapter$2$1() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
    @Override // com.tencent.mm.view.recyclerview.g.c
    public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
        AppMethodBeat.i(249848);
        h hVar2 = hVar;
        p.h(aVar, "adapter");
        p.h(view, "view");
        p.h(hVar2, "holder");
        ap apVar = (ap) hVar2.hgv();
        Intent intent = new Intent();
        LinkedList<awi> linkedList = apVar.uOB.LHe;
        p.g(linkedList, "item.lotteryRecord.lotteryInfo");
        LinkedList<awi> linkedList2 = linkedList;
        ArrayList arrayList = new ArrayList(j.a(linkedList2, 10));
        for (T t : linkedList2) {
            p.g(t, LocaleUtil.ITALIAN);
            arrayList.add(new an(t));
        }
        y yVar = y.vXH;
        y.a(0, arrayList, (b) null, intent);
        intent.putExtra("KEY_LOTTERY_HISTORY_SCENE", 1);
        intent.putExtra("KEY_LOTTERY_HISTORY_LIVE_ID", apVar.uOB.liveId);
        intent.putExtra("KEY_LOTTERY_HISTORY_OBJECT_ID", apVar.uOB.hFK);
        intent.putExtra("KEY_LOTTERY_HISTORY_OBJECT_NONCE_ID", apVar.uOB.objectNonceId);
        intent.putExtra("KEY_LIVE_ANCHOR_USERNAME", z.aUg());
        intent.putExtra("KEY_SHOW_SETTING_TITLE", true);
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        Context context = hVar2.getContext();
        p.g(context, "holder.context");
        FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
        a aVar3 = a.vUU;
        Context context2 = view.getContext();
        if (context2 == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(249848);
            throw tVar;
        }
        a.f((Activity) context2, intent);
        AppMethodBeat.o(249848);
    }
}
