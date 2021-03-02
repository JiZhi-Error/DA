package android.support.design.f;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.e;
import com.tencent.smtt.sdk.WebView;

public final class c extends Drawable implements e {
    private int alpha;
    private final Matrix gT;
    private final PointF ja;
    private PorterDuffColorFilter ji;
    private PorterDuff.Mode jk;
    private final Matrix[] lO;
    private final Matrix[] lP;
    private final d[] lQ;
    private final Path lR;
    private final d lS;
    private final Region lT;
    private final Region lU;
    private final float[] lV;
    private final float[] lW;
    private e lX;
    public boolean lY;
    private boolean lZ;
    public float ma;
    private int mb;
    public Paint.Style mc;
    public ColorStateList md;
    private final Paint paint;
    private float scale;
    private int shadowColor;
    private int shadowRadius;
    private float strokeWidth;

    public c() {
        this(null);
    }

    public c(e eVar) {
        this.paint = new Paint();
        this.lO = new Matrix[4];
        this.lP = new Matrix[4];
        this.lQ = new d[4];
        this.gT = new Matrix();
        this.lR = new Path();
        this.ja = new PointF();
        this.lS = new d();
        this.lT = new Region();
        this.lU = new Region();
        this.lV = new float[2];
        this.lW = new float[2];
        this.lX = null;
        this.lY = false;
        this.lZ = false;
        this.ma = 1.0f;
        this.shadowColor = WebView.NIGHT_MODE_COLOR;
        this.mb = 5;
        this.shadowRadius = 10;
        this.alpha = 255;
        this.scale = 1.0f;
        this.strokeWidth = 0.0f;
        this.mc = Paint.Style.FILL_AND_STROKE;
        this.jk = PorterDuff.Mode.SRC_IN;
        this.md = null;
        this.lX = eVar;
        for (int i2 = 0; i2 < 4; i2++) {
            this.lO[i2] = new Matrix();
            this.lP[i2] = new Matrix();
            this.lQ[i2] = new d();
        }
    }

    @Override // android.support.v4.graphics.drawable.e
    public final void setTintList(ColorStateList colorStateList) {
        this.md = colorStateList;
        bJ();
        invalidateSelf();
    }

    @Override // android.support.v4.graphics.drawable.e
    public final void setTintMode(PorterDuff.Mode mode) {
        this.jk = mode;
        bJ();
        invalidateSelf();
    }

    @Override // android.support.v4.graphics.drawable.e
    public final void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setAlpha(int i2) {
        this.alpha = i2;
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        this.lT.set(bounds);
        b(bounds.width(), bounds.height(), this.lR);
        this.lU.setPath(this.lR, this.lT);
        this.lT.op(this.lU, Region.Op.DIFFERENCE);
        return this.lT;
    }

    public final void i(float f2) {
        this.ma = f2;
        invalidateSelf();
    }

    public final void draw(Canvas canvas) {
        this.paint.setColorFilter(this.ji);
        int alpha2 = this.paint.getAlpha();
        Paint paint2 = this.paint;
        int i2 = this.alpha;
        paint2.setAlpha(((i2 + (i2 >>> 7)) * alpha2) >>> 8);
        this.paint.setStrokeWidth(this.strokeWidth);
        this.paint.setStyle(this.mc);
        if (this.mb > 0 && this.lY) {
            this.paint.setShadowLayer((float) this.shadowRadius, 0.0f, (float) this.mb, this.shadowColor);
        }
        if (this.lX != null) {
            b(canvas.getWidth(), canvas.getHeight(), this.lR);
            canvas.drawPath(this.lR, this.paint);
        } else {
            canvas.drawRect(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), this.paint);
        }
        this.paint.setAlpha(alpha2);
    }

    private void a(int i2, int i3, Path path) {
        b bVar;
        path.rewind();
        if (this.lX != null) {
            for (int i4 = 0; i4 < 4; i4++) {
                a(i4, i2, i3, this.ja);
                a(((i4 - 1) + 4) % 4, i2, i3, this.ja);
                float f2 = this.ja.x;
                float f3 = this.ja.y;
                a((i4 + 1) % 4, i2, i3, this.ja);
                float f4 = this.ja.x;
                float f5 = this.ja.y;
                a(i4, i2, i3, this.ja);
                float f6 = this.ja.x;
                float f7 = this.ja.y;
                Math.atan2((double) (f3 - f7), (double) (f2 - f6));
                Math.atan2((double) (f5 - f7), (double) (f4 - f6));
                this.lO[i4].reset();
                this.lO[i4].setTranslate(this.ja.x, this.ja.y);
                this.lO[i4].preRotate((float) Math.toDegrees((double) (e(((i4 - 1) + 4) % 4, i2, i3) + 1.5707964f)));
                this.lV[0] = this.lQ[i4].mg;
                this.lV[1] = this.lQ[i4].mh;
                this.lO[i4].mapPoints(this.lV);
                float e2 = e(i4, i2, i3);
                this.lP[i4].reset();
                this.lP[i4].setTranslate(this.lV[0], this.lV[1]);
                this.lP[i4].preRotate((float) Math.toDegrees((double) e2));
            }
            for (int i5 = 0; i5 < 4; i5++) {
                this.lV[0] = this.lQ[i5].f30me;
                this.lV[1] = this.lQ[i5].mf;
                this.lO[i5].mapPoints(this.lV);
                if (i5 == 0) {
                    path.moveTo(this.lV[0], this.lV[1]);
                } else {
                    path.lineTo(this.lV[0], this.lV[1]);
                }
                this.lQ[i5].a(this.lO[i5], path);
                int i6 = (i5 + 1) % 4;
                this.lV[0] = this.lQ[i5].mg;
                this.lV[1] = this.lQ[i5].mh;
                this.lO[i5].mapPoints(this.lV);
                this.lW[0] = this.lQ[i6].f30me;
                this.lW[1] = this.lQ[i6].mf;
                this.lO[i6].mapPoints(this.lW);
                float hypot = (float) Math.hypot((double) (this.lV[0] - this.lW[0]), (double) (this.lV[1] - this.lW[1]));
                this.lS.bK();
                switch (i5) {
                    case 1:
                        bVar = this.lX.ms;
                        break;
                    case 2:
                        bVar = this.lX.mt;
                        break;
                    case 3:
                        bVar = this.lX.mu;
                        break;
                    default:
                        bVar = this.lX.mr;
                        break;
                }
                bVar.a(hypot, this.ma, this.lS);
                this.lS.a(this.lP[i5], path);
            }
            path.close();
        }
    }

    private static void a(int i2, int i3, int i4, PointF pointF) {
        switch (i2) {
            case 1:
                pointF.set((float) i3, 0.0f);
                return;
            case 2:
                pointF.set((float) i3, (float) i4);
                return;
            case 3:
                pointF.set(0.0f, (float) i4);
                return;
            default:
                pointF.set(0.0f, 0.0f);
                return;
        }
    }

    private float e(int i2, int i3, int i4) {
        a(i2, i3, i4, this.ja);
        float f2 = this.ja.x;
        float f3 = this.ja.y;
        a((i2 + 1) % 4, i3, i4, this.ja);
        return (float) Math.atan2((double) (this.ja.y - f3), (double) (this.ja.x - f2));
    }

    private void b(int i2, int i3, Path path) {
        a(i2, i3, path);
        if (this.scale != 1.0f) {
            this.gT.reset();
            this.gT.setScale(this.scale, this.scale, (float) (i2 / 2), (float) (i3 / 2));
            path.transform(this.gT);
        }
    }

    private void bJ() {
        if (this.md == null || this.jk == null) {
            this.ji = null;
            return;
        }
        int colorForState = this.md.getColorForState(getState(), 0);
        this.ji = new PorterDuffColorFilter(colorForState, this.jk);
        if (this.lZ) {
            this.shadowColor = colorForState;
        }
    }
}
