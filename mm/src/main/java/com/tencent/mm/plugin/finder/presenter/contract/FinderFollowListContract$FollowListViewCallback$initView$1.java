package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ao;
import com.tencent.mm.plugin.finder.model.af;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
public final class FinderFollowListContract$FollowListViewCallback$initView$1 implements f {
    final /* synthetic */ FinderFollowListContract.FollowListViewCallback uWN;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public FinderFollowListContract$FollowListViewCallback$initView$1(FinderFollowListContract.FollowListViewCallback followListViewCallback) {
        this.uWN = followListViewCallback;
    }

    @Override // com.tencent.mm.view.recyclerview.f
    public final e<?> EC(int i2) {
        AppMethodBeat.i(249728);
        if (i2 == af.class.getName().hashCode()) {
            ao aoVar = new ao();
            AppMethodBeat.o(249728);
            return aoVar;
        }
        y yVar = y.vXH;
        y.dQ(this.uWN.TAG, i2);
        com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(249728);
        return fVar;
    }
}