package com.tencent.neattextview.textview.b;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.layout.d;
import java.util.Iterator;
import java.util.List;

public class c extends b<ClickableSpan> {
    public boolean isPressed;

    public c(int i2, int i3, ClickableSpan clickableSpan) {
        super(i2, i3, clickableSpan);
    }

    @Override // com.tencent.neattextview.textview.b.b
    public final void a(Canvas canvas, TextPaint textPaint, List<d> list) {
        AppMethodBeat.i(39744);
        kb(list);
        if (this.isPressed) {
            int color = textPaint.getColor();
            int i2 = textPaint.bgColor;
            boolean isUnderlineText = textPaint.isUnderlineText();
            ((ClickableSpan) this.RAM).updateDrawState(textPaint);
            textPaint.setColor(textPaint.bgColor);
            Iterator it = this.RAL.iterator();
            while (it.hasNext()) {
                canvas.drawRect((RectF) it.next(), textPaint);
            }
            textPaint.setColor(color);
            textPaint.setUnderlineText(isUnderlineText);
            textPaint.bgColor = i2;
            this.isPressed = false;
        }
        AppMethodBeat.o(39744);
    }
}
