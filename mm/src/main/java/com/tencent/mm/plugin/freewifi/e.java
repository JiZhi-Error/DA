package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
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

public final class e {
    Lock aIR = new ReentrantLock();
    private Activity activity;
    private BroadcastReceiver broadcastReceiver;
    private WifiManager cnK = ((WifiManager) MMApplicationContext.getContext().getSystemService("wifi"));
    Condition dgF = this.aIR.newCondition();
    private int wMK = 10;

    public e(Activity activity2) {
        AppMethodBeat.i(24649);
        this.activity = activity2;
        AppMethodBeat.o(24649);
    }

    public final int dMw() {
        AppMethodBeat.i(24650);
        if (3 == this.cnK.getWifiState()) {
            AppMethodBeat.o(24650);
            return 0;
        }
        this.broadcastReceiver = new BroadcastReceiver() {
            /* class com.tencent.mm.plugin.freewifi.e.AnonymousClass1 */

            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(24648);
                if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("wifi_state", 0);
                    Log.i("MicroMsg.FreeWifi.EnableWifiHelper", "wifi enabled state=".concat(String.valueOf(intExtra)));
                    if (intExtra == 3) {
                        try {
                            e.this.aIR.lock();
                            e.this.dgF.signalAll();
                            return;
                        } finally {
                            e.this.dMu();
                            e.this.aIR.unlock();
                            AppMethodBeat.o(24648);
                        }
                    }
                }
                AppMethodBeat.o(24648);
            }
        };
        try {
            this.aIR.lock();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            this.activity.registerReceiver(this.broadcastReceiver, intentFilter);
            this.cnK.setWifiEnabled(true);
            if (this.dgF.await((long) this.wMK, TimeUnit.SECONDS)) {
                dMu();
                this.aIR.unlock();
                AppMethodBeat.o(24650);
                return 0;
            }
            dMu();
            this.aIR.unlock();
            AppMethodBeat.o(24650);
            return 1;
        } catch (InterruptedException e2) {
            dMu();
            this.aIR.unlock();
            AppMethodBeat.o(24650);
            return 2;
        } catch (Throwable th) {
            dMu();
            this.aIR.unlock();
            AppMethodBeat.o(24650);
            throw th;
        }
    }

    public final void dMu() {
        AppMethodBeat.i(24651);
        try {
            this.activity.unregisterReceiver(this.broadcastReceiver);
            AppMethodBeat.o(24651);
        } catch (IllegalArgumentException e2) {
            AppMethodBeat.o(24651);
        }
    }
}
