package android.support.v4.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class e<Params, Progress, Result> {
    private static final ThreadFactory Jj = new ThreadFactory() {
        /* class android.support.v4.content.e.AnonymousClass1 */
        private final AtomicInteger Js = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.Js.getAndIncrement());
        }
    };
    private static final BlockingQueue<Runnable> Jk = new LinkedBlockingQueue(10);
    private static b Jl;
    private static volatile Executor Jm;
    public static final Executor THREAD_POOL_EXECUTOR;
    final d<Params, Result> Jn = new d<Params, Result>() {
        /* class android.support.v4.content.e.AnonymousClass2 */

        @Override // java.util.concurrent.Callable
        public final Result call() {
            e.this.Jr.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = (Result) e.this.ew();
                Binder.flushPendingCommands();
                e.this.o(result);
                return result;
            } catch (Throwable th) {
                e.this.o(result);
                throw th;
            }
        }
    };
    final FutureTask<Result> Jo = new FutureTask<Result>(this.Jn) {
        /* class android.support.v4.content.e.AnonymousClass3 */

        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: android.support.v4.content.e */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: protected */
        public final void done() {
            try {
                e.this.n(get());
            } catch (InterruptedException e2) {
            } catch (ExecutionException e3) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e3.getCause());
            } catch (CancellationException e4) {
                e.this.n(null);
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    };
    volatile c Jp = c.PENDING;
    final AtomicBoolean Jq = new AtomicBoolean();
    final AtomicBoolean Jr = new AtomicBoolean();

    public enum c {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* access modifiers changed from: protected */
    public abstract Result ew();

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, Jk, Jj);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
        Jm = threadPoolExecutor;
    }

    private static Handler getHandler() {
        b bVar;
        synchronized (e.class) {
            if (Jl == null) {
                Jl = new b();
            }
            bVar = Jl;
        }
        return bVar;
    }

    e() {
    }

    /* access modifiers changed from: package-private */
    public final void n(Result result) {
        if (!this.Jr.get()) {
            o(result);
        }
    }

    /* access modifiers changed from: package-private */
    public final Result o(Result result) {
        getHandler().obtainMessage(1, new a(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Result result) {
    }

    /* access modifiers changed from: protected */
    public void onCancelled(Result result) {
    }

    /* access modifiers changed from: package-private */
    public static class b extends Handler {
        b() {
            super(Looper.getMainLooper());
        }

        public final void handleMessage(Message message) {
            a aVar = (a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.Jv.p(aVar.Jw[0]);
                    return;
                default:
                    return;
            }
        }
    }

    static abstract class d<Params, Result> implements Callable<Result> {
        Params[] JB;

        d() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class a<Data> {
        final e Jv;
        final Data[] Jw;

        a(e eVar, Data... dataArr) {
            this.Jv = eVar;
            this.Jw = dataArr;
        }
    }

    /* access modifiers changed from: package-private */
    public final void p(Result result) {
        if (this.Jq.get()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.Jp = c.FINISHED;
    }
}
