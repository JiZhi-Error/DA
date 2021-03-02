package me.imid.swipebacklayout.lib;

import android.content.Context;
import android.support.v4.widget.p;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class b {
    private static final Interpolator sInterpolator = new Interpolator() {
        /* class me.imid.swipebacklayout.lib.b.AnonymousClass1 */

        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    int[] UaW;
    final a UaX;
    private float[] WA;
    private float[] WB;
    private int[] WD;
    private int[] WE;
    private int WF;
    float WG;
    float WH;
    int WI;
    int WJ;
    View WL;
    boolean WM;
    final ViewGroup WN;
    final Runnable WO = new Runnable() {
        /* class me.imid.swipebacklayout.lib.b.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(140896);
            b.this.bf(0);
            AppMethodBeat.o(140896);
        }
    };
    int Wx;
    float[] Wy;
    float[] Wz;
    p hgg;
    int mActivePointerId = -1;
    private int mTouchSlop;
    VelocityTracker mVelocityTracker;

    public static abstract class a {
        public abstract boolean pv(int i2);

        public void L(int i2) {
        }

        public void l(View view, int i2, int i3, int i4, int i5) {
        }

        public void a(View view, float f2, float f3) {
        }

        public int awM() {
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

    static {
        AppMethodBeat.i(140924);
        AppMethodBeat.o(140924);
    }

    public static b a(ViewGroup viewGroup, a aVar) {
        AppMethodBeat.i(140897);
        b bVar = new b(viewGroup.getContext(), viewGroup, aVar);
        AppMethodBeat.o(140897);
        return bVar;
    }

    private b(Context context, ViewGroup viewGroup, a aVar) {
        AppMethodBeat.i(140898);
        if (viewGroup == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Parent view may not be null");
            AppMethodBeat.o(140898);
            throw illegalArgumentException;
        } else if (aVar == null) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Callback may not be null");
            AppMethodBeat.o(140898);
            throw illegalArgumentException2;
        } else {
            this.WN = viewGroup;
            this.UaX = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.WI = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.WG = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.WH = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.hgg = p.a(context, sInterpolator);
            AppMethodBeat.o(140898);
        }
    }

    private void y(View view, int i2) {
        AppMethodBeat.i(140899);
        if (view.getParent() != this.WN) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.WN + ")");
            AppMethodBeat.o(140899);
            throw illegalArgumentException;
        }
        this.WL = view;
        this.mActivePointerId = i2;
        bf(1);
        AppMethodBeat.o(140899);
    }

    public final void cancel() {
        AppMethodBeat.i(140900);
        this.mActivePointerId = -1;
        gp();
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        AppMethodBeat.o(140900);
    }

    /* access modifiers changed from: package-private */
    public final int h(int i2, int i3, int i4) {
        int abs;
        AppMethodBeat.i(140901);
        if (i2 == 0) {
            AppMethodBeat.o(140901);
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
        int min = Math.min(abs, 600);
        AppMethodBeat.o(140901);
        return min;
    }

    static int i(int i2, int i3, int i4) {
        AppMethodBeat.i(140902);
        int abs = Math.abs(i2);
        if (abs < i3) {
            AppMethodBeat.o(140902);
            return 0;
        } else if (abs <= i4) {
            AppMethodBeat.o(140902);
            return i2;
        } else if (i2 > 0) {
            AppMethodBeat.o(140902);
            return i4;
        } else {
            int i5 = -i4;
            AppMethodBeat.o(140902);
            return i5;
        }
    }

    private static float f(float f2, float f3, float f4) {
        AppMethodBeat.i(140903);
        float abs = Math.abs(f2);
        if (abs < f3) {
            AppMethodBeat.o(140903);
            return 0.0f;
        } else if (abs <= f4) {
            AppMethodBeat.o(140903);
            return f2;
        } else if (f2 > 0.0f) {
            AppMethodBeat.o(140903);
            return f4;
        } else {
            float f5 = -f4;
            AppMethodBeat.o(140903);
            return f5;
        }
    }

    private static float distanceInfluenceForSnapDuration(float f2) {
        AppMethodBeat.i(140904);
        float sin = (float) Math.sin((double) ((float) (((double) (f2 - 0.5f)) * 0.4712389167638204d)));
        AppMethodBeat.o(140904);
        return sin;
    }

    private void l(float f2, float f3) {
        AppMethodBeat.i(140905);
        this.WM = true;
        this.UaX.a(this.WL, f2, f3);
        this.WM = false;
        if (this.Wx == 1) {
            bf(0);
        }
        AppMethodBeat.o(140905);
    }

    private void gp() {
        AppMethodBeat.i(140906);
        if (this.Wy == null) {
            AppMethodBeat.o(140906);
            return;
        }
        Arrays.fill(this.Wy, 0.0f);
        Arrays.fill(this.Wz, 0.0f);
        Arrays.fill(this.WA, 0.0f);
        Arrays.fill(this.WB, 0.0f);
        Arrays.fill(this.UaW, 0);
        Arrays.fill(this.WD, 0);
        Arrays.fill(this.WE, 0);
        this.WF = 0;
        AppMethodBeat.o(140906);
    }

    /* access modifiers changed from: package-private */
    public final void bd(int i2) {
        if (this.Wy != null) {
            this.Wy[i2] = 0.0f;
            this.Wz[i2] = 0.0f;
            this.WA[i2] = 0.0f;
            this.WB[i2] = 0.0f;
            this.UaW[i2] = 0;
            this.WD[i2] = 0;
            this.WE[i2] = 0;
            this.WF &= (1 << i2) ^ -1;
        }
    }

    private void pw(int i2) {
        AppMethodBeat.i(140907);
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
                System.arraycopy(this.UaW, 0, iArr, 0, this.UaW.length);
                System.arraycopy(this.WD, 0, iArr2, 0, this.WD.length);
                System.arraycopy(this.WE, 0, iArr3, 0, this.WE.length);
            }
            this.Wy = fArr;
            this.Wz = fArr2;
            this.WA = fArr3;
            this.WB = fArr4;
            this.UaW = iArr;
            this.WD = iArr2;
            this.WE = iArr3;
        }
        AppMethodBeat.o(140907);
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2, float f3, int i2) {
        AppMethodBeat.i(140908);
        pw(i2);
        float[] fArr = this.Wy;
        this.WA[i2] = f2;
        fArr[i2] = f2;
        float[] fArr2 = this.Wz;
        this.WB[i2] = f3;
        fArr2[i2] = f3;
        this.UaW[i2] = ng((int) f2, (int) f3);
        this.WF |= 1 << i2;
        AppMethodBeat.o(140908);
    }

    private boolean be(int i2) {
        return (this.WF & (1 << i2)) != 0;
    }

    /* access modifiers changed from: package-private */
    public final void bf(int i2) {
        AppMethodBeat.i(140910);
        if (this.Wx != i2) {
            this.Wx = i2;
            this.UaX.L(i2);
            if (i2 == 0) {
                this.WL = null;
            }
        }
        AppMethodBeat.o(140910);
    }

    /* access modifiers changed from: package-private */
    public final boolean z(View view, int i2) {
        AppMethodBeat.i(140911);
        if (view == this.WL && this.mActivePointerId == i2) {
            AppMethodBeat.o(140911);
            return true;
        } else if (view == null || !this.UaX.pv(i2)) {
            AppMethodBeat.o(140911);
            return false;
        } else {
            this.mActivePointerId = i2;
            y(view, i2);
            AppMethodBeat.o(140911);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(float f2, float f3, int i2) {
        int i3 = 1;
        AppMethodBeat.i(140913);
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
            iArr[i2] = i3 | iArr[i2];
        }
        AppMethodBeat.o(140913);
    }

    private boolean a(float f2, float f3, int i2, int i3) {
        AppMethodBeat.i(140914);
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.UaW[i2] & i3) != i3 || (this.WJ & i3) == 0 || (this.WE[i2] & i3) == i3 || (this.WD[i2] & i3) == i3 || (abs <= ((float) this.mTouchSlop) && abs2 <= ((float) this.mTouchSlop))) {
            AppMethodBeat.o(140914);
            return false;
        } else if ((this.WD[i2] & i3) != 0 || abs <= ((float) this.mTouchSlop)) {
            AppMethodBeat.o(140914);
            return false;
        } else {
            AppMethodBeat.o(140914);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean c(View view, float f2, float f3) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(140915);
        if (view == null) {
            AppMethodBeat.o(140915);
            return false;
        }
        if (this.UaX.awM() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.UaX.cg() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z || !z2) {
            if (z) {
                if (Math.abs(f2) > ((float) this.mTouchSlop)) {
                    AppMethodBeat.o(140915);
                    return true;
                }
                AppMethodBeat.o(140915);
                return false;
            } else if (!z2) {
                AppMethodBeat.o(140915);
                return false;
            } else if (Math.abs(f3) > ((float) this.mTouchSlop)) {
                AppMethodBeat.o(140915);
                return true;
            } else {
                AppMethodBeat.o(140915);
                return false;
            }
        } else if ((f2 * f2) + (f3 * f3) > ((float) (this.mTouchSlop * this.mTouchSlop))) {
            AppMethodBeat.o(140915);
            return true;
        } else {
            AppMethodBeat.o(140915);
            return false;
        }
    }

    public final boolean hl(int i2, int i3) {
        boolean z;
        AppMethodBeat.i(140916);
        if (!be(i3)) {
            AppMethodBeat.o(140916);
            return false;
        }
        boolean z2 = (i2 & 1) == 1;
        if ((i2 & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        float f2 = this.WA[i3] - this.Wy[i3];
        float f3 = this.WB[i3] - this.Wz[i3];
        if (!z2 || !z) {
            if (z2) {
                if (Math.abs(f2) > ((float) this.mTouchSlop)) {
                    AppMethodBeat.o(140916);
                    return true;
                }
                AppMethodBeat.o(140916);
                return false;
            } else if (!z) {
                AppMethodBeat.o(140916);
                return false;
            } else if (Math.abs(f3) > ((float) this.mTouchSlop)) {
                AppMethodBeat.o(140916);
                return true;
            } else {
                AppMethodBeat.o(140916);
                return false;
            }
        } else if ((f2 * f2) + (f3 * f3) > ((float) (this.mTouchSlop * this.mTouchSlop))) {
            AppMethodBeat.o(140916);
            return true;
        } else {
            AppMethodBeat.o(140916);
            return false;
        }
    }

    public final boolean nf(int i2, int i3) {
        AppMethodBeat.i(140917);
        if (!be(i3) || (this.UaW[i3] & i2) == 0) {
            AppMethodBeat.o(140917);
            return false;
        }
        AppMethodBeat.o(140917);
        return true;
    }

    private void gq() {
        AppMethodBeat.i(140918);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.WG);
        l(f(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.WH, this.WG), f(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.WH, this.WG));
        AppMethodBeat.o(140918);
    }

    private void i(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        AppMethodBeat.i(140919);
        int left = this.WL.getLeft();
        int top = this.WL.getTop();
        if (i4 != 0) {
            i6 = this.UaX.e(this.WL, i2);
            this.WL.offsetLeftAndRight(i6 - left);
        } else {
            i6 = i2;
        }
        if (i5 != 0) {
            i7 = this.UaX.d(this.WL, i3);
            this.WL.offsetTopAndBottom(i7 - top);
        } else {
            i7 = i3;
        }
        if (!(i4 == 0 && i5 == 0)) {
            this.UaX.l(this.WL, i6, i7, i6 - left, i7 - top);
        }
        AppMethodBeat.o(140919);
    }

    private boolean I(int i2, int i3) {
        AppMethodBeat.i(140920);
        boolean i4 = i(this.WL, i2, i3);
        AppMethodBeat.o(140920);
        return i4;
    }

    private static boolean i(View view, int i2, int i3) {
        AppMethodBeat.i(140921);
        if (view == null) {
            AppMethodBeat.o(140921);
            return false;
        } else if (i2 < view.getLeft() || i2 >= view.getRight() || i3 < view.getTop() || i3 >= view.getBottom()) {
            AppMethodBeat.o(140921);
            return false;
        } else {
            AppMethodBeat.o(140921);
            return true;
        }
    }

    public final View J(int i2, int i3) {
        AppMethodBeat.i(140922);
        for (int childCount = this.WN.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.WN.getChildAt(childCount);
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                AppMethodBeat.o(140922);
                return childAt;
            }
        }
        AppMethodBeat.o(140922);
        return null;
    }

    private int ng(int i2, int i3) {
        AppMethodBeat.i(140923);
        int i4 = 0;
        if (i2 < this.WN.getLeft() + this.WI) {
            i4 = 1;
        }
        if (i3 < this.WN.getTop() + this.WI) {
            i4 = 4;
        }
        if (i2 > this.WN.getRight() - this.WI) {
            i4 = 2;
        }
        if (i3 > this.WN.getBottom() - this.WI) {
            i4 = 8;
        }
        AppMethodBeat.o(140923);
        return i4;
    }

    /* access modifiers changed from: package-private */
    public final void i(MotionEvent motionEvent) {
        AppMethodBeat.i(140909);
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            float x = motionEvent.getX(i2);
            float y = motionEvent.getY(i2);
            this.WA[pointerId] = x;
            this.WB[pointerId] = y;
        }
        AppMethodBeat.o(140909);
    }

    public final void k(MotionEvent motionEvent) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(140912);
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
                if ((this.UaW[pointerId] & this.WJ) != 0) {
                    AppMethodBeat.o(140912);
                    return;
                }
                break;
            case 1:
                if (this.Wx == 1) {
                    gq();
                }
                cancel();
                AppMethodBeat.o(140912);
                return;
            case 2:
                if (this.Wx == 1) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float y2 = motionEvent.getY(findPointerIndex);
                    int i4 = (int) (x2 - this.WA[this.mActivePointerId]);
                    int i5 = (int) (y2 - this.WB[this.mActivePointerId]);
                    i(this.WL.getLeft() + i4, this.WL.getTop() + i5, i4, i5);
                    i(motionEvent);
                    AppMethodBeat.o(140912);
                    return;
                }
                int pointerCount = motionEvent.getPointerCount();
                while (i3 < pointerCount) {
                    int pointerId2 = motionEvent.getPointerId(i3);
                    float x3 = motionEvent.getX(i3);
                    float y3 = motionEvent.getY(i3);
                    float f2 = x3 - this.Wy[pointerId2];
                    float f3 = y3 - this.Wz[pointerId2];
                    b(f2, f3, pointerId2);
                    if (this.Wx != 1) {
                        View J2 = J((int) x3, (int) y3);
                        if (!c(J2, f2, f3) || !z(J2, pointerId2)) {
                            i3++;
                        }
                    }
                    i(motionEvent);
                    AppMethodBeat.o(140912);
                    return;
                }
                i(motionEvent);
                AppMethodBeat.o(140912);
                return;
            case 3:
                if (this.Wx == 1) {
                    l(0.0f, 0.0f);
                }
                cancel();
                break;
            case 5:
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                float x4 = motionEvent.getX(actionIndex);
                float y4 = motionEvent.getY(actionIndex);
                a(x4, y4, pointerId3);
                if (this.Wx == 0) {
                    z(J((int) x4, (int) y4), pointerId3);
                    AppMethodBeat.o(140912);
                    return;
                } else if (I((int) x4, (int) y4)) {
                    z(this.WL, pointerId3);
                    AppMethodBeat.o(140912);
                    return;
                }
                break;
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
                AppMethodBeat.o(140912);
                return;
        }
        AppMethodBeat.o(140912);
    }
}
