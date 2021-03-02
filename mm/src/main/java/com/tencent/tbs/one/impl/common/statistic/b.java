package com.tencent.tbs.one.impl.common.statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int f2600a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b  reason: collision with root package name */
    private static final int f2601b = Math.max(2, Math.min(f2600a - 1, 4));

    /* renamed from: c  reason: collision with root package name */
    private static final int f2602c = ((f2600a * 2) + 1);

    /* renamed from: d  reason: collision with root package name */
    private static final BlockingQueue<Runnable> f2603d = new LinkedBlockingQueue(128);

    /* renamed from: e  reason: collision with root package name */
    private static final Executor f2604e;

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadFactory f2605f = new ThreadFactory() {
        /* class com.tencent.tbs.one.impl.common.statistic.b.AnonymousClass1 */

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f2609a = new AtomicInteger(1);

        {
            AppMethodBeat.i(174199);
            AppMethodBeat.o(174199);
        }

        public final Thread newThread(Runnable runnable) {
            AppMethodBeat.i(174200);
            Thread thread = new Thread(runnable, "StatisticExecutor #" + this.f2609a.getAndIncrement());
            AppMethodBeat.o(174200);
            return thread;
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private static volatile Executor f2606g = new Executor() {
        /* class com.tencent.tbs.one.impl.common.statistic.b.AnonymousClass2 */

        /* renamed from: a  reason: collision with root package name */
        final ArrayDeque<Runnable> f2610a = new ArrayDeque<>();

        /* renamed from: b  reason: collision with root package name */
        Runnable f2611b;

        {
            AppMethodBeat.i(174226);
            AppMethodBeat.o(174226);
        }

        /* access modifiers changed from: package-private */
        public final synchronized void a() {
            AppMethodBeat.i(174228);
            Runnable poll = this.f2610a.poll();
            this.f2611b = poll;
            if (poll != null) {
                b.f2604e.execute(this.f2611b);
            }
            AppMethodBeat.o(174228);
        }

        public final synchronized void execute(final Runnable runnable) {
            AppMethodBeat.i(174227);
            this.f2610a.offer(new Runnable() {
                /* class com.tencent.tbs.one.impl.common.statistic.b.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(174230);
                    try {
                        runnable.run();
                    } finally {
                        AnonymousClass2.this.a();
                        AppMethodBeat.o(174230);
                    }
                }
            });
            if (this.f2611b == null) {
                a();
            }
            AppMethodBeat.o(174227);
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private static b f2607h;

    /* renamed from: i  reason: collision with root package name */
    private static final Object f2608i = new Object();

    static {
        AppMethodBeat.i(174234);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f2601b, f2602c, 30, TimeUnit.SECONDS, f2603d, f2605f);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f2604e = threadPoolExecutor;
        AppMethodBeat.o(174234);
    }

    public static b a() {
        AppMethodBeat.i(174232);
        if (f2607h == null) {
            synchronized (f2608i) {
                try {
                    if (f2607h == null) {
                        f2607h = new b();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(174232);
                    throw th;
                }
            }
        }
        b bVar = f2607h;
        AppMethodBeat.o(174232);
        return bVar;
    }

    public static void a(Runnable runnable) {
        AppMethodBeat.i(174233);
        f2606g.execute(runnable);
        AppMethodBeat.o(174233);
    }
}
