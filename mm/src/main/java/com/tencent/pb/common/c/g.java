package com.tencent.pb.common.c;

import android.os.Handler;
import android.os.Looper;

public final class g {
    public static Handler sHandler = new Handler(Looper.getMainLooper());

    public static void runOnMainThread(Runnable runnable) {
        boolean z;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            runnable.run();
        } else {
            sHandler.post(runnable);
        }
    }
}
