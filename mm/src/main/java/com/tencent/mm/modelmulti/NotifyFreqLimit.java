package com.tencent.mm.modelmulti;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class NotifyFreqLimit extends BroadcastReceiver {
    private static long beginTime = 0;
    private static a jdp = null;
    private static m jdq = null;
    private static int jdr = 0;
    private static long[] jds = null;
    private static LinkedList<Object> jdt = new LinkedList<>();
    private static int jdu = 0;
    private static Boolean jdv = null;
    private static Boolean jdw = null;
    private static long jdx = 0;
    private static PendingIntent jdy = null;
    private static byte[] lock = new byte[0];

    public interface a {
    }

    static {
        AppMethodBeat.i(20550);
        AppMethodBeat.o(20550);
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(20549);
        try {
            synchronized (lock) {
                if (intent != null) {
                    try {
                        if ("com.tencent.mm.NotifyFreqLimit.AlarmReceiver".equals(intent.getAction())) {
                            long longExtra = intent.getLongExtra("hashCode", 0);
                            long nowMilliSecond = Util.nowMilliSecond() - longExtra;
                            int intExtra = intent.getIntExtra("pid", 0);
                            long longExtra2 = intent.getLongExtra("delaySecond", 0) * 1000;
                            int myPid = Process.myPid();
                            long id = Thread.currentThread().getId();
                            Log.i("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", Long.valueOf(longExtra), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(nowMilliSecond), Long.valueOf(longExtra2), jdy, jdp);
                            if (jdy == null) {
                                h.INSTANCE.idkeyStat(99, 156, 1, false);
                                Log.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: SENDER NULL alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", Long.valueOf(longExtra), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(nowMilliSecond), Long.valueOf(longExtra2), jdy, jdp);
                                return;
                            }
                            jdy = null;
                            if (myPid != intExtra) {
                                h.INSTANCE.idkeyStat(99, 159, 1, false);
                                Log.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: DIFF PID alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", Long.valueOf(longExtra), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(nowMilliSecond), Long.valueOf(longExtra2), jdy, jdp);
                                AppMethodBeat.o(20549);
                                return;
                            }
                            if (5 * longExtra2 < nowMilliSecond || 180000 + longExtra2 < nowMilliSecond) {
                                Log.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: ALARM DELAY TOO MUCH alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", Long.valueOf(longExtra), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(nowMilliSecond), Long.valueOf(longExtra2), jdy, jdp);
                                jdw = Boolean.FALSE;
                                SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("NOTIFY_FREQ_LIMIT_INFO", 0);
                                String nullAsNil = Util.nullAsNil(sharedPreferences.getString("NOTIFY_FREQ_LIMIT_CLOSE_BY_ALARM_FAILED_KEY", ""));
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                edit.putString("NOTIFY_FREQ_LIMIT_CLOSE_BY_ALARM_FAILED_KEY", Util.nowMilliSecond() + "," + nullAsNil);
                                edit.commit();
                                if (Util.isNullOrNil(nullAsNil)) {
                                    h.INSTANCE.a(11098, 3103);
                                }
                                Log.i("MicroMsg.NotifyFreqLimit", "setAlarmFailed end isAlarmCanUse:%s shared_pref:%s", jdw, nullAsNil);
                            }
                            if (jdp == null) {
                                h.INSTANCE.idkeyStat(99, 157, 1, false);
                                Log.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: FUNC NULL alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", Long.valueOf(longExtra), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(nowMilliSecond), Long.valueOf(longExtra2), jdy, jdp);
                            }
                            AppMethodBeat.o(20549);
                            return;
                        }
                    } finally {
                        AppMethodBeat.o(20549);
                    }
                }
                Object[] objArr = new Object[1];
                objArr[0] = intent == null ? "intent is null" : intent.getAction();
                Log.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver onReceive intent:%s", objArr);
                AppMethodBeat.o(20549);
            }
        } catch (Throwable th) {
            jdy = null;
            h.INSTANCE.idkeyStat(99, 151, 1, false);
            Log.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver onReceive e:%s", Util.stackTraceToString(th));
            AppMethodBeat.o(20549);
        }
    }
}
