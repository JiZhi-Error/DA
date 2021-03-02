package com.tencent.mm.plugin.finder.presenter.contract;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.i;
import com.tencent.mm.plugin.finder.model.p;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
public final class FinderBlockListContract$BlockListViewCallback$hideSearchBar$1 implements Runnable {
    final /* synthetic */ long $delay;
    final /* synthetic */ boolean tSM = false;
    final /* synthetic */ LinearLayoutManager tSy;
    final /* synthetic */ FinderBlockListContract.BlockListViewCallback uWu;

    FinderBlockListContract$BlockListViewCallback$hideSearchBar$1(FinderBlockListContract.BlockListViewCallback blockListViewCallback, LinearLayoutManager linearLayoutManager) {
        this.uWu = blockListViewCallback;
        this.tSy = linearLayoutManager;
        this.$delay = 200;
    }

    public final void run() {
        AppMethodBeat.i(249690);
        WxRecyclerAdapter<p> wxRecyclerAdapter = this.uWu.tFp;
        if (wxRecyclerAdapter != null) {
            i g2 = FinderBlockListContract.BlockListViewCallback.g(this.uWu);
            if (g2 == null) {
                kotlin.g.b.p.hyc();
            }
            h hVar = (h) wxRecyclerAdapter.V((long) g2.hashCode(), false);
            if (hVar != null) {
                Rect rect = new Rect();
                if (hVar.aus.getGlobalVisibleRect(rect) && rect.height() > 0) {
                    if (this.tSM) {
                        hVar.getRecyclerView().smoothScrollBy(0, rect.height());
                    } else {
                        LinearLayoutManager linearLayoutManager = this.tSy;
                        if (linearLayoutManager != null) {
                            linearLayoutManager.ah(1, 0);
                        }
                    }
                    FinderBlockListContract finderBlockListContract = FinderBlockListContract.uWn;
                    Log.i(FinderBlockListContract.dlO(), "[hideSearchBar] to hide search bar. delay=" + this.$delay + " isSmooth=" + this.tSM + " height=" + rect.height());
                }
                AppMethodBeat.o(249690);
                return;
            }
        }
        AppMethodBeat.o(249690);
    }
}
