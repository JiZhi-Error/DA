package android.support.design.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.circularreveal.c;
import android.support.design.widget.k;
import android.view.View;

public final class b {
    public static final int jG;
    private final a jH;
    private final Path jI = new Path();
    private final Paint jJ = new Paint(7);
    public final Paint jK = new Paint(1);
    private c.d jL;
    public Drawable jM;
    private boolean jN;
    private boolean jO;
    private final View view;

    public interface a {
        void a(Canvas canvas);

        boolean bw();
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            jG = 2;
        } else if (Build.VERSION.SDK_INT >= 18) {
            jG = 1;
        } else {
            jG = 0;
        }
    }

    public b(a aVar) {
        this.jH = aVar;
        this.view = (View) aVar;
        this.view.setWillNotDraw(false);
        this.jK.setColor(0);
    }

    public final void bu() {
        if (jG == 0) {
            this.jN = true;
            this.jO = false;
            this.view.buildDrawingCache();
            Bitmap drawingCache = this.view.getDrawingCache();
            if (!(drawingCache != null || this.view.getWidth() == 0 || this.view.getHeight() == 0)) {
                drawingCache = Bitmap.createBitmap(this.view.getWidth(), this.view.getHeight(), Bitmap.Config.ARGB_8888);
                this.view.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.jJ;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.jN = false;
            this.jO = true;
        }
    }

    public final void bv() {
        if (jG == 0) {
            this.jO = false;
            this.view.destroyDrawingCache();
            this.jJ.setShader(null);
            this.view.invalidate();
        }
    }

    public final void setRevealInfo(c.d dVar) {
        if (dVar == null) {
            this.jL = null;
        } else {
            if (this.jL == null) {
                this.jL = new c.d(dVar);
            } else {
                this.jL.b(dVar);
            }
            if (k.e(dVar.radius, a(dVar))) {
                this.jL.radius = Float.MAX_VALUE;
            }
        }
        bx();
    }

    public final c.d getRevealInfo() {
        if (this.jL == null) {
            return null;
        }
        c.d dVar = new c.d(this.jL);
        if (!dVar.isInvalid()) {
            return dVar;
        }
        dVar.radius = a(dVar);
        return dVar;
    }

    public final void setCircularRevealScrimColor(int i2) {
        this.jK.setColor(i2);
        this.view.invalidate();
    }

    public final void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.jM = drawable;
        this.view.invalidate();
    }

    private void bx() {
        if (jG == 1) {
            this.jI.rewind();
            if (this.jL != null) {
                this.jI.addCircle(this.jL.centerX, this.jL.centerY, this.jL.radius, Path.Direction.CW);
            }
        }
        this.view.invalidate();
    }

    private float a(c.d dVar) {
        return k.c(dVar.centerX, dVar.centerY, (float) this.view.getWidth(), (float) this.view.getHeight());
    }

    public final void draw(Canvas canvas) {
        if (by()) {
            switch (jG) {
                case 0:
                    canvas.drawCircle(this.jL.centerX, this.jL.centerY, this.jL.radius, this.jJ);
                    if (bz()) {
                        canvas.drawCircle(this.jL.centerX, this.jL.centerY, this.jL.radius, this.jK);
                        break;
                    }
                    break;
                case 1:
                    int save = canvas.save();
                    canvas.clipPath(this.jI);
                    this.jH.a(canvas);
                    if (bz()) {
                        canvas.drawRect(0.0f, 0.0f, (float) this.view.getWidth(), (float) this.view.getHeight(), this.jK);
                    }
                    canvas.restoreToCount(save);
                    break;
                case 2:
                    this.jH.a(canvas);
                    if (bz()) {
                        canvas.drawRect(0.0f, 0.0f, (float) this.view.getWidth(), (float) this.view.getHeight(), this.jK);
                        break;
                    }
                    break;
                default:
                    throw new IllegalStateException("Unsupported strategy " + jG);
            }
        } else {
            this.jH.a(canvas);
            if (bz()) {
                canvas.drawRect(0.0f, 0.0f, (float) this.view.getWidth(), (float) this.view.getHeight(), this.jK);
            }
        }
        b(canvas);
    }

    private void b(Canvas canvas) {
        if (bA()) {
            Rect bounds = this.jM.getBounds();
            float width = this.jL.centerX - (((float) bounds.width()) / 2.0f);
            float height = this.jL.centerY - (((float) bounds.height()) / 2.0f);
            canvas.translate(width, height);
            this.jM.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    public final boolean isOpaque() {
        return this.jH.bw() && !by();
    }

    private boolean by() {
        boolean z;
        if (this.jL == null || this.jL.isInvalid()) {
            z = true;
        } else {
            z = false;
        }
        return jG == 0 ? !z && this.jO : !z;
    }

    private boolean bz() {
        return !this.jN && Color.alpha(this.jK.getColor()) != 0;
    }

    private boolean bA() {
        return (this.jN || this.jM == null || this.jL == null) ? false : true;
    }
}
