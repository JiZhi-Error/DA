package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

public abstract class b extends Drawable {
    private boolean KA = true;
    private boolean KB;
    private int Kt = 160;
    private int Ku = 119;
    private final BitmapShader Kv;
    private final Matrix Kw = new Matrix();
    float Kx;
    final Rect Ky = new Rect();
    private final RectF Kz = new RectF();
    public final Bitmap mBitmap;
    private int mBitmapHeight;
    private int mBitmapWidth;
    private final Paint mPaint = new Paint(3);

    public final Paint getPaint() {
        return this.mPaint;
    }

    public final Bitmap getBitmap() {
        return this.mBitmap;
    }

    public void setFilterBitmap(boolean z) {
        this.mPaint.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.mPaint.setDither(z);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int i4, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public final void eC() {
        if (this.KA) {
            if (this.KB) {
                int min = Math.min(this.mBitmapWidth, this.mBitmapHeight);
                a(this.Ku, min, min, getBounds(), this.Ky);
                int min2 = Math.min(this.Ky.width(), this.Ky.height());
                this.Ky.inset(Math.max(0, (this.Ky.width() - min2) / 2), Math.max(0, (this.Ky.height() - min2) / 2));
                this.Kx = ((float) min2) * 0.5f;
            } else {
                a(this.Ku, this.mBitmapWidth, this.mBitmapHeight, getBounds(), this.Ky);
            }
            this.Kz.set(this.Ky);
            if (this.Kv != null) {
                this.Kw.setTranslate(this.Kz.left, this.Kz.top);
                this.Kw.preScale(this.Kz.width() / ((float) this.mBitmap.getWidth()), this.Kz.height() / ((float) this.mBitmap.getHeight()));
                this.Kv.setLocalMatrix(this.Kw);
                this.mPaint.setShader(this.Kv);
            }
            this.KA = false;
        }
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            eC();
            if (this.mPaint.getShader() == null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.Ky, this.mPaint);
            } else {
                canvas.drawRoundRect(this.Kz, this.Kx, this.Kx, this.mPaint);
            }
        }
    }

    public void setAlpha(int i2) {
        if (i2 != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i2);
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public ColorFilter getColorFilter() {
        return this.mPaint.getColorFilter();
    }

    public final void eD() {
        this.KB = true;
        this.KA = true;
        eE();
        this.mPaint.setShader(this.Kv);
        invalidateSelf();
    }

    private void eE() {
        this.Kx = (float) (Math.min(this.mBitmapHeight, this.mBitmapWidth) / 2);
    }

    public final void setCornerRadius(float f2) {
        if (this.Kx != f2) {
            this.KB = false;
            if (x(f2)) {
                this.mPaint.setShader(this.Kv);
            } else {
                this.mPaint.setShader(null);
            }
            this.Kx = f2;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.KB) {
            eE();
        }
        this.KA = true;
    }

    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    public int getOpacity() {
        Bitmap bitmap;
        if (this.Ku != 119 || this.KB || (bitmap = this.mBitmap) == null || bitmap.hasAlpha() || this.mPaint.getAlpha() < 255 || x(this.Kx)) {
            return -3;
        }
        return -1;
    }

    b(Resources resources, Bitmap bitmap) {
        if (resources != null) {
            this.Kt = resources.getDisplayMetrics().densityDpi;
        }
        this.mBitmap = bitmap;
        if (this.mBitmap != null) {
            this.mBitmapWidth = this.mBitmap.getScaledWidth(this.Kt);
            this.mBitmapHeight = this.mBitmap.getScaledHeight(this.Kt);
            Bitmap bitmap2 = this.mBitmap;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.Kv = new BitmapShader(bitmap2, tileMode, tileMode);
            return;
        }
        this.mBitmapHeight = -1;
        this.mBitmapWidth = -1;
        this.Kv = null;
    }

    private static boolean x(float f2) {
        return f2 > 0.05f;
    }
}
