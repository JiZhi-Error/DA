package com.tencent.mm.svg.a;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import com.tencent.mm.svg.b.c;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.lang.ref.WeakReference;

public abstract class b extends Drawable {
    protected final Rect Ky = new Rect();
    protected Paint OuA = new Paint();
    protected WeakReference<View> OuB;
    protected int OuC = 0;
    protected int OuD = 0;
    protected int OuE = 0;
    protected int OuF = 0;
    protected float OuG;
    protected int Ouy = 0;
    protected boolean Ouz = false;
    public long mDuration = 0;
    protected ColorFilter xo;

    public b(int i2, int i3, int i4) {
        this.OuE = i2;
        this.OuF = i3;
        this.OuG = 1.0f;
        this.OuC = this.OuE;
        this.OuD = this.OuF;
        setLevel(10000);
        this.Ouy = i4;
    }

    /* access modifiers changed from: protected */
    public final void gFP() {
        this.Ky.set(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.Ouz = true;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        gFR();
        return super.onLevelChange(i2);
    }

    /* access modifiers changed from: protected */
    public final void gFQ() {
        if (this.Ouz) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.Ky);
        }
        this.Ouz = false;
    }

    private void gFR() {
        View C = a.C(this);
        gr(C);
        if (C != null) {
            if (this.xo != null) {
                setColorFilter(this.xo);
            }
            a.b(C, this.OuA);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized View gFS() {
        View view;
        if (this.OuB == null) {
            view = null;
        } else {
            view = this.OuB.get();
        }
        return view;
    }

    /* access modifiers changed from: protected */
    public final synchronized void gr(View view) {
        this.OuB = new WeakReference<>(view);
    }

    public boolean setVisible(boolean z, boolean z2) {
        gFR();
        return super.setVisible(z, z2);
    }

    @TargetApi(17)
    public void setAlpha(int i2) {
        this.OuA.setAlpha(i2);
        View gFS = gFS();
        if (gFS != null && Build.VERSION.SDK_INT >= 17) {
            try {
                gFS.setLayerPaint(this.OuA);
            } catch (NoSuchMethodError e2) {
                c.printErrStackTrace("MicroMsg.SVGDrawable", e2, "samsung", new Object[0]);
            }
        }
    }

    @TargetApi(17)
    public void setColorFilter(ColorFilter colorFilter) {
        this.OuA.setColorFilter(colorFilter);
        View gFS = gFS();
        if (gFS != null && Build.VERSION.SDK_INT >= 17) {
            try {
                gFS.setLayerPaint(this.OuA);
            } catch (NoSuchMethodError e2) {
                c.printErrStackTrace("MicroMsg.SVGDrawable", e2, "samsung", new Object[0]);
            }
        } else if (gFS == null) {
            this.xo = colorFilter;
        }
    }

    public int getOpacity() {
        View gFS = gFS();
        if (gFS != null && gFS.getAlpha() < 1.0f) {
            return -3;
        }
        if (this.OuA == null || this.OuA.getAlpha() >= 255) {
            return 0;
        }
        return -3;
    }

    /* access modifiers changed from: protected */
    public final void y(Canvas canvas) {
        if (com.tencent.mm.svg.b.b.gFW()) {
            int height = this.Ky.height() / 3;
            canvas.save();
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(-12303292);
            paint.setAlpha(TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
            paint.setTextSize((float) height);
            paint.setStrokeWidth(1.0f);
            canvas.translate(((float) this.Ky.width()) - paint.measureText("SVG"), (float) ((this.Ky.height() * 2) / 3));
            canvas.drawText("SVG", 0.0f, (float) height, paint);
            canvas.restore();
        }
    }

    public int getIntrinsicWidth() {
        return this.OuC;
    }

    public int getIntrinsicHeight() {
        return this.OuD;
    }
}
