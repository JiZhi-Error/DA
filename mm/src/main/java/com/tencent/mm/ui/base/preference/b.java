package com.tencent.mm.ui.base.preference;

import android.widget.RadioButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class b {
    int id;
    CharSequence text;

    public b(CharSequence charSequence, int i2) {
        this.text = charSequence;
        this.id = i2;
    }

    public final void a(RadioButton radioButton) {
        AppMethodBeat.i(142521);
        radioButton.setText(this.text);
        radioButton.setId(this.id);
        AppMethodBeat.o(142521);
    }
}
