package com.tencent.mm.plugin.bbom;

import android.app.Service;
import android.content.IntentFilter;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.TrafficStatsReceiver;
import com.tencent.mm.modelfriend.AddrBookObserver;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.plugin.zero.a.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class g implements a {
    private AddrBookObserver peW;
    private WatchDogPushReceiver peX;
    private TrafficStatsReceiver peY;

    @Override // com.tencent.mm.plugin.zero.a.a
    public final void a(Service service) {
        AppMethodBeat.i(22357);
        boolean z = Build.VERSION.SDK_INT < 26;
        if (!z) {
            z = b.n(service.getApplicationContext(), "android.permission.READ_CONTACTS");
        }
        if (z) {
            try {
                this.peW = new AddrBookObserver(service);
                service.getContentResolver().registerContentObserver(com.tencent.mm.pluginsdk.b.glF(), true, this.peW);
            } catch (Exception e2) {
                this.peW = null;
                Log.e("MicroMsg.CoreService", "onCreate registerContentObserver() Exception = %s", e2.getMessage());
            }
        }
        this.peX = new WatchDogPushReceiver();
        service.registerReceiver(this.peX, new IntentFilter("com.tencent.mm.WatchDogPushReceiver"));
        this.peY = new TrafficStatsReceiver();
        service.registerReceiver(this.peY, new IntentFilter("com.tencent.mm.TrafficStatsReceiver"));
        TrafficStatsReceiver.cm(service);
        AppMethodBeat.o(22357);
    }

    @Override // com.tencent.mm.plugin.zero.a.a
    public final void b(Service service) {
        AppMethodBeat.i(22358);
        if (this.peW != null) {
            service.getContentResolver().unregisterContentObserver(this.peW);
            this.peW = null;
        }
        service.unregisterReceiver(this.peX);
        service.unregisterReceiver(this.peY);
        TrafficStatsReceiver.cn(service);
        AppMethodBeat.o(22358);
    }
}
