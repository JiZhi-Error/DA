package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LuckyMoneyEnvelopeTouchRecyclerView extends RecyclerView {
    public a zer;

    public interface a {
        boolean onInterceptTouchEvent(MotionEvent motionEvent);
    }

    public LuckyMoneyEnvelopeTouchRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LuckyMoneyEnvelopeTouchRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(65596);
        if (this.zer != null) {
            this.zer.onInterceptTouchEvent(motionEvent);
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(65596);
        return onInterceptTouchEvent;
    }
}
