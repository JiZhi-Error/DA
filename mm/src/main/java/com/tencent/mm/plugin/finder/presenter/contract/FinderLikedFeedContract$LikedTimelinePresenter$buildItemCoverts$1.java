package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ak;
import com.tencent.mm.plugin.finder.convert.q;
import com.tencent.mm.plugin.finder.convert.t;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
public final class FinderLikedFeedContract$LikedTimelinePresenter$buildItemCoverts$1 implements f {
    final /* synthetic */ FinderLikedFeedContract.LikedTimelinePresenter uXi;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public FinderLikedFeedContract$LikedTimelinePresenter$buildItemCoverts$1(FinderLikedFeedContract.LikedTimelinePresenter likedTimelinePresenter) {
        this.uXi = likedTimelinePresenter;
    }

    @Override // com.tencent.mm.view.recyclerview.f
    public final e<?> EC(int i2) {
        AppMethodBeat.i(166484);
        switch (i2) {
            case 2:
            case 3001:
                FinderLikedFeedContract finderLikedFeedContract = FinderLikedFeedContract.uXb;
                if (FinderLikedFeedContract.dlU()) {
                    q qVar = new q(this.uXi, false, 0, 6);
                    AppMethodBeat.o(166484);
                    return qVar;
                }
                u uVar = new u(this.uXi, false, 0, 6);
                AppMethodBeat.o(166484);
                return uVar;
            case 4:
            case 3002:
                FinderLikedFeedContract finderLikedFeedContract2 = FinderLikedFeedContract.uXb;
                if (FinderLikedFeedContract.dlU()) {
                    t tVar = new t(this.uXi.tCD, this.uXi, false, 0, 12);
                    AppMethodBeat.o(166484);
                    return tVar;
                }
                ak akVar = new ak(this.uXi.tCD, this.uXi, false, 0, 12);
                AppMethodBeat.o(166484);
                return akVar;
            default:
                y yVar = y.vXH;
                y.dQ(this.uXi.TAG, i2);
                com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
                AppMethodBeat.o(166484);
                return fVar;
        }
    }
}
