package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
final class FinderFollowTopicListContract$FollowTopicPresenter$onSceneEnd$3 extends q implements a<x> {
    final /* synthetic */ z.f uWI;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderFollowTopicListContract$FollowTopicPresenter$onSceneEnd$3(z.f fVar) {
        super(0);
        this.uWI = fVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.g.a.a
    public final /* synthetic */ x invoke() {
        AppMethodBeat.i(249755);
        T t = this.uWI.SYG;
        if (t != null) {
            t.run();
        }
        x xVar = x.SXb;
        AppMethodBeat.o(249755);
        return xVar;
    }
}
