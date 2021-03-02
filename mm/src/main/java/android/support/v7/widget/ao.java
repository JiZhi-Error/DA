package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.tencent.mm.R;

/* access modifiers changed from: package-private */
public final class ao extends Drawable {
    static a auT;
    private static final double tn = Math.cos(Math.toRadians(45.0d));
    float Kx;
    ColorStateList auR;
    private final int auS;
    private Paint auU;
    private Paint auV;
    private final RectF auW;
    private Path auX;
    float auY;
    private float auZ;
    float ava;
    boolean avb = true;
    private final int avc;
    private final int avd;
    private boolean ave = true;
    private boolean avf = false;
    private Paint mPaint;

    interface a {
        void a(Canvas canvas, RectF rectF, float f2, Paint paint);
    }

    ao(Resources resources, ColorStateList colorStateList, float f2, float f3, float f4) {
        this.avc = resources.getColor(R.color.il);
        this.avd = resources.getColor(R.color.ik);
        this.auS = resources.getDimensionPixelSize(R.dimen.w5);
        this.mPaint = new Paint(5);
        g(colorStateList);
        this.auU = new Paint(5);
        this.auU.setStyle(Paint.Style.FILL);
        this.Kx = (float) ((int) (0.5f + f2));
        this.auW = new RectF();
        this.auV = new Paint(this.auU);
        this.auV.setAntiAlias(false);
        f(f3, f4);
    }

    /* access modifiers changed from: package-private */
    public final void g(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.auR = colorStateList;
        this.mPaint.setColor(this.auR.getColorForState(getState(), this.auR.getDefaultColor()));
    }

    private static int s(float f2) {
        int i2 = (int) (0.5f + f2);
        if (i2 % 2 == 1) {
            return i2 - 1;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final void aw(boolean z) {
        this.ave = z;
        invalidateSelf();
    }

    public final void setAlpha(int i2) {
        this.mPaint.setAlpha(i2);
        this.auU.setAlpha(i2);
        this.auV.setAlpha(i2);
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.avb = true;
    }

    /* access modifiers changed from: package-private */
    public final void f(float f2, float f3) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f2 + ". Must be >= 0");
        } else if (f3 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f3 + ". Must be >= 0");
        } else {
            float s = (float) s(f2);
            float s2 = (float) s(f3);
            if (s > s2) {
                if (!this.avf) {
                    this.avf = true;
                }
                s = s2;
            }
            if (this.ava != s || this.auY != s2) {
                this.ava = s;
                this.auY = s2;
                this.auZ = (float) ((int) ((s * 1.5f) + ((float) this.auS) + 0.5f));
                this.avb = true;
                invalidateSelf();
            }
        }
    }

    public final boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) a(this.auY, this.Kx, this.ave));
        int ceil2 = (int) Math.ceil((double) b(this.auY, this.Kx, this.ave));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    static float a(float f2, float f3, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f2)) + ((1.0d - tn) * ((double) f3)));
        }
        return 1.5f * f2;
    }

    static float b(float f2, float f3, boolean z) {
        if (z) {
            return (float) (((double) f2) + ((1.0d - tn) * ((double) f3)));
        }
        return f2;
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        int colorForState = this.auR.getColorForState(iArr, this.auR.getDefaultColor());
        if (this.mPaint.getColor() == colorForState) {
            return false;
        }
        this.mPaint.setColor(colorForState);
        this.avb = true;
        invalidateSelf();
        return true;
    }

    public final boolean isStateful() {
        return (this.auR != null && this.auR.isStateful()) || super.isStateful();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }

    public final void draw(Canvas canvas) {
        boolean z = true;
        if (this.avb) {
            Rect bounds = getBounds();
            float f2 = this.auY * 1.5f;
            this.auW.set(((float) bounds.left) + this.auY, ((float) bounds.top) + f2, ((float) bounds.right) - this.auY, ((float) bounds.bottom) - f2);
            RectF rectF = new RectF(-this.Kx, -this.Kx, this.Kx, this.Kx);
            RectF rectF2 = new RectF(rectF);
            rectF2.inset(-this.auZ, -this.auZ);
            if (this.auX == null) {
                this.auX = new Path();
            } else {
                this.auX.reset();
            }
            this.auX.setFillType(Path.FillType.EVEN_ODD);
            this.auX.moveTo(-this.Kx, 0.0f);
            this.auX.rLineTo(-this.auZ, 0.0f);
            this.auX.arcTo(rectF2, 180.0f, 90.0f, false);
            this.auX.arcTo(rectF, 270.0f, -90.0f, false);
            this.auX.close();
            this.auU.setShader(new RadialGradient(0.0f, 0.0f, this.Kx + this.auZ, new int[]{this.avc, this.avc, this.avd}, new float[]{0.0f, this.Kx / (this.Kx + this.auZ), 1.0f}, Shader.TileMode.CLAMP));
            this.auV.setShader(new LinearGradient(0.0f, (-this.Kx) + this.auZ, 0.0f, (-this.Kx) - this.auZ, new int[]{this.avc, this.avc, this.avd}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
            this.auV.setAntiAlias(false);
            this.avb = false;
        }
        canvas.translate(0.0f, this.ava / 2.0f);
        float f3 = (-this.Kx) - this.auZ;
        float f4 = this.Kx + ((float) this.auS) + (this.ava / 2.0f);
        boolean z2 = this.auW.width() - (2.0f * f4) > 0.0f;
        if (this.auW.height() - (2.0f * f4) <= 0.0f) {
            z = false;
        }
        int save = canvas.save();
        canvas.translate(this.auW.left + f4, this.auW.top + f4);
        canvas.drawPath(this.auX, this.auU);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.auW.width() - (2.0f * f4), -this.Kx, this.auV);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.auW.right - f4, this.auW.bottom - f4);
        canvas.rotate(180.0f);
        canvas.drawPath(this.auX, this.auU);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.auW.width() - (2.0f * f4), this.auZ + (-this.Kx), this.auV);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.auW.left + f4, this.auW.bottom - f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.auX, this.auU);
        if (z) {
            canvas.drawRect(0.0f, f3, this.auW.height() - (2.0f * f4), -this.Kx, this.auV);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        canvas.translate(this.auW.right - f4, this.auW.top + f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.auX, this.auU);
        if (z) {
            canvas.drawRect(0.0f, f3, this.auW.height() - (2.0f * f4), -this.Kx, this.auV);
        }
        canvas.restoreToCount(save4);
        canvas.translate(0.0f, (-this.ava) / 2.0f);
        auT.a(canvas, this.auW, this.Kx, this.mPaint);
    }

    /* access modifiers changed from: package-private */
    public final float getMinWidth() {
        return (Math.max(this.auY, this.Kx + ((float) this.auS) + (this.auY / 2.0f)) * 2.0f) + ((this.auY + ((float) this.auS)) * 2.0f);
    }

    /* access modifiers changed from: package-private */
    public final float getMinHeight() {
        return (Math.max(this.auY, this.Kx + ((float) this.auS) + ((this.auY * 1.5f) / 2.0f)) * 2.0f) + (((this.auY * 1.5f) + ((float) this.auS)) * 2.0f);
    }
}
