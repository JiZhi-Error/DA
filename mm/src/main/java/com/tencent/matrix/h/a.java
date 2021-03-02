package com.tencent.matrix.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

public final class a {
    private static int dfg = 0;
    private static Timer dfh = new Timer();
    private static TimerTask dfi;
    private static String dfj = "";
    private static volatile SparseBooleanArray dfk = new SparseBooleanArray(5);
    private static int dfl = -1;
    private static volatile boolean dfm = true;
    private static boolean isStarted = false;

    static /* synthetic */ int TU() {
        int i2 = dfg;
        dfg = i2 + 1;
        return i2;
    }

    public static void TR() {
        Log.i("SyncBarrierWatchDogPlus", "startDetect sync barrier, isStarted =%b , oncCheckFinished = %b", Boolean.valueOf(isStarted), Boolean.valueOf(dfm));
        if (!isStarted) {
            isStarted = true;
            dfi = new TimerTask() {
                /* class com.tencent.matrix.h.a.AnonymousClass1 */

                public final void run() {
                    if (a.dfm) {
                        try {
                            if (com.tencent.matrix.a.INSTANCE.cPB) {
                                Log.i("SyncBarrierWatchDogPlus", "check Sync Barrier");
                                MessageQueue queue = Looper.getMainLooper().getQueue();
                                Field declaredField = queue.getClass().getDeclaredField("mMessages");
                                declaredField.setAccessible(true);
                                Message message = (Message) declaredField.get(queue);
                                if (message != null) {
                                    try {
                                        String unused = a.dfj = message.toString();
                                        Log.i("SyncBarrierWatchDogPlus", "mMessage = %s", a.dfj);
                                    } catch (Exception e2) {
                                        String unused2 = a.dfj = "";
                                        Log.e("SyncBarrierWatchDogPlus", "mMessage Exception e : " + e2.getMessage());
                                    }
                                    if (message.getWhen() - SystemClock.uptimeMillis() < -3000) {
                                        if (message.getTarget() == null) {
                                            int i2 = message.arg1;
                                            if (i2 == a.dfl) {
                                                boolean unused3 = a.dfm = true;
                                                return;
                                            } else if (a.dfj != null && a.dfj.contains("barrier=")) {
                                                a.iy(i2);
                                                int unused4 = a.dfl = i2;
                                            }
                                        } else {
                                            Log.i("SyncBarrierWatchDogPlus", "Maybe Happens Lag");
                                        }
                                    }
                                }
                                boolean unused5 = a.dfm = true;
                            }
                        } catch (Exception e3) {
                            Log.e("timerTask run error, message : %s", e3.getMessage());
                        } finally {
                            boolean unused6 = a.dfm = true;
                        }
                    }
                }
            };
            dfh.schedule(dfi, 4500, 4500);
        }
    }

    private static int TS() {
        try {
            MessageQueue queue = Looper.getMainLooper().getQueue();
            Field declaredField = queue.getClass().getDeclaredField("mMessages");
            declaredField.setAccessible(true);
            Message message = (Message) declaredField.get(queue);
            if (message == null || message.getTarget() != null) {
                return -1;
            }
            return message.arg1;
        } catch (Exception e2) {
            return -1;
        }
    }

    private static void F(int i2, int i3, int i4) {
        if (!dfk.get(i2)) {
            dfk.put(i2, true);
            e.INSTANCE.idkeyStat(1470, (long) i3, 1, true);
            String visibleScene = AppMethodBeat.getVisibleScene();
            if (visibleScene == null) {
                visibleScene = "";
            }
            Log.i("SyncBarrierWatchDogPlus", "sync barrier leak happens in scene : %s, type : %d", visibleScene, Integer.valueOf(i4));
            e.INSTANCE.a(20739, visibleScene, Integer.valueOf(i4));
        }
    }

    static /* synthetic */ void iy(int i2) {
        boolean z;
        dfg = 0;
        int i3 = 0;
        while (i3 < 10) {
            Log.i("SyncBarrierWatchDogPlus", "startCheckStrictly, token = %d, checkCount = %d ", Integer.valueOf(i2), Integer.valueOf(i3));
            int i4 = i3 + 1;
            if (i2 != TS()) {
                Log.i("SyncBarrierWatchDogPlus", "token != lastToken, just break");
                return;
            }
            Handler r0 = new Handler(Looper.getMainLooper()) {
                /* class com.tencent.matrix.h.a.AnonymousClass2 */

                public final void handleMessage(Message message) {
                    super.handleMessage(message);
                    Log.i("SyncBarrierWatchDogPlus", "mainHandler handleMessage, msg = %s", message.toString());
                    if (message.arg1 == 0) {
                        a.TU();
                    } else if (message.arg1 == 1) {
                        int unused = a.dfg = 0;
                    }
                }
            };
            Message obtain = Message.obtain();
            obtain.setAsynchronous(true);
            obtain.setTarget(r0);
            obtain.arg1 = 0;
            Message obtain2 = Message.obtain();
            obtain2.arg1 = 1;
            r0.sendMessage(obtain);
            r0.sendMessage(obtain2);
            if (dfg > 3) {
                Log.i("SyncBarrierWatchDogPlus", "Maybe happens a barrier leak, token = %d, barrierCount = barrierCount", Integer.valueOf(i2), Integer.valueOf(dfg));
                if (i2 == TS()) {
                    F(i2, 21, 11);
                } else {
                    F(i2, 20, 10);
                }
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                try {
                    Thread.sleep(1000);
                    i3 = i4;
                } catch (InterruptedException e2) {
                    i3 = i4;
                }
            } else {
                return;
            }
        }
    }
}
