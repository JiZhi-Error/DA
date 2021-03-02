package com.tencent.mm.util;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.s;
import android.widget.RemoteViews;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0017J\b\u0010\u000b\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\bH\u0016¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/util/FullScreenIntentService;", "Landroid/app/Service;", "()V", "getNotificationIconRs", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "flags", "startId", "onTaskRemoved", "rootIntent", "onUnbind", "", "prepareCallingIntent", "stopService", "name", "Companion", "FullScreenOperationReceiver", "plugin-comm_release"})
public final class FullScreenIntentService extends Service {
    public static final a QYB = new a((byte) 0);
    private static final String TAG = TAG;

    public final int onStartCommand(Intent intent, int i2, int i3) {
        s.c E;
        AppMethodBeat.i(149833);
        if ((d.oF(28) || p.j(Build.VERSION.CODENAME, "Q")) && intent != null) {
            Log.i(TAG, "FullScreenIntentService calling service is on bind " + TAG + intent.hasFileDescriptors());
            if ((d.oF(28) || p.j(Build.VERSION.CODENAME, "Q")) && intent != null) {
                Log.i(TAG, "FullScreenIntentService calling  service is on bind " + TAG + intent.hasFileDescriptors());
                intent.setClassName(getPackageName(), intent.getStringExtra(d.QYE));
                RemoteViews remoteViews = (RemoteViews) intent.getParcelableExtra(d.QYC);
                String stringExtra = intent.getStringExtra(d.QYD);
                intent.setFlags(268435456);
                String stringExtra2 = intent.getStringExtra(d.QYF);
                boolean booleanExtra = intent.getBooleanExtra(d.QYG, false);
                PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 134217728);
                if (Build.VERSION.SDK_INT >= 26) {
                    if (remoteViews != null) {
                        E = new s.c(this, stringExtra2).eu().u("call").i(System.currentTimeMillis()).c(remoteViews).d(remoteViews).as(ezb()).a(activity).f(getString(R.string.y7)).g(stringExtra).c(activity).et().E(true);
                        p.g(E, "NotificationCompat.Build…     .setAutoCancel(true)");
                    } else {
                        E = new s.c(this, g.apJ()).eu().u("reminder").i(System.currentTimeMillis()).g(stringExtra).f(getString(R.string.y7)).as(ezb()).a(activity).c(activity).et().E(true);
                        p.g(E, "NotificationCompat.Build…     .setAutoCancel(true)");
                    }
                    Notification build = E.build();
                    if (booleanExtra) {
                        build.flags |= 4;
                    }
                    try {
                        if (MMApplicationContext.isMMProcessExist()) {
                            Log.i(TAG, "current mmprocess is exits");
                        }
                        com.tencent.mm.plugin.notification.d.eys().notify(41, build);
                    } catch (Exception e2) {
                        Log.i(TAG, "start foreground service happened error %s", e2.getMessage());
                    }
                }
            }
        }
        int onStartCommand = super.onStartCommand(intent, i2, i3);
        AppMethodBeat.o(149833);
        return onStartCommand;
    }

    public final void onCreate() {
        AppMethodBeat.i(149834);
        Log.i(TAG, "FullScreenIntentService onCreate");
        AppMethodBeat.o(149834);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/util/FullScreenIntentService$FullScreenOperationReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "p0", "Landroid/content/Context;", "p1", "Landroid/content/Intent;", "plugin-comm_release"})
    public static final class FullScreenOperationReceiver extends BroadcastReceiver {
        public final void onReceive(Context context, Intent intent) {
        }
    }

    public final void onDestroy() {
        AppMethodBeat.i(149835);
        Log.i(TAG, "FullScreenIntentService service onDestroy");
        com.tencent.mm.plugin.notification.d.eys().cancel(41);
        stopForeground(true);
        AppMethodBeat.o(149835);
    }

    public final IBinder onBind(Intent intent) {
        AppMethodBeat.i(149836);
        p.h(intent, "intent");
        AppMethodBeat.o(149836);
        return null;
    }

    public final boolean onUnbind(Intent intent) {
        AppMethodBeat.i(149837);
        p.h(intent, "intent");
        Log.i(TAG, "FullScreenIntentService service onUnbind");
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(149837);
        return onUnbind;
    }

    public final boolean stopService(Intent intent) {
        AppMethodBeat.i(149838);
        p.h(intent, "name");
        com.tencent.mm.plugin.notification.d.eys().cancel(41);
        stopForeground(true);
        boolean stopService = super.stopService(intent);
        AppMethodBeat.o(149838);
        return stopService;
    }

    public final void onTaskRemoved(Intent intent) {
        AppMethodBeat.i(149839);
        p.h(intent, "rootIntent");
        Log.i(TAG, "onTaskRemoved: %s", intent);
        super.onTaskRemoved(intent);
        com.tencent.mm.plugin.notification.d.eys().cancel(41);
        stopSelf();
        AppMethodBeat.o(149839);
    }

    private static int ezb() {
        if (Build.VERSION.SDK_INT < 19) {
            return R.drawable.cj7;
        }
        return R.drawable.cj8;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/util/FullScreenIntentService$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(149840);
        AppMethodBeat.o(149840);
    }
}
