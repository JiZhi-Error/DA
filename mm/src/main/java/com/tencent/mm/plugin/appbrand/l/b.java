package com.tencent.mm.plugin.appbrand.l;

import android.support.e.a;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import com.tencent.rtmp.sharp.jni.QLog;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class b {
    private static SimpleDateFormat yC = null;

    public static int m(InputStream inputStream) {
        int i2 = 0;
        AppMethodBeat.i(138800);
        if (inputStream == null) {
            AppMethodBeat.o(138800);
        } else {
            try {
                i2 = new a(inputStream).l(a.TAG_ORIENTATION);
                AppMethodBeat.o(138800);
            } catch (Exception e2) {
                AppMethodBeat.o(138800);
            } catch (Error e3) {
                AppMethodBeat.o(138800);
            }
        }
        return i2;
    }

    public static void a(String str, double d2, double d3, long j2) {
        AppMethodBeat.i(179483);
        if (!YS(str)) {
            AppMethodBeat.o(179483);
            return;
        }
        if (yC == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
            yC = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }
        a aVar = new a(str);
        if (d2 < -90.0d || d2 > 90.0d || Double.isNaN(d2)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Latitude value " + d2 + " is not valid.");
            AppMethodBeat.o(179483);
            throw illegalArgumentException;
        } else if (d3 < -180.0d || d3 > 180.0d || Double.isNaN(d3)) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Longitude value " + d3 + " is not valid.");
            AppMethodBeat.o(179483);
            throw illegalArgumentException2;
        } else {
            aVar.setAttribute(a.TAG_GPS_LATITUDE_REF, d2 >= 0.0d ? "N" : "S");
            aVar.setAttribute(a.TAG_GPS_LATITUDE, a.b(Math.abs(d2)));
            aVar.setAttribute(a.TAG_GPS_LONGITUDE_REF, d3 >= 0.0d ? QLog.TAG_REPORTLEVEL_USER : QLog.TAG_REPORTLEVEL_COLORUSER);
            aVar.setAttribute(a.TAG_GPS_LONGITUDE, a.b(Math.abs(d3)));
            String[] split = yC.format(new Date(j2)).split("\\s+", -1);
            aVar.setAttribute(a.TAG_GPS_DATESTAMP, split[0]);
            aVar.setAttribute(a.TAG_GPS_TIMESTAMP, split[1]);
            aVar.setAttribute(a.TAG_DATETIME, yC.format(new Date(j2)));
            aVar.setAttribute(a.TAG_SUBSEC_TIME, Long.toString(j2 % 1000));
            aVar.saveAttributes();
            AppMethodBeat.o(179483);
        }
    }

    public static void dk(String str, String str2) {
        AppMethodBeat.i(138801);
        if (!YS(str) || !YS(str2)) {
            AppMethodBeat.o(138801);
            return;
        }
        a aVar = new a(str2);
        a.a(new a(str), aVar);
        aVar.setAttribute(a.TAG_ORIENTATION, null);
        aVar.setAttribute(a.TAG_IMAGE_WIDTH, null);
        aVar.setAttribute(a.TAG_THUMBNAIL_IMAGE_WIDTH, null);
        aVar.saveAttributes();
        AppMethodBeat.o(138801);
    }

    public static void b(InputStream inputStream, String str) {
        AppMethodBeat.i(138802);
        if (inputStream == null || !YS(str)) {
            AppMethodBeat.o(138802);
            return;
        }
        a aVar = new a(str);
        a.a(new a(inputStream), aVar);
        aVar.setAttribute(a.TAG_ORIENTATION, null);
        aVar.setAttribute(a.TAG_IMAGE_WIDTH, null);
        aVar.setAttribute(a.TAG_THUMBNAIL_IMAGE_WIDTH, null);
        aVar.saveAttributes();
        AppMethodBeat.o(138802);
    }

    private static boolean YS(String str) {
        AppMethodBeat.i(138803);
        if (TextUtils.isEmpty(str) || !new o(str).exists()) {
            AppMethodBeat.o(138803);
            return false;
        }
        AppMethodBeat.o(138803);
        return true;
    }
}
