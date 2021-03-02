package com.tencent.mm.live.core.mini;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/live/core/mini/LiveForegroundService;", "Landroid/app/Service;", "()V", "getNotificationIconRs", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "flags", "startId", "parseCreateNotification", "Landroid/app/Notification;", "startNotification", "Companion", "plugin-core_release"})
public final class LiveForegroundService extends Service {
    public static final a hCM = new a((byte) 0);

    static {
        AppMethodBeat.i(196583);
        AppMethodBeat.o(196583);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/live/core/mini/LiveForegroundService$Companion;", "", "()V", "PARAM_ACTIVITY_NAME", "", "PARAM_CONTENT", "PARAM_TICKER", "PARAM_TITLE", "TAG", "plugin-core_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final int onStartCommand(Intent intent, int i2, int i3) {
        Notification c2;
        AppMethodBeat.i(196580);
        Log.i("MicroMsg.LiveForegroundService", "foreground service onStartCommand");
        if (!g.aAf().azp()) {
            Log.e("MicroMsg.LiveForegroundService", "error called foreground service in onStartCommand process");
            stopSelf();
            AppMethodBeat.o(196580);
            return 2;
        }
        if (d.oD(26) && intent != null) {
            if (!g.aAf().azp()) {
                Log.e("MicroMsg.LiveForegroundService", "error called foreground service in startNotification process");
                stopSelf();
            } else {
                intent.setClass(MMApplicationContext.getContext(), Class.forName(intent.getStringExtra("PARAM_ACTIVITY_NAME")));
                intent.setFlags(268435456);
                String stringExtra = intent.getStringExtra("PARAM_TITLE");
                String stringExtra2 = intent.getStringExtra("PARAM_CONTENT");
                String stringExtra3 = intent.getStringExtra("PARAM_TICKER");
                c cVar = c.hCU;
                p.g(stringExtra, "title");
                p.g(stringExtra2, "content");
                p.g(stringExtra3, "ticker");
                p.h(intent, "intent");
                p.h(stringExtra, "title");
                p.h(stringExtra2, "content");
                p.h(stringExtra3, "tickerContent");
                s.c et = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(stringExtra3).i(System.currentTimeMillis()).f(stringExtra).g(stringExtra2).a(PendingIntent.getActivity(MMApplicationContext.getContext(), 46, intent, 134217728)).as(com.tencent.mm.bq.a.ezb()).et();
                p.g(et, "NotificationHelper.getNo…        .setOngoing(true)");
                if (d.oE(16)) {
                    c2 = c.d(et);
                } else {
                    c2 = c.c(et);
                }
                com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.notification.b.a.class);
                p.g(ah, "MMKernel.plugin(IPluginNotification::class.java)");
                ((com.tencent.mm.plugin.notification.b.a) ah).getNotification().a(46, c2, false);
            }
        }
        AppMethodBeat.o(196580);
        return 3;
    }

    public final void onCreate() {
        int i2;
        AppMethodBeat.i(196581);
        Log.i("MicroMsg.LiveForegroundService", "foreground service onCreate");
        if (!g.aAf().azp()) {
            stopSelf();
            AppMethodBeat.o(196581);
            return;
        }
        if (d.oD(26)) {
            s.c i3 = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(System.currentTimeMillis());
            if (Build.VERSION.SDK_INT < 19) {
                i2 = R.drawable.cj7;
            } else {
                i2 = R.drawable.cj8;
            }
            Notification build = i3.as(i2).et().build();
            p.g(build, "NotificationHelper.getNo….setOngoing(true).build()");
            try {
                startForeground(46, build);
                AppMethodBeat.o(196581);
                return;
            } catch (Exception e2) {
                Log.i("MicroMsg.LiveForegroundService", "start foreground service happened error %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(196581);
    }

    public final void onDestroy() {
        AppMethodBeat.i(196582);
        Log.i("MicroMsg.LiveForegroundService", "foreground service onDestroy");
        try {
            stopForeground(true);
        } catch (Exception e2) {
            Log.e("MicroMsg.LiveForegroundService", "onDestroy happened error %s", e2);
        }
        com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.notification.b.a.class);
        p.g(ah, "MMKernel.plugin(IPluginNotification::class.java)");
        ((com.tencent.mm.plugin.notification.b.a) ah).getNotification().cancel(46);
        super.onDestroy();
        AppMethodBeat.o(196582);
    }

    public final IBinder onBind(Intent intent) {
        return null;
    }
}
