package com.tencent.mm.plugin.sns.ad.i;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Util;

public final class e {

    public static class a {
        public int grV;
        public int hour;
        public int minute;
        public int second;

        public final String toString() {
            AppMethodBeat.i(202355);
            String str = "DateTime{day=" + this.grV + ", hour=" + this.hour + ", minute=" + this.minute + ", second=" + this.second + '}' + '@' + hashCode();
            AppMethodBeat.o(202355);
            return str;
        }
    }

    public static a a(long j2, a aVar) {
        AppMethodBeat.i(202356);
        if (aVar == null) {
            aVar = new a();
        }
        aVar.grV = (int) (j2 / Util.MILLSECONDS_OF_DAY);
        aVar.hour = (int) ((j2 - (((long) aVar.grV) * Util.MILLSECONDS_OF_DAY)) / Util.MILLSECONDS_OF_HOUR);
        aVar.minute = (int) (((j2 - (((long) aVar.grV) * Util.MILLSECONDS_OF_DAY)) - (((long) aVar.hour) * Util.MILLSECONDS_OF_HOUR)) / Util.MILLSECONDS_OF_MINUTE);
        aVar.second = (int) ((((j2 - (((long) aVar.grV) * Util.MILLSECONDS_OF_DAY)) - (((long) aVar.hour) * Util.MILLSECONDS_OF_HOUR)) - (((long) aVar.minute) * Util.MILLSECONDS_OF_MINUTE)) / 1000);
        AppMethodBeat.o(202356);
        return aVar;
    }

    public static String XS(int i2) {
        AppMethodBeat.i(202357);
        if (i2 > 9 || i2 < 0) {
            String valueOf = String.valueOf(i2);
            AppMethodBeat.o(202357);
            return valueOf;
        }
        String concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i2));
        AppMethodBeat.o(202357);
        return concat;
    }

    public static boolean ap(long j2, long j3) {
        AppMethodBeat.i(202358);
        long aWA = cl.aWA();
        if (j2 == 0) {
            j2 = aWA;
        }
        if (j2 < 0 || j2 > aWA || j3 < aWA) {
            AppMethodBeat.o(202358);
            return false;
        } else if (((int) ((j3 - aWA) / Util.MILLSECONDS_OF_DAY)) < 100) {
            AppMethodBeat.o(202358);
            return true;
        } else {
            AppMethodBeat.o(202358);
            return false;
        }
    }
}
