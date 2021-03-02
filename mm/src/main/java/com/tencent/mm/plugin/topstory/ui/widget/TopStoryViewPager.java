package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TopStoryViewPager extends ViewPager {
    private boolean canScroll = true;

    public TopStoryViewPager(Context context) {
        super(context);
    }

    public TopStoryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setScrollEnable(boolean z) {
        this.canScroll = z;
    }

    @Override // android.support.v4.view.ViewPager
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(126676);
        if (!this.canScroll) {
            AppMethodBeat.o(126676);
            return false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(126676);
        return onTouchEvent;
    }

    @Override // android.support.v4.view.ViewPager
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(126677);
        if (!this.canScroll) {
            AppMethodBeat.o(126677);
            return false;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(126677);
        return onInterceptTouchEvent;
    }
}
