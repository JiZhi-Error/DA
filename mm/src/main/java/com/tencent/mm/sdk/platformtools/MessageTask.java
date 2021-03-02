package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TimeUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MessageTask implements Runnable {
    private static final String CONSICE_FORMAT;
    private static final String TAG = "MicroMsg.MessageTask";
    private static final String VERBOSE_FORMAT = ("taskName = %s" + "|token = %s" + "|handler = %s" + "|threadName = %s" + "|threadId = %d" + "|priority = %d" + "|addTime = %d" + "|delayTime = %d" + "|usedTime = %d" + "|cpuTime = %d" + "|started = %b");
    long addTime;
    final MessageTaskCallback callback;
    long cpuTime;
    long delayTime;
    long endTime;
    final Handler handler;
    int priority;
    boolean started = false;
    public final Runnable task;
    final String taskName;
    final Thread thread;
    float threadCpuRate = -1.0f;
    long threadCpuTime;
    long threadId;
    String threadName;
    final Object token;
    long totalCpuTime;
    long usedTime;
    long waitTime;

    public interface MessageTaskCallback {
        void onLog(Message message, Runnable runnable, Thread thread, long j2, long j3, float f2);

        void onRunEnd(Runnable runnable, MessageTask messageTask);
    }

    MessageTask(Thread thread2, Handler handler2, Runnable runnable, Object obj, MessageTaskCallback messageTaskCallback) {
        int indexOf;
        AppMethodBeat.i(157724);
        this.thread = thread2;
        if (thread2 != null) {
            this.threadName = thread2.getName();
            this.threadId = thread2.getId();
            this.priority = thread2.getPriority();
        }
        this.handler = handler2;
        this.task = runnable;
        String name = runnable.getClass().getName();
        String obj2 = runnable.toString();
        if (!Util.isNullOrNil(obj2) && (indexOf = obj2.indexOf(124)) > 0) {
            name = name + "_" + obj2.substring(indexOf + 1);
        }
        this.taskName = name;
        this.token = obj;
        this.callback = messageTaskCallback;
        this.addTime = System.currentTimeMillis();
        AppMethodBeat.o(157724);
    }

    public void run() {
        AppMethodBeat.i(157725);
        String str = "/proc/self/task/" + Process.myTid() + "/stat";
        this.usedTime = System.currentTimeMillis();
        this.cpuTime = Debug.threadCpuTimeNanos();
        this.waitTime = (this.usedTime - this.addTime) - this.delayTime;
        this.threadCpuTime = getThreadCpuTime(str);
        this.totalCpuTime = getTotalCpuTime();
        this.started = true;
        this.task.run();
        this.threadCpuTime = getThreadCpuTime(str) - this.threadCpuTime;
        this.totalCpuTime = getTotalCpuTime() - this.totalCpuTime;
        this.endTime = System.currentTimeMillis();
        this.usedTime = this.endTime - this.usedTime;
        this.cpuTime = (Debug.threadCpuTimeNanos() - this.cpuTime) / TimeUtil.SECOND_TO_US;
        if (this.totalCpuTime != 0) {
            this.threadCpuRate = ((float) (100 * this.threadCpuTime)) / ((float) this.totalCpuTime);
        }
        if (this.callback != null) {
            this.callback.onRunEnd(this.task, this);
            this.callback.onLog(null, this, Thread.currentThread(), this.usedTime, this.cpuTime, this.threadCpuRate);
        }
        AppMethodBeat.o(157725);
    }

    static {
        AppMethodBeat.i(157728);
        StringBuilder sb = new StringBuilder();
        sb.append("taskName = %s");
        sb.append(" | addTime = %s");
        sb.append(" | endTime = %s");
        sb.append(" | usedTime = %d");
        sb.append(" | cpuTime = %d");
        sb.append(" | threadCpuTime = %d");
        sb.append(" | totalCpuTime = %d");
        sb.append(" | threadCpuRate = %.1f");
        CONSICE_FORMAT = sb.toString();
        AppMethodBeat.o(157728);
    }

    public String toString() {
        AppMethodBeat.i(157726);
        String str = this.taskName + ", " + this.task;
        AppMethodBeat.o(157726);
        return str;
    }

    public String dump(boolean z) {
        AppMethodBeat.i(157727);
        if (z) {
            String format = String.format(VERBOSE_FORMAT, this.taskName, this.token, this.handler, this.threadName, Long.valueOf(this.threadId), Integer.valueOf(this.priority), Long.valueOf(this.addTime), Long.valueOf(this.delayTime), Long.valueOf(this.usedTime), Long.valueOf(this.cpuTime), Boolean.valueOf(this.started));
            AppMethodBeat.o(157727);
            return format;
        }
        String format2 = String.format(CONSICE_FORMAT, this.taskName, new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.addTime)), new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.endTime)), Long.valueOf(this.usedTime), Long.valueOf(this.cpuTime), Long.valueOf(this.threadCpuTime), Long.valueOf(this.totalCpuTime), Float.valueOf(this.threadCpuRate));
        AppMethodBeat.o(157727);
        return format2;
    }

    private static long getTotalCpuTime() {
        return -1;
    }

    private static long getThreadCpuTime(String str) {
        return -1;
    }
}
