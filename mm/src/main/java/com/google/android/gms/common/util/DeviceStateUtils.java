package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import com.google.android.gms.internal.stable.zzg;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class DeviceStateUtils {
    private static final IntentFilter filter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static long zzzw;
    private static float zzzx = Float.NaN;

    static {
        AppMethodBeat.i(5217);
        AppMethodBeat.o(5217);
    }

    private DeviceStateUtils() {
    }

    @TargetApi(20)
    public static int getDeviceState(Context context) {
        int i2 = 1;
        AppMethodBeat.i(5210);
        if (context == null || context.getApplicationContext() == null) {
            AppMethodBeat.o(5210);
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, filter);
        boolean z = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            AppMethodBeat.o(5210);
            return -1;
        }
        int i3 = (isInteractive(powerManager) ? 1 : 0) << 1;
        if (!z) {
            i2 = 0;
        }
        int i4 = i3 | i2;
        AppMethodBeat.o(5210);
        return i4;
    }

    public static synchronized float getPowerPercentage(Context context) {
        float f2;
        synchronized (DeviceStateUtils.class) {
            AppMethodBeat.i(5213);
            if (SystemClock.elapsedRealtime() - zzzw >= Util.MILLSECONDS_OF_MINUTE || Float.isNaN(zzzx)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver(null, filter);
                if (registerReceiver != null) {
                    zzzx = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                zzzw = SystemClock.elapsedRealtime();
                f2 = zzzx;
                AppMethodBeat.o(5213);
            } else {
                f2 = zzzx;
                AppMethodBeat.o(5213);
            }
        }
        return f2;
    }

    public static boolean hasConsentedNlp(Context context) {
        AppMethodBeat.i(5216);
        if (zzg.getInt(context.getContentResolver(), "network_location_opt_in", -1) == 1) {
            AppMethodBeat.o(5216);
            return true;
        }
        AppMethodBeat.o(5216);
        return false;
    }

    public static boolean isCallActive(Context context) {
        AppMethodBeat.i(5214);
        if (((AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getMode() == 2) {
            AppMethodBeat.o(5214);
            return true;
        }
        AppMethodBeat.o(5214);
        return false;
    }

    public static boolean isInteractive(Context context) {
        AppMethodBeat.i(5211);
        boolean isInteractive = isInteractive((PowerManager) context.getSystemService("power"));
        AppMethodBeat.o(5211);
        return isInteractive;
    }

    @TargetApi(20)
    public static boolean isInteractive(PowerManager powerManager) {
        AppMethodBeat.i(5212);
        if (PlatformVersion.isAtLeastKitKatWatch()) {
            boolean isInteractive = powerManager.isInteractive();
            AppMethodBeat.o(5212);
            return isInteractive;
        }
        boolean isScreenOn = powerManager.isScreenOn();
        AppMethodBeat.o(5212);
        return isScreenOn;
    }

    public static boolean isUserSetupComplete(Context context) {
        AppMethodBeat.i(5215);
        if (Build.VERSION.SDK_INT < 23 || Settings.Secure.getInt(context.getContentResolver(), "user_setup_complete", -1) == 1) {
            AppMethodBeat.o(5215);
            return true;
        }
        AppMethodBeat.o(5215);
        return false;
    }

    @VisibleForTesting
    public static synchronized void resetForTest() {
        synchronized (DeviceStateUtils.class) {
            zzzw = 0;
            zzzx = Float.NaN;
        }
    }
}
