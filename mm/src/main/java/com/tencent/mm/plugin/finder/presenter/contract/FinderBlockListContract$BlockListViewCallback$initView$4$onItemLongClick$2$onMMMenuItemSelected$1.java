package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback$initView$4$onItemLongClick$2$onMMMenuItemSelected$1", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "onDel", "", "success", "", "plugin-finder_release"})
public final class FinderBlockListContract$BlockListViewCallback$initView$4$onItemLongClick$2$onMMMenuItemSelected$1 implements ak.a {
    final /* synthetic */ FinderBlockListContract$BlockListViewCallback$initView$4$onItemLongClick$2 uWz;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FinderBlockListContract$BlockListViewCallback$initView$4$onItemLongClick$2$onMMMenuItemSelected$1(FinderBlockListContract$BlockListViewCallback$initView$4$onItemLongClick$2 finderBlockListContract$BlockListViewCallback$initView$4$onItemLongClick$2) {
        this.uWz = finderBlockListContract$BlockListViewCallback$initView$4$onItemLongClick$2;
    }

    @Override // com.tencent.mm.plugin.finder.storage.ak.a
    public final void nN(boolean z) {
        AppMethodBeat.i(249695);
        if (z) {
            if (this.uWz.uWy < this.uWz.uWx.uWu.uWr.kgc.size() && this.uWz.uWy >= 0) {
                this.uWz.uWx.uWu.uWr.kgc.remove(this.uWz.uWy);
            }
            this.uWz.tPP.ck(((g) this.uWz.tPP).RqM.size() + this.uWz.uWy);
        } else {
            u.makeText(this.uWz.uWx.uWu.gte, StateEvent.ProcessResult.FAILED, 0).show();
        }
        this.uWz.uWx.uWu.bIo();
        AppMethodBeat.o(249695);
    }
}
