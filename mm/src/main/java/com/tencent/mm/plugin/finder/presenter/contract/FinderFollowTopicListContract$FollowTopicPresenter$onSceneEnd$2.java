package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.bk;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
final class FinderFollowTopicListContract$FollowTopicPresenter$onSceneEnd$2 implements Runnable {
    final /* synthetic */ q hvN;
    final /* synthetic */ z.a uWH;
    final /* synthetic */ FinderFollowTopicListContract.FollowTopicPresenter uWT;

    FinderFollowTopicListContract$FollowTopicPresenter$onSceneEnd$2(FinderFollowTopicListContract.FollowTopicPresenter followTopicPresenter, z.a aVar, q qVar) {
        this.uWT = followTopicPresenter;
        this.uWH = aVar;
        this.hvN = qVar;
    }

    public final void run() {
        AppMethodBeat.i(249754);
        FinderFollowTopicListContract.FollowTopicPresenter followTopicPresenter = this.uWT;
        boolean z = this.uWH.SYB;
        LinkedList<bds> cYu = ((bk) this.hvN).cYu();
        boolean e2 = FinderFollowTopicListContract.FollowTopicPresenter.e(this.uWT);
        p.h(cYu, "dataList");
        Log.i("Finder.FollowTopicPresenter", "firstPage " + z + ", get follow contact " + cYu.size());
        int size = followTopicPresenter.kgc.size();
        int size2 = cYu.size();
        if (z) {
            followTopicPresenter.kgc.clear();
            size2 = -1;
            size = -1;
        }
        ArrayList<com.tencent.mm.plugin.finder.model.bk> arrayList = followTopicPresenter.kgc;
        LinkedList<bds> linkedList = cYu;
        ArrayList arrayList2 = new ArrayList(j.a(linkedList, 10));
        Iterator<T> it = linkedList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new com.tencent.mm.plugin.finder.model.bk(it.next()));
        }
        arrayList.addAll(arrayList2);
        FinderFollowTopicListContract.FollowTopicViewCallback followTopicViewCallback = followTopicPresenter.uWP;
        if (followTopicViewCallback == null) {
            p.btv("viewCallback");
        }
        followTopicViewCallback.f(e2, size, size2);
        AppMethodBeat.o(249754);
    }
}
