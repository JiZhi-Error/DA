package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.af;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "invoke"})
final class FinderFollowListContract$FollowListPresent$onSceneEnd$4 extends q implements b<af, Boolean> {
    final /* synthetic */ String uWJ;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderFollowListContract$FollowListPresent$onSceneEnd$4(String str) {
        super(1);
        this.uWJ = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ Boolean invoke(af afVar) {
        AppMethodBeat.i(249718);
        af afVar2 = afVar;
        p.h(afVar2, "data");
        Boolean valueOf = Boolean.valueOf(afVar2.contact.getUsername().equals(this.uWJ));
        AppMethodBeat.o(249718);
        return valueOf;
    }
}
