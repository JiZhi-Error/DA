package com.tencent.xweb.util;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Calendar;
import org.xwalk.core.Log;

public final class e {

    public static class a {
        public boolean SEF = false;
        public Object SEG;

        public final double doubleValue() {
            AppMethodBeat.i(219076);
            if (this.SEG == null) {
                AppMethodBeat.o(219076);
                return 0.0d;
            }
            double doubleValue = ((Double) this.SEG).doubleValue();
            AppMethodBeat.o(219076);
            return doubleValue;
        }

        public final int intValue() {
            AppMethodBeat.i(219077);
            if (this.SEG == null) {
                AppMethodBeat.o(219077);
                return 0;
            }
            int intValue = ((Integer) this.SEG).intValue();
            AppMethodBeat.o(219077);
            return intValue;
        }
    }

    public static a bsC(String str) {
        AppMethodBeat.i(219078);
        a aVar = new a();
        try {
            aVar.SEG = Double.valueOf(Double.parseDouble(str));
            aVar.SEF = true;
        } catch (Exception e2) {
            Log.e("NumberUtil", "safeGetDouble failed : " + e2.getMessage());
        }
        AppMethodBeat.o(219078);
        return aVar;
    }

    public static a bsD(String str) {
        AppMethodBeat.i(219079);
        a aVar = new a();
        try {
            String trim = str.trim();
            while (trim.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO) && trim.length() > 1) {
                trim = trim.substring(1);
            }
            aVar.SEG = Integer.valueOf(Integer.parseInt(trim));
            aVar.SEF = true;
        } catch (Exception e2) {
            Log.e("NumberUtil", "safeParseInt failed : " + e2.getMessage());
        }
        AppMethodBeat.o(219079);
        return aVar;
    }

    public static long htR() {
        AppMethodBeat.i(219080);
        Calendar instance = Calendar.getInstance();
        long j2 = (((long) (24 - instance.get(11))) * Util.MILLSECONDS_OF_HOUR) - (((long) instance.get(12)) * Util.MILLSECONDS_OF_MINUTE);
        AppMethodBeat.o(219080);
        return j2;
    }

    public static long c(Calendar calendar) {
        AppMethodBeat.i(219081);
        long j2 = ((((long) (24 - calendar.get(11))) * Util.MILLSECONDS_OF_HOUR) - (((long) calendar.get(12)) * Util.MILLSECONDS_OF_MINUTE)) - ((long) (calendar.get(13) * 1000));
        AppMethodBeat.o(219081);
        return j2;
    }

    public static double OP(long j2) {
        AppMethodBeat.i(219082);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j2);
        double d2 = ((double) instance.get(11)) + (((double) instance.get(12)) / 60.0d);
        AppMethodBeat.o(219082);
        return d2;
    }

    public static double htS() {
        AppMethodBeat.i(219083);
        Calendar instance = Calendar.getInstance();
        double d2 = ((double) instance.get(11)) + (((double) instance.get(12)) / 60.0d);
        AppMethodBeat.o(219083);
        return d2;
    }

    public static double d(Calendar calendar) {
        AppMethodBeat.i(219084);
        double d2 = ((double) calendar.get(11)) + (((double) calendar.get(12)) / 60.0d);
        AppMethodBeat.o(219084);
        return d2;
    }

    public static double bsE(String str) {
        AppMethodBeat.i(219085);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(219085);
            return -1.0d;
        }
        String[] split = str.split(":");
        if (split == null || split.length == 0) {
            AppMethodBeat.o(219085);
            return -1.0d;
        }
        a bsC = bsC(split[0]);
        if (!bsC.SEF) {
            AppMethodBeat.o(219085);
            return -1.0d;
        }
        double doubleValue = bsC.doubleValue();
        if (split.length == 2) {
            int intValue = bsD(split[1]).intValue();
            if (intValue < 0 || intValue >= 60) {
                AppMethodBeat.o(219085);
                return -1.0d;
            }
            doubleValue += (((double) intValue) * 1.0d) / 60.0d;
        }
        if (doubleValue < 0.0d || doubleValue > 24.0d) {
            AppMethodBeat.o(219085);
            return -1.0d;
        }
        AppMethodBeat.o(219085);
        return doubleValue;
    }
}
