package com.facebook.appevents.internal;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

/* access modifiers changed from: package-private */
public class SessionInfo {
    private static final String INTERRUPTION_COUNT_KEY = "com.facebook.appevents.SessionInfo.interruptionCount";
    private static final String LAST_SESSION_INFO_END_KEY = "com.facebook.appevents.SessionInfo.sessionEndTime";
    private static final String LAST_SESSION_INFO_START_KEY = "com.facebook.appevents.SessionInfo.sessionStartTime";
    private static final String SESSION_ID_KEY = "com.facebook.appevents.SessionInfo.sessionId";
    private Long diskRestoreTime;
    private int interruptionCount;
    private UUID sessionId;
    private Long sessionLastEventTime;
    private Long sessionStartTime;
    private SourceApplicationInfo sourceApplicationInfo;

    public SessionInfo(Long l, Long l2) {
        this(l, l2, UUID.randomUUID());
        AppMethodBeat.i(17650);
        AppMethodBeat.o(17650);
    }

    public SessionInfo(Long l, Long l2, UUID uuid) {
        this.sessionStartTime = l;
        this.sessionLastEventTime = l2;
        this.sessionId = uuid;
    }

    public static SessionInfo getStoredSessionInfo() {
        AppMethodBeat.i(17651);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
        long j2 = defaultSharedPreferences.getLong(LAST_SESSION_INFO_START_KEY, 0);
        long j3 = defaultSharedPreferences.getLong(LAST_SESSION_INFO_END_KEY, 0);
        String string = defaultSharedPreferences.getString(SESSION_ID_KEY, null);
        if (j2 == 0 || j3 == 0 || string == null) {
            AppMethodBeat.o(17651);
            return null;
        }
        SessionInfo sessionInfo = new SessionInfo(Long.valueOf(j2), Long.valueOf(j3));
        sessionInfo.interruptionCount = defaultSharedPreferences.getInt(INTERRUPTION_COUNT_KEY, 0);
        sessionInfo.sourceApplicationInfo = SourceApplicationInfo.getStoredSourceApplicatioInfo();
        sessionInfo.diskRestoreTime = Long.valueOf(System.currentTimeMillis());
        sessionInfo.sessionId = UUID.fromString(string);
        AppMethodBeat.o(17651);
        return sessionInfo;
    }

    public static void clearSavedSessionFromDisk() {
        AppMethodBeat.i(17652);
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.remove(LAST_SESSION_INFO_START_KEY);
        edit.remove(LAST_SESSION_INFO_END_KEY);
        edit.remove(INTERRUPTION_COUNT_KEY);
        edit.remove(SESSION_ID_KEY);
        edit.apply();
        SourceApplicationInfo.clearSavedSourceApplicationInfoFromDisk();
        AppMethodBeat.o(17652);
    }

    public Long getSessionStartTime() {
        return this.sessionStartTime;
    }

    public Long getSessionLastEventTime() {
        return this.sessionLastEventTime;
    }

    public void setSessionLastEventTime(Long l) {
        this.sessionLastEventTime = l;
    }

    public int getInterruptionCount() {
        return this.interruptionCount;
    }

    public void incrementInterruptionCount() {
        this.interruptionCount++;
    }

    public long getDiskRestoreTime() {
        AppMethodBeat.i(17653);
        if (this.diskRestoreTime == null) {
            AppMethodBeat.o(17653);
            return 0;
        }
        long longValue = this.diskRestoreTime.longValue();
        AppMethodBeat.o(17653);
        return longValue;
    }

    public UUID getSessionId() {
        return this.sessionId;
    }

    public long getSessionLength() {
        AppMethodBeat.i(17654);
        if (this.sessionStartTime == null || this.sessionLastEventTime == null) {
            AppMethodBeat.o(17654);
            return 0;
        }
        long longValue = this.sessionLastEventTime.longValue() - this.sessionStartTime.longValue();
        AppMethodBeat.o(17654);
        return longValue;
    }

    public SourceApplicationInfo getSourceApplicationInfo() {
        return this.sourceApplicationInfo;
    }

    public void setSourceApplicationInfo(SourceApplicationInfo sourceApplicationInfo2) {
        this.sourceApplicationInfo = sourceApplicationInfo2;
    }

    public void writeSessionToDisk() {
        AppMethodBeat.i(17655);
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.putLong(LAST_SESSION_INFO_START_KEY, this.sessionStartTime.longValue());
        edit.putLong(LAST_SESSION_INFO_END_KEY, this.sessionLastEventTime.longValue());
        edit.putInt(INTERRUPTION_COUNT_KEY, this.interruptionCount);
        edit.putString(SESSION_ID_KEY, this.sessionId.toString());
        edit.apply();
        if (this.sourceApplicationInfo != null) {
            this.sourceApplicationInfo.writeSourceApplicationInfoToDisk();
        }
        AppMethodBeat.o(17655);
    }
}
