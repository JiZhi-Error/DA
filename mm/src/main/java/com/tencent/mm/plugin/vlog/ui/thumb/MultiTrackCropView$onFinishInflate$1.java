package com.tencent.mm.plugin.vlog.ui.thumb;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0018\u00010\u0006R\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$onFinishInflate$1", "Landroid/support/v7/widget/LinearLayoutManager;", "scrollHorizontallyBy", "", "dx", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-vlog_release"})
public final class MultiTrackCropView$onFinishInflate$1 extends LinearLayoutManager {
    final /* synthetic */ MultiTrackCropView GPJ;

    /* JADX WARN: Incorrect types in method signature: (Landroid/content/Context;)V */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultiTrackCropView$onFinishInflate$1(MultiTrackCropView multiTrackCropView) {
        super(0, false);
        this.GPJ = multiTrackCropView;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(192098);
        int i3 = this.GPJ.FVU + i2;
        if (!this.GPJ.GPE) {
            int i4 = this.GPJ.GPz;
            int i5 = this.GPJ.GPz + this.GPJ.GJa;
            if (i3 < i4) {
                i2 = i4 - this.GPJ.FVU;
            } else if (i3 > i5) {
                i2 = i5 - this.GPJ.FVU;
            }
            int scrollHorizontallyBy = super.scrollHorizontallyBy(i2, nVar, sVar);
            AppMethodBeat.o(192098);
            return scrollHorizontallyBy;
        }
        int scrollHorizontallyBy2 = super.scrollHorizontallyBy(i2, nVar, sVar);
        AppMethodBeat.o(192098);
        return scrollHorizontallyBy2;
    }
}
