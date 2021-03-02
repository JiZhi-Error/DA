package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.bj;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "invoke", "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent$onSceneEnd$1$1"})
final class FinderFollowListContract$FollowListPresent$onSceneEnd$$inlined$let$lambda$1 extends q implements b<Void, x> {
    final /* synthetic */ FinderFollowListContract.FollowListPresent uWE;
    final /* synthetic */ z.a uWF;
    final /* synthetic */ com.tencent.mm.ak.q uWG;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderFollowListContract$FollowListPresent$onSceneEnd$$inlined$let$lambda$1(FinderFollowListContract.FollowListPresent followListPresent, z.a aVar, com.tencent.mm.ak.q qVar) {
        super(1);
        this.uWE = followListPresent;
        this.uWF = aVar;
        this.uWG = qVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(Void r4) {
        AppMethodBeat.i(249715);
        FinderFollowListContract.FollowListPresent.a(this.uWE).blr();
        FinderFollowListContract.FollowListPresent.a(this.uWE).r(((bj) this.uWG).cYt());
        x xVar = x.SXb;
        AppMethodBeat.o(249715);
        return xVar;
    }
}
