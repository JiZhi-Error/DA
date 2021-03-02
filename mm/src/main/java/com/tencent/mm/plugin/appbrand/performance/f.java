package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.coremedia.TimeUtil;

@TargetApi(16)
public final class f implements Choreographer.FrameCallback {
    private Choreographer fH = Choreographer.getInstance();
    private boolean mEnabled = false;
    public long mInterval = 200;
    public a nwI;
    private long nwY = 0;
    private int nwZ = 0;
    public volatile double nxa = 0.0d;

    public interface a {
        void t(double d2);
    }

    public f() {
        AppMethodBeat.i(139905);
        AppMethodBeat.o(139905);
    }

    public final void start() {
        AppMethodBeat.i(139906);
        if (this.mEnabled) {
            AppMethodBeat.o(139906);
            return;
        }
        this.mEnabled = true;
        Log.i("FPSMetronome", "[start] stack:%s", Util.getStack());
        this.fH.postFrameCallback(this);
        AppMethodBeat.o(139906);
    }

    public final void stop() {
        AppMethodBeat.i(139907);
        if (!this.mEnabled) {
            AppMethodBeat.o(139907);
            return;
        }
        this.mEnabled = false;
        this.nwY = 0;
        this.nwZ = 0;
        Log.i("FPSMetronome", "[stop] stack:%s", Util.getStack());
        this.fH.removeFrameCallback(this);
        AppMethodBeat.o(139907);
    }

    public final void doFrame(long j2) {
        double d2 = 60.0d;
        AppMethodBeat.i(139908);
        if (this.mEnabled) {
            long j3 = j2 / TimeUtil.SECOND_TO_US;
            if (this.nwY > 0) {
                long j4 = j3 - this.nwY;
                this.nwZ++;
                if (j4 > this.mInterval) {
                    double d3 = ((double) (this.nwZ * 1000)) / ((double) j4);
                    if (d3 < 60.0d) {
                        d2 = d3;
                    }
                    this.nwY = j3;
                    this.nwZ = 0;
                    this.nxa = d2;
                    if (this.nwI != null) {
                        this.nwI.t(d2);
                    }
                }
            } else {
                this.nwY = j3;
            }
        }
        if (this.mEnabled) {
            this.fH.postFrameCallback(this);
        }
        AppMethodBeat.o(139908);
    }
}
