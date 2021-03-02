package com.tencent.mm.plugin.d.a.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a {
    final AbstractC0940a pjT;
    public final BroadcastReceiver pjU = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.d.a.d.a.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(22607);
            if (intent == null) {
                Log.e("McroMsg.exdevice.BluetoohtStateMonitor", "null == intent");
                AppMethodBeat.o(22607);
                return;
            }
            if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                Log.i("McroMsg.exdevice.BluetoohtStateMonitor", "onReceive, action = " + intent.getAction());
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                if (10 == intExtra || 12 == intExtra) {
                    a.this.pjT.CM(intExtra);
                }
            }
            AppMethodBeat.o(22607);
        }
    };

    /* renamed from: com.tencent.mm.plugin.d.a.d.a$a  reason: collision with other inner class name */
    public interface AbstractC0940a {
        void CM(int i2);
    }

    public a(AbstractC0940a aVar) {
        AppMethodBeat.i(22608);
        Log.i("McroMsg.exdevice.BluetoohtStateMonitor", "register BluetoothState receiver");
        this.pjT = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        MMApplicationContext.getContext().registerReceiver(this.pjU, intentFilter);
        AppMethodBeat.o(22608);
    }
}
