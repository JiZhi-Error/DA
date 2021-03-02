package com.tencent.mm.plugin.vlog.ui.thumb;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-vlog_release"})
public final class d extends RecyclerView.h {
    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        AppMethodBeat.i(192053);
        p.h(rect, "outRect");
        p.h(view, "view");
        p.h(recyclerView, "parent");
        p.h(sVar, "state");
        int fromDPToPix = a.fromDPToPix(recyclerView.getContext(), 8);
        int bw = RecyclerView.bw(view);
        if (bw != 0) {
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (adapter == null) {
                p.hyc();
            }
            p.g(adapter, "parent.adapter!!");
            if (bw != adapter.getItemCount() - 1) {
                rect.left = -fromDPToPix;
                rect.right = -fromDPToPix;
            }
        }
        AppMethodBeat.o(192053);
    }
}
