package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\fH\u0002J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderFoldedPresenter;", "Lcom/tencent/mm/plugin/finder/view/FoldedScrollPresenter;", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "parent", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "getFoldedLayout", "()Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "getParent", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getItemLayoutType", "", "getLayoutParam", "Landroid/support/constraint/ConstraintLayout$LayoutParams;", "getList", "", "getParentFeed", "getSpaceWidth", "hasMore", "", "isShowLikeInfo", "jumpFoldedUI", "", "context", "Landroid/content/Context;", "jumpPos", "onItemClick", "pos", "plugin-finder_release"})
public final class g implements p {
    private final ard foldedLayout;
    private final BaseFinderFeed wmG;

    public g(ard ard, BaseFinderFeed baseFinderFeed) {
        p.h(ard, "foldedLayout");
        p.h(baseFinderFeed, "parent");
        AppMethodBeat.i(254824);
        this.foldedLayout = ard;
        this.wmG = baseFinderFeed;
        AppMethodBeat.o(254824);
    }

    @Override // com.tencent.mm.plugin.finder.view.p
    public final BaseFinderFeed dGI() {
        return this.wmG;
    }

    @Override // com.tencent.mm.plugin.finder.view.p
    public final List<BaseFinderFeed> GW() {
        AppMethodBeat.i(254821);
        List<BaseFinderFeed> foldedFeedList = this.wmG.feedObject.getFoldedFeedList();
        AppMethodBeat.o(254821);
        return foldedFeedList;
    }

    @Override // com.tencent.mm.plugin.finder.view.p
    public final int cZG() {
        if (this.foldedLayout.tQR == 1) {
            return 1;
        }
        return 2;
    }

    @Override // com.tencent.mm.plugin.finder.view.p
    public final boolean dGJ() {
        AppMethodBeat.i(254822);
        int i2 = this.foldedLayout.gAZ;
        c cVar = c.vCb;
        if (i2 >= c.dsu().value().intValue()) {
            AppMethodBeat.o(254822);
            return true;
        }
        AppMethodBeat.o(254822);
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.view.p
    public final void ag(Context context, int i2) {
        int i3;
        AppMethodBeat.i(254823);
        p.h(context, "context");
        ard ard = this.foldedLayout;
        BaseFinderFeed baseFinderFeed = this.wmG;
        List<BaseFinderFeed> foldedFeedList = this.wmG.feedObject.getFoldedFeedList();
        if (!Util.isNullOrNil(foldedFeedList)) {
            if (i2 >= foldedFeedList.size()) {
                i3 = foldedFeedList.size() - 1;
            } else {
                i3 = i2 < 0 ? 0 : i2;
            }
            Log.i("Finder.FinderFoldedScrollLayout", "jumpFoldedUI item " + baseFinderFeed + " jumpPos " + i2);
            FinderFoldedScrollLayout.a aVar = FinderFoldedScrollLayout.wmQ;
            FinderFoldedScrollLayout.wmO = foldedFeedList.get(i3).lT();
            FinderFoldedScrollLayout.a aVar2 = FinderFoldedScrollLayout.wmQ;
            FinderFoldedScrollLayout.wmP = cl.aWA();
            Intent intent = new Intent();
            intent.putExtra("FEED_ID", baseFinderFeed.feedObject.getId());
            intent.putExtra("FEED_NONCE_ID", baseFinderFeed.feedObject.getObjectNonceId());
            if (ard.tQR == 1) {
                y yVar = y.vXH;
                intent.putExtra("NICKNAME", y.hf(ard.username, ""));
                p.g(intent.putExtra("FOLED_TYPE", 1), "intent.putExtra(Constant…utType.Folded_FriendLike)");
            } else if (ard.tQR == 2) {
                intent.putExtra("NICKNAME", baseFinderFeed.feedObject.getNickName());
                intent.putExtra("FOLED_TYPE", 2);
            }
            y yVar2 = y.vXH;
            y.a(i3, foldedFeedList, (b) null, intent);
            a aVar3 = a.vUU;
            a.V(context, intent);
        }
        AppMethodBeat.o(254823);
    }
}
