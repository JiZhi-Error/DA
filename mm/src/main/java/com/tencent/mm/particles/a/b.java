package com.tencent.mm.particles.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;

public abstract class b {
    public int alpha;
    private final Matrix gT = new Matrix();
    public float jIE;
    public float jIG;
    public Float jII;
    public Float jIK;
    public float jIQ;
    public Float jIS;
    public long jIU;
    public Interpolator jIy;
    public Rect jIz;
    public float jJA;
    public float jJB;
    public float jJC;
    public float jJD;
    private final Paint jJi = new Paint(1);
    public long jJj;
    public float jJk;
    public float jJl;
    public float jJm;
    public float jJn;
    public Long jJo;
    public Long jJp;
    public float jJq;
    public float jJr;
    public Long jJs;
    public float jJt;
    public float jJu;
    public float jJv;
    public float jJw;
    public float jJx;
    public boolean jJy;
    public boolean jJz;
    public VelocityTracker ol;
    public boolean terminated;

    /* access modifiers changed from: protected */
    public abstract void a(Canvas canvas, Matrix matrix, Paint paint, float f2, float f3, float f4, float f5);

    public abstract int getHeight();

    public abstract int getWidth();

    public final void k(Rect rect) {
        this.jIz = rect;
        this.jJo = a(this.jII, this.jJm, this.jIE);
        this.jJp = a(this.jIK, this.jJn, this.jIG);
        this.jJs = a(this.jIS, this.jJr, this.jIQ);
        if (this.jJt == 0.0f) {
            this.jJt = this.jIU >= 0 ? (float) this.jIU : 9.223372E18f;
            this.jJt = Math.min((float) a(this.jJk, this.jJm, this.jIE, this.jJo, this.jII, rect.left - getWidth(), rect.right), this.jJt);
            this.jJt = Math.min((float) a(this.jJl, this.jJn, this.jIG, this.jJp, this.jIK, rect.top - getHeight(), rect.bottom), this.jJt);
        }
        this.jJi.setAlpha(this.alpha);
    }

    private static Long a(Float f2, float f3, float f4) {
        if (f2 == null) {
            return null;
        }
        if (f4 != 0.0f) {
            long floatValue = (long) ((f2.floatValue() - f3) / f4);
            if (floatValue <= 0) {
                floatValue = 0;
            }
            return Long.valueOf(floatValue);
        } else if (f2.floatValue() < f3) {
            return 0L;
        } else {
            return null;
        }
    }

    private static long a(float f2, float f3, float f4, Long l, Float f5, int i2, int i3) {
        if (f4 != 0.0f) {
            if (f4 <= 0.0f) {
                i3 = i2;
            }
            if (l == null || l.longValue() < 0) {
                double sqrt = Math.sqrt((double) ((((2.0f * f4) * ((float) i3)) - ((2.0f * f4) * f2)) + (f3 * f3)));
                double d2 = ((-sqrt) - ((double) f3)) / ((double) f4);
                if (d2 > 0.0d) {
                    return (long) d2;
                }
                double d3 = (sqrt - ((double) f3)) / ((double) f4);
                if (d3 > 0.0d) {
                    return (long) d3;
                }
                return MAlarmHandler.NEXT_FIRE_INTERVAL;
            }
            double longValue = ((((double) ((((float) i3) - f2) - (((float) l.longValue()) * f3))) - (((0.5d * ((double) f4)) * ((double) l.longValue())) * ((double) l.longValue()))) + ((double) (f5.floatValue() * ((float) l.longValue())))) / ((double) f5.floatValue());
            return longValue > 0.0d ? (long) longValue : MAlarmHandler.NEXT_FIRE_INTERVAL;
        }
        if (l != null) {
            f3 = f5.floatValue();
        }
        if (f3 <= 0.0f) {
            i3 = i2;
        }
        if (f3 == 0.0f) {
            return MAlarmHandler.NEXT_FIRE_INTERVAL;
        }
        double d4 = (double) ((((float) i3) - f2) / f3);
        return d4 > 0.0d ? (long) d4 : MAlarmHandler.NEXT_FIRE_INTERVAL;
    }

    public void reset() {
        this.jJj = 0;
        this.jJl = 0.0f;
        this.jJk = 0.0f;
        this.jJn = 0.0f;
        this.jJm = 0.0f;
        this.jIG = 0.0f;
        this.jIE = 0.0f;
        this.jIK = null;
        this.jII = null;
        this.jJp = null;
        this.jJo = null;
        this.jJq = 0.0f;
        this.jJr = 0.0f;
        this.jIQ = 0.0f;
        this.jIS = null;
        this.jJs = null;
        this.jIU = 0;
        this.jJt = 0.0f;
        this.jJu = 0.0f;
        this.jIy = null;
        this.jJw = 0.0f;
        this.jJv = 0.0f;
        this.jJx = 0.0f;
        this.alpha = 255;
        this.jJy = false;
        this.terminated = false;
    }

    public static float a(long j2, float f2, float f3, float f4, Long l, Float f5) {
        if (l == null || j2 < l.longValue()) {
            return (((float) j2) * f3) + f2 + (0.5f * f4 * ((float) j2) * ((float) j2));
        }
        return (((float) l.longValue()) * f3) + f2 + (0.5f * f4 * ((float) l.longValue()) * ((float) l.longValue())) + (((float) (j2 - l.longValue())) * f5.floatValue());
    }

    public final void a(Canvas canvas, float f2, float f3, float f4, float f5) {
        canvas.save();
        canvas.clipRect(this.jIz);
        this.gT.reset();
        this.jJi.setAlpha(this.alpha);
        a(canvas, this.gT, this.jJi, f2, f3, f4, f5);
        canvas.restore();
    }

    public final float bkP() {
        return this.jJk;
    }

    public final float bkQ() {
        return this.jJl;
    }
}
