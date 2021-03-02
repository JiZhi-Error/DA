package com.tencent.mm.plugin.appbrand.m;

public interface q extends j {
    boolean LO();

    String LP();

    void a(Runnable runnable, boolean z);

    void cS(boolean z);

    boolean doInnerLoopTask();

    void post(Runnable runnable);

    void resumeLoopTasks();

    void setThreadPriority(int i2);
}
