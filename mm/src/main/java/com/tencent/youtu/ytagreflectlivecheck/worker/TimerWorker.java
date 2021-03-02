package com.tencent.youtu.ytagreflectlivecheck.worker;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import java.util.Timer;
import java.util.TimerTask;

public abstract class TimerWorker {
    private static final String TAG = "CloudFaceCountDownTimer";
    private boolean mCancelled = false;
    private final long mCountdownInterval;
    private final long mMillisInFuture;
    private long mStopTimeInFuture;
    private Timer mTimer;

    public abstract void onFinish();

    public abstract void onTick(long j2);

    protected TimerWorker(long j2, long j3) {
        YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "[TimerWorker.TimerWorker] mCountDownTimer");
        this.mMillisInFuture = j2;
        this.mCountdownInterval = j3;
    }

    public final synchronized void cancel() {
        this.mCancelled = true;
        if (this.mTimer != null) {
            this.mTimer = null;
        }
    }

    public final synchronized TimerWorker start() {
        TimerWorker timerWorker;
        this.mCancelled = false;
        if (this.mMillisInFuture <= 0) {
            onFinish();
            timerWorker = this;
        } else {
            this.mStopTimeInFuture = SystemClock.elapsedRealtime() + this.mMillisInFuture;
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() {
                /* class com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(43426);
                    if (TimerWorker.this.mCancelled) {
                        AppMethodBeat.o(43426);
                        return;
                    }
                    TimerWorker.this.continueTimerJudge();
                    AppMethodBeat.o(43426);
                }
            }, 0, this.mCountdownInterval);
            timerWorker = this;
        }
        return timerWorker;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void continueTimerJudge() {
        if (!this.mCancelled) {
            long elapsedRealtime = this.mStopTimeInFuture - SystemClock.elapsedRealtime();
            if (elapsedRealtime <= 0) {
                this.mTimer.cancel();
                onFinish();
            } else if (elapsedRealtime >= this.mCountdownInterval) {
                SystemClock.elapsedRealtime();
                onTick(elapsedRealtime);
                SystemClock.elapsedRealtime();
            }
        }
    }
}
