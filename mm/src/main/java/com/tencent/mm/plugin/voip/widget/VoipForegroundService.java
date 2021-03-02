package com.tencent.mm.plugin.voip.widget;

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
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.q;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class VoipForegroundService extends Service {
    public int onStartCommand(Intent intent, int i2, int i3) {
        String string;
        AppMethodBeat.i(115788);
        g.aAi();
        if (!g.aAf().azp()) {
            Log.e("MicroMsg.VoipForegroundService", "error called voip foreground service in onStartCommand process");
            q qVar = q.GXY;
            q.fHj();
            stopSelf();
            AppMethodBeat.o(115788);
            return 2;
        }
        if (d.oD(26) && intent != null) {
            Log.i("MicroMsg.VoipForegroundService", "foreground service is on bind ");
            if (intent.getBooleanExtra("isRecalled", false)) {
                q qVar2 = q.GXY;
                q.fHi();
            }
            q qVar3 = q.GXY;
            q.fHe();
            Log.i("MicroMsg.VoipForegroundService", "setNotificationBind");
            intent.setClass(MMApplicationContext.getContext(), VideoActivity.class);
            intent.setFlags(268435456);
            intent.putExtra("Voip_Call_From", 2);
            String stringExtra = intent.getStringExtra("Voip_User");
            if (intent.getBooleanExtra("Voip_VideoCall", false)) {
                string = MMApplicationContext.getContext().getString(R.string.i4r);
            } else if (intent.getStringExtra("mTickerText") == null) {
                string = MMApplicationContext.getContext().getString(R.string.i4z);
            } else {
                string = intent.getStringExtra("mTickerText");
            }
            Log.i("MicroMsg.VoipForegroundService", "voip notification type is 40");
            g.aAi();
            if (!g.aAf().azp()) {
                Log.e("MicroMsg.VoipForegroundService", "error called voip foreground service in setNotification process");
                q qVar4 = q.GXY;
                q.fHj();
                stopSelf();
            } else {
                PendingIntent activity = PendingIntent.getActivity(MMApplicationContext.getContext(), 40, intent, 134217728);
                s.c as = a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(string).i(System.currentTimeMillis()).f(aa.getDisplayName(stringExtra)).g(string).as(b.ezb());
                as.Hv = activity;
                as.g(2, true);
                ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(40, m.e(as), false);
            }
        }
        AppMethodBeat.o(115788);
        return 3;
    }

    public void onCreate() {
        AppMethodBeat.i(115789);
        Log.i("MicroMsg.VoipForegroundService", "VoipForegroundService onCreate");
        super.onCreate();
        g.aAi();
        if (!g.aAf().azp()) {
            stopSelf();
            AppMethodBeat.o(115789);
            return;
        }
        if (d.oD(26)) {
            q qVar = q.GXY;
            q.fHd();
            s.c as = a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(System.currentTimeMillis()).as(b.ezb());
            as.g(2, true);
            Notification e2 = m.e(as);
            try {
                if (MMApplicationContext.isMMProcessExist()) {
                    Log.i("MicroMsg.VoipForegroundService", "current mmprocess is exits");
                }
                startForeground(40, e2);
                AppMethodBeat.o(115789);
                return;
            } catch (Exception e3) {
                Log.i("MicroMsg.VoipForegroundService", "start foreground service happened error %s", e3.getMessage());
            }
        }
        AppMethodBeat.o(115789);
    }

    public void onDestroy() {
        AppMethodBeat.i(115790);
        Log.i("MicroMsg.VoipForegroundService", "VoipForegroundService onDestroy");
        q qVar = q.GXY;
        q.fHf();
        try {
            stopForeground(true);
        } catch (Exception e2) {
            Log.e("MicroMsg.VoipForegroundService", "onDestroy happened error %s", e2);
        }
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        g.aAi();
        if (g.aAf().azp()) {
            sendBroadcast(new Intent("com.tencent.mm.foregroundDestroy"));
            if (c.fFg().dya) {
                q qVar2 = q.GXY;
                q.fHh();
            }
        }
        super.onDestroy();
        AppMethodBeat.o(115790);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(115791);
        Log.i("MicroMsg.VoipForegroundService", "onBind");
        AppMethodBeat.o(115791);
        return null;
    }
}
