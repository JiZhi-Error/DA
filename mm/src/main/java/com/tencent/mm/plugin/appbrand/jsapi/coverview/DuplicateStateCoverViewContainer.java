package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;

public class DuplicateStateCoverViewContainer extends CoverViewContainer {
    public DuplicateStateCoverViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DuplicateStateCoverViewContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(140671);
        boolean contains = cu(this).contains(motionEvent.getRawX(), motionEvent.getRawY());
        if (motionEvent.getActionMasked() != 0 || K(motionEvent.getX(), motionEvent.getY()) || contains) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (!dispatchTouchEvent && motionEvent.getActionMasked() != 0) {
                int childCount = getChildCount();
                int pointerId = isMotionEventSplittingEnabled() ? 1 << motionEvent.getPointerId(motionEvent.getActionIndex()) : -1;
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    View childAt = getChildAt(i2);
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if ((!(childAt instanceof CoverViewContainer) || ((CoverViewContainer) childAt).bGj()) && AppBrandViewMotionCompat.cN(childAt) && AppBrandViewMotionCompat.a(this, x, y, childAt) && childAt.isDuplicateParentStateEnabled()) {
                        e.a(this, motionEvent, childAt, pointerId);
                        if ((childAt instanceof f) && ((f) childAt).bEY()) {
                            break;
                        }
                    }
                }
            }
            AppMethodBeat.o(140671);
            return dispatchTouchEvent;
        }
        AppMethodBeat.o(140671);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer
    public final boolean bGj() {
        return true;
    }
}
