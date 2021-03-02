package com.tencent.mm.sandbox.monitor;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sandbox.monitor.ErrLog;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class b {
    private static a NEf = null;
    public static int NEg = 0;
    public static long hwQ = 0;
    private long NEh = 300000;
    private MMHandler NEi = new MMHandler();
    private Runnable NEj = new Runnable() {
        /* class com.tencent.mm.sandbox.monitor.b.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(32594);
            Log.d("MicroMsg.ExceptionMonitor", "stopSelf");
            if (b.NEf != null) {
                b.NEf.stopSelf();
            }
            AppMethodBeat.o(32594);
        }
    };
    private long NEk;

    public interface a {
        void stopSelf();
    }

    public b() {
        AppMethodBeat.i(32596);
        AppMethodBeat.o(32596);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(32597);
        NEf = aVar;
        c.q(hashCode(), this);
        this.NEi.postDelayed(this.NEj, this.NEh);
        AppMethodBeat.o(32597);
    }

    public final void onDestroy() {
        AppMethodBeat.i(32598);
        c.r(hashCode(), this);
        this.NEi.removeCallbacks(this.NEj);
        NEf = null;
        AppMethodBeat.o(32598);
    }

    public final void o(Intent intent) {
        AppMethodBeat.i(32599);
        Log.i("MicroMsg.ExceptionMonitor", "handleCommand()");
        if (intent == null) {
            AppMethodBeat.o(32599);
            return;
        }
        this.NEi.removeCallbacks(this.NEj);
        this.NEi.postDelayed(this.NEj, this.NEh);
        String action = intent.getAction();
        Log.d("MicroMsg.ExceptionMonitor", "dkcrash handleCommand action:".concat(String.valueOf(action)));
        try {
            String stringExtra = intent.getStringExtra("tag");
            if (stringExtra == null) {
                stringExtra = "exception";
            }
            String stringExtra2 = intent.getStringExtra("exceptionProcess");
            if (Util.isEqual(stringExtra2, "mm")) {
                h.INSTANCE.idkeyStat(1185, 11, 1, true);
            } else if (Util.isEqual(stringExtra2, "push")) {
                h.INSTANCE.idkeyStat(1185, 12, 1, true);
            } else if (Util.isEqual(stringExtra2, FacebookRequestErrorClassification.KEY_OTHER)) {
                h.INSTANCE.idkeyStat(1185, 13, 1, true);
            }
            int intExtra = intent.getIntExtra("exceptionPid", 0);
            stringExtra.equals("exception");
            NEg = intExtra;
            hwQ = intent.getLongExtra("exceptionTime", SystemClock.elapsedRealtime());
            String stringExtra3 = intent.getStringExtra("exceptionMsg");
            String stringExtra4 = intent.getStringExtra("userName");
            String stringExtra5 = intent.getStringExtra("exceptionPreventPath");
            boolean booleanExtra = intent.getBooleanExtra("exceptionWriteSdcard", true);
            Log.d("MicroMsg.ExceptionMonitor", "dkcrash handleCommand. action=" + action + " pid:" + intExtra + " tag=" + stringExtra + ", userName=" + stringExtra4 + ", crashPreventPath=" + Util.nullAs(stringExtra5, BuildConfig.COMMAND) + ", message" + stringExtra3);
            Log.i("MicroMsg.ExceptionMonitor", "processName:%s crashPreventPath:%s", stringExtra2, stringExtra5);
            if (Util.isNullOrNil(stringExtra3)) {
                AppMethodBeat.o(32599);
                return;
            }
            if (a.a(stringExtra4, stringExtra, new ErrLog.Error(stringExtra4, stringExtra, Util.nowSecond(), stringExtra3, booleanExtra), stringExtra5, false) == 0) {
                js(MMApplicationContext.getContext());
            }
            if (System.currentTimeMillis() - this.NEk > 600000) {
                this.NEk = System.currentTimeMillis();
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.sandbox.monitor.b.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(32595);
                        com.tencent.mm.modelrecovery.b.bex();
                        AppMethodBeat.o(32595);
                    }
                }, "RecoveryWriteLogThread");
            }
            AppMethodBeat.o(32599);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ExceptionMonitor", e2, "", new Object[0]);
            AppMethodBeat.o(32599);
        }
    }

    public static void js(Context context) {
        AppMethodBeat.i(32600);
        Intent intent = new Intent(context, CrashUploadAlarmReceiver.class);
        PendingIntent b2 = com.tencent.mm.a.a.b(context, 108, intent);
        if (b2 == null) {
            long nowMilliSecond = Util.nowMilliSecond() + 1800000;
            com.tencent.mm.a.a.set(context, 108, 0, nowMilliSecond, intent, 0);
            Log.i("MicroMsg.ExceptionMonitor", "dkcrash startAlarmMgr pendingIntent:%d %d", Integer.valueOf(b2.hashCode()), Long.valueOf(nowMilliSecond));
        }
        AppMethodBeat.o(32600);
    }
}
