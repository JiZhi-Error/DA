package com.tencent.mm.plugin.multitalk.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bq.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class MultiTalkingForegroundService extends Service {
    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(114608);
        Log.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onBind");
        if (d.oD(26)) {
            Log.i("MicroMsg.MultiTalkingForegroundService", "foreground service is on bind MicroMsg.MultiTalkingForegroundService");
            String string = MMApplicationContext.getContext().getString(R.string.f5g);
            String string2 = MMApplicationContext.getContext().getString(R.string.f6s);
            intent.setClass(MMApplicationContext.getContext(), MultiTalkMainUI.class);
            PendingIntent activity = PendingIntent.getActivity(MMApplicationContext.getContext(), 43, intent, 134217728);
            int i2 = R.drawable.cj8;
            if (d.oE(19)) {
                i2 = R.drawable.cj7;
            }
            s.c g2 = a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(string2).i(System.currentTimeMillis()).f(string).g(string2);
            g2.Hv = activity;
            Notification e2 = m.e(g2);
            e2.icon = i2;
            e2.flags |= 32;
            ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(43, e2, false);
            startForeground(43, e2);
        }
        AppMethodBeat.o(114608);
        return null;
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(114609);
        Log.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onUnbind");
        stopSelf();
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(114609);
        return onUnbind;
    }

    public void onCreate() {
        AppMethodBeat.i(114610);
        Log.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onCreate");
        AppMethodBeat.o(114610);
    }

    public void onDestroy() {
        AppMethodBeat.i(114611);
        Log.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onDestroy");
        AppMethodBeat.o(114611);
    }
}
