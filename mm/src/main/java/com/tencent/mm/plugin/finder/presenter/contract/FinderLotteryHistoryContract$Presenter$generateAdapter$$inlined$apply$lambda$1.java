package com.tencent.mm.plugin.finder.presenter.contract;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.an;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryHistoryContract;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter$generateAdapter$2$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
public final class FinderLotteryHistoryContract$Presenter$generateAdapter$$inlined$apply$lambda$1 implements g.c<h> {
    final /* synthetic */ FinderLotteryHistoryContract.Presenter uYd;

    FinderLotteryHistoryContract$Presenter$generateAdapter$$inlined$apply$lambda$1(FinderLotteryHistoryContract.Presenter presenter) {
        this.uYd = presenter;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
    @Override // com.tencent.mm.view.recyclerview.g.c
    public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
        AppMethodBeat.i(249856);
        h hVar2 = hVar;
        p.h(aVar, "adapter");
        p.h(view, "view");
        p.h(hVar2, "holder");
        if (i2 - ((g) aVar).RqM.size() < 0) {
            AppMethodBeat.o(249856);
            return;
        }
        an anVar = (an) hVar2.hgv();
        Intent intent = new Intent();
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        Context context = hVar2.getContext();
        p.g(context, "holder.context");
        FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
        if (this.uYd.scene == 2) {
            intent.putExtra("KEY_LIVE_ANCHOR_USERNAME", this.uYd.hwd);
            intent.putExtra("KEY_LOTTERY_HISTORY_INFO", anVar.tWe.toByteArray());
            a aVar3 = a.vUU;
            Context context2 = hVar2.getContext();
            if (context2 == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(249856);
                throw tVar;
            }
            a.g((Activity) context2, intent);
            m.vli.a(s.ay.CLICK_WIN_ITEM_ENTER_DETAIL, "");
            AppMethodBeat.o(249856);
            return;
        }
        intent.putExtra("KEY_LOTTERY_HISTORY_LIVE_ID", this.uYd.liveId);
        intent.putExtra("KEY_LOTTERY_HISTORY_OBJECT_ID", this.uYd.hFK);
        intent.putExtra("KEY_LOTTERY_HISTORY_OBJECT_NONCE_ID", this.uYd.objectNonceId);
        intent.putExtra("KEY_LOTTERY_ID", anVar.tWe.id);
        Context context3 = hVar2.getContext();
        if (context3 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(249856);
            throw tVar2;
        }
        intent.putExtra("KEY_SHOW_SETTING_TITLE", ((Activity) context3).getIntent().getBooleanExtra("KEY_SHOW_SETTING_TITLE", false));
        a aVar4 = a.vUU;
        Context context4 = hVar2.getContext();
        if (context4 == null) {
            t tVar3 = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(249856);
            throw tVar3;
        }
        a.h((Activity) context4, intent);
        k kVar = k.vkd;
        k.a(s.f.CLICK_LOTTERY_RECORD_LIST_ENTER_WINNER_LIST_UI, "");
        AppMethodBeat.o(249856);
    }
}
