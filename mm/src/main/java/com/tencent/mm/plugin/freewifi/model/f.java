package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class f {
    private b wOI;

    /* synthetic */ f(byte b2) {
        this();
    }

    private f() {
    }

    public static class a {
        private static f wOJ = new f((byte) 0);

        static {
            AppMethodBeat.i(24796);
            AppMethodBeat.o(24796);
        }
    }

    public final synchronized void dNg() {
        AppMethodBeat.i(24798);
        if (this.wOI != null) {
            Log.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory : ssid=%s, bssid=%s ", this.wOI.wOK, this.wOI.wOL);
        } else {
            Log.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory is null.");
        }
        this.wOI = null;
        Log.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "new WifiInfo stored in memmory is null.");
        AppMethodBeat.o(24798);
    }

    public final synchronized boolean ao(String str, String str2, String str3) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(24799);
            if (Util.isNullOrNil(str, str2, str3)) {
                Log.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "WifiInfo got Currently is null. Cannot compared with last WifiInfo.");
                AppMethodBeat.o(24799);
            } else {
                if (this.wOI != null) {
                    Log.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory : ssid=%s, bssid=%s ", this.wOI.wOK, this.wOI.wOL);
                    if (m.removeSsidQuote(str).equals(this.wOI.wOK) && str2.equalsIgnoreCase(this.wOI.wOL)) {
                        AppMethodBeat.o(24799);
                    }
                } else {
                    Log.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory is null.");
                }
                this.wOI = new b(m.removeSsidQuote(str), str2, str3, System.currentTimeMillis(), (byte) 0);
                Log.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "new WifiInfo stored in memmory : ssid=%s, bssid=%s ", this.wOI.wOK, this.wOI.wOL);
                AppMethodBeat.o(24799);
                z = true;
            }
        }
        return z;
    }

    public final synchronized b dNh() {
        return this.wOI;
    }

    public final synchronized void dNi() {
        b bVar;
        AppMethodBeat.i(24800);
        if (this.wOI != null) {
            b bVar2 = this.wOI;
            if (bVar2.wON) {
                bVar = bVar2;
            } else {
                bVar = new b(bVar2.wOK, bVar2.wOL, bVar2.wOM, bVar2.wOB);
                bVar.wON = true;
            }
            this.wOI = bVar;
        }
        AppMethodBeat.o(24800);
    }

    public static final class b {
        public long wOB;
        public String wOK;
        public String wOL;
        public String wOM;
        public boolean wON;

        /* synthetic */ b(String str, String str2, String str3, long j2, byte b2) {
            this(str, str2, str3, j2);
        }

        b(String str, String str2, String str3, long j2) {
            AppMethodBeat.i(24797);
            this.wOK = m.removeSsidQuote(str);
            this.wOL = str2;
            this.wOM = str3;
            this.wOB = j2;
            this.wON = false;
            AppMethodBeat.o(24797);
        }
    }
}
