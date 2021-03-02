package com.tencent.mm.plugin.sns.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class bf {
    int CTg = fiw();
    b EGI;
    private BroadcastReceiver wOz = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.sns.ui.bf.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(98915);
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                Log.i("MicroMsg.Sns.SnsNetworkMgr", "connChangedBroadcastReceiver");
                int i2 = bf.this.CTg;
                bf.this.CTg = bf.fiw();
                Log.i("MicroMsg.Sns.SnsNetworkMgr", "network change current:%s change:%s", Integer.valueOf(i2), Integer.valueOf(bf.this.CTg));
                if (!(bf.this.CTg == i2 || bf.this.EGI == null)) {
                    bf.this.EGI.fix();
                }
            }
            AppMethodBeat.o(98915);
        }
    };

    public static class a {
        static int EGK = 1;
        static int EGL = 2;
        static int EGM = 3;
        static int EGN = 4;
        static int WIFI = 5;
    }

    interface b {
        void fix();
    }

    public bf() {
        AppMethodBeat.i(98916);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        dMu();
        MMApplicationContext.getContext().registerReceiver(this.wOz, intentFilter);
        AppMethodBeat.o(98916);
    }

    public final boolean cGF() {
        return this.CTg == a.WIFI;
    }

    public final boolean emf() {
        return this.CTg == a.EGL || this.CTg == a.EGM;
    }

    static int fiw() {
        int i2;
        AppMethodBeat.i(98917);
        if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
            i2 = a.EGK;
        } else if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            i2 = a.WIFI;
        } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
            i2 = a.EGL;
        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
            i2 = a.EGM;
        } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
            i2 = a.EGN;
        } else {
            Log.i("MicroMsg.Sns.SnsNetworkMgr", "failed and return 4g");
            i2 = a.EGN;
        }
        Log.i("MicroMsg.Sns.SnsNetworkMgr", "currentNetworkStatus:%s", Integer.valueOf(i2));
        AppMethodBeat.o(98917);
        return i2;
    }

    public final void dMu() {
        AppMethodBeat.i(98918);
        try {
            MMApplicationContext.getContext().unregisterReceiver(this.wOz);
            AppMethodBeat.o(98918);
        } catch (IllegalArgumentException e2) {
            AppMethodBeat.o(98918);
        }
    }
}
