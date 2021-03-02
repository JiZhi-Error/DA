package com.tencent.mars.ilink.comm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.mars.ilink.xlog.Log;
import com.tencent.mm.loader.BuildConfig;

public class AlarmHelper {
    private static final String TAG = "MicroMsg.AlarmHelper";

    public static PendingIntent set(Context context, int i2, int i3, long j2, Intent intent, int i4) {
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i3);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Long.valueOf(j2);
        objArr[3] = intent != null ? intent : BuildConfig.COMMAND;
        objArr[4] = Integer.valueOf(i4);
        Log.d(TAG, "set(type:%s requestCode:%s triggerAtMillis:%s intent:%s flags:%s)", objArr);
        if (context == null) {
            Log.e(TAG, "set(requestCode:%s): context == null", Integer.valueOf(i2));
            return null;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            Log.e(TAG, "set(requestCode:%s): am == null", Integer.valueOf(i2));
            return null;
        } else if (!isRequestCodeValid(i2)) {
            Log.e(TAG, "set(requestCode:%s): requestCode invalid", Integer.valueOf(i2));
            return null;
        } else {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, i2, intent, i4);
            alarmManager.set(i3, j2, broadcast);
            return broadcast;
        }
    }

    public static PendingIntent setExact(Context context, int i2, int i3, long j2, Intent intent, int i4) {
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i3);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Long.valueOf(j2);
        objArr[3] = intent != null ? intent : BuildConfig.COMMAND;
        objArr[4] = Integer.valueOf(i4);
        Log.d(TAG, "setExact(type:%s requestCode:%s triggerAtMillis:%s intent:%s flags:%s)", objArr);
        if (context == null) {
            Log.e(TAG, "setExact(requestCode:%s): context == null", Integer.valueOf(i2));
            return null;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            Log.e(TAG, "setExact(requestCode:%s): am == null", Integer.valueOf(i2));
            return null;
        } else if (!isRequestCodeValid(i2)) {
            Log.e(TAG, "setExact(requestCode:%s): requestCode invalid", Integer.valueOf(i2));
            return null;
        } else {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, i2, intent, i4);
            alarmManager.set(i3, j2, broadcast);
            return broadcast;
        }
    }

    public static PendingIntent setRepeating(Context context, int i2, int i3, long j2, long j3, Intent intent, int i4) {
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(i3);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Long.valueOf(j2);
        objArr[3] = Long.valueOf(j3);
        objArr[4] = intent != null ? intent : BuildConfig.COMMAND;
        objArr[5] = Integer.valueOf(i4);
        Log.d(TAG, "setRepeating(type:%s requestCode:%s triggerAtMillis:%s intervalMillis:%s intent:%s flags:%s)", objArr);
        if (context == null) {
            Log.e(TAG, "setRepeating(requestCode:%s): context == null", Integer.valueOf(i2));
            return null;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            Log.e(TAG, "setRepeating(requestCode:%s): am == null", Integer.valueOf(i2));
            return null;
        } else if (!isRequestCodeValid(i2)) {
            Log.e(TAG, "setRepeating(requestCode:%s): requestCode invalid", Integer.valueOf(i2));
            return null;
        } else {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, i2, intent, i4);
            alarmManager.set(i3, j2, broadcast);
            return broadcast;
        }
    }

    public static void cancel(Context context, PendingIntent pendingIntent) {
        Object[] objArr = new Object[1];
        objArr[0] = pendingIntent != null ? pendingIntent.toString() : BuildConfig.COMMAND;
        Log.d(TAG, "cancel(operation:%s)", objArr);
        if (context == null) {
            Log.e(TAG, "cancel: context == null");
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            Log.e(TAG, "cancel: am == null");
        } else {
            alarmManager.cancel(pendingIntent);
        }
    }

    public static void cancel(Context context, int i2, PendingIntent pendingIntent) {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = pendingIntent != null ? pendingIntent.toString() : BuildConfig.COMMAND;
        Log.d(TAG, "cancel(requestCode:%s operation:%s)", objArr);
        if (context == null) {
            Log.e(TAG, "cancel(requestCode:%s): context == null", Integer.valueOf(i2));
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            Log.e(TAG, "cancel(requestCode:%s): am == null", Integer.valueOf(i2));
        } else {
            alarmManager.cancel(pendingIntent);
        }
    }

    public static void cancel(Context context, int i2, Intent intent, int i3) {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = intent != null ? intent : BuildConfig.COMMAND;
        objArr[2] = Integer.valueOf(i3);
        Log.d(TAG, "cancel(requestCode:%s intent:%s flags:%s)", objArr);
        if (context == null) {
            Log.e(TAG, "cancel(requestCode:%s): context == null", Integer.valueOf(i2));
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            Log.e(TAG, "cancel(requestCode:%s): am == null", Integer.valueOf(i2));
        } else {
            alarmManager.cancel(getPendingIntent(context, i2, intent, i3));
        }
    }

    public static PendingIntent getPendingIntent(Context context, int i2, Intent intent, int i3) {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = intent != null ? intent : BuildConfig.COMMAND;
        objArr[2] = Integer.valueOf(i3);
        Log.d(TAG, "getPendingIntent(requestCode:%s intent:%s flags:%s)", objArr);
        if (context == null) {
            Log.e(TAG, "getPendingIntent(requestCode:%s): context == null", Integer.valueOf(i2));
            return null;
        } else if (isRequestCodeValid(i2)) {
            return PendingIntent.getBroadcast(context, i2, intent, i3);
        } else {
            Log.e(TAG, "getPendingIntent(requestCode:%s): requestCode invalid", Integer.valueOf(i2));
            return null;
        }
    }

    private static boolean isRequestCodeValid(int i2) {
        if (i2 < 100 || i2 > 119) {
            return false;
        }
        return true;
    }
}
