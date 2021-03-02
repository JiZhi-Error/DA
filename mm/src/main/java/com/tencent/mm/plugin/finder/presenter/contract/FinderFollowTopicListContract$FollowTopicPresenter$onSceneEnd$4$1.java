package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.ck;
import com.tencent.mm.plugin.finder.model.bk;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/finder/model/FinderTopicFollowData;", "invoke"})
final class FinderFollowTopicListContract$FollowTopicPresenter$onSceneEnd$4$1 extends q implements b<bk, Boolean> {
    final /* synthetic */ ck uWU;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderFollowTopicListContract$FollowTopicPresenter$onSceneEnd$4$1(ck ckVar) {
        super(1);
        this.uWU = ckVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ Boolean invoke(bk bkVar) {
        boolean z;
        AppMethodBeat.i(249756);
        bk bkVar2 = bkVar;
        p.h(bkVar2, "data");
        if (bkVar2.dMU.twp == this.uWU.twp) {
            z = true;
        } else {
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        AppMethodBeat.o(249756);
        return valueOf;
    }
}
