package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* access modifiers changed from: package-private */
public final class an extends Drawable {
    float auL;
    private final RectF auM;
    private final Rect auN;
    float auO;
    private boolean auP = false;
    private boolean auQ = true;
    ColorStateList auR;
    private final Paint mPaint;
    private PorterDuffColorFilter xn;
    private ColorStateList yk;
    private PorterDuff.Mode yl = PorterDuff.Mode.SRC_IN;

    an(ColorStateList colorStateList, float f2) {
        this.auL = f2;
        this.mPaint = new Paint(5);
        g(colorStateList);
        this.auM = new RectF();
        this.auN = new Rect();
    }

    /* access modifiers changed from: package-private */
    public final void g(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.auR = colorStateList;
        this.mPaint.setColor(this.auR.getColorForState(getState(), this.auR.getDefaultColor()));
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2, boolean z, boolean z2) {
        if (f2 != this.auO || this.auP != z || this.auQ != z2) {
            this.auO = f2;
            this.auP = z;
            this.auQ = z2;
            h(null);
            invalidateSelf();
        }
    }

    public final void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.mPaint;
        if (this.xn == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.xn);
            z = true;
        }
        canvas.drawRoundRect(this.auM, this.auL, this.auL, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    /* access modifiers changed from: package-private */
    public final void h(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.auM.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.auN.set(rect);
        if (this.auP) {
            float a2 = ao.a(this.auO, this.auL, this.auQ);
            this.auN.inset((int) Math.ceil((double) ao.b(this.auO, this.auL, this.auQ)), (int) Math.ceil((double) a2));
            this.auM.set(this.auN);
        }
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        h(rect);
    }

    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.auN, this.auL);
    }

    public final void setAlpha(int i2) {
        this.mPaint.setAlpha(i2);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setTintList(ColorStateList colorStateList) {
        this.yk = colorStateList;
        this.xn = b(this.yk, this.yl);
        invalidateSelf();
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        this.yl = mode;
        this.xn = b(this.yk, this.yl);
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        int colorForState = this.auR.getColorForState(iArr, this.auR.getDefaultColor());
        boolean z = colorForState != this.mPaint.getColor();
        if (z) {
            this.mPaint.setColor(colorForState);
        }
        if (this.yk == null || this.yl == null) {
            return z;
        }
        this.xn = b(this.yk, this.yl);
        return true;
    }

    public final boolean isStateful() {
        return (this.yk != null && this.yk.isStateful()) || (this.auR != null && this.auR.isStateful()) || super.isStateful();
    }

    private PorterDuffColorFilter b(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
