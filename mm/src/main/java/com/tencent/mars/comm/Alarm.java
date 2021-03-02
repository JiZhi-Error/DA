package com.tencent.mars.comm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mm.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.TreeMap;

public class Alarm extends BroadcastReceiver {
    private static final int IDKEY_ALARM_DELAY_REPORT = 1256;
    private static final int INTENT_FILTER_ACTION_ID_DEFAULT = 10000;
    private static final String KEXTRA_ID = "ID";
    private static final String KEXTRA_PID = "PID";
    private static final int KV_ALARM_DELAY_REPORT = 18860;
    private static final String TAG = "MicroMsg.Alarm";
    private static Alarm bc_alarm = null;
    private static TreeMap<Long, AlarmRecord> gPendingAlarms = new TreeMap<>();
    private static WakerLock wakerlock = null;

    private native void onAlarm(long j2);

    /* access modifiers changed from: package-private */
    public static class AlarmRecord implements Comparable<AlarmRecord> {
        final long id;
        PendingIntent pendingIntent;
        long waitTime;

        public int compareTo(AlarmRecord alarmRecord) {
            return (int) (this.id - alarmRecord.id);
        }

        AlarmRecord(long j2, long j3, PendingIntent pendingIntent2) {
            this.id = j2;
            this.waitTime = j3;
            this.pendingIntent = pendingIntent2;
        }
    }

    public static void resetAlarm(Context context) {
        synchronized (gPendingAlarms) {
            for (AlarmRecord alarmRecord : gPendingAlarms.values()) {
                cancelAlarmMgr(alarmRecord.id, context, alarmRecord.pendingIntent);
            }
            gPendingAlarms.clear();
            if (bc_alarm != null) {
                context.unregisterReceiver(bc_alarm);
                bc_alarm = null;
            }
        }
    }

    public static boolean start(int i2, long j2, int i3, Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (i3 < 0) {
            Log.e(TAG, "id:%d, after:%d", Long.valueOf(j2), Integer.valueOf(i3));
            return false;
        } else if (context == null) {
            Log.e(TAG, "null==context, id:%d, after:%d", Long.valueOf(j2), Integer.valueOf(i3));
            return false;
        } else {
            synchronized (gPendingAlarms) {
                if (wakerlock == null) {
                    wakerlock = new WakerLock(context, TAG);
                    Log.i(TAG, "start new wakerlock");
                }
                if (bc_alarm == null) {
                    bc_alarm = new Alarm();
                    context.registerReceiver(bc_alarm, new IntentFilter(new StringBuilder("ALARM_ACTION(10000)").toString()));
                }
                if (gPendingAlarms.containsKey(Long.valueOf(j2))) {
                    Log.e(TAG, "id exist=%d", Long.valueOf(j2));
                    return false;
                }
                if (i3 >= 0) {
                    elapsedRealtime += (long) i3;
                }
                PendingIntent alarmMgr = setAlarmMgr(i2, j2, elapsedRealtime, context);
                if (alarmMgr == null) {
                    return false;
                }
                gPendingAlarms.put(Long.valueOf(j2), new AlarmRecord(j2, elapsedRealtime, alarmMgr));
                Log.i(TAG, "Alarm.start [id: %d, after: %d, size: %d]", Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(gPendingAlarms.size()));
                return true;
            }
        }
    }

    public static boolean stop(long j2, Context context) {
        Log.i(TAG, "Alarm.stop [id: %d]", Long.valueOf(j2));
        if (context == null) {
            Log.e(TAG, "context==null");
            return false;
        }
        synchronized (gPendingAlarms) {
            if (wakerlock == null) {
                wakerlock = new WakerLock(context, TAG);
                Log.i(TAG, "stop new wakerlock");
            }
            if (bc_alarm == null) {
                bc_alarm = new Alarm();
                context.registerReceiver(bc_alarm, new IntentFilter());
                Log.i(TAG, "stop new Alarm");
            }
            AlarmRecord remove = gPendingAlarms.remove(Long.valueOf(j2));
            if (remove == null) {
                return false;
            }
            cancelAlarmMgr(remove.id, context, remove.pendingIntent);
            return true;
        }
    }

    private static PendingIntent setAlarmMgr(int i2, long j2, long j3, Context context) {
        if (((AlarmManager) context.getSystemService("alarm")) == null) {
            Log.e(TAG, "am == null");
            return null;
        }
        Intent intent = new Intent();
        intent.setAction(new StringBuilder("ALARM_ACTION(10000)").toString());
        intent.putExtra(KEXTRA_ID, j2);
        intent.putExtra(KEXTRA_PID, Process.myPid());
        if (Build.VERSION.SDK_INT >= 19) {
            return a.a(context, i2, j3, intent);
        }
        return a.set(context, i2, 2, j3, intent, 268435456);
    }

    private static boolean cancelAlarmMgr(long j2, Context context, PendingIntent pendingIntent) {
        if (((AlarmManager) context.getSystemService("alarm")) == null) {
            Log.e(TAG, "am == null");
            return false;
        } else if (pendingIntent == null) {
            Log.e(TAG, "pendingIntent == null");
            return false;
        } else {
            a.cancel(context, (int) j2, pendingIntent);
            pendingIntent.cancel();
            return true;
        }
    }

    public void onReceive(Context context, Intent intent) {
        long j2;
        if (context != null && intent != null) {
            long longExtra = intent.getLongExtra(KEXTRA_ID, 0);
            int intExtra = intent.getIntExtra(KEXTRA_PID, 0);
            if (0 != longExtra && intExtra != 0) {
                if (intExtra != Process.myPid()) {
                    Log.w(TAG, "onReceive id:%d, pid:%d, mypid:%d", Long.valueOf(longExtra), Integer.valueOf(intExtra), Integer.valueOf(Process.myPid()));
                    return;
                }
                synchronized (gPendingAlarms) {
                    AlarmRecord remove = gPendingAlarms.remove(Long.valueOf(longExtra));
                    if (remove != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - remove.waitTime;
                        Log.i(TAG, "Alarm.onReceive [id: %d, delta miss time: %d, size: %d]", Long.valueOf(longExtra), Long.valueOf(elapsedRealtime), Integer.valueOf(gPendingAlarms.size()));
                        if (elapsedRealtime <= 30000) {
                            j2 = 0;
                        } else if (elapsedRealtime <= Util.MILLSECONDS_OF_MINUTE) {
                            j2 = 1;
                        } else if (elapsedRealtime <= 120000) {
                            j2 = 2;
                        } else if (elapsedRealtime <= 300000) {
                            j2 = 3;
                        } else {
                            j2 = 4;
                        }
                        e.INSTANCE.idkeyStat(1256, j2, 1, false);
                        e.INSTANCE.a(KV_ALARM_DELAY_REPORT, Long.valueOf(elapsedRealtime));
                        if (wakerlock != null) {
                            wakerlock.lock(200, "Alarm.onReceive");
                        }
                        onAlarm(longExtra);
                    } else {
                        Log.e(TAG, "onReceive not found id:%d, pid:%d, gPendingAlarms.size:%d", Long.valueOf(longExtra), Integer.valueOf(intExtra), Integer.valueOf(gPendingAlarms.size()));
                    }
                }
            }
        }
    }
}
