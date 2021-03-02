package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.ayy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1$onMMMenuItemSelected$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
public final class FinderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1$onMMMenuItemSelected$1 implements ai<ayy> {
    final /* synthetic */ FinderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1 uXj;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FinderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1$onMMMenuItemSelected$1(FinderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1 finderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1) {
        this.uXj = finderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
    @Override // com.tencent.mm.plugin.i.a.ai
    public final /* synthetic */ void a(ayy ayy, apg apg) {
        AppMethodBeat.i(166490);
        p.h(ayy, "req");
        p.h(apg, "ret");
        if (apg.retCode == 0) {
            u.makeText(MMApplicationContext.getContext(), (int) R.string.cnn, 0).show();
            AppMethodBeat.o(166490);
            return;
        }
        u.makeText(MMApplicationContext.getContext(), (int) R.string.cnm, 0).show();
        Log.i(this.uXj.uXi.TAG, "finder_feed_open_comment_no_ok " + apg.retCode);
        AppMethodBeat.o(166490);
    }
}
