package com.tencent.recovery.crash;

import java.lang.Thread;

public class DefaultExceptionHandler extends RecoveryExceptionHandler {
    private Thread.UncaughtExceptionHandler origin;

    public DefaultExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.origin = uncaughtExceptionHandler;
    }

    @Override // com.tencent.recovery.crash.RecoveryExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        super.uncaughtException(thread, th);
        if (this.origin != null) {
            this.origin.uncaughtException(thread, th);
        }
    }
}
