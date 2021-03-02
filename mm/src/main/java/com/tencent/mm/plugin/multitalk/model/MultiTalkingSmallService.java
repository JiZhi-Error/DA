package com.tencent.mm.plugin.multitalk.model;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;

public class MultiTalkingSmallService extends Service {
    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(114612);
        Log.i("MicroMsg.MultiTalkingSmallService", "MultiTalkingSmallService onBind");
        Notification notification = (Notification) intent.getParcelableExtra("notification");
        if (d.oD(26) && notification != null) {
            startForeground(43, notification);
        }
        AppMethodBeat.o(114612);
        return null;
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(114613);
        Log.i("MicroMsg.MultiTalkingSmallService", "MultiTalkingSmallService onUnbind");
        stopSelf();
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(114613);
        return onUnbind;
    }

    public void onCreate() {
        AppMethodBeat.i(114614);
        Log.i("MicroMsg.MultiTalkingSmallService", "MultiTalkingSmallService onCreate");
        AppMethodBeat.o(114614);
    }

    public void onDestroy() {
        AppMethodBeat.i(114615);
        Log.i("MicroMsg.MultiTalkingSmallService", "MultiTalkingSmallService onDestroy");
        AppMethodBeat.o(114615);
    }
}
