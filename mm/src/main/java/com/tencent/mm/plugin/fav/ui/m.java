package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.GregorianCalendar;

public final class m {
    public static CharSequence J(Context context, int i2) {
        AppMethodBeat.i(106935);
        if (i2 <= 0) {
            String string = context.getString(R.string.cc3, 0, 0);
            AppMethodBeat.o(106935);
            return string;
        }
        String string2 = context.getString(R.string.cc3, Integer.valueOf(i2 / 60), Integer.valueOf(i2 % 60));
        AppMethodBeat.o(106935);
        return string2;
    }

    public static CharSequence h(Context context, long j2) {
        AppMethodBeat.i(106936);
        if (j2 < Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(106936);
            return "";
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j2 - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis <= 0 || timeInMillis > Util.MILLSECONDS_OF_DAY) {
            long timeInMillis2 = gregorianCalendar2.getTimeInMillis() - j2;
            if (timeInMillis2 <= 0 || timeInMillis2 > Util.MILLSECONDS_OF_DAY) {
                new GregorianCalendar().setTimeInMillis(j2);
                int timeInMillis3 = (int) ((gregorianCalendar.getTimeInMillis() - j2) / Util.MILLSECONDS_OF_DAY);
                if (timeInMillis3 <= 0) {
                    timeInMillis3 = 1;
                }
                if (timeInMillis3 > 30) {
                    CharSequence format = DateFormat.format(context.getString(R.string.ca5), j2);
                    AppMethodBeat.o(106936);
                    return format;
                }
                String quantityString = context.getResources().getQuantityString(R.plurals.l, timeInMillis3, Integer.valueOf(timeInMillis3));
                AppMethodBeat.o(106936);
                return quantityString;
            }
            String string = context.getString(R.string.dfu);
            AppMethodBeat.o(106936);
            return string;
        }
        String string2 = context.getString(R.string.dfl);
        AppMethodBeat.o(106936);
        return string2;
    }
}
