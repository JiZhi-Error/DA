package com.robinhood.ticker;

import android.graphics.Paint;
import com.robinhood.ticker.TickerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class f {
    float cgK;
    private final Paint cgU;
    private final Map<Character, Float> cgV = new HashMap(256);
    float cgW;
    TickerView.a cgX = TickerView.a.ANY;

    f(Paint paint) {
        AppMethodBeat.i(39856);
        this.cgU = paint;
        invalidate();
        AppMethodBeat.o(39856);
    }

    /* access modifiers changed from: package-private */
    public final void invalidate() {
        AppMethodBeat.i(39857);
        this.cgV.clear();
        Paint.FontMetrics fontMetrics = this.cgU.getFontMetrics();
        this.cgK = fontMetrics.bottom - fontMetrics.top;
        this.cgW = -fontMetrics.top;
        AppMethodBeat.o(39857);
    }

    /* access modifiers changed from: package-private */
    public final float r(char c2) {
        AppMethodBeat.i(39858);
        if (c2 == 0) {
            AppMethodBeat.o(39858);
            return 0.0f;
        }
        Float f2 = this.cgV.get(Character.valueOf(c2));
        if (f2 != null) {
            float floatValue = f2.floatValue();
            AppMethodBeat.o(39858);
            return floatValue;
        }
        float measureText = this.cgU.measureText(Character.toString(c2));
        this.cgV.put(Character.valueOf(c2), Float.valueOf(measureText));
        AppMethodBeat.o(39858);
        return measureText;
    }
}
