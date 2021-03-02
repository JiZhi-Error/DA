package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "invoke"})
public final class FinderFollowListContract$FollowListPresent$loadStart$1 extends q implements b<Void, LinkedList<FinderContact>> {
    final /* synthetic */ FinderFollowListContract.FollowListPresent uWE;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFollowListContract$FollowListPresent$loadStart$1(FinderFollowListContract.FollowListPresent followListPresent) {
        super(1);
        this.uWE = followListPresent;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ LinkedList<FinderContact> invoke(Void r3) {
        AppMethodBeat.i(249713);
        LinkedList blq = this.uWE.uWD.blq();
        AppMethodBeat.o(249713);
        return blq;
    }
}
