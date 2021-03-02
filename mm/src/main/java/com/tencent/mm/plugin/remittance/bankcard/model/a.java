package com.tencent.mm.plugin.remittance.bankcard.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigDecimal;

public final class a {
    public static long jI(String str, String str2) {
        AppMethodBeat.i(67394);
        try {
            long longValue = new BigDecimal(Util.getDouble(str.trim(), 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str.trim()).divide(new BigDecimal(str2.trim()), 0, 4).longValue();
            AppMethodBeat.o(67394);
            return longValue;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BankRemitUtil", e2, "", new Object[0]);
            AppMethodBeat.o(67394);
            return 0;
        }
    }

    public static double jJ(String str, String str2) {
        double d2 = 0.0d;
        AppMethodBeat.i(67395);
        try {
            d2 = new BigDecimal(Util.getDouble(str.trim(), 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str.trim()).divide(new BigDecimal(str2.trim()), 2, 4).doubleValue();
            AppMethodBeat.o(67395);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BankRemitUtil", e2, "", new Object[0]);
            AppMethodBeat.o(67395);
        }
        return d2;
    }

    public static double jK(String str, String str2) {
        double d2 = 0.0d;
        AppMethodBeat.i(67396);
        try {
            double d3 = Util.getDouble(str, 0.0d);
            double d4 = Util.getDouble(str2, 0.0d);
            if (d3 == 0.0d) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            if (d4 == 0.0d) {
                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            d2 = bigDecimal.multiply(new BigDecimal(str2)).doubleValue();
            AppMethodBeat.o(67396);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BankRemitUtil", e2, "", new Object[0]);
            AppMethodBeat.o(67396);
        }
        return d2;
    }

    public static double VX(int i2) {
        AppMethodBeat.i(67397);
        double jJ = jJ(String.valueOf(i2), "100");
        AppMethodBeat.o(67397);
        return jJ;
    }

    public static char aLU(String str) {
        AppMethodBeat.i(67398);
        String x = SpellMap.x(str.charAt(0));
        Log.d("MicroMsg.BankRemitUtil", "pinyin: %s", x);
        if (!Util.isNullOrNil(x)) {
            char charAt = x.toUpperCase().charAt(0);
            AppMethodBeat.o(67398);
            return charAt;
        }
        AppMethodBeat.o(67398);
        return '#';
    }
}
