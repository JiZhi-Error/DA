package com.tencent.mm.plugin.wallet_core.utils;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TextAppearanceSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WcPayTextApppearanceSpan extends TextAppearanceSpan {
    public Typeface IoX;

    public WcPayTextApppearanceSpan(int i2, ColorStateList colorStateList) {
        super(null, 0, i2, colorStateList, null);
    }

    public void updateMeasureState(TextPaint textPaint) {
        AppMethodBeat.i(71650);
        super.updateMeasureState(textPaint);
        if (this.IoX != null) {
            textPaint.setTypeface(this.IoX);
        }
        AppMethodBeat.o(71650);
    }
}
