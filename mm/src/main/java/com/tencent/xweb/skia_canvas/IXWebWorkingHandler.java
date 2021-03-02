package com.tencent.xweb.skia_canvas;

public interface IXWebWorkingHandler {
    boolean isRunOnWorkingThread();

    void post(Runnable runnable);
}
