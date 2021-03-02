package com.tencent.mars.comm;

import android.content.Context;
import android.os.PowerManager;
import com.tencent.mm.jni.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class WakerLock {
    private static final String TAG = "MicroMsg.WakerLock";
    private static long lastChecktime = 0;
    private static Boolean shouldLock = null;
    private IAutoUnlockCallback autoUnlockCallback;
    private Context context;
    private String mCreatePosStackLine;
    private MMHandler mHandler;
    private Runnable mReleaser;
    private PowerManager.WakeLock wakeLock;

    public interface IAutoUnlockCallback {
        void autoUnlockCallback();
    }

    private String getCallerStack() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.getClassName().contains(WakerLock.class.getName())) {
                return stackTraceElement.toString();
            }
        }
        return "<native>";
    }

    public String getCreatePosStackLine() {
        return this.mCreatePosStackLine;
    }

    public WakerLock(Context context2, String str, IAutoUnlockCallback iAutoUnlockCallback) {
        this(context2, str);
        this.autoUnlockCallback = iAutoUnlockCallback;
    }

    public WakerLock(Context context2, String str) {
        this.mCreatePosStackLine = null;
        this.wakeLock = null;
        this.mHandler = null;
        this.autoUnlockCallback = null;
        this.mReleaser = new Runnable() {
            /* class com.tencent.mars.comm.WakerLock.AnonymousClass1 */

            public void run() {
                if (WakerLock.this.wakeLock.isHeld()) {
                    Log.w(WakerLock.TAG, "unlock by fucking handler! [%d,%d] @[%s]", Integer.valueOf(WakerLock.this.hashCode()), Integer.valueOf(WakerLock.this.wakeLock.hashCode()), WakerLock.this.mCreatePosStackLine);
                    WakerLock.this.unLock();
                    if (WakerLock.this.autoUnlockCallback != null) {
                        WakerLock.this.autoUnlockCallback.autoUnlockCallback();
                    }
                }
            }
        };
        this.mCreatePosStackLine = getCallerStack();
        this.wakeLock = ((PowerManager) context2.getSystemService("power")).newWakeLock(1, str);
        this.wakeLock.setReferenceCounted(false);
        this.mHandler = new MMHandler(context2.getMainLooper());
        this.context = context2;
        Log.i(TAG, "init [%d,%d] @[%s]", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), this.mCreatePosStackLine);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        Log.i(TAG, "finalize unlock [%d,%d] @[%s]", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), this.mCreatePosStackLine);
        unLock();
        super.finalize();
    }

    public void lock(long j2) {
        lock(j2, getCallerStack());
    }

    public void lock() {
        lock(getCallerStack());
    }

    public void lock(String str) {
        lock(-1, str);
    }

    public void lock(long j2, String str) {
        try {
            if (this.wakeLock.isHeld()) {
                unLock();
            }
            a.a(this, str);
            Log.i(TAG, "lock [%d,%d] traceMsg:[%s] @[%s] limit time:%d", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), str, getCreatePosStackLine(), Long.valueOf(j2));
            this.wakeLock.acquire();
            if (j2 == -1) {
                this.mHandler.removeCallbacks(this.mReleaser);
            } else {
                this.mHandler.postDelayed(this.mReleaser, j2);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", "");
        }
    }

    public void unLock() {
        if (this.wakeLock.isHeld()) {
            this.mHandler.removeCallbacks(this.mReleaser);
            a.c(this);
            Log.i(TAG, "unlock [%d,%d] caller:[%s] @[%s]", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), getCallerStack(), getCreatePosStackLine());
            try {
                this.wakeLock.release();
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", "");
            }
        }
    }

    public boolean isLocking() {
        try {
            boolean isHeld = this.wakeLock.isHeld();
            Log.i(TAG, "check is held [%d,%d] :%b caller:[%s] @[%s]", Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), Boolean.valueOf(isHeld), getCallerStack(), getCreatePosStackLine());
            return isHeld;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", "");
            return false;
        }
    }

    public int innerWakeLockHashCode() {
        return this.wakeLock.hashCode();
    }
}
