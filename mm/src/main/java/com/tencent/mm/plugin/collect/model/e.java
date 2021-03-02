package com.tencent.mm.plugin.collect.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class e {
    public static String a(Context context, long j2, int i2) {
        AppMethodBeat.i(63780);
        long j3 = 1000 * j2;
        if (i2 == 0) {
            String format = new SimpleDateFormat(context.getString(R.string.b61)).format(new Date(j3));
            AppMethodBeat.o(63780);
            return format;
        } else if (i2 == 1) {
            String format2 = new SimpleDateFormat(context.getString(R.string.b62)).format(new Date(j3));
            AppMethodBeat.o(63780);
            return format2;
        } else {
            String format3 = new SimpleDateFormat(context.getString(R.string.b63)).format(new Date(j3));
            AppMethodBeat.o(63780);
            return format3;
        }
    }

    public static String Fb(int i2) {
        AppMethodBeat.i(63781);
        String format = String.format("%.2f", Double.valueOf(((double) i2) / 100.0d));
        AppMethodBeat.o(63781);
        return format;
    }
}
