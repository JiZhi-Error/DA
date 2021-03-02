package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.af;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC;
import com.tencent.mm.protocal.protobuf.FinderContact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "invoke"})
public final class FinderFollowListContract$FollowListPresent$loadStart$2 extends q implements b<LinkedList<FinderContact>, Object> {
    final /* synthetic */ FinderFollowListContract.FollowListPresent uWE;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFollowListContract$FollowListPresent$loadStart$2(FinderFollowListContract.FollowListPresent followListPresent) {
        super(1);
        this.uWE = followListPresent;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ Object invoke(LinkedList<FinderContact> linkedList) {
        AppMethodBeat.i(249714);
        LinkedList<FinderContact> linkedList2 = linkedList;
        com.tencent.mm.bw.b bVar = this.uWE.tsO;
        if (bVar == null) {
            if (linkedList2 != null) {
                if (this.uWE.kgc.isEmpty()) {
                    ArrayList arrayList = this.uWE.kgc;
                    LinkedList<FinderContact> linkedList3 = linkedList2;
                    ArrayList arrayList2 = new ArrayList(j.a(linkedList3, 10));
                    Iterator<T> it = linkedList3.iterator();
                    while (it.hasNext()) {
                        FinderFollowListUIC.a aVar = FinderFollowListUIC.wwp;
                        arrayList2.add(new af(FinderFollowListUIC.a.f(it.next())));
                    }
                    arrayList.addAll(arrayList2);
                    FinderFollowListContract.FollowListPresent.e(this.uWE).f(false, 0, this.uWE.kgc.size());
                }
                x xVar = x.SXb;
                AppMethodBeat.o(249714);
                return xVar;
            }
            bVar = null;
        }
        AppMethodBeat.o(249714);
        return bVar;
    }
}
