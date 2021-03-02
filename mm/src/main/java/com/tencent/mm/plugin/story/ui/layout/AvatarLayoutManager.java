package com.tencent.mm.plugin.story.ui.layout;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0018\u00010\rR\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0002R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/layout/AvatarLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "alphaStartOffset", "canScrollVertically", "", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollToPositionWithOffset", "position", "offset", "updateChild", "plugin-story_release"})
public final class AvatarLayoutManager extends LinearLayoutManager {
    private final int ArH;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AvatarLayoutManager(Context context) {
        super(1, false);
        p.h(context, "context");
        AppMethodBeat.i(119918);
        this.ArH = a.fromDPToPix(context, 0);
        AppMethodBeat.o(119918);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final boolean canScrollVertically() {
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(119915);
        super.onLayoutChildren(nVar, sVar);
        cKb();
        AppMethodBeat.o(119915);
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public final void ah(int i2, int i3) {
        AppMethodBeat.i(119916);
        super.ah(i2, i3);
        cKb();
        AppMethodBeat.o(119916);
    }

    private final void cKb() {
        AppMethodBeat.i(119917);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt == null) {
                p.hyc();
            }
            p.g(childAt, "getChildAt(i)!!");
            int top = (childAt.getTop() + childAt.getBottom()) / 2;
            int height = getHeight() / 2;
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight - Math.abs(top - height) > this.ArH) {
                childAt.setAlpha(Math.min(1.0f - (((float) Math.abs(top - height)) / ((float) (measuredHeight - this.ArH))), 1.0f));
            } else {
                childAt.setAlpha(0.0f);
            }
            childAt.setSelected(1.0f - childAt.getAlpha() < 0.1f);
        }
        AppMethodBeat.o(119917);
    }
}
