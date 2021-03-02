package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.event.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.upload.action.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
final class FinderLikedFeedContract$LikedTimelinePresenter$getCreateMoreMenuListener$1 implements o.f {
    final /* synthetic */ BaseFinderFeed tEM;
    final /* synthetic */ FinderLikedFeedContract.LikedTimelinePresenter uXi;

    FinderLikedFeedContract$LikedTimelinePresenter$getCreateMoreMenuListener$1(FinderLikedFeedContract.LikedTimelinePresenter likedTimelinePresenter, BaseFinderFeed baseFinderFeed) {
        this.uXi = likedTimelinePresenter;
        this.tEM = baseFinderFeed;
    }

    @Override // com.tencent.mm.ui.base.o.f
    public final void onCreateMMMenu(m mVar) {
        boolean z;
        boolean z2;
        a b2;
        boolean z3 = true;
        AppMethodBeat.i(166488);
        p.g(mVar, "menu");
        if (mVar.gKQ()) {
            Context context = MMApplicationContext.getContext();
            String string = context.getString(R.string.yz);
            p.g(string, "context.getString(R.string.app_share_to_weixin)");
            String string2 = context.getString(R.string.d9p);
            p.g(string2, "context.getString(R.string.finder_share_timeline)");
            p.g(context.getString(R.string.c8z), "context.getString(R.string.favorite)");
            if (this.tEM.feedObject.isOnlySelfSee() || this.tEM.feedObject.isNotShare()) {
                y yVar = y.vXH;
                string = y.dP("FinderSafeSelfSeeForward", R.string.d8u);
                y yVar2 = y.vXH;
                string2 = y.dP("FinderSafeSelfSeeShare", R.string.d8v);
                y yVar3 = y.vXH;
                y.dP("FinderSafeSelfSeeCollect", R.string.d8t);
                z = true;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            p.g(context, "context");
            mVar.a(FinderLikedFeedContract.LikedTimelinePresenter.a(this.uXi), string, R.raw.finder_icons_filled_share, context.getResources().getColor(R.color.Brand), z2);
            mVar.a(FinderLikedFeedContract.LikedTimelinePresenter.b(this.uXi), string2, R.raw.bottomsheet_icon_moment, 0, z);
            FinderLikedFeedContract finderLikedFeedContract = FinderLikedFeedContract.uXb;
            if (FinderLikedFeedContract.dlU()) {
                c.a aVar = c.vUa;
                if (c.vTZ.k(this.tEM.feedObject.getFeedObject())) {
                    z3 = false;
                }
                if (z3) {
                    mVar.a(FinderLikedFeedContract.LikedTimelinePresenter.c(this.uXi), context.getString(R.string.c8z), R.raw.finder_icons_filled_star2, context.getResources().getColor(R.color.a3b));
                } else {
                    mVar.a(FinderLikedFeedContract.LikedTimelinePresenter.d(this.uXi), context.getString(R.string.cir), R.raw.finder_icons_filled_unstar2, context.getResources().getColor(R.color.a3b));
                }
            }
            k kVar = k.vfA;
            k.I(this.tEM.lT(), 2);
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.uXi.gte);
            if (!(fH == null || (b2 = FinderReporterUIC.b(fH)) == null)) {
                b2.cZR().Ew(this.tEM.lT());
                AppMethodBeat.o(166488);
                return;
            }
        }
        AppMethodBeat.o(166488);
    }
}
