package com.tencent.qqmusic.mediaplayer;

import java.lang.Thread;

public interface QMThreadExecutor {
    void execute(Runnable runnable, Thread.UncaughtExceptionHandler uncaughtExceptionHandler);
}
