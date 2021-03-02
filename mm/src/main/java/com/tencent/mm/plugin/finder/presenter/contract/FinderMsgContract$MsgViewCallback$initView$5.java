package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.model.a;
import com.tencent.mm.plugin.finder.model.bc;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$initView$5", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
public final class FinderMsgContract$MsgViewCallback$initView$5 implements g.c<h> {
    final /* synthetic */ FinderMsgContract.MsgViewCallback uYD;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FinderMsgContract$MsgViewCallback$initView$5(FinderMsgContract.MsgViewCallback msgViewCallback) {
        this.uYD = msgViewCallback;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.view.recyclerview.g.c
    public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(249892);
        h hVar2 = hVar;
        p.h(aVar, "adapter");
        p.h(view, "view");
        p.h(hVar2, "holder");
        int size = i2 - ((g) aVar).RqM.size();
        if (size >= 0 && size < FinderMsgContract.MsgViewCallback.b(this.uYD).kgc.size()) {
            a aVar2 = FinderMsgContract.MsgViewCallback.b(this.uYD).kgc.get(size);
            p.g(aVar2, "presenter.getData()[fixPos]");
            a aVar3 = aVar2;
            if (!(aVar3 instanceof bc)) {
                ao aoVar = aVar3.uNF;
                Log.i(FinderMsgContract.MsgViewCallback.c(this.uYD), "onClick " + size + " id:" + aoVar.field_id + " commentId:" + aoVar.field_commentId);
                FinderMsgContract.MsgViewCallback.UICallbackListener e2 = FinderMsgContract.MsgViewCallback.e(this.uYD);
                if (e2 != null) {
                    e2.a(aoVar);
                }
                if (FinderMsgContract.MsgViewCallback.b(this.uYD).scene == 1 && FinderMsgContract.MsgViewCallback.b(this.uYD).tvu == 1 && size == 0) {
                    e aAh = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh, "MMKernel.storage()");
                    int i7 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_MSG_SYSTEM_INT_SYNC, 0);
                    k kVar = k.vfA;
                    k.ai(i7, 2);
                    com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    com.tencent.mm.plugin.finder.utils.a.fy(this.uYD.gte);
                    if (i7 > 0) {
                        k kVar2 = k.vfA;
                        FinderReporterUIC.a aVar5 = FinderReporterUIC.wzC;
                        FinderReporterUIC fH = FinderReporterUIC.a.fH(FinderMsgContract.MsgViewCallback.d(this.uYD));
                        k.a("5", 4, 2, 5, 0, i7, (String) null, (String) null, 0, fH != null ? fH.dIx() : null, 0, 0, 3520);
                    }
                    com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                    p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
                    com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah).getRedDotManager().asX("NotificitionCenterNotify");
                    com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                    p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
                    bdo asW = ((PluginFinder) ah2).getRedDotManager().asW("NotificitionCenterNotify");
                    if (!(asX == null || asW == null)) {
                        j jVar = j.vft;
                        FinderReporterUIC.a aVar6 = FinderReporterUIC.wzC;
                        FinderReporterUIC fH2 = FinderReporterUIC.a.fH(FinderMsgContract.MsgViewCallback.d(this.uYD));
                        j.a("5", asX, asW, 2, fH2 != null ? fH2.dIx() : null, 0, 0, 96);
                        com.tencent.mm.kernel.b.a ah3 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                        p.g(ah3, "MMKernel.plugin(PluginFinder::class.java)");
                        ((PluginFinder) ah3).getRedDotManager().asV("NotificitionCenterNotify");
                        com.tencent.mm.kernel.b.a ah4 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                        p.g(ah4, "MMKernel.plugin(PluginFinder::class.java)");
                        ((PluginFinder) ah4).getRedDotManager().asV("AuthorProfileNotify");
                        AppMethodBeat.o(249892);
                        return;
                    }
                } else if (aoVar.field_type == 1) {
                    k kVar3 = k.vfA;
                    int i8 = aoVar.field_type;
                    if (aoVar.isOverlap()) {
                        i6 = 1;
                    } else {
                        i6 = 0;
                    }
                    k.d(i8, i6, aoVar.dym(), aVar3.uNF.field_objectId);
                    com.tencent.mm.plugin.finder.utils.a aVar7 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    com.tencent.mm.plugin.finder.utils.a.fz(this.uYD.gte);
                    AppMethodBeat.o(249892);
                    return;
                } else if (aoVar.field_type == 10 || aoVar.field_type == 11) {
                    if (aoVar.field_type == 11 && !Util.isNullOrNil(aoVar.field_username)) {
                        Intent intent = new Intent();
                        intent.putExtra("finder_username", aoVar.field_username);
                        FinderReporterUIC.a aVar8 = FinderReporterUIC.wzC;
                        Context context = hVar2.getContext();
                        p.g(context, "holder.context");
                        FinderReporterUIC.a.a(context, intent, 0, 9, false, 64);
                        com.tencent.mm.plugin.finder.utils.a aVar9 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        Context context2 = hVar2.getContext();
                        p.g(context2, "holder.context");
                        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context2, intent);
                        AppMethodBeat.o(249892);
                        return;
                    }
                } else if (aoVar.field_type == 2 && (aoVar.field_extFlag & 16) > 0) {
                    k kVar4 = k.vfA;
                    int i9 = aoVar.field_type;
                    if (aoVar.isOverlap()) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                    k.d(i9, i5, aoVar.dym(), aVar3.uNF.field_objectId);
                    FinderMsgContract.MsgViewCallback.a(this.uYD, aoVar);
                    AppMethodBeat.o(249892);
                    return;
                } else if (aoVar.field_type != 4) {
                    k kVar5 = k.vfA;
                    int i10 = aoVar.field_type;
                    if (aoVar.isOverlap()) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    k.d(i10, i4, aoVar.dym(), aVar3.uNF.field_objectId);
                    af f2 = FinderMsgContract.MsgViewCallback.f(this.uYD);
                    if (f2 != null) {
                        f2.cancel();
                    }
                    FinderMsgContract.MsgViewCallback.b(this.uYD, aoVar);
                    AppMethodBeat.o(249892);
                    return;
                } else {
                    k kVar6 = k.vfA;
                    int i11 = aoVar.field_type;
                    if (aoVar.isOverlap()) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    k.d(i11, i3, aoVar.dym(), aVar3.uNF.field_objectId);
                    azp azp = aoVar.field_notify;
                    if (azp != null) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(20849, aoVar.field_notify.subType + ",2," + d.zs(aoVar.field_id));
                        switch (azp.subType) {
                            case 1:
                                ((r) com.tencent.mm.kernel.g.af(r.class)).a(FinderMsgContract.MsgViewCallback.d(this.uYD), azp.LJu, "", 0, 0, azp.link, new AppBrandStatObject());
                                AppMethodBeat.o(249892);
                                return;
                            case 2:
                                Intent intent2 = new Intent();
                                intent2.putExtra("rawUrl", azp.link);
                                c.b(FinderMsgContract.MsgViewCallback.d(this.uYD), "webview", ".ui.tools.WebViewUI", intent2);
                                AppMethodBeat.o(249892);
                                return;
                            case 3:
                            case 4:
                                af f3 = FinderMsgContract.MsgViewCallback.f(this.uYD);
                                if (f3 != null) {
                                    f3.cancel();
                                }
                                FinderMsgContract.MsgViewCallback.b(this.uYD, aoVar);
                                break;
                        }
                        AppMethodBeat.o(249892);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.o(249892);
    }
}
