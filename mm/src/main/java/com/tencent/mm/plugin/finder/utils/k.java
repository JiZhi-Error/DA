package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.text.format.DateFormat;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class k {
    private static HashMap<Long, String> UVb = new HashMap<>();
    private static HashMap<Long, Long> pMp = new HashMap<>();
    private static HashMap<Long, String> pMq = new HashMap<>();
    private static Map<String, List<String>> vVB = new HashMap();
    private static Map<String, List<String>> vVC = new HashMap();
    public static String vVD = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());

    static {
        AppMethodBeat.i(168642);
        AppMethodBeat.o(168642);
    }

    public static CharSequence j(Context context, long j2) {
        AppMethodBeat.i(241813);
        CharSequence format = DateFormat.format(context.getString(R.string.df7), j2);
        AppMethodBeat.o(241813);
        return format;
    }

    public static String k(Context context, long j2) {
        AppMethodBeat.i(241814);
        String l = l(context, j2);
        AppMethodBeat.o(241814);
        return l;
    }

    public static String l(Context context, long j2) {
        AppMethodBeat.i(241815);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTimeInMillis(j2);
        if (gregorianCalendar.get(6) == gregorianCalendar2.get(6)) {
            String string = context.getString(R.string.dfl);
            pMq.put(Long.valueOf(j2), string);
            pMp.put(Long.valueOf(j2), Long.valueOf(timeInMillis));
            AppMethodBeat.o(241815);
            return string;
        } else if (gregorianCalendar.get(6) == gregorianCalendar2.get(6) + 1) {
            String string2 = context.getString(R.string.dfu);
            pMq.put(Long.valueOf(j2), string2);
            pMp.put(Long.valueOf(j2), Long.valueOf(timeInMillis));
            AppMethodBeat.o(241815);
            return string2;
        } else if (gregorianCalendar.get(6) == gregorianCalendar2.get(6) + 2) {
            String string3 = context.getString(R.string.dfd);
            pMq.put(Long.valueOf(j2), string3);
            pMp.put(Long.valueOf(j2), Long.valueOf(timeInMillis));
            AppMethodBeat.o(241815);
            return string3;
        } else if (gregorianCalendar.get(1) == gregorianCalendar2.get(1)) {
            String sb = new StringBuilder().append((Object) DateFormat.format(context.getString(R.string.dec), j2)).toString();
            pMq.put(Long.valueOf(j2), sb);
            pMp.put(Long.valueOf(j2), Long.valueOf(timeInMillis));
            AppMethodBeat.o(241815);
            return sb;
        } else {
            String sb2 = new StringBuilder().append((Object) DateFormat.format(context.getString(R.string.dev), j2)).toString();
            pMq.put(Long.valueOf(j2), sb2);
            pMp.put(Long.valueOf(j2), Long.valueOf(timeInMillis));
            AppMethodBeat.o(241815);
            return sb2;
        }
    }

    public static String z(Context context, long j2) {
        AppMethodBeat.i(260050);
        if (j2 < Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(260050);
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (pMp.containsKey(Long.valueOf(j2))) {
            if (currentTimeMillis - pMp.get(Long.valueOf(j2)).longValue() >= Util.MILLSECONDS_OF_MINUTE) {
                pMp.remove(Long.valueOf(j2));
            } else if (UVb.containsKey(Long.valueOf(j2))) {
                String str = UVb.get(Long.valueOf(j2));
                AppMethodBeat.o(260050);
                return str;
            }
        }
        if ((j2 - currentTimeMillis) / Util.MILLSECONDS_OF_HOUR == 0) {
            int i2 = (int) ((j2 - currentTimeMillis) / Util.MILLSECONDS_OF_MINUTE);
            if (i2 <= 0) {
                i2 = 1;
            }
            String string = context.getResources().getString(R.string.j9w, Integer.valueOf(i2));
            UVb.put(Long.valueOf(j2), string);
            pMp.put(Long.valueOf(j2), Long.valueOf(currentTimeMillis));
            AppMethodBeat.o(260050);
            return string;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        long timeInMillis = j2 - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5), gregorianCalendar.get(11), gregorianCalendar.get(12)).getTimeInMillis();
        if (timeInMillis > 0 && timeInMillis <= Util.MILLSECONDS_OF_DAY) {
            int i3 = (int) ((j2 - currentTimeMillis) / Util.MILLSECONDS_OF_HOUR);
            if (i3 <= 0) {
                i3 = 1;
            }
            String string2 = context.getResources().getString(R.string.j9v, Integer.valueOf(i3));
            UVb.put(Long.valueOf(j2), string2);
            pMp.put(Long.valueOf(j2), Long.valueOf(currentTimeMillis));
            AppMethodBeat.o(260050);
            return string2;
        } else if (timeInMillis > Util.MILLSECONDS_OF_DAY) {
            int max = Math.max((int) ((j2 - currentTimeMillis) / Util.MILLSECONDS_OF_DAY), 1);
            String string3 = context.getResources().getString(R.string.j9u, Integer.valueOf(max));
            UVb.put(Long.valueOf(j2), string3);
            pMp.put(Long.valueOf(j2), Long.valueOf(currentTimeMillis));
            AppMethodBeat.o(260050);
            return string3;
        } else {
            AppMethodBeat.o(260050);
            return "";
        }
    }

    public static String m(Context context, long j2) {
        AppMethodBeat.i(241816);
        if (j2 < Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(241816);
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (pMp.containsKey(Long.valueOf(j2))) {
            if (currentTimeMillis - pMp.get(Long.valueOf(j2)).longValue() >= Util.MILLSECONDS_OF_MINUTE) {
                pMp.remove(Long.valueOf(j2));
            } else if (pMq.containsKey(Long.valueOf(j2))) {
                String str = pMq.get(Long.valueOf(j2));
                AppMethodBeat.o(241816);
                return str;
            }
        }
        if ((currentTimeMillis - j2) / Util.MILLSECONDS_OF_HOUR == 0) {
            int i2 = (int) ((currentTimeMillis - j2) / Util.MILLSECONDS_OF_MINUTE);
            if (i2 <= 0) {
                i2 = 1;
            }
            String string = context.getResources().getString(R.string.da0, Integer.valueOf(i2));
            pMq.put(Long.valueOf(j2), string);
            pMp.put(Long.valueOf(j2), Long.valueOf(currentTimeMillis));
            AppMethodBeat.o(241816);
            return string;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j2 - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis <= 0 || timeInMillis > Util.MILLSECONDS_OF_DAY) {
            long timeInMillis2 = gregorianCalendar2.getTimeInMillis();
            int i3 = (int) (((timeInMillis2 + Util.MILLSECONDS_OF_DAY) - j2) / Util.MILLSECONDS_OF_DAY);
            if ((j2 - timeInMillis2) + 2592000000L <= 0 || i3 > 30) {
                GregorianCalendar gregorianCalendar3 = new GregorianCalendar();
                gregorianCalendar3.setTimeInMillis(j2);
                if (gregorianCalendar.get(1) == gregorianCalendar3.get(1)) {
                    String sb = new StringBuilder().append((Object) DateFormat.format(context.getString(R.string.dec), j2)).toString();
                    pMq.put(Long.valueOf(j2), sb);
                    pMp.put(Long.valueOf(j2), Long.valueOf(currentTimeMillis));
                    AppMethodBeat.o(241816);
                    return sb;
                }
                String sb2 = new StringBuilder().append((Object) DateFormat.format(context.getString(R.string.dev), j2)).toString();
                pMq.put(Long.valueOf(j2), sb2);
                pMp.put(Long.valueOf(j2), Long.valueOf(currentTimeMillis));
                AppMethodBeat.o(241816);
                return sb2;
            }
            if (i3 <= 0) {
                i3 = 1;
            }
            String quantityString = context.getResources().getQuantityString(R.plurals.l, i3, Integer.valueOf(i3));
            pMq.put(Long.valueOf(j2), quantityString);
            pMp.put(Long.valueOf(j2), Long.valueOf(currentTimeMillis));
            AppMethodBeat.o(241816);
            return quantityString;
        }
        int i4 = (int) ((currentTimeMillis - j2) / Util.MILLSECONDS_OF_HOUR);
        if (i4 <= 0) {
            i4 = 1;
        }
        String string2 = context.getResources().getString(R.string.d_z, Integer.valueOf(i4));
        pMq.put(Long.valueOf(j2), string2);
        pMp.put(Long.valueOf(j2), Long.valueOf(currentTimeMillis));
        AppMethodBeat.o(241816);
        return string2;
    }

    public static synchronized String f(Context context, long j2) {
        String quantityString;
        int i2 = 1;
        synchronized (k.class) {
            AppMethodBeat.i(168637);
            if (j2 < Util.MILLSECONDS_OF_HOUR) {
                quantityString = "";
                AppMethodBeat.o(168637);
            } else {
                long aWy = cl.aWy();
                if (pMp.containsKey(Long.valueOf(j2))) {
                    if (aWy - pMp.get(Long.valueOf(j2)).longValue() >= Util.MILLSECONDS_OF_MINUTE) {
                        pMp.remove(Long.valueOf(j2));
                    } else if (pMq.containsKey(Long.valueOf(j2))) {
                        quantityString = pMq.get(Long.valueOf(j2));
                        AppMethodBeat.o(168637);
                    }
                }
                long j3 = aWy - j2;
                if (j3 < 0 && j3 > -3600000) {
                    j3 = 0;
                }
                if (j3 < 0) {
                    quantityString = new StringBuilder().append((Object) DateFormat.format(context.getString(R.string.dev), j2)).toString();
                    pMq.put(Long.valueOf(j2), quantityString);
                    pMp.put(Long.valueOf(j2), Long.valueOf(aWy));
                    AppMethodBeat.o(168637);
                } else if (j3 / Util.MILLSECONDS_OF_HOUR == 0) {
                    int i3 = (int) (j3 / Util.MILLSECONDS_OF_MINUTE);
                    if (i3 > 0) {
                        i2 = i3;
                    }
                    quantityString = context.getResources().getString(R.string.da0, Integer.valueOf(i2));
                    pMq.put(Long.valueOf(j2), quantityString);
                    pMp.put(Long.valueOf(j2), Long.valueOf(aWy));
                    AppMethodBeat.o(168637);
                } else if (j3 <= Util.MILLSECONDS_OF_DAY) {
                    int i4 = (int) (j3 / Util.MILLSECONDS_OF_HOUR);
                    if (i4 <= 0) {
                        i4 = 1;
                    }
                    quantityString = context.getResources().getString(R.string.d_z, Integer.valueOf(i4));
                    pMq.put(Long.valueOf(j2), quantityString);
                    pMp.put(Long.valueOf(j2), Long.valueOf(aWy));
                    AppMethodBeat.o(168637);
                } else if (j3 <= 172800000) {
                    quantityString = context.getString(R.string.dfu);
                    pMq.put(Long.valueOf(j2), quantityString);
                    pMp.put(Long.valueOf(j2), Long.valueOf(aWy));
                    AppMethodBeat.o(168637);
                } else if (j3 <= 259200000) {
                    quantityString = context.getString(R.string.dfd);
                    pMq.put(Long.valueOf(j2), quantityString);
                    pMp.put(Long.valueOf(j2), Long.valueOf(aWy));
                    AppMethodBeat.o(168637);
                } else if (j3 <= 2592000000L) {
                    quantityString = context.getResources().getQuantityString(R.plurals.l, (int) (j3 / Util.MILLSECONDS_OF_DAY), Integer.valueOf((int) (j3 / Util.MILLSECONDS_OF_DAY)));
                    pMq.put(Long.valueOf(j2), quantityString);
                    pMp.put(Long.valueOf(j2), Long.valueOf(aWy));
                    AppMethodBeat.o(168637);
                } else if (j3 <= 31536000000L) {
                    quantityString = context.getResources().getQuantityString(R.plurals.m, (int) (j3 / 2592000000L), Integer.valueOf((int) (j3 / 2592000000L)));
                    pMq.put(Long.valueOf(j2), quantityString);
                    pMp.put(Long.valueOf(j2), Long.valueOf(aWy));
                    AppMethodBeat.o(168637);
                } else {
                    quantityString = context.getResources().getQuantityString(R.plurals.n, (int) (j3 / 31536000000L), Integer.valueOf((int) (j3 / 31536000000L)));
                    pMq.put(Long.valueOf(j2), quantityString);
                    pMp.put(Long.valueOf(j2), Long.valueOf(aWy));
                    AppMethodBeat.o(168637);
                }
            }
        }
        return quantityString;
    }

    private static void cx(Context context, String str) {
        AppMethodBeat.i(260051);
        String[] stringArray = context.getResources().getStringArray(R.array.ar);
        ArrayList arrayList = new ArrayList();
        arrayList.add("");
        for (String str2 : stringArray) {
            arrayList.add(str2);
        }
        vVB.put(str, arrayList);
        AppMethodBeat.o(260051);
    }

    public static String d(Context context, int i2, String str) {
        AppMethodBeat.i(260052);
        if (vVB.get(str) == null) {
            cx(context, str);
        }
        List<String> list = vVB.get(str);
        if (i2 >= list.size() || list.get(i2) == null || list.get(i2).equals("")) {
            cx(context, str);
        }
        List<String> list2 = vVB.get(str);
        if (i2 < list2.size()) {
            String str2 = list2.get(i2);
            AppMethodBeat.o(260052);
            return str2;
        }
        AppMethodBeat.o(260052);
        return "";
    }

    public static String gm(int i2, int i3) {
        AppMethodBeat.i(241817);
        y yVar = y.vXH;
        if (y.LC(i2)) {
            String Gb = Gb((long) i3);
            AppMethodBeat.o(241817);
            return Gb;
        }
        String Lv = Lv(i3);
        AppMethodBeat.o(241817);
        return Lv;
    }

    public static String Lv(int i2) {
        AppMethodBeat.i(168639);
        if (i2 <= 0) {
            AppMethodBeat.o(168639);
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else if (i2 <= 999) {
            String valueOf = String.valueOf(i2);
            AppMethodBeat.o(168639);
            return valueOf;
        } else if (vVD.equals(LocaleUtil.CHINA) || vVD.equals(LocaleUtil.HONGKONG) || vVD.equals(LocaleUtil.TAIWAN)) {
            if (i2 <= 9999) {
                String valueOf2 = String.valueOf(i2);
                AppMethodBeat.o(168639);
                return valueOf2;
            } else if (i2 <= 100000) {
                String string = MMApplicationContext.getContext().getString(R.string.d3w, Double.valueOf(((double) ((((float) i2) * 1.0f) / 10000.0f)) - 0.05d));
                AppMethodBeat.o(168639);
                return string;
            } else {
                String string2 = MMApplicationContext.getContext().getString(R.string.d3z, 10);
                AppMethodBeat.o(168639);
                return string2;
            }
        } else if (i2 <= 100000) {
            String string3 = MMApplicationContext.getContext().getString(R.string.d3y, Double.valueOf(((double) ((((float) i2) * 1.0f) / 1000.0f)) - 0.05d));
            AppMethodBeat.o(168639);
            return string3;
        } else {
            String string4 = MMApplicationContext.getContext().getString(R.string.d44, 100);
            AppMethodBeat.o(168639);
            return string4;
        }
    }

    public static String Lw(int i2) {
        AppMethodBeat.i(260053);
        String Gb = Gb((long) i2);
        AppMethodBeat.o(260053);
        return Gb;
    }

    public static String Gb(long j2) {
        AppMethodBeat.i(168641);
        if (j2 <= 0) {
            AppMethodBeat.o(168641);
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else if (j2 <= 999) {
            String valueOf = String.valueOf(j2);
            AppMethodBeat.o(168641);
            return valueOf;
        } else if (vVD.equals(LocaleUtil.CHINA) || vVD.equals(LocaleUtil.HONGKONG) || vVD.equals(LocaleUtil.TAIWAN)) {
            if (j2 <= 9999) {
                String valueOf2 = String.valueOf(j2);
                AppMethodBeat.o(168641);
                return valueOf2;
            } else if (j2 <= 99990000) {
                String string = MMApplicationContext.getContext().getString(R.string.d3w, Double.valueOf(((double) ((((float) j2) * 1.0f) / 10000.0f)) - 0.05d));
                AppMethodBeat.o(168641);
                return string;
            } else {
                String string2 = MMApplicationContext.getContext().getString(R.string.d40, 1);
                AppMethodBeat.o(168641);
                return string2;
            }
        } else if (j2 <= 990000) {
            String string3 = MMApplicationContext.getContext().getString(R.string.d3y, Double.valueOf(((double) ((((float) j2) * 1.0f) / 1000.0f)) - 0.05d));
            AppMethodBeat.o(168641);
            return string3;
        } else if (j2 <= 99990000) {
            String string4 = MMApplicationContext.getContext().getString(R.string.d3x, Double.valueOf(((double) ((((float) j2) * 1.0f) / 1000000.0f)) - 0.05d));
            AppMethodBeat.o(168641);
            return string4;
        } else {
            String string5 = MMApplicationContext.getContext().getString(R.string.d41, 100);
            AppMethodBeat.o(168641);
            return string5;
        }
    }

    public static String Lx(int i2) {
        AppMethodBeat.i(241819);
        if (i2 <= 0) {
            AppMethodBeat.o(241819);
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else if (vVD.equals(LocaleUtil.CHINA) || vVD.equals(LocaleUtil.HONGKONG) || vVD.equals(LocaleUtil.TAIWAN)) {
            if (i2 <= 9999) {
                String valueOf = String.valueOf(i2);
                AppMethodBeat.o(241819);
                return valueOf;
            } else if (i2 <= 99990000) {
                String string = MMApplicationContext.getContext().getString(R.string.d3w, Double.valueOf(((double) ((((float) i2) * 1.0f) / 10000.0f)) - 0.05d));
                AppMethodBeat.o(241819);
                return string;
            } else {
                String string2 = MMApplicationContext.getContext().getString(R.string.d43, Double.valueOf(((double) (((((float) i2) * 1.0f) / 10000.0f) / 10000.0f)) - 0.05d));
                AppMethodBeat.o(241819);
                return string2;
            }
        } else if (i2 <= 999) {
            String valueOf2 = String.valueOf(i2);
            AppMethodBeat.o(241819);
            return valueOf2;
        } else if (i2 <= 990000) {
            String string3 = MMApplicationContext.getContext().getString(R.string.d3y, Double.valueOf(((double) ((((float) i2) * 1.0f) / 1000.0f)) - 0.05d));
            AppMethodBeat.o(241819);
            return string3;
        } else if (i2 <= 990000000) {
            String string4 = MMApplicationContext.getContext().getString(R.string.d42, Double.valueOf(((double) (((((float) i2) * 1.0f) / 1000.0f) / 1000.0f)) - 0.05d));
            AppMethodBeat.o(241819);
            return string4;
        } else {
            String string5 = MMApplicationContext.getContext().getString(R.string.d45, Double.valueOf(((double) ((((((float) i2) * 1.0f) / 10000.0f) / 10000.0f) / 10.0f)) - 0.05d));
            AppMethodBeat.o(241819);
            return string5;
        }
    }
}
