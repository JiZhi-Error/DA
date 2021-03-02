package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d implements LeadingMarginSpan, f<Boolean>, g<Boolean> {
    private static Path qTc = null;
    private final int qTd;
    public boolean qTe;

    public d(int i2, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(30631);
        this.qTd = i2;
        this.qTe = z && z3 && !z2;
        if (qTc == null) {
            qTc = new Path();
        }
        AppMethodBeat.o(30631);
    }

    private d(int i2, boolean z) {
        this.qTd = i2;
        this.qTe = z;
    }

    public final int getLeadingMargin(boolean z) {
        if (this.qTe) {
            return 0;
        }
        return this.qTd;
    }

    public final void drawLeadingMargin(Canvas canvas, Paint paint, int i2, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7, int i8, boolean z, Layout layout) {
        AppMethodBeat.i(30632);
        Spanned spanned = (Spanned) charSequence;
        if (!this.qTe && spanned.getSpanStart(this) == i7) {
            Paint.Style style = paint.getStyle();
            paint.setStyle(Paint.Style.FILL);
            qTc.reset();
            qTc.addCircle(0.0f, 0.0f, 6.0f, Path.Direction.CW);
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i9 = fontMetricsInt.ascent;
            canvas.save();
            canvas.translate((float) ((i3 * 6) + i2), (float) ((i9 + ((fontMetricsInt.descent + i5) + i5)) / 2));
            canvas.drawPath(qTc, paint);
            canvas.restore();
            paint.setStyle(style);
        }
        AppMethodBeat.o(30632);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.g
    public final /* bridge */ /* synthetic */ Boolean getValue() {
        return Boolean.TRUE;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.wenote.model.nativenote.spans.f' to match base method */
    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.f
    public final /* synthetic */ f<Boolean> gjZ() {
        AppMethodBeat.i(30633);
        d dVar = new d(this.qTd, this.qTe);
        AppMethodBeat.o(30633);
        return dVar;
    }
}
