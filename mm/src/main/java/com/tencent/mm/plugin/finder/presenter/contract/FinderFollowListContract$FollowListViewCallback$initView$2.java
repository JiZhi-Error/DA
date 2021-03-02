package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.af;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
public final class FinderFollowListContract$FollowListViewCallback$initView$2 implements g.c<h> {
    final /* synthetic */ FinderFollowListContract.FollowListViewCallback uWN;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public FinderFollowListContract$FollowListViewCallback$initView$2(FinderFollowListContract.FollowListViewCallback followListViewCallback) {
        this.uWN = followListViewCallback;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
    @Override // com.tencent.mm.view.recyclerview.g.c
    public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
        AppMethodBeat.i(249729);
        p.h(aVar, "adapter");
        p.h(view, "view");
        p.h(hVar, "holder");
        ArrayList<af> arrayList = this.uWN.uWL.kgc;
        if (i2 < arrayList.size()) {
            if (arrayList.get(i2).contact.field_liveStatus == 1) {
                k.vkd.a(null, arrayList.get(i2).contact.getUsername(), (long) i2, s.p.LIVE_AUDIENCE_CLICK_SINGLE_AVATAR, "12");
            }
            Intent intent = new Intent();
            intent.putExtra("finder_username", arrayList.get(i2).contact.getUsername());
            intent.putExtra("from_teen_mode_setting_page", this.uWN.uWM);
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            FinderReporterUIC.a.a(this.uWN.activity, intent, 0, 1, false, 64);
            a aVar3 = a.vUU;
            a.enterFinderProfileUI(this.uWN.activity, intent);
            FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.uWN.activity);
            if (fH != null) {
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.a(6, 0, fH.tCE, 1, arrayList.get(i2).contact.getUsername());
                AppMethodBeat.o(249729);
                return;
            }
        }
        AppMethodBeat.o(249729);
    }
}
