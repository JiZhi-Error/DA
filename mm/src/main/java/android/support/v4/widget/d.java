package android.support.v4.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v4.e.m;
import android.support.v4.view.b.b;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public final class d extends Drawable implements Animatable {
    private static final Interpolator SI = new LinearInterpolator();
    private static final Interpolator SJ = new b();
    private static final int[] SK = {-16777216};
    private Animator Fj;
    final a SL = new a();
    private float SM;
    float SN;
    boolean SO;
    private Resources mResources;

    public d(Context context) {
        this.mResources = ((Context) m.checkNotNull(context)).getResources();
        this.SL.setColors(SK);
        this.SL.setStrokeWidth(2.5f);
        invalidateSelf();
        final a aVar = this.SL;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class android.support.v4.widget.d.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                d.a(floatValue, aVar);
                d.this.a(floatValue, aVar, false);
                d.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(SI);
        ofFloat.addListener(new Animator.AnimatorListener() {
            /* class android.support.v4.widget.d.AnonymousClass2 */

            public final void onAnimationStart(Animator animator) {
                d.this.SN = 0.0f;
            }

            public final void onAnimationEnd(Animator animator) {
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
                d.this.a(1.0f, aVar, true);
                aVar.fQ();
                a aVar = aVar;
                aVar.aV(aVar.fO());
                if (d.this.SO) {
                    d.this.SO = false;
                    animator.cancel();
                    animator.setDuration(1332);
                    animator.start();
                    aVar.N(false);
                    return;
                }
                d.this.SN += 1.0f;
            }
        });
        this.Fj = ofFloat;
    }

    private void g(float f2, float f3, float f4, float f5) {
        a aVar = this.SL;
        float f6 = this.mResources.getDisplayMetrics().density;
        aVar.setStrokeWidth(f3 * f6);
        aVar.Tc = f2 * f6;
        aVar.aV(0);
        aVar.Td = (int) (f4 * f6);
        aVar.Te = (int) (f6 * f5);
    }

    public final void setStyle(int i2) {
        if (i2 == 0) {
            g(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            g(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public final void M(boolean z) {
        this.SL.N(z);
        invalidateSelf();
    }

    public final void C(float f2) {
        a aVar = this.SL;
        if (f2 != aVar.Tb) {
            aVar.Tb = f2;
        }
        invalidateSelf();
    }

    public final void D(float f2) {
        this.SL.SU = 0.0f;
        this.SL.SV = f2;
        invalidateSelf();
    }

    public final void E(float f2) {
        this.SL.SM = f2;
        invalidateSelf();
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.SM, bounds.exactCenterX(), bounds.exactCenterY());
        a aVar = this.SL;
        RectF rectF = aVar.SR;
        float f2 = aVar.Tc + (aVar.mStrokeWidth / 2.0f);
        if (aVar.Tc <= 0.0f) {
            f2 = (((float) Math.min(bounds.width(), bounds.height())) / 2.0f) - Math.max((((float) aVar.Td) * aVar.Tb) / 2.0f, aVar.mStrokeWidth / 2.0f);
        }
        rectF.set(((float) bounds.centerX()) - f2, ((float) bounds.centerY()) - f2, ((float) bounds.centerX()) + f2, f2 + ((float) bounds.centerY()));
        float f3 = (aVar.SU + aVar.SM) * 360.0f;
        float f4 = ((aVar.SV + aVar.SM) * 360.0f) - f3;
        aVar.mPaint.setColor(aVar.KC);
        aVar.mPaint.setAlpha(aVar.mAlpha);
        float f5 = aVar.mStrokeWidth / 2.0f;
        rectF.inset(f5, f5);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, aVar.ST);
        rectF.inset(-f5, -f5);
        canvas.drawArc(rectF, f3, f4, false, aVar.mPaint);
        if (aVar.mShowArrow) {
            if (aVar.Ta == null) {
                aVar.Ta = new Path();
                aVar.Ta.setFillType(Path.FillType.EVEN_ODD);
            } else {
                aVar.Ta.reset();
            }
            aVar.Ta.moveTo(0.0f, 0.0f);
            aVar.Ta.lineTo(((float) aVar.Td) * aVar.Tb, 0.0f);
            aVar.Ta.lineTo((((float) aVar.Td) * aVar.Tb) / 2.0f, ((float) aVar.Te) * aVar.Tb);
            aVar.Ta.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((((float) aVar.Td) * aVar.Tb) / 2.0f), rectF.centerY() + (aVar.mStrokeWidth / 2.0f));
            aVar.Ta.close();
            aVar.SS.setColor(aVar.KC);
            aVar.SS.setAlpha(aVar.mAlpha);
            canvas.save();
            canvas.rotate(f3 + f4, rectF.centerX(), rectF.centerY());
            canvas.drawPath(aVar.Ta, aVar.SS);
            canvas.restore();
        }
        canvas.restore();
    }

    public final void setAlpha(int i2) {
        this.SL.mAlpha = i2;
        invalidateSelf();
    }

    public final int getAlpha() {
        return this.SL.mAlpha;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.SL.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final int getOpacity() {
        return -3;
    }

    public final boolean isRunning() {
        return this.Fj.isRunning();
    }

    public final void start() {
        this.Fj.cancel();
        this.SL.fQ();
        if (this.SL.SV != this.SL.SU) {
            this.SO = true;
            this.Fj.setDuration(666);
            this.Fj.start();
            return;
        }
        this.SL.aV(0);
        this.SL.fR();
        this.Fj.setDuration(1332);
        this.Fj.start();
    }

    public final void stop() {
        this.Fj.cancel();
        this.SM = 0.0f;
        this.SL.N(false);
        this.SL.aV(0);
        this.SL.fR();
        invalidateSelf();
    }

    static void a(float f2, a aVar) {
        if (f2 > 0.75f) {
            float f3 = (f2 - 0.75f) / 0.25f;
            int fP = aVar.fP();
            int i2 = aVar.mColors[aVar.fO()];
            int i3 = (fP >> 24) & 255;
            int i4 = (fP >> 16) & 255;
            int i5 = (fP >> 8) & 255;
            int i6 = fP & 255;
            aVar.KC = (((int) (f3 * ((float) ((i2 & 255) - i6)))) + i6) | ((i3 + ((int) (((float) (((i2 >> 24) & 255) - i3)) * f3))) << 24) | ((i4 + ((int) (((float) (((i2 >> 16) & 255) - i4)) * f3))) << 16) | ((((int) (((float) (((i2 >> 8) & 255) - i5)) * f3)) + i5) << 8);
            return;
        }
        aVar.KC = aVar.fP();
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2, a aVar, boolean z) {
        float f3;
        float interpolation;
        if (this.SO) {
            a(f2, aVar);
            aVar.SU = aVar.SX + (((aVar.SY - 0.01f) - aVar.SX) * f2);
            aVar.SV = aVar.SY;
            aVar.SM = ((((float) (Math.floor((double) (aVar.SZ / 0.8f)) + 1.0d)) - aVar.SZ) * f2) + aVar.SZ;
        } else if (f2 != 1.0f || z) {
            float f4 = aVar.SZ;
            if (f2 < 0.5f) {
                interpolation = aVar.SX;
                f3 = (SJ.getInterpolation(f2 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                f3 = aVar.SX + 0.79f;
                interpolation = f3 - (((1.0f - SJ.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            aVar.SU = interpolation;
            aVar.SV = f3;
            aVar.SM = f4 + (0.20999998f * f2);
            this.SM = 216.0f * (this.SN + f2);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        int KC;
        float SM = 0.0f;
        final RectF SR = new RectF();
        final Paint SS = new Paint();
        final Paint ST = new Paint();
        float SU = 0.0f;
        float SV = 0.0f;
        int SW;
        float SX;
        float SY;
        float SZ;
        Path Ta;
        float Tb = 1.0f;
        float Tc;
        int Td;
        int Te;
        int mAlpha = 255;
        int[] mColors;
        final Paint mPaint = new Paint();
        boolean mShowArrow;
        float mStrokeWidth = 5.0f;

        a() {
            this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.SS.setStyle(Paint.Style.FILL);
            this.SS.setAntiAlias(true);
            this.ST.setColor(0);
        }

        /* access modifiers changed from: package-private */
        public final void setColors(int[] iArr) {
            this.mColors = iArr;
            aV(0);
        }

        /* access modifiers changed from: package-private */
        public final void aV(int i2) {
            this.SW = i2;
            this.KC = this.mColors[this.SW];
        }

        /* access modifiers changed from: package-private */
        public final int fO() {
            return (this.SW + 1) % this.mColors.length;
        }

        /* access modifiers changed from: package-private */
        public final void setStrokeWidth(float f2) {
            this.mStrokeWidth = f2;
            this.mPaint.setStrokeWidth(f2);
        }

        /* access modifiers changed from: package-private */
        public final int fP() {
            return this.mColors[this.SW];
        }

        /* access modifiers changed from: package-private */
        public final void N(boolean z) {
            if (this.mShowArrow != z) {
                this.mShowArrow = z;
            }
        }

        /* access modifiers changed from: package-private */
        public final void fQ() {
            this.SX = this.SU;
            this.SY = this.SV;
            this.SZ = this.SM;
        }

        /* access modifiers changed from: package-private */
        public final void fR() {
            this.SX = 0.0f;
            this.SY = 0.0f;
            this.SZ = 0.0f;
            this.SU = 0.0f;
            this.SV = 0.0f;
            this.SM = 0.0f;
        }
    }
}
