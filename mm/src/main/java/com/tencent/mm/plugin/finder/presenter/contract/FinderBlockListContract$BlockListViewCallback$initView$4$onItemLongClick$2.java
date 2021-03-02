package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback$initView$4$onItemLongClick$2", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "onMMMenuItemSelected", "", "menuItem", "Landroid/view/MenuItem;", FirebaseAnalytics.b.INDEX, "", "plugin-finder_release"})
public final class FinderBlockListContract$BlockListViewCallback$initView$4$onItemLongClick$2 implements o.g {
    final /* synthetic */ RecyclerView.a tPP;
    final /* synthetic */ FinderBlockListContract$BlockListViewCallback$initView$4 uWx;
    final /* synthetic */ int uWy;

    FinderBlockListContract$BlockListViewCallback$initView$4$onItemLongClick$2(FinderBlockListContract$BlockListViewCallback$initView$4 finderBlockListContract$BlockListViewCallback$initView$4, int i2, RecyclerView.a aVar) {
        this.uWx = finderBlockListContract$BlockListViewCallback$initView$4;
        this.uWy = i2;
        this.tPP = aVar;
    }

    @Override // com.tencent.mm.ui.base.o.g
    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
        AppMethodBeat.i(249696);
        if (this.uWy >= 0 && this.uWy < this.uWx.uWu.uWr.kgc.size()) {
            this.uWx.uWu.uWr.uWp.a(this.uWx.uWu.uWr.kgc.get(this.uWy).contact, new FinderBlockListContract$BlockListViewCallback$initView$4$onItemLongClick$2$onMMMenuItemSelected$1(this));
        }
        AppMethodBeat.o(249696);
    }
}
