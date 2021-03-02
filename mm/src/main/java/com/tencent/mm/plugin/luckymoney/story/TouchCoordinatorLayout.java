package com.tencent.mm.plugin.luckymoney.story;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class TouchCoordinatorLayout extends CoordinatorLayout {
    private List<View.OnTouchListener> zbn = new ArrayList();
    public boolean zbo = false;

    public TouchCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(163684);
        AppMethodBeat.o(163684);
    }

    public TouchCoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(163685);
        AppMethodBeat.o(163685);
    }

    public final void b(View.OnTouchListener onTouchListener) {
        AppMethodBeat.i(163686);
        this.zbn.add(onTouchListener);
        AppMethodBeat.o(163686);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(163687);
        for (View.OnTouchListener onTouchListener : this.zbn) {
            onTouchListener.onTouch(this, motionEvent);
        }
        if (this.zbo) {
            AppMethodBeat.o(163687);
            return true;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(163687);
        return dispatchTouchEvent;
    }
}
