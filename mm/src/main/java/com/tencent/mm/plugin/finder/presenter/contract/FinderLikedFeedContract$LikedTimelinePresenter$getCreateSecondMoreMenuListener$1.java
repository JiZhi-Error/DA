package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
final class FinderLikedFeedContract$LikedTimelinePresenter$getCreateSecondMoreMenuListener$1 implements o.f {
    final /* synthetic */ BaseFinderFeed tEM;
    final /* synthetic */ FinderLikedFeedContract.LikedTimelinePresenter uXi;

    FinderLikedFeedContract$LikedTimelinePresenter$getCreateSecondMoreMenuListener$1(FinderLikedFeedContract.LikedTimelinePresenter likedTimelinePresenter, BaseFinderFeed baseFinderFeed) {
        this.uXi = likedTimelinePresenter;
        this.tEM = baseFinderFeed;
    }

    @Override // com.tencent.mm.ui.base.o.f
    public final void onCreateMMMenu(m mVar) {
        AppMethodBeat.i(166489);
        y yVar = y.vXH;
        if (y.C(this.tEM.feedObject)) {
            int e2 = FinderLikedFeedContract.LikedTimelinePresenter.e(this.uXi);
            y yVar2 = y.vXH;
            mVar.a(e2, y.x(this.tEM), R.raw.finder_bgm_gif_first_page, !this.tEM.feedObject.isPostFinish() || this.tEM.feedObject.isPostFailed());
        }
        if (!FinderLikedFeedContract.LikedTimelinePresenter.o(this.tEM)) {
            mVar.b(FinderLikedFeedContract.LikedTimelinePresenter.f(this.uXi), MMApplicationContext.getContext().getString(R.string.f3g), R.raw.icons_outlined_report_problem);
        }
        AppMethodBeat.o(166489);
    }
}
