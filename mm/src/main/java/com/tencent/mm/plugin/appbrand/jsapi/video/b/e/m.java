package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class m {
    public static Future<?> a(Runnable runnable, String str) {
        AppMethodBeat.i(234900);
        b bVar = new b("job " + str + " ");
        Future<?> submit = bVar.submit(runnable);
        bVar.shutdown();
        AppMethodBeat.o(234900);
        return submit;
    }

    public static synchronized void G(ArrayList<Runnable> arrayList) {
        synchronized (m.class) {
            AppMethodBeat.i(234901);
            c cVar = new c(2);
            Iterator<Runnable> it = arrayList.iterator();
            Long l = 1L;
            while (it.hasNext()) {
                Long valueOf = Long.valueOf(l.longValue() + 1);
                cVar.k(it.next(), l.longValue());
                l = valueOf;
            }
            cVar.shutdown();
            AppMethodBeat.o(234901);
        }
    }

    public static Object a(Callable<?> callable, int i2, String str, String str2) {
        AppMethodBeat.i(234902);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future submit = newSingleThreadExecutor.submit(callable);
        newSingleThreadExecutor.shutdown();
        String str3 = "job " + str + " ";
        try {
            Object obj = submit.get((long) i2, TimeUnit.MILLISECONDS);
            AppMethodBeat.o(234902);
            return obj;
        } catch (TimeoutException e2) {
            h.log(4, str2, str3 + AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED);
            submit.cancel(true);
            AppMethodBeat.o(234902);
            return null;
        }
    }

    static class c extends ThreadPoolExecutor {
        private c(int i2, int i3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
            super(i2, i3, 0, timeUnit, blockingQueue);
        }

        public c(int i2) {
            this(2, 2, TimeUnit.MILLISECONDS, new PriorityBlockingQueue());
            AppMethodBeat.i(234898);
            AppMethodBeat.o(234898);
        }

        public final void k(Runnable runnable, long j2) {
            AppMethodBeat.i(234899);
            super.execute(new a(runnable, j2));
            AppMethodBeat.o(234899);
        }

        /* access modifiers changed from: protected */
        @Override // java.util.concurrent.AbstractExecutorService
        public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return (RunnableFuture) runnable;
        }

        /* access modifiers changed from: protected */
        @Override // java.util.concurrent.AbstractExecutorService
        public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
            return (RunnableFuture) callable;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a<T> extends FutureTask<T> implements Comparable<a<T>> {
        volatile long mAc = 0;

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            AppMethodBeat.i(234893);
            int compareTo = Long.valueOf(this.mAc).compareTo(Long.valueOf(((a) obj).mAc));
            AppMethodBeat.o(234893);
            return compareTo;
        }

        public a(Runnable runnable, long j2) {
            super(runnable, null);
            this.mAc = j2;
        }
    }

    public static class b extends ThreadPoolExecutor {
        String mAd = "";

        public b(String str) {
            super(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            AppMethodBeat.i(234894);
            this.mAd = str;
            AppMethodBeat.o(234894);
        }

        public b(TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
            super(10, 10, 0, timeUnit, blockingQueue);
        }

        /* access modifiers changed from: protected */
        @Override // java.util.concurrent.AbstractExecutorService
        public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            AppMethodBeat.i(234895);
            RunnableFuture<T> newTaskFor = super.newTaskFor(runnable, t);
            AppMethodBeat.o(234895);
            return newTaskFor;
        }

        /* access modifiers changed from: protected */
        public final void beforeExecute(Thread thread, Runnable runnable) {
            AppMethodBeat.i(234896);
            super.beforeExecute(thread, runnable);
            h.log(4, "ThreadUtils", "beforeExecute: thread=" + thread.toString() + " thread.state=" + thread.getState() + " runnable=" + runnable.toString());
            AppMethodBeat.o(234896);
        }

        /* access modifiers changed from: protected */
        public final void afterExecute(Runnable runnable, Throwable th) {
            AppMethodBeat.i(234897);
            super.afterExecute(runnable, th);
            if (th == null && (runnable instanceof Future)) {
                try {
                    Future future = (Future) runnable;
                    if (future.isDone() && !future.isCancelled()) {
                        h.log(3, "ThreadUtils", "before future.get()");
                        future.get();
                        h.log(3, "ThreadUtils", "after future.get()");
                    }
                } catch (CancellationException e2) {
                    h.log(5, "ThreadUtils", "CancellationException");
                    th = e2;
                } catch (ExecutionException e3) {
                    h.log(5, "ThreadUtils", "ExecutionException");
                    th = e3.getCause();
                } catch (InterruptedException e4) {
                    h.log(5, "ThreadUtils", "InterruptedException");
                    Thread.currentThread().interrupt();
                }
            }
            if (th != null) {
                h.log(6, "ThreadUtils", this.mAd + " error occurred during processing request:" + h.i(th));
            }
            AppMethodBeat.o(234897);
        }
    }
}
