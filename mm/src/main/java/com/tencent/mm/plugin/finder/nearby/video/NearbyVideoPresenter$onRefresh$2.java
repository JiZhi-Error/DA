package com.tencent.mm.plugin.finder.nearby.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
public final class NearbyVideoPresenter$onRefresh$2 extends q implements a<x> {
    final /* synthetic */ NearbyVideoPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NearbyVideoPresenter$onRefresh$2(NearbyVideoPresenter nearbyVideoPresenter) {
        super(0);
        this.this$0 = nearbyVideoPresenter;
    }

    @Override // kotlin.g.a.a
    public final void invoke() {
        AppMethodBeat.i(249413);
        if (this.this$0.isRequestingLbs()) {
            AppMethodBeat.o(249413);
            return;
        }
        this.this$0.setRequestingLbs(true);
        d.b("LbsPresenter_requestLbs", new a<x>(this) {
            /* class com.tencent.mm.plugin.finder.nearby.video.NearbyVideoPresenter$onRefresh$2.AnonymousClass1 */
            final /* synthetic */ NearbyVideoPresenter$onRefresh$2 this$0;

            {
                this.this$0 = r2;
            }

            @Override // kotlin.g.a.a
            public final void invoke() {
                AppMethodBeat.i(249411);
                com.tencent.mm.plugin.finder.utils.l lVar = com.tencent.mm.plugin.finder.utils.l.vVE;
                final boolean dBK = com.tencent.mm.plugin.finder.utils.l.dBK();
                this.this$0.this$0.setRequestingLbs(false);
                d.h(new a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.nearby.video.NearbyVideoPresenter$onRefresh$2.AnonymousClass1.AnonymousClass1 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r2;
                    }

                    @Override // kotlin.g.a.a
                    public final void invoke() {
                        AppMethodBeat.i(249409);
                        if (dBK) {
                            k kVar = k.vfA;
                            k.ac(this.this$0.this$0.this$0.activity, 6);
                            this.this$0.this$0.this$0.getFeedLoader().requestRefresh();
                            AppMethodBeat.o(249409);
                            return;
                        }
                        k kVar2 = k.vfA;
                        k.ac(this.this$0.this$0.this$0.activity, 7);
                        this.this$0.this$0.this$0.getViewCallback().dcQ().postDelayed(new Runnable(this) {
                            /* class com.tencent.mm.plugin.finder.nearby.video.NearbyVideoPresenter$onRefresh$2.AnonymousClass1.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 this$0;

                            {
                                this.this$0 = r1;
                            }

                            public final void run() {
                                AppMethodBeat.i(249407);
                                RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(0);
                                cVar.Rmh = -2;
                                this.this$0.this$0.this$0.this$0.getViewCallback().dcQ().g(cVar);
                                AppMethodBeat.o(249407);
                            }
                        }, 200);
                        AppMethodBeat.o(249409);
                    }
                });
                AppMethodBeat.o(249411);
            }
        });
        AppMethodBeat.o(249413);
    }
}
