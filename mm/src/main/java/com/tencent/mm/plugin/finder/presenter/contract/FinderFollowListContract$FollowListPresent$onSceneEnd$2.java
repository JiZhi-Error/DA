package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.bj;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
final class FinderFollowListContract$FollowListPresent$onSceneEnd$2 implements Runnable {
    final /* synthetic */ q hvN;
    final /* synthetic */ FinderFollowListContract.FollowListPresent uWE;
    final /* synthetic */ z.a uWH;

    FinderFollowListContract$FollowListPresent$onSceneEnd$2(FinderFollowListContract.FollowListPresent followListPresent, z.a aVar, q qVar) {
        this.uWE = followListPresent;
        this.uWH = aVar;
        this.hvN = qVar;
    }

    public final void run() {
        AppMethodBeat.i(249716);
        FinderFollowListContract.FollowListPresent.a(this.uWE, this.uWH.SYB, ((bj) this.hvN).cYt(), FinderFollowListContract.FollowListPresent.b(this.uWE));
        AppMethodBeat.o(249716);
    }
}
