package com.facebook.appevents.internal;

import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;

class SessionLogger {
    private static final long[] INACTIVE_SECONDS_QUANTA = {300000, 900000, 1800000, Util.MILLSECONDS_OF_HOUR, 21600000, 43200000, Util.MILLSECONDS_OF_DAY, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};
    private static final String TAG = SessionLogger.class.getCanonicalName();

    SessionLogger() {
    }

    static {
        AppMethodBeat.i(17659);
        AppMethodBeat.o(17659);
    }

    public static void logActivateApp(String str, SourceApplicationInfo sourceApplicationInfo, String str2) {
        AppMethodBeat.i(17656);
        String sourceApplicationInfo2 = sourceApplicationInfo != null ? sourceApplicationInfo.toString() : "Unclassified";
        Bundle bundle = new Bundle();
        bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, sourceApplicationInfo2);
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(str, str2, null);
        internalAppEventsLogger.logEvent(AppEventsConstants.EVENT_NAME_ACTIVATED_APP, bundle);
        if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
            internalAppEventsLogger.flush();
        }
        AppMethodBeat.o(17656);
    }

    public static void logDeactivateApp(String str, SessionInfo sessionInfo, String str2) {
        AppMethodBeat.i(17657);
        Long valueOf = Long.valueOf(sessionInfo.getDiskRestoreTime() - sessionInfo.getSessionLastEventTime().longValue());
        if (valueOf.longValue() < 0) {
            valueOf = 0L;
            logClockSkewEvent();
        }
        Long valueOf2 = Long.valueOf(sessionInfo.getSessionLength());
        if (valueOf2.longValue() < 0) {
            logClockSkewEvent();
            valueOf2 = 0L;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(AppEventsConstants.EVENT_NAME_SESSION_INTERRUPTIONS, sessionInfo.getInterruptionCount());
        bundle.putString(AppEventsConstants.EVENT_NAME_TIME_BETWEEN_SESSIONS, String.format(Locale.ROOT, "session_quanta_%d", Integer.valueOf(getQuantaIndex(valueOf.longValue()))));
        SourceApplicationInfo sourceApplicationInfo = sessionInfo.getSourceApplicationInfo();
        bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, sourceApplicationInfo != null ? sourceApplicationInfo.toString() : "Unclassified");
        bundle.putLong(Constants.LOG_TIME_APP_EVENT_KEY, sessionInfo.getSessionLastEventTime().longValue() / 1000);
        new InternalAppEventsLogger(str, str2, null).logEvent(AppEventsConstants.EVENT_NAME_DEACTIVATED_APP, (double) (valueOf2.longValue() / 1000), bundle);
        AppMethodBeat.o(17657);
    }

    private static void logClockSkewEvent() {
        AppMethodBeat.i(17658);
        Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
        AppMethodBeat.o(17658);
    }

    private static int getQuantaIndex(long j2) {
        int i2 = 0;
        while (i2 < INACTIVE_SECONDS_QUANTA.length && INACTIVE_SECONDS_QUANTA[i2] < j2) {
            i2++;
        }
        return i2;
    }
}
