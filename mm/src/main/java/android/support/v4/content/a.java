package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.content.e;
import android.support.v4.e.p;
import android.support.v4.os.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class a<D> extends c<D> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile a<D>.RunnableC0020a mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile a<D>.RunnableC0020a mTask;
    long mUpdateThrottle;

    public abstract D loadInBackground();

    /* access modifiers changed from: package-private */
    /* renamed from: android.support.v4.content.a$a  reason: collision with other inner class name */
    public final class RunnableC0020a extends e<Void, Void, D> implements Runnable {
        final CountDownLatch IU = new CountDownLatch(1);
        boolean IV;

        RunnableC0020a() {
        }

        /* access modifiers changed from: private */
        /* renamed from: ev */
        public D ew() {
            try {
                return (D) a.this.onLoadInBackground();
            } catch (b e2) {
                if (this.Jq.get()) {
                    return null;
                }
                throw e2;
            }
        }

        /* access modifiers changed from: protected */
        @Override // android.support.v4.content.e
        public final void onPostExecute(D d2) {
            try {
                a.this.dispatchOnLoadComplete(this, d2);
            } finally {
                this.IU.countDown();
            }
        }

        /* access modifiers changed from: protected */
        @Override // android.support.v4.content.e
        public final void onCancelled(D d2) {
            try {
                a.this.dispatchOnCancelled(this, d2);
            } finally {
                this.IU.countDown();
            }
        }

        public final void run() {
            this.IV = false;
            a.this.executePendingTask();
        }
    }

    public a(Context context) {
        this(context, e.THREAD_POOL_EXECUTOR);
    }

    private a(Context context, Executor executor) {
        super(context);
        this.mLastLoadCompleteTime = -10000;
        this.mExecutor = executor;
    }

    public void setUpdateThrottle(long j2) {
        this.mUpdateThrottle = j2;
        if (j2 != 0) {
            this.mHandler = new Handler();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.content.c
    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new RunnableC0020a();
        executePendingTask();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.content.c
    public boolean onCancelLoad() {
        boolean z = false;
        if (this.mTask != null) {
            if (!this.mStarted) {
                this.mContentChanged = true;
            }
            if (this.mCancellingTask != null) {
                if (this.mTask.IV) {
                    this.mTask.IV = false;
                    this.mHandler.removeCallbacks(this.mTask);
                }
                this.mTask = null;
            } else if (this.mTask.IV) {
                this.mTask.IV = false;
                this.mHandler.removeCallbacks(this.mTask);
                this.mTask = null;
            } else {
                a<D>.RunnableC0020a aVar = this.mTask;
                aVar.Jq.set(true);
                z = aVar.Jo.cancel(false);
                if (z) {
                    this.mCancellingTask = this.mTask;
                    cancelLoadInBackground();
                }
                this.mTask = null;
            }
        }
        return z;
    }

    public void onCanceled(D d2) {
    }

    /* access modifiers changed from: package-private */
    public void executePendingTask() {
        if (this.mCancellingTask == null && this.mTask != null) {
            if (this.mTask.IV) {
                this.mTask.IV = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if (this.mUpdateThrottle <= 0 || SystemClock.uptimeMillis() >= this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                a<D>.RunnableC0020a aVar = this.mTask;
                Executor executor = this.mExecutor;
                if (aVar.Jp != e.c.PENDING) {
                    switch (aVar.Jp) {
                        case RUNNING:
                            throw new IllegalStateException("Cannot execute task: the task is already running.");
                        case FINISHED:
                            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                        default:
                            throw new IllegalStateException("We should never reach this state");
                    }
                } else {
                    aVar.Jp = e.c.RUNNING;
                    aVar.Jn.JB = null;
                    executor.execute(aVar.Jo);
                }
            } else {
                this.mTask.IV = true;
                this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnCancelled(a<D>.RunnableC0020a aVar, D d2) {
        onCanceled(d2);
        if (this.mCancellingTask == aVar) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnLoadComplete(a<D>.RunnableC0020a aVar, D d2) {
        if (this.mTask != aVar) {
            dispatchOnCancelled(aVar, d2);
        } else if (isAbandoned()) {
            onCanceled(d2);
        } else {
            commitContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            deliverResult(d2);
        }
    }

    /* access modifiers changed from: protected */
    public D onLoadInBackground() {
        return loadInBackground();
    }

    public void cancelLoadInBackground() {
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.mCancellingTask != null;
    }

    public void waitForLoader() {
        a<D>.RunnableC0020a aVar = this.mTask;
        if (aVar != null) {
            try {
                aVar.IU.await();
            } catch (InterruptedException e2) {
            }
        }
    }

    @Override // android.support.v4.content.c
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.IV);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.IV);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            p.b(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            p.a(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
