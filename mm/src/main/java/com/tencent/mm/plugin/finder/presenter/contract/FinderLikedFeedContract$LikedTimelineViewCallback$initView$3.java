package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "invoke"})
public final class FinderLikedFeedContract$LikedTimelineViewCallback$initView$3 extends q implements b<Void, x> {
    final /* synthetic */ FinderLikedFeedContract.LikedTimelineViewCallback uXm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLikedFeedContract$LikedTimelineViewCallback$initView$3(FinderLikedFeedContract.LikedTimelineViewCallback likedTimelineViewCallback) {
        super(1);
        this.uXm = likedTimelineViewCallback;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(Void r6) {
        AppMethodBeat.i(261266);
        BaseFeedLoader.requestInit$default(this.uXm.uXl.uXc, false, 1, null);
        x xVar = x.SXb;
        AppMethodBeat.o(261266);
        return xVar;
    }
}
