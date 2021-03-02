package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.d.c;
import com.tencent.mm.plugin.appbrand.widget.input.d.g;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.sdk.platformtools.Log;

/* access modifiers changed from: package-private */
public enum b {
    ;

    public static b valueOf(String str) {
        AppMethodBeat.i(136305);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(136305);
        return bVar;
    }

    static <Input extends EditText & ab> void a(Input input, h hVar) {
        Typeface create;
        AppMethodBeat.i(136306);
        if (input == null || hVar == null) {
            AppMethodBeat.o(136306);
            return;
        }
        if (!(hVar.oxS == null || hVar.oxS.floatValue() == input.getTextSize())) {
            input.setTextSize(hVar.oxS.floatValue());
        }
        if (hVar.oxR != null) {
            input.setTextColor(hVar.oxR.intValue());
        }
        if (hVar.oxQ == null) {
            input.setBackground(null);
        } else if (input.getBackground() == null || !(input.getBackground() instanceof ColorDrawable) || ((ColorDrawable) input.getBackground()).getColor() != hVar.oxQ.intValue()) {
            input.setBackground(new ColorDrawable(hVar.oxQ.intValue()));
        }
        if (hVar.oxU != null) {
            if (TextUtils.isEmpty(hVar.oxU)) {
                input.setHint("");
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(hVar.oxU);
                int length = hVar.oxU.length();
                spannableStringBuilder.setSpan(new StyleSpan(c.agb(hVar.oxV).style), 0, length, 18);
                if (hVar.oxX != null) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(hVar.oxX.intValue()), 0, length, 18);
                }
                if (hVar.oxW != null) {
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(hVar.oxW.intValue(), false), 0, length, 18);
                }
                input.setHint(spannableStringBuilder);
            }
        }
        if (!(hVar.cNw == null || (create = Typeface.create("sans-serif", c.agb(hVar.cNw).style)) == null)) {
            input.setTypeface(create);
        }
        g agc = g.agc(hVar.kZR);
        Input input2 = input;
        if (input2 != null) {
            switch (agc) {
                case LEFT:
                    input2.cbQ();
                    break;
                case RIGHT:
                    input2.cbR();
                    break;
                case CENTER:
                    input2.cbS();
                    break;
            }
        }
        input.setVisibility(aj.i(hVar.oxZ) ? 8 : 0);
        input.setFixed(aj.i(hVar.oyd));
        AppMethodBeat.o(136306);
    }

    static <Input extends EditText & ab> void a(Input input, int i2, int i3) {
        int length;
        int length2;
        AppMethodBeat.i(136307);
        if (input == null || input.getEditableText() == null) {
            Log.w("MicroMsg.AppBrandInputCommStyleHelper", "applySelection, invalid input %s", input);
            AppMethodBeat.o(136307);
            return;
        }
        if (i2 <= -2) {
            length = input.getSelectionStart();
        } else if (i2 == -1 || i2 > input.getText().length()) {
            length = input.getText().length();
        } else {
            length = i2;
        }
        if (i3 <= -2) {
            length2 = input.getSelectionEnd();
        } else {
            length2 = (i3 == -1 || i3 > input.getText().length()) ? input.getText().length() : i3;
        }
        if (length > length2) {
            length = length2;
        }
        Selection.removeSelection(input.getEditableText());
        input.setSelection(length, length2);
        AppMethodBeat.o(136307);
    }
}
