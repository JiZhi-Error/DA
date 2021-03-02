package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bk;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "invoke"})
public final class FinderFollowTopicListContract$FollowTopicPresenter$loadStart$2 extends q implements b<LinkedList<bds>, Object> {
    final /* synthetic */ FinderFollowTopicListContract.FollowTopicPresenter uWT;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFollowTopicListContract$FollowTopicPresenter$loadStart$2(FinderFollowTopicListContract.FollowTopicPresenter followTopicPresenter) {
        super(1);
        this.uWT = followTopicPresenter;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ Object invoke(LinkedList<bds> linkedList) {
        AppMethodBeat.i(249752);
        LinkedList<bds> linkedList2 = linkedList;
        com.tencent.mm.bw.b bVar = this.uWT.tsO;
        if (bVar == null) {
            if (linkedList2 != null) {
                if (this.uWT.kgc.isEmpty()) {
                    ArrayList arrayList = this.uWT.kgc;
                    LinkedList<bds> linkedList3 = linkedList2;
                    ArrayList arrayList2 = new ArrayList(j.a(linkedList3, 10));
                    Iterator<T> it = linkedList3.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(new bk(it.next()));
                    }
                    arrayList.addAll(arrayList2);
                }
                Log.i("Finder.FollowTopicPresenter", "refreshList from firstPageData");
                FinderFollowTopicListContract.FollowTopicPresenter.d(this.uWT).f(false, 0, this.uWT.kgc.size());
                AppMethodBeat.o(249752);
                return linkedList2;
            }
            bVar = null;
        }
        AppMethodBeat.o(249752);
        return bVar;
    }
}
