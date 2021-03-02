package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class WiFiConnector$2 extends BroadcastReceiver {
    final /* synthetic */ a mIt;

    public WiFiConnector$2(a aVar) {
        this.mIt = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        int i2;
        String str;
        AppMethodBeat.i(144703);
        if (intent == null) {
            AppMethodBeat.o(144703);
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            AppMethodBeat.o(144703);
            return;
        }
        Log.i("MicroMsg.WiFiConnector", "startMonitorWiFiEvent, action: ".concat(String.valueOf(action)));
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.net.wifi.STATE_CHANGE".equals(action)) {
            NetworkInfo activeNetworkInfo = this.mIt.mIp.getActiveNetworkInfo();
            WifiInfo connectionInfo = d.getConnectionInfo();
            if (activeNetworkInfo != null && connectionInfo != null && activeNetworkInfo.getType() == 1 && activeNetworkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED && connectionInfo.getNetworkId() == this.mIt.mIo.networkId) {
                this.mIt.q(true, "");
                Log.i("MicroMsg.wifi_event", "CONNECTIVITY_ACTION CONNECTED.");
            }
            AppMethodBeat.o(144703);
            return;
        }
        if ("android.net.wifi.supplicant.STATE_CHANGE".equals(action)) {
            try {
                i2 = intent.getIntExtra("supplicantError", -1);
            } catch (Exception e2) {
                Log.e("MicroMsg.WiFiConnector", e2.getMessage());
                i2 = -1;
            }
            if (i2 == 1) {
                Log.e("MicroMsg.WiFiConnector", "ERROR_AUTHENTICATING");
                Log.i("MicroMsg.wifi_event", "ERROR_AUTHENTICATING FAIL.");
                a aVar = this.mIt;
                if (this.mIt.mIs) {
                    str = "wifi config may be expired";
                } else {
                    str = "password error";
                }
                aVar.q(false, str);
            }
        }
        AppMethodBeat.o(144703);
    }
}
