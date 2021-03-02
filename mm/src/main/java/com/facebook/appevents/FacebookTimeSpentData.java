package com.facebook.appevents;

import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Serializable;
import java.util.Locale;

/* access modifiers changed from: package-private */
public class FacebookTimeSpentData implements Serializable {
    private static final long APP_ACTIVATE_SUPPRESSION_PERIOD_IN_MILLISECONDS = 300000;
    private static final long FIRST_TIME_LOAD_RESUME_TIME = -1;
    private static final long[] INACTIVE_SECONDS_QUANTA = {APP_ACTIVATE_SUPPRESSION_PERIOD_IN_MILLISECONDS, 900000, 1800000, Util.MILLSECONDS_OF_HOUR, 21600000, 43200000, Util.MILLSECONDS_OF_DAY, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};
    private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000;
    private static final long NUM_MILLISECONDS_IDLE_TO_BE_NEW_SESSION = 60000;
    private static final String TAG = FacebookTimeSpentData.class.getCanonicalName();
    private static final long serialVersionUID = 1;
    private String firstOpenSourceApplication;
    private int interruptionCount;
    private boolean isAppActive;
    private boolean isWarmLaunch;
    private long lastActivateEventLoggedTime;
    private long lastResumeTime;
    private long lastSuspendTime;
    private long millisecondsSpentInSession;

    static {
        AppMethodBeat.i(17433);
        AppMethodBeat.o(17433);
    }

    static class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = 6;
        private final int interruptionCount;
        private final long lastResumeTime;
        private final long lastSuspendTime;
        private final long millisecondsSpentInSession;

        SerializationProxyV1(long j2, long j3, long j4, int i2) {
            this.lastResumeTime = j2;
            this.lastSuspendTime = j3;
            this.millisecondsSpentInSession = j4;
            this.interruptionCount = i2;
        }

        private Object readResolve() {
            AppMethodBeat.i(17424);
            FacebookTimeSpentData facebookTimeSpentData = new FacebookTimeSpentData(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount);
            AppMethodBeat.o(17424);
            return facebookTimeSpentData;
        }
    }

    private FacebookTimeSpentData(long j2, long j3, long j4, int i2) {
        AppMethodBeat.i(17426);
        resetSession();
        this.lastResumeTime = j2;
        this.lastSuspendTime = j3;
        this.millisecondsSpentInSession = j4;
        this.interruptionCount = i2;
        AppMethodBeat.o(17426);
    }

    static class SerializationProxyV2 implements Serializable {
        private static final long serialVersionUID = 6;
        private final String firstOpenSourceApplication;
        private final int interruptionCount;
        private final long lastResumeTime;
        private final long lastSuspendTime;
        private final long millisecondsSpentInSession;

        SerializationProxyV2(long j2, long j3, long j4, int i2, String str) {
            this.lastResumeTime = j2;
            this.lastSuspendTime = j3;
            this.millisecondsSpentInSession = j4;
            this.interruptionCount = i2;
            this.firstOpenSourceApplication = str;
        }

        private Object readResolve() {
            AppMethodBeat.i(17425);
            FacebookTimeSpentData facebookTimeSpentData = new FacebookTimeSpentData(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, this.firstOpenSourceApplication);
            AppMethodBeat.o(17425);
            return facebookTimeSpentData;
        }
    }

    FacebookTimeSpentData() {
        AppMethodBeat.i(17427);
        resetSession();
        AppMethodBeat.o(17427);
    }

    private FacebookTimeSpentData(long j2, long j3, long j4, int i2, String str) {
        AppMethodBeat.i(17428);
        resetSession();
        this.lastResumeTime = j2;
        this.lastSuspendTime = j3;
        this.millisecondsSpentInSession = j4;
        this.interruptionCount = i2;
        this.firstOpenSourceApplication = str;
        AppMethodBeat.o(17428);
    }

    private Object writeReplace() {
        AppMethodBeat.i(17429);
        SerializationProxyV2 serializationProxyV2 = new SerializationProxyV2(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, this.firstOpenSourceApplication);
        AppMethodBeat.o(17429);
        return serializationProxyV2;
    }

    /* access modifiers changed from: package-private */
    public void onSuspend(AppEventsLogger appEventsLogger, long j2) {
        long j3 = 0;
        AppMethodBeat.i(17430);
        if (!this.isAppActive) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Suspend for inactive app");
            AppMethodBeat.o(17430);
            return;
        }
        long j4 = j2 - this.lastResumeTime;
        if (j4 < 0) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
        } else {
            j3 = j4;
        }
        this.millisecondsSpentInSession = j3 + this.millisecondsSpentInSession;
        this.lastSuspendTime = j2;
        this.isAppActive = false;
        AppMethodBeat.o(17430);
    }

    /* access modifiers changed from: package-private */
    public void onResume(AppEventsLogger appEventsLogger, long j2, String str) {
        long j3 = 0;
        AppMethodBeat.i(17431);
        if (isColdLaunch() || j2 - this.lastActivateEventLoggedTime > APP_ACTIVATE_SUPPRESSION_PERIOD_IN_MILLISECONDS) {
            Bundle bundle = new Bundle();
            bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, str);
            appEventsLogger.logEvent(AppEventsConstants.EVENT_NAME_ACTIVATED_APP, bundle);
            this.lastActivateEventLoggedTime = j2;
            if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                appEventsLogger.flush();
            }
        }
        if (this.isAppActive) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Resume for active app");
            AppMethodBeat.o(17431);
            return;
        }
        long j4 = wasSuspendedEver() ? j2 - this.lastSuspendTime : 0;
        if (j4 < 0) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
        } else {
            j3 = j4;
        }
        if (j3 > 60000) {
            logAppDeactivatedEvent(appEventsLogger, j3);
        } else if (j3 > 1000) {
            this.interruptionCount++;
        }
        if (this.interruptionCount == 0) {
            this.firstOpenSourceApplication = str;
        }
        this.lastResumeTime = j2;
        this.isAppActive = true;
        AppMethodBeat.o(17431);
    }

    private void logAppDeactivatedEvent(AppEventsLogger appEventsLogger, long j2) {
        AppMethodBeat.i(17432);
        Bundle bundle = new Bundle();
        bundle.putInt(AppEventsConstants.EVENT_NAME_SESSION_INTERRUPTIONS, this.interruptionCount);
        bundle.putString(AppEventsConstants.EVENT_NAME_TIME_BETWEEN_SESSIONS, String.format(Locale.ROOT, "session_quanta_%d", Integer.valueOf(getQuantaIndex(j2))));
        bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, this.firstOpenSourceApplication);
        appEventsLogger.logEvent(AppEventsConstants.EVENT_NAME_DEACTIVATED_APP, (double) (this.millisecondsSpentInSession / 1000), bundle);
        resetSession();
        AppMethodBeat.o(17432);
    }

    private static int getQuantaIndex(long j2) {
        int i2 = 0;
        while (i2 < INACTIVE_SECONDS_QUANTA.length && INACTIVE_SECONDS_QUANTA[i2] < j2) {
            i2++;
        }
        return i2;
    }

    private void resetSession() {
        this.isAppActive = false;
        this.lastResumeTime = -1;
        this.lastSuspendTime = -1;
        this.interruptionCount = 0;
        this.millisecondsSpentInSession = 0;
    }

    private boolean wasSuspendedEver() {
        return this.lastSuspendTime != -1;
    }

    private boolean isColdLaunch() {
        boolean z = !this.isWarmLaunch;
        this.isWarmLaunch = true;
        return z;
    }
}
