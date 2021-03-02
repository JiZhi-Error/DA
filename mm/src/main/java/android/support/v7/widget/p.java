package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.widget.ao;

/* access modifiers changed from: package-private */
public class p implements r {
    final RectF alV = new RectF();

    p() {
    }

    @Override // android.support.v7.widget.r
    public void initStatic() {
        ao.auT = new ao.a() {
            /* class android.support.v7.widget.p.AnonymousClass1 */

            @Override // android.support.v7.widget.ao.a
            public final void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
                float f3 = 2.0f * f2;
                float width = (rectF.width() - f3) - 1.0f;
                float height = (rectF.height() - f3) - 1.0f;
                if (f2 >= 1.0f) {
                    float f4 = f2 + 0.5f;
                    p.this.alV.set(-f4, -f4, f4, f4);
                    int save = canvas.save();
                    canvas.translate(rectF.left + f4, rectF.top + f4);
                    canvas.drawArc(p.this.alV, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(p.this.alV, 180.0f, 90.0f, true, paint);
                    canvas.translate(height, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(p.this.alV, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(p.this.alV, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(save);
                    canvas.drawRect((rectF.left + f4) - 1.0f, rectF.top, 1.0f + (rectF.right - f4), rectF.top + f4, paint);
                    canvas.drawRect((rectF.left + f4) - 1.0f, rectF.bottom - f4, 1.0f + (rectF.right - f4), rectF.bottom, paint);
                }
                canvas.drawRect(rectF.left, rectF.top + f2, rectF.right, rectF.bottom - f2, paint);
            }
        };
    }

    @Override // android.support.v7.widget.r
    public final void f(q qVar) {
        Rect rect = new Rect();
        k(qVar).getPadding(rect);
        qVar.R((int) Math.ceil((double) k(qVar).getMinWidth()), (int) Math.ceil((double) k(qVar).getMinHeight()));
        qVar.e(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // android.support.v7.widget.r
    public final void g(q qVar) {
    }

    @Override // android.support.v7.widget.r
    public final void h(q qVar) {
        k(qVar).aw(qVar.getPreventCornerOverlap());
        f(qVar);
    }

    @Override // android.support.v7.widget.r
    public final void a(q qVar, ColorStateList colorStateList) {
        ao k = k(qVar);
        k.g(colorStateList);
        k.invalidateSelf();
    }

    @Override // android.support.v7.widget.r
    public final ColorStateList i(q qVar) {
        return k(qVar).auR;
    }

    @Override // android.support.v7.widget.r
    public final void a(q qVar, float f2) {
        ao k = k(qVar);
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f2 + ". Must be >= 0");
        }
        float f3 = (float) ((int) (0.5f + f2));
        if (k.Kx != f3) {
            k.Kx = f3;
            k.avb = true;
            k.invalidateSelf();
        }
        f(qVar);
    }

    @Override // android.support.v7.widget.r
    public final float d(q qVar) {
        return k(qVar).Kx;
    }

    @Override // android.support.v7.widget.r
    public final void c(q qVar, float f2) {
        ao k = k(qVar);
        k.f(f2, k.auY);
    }

    @Override // android.support.v7.widget.r
    public final float e(q qVar) {
        return k(qVar).ava;
    }

    @Override // android.support.v7.widget.r
    public final void b(q qVar, float f2) {
        ao k = k(qVar);
        k.f(k.ava, f2);
        f(qVar);
    }

    @Override // android.support.v7.widget.r
    public final float a(q qVar) {
        return k(qVar).auY;
    }

    @Override // android.support.v7.widget.r
    public final float b(q qVar) {
        return k(qVar).getMinWidth();
    }

    @Override // android.support.v7.widget.r
    public final float c(q qVar) {
        return k(qVar).getMinHeight();
    }

    private static ao k(q qVar) {
        return (ao) qVar.jy();
    }

    @Override // android.support.v7.widget.r
    public final void a(q qVar, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        ao aoVar = new ao(context.getResources(), colorStateList, f2, f3, f4);
        aoVar.aw(qVar.getPreventCornerOverlap());
        qVar.q(aoVar);
        f(qVar);
    }
}
