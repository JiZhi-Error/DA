package com.tencent.mm.plugin.finder.presenter.contract;

import android.view.MenuItem;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.model.ag;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.component.a;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
public final class FinderFollowListContract$FollowListViewCallback$showPopupMenu$2 implements o.g {
    final /* synthetic */ FinderFollowListContract.FollowListViewCallback uWN;
    final /* synthetic */ g uWO;

    FinderFollowListContract$FollowListViewCallback$showPopupMenu$2(FinderFollowListContract.FollowListViewCallback followListViewCallback, g gVar) {
        this.uWN = followListViewCallback;
        this.uWO = gVar;
    }

    @Override // com.tencent.mm.ui.base.o.g
    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
        AppMethodBeat.i(249740);
        p.g(menuItem, "menuItem");
        if (menuItem.getItemId() == FinderFollowListContract.FollowListViewCallback.h(this.uWN)) {
            a aVar = a.PRN;
            bbn dIx = ((FinderReporterUIC) a.b(FinderFollowListContract.FollowListViewCallback.f(this.uWN)).get(FinderReporterUIC.class)).dIx();
            dIx.tyh = 12;
            ag agVar = ag.uOs;
            String username = this.uWO.getUsername();
            bb.a aVar2 = bb.tve;
            com.tencent.mm.kernel.g.azz().b(ag.a(dIx, username, bb.tvc));
            if (FinderFollowListContract.FollowListViewCallback.e(this.uWN)) {
                h.INSTANCE.a(20911, 3, this.uWO.getUsername(), this.uWO.getNickname());
            }
        }
        AppMethodBeat.o(249740);
    }
}
