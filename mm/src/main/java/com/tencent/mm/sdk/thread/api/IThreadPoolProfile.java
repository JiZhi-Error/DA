package com.tencent.mm.sdk.thread.api;

import com.tencent.mm.sdk.thread.ThreadTaskInfo;
import java.util.List;

public interface IThreadPoolProfile {
    long getTaskTimeout();

    void onBusy(int i2, List<ThreadTaskInfo> list, List<ThreadTaskInfo> list2);

    void onException(Object obj, Throwable th);

    void onLog(Runnable runnable, String str, long j2, long j3);

    void onRelax(long j2);

    void onTaskAdded(ThreadTaskInfo threadTaskInfo);

    void onTaskAfterExecuted(ThreadTaskInfo threadTaskInfo);

    void onTaskBeforeExecute(ThreadTaskInfo threadTaskInfo);

    void onTaskRemove(ThreadTaskInfo threadTaskInfo);

    void onTaskTimeout(ThreadTaskInfo threadTaskInfo);
}
