package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.os.SystemClock;
import android.support.v4.view.u;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager;

public final class b implements View.OnTouchListener {
    private DummyViewPager Eie;
    private float Eif = Float.MIN_VALUE;
    private float dep = Float.MIN_VALUE;

    public b(DummyViewPager dummyViewPager) {
        this.Eie = dummyViewPager;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(97058);
        new StringBuilder("onTouchEvent , action ").append(motionEvent.getAction()).append(", e.rawY ").append(motionEvent.getRawY()).append(",lastMotionY ").append(this.Eif).append(",downY ").append(this.dep);
        switch (motionEvent.getAction()) {
            case 0:
                this.dep = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                if (this.Eie.mFakeDragging) {
                    try {
                        DummyViewPager dummyViewPager = this.Eie;
                        if (!dummyViewPager.mFakeDragging) {
                            IllegalStateException illegalStateException = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
                            AppMethodBeat.o(97058);
                            throw illegalStateException;
                        }
                        VelocityTracker velocityTracker = dummyViewPager.mVelocityTracker;
                        velocityTracker.computeCurrentVelocity(1000, (float) dummyViewPager.mMaximumVelocity);
                        int xVelocity = (int) velocityTracker.getXVelocity(dummyViewPager.mActivePointerId);
                        dummyViewPager.mPopulatePending = true;
                        int clientWidth = dummyViewPager.getClientWidth();
                        int scrollX = dummyViewPager.getScrollX();
                        AdLandingViewPager.b fdV = dummyViewPager.fdV();
                        dummyViewPager.setCurrentItemInternal(dummyViewPager.determineTargetPage(fdV.position, ((((float) scrollX) / ((float) clientWidth)) - fdV.offset) / fdV.widthFactor, xVelocity, (int) (dummyViewPager.mLastMotionX - dummyViewPager.mInitialMotionX)), true, true, xVelocity);
                        dummyViewPager.endDrag();
                        dummyViewPager.mFakeDragging = false;
                    } catch (Exception e2) {
                    }
                }
                this.dep = Float.MIN_VALUE;
                this.Eif = Float.MIN_VALUE;
                break;
            case 2:
                if (this.dep == Float.MIN_VALUE && this.Eif == Float.MIN_VALUE) {
                    this.dep = motionEvent.getRawY();
                    break;
                } else {
                    float rawY = motionEvent.getRawY() - (this.Eif == Float.MIN_VALUE ? this.dep : this.Eif);
                    this.Eif = motionEvent.getRawY();
                    float f2 = rawY / 2.0f;
                    new StringBuilder("scrollX ").append(this.Eie.getScrollX()).append(",basescrollX ").append(this.Eie.getBaseScrollX());
                    if (this.Eie.getScrollX() == this.Eie.getBaseScrollX()) {
                        if (u.o(view, (-f2) > 0.0f ? 1 : -1)) {
                            new StringBuilder("scroll vertically  ").append(f2).append(", move.lastMotionY ").append(motionEvent.getY());
                            break;
                        } else {
                            DummyViewPager dummyViewPager2 = this.Eie;
                            if (!dummyViewPager2.mIsBeingDragged) {
                                dummyViewPager2.mFakeDragging = true;
                                dummyViewPager2.setScrollState(1);
                                dummyViewPager2.mLastMotionX = 0.0f;
                                dummyViewPager2.mInitialMotionX = 0.0f;
                                if (dummyViewPager2.mVelocityTracker == null) {
                                    dummyViewPager2.mVelocityTracker = VelocityTracker.obtain();
                                } else {
                                    dummyViewPager2.mVelocityTracker.clear();
                                }
                                long uptimeMillis = SystemClock.uptimeMillis();
                                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
                                dummyViewPager2.mVelocityTracker.addMovement(obtain);
                                obtain.recycle();
                                dummyViewPager2.mFakeDragBeginTime = uptimeMillis;
                            }
                            a(view, motionEvent, f2);
                            e(view, motionEvent);
                            AppMethodBeat.o(97058);
                            return false;
                        }
                    } else if (a(view, motionEvent, f2)) {
                        AppMethodBeat.o(97058);
                        return false;
                    }
                }
                break;
        }
        boolean onTouchEvent = view.onTouchEvent(motionEvent);
        AppMethodBeat.o(97058);
        return onTouchEvent;
    }

    private boolean a(View view, MotionEvent motionEvent, float f2) {
        float f3;
        AppMethodBeat.i(97059);
        if (this.Eie.mFakeDragging) {
            if (am((float) (((int) (((float) this.Eie.getScrollX()) - f2)) - this.Eie.getBaseScrollX()), (float) (this.Eie.getScrollX() - this.Eie.getBaseScrollX()))) {
                f3 = (float) (this.Eie.getScrollX() - this.Eie.getBaseScrollX());
            } else {
                f3 = f2;
            }
            this.Eie.fakeDragBy(f3);
            new StringBuilder("fake drag, diff ").append(f2).append(",step ").append(f3).append(",scrollX ").append(this.Eie.getScrollX());
            e(view, motionEvent);
            AppMethodBeat.o(97059);
            return true;
        }
        AppMethodBeat.o(97059);
        return false;
    }

    private static void e(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(97060);
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(0);
        view.dispatchTouchEvent(obtain);
        AppMethodBeat.o(97060);
    }

    private static boolean am(float f2, float f3) {
        AppMethodBeat.i(97061);
        if (Math.abs(f2 + f3) < Math.abs(f2 - f3)) {
            AppMethodBeat.o(97061);
            return true;
        }
        AppMethodBeat.o(97061);
        return false;
    }
}
