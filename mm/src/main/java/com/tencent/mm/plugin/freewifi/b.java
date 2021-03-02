package com.tencent.mm.plugin.freewifi;

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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class b {
    Lock aIR;
    private BroadcastReceiver broadcastReceiver;
    private WifiManager cnK;
    private Context context;
    Condition dgF;
    String ssid;
    private long timeout = 15000;
    boolean wMA = false;
    boolean wMB = false;

    public b(String str, Context context2) {
        AppMethodBeat.i(24638);
        this.ssid = str;
        this.aIR = new ReentrantLock();
        this.dgF = this.aIR.newCondition();
        this.cnK = (WifiManager) context2.getSystemService("wifi");
        this.context = context2;
        AppMethodBeat.o(24638);
    }

    public final int dMv() {
        AppMethodBeat.i(24639);
        if (((ConnectivityManager) this.context.getSystemService("connectivity")).getNetworkInfo(1).isConnected() && this.ssid.equals(d.dNf())) {
            AppMethodBeat.o(24639);
            return 0;
        } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            RuntimeException runtimeException = new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
            AppMethodBeat.o(24639);
            throw runtimeException;
        } else {
            this.broadcastReceiver = new BroadcastReceiver() {
                /* class com.tencent.mm.plugin.freewifi.b.AnonymousClass1 */

                public final void onReceive(Context context, Intent intent) {
                    AppMethodBeat.i(24637);
                    if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
                        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                        if (networkInfo != null) {
                            Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", b.this.ssid, m.axM("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString());
                        }
                        if (networkInfo == null || !networkInfo.isConnected() || networkInfo.getType() != 1 || !b.this.ssid.equals(m.removeSsidQuote(networkInfo.getExtraInfo()))) {
                            AppMethodBeat.o(24637);
                            return;
                        }
                        try {
                            b.this.aIR.lock();
                            b.this.wMA = true;
                            Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastreceiver signal connected state.");
                            b.this.dgF.signalAll();
                        } finally {
                            b.this.aIR.unlock();
                            AppMethodBeat.o(24637);
                        }
                    } else {
                        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                            NetworkInfo networkInfo2 = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                            if (networkInfo2 != null) {
                                Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", b.this.ssid, m.axM("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo2.isConnected()), Boolean.valueOf(networkInfo2.isConnectedOrConnecting()), networkInfo2.getExtraInfo(), Integer.valueOf(networkInfo2.getType()), networkInfo2.toString());
                            }
                            if (networkInfo2 != null && networkInfo2.isConnected() && networkInfo2.getType() == 1 && b.this.ssid.equals(m.removeSsidQuote(networkInfo2.getExtraInfo()))) {
                                try {
                                    b.this.aIR.lock();
                                    b.this.wMB = true;
                                    Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastreceiver signal connected state.");
                                    b.this.dgF.signalAll();
                                    return;
                                } finally {
                                    b.this.aIR.unlock();
                                    AppMethodBeat.o(24637);
                                }
                            }
                        }
                        AppMethodBeat.o(24637);
                    }
                }
            };
            try {
                this.aIR.lock();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.wifi.STATE_CHANGE");
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.context.registerReceiver(this.broadcastReceiver, intentFilter);
                if (!this.cnK.isWifiEnabled()) {
                    int dMw = new f(this.context).dMw();
                    Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "enable ret = ".concat(String.valueOf(dMw)));
                    if (dMw != 0) {
                        return dMw;
                    }
                }
                int axT = d.axT(this.ssid);
                if (axT != 0) {
                    dMu();
                    dMu();
                    this.aIR.unlock();
                    AppMethodBeat.o(24639);
                    return axT;
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
                        Log.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", e2.getMessage());
                        dMu();
                        this.aIR.unlock();
                        AppMethodBeat.o(24639);
                        return -17;
                    }
                }
                if (!z) {
                    dMu();
                    this.aIR.unlock();
                    AppMethodBeat.o(24639);
                    return -16;
                }
                dMu();
                this.aIR.unlock();
                AppMethodBeat.o(24639);
                return 0;
            } finally {
                dMu();
                this.aIR.unlock();
                AppMethodBeat.o(24639);
            }
        }
    }

    private void dMu() {
        AppMethodBeat.i(24640);
        try {
            this.context.unregisterReceiver(this.broadcastReceiver);
            AppMethodBeat.o(24640);
        } catch (IllegalArgumentException e2) {
            AppMethodBeat.o(24640);
        }
    }
}
