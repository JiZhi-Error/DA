package com.tencent.soter.core.biometric;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

/* access modifiers changed from: package-private */
public class SoterBiometricAntiBruteForceStrategy {
    private static final long DEFAULT_FREEZE_TIME = -1;
    private static final int FREEZE_SECOND = 30;
    private static final String KEY_FAIL_TIMES = "key_fail_times";
    private static final String KEY_LAST_FREEZE_TIME = "key_last_freeze_time";
    private static final int MAX_FAIL_NUM = 5;
    private static final String TAG = "Soter.SoterBiometricAntiBruteForceStrategy";

    SoterBiometricAntiBruteForceStrategy() {
    }

    static boolean isSystemHasAntiBruteForce() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static int getCurrentFailTime(Context context) {
        AppMethodBeat.i(88589);
        Integer valueOf = Integer.valueOf(getCurrentFailTimeInDB(context));
        d.i(TAG, "soter: current retry time: ".concat(String.valueOf(valueOf)), new Object[0]);
        int intValue = valueOf.intValue();
        AppMethodBeat.o(88589);
        return intValue;
    }

    private static void setCurrentFailTime(Context context, int i2) {
        AppMethodBeat.i(88590);
        d.i(TAG, "soter: setting to time: ".concat(String.valueOf(i2)), new Object[0]);
        if (i2 < 0) {
            d.w(TAG, "soter: illegal fail time", new Object[0]);
            AppMethodBeat.o(88590);
            return;
        }
        setCurrentFailTimeInDB(context, i2);
        AppMethodBeat.o(88590);
    }

    private static long getLastFreezeTime(Context context) {
        AppMethodBeat.i(88591);
        Long valueOf = Long.valueOf(getLastFreezeTimeInDB(context));
        d.i(TAG, "soter: current last freeze time: ".concat(String.valueOf(valueOf)), new Object[0]);
        long longValue = valueOf.longValue();
        AppMethodBeat.o(88591);
        return longValue;
    }

    private static void setLastFreezeTime(Context context, long j2) {
        AppMethodBeat.i(88592);
        d.i(TAG, "soter: setting last freeze time: ".concat(String.valueOf(j2)), new Object[0]);
        if (j2 < -1) {
            d.w(TAG, "soter: illegal setLastFreezeTime", new Object[0]);
            AppMethodBeat.o(88592);
            return;
        }
        setLastFreezeTimeInDB(context, j2);
        AppMethodBeat.o(88592);
    }

    static void freeze(Context context) {
        AppMethodBeat.i(88593);
        setCurrentFailTime(context, 6);
        setLastFreezeTime(context, System.currentTimeMillis());
        AppMethodBeat.o(88593);
    }

    static void unFreeze(Context context) {
        AppMethodBeat.i(88594);
        setLastFreezeTime(context, -1);
        setCurrentFailTime(context, 0);
        AppMethodBeat.o(88594);
    }

    static void addFailTime(Context context) {
        AppMethodBeat.i(88595);
        setCurrentFailTime(context, Integer.valueOf(getCurrentFailTime(context)).intValue() + 1);
        AppMethodBeat.o(88595);
    }

    static boolean isCurrentTweenTimeAvailable(Context context) {
        AppMethodBeat.i(88596);
        int currentTimeMillis = (int) ((System.currentTimeMillis() - getLastFreezeTime(context)) / 1000);
        d.i(TAG, "soter: tween sec after last freeze: ".concat(String.valueOf(currentTimeMillis)), new Object[0]);
        if (currentTimeMillis > 30) {
            d.d(TAG, "soter: after last freeze", new Object[0]);
            AppMethodBeat.o(88596);
            return true;
        }
        AppMethodBeat.o(88596);
        return false;
    }

    static boolean isCurrentFailTimeAvailable(Context context) {
        AppMethodBeat.i(88597);
        if (getCurrentFailTime(context) < 5) {
            d.i(TAG, "soter: fail time available", new Object[0]);
            AppMethodBeat.o(88597);
            return true;
        }
        AppMethodBeat.o(88597);
        return false;
    }

    private static void setCurrentFailTimeInDB(Context context, int i2) {
        AppMethodBeat.i(88598);
        if (context == null) {
            d.e(TAG, "soter: context is null", new Object[0]);
            AppMethodBeat.o(88598);
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(KEY_FAIL_TIMES, i2);
        edit.apply();
        AppMethodBeat.o(88598);
    }

    private static int getCurrentFailTimeInDB(Context context) {
        AppMethodBeat.i(88599);
        int i2 = PreferenceManager.getDefaultSharedPreferences(context).getInt(KEY_FAIL_TIMES, 0);
        AppMethodBeat.o(88599);
        return i2;
    }

    private static long getLastFreezeTimeInDB(Context context) {
        AppMethodBeat.i(88600);
        long j2 = PreferenceManager.getDefaultSharedPreferences(context).getLong(KEY_LAST_FREEZE_TIME, -1);
        AppMethodBeat.o(88600);
        return j2;
    }

    private static void setLastFreezeTimeInDB(Context context, long j2) {
        AppMethodBeat.i(88601);
        if (context == null) {
            d.e(TAG, "soter: context is null", new Object[0]);
            AppMethodBeat.o(88601);
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong(KEY_LAST_FREEZE_TIME, j2);
        edit.apply();
        AppMethodBeat.o(88601);
    }
}
