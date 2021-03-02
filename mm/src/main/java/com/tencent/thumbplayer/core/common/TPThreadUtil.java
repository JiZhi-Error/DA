package com.tencent.thumbplayer.core.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class TPThreadUtil {
    public static ExecutorService THREAD_POOL_EXECUTOR = Executors.newCachedThreadPool();
    private static volatile EventHandler mMainThreadHandler = null;
    private static volatile ScheduledExecutorService mScheduler = null;

    static {
        AppMethodBeat.i(189846);
        AppMethodBeat.o(189846);
    }

    public static ScheduledExecutorService getScheduledExecutorServiceInstance() {
        AppMethodBeat.i(189839);
        if (mScheduler == null) {
            synchronized (TPThreadUtil.class) {
                try {
                    if (mScheduler == null) {
                        mScheduler = Executors.newScheduledThreadPool(4);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(189839);
                    throw th;
                }
            }
        }
        ScheduledExecutorService scheduledExecutorService = mScheduler;
        AppMethodBeat.o(189839);
        return scheduledExecutorService;
    }

    private static void getMainThreadHandler() {
        AppMethodBeat.i(189840);
        if (mMainThreadHandler == null) {
            synchronized (TPThreadUtil.class) {
                try {
                    if (mMainThreadHandler == null) {
                        Looper mainLooper = Looper.getMainLooper();
                        if (mainLooper != null) {
                            mMainThreadHandler = new EventHandler(mainLooper);
                        } else {
                            mMainThreadHandler = null;
                            IllegalStateException illegalStateException = new IllegalStateException("cannot get thread looper");
                            AppMethodBeat.o(189840);
                            throw illegalStateException;
                        }
                    }
                } finally {
                    AppMethodBeat.o(189840);
                }
            }
            return;
        }
        AppMethodBeat.o(189840);
    }

    public static void postRunnableOnMainThreadFront(Runnable runnable) {
        AppMethodBeat.i(189841);
        getMainThreadHandler();
        if (mMainThreadHandler != null) {
            mMainThreadHandler.postAtFrontOfQueue(runnable);
        }
        AppMethodBeat.o(189841);
    }

    public static void postRunnableOnMainThread(Runnable runnable) {
        AppMethodBeat.i(189842);
        getMainThreadHandler();
        if (mMainThreadHandler != null) {
            mMainThreadHandler.post(runnable);
        }
        AppMethodBeat.o(189842);
    }

    public static void postDelayRunnableOnMainThread(Runnable runnable, long j2) {
        AppMethodBeat.i(189843);
        getMainThreadHandler();
        if (mMainThreadHandler != null) {
            mMainThreadHandler.postDelayed(runnable, j2);
        }
        AppMethodBeat.o(189843);
    }

    public static void sendMessage(Handler handler, int i2, int i3, int i4, Object obj) {
        AppMethodBeat.i(189844);
        if (handler != null) {
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.arg1 = i3;
            obtain.arg2 = i4;
            obtain.obj = obj;
            handler.sendMessage(obtain);
        }
        AppMethodBeat.o(189844);
    }

    public static void sendMessageDelay(Handler handler, int i2, int i3, int i4, Object obj, long j2) {
        AppMethodBeat.i(189845);
        if (handler != null) {
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.arg1 = i3;
            obtain.arg2 = i4;
            obtain.obj = obj;
            handler.sendMessageDelayed(obtain, j2);
        }
        AppMethodBeat.o(189845);
    }

    /* access modifiers changed from: package-private */
    public static class EventHandler extends Handler {
        EventHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
        }
    }
}
