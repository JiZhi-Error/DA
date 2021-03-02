package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isInterceptDown", "", "()Z", "setInterceptDown", "(Z)V", "lastX", "", "getLastX", "()F", "setLastX", "(F)V", "touchListener", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "getTouchListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "setTouchListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;)V", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "TouchListener", "plugin-finder_release"})
public final class FinderTouchLayout extends FrameLayout {
    private float aTD;
    private boolean wpJ;
    public a wpK;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "", "interceptDown", "", "event", "Landroid/view/MotionEvent;", "onScrollX", "", "x", "", "onTouchUp", "plugin-finder_release"})
    public interface a {
        boolean T(MotionEvent motionEvent);

        void U(MotionEvent motionEvent);

        void bh(float f2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderTouchLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(254999);
        AppMethodBeat.o(254999);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderTouchLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(255000);
        AppMethodBeat.o(255000);
    }

    public final float getLastX() {
        return this.aTD;
    }

    public final void setLastX(float f2) {
        this.aTD = f2;
    }

    public final void setInterceptDown(boolean z) {
        this.wpJ = z;
    }

    public final a getTouchListener() {
        AppMethodBeat.i(254996);
        a aVar = this.wpK;
        if (aVar == null) {
            p.btv("touchListener");
        }
        AppMethodBeat.o(254996);
        return aVar;
    }

    public final void setTouchListener(a aVar) {
        AppMethodBeat.i(254997);
        p.h(aVar, "<set-?>");
        this.wpK = aVar;
        AppMethodBeat.o(254997);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(254998);
        p.h(motionEvent, "event");
        if (motionEvent.getAction() == 0) {
            this.aTD = motionEvent.getRawX();
            a aVar = this.wpK;
            if (aVar == null) {
                p.btv("touchListener");
            }
            this.wpJ = aVar.T(motionEvent);
            if (this.wpJ) {
                AppMethodBeat.o(254998);
                return true;
            }
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(254998);
            return dispatchTouchEvent;
        }
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            if (this.wpJ) {
                a aVar2 = this.wpK;
                if (aVar2 == null) {
                    p.btv("touchListener");
                }
                aVar2.U(motionEvent);
                this.wpJ = false;
                AppMethodBeat.o(254998);
                return true;
            }
        } else if (this.wpJ) {
            a aVar3 = this.wpK;
            if (aVar3 == null) {
                p.btv("touchListener");
            }
            aVar3.bh(motionEvent.getRawX() - this.aTD);
        }
        boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(254998);
        return dispatchTouchEvent2;
    }
}
