package com.tencent.mm.sandbox.monitor;

import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sandbox.monitor.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.service.MMService;

public class ExceptionMonitorMMService extends MMService implements b.a {
    b NEm = null;

    @Override // com.tencent.mm.service.MMService
    public final void onCreate() {
        AppMethodBeat.i(32602);
        super.onCreate();
        Log.i("MicroMsg.ExceptionMonitorMMService", "onCreate()");
        this.NEm = new b();
        this.NEm.a(this);
        AppMethodBeat.o(32602);
    }

    @Override // com.tencent.mm.service.MMService
    public final void onStart(Intent intent, int i2) {
        AppMethodBeat.i(32603);
        super.onStart(intent, i2);
        Log.i("MicroMsg.ExceptionMonitorMMService", "onStart()");
        if (this.NEm != null) {
            o(intent);
        }
        AppMethodBeat.o(32603);
    }

    @Override // com.tencent.mm.service.MMService
    public final int onStartCommand(Intent intent, int i2, int i3) {
        AppMethodBeat.i(32604);
        Log.i("MicroMsg.ExceptionMonitorMMService", "onStartCommand()");
        if (this.NEm != null) {
            o(intent);
        }
        AppMethodBeat.o(32604);
        return 1;
    }

    @Override // com.tencent.mm.service.MMService
    public final void onDestroy() {
        AppMethodBeat.i(32605);
        super.onDestroy();
        Log.i("MicroMsg.ExceptionMonitorMMService", "onDestroy()");
        if (this.NEm != null) {
            this.NEm.onDestroy();
            this.NEm = null;
        }
        AppMethodBeat.o(32605);
    }

    @Override // com.tencent.mm.service.MMService
    public final IBinder akL() {
        return null;
    }

    @Override // com.tencent.mm.service.MMService
    public final String getTag() {
        return "MicroMsg.ExceptionMonitorMMService";
    }

    private void o(Intent intent) {
        AppMethodBeat.i(32606);
        if (this.NEm != null) {
            this.NEm.o(intent);
        }
        AppMethodBeat.o(32606);
    }
}
