package com.tencent.mm.plugin.finder.presenter.contract;

import android.view.ContextMenu;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback$initView$4$onItemLongClick$1", "Landroid/view/View$OnCreateContextMenuListener;", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-finder_release"})
public final class FinderBlockListContract$BlockListViewCallback$initView$4$onItemLongClick$1 implements View.OnCreateContextMenuListener {
    final /* synthetic */ FinderBlockListContract$BlockListViewCallback$initView$4 uWx;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FinderBlockListContract$BlockListViewCallback$initView$4$onItemLongClick$1(FinderBlockListContract$BlockListViewCallback$initView$4 finderBlockListContract$BlockListViewCallback$initView$4) {
        this.uWx = finderBlockListContract$BlockListViewCallback$initView$4;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(249694);
        if (contextMenu != null) {
            contextMenu.add(0, this.uWx.uWu.uWt, 0, R.string.d1k);
            AppMethodBeat.o(249694);
            return;
        }
        AppMethodBeat.o(249694);
    }
}
