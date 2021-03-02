package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.u;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

public final class t {
    private static final Interpolator sInterpolator = new Interpolator() {
        /* class android.support.v4.widget.t.AnonymousClass1 */

        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private OverScroller UD;
    float[] WA;
    float[] WB;
    private int[] WC;
    private int[] WD;
    private int[] WE;
    private int WF;
    private float WG;
    float WH;
    int WI;
    int WJ;
    private final a WK;
    View WL;
    private boolean WM;
    private final ViewGroup WN;
    private final Runnable WO = new Runnable() {
        /* class android.support.v4.widget.t.AnonymousClass2 */

        public final void run() {
            t.this.bf(0);
        }
    };
    int Wx;
    float[] Wy;
    float[] Wz;
    private int mActivePointerId = -1;
    public int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public static abstract class a {
        public abstract boolean c(View view, int i2);

        public void L(int i2) {
        }

        public void b(View view, int i2, int i3) {
        }

        public void l(View view, int i2) {
        }

        public void a(View view, float f2, float f3) {
        }

        public void fZ() {
        }

        public void D(int i2, int i3) {
        }

        public int y(View view) {
            return 0;
        }

        public int cg() {
            return 0;
        }

        public int e(View view, int i2) {
            return 0;
        }

        public int d(View view, int i2) {
            return 0;
        }
    }

    public static t a(ViewGroup viewGroup, a aVar) {
        return new t(viewGroup.getContext(), viewGroup, aVar);
    }

    public static t a(ViewGroup viewGroup, float f2, a aVar) {
        t a2 = a(viewGroup, aVar);
        a2.mTouchSlop = (int) (((float) a2.mTouchSlop) * (1.0f / f2));
        return a2;
    }

    private t(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.WN = viewGroup;
            this.WK = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.WI = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.WG = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.WH = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.UD = new OverScroller(context, sInterpolator);
        }
    }

    public final void y(View view, int i2) {
        if (view.getParent() != this.WN) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.WN + ")");
        }
        this.WL = view;
        this.mActivePointerId = i2;
        this.WK.l(view, i2);
        bf(1);
    }

    public final void cancel() {
        this.mActivePointerId = -1;
        gp();
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public final void abort() {
        cancel();
        if (this.Wx == 2) {
            this.UD.getCurrX();
            this.UD.getCurrY();
            this.UD.abortAnimation();
            this.WK.b(this.WL, this.UD.getCurrX(), this.UD.getCurrY());
        }
        bf(0);
    }

    public final boolean h(View view, int i2, int i3) {
        this.WL = view;
        this.mActivePointerId = -1;
        boolean h2 = h(i2, i3, 0, 0);
        if (!h2 && this.Wx == 0 && this.WL != null) {
            this.WL = null;
        }
        return h2;
    }

    public final boolean H(int i2, int i3) {
        if (this.WM) {
            return h(i2, i3, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean h(int i2, int i3, int i4, int i5) {
        int left = this.WL.getLeft();
        int top = this.WL.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.UD.abortAnimation();
            bf(0);
            return false;
        }
        this.UD.startScroll(left, top, i6, i7, e(this.WL, i6, i7, i4, i5));
        bf(2);
        return true;
    }

    private int e(View view, int i2, int i3, int i4, int i5) {
        int i6 = i(i4, (int) this.WH, (int) this.WG);
        int i7 = i(i5, (int) this.WH, (int) this.WG);
        int abs = Math.abs(i2);
        int abs2 = Math.abs(i3);
        int abs3 = Math.abs(i6);
        int abs4 = Math.abs(i7);
        int i8 = abs3 + abs4;
        int i9 = abs + abs2;
        return (int) (((i7 != 0 ? ((float) abs4) / ((float) i8) : ((float) abs2) / ((float) i9)) * ((float) h(i3, i7, this.WK.cg()))) + ((i6 != 0 ? ((float) abs3) / ((float) i8) : ((float) abs) / ((float) i9)) * ((float) h(i2, i6, this.WK.y(view)))));
    }

    private int h(int i2, int i3, int i4) {
        int abs;
        if (i2 == 0) {
            return 0;
        }
        int width = this.WN.getWidth();
        int i5 = width / 2;
        float distanceInfluenceForSnapDuration = (distanceInfluenceForSnapDuration(Math.min(1.0f, ((float) Math.abs(i2)) / ((float) width))) * ((float) i5)) + ((float) i5);
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(distanceInfluenceForSnapDuration / ((float) abs2)) * 1000.0f) * 4;
        } else {
            abs = (int) (((((float) Math.abs(i2)) / ((float) i4)) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    private static int i(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        if (abs <= i4) {
            return i2;
        }
        if (i2 <= 0) {
            return -i4;
        }
        return i4;
    }

    private static float f(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        if (abs <= f4) {
            return f2;
        }
        if (f2 <= 0.0f) {
            return -f4;
        }
        return f4;
    }

    private static float distanceInfluenceForSnapDuration(float f2) {
        return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
    }

    public final boolean go() {
        if (this.Wx == 2) {
            boolean computeScrollOffset = this.UD.computeScrollOffset();
            int currX = this.UD.getCurrX();
            int currY = this.UD.getCurrY();
            int left = currX - this.WL.getLeft();
            int top = currY - this.WL.getTop();
            if (left != 0) {
                u.u(this.WL, left);
            }
            if (top != 0) {
                u.s(this.WL, top);
            }
            if (!(left == 0 && top == 0)) {
                this.WK.b(this.WL, currX, currY);
            }
            if (computeScrollOffset && currX == this.UD.getFinalX() && currY == this.UD.getFinalY()) {
                this.UD.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.WN.post(this.WO);
            }
        }
        if (this.Wx == 2) {
            return true;
        }
        return false;
    }

    private void l(float f2, float f3) {
        this.WM = true;
        this.WK.a(this.WL, f2, f3);
        this.WM = false;
        if (this.Wx == 1) {
            bf(0);
        }
    }

    private void gp() {
        if (this.Wy != null) {
            Arrays.fill(this.Wy, 0.0f);
            Arrays.fill(this.Wz, 0.0f);
            Arrays.fill(this.WA, 0.0f);
            Arrays.fill(this.WB, 0.0f);
            Arrays.fill(this.WC, 0);
            Arrays.fill(this.WD, 0);
            Arrays.fill(this.WE, 0);
            this.WF = 0;
        }
    }

    private void bd(int i2) {
        if (this.Wy != null && be(i2)) {
            this.Wy[i2] = 0.0f;
            this.Wz[i2] = 0.0f;
            this.WA[i2] = 0.0f;
            this.WB[i2] = 0.0f;
            this.WC[i2] = 0;
            this.WD[i2] = 0;
            this.WE[i2] = 0;
            this.WF &= (1 << i2) ^ -1;
        }
    }

    private void a(float f2, float f3, int i2) {
        int i3 = 0;
        if (this.Wy == null || this.Wy.length <= i2) {
            float[] fArr = new float[(i2 + 1)];
            float[] fArr2 = new float[(i2 + 1)];
            float[] fArr3 = new float[(i2 + 1)];
            float[] fArr4 = new float[(i2 + 1)];
            int[] iArr = new int[(i2 + 1)];
            int[] iArr2 = new int[(i2 + 1)];
            int[] iArr3 = new int[(i2 + 1)];
            if (this.Wy != null) {
                System.arraycopy(this.Wy, 0, fArr, 0, this.Wy.length);
                System.arraycopy(this.Wz, 0, fArr2, 0, this.Wz.length);
                System.arraycopy(this.WA, 0, fArr3, 0, this.WA.length);
                System.arraycopy(this.WB, 0, fArr4, 0, this.WB.length);
                System.arraycopy(this.WC, 0, iArr, 0, this.WC.length);
                System.arraycopy(this.WD, 0, iArr2, 0, this.WD.length);
                System.arraycopy(this.WE, 0, iArr3, 0, this.WE.length);
            }
            this.Wy = fArr;
            this.Wz = fArr2;
            this.WA = fArr3;
            this.WB = fArr4;
            this.WC = iArr;
            this.WD = iArr2;
            this.WE = iArr3;
        }
        float[] fArr5 = this.Wy;
        this.WA[i2] = f2;
        fArr5[i2] = f2;
        float[] fArr6 = this.Wz;
        this.WB[i2] = f3;
        fArr6[i2] = f3;
        int[] iArr4 = this.WC;
        int i4 = (int) f2;
        int i5 = (int) f3;
        if (i4 < this.WN.getLeft() + this.WI) {
            i3 = 1;
        }
        if (i5 < this.WN.getTop() + this.WI) {
            i3 |= 4;
        }
        if (i4 > this.WN.getRight() - this.WI) {
            i3 |= 2;
        }
        if (i5 > this.WN.getBottom() - this.WI) {
            i3 |= 8;
        }
        iArr4[i2] = i3;
        this.WF |= 1 << i2;
    }

    private void i(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (bg(pointerId)) {
                float x = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                this.WA[pointerId] = x;
                this.WB[pointerId] = y;
            }
        }
    }

    public final boolean be(int i2) {
        return (this.WF & (1 << i2)) != 0;
    }

    /* access modifiers changed from: package-private */
    public final void bf(int i2) {
        this.WN.removeCallbacks(this.WO);
        if (this.Wx != i2) {
            this.Wx = i2;
            this.WK.L(i2);
            if (this.Wx == 0) {
                this.WL = null;
            }
        }
    }

    private boolean z(View view, int i2) {
        if (view == this.WL && this.mActivePointerId == i2) {
            return true;
        }
        if (view == null || !this.WK.c(view, i2)) {
            return false;
        }
        this.mActivePointerId = i2;
        y(view, i2);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f3, code lost:
        if (r8 != r7) goto L_0x00fb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean j(android.view.MotionEvent r14) {
        /*
        // Method dump skipped, instructions count: 314
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.t.j(android.view.MotionEvent):boolean");
    }

    public final void k(MotionEvent motionEvent) {
        int i2;
        int i3 = 0;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (actionMasked) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int pointerId = motionEvent.getPointerId(0);
                View J = J((int) x, (int) y);
                a(x, y, pointerId);
                z(J, pointerId);
                if ((this.WC[pointerId] & this.WJ) != 0) {
                    this.WK.fZ();
                    return;
                }
                return;
            case 1:
                if (this.Wx == 1) {
                    gq();
                }
                cancel();
                return;
            case 2:
                if (this.Wx != 1) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (i3 < pointerCount) {
                        int pointerId2 = motionEvent.getPointerId(i3);
                        if (bg(pointerId2)) {
                            float x2 = motionEvent.getX(i3);
                            float y2 = motionEvent.getY(i3);
                            float f2 = x2 - this.Wy[pointerId2];
                            float f3 = y2 - this.Wz[pointerId2];
                            b(f2, f3, pointerId2);
                            if (this.Wx != 1) {
                                View J2 = J((int) x2, (int) y2);
                                if (c(J2, f2, f3) && z(J2, pointerId2)) {
                                }
                            }
                            i(motionEvent);
                            return;
                        }
                        i3++;
                    }
                    i(motionEvent);
                    return;
                } else if (bg(this.mActivePointerId)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    float x3 = motionEvent.getX(findPointerIndex);
                    float y3 = motionEvent.getY(findPointerIndex);
                    int i4 = (int) (x3 - this.WA[this.mActivePointerId]);
                    int i5 = (int) (y3 - this.WB[this.mActivePointerId]);
                    i(this.WL.getLeft() + i4, this.WL.getTop() + i5, i4, i5);
                    i(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.Wx == 1) {
                    l(0.0f, 0.0f);
                }
                cancel();
                return;
            case 4:
            default:
                return;
            case 5:
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                float x4 = motionEvent.getX(actionIndex);
                float y4 = motionEvent.getY(actionIndex);
                a(x4, y4, pointerId3);
                if (this.Wx == 0) {
                    z(J((int) x4, (int) y4), pointerId3);
                    if ((this.WC[pointerId3] & this.WJ) != 0) {
                        this.WK.fZ();
                        return;
                    }
                    return;
                } else if (I((int) x4, (int) y4)) {
                    z(this.WL, pointerId3);
                    return;
                } else {
                    return;
                }
            case 6:
                int pointerId4 = motionEvent.getPointerId(actionIndex);
                if (this.Wx == 1 && pointerId4 == this.mActivePointerId) {
                    int pointerCount2 = motionEvent.getPointerCount();
                    while (true) {
                        if (i3 >= pointerCount2) {
                            i2 = -1;
                        } else {
                            int pointerId5 = motionEvent.getPointerId(i3);
                            if (pointerId5 != this.mActivePointerId) {
                                if (J((int) motionEvent.getX(i3), (int) motionEvent.getY(i3)) == this.WL && z(this.WL, pointerId5)) {
                                    i2 = this.mActivePointerId;
                                }
                            }
                            i3++;
                        }
                    }
                    if (i2 == -1) {
                        gq();
                    }
                }
                bd(pointerId4);
                return;
        }
    }

    private void b(float f2, float f3, int i2) {
        int i3 = 1;
        if (!a(f2, f3, i2, 1)) {
            i3 = 0;
        }
        if (a(f3, f2, i2, 4)) {
            i3 |= 4;
        }
        if (a(f2, f3, i2, 2)) {
            i3 |= 2;
        }
        if (a(f3, f2, i2, 8)) {
            i3 |= 8;
        }
        if (i3 != 0) {
            int[] iArr = this.WD;
            iArr[i2] = iArr[i2] | i3;
            this.WK.D(i3, i2);
        }
    }

    private boolean a(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.WC[i2] & i3) != i3 || (this.WJ & i3) == 0 || (this.WE[i2] & i3) == i3 || (this.WD[i2] & i3) == i3) {
            return false;
        }
        if ((abs > ((float) this.mTouchSlop) || abs2 > ((float) this.mTouchSlop)) && (this.WD[i2] & i3) == 0 && abs > ((float) this.mTouchSlop)) {
            return true;
        }
        return false;
    }

    private boolean c(View view, float f2, float f3) {
        boolean z;
        boolean z2;
        if (view == null) {
            return false;
        }
        if (this.WK.y(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.WK.cg() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        return (!z || !z2) ? z ? Math.abs(f2) > ((float) this.mTouchSlop) : z2 && Math.abs(f3) > ((float) this.mTouchSlop) : (f2 * f2) + (f3 * f3) > ((float) (this.mTouchSlop * this.mTouchSlop));
    }

    private void gq() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.WG);
        l(f(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.WH, this.WG), f(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.WH, this.WG));
    }

    private void i(int i2, int i3, int i4, int i5) {
        int left = this.WL.getLeft();
        int top = this.WL.getTop();
        if (i4 != 0) {
            i2 = this.WK.e(this.WL, i2);
            u.u(this.WL, i2 - left);
        }
        if (i5 != 0) {
            i3 = this.WK.d(this.WL, i3);
            u.s(this.WL, i3 - top);
        }
        if (i4 != 0 || i5 != 0) {
            this.WK.b(this.WL, i2, i3);
        }
    }

    private boolean I(int i2, int i3) {
        return i(this.WL, i2, i3);
    }

    public static boolean i(View view, int i2, int i3) {
        if (view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public final View J(int i2, int i3) {
        for (int childCount = this.WN.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.WN.getChildAt(childCount);
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private boolean bg(int i2) {
        if (be(i2)) {
            return true;
        }
        new StringBuilder("Ignoring pointerId=").append(i2).append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }
}
