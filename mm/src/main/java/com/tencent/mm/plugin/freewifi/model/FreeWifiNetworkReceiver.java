package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class FreeWifiNetworkReceiver extends BroadcastReceiver {
    public b wOS;
    public a wOT;

    public interface a {
        void a(NetworkInfo.State state);
    }

    public interface b {
        void Nf(int i2);
    }

    public void onReceive(Context context, Intent intent) {
        Parcelable parcelableExtra;
        NetworkInfo networkInfo;
        AppMethodBeat.i(24806);
        if (intent == null) {
            Log.e("MicroMsg.FreeWifi.WifiStateChangedReceiver", "intent is null");
            AppMethodBeat.o(24806);
            return;
        }
        String action = intent.getAction();
        Log.i("MicroMsg.FreeWifi.WifiStateChangedReceiver", "FreeWifiNetworkReceiver action : %s", action);
        if (Util.isNullOrNil(action)) {
            Log.e("MicroMsg.FreeWifi.WifiStateChangedReceiver", "action is null");
            AppMethodBeat.o(24806);
        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
            int intExtra = intent.getIntExtra("wifi_state", 0);
            Log.i("MicroMsg.FreeWifi.WifiStateChangedReceiver", "now wifi state : %d", Integer.valueOf(intExtra));
            if (this.wOS != null) {
                this.wOS.Nf(intExtra);
            }
            AppMethodBeat.o(24806);
        } else {
            if (!(!action.equals("android.net.wifi.STATE_CHANGE") || (parcelableExtra = intent.getParcelableExtra("networkInfo")) == null || (networkInfo = (NetworkInfo) parcelableExtra) == null || this.wOT == null)) {
                this.wOT.a(networkInfo.getState());
            }
            AppMethodBeat.o(24806);
        }
    }
}
