package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class f {
    Lock aIR = new ReentrantLock();
    private BroadcastReceiver broadcastReceiver;
    private WifiManager cnK = ((WifiManager) MMApplicationContext.getContext().getSystemService("wifi"));
    private Context context;
    Condition dgF = this.aIR.newCondition();
    private int wMK = 10;

    public f(Context context2) {
        AppMethodBeat.i(24653);
        this.context = context2;
        AppMethodBeat.o(24653);
    }

    public final int dMw() {
        AppMethodBeat.i(24654);
        if (3 == this.cnK.getWifiState()) {
            AppMethodBeat.o(24654);
            return 0;
        }
        this.broadcastReceiver = new BroadcastReceiver() {
            /* class com.tencent.mm.plugin.freewifi.f.AnonymousClass1 */

            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(24652);
                if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("wifi_state", 0);
                    Log.i("MicroMsg.FreeWifi.EnableWifiHelper", "wifi enabled state=".concat(String.valueOf(intExtra)));
                    if (intExtra == 3) {
                        try {
                            f.this.aIR.lock();
                            f.this.dgF.signalAll();
                            return;
                        } finally {
                            f.this.dMu();
                            f.this.aIR.unlock();
                            AppMethodBeat.o(24652);
                        }
                    }
                }
                AppMethodBeat.o(24652);
            }
        };
        try {
            this.aIR.lock();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            this.context.registerReceiver(this.broadcastReceiver, intentFilter);
            this.cnK.setWifiEnabled(true);
            if (this.dgF.await((long) this.wMK, TimeUnit.SECONDS)) {
                dMu();
                this.aIR.unlock();
                AppMethodBeat.o(24654);
                return 0;
            }
            dMu();
            this.aIR.unlock();
            AppMethodBeat.o(24654);
            return 1;
        } catch (InterruptedException e2) {
            dMu();
            this.aIR.unlock();
            AppMethodBeat.o(24654);
            return 2;
        } catch (Throwable th) {
            dMu();
            this.aIR.unlock();
            AppMethodBeat.o(24654);
            throw th;
        }
    }

    public final void dMu() {
        AppMethodBeat.i(24655);
        try {
            this.context.unregisterReceiver(this.broadcastReceiver);
            AppMethodBeat.o(24655);
        } catch (IllegalArgumentException e2) {
            AppMethodBeat.o(24655);
        }
    }
}
