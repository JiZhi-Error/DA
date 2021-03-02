package com.tencent.kinda.framework.app;

import android.os.Looper;
import com.tencent.kinda.gen.KTimerService;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

public class KindaTimerService implements KTimerService {
    private static final String TAG = "KindaTimerService";
    private float interval;
    private boolean needThrottle;
    private MTimerHandler throttleTimerHandler = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.kinda.framework.app.KindaTimerService.AnonymousClass4 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public boolean onTimerExpired() {
            return true;
        }
    }, true);
    private VoidCallback timeCheckCallback;
    private MTimerHandler timerHandler;

    @Override // com.tencent.kinda.gen.KTimerService
    public void initIntervalAndCheckedCallbackImpl(float f2, VoidCallback voidCallback) {
        this.interval = f2;
        this.timeCheckCallback = voidCallback;
    }

    @Override // com.tencent.kinda.gen.KTimerService
    public void startTimeCheck() {
        AppMethodBeat.i(18519);
        if (this.timerHandler != null && !this.timerHandler.stopped()) {
            this.timerHandler.stopTimer();
        }
        this.timerHandler = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.kinda.framework.app.KindaTimerService.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public boolean onTimerExpired() {
                AppMethodBeat.i(18516);
                KindaTimerService.this.timeCheckCallback.call();
                Log.d(KindaTimerService.TAG, "A callback to C++ from Kinda timer was performed.");
                AppMethodBeat.o(18516);
                return true;
            }
        }, true);
        this.timerHandler.startTimer((long) (this.interval * 1000.0f));
        Log.d(TAG, "Kinda timer has started, interval(second): " + this.interval);
        AppMethodBeat.o(18519);
    }

    @Override // com.tencent.kinda.gen.KTimerService
    public void stopTimeCheck() {
        AppMethodBeat.i(18520);
        if (this.timerHandler != null) {
            this.timerHandler.stopTimer();
            Log.d(TAG, "Kinda timer has stopped.");
        }
        AppMethodBeat.o(18520);
    }

    @Override // com.tencent.kinda.gen.KTimerService
    public void throttleImpl(float f2, VoidCallback voidCallback) {
        AppMethodBeat.i(18521);
        if (this.throttleTimerHandler == null) {
            this.throttleTimerHandler = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.kinda.framework.app.KindaTimerService.AnonymousClass2 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public boolean onTimerExpired() {
                    return true;
                }
            }, true);
        }
        if (this.needThrottle) {
            AppMethodBeat.o(18521);
            return;
        }
        voidCallback.call();
        this.needThrottle = true;
        this.throttleTimerHandler.postDelayed(new Runnable() {
            /* class com.tencent.kinda.framework.app.KindaTimerService.AnonymousClass3 */

            public void run() {
                AppMethodBeat.i(18517);
                KindaTimerService.this.needThrottle = false;
                AppMethodBeat.o(18517);
            }
        }, (long) f2);
        AppMethodBeat.o(18521);
    }

    public KindaTimerService() {
        AppMethodBeat.i(18522);
        AppMethodBeat.o(18522);
    }

    @Override // com.tencent.kinda.gen.KTimerService
    public void dispatchAfterImpl(float f2, final VoidCallback voidCallback) {
        AppMethodBeat.i(18523);
        if (this.throttleTimerHandler == null) {
            this.throttleTimerHandler = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.kinda.framework.app.KindaTimerService.AnonymousClass5 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public boolean onTimerExpired() {
                    return true;
                }
            }, true);
        }
        this.throttleTimerHandler.postDelayed(new Runnable() {
            /* class com.tencent.kinda.framework.app.KindaTimerService.AnonymousClass6 */

            public void run() {
                AppMethodBeat.i(18518);
                voidCallback.call();
                AppMethodBeat.o(18518);
            }
        }, (long) f2);
        AppMethodBeat.o(18523);
    }

    @Override // com.tencent.kinda.gen.KTimerService
    public double now() {
        AppMethodBeat.i(18524);
        double currentTimeMillis = (double) System.currentTimeMillis();
        AppMethodBeat.o(18524);
        return currentTimeMillis;
    }
}
