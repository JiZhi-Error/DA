package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b {
    a wOy;
    BroadcastReceiver wOz;

    /* synthetic */ b(byte b2) {
        this();
    }

    private b() {
        AppMethodBeat.i(24769);
        this.wOy = new a((byte) 0);
        this.wOz = new BroadcastReceiver() {
            /* class com.tencent.mm.plugin.freewifi.model.b.AnonymousClass1 */

            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(24765);
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    try {
                        Log.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connChangedBroadcastReceiver");
                        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                        if (networkInfo == null) {
                            Log.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo is null");
                            AppMethodBeat.o(24765);
                            return;
                        }
                        Log.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo=" + networkInfo.toString() + "; networkInfo.isConnected()=%b, networkInfo.getState()=%s, networkInfo.getDetailedState()=%s, networkInfo.getExtraInfo()=%s, networkInfo.isConnectedOrConnecting()=%b, networkInfo.isAvailable()=%b, ", Boolean.valueOf(networkInfo.isConnected()), networkInfo.getState(), networkInfo.getDetailedState(), networkInfo.getExtraInfo(), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), Boolean.valueOf(networkInfo.isAvailable()));
                        if (!networkInfo.isConnected()) {
                            Log.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network is not connected.");
                            AppMethodBeat.o(24765);
                            return;
                        } else if (networkInfo.getType() != 0 && networkInfo.getType() != 1) {
                            Log.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network type is not wifi or mobile.");
                            AppMethodBeat.o(24765);
                            return;
                        } else if (context == null) {
                            Log.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "context is null.");
                            AppMethodBeat.o(24765);
                            return;
                        } else if (networkInfo.getType() == 1) {
                            String removeSsidQuote = m.removeSsidQuote(m.axM("MicroMsg.FreeWifi.FreeWifiConnChangedManager"));
                            String lowerCase = m.axN("MicroMsg.FreeWifi.FreeWifiConnChangedManager").toLowerCase();
                            String removeSsidQuote2 = m.removeSsidQuote(m.axL(networkInfo.getExtraInfo()));
                            Log.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo.getExtraInfo()=%s, wifiInfo.getSsid()=%s, wifiInfo.getBssid=%s", removeSsidQuote2, removeSsidQuote, lowerCase);
                            if (!m.axL(removeSsidQuote2).equals(removeSsidQuote)) {
                                Log.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManage ssid is not equal to networkInfo.getExtraInfo(). networkwork might changed. return.");
                                AppMethodBeat.o(24765);
                                return;
                            } else if (b.this.wOy.type != 1 || !m.axL(b.this.wOy.ssid).equals(removeSsidQuote) || !m.axL(b.this.wOy.bssid).equals(lowerCase)) {
                                a aVar = new a((byte) 0);
                                aVar.wOB = System.currentTimeMillis();
                                aVar.type = 1;
                                aVar.ssid = removeSsidQuote;
                                aVar.bssid = lowerCase;
                                aVar.wOC = "";
                                b.b(b.this.wOy.dMX(), aVar);
                                b.this.wOy = aVar;
                                AppMethodBeat.o(24765);
                                return;
                            } else {
                                Log.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                                AppMethodBeat.o(24765);
                                return;
                            }
                        } else if (networkInfo.getType() != 0) {
                            AppMethodBeat.o(24765);
                            return;
                        } else if (b.this.wOy.type != 0 || !m.axL(b.this.wOy.wOC).equals(m.axL(networkInfo.getExtraInfo()))) {
                            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                            if (connectivityManager == null) {
                                Log.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connManager is null.");
                                AppMethodBeat.o(24765);
                                return;
                            }
                            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
                            if (networkInfo2 == null) {
                                Log.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi is null.");
                                AppMethodBeat.o(24765);
                                return;
                            }
                            Log.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi.getState()=%s, networkInfoWifi.getDetailedState()=%s", networkInfo2.getState(), networkInfo2.getDetailedState());
                            if (networkInfo2.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED) {
                                Log.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "It receives a type mobile connected event, but wifi network is not disconnected, so in fact user is probably switching wifi among ssids, not trying to connect to mobile network. ");
                                AppMethodBeat.o(24765);
                                return;
                            }
                            a aVar2 = new a((byte) 0);
                            aVar2.wOB = System.currentTimeMillis();
                            aVar2.type = 0;
                            aVar2.ssid = "";
                            aVar2.bssid = "";
                            aVar2.wOC = m.axL(networkInfo.getExtraInfo());
                            b.a(b.this.wOy.dMX(), aVar2);
                            b.this.wOy = aVar2;
                            AppMethodBeat.o(24765);
                            return;
                        } else {
                            Log.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                            AppMethodBeat.o(24765);
                            return;
                        }
                    } catch (Exception e2) {
                        k.a dMF = k.dMF();
                        dMF.dFd = "UnExpectedException";
                        dMF.result = -1;
                        dMF.resultMsg = m.l(e2);
                        dMF.dMH().dMG();
                        Log.e("MicroMsg.FreeWifi.UnExcepctedException", m.m(e2));
                    }
                }
                AppMethodBeat.o(24765);
            }
        };
        AppMethodBeat.o(24769);
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.b$b  reason: collision with other inner class name */
    static class C1371b {
        private static b wOD = new b((byte) 0);

        static {
            AppMethodBeat.i(24768);
            AppMethodBeat.o(24768);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        String bssid;
        String ssid;
        int type;
        long wOB;
        String wOC;

        private a() {
            this.ssid = "";
            this.bssid = "";
            this.wOC = "";
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final a dMX() {
            AppMethodBeat.i(24766);
            a aVar = new a();
            aVar.wOB = this.wOB;
            aVar.type = this.type;
            aVar.ssid = this.ssid;
            aVar.bssid = this.bssid;
            aVar.wOC = this.wOC;
            AppMethodBeat.o(24766);
            return aVar;
        }

        public final String toString() {
            AppMethodBeat.i(24767);
            String format = String.format("NetworkInfoConnectedRecord(timeMillis=%d, type=%d, ssid=%s, bssid=%s, mobileNetworkType=%s)", Long.valueOf(this.wOB), Integer.valueOf(this.type), this.ssid, this.bssid, this.wOC);
            AppMethodBeat.o(24767);
            return format;
        }
    }

    public final void dMu() {
        AppMethodBeat.i(24770);
        try {
            MMApplicationContext.getContext().unregisterReceiver(this.wOz);
            AppMethodBeat.o(24770);
        } catch (IllegalArgumentException e2) {
            AppMethodBeat.o(24770);
        }
    }

    static void a(a aVar, a aVar2) {
        AppMethodBeat.i(24771);
        m.axP("on mobile connected.");
        Log.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onMobileConnected. lastRecord=%s, newRecord=%s", aVar.toString(), aVar2.toString());
        com.tencent.mm.plugin.freewifi.f.b.pl(0);
        AppMethodBeat.o(24771);
    }

    static void b(a aVar, a aVar2) {
        AppMethodBeat.i(24772);
        m.axP("on wifi connected.");
        Log.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onWifiConnected. lastRecord=%s, newRecord=%s", aVar.toString(), aVar2.toString());
        if (aVar.type == 1 && aVar.ssid.equals(aVar2.ssid) && !aVar.bssid.equals(aVar2.bssid)) {
            String str = aVar.ssid;
            String str2 = aVar.bssid;
            String str3 = aVar2.bssid;
            m.axP("on wifi roaming.");
            Log.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "WifiRoaming. ssid=%s, fromBssid=%s, toBssid=%s", str, str2, str3);
        }
        com.tencent.mm.plugin.freewifi.f.b.pl(1);
        AppMethodBeat.o(24772);
    }
}
