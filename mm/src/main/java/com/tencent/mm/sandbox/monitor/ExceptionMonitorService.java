package com.tencent.mm.sandbox.monitor;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sandbox.monitor.b;
import com.tencent.mm.sdk.platformtools.Log;

public class ExceptionMonitorService extends Service implements b.a {
    b NEm = null;

    public void onCreate() {
        AppMethodBeat.i(32607);
        super.onCreate();
        Log.i("MicroMsg.ExceptionMonitorService", "onCreate()");
        this.NEm = new b();
        this.NEm.a(this);
        AppMethodBeat.o(32607);
    }

    public void onStart(Intent intent, int i2) {
        AppMethodBeat.i(32608);
        super.onStart(intent, i2);
        Log.i("MicroMsg.ExceptionMonitorService", "onStart()");
        if (this.NEm != null) {
            this.NEm.o(intent);
        }
        AppMethodBeat.o(32608);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        AppMethodBeat.i(32609);
        Log.i("MicroMsg.ExceptionMonitorService", "onStartCommand()");
        if (this.NEm != null) {
            this.NEm.o(intent);
        }
        AppMethodBeat.o(32609);
        return 1;
    }

    public void onDestroy() {
        AppMethodBeat.i(32610);
        super.onDestroy();
        Log.i("MicroMsg.ExceptionMonitorService", "onDestroy()");
        if (this.NEm != null) {
            this.NEm.onDestroy();
            this.NEm = null;
        }
        AppMethodBeat.o(32610);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
