package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class MMFlipper extends ViewGroup {
    protected int OPT;
    private int OPU;
    private boolean OPV;
    private c OPW;
    private a OPX;
    private b OPY;
    private Interpolator OPZ;
    private int OPg;
    protected int OPi;
    protected int OPj;
    private boolean OPl;
    int OQa;
    int OQb;
    private float mLastMotionX;
    private float mLastMotionY;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public interface a {
        void aiv(int i2);
    }

    public interface b {
        void ig(int i2, int i3);
    }

    public interface c {
        void z(int i2, int i3, boolean z);
    }

    /* access modifiers changed from: package-private */
    public static class d implements Interpolator {
        private float BAe;

        public d() {
            this.BAe = 1.3f;
            this.BAe = 0.0f;
        }

        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3) + 1.0f;
        }
    }

    public MMFlipper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.i(141897);
        init(context);
        AppMethodBeat.o(141897);
    }

    public MMFlipper(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(141898);
        this.OPU = 0;
        this.OPg = 0;
        this.OPV = false;
        this.OPl = true;
        this.OQa = -123454321;
        this.OQb = -123454321;
        init(context);
        AppMethodBeat.o(141898);
    }

    /* access modifiers changed from: protected */
    public Interpolator getInterpolator() {
        AppMethodBeat.i(141899);
        d dVar = new d();
        AppMethodBeat.o(141899);
        return dVar;
    }

    private void init(Context context) {
        AppMethodBeat.i(141900);
        this.OPZ = getInterpolator();
        this.mScroller = new Scroller(context, this.OPZ);
        this.OPj = -1;
        int i2 = this.OPU;
        this.OPi = i2;
        this.OPT = i2;
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        AppMethodBeat.o(141900);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(141901);
        long currentTicks = Util.currentTicks();
        int i6 = 0;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                Log.v("MicroMsg.MMFlipper", "flipper onLayout childWidth:".concat(String.valueOf(measuredWidth)));
                childAt.layout(i6, 0, i6 + measuredWidth, childAt.getMeasuredHeight());
                i6 += measuredWidth;
            }
        }
        Log.v("MicroMsg.MMFlipper", "use " + Util.ticksToNow(currentTicks) + " ms, flipper onLayout changed:" + z + " Left,Top,Right,Bottom:" + i2 + "," + i3 + "," + i4 + "," + i5);
        AppMethodBeat.o(141901);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(141902);
        long currentTicks = Util.currentTicks();
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (this.OPY != null) {
            this.OPY.ig(size, size2);
        }
        this.OQa = size;
        this.OQb = size2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            getChildAt(i4).measure(i2, i3);
        }
        scrollTo(this.OPi * size, 0);
        Log.i("MicroMsg.MMFlipper", "flipper onMeasure:" + size + "," + View.MeasureSpec.getSize(i3) + " childCount:" + childCount + ", use " + Util.ticksToNow(currentTicks));
        AppMethodBeat.o(141902);
    }

    public void setOnMeasureListener(b bVar) {
        this.OPY = bVar;
    }

    public void setOnScreenChangedListener(c cVar) {
        this.OPW = cVar;
    }

    public void setOnFlipperViewShowedListener(a aVar) {
        this.OPX = aVar;
    }

    private void alu(int i2) {
        AppMethodBeat.i(141903);
        int max = Math.max(0, Math.min(i2, getChildCount() - 1));
        if (getScrollX() != getWidth() * max) {
            int width = (getWidth() * max) - getScrollX();
            this.mScroller.startScroll(getScrollX(), 0, width, 0, com.tencent.mm.cb.a.E(getContext(), (int) (((float) Math.abs(width)) * 1.3f)));
            if (this.OPi != max) {
                this.OPV = true;
                this.OPT += max - this.OPi;
            }
            this.OPj = this.OPi;
            this.OPi = max;
            invalidate();
        }
        AppMethodBeat.o(141903);
    }

    public final void alx(int i2) {
        AppMethodBeat.i(141904);
        int max = Math.max(0, Math.min(i2, getChildCount() - 1));
        this.OPV = false;
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        this.OPj = this.OPi;
        this.OPi = max;
        scrollTo(max * getWidth(), 0);
        AppMethodBeat.o(141904);
    }

    public final void aly(int i2) {
        this.OPT = i2;
    }

    public void setToScreen(int i2) {
        AppMethodBeat.i(141905);
        int max = Math.max(0, Math.min(i2, getChildCount() - 1));
        this.OPV = false;
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        if (this.OPW != null) {
            this.OPW.z(this.OPj, max, false);
        }
        this.OPj = this.OPi;
        this.OPi = max;
        this.OPT = max;
        scrollTo(max * getWidth(), 0);
        AppMethodBeat.o(141905);
    }

    public int getCurScreen() {
        AppMethodBeat.i(141906);
        Log.d("MicroMsg.MMFlipper", "cur screen is %d", Integer.valueOf(this.OPi));
        int i2 = this.OPi;
        AppMethodBeat.o(141906);
        return i2;
    }

    public void computeScroll() {
        AppMethodBeat.i(141907);
        this.mScroller.getCurrX();
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
            AppMethodBeat.o(141907);
            return;
        }
        if (this.OPV) {
            this.OPV = false;
            if (this.OPW != null) {
                this.OPW.z(this.OPj, this.OPT, true);
                AppMethodBeat.o(141907);
                return;
            }
        } else if (!(this.OPX == null || this.mLastMotionX != 0.0f || this.OPj == this.OPi)) {
            this.OPX.aiv(this.OPT);
        }
        AppMethodBeat.o(141907);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(141908);
        if (getChildCount() == 1) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(141908);
            return onTouchEvent;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        motionEvent.getY();
        switch (action) {
            case 0:
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                this.mLastMotionX = x;
                break;
            case 1:
            case 3:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000);
                int xVelocity = (int) velocityTracker.getXVelocity();
                if (xVelocity > 600 && this.OPi > 0) {
                    alu(this.OPi - 1);
                } else if (xVelocity >= -600 || this.OPi >= getChildCount() - 1) {
                    int width = getWidth();
                    alu((getScrollX() + (width / 2)) / width);
                } else {
                    alu(this.OPi + 1);
                }
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                }
                this.OPg = 0;
                this.mLastMotionX = 0.0f;
                this.mLastMotionY = 0.0f;
                break;
            case 2:
                this.mLastMotionX = x;
                scrollBy((int) (this.mLastMotionX - x), 0);
                break;
        }
        AppMethodBeat.o(141908);
        return true;
    }

    public void setScrollEnable(boolean z) {
        this.OPl = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(141909);
        if (!this.OPl) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(141909);
            return onInterceptTouchEvent;
        } else if (getChildCount() == 1) {
            boolean onInterceptTouchEvent2 = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(141909);
            return onInterceptTouchEvent2;
        } else {
            int action = motionEvent.getAction();
            if (action != 2 || this.OPg == 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                switch (action) {
                    case 0:
                        this.mLastMotionX = x;
                        this.mLastMotionY = y;
                        this.OPg = this.mScroller.isFinished() ? 0 : 1;
                        break;
                    case 1:
                    case 3:
                        this.OPg = 0;
                        break;
                    case 2:
                        int abs = (int) Math.abs(this.mLastMotionX - x);
                        int abs2 = (int) Math.abs(this.mLastMotionY - y);
                        Log.v("MicroMsg.MMFlipper", "xDif = " + abs + ", yDif = " + abs2);
                        if (abs <= this.mTouchSlop || abs2 >= this.mTouchSlop) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            this.OPg = 0;
                            break;
                        } else {
                            this.OPg = 1;
                            break;
                        }
                }
                if (this.OPg != 0) {
                    AppMethodBeat.o(141909);
                    return true;
                }
                AppMethodBeat.o(141909);
                return false;
            }
            AppMethodBeat.o(141909);
            return true;
        }
    }
}
