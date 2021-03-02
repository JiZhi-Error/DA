package com.tencent.tmassistantsdk.downloadservice;

import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class DownloadThreadPool {
    public static final String TAG = "DownloadThreadPool";
    protected static DownloadThreadPool mDownloadThreadPool = null;
    final ArrayList<TaskThread> mDownloadThreadList = new ArrayList<>();
    final ArrayList<DownloadTask> mExecList = new ArrayList<>();
    protected final Comparator<DownloadTask> mPriorityQueueComparator = new Comparator<DownloadTask>() {
        /* class com.tencent.tmassistantsdk.downloadservice.DownloadThreadPool.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(DownloadTask downloadTask, DownloadTask downloadTask2) {
            AppMethodBeat.i(102004);
            int compare = compare(downloadTask, downloadTask2);
            AppMethodBeat.o(102004);
            return compare;
        }

        public int compare(DownloadTask downloadTask, DownloadTask downloadTask2) {
            AppMethodBeat.i(102003);
            if (downloadTask.getPriority() > downloadTask2.getPriority()) {
                AppMethodBeat.o(102003);
                return 1;
            } else if (downloadTask.getPriority() == downloadTask2.getPriority()) {
                AppMethodBeat.o(102003);
                return 0;
            } else {
                AppMethodBeat.o(102003);
                return -1;
            }
        }
    };
    final Object mTaskLock = new Object();
    final Object mThreadlock = new Object();
    final PriorityQueue<DownloadTask> mWaitingList = new PriorityQueue<>(16, this.mPriorityQueueComparator);

    public static DownloadThreadPool getInstance() {
        AppMethodBeat.i(102008);
        if (mDownloadThreadPool == null) {
            mDownloadThreadPool = new DownloadThreadPool();
        }
        DownloadThreadPool downloadThreadPool = mDownloadThreadPool;
        AppMethodBeat.o(102008);
        return downloadThreadPool;
    }

    private DownloadThreadPool() {
        AppMethodBeat.i(102009);
        int maxTaskNum = DownloadSetting.getInstance().getMaxTaskNum();
        for (int i2 = 0; i2 < maxTaskNum; i2++) {
            this.mDownloadThreadList.add(new TaskThread(i2));
        }
        AppMethodBeat.o(102009);
    }

    /* access modifiers changed from: package-private */
    public int addDownloadTask(DownloadTask downloadTask) {
        int taskId;
        AppMethodBeat.i(102010);
        synchronized (this.mTaskLock) {
            try {
                this.mWaitingList.add(downloadTask);
                synchronized (this.mThreadlock) {
                    try {
                        this.mThreadlock.notifyAll();
                    } catch (Throwable th) {
                        AppMethodBeat.o(102010);
                        throw th;
                    }
                }
                taskId = downloadTask.getTaskId();
            } finally {
                AppMethodBeat.o(102010);
            }
        }
        return taskId;
    }

    /* access modifiers changed from: package-private */
    public void cancelDownloadTask(final int i2) {
        AppMethodBeat.i(102011);
        new Thread(new Runnable() {
            /* class com.tencent.tmassistantsdk.downloadservice.DownloadThreadPool.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(102005);
                synchronized (DownloadThreadPool.this.mTaskLock) {
                    try {
                        Iterator<DownloadTask> it = DownloadThreadPool.this.mExecList.iterator();
                        while (it.hasNext()) {
                            DownloadTask next = it.next();
                            if (next.getTaskId() == i2) {
                                next.cancel();
                                DownloadThreadPool.this.mExecList.remove(next);
                                return;
                            }
                        }
                        Iterator<DownloadTask> it2 = DownloadThreadPool.this.mWaitingList.iterator();
                        while (it2.hasNext()) {
                            DownloadTask next2 = it2.next();
                            if (next2.getTaskId() == i2) {
                                next2.cancel();
                                DownloadThreadPool.this.mWaitingList.remove(next2);
                                AppMethodBeat.o(102005);
                                return;
                            }
                        }
                        AppMethodBeat.o(102005);
                    } finally {
                        AppMethodBeat.o(102005);
                    }
                }
            }
        }).start();
        AppMethodBeat.o(102011);
    }

    /* access modifiers changed from: package-private */
    public boolean hasWaitingTask() {
        boolean z;
        AppMethodBeat.i(102012);
        synchronized (this.mTaskLock) {
            try {
                z = this.mWaitingList.size() > 0;
            } finally {
                AppMethodBeat.o(102012);
            }
        }
        return z;
    }

    class TaskThread extends Thread {
        private int mIndex = 0;

        public TaskThread(int i2) {
            AppMethodBeat.i(102006);
            this.mIndex = i2;
            setName("download_thread_" + this.mIndex);
            start();
            AppMethodBeat.o(102006);
        }

        public void run() {
            AppMethodBeat.i(102007);
            TMLog.i(DownloadThreadPool.TAG, "Thread " + this.mIndex + " starts running...");
            while (true) {
                synchronized (DownloadThreadPool.this.mThreadlock) {
                    try {
                        TMLog.i(DownloadThreadPool.TAG, "Thread " + this.mIndex + " is waitting...");
                        DownloadThreadPool.this.mThreadlock.wait();
                        try {
                        } finally {
                            AppMethodBeat.o(102007);
                        }
                    } catch (InterruptedException e2) {
                        TMLog.i(DownloadThreadPool.TAG, "Thread " + this.mIndex + " is interrupted...");
                        Log.printErrStackTrace(DownloadThreadPool.TAG, e2, "", new Object[0]);
                        AppMethodBeat.o(102007);
                        return;
                    }
                }
                if (Thread.currentThread().isInterrupted()) {
                    TMLog.i(DownloadThreadPool.TAG, "Thread " + this.mIndex + " is interrupted...");
                    AppMethodBeat.o(102007);
                    return;
                }
                while (true) {
                    if (DownloadThreadPool.this.hasWaitingTask()) {
                        DownloadTask downloadTask = null;
                        synchronized (DownloadThreadPool.this.mTaskLock) {
                            try {
                                if (DownloadThreadPool.this.mWaitingList.size() > 0) {
                                    downloadTask = DownloadThreadPool.this.mWaitingList.remove();
                                    DownloadThreadPool.this.mExecList.add(downloadTask);
                                }
                            } finally {
                                AppMethodBeat.o(102007);
                            }
                        }
                        if (Thread.currentThread().isInterrupted()) {
                            TMLog.i(DownloadThreadPool.TAG, "Thread " + this.mIndex + " is interrupted...");
                            AppMethodBeat.o(102007);
                            return;
                        }
                        if (downloadTask != null) {
                            TMLog.i(DownloadThreadPool.TAG, "TaskThread::Run ThreadName: " + getName() + " url: " + downloadTask.getDownloadURI());
                            PowerManager.WakeLock wakeLock = DownloadHelper.getWakeLock();
                            downloadTask.exec(getName());
                            if (wakeLock != null) {
                                wakeLock.release();
                            }
                        }
                        synchronized (DownloadThreadPool.this.mTaskLock) {
                            if (downloadTask != null) {
                                try {
                                    DownloadThreadPool.this.mExecList.remove(downloadTask);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public DownloadTask getDownloadTask(String str) {
        AppMethodBeat.i(102013);
        synchronized (this.mTaskLock) {
            try {
                Iterator<DownloadTask> it = this.mExecList.iterator();
                while (it.hasNext()) {
                    DownloadTask next = it.next();
                    if (next.getDownloadURI().equals(str)) {
                        return next;
                    }
                }
                Iterator<DownloadTask> it2 = this.mWaitingList.iterator();
                while (it2.hasNext()) {
                    DownloadTask next2 = it2.next();
                    if (next2.getDownloadURI().equals(str)) {
                        AppMethodBeat.o(102013);
                        return next2;
                    }
                }
                AppMethodBeat.o(102013);
                return null;
            } finally {
                AppMethodBeat.o(102013);
            }
        }
    }
}
