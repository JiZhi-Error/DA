package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* access modifiers changed from: package-private */
@Deprecated
public class QueuedWork {
    private static final ConcurrentLinkedQueue<Runnable> mPendingWorks = new ConcurrentLinkedQueue<>();
    private static ExecutorService mSingleThreadExecutor = null;

    QueuedWork() {
    }

    static {
        AppMethodBeat.i(156351);
        AppMethodBeat.o(156351);
    }

    public static ExecutorService singleThreadExecutor() {
        ExecutorService executorService;
        AppMethodBeat.i(156348);
        synchronized (QueuedWork.class) {
            try {
                if (mSingleThreadExecutor == null) {
                    mSingleThreadExecutor = Executors.newSingleThreadExecutor();
                }
                executorService = mSingleThreadExecutor;
            } finally {
                AppMethodBeat.o(156348);
            }
        }
        return executorService;
    }

    public static void add(Runnable runnable) {
        AppMethodBeat.i(156349);
        mPendingWorks.add(runnable);
        AppMethodBeat.o(156349);
    }

    public static void remove(Runnable runnable) {
        AppMethodBeat.i(156350);
        mPendingWorks.remove(runnable);
        AppMethodBeat.o(156350);
    }

    public static void waitToFinish() {
        AppMethodBeat.i(215434);
        while (true) {
            Runnable poll = mPendingWorks.poll();
            if (poll != null) {
                poll.run();
            } else {
                AppMethodBeat.o(215434);
                return;
            }
        }
    }

    public static boolean hasPendingWork() {
        AppMethodBeat.i(215435);
        if (!mPendingWorks.isEmpty()) {
            AppMethodBeat.o(215435);
            return true;
        }
        AppMethodBeat.o(215435);
        return false;
    }
}
