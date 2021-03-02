package com.tencent.mm.plugin.emojicapture.ui.layout;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.k.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000eR\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\n\u0010\r\u001a\u00060\u000eR\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J \u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\fH\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "TAG", "", "itemPadding", "itemWidth", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "smoothScrollToPosition", "recyclerView", "updateChild", "plugin-emojicapture_release"})
public final class StickerLayoutManager extends LinearLayoutManager {
    private final String TAG = "MicroMsg.StickerLayoutManager";
    private final int itemPadding;
    private final int qmd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StickerLayoutManager(Context context) {
        super(0, false);
        p.h(context, "context");
        AppMethodBeat.i(f.CTRL_INDEX);
        this.qmd = context.getResources().getDimensionPixelSize(R.dimen.a1y);
        this.itemPadding = context.getResources().getDimensionPixelSize(R.dimen.ct);
        AppMethodBeat.o(f.CTRL_INDEX);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(884);
        p.h(nVar, "recycler");
        p.h(sVar, "state");
        super.onLayoutChildren(nVar, sVar);
        cKb();
        AppMethodBeat.o(884);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(885);
        p.h(nVar, "recycler");
        p.h(sVar, "state");
        int scrollHorizontallyBy = super.scrollHorizontallyBy(i2, nVar, sVar);
        cKb();
        AppMethodBeat.o(885);
        return scrollHorizontallyBy;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        AppMethodBeat.i(886);
        p.h(recyclerView, "recyclerView");
        p.h(sVar, "state");
        Context context = recyclerView.getContext();
        p.g(context, "recyclerView.context");
        a aVar = new a(context);
        aVar.ct(i2);
        startSmoothScroll(aVar);
        AppMethodBeat.o(886);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void scrollToPosition(int i2) {
        AppMethodBeat.i(887);
        ah(i2, ((getWidth() - this.qmd) / 2) - this.itemPadding);
        AppMethodBeat.o(887);
    }

    private final void cKb() {
        AppMethodBeat.i(888);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                p.g(childAt, "getChildAt(i) ?: continue");
                int position = getPosition(childAt);
                int left = (childAt.getLeft() + childAt.getRight()) / 2;
                int width = getWidth() / 2;
                int right = childAt.getRight() - childAt.getLeft();
                if (position == getItemCount() - 1 || Math.abs(left - width) < right / 2) {
                    childAt.setAlpha(1.0f);
                } else {
                    childAt.setAlpha(0.3f);
                }
            }
        }
        AppMethodBeat.o(888);
    }
}
