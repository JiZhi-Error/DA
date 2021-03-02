package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class bm {
    private static HashMap<Long, Long> pMp = new HashMap<>();
    private static HashMap<Long, String> pMq = new HashMap<>();
    private static Map<String, List<String>> vVB = new HashMap();
    private static Map<String, List<String>> vVC = new HashMap();

    static {
        AppMethodBeat.i(99442);
        AppMethodBeat.o(99442);
    }

    private static CharSequence j(Context context, long j2) {
        AppMethodBeat.i(99431);
        CharSequence format = DateFormat.format(context.getString(R.string.df7), j2);
        AppMethodBeat.o(99431);
        return format;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String q(android.content.Context r13, long r14) {
        /*
        // Method dump skipped, instructions count: 354
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.bm.q(android.content.Context, long):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String r(android.content.Context r13, long r14) {
        /*
        // Method dump skipped, instructions count: 338
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.bm.r(android.content.Context, long):java.lang.String");
    }

    public static synchronized void clean() {
        synchronized (bm.class) {
            AppMethodBeat.i(99434);
            pMp.clear();
            pMq.clear();
            AppMethodBeat.o(99434);
        }
    }

    public static synchronized String n(Context context, long j2) {
        String quantityString;
        synchronized (bm.class) {
            AppMethodBeat.i(99435);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j2 < Util.MILLSECONDS_OF_HOUR) {
                quantityString = "";
                AppMethodBeat.o(99435);
            } else {
                long timeInMillis = gregorianCalendar.getTimeInMillis();
                if (pMp.containsKey(Long.valueOf(j2))) {
                    if (timeInMillis - pMp.get(Long.valueOf(j2)).longValue() >= Util.MILLSECONDS_OF_MINUTE) {
                        pMp.remove(Long.valueOf(j2));
                    } else if (pMq.containsKey(Long.valueOf(j2))) {
                        quantityString = pMq.get(Long.valueOf(j2));
                        AppMethodBeat.o(99435);
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
                    AppMethodBeat.o(99435);
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
                            quantityString = context.getResources().getQuantityString(R.plurals.l, timeInMillis4, Integer.valueOf(timeInMillis4));
                            pMq.put(Long.valueOf(j2), quantityString);
                            pMp.put(Long.valueOf(j2), Long.valueOf(timeInMillis));
                            AppMethodBeat.o(99435);
                        } else {
                            quantityString = context.getString(R.string.dfu);
                            pMq.put(Long.valueOf(j2), quantityString);
                            pMp.put(Long.valueOf(j2), Long.valueOf(timeInMillis));
                            AppMethodBeat.o(99435);
                        }
                    } else {
                        int i3 = (int) ((timeInMillis - j2) / Util.MILLSECONDS_OF_HOUR);
                        if (i3 <= 0) {
                            i3 = 1;
                        }
                        quantityString = context.getResources().getQuantityString(R.plurals.f3143j, i3, Integer.valueOf(i3));
                        pMq.put(Long.valueOf(j2), quantityString);
                        pMp.put(Long.valueOf(j2), Long.valueOf(timeInMillis));
                        AppMethodBeat.o(99435);
                    }
                }
            }
        }
        return quantityString;
    }

    private static void bA(Context context, String str) {
        AppMethodBeat.i(99436);
        String[] stringArray = context.getResources().getStringArray(R.array.as);
        ArrayList arrayList = new ArrayList();
        arrayList.add("");
        for (String str2 : stringArray) {
            arrayList.add(str2);
        }
        vVC.put(str, arrayList);
        AppMethodBeat.o(99436);
    }

    private static String aq(Context context, int i2) {
        AppMethodBeat.i(99437);
        String[] stringArray = context.getResources().getStringArray(R.array.as);
        ArrayList arrayList = new ArrayList();
        arrayList.add("");
        for (String str : stringArray) {
            arrayList.add(str);
        }
        if (i2 >= arrayList.size()) {
            AppMethodBeat.o(99437);
            return "";
        }
        String str2 = (String) arrayList.get(i2);
        AppMethodBeat.o(99437);
        return str2;
    }

    public static String K(Context context, String str, String str2) {
        AppMethodBeat.i(99438);
        if (vVC.get(str2) == null) {
            bA(context, str2);
        }
        int i2 = Util.getInt(str, 0);
        List<String> list = vVC.get(str2);
        if (i2 >= list.size() || list.get(i2) == null || list.get(i2).equals("")) {
            bA(context, str2);
        }
        List<String> list2 = vVC.get(str2);
        if (i2 < list2.size()) {
            String str3 = list2.get(i2);
            AppMethodBeat.o(99438);
            return str3;
        }
        AppMethodBeat.o(99438);
        return "";
    }

    public static CharSequence a(Context context, long j2, boolean z) {
        AppMethodBeat.i(99439);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j2 < Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(99439);
            return "";
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j2 - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis <= 0 || timeInMillis > Util.MILLSECONDS_OF_DAY || !z) {
            long timeInMillis2 = (j2 - gregorianCalendar2.getTimeInMillis()) + Util.MILLSECONDS_OF_DAY;
            if (timeInMillis2 <= 0 || timeInMillis2 > Util.MILLSECONDS_OF_DAY || !z) {
                new GregorianCalendar().setTimeInMillis(j2);
                CharSequence format = DateFormat.format(context.getString(R.string.ded), j2);
                AppMethodBeat.o(99439);
                return format;
            }
            String string = context.getString(R.string.dfu);
            AppMethodBeat.o(99439);
            return string;
        }
        String string2 = context.getString(R.string.dfl);
        AppMethodBeat.o(99439);
        return string2;
    }

    public static int getYear() {
        AppMethodBeat.i(99441);
        int i2 = new GregorianCalendar().get(1);
        AppMethodBeat.o(99441);
        return i2;
    }

    public static CharSequence JU(long j2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(99440);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        long timeInMillis = j2 - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
        if (timeInMillis <= 0 || timeInMillis > Util.MILLSECONDS_OF_DAY) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            String string = MMApplicationContext.getContext().getResources().getString(R.string.dfl);
            AppMethodBeat.o(99440);
            return string;
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        GregorianCalendar gregorianCalendar3 = new GregorianCalendar(gregorianCalendar2.get(1), gregorianCalendar2.get(2), gregorianCalendar2.get(5));
        int i2 = gregorianCalendar2.get(7) - 1;
        if (i2 == 0) {
            i2 = 7;
        }
        long timeInMillis2 = gregorianCalendar3.getTimeInMillis() - (((long) i2) * Util.MILLSECONDS_OF_DAY);
        long timeInMillis3 = gregorianCalendar3.getTimeInMillis() + (((long) (7 - i2)) * Util.MILLSECONDS_OF_DAY);
        if (j2 < timeInMillis2 || j2 >= timeInMillis3) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            String string2 = MMApplicationContext.getContext().getResources().getString(R.string.dem);
            AppMethodBeat.o(99440);
            return string2;
        }
        CharSequence format = DateFormat.format(MMApplicationContext.getContext().getString(R.string.dgm), j2);
        AppMethodBeat.o(99440);
        return format;
    }
}
