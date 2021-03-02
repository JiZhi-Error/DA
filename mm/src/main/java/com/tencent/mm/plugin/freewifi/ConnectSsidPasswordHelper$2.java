package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.c;
import com.tencent.mm.sdk.platformtools.Log;

public class ConnectSsidPasswordHelper$2 extends BroadcastReceiver {
    final /* synthetic */ c wMH;

    public ConnectSsidPasswordHelper$2(c cVar) {
        this.wMH = cVar;
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(24643);
        if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo != null) {
                Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s, networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", this.wMH.ssid, m.axM("MicroMsg.FreeWifi.ConnectSsidPasswordHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString());
            }
            if (networkInfo == null || !networkInfo.isConnected() || networkInfo.getType() != 1 || !this.wMH.ssid.equals(m.removeSsidQuote(networkInfo.getExtraInfo()))) {
                AppMethodBeat.o(24643);
                return;
            }
            try {
                this.wMH.aIR.lock();
                this.wMH.connected = true;
                this.wMH.wMF = false;
                this.wMH.dgF.signalAll();
                Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager connect successs! signal success!");
            } finally {
                this.wMH.dMu();
                this.wMH.aIR.unlock();
                AppMethodBeat.o(24643);
            }
        } else {
            if ("android.net.wifi.supplicant.STATE_CHANGE".equals(intent.getAction())) {
                switch (c.AnonymousClass2.wMI[((SupplicantState) intent.getParcelableExtra("newState")).ordinal()]) {
                    case 1:
                        Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, ASSOCIATED");
                        break;
                    case 2:
                        Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, ASSOCIATING");
                        break;
                    case 3:
                        Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Authenticating...");
                        break;
                    case 4:
                        Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Connected");
                        break;
                    case 5:
                        Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Disconnected");
                        break;
                    case 6:
                        Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, DORMANT");
                        break;
                    case 7:
                        Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, FOUR_WAY_HANDSHAKE");
                        break;
                    case 8:
                        Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, GROUP_HANDSHAKE");
                        break;
                    case 9:
                        Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INACTIVE");
                        break;
                    case 10:
                        Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INTERFACE_DISABLED");
                        break;
                    case 11:
                        Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INVALID");
                        break;
                    case 12:
                        Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, SCANNING");
                        break;
                    case 13:
                        Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, UNINITIALIZED");
                        break;
                    default:
                        Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Unknown");
                        break;
                }
                if (intent.getIntExtra("supplicantError", -1) == 1) {
                    try {
                        this.wMH.aIR.lock();
                        this.wMH.connected = false;
                        this.wMH.wMF = true;
                        this.wMH.dgF.signalAll();
                        Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager connect AUTHENTICATING error! signal error!");
                        this.wMH.dMu();
                        this.wMH.aIR.unlock();
                        Log.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "ERROR_AUTHENTICATING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    } catch (Throwable th) {
                        this.wMH.dMu();
                        this.wMH.aIR.unlock();
                        AppMethodBeat.o(24643);
                        throw th;
                    }
                }
            }
            AppMethodBeat.o(24643);
        }
    }
}
