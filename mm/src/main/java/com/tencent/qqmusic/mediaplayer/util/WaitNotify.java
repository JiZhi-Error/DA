package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;

public class WaitNotify {
    private static final String TAG = "WaitNotify";
    private volatile boolean isWaiting = false;
    private final MonitorObject myMonitorObject = new MonitorObject();
    private volatile boolean wasSignalled = false;

    public interface WaitListener {
        boolean keepWaiting();
    }

    public WaitNotify() {
        AppMethodBeat.i(114159);
        AppMethodBeat.o(114159);
    }

    public boolean isWaiting() {
        return this.isWaiting;
    }

    public void doWait() {
        AppMethodBeat.i(114160);
        doWait(MAlarmHandler.NEXT_FIRE_INTERVAL, 0, new WaitListener() {
            /* class com.tencent.qqmusic.mediaplayer.util.WaitNotify.AnonymousClass1 */

            @Override // com.tencent.qqmusic.mediaplayer.util.WaitNotify.WaitListener
            public boolean keepWaiting() {
                return true;
            }
        });
        AppMethodBeat.o(114160);
    }

    public void doWait(long j2, int i2, WaitListener waitListener) {
        int i3 = 0;
        AppMethodBeat.i(114161);
        Logger.d(TAG, "doWait " + Thread.currentThread().getName());
        synchronized (this.myMonitorObject) {
            try {
                this.wasSignalled = false;
                while (true) {
                    if (this.wasSignalled) {
                        break;
                    }
                    try {
                        Logger.d(TAG, "doWait internal " + Thread.currentThread().getName() + " " + i3);
                        this.isWaiting = true;
                        if (i3 < i2) {
                            this.myMonitorObject.wait(j2, 0);
                            if (!waitListener.keepWaiting()) {
                                doNotify();
                                break;
                            }
                        } else {
                            this.myMonitorObject.wait();
                        }
                        Logger.d(TAG, "doWait wake " + Thread.currentThread().getName() + " " + i3);
                    } catch (InterruptedException e2) {
                        Logger.e(TAG, e2.toString());
                    }
                    i3++;
                }
                this.isWaiting = false;
            } finally {
                AppMethodBeat.o(114161);
            }
        }
    }

    public void doNotify() {
        AppMethodBeat.i(114162);
        Logger.d(TAG, "doNotify " + Thread.currentThread().getName());
        synchronized (this.myMonitorObject) {
            try {
                this.wasSignalled = true;
                Logger.d(TAG, "doNotify internal " + Thread.currentThread().getName());
                this.myMonitorObject.notifyAll();
                Logger.d(TAG, "doNotify over " + Thread.currentThread().getName());
            } finally {
                AppMethodBeat.o(114162);
            }
        }
    }
}
