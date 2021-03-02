package com.tencent.mm.plugin.finder.nearby.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
final class NearbyVideoPresenter$onRefresh$1 extends q implements a<x> {
    final /* synthetic */ NearbyVideoPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NearbyVideoPresenter$onRefresh$1(NearbyVideoPresenter nearbyVideoPresenter) {
        super(0);
        this.this$0 = nearbyVideoPresenter;
    }

    @Override // kotlin.g.a.a
    public final void invoke() {
        AppMethodBeat.i(249406);
        this.this$0.getViewCallback().dcQ().postDelayed(new Runnable(this) {
            /* class com.tencent.mm.plugin.finder.nearby.video.NearbyVideoPresenter$onRefresh$1.AnonymousClass1 */
            final /* synthetic */ NearbyVideoPresenter$onRefresh$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                AppMethodBeat.i(249404);
                RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(0);
                cVar.Rmh = -2;
                this.this$0.this$0.getViewCallback().dcQ().g(cVar);
                AppMethodBeat.o(249404);
            }
        }, 200);
        AppMethodBeat.o(249406);
    }
}
