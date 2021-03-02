package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class MMADFlipper extends ViewGroup {
    private int OPg;
    private Interpolator OPh;
    private int OPi;
    private int OPj;
    private boolean OPk;
    private boolean OPl;
    private a OPm;
    private View agA;
    private Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private View rfF;

    public interface a {
    }

    public MMADFlipper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMADFlipper(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(141755);
        this.OPg = 0;
        this.OPk = false;
        this.OPl = true;
        this.mContext = context;
        this.OPh = getInterpolator();
        this.mScroller = new Scroller(this.mContext, this.OPh);
        this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledDoubleTapSlop();
        AppMethodBeat.o(141755);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(141756);
        super.onFinishInflate();
        AppMethodBeat.o(141756);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(141757);
        int childCount = getChildCount();
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i6, 0, i6 + measuredWidth, childAt.getMeasuredHeight());
                i6 += measuredWidth;
            }
        }
        AppMethodBeat.o(141757);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(141758);
        super.onMeasure(i2, i3);
        View.MeasureSpec.getSize(i2);
        View.MeasureSpec.getSize(i3);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            getChildAt(i4).measure(i2, i3);
        }
        AppMethodBeat.o(141758);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(141760);
        if (getChildCount() == 1) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(141760);
            return onTouchEvent;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
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
                if (xVelocity > 600) {
                    if (gKC()) {
                        this.OPi--;
                        alt(this.OPi);
                    }
                    this.OPk = true;
                } else if (xVelocity < -600) {
                    if (gKC()) {
                        this.OPi++;
                        alt(this.OPi);
                    }
                    this.OPk = true;
                } else {
                    int width = getWidth();
                    alt((getScrollX() + (width / 2)) / width);
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
        AppMethodBeat.o(141760);
        return true;
    }

    private Interpolator getInterpolator() {
        AppMethodBeat.i(141761);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        AppMethodBeat.o(141761);
        return linearInterpolator;
    }

    public void setHeaderView(View view) {
        this.agA = view;
    }

    public void setFooterView(View view) {
        this.rfF = view;
    }

    public void setScrollEnable(boolean z) {
        this.OPl = z;
    }

    private boolean gKC() {
        AppMethodBeat.i(141762);
        if (getChildCount() > 1) {
            AppMethodBeat.o(141762);
            return true;
        }
        AppMethodBeat.o(141762);
        return false;
    }

    public int getRealChildCount() {
        AppMethodBeat.i(141763);
        if (getChildCount() > 1) {
            int childCount = getChildCount() - 2;
            AppMethodBeat.o(141763);
            return childCount;
        }
        int childCount2 = getChildCount();
        AppMethodBeat.o(141763);
        return childCount2;
    }

    public int getCurScreen() {
        return this.OPi;
    }

    public int getRealCurScreen() {
        AppMethodBeat.i(141764);
        if (getChildCount() > 1) {
            int i2 = this.OPi - 1;
            AppMethodBeat.o(141764);
            return i2;
        }
        int i3 = this.OPi;
        AppMethodBeat.o(141764);
        return i3;
    }

    private void alt(int i2) {
        AppMethodBeat.i(141765);
        alu(i2);
        Log.d("MicroMsg.MMFlipper", "mCurScreen:%d, mLastScreen:%d, whichScreen:%d", Integer.valueOf(this.OPi), Integer.valueOf(this.OPj), Integer.valueOf(i2));
        this.OPj = i2;
        AppMethodBeat.o(141765);
    }

    private void alu(int i2) {
        AppMethodBeat.i(141766);
        int max = Math.max(0, Math.min(i2, getChildCount() - 1));
        if (getScrollX() != getWidth() * max) {
            int width = (max * getWidth()) - getScrollX();
            this.mScroller.startScroll(getScrollX(), 0, width, 0, com.tencent.mm.cb.a.E(getContext(), Math.abs(width) * 2));
            invalidate();
        }
        AppMethodBeat.o(141766);
    }

    public void computeScroll() {
        AppMethodBeat.i(141767);
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
            AppMethodBeat.o(141767);
            return;
        }
        if (this.OPk) {
            this.OPk = false;
            if (this.OPi <= 0) {
                this.OPi = getRealChildCount();
                setScrollXOffest(this.OPi * getWidth());
                AppMethodBeat.o(141767);
                return;
            } else if (this.OPi >= getChildCount() - 1) {
                this.OPi = 1;
                setScrollXOffest(this.OPi * getWidth());
            }
        }
        AppMethodBeat.o(141767);
    }

    public void setOnScreenChangedListener(a aVar) {
        this.OPm = aVar;
    }

    @TargetApi(14)
    public void setScrollXOffest(int i2) {
        AppMethodBeat.i(141768);
        if (Build.VERSION.SDK_INT >= 14) {
            setScrollX(i2);
            AppMethodBeat.o(141768);
            return;
        }
        if (this.mScroller != null) {
            this.mScroller.setFinalX(i2);
        }
        AppMethodBeat.o(141768);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(141759);
        if (!this.OPl) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(141759);
            return onInterceptTouchEvent;
        } else if (getChildCount() == 1) {
            boolean onInterceptTouchEvent2 = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(141759);
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
                        break;
                }
                if (this.OPg != 0) {
                    AppMethodBeat.o(141759);
                    return true;
                }
                AppMethodBeat.o(141759);
                return false;
            }
            AppMethodBeat.o(141759);
            return true;
        }
    }
}
