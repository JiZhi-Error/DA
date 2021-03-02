package com.tencent.mm.pluginsdk.i;

import android.content.Context;
import android.text.format.DateFormat;
import android.text.format.Time;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.sharp.jni.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public final class f {
    private static long JYp;
    private static boolean JYq = false;

    public static String formatTime(String str, long j2) {
        AppMethodBeat.i(151899);
        String format = new SimpleDateFormat(str).format(new Date(1000 * j2));
        AppMethodBeat.o(151899);
        return format;
    }

    public static String az(Context context, int i2) {
        String string;
        AppMethodBeat.i(151900);
        long j2 = 1000 * ((long) i2);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j2 < Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(151900);
            return "";
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j2 - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis < 0 || timeInMillis >= Util.MILLSECONDS_OF_DAY) {
            long timeInMillis2 = j2 - (gregorianCalendar2.getTimeInMillis() - Util.MILLSECONDS_OF_DAY);
            if (timeInMillis2 < 0 || timeInMillis2 >= Util.MILLSECONDS_OF_DAY) {
                long timeInMillis3 = j2 - (gregorianCalendar2.getTimeInMillis() - 172800000);
                if (timeInMillis3 < 0 || timeInMillis3 >= Util.MILLSECONDS_OF_DAY) {
                    long timeInMillis4 = j2 - (gregorianCalendar2.getTimeInMillis() + Util.MILLSECONDS_OF_DAY);
                    if (timeInMillis4 < 0 || timeInMillis4 >= Util.MILLSECONDS_OF_DAY) {
                        long timeInMillis5 = j2 - (gregorianCalendar2.getTimeInMillis() + 172800000);
                        if (timeInMillis5 < 0 || timeInMillis5 >= Util.MILLSECONDS_OF_DAY) {
                            GregorianCalendar gregorianCalendar3 = new GregorianCalendar();
                            gregorianCalendar3.setTimeInMillis(j2);
                            int i3 = gregorianCalendar3.get(11);
                            if (gregorianCalendar.get(1) == gregorianCalendar3.get(1) && gregorianCalendar.get(3) == gregorianCalendar3.get(3)) {
                                String str = aA(context, gregorianCalendar3.get(7)) + " " + ((Object) aB(context, i3)) + ";" + bQ(context.getString(R.string.df6), j2);
                                AppMethodBeat.o(151900);
                                return str;
                            } else if (gregorianCalendar.get(1) == gregorianCalendar3.get(1) && gregorianCalendar.get(3) + 1 == gregorianCalendar3.get(3)) {
                                int i4 = gregorianCalendar3.get(7);
                                StringBuilder sb = new StringBuilder();
                                switch (i4) {
                                    case 1:
                                        string = context.getString(R.string.dfh);
                                        break;
                                    case 2:
                                        string = context.getString(R.string.dff);
                                        break;
                                    case 3:
                                        string = context.getString(R.string.dfj);
                                        break;
                                    case 4:
                                        string = context.getString(R.string.dfk);
                                        break;
                                    case 5:
                                        string = context.getString(R.string.dfi);
                                        break;
                                    case 6:
                                        string = context.getString(R.string.dfe);
                                        break;
                                    case 7:
                                        string = context.getString(R.string.dfg);
                                        break;
                                    default:
                                        string = "";
                                        break;
                                }
                                String sb2 = sb.append(string).append(" ").append((Object) aB(context, i3)).append(";").append(bQ(context.getString(R.string.df6), j2)).toString();
                                AppMethodBeat.o(151900);
                                return sb2;
                            } else if (gregorianCalendar.get(1) == gregorianCalendar3.get(1)) {
                                String str2 = ((Object) DateFormat.format(context.getString(R.string.dec), j2)) + " " + ((Object) aB(context, i3)) + ";" + bQ(context.getString(R.string.df6), j2);
                                AppMethodBeat.o(151900);
                                return str2;
                            } else {
                                String str3 = ((Object) DateFormat.format(context.getString(R.string.dev), j2)) + " " + ((Object) aB(context, i3)) + ";" + bQ(context.getString(R.string.df6), j2);
                                AppMethodBeat.o(151900);
                                return str3;
                            }
                        } else {
                            String str4 = context.getString(R.string.dfc) + " " + ((Object) v(context, timeInMillis5)) + ";" + bQ(context.getString(R.string.df6), j2);
                            AppMethodBeat.o(151900);
                            return str4;
                        }
                    } else {
                        String str5 = context.getString(R.string.dfm) + " " + ((Object) v(context, timeInMillis4)) + ";" + bQ(context.getString(R.string.df6), j2);
                        AppMethodBeat.o(151900);
                        return str5;
                    }
                } else {
                    String str6 = context.getString(R.string.dfd) + " " + ((Object) v(context, timeInMillis3)) + ";" + bQ(context.getString(R.string.df6), j2);
                    AppMethodBeat.o(151900);
                    return str6;
                }
            } else {
                String str7 = context.getString(R.string.dfu) + " " + ((Object) v(context, timeInMillis2)) + ";" + bQ(context.getString(R.string.df6), j2);
                AppMethodBeat.o(151900);
                return str7;
            }
        } else {
            String str8 = ((Object) v(context, timeInMillis)) + ";" + bQ(context.getString(R.string.df6), j2);
            AppMethodBeat.o(151900);
            return str8;
        }
    }

    public static String bQ(String str, long j2) {
        AppMethodBeat.i(151901);
        String charSequence = DateFormat.format(str, j2).toString();
        if (Util.isNullOrNil(charSequence)) {
            AppMethodBeat.o(151901);
            return "";
        }
        String trim = charSequence.trim();
        if (trim.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            trim = trim.substring(1);
        }
        AppMethodBeat.o(151901);
        return trim;
    }

    public static String aA(Context context, int i2) {
        AppMethodBeat.i(151902);
        switch (i2) {
            case 1:
                String string = context.getString(R.string.dfq);
                AppMethodBeat.o(151902);
                return string;
            case 2:
                String string2 = context.getString(R.string.dfo);
                AppMethodBeat.o(151902);
                return string2;
            case 3:
                String string3 = context.getString(R.string.dfs);
                AppMethodBeat.o(151902);
                return string3;
            case 4:
                String string4 = context.getString(R.string.dft);
                AppMethodBeat.o(151902);
                return string4;
            case 5:
                String string5 = context.getString(R.string.dfr);
                AppMethodBeat.o(151902);
                return string5;
            case 6:
                String string6 = context.getString(R.string.dfn);
                AppMethodBeat.o(151902);
                return string6;
            case 7:
                String string7 = context.getString(R.string.dfp);
                AppMethodBeat.o(151902);
                return string7;
            default:
                AppMethodBeat.o(151902);
                return "";
        }
    }

    public static CharSequence t(Context context, long j2) {
        AppMethodBeat.i(151903);
        String str = context.getString(R.string.dgi) + ((Object) DateFormat.format(context.getString(R.string.dgh), j2));
        AppMethodBeat.o(151903);
        return str;
    }

    public static CharSequence u(Context context, long j2) {
        AppMethodBeat.i(151904);
        String str = context.getString(R.string.dgj) + ((Object) DateFormat.format(context.getString(R.string.dgh), j2));
        AppMethodBeat.o(151904);
        return str;
    }

    private static CharSequence aB(Context context, int i2) {
        AppMethodBeat.i(151905);
        if (i2 < 0) {
            AppMethodBeat.o(151905);
            return "";
        } else if (((long) i2) < 6) {
            String string = context.getString(R.string.deg);
            AppMethodBeat.o(151905);
            return string;
        } else if (((long) i2) < 12) {
            String string2 = context.getString(R.string.dez);
            AppMethodBeat.o(151905);
            return string2;
        } else if (((long) i2) < 13) {
            String string3 = context.getString(R.string.df5);
            AppMethodBeat.o(151905);
            return string3;
        } else if (((long) i2) < 18) {
            String string4 = context.getString(R.string.de3);
            AppMethodBeat.o(151905);
            return string4;
        } else {
            String string5 = context.getString(R.string.den);
            AppMethodBeat.o(151905);
            return string5;
        }
    }

    public static CharSequence v(Context context, long j2) {
        AppMethodBeat.i(151906);
        if (j2 < 0) {
            AppMethodBeat.o(151906);
            return "";
        } else if (j2 < 21600000) {
            String string = context.getString(R.string.deg);
            AppMethodBeat.o(151906);
            return string;
        } else if (j2 < 43200000) {
            String string2 = context.getString(R.string.dez);
            AppMethodBeat.o(151906);
            return string2;
        } else if (j2 < 46800000) {
            String string3 = context.getString(R.string.df5);
            AppMethodBeat.o(151906);
            return string3;
        } else if (j2 < 64800000) {
            String string4 = context.getString(R.string.de3);
            AppMethodBeat.o(151906);
            return string4;
        } else {
            String string5 = context.getString(R.string.den);
            AppMethodBeat.o(151906);
            return string5;
        }
    }

    public static boolean gns() {
        AppMethodBeat.i(151907);
        if (System.currentTimeMillis() - JYp > 30000) {
            try {
                JYq = DateFormat.is24HourFormat(MMApplicationContext.getContext());
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.TimeUtil", e2, "", new Object[0]);
            }
        }
        boolean z = JYq;
        AppMethodBeat.o(151907);
        return z;
    }

    private static String ahO(int i2) {
        switch (i2) {
            case 0:
                return "JANUARY";
            case 1:
                return "FEBRUARY";
            case 2:
                return "MARCH";
            case 3:
                return "APRIL";
            case 4:
                return "MAY";
            case 5:
                return "JUNE";
            case 6:
                return "JULY";
            case 7:
                return "AUGUST";
            case 8:
                return "SEPTEMBER";
            case 9:
                return "OCTOBER";
            case 10:
                return "NOVEMBER";
            case 11:
                return "DECEMBER";
            default:
                return "UNDECIMBER";
        }
    }

    public static String w(Context context, long j2) {
        AppMethodBeat.i(223818);
        if (!LocaleUtil.isSimplifiedChineseAppLang()) {
            LocaleUtil.transLanguageToLocale(LocaleUtil.getApplicationLanguage());
            String x = x(context, j2);
            AppMethodBeat.o(223818);
            return x;
        } else if (j2 < Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(223818);
            return "";
        } else {
            Time time = new Time();
            Time time2 = new Time();
            time.set(j2);
            time2.setToNow();
            if (time.year == time2.year && time.yearDay == time2.yearDay) {
                String string = context.getString(R.string.dfl);
                AppMethodBeat.o(223818);
                return string;
            } else if (time.year == time2.year && time2.yearDay - time.yearDay == 1) {
                String string2 = context.getString(R.string.dfu);
                AppMethodBeat.o(223818);
                return string2;
            } else if (time.year == time2.year && time2.yearDay - time.yearDay <= 7) {
                String string3 = context.getString(R.string.dfb);
                AppMethodBeat.o(223818);
                return string3;
            } else if (time.year == time2.year && time2.yearDay - time.yearDay <= 30) {
                String string4 = context.getString(R.string.dfa);
                AppMethodBeat.o(223818);
                return string4;
            } else if (time.year == time2.year) {
                String str = (time.month + 1) + "月";
                AppMethodBeat.o(223818);
                return str;
            } else {
                String str2 = time.year + "年";
                AppMethodBeat.o(223818);
                return str2;
            }
        }
    }

    private static String x(Context context, long j2) {
        AppMethodBeat.i(223819);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j2 < Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(223819);
            return "";
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j2 - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis <= 0 || timeInMillis > Util.MILLSECONDS_OF_DAY) {
            long timeInMillis2 = (j2 - gregorianCalendar2.getTimeInMillis()) + Util.MILLSECONDS_OF_DAY;
            if (timeInMillis2 <= 0 || timeInMillis2 > Util.MILLSECONDS_OF_DAY) {
                GregorianCalendar gregorianCalendar3 = new GregorianCalendar();
                gregorianCalendar3.setTimeInMillis(j2);
                long timeInMillis3 = (j2 - gregorianCalendar2.getTimeInMillis()) + 604800000;
                if (timeInMillis3 <= 0 || timeInMillis3 > 604800000) {
                    long timeInMillis4 = (j2 - gregorianCalendar2.getTimeInMillis()) + 2592000000L;
                    if (timeInMillis4 > 0 && timeInMillis4 <= 2592000000L) {
                        AppMethodBeat.o(223819);
                        return "30 days ago";
                    } else if (gregorianCalendar.get(1) == gregorianCalendar3.get(1)) {
                        String ahO = ahO(gregorianCalendar.get(2));
                        AppMethodBeat.o(223819);
                        return ahO;
                    } else {
                        String format = String.format("%d", Integer.valueOf(gregorianCalendar.get(1)));
                        AppMethodBeat.o(223819);
                        return format;
                    }
                } else {
                    AppMethodBeat.o(223819);
                    return "7 days ago";
                }
            } else {
                String string = context.getString(R.string.dfu);
                AppMethodBeat.o(223819);
                return string;
            }
        } else {
            String string2 = context.getString(R.string.dfl);
            AppMethodBeat.o(223819);
            return string2;
        }
    }

    public static CharSequence y(Context context, long j2) {
        AppMethodBeat.i(223820);
        if (!LocaleUtil.isSimplifiedChineseAppLang()) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j2 < Util.MILLSECONDS_OF_HOUR) {
                AppMethodBeat.o(223820);
                return "";
            }
            long timeInMillis = j2 - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
            if (timeInMillis <= 0 || timeInMillis > Util.MILLSECONDS_OF_DAY) {
                LocaleUtil.transLanguageToLocale(LocaleUtil.getApplicationLanguage());
                String x = x(context, j2);
                AppMethodBeat.o(223820);
                return x;
            }
            String string = context.getString(R.string.dfl);
            AppMethodBeat.o(223820);
            return string;
        } else if (j2 < Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(223820);
            return "";
        } else {
            Time time = new Time();
            Time time2 = new Time();
            time.set(j2);
            time2.setToNow();
            if (time.year == time2.year && time.yearDay == time2.yearDay) {
                String string2 = context.getString(R.string.dfl);
                AppMethodBeat.o(223820);
                return string2;
            }
            CharSequence c2 = c(context, j2, true);
            AppMethodBeat.o(223820);
            return c2;
        }
    }

    public static CharSequence c(Context context, long j2, boolean z) {
        Object sb;
        AppMethodBeat.i(151908);
        if (!LocaleUtil.isSimplifiedChineseAppLang()) {
            CharSequence a2 = a(context, j2, z, LocaleUtil.transLanguageToLocale(LocaleUtil.getApplicationLanguage()));
            AppMethodBeat.o(151908);
            return a2;
        } else if (j2 < Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(151908);
            return "";
        } else {
            Time time = new Time();
            Time time2 = new Time();
            time.set(j2);
            time2.setToNow();
            if (time.year == time2.year && time.yearDay == time2.yearDay) {
                if (gns()) {
                    CharSequence a3 = e.a(context.getString(R.string.df7), time);
                    AppMethodBeat.o(151908);
                    return a3;
                }
                String sb2 = new StringBuilder().append((Object) aB(context, time.hour)).append((Object) e.a(context.getString(R.string.df6), time)).toString();
                AppMethodBeat.o(151908);
                return sb2;
            } else if (time.year == time2.year && time2.yearDay - time.yearDay == 1) {
                boolean gns = gns();
                if (z) {
                    String string = context.getString(R.string.dfu);
                    AppMethodBeat.o(151908);
                    return string;
                }
                StringBuilder append = new StringBuilder().append(context.getString(R.string.dfu)).append(" ");
                if (gns) {
                    sb = e.a(context.getString(R.string.df7), time);
                } else {
                    sb = new StringBuilder().append((Object) aB(context, time.hour)).append((Object) e.a(context.getString(R.string.df6), time)).toString();
                }
                String sb3 = append.append(sb).toString();
                AppMethodBeat.o(151908);
                return sb3;
            } else if (time.year == time2.year && time.getWeekNumber() == time2.getWeekNumber()) {
                String sb4 = new StringBuilder().append((Object) e.a("E ", time)).toString();
                if (z) {
                    AppMethodBeat.o(151908);
                    return sb4;
                }
                String str = sb4 + ((Object) e.a(context.getString(R.string.df8), time));
                AppMethodBeat.o(151908);
                return str;
            } else if (time.year == time2.year) {
                if (z) {
                    CharSequence a4 = e.a(context.getString(R.string.dec), time);
                    AppMethodBeat.o(151908);
                    return a4;
                }
                CharSequence a5 = e.a(context.getString(R.string.dee, v(context, ((long) time.hour) * Util.MILLSECONDS_OF_HOUR)).toString(), time);
                AppMethodBeat.o(151908);
                return a5;
            } else if (z) {
                CharSequence a6 = e.a(context.getString(R.string.dev), time);
                AppMethodBeat.o(151908);
                return a6;
            } else {
                CharSequence a7 = e.a(context.getString(R.string.dex, v(context, ((long) time.hour) * Util.MILLSECONDS_OF_HOUR)).toString(), time);
                AppMethodBeat.o(151908);
                return a7;
            }
        }
    }

    private static CharSequence a(Context context, long j2, boolean z, Locale locale) {
        AppMethodBeat.i(223821);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j2 < Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(223821);
            return "";
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j2 - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis <= 0 || timeInMillis > Util.MILLSECONDS_OF_DAY) {
            long timeInMillis2 = (j2 - gregorianCalendar2.getTimeInMillis()) + Util.MILLSECONDS_OF_DAY;
            if (timeInMillis2 <= 0 || timeInMillis2 > Util.MILLSECONDS_OF_DAY) {
                GregorianCalendar gregorianCalendar3 = new GregorianCalendar();
                gregorianCalendar3.setTimeInMillis(j2);
                if (gregorianCalendar.get(1) == gregorianCalendar3.get(1) && gregorianCalendar.get(3) == gregorianCalendar3.get(3)) {
                    String str = new SimpleDateFormat(QLog.TAG_REPORTLEVEL_USER, locale).format(Long.valueOf(j2));
                    if (z) {
                        AppMethodBeat.o(223821);
                        return str;
                    }
                    String str2 = str + " " + java.text.DateFormat.getTimeInstance(3, locale).format(Long.valueOf(j2));
                    AppMethodBeat.o(223821);
                    return str2;
                } else if (gregorianCalendar.get(1) == gregorianCalendar3.get(1)) {
                    if (z) {
                        String format = java.text.DateFormat.getDateInstance(3, locale).format(Long.valueOf(j2));
                        AppMethodBeat.o(223821);
                        return format;
                    }
                    String format2 = java.text.DateFormat.getDateTimeInstance(3, 3, locale).format(Long.valueOf(j2));
                    AppMethodBeat.o(223821);
                    return format2;
                } else if (z) {
                    String format3 = java.text.DateFormat.getDateInstance(3, locale).format(Long.valueOf(j2));
                    AppMethodBeat.o(223821);
                    return format3;
                } else {
                    String format4 = java.text.DateFormat.getDateTimeInstance(3, 3, locale).format(Long.valueOf(j2));
                    AppMethodBeat.o(223821);
                    return format4;
                }
            } else if (z) {
                String string = context.getString(R.string.dfu);
                AppMethodBeat.o(223821);
                return string;
            } else {
                String str3 = context.getString(R.string.dfu) + " " + java.text.DateFormat.getTimeInstance(3, locale).format(Long.valueOf(j2));
                AppMethodBeat.o(223821);
                return str3;
            }
        } else {
            String str4 = java.text.DateFormat.getTimeInstance(3, locale).format(Long.valueOf(j2));
            AppMethodBeat.o(223821);
            return str4;
        }
    }
}
