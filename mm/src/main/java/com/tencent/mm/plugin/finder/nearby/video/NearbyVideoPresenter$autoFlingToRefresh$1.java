package com.tencent.mm.plugin.finder.nearby.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
public final class NearbyVideoPresenter$autoFlingToRefresh$1 implements Runnable {
    final /* synthetic */ boolean $isSilence;
    final /* synthetic */ RefreshLoadMoreLayout $rlLayout;

    NearbyVideoPresenter$autoFlingToRefresh$1(RefreshLoadMoreLayout refreshLoadMoreLayout, boolean z) {
        this.$rlLayout = refreshLoadMoreLayout;
        this.$isSilence = z;
    }

    public final void run() {
        AppMethodBeat.i(249395);
        this.$rlLayout.DD(this.$isSilence);
        AppMethodBeat.o(249395);
    }
}
