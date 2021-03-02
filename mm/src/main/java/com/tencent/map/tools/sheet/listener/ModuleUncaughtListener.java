package com.tencent.map.tools.sheet.listener;

import java.lang.Thread;

public abstract class ModuleUncaughtListener {
    private Thread.UncaughtExceptionHandler mUncaughtExceptionHandler;

    public abstract boolean onModuleSDKCrashed(Throwable th);

    public ModuleUncaughtListener(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.mUncaughtExceptionHandler = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (this.mUncaughtExceptionHandler != null) {
            this.mUncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
