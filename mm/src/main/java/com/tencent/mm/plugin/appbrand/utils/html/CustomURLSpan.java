package com.tencent.mm.plugin.appbrand.utils.html;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.html.c;

public class CustomURLSpan extends URLSpan {
    private String mUrl;
    private c.a ohX;
    private boolean ohY;

    public CustomURLSpan(String str, c.a aVar, boolean z) {
        super(str);
        this.mUrl = str;
        this.ohX = aVar;
        this.ohY = z;
    }

    public void onClick(View view) {
        AppMethodBeat.i(147727);
        if (this.ohX == null) {
            AppMethodBeat.o(147727);
            return;
        }
        this.ohX.YF(this.mUrl);
        AppMethodBeat.o(147727);
    }

    public void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.i(147728);
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(this.ohY);
        AppMethodBeat.o(147728);
    }
}
