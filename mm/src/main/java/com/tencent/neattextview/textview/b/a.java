package com.tencent.neattextview.textview.b;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.layout.d;
import java.util.Iterator;
import java.util.List;

public final class a extends b<BackgroundColorSpan> {
    public a(int i2, int i3, CharacterStyle characterStyle) {
        super(i2, i3, characterStyle);
    }

    @Override // com.tencent.neattextview.textview.b.b
    public final void a(Canvas canvas, TextPaint textPaint, List<d> list) {
        AppMethodBeat.i(39743);
        kb(list);
        int color = textPaint.getColor();
        textPaint.setColor(((BackgroundColorSpan) this.RAM).getBackgroundColor());
        Iterator it = this.RAL.iterator();
        while (it.hasNext()) {
            canvas.drawRect((RectF) it.next(), textPaint);
        }
        textPaint.setColor(color);
        AppMethodBeat.o(39743);
    }
}
