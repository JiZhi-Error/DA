package com.tencent.mm.plugin.mv.ui.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class a extends ImageSpan {
    private WeakReference<Drawable> qTG;

    public a(Drawable drawable) {
        super(drawable);
    }

    public final int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        AppMethodBeat.i(256703);
        Rect bounds = ewj().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        int i4 = bounds.right;
        AppMethodBeat.o(256703);
        return i4;
    }

    public final void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        AppMethodBeat.i(256704);
        Drawable ewj = ewj();
        canvas.save();
        canvas.translate(f2, (float) ((i6 - ewj.getBounds().bottom) - (paint.getFontMetricsInt().descent / 2)));
        ewj.draw(canvas);
        canvas.restore();
        AppMethodBeat.o(256704);
    }

    private Drawable ewj() {
        AppMethodBeat.i(256705);
        WeakReference<Drawable> weakReference = this.qTG;
        Drawable drawable = null;
        if (weakReference != null) {
            drawable = weakReference.get();
        }
        if (drawable == null) {
            drawable = getDrawable();
            this.qTG = new WeakReference<>(drawable);
        }
        AppMethodBeat.o(256705);
        return drawable;
    }
}
