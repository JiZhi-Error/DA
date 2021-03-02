package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class k implements LeadingMarginSpan, g<Boolean>, h<Boolean> {
    public static float qTi = 0.0f;
    private float gPN = 10.0f;
    private float mWidth;
    private final int qTd;
    public boolean qTe;
    private final int qTh;

    public k(int i2, int i3, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(181942);
        this.qTh = i2;
        this.qTd = i3;
        this.qTe = z && z3 && !z2;
        AppMethodBeat.o(181942);
    }

    private k(int i2, int i3, boolean z) {
        this.qTh = i2;
        this.qTd = i3;
        this.qTe = z;
    }

    public int getLeadingMargin(boolean z) {
        AppMethodBeat.i(181943);
        qTi = (float) Math.max(Math.round(this.mWidth + 2.0f > qTi ? this.mWidth + 2.0f : qTi), this.qTd);
        if (this.qTe) {
            AppMethodBeat.o(181943);
            return 0;
        }
        int i2 = (int) qTi;
        AppMethodBeat.o(181943);
        return i2;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i2, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7, int i8, boolean z, Layout layout) {
        AppMethodBeat.i(181944);
        Spanned spanned = (Spanned) charSequence;
        if (!this.qTe && spanned.getSpanStart(this) == i7) {
            Paint.Style style = paint.getStyle();
            float textSize = paint.getTextSize();
            paint.setStyle(Paint.Style.FILL);
            this.gPN = (float) (i5 - i4);
            this.mWidth = paint.measureText(this.qTh + ".");
            canvas.drawText(this.qTh + ".", (float) i2, (float) i5, paint);
            paint.setStyle(style);
            paint.setTextSize(textSize);
        }
        AppMethodBeat.o(181944);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.h
    public final /* bridge */ /* synthetic */ Boolean getValue() {
        return Boolean.TRUE;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.editor.model.nativenote.spans.g' to match base method */
    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.g
    public final /* synthetic */ g<Boolean> cEu() {
        AppMethodBeat.i(181945);
        k kVar = new k(this.qTh, this.qTd, this.qTe);
        AppMethodBeat.o(181945);
        return kVar;
    }
}
