package com.tencent.mm.plugin.finder.view;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.h.a;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J8\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/LineHeightStandard;", "Landroid/text/style/LineHeightSpan;", "height", "", "(I)V", "getHeight", "()I", "chooseHeight", "", "text", "", "start", "end", "spanstartv", "lineHeight", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "plugin-finder_release"})
public final class q implements LineHeightSpan {
    private final int height;

    public q(int i2) {
        this.height = i2;
    }

    public final void chooseHeight(CharSequence charSequence, int i2, int i3, int i4, int i5, Paint.FontMetricsInt fontMetricsInt) {
        AppMethodBeat.i(255045);
        p.h(charSequence, "text");
        p.h(fontMetricsInt, "fm");
        int i6 = fontMetricsInt.descent - fontMetricsInt.ascent;
        if (i6 <= 0) {
            AppMethodBeat.o(255045);
            return;
        }
        fontMetricsInt.descent = a.cR(((((float) this.height) * 1.0f) / ((float) i6)) * ((float) fontMetricsInt.descent));
        fontMetricsInt.ascent = fontMetricsInt.descent - this.height;
        AppMethodBeat.o(255045);
    }
}
