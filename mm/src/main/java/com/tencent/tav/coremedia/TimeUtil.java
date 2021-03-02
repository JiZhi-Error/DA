package com.tencent.tav.coremedia;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtil {
    private static final long DEVIATION = 10000;
    public static final long SECOND_TO_US = 1000000;
    public static final String YYYY2MM2DD_HH1MM1SS = "yyyy-MM-dd HH:mm:ss";

    public static float us2Second(long j2) {
        return (((float) j2) * 1.0f) / 1000000.0f;
    }

    public static String usToSecond(long j2) {
        AppMethodBeat.i(199466);
        String format = String.format(Locale.CHINA, "%1$.1f", Float.valueOf(((float) Math.round(us2Second(j2) * 10.0f)) / 10.0f));
        AppMethodBeat.o(199466);
        return format;
    }

    public static long us2Milli(long j2) {
        return j2 / 1000;
    }

    public static boolean equals(long j2, long j3) {
        AppMethodBeat.i(199467);
        if (Math.abs(j2 - j3) < DEVIATION) {
            AppMethodBeat.o(199467);
            return true;
        }
        AppMethodBeat.o(199467);
        return false;
    }

    public static long second2Us(float f2) {
        return (long) (1000000.0f * f2);
    }

    public static long second2Ms(float f2) {
        return (long) (1000.0f * f2);
    }

    public static long milli2Us(long j2) {
        return 1000 * j2;
    }

    public static float milli2Second(long j2) {
        return (((float) j2) * 1.0f) / 1000.0f;
    }

    public static String milliToSecond(long j2) {
        AppMethodBeat.i(199468);
        String format = String.format(Locale.CHINA, "%1$.1f", Float.valueOf(((float) Math.round(milli2Second(j2) * 10.0f)) / 10.0f));
        AppMethodBeat.o(199468);
        return format;
    }

    public static String second2String(int i2) {
        AppMethodBeat.i(199469);
        StringBuilder sb = new StringBuilder();
        int i3 = i2 / 60;
        if (i3 > 0) {
            sb.append(i3 + "'");
        }
        int i4 = i2 % 60;
        if (i4 >= 10) {
            sb.append(i4 + "\"");
        } else if (i4 >= 0) {
            sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO + i4 + "\"");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(199469);
        return sb2;
    }

    public static String long2str(long j2, String str) {
        AppMethodBeat.i(199470);
        if (str == null) {
            str = "yyyy-M-d  HH:mm";
        }
        String format = new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j2));
        AppMethodBeat.o(199470);
        return format;
    }

    public static CMTime us2CMTime(long j2) {
        AppMethodBeat.i(199471);
        CMTime cMTime = new CMTime((long) (us2Second(j2) * 600.0f));
        AppMethodBeat.o(199471);
        return cMTime;
    }

    public static long getAudioDuration(long j2, int i2, int i3) {
        return (SECOND_TO_US * j2) / ((long) ((i2 * 2) * i3));
    }
}
