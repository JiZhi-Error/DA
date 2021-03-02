package com.tencent.mm.plugin.festival.finder;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0017\u001a\u00020\fH\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR4\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00112\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0011@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalPopupContainerFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isTouchEnabled", "", "()Z", "setTouchEnabled", "(Z)V", "value", "Lkotlin/Function0;", "onComputeScrollCallback", "getOnComputeScrollCallback", "()Lkotlin/jvm/functions/Function0;", "setOnComputeScrollCallback", "(Lkotlin/jvm/functions/Function0;)V", "canAnimate", "computeScroll", "", "dispatchClickEvent", "pointF", "Landroid/graphics/PointF;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "plugin-festival_release"})
public final class FestivalPopupContainerFrameLayout extends FrameLayout {
    private a<Boolean> UwG;
    boolean pbB = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FestivalPopupContainerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(262843);
        AppMethodBeat.o(262843);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FestivalPopupContainerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(262844);
        AppMethodBeat.o(262844);
    }

    public final a<Boolean> getOnComputeScrollCallback() {
        return this.UwG;
    }

    public final void setOnComputeScrollCallback(a<Boolean> aVar) {
        AppMethodBeat.i(262839);
        this.UwG = aVar;
        setWillNotDraw(this.UwG == null);
        AppMethodBeat.o(262839);
    }

    public final void computeScroll() {
        AppMethodBeat.i(262840);
        a<Boolean> aVar = this.UwG;
        if (aVar == null) {
            AppMethodBeat.o(262840);
            return;
        }
        if (aVar.invoke().booleanValue()) {
            u.X(this);
        }
        AppMethodBeat.o(262840);
    }

    /* access modifiers changed from: protected */
    public final boolean canAnimate() {
        return false;
    }

    public final void setTouchEnabled(boolean z) {
        this.pbB = z;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(262841);
        p.h(motionEvent, "ev");
        if (!this.pbB) {
            AppMethodBeat.o(262841);
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(262841);
        return dispatchTouchEvent;
    }

    public final boolean e(PointF pointF) {
        AppMethodBeat.i(262842);
        p.h(pointF, "pointF");
        RectF rectF = new RectF();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (!(childAt instanceof com.tencent.mm.plugin.festival.ui.view.a)) {
                childAt = null;
            }
            com.tencent.mm.plugin.festival.ui.view.a aVar = (com.tencent.mm.plugin.festival.ui.view.a) childAt;
            if (aVar != null) {
                rectF.set(aVar.getX(), aVar.getY(), aVar.getX() + ((float) aVar.getWidth()), aVar.getY() + ((float) aVar.getHeight()));
                if (rectF.contains(pointF.x, pointF.y)) {
                    boolean performClick = aVar.performClick();
                    AppMethodBeat.o(262842);
                    return performClick;
                }
            }
        }
        AppMethodBeat.o(262842);
        return false;
    }
}
