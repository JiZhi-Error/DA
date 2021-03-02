package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.TrafficStats;

public class TrafficStatsReceiver extends BroadcastReceiver {
    private long mLastTime = -1;

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(131937);
        Log.d("MicroMsg.TrafficStats", "onRecieve");
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.booter.TrafficStatsReceiver.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(196983);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (Build.VERSION.SDK_INT >= 28) {
                    TrafficStats.updateNsm(MMApplicationContext.getContext());
                } else {
                    TrafficStats.update();
                }
                if (TrafficStatsReceiver.this.mLastTime >= 0) {
                    long j2 = elapsedRealtime - TrafficStatsReceiver.this.mLastTime;
                    long mobileRx = TrafficStats.getMobileRx(0) + TrafficStats.getMobileTx(0);
                    long wifiRx = TrafficStats.getWifiRx(0) + TrafficStats.getWifiTx(0);
                    long wxMobileRx = TrafficStats.getWxMobileRx(0) + TrafficStats.getWxMobileTx(0);
                    long wxMobileRx2 = TrafficStats.getWxMobileRx(0) + TrafficStats.getWxMobileTx(0);
                    Log.i("MicroMsg.TrafficStats", "Time: %d ms, System - [Mobile: %d, Wifi: %d, Speed: %.2f], WeChat - [Mobile: %d, Wifi: %d, Speed: %.2f]", Long.valueOf(j2), Long.valueOf(mobileRx), Long.valueOf(wifiRx), Double.valueOf(((double) (mobileRx + wifiRx)) / ((double) (j2 / 1000))), Long.valueOf(wxMobileRx), Long.valueOf(wxMobileRx2), Double.valueOf(((double) (wxMobileRx + wxMobileRx2)) / ((double) (j2 / 1000))));
                }
                TrafficStatsReceiver.this.mLastTime = elapsedRealtime;
                AppMethodBeat.o(196983);
            }
        }, "TrafficStats.onReceive");
        AppMethodBeat.o(131937);
    }

    public static void cm(Context context) {
        AppMethodBeat.i(131938);
        a.a(context, 111, 3, SystemClock.elapsedRealtime(), 300000, new Intent("com.tencent.mm.TrafficStatsReceiver"));
        Log.i("MicroMsg.TrafficStats", "Register alarm, interval: %d ms", 300000L);
        AppMethodBeat.o(131938);
    }

    public static void cn(Context context) {
        AppMethodBeat.i(131939);
        a.c(context, new Intent("com.tencent.mm.TrafficStatsReceiver"));
        AppMethodBeat.o(131939);
    }
}
