package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.mm.sdk.platformtools.Log;

public abstract class e {
    f GsO;
    a GsP;
    private final String TAG = "MicroMsg.TrafficInspector";
    int currentIndex;
    int id;
    long interval;
    int type;

    public interface a {
    }

    /* access modifiers changed from: package-private */
    public abstract void fAh();

    static boolean KL(long j2) {
        if (!TrafficClickFlowReceiver.KI(j2)) {
            return false;
        }
        boolean KJ = TrafficClickFlowReceiver.KJ(j2);
        Log.i("MicroMsg.TrafficInspector", "hasDownload");
        return KJ;
    }

    /* access modifiers changed from: package-private */
    public final void fAj() {
        g.fAk();
        if (this.id == g.fAn()) {
            TrafficClickFlowReceiver.fAi();
            g.fAk();
            g.fAm();
        }
    }
}
