package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.support.v7.d.a.c;
import com.tencent.mm.R;

public final class l extends c {
    static final double tn = Math.cos(Math.toRadians(45.0d));
    private boolean dirty = true;
    float rotation;
    private final int tA;
    private final int tB;
    boolean tC = true;
    private boolean tD = false;
    final Paint tp;
    final Paint tq;
    final RectF tr;
    float tt;
    Path tu;
    float tv;
    float tw;
    float tx;
    float ty;
    private final int tz;

    public l(Context context, Drawable drawable, float f2, float f3, float f4) {
        super(drawable);
        this.tz = b.n(context, R.color.lb);
        this.tA = b.n(context, R.color.la);
        this.tB = b.n(context, R.color.l_);
        this.tp = new Paint(5);
        this.tp.setStyle(Paint.Style.FILL);
        this.tt = (float) Math.round(f2);
        this.tr = new RectF();
        this.tq = new Paint(this.tp);
        this.tq.setAntiAlias(false);
        f(f3, f4);
    }

    private static int s(float f2) {
        int round = Math.round(f2);
        return round % 2 == 1 ? round - 1 : round;
    }

    @Override // android.support.v7.d.a.c
    public final void setAlpha(int i2) {
        super.setAlpha(i2);
        this.tp.setAlpha(i2);
        this.tq.setAlpha(i2);
    }

    @Override // android.support.v7.d.a.c
    public final void onBoundsChange(Rect rect) {
        this.dirty = true;
    }

    public final void f(float f2, float f3) {
        if (f2 < 0.0f || f3 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float s = (float) s(f2);
        float s2 = (float) s(f3);
        if (s > s2) {
            if (!this.tD) {
                this.tD = true;
            }
            s = s2;
        }
        if (this.ty != s || this.tw != s2) {
            this.ty = s;
            this.tw = s2;
            this.tx = (float) Math.round(s * 1.5f);
            this.tv = s2;
            this.dirty = true;
            invalidateSelf();
        }
    }

    public final void t(float f2) {
        f(f2, this.tw);
    }

    @Override // android.support.v7.d.a.c
    public final boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) a(this.tw, this.tt, this.tC));
        int ceil2 = (int) Math.ceil((double) b(this.tw, this.tt, this.tC));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public static float a(float f2, float f3, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f2)) + ((1.0d - tn) * ((double) f3)));
        }
        return 1.5f * f2;
    }

    public static float b(float f2, float f3, boolean z) {
        if (z) {
            return (float) (((double) f2) + ((1.0d - tn) * ((double) f3)));
        }
        return f2;
    }

    @Override // android.support.v7.d.a.c
    public final int getOpacity() {
        return -3;
    }

    @Override // android.support.v7.d.a.c
    public final void draw(Canvas canvas) {
        boolean z;
        if (this.dirty) {
            Rect bounds = getBounds();
            float f2 = this.tw * 1.5f;
            this.tr.set(((float) bounds.left) + this.tw, ((float) bounds.top) + f2, ((float) bounds.right) - this.tw, ((float) bounds.bottom) - f2);
            this.mDrawable.setBounds((int) this.tr.left, (int) this.tr.top, (int) this.tr.right, (int) this.tr.bottom);
            RectF rectF = new RectF(-this.tt, -this.tt, this.tt, this.tt);
            RectF rectF2 = new RectF(rectF);
            rectF2.inset(-this.tx, -this.tx);
            if (this.tu == null) {
                this.tu = new Path();
            } else {
                this.tu.reset();
            }
            this.tu.setFillType(Path.FillType.EVEN_ODD);
            this.tu.moveTo(-this.tt, 0.0f);
            this.tu.rLineTo(-this.tx, 0.0f);
            this.tu.arcTo(rectF2, 180.0f, 90.0f, false);
            this.tu.arcTo(rectF, 270.0f, -90.0f, false);
            this.tu.close();
            float f3 = -rectF2.top;
            if (f3 > 0.0f) {
                float f4 = this.tt / f3;
                this.tp.setShader(new RadialGradient(0.0f, 0.0f, f3, new int[]{0, this.tz, this.tA, this.tB}, new float[]{0.0f, f4, f4 + ((1.0f - f4) / 2.0f), 1.0f}, Shader.TileMode.CLAMP));
            }
            this.tq.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.tz, this.tA, this.tB}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
            this.tq.setAntiAlias(false);
            this.dirty = false;
        }
        int save = canvas.save();
        canvas.rotate(this.rotation, this.tr.centerX(), this.tr.centerY());
        float f5 = (-this.tt) - this.tx;
        float f6 = this.tt;
        boolean z2 = this.tr.width() - (2.0f * f6) > 0.0f;
        if (this.tr.height() - (2.0f * f6) > 0.0f) {
            z = true;
        } else {
            z = false;
        }
        float f7 = this.ty - (this.ty * 0.25f);
        float f8 = f6 / ((this.ty - (this.ty * 0.5f)) + f6);
        float f9 = f6 / (f7 + f6);
        float f10 = f6 / (f6 + (this.ty - (this.ty * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.tr.left + f6, this.tr.top + f6);
        canvas.scale(f8, f9);
        canvas.drawPath(this.tu, this.tp);
        if (z2) {
            canvas.scale(1.0f / f8, 1.0f);
            canvas.drawRect(0.0f, f5, this.tr.width() - (2.0f * f6), -this.tt, this.tq);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.tr.right - f6, this.tr.bottom - f6);
        canvas.scale(f8, f10);
        canvas.rotate(180.0f);
        canvas.drawPath(this.tu, this.tp);
        if (z2) {
            canvas.scale(1.0f / f8, 1.0f);
            canvas.drawRect(0.0f, f5, this.tr.width() - (2.0f * f6), this.tx + (-this.tt), this.tq);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        canvas.translate(this.tr.left + f6, this.tr.bottom - f6);
        canvas.scale(f8, f10);
        canvas.rotate(270.0f);
        canvas.drawPath(this.tu, this.tp);
        if (z) {
            canvas.scale(1.0f / f10, 1.0f);
            canvas.drawRect(0.0f, f5, this.tr.height() - (2.0f * f6), -this.tt, this.tq);
        }
        canvas.restoreToCount(save4);
        int save5 = canvas.save();
        canvas.translate(this.tr.right - f6, this.tr.top + f6);
        canvas.scale(f8, f9);
        canvas.rotate(90.0f);
        canvas.drawPath(this.tu, this.tp);
        if (z) {
            canvas.scale(1.0f / f9, 1.0f);
            canvas.drawRect(0.0f, f5, this.tr.height() - (2.0f * f6), -this.tt, this.tq);
        }
        canvas.restoreToCount(save5);
        canvas.restoreToCount(save);
        super.draw(canvas);
    }
}
