package com.google.android.gms.common.stats;

import android.content.AbstractThreadedSyncAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.DeviceStateUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

public class WakeLockTracker {
    @VisibleForTesting
    private static boolean zzyh = false;
    private static WakeLockTracker zzyz = new WakeLockTracker();
    private static Boolean zzza;

    static {
        AppMethodBeat.i(5013);
        AppMethodBeat.o(5013);
    }

    public static WakeLockTracker getInstance() {
        return zzyz;
    }

    public void registerAcquireEvent(Context context, Intent intent, String str, String str2, String str3, int i2, String str4) {
        AppMethodBeat.i(5008);
        registerAcquireEvent(context, intent, str, str2, str3, i2, Arrays.asList(str4));
        AppMethodBeat.o(5008);
    }

    public void registerAcquireEvent(Context context, Intent intent, String str, String str2, String str3, int i2, List<String> list) {
        AppMethodBeat.i(5009);
        registerEvent(context, intent.getStringExtra(LoggingConstants.EXTRA_WAKE_LOCK_KEY), 7, str, str2, str3, i2, list);
        AppMethodBeat.o(5009);
    }

    public void registerEvent(Context context, String str, int i2, String str2, String str3, String str4, int i3, List<String> list) {
        AppMethodBeat.i(5011);
        registerEvent(context, str, i2, str2, str3, str4, i3, list, 0);
        AppMethodBeat.o(5011);
    }

    public void registerEvent(Context context, String str, int i2, String str2, String str3, String str4, int i3, List<String> list, long j2) {
        List<String> list2;
        AppMethodBeat.i(5012);
        if (zzza == null) {
            zzza = Boolean.FALSE;
        }
        if (!zzza.booleanValue()) {
            AppMethodBeat.o(5012);
        } else if (TextUtils.isEmpty(str)) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "missing wakeLock key. ".concat(valueOf);
                AppMethodBeat.o(5012);
                return;
            }
            new String("missing wakeLock key. ");
            AppMethodBeat.o(5012);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (7 == i2 || 8 == i2 || 10 == i2 || 11 == i2) {
                if (list == null || list.size() != 1) {
                    list2 = list;
                } else {
                    if ("com.google.android.gms".equals(list.get(0))) {
                        list = null;
                    }
                    list2 = list;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int deviceState = DeviceStateUtils.getDeviceState(context);
                String packageName = context.getPackageName();
                if ("com.google.android.gms".equals(packageName)) {
                    packageName = null;
                }
                try {
                    context.startService(new Intent().setComponent(LoggingConstants.STATS_SERVICE_COMPONENT_NAME).putExtra(LoggingConstants.EXTRA_LOG_EVENT, new WakeLockEvent(currentTimeMillis, i2, str2, i3, list2, str, elapsedRealtime, deviceState, str3, packageName, DeviceStateUtils.getPowerPercentage(context), j2, str4)));
                    AppMethodBeat.o(5012);
                    return;
                } catch (Exception e2) {
                    Log.wtf("WakeLockTracker", e2);
                }
            }
            AppMethodBeat.o(5012);
        }
    }

    public void registerReleaseEvent(Context context, Intent intent) {
        AppMethodBeat.i(5010);
        registerEvent(context, intent.getStringExtra(LoggingConstants.EXTRA_WAKE_LOCK_KEY), 8, null, null, null, 0, null);
        AppMethodBeat.o(5010);
    }

    public void registerSyncEnd(Context context, AbstractThreadedSyncAdapter abstractThreadedSyncAdapter, String str, String str2, boolean z) {
        AppMethodBeat.i(5007);
        registerEvent(context, StatsUtils.getEventKey(abstractThreadedSyncAdapter, str), 11, str, str2, null, 0, null);
        AppMethodBeat.o(5007);
    }

    public void registerSyncStart(Context context, AbstractThreadedSyncAdapter abstractThreadedSyncAdapter, String str, String str2) {
        AppMethodBeat.i(5006);
        registerEvent(context, StatsUtils.getEventKey(abstractThreadedSyncAdapter, str), 10, str, str2, null, 0, null);
        AppMethodBeat.o(5006);
    }
}
