package com.tencent.mm.plugin.luckymoney.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.RecyclerHorizontalViewPager;

public class LuckyMoneyStoryViewPager extends RecyclerHorizontalViewPager {
    public LuckyMoneyStoryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.view.RecyclerHorizontalViewPager
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(163683);
        if (motionEvent.getActionMasked() == 3) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 1, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState()));
            AppMethodBeat.o(163683);
            return dispatchTouchEvent;
        }
        boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(163683);
        return dispatchTouchEvent2;
    }
}
