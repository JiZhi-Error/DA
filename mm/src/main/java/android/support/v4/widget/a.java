package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.u;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class a implements View.OnTouchListener {
    private static final int Ss = ViewConfiguration.getTapTimeout();
    boolean FR;
    final C0039a Se = new C0039a();
    private final Interpolator Sf = new AccelerateInterpolator();
    final View Sg;
    private float[] Sh = {0.0f, 0.0f};
    private float[] Si = {Float.MAX_VALUE, Float.MAX_VALUE};
    private int Sj;
    private int Sk;
    private float[] Sl = {0.0f, 0.0f};
    private float[] Sm = {0.0f, 0.0f};
    private float[] Sn = {Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean So;
    boolean Sp;
    boolean Sq;
    private boolean Sr;
    private boolean mEnabled;
    private Runnable mRunnable;

    public abstract void aS(int i2);

    public abstract boolean aT(int i2);

    public a(View view) {
        this.Sg = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        float f2 = (float) ((int) ((1575.0f * displayMetrics.density) + 0.5f));
        this.Sn[0] = f2 / 1000.0f;
        this.Sn[1] = f2 / 1000.0f;
        float f3 = (float) ((int) ((displayMetrics.density * 315.0f) + 0.5f));
        this.Sm[0] = f3 / 1000.0f;
        this.Sm[1] = f3 / 1000.0f;
        this.Sj = 1;
        this.Si[0] = Float.MAX_VALUE;
        this.Si[1] = Float.MAX_VALUE;
        this.Sh[0] = 0.2f;
        this.Sh[1] = 0.2f;
        this.Sl[0] = 0.001f;
        this.Sl[1] = 0.001f;
        this.Sk = Ss;
        this.Se.St = 500;
        this.Se.Su = 500;
    }

    public final a L(boolean z) {
        if (this.mEnabled && !z) {
            fK();
        }
        this.mEnabled = z;
        return this;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
        /*
        // Method dump skipped, instructions count: 142
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public final boolean bZ() {
        C0039a aVar = this.Se;
        int fM = aVar.fM();
        int fL = aVar.fL();
        if (fM != 0 && aT(fM)) {
            return true;
        }
        if (fL != 0) {
        }
        return false;
    }

    private void fK() {
        if (this.Sp) {
            this.FR = false;
        } else {
            this.Se.fK();
        }
    }

    private float a(int i2, float f2, float f3, float f4) {
        float f5 = f(this.Sh[i2], f3, this.Si[i2], f2);
        if (f5 == 0.0f) {
            return 0.0f;
        }
        float f6 = this.Sl[i2];
        float f7 = this.Sm[i2];
        float f8 = this.Sn[i2];
        float f9 = f6 * f4;
        if (f5 > 0.0f) {
            return e(f5 * f9, f7, f8);
        }
        return -e((-f5) * f9, f7, f8);
    }

    private float f(float f2, float f3, float f4, float f5) {
        float interpolation;
        float e2 = e(f2 * f3, 0.0f, f4);
        float k = k(f3 - f5, e2) - k(f5, e2);
        if (k < 0.0f) {
            interpolation = -this.Sf.getInterpolation(-k);
        } else if (k <= 0.0f) {
            return 0.0f;
        } else {
            interpolation = this.Sf.getInterpolation(k);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private float k(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        switch (this.Sj) {
            case 0:
            case 1:
                if (f2 >= f3) {
                    return 0.0f;
                }
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                return (!this.FR || this.Sj != 1) ? 0.0f : 1.0f;
            case 2:
                if (f2 < 0.0f) {
                    return f2 / (-f3);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    static int B(int i2, int i3) {
        if (i2 > i3) {
            return i3;
        }
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    static float e(float f2, float f3, float f4) {
        if (f2 > f4) {
            return f4;
        }
        return f2 < f3 ? f3 : f2;
    }

    class b implements Runnable {
        b() {
        }

        public final void run() {
            boolean z;
            if (a.this.FR) {
                if (a.this.Sp) {
                    a.this.Sp = false;
                    C0039a aVar = a.this.Se;
                    aVar.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                    aVar.Sy = -1;
                    aVar.Sx = aVar.mStartTime;
                    aVar.Sz = 0.5f;
                    aVar.Bi = 0;
                    aVar.Bj = 0;
                }
                C0039a aVar2 = a.this.Se;
                if (aVar2.Sy <= 0 || AnimationUtils.currentAnimationTimeMillis() <= aVar2.Sy + ((long) aVar2.SA)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z || !a.this.bZ()) {
                    a.this.FR = false;
                    return;
                }
                if (a.this.Sq) {
                    a.this.Sq = false;
                    a aVar3 = a.this;
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    aVar3.Sg.onTouchEvent(obtain);
                    obtain.recycle();
                }
                if (aVar2.Sx == 0) {
                    throw new RuntimeException("Cannot compute scroll delta before calling start()");
                }
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float l = aVar2.l(currentAnimationTimeMillis);
                float f2 = (l * 4.0f) + (-4.0f * l * l);
                long j2 = currentAnimationTimeMillis - aVar2.Sx;
                aVar2.Sx = currentAnimationTimeMillis;
                aVar2.Bi = (int) (((float) j2) * f2 * aVar2.Sv);
                aVar2.Bj = (int) (((float) j2) * f2 * aVar2.Sw);
                a.this.aS(aVar2.Bj);
                u.b(a.this.Sg, this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: android.support.v4.widget.a$a  reason: collision with other inner class name */
    public static class C0039a {
        int Bi = 0;
        int Bj = 0;
        int SA;
        int St;
        int Su;
        float Sv;
        float Sw;
        long Sx = 0;
        long Sy = -1;
        float Sz;
        long mStartTime = Long.MIN_VALUE;

        C0039a() {
        }

        public final void fK() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.SA = a.B((int) (currentAnimationTimeMillis - this.mStartTime), this.Su);
            this.Sz = l(currentAnimationTimeMillis);
            this.Sy = currentAnimationTimeMillis;
        }

        /* access modifiers changed from: package-private */
        public final float l(long j2) {
            if (j2 < this.mStartTime) {
                return 0.0f;
            }
            if (this.Sy < 0 || j2 < this.Sy) {
                return a.e(((float) (j2 - this.mStartTime)) / ((float) this.St), 0.0f, 1.0f) * 0.5f;
            }
            return (a.e(((float) (j2 - this.Sy)) / ((float) this.SA), 0.0f, 1.0f) * this.Sz) + (1.0f - this.Sz);
        }

        public final int fL() {
            return (int) (this.Sv / Math.abs(this.Sv));
        }

        public final int fM() {
            return (int) (this.Sw / Math.abs(this.Sw));
        }
    }
}
