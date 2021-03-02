package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.ao;

final class n extends p {
    n() {
    }

    @Override // android.support.v7.widget.p, android.support.v7.widget.r
    public final void initStatic() {
        ao.auT = new ao.a() {
            /* class android.support.v7.widget.n.AnonymousClass1 */

            @Override // android.support.v7.widget.ao.a
            public final void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
                canvas.drawRoundRect(rectF, f2, f2, paint);
            }
        };
    }
}
