package com.tencent.mm.danmaku.e;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.b.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

public final class c {
    private static float cPs = -1.0f;
    private static final SimpleDateFormat gQI = new SimpleDateFormat("yy年M月d日 hh:mm:ss");
    private static final Date gQJ = new Date();
    private static final StringBuilder gQK = new StringBuilder();
    private static final Formatter gQL = new Formatter(gQK, Locale.getDefault());

    static {
        AppMethodBeat.i(241760);
        AppMethodBeat.o(241760);
    }

    public static int a(a aVar, a aVar2, long j2) {
        AppMethodBeat.i(241756);
        if (aVar.yZ(j2) || aVar2.yZ(j2)) {
            AppMethodBeat.o(241756);
            return -1;
        }
        float[] zc = aVar.zc(aVar.asN());
        float[] zc2 = aVar2.zc(aVar.asN());
        if (zc == null || zc2 == null) {
            AppMethodBeat.o(241756);
            return -1;
        }
        int max = Math.max((int) ((zc2[0] - zc[2]) / aVar2.asv()), (int) ((aVar2.zc(aVar.asw())[0] - aVar.zc(aVar.asw())[2]) / aVar2.asv()));
        AppMethodBeat.o(241756);
        return max;
    }

    public static int a(a aVar, a aVar2) {
        AppMethodBeat.i(241757);
        if (aVar == aVar2) {
            AppMethodBeat.o(241757);
            return 0;
        } else if (aVar == null) {
            AppMethodBeat.o(241757);
            return -1;
        } else if (aVar2 == null) {
            AppMethodBeat.o(241757);
            return 1;
        } else if (aVar.equals(aVar2)) {
            AppMethodBeat.o(241757);
            return 0;
        } else {
            long time = aVar.getTime() - aVar2.getTime();
            if (time > 0) {
                AppMethodBeat.o(241757);
                return 1;
            } else if (time < 0) {
                AppMethodBeat.o(241757);
                return -1;
            } else {
                int asz = aVar.asz() - aVar2.asz();
                if (asz > 0) {
                    AppMethodBeat.o(241757);
                    return -1;
                } else if (asz < 0) {
                    AppMethodBeat.o(241757);
                    return 1;
                } else {
                    int asD = aVar.asD() - aVar2.asD();
                    if (asD > 0) {
                        AppMethodBeat.o(241757);
                        return 1;
                    } else if (asD < 0) {
                        AppMethodBeat.o(241757);
                        return -1;
                    } else {
                        int asA = aVar.asA() - aVar2.asA();
                        if (asA > 0) {
                            AppMethodBeat.o(241757);
                            return -1;
                        } else if (asA < 0) {
                            AppMethodBeat.o(241757);
                            return 1;
                        } else {
                            long adU = aVar.adU() - aVar2.adU();
                            if (adU > 0) {
                                AppMethodBeat.o(241757);
                                return -1;
                            } else if (adU < 0) {
                                AppMethodBeat.o(241757);
                                return 1;
                            } else {
                                int type = aVar.getType() - aVar2.getType();
                                if (type > 0) {
                                    AppMethodBeat.o(241757);
                                    return 1;
                                } else if (type < 0) {
                                    AppMethodBeat.o(241757);
                                    return -1;
                                } else {
                                    AppMethodBeat.o(241757);
                                    return type;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static String zg(long j2) {
        AppMethodBeat.i(241758);
        if (j2 < Util.MILLSECONDS_OF_DAY) {
            long j3 = j2 / 1000;
            long j4 = j3 % 60;
            long j5 = (j3 / 60) % 60;
            long j6 = j3 / 3600;
            if (j4 < 0) {
                j4 = 0;
            }
            if (j5 < 0) {
                j5 = 0;
            }
            if (j6 < 0) {
                j6 = 0;
            }
            gQK.setLength(0);
            if (j6 > 0) {
                String formatter = gQL.format("%d:%02d:%02d", Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j4)).toString();
                AppMethodBeat.o(241758);
                return formatter;
            }
            String formatter2 = gQL.format("%02d:%02d", Long.valueOf(j5), Long.valueOf(j4)).toString();
            AppMethodBeat.o(241758);
            return formatter2;
        }
        gQJ.setTime(j2);
        String format = gQI.format(gQJ);
        AppMethodBeat.o(241758);
        return format;
    }

    public static boolean atm() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public static int ao(float f2) {
        AppMethodBeat.i(241759);
        if (cPs < 0.0f) {
            cPs = com.tencent.mm.danmaku.f.a.atr().getResources().getDisplayMetrics().density;
        }
        int i2 = (int) ((cPs * f2) + 0.5f);
        AppMethodBeat.o(241759);
        return i2;
    }
}
