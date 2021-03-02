package com.bumptech.glide.load.b.c;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a implements ExecutorService {
    private static final long aJr = TimeUnit.SECONDS.toMillis(10);
    private static volatile int aJs;
    private final ExecutorService aJt;

    public interface b {
        public static final b aJA = new b() {
            /* class com.bumptech.glide.load.b.c.a.b.AnonymousClass3 */

            @Override // com.bumptech.glide.load.b.c.a.b
            public final void c(Throwable th) {
                AppMethodBeat.i(77174);
                RuntimeException runtimeException = new RuntimeException("Request threw uncaught throwable", th);
                AppMethodBeat.o(77174);
                throw runtimeException;
            }
        };
        public static final b aJB = aJz;
        public static final b aJy = new b() {
            /* class com.bumptech.glide.load.b.c.a.b.AnonymousClass1 */

            @Override // com.bumptech.glide.load.b.c.a.b
            public final void c(Throwable th) {
            }
        };
        public static final b aJz = new b() {
            /* class com.bumptech.glide.load.b.c.a.b.AnonymousClass2 */

            @Override // com.bumptech.glide.load.b.c.a.b
            public final void c(Throwable th) {
                AppMethodBeat.i(77173);
                Log.isLoggable("GlideExecutor", 6);
                AppMethodBeat.o(77173);
            }
        };

        void c(Throwable th);
    }

    static {
        AppMethodBeat.i(77194);
        AppMethodBeat.o(77194);
    }

    public static a pm() {
        AppMethodBeat.i(77175);
        a aVar = new a(new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0069a("disk-cache", b.aJB, true)));
        AppMethodBeat.o(77175);
        return aVar;
    }

    public static a pn() {
        AppMethodBeat.i(77176);
        int pq = pq();
        a aVar = new a(new ThreadPoolExecutor(pq, pq, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0069a("source", b.aJB, false)));
        AppMethodBeat.o(77176);
        return aVar;
    }

    public static a po() {
        AppMethodBeat.i(77177);
        a aVar = new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, aJr, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryC0069a("source-unlimited", b.aJB, false)));
        AppMethodBeat.o(77177);
        return aVar;
    }

    public static a pp() {
        int i2;
        AppMethodBeat.i(77178);
        if (pq() >= 4) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        a aVar = new a(new ThreadPoolExecutor(0, i2, aJr, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0069a("animation", b.aJB, true)));
        AppMethodBeat.o(77178);
        return aVar;
    }

    private a(ExecutorService executorService) {
        this.aJt = executorService;
    }

    public final void execute(Runnable runnable) {
        AppMethodBeat.i(77179);
        this.aJt.execute(runnable);
        AppMethodBeat.o(77179);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable runnable) {
        AppMethodBeat.i(77180);
        Future<?> submit = this.aJt.submit(runnable);
        AppMethodBeat.o(77180);
        return submit;
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        AppMethodBeat.i(77181);
        List<Future<T>> invokeAll = this.aJt.invokeAll(collection);
        AppMethodBeat.o(77181);
        return invokeAll;
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) {
        AppMethodBeat.i(77182);
        List<Future<T>> invokeAll = this.aJt.invokeAll(collection, j2, timeUnit);
        AppMethodBeat.o(77182);
        return invokeAll;
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        AppMethodBeat.i(77183);
        T t = (T) this.aJt.invokeAny(collection);
        AppMethodBeat.o(77183);
        return t;
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) {
        AppMethodBeat.i(77184);
        T t = (T) this.aJt.invokeAny(collection, j2, timeUnit);
        AppMethodBeat.o(77184);
        return t;
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Runnable runnable, T t) {
        AppMethodBeat.i(77185);
        Future<T> submit = this.aJt.submit(runnable, t);
        AppMethodBeat.o(77185);
        return submit;
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Callable<T> callable) {
        AppMethodBeat.i(77186);
        Future<T> submit = this.aJt.submit(callable);
        AppMethodBeat.o(77186);
        return submit;
    }

    public final void shutdown() {
        AppMethodBeat.i(77187);
        this.aJt.shutdown();
        AppMethodBeat.o(77187);
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        AppMethodBeat.i(77188);
        List<Runnable> shutdownNow = this.aJt.shutdownNow();
        AppMethodBeat.o(77188);
        return shutdownNow;
    }

    public final boolean isShutdown() {
        AppMethodBeat.i(77189);
        boolean isShutdown = this.aJt.isShutdown();
        AppMethodBeat.o(77189);
        return isShutdown;
    }

    public final boolean isTerminated() {
        AppMethodBeat.i(77190);
        boolean isTerminated = this.aJt.isTerminated();
        AppMethodBeat.o(77190);
        return isTerminated;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j2, TimeUnit timeUnit) {
        AppMethodBeat.i(77191);
        boolean awaitTermination = this.aJt.awaitTermination(j2, timeUnit);
        AppMethodBeat.o(77191);
        return awaitTermination;
    }

    public final String toString() {
        AppMethodBeat.i(77192);
        String obj = this.aJt.toString();
        AppMethodBeat.o(77192);
        return obj;
    }

    private static int pq() {
        AppMethodBeat.i(77193);
        if (aJs == 0) {
            aJs = Math.min(4, b.availableProcessors());
        }
        int i2 = aJs;
        AppMethodBeat.o(77193);
        return i2;
    }

    /* renamed from: com.bumptech.glide.load.b.c.a$a  reason: collision with other inner class name */
    static final class ThreadFactoryC0069a implements ThreadFactory {
        final b aJu;
        final boolean aJv;
        private int aJw;
        private final String name;

        ThreadFactoryC0069a(String str, b bVar, boolean z) {
            this.name = str;
            this.aJu = bVar;
            this.aJv = z;
        }

        public final synchronized Thread newThread(Runnable runnable) {
            AnonymousClass1 r0;
            AppMethodBeat.i(77172);
            r0 = new Thread(runnable, "glide-" + this.name + "-thread-" + this.aJw) {
                /* class com.bumptech.glide.load.b.c.a.ThreadFactoryC0069a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(77171);
                    Process.setThreadPriority(9);
                    if (ThreadFactoryC0069a.this.aJv) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                        AppMethodBeat.o(77171);
                    } catch (Throwable th) {
                        ThreadFactoryC0069a.this.aJu.c(th);
                        AppMethodBeat.o(77171);
                    }
                }
            };
            this.aJw++;
            AppMethodBeat.o(77172);
            return r0;
        }
    }
}
