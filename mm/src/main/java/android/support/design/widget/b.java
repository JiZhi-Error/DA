package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

public class b extends Drawable {
    float borderWidth;
    final RectF hO = new RectF();
    final a oF = new a(this, (byte) 0);
    private int oG;
    private int oH;
    private int oI;
    private int oJ;
    private ColorStateList oK;
    private int oL;
    private boolean oM = true;
    final Paint paint = new Paint(1);
    final Rect rect = new Rect();
    float rotation;

    public b() {
        this.paint.setStyle(Paint.Style.STROKE);
    }

    public Drawable.ConstantState getConstantState() {
        return this.oF;
    }

    public final void b(int i2, int i3, int i4, int i5) {
        this.oG = i2;
        this.oH = i3;
        this.oI = i4;
        this.oJ = i5;
    }

    public final void setBorderWidth(float f2) {
        if (this.borderWidth != f2) {
            this.borderWidth = f2;
            this.paint.setStrokeWidth(1.3333f * f2);
            this.oM = true;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.oM) {
            Paint paint2 = this.paint;
            Rect rect2 = this.rect;
            copyBounds(rect2);
            float height = this.borderWidth / ((float) rect2.height());
            paint2.setShader(new LinearGradient(0.0f, (float) rect2.top, 0.0f, (float) rect2.bottom, new int[]{android.support.v4.graphics.b.v(this.oG, this.oL), android.support.v4.graphics.b.v(this.oH, this.oL), android.support.v4.graphics.b.v(android.support.v4.graphics.b.x(this.oH, 0), this.oL), android.support.v4.graphics.b.v(android.support.v4.graphics.b.x(this.oJ, 0), this.oL), android.support.v4.graphics.b.v(this.oJ, this.oL), android.support.v4.graphics.b.v(this.oI, this.oL)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP));
            this.oM = false;
        }
        float strokeWidth = this.paint.getStrokeWidth() / 2.0f;
        RectF rectF = this.hO;
        copyBounds(this.rect);
        rectF.set(this.rect);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.rotation, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.paint);
        canvas.restore();
    }

    public boolean getPadding(Rect rect2) {
        int round = Math.round(this.borderWidth);
        rect2.set(round, round, round, round);
        return true;
    }

    public void setAlpha(int i2) {
        this.paint.setAlpha(i2);
        invalidateSelf();
    }

    public final void c(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.oL = colorStateList.getColorForState(getState(), this.oL);
        }
        this.oK = colorStateList;
        this.oM = true;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        return this.borderWidth > 0.0f ? -3 : -2;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect2) {
        this.oM = true;
    }

    public boolean isStateful() {
        return (this.oK != null && this.oK.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        if (!(this.oK == null || (colorForState = this.oK.getColorForState(iArr, this.oL)) == this.oL)) {
            this.oM = true;
            this.oL = colorForState;
        }
        if (this.oM) {
            invalidateSelf();
        }
        return this.oM;
    }

    class a extends Drawable.ConstantState {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        public final Drawable newDrawable() {
            return b.this;
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }
}
