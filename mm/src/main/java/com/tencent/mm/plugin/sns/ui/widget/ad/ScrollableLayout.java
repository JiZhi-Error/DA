package com.tencent.mm.plugin.sns.ui.widget.ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;

public class ScrollableLayout extends LinearLayout {
    private int DtN;
    private int Fcb;
    private int Fcc;
    public View Fgd;
    private int Fge;
    private int Fgf;
    private int Fgg;
    private int Fgh;
    private int Fgi;
    private int Fgj;
    private a Fgk;
    private b Fgl;
    private int mActivePointerId;
    private boolean mIsBeingDragged;
    protected Scroller mScroller;
    private int mTouchSlop;

    public interface a {
    }

    public interface b {
        void aS(int i2, boolean z);
    }

    public ScrollableLayout(Context context) {
        this(context, null);
    }

    public ScrollableLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrollableLayout(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    private ScrollableLayout(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, 0);
        AppMethodBeat.i(204024);
        this.mIsBeingDragged = false;
        this.Fge = 0;
        this.Fgf = 0;
        this.Fgg = 0;
        this.Fgh = 0;
        this.mActivePointerId = -1;
        this.Fgi = 0;
        this.Fgj = 0;
        try {
            this.mScroller = new Scroller(context, new DecelerateInterpolator());
            this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            setOrientation(1);
            this.DtN = context.getResources().getDimensionPixelOffset(R.dimen.aju);
            AppMethodBeat.o(204024);
        } catch (Throwable th) {
            Log.w("ScrollLinearLayout", "the init method has something wrong!");
            AppMethodBeat.o(204024);
        }
    }

    public void computeScroll() {
        AppMethodBeat.i(204025);
        super.computeScroll();
        try {
            if (this.mScroller.computeScrollOffset()) {
                scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
                invalidate();
                AppMethodBeat.o(204025);
                return;
            }
            if (this.Fgj == 2) {
                Log.i("ScrollLinearLayout", "compute scroll offset is false the currY is " + this.mScroller.getCurrY() + ", the final Y is " + this.mScroller.getFinalY());
                aar(0);
            }
            AppMethodBeat.o(204025);
        } catch (Throwable th) {
            Log.w("ScrollLinearLayout", "the compute scroll has something wrong!");
            AppMethodBeat.o(204025);
        }
    }

    public void setMaxYScrollOffset(int i2) {
        this.Fgf = i2;
    }

    public void setMaxOverScrollOffset(int i2) {
        this.Fge = i2;
    }

    public void setDescendantScrollStatusHunter(a aVar) {
        this.Fgk = aVar;
    }

    public void setOnScrollStatusListener(b bVar) {
        this.Fgl = bVar;
    }

    private boolean x(View view, int i2, int i3) {
        AppMethodBeat.i(204028);
        if (view == null) {
            AppMethodBeat.o(204028);
            return false;
        }
        int scrollY = getScrollY();
        if (i3 < view.getTop() - scrollY || i3 >= view.getBottom() - scrollY || i2 < view.getLeft() || i2 >= view.getRight()) {
            AppMethodBeat.o(204028);
            return false;
        }
        AppMethodBeat.o(204028);
        return true;
    }

    private void aar(int i2) {
        AppMethodBeat.i(204029);
        if (i2 != this.Fgj) {
            b bVar = this.Fgl;
            if (bVar != null) {
                bVar.aS(i2, getScrollY() >= this.Fgf);
            }
            Log.i("ScrollLinearLayout", "the new state is ".concat(String.valueOf(i2)));
            this.Fgj = i2;
        }
        AppMethodBeat.o(204029);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        int i2;
        boolean z = false;
        AppMethodBeat.i(204026);
        try {
            int action = motionEvent.getAction();
            if (action != 2 || !this.mIsBeingDragged) {
                switch (action & 255) {
                    case 0:
                        int x = (int) motionEvent.getX();
                        int y = (int) motionEvent.getY();
                        this.Fgi = getScrollY();
                        if (!x(this.Fgd, x, y)) {
                            this.mIsBeingDragged = false;
                        } else {
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            this.Fcb = y;
                            this.Fcc = x;
                            if (!this.mScroller.isFinished()) {
                                z = true;
                            }
                            this.mIsBeingDragged = z;
                            if (this.Fge > 0) {
                                i2 = this.Fge;
                            } else {
                                i2 = this.Fgf / 3;
                            }
                            this.Fgg = this.Fgf + i2;
                            this.Fgh = -i2;
                        }
                        Log.i("ScrollLinearLayout", "the onInterceptTouchActionDown is called " + this.mIsBeingDragged + ", mScrollYWhenTouchDown = " + this.Fgi);
                        z = this.mIsBeingDragged;
                        break;
                    case 1:
                    case 3:
                        this.mIsBeingDragged = false;
                        this.mActivePointerId = -1;
                        Log.i("ScrollLinearLayout", "the onInterceptTouchActionUpOrCancel is called " + this.mIsBeingDragged);
                        z = this.mIsBeingDragged;
                        break;
                    case 2:
                        int i3 = this.mActivePointerId;
                        if (i3 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i3)) >= 0) {
                            int x2 = (int) motionEvent.getX(findPointerIndex);
                            int y2 = (int) motionEvent.getY(findPointerIndex);
                            int i4 = y2 - this.Fcb;
                            int scrollY = getScrollY();
                            if (Math.abs(i4) >= this.mTouchSlop) {
                                this.Fcb = y2;
                                this.Fcc = x2;
                                if ((i4 < 0 && scrollY <= 0) || (i4 > 0 && scrollY >= this.Fgf)) {
                                    this.mIsBeingDragged = true;
                                }
                            }
                        }
                        Log.i("ScrollLinearLayout", "the onInterceptTouchActionMove is called " + this.mIsBeingDragged);
                        z = this.mIsBeingDragged;
                        break;
                }
            } else {
                z = true;
            }
            if (z) {
                AppMethodBeat.o(204026);
                return true;
            }
        } catch (Throwable th) {
            Log.e("ScrollLinearLayout", "the onInterceptTouchEventInner has something wrong");
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(204026);
        return onInterceptTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        boolean z = false;
        AppMethodBeat.i(204027);
        try {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (x(this.Fgd, x, y)) {
                        if (!this.mScroller.isFinished()) {
                            z = true;
                        }
                        this.mIsBeingDragged = z;
                        if (!this.mScroller.isFinished()) {
                            this.mScroller.abortAnimation();
                        }
                        this.Fcc = x;
                        this.Fcb = y;
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        Log.i("ScrollLinearLayout", "the onTouchActionDown is called " + this.mIsBeingDragged);
                        z = this.mIsBeingDragged;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    int i3 = this.Fgi;
                    int scrollY = getScrollY();
                    int i4 = scrollY - i3;
                    if (i4 > 0) {
                        i2 = this.Fgf - scrollY;
                        if (i4 < this.DtN) {
                            i2 = -scrollY;
                        }
                    } else {
                        i2 = -scrollY;
                        if (i4 > (-this.DtN)) {
                            i2 = this.Fgf - scrollY;
                        }
                    }
                    Log.i("ScrollLinearLayout", "the onTouchActionUpOrCancel is called, mScrollYWhenTouchDown = " + i3 + ", currentScrollY = " + scrollY + ", yDistance = " + i2);
                    if (this.mIsBeingDragged) {
                        this.mScroller.startScroll(getScrollX(), scrollY, 0, i2, 350);
                        invalidate();
                        aar(2);
                        z = true;
                    } else {
                        aar(0);
                    }
                    this.mIsBeingDragged = false;
                    this.mActivePointerId = -1;
                    this.Fcb = 0;
                    this.Fcc = 0;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex < 0) {
                        Log.e("ScrollLinearLayout", "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
                    } else {
                        int x2 = (int) motionEvent.getX(findPointerIndex);
                        int y2 = (int) motionEvent.getY(findPointerIndex);
                        int i5 = y2 - this.Fcb;
                        if (!this.mIsBeingDragged && Math.abs(i5) >= this.mTouchSlop) {
                            this.mIsBeingDragged = true;
                            i5 = i5 > 0 ? i5 - this.mTouchSlop : i5 + this.mTouchSlop;
                        }
                        int scrollY2 = getScrollY() - i5;
                        if (this.mIsBeingDragged && this.Fgh < scrollY2 && this.Fgg > scrollY2) {
                            aar(1);
                            scrollBy(0, -i5);
                            this.Fcb = y2;
                            this.Fcc = x2;
                        }
                    }
                    z = true;
                    break;
            }
            if (z) {
                AppMethodBeat.o(204027);
                return true;
            }
        } catch (Throwable th) {
            Log.e("ScrollLinearLayout", "the onTouchEventInner is called " + this.mIsBeingDragged);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(204027);
        return onTouchEvent;
    }
}
