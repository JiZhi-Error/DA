package com.tencent.mm.plugin.mmsight.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class c {
    int duration;
    long gXF;
    boolean isStart;
    MTimerHandler jer = null;
    private float zCH = 0.0f;
    float zCI;
    float zCJ;
    float zCK;
    a zCL;

    public interface a {
        void bv(float f2);

        void onAnimationEnd();
    }

    public c(float f2, float f3, int i2) {
        AppMethodBeat.i(94630);
        this.zCI = f2;
        this.zCJ = f3;
        this.duration = i2;
        this.zCH = (100.0f / ((float) this.duration)) * 20.0f;
        Log.i("MicroMsg.ProgressHandlerAnimator", "create ProgressHandlerAnimator, start: %s, end: %s, duration: %s, updateStep: %s", Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Float.valueOf(this.zCH));
        this.isStart = false;
        this.gXF = 0;
        this.jer = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.mmsight.ui.c.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(94628);
                c cVar = c.this;
                cVar.zCK = ((((float) Util.ticksToNow(cVar.gXF)) / ((float) cVar.duration)) * 100.0f) + cVar.zCI;
                if (cVar.zCL != null) {
                    cVar.zCL.bv(cVar.zCK);
                }
                if (!c.this.isStart) {
                    Log.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
                    AppMethodBeat.o(94628);
                    return false;
                } else if (c.this.zCK < c.this.zCJ) {
                    AppMethodBeat.o(94628);
                    return true;
                } else {
                    c.this.isStart = false;
                    Log.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s, callback: %s", Float.valueOf(c.this.zCK), Float.valueOf(c.this.zCJ), c.this.zCL);
                    if (c.this.zCL != null) {
                        c.this.zCL.onAnimationEnd();
                    }
                    AppMethodBeat.o(94628);
                    return false;
                }
            }
        }, true);
        AppMethodBeat.o(94630);
    }

    public final void cancel() {
        this.isStart = false;
        this.gXF = 0;
    }
}
