package com.tencent.mm.ext.ui;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ext.ui.a;
import com.tencent.mm.ext.ui.b;
import com.tencent.mm.ext.ui.f;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SwipeBackLayout extends FrameLayout {
    private float TH;
    private Rect Ui;
    private Drawable hfA;
    private boolean hfB;
    private boolean hfC;
    private a hfD;
    private float hfn;
    private int hfo;
    private int hfp;
    private f hfq;
    private float hfr;
    private Drawable hfs;
    private boolean hft;
    private boolean hfu;
    boolean hfv;
    private boolean hfw;
    boolean hfx;
    private boolean hfy;
    private b hfz;
    private View mContentView;
    private boolean mEnable;
    private Handler mHandler;
    private boolean mInLayout;

    public interface a {
        void onCancel();

        void onDrag();

        void onSwipeBack();
    }

    public interface b {
        int awL();
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(197854);
        this.hfn = 0.3f;
        this.mEnable = true;
        this.Ui = new Rect();
        this.hft = true;
        this.hfu = false;
        this.hfv = false;
        this.hfw = false;
        this.hfx = false;
        this.hfy = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.hfC = true;
        this.hfD = null;
        this.hfs = getResources().getDrawable(R.drawable.bt9);
        setFocusable(true);
        setDescendantFocusability(TPMediaCodecProfileLevel.HEVCMainTierLevel52);
        init();
        AppMethodBeat.o(197854);
    }

    public final void init() {
        AppMethodBeat.i(197855);
        this.hfq = f.a(this, new c(this, (byte) 0), AnimationUtils.loadInterpolator(getContext(), R.anim.co));
        this.hfq.WJ = 1;
        float f2 = getResources().getDisplayMetrics().density;
        this.hfq.WH = 100.0f * f2;
        this.hfq.WG = f2 * 300.0f;
        this.hfo = 0;
        this.hfp = 0;
        AppMethodBeat.o(197855);
    }

    public void setNeedRequestActivityTranslucent(boolean z) {
        this.hft = z;
        if (this.hft) {
            this.hfu = false;
        }
    }

    public void setSwipeBackListener(b bVar) {
        this.hfz = bVar;
    }

    public void setContentView(View view) {
        this.mContentView = view;
    }

    public View getTargetContentView() {
        return this.mContentView;
    }

    public void onFinishInflate() {
        AppMethodBeat.i(197856);
        super.onFinishInflate();
        this.mContentView = this;
        AppMethodBeat.o(197856);
    }

    public void setEnableGesture(boolean z) {
        this.mEnable = z;
    }

    public void setOnceDisEnableGesture(boolean z) {
        AppMethodBeat.i(197857);
        com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "[setOnceDisEnableGesture] enable:%s", Boolean.valueOf(z));
        this.hfB = z;
        AppMethodBeat.o(197857);
    }

    public final boolean awK() {
        AppMethodBeat.i(197858);
        if (!this.hfx) {
            AppMethodBeat.o(197858);
            return false;
        } else if (Float.compare((float) this.mContentView.getLeft(), 0.01f) <= 0) {
            this.hfx = false;
            AppMethodBeat.o(197858);
            return false;
        } else {
            AppMethodBeat.o(197858);
            return true;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View J;
        View J2;
        int i2;
        AppMethodBeat.i(197859);
        if (!this.mEnable) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(197859);
            return dispatchTouchEvent;
        }
        if (motionEvent.getAction() == 0) {
            this.hfB = false;
        }
        if (this.hfB) {
            boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(197859);
            return dispatchTouchEvent2;
        } else if (awK()) {
            boolean dispatchTouchEvent3 = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(197859);
            return dispatchTouchEvent3;
        } else {
            try {
                if (this.hfq.Wx == 1) {
                    f fVar = this.hfq;
                    int actionMasked = motionEvent.getActionMasked();
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionMasked == 0) {
                        fVar.cancel();
                    }
                    if (fVar.mVelocityTracker == null) {
                        fVar.mVelocityTracker = VelocityTracker.obtain();
                    }
                    fVar.mVelocityTracker.addMovement(motionEvent);
                    switch (actionMasked) {
                        case 0:
                            float x = motionEvent.getX();
                            float y = motionEvent.getY();
                            int pointerId = motionEvent.getPointerId(0);
                            View J3 = fVar.J((int) x, (int) y);
                            fVar.a(x, y, pointerId);
                            fVar.z(J3, pointerId);
                            if ((fVar.WJ & fVar.WC[pointerId]) != 0) {
                            }
                            break;
                        case 1:
                            if (fVar.Wx == 1) {
                                fVar.gq();
                            }
                            fVar.cancel();
                            break;
                        case 2:
                            if (fVar.Wx == 1) {
                                int findPointerIndex = motionEvent.findPointerIndex(fVar.mActivePointerId);
                                float x2 = motionEvent.getX(findPointerIndex);
                                float y2 = motionEvent.getY(findPointerIndex);
                                int i3 = (int) (x2 - fVar.WA[fVar.mActivePointerId]);
                                int i4 = (int) (y2 - fVar.WB[fVar.mActivePointerId]);
                                int left = fVar.WL.getLeft() + i3;
                                int top = fVar.WL.getTop() + i4;
                                int left2 = fVar.WL.getLeft();
                                int top2 = fVar.WL.getTop();
                                if (i3 != 0) {
                                    left = fVar.hgh.e(fVar.WL, left);
                                    fVar.WL.offsetLeftAndRight(left - left2);
                                }
                                if (i4 != 0) {
                                    fVar.WL.offsetTopAndBottom(0 - top2);
                                    top = 0;
                                }
                                if (!(i3 == 0 && i4 == 0)) {
                                    fVar.hgh.cL(left, top);
                                }
                                fVar.i(motionEvent);
                                break;
                            } else {
                                int pointerCount = motionEvent.getPointerCount();
                                for (int i5 = 0; i5 < pointerCount; i5++) {
                                    int pointerId2 = motionEvent.getPointerId(i5);
                                    float x3 = motionEvent.getX(i5);
                                    float y3 = motionEvent.getY(i5);
                                    float f2 = x3 - fVar.Wy[pointerId2];
                                    fVar.b(f2, y3 - fVar.Wz[pointerId2], pointerId2);
                                    if (fVar.Wx != 1) {
                                        View J4 = fVar.J((int) x3, (int) y3);
                                        if (!fVar.r(J4, f2) || !fVar.z(J4, pointerId2)) {
                                        }
                                    }
                                    fVar.i(motionEvent);
                                    break;
                                }
                                fVar.i(motionEvent);
                            }
                            break;
                        case 3:
                            if (fVar.Wx == 1) {
                                fVar.l(0.0f, 0.0f);
                            }
                            fVar.cancel();
                            break;
                        case 5:
                            int pointerId3 = motionEvent.getPointerId(actionIndex);
                            float x4 = motionEvent.getX(actionIndex);
                            float y4 = motionEvent.getY(actionIndex);
                            fVar.a(x4, y4, pointerId3);
                            if (fVar.Wx != 0) {
                                if (f.i(fVar.WL, (int) x4, (int) y4)) {
                                    fVar.z(fVar.WL, pointerId3);
                                    break;
                                }
                            } else {
                                fVar.z(fVar.J((int) x4, (int) y4), pointerId3);
                                break;
                            }
                            break;
                        case 6:
                            int pointerId4 = motionEvent.getPointerId(actionIndex);
                            if (fVar.Wx == 1 && pointerId4 == fVar.mActivePointerId) {
                                int pointerCount2 = motionEvent.getPointerCount();
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= pointerCount2) {
                                        i2 = -1;
                                    } else {
                                        int pointerId5 = motionEvent.getPointerId(i6);
                                        if (pointerId5 != fVar.mActivePointerId) {
                                            if (fVar.J((int) motionEvent.getX(i6), (int) motionEvent.getY(i6)) == fVar.WL && fVar.z(fVar.WL, pointerId5)) {
                                                i2 = fVar.mActivePointerId;
                                            }
                                        }
                                        i6++;
                                    }
                                }
                                if (i2 == -1) {
                                    fVar.gq();
                                }
                            }
                            fVar.bd(pointerId4);
                            break;
                    }
                    AppMethodBeat.o(197859);
                    return true;
                }
                f fVar2 = this.hfq;
                int actionMasked2 = motionEvent.getActionMasked();
                int actionIndex2 = motionEvent.getActionIndex();
                if (actionMasked2 == 0) {
                    fVar2.cancel();
                }
                if (fVar2.mVelocityTracker == null) {
                    fVar2.mVelocityTracker = VelocityTracker.obtain();
                }
                fVar2.mVelocityTracker.addMovement(motionEvent);
                switch (actionMasked2) {
                    case 0:
                        float x5 = motionEvent.getX();
                        float y5 = motionEvent.getY();
                        int pointerId6 = motionEvent.getPointerId(0);
                        fVar2.a(x5, y5, pointerId6);
                        View J5 = fVar2.J((int) x5, (int) y5);
                        if (J5 == fVar2.WL && fVar2.Wx == 2) {
                            fVar2.z(J5, pointerId6);
                        }
                        if ((fVar2.WC[pointerId6] & fVar2.WJ) != 0) {
                        }
                        break;
                    case 1:
                    case 3:
                        fVar2.cancel();
                        break;
                    case 2:
                        int pointerCount3 = motionEvent.getPointerCount();
                        for (int i7 = 0; i7 < pointerCount3; i7++) {
                            int pointerId7 = motionEvent.getPointerId(i7);
                            float x6 = motionEvent.getX(i7);
                            float y6 = motionEvent.getY(i7);
                            float f3 = x6 - fVar2.Wy[pointerId7];
                            fVar2.b(f3, y6 - fVar2.Wz[pointerId7], pointerId7);
                            if (fVar2.Wx != 1 && ((J = fVar2.J((int) x6, (int) y6)) == null || !fVar2.r(J, f3) || !fVar2.z(J, pointerId7))) {
                            }
                            fVar2.i(motionEvent);
                            break;
                        }
                        fVar2.i(motionEvent);
                    case 5:
                        int pointerId8 = motionEvent.getPointerId(actionIndex2);
                        float x7 = motionEvent.getX(actionIndex2);
                        float y7 = motionEvent.getY(actionIndex2);
                        fVar2.a(x7, y7, pointerId8);
                        if (fVar2.Wx != 0 && fVar2.Wx == 2 && (J2 = fVar2.J((int) x7, (int) y7)) == fVar2.WL) {
                            fVar2.z(J2, pointerId8);
                            break;
                        }
                    case 6:
                        fVar2.bd(motionEvent.getPointerId(actionIndex2));
                        break;
                }
                if (fVar2.Wx == 1) {
                    com.tencent.liteapp.b.b.i("changelcai", "shouldInterceptTouchEvent %s", motionEvent);
                    motionEvent.setAction(3);
                    super.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.o(197859);
                    return true;
                }
                super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(197859);
                return true;
            } catch (NullPointerException e2) {
                com.tencent.liteapp.b.b.e("MicroMsg.SwipeBackLayout", "got an NullPointerException: %s", e2.toString());
                AppMethodBeat.o(197859);
                return false;
            } catch (IllegalArgumentException e3) {
                com.tencent.liteapp.b.b.e("MicroMsg.SwipeBackLayout", "got an IllegalArgumentException: %s", e3.toString());
                AppMethodBeat.o(197859);
                return false;
            } catch (ArrayIndexOutOfBoundsException e4) {
                com.tencent.liteapp.b.b.e("MicroMsg.SwipeBackLayout", "got an ArrayIndexOutOfBoundsException: %s", e4.toString());
                AppMethodBeat.o(197859);
                return false;
            } catch (IllegalStateException e5) {
                com.tencent.liteapp.b.b.e("MicroMsg.SwipeBackLayout", "got an IllegalStateException: %s", e5.toString());
                AppMethodBeat.o(197859);
                return false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(197860);
        this.mInLayout = true;
        if (this.mContentView != null) {
            this.mContentView.layout(this.hfo, this.hfp, this.hfo + this.mContentView.getMeasuredWidth(), this.hfp + this.mContentView.getMeasuredHeight());
        }
        this.mInLayout = false;
        AppMethodBeat.o(197860);
    }

    public void requestLayout() {
        AppMethodBeat.i(197861);
        if (!this.mInLayout) {
            super.requestLayout();
        }
        AppMethodBeat.o(197861);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        AppMethodBeat.i(197862);
        boolean z = view == this.mContentView;
        boolean drawChild = super.drawChild(canvas, view, j2);
        if (Float.compare(this.TH, 0.0f) > 0 && z && this.hfq.Wx != 0) {
            Rect rect = this.Ui;
            view.getHitRect(rect);
            this.hfs.setBounds(rect.left - this.hfs.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
            this.hfs.setAlpha((int) (this.TH * 255.0f));
            this.hfs.draw(canvas);
            com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "shadow left:%d top:%d right:%d bootom:%d", Integer.valueOf(this.hfs.getBounds().left), Integer.valueOf(this.hfs.getBounds().top), Integer.valueOf(this.hfs.getBounds().right), Integer.valueOf(this.hfs.getBounds().bottom));
        }
        AppMethodBeat.o(197862);
        return drawChild;
    }

    public void computeScroll() {
        boolean z;
        AppMethodBeat.i(197863);
        this.TH = Math.max(0.0f, 1.0f - this.hfr);
        f fVar = this.hfq;
        if (fVar.Wx == 2) {
            boolean computeScrollOffset = fVar.hgg.UD.computeScrollOffset();
            int currX = fVar.hgg.UD.getCurrX();
            int currY = fVar.hgg.UD.getCurrY();
            int left = currX - fVar.WL.getLeft();
            int top = currY - fVar.WL.getTop();
            if (left != 0) {
                fVar.WL.offsetLeftAndRight(left);
            }
            if (top != 0) {
                fVar.WL.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                fVar.hgh.cL(currX, currY);
            }
            if (computeScrollOffset && currX == fVar.hgg.UD.getFinalX() && currY == fVar.hgg.UD.getFinalY()) {
                fVar.hgg.UD.abortAnimation();
                computeScrollOffset = fVar.hgg.UD.isFinished();
            }
            if (!computeScrollOffset) {
                fVar.WN.post(fVar.WO);
            }
        }
        if (fVar.Wx == 2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            u.X(this);
        }
        AppMethodBeat.o(197863);
    }

    public void setNeedChangeWindowBackground(boolean z) {
        this.hfC = z;
    }

    /* access modifiers changed from: package-private */
    public class c extends f.a implements a.AbstractC0343a {
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

        @Override // com.tencent.mm.ext.ui.f.a
        public final boolean pv(int i2) {
            boolean z;
            AppMethodBeat.i(197848);
            f fVar = SwipeBackLayout.this.hfq;
            if ((fVar.WF & (1 << i2)) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z || (fVar.WC[i2] & 1) == 0) {
                AppMethodBeat.o(197848);
                return false;
            }
            AppMethodBeat.o(197848);
            return true;
        }

        @Override // com.tencent.mm.ext.ui.f.a
        public final int awM() {
            return 1;
        }

        @Override // com.tencent.mm.ext.ui.f.a
        public final void cL(int i2, int i3) {
            AppMethodBeat.i(197849);
            if (!SwipeBackLayout.this.hfv) {
                com.tencent.liteapp.b.b.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mHasTranslucent is false", new Object[0]);
                AppMethodBeat.o(197849);
                return;
            }
            SwipeBackLayout.this.hfr = Math.abs(((float) i2) / ((float) (SwipeBackLayout.this.mContentView.getWidth() + SwipeBackLayout.this.hfs.getIntrinsicWidth())));
            SwipeBackLayout.this.hfo = i2;
            SwipeBackLayout.this.hfp = i3;
            SwipeBackLayout.this.invalidate();
            if (SwipeBackLayout.this.hfz != null) {
                b unused = SwipeBackLayout.this.hfz;
                float unused2 = SwipeBackLayout.this.hfr;
            }
            if (Float.compare(SwipeBackLayout.this.hfr, 1.0f) >= 0 && !SwipeBackLayout.this.hfw) {
                SwipeBackLayout.this.hfw = true;
                SwipeBackLayout.this.mHandler.post(new Runnable() {
                    /* class com.tencent.mm.ext.ui.SwipeBackLayout.c.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(197841);
                        if (SwipeBackLayout.this.hfD != null) {
                            com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest:: on popOut", new Object[0]);
                            if ((SwipeBackLayout.this.getContext() instanceof Activity) && SwipeBackLayout.this.hfA != null) {
                                if (SwipeBackLayout.this.hfC) {
                                    ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.this.hfA);
                                }
                                SwipeBackLayout.this.hfA = null;
                            }
                            SwipeBackLayout.this.hfD.onSwipeBack();
                        }
                        SwipeBackLayout.this.hfx = false;
                        AppMethodBeat.o(197841);
                    }
                });
            } else if (Float.compare(SwipeBackLayout.this.hfr, 0.01f) <= 0) {
                SwipeBackLayout.this.hfx = false;
                com.tencent.liteapp.b.b.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mScrollPercent:%s mHasCallPopOut:%s", Float.valueOf(SwipeBackLayout.this.hfr), Boolean.valueOf(SwipeBackLayout.this.hfw));
            }
            if (SwipeBackLayout.this.hfq.Wx == 1) {
                d.aq(SwipeBackLayout.this.hfr);
            }
            AppMethodBeat.o(197849);
        }

        @Override // com.tencent.mm.ext.ui.f.a
        public final void a(View view, float f2, float f3) {
            long j2;
            float f4;
            AppMethodBeat.i(197850);
            int width = view.getWidth();
            this.hfF = 0;
            this.hfG = 0;
            this.hfF = (f2 > 0.0f || (f2 == 0.0f && SwipeBackLayout.this.hfr > SwipeBackLayout.this.hfn)) ? width + SwipeBackLayout.this.hfs.getIntrinsicWidth() + 10 : 0;
            com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest::onViewReleased, xvel:%f yvel:%f, releaseLeft:%d, releaseTop:%d, translucent %B", Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(this.hfF), Integer.valueOf(this.hfG), Boolean.valueOf(SwipeBackLayout.this.hfv));
            SwipeBackLayout.this.hfx = true;
            if (SwipeBackLayout.this.hfz != null) {
                int awL = SwipeBackLayout.this.hfz.awL();
                com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "intercepted by mSwipeBackListener.onViewReleased, result:%s", Integer.valueOf(awL));
                if (awL == 2) {
                    this.hfF = 0;
                } else if (awL == 3) {
                    AppMethodBeat.o(197850);
                    return;
                }
            }
            if (SwipeBackLayout.this.hfv) {
                f fVar = SwipeBackLayout.this.hfq;
                int i2 = this.hfF;
                int i3 = this.hfG;
                if (!fVar.WM) {
                    IllegalStateException illegalStateException = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
                    AppMethodBeat.o(197850);
                    throw illegalStateException;
                }
                int xVelocity = (int) fVar.mVelocityTracker.getXVelocity(fVar.mActivePointerId);
                int yVelocity = (int) fVar.mVelocityTracker.getYVelocity(fVar.mActivePointerId);
                int left = fVar.WL.getLeft();
                int top = fVar.WL.getTop();
                int i4 = i2 - left;
                int i5 = i3 - top;
                if (i4 == 0 && i5 == 0) {
                    fVar.hgg.UD.abortAnimation();
                    fVar.bf(0);
                } else {
                    if (0 == 0) {
                        int i6 = f.i(xVelocity, (int) fVar.WH, (int) fVar.WG);
                        int i7 = f.i(yVelocity, (int) fVar.WH, (int) fVar.WG);
                        int abs = Math.abs(i4);
                        int abs2 = Math.abs(i5);
                        int abs3 = Math.abs(i6);
                        int abs4 = Math.abs(i7);
                        int i8 = abs3 + abs4;
                        int i9 = abs + abs2;
                        float f5 = i6 != 0 ? ((float) abs3) / ((float) i8) : ((float) abs) / ((float) i9);
                        if (i7 != 0) {
                            f4 = ((float) abs4) / ((float) i8);
                        } else {
                            f4 = ((float) abs2) / ((float) i9);
                        }
                        j2 = (long) ((int) ((f4 * ((float) fVar.h(i5, i7, 0))) + (f5 * ((float) fVar.h(i4, i6, fVar.hgh.awM())))));
                    } else {
                        j2 = 0;
                    }
                    com.tencent.liteapp.b.b.d("WxViewDragHelper", "ashutest:: xvel %d, yvel %d, dx %d, dy %d duration %d", Integer.valueOf(xVelocity), Integer.valueOf(yVelocity), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j2));
                    fVar.hgg.startScroll(left, top, i4, i5, (int) j2);
                    fVar.bf(2);
                }
                SwipeBackLayout.this.invalidate();
                AppMethodBeat.o(197850);
                return;
            }
            SwipeBackLayout.this.hfy = true;
            AppMethodBeat.o(197850);
        }

        @Override // com.tencent.mm.ext.ui.f.a
        public final int e(View view, int i2) {
            AppMethodBeat.i(197851);
            if (SwipeBackLayout.this.hfv) {
                int max = Math.max(this.hfE, i2);
                this.hfE = 0;
                int min = Math.min(view.getWidth(), Math.max(max, 0));
                AppMethodBeat.o(197851);
                return min;
            }
            this.hfE = Math.max(this.hfE, i2);
            AppMethodBeat.o(197851);
            return 0;
        }

        @Override // com.tencent.mm.ext.ui.f.a
        public final void L(int i2) {
            Class<?> cls = null;
            AppMethodBeat.i(197852);
            com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest::onViewDragStateChanged state %d, requestedTranslucent %B fastRelease %B", Integer.valueOf(i2), Boolean.valueOf(SwipeBackLayout.this.hfu), Boolean.valueOf(SwipeBackLayout.this.hfy));
            if (1 == i2) {
                com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest:: on drag", new Object[0]);
                if ((SwipeBackLayout.this.getContext() instanceof Activity) && SwipeBackLayout.this.hfA == null) {
                    SwipeBackLayout.this.hfA = ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().getBackground();
                    if (SwipeBackLayout.this.hfC) {
                        ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackgroundResource(17170445);
                    }
                }
                if (SwipeBackLayout.this.hfD != null) {
                    SwipeBackLayout.this.hfD.onDrag();
                }
                SwipeBackLayout.this.hfw = false;
                if (SwipeBackLayout.this.hfv) {
                    d.aq(0.0f);
                }
            }
            if (i2 == 0 && !SwipeBackLayout.this.hfy) {
                com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest:: on cancel", new Object[0]);
                if (SwipeBackLayout.this.hfD != null) {
                    if ((SwipeBackLayout.this.getContext() instanceof Activity) && SwipeBackLayout.this.hfA != null) {
                        if (SwipeBackLayout.this.hfC) {
                            ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.this.hfA);
                        }
                        SwipeBackLayout.this.hfA = null;
                    }
                    SwipeBackLayout.this.hfD.onCancel();
                }
                d.aq(1.0f);
            }
            if (1 == i2 && SwipeBackLayout.this.hft && (SwipeBackLayout.this.getContext() instanceof Activity) && !SwipeBackLayout.this.hfv && !SwipeBackLayout.this.hfu) {
                com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest:: match dragging", new Object[0]);
                SwipeBackLayout.this.hfu = true;
                Activity activity = (Activity) SwipeBackLayout.this.getContext();
                if (com.tencent.mm.ext.a.b.a.oE(16)) {
                    com.tencent.liteapp.b.b.w("MicroMsg.ActivityUtil", "convertActivityToTranslucent::Android Version Error %d", Integer.valueOf(Build.VERSION.SDK_INT));
                } else {
                    try {
                        Class<?>[] declaredClasses = Activity.class.getDeclaredClasses();
                        int length = declaredClasses.length;
                        int i3 = 0;
                        while (i3 < length) {
                            Class<?> cls2 = declaredClasses[i3];
                            if (!cls2.getSimpleName().contains("TranslucentConversionListener")) {
                                cls2 = cls;
                            }
                            i3++;
                            cls = cls2;
                        }
                        a.b bVar = new a.b((byte) 0);
                        bVar.hfj = new WeakReference<>(this);
                        Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, bVar);
                        if (com.tencent.mm.ext.a.b.a.oE(21)) {
                            Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(activity, newProxyInstance);
                        } else {
                            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
                            declaredMethod2.setAccessible(true);
                            declaredMethod2.invoke(activity, newProxyInstance, null);
                        }
                    } catch (Throwable th) {
                        com.tencent.liteapp.b.b.e("MicroMsg.ActivityUtil", "call convertActivityToTranslucent Fail: %s", th.getMessage());
                    }
                }
            }
            if (2 == i2) {
                com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest:: notify settle, mReleasedLeft %d", Integer.valueOf(this.hfF));
                d.h(this.hfF > 0, this.hfF);
            }
            AppMethodBeat.o(197852);
        }

        @Override // com.tencent.mm.ext.ui.a.AbstractC0343a
        public final void ei(final boolean z) {
            AppMethodBeat.i(197853);
            SwipeBackLayout.this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.ext.ui.SwipeBackLayout.c.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(197847);
                    com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "on Complete, result %B, releaseLeft %d", Boolean.valueOf(z), Integer.valueOf(c.this.hfF));
                    SwipeBackLayout.this.hfu = z;
                    if (!z) {
                        SwipeBackLayout.this.hfx = false;
                    } else if (c.this.hfF > 0) {
                        d.aq(0.0f);
                    } else {
                        d.aq(1.0f);
                    }
                    SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
                    boolean z = z;
                    com.tencent.liteapp.b.b.i("MicroMsg.SwipeBackLayout", "ashutest::markTranslucent %B", Boolean.valueOf(z));
                    swipeBackLayout.hfv = z;
                    if (z && SwipeBackLayout.this.hfy) {
                        if (c.this.hfF == 0) {
                            b.a(SwipeBackLayout.this.mContentView, 200, 0.0f, new b.a() {
                                /* class com.tencent.mm.ext.ui.SwipeBackLayout.c.AnonymousClass2.AnonymousClass1 */

                                @Override // com.tencent.mm.ext.ui.b.a
                                public final void onAnimationEnd() {
                                    AppMethodBeat.i(197842);
                                    SwipeBackLayout.this.hfx = false;
                                    AppMethodBeat.o(197842);
                                }

                                @Override // com.tencent.mm.ext.ui.b.a
                                public final void awJ() {
                                    AppMethodBeat.i(197843);
                                    onAnimationEnd();
                                    AppMethodBeat.o(197843);
                                }
                            });
                        } else {
                            b.a(SwipeBackLayout.this.mContentView, 200, (float) c.this.hfF, new b.a() {
                                /* class com.tencent.mm.ext.ui.SwipeBackLayout.c.AnonymousClass2.AnonymousClass2 */

                                @Override // com.tencent.mm.ext.ui.b.a
                                public final void onAnimationEnd() {
                                    AppMethodBeat.i(197845);
                                    SwipeBackLayout.this.hfw = true;
                                    new Handler().post(new Runnable() {
                                        /* class com.tencent.mm.ext.ui.SwipeBackLayout.c.AnonymousClass2.AnonymousClass2.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(197844);
                                            if (SwipeBackLayout.this.hfD != null) {
                                                if ((SwipeBackLayout.this.getContext() instanceof Activity) && SwipeBackLayout.this.hfA != null) {
                                                    if (SwipeBackLayout.this.hfC) {
                                                        ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.this.hfA);
                                                    }
                                                    SwipeBackLayout.this.hfA = null;
                                                }
                                                SwipeBackLayout.this.hfD.onSwipeBack();
                                                com.tencent.liteapp.b.b.d("MicroMsg.SwipeBackLayout", "ashutest:: on onSwipeBack", new Object[0]);
                                            }
                                            d.aq(1.0f);
                                            SwipeBackLayout.this.hfx = false;
                                            AppMethodBeat.o(197844);
                                        }
                                    });
                                    AppMethodBeat.o(197845);
                                }

                                @Override // com.tencent.mm.ext.ui.b.a
                                public final void awJ() {
                                    AppMethodBeat.i(197846);
                                    onAnimationEnd();
                                    AppMethodBeat.o(197846);
                                }
                            });
                            d.h(true, c.this.hfF);
                        }
                    }
                    SwipeBackLayout.this.hfy = false;
                    AppMethodBeat.o(197847);
                }
            });
            AppMethodBeat.o(197853);
        }
    }

    public void setSwipeGestureDelegate(a aVar) {
        this.hfD = aVar;
    }
}
