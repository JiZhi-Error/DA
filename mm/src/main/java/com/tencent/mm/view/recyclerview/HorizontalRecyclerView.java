package com.tencent.mm.view.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/view/recyclerview/HorizontalRecyclerView;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "lastIntercept", "", "onInterceptChangedListener", "Lkotlin/Function1;", "", "getOnInterceptChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnInterceptChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "e", "onTouchEvent", "libmmui_release"})
public final class HorizontalRecyclerView extends WxRecyclerView {
    private boolean RqE;
    private b<? super Boolean, x> RqF;
    private final String TAG = "MicroMsg.HorizontalRecyclerView";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(205044);
        AppMethodBeat.o(205044);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(205045);
        AppMethodBeat.o(205045);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Boolean, kotlin.x>, kotlin.g.a.b<java.lang.Boolean, kotlin.x> */
    public final b<Boolean, x> getOnInterceptChangedListener() {
        return this.RqF;
    }

    public final void setOnInterceptChangedListener(b<? super Boolean, x> bVar) {
        this.RqF = bVar;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(205041);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(205041);
        return dispatchTouchEvent;
    }

    @Override // android.support.v7.widget.RecyclerView
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(205042);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(205042);
        return onTouchEvent;
    }

    @Override // android.support.v7.widget.RecyclerView
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(205043);
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (onInterceptTouchEvent != this.RqE) {
            b<? super Boolean, x> bVar = this.RqF;
            if (bVar != null) {
                bVar.invoke(Boolean.valueOf(onInterceptTouchEvent));
            }
            this.RqE = onInterceptTouchEvent;
        }
        AppMethodBeat.o(205043);
        return onInterceptTouchEvent;
    }
}
