package com.tencent.mm.ui.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class a extends ImageSpan implements com.tencent.mm.ui.base.span.a {
    public int QBM = 0;
    private boolean isPressed = false;

    public a(Drawable drawable, int i2) {
        super(drawable, 1);
    }

    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        AppMethodBeat.i(143318);
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i4 = fontMetricsInt2.descent - fontMetricsInt2.ascent;
            int i5 = bounds.bottom - bounds.top;
            int i6 = fontMetricsInt2.ascent + (i4 / 2);
            fontMetricsInt.ascent = i6 - (i5 / 2);
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = i6 + (i5 / 2);
            fontMetricsInt.descent = fontMetricsInt.bottom;
        }
        int i7 = bounds.right;
        AppMethodBeat.o(143318);
        return i7;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        AppMethodBeat.i(143319);
        Drawable drawable = getDrawable();
        canvas.save();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        canvas.translate(f2, (float) (((fontMetricsInt.descent + i5) - ((fontMetricsInt.descent - fontMetricsInt.ascent) / 2)) - ((drawable.getBounds().bottom - drawable.getBounds().top) / 2)));
        int alpha = paint.getAlpha();
        int alpha2 = drawable.getAlpha();
        if (alpha == 0 && alpha2 != alpha) {
            drawable.setAlpha(alpha);
        }
        drawable.draw(canvas);
        drawable.setAlpha(alpha2);
        canvas.restore();
        AppMethodBeat.o(143319);
    }

    public void onClick(View view) {
        AppMethodBeat.i(259389);
        Log.i("MicroMsg.FixImageSpan", "onClick view:%d", Integer.valueOf(view.hashCode()));
        AppMethodBeat.o(259389);
    }

    @Override // com.tencent.mm.ui.base.span.a
    public void setIsPressed(boolean z) {
        this.isPressed = z;
    }
}
