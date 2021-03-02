package android.support.design.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;

/* access modifiers changed from: package-private */
public final class e extends GradientDrawable {
    private final Paint qT = new Paint(1);
    private final RectF qU;
    private int qV;

    e() {
        this.qT.setStyle(Paint.Style.FILL_AND_STROKE);
        this.qT.setColor(-1);
        this.qT.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.qU = new RectF();
    }

    /* access modifiers changed from: package-private */
    public final boolean cz() {
        return !this.qU.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2, float f3, float f4, float f5) {
        if (f2 != this.qU.left || f3 != this.qU.top || f4 != this.qU.right || f5 != this.qU.bottom) {
            this.qU.set(f2, f3, f4, f5);
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(RectF rectF) {
        a(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public final void draw(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (callback instanceof View) {
            ((View) callback).setLayerType(2, null);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.qV = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), null);
        } else {
            this.qV = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), null, 31);
        }
        super.draw(canvas);
        canvas.drawRect(this.qU, this.qT);
        if (!(getCallback() instanceof View)) {
            canvas.restoreToCount(this.qV);
        }
    }
}
