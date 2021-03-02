package com.tencent.mm.plugin.sns.waid;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class a {
    ArrayList<Runnable> FgH = new ArrayList<>();
    HandlerThread FgI;
    Handler FgJ;
    private Runnable FgK = new Runnable() {
        /* class com.tencent.mm.plugin.sns.waid.a.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(204035);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mm.plugin.sns.ad.b.a.eWD();
                Log.i("InitTaskMgr", "DeviceIdInitTask run, timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(204035);
            } catch (Exception e2) {
                Log.e("InitTaskMgr", "mDeviceIdInitTask exp=" + e2.toString());
                AppMethodBeat.o(204035);
            }
        }
    };
    private final String TAG = "InitTaskMgr";

    public a() {
        AppMethodBeat.i(204036);
        this.FgH.add(this.FgK);
        try {
            this.FgI = new HandlerThread("waidproviderInitTask");
            this.FgI.start();
            this.FgJ = new Handler(this.FgI.getLooper());
            AppMethodBeat.o(204036);
        } catch (Exception e2) {
            Log.e("InitTaskMgr", "initWorkThread exp=" + e2.toString());
            AppMethodBeat.o(204036);
        }
    }
}
