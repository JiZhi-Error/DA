package android.support.v7.d.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.a;

public final class d extends Drawable {
    private static final float acV = ((float) Math.toRadians(45.0d));
    private float acW;
    private float acX;
    private float acY;
    private float acZ;
    private boolean ada;
    private boolean adb;
    private float adc;
    private int add;
    private final Paint mPaint;
    private float mProgress;
    private final int mSize;
    private final Path xT;

    public final void Z(boolean z) {
        if (this.adb != z) {
            this.adb = z;
            invalidateSelf();
        }
    }

    public final void draw(Canvas canvas) {
        boolean z;
        float f2;
        float f3;
        Rect bounds = getBounds();
        switch (this.add) {
            case 0:
                z = false;
                break;
            case 1:
                z = true;
                break;
            case 2:
            default:
                if (a.k(this) != 1) {
                    z = false;
                    break;
                } else {
                    z = true;
                    break;
                }
            case 3:
                if (a.k(this) != 0) {
                    z = false;
                    break;
                } else {
                    z = true;
                    break;
                }
        }
        float sqrt = (float) Math.sqrt((double) (this.acW * this.acW * 2.0f));
        float f4 = this.acX;
        float f5 = f4 + ((sqrt - f4) * this.mProgress);
        float f6 = this.acX;
        float f7 = f6 + ((this.acY - f6) * this.mProgress);
        float round = (float) Math.round(0.0f + ((this.adc - 0.0f) * this.mProgress));
        float f8 = 0.0f + ((acV - 0.0f) * this.mProgress);
        if (z) {
            f2 = 0.0f;
        } else {
            f2 = -180.0f;
        }
        if (z) {
            f3 = 180.0f;
        } else {
            f3 = 0.0f;
        }
        float f9 = ((f3 - f2) * this.mProgress) + f2;
        float round2 = (float) Math.round(((double) f5) * Math.cos((double) f8));
        float round3 = (float) Math.round(((double) f5) * Math.sin((double) f8));
        this.xT.rewind();
        float strokeWidth = this.acZ + this.mPaint.getStrokeWidth();
        float f10 = strokeWidth + (((-this.adc) - strokeWidth) * this.mProgress);
        float f11 = (-f7) / 2.0f;
        this.xT.moveTo(f11 + round, 0.0f);
        this.xT.rLineTo(f7 - (round * 2.0f), 0.0f);
        this.xT.moveTo(f11, f10);
        this.xT.rLineTo(round2, round3);
        this.xT.moveTo(f11, -f10);
        this.xT.rLineTo(round2, -round3);
        this.xT.close();
        canvas.save();
        float strokeWidth2 = this.mPaint.getStrokeWidth();
        canvas.translate((float) bounds.centerX(), (strokeWidth2 * 1.5f) + this.acZ + ((float) ((((int) ((((float) bounds.height()) - (3.0f * strokeWidth2)) - (this.acZ * 2.0f))) / 4) * 2)));
        if (this.ada) {
            canvas.rotate(((float) (z ^ this.adb ? -1 : 1)) * f9);
        } else if (z) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.xT, this.mPaint);
        canvas.restore();
    }

    public final void setAlpha(int i2) {
        if (i2 != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i2);
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final int getIntrinsicHeight() {
        return this.mSize;
    }

    public final int getIntrinsicWidth() {
        return this.mSize;
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setProgress(float f2) {
        if (this.mProgress != f2) {
            this.mProgress = f2;
            invalidateSelf();
        }
    }
}
