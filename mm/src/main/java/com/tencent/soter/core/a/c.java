package com.tencent.soter.core.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

@Deprecated
public final class c {
    static boolean isSystemHasAntiBruteForce() {
        return Build.VERSION.SDK_INT >= 23;
    }

    static int getCurrentFailTime(Context context) {
        AppMethodBeat.i(88623);
        Integer valueOf = Integer.valueOf(getCurrentFailTimeInDB(context));
        d.i("Soter.SoterAntiBruteForceStrategy", "soter: current retry time: ".concat(String.valueOf(valueOf)), new Object[0]);
        int intValue = valueOf.intValue();
        AppMethodBeat.o(88623);
        return intValue;
    }

    static void setCurrentFailTime(Context context, int i2) {
        AppMethodBeat.i(88624);
        d.i("Soter.SoterAntiBruteForceStrategy", "soter: setting to time: ".concat(String.valueOf(i2)), new Object[0]);
        if (i2 < 0) {
            d.w("Soter.SoterAntiBruteForceStrategy", "soter: illegal fail time", new Object[0]);
            AppMethodBeat.o(88624);
            return;
        }
        setCurrentFailTimeInDB(context, i2);
        AppMethodBeat.o(88624);
    }

    private static void setLastFreezeTime(Context context, long j2) {
        AppMethodBeat.i(88626);
        d.i("Soter.SoterAntiBruteForceStrategy", "soter: setting last freeze time: ".concat(String.valueOf(j2)), new Object[0]);
        if (j2 < -1) {
            d.w("Soter.SoterAntiBruteForceStrategy", "soter: illegal setLastFreezeTime", new Object[0]);
            AppMethodBeat.o(88626);
        } else if (context == null) {
            d.e("Soter.SoterAntiBruteForceStrategy", "soter: context is null", new Object[0]);
            AppMethodBeat.o(88626);
        } else {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putLong("key_last_freeze_time", j2);
            edit.apply();
            AppMethodBeat.o(88626);
        }
    }

    static void freeze(Context context) {
        AppMethodBeat.i(88627);
        setCurrentFailTime(context, 6);
        setLastFreezeTime(context, System.currentTimeMillis());
        AppMethodBeat.o(88627);
    }

    static void unFreeze(Context context) {
        AppMethodBeat.i(88628);
        setLastFreezeTime(context, -1);
        setCurrentFailTime(context, 0);
        AppMethodBeat.o(88628);
    }

    public static boolean isCurrentTweenTimeAvailable(Context context) {
        AppMethodBeat.i(88629);
        int currentTimeMillis = (int) ((System.currentTimeMillis() - getLastFreezeTime(context)) / 1000);
        d.i("Soter.SoterAntiBruteForceStrategy", "soter: tween sec after last freeze: ".concat(String.valueOf(currentTimeMillis)), new Object[0]);
        if (currentTimeMillis > 30) {
            d.d("Soter.SoterAntiBruteForceStrategy", "soter: after last freeze", new Object[0]);
            AppMethodBeat.o(88629);
            return true;
        }
        AppMethodBeat.o(88629);
        return false;
    }

    public static boolean isCurrentFailTimeAvailable(Context context) {
        AppMethodBeat.i(88630);
        if (getCurrentFailTime(context) < 5) {
            d.i("Soter.SoterAntiBruteForceStrategy", "soter: fail time available", new Object[0]);
            AppMethodBeat.o(88630);
            return true;
        }
        AppMethodBeat.o(88630);
        return false;
    }

    private static void setCurrentFailTimeInDB(Context context, int i2) {
        AppMethodBeat.i(88631);
        if (context == null) {
            d.e("Soter.SoterAntiBruteForceStrategy", "soter: context is null", new Object[0]);
            AppMethodBeat.o(88631);
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("key_fail_times", i2);
        edit.apply();
        AppMethodBeat.o(88631);
    }

    private static int getCurrentFailTimeInDB(Context context) {
        AppMethodBeat.i(88632);
        int i2 = PreferenceManager.getDefaultSharedPreferences(context).getInt("key_fail_times", 0);
        AppMethodBeat.o(88632);
        return i2;
    }

    private static long getLastFreezeTime(Context context) {
        AppMethodBeat.i(88625);
        Long valueOf = Long.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getLong("key_last_freeze_time", -1));
        d.i("Soter.SoterAntiBruteForceStrategy", "soter: current last freeze time: ".concat(String.valueOf(valueOf)), new Object[0]);
        long longValue = valueOf.longValue();
        AppMethodBeat.o(88625);
        return longValue;
    }
}
