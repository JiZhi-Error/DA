package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public class CustomViewPager extends WxViewPager {
    private static final String TAG = "MicroMsg.CustomViewPager";
    private boolean mCanSlide = true;
    private boolean mCanSlideBySide = true;
    private SwipeBackLayout.b mSwipeBackListener = null;

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCanSlide(boolean z) {
        this.mCanSlide = z;
    }

    public void setCanSlideBySide(boolean z) {
        this.mCanSlideBySide = z;
    }

    @Override // com.tencent.mm.ui.mogic.WxViewPager
    public boolean isGutterDrag(float f2, float f3) {
        AppMethodBeat.i(141620);
        if (this.mCanSlideBySide) {
            boolean isGutterDrag = super.isGutterDrag(f2, f3);
            AppMethodBeat.o(141620);
            return isGutterDrag;
        }
        AppMethodBeat.o(141620);
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(205203);
        if (this.mSwipeBackListener != null && this.mSwipeBackListener.eqF()) {
            if (!this.mSwipeBackListener.eqH()) {
                this.mSwipeBackListener.n(motionEvent);
            } else if (this.mSwipeBackListener.eqE() == 1) {
                this.mSwipeBackListener.n(motionEvent);
                AppMethodBeat.o(205203);
                return true;
            } else if (this.mSwipeBackListener.j(motionEvent)) {
                motionEvent.setAction(3);
                super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(205203);
                return true;
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(205203);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mm.ui.mogic.WxViewPager
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.i(141621);
        if (!this.mCanSlide) {
            AppMethodBeat.o(141621);
        } else {
            try {
                z = super.onInterceptTouchEvent(motionEvent);
                AppMethodBeat.o(141621);
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "get a Exception", new Object[0]);
                AppMethodBeat.o(141621);
            }
        }
        return z;
    }

    @Override // com.tencent.mm.ui.mogic.WxViewPager
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.i(141622);
        if (!this.mCanSlide) {
            AppMethodBeat.o(141622);
        } else {
            try {
                z = super.onTouchEvent(motionEvent);
                AppMethodBeat.o(141622);
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "get a Exception", new Object[0]);
                AppMethodBeat.o(141622);
            }
        }
        return z;
    }

    public void setSwipeBackListener(SwipeBackLayout.b bVar) {
        this.mSwipeBackListener = bVar;
    }
}
