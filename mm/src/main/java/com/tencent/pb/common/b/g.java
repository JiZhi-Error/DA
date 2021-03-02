package com.tencent.pb.common.b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;

public final class g {
    private WifiInfo RDc = null;
    private NetworkInfo glA = null;
    private int lastNetType = 1;

    public final synchronized boolean akC() {
        boolean z;
        int i2;
        WifiInfo wifiInfo = null;
        synchronized (this) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) c.Hhs.getSystemService("connectivity");
                if (connectivityManager == null) {
                    b.w("NetworkChangeMgr", "can't get ConnectivityManager");
                    this.lastNetType = 1;
                    this.RDc = null;
                    this.glA = null;
                    z = true;
                } else {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        this.lastNetType = 1;
                        this.RDc = null;
                        this.glA = null;
                        z = true;
                    } else {
                        b.d("NetworkChangeMgr", "NetworkChangeMgr ", activeNetworkInfo);
                        if (!activeNetworkInfo.isConnected()) {
                            i2 = 1;
                        } else if (activeNetworkInfo.getType() == 1) {
                            i2 = 2;
                            wifiInfo = ((WifiManager) c.Hhs.getSystemService("wifi")).getConnectionInfo();
                        } else {
                            i2 = 3;
                        }
                        if (i2 == this.lastNetType) {
                            if (i2 == 1) {
                                z = false;
                            } else if (i2 == 2) {
                                if (wifiInfo == null || this.RDc == null || !this.RDc.getBSSID().equals(wifiInfo.getBSSID()) || !this.RDc.getSSID().equals(wifiInfo.getSSID()) || this.RDc.getNetworkId() != wifiInfo.getNetworkId()) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            } else if (this.glA != null && this.glA.getExtraInfo() != null && activeNetworkInfo.getExtraInfo() != null && this.glA.getExtraInfo().equals(activeNetworkInfo.getExtraInfo()) && this.glA.getSubtype() == activeNetworkInfo.getSubtype() && this.glA.getType() == activeNetworkInfo.getType()) {
                                z = false;
                            } else if (this.glA != null && this.glA.getExtraInfo() == null && activeNetworkInfo.getExtraInfo() == null && this.glA.getSubtype() == activeNetworkInfo.getSubtype() && this.glA.getType() == activeNetworkInfo.getType()) {
                                z = false;
                            }
                            this.lastNetType = i2;
                            this.RDc = wifiInfo;
                            this.glA = activeNetworkInfo;
                        }
                        z = true;
                        this.lastNetType = i2;
                        this.RDc = wifiInfo;
                        this.glA = activeNetworkInfo;
                    }
                }
            } catch (Exception e2) {
                b.w("NetworkChangeMgr", e2);
                this.lastNetType = 1;
                this.RDc = null;
                this.glA = null;
                z = true;
            }
        }
        return z;
    }
}
