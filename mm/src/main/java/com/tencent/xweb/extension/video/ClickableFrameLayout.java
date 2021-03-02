package com.tencent.xweb.extension.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ClickableFrameLayout extends FrameLayout {
    private GestureDetector mDJ;
    private View.OnClickListener mOnClickListener;

    public void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(153552);
        super.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
        AppMethodBeat.o(153552);
    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        this.mDJ = gestureDetector;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mOnClickListener != null;
    }

    public ClickableFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ClickableFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
