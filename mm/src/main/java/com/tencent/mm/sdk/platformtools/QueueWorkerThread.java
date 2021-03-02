package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class QueueWorkerThread {
    private static final long DEF_WAIT_OFFER = 1;
    private static final int MAX_WAIT_COUNT = 60;
    private static final String TAG = "QueueWorkerThread.QueueWorkerThread";
    private static final int WAIT_MILL_TIME = 2000;
    private Object lock;
    private String name;
    private MMHandler onPostExc;
    private boolean pause;
    private int priority;
    private LinkedBlockingQueue<ThreadObject> queueToReq;
    private int threadCount;
    private Vector<WorkerThread> vectorThread;

    public interface ThreadObject {
        boolean doInBackground();

        boolean onPostExecute();
    }

    public QueueWorkerThread(int i2, String str) {
        this(i2, str, 1);
    }

    public QueueWorkerThread(int i2, String str, int i3) {
        this(i2, str, i3, Looper.myLooper());
        AppMethodBeat.i(157795);
        AppMethodBeat.o(157795);
    }

    public QueueWorkerThread(int i2, String str, int i3, Looper looper) {
        AppMethodBeat.i(157796);
        this.queueToReq = new LinkedBlockingQueue<>();
        this.pause = false;
        this.threadCount = 1;
        this.priority = 1;
        this.name = "";
        this.lock = new byte[0];
        this.vectorThread = new Vector<>();
        this.threadCount = i3;
        this.name = str;
        this.priority = i2;
        if (looper == null && Looper.getMainLooper() != null) {
            looper = Looper.getMainLooper();
            Log.i(TAG, "looper is null use MainLooper!");
        }
        this.onPostExc = new MMHandler(looper) {
            /* class com.tencent.mm.sdk.platformtools.QueueWorkerThread.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public void handleMessage(Message message) {
                AppMethodBeat.i(157792);
                if (!(message == null || message.obj == null)) {
                    ((ThreadObject) message.obj).onPostExecute();
                }
                AppMethodBeat.o(157792);
            }
        };
        AppMethodBeat.o(157796);
    }

    public int getQueueSize() {
        AppMethodBeat.i(230374);
        int size = this.queueToReq.size();
        AppMethodBeat.o(230374);
        return size;
    }

    public void clear() {
        AppMethodBeat.i(230375);
        this.queueToReq.clear();
        AppMethodBeat.o(230375);
    }

    public int add(ThreadObject threadObject) {
        AppMethodBeat.i(157797);
        if (threadObject == null) {
            Log.e(TAG, "add empty thread object");
            AppMethodBeat.o(157797);
            return -1;
        }
        try {
            if (!this.queueToReq.offer(threadObject, 1, TimeUnit.MILLISECONDS)) {
                Log.e(TAG, "add To Queue failed");
                AppMethodBeat.o(157797);
                return -2;
            }
            if (this.vectorThread.size() == 0 || (this.queueToReq.size() > 0 && this.threadCount > this.vectorThread.size())) {
                new WorkerThread().start();
            }
            AppMethodBeat.o(157797);
            return 0;
        } catch (Exception e2) {
            Log.e(TAG, "add To Queue failed :" + e2.getMessage());
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(157797);
            return -3;
        }
    }

    @Deprecated
    public boolean isDead() {
        AppMethodBeat.i(157798);
        if (this.vectorThread == null || this.vectorThread.size() == 0) {
            AppMethodBeat.o(157798);
            return true;
        }
        AppMethodBeat.o(157798);
        return false;
    }

    public void pause(boolean z) {
        AppMethodBeat.i(157799);
        synchronized (this.lock) {
            try {
                this.pause = z;
                if (!z) {
                    synchronized (this.lock) {
                        try {
                            this.lock.notifyAll();
                        } catch (Throwable th) {
                            AppMethodBeat.o(157799);
                            throw th;
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(157799);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final class WorkerThread extends Thread {
        private int waitTimes;

        private WorkerThread() {
            super(QueueWorkerThread.this.name);
            AppMethodBeat.i(157793);
            this.waitTimes = 60;
            setPriority(QueueWorkerThread.this.priority);
            QueueWorkerThread.this.vectorThread.add(this);
            AppMethodBeat.o(157793);
        }

        public final void run() {
            ThreadObject threadObject;
            AppMethodBeat.i(157794);
            while (this.waitTimes > 0) {
                synchronized (QueueWorkerThread.this.lock) {
                    try {
                        if (QueueWorkerThread.this.pause) {
                            QueueWorkerThread.this.lock.wait();
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace(QueueWorkerThread.TAG, e2, "", new Object[0]);
                    }
                    try {
                    } catch (Throwable th) {
                        AppMethodBeat.o(157794);
                        throw th;
                    }
                }
                try {
                    threadObject = (ThreadObject) QueueWorkerThread.this.queueToReq.poll(2000, TimeUnit.MILLISECONDS);
                } catch (Exception e3) {
                    Log.printErrStackTrace(QueueWorkerThread.TAG, e3, "", new Object[0]);
                    threadObject = null;
                }
                if (threadObject == null) {
                    this.waitTimes--;
                } else {
                    this.waitTimes = 60;
                    if (threadObject.doInBackground()) {
                        QueueWorkerThread.this.onPostExc.sendMessage(QueueWorkerThread.this.onPostExc.obtainMessage(0, threadObject));
                    }
                }
            }
            QueueWorkerThread.this.vectorThread.remove(this);
            Log.d(QueueWorkerThread.TAG, "dktest Finish queueToReqSize:" + QueueWorkerThread.this.queueToReq.size() + " ThreadSize:" + QueueWorkerThread.this.vectorThread.size());
            AppMethodBeat.o(157794);
        }
    }
}
