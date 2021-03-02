package com.tencent.mm.plugin.vlog.ui.thumb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0014J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J0\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0014J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0014J\u0012\u0010!\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "selectedPosition", "dispatchTouchEvent", "", "e", "Landroid/view/MotionEvent;", "getChildDrawingOrder", "childCount", "i", "onDraw", "", "c", "Landroid/graphics/Canvas;", "onInterceptTouchEvent", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthSpec", "heightSpec", "onTouchEvent", "selectItem", "position", "Companion", "plugin-vlog_release"})
@SuppressLint({"LongLogTag"})
public final class MultiTrackRecyclerView extends RecyclerView {
    public static final a GPM = new a((byte) 0);
    int va = -1;

    static {
        AppMethodBeat.i(192133);
        AppMethodBeat.o(192133);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackRecyclerView$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiTrackRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(192131);
        setChildrenDrawingOrderEnabled(true);
        setClipToPadding(false);
        AppMethodBeat.o(192131);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiTrackRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(192132);
        setChildrenDrawingOrderEnabled(true);
        setClipToPadding(false);
        AppMethodBeat.o(192132);
    }

    @Override // android.support.v7.widget.RecyclerView
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(192124);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(192124);
    }

    @Override // android.support.v7.widget.RecyclerView
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(192125);
        super.onLayout(z, i2, i3, i4, i5);
        AppMethodBeat.o(192125);
    }

    @Override // android.support.v7.widget.RecyclerView
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(192126);
        super.onDraw(canvas);
        AppMethodBeat.o(192126);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(192127);
        new StringBuilder("dispatchTouchEvent, action:").append(motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(192127);
        return dispatchTouchEvent;
    }

    @Override // android.support.v7.widget.RecyclerView
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(192128);
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(192128);
        return onInterceptTouchEvent;
    }

    @Override // android.support.v7.widget.RecyclerView
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(192129);
        new StringBuilder("onTouchEvent, action:").append(motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(192129);
        return onTouchEvent;
    }

    @Override // android.support.v7.widget.RecyclerView
    public final int getChildDrawingOrder(int i2, int i3) {
        AppMethodBeat.i(192130);
        int i4 = this.va;
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int ks = i4 - (linearLayoutManager != null ? linearLayoutManager.ks() : 0);
        if (ks < 0 || i3 < ks || ks >= i2) {
            AppMethodBeat.o(192130);
            return i3;
        } else if (i3 == i2 - 1) {
            AppMethodBeat.o(192130);
            return ks;
        } else {
            int i5 = i3 + 1;
            AppMethodBeat.o(192130);
            return i5;
        }
    }
}
