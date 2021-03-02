package com.tencent.mm.plugin.brandservice.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.GregorianCalendar;
import java.util.HashMap;

public final class b {
    private static HashMap<Long, Long> pMp = new HashMap<>();
    private static HashMap<Long, String> pMq = new HashMap<>();

    public static synchronized void clean() {
        synchronized (b.class) {
            AppMethodBeat.i(6236);
            pMp.clear();
            pMq.clear();
            AppMethodBeat.o(6236);
        }
    }

    static {
        AppMethodBeat.i(6238);
        AppMethodBeat.o(6238);
    }

    public static synchronized String f(Context context, long j2) {
        String quantityString;
        synchronized (b.class) {
            AppMethodBeat.i(6237);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j2 < Util.MILLSECONDS_OF_HOUR) {
                quantityString = "";
                AppMethodBeat.o(6237);
            } else {
                long timeInMillis = gregorianCalendar.getTimeInMillis();
                if (pMp.containsKey(Long.valueOf(j2))) {
                    if (timeInMillis - pMp.get(Long.valueOf(j2)).longValue() >= Util.MILLSECONDS_OF_MINUTE) {
                        pMp.remove(Long.valueOf(j2));
                    } else if (pMq.containsKey(Long.valueOf(j2))) {
                        quantityString = pMq.get(Long.valueOf(j2));
                        AppMethodBeat.o(6237);
                    }
                }
                if ((timeInMillis - j2) / Util.MILLSECONDS_OF_HOUR == 0) {
                    int i2 = (int) ((timeInMillis - j2) / Util.MILLSECONDS_OF_MINUTE);
                    if (i2 <= 0) {
                        i2 = 1;
                    }
                    quantityString = context.getResources().getQuantityString(R.plurals.k, i2, Integer.valueOf(i2));
                    pMq.put(Long.valueOf(j2), quantityString);
                    pMp.put(Long.valueOf(j2), Long.valueOf(timeInMillis));
                    AppMethodBeat.o(6237);
                } else {
                    long timeInMillis2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
                    long j3 = j2 - timeInMillis2;
                    if (j3 <= 0 || j3 > Util.MILLSECONDS_OF_DAY) {
                        long j4 = (j2 - timeInMillis2) + Util.MILLSECONDS_OF_DAY;
                        if (j4 <= 0 || j4 > Util.MILLSECONDS_OF_DAY) {
                            int i3 = (int) (((timeInMillis2 + Util.MILLSECONDS_OF_DAY) - j2) / Util.MILLSECONDS_OF_DAY);
                            if (i3 <= 0) {
                                i3 = 1;
                            }
                            quantityString = context.getResources().getQuantityString(R.plurals.l, i3, Integer.valueOf(i3));
                            pMq.put(Long.valueOf(j2), quantityString);
                            pMp.put(Long.valueOf(j2), Long.valueOf(timeInMillis));
                            AppMethodBeat.o(6237);
                        } else {
                            quantityString = context.getString(R.string.dfu);
                            pMq.put(Long.valueOf(j2), quantityString);
                            pMp.put(Long.valueOf(j2), Long.valueOf(timeInMillis));
                            AppMethodBeat.o(6237);
                        }
                    } else {
                        int i4 = (int) ((timeInMillis - j2) / Util.MILLSECONDS_OF_HOUR);
                        if (i4 <= 0) {
                            i4 = 1;
                        }
                        quantityString = context.getResources().getQuantityString(R.plurals.f3143j, i4, Integer.valueOf(i4));
                        pMq.put(Long.valueOf(j2), quantityString);
                        pMp.put(Long.valueOf(j2), Long.valueOf(timeInMillis));
                        AppMethodBeat.o(6237);
                    }
                }
            }
        }
        return quantityString;
    }
}
