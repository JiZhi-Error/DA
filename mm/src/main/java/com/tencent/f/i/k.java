package com.tencent.f.i;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.f.f;
import com.tencent.f.f.a;
import com.tencent.f.g;
import com.tencent.f.g.a.b;
import com.tencent.f.g.g;
import com.tencent.f.g.h;
import com.tencent.f.h.d;
import com.tencent.f.k.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class k<V> extends FutureTask<V> implements c, d<V>, h, Delayed, RunnableScheduledFuture<V> {
    private static final b RSt = h.RUe;
    private static final a RUF = new a() {
        /* class com.tencent.f.i.k.AnonymousClass1 */

        @Override // com.tencent.f.f.a
        public final void d(k kVar) {
            AppMethodBeat.i(256676);
            if (com.tencent.f.c.b.RTE != null) {
                com.tencent.f.c.b.RTE.d(kVar);
            }
            AppMethodBeat.o(256676);
        }

        @Override // com.tencent.f.f.a
        public final void b(k kVar) {
            AppMethodBeat.i(256677);
            if (com.tencent.f.c.b.RTE != null) {
                com.tencent.f.c.b.RTE.b(kVar);
            }
            AppMethodBeat.o(256677);
        }

        @Override // com.tencent.f.f.a
        public final void a(k kVar, long j2, long j3) {
            AppMethodBeat.i(256678);
            if (com.tencent.f.c.b.RTE != null) {
                com.tencent.f.c.b.RTE.a(kVar, j2, j3);
            }
            AppMethodBeat.o(256678);
        }

        @Override // com.tencent.f.f.a
        public final void a(k kVar) {
            AppMethodBeat.i(256679);
            if (com.tencent.f.c.b.RTE != null) {
                com.tencent.f.c.b.RTE.a(kVar);
            }
            AppMethodBeat.o(256679);
        }

        @Override // com.tencent.f.f.a
        public final void c(k kVar) {
            AppMethodBeat.i(256680);
            if (com.tencent.f.c.b.RTE != null) {
                com.tencent.f.c.b.RTE.c(kVar);
            }
            AppMethodBeat.o(256680);
        }

        @Override // com.tencent.f.f.a
        public final void e(k kVar) {
            AppMethodBeat.i(256681);
            if (com.tencent.f.c.b.RTE != null) {
                com.tencent.f.c.b.RTE.e(kVar);
            }
            AppMethodBeat.o(256681);
        }
    };
    private static final AtomicLong RUG = new AtomicLong();
    private static final long RUN = Looper.getMainLooper().getThread().getId();
    protected long AVw = 0;
    private f RUE = f.CREATED;
    private volatile long RUH;
    public Object RUI;
    private String RUJ;
    private g RUK;
    public d RUL;
    public final int RUM;
    private final long aDT = RUG.getAndIncrement();
    private boolean isLogging = true;
    private final long period;
    protected Thread thread;
    private Throwable throwable;
    protected long time = 0;
    protected long waitTime = 0;

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.i(183390);
        Delayed delayed = (Delayed) obj;
        if (delayed != this) {
            if (delayed instanceof k) {
                k kVar = (k) delayed;
                long j2 = this.RUH - kVar.RUH;
                if (j2 < 0) {
                    AppMethodBeat.o(183390);
                    return -1;
                } else if (j2 > 0) {
                    AppMethodBeat.o(183390);
                    return 1;
                } else if (this.aDT < kVar.aDT) {
                    AppMethodBeat.o(183390);
                    return -1;
                } else {
                    AppMethodBeat.o(183390);
                    return 1;
                }
            } else {
                long delay = getDelay(TimeUnit.NANOSECONDS) - delayed.getDelay(TimeUnit.NANOSECONDS);
                if (delay < 0) {
                    AppMethodBeat.o(183390);
                    return -1;
                } else if (delay > 0) {
                    AppMethodBeat.o(183390);
                    return 1;
                }
            }
        }
        AppMethodBeat.o(183390);
        return 0;
    }

    static {
        AppMethodBeat.i(183391);
        AppMethodBeat.o(183391);
    }

    public k(Runnable runnable, long j2, boolean z) {
        super(runnable, null);
        AppMethodBeat.i(183376);
        this.RUI = runnable;
        this.RUH = j2;
        this.period = 0;
        this.RUJ = getKey();
        this.RUM = runnable.hashCode();
        this.isLogging = z;
        if (z && RUF != null) {
            RUF.d(this);
        }
        com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.RUE, j2 - System.nanoTime(), 0, "", z);
        AppMethodBeat.o(183376);
    }

    public k(Runnable runnable, long j2, long j3, boolean z) {
        super(runnable, null);
        AppMethodBeat.i(183377);
        this.RUI = runnable;
        this.RUH = j2;
        this.period = j3;
        this.RUJ = getKey();
        this.RUM = runnable.hashCode();
        this.isLogging = z;
        if (z && RUF != null) {
            RUF.d(this);
        }
        com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.RUE, j2 - System.nanoTime(), 0, "", z);
        AppMethodBeat.o(183377);
    }

    public k(Callable<V> callable, long j2, boolean z) {
        super(callable);
        AppMethodBeat.i(183378);
        this.RUI = callable;
        this.RUH = j2;
        this.period = 0;
        this.RUJ = getKey();
        this.RUM = callable.hashCode();
        this.isLogging = z;
        if (z && RUF != null) {
            RUF.d(this);
        }
        com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.RUE, j2 - System.nanoTime(), 0, "", z);
        AppMethodBeat.o(183378);
    }

    public void run() {
        boolean z;
        long nanoTime;
        k<V> kVar;
        boolean z2;
        AppMethodBeat.i(183379);
        if (isCancelled()) {
            AppMethodBeat.o(183379);
        } else if (!RSt.c(hmB())) {
            long a2 = RSt.a(hmB(), TimeUnit.NANOSECONDS);
            if (a2 >= 0) {
                this.RUH = a2 + System.nanoTime();
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.RUE = f.WAITING;
                this.RUL.g(this);
                com.tencent.f.d.RSQ.a(getKey(), this.RUM, hmB().hmu(), this.RUH - System.nanoTime(), this.RUL.getName());
                AppMethodBeat.o(183379);
                return;
            }
            this.RUE = f.THROW;
            if (this.isLogging && RUF != null) {
                RUF.e(this);
            }
            com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.RUE, 0, 0, this.RUL.getName(), this.isLogging);
            AppMethodBeat.o(183379);
        } else {
            this.time = SystemClock.uptimeMillis();
            this.waitTime -= this.time;
            this.AVw = SystemClock.currentThreadTimeMillis();
            this.RUE = f.RUNNING;
            com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.RUE, this.time, this.AVw, this.RUL.getName(), this.isLogging);
            if (this.isLogging && RUF != null) {
                RUF.a(this);
            }
            Looper myLooper = Looper.myLooper();
            this.thread = Thread.currentThread();
            try {
                boolean isPeriodic = isPeriodic();
                if (!this.RUL.isShutdown()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    cancel(false);
                } else if (!isPeriodic) {
                    super.run();
                } else if (super.runAndReset()) {
                    long j2 = this.period;
                    if (j2 > 0) {
                        nanoTime = this.RUH;
                        kVar = this;
                    } else {
                        j2 = -j2;
                        nanoTime = System.nanoTime();
                        if (j2 < 4611686018427387903L) {
                            kVar = this;
                        } else {
                            j2 = 4611686018427387903L;
                            kVar = this;
                        }
                    }
                    kVar.RUH = j2 + nanoTime;
                    if (this.isLogging && RUF != null) {
                        RUF.d(this);
                    }
                    this.RUL.g(this);
                }
                this.time = SystemClock.uptimeMillis() - this.time;
                this.AVw = SystemClock.currentThreadTimeMillis() - this.AVw;
                if (this.RUE != f.ERROR) {
                    this.RUE = f.COMPLETE;
                }
                if (RUF != null) {
                    switch (this.RUE) {
                        case ERROR:
                            if (this.isLogging) {
                                RUF.c(this);
                            }
                            com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.throwable);
                            break;
                        case COMPLETE:
                            if (this.isLogging) {
                                RUF.a(this, this.AVw, this.time);
                            }
                            com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.RUE, this.time, this.AVw, this.RUL.getName(), this.isLogging);
                            break;
                    }
                }
                i(myLooper);
                hmz();
                AppMethodBeat.o(183379);
            } catch (Throwable th) {
                this.time = SystemClock.uptimeMillis() - this.time;
                this.AVw = SystemClock.currentThreadTimeMillis() - this.AVw;
                if (this.RUE != f.ERROR) {
                    this.RUE = f.COMPLETE;
                }
                if (RUF != null) {
                    switch (this.RUE) {
                        case ERROR:
                            if (this.isLogging) {
                                RUF.c(this);
                            }
                            com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.throwable);
                            break;
                        case COMPLETE:
                            if (this.isLogging) {
                                RUF.a(this, this.AVw, this.time);
                            }
                            com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.RUE, this.time, this.AVw, this.RUL.getName(), this.isLogging);
                            break;
                    }
                }
                i(myLooper);
                hmz();
                AppMethodBeat.o(183379);
                throw th;
            }
        }
    }

    private void i(Looper looper) {
        AppMethodBeat.i(256683);
        g.b bVar = com.tencent.f.a.RSx;
        if (bVar.eCC() && RUN != Thread.currentThread().getId() && Looper.myLooper() != null && looper == null) {
            bVar.a(Thread.currentThread(), getKey());
            if (bVar.eCD()) {
                try {
                    ((ThreadLocal) c.l(Looper.class, "sThreadLocal")).set(null);
                    AppMethodBeat.o(256683);
                    return;
                } catch (Exception e2) {
                    this.throwable = e2;
                }
            }
        }
        AppMethodBeat.o(256683);
    }

    private void hmz() {
        AppMethodBeat.i(183380);
        if (this.throwable == null) {
            AppMethodBeat.o(183380);
        } else if (this.throwable instanceof RuntimeException) {
            RuntimeException runtimeException = (RuntimeException) this.throwable;
            AppMethodBeat.o(183380);
            throw runtimeException;
        } else if (this.throwable instanceof Error) {
            Error error = (Error) this.throwable;
            AppMethodBeat.o(183380);
            throw error;
        } else {
            Error error2 = new Error(this.throwable);
            AppMethodBeat.o(183380);
            throw error2;
        }
    }

    public boolean cancel(boolean z) {
        AppMethodBeat.i(183381);
        if (super.cancel(z)) {
            this.RUE = f.CANCEL;
            if (this.isLogging && RUF != null) {
                RUF.b(this);
            }
            com.tencent.f.d.RSQ.a(getKey(), this.RUM, this.RUE, 0, 0, "", this.isLogging);
            if (this.RUL != null) {
                this.RUL.i(this);
            }
            AppMethodBeat.o(183381);
            return true;
        }
        AppMethodBeat.o(183381);
        return false;
    }

    public final void a(d dVar) {
        AppMethodBeat.i(183382);
        this.RUL = dVar;
        this.waitTime = SystemClock.uptimeMillis();
        AppMethodBeat.o(183382);
    }

    public static b hmA() {
        return RSt;
    }

    public final com.tencent.f.g.g hmB() {
        AppMethodBeat.i(183383);
        if (this.RUK == null) {
            this.RUK = RSt.bqs(this.RUJ);
        }
        com.tencent.f.g.g gVar = this.RUK;
        AppMethodBeat.o(183383);
        return gVar;
    }

    /* access modifiers changed from: protected */
    public void setException(Throwable th) {
        AppMethodBeat.i(183384);
        super.setException(th);
        this.RUE = f.ERROR;
        this.throwable = th;
        AppMethodBeat.o(183384);
    }

    @Override // com.tencent.f.i.h, com.tencent.f.i.g
    public String getKey() {
        AppMethodBeat.i(183385);
        if (this.RUJ != null) {
            String str = this.RUJ;
            AppMethodBeat.o(183385);
            return str;
        } else if (this.RUI instanceof g) {
            String key = ((g) this.RUI).getKey();
            AppMethodBeat.o(183385);
            return key;
        } else {
            String name = this.RUI.getClass().getName();
            AppMethodBeat.o(183385);
            return name;
        }
    }

    public long getDelay(TimeUnit timeUnit) {
        AppMethodBeat.i(183386);
        long convert = timeUnit.convert(this.RUH - System.nanoTime(), TimeUnit.NANOSECONDS);
        AppMethodBeat.o(183386);
        return convert;
    }

    @Override // com.tencent.f.i.d
    public final Thread getThread() {
        return this.thread;
    }

    public final long[] hmC() {
        if (this.RUE != f.COMPLETE) {
            return new long[2];
        }
        return new long[]{this.AVw, this.time};
    }

    public boolean isPeriodic() {
        return this.period != 0;
    }

    /* access modifiers changed from: protected */
    public void done() {
        AppMethodBeat.i(183388);
        super.done();
        this.RUI = null;
        AppMethodBeat.o(183388);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        AppMethodBeat.i(183389);
        super.finalize();
        if (this.RUE == f.CREATED || this.RUE == f.WAITING) {
            cancel(false);
        }
        AppMethodBeat.o(183389);
    }
}
