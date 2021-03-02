package com.tencent.mm.ext.ui;

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

public final class f {
    private static final Interpolator sInterpolator = new Interpolator() {
        /* class com.tencent.mm.ext.ui.f.AnonymousClass1 */

        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    float[] WA;
    float[] WB;
    int[] WC;
    private int[] WD;
    private int[] WE;
    int WF;
    float WG;
    float WH;
    private int WI;
    int WJ;
    View WL;
    boolean WM;
    final ViewGroup WN;
    final Runnable WO = new Runnable() {
        /* class com.tencent.mm.ext.ui.f.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(197879);
            f.this.bf(0);
            AppMethodBeat.o(197879);
        }
    };
    int Wx;
    float[] Wy;
    float[] Wz;
    p hgg;
    final a hgh;
    int mActivePointerId = -1;
    private int mTouchSlop;
    VelocityTracker mVelocityTracker;

    public static abstract class a {
        public abstract boolean pv(int i2);

        public void L(int i2) {
        }

        public void cL(int i2, int i3) {
        }

        public void a(View view, float f2, float f3) {
        }

        public int awM() {
            return 0;
        }

        public int e(View view, int i2) {
            return 0;
        }
    }

    static {
        AppMethodBeat.i(197902);
        AppMethodBeat.o(197902);
    }

    public static f a(ViewGroup viewGroup, a aVar, Interpolator interpolator) {
        AppMethodBeat.i(197880);
        f fVar = new f(viewGroup.getContext(), viewGroup, aVar, interpolator);
        AppMethodBeat.o(197880);
        return fVar;
    }

    private f(Context context, ViewGroup viewGroup, a aVar, Interpolator interpolator) {
        AppMethodBeat.i(197881);
        if (viewGroup == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Parent view may not be null");
            AppMethodBeat.o(197881);
            throw illegalArgumentException;
        } else if (aVar == null) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Callback may not be null");
            AppMethodBeat.o(197881);
            throw illegalArgumentException2;
        } else {
            this.WN = viewGroup;
            this.hgh = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.WI = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.WG = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.WH = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.hgg = p.a(context, interpolator);
            AppMethodBeat.o(197881);
        }
    }

    private void y(View view, int i2) {
        AppMethodBeat.i(197882);
        if (view.getParent() != this.WN) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.WN + ")");
            AppMethodBeat.o(197882);
            throw illegalArgumentException;
        }
        this.WL = view;
        this.mActivePointerId = i2;
        bf(1);
        AppMethodBeat.o(197882);
    }

    public final void cancel() {
        AppMethodBeat.i(197883);
        this.mActivePointerId = -1;
        gp();
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        AppMethodBeat.o(197883);
    }

    /* access modifiers changed from: package-private */
    public final int h(int i2, int i3, int i4) {
        int abs;
        AppMethodBeat.i(197884);
        if (i2 == 0) {
            AppMethodBeat.o(197884);
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
        AppMethodBeat.o(197884);
        return min;
    }

    static int i(int i2, int i3, int i4) {
        AppMethodBeat.i(197885);
        int abs = Math.abs(i2);
        if (abs < i3) {
            AppMethodBeat.o(197885);
            return 0;
        } else if (abs <= i4) {
            AppMethodBeat.o(197885);
            return i2;
        } else if (i2 > 0) {
            AppMethodBeat.o(197885);
            return i4;
        } else {
            int i5 = -i4;
            AppMethodBeat.o(197885);
            return i5;
        }
    }

    private static float f(float f2, float f3, float f4) {
        AppMethodBeat.i(197886);
        float abs = Math.abs(f2);
        if (abs < f3) {
            AppMethodBeat.o(197886);
            return 0.0f;
        } else if (abs <= f4) {
            AppMethodBeat.o(197886);
            return f2;
        } else if (f2 > 0.0f) {
            AppMethodBeat.o(197886);
            return f4;
        } else {
            float f5 = -f4;
            AppMethodBeat.o(197886);
            return f5;
        }
    }

    private static float distanceInfluenceForSnapDuration(float f2) {
        AppMethodBeat.i(197887);
        float sin = (float) Math.sin((double) ((float) (((double) (f2 - 0.5f)) * 0.4712389167638204d)));
        AppMethodBeat.o(197887);
        return sin;
    }

    /* access modifiers changed from: package-private */
    public final void l(float f2, float f3) {
        AppMethodBeat.i(197888);
        this.WM = true;
        this.hgh.a(this.WL, f2, f3);
        this.WM = false;
        if (this.Wx == 1) {
            bf(0);
        }
        AppMethodBeat.o(197888);
    }

    private void gp() {
        AppMethodBeat.i(197889);
        if (this.Wy == null) {
            AppMethodBeat.o(197889);
            return;
        }
        Arrays.fill(this.Wy, 0.0f);
        Arrays.fill(this.Wz, 0.0f);
        Arrays.fill(this.WA, 0.0f);
        Arrays.fill(this.WB, 0.0f);
        Arrays.fill(this.WC, 0);
        Arrays.fill(this.WD, 0);
        Arrays.fill(this.WE, 0);
        this.WF = 0;
        AppMethodBeat.o(197889);
    }

    /* access modifiers changed from: package-private */
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

    private void pw(int i2) {
        AppMethodBeat.i(197890);
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
        AppMethodBeat.o(197890);
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2, float f3, int i2) {
        AppMethodBeat.i(197891);
        pw(i2);
        float[] fArr = this.Wy;
        this.WA[i2] = f2;
        fArr[i2] = f2;
        float[] fArr2 = this.Wz;
        this.WB[i2] = f3;
        fArr2[i2] = f3;
        this.WC[i2] = cM((int) f2, (int) f3);
        this.WF |= 1 << i2;
        AppMethodBeat.o(197891);
    }

    /* access modifiers changed from: package-private */
    public final void bf(int i2) {
        AppMethodBeat.i(197893);
        if (this.Wx != i2) {
            this.Wx = i2;
            this.hgh.L(i2);
            if (i2 == 0) {
                this.WL = null;
            }
        }
        AppMethodBeat.o(197893);
    }

    /* access modifiers changed from: package-private */
    public final boolean z(View view, int i2) {
        AppMethodBeat.i(197894);
        if (view == this.WL && this.mActivePointerId == i2) {
            AppMethodBeat.o(197894);
            return true;
        } else if (view == null || !this.hgh.pv(i2)) {
            AppMethodBeat.o(197894);
            return false;
        } else {
            this.mActivePointerId = i2;
            y(view, i2);
            AppMethodBeat.o(197894);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(float f2, float f3, int i2) {
        int i3 = 1;
        AppMethodBeat.i(197895);
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
        AppMethodBeat.o(197895);
    }

    private boolean a(float f2, float f3, int i2, int i3) {
        AppMethodBeat.i(197896);
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.WC[i2] & i3) != i3 || (this.WJ & i3) == 0 || (this.WE[i2] & i3) == i3 || (this.WD[i2] & i3) == i3 || (abs <= ((float) this.mTouchSlop) && abs2 <= ((float) this.mTouchSlop))) {
            AppMethodBeat.o(197896);
            return false;
        } else if ((this.WD[i2] & i3) != 0 || abs <= ((float) this.mTouchSlop)) {
            AppMethodBeat.o(197896);
            return false;
        } else {
            AppMethodBeat.o(197896);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean r(View view, float f2) {
        AppMethodBeat.i(197897);
        if (view == null) {
            AppMethodBeat.o(197897);
            return false;
        }
        if (!(this.hgh.awM() > 0)) {
            AppMethodBeat.o(197897);
            return false;
        } else if (Math.abs(f2) > ((float) this.mTouchSlop)) {
            AppMethodBeat.o(197897);
            return true;
        } else {
            AppMethodBeat.o(197897);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void gq() {
        AppMethodBeat.i(197898);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.WG);
        l(f(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.WH, this.WG), f(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.WH, this.WG));
        AppMethodBeat.o(197898);
    }

    public static boolean i(View view, int i2, int i3) {
        AppMethodBeat.i(197899);
        if (view == null) {
            AppMethodBeat.o(197899);
            return false;
        } else if (i2 < view.getLeft() || i2 >= view.getRight() || i3 < view.getTop() || i3 >= view.getBottom()) {
            AppMethodBeat.o(197899);
            return false;
        } else {
            AppMethodBeat.o(197899);
            return true;
        }
    }

    public final View J(int i2, int i3) {
        AppMethodBeat.i(197900);
        for (int childCount = this.WN.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.WN.getChildAt(childCount);
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                AppMethodBeat.o(197900);
                return childAt;
            }
        }
        AppMethodBeat.o(197900);
        return null;
    }

    private int cM(int i2, int i3) {
        AppMethodBeat.i(197901);
        int i4 = 0;
        if (i2 < this.WN.getLeft() + this.WI) {
            i4 = 1;
        }
        if (i3 < this.WN.getTop() + this.WI) {
            i4 |= 4;
        }
        if (i2 > this.WN.getRight() - this.WI) {
            i4 |= 2;
        }
        if (i3 > this.WN.getBottom() - this.WI) {
            i4 |= 8;
        }
        AppMethodBeat.o(197901);
        return i4;
    }

    /* access modifiers changed from: package-private */
    public final void i(MotionEvent motionEvent) {
        AppMethodBeat.i(197892);
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            float x = motionEvent.getX(i2);
            float y = motionEvent.getY(i2);
            this.WA[pointerId] = x;
            this.WB[pointerId] = y;
        }
        AppMethodBeat.o(197892);
    }
}
