package com.google.android.gms.common.stats;

import android.content.AbstractThreadedSyncAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.stats.StatisticalEventTrackerProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class StatsUtils {
    public static String getEventKey(AbstractThreadedSyncAdapter abstractThreadedSyncAdapter, String str) {
        AppMethodBeat.i(4994);
        String valueOf = String.valueOf(String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(abstractThreadedSyncAdapter))));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String valueOf2 = String.valueOf(str);
        if (valueOf2.length() != 0) {
            String concat = valueOf.concat(valueOf2);
            AppMethodBeat.o(4994);
            return concat;
        }
        String str2 = new String(valueOf);
        AppMethodBeat.o(4994);
        return str2;
    }

    public static String getEventKey(Context context, Intent intent) {
        AppMethodBeat.i(4992);
        String valueOf = String.valueOf((((long) System.identityHashCode(context)) << 32) | ((long) System.identityHashCode(intent)));
        AppMethodBeat.o(4992);
        return valueOf;
    }

    public static String getEventKey(PowerManager.WakeLock wakeLock, String str) {
        AppMethodBeat.i(4993);
        String valueOf = String.valueOf(String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(wakeLock))));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String valueOf2 = String.valueOf(str);
        if (valueOf2.length() != 0) {
            String concat = valueOf.concat(valueOf2);
            AppMethodBeat.o(4993);
            return concat;
        }
        String str2 = new String(valueOf);
        AppMethodBeat.o(4993);
        return str2;
    }

    public static boolean isLoggingEnabled() {
        AppMethodBeat.i(4991);
        StatisticalEventTrackerProvider.StatisticalEventTracker impl = StatisticalEventTrackerProvider.getImpl();
        if (impl == null || !impl.isEnabled() || (!zza(Integer.valueOf(impl.getLogLevel(3))) && !zza(Integer.valueOf(impl.getLogLevel(2))) && !zza(Integer.valueOf(impl.getLogLevel(1))))) {
            AppMethodBeat.o(4991);
            return false;
        }
        AppMethodBeat.o(4991);
        return true;
    }

    public static boolean isTimeOutEvent(StatsEvent statsEvent) {
        AppMethodBeat.i(4995);
        switch (statsEvent.getEventType()) {
            case 6:
            case 9:
            case 12:
                AppMethodBeat.o(4995);
                return true;
            default:
                AppMethodBeat.o(4995);
                return false;
        }
    }

    private static boolean zza(Integer num) {
        AppMethodBeat.i(4990);
        if (!num.equals(Integer.valueOf(LoggingConstants.LOG_LEVEL_OFF))) {
            AppMethodBeat.o(4990);
            return true;
        }
        AppMethodBeat.o(4990);
        return false;
    }
}
