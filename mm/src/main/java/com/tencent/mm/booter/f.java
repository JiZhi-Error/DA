package com.tencent.mm.booter;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class f {
    NetworkInfo glA = null;
    String glB = "";
    String glC = "";
    int glD = -1;

    /* access modifiers changed from: package-private */
    public final boolean akC() {
        NetworkInfo networkInfo = null;
        AppMethodBeat.i(131895);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) af.getContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                Log.w("MicroMsg.NetworkChangeMgr", "can't get ConnectivityManager");
                this.glA = null;
                AppMethodBeat.o(131895);
                return false;
            }
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Exception e2) {
                Log.e("MicroMsg.NetworkChangeMgr", "getActiveNetworkInfo failed.");
            }
            if (networkInfo == null) {
                Log.w("MicroMsg.NetworkChangeMgr", "ActiveNetwork is null, has no network");
                this.glA = null;
                AppMethodBeat.o(131895);
                return false;
            }
            boolean z = networkInfo.getType() == 1;
            if (z) {
                WifiInfo wifiInfo = NetStatusUtil.getWifiInfo(MMApplicationContext.getContext());
                if (wifiInfo != null) {
                    Log.d("MicroMsg.NetworkChangeMgr", "New Wifi Info:[%s][%s][%s]", wifiInfo.getBSSID(), NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext()), Integer.valueOf(wifiInfo.getNetworkId()));
                    Log.d("MicroMsg.NetworkChangeMgr", "OldWifi Info:[%s][%s][%s]", this.glC, this.glB, Integer.valueOf(this.glD));
                    if (!this.glC.equals(wifiInfo.getBSSID()) || !this.glB.equals(NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext())) || this.glD != wifiInfo.getNetworkId()) {
                        this.glC = wifiInfo.getBSSID();
                        this.glB = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
                        this.glD = wifiInfo.getNetworkId();
                    } else {
                        Log.w("MicroMsg.NetworkChangeMgr", "Same Wifi, do not NetworkChanged");
                        AppMethodBeat.o(131895);
                        return false;
                    }
                }
            } else if (this.glA != null && this.glA.getExtraInfo() != null && networkInfo.getExtraInfo() != null && this.glA.getExtraInfo().equals(networkInfo.getExtraInfo()) && this.glA.getSubtype() == networkInfo.getSubtype() && this.glA.getType() == networkInfo.getType()) {
                Log.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
                AppMethodBeat.o(131895);
                return false;
            } else if (this.glA != null && this.glA.getExtraInfo() == null && networkInfo.getExtraInfo() == null && this.glA.getSubtype() == networkInfo.getSubtype() && this.glA.getType() == networkInfo.getType()) {
                Log.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
                AppMethodBeat.o(131895);
                return false;
            }
            if (!z) {
                Log.d("MicroMsg.NetworkChangeMgr", "New NetworkInfo:%s", networkInfo);
                if (this.glA != null) {
                    Log.d("MicroMsg.NetworkChangeMgr", "Old NetworkInfo:%s", this.glA);
                }
                this.glC = "";
                this.glB = "";
                this.glD = -1;
            }
            this.glA = networkInfo;
            AppMethodBeat.o(131895);
            return true;
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.NetworkChangeMgr", e3, "", new Object[0]);
        }
    }
}
