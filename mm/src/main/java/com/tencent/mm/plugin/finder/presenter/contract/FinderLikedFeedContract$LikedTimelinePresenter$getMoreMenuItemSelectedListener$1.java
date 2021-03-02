package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.utils.g;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.v;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "onMMMenuItemSelected", "", "menuItem", "Landroid/view/MenuItem;", FirebaseAnalytics.b.INDEX, "", "plugin-finder_release"})
public final class FinderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1 implements o.g {
    final /* synthetic */ BaseFinderFeed tEM;
    final /* synthetic */ FinderLikedFeedContract.LikedTimelinePresenter uXi;

    FinderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1(FinderLikedFeedContract.LikedTimelinePresenter likedTimelinePresenter, BaseFinderFeed baseFinderFeed) {
        this.uXi = likedTimelinePresenter;
        this.tEM = baseFinderFeed;
    }

    @Override // com.tencent.mm.ui.base.o.g
    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
        int i3;
        MMActivity context;
        MMActivity mMActivity;
        azr azr = null;
        AppMethodBeat.i(166492);
        p.h(menuItem, "menuItem");
        int itemId = menuItem.getItemId();
        if (itemId == FinderLikedFeedContract.LikedTimelinePresenter.a(this.uXi)) {
            s.a aVar = s.vWt;
            FinderLikedFeedContract.LikedTimelineViewCallback g2 = FinderLikedFeedContract.LikedTimelinePresenter.g(this.uXi);
            if (g2 == null) {
                p.hyc();
            }
            s.a.a(aVar, g2.gte, this.tEM.feedObject, 3, 4);
            AppMethodBeat.o(166492);
        } else if (itemId == FinderLikedFeedContract.LikedTimelinePresenter.b(this.uXi)) {
            s.a aVar2 = s.vWt;
            FinderLikedFeedContract.LikedTimelineViewCallback g3 = FinderLikedFeedContract.LikedTimelinePresenter.g(this.uXi);
            if (g3 == null) {
                p.hyc();
            }
            s.a.a(g3.gte, this.tEM, 0, 0, 28);
            AppMethodBeat.o(166492);
        } else if (itemId == FinderLikedFeedContract.LikedTimelinePresenter.h(this.uXi)) {
            g gVar = g.vVq;
            BaseFinderFeed baseFinderFeed = this.tEM;
            FinderLikedFeedContract.LikedTimelineViewCallback g4 = FinderLikedFeedContract.LikedTimelinePresenter.g(this.uXi);
            if (g4 == null) {
                p.hyc();
            }
            g.a(baseFinderFeed, g4.gte);
            AppMethodBeat.o(166492);
        } else if (itemId == FinderLikedFeedContract.LikedTimelinePresenter.i(this.uXi)) {
            Intent intent = new Intent();
            FinderObjectDesc finderObjectDesc = this.tEM.feedObject.getFeedObject().objectDesc;
            intent.putExtra("postRefMediaList", finderObjectDesc != null ? finderObjectDesc.toByteArray() : null);
            y yVar = y.vXH;
            intent.putExtra("postRefFeedInfo", y.u(this.tEM).toByteArray());
            intent.putExtra("postType", this.tEM.feedObject.getMediaType());
            intent.putExtra("key_finder_post_from", 5);
            a aVar3 = a.vUU;
            FinderLikedFeedContract.LikedTimelineViewCallback g5 = FinderLikedFeedContract.LikedTimelinePresenter.g(this.uXi);
            if (g5 == null || (mMActivity = g5.gte) == null) {
                context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
            } else {
                context = mMActivity;
            }
            a.enterFinderPostUI(context, intent);
            AppMethodBeat.o(166492);
        } else if (itemId == FinderLikedFeedContract.LikedTimelinePresenter.j(this.uXi)) {
            ((v) com.tencent.mm.kernel.g.af(v.class)).a(this.tEM.feedObject.getId(), this.tEM.feedObject.getFeedObject(), this.tEM.feedObject.getObjectNonceId(), true, new FinderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1$onMMMenuItemSelected$1(this));
            AppMethodBeat.o(166492);
        } else if (itemId == FinderLikedFeedContract.LikedTimelinePresenter.l(this.uXi)) {
            ((v) com.tencent.mm.kernel.g.af(v.class)).a(this.tEM.feedObject.getId(), this.tEM.feedObject.getFeedObject(), this.tEM.feedObject.getObjectNonceId(), false, new FinderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1$onMMMenuItemSelected$2(this));
            AppMethodBeat.o(166492);
        } else if (itemId == FinderLikedFeedContract.LikedTimelinePresenter.f(this.uXi)) {
            y yVar2 = y.vXH;
            if (y.w(this.tEM)) {
                awe liveInfo = this.tEM.feedObject.getLiveInfo();
                if (liveInfo != null) {
                    long j2 = liveInfo.liveId;
                    com.tencent.mm.plugin.finder.feed.logic.a aVar4 = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
                    com.tencent.mm.plugin.finder.feed.logic.a.b(this.uXi.gte, j2, this.tEM.feedObject.getUserName());
                    AppMethodBeat.o(166492);
                    return;
                }
                AppMethodBeat.o(166492);
                return;
            }
            com.tencent.mm.plugin.finder.feed.logic.a aVar5 = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            com.tencent.mm.plugin.finder.feed.logic.a.a(context2, this.tEM.feedObject.field_id, 0, 0, 12);
            AppMethodBeat.o(166492);
        } else {
            if (itemId == FinderLikedFeedContract.LikedTimelinePresenter.e(this.uXi)) {
                if (this.tEM.feedObject.isPostFinish()) {
                    FinderReporterUIC.a aVar6 = FinderReporterUIC.wzC;
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(this.uXi.gte);
                    if (fH != null) {
                        i3 = fH.tCE;
                    } else {
                        i3 = 0;
                    }
                    if (i3 != 52) {
                        e.a aVar7 = e.vFX;
                        e.a.n(this.tEM.feedObject);
                        w wVar = w.vXp;
                        FinderObjectDesc finderObjectDesc2 = this.tEM.feedObject.getFeedObject().objectDesc;
                        if (finderObjectDesc2 != null) {
                            azr = finderObjectDesc2.feedBgmInfo;
                        }
                        w.a(azr, Long.valueOf(this.tEM.feedObject.field_id), 0);
                    } else if (this.uXi.gte instanceof FinderTopicTimelineUI) {
                        MMActivity mMActivity2 = this.uXi.gte;
                        if (mMActivity2 == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI");
                            AppMethodBeat.o(166492);
                            throw tVar;
                        }
                        ((FinderTopicTimelineUI) mMActivity2).onBackPressed();
                    }
                    k kVar = k.vfA;
                    k.a(this.uXi.gte, 1, 1, Integer.valueOf(this.tEM.feedObject.field_finderObject.follow_feed_count));
                    AppMethodBeat.o(166492);
                    return;
                }
            } else if (itemId == FinderLikedFeedContract.LikedTimelinePresenter.c(this.uXi)) {
                u.a(this.uXi.gte, this.uXi.gte.getResources().getString(R.string.cp8), new FinderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1$onMMMenuItemSelected$4(this));
                AppMethodBeat.o(166492);
                return;
            } else if (itemId == FinderLikedFeedContract.LikedTimelinePresenter.d(this.uXi)) {
                u.a(this.uXi.gte, this.uXi.gte.getResources().getString(R.string.cp7), new FinderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1$onMMMenuItemSelected$5(this));
            }
            AppMethodBeat.o(166492);
        }
    }
}
