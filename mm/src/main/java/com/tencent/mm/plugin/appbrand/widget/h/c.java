package com.tencent.mm.plugin.appbrand.widget.h;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c extends ReplacementSpan {
    private final int backgroundColor;
    private final int paddingLeft;
    private final int paddingRight;
    private final int radius;
    private final String text;
    private final int textColor;
    private final float textSize;

    public c(String str, int i2, int i3, int i4, int i5, int i6, int i7) {
        AppMethodBeat.i(204434);
        this.textSize = (float) i4;
        this.text = str;
        this.textColor = i5;
        this.backgroundColor = i6;
        this.radius = i7;
        this.paddingLeft = i2;
        this.paddingRight = i3;
        AppMethodBeat.o(204434);
    }

    public final void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        AppMethodBeat.i(204436);
        paint.setTextSize(this.textSize);
        paint.setAntiAlias(true);
        RectF rectF = new RectF();
        rectF.left = (float) (((int) f2) + this.paddingLeft);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int max = Math.max(0, ((((i6 - i4) - fontMetricsInt.descent) + fontMetricsInt.top) / 2) - this.radius);
        rectF.top = (float) (i4 + max);
        rectF.bottom = (float) (i6 - max);
        rectF.right = rectF.left + ((float) ((int) paint.measureText(this.text))) + ((float) (this.radius * 2));
        paint.setColor(this.backgroundColor);
        canvas.drawRoundRect(rectF, (float) this.radius, (float) this.radius, paint);
        paint.setColor(this.textColor);
        canvas.drawText(this.text, rectF.left + ((float) this.radius), (rectF.top + ((float) this.radius)) - ((float) fontMetricsInt.top), paint);
        AppMethodBeat.o(204436);
    }

    public final int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        AppMethodBeat.i(204435);
        if (paint == null) {
            paint = new Paint();
        }
        paint.setTextSize(this.textSize);
        int measureText = ((int) paint.measureText(this.text)) + this.paddingLeft + this.paddingRight + (this.radius * 2);
        AppMethodBeat.o(204435);
        return measureText;
    }
}
