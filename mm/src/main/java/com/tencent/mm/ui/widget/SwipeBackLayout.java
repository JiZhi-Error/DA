package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.mogic.a;
import com.tencent.mm.ui.tools.j;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

public class SwipeBackLayout extends FrameLayout {
    public com.tencent.mm.ui.mogic.a QFb;
    public a QFc;
    private float TH;
    private Rect Ui;
    private Drawable hfA;
    private boolean hfB;
    private boolean hfC;
    private float hfn;
    private int hfo;
    private int hfp;
    private float hfr;
    public Drawable hfs;
    private boolean hft;
    private boolean hfu;
    public boolean hfv;
    public boolean hfw;
    public boolean hfx;
    private boolean hfy;
    public View mContentView;
    private boolean mEnable;
    private boolean mInLayout;
    private b mSwipeBackListener;

    public interface a {
        void onCancel();

        void onDrag();

        void onSwipeBack();
    }

    public interface b {
        void RF(int i2);

        int bS(boolean z);

        void bw(float f2);

        int eqE();

        boolean eqF();

        boolean eqH();

        boolean j(MotionEvent motionEvent);

        void n(MotionEvent motionEvent);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(143486);
        this.hfn = 0.3f;
        this.mEnable = true;
        this.Ui = new Rect();
        this.hft = true;
        this.hfu = false;
        this.hfv = false;
        this.hfw = false;
        this.hfx = false;
        this.hfy = false;
        this.hfC = true;
        this.QFc = null;
        this.hfs = getResources().getDrawable(R.drawable.bt9);
        setFocusable(true);
        setDescendantFocusability(TPMediaCodecProfileLevel.HEVCMainTierLevel52);
        init();
        AppMethodBeat.o(143486);
    }

    public final void init() {
        AppMethodBeat.i(143487);
        this.QFb = com.tencent.mm.ui.mogic.a.a(this, new c(this, (byte) 0), AnimationUtils.loadInterpolator(getContext(), R.anim.co));
        this.QFb.WJ = 1;
        float f2 = getResources().getDisplayMetrics().density;
        this.QFb.WH = 100.0f * f2;
        this.QFb.WG = f2 * 300.0f;
        this.hfo = 0;
        this.hfp = 0;
        AppMethodBeat.o(143487);
    }

    public final void CV(boolean z) {
        AppMethodBeat.i(143488);
        Log.i("MicroMsg.SwipeBackLayout", "ashutest::markTranslucent %B", Boolean.valueOf(z));
        this.hfv = z;
        AppMethodBeat.o(143488);
    }

    public void setNeedRequestActivityTranslucent(boolean z) {
        this.hft = z;
        if (this.hft) {
            this.hfu = false;
        }
    }

    public void setSwipeBackListener(b bVar) {
        this.mSwipeBackListener = bVar;
    }

    public final boolean gqI() {
        AppMethodBeat.i(143489);
        awK();
        boolean z = this.hfx;
        AppMethodBeat.o(143489);
        return z;
    }

    public void setContentView(View view) {
        this.mContentView = view;
    }

    public View getTargetContentView() {
        return this.mContentView;
    }

    public void onFinishInflate() {
        this.mContentView = this;
    }

    public void setEnableGesture(boolean z) {
        this.mEnable = z;
    }

    public void setOnceDisEnableGesture(boolean z) {
        AppMethodBeat.i(143490);
        Log.i("MicroMsg.SwipeBackLayout", "[setOnceDisEnableGesture] enable:%s", Boolean.valueOf(z));
        this.hfB = z;
        AppMethodBeat.o(143490);
    }

    public final boolean awK() {
        AppMethodBeat.i(143491);
        if (!this.hfx) {
            AppMethodBeat.o(143491);
            return false;
        } else if (Float.compare((float) this.mContentView.getLeft(), 0.01f) <= 0) {
            this.hfx = false;
            AppMethodBeat.o(143491);
            return false;
        } else {
            AppMethodBeat.o(143491);
            return true;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View J;
        View J2;
        int i2;
        AppMethodBeat.i(143492);
        if (!this.mEnable) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(143492);
            return dispatchTouchEvent;
        }
        if (this.mSwipeBackListener != null && this.mSwipeBackListener.eqF()) {
            if (!this.mSwipeBackListener.eqH()) {
                this.mSwipeBackListener.n(motionEvent);
            } else if (this.mSwipeBackListener.eqE() == 1) {
                this.mSwipeBackListener.n(motionEvent);
                AppMethodBeat.o(143492);
                return true;
            } else if (this.mSwipeBackListener.j(motionEvent)) {
                motionEvent.setAction(3);
                super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(143492);
                return true;
            }
        }
        if (motionEvent.getAction() == 0) {
            this.hfB = false;
        }
        if (this.hfB) {
            boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(143492);
            return dispatchTouchEvent2;
        } else if (awK()) {
            boolean dispatchTouchEvent3 = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(143492);
            return dispatchTouchEvent3;
        } else {
            try {
                if (this.QFb.Wx == 1) {
                    com.tencent.mm.ui.mogic.a aVar = this.QFb;
                    int actionMasked = motionEvent.getActionMasked();
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionMasked == 0) {
                        aVar.cancel();
                    }
                    if (aVar.mVelocityTracker == null) {
                        aVar.mVelocityTracker = VelocityTracker.obtain();
                    }
                    aVar.mVelocityTracker.addMovement(motionEvent);
                    switch (actionMasked) {
                        case 0:
                            float x = motionEvent.getX();
                            float y = motionEvent.getY();
                            int pointerId = motionEvent.getPointerId(0);
                            View J3 = aVar.J((int) x, (int) y);
                            aVar.a(x, y, pointerId);
                            aVar.z(J3, pointerId);
                            if ((aVar.WJ & aVar.WC[pointerId]) != 0) {
                            }
                            break;
                        case 1:
                            if (aVar.Wx == 1) {
                                aVar.gq();
                            }
                            aVar.cancel();
                            break;
                        case 2:
                            if (aVar.Wx == 1) {
                                int findPointerIndex = motionEvent.findPointerIndex(aVar.mActivePointerId);
                                float x2 = motionEvent.getX(findPointerIndex);
                                float y2 = motionEvent.getY(findPointerIndex);
                                int i3 = (int) (x2 - aVar.WA[aVar.mActivePointerId]);
                                int i4 = (int) (y2 - aVar.WB[aVar.mActivePointerId]);
                                int left = aVar.WL.getLeft() + i3;
                                int top = aVar.WL.getTop() + i4;
                                int left2 = aVar.WL.getLeft();
                                int top2 = aVar.WL.getTop();
                                if (i3 != 0) {
                                    left = aVar.Qnx.e(aVar.WL, left);
                                    aVar.WL.offsetLeftAndRight(left - left2);
                                }
                                if (i4 != 0) {
                                    aVar.WL.offsetTopAndBottom(0 - top2);
                                    top = 0;
                                }
                                if (!(i3 == 0 && i4 == 0)) {
                                    aVar.Qnx.cL(left, top);
                                }
                                aVar.i(motionEvent);
                                break;
                            } else {
                                int pointerCount = motionEvent.getPointerCount();
                                for (int i5 = 0; i5 < pointerCount; i5++) {
                                    int pointerId2 = motionEvent.getPointerId(i5);
                                    float x3 = motionEvent.getX(i5);
                                    float y3 = motionEvent.getY(i5);
                                    float f2 = x3 - aVar.Wy[pointerId2];
                                    aVar.b(f2, y3 - aVar.Wz[pointerId2], pointerId2);
                                    if (aVar.Wx != 1) {
                                        View J4 = aVar.J((int) x3, (int) y3);
                                        if (!aVar.r(J4, f2) || !aVar.z(J4, pointerId2)) {
                                        }
                                    }
                                    aVar.i(motionEvent);
                                    break;
                                }
                                aVar.i(motionEvent);
                            }
                            break;
                        case 3:
                            if (aVar.Wx == 1) {
                                aVar.l(0.0f, 0.0f);
                            }
                            aVar.cancel();
                            break;
                        case 5:
                            int pointerId3 = motionEvent.getPointerId(actionIndex);
                            float x4 = motionEvent.getX(actionIndex);
                            float y4 = motionEvent.getY(actionIndex);
                            aVar.a(x4, y4, pointerId3);
                            if (aVar.Wx == 0) {
                                aVar.z(aVar.J((int) x4, (int) y4), pointerId3);
                                break;
                            } else {
                                int i6 = (int) x4;
                                int i7 = (int) y4;
                                View view = aVar.WL;
                                if (view != null && i6 >= view.getLeft() && i6 < view.getRight() && i7 >= view.getTop() && i7 < view.getBottom()) {
                                    aVar.z(aVar.WL, pointerId3);
                                    break;
                                }
                            }
                            break;
                        case 6:
                            int pointerId4 = motionEvent.getPointerId(actionIndex);
                            if (aVar.Wx == 1 && pointerId4 == aVar.mActivePointerId) {
                                int pointerCount2 = motionEvent.getPointerCount();
                                int i8 = 0;
                                while (true) {
                                    if (i8 >= pointerCount2) {
                                        i2 = -1;
                                    } else {
                                        int pointerId5 = motionEvent.getPointerId(i8);
                                        if (pointerId5 != aVar.mActivePointerId) {
                                            if (aVar.J((int) motionEvent.getX(i8), (int) motionEvent.getY(i8)) == aVar.WL && aVar.z(aVar.WL, pointerId5)) {
                                                i2 = aVar.mActivePointerId;
                                            }
                                        }
                                        i8++;
                                    }
                                }
                                if (i2 == -1) {
                                    aVar.gq();
                                }
                            }
                            aVar.bd(pointerId4);
                            break;
                    }
                    AppMethodBeat.o(143492);
                    return true;
                }
                com.tencent.mm.ui.mogic.a aVar2 = this.QFb;
                int actionMasked2 = motionEvent.getActionMasked();
                int actionIndex2 = motionEvent.getActionIndex();
                if (actionMasked2 == 0) {
                    aVar2.cancel();
                }
                if (aVar2.mVelocityTracker == null) {
                    aVar2.mVelocityTracker = VelocityTracker.obtain();
                }
                aVar2.mVelocityTracker.addMovement(motionEvent);
                switch (actionMasked2) {
                    case 0:
                        float x5 = motionEvent.getX();
                        float y5 = motionEvent.getY();
                        int pointerId6 = motionEvent.getPointerId(0);
                        aVar2.a(x5, y5, pointerId6);
                        View J5 = aVar2.J((int) x5, (int) y5);
                        if (J5 == aVar2.WL && aVar2.Wx == 2) {
                            aVar2.z(J5, pointerId6);
                        }
                        if ((aVar2.WC[pointerId6] & aVar2.WJ) != 0) {
                        }
                        break;
                    case 1:
                    case 3:
                        aVar2.cancel();
                        break;
                    case 2:
                        int pointerCount3 = motionEvent.getPointerCount();
                        for (int i9 = 0; i9 < pointerCount3; i9++) {
                            int pointerId7 = motionEvent.getPointerId(i9);
                            float x6 = motionEvent.getX(i9);
                            float y6 = motionEvent.getY(i9);
                            float f3 = x6 - aVar2.Wy[pointerId7];
                            aVar2.b(f3, y6 - aVar2.Wz[pointerId7], pointerId7);
                            if (aVar2.Wx != 1 && ((J = aVar2.J((int) x6, (int) y6)) == null || !aVar2.r(J, f3) || !aVar2.z(J, pointerId7))) {
                            }
                            aVar2.i(motionEvent);
                            break;
                        }
                        aVar2.i(motionEvent);
                    case 5:
                        int pointerId8 = motionEvent.getPointerId(actionIndex2);
                        float x7 = motionEvent.getX(actionIndex2);
                        float y7 = motionEvent.getY(actionIndex2);
                        aVar2.a(x7, y7, pointerId8);
                        if (aVar2.Wx != 0 && aVar2.Wx == 2 && (J2 = aVar2.J((int) x7, (int) y7)) == aVar2.WL) {
                            aVar2.z(J2, pointerId8);
                            break;
                        }
                    case 6:
                        aVar2.bd(motionEvent.getPointerId(actionIndex2));
                        break;
                }
                if (aVar2.Wx == 1) {
                    Log.i("changelcai", "shouldInterceptTouchEvent %s", motionEvent);
                    motionEvent.setAction(3);
                    super.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.o(143492);
                    return true;
                }
                super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(143492);
                return true;
            } catch (NullPointerException e2) {
                Log.printErrStackTrace("MicroMsg.SwipeBackLayout", e2, "got an NullPointerException", new Object[0]);
                AppMethodBeat.o(143492);
                return false;
            } catch (IllegalArgumentException e3) {
                Log.printErrStackTrace("MicroMsg.SwipeBackLayout", e3, "got an IllegalArgumentException", new Object[0]);
                AppMethodBeat.o(143492);
                return false;
            } catch (ArrayIndexOutOfBoundsException e4) {
                Log.printErrStackTrace("MicroMsg.SwipeBackLayout", e4, "got an ArrayIndexOutOfBoundsException", new Object[0]);
                AppMethodBeat.o(143492);
                return false;
            } catch (IllegalStateException e5) {
                Log.printErrStackTrace("MicroMsg.SwipeBackLayout", e5, "got an IllegalStateException", new Object[0]);
                AppMethodBeat.o(143492);
                return false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(143493);
        this.mInLayout = true;
        if (this.mContentView != null) {
            this.mContentView.layout(this.hfo, this.hfp, this.hfo + this.mContentView.getMeasuredWidth(), this.hfp + this.mContentView.getMeasuredHeight());
        }
        this.mInLayout = false;
        AppMethodBeat.o(143493);
    }

    public void requestLayout() {
        AppMethodBeat.i(143494);
        if (!this.mInLayout) {
            super.requestLayout();
        }
        AppMethodBeat.o(143494);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        AppMethodBeat.i(143495);
        boolean z = view == this.mContentView;
        boolean drawChild = super.drawChild(canvas, view, j2);
        if (Float.compare(this.TH, 0.0f) > 0 && z && this.QFb.Wx != 0) {
            Rect rect = this.Ui;
            view.getHitRect(rect);
            this.hfs.setBounds(rect.left - this.hfs.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
            this.hfs.setAlpha((int) (this.TH * 255.0f));
            this.hfs.draw(canvas);
        }
        AppMethodBeat.o(143495);
        return drawChild;
    }

    public void computeScroll() {
        boolean z;
        AppMethodBeat.i(143496);
        this.TH = Math.max(0.0f, 1.0f - this.hfr);
        com.tencent.mm.ui.mogic.a aVar = this.QFb;
        if (aVar.Wx == 2) {
            boolean computeScrollOffset = aVar.hgg.UD.computeScrollOffset();
            int currX = aVar.hgg.UD.getCurrX();
            int currY = aVar.hgg.UD.getCurrY();
            int left = currX - aVar.WL.getLeft();
            int top = currY - aVar.WL.getTop();
            if (left != 0) {
                aVar.WL.offsetLeftAndRight(left);
            }
            if (top != 0) {
                aVar.WL.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                aVar.Qnx.cL(currX, currY);
            }
            if (computeScrollOffset && currX == aVar.hgg.UD.getFinalX() && currY == aVar.hgg.UD.getFinalY()) {
                aVar.hgg.UD.abortAnimation();
                computeScrollOffset = aVar.hgg.UD.isFinished();
            }
            if (!computeScrollOffset) {
                aVar.WN.post(aVar.WO);
            }
        }
        if (aVar.Wx == 2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            u.X(this);
        }
        AppMethodBeat.o(143496);
    }

    public void setNeedChangeWindowBackground(boolean z) {
        this.hfC = z;
    }

    /* access modifiers changed from: package-private */
    public class c extends a.AbstractC2121a implements b.AbstractC2081b {
        int hfE;
        int hfF;
        int hfG;

        private c() {
            this.hfE = 0;
            this.hfF = 0;
            this.hfG = 0;
        }

        /* synthetic */ c(SwipeBackLayout swipeBackLayout, byte b2) {
            this();
        }

        @Override // com.tencent.mm.ui.mogic.a.AbstractC2121a
        public final boolean pv(int i2) {
            boolean z;
            AppMethodBeat.i(143480);
            com.tencent.mm.ui.mogic.a aVar = SwipeBackLayout.this.QFb;
            if ((aVar.WF & (1 << i2)) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z || (aVar.WC[i2] & 1) == 0) {
                AppMethodBeat.o(143480);
                return false;
            }
            AppMethodBeat.o(143480);
            return true;
        }

        @Override // com.tencent.mm.ui.mogic.a.AbstractC2121a
        public final void RF(int i2) {
            AppMethodBeat.i(205444);
            if (SwipeBackLayout.this.mSwipeBackListener != null) {
                SwipeBackLayout.this.mSwipeBackListener.RF(i2);
            }
            AppMethodBeat.o(205444);
        }

        @Override // com.tencent.mm.ui.mogic.a.AbstractC2121a
        public final int awM() {
            return 1;
        }

        @Override // com.tencent.mm.ui.mogic.a.AbstractC2121a
        public final void cL(int i2, int i3) {
            AppMethodBeat.i(143481);
            if (!SwipeBackLayout.this.hfv) {
                Log.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mHasTranslucent is false");
                AppMethodBeat.o(143481);
                return;
            }
            SwipeBackLayout.this.hfr = Math.abs(((float) i2) / ((float) (SwipeBackLayout.this.mContentView.getWidth() + SwipeBackLayout.this.hfs.getIntrinsicWidth())));
            SwipeBackLayout.this.hfo = i2;
            SwipeBackLayout.this.hfp = i3;
            SwipeBackLayout.this.invalidate();
            if (SwipeBackLayout.this.mSwipeBackListener != null) {
                SwipeBackLayout.this.mSwipeBackListener.bw(SwipeBackLayout.this.hfr);
            }
            if (Float.compare(SwipeBackLayout.this.hfr, 1.0f) >= 0 && !SwipeBackLayout.this.hfw) {
                SwipeBackLayout.this.hfw = true;
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.widget.SwipeBackLayout.c.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(143473);
                        if (SwipeBackLayout.this.QFc != null) {
                            Log.i("MicroMsg.SwipeBackLayout", "ashutest:: on popOut");
                            if ((SwipeBackLayout.this.getContext() instanceof Activity) && SwipeBackLayout.this.hfA != null) {
                                if (SwipeBackLayout.this.hfC) {
                                    ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.this.hfA);
                                }
                                SwipeBackLayout.this.hfA = null;
                            }
                            SwipeBackLayout.this.QFc.onSwipeBack();
                        }
                        SwipeBackLayout.this.hfx = false;
                        AppMethodBeat.o(143473);
                    }
                });
            } else if (Float.compare(SwipeBackLayout.this.hfr, 0.01f) <= 0) {
                SwipeBackLayout.this.hfx = false;
                Log.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mScrollPercent:%s mHasCallPopOut:%s", Float.valueOf(SwipeBackLayout.this.hfr), Boolean.valueOf(SwipeBackLayout.this.hfw));
            }
            if (SwipeBackLayout.this.QFb.Wx == 1) {
                h.aq(SwipeBackLayout.this.hfr);
            }
            AppMethodBeat.o(143481);
        }

        @Override // com.tencent.mm.ui.mogic.a.AbstractC2121a
        public final void a(View view, float f2, float f3) {
            boolean z;
            AppMethodBeat.i(143482);
            int width = view.getWidth();
            this.hfF = 0;
            this.hfG = 0;
            this.hfF = (f2 > 0.0f || (f2 == 0.0f && SwipeBackLayout.this.hfr > SwipeBackLayout.this.hfn)) ? width + SwipeBackLayout.this.hfs.getIntrinsicWidth() + 10 : 0;
            Log.i("MicroMsg.SwipeBackLayout", "ashutest::onViewReleased, xvel:%f yvel:%f, releaseLeft:%d, releaseTop:%d, translucent %B", Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(this.hfF), Integer.valueOf(this.hfG), Boolean.valueOf(SwipeBackLayout.this.hfv));
            SwipeBackLayout.this.hfx = true;
            if (SwipeBackLayout.this.mSwipeBackListener != null) {
                b bVar = SwipeBackLayout.this.mSwipeBackListener;
                if (this.hfF != 0) {
                    z = true;
                } else {
                    z = false;
                }
                int bS = bVar.bS(z);
                Log.i("MicroMsg.SwipeBackLayout", "intercepted by mSwipeBackListener.onViewReleased, result:%s", Integer.valueOf(bS));
                if (bS == 2) {
                    this.hfF = 0;
                } else if (bS == 3) {
                    AppMethodBeat.o(143482);
                    return;
                }
            }
            if (SwipeBackLayout.this.hfv) {
                com.tencent.mm.ui.mogic.a aVar = SwipeBackLayout.this.QFb;
                int i2 = this.hfF;
                int i3 = this.hfG;
                if (!aVar.WM) {
                    IllegalStateException illegalStateException = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
                    AppMethodBeat.o(143482);
                    throw illegalStateException;
                }
                aVar.b(i2, i3, (int) aVar.mVelocityTracker.getXVelocity(aVar.mActivePointerId), (int) aVar.mVelocityTracker.getYVelocity(aVar.mActivePointerId), 0);
                SwipeBackLayout.this.invalidate();
                AppMethodBeat.o(143482);
                return;
            }
            SwipeBackLayout.this.hfy = true;
            AppMethodBeat.o(143482);
        }

        @Override // com.tencent.mm.ui.mogic.a.AbstractC2121a
        public final int e(View view, int i2) {
            AppMethodBeat.i(143483);
            if (SwipeBackLayout.this.hfv) {
                int max = Math.max(this.hfE, i2);
                this.hfE = 0;
                int min = Math.min(view.getWidth(), Math.max(max, 0));
                AppMethodBeat.o(143483);
                return min;
            }
            this.hfE = Math.max(this.hfE, i2);
            AppMethodBeat.o(143483);
            return 0;
        }

        @Override // com.tencent.mm.ui.mogic.a.AbstractC2121a
        public final void L(int i2) {
            boolean z;
            AppMethodBeat.i(143484);
            Log.i("MicroMsg.SwipeBackLayout", "ashutest::onViewDragStateChanged state %d, requestedTranslucent %B fastRelease %B", Integer.valueOf(i2), Boolean.valueOf(SwipeBackLayout.this.hfu), Boolean.valueOf(SwipeBackLayout.this.hfy));
            if (1 == i2) {
                Log.i("MicroMsg.SwipeBackLayout", "ashutest:: on drag");
                if ((SwipeBackLayout.this.getContext() instanceof Activity) && SwipeBackLayout.this.hfA == null) {
                    SwipeBackLayout.this.hfA = ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().getBackground();
                    if (SwipeBackLayout.this.hfC) {
                        ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackgroundResource(R.color.ac_);
                    }
                }
                if (SwipeBackLayout.this.QFc != null) {
                    SwipeBackLayout.this.QFc.onDrag();
                }
                SwipeBackLayout.this.hfw = false;
                if (SwipeBackLayout.this.hfv) {
                    h.aq(0.0f);
                }
            }
            if (i2 == 0 && !SwipeBackLayout.this.hfy) {
                Log.i("MicroMsg.SwipeBackLayout", "ashutest:: on cancel");
                if (SwipeBackLayout.this.QFc != null) {
                    if ((SwipeBackLayout.this.getContext() instanceof Activity) && SwipeBackLayout.this.hfA != null) {
                        if (SwipeBackLayout.this.hfC) {
                            ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.this.hfA);
                        }
                        SwipeBackLayout.this.hfA = null;
                    }
                    SwipeBackLayout.this.QFc.onCancel();
                }
                h.aq(1.0f);
            }
            if (1 == i2 && SwipeBackLayout.this.hft && (SwipeBackLayout.this.getContext() instanceof Activity) && !SwipeBackLayout.this.hfv && !SwipeBackLayout.this.hfu) {
                Log.i("MicroMsg.SwipeBackLayout", "ashutest:: match dragging");
                SwipeBackLayout.this.hfu = true;
                com.tencent.mm.ui.base.b.a((Activity) SwipeBackLayout.this.getContext(), this);
            }
            if (2 == i2) {
                Log.i("MicroMsg.SwipeBackLayout", "ashutest:: notify settle, mReleasedLeft %d", Integer.valueOf(this.hfF));
                if (this.hfF > 0) {
                    z = true;
                } else {
                    z = false;
                }
                h.h(z, this.hfF);
            }
            AppMethodBeat.o(143484);
        }

        @Override // com.tencent.mm.ui.base.b.AbstractC2081b
        public final void ei(final boolean z) {
            AppMethodBeat.i(143485);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.widget.SwipeBackLayout.c.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(143479);
                    Log.i("MicroMsg.SwipeBackLayout", "on Complete, result %B, releaseLeft %d", Boolean.valueOf(z), Integer.valueOf(c.this.hfF));
                    SwipeBackLayout.this.hfu = z;
                    if (!z) {
                        SwipeBackLayout.this.hfx = false;
                    } else if (c.this.hfF > 0) {
                        h.aq(0.0f);
                    } else {
                        h.aq(1.0f);
                    }
                    SwipeBackLayout.this.CV(z);
                    if (z && SwipeBackLayout.this.hfy) {
                        if (c.this.hfF == 0) {
                            j.a(SwipeBackLayout.this.mContentView, 200, 0.0f, new j.a() {
                                /* class com.tencent.mm.ui.widget.SwipeBackLayout.c.AnonymousClass2.AnonymousClass1 */

                                @Override // com.tencent.mm.ui.tools.j.a
                                public final void onAnimationEnd() {
                                    AppMethodBeat.i(143474);
                                    SwipeBackLayout.this.hfx = false;
                                    AppMethodBeat.o(143474);
                                }

                                @Override // com.tencent.mm.ui.tools.j.a
                                public final void awJ() {
                                    AppMethodBeat.i(143475);
                                    onAnimationEnd();
                                    AppMethodBeat.o(143475);
                                }
                            });
                        } else {
                            j.a(SwipeBackLayout.this.mContentView, 200, (float) c.this.hfF, new j.a() {
                                /* class com.tencent.mm.ui.widget.SwipeBackLayout.c.AnonymousClass2.AnonymousClass2 */

                                @Override // com.tencent.mm.ui.tools.j.a
                                public final void onAnimationEnd() {
                                    AppMethodBeat.i(143477);
                                    SwipeBackLayout.this.hfw = true;
                                    MMHandlerThread.postToMainThread(new Runnable() {
                                        /* class com.tencent.mm.ui.widget.SwipeBackLayout.c.AnonymousClass2.AnonymousClass2.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(143476);
                                            if (SwipeBackLayout.this.QFc != null) {
                                                if ((SwipeBackLayout.this.getContext() instanceof Activity) && SwipeBackLayout.this.hfA != null) {
                                                    if (SwipeBackLayout.this.hfC) {
                                                        ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.this.hfA);
                                                    }
                                                    SwipeBackLayout.this.hfA = null;
                                                }
                                                SwipeBackLayout.this.QFc.onSwipeBack();
                                                Log.d("MicroMsg.SwipeBackLayout", "ashutest:: on onSwipeBack");
                                            }
                                            h.aq(1.0f);
                                            SwipeBackLayout.this.hfx = false;
                                            AppMethodBeat.o(143476);
                                        }
                                    });
                                    AppMethodBeat.o(143477);
                                }

                                @Override // com.tencent.mm.ui.tools.j.a
                                public final void awJ() {
                                    AppMethodBeat.i(143478);
                                    onAnimationEnd();
                                    AppMethodBeat.o(143478);
                                }
                            });
                            h.h(true, c.this.hfF);
                        }
                    }
                    SwipeBackLayout.this.hfy = false;
                    AppMethodBeat.o(143479);
                }
            });
            AppMethodBeat.o(143485);
        }
    }

    public void setSwipeGestureDelegate(a aVar) {
        this.QFc = aVar;
    }
}
