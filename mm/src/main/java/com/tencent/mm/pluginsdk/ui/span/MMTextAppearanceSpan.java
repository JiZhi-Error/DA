package com.tencent.mm.pluginsdk.ui.span;

import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.style.TextAppearanceSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;

public class MMTextAppearanceSpan extends TextAppearanceSpan {
    public int fontStyle = 0;

    public MMTextAppearanceSpan(int i2, ColorStateList colorStateList, ColorStateList colorStateList2) {
        super(null, 0, i2, colorStateList, colorStateList2);
    }

    public void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.i(152328);
        super.updateDrawState(textPaint);
        switch (this.fontStyle) {
            case 0:
                ao.a(textPaint, 0.1f);
                AppMethodBeat.o(152328);
                return;
            case 1:
                ao.a(textPaint, 0.8f);
                break;
        }
        AppMethodBeat.o(152328);
    }
}
