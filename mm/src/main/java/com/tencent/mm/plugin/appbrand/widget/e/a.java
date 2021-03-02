package com.tencent.mm.plugin.appbrand.widget.e;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a extends Drawable {
    private Paint borderPaint;
    float borderRadius = 0.0f;
    private final RectF cuN = new RectF();
    private Path oyr;
    private Path oys;
    private int oyt = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 3);
    private int oyu = this.oyt;
    private Paint paint = new Paint(1);
    private int rc = 0;

    public a() {
        AppMethodBeat.i(146565);
        this.paint.setStyle(Paint.Style.FILL);
        this.borderPaint = new Paint(1);
        this.borderPaint.setStyle(Paint.Style.FILL);
        this.oyr = new Path();
        this.oys = new Path();
        AppMethodBeat.o(146565);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(146566);
        float width = this.cuN.width();
        float height = this.cuN.height();
        float f2 = this.cuN.left;
        float f3 = this.cuN.top;
        float f4 = this.cuN.right;
        float f5 = this.cuN.bottom;
        float min = Math.min(this.borderRadius, Math.min(width, height) * 0.5f);
        canvas.drawRoundRect(new RectF(((float) this.oyu) + f2, ((float) this.oyu) + f3, f4 - ((float) this.oyu), f5 - ((float) this.oyu)), min, min, this.borderPaint);
        canvas.drawPath(this.oys, this.borderPaint);
        canvas.drawRoundRect(new RectF(f2 + ((float) this.oyu) + ((float) this.rc), f3 + ((float) this.oyu) + ((float) this.rc), (f4 - ((float) this.oyu)) - ((float) this.rc), (f5 - ((float) this.oyu)) - ((float) this.rc)), min, min, this.paint);
        canvas.drawPath(this.oyr, this.paint);
        AppMethodBeat.o(146566);
    }

    public final void setBounds(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(146567);
        super.setBounds(i2, i3, i4, i5);
        this.cuN.set((float) i2, (float) i3, (float) i4, (float) i5);
        float f2 = ((float) (i2 + i4)) / 2.0f;
        this.oys.moveTo(f2, (float) i5);
        this.oys.lineTo(f2 - ((float) this.oyu), (float) (i5 - this.oyu));
        this.oys.lineTo(((float) this.oyu) + f2, (float) (i5 - this.oyu));
        this.oys.close();
        this.oyr.moveTo(f2, (float) (i5 - this.rc));
        this.oyr.lineTo(f2 - ((float) this.oyu), (float) ((i5 - this.oyu) - this.rc));
        this.oyr.lineTo(f2 + ((float) this.oyu), (float) ((i5 - this.oyu) - this.rc));
        this.oyr.close();
        AppMethodBeat.o(146567);
    }

    public final void setAlpha(int i2) {
        AppMethodBeat.i(146568);
        this.paint.setAlpha(i2);
        this.borderPaint.setAlpha(i2);
        AppMethodBeat.o(146568);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.i(146569);
        this.paint.setColorFilter(colorFilter);
        this.borderPaint.setColorFilter(colorFilter);
        AppMethodBeat.o(146569);
    }

    public final void setColor(int i2) {
        AppMethodBeat.i(146570);
        this.paint.setColor(i2);
        AppMethodBeat.o(146570);
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setStroke(int i2, int i3) {
        AppMethodBeat.i(146571);
        this.rc = i2;
        this.oyu = (i2 / 3) + this.oyt;
        this.borderPaint.setColor(i3);
        AppMethodBeat.o(146571);
    }
}
