package com.tencent.recovery.crash;

import com.tencent.recovery.Recovery;
import java.lang.Thread;

public class RecoveryExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread thread, Throwable th) {
        Recovery.crash();
    }
}
