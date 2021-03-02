package com.b.a.a;

import android.net.wifi.WifiManager;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ac extends e {
    private final WifiManager cnK;

    ac(WifiManager wifiManager, Handler handler) {
        super(handler);
        this.cnK = wifiManager;
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.e
    public final void IZ() {
        AppMethodBeat.i(87960);
        this.cnK.startScan();
        AppMethodBeat.o(87960);
    }
}
