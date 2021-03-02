package com.tencent.mm.ui.mogic;

import android.content.Context;
import android.support.v4.widget.p;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;

public final class a {
    private static final Interpolator sInterpolator = new Interpolator() {
        /* class com.tencent.mm.ui.mogic.a.AnonymousClass1 */

        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    public final AbstractC2121a Qnx;
    public float[] WA;
    public float[] WB;
    public int[] WC;
    private int[] WD;
    private int[] WE;
    public int WF;
    public float WG;
    public float WH;
    private int WI;
    public int WJ;
    public View WL;
    public boolean WM;
    public final ViewGroup WN;
    public final Runnable WO = new Runnable() {
        /* class com.tencent.mm.ui.mogic.a.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(142866);
            a.this.bf(0);
            AppMethodBeat.o(142866);
        }
    };
    public int Wx;
    public float[] Wy;
    public float[] Wz;
    public p hgg;
    public int mActivePointerId = -1;
    private int mTouchSlop;
    public VelocityTracker mVelocityTracker;

    /* renamed from: com.tencent.mm.ui.mogic.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC2121a {
        public abstract boolean pv(int i2);

        public void L(int i2) {
        }

        public void cL(int i2, int i3) {
        }

        public void a(View view, float f2, float f3) {
        }

        public void RF(int i2) {
        }

        public int awM() {
            return 0;
        }

        public int e(View view, int i2) {
            return 0;
        }
    }

    static {
        AppMethodBeat.i(142886);
        AppMethodBeat.o(142886);
    }

    public static a a(ViewGroup viewGroup, AbstractC2121a aVar, Interpolator interpolator) {
        AppMethodBeat.i(142867);
        a aVar2 = new a(viewGroup.getContext(), viewGroup, aVar, interpolator);
        AppMethodBeat.o(142867);
        return aVar2;
    }

    private a(Context context, ViewGroup viewGroup, AbstractC2121a aVar, Interpolator interpolator) {
        AppMethodBeat.i(142868);
        if (viewGroup == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Parent view may not be null");
            AppMethodBeat.o(142868);
            throw illegalArgumentException;
        } else if (aVar == null) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Callback may not be null");
            AppMethodBeat.o(142868);
            throw illegalArgumentException2;
        } else {
            this.WN = viewGroup;
            this.Qnx = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.WI = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.WG = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.WH = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.hgg = p.a(context, interpolator);
            AppMethodBeat.o(142868);
        }
    }

    public final void cancel() {
        AppMethodBeat.i(142869);
        this.mActivePointerId = -1;
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
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        AppMethodBeat.o(142869);
    }

    public final boolean b(int i2, int i3, int i4, int i5, long j2) {
        AppMethodBeat.i(142870);
        int left = this.WL.getLeft();
        int top = this.WL.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.hgg.UD.abortAnimation();
            bf(0);
            AppMethodBeat.o(142870);
            return false;
        }
        if (j2 == 0) {
            j2 = (long) H(i6, i7, i4, i5);
        }
        Log.d("WxViewDragHelper", "ashutest:: xvel %d, yvel %d, dx %d, dy %d duration %d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Long.valueOf(j2));
        this.hgg.startScroll(left, top, i6, i7, (int) j2);
        bf(2);
        AppMethodBeat.o(142870);
        return true;
    }

    private int H(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(142871);
        int i6 = i(i4, (int) this.WH, (int) this.WG);
        int i7 = i(i5, (int) this.WH, (int) this.WG);
        int abs = Math.abs(i2);
        int abs2 = Math.abs(i3);
        int abs3 = Math.abs(i6);
        int abs4 = Math.abs(i7);
        int i8 = abs3 + abs4;
        int i9 = abs + abs2;
        int h2 = (int) (((i7 != 0 ? ((float) abs4) / ((float) i8) : ((float) abs2) / ((float) i9)) * ((float) h(i3, i7, 0))) + ((i6 != 0 ? ((float) abs3) / ((float) i8) : ((float) abs) / ((float) i9)) * ((float) h(i2, i6, this.Qnx.awM()))));
        AppMethodBeat.o(142871);
        return h2;
    }

    private int h(int i2, int i3, int i4) {
        int abs;
        AppMethodBeat.i(142872);
        if (i2 == 0) {
            AppMethodBeat.o(142872);
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
        AppMethodBeat.o(142872);
        return min;
    }

    private static int i(int i2, int i3, int i4) {
        AppMethodBeat.i(142873);
        int abs = Math.abs(i2);
        if (abs < i3) {
            AppMethodBeat.o(142873);
            return 0;
        } else if (abs <= i4) {
            AppMethodBeat.o(142873);
            return i2;
        } else if (i2 > 0) {
            AppMethodBeat.o(142873);
            return i4;
        } else {
            int i5 = -i4;
            AppMethodBeat.o(142873);
            return i5;
        }
    }

    private static float f(float f2, float f3, float f4) {
        AppMethodBeat.i(142874);
        float abs = Math.abs(f2);
        if (abs < f3) {
            AppMethodBeat.o(142874);
            return 0.0f;
        } else if (abs <= f4) {
            AppMethodBeat.o(142874);
            return f2;
        } else if (f2 > 0.0f) {
            AppMethodBeat.o(142874);
            return f4;
        } else {
            float f5 = -f4;
            AppMethodBeat.o(142874);
            return f5;
        }
    }

    private static float distanceInfluenceForSnapDuration(float f2) {
        AppMethodBeat.i(142875);
        float sin = (float) Math.sin((double) ((float) (((double) (f2 - 0.5f)) * 0.4712389167638204d)));
        AppMethodBeat.o(142875);
        return sin;
    }

    public final void l(float f2, float f3) {
        AppMethodBeat.i(142876);
        this.WM = true;
        this.Qnx.a(this.WL, f2, f3);
        this.WM = false;
        if (this.Wx == 1) {
            bf(0);
        }
        AppMethodBeat.o(142876);
    }

    public final void bd(int i2) {
        if (this.Wy != null) {
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

    /* access modifiers changed from: package-private */
    public final void bf(int i2) {
        AppMethodBeat.i(142879);
        if (this.Wx != i2) {
            this.Wx = i2;
            this.Qnx.L(i2);
            if (i2 == 0) {
                this.WL = null;
            }
        }
        AppMethodBeat.o(142879);
    }

    public final boolean z(View view, int i2) {
        AppMethodBeat.i(142880);
        if (view == this.WL && this.mActivePointerId == i2) {
            AppMethodBeat.o(142880);
            return true;
        } else if (view == null || !this.Qnx.pv(i2)) {
            AppMethodBeat.o(142880);
            return false;
        } else {
            this.mActivePointerId = i2;
            if (view.getParent() != this.WN) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.WN + ")");
                AppMethodBeat.o(142880);
                throw illegalArgumentException;
            }
            this.WL = view;
            this.mActivePointerId = i2;
            bf(1);
            AppMethodBeat.o(142880);
            return true;
        }
    }

    public final void b(float f2, float f3, int i2) {
        int i3 = 1;
        AppMethodBeat.i(142881);
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
            this.Qnx.RF(i3);
        }
        AppMethodBeat.o(142881);
    }

    private boolean a(float f2, float f3, int i2, int i3) {
        AppMethodBeat.i(142882);
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.WC[i2] & i3) != i3 || (this.WJ & i3) == 0 || (this.WE[i2] & i3) == i3 || (this.WD[i2] & i3) == i3 || (abs <= ((float) this.mTouchSlop) && abs2 <= ((float) this.mTouchSlop))) {
            AppMethodBeat.o(142882);
            return false;
        } else if ((this.WD[i2] & i3) != 0 || abs <= ((float) this.mTouchSlop)) {
            AppMethodBeat.o(142882);
            return false;
        } else {
            AppMethodBeat.o(142882);
            return true;
        }
    }

    public final boolean r(View view, float f2) {
        AppMethodBeat.i(142883);
        if (view == null) {
            AppMethodBeat.o(142883);
            return false;
        }
        if (!(this.Qnx.awM() > 0)) {
            AppMethodBeat.o(142883);
            return false;
        } else if (Math.abs(f2) > ((float) this.mTouchSlop)) {
            AppMethodBeat.o(142883);
            return true;
        } else {
            AppMethodBeat.o(142883);
            return false;
        }
    }

    public final void gq() {
        AppMethodBeat.i(142884);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.WG);
        l(f(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.WH, this.WG), f(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.WH, this.WG));
        AppMethodBeat.o(142884);
    }

    public final View J(int i2, int i3) {
        AppMethodBeat.i(142885);
        for (int childCount = this.WN.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.WN.getChildAt(childCount);
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                AppMethodBeat.o(142885);
                return childAt;
            }
        }
        AppMethodBeat.o(142885);
        return null;
    }

    public final void a(float f2, float f3, int i2) {
        int i3 = 0;
        AppMethodBeat.i(142877);
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
        AppMethodBeat.o(142877);
    }

    public final void i(MotionEvent motionEvent) {
        AppMethodBeat.i(142878);
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            float x = motionEvent.getX(i2);
            float y = motionEvent.getY(i2);
            this.WA[pointerId] = x;
            this.WB[pointerId] = y;
        }
        AppMethodBeat.o(142878);
    }
}
