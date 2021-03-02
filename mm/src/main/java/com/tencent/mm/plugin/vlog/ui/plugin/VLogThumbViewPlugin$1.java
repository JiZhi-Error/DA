package com.tencent.mm.plugin.vlog.ui.plugin;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0018\u00010\u0006R\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin$1", "Landroid/support/v7/widget/LinearLayoutManager;", "scrollHorizontallyBy", "", "dx", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-vlog_release"})
public final class VLogThumbViewPlugin$1 extends LinearLayoutManager {
    final /* synthetic */ ah GJt;

    /* JADX WARN: Incorrect types in method signature: (Landroid/content/Context;)V */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VLogThumbViewPlugin$1(ah ahVar) {
        super(0, false);
        this.GJt = ahVar;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        boolean z;
        AppMethodBeat.i(191526);
        int i3 = this.GJt.FVU + i2;
        if (this.GJt.whv < 0 || !this.GJt.GJq) {
            int scrollHorizontallyBy = super.scrollHorizontallyBy(i2, nVar, sVar);
            AppMethodBeat.o(191526);
            return scrollHorizontallyBy;
        }
        o v = ah.v(this.GJt);
        if (((float) i3) > v.second.floatValue() || ((float) i3) < v.first.floatValue()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            int scrollHorizontallyBy2 = super.scrollHorizontallyBy(i2, nVar, sVar);
            AppMethodBeat.o(191526);
            return scrollHorizontallyBy2;
        }
        AppMethodBeat.o(191526);
        return 0;
    }
}
