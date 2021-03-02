package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class a {
    Lock aIR;
    Activity activity;
    private BroadcastReceiver broadcastReceiver;
    private WifiManager cnK;
    Condition dgF;
    String ssid;
    private long timeout;
    boolean wMA = false;
    boolean wMB = false;

    /* renamed from: com.tencent.mm.plugin.freewifi.a$a  reason: collision with other inner class name */
    public interface AbstractC1368a {
        void onFail(int i2);

        void onSuccess();
    }

    public a(String str, Activity activity2) {
        AppMethodBeat.i(24634);
        this.activity = activity2;
        this.timeout = 15000;
        this.ssid = str;
        this.aIR = new ReentrantLock();
        this.dgF = this.aIR.newCondition();
        this.cnK = (WifiManager) MMApplicationContext.getContext().getSystemService("wifi");
        AppMethodBeat.o(24634);
    }

    public final void a(final AbstractC1368a aVar) {
        AppMethodBeat.i(24635);
        AnonymousClass1 r4 = new AbstractC1368a() {
            /* class com.tencent.mm.plugin.freewifi.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.freewifi.a.AbstractC1368a
            public final void onSuccess() {
                AppMethodBeat.i(24631);
                Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "sessionKey=%s, step=%d, desc=Connect ssid succeeded. ", m.aw(a.this.activity.getIntent()), Integer.valueOf(m.ax(a.this.activity.getIntent())));
                aVar.onSuccess();
                AppMethodBeat.o(24631);
            }

            @Override // com.tencent.mm.plugin.freewifi.a.AbstractC1368a
            public final void onFail(int i2) {
                AppMethodBeat.i(24632);
                Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "sessionKey=%s, step=%d, desc=Connect ssid failed. errorcode=%d", m.aw(a.this.activity.getIntent()), Integer.valueOf(m.ax(a.this.activity.getIntent())), Integer.valueOf(i2));
                aVar.onFail(i2);
                AppMethodBeat.o(24632);
            }
        };
        if (((ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected() && this.ssid.equals(d.dNf())) {
            r4.onSuccess();
            AppMethodBeat.o(24635);
        } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            RuntimeException runtimeException = new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
            AppMethodBeat.o(24635);
            throw runtimeException;
        } else {
            this.broadcastReceiver = new BroadcastReceiver() {
                /* class com.tencent.mm.plugin.freewifi.a.AnonymousClass2 */

                public final void onReceive(Context context, Intent intent) {
                    AppMethodBeat.i(24633);
                    if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
                        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                        if (networkInfo != null) {
                            Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", a.this.ssid, m.axM("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString());
                        }
                        if (networkInfo == null || !networkInfo.isConnected() || networkInfo.getType() != 1 || !a.this.ssid.equals(m.removeSsidQuote(networkInfo.getExtraInfo()))) {
                            AppMethodBeat.o(24633);
                            return;
                        }
                        try {
                            a.this.aIR.lock();
                            a.this.wMA = true;
                            Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastreceiver signal connected state.");
                            a.this.dgF.signalAll();
                        } finally {
                            a.this.aIR.unlock();
                            AppMethodBeat.o(24633);
                        }
                    } else {
                        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                            NetworkInfo networkInfo2 = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                            if (networkInfo2 != null) {
                                Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", a.this.ssid, m.axM("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo2.isConnected()), Boolean.valueOf(networkInfo2.isConnectedOrConnecting()), networkInfo2.getExtraInfo(), Integer.valueOf(networkInfo2.getType()), networkInfo2.toString());
                            }
                            if (networkInfo2 != null && networkInfo2.isConnected() && networkInfo2.getType() == 1 && a.this.ssid.equals(m.removeSsidQuote(networkInfo2.getExtraInfo()))) {
                                try {
                                    a.this.aIR.lock();
                                    a.this.wMB = true;
                                    Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastreceiver signal connected state.");
                                    a.this.dgF.signalAll();
                                    return;
                                } finally {
                                    a.this.aIR.unlock();
                                    AppMethodBeat.o(24633);
                                }
                            }
                        }
                        AppMethodBeat.o(24633);
                    }
                }
            };
            try {
                this.aIR.lock();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.wifi.STATE_CHANGE");
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.activity.registerReceiver(this.broadcastReceiver, intentFilter);
                if (!this.cnK.isWifiEnabled()) {
                    int dMw = new e(this.activity).dMw();
                    Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "enable ret = ".concat(String.valueOf(dMw)));
                    if (dMw != 0) {
                        r4.onFail(dMw);
                        return;
                    }
                }
                int axT = d.axT(this.ssid);
                if (axT != 0) {
                    dMu();
                    r4.onFail(axT);
                    dMu();
                    this.aIR.unlock();
                    AppMethodBeat.o(24635);
                    return;
                }
                boolean z = false;
                while (true) {
                    try {
                        if (this.wMA && this.wMB) {
                            break;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        z = this.dgF.await(this.timeout, TimeUnit.MILLISECONDS);
                        if (!z) {
                            break;
                        }
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        this.timeout -= currentTimeMillis2;
                        Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "costMillis=" + currentTimeMillis2 + "; left timeout=" + this.timeout);
                        this.timeout = this.timeout > 0 ? this.timeout : 3000;
                    } catch (InterruptedException e2) {
                        Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "sessionKey=%s, step=%d, desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", m.aw(this.activity.getIntent()), Integer.valueOf(m.ax(this.activity.getIntent())), e2.getMessage());
                        r4.onFail(-17);
                        dMu();
                        this.aIR.unlock();
                        AppMethodBeat.o(24635);
                        return;
                    }
                }
                if (!z) {
                    r4.onFail(-16);
                } else {
                    r4.onSuccess();
                }
                dMu();
                this.aIR.unlock();
                AppMethodBeat.o(24635);
            } finally {
                dMu();
                this.aIR.unlock();
                AppMethodBeat.o(24635);
            }
        }
    }

    private void dMu() {
        AppMethodBeat.i(24636);
        try {
            this.activity.unregisterReceiver(this.broadcastReceiver);
            AppMethodBeat.o(24636);
        } catch (IllegalArgumentException e2) {
            AppMethodBeat.o(24636);
        }
    }
}
