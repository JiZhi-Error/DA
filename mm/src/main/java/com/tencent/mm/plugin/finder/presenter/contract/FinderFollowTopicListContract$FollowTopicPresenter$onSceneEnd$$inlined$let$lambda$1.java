package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.bk;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "invoke", "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter$onSceneEnd$1$1"})
final class FinderFollowTopicListContract$FollowTopicPresenter$onSceneEnd$$inlined$let$lambda$1 extends q implements b<Void, x> {
    final /* synthetic */ z.a uWF;
    final /* synthetic */ com.tencent.mm.ak.q uWG;
    final /* synthetic */ FinderFollowTopicListContract.FollowTopicPresenter uWT;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderFollowTopicListContract$FollowTopicPresenter$onSceneEnd$$inlined$let$lambda$1(FinderFollowTopicListContract.FollowTopicPresenter followTopicPresenter, z.a aVar, com.tencent.mm.ak.q qVar) {
        super(1);
        this.uWT = followTopicPresenter;
        this.uWF = aVar;
        this.uWG = qVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(Void r4) {
        AppMethodBeat.i(249753);
        FinderFollowTopicListContract.FollowTopicPresenter.a(this.uWT).blr();
        FinderFollowTopicListContract.FollowTopicPresenter.a(this.uWT).r(((bk) this.uWG).cYu());
        x xVar = x.SXb;
        AppMethodBeat.o(249753);
        return xVar;
    }
}
