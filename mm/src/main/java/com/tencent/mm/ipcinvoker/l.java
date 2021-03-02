package com.tencent.mm.ipcinvoker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.a.b;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/* access modifiers changed from: package-private */
public class l {
    private static volatile l hnh;
    private static b hni = null;
    private static final HandlerThread hnj;
    ExecutorService mExecutorService;
    private Handler mHandler = new Handler(hnj.getLooper());

    static {
        AppMethodBeat.i(179050);
        HandlerThread handlerThread = new HandlerThread("IPCThreadPool#WorkerThread");
        hnj = handlerThread;
        handlerThread.start();
        AppMethodBeat.o(179050);
    }

    private static l ayb() {
        AppMethodBeat.i(179045);
        if (hnh == null) {
            synchronized (l.class) {
                try {
                    if (hnh == null) {
                        hnh = new l();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(179045);
                    throw th;
                }
            }
        }
        l lVar = hnh;
        AppMethodBeat.o(179045);
        return lVar;
    }

    private l() {
        AppMethodBeat.i(179046);
        if (hni == null) {
            hni = new a();
        }
        this.mExecutorService = hni.ayd();
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCThreadPool", "initialize IPCInvoker IPCThreadPool(hashCode : %s)", Integer.valueOf(hashCode()));
        AppMethodBeat.o(179046);
    }

    public static Handler ayc() {
        AppMethodBeat.i(179047);
        Handler handler = new Handler(hnj.getLooper());
        AppMethodBeat.o(179047);
        return handler;
    }

    public static boolean post(Runnable runnable) {
        AppMethodBeat.i(179048);
        if (runnable == null) {
            AppMethodBeat.o(179048);
            return false;
        }
        ayb().mExecutorService.execute(runnable);
        AppMethodBeat.o(179048);
        return true;
    }

    public static boolean x(Runnable runnable) {
        AppMethodBeat.i(179049);
        boolean postDelayed = ayb().mHandler.postDelayed(runnable, 2000);
        AppMethodBeat.o(179049);
        return postDelayed;
    }

    static class a implements b {
        private int hnk = 3;
        HandlerThread mHandlerThread;

        a() {
            AppMethodBeat.i(179043);
            HandlerThread handlerThread = new HandlerThread("IPCThreadPool#InnerWorkerThread-" + hashCode());
            handlerThread.start();
            com.tencent.mm.ipcinvoker.h.b.i("IPC.ExecutorServiceCreatorImpl", "createHandlerThread(hash : %d)", Integer.valueOf(handlerThread.hashCode()));
            this.mHandlerThread = handlerThread;
            AppMethodBeat.o(179043);
        }

        @Override // com.tencent.mm.ipcinvoker.a.b
        public final ExecutorService ayd() {
            AppMethodBeat.i(179044);
            AnonymousClass2 r0 = new ScheduledThreadPoolExecutor(this.hnk, new ThreadFactory() {
                /* class com.tencent.mm.ipcinvoker.l.a.AnonymousClass1 */
                int index = 0;

                public final Thread newThread(final Runnable runnable) {
                    AppMethodBeat.i(179039);
                    StringBuilder sb = new StringBuilder("IPCThreadPool#Thread-");
                    int i2 = this.index;
                    this.index = i2 + 1;
                    String sb2 = sb.append(i2).toString();
                    Thread thread = new Thread(new Runnable() {
                        /* class com.tencent.mm.ipcinvoker.l.a.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(179038);
                            ThreadLocal threadLocal = (ThreadLocal) new com.tencent.mm.ipcinvoker.g.a(Looper.class, "sThreadLocal").ayl();
                            if (threadLocal == null || threadLocal.get() != null) {
                                com.tencent.mm.ipcinvoker.h.b.d("IPC.ExecutorServiceCreatorImpl", "ThreadLocal Looper variable is null or has set.(%s)", threadLocal);
                            } else {
                                com.tencent.mm.ipcinvoker.h.b.d("IPC.ExecutorServiceCreatorImpl", "create a new Looper ThreadLocal variable.", new Object[0]);
                                threadLocal.set(a.this.mHandlerThread.getLooper());
                            }
                            runnable.run();
                            AppMethodBeat.o(179038);
                        }
                    }, sb2);
                    com.tencent.mm.ipcinvoker.h.b.i("IPC.ExecutorServiceCreatorImpl", "newThread(thread : %s)", sb2);
                    AppMethodBeat.o(179039);
                    return thread;
                }
            }) {
                /* class com.tencent.mm.ipcinvoker.l.a.AnonymousClass2 */

                public final void execute(final Runnable runnable) {
                    AppMethodBeat.i(179041);
                    super.execute(new Runnable() {
                        /* class com.tencent.mm.ipcinvoker.l.a.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(179040);
                            try {
                                runnable.run();
                                AppMethodBeat.o(179040);
                            } catch (Throwable th) {
                                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.currentThread().getUncaughtExceptionHandler();
                                if (uncaughtExceptionHandler == null) {
                                    uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                                }
                                if (uncaughtExceptionHandler != null) {
                                    uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
                                }
                                AppMethodBeat.o(179040);
                                throw th;
                            }
                        }
                    });
                    AppMethodBeat.o(179041);
                }
            };
            r0.setMaximumPoolSize((int) (((double) this.hnk) * 1.5d));
            r0.setRejectedExecutionHandler(new RejectedExecutionHandler() {
                /* class com.tencent.mm.ipcinvoker.l.a.AnonymousClass3 */

                public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    AppMethodBeat.i(179042);
                    com.tencent.mm.ipcinvoker.h.b.w("IPC.ExecutorServiceCreatorImpl", "on rejectedExecution(r : %s)", runnable);
                    AppMethodBeat.o(179042);
                }
            });
            AppMethodBeat.o(179044);
            return r0;
        }
    }
}
