package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
public final class FinderLikedFeedContract$LikedTimelineViewCallback$smoothScrollToNextPosition$1 implements Runnable {
    final /* synthetic */ RecyclerView tDJ;
    final /* synthetic */ int tQg;

    FinderLikedFeedContract$LikedTimelineViewCallback$smoothScrollToNextPosition$1(RecyclerView recyclerView, int i2) {
        this.tDJ = recyclerView;
        this.tQg = i2;
    }

    public final void run() {
        AppMethodBeat.i(249797);
        RecyclerView recyclerView = this.tDJ;
        a a2 = c.a(this.tQg, new a());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        AppMethodBeat.o(249797);
    }
}
