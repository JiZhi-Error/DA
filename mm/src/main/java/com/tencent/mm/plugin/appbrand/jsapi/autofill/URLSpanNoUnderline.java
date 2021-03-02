package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.text.TextPaint;
import android.text.style.URLSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class URLSpanNoUnderline extends URLSpan {
    public URLSpanNoUnderline(String str) {
        super(str);
    }

    public void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.i(229901);
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
        AppMethodBeat.o(229901);
    }
}
