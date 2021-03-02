package com.tencent.mm.plugin.product.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.sdk.platformtools.Util;

public final class b {
    public static String C(int i2, int i3, String str) {
        AppMethodBeat.i(66854);
        if (i2 == i3) {
            String c2 = c((double) i2, str);
            AppMethodBeat.o(66854);
            return c2;
        }
        String format = String.format("%s~%s", c((double) i3, str), c((double) i2, str));
        AppMethodBeat.o(66854);
        return format;
    }

    public static String c(double d2, String str) {
        AppMethodBeat.i(66855);
        if ("CNY".equals(str) || "1".equals(str) || Util.isNullOrNil(str)) {
            String format = String.format("¥%.2f", Double.valueOf(d2 / 100.0d));
            AppMethodBeat.o(66855);
            return format;
        }
        String format2 = String.format("%s%.2f", str, Double.valueOf(d2 / 100.0d));
        AppMethodBeat.o(66855);
        return format2;
    }

    public static String a(Context context, akg akg) {
        AppMethodBeat.i(66856);
        if (akg.KZx > 0) {
            String str = akg.Name + " " + c((double) akg.KZx, akg.PriceType);
            AppMethodBeat.o(66856);
            return str;
        }
        String string = context.getString(R.string.exf);
        AppMethodBeat.o(66856);
        return string;
    }
}
