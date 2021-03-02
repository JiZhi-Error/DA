package com.tencent.mm.cg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

/* access modifiers changed from: package-private */
public final class c extends BroadcastReceiver {
    a<Boolean> NMG;
    a<Boolean> NMH;

    c(Context context) {
        int intExtra;
        boolean z = false;
        AppMethodBeat.i(133217);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        context.registerReceiver(this, intentFilter);
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null && ((intExtra = registerReceiver.getIntExtra("status", -1)) == 2 || intExtra == 5)) {
            z = true;
        }
        this.NMG = new a<>("charging", Boolean.valueOf(z));
        this.NMH = new a<>("interactive", Boolean.valueOf(((PowerManager) context.getSystemService("power")).isScreenOn()));
        AppMethodBeat.o(133217);
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(133218);
        String action = intent.getAction();
        if (action == null) {
            AppMethodBeat.o(133218);
            return;
        }
        a<Boolean> aVar = null;
        char c2 = 65535;
        switch (action.hashCode()) {
            case -2128145023:
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1886648615:
                if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1454123155:
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1019184907:
                if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.NMH.set(Boolean.TRUE);
                aVar = this.NMH;
                break;
            case 1:
                this.NMH.set(Boolean.FALSE);
                aVar = this.NMH;
                break;
            case 2:
                this.NMG.set(Boolean.TRUE);
                aVar = this.NMG;
                break;
            case 3:
                this.NMG.set(Boolean.FALSE);
                aVar = this.NMG;
                break;
        }
        if (aVar != null) {
            Log.i("MicroMsg.SystemStatus", "System status changed: %s = %s", aVar.name(), aVar.get().toString());
        }
        AppMethodBeat.o(133218);
    }
}
