package com.tencent.mm.view.layoutmanager;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u000e\u0010\t\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\n\u0010\u0014\u001a\u00060\u0015R\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J$\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\rH\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/view/layoutmanager/Flip3DLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "enableHorizontalScroll", "enableVerticalScroll", "canScrollHorizontally", "canScrollVertically", "", "enable", "onLayoutCompleted", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "scrollToPosition", "position", "smoothScrollToPosition", "recyclerView", "updateSelectedChild", "Companion", "libmmui_release"})
public final class Flip3DLayoutManager extends LinearLayoutManager {
    public static final a Vmy = new a((byte) 0);
    private boolean Rpx = true;
    public boolean Rpy = true;

    static {
        AppMethodBeat.i(259393);
        AppMethodBeat.o(259393);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Flip3DLayoutManager(Context context) {
        super(0, false);
        p.h(context, "context");
        AppMethodBeat.i(205029);
        AppMethodBeat.o(205029);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/view/layoutmanager/Flip3DLayoutManager$Companion;", "", "()V", "TAG", "", "libmmui_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void onLayoutCompleted(RecyclerView.s sVar) {
        AppMethodBeat.i(205024);
        super.onLayoutCompleted(sVar);
        hgp();
        Log.i("MicroMsg.Flip3DLayoutManager", "onLayoutCompleted childCount:" + getChildCount());
        AppMethodBeat.o(205024);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(205025);
        p.h(nVar, "recycler");
        p.h(sVar, "state");
        int scrollHorizontallyBy = super.scrollHorizontallyBy(i2, nVar, sVar);
        hgp();
        Log.i("MicroMsg.Flip3DLayoutManager", "scrollHorizontallyBy childCount:" + getChildCount() + ", dx:" + i2);
        AppMethodBeat.o(205025);
        return scrollHorizontallyBy;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void scrollToPosition(int i2) {
        AppMethodBeat.i(259391);
        super.scrollToPosition(i2);
        Log.i("MicroMsg.Flip3DLayoutManager", "scrollToPosition childCount:" + getChildCount() + ", position:" + i2);
        AppMethodBeat.o(259391);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        AppMethodBeat.i(259392);
        super.smoothScrollToPosition(recyclerView, sVar, i2);
        Log.i("MicroMsg.Flip3DLayoutManager", "smoothScrollToPosition childCount:" + getChildCount() + ", position:" + i2);
        AppMethodBeat.o(259392);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final boolean canScrollHorizontally() {
        AppMethodBeat.i(205026);
        if (!super.canScrollHorizontally() || !this.Rpy) {
            AppMethodBeat.o(205026);
            return false;
        }
        AppMethodBeat.o(205026);
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final boolean canScrollVertically() {
        AppMethodBeat.i(205027);
        if (!super.canScrollVertically() || !this.Rpx) {
            AppMethodBeat.o(205027);
            return false;
        }
        AppMethodBeat.o(205027);
        return true;
    }

    private final void hgp() {
        AppMethodBeat.i(205028);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                p.g(childAt, "getChildAt(i) ?: continue");
                float width = ((float) getWidth()) / 2.0f;
                float left = ((((float) ((childAt.getLeft() + childAt.getRight()) / 2)) - width) / ((float) getWidth())) * 45.0f;
                childAt.setPivotX(width);
                childAt.setPivotY(((float) getHeight()) / 2.0f);
                if (left < 0.0f) {
                    childAt.setPivotX((float) getWidth());
                } else {
                    childAt.setPivotX(0.0f);
                }
                childAt.setRotationY(left);
            }
        }
        AppMethodBeat.o(205028);
    }
}
