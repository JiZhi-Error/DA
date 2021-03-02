package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WrapScollview extends ScrollView {
    private boolean ESm = true;
    private View contentView;

    public WrapScollview(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public WrapScollview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setContentView(View view) {
        this.contentView = view;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        AppMethodBeat.i(99805);
        if (this.contentView != null) {
            View view = this.contentView;
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = view.getWidth() + i2;
            int i3 = iArr[1];
            int height = view.getHeight() + i3;
            if (((float) i2) >= rawX || rawX >= ((float) width) || ((float) i3) >= rawY || rawY >= ((float) height)) {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(99805);
                return false;
            }
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(99805);
        return onInterceptTouchEvent;
    }

    public void setDoComputeScrollDeltaToGetChildRectOnScreen(boolean z) {
        this.ESm = z;
    }

    /* access modifiers changed from: protected */
    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        AppMethodBeat.i(99806);
        if (!this.ESm) {
            AppMethodBeat.o(99806);
            return 0;
        }
        int computeScrollDeltaToGetChildRectOnScreen = super.computeScrollDeltaToGetChildRectOnScreen(rect);
        AppMethodBeat.o(99806);
        return computeScrollDeltaToGetChildRectOnScreen;
    }
}
