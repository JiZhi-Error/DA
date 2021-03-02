package com.tencent.mm.ui.base.span;

import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;

public class BoldForegroundColorSpan extends ForegroundColorSpan {
    public BoldForegroundColorSpan(int i2) {
        super(i2);
    }

    public void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.i(205306);
        super.updateDrawState(textPaint);
        ao.a(textPaint, 0.8f);
        AppMethodBeat.o(205306);
    }
}
