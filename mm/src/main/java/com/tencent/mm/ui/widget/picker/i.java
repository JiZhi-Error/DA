package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Formatter;
import java.util.Locale;

/* access modifiers changed from: package-private */
public final class i implements NumberPicker.Formatter {
    final Object[] QTB = new Object[1];
    char QTC;
    Formatter QTD;
    final StringBuilder mBuilder = new StringBuilder();

    i() {
        AppMethodBeat.i(159590);
        d(Locale.getDefault());
        AppMethodBeat.o(159590);
    }

    private void d(Locale locale) {
        AppMethodBeat.i(159591);
        this.QTD = e(locale);
        this.QTC = '0';
        AppMethodBeat.o(159591);
    }

    public final String format(int i2) {
        AppMethodBeat.i(159592);
        Locale locale = Locale.getDefault();
        if (this.QTC != '0') {
            d(locale);
        }
        this.QTB[0] = Integer.valueOf(i2);
        this.mBuilder.delete(0, this.mBuilder.length());
        this.QTD.format("%02d", this.QTB);
        String formatter = this.QTD.toString();
        AppMethodBeat.o(159592);
        return formatter;
    }

    private Formatter e(Locale locale) {
        AppMethodBeat.i(159593);
        Formatter formatter = new Formatter(this.mBuilder, locale);
        AppMethodBeat.o(159593);
        return formatter;
    }
}
