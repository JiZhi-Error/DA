package com.tencent.mm.plugin.game.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
    public static HashMap<Long, Long> pMp = new HashMap<>();
    public static HashMap<Long, String> pMq = new HashMap<>();
    private static Map<String, List<String>> vVB = new HashMap();
    private static Map<String, List<String>> vVC = new HashMap();

    static {
        AppMethodBeat.i(42491);
        AppMethodBeat.o(42491);
    }

    public static String n(Context context, long j2) {
        AppMethodBeat.i(42490);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j2 < Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(42490);
            return "";
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        if (pMp.containsKey(Long.valueOf(j2))) {
            if (timeInMillis - pMp.get(Long.valueOf(j2)).longValue() >= Util.MILLSECONDS_OF_MINUTE) {
                pMp.remove(Long.valueOf(j2));
            } else if (pMq.containsKey(Long.valueOf(j2))) {
                String str = pMq.get(Long.valueOf(j2));
                AppMethodBeat.o(42490);
                return str;
            }
        }
        if (timeInMillis - j2 < Util.MILLSECONDS_OF_MINUTE) {
            String string = context.getString(R.string.dpg);
            AppMethodBeat.o(42490);
            return string;
        } else if ((timeInMillis - j2) / Util.MILLSECONDS_OF_HOUR == 0) {
            int i2 = (int) ((timeInMillis - j2) / Util.MILLSECONDS_OF_MINUTE);
            if (i2 <= 0) {
                i2 = 1;
            }
            String quantityString = context.getResources().getQuantityString(R.plurals.k, i2, Integer.valueOf(i2));
            pMq.put(Long.valueOf(j2), quantityString);
            pMp.put(Long.valueOf(j2), Long.valueOf(timeInMillis));
            AppMethodBeat.o(42490);
            return quantityString;
        } else {
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
            long timeInMillis2 = j2 - gregorianCalendar2.getTimeInMillis();
            if (timeInMillis2 <= 0 || timeInMillis2 > Util.MILLSECONDS_OF_DAY) {
                long timeInMillis3 = (j2 - gregorianCalendar2.getTimeInMillis()) + Util.MILLSECONDS_OF_DAY;
                if (timeInMillis3 <= 0 || timeInMillis3 > Util.MILLSECONDS_OF_DAY) {
                    int timeInMillis4 = (int) (((gregorianCalendar2.getTimeInMillis() + Util.MILLSECONDS_OF_DAY) - j2) / Util.MILLSECONDS_OF_DAY);
                    if (timeInMillis4 <= 0) {
                        timeInMillis4 = 1;
                    }
                    String quantityString2 = context.getResources().getQuantityString(R.plurals.l, timeInMillis4, Integer.valueOf(timeInMillis4));
                    pMq.put(Long.valueOf(j2), quantityString2);
                    pMp.put(Long.valueOf(j2), Long.valueOf(timeInMillis));
                    AppMethodBeat.o(42490);
                    return quantityString2;
                }
                String string2 = context.getString(R.string.dfu);
                pMq.put(Long.valueOf(j2), string2);
                pMp.put(Long.valueOf(j2), Long.valueOf(timeInMillis));
                AppMethodBeat.o(42490);
                return string2;
            }
            int i3 = (int) ((timeInMillis - j2) / Util.MILLSECONDS_OF_HOUR);
            if (i3 <= 0) {
                i3 = 1;
            }
            String quantityString3 = context.getResources().getQuantityString(R.plurals.f3143j, i3, Integer.valueOf(i3));
            pMq.put(Long.valueOf(j2), quantityString3);
            pMp.put(Long.valueOf(j2), Long.valueOf(timeInMillis));
            AppMethodBeat.o(42490);
            return quantityString3;
        }
    }
}
