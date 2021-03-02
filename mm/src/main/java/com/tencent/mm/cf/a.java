package com.tencent.mm.cf;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends ReplacementSpan {
    private int NLq;

    public a(int i2) {
        this.NLq = i2;
    }

    public final int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        AppMethodBeat.i(152790);
        int measureText = (int) a(paint).measureText(charSequence.subSequence(i2, i3).toString());
        AppMethodBeat.o(152790);
        return measureText;
    }

    public final void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        AppMethodBeat.i(152791);
        CharSequence subSequence = charSequence.subSequence(i2, i3);
        TextPaint a2 = a(paint);
        Paint.FontMetricsInt fontMetricsInt = a2.getFontMetricsInt();
        canvas.drawText(subSequence.toString(), f2, (float) (i5 - (((fontMetricsInt.ascent + ((fontMetricsInt.descent + i5) + i5)) / 2) - ((i6 + i4) / 2))), a2);
        AppMethodBeat.o(152791);
    }

    private TextPaint a(Paint paint) {
        AppMethodBeat.i(152792);
        TextPaint textPaint = new TextPaint(paint);
        textPaint.setTextSize((float) this.NLq);
        AppMethodBeat.o(152792);
        return textPaint;
    }
}
