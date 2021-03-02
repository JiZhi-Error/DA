package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "invoke"})
public final class FinderFollowTopicListContract$FollowTopicPresenter$loadStart$1 extends q implements b<Void, LinkedList<bds>> {
    final /* synthetic */ FinderFollowTopicListContract.FollowTopicPresenter uWT;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFollowTopicListContract$FollowTopicPresenter$loadStart$1(FinderFollowTopicListContract.FollowTopicPresenter followTopicPresenter) {
        super(1);
        this.uWT = followTopicPresenter;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ LinkedList<bds> invoke(Void r3) {
        AppMethodBeat.i(249751);
        LinkedList blq = this.uWT.uWQ.blq();
        AppMethodBeat.o(249751);
        return blq;
    }
}
