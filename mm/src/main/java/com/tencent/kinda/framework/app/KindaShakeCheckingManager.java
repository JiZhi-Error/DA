package com.tencent.kinda.framework.app;

import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.IShakeCheckingManager;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;

public class KindaShakeCheckingManager implements IShakeCheckingManager {
    private static final int CONTINUE_SHAKE_INTERVAL = 80;
    private static final int FIRST_SHAKE_INTERVAL = 1200;
    private final String TAG = "KindaShakeCheckingManager";
    private Runnable delayNofiyRunnable = new Runnable() {
        /* class com.tencent.kinda.framework.app.KindaShakeCheckingManager.AnonymousClass1 */

        public void run() {
            AppMethodBeat.i(18509);
            if (!KindaShakeCheckingManager.this.isInvokeCallback && KindaShakeCheckingManager.this.delayNotifyCallback != null) {
                KindaShakeCheckingManager.this.delayNotifyCallback.call();
            }
            AppMethodBeat.o(18509);
        }
    };
    private VoidCallback delayNotifyCallback;
    private int delayNotifyMs = 3000;
    private boolean isInvokeCallback = false;
    private boolean isStartShake = false;
    private long lastShakeTime;
    private VoidCallback shakeCallBack;
    private d shakeSensor;

    public KindaShakeCheckingManager() {
        AppMethodBeat.i(18511);
        AppMethodBeat.o(18511);
    }

    @Override // com.tencent.kinda.gen.IShakeCheckingManager
    public void startCheck() {
        AppMethodBeat.i(18512);
        KindaContext.get();
        this.shakeSensor = new d();
        this.shakeSensor.a(new d.a() {
            /* class com.tencent.kinda.framework.app.KindaShakeCheckingManager.AnonymousClass2 */

            @Override // com.tencent.mm.pluginsdk.l.d.a
            public void onShake(boolean z) {
                AppMethodBeat.i(18510);
                Log.i("KindaShakeCheckingManager", "onShake");
                long ticksToNow = Util.ticksToNow(KindaShakeCheckingManager.this.lastShakeTime);
                if (!KindaShakeCheckingManager.this.isStartShake) {
                    if (ticksToNow < 1200) {
                        AppMethodBeat.o(18510);
                        return;
                    }
                } else if (ticksToNow < 80) {
                    AppMethodBeat.o(18510);
                    return;
                }
                KindaShakeCheckingManager.this.lastShakeTime = Util.currentTicks();
                KindaShakeCheckingManager.this.isStartShake = true;
                if (!KindaShakeCheckingManager.this.isInvokeCallback) {
                    KindaShakeCheckingManager.this.isInvokeCallback = true;
                    if (KindaShakeCheckingManager.this.shakeCallBack != null) {
                        KindaShakeCheckingManager.this.shakeCallBack.call();
                    }
                }
                AppMethodBeat.o(18510);
            }

            @Override // com.tencent.mm.pluginsdk.l.d.a
            public void onRelease() {
            }
        });
        this.lastShakeTime = Util.currentTicks();
        MMHandlerThread.removeRunnable(this.delayNofiyRunnable);
        MMHandlerThread.postToMainThreadDelayed(this.delayNofiyRunnable, (long) this.delayNotifyMs);
        AppMethodBeat.o(18512);
    }

    @Override // com.tencent.kinda.gen.IShakeCheckingManager
    public void stopCheck() {
        AppMethodBeat.i(18513);
        if (this.shakeSensor != null) {
            this.shakeSensor.cBo();
            this.shakeSensor = null;
        }
        this.isInvokeCallback = false;
        this.isStartShake = false;
        MMHandlerThread.removeRunnable(this.delayNofiyRunnable);
        AppMethodBeat.o(18513);
    }

    @Override // com.tencent.kinda.gen.IShakeCheckingManager
    public void setOnShakeCallBackImpl(VoidCallback voidCallback) {
        this.shakeCallBack = voidCallback;
    }

    @Override // com.tencent.kinda.gen.IShakeCheckingManager
    public void setDelayNotifyCallBackImpl(VoidCallback voidCallback, int i2) {
        this.delayNotifyCallback = voidCallback;
        this.delayNotifyMs = i2;
    }

    @Override // com.tencent.kinda.gen.IShakeCheckingManager
    public void playShakeSound() {
        AppMethodBeat.i(18514);
        PlaySound.play(KindaContext.get(), R.string.gzt);
        AppMethodBeat.o(18514);
    }

    @Override // com.tencent.kinda.gen.IShakeCheckingManager
    public void playShakeMatch(boolean z) {
        AppMethodBeat.i(18515);
        if (z) {
            PlaySound.play(KindaContext.get(), R.string.gyz);
            AppMethodBeat.o(18515);
            return;
        }
        PlaySound.play(KindaContext.get(), R.string.gz7);
        AppMethodBeat.o(18515);
    }
}
