package com.tencent.mars.ilink.comm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.PowerManager;
import com.tencent.mars.ilink.xlog.Log;

public class WakerLock {
    private static final String TAG = "MicroMsg.WakerLock";
    private Handler mHandler = null;
    private Runnable mReleaser = new Runnable() {
        /* class com.tencent.mars.ilink.comm.WakerLock.AnonymousClass1 */

        public void run() {
            WakerLock.this.unLock();
        }
    };
    private PowerManager.WakeLock wakeLock = null;

    @SuppressLint({"InvalidWakeLockTag"})
    public WakerLock(Context context) {
        this.wakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, TAG);
        this.wakeLock.setReferenceCounted(false);
        this.mHandler = new Handler(context.getMainLooper());
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        unLock();
    }

    public void lock(long j2) {
        if (j2 == -1) {
            try {
                this.wakeLock.acquire();
                Log.w(TAG, "acquire wakelock without timeout, msg:");
            } catch (Exception e2) {
            }
        } else {
            this.wakeLock.acquire(j2);
        }
    }

    public void lock() {
        try {
            this.mHandler.removeCallbacks(this.mReleaser);
            lock(-1);
        } catch (Exception e2) {
        }
    }

    public void unLock() {
        try {
            this.mHandler.removeCallbacks(this.mReleaser);
            if (this.wakeLock.isHeld()) {
                this.wakeLock.release();
            }
        } catch (Exception e2) {
        }
    }

    public boolean isLocking() {
        try {
            return this.wakeLock.isHeld();
        } catch (Exception e2) {
            return false;
        }
    }
}
