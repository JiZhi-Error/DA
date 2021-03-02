package com.tencent.mm.booter;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.os.Process;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.kernel.k;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.network.af;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class MMReceivers {

    public interface a {
        void onReceive(Context context, Intent intent);
    }

    @k
    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140819", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public static class ConnectionReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(131890);
            new StringBuilder("onReceive process: ").append(Process.myPid());
            Log.i("MicroMsg.ConnectionReceiver", "onReceive threadID: " + Thread.currentThread().getId());
            if (context == null) {
                AppMethodBeat.o(131890);
            } else if (!b.c(context, "connection", true)) {
                AlarmReceiver.ck(context);
                Log.appenderFlush();
                AppMethodBeat.o(131890);
            } else if (af.bkk() == null) {
                AppMethodBeat.o(131890);
            } else {
                NetworkInfo networkInfo = null;
                try {
                    networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                } catch (Exception e2) {
                    Log.e("MicroMsg.ConnectionReceiver", "getActiveNetworkInfo failed. exception: %s", e2.getMessage());
                }
                if (networkInfo == null || networkInfo.getState() != NetworkInfo.State.CONNECTED) {
                    Object[] objArr = new Object[1];
                    objArr[0] = networkInfo == null ? BuildConfig.COMMAND : networkInfo.getState();
                    Log.i("MicroMsg.ConnectionReceiver", "NetworkAvailable: false, state:%s", objArr);
                    af.b bkk = af.bkk();
                    if (networkInfo != null) {
                        networkInfo.getTypeName();
                    }
                    if (networkInfo != null) {
                        networkInfo.getSubtypeName();
                    }
                    bkk.df(false);
                    AppMethodBeat.o(131890);
                    return;
                }
                Log.i("MicroMsg.ConnectionReceiver", "NetworkAvailable: true");
                af.b bkk2 = af.bkk();
                networkInfo.getTypeName();
                networkInfo.getSubtypeName();
                bkk2.df(true);
                AppMethodBeat.o(131890);
            }
        }
    }

    @k
    public static class AlarmReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(131883);
            if (context == null || intent == null) {
                AppMethodBeat.o(131883);
                return;
            }
            if (!com.tencent.mm.kernel.a.apK().getBoolean("keepaliveserviceswitch", false)) {
                Log.i("MicroMsg.AlarmReceiver", "onReceive() MMHandlerThread() publish PushKeepAliveEvent");
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.booter.MMReceivers.AlarmReceiver.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(131882);
                        EventCenter.instance.asyncPublish(new qb(), Looper.getMainLooper());
                        Log.i("MicroMsg.AlarmReceiver", "onReceive() publish PushKeepAliveEvent");
                        AppMethodBeat.o(131882);
                    }
                }, 10000);
            }
            boolean booleanExtra = intent.getBooleanExtra("MMBoot_Bump", false);
            Log.i("MicroMsg.AlarmReceiver", "[ALARM NOTIFICATION] bump:".concat(String.valueOf(booleanExtra)));
            if (booleanExtra) {
                ch(context);
                AppMethodBeat.o(131883);
                return;
            }
            if (!b.c(context, "alarm", true)) {
                ck(context);
                Log.appenderFlush();
            }
            AppMethodBeat.o(131883);
        }

        public static void ch(Context context) {
            long j2 = 30000;
            AppMethodBeat.i(131884);
            long fire = MAlarmHandler.fire();
            Log.d("MicroMsg.AlarmReceiver", "bumper comes, next=".concat(String.valueOf(fire)));
            if (fire > 1860000) {
                AppMethodBeat.o(131884);
                return;
            }
            if (fire >= 30000) {
                j2 = fire;
            }
            a(j2, context);
            AppMethodBeat.o(131884);
        }

        private static void a(long j2, Context context) {
            AppMethodBeat.i(131885);
            Log.w("MicroMsg.AlarmReceiver", "reset bumper, interval=".concat(String.valueOf(j2)));
            com.tencent.mm.a.a.set(context, 109, 0, System.currentTimeMillis() + j2, new Intent(context, AlarmReceiver.class).putExtra("MMBoot_Bump", true), 268435456);
            AppMethodBeat.o(131885);
        }

        public static void ci(Context context) {
            AppMethodBeat.i(131886);
            PendingIntent b2 = com.tencent.mm.a.a.b(context, 109, new Intent(context, AlarmReceiver.class).putExtra("MMBoot_Bump", true));
            if (b2 != null) {
                com.tencent.mm.a.a.cancel(context, 109, b2);
                b2.cancel();
            }
            AppMethodBeat.o(131886);
        }

        public static void cj(Context context) {
            AppMethodBeat.i(131887);
            Log.w("MicroMsg.AlarmReceiver", "keep awaker");
            int i2 = af.bkg() ? 300000 : 900000;
            com.tencent.mm.a.a.a(context, 110, 0, System.currentTimeMillis() + ((long) i2), (long) i2, new Intent(context, AlarmReceiver.class));
            AppMethodBeat.o(131887);
        }

        public static void ck(Context context) {
            AppMethodBeat.i(131888);
            Log.w("MicroMsg.AlarmReceiver", "stop awaker");
            PendingIntent b2 = com.tencent.mm.a.a.b(context, 110, new Intent(context, AlarmReceiver.class));
            if (b2 != null) {
                com.tencent.mm.a.a.cancel(context, 110, b2);
                b2.cancel();
            }
            AppMethodBeat.o(131888);
        }
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public static class BootReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(131889);
            if (context == null) {
                AppMethodBeat.o(131889);
                return;
            }
            new StringBuilder("system booted, pid=").append(Process.myPid());
            if (!b.c(context, "auto", true)) {
                AlarmReceiver.ck(context);
                Log.appenderFlush();
            }
            AppMethodBeat.o(131889);
        }
    }

    public static class ToolsProcessReceiver extends BroadcastReceiver {
        private static a glx = null;

        public static void a(a aVar) {
            glx = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(131894);
            try {
                if (glx != null) {
                    glx.onReceive(context, intent);
                }
                AppMethodBeat.o(131894);
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.ToolsProcessReceiver", th, "onReceive error", new Object[0]);
                AppMethodBeat.o(131894);
            }
        }
    }

    public static class ToolsMpProcessReceiver extends BroadcastReceiver {
        private static a glx = null;

        public static void a(a aVar) {
            glx = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(131893);
            try {
                if (glx != null) {
                    glx.onReceive(context, intent);
                }
                AppMethodBeat.o(131893);
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.ToolsMpProcessReceiver", th, "onReceive error", new Object[0]);
                AppMethodBeat.o(131893);
            }
        }
    }

    public static class SandBoxProcessReceiver extends BroadcastReceiver {
        private static a glx = null;

        public static void a(a aVar) {
            glx = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(131892);
            if (glx != null) {
                glx.onReceive(context, intent);
            }
            AppMethodBeat.o(131892);
        }
    }

    public static class ExdeviceProcessReceiver extends BroadcastReceiver {
        private static a glx = null;

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(131891);
            if (glx != null) {
                glx.onReceive(context, intent);
            }
            AppMethodBeat.o(131891);
        }
    }
}
