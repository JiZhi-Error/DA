package com.tencent.mm.plugin.gallery.picker.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TouchCoordinatorLayout extends CoordinatorLayout {
    private View.OnTouchListener uwC;

    public TouchCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TouchCoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setTouchListener(View.OnTouchListener onTouchListener) {
        this.uwC = onTouchListener;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(164789);
        if (this.uwC != null) {
            this.uwC.onTouch(this, motionEvent);
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(164789);
        return dispatchTouchEvent;
    }
}
