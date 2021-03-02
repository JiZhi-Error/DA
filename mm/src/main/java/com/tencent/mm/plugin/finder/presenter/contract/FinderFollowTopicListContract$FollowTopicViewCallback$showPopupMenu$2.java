package com.tencent.mm.plugin.finder.presenter.contract;

import android.view.MenuItem;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.ck;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.component.a;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
public final class FinderFollowTopicListContract$FollowTopicViewCallback$showPopupMenu$2 implements o.g {
    final /* synthetic */ FinderFollowTopicListContract.FollowTopicViewCallback uWY;
    final /* synthetic */ bds uWZ;

    FinderFollowTopicListContract$FollowTopicViewCallback$showPopupMenu$2(FinderFollowTopicListContract.FollowTopicViewCallback followTopicViewCallback, bds bds) {
        this.uWY = followTopicViewCallback;
        this.uWZ = bds;
    }

    @Override // com.tencent.mm.ui.base.o.g
    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
        AppMethodBeat.i(249773);
        p.g(menuItem, "menuItem");
        if (menuItem.getItemId() == FinderFollowTopicListContract.FollowTopicViewCallback.f(this.uWY)) {
            a aVar = a.PRN;
            bbn dIx = ((FinderReporterUIC) a.b(FinderFollowTopicListContract.FollowTopicViewCallback.d(this.uWY)).get(FinderReporterUIC.class)).dIx();
            dIx.tyh = 12;
            long j2 = this.uWZ.twp;
            String str = this.uWZ.twq;
            if (str == null) {
                str = "";
            }
            ck.a aVar2 = ck.twr;
            g.azz().b(new ck(j2, str, ck.tvc, dIx));
        }
        AppMethodBeat.o(249773);
    }
}
