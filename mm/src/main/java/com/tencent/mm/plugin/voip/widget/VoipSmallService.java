package com.tencent.mm.plugin.voip.widget;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;

public class VoipSmallService extends Service {
    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(115792);
        Log.i("MicroMsg.VoipSmallService", "VoipSmallService onBind");
        Notification notification = (Notification) intent.getParcelableExtra("notification");
        if (d.oD(26) && notification != null) {
            startForeground(40, notification);
        }
        AppMethodBeat.o(115792);
        return null;
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(115793);
        Log.i("MicroMsg.VoipSmallService", "VoipSmallService onUnbind");
        stopSelf();
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(115793);
        return onUnbind;
    }

    public void onCreate() {
        AppMethodBeat.i(115794);
        Log.i("MicroMsg.VoipSmallService", "VoipSmallService onCreate");
        AppMethodBeat.o(115794);
    }

    public void onDestroy() {
        AppMethodBeat.i(115795);
        Log.i("MicroMsg.VoipSmallService", "VoipSmallService onDestroy");
        AppMethodBeat.o(115795);
    }
}
