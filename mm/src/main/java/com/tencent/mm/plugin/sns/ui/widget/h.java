package com.tencent.mm.plugin.sns.ui.widget;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.a;

public final class h extends a {
    public h(Drawable drawable) {
        super(drawable, 1);
    }

    @Override // com.tencent.mm.ui.widget.a
    public final int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        AppMethodBeat.i(100564);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4) + super.getSize(paint, charSequence, i2, i3, fontMetricsInt);
        AppMethodBeat.o(100564);
        return fromDPToPix;
    }
}
