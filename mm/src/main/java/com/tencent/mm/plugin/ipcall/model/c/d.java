package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.sdk.platformtools.Util;

public final class d implements SensorController.SensorEventCallBack {
    long lastShakeTime = -1;
    private boolean qUo = false;
    public ShakeManager qUp = new ShakeManager(MMApplicationContext.getContext());
    public SensorController qUq = new SensorController(MMApplicationContext.getContext());
    public a yqC = null;

    public interface a {
        void qx(boolean z);
    }

    public d() {
        AppMethodBeat.i(25435);
        AppMethodBeat.o(25435);
    }

    @Override // com.tencent.mm.sdk.platformtools.SensorController.SensorEventCallBack
    public final void onSensorEvent(final boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(25436);
        Log.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isON:" + z + "  hasSkip:" + this.qUo + " tick:" + Util.ticksToNow(this.lastShakeTime) + "  lt:" + this.lastShakeTime);
        if (this.qUo) {
            if (z) {
                z2 = false;
            }
            this.qUo = z2;
            AppMethodBeat.o(25436);
        } else if (z || this.lastShakeTime == -1 || Util.ticksToNow(this.lastShakeTime) <= 400) {
            this.qUo = false;
            Log.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isNeedOffScreen: %b", Boolean.valueOf(z));
            new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.ipcall.model.c.d.AnonymousClass2 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(25434);
                    if (!z) {
                        Log.i("MicroMsg.IPCallSensorManager", "off screen");
                        if (d.this.yqC != null) {
                            d.this.yqC.qx(true);
                        }
                    } else {
                        Log.i("MicroMsg.IPCallSensorManager", "light screen");
                        if (d.this.yqC != null) {
                            d.this.yqC.qx(false);
                        }
                    }
                    AppMethodBeat.o(25434);
                    return false;
                }
            }, false).startTimer(50);
            AppMethodBeat.o(25436);
        } else {
            this.qUo = true;
            AppMethodBeat.o(25436);
        }
    }
}
