package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.thread.DeprecatedThreadFactory;
import junit.framework.Assert;

@Deprecated
public class MMHandlerThread {
    private static final String TAG = "MicroMsg.MMHandlerThread";
    private static final int WORKER_THREAD_HIGH_PRIROITY = -8;
    private static final int WORKER_THREAD_LOWEST_PRIROITY = 19;
    private static final int WORKER_THREAD_LOW_PRIROITY = 0;
    private static MMHandler mainHandler = null;
    private HandlerThread thread;
    private String threadName;
    private MMHandler workerHandler;

    public interface IWaitWorkThread {
        boolean doInBackground();

        boolean onPostExecute();
    }

    public interface ResetCallback {
        void callback();
    }

    static /* synthetic */ void access$100(MMHandlerThread mMHandlerThread, String str) {
        AppMethodBeat.i(157698);
        mMHandlerThread.init(str);
        AppMethodBeat.o(157698);
    }

    static /* synthetic */ void access$200(Runnable runnable) {
        AppMethodBeat.i(157699);
        postToMainThreadAtFrontOfQueue(runnable);
        AppMethodBeat.o(157699);
    }

    private void init(String str) {
        AppMethodBeat.i(157675);
        this.workerHandler = null;
        if (Util.isNullOrNil(str)) {
            str = "MMHandlerThread";
        }
        this.threadName = str;
        this.thread = DeprecatedThreadFactory.createHandlerThread(this.threadName);
        AppMethodBeat.o(157675);
    }

    public static void setCurrentPriority(int i2) {
        AppMethodBeat.i(157676);
        try {
            Process.setThreadPriority(i2);
            Log.i(TAG, "setCurrentPriority to %d ok", Integer.valueOf(i2));
            AppMethodBeat.o(157676);
        } catch (Exception e2) {
            Log.i(TAG, "setCurrentPriority to %d fail, %s", Integer.valueOf(i2), e2.getMessage());
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(157676);
        }
    }

    public void setLowestPriority() {
        AppMethodBeat.i(157677);
        if (this.thread == null || !this.thread.isAlive()) {
            Log.e(TAG, "setLowestPriority failed thread is dead");
            AppMethodBeat.o(157677);
            return;
        }
        int threadId = this.thread.getThreadId();
        try {
            if (19 == Process.getThreadPriority(threadId)) {
                Log.w(TAG, "setLowestPriority No Need.");
                AppMethodBeat.o(157677);
                return;
            }
            Process.setThreadPriority(threadId, 19);
            Log.i(TAG, "thread:%d setLowestPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
            AppMethodBeat.o(157677);
        } catch (Exception e2) {
            Log.w(TAG, "thread:%d setLowestPriority failed", Integer.valueOf(threadId));
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(157677);
        }
    }

    public int getProcessTid() {
        AppMethodBeat.i(157678);
        if (this.thread == null) {
            AppMethodBeat.o(157678);
            return -1;
        }
        int threadId = this.thread.getThreadId();
        AppMethodBeat.o(157678);
        return threadId;
    }

    public void setHighPriority() {
        AppMethodBeat.i(157679);
        if (this.thread == null || !this.thread.isAlive()) {
            Log.e(TAG, "setHighPriority failed thread is dead");
            AppMethodBeat.o(157679);
            return;
        }
        int threadId = this.thread.getThreadId();
        try {
            if (-8 == Process.getThreadPriority(threadId)) {
                Log.w(TAG, "setHighPriority No Need.");
                AppMethodBeat.o(157679);
                return;
            }
            Process.setThreadPriority(threadId, -8);
            Log.i(TAG, "thread:%d setHighPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
            AppMethodBeat.o(157679);
        } catch (Exception e2) {
            Log.w(TAG, "thread:%d setHighPriority failed", Integer.valueOf(threadId));
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(157679);
        }
    }

    public boolean inHighPriority() {
        AppMethodBeat.i(230341);
        if (this.thread == null || !this.thread.isAlive()) {
            Log.e(TAG, "check inHighPriority failed thread is dead");
            AppMethodBeat.o(230341);
            return false;
        }
        int threadId = this.thread.getThreadId();
        try {
            if (-8 == Process.getThreadPriority(threadId)) {
                AppMethodBeat.o(230341);
                return true;
            }
        } catch (Exception e2) {
            Log.w(TAG, "thread:%d  check inHighPriority failed", Integer.valueOf(threadId));
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        AppMethodBeat.o(230341);
        return false;
    }

    public void setLowPriority() {
        AppMethodBeat.i(157680);
        if (this.thread == null || !this.thread.isAlive()) {
            Log.e(TAG, "setLowPriority failed thread is dead");
            AppMethodBeat.o(157680);
            return;
        }
        int threadId = this.thread.getThreadId();
        try {
            if (Process.getThreadPriority(threadId) == 0) {
                Log.w(TAG, "setLowPriority No Need.");
                AppMethodBeat.o(157680);
                return;
            }
            Process.setThreadPriority(threadId, 0);
            Log.i(TAG, "thread:%d setLowPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
            AppMethodBeat.o(157680);
        } catch (Exception e2) {
            Log.w(TAG, "thread:%d setLowPriority failed", Integer.valueOf(threadId));
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(157680);
        }
    }

    @Deprecated
    public MMHandlerThread(HandlerThread handlerThread) {
        AppMethodBeat.i(182963);
        this.thread = null;
        this.workerHandler = null;
        this.threadName = null;
        this.workerHandler = null;
        this.thread = handlerThread;
        this.threadName = handlerThread.getName();
        AppMethodBeat.o(182963);
    }

    public Looper getLooper() {
        AppMethodBeat.i(186050);
        Looper looper = this.thread.getLooper();
        AppMethodBeat.o(186050);
        return looper;
    }

    public MMHandler getWorkerHandler() {
        AppMethodBeat.i(157684);
        if (this.workerHandler == null) {
            this.workerHandler = new MMHandler(this.thread.getLooper());
        }
        MMHandler mMHandler = this.workerHandler;
        AppMethodBeat.o(157684);
        return mMHandler;
    }

    public void interrupt() {
        AppMethodBeat.i(230342);
        this.thread.interrupt();
        AppMethodBeat.o(230342);
    }

    public int reset(final IWaitWorkThread iWaitWorkThread) {
        AppMethodBeat.i(230343);
        Log.i(TAG, "reset stack:%s", Util.getStack());
        final String str = this.threadName;
        int postAtFrontOfWorker = postAtFrontOfWorker(new IWaitWorkThread() {
            /* class com.tencent.mm.sdk.platformtools.MMHandlerThread.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public boolean onPostExecute() {
                AppMethodBeat.i(230339);
                if (iWaitWorkThread != null) {
                    boolean onPostExecute = iWaitWorkThread.onPostExecute();
                    AppMethodBeat.o(230339);
                    return onPostExecute;
                }
                AppMethodBeat.o(230339);
                return true;
            }

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public boolean doInBackground() {
                AppMethodBeat.i(230340);
                if (iWaitWorkThread != null) {
                    boolean doInBackground = iWaitWorkThread.doInBackground();
                    AppMethodBeat.o(230340);
                    return doInBackground;
                }
                MMHandlerThread.this.thread.quit();
                MMHandlerThread.access$100(MMHandlerThread.this, str);
                AppMethodBeat.o(230340);
                return true;
            }
        });
        AppMethodBeat.o(230343);
        return postAtFrontOfWorker;
    }

    public int syncReset(final ResetCallback resetCallback) {
        int postAtFrontOfWorker;
        AppMethodBeat.i(157685);
        Log.i(TAG, "syncReset tid[%d] stack:%s", Long.valueOf(Thread.currentThread().getId()), Util.getStack());
        Assert.assertTrue("syncReset should in mainThread", isMainThread());
        long id = this.thread.getId();
        final byte[] bArr = new byte[0];
        final String str = this.threadName;
        AnonymousClass2 r4 = new IWaitWorkThread() {
            /* class com.tencent.mm.sdk.platformtools.MMHandlerThread.AnonymousClass2 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public boolean onPostExecute() {
                AppMethodBeat.i(157670);
                Log.i(MMHandlerThread.TAG, "syncReset onPostExecute");
                AppMethodBeat.o(157670);
                return true;
            }

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public boolean doInBackground() {
                AppMethodBeat.i(157671);
                Log.i(MMHandlerThread.TAG, "syncReset doInBackground tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                if (resetCallback != null) {
                    resetCallback.callback();
                }
                Log.i(MMHandlerThread.TAG, "syncReset doInBackground callback done tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                MMHandlerThread.this.thread.quit();
                Log.i(MMHandlerThread.TAG, "syncReset init start old tid[%d]", Long.valueOf(MMHandlerThread.this.thread.getId()));
                MMHandlerThread.access$100(MMHandlerThread.this, str);
                Log.i(MMHandlerThread.TAG, "syncReset init done new tid[%d]", Long.valueOf(MMHandlerThread.this.thread.getId()));
                synchronized (bArr) {
                    try {
                        Log.i(MMHandlerThread.TAG, "syncReset notify tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                        bArr.notify();
                    } finally {
                        AppMethodBeat.o(157671);
                    }
                }
                return true;
            }
        };
        synchronized (bArr) {
            try {
                postAtFrontOfWorker = postAtFrontOfWorker(r4);
                long id2 = this.thread.getId();
                Log.i(TAG, "syncReset postAtFrontOfWorker ret[%d], oldTid[%d], curTid[%d]", Integer.valueOf(postAtFrontOfWorker), Long.valueOf(id), Long.valueOf(id2));
                if (postAtFrontOfWorker == 0 && id == id2) {
                    try {
                        bArr.wait();
                    } catch (Exception e2) {
                        Log.d(TAG, "syncReset lock wait end with exception[%s]", e2.getMessage());
                    }
                }
            } finally {
                AppMethodBeat.o(157685);
            }
        }
        return postAtFrontOfWorker;
    }

    public boolean quit() {
        AppMethodBeat.i(230344);
        boolean quit = this.thread.quit();
        AppMethodBeat.o(230344);
        return quit;
    }

    public boolean quitSafely() {
        AppMethodBeat.i(177914);
        boolean quitSafely = this.thread.quitSafely();
        AppMethodBeat.o(177914);
        return quitSafely;
    }

    public int postToWorker(Runnable runnable) {
        AppMethodBeat.i(157688);
        if (runnable == null) {
            AppMethodBeat.o(157688);
            return -1;
        }
        getWorkerHandler().post(runnable);
        AppMethodBeat.o(157688);
        return 0;
    }

    public int postAtFrontOfQueueToWorker(Runnable runnable) {
        AppMethodBeat.i(157689);
        if (runnable == null) {
            AppMethodBeat.o(157689);
            return -1;
        }
        getWorkerHandler().postAtFrontOfQueue(runnable);
        AppMethodBeat.o(157689);
        return 0;
    }

    public int postToWorkerDelayed(Runnable runnable, long j2) {
        AppMethodBeat.i(157690);
        if (runnable == null) {
            AppMethodBeat.o(157690);
            return -1;
        }
        getWorkerHandler().postDelayed(runnable, j2);
        AppMethodBeat.o(157690);
        return 0;
    }

    public int postAtFrontOfWorker(final IWaitWorkThread iWaitWorkThread) {
        AppMethodBeat.i(157691);
        if (iWaitWorkThread == null) {
            AppMethodBeat.o(157691);
            return -1;
        } else if (new MMHandler(getLooper()).postAtFrontOfQueue(new Runnable() {
            /* class com.tencent.mm.sdk.platformtools.MMHandlerThread.AnonymousClass3 */

            public void run() {
                AppMethodBeat.i(157673);
                iWaitWorkThread.doInBackground();
                MMHandlerThread.access$200(new Runnable() {
                    /* class com.tencent.mm.sdk.platformtools.MMHandlerThread.AnonymousClass3.AnonymousClass1 */

                    public void run() {
                        AppMethodBeat.i(157672);
                        iWaitWorkThread.onPostExecute();
                        AppMethodBeat.o(157672);
                    }
                });
                AppMethodBeat.o(157673);
            }

            public String toString() {
                AppMethodBeat.i(157674);
                String str = super.toString() + "|" + iWaitWorkThread.toString();
                AppMethodBeat.o(157674);
                return str;
            }
        })) {
            AppMethodBeat.o(157691);
            return 0;
        } else {
            AppMethodBeat.o(157691);
            return -2;
        }
    }

    public static boolean isMainThread() {
        AppMethodBeat.i(157692);
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            AppMethodBeat.o(157692);
            return true;
        }
        AppMethodBeat.o(157692);
        return false;
    }

    public boolean isThisHandlerThread() {
        AppMethodBeat.i(157693);
        if (Thread.currentThread().getId() == this.thread.getId()) {
            AppMethodBeat.o(157693);
            return true;
        }
        AppMethodBeat.o(157693);
        return false;
    }

    private static MMHandler getMainHandler() {
        AppMethodBeat.i(157694);
        if (mainHandler == null) {
            mainHandler = new MMHandler(Looper.getMainLooper());
        }
        MMHandler mMHandler = mainHandler;
        AppMethodBeat.o(157694);
        return mMHandler;
    }

    public static void postToMainThread(Runnable runnable) {
        AppMethodBeat.i(157695);
        if (runnable == null) {
            AppMethodBeat.o(157695);
            return;
        }
        getMainHandler().post(runnable);
        AppMethodBeat.o(157695);
    }

    public static void postToMainThreadDelayed(Runnable runnable, long j2) {
        AppMethodBeat.i(157696);
        if (runnable == null) {
            AppMethodBeat.o(157696);
            return;
        }
        getMainHandler().postDelayed(runnable, j2);
        AppMethodBeat.o(157696);
    }

    public static void removeRunnable(Runnable runnable) {
        AppMethodBeat.i(157697);
        if (runnable == null) {
            AppMethodBeat.o(157697);
            return;
        }
        getMainHandler().removeCallbacks(runnable);
        AppMethodBeat.o(157697);
    }

    private static void postToMainThreadAtFrontOfQueue(Runnable runnable) {
        AppMethodBeat.i(230345);
        if (runnable == null) {
            AppMethodBeat.o(230345);
            return;
        }
        getMainHandler().postAtFrontOfQueue(runnable);
        AppMethodBeat.o(230345);
    }

    public String dump(boolean z, boolean z2) {
        AppMethodBeat.i(230346);
        Message runningMessage = getWorkerHandler().getRunningMessage();
        if (runningMessage == null) {
            AppMethodBeat.o(230346);
            return null;
        }
        String message = runningMessage.toString();
        AppMethodBeat.o(230346);
        return message;
    }

    public Runnable findTaskByRunTime(boolean z, long j2) {
        AppMethodBeat.i(230347);
        Message runningMessage = getWorkerHandler().getRunningMessage();
        if (runningMessage == null) {
            AppMethodBeat.o(230347);
            return null;
        }
        Runnable callback = runningMessage.getCallback();
        AppMethodBeat.o(230347);
        return callback;
    }
}
