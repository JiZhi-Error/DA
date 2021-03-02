package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.Thread;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zzgg extends zzhh {
    private static final AtomicLong zzalx = new AtomicLong(Long.MIN_VALUE);
    private ExecutorService zzaln;
    private zzgk zzalo;
    private zzgk zzalp;
    private final PriorityBlockingQueue<zzgj<?>> zzalq = new PriorityBlockingQueue<>();
    private final BlockingQueue<zzgj<?>> zzalr = new LinkedBlockingQueue();
    private final Thread.UncaughtExceptionHandler zzals = new zzgi(this, "Thread death: Uncaught exception on worker thread");
    private final Thread.UncaughtExceptionHandler zzalt = new zzgi(this, "Thread death: Uncaught exception on network thread");
    private final Object zzalu = new Object();
    private final Semaphore zzalv = new Semaphore(2);
    private volatile boolean zzalw;

    static {
        AppMethodBeat.i(1575);
        AppMethodBeat.o(1575);
    }

    zzgg(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.i(1546);
        AppMethodBeat.o(1546);
    }

    public static boolean isMainThread() {
        AppMethodBeat.i(1549);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AppMethodBeat.o(1549);
            return true;
        }
        AppMethodBeat.o(1549);
        return false;
    }

    private final void zza(zzgj<?> zzgj) {
        AppMethodBeat.i(1555);
        synchronized (this.zzalu) {
            try {
                this.zzalq.add(zzgj);
                if (this.zzalo == null) {
                    this.zzalo = new zzgk(this, "Measurement Worker", this.zzalq);
                    this.zzalo.setUncaughtExceptionHandler(this.zzals);
                    this.zzalo.start();
                } else {
                    this.zzalo.zzjn();
                }
            } finally {
                AppMethodBeat.o(1555);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(1566);
        Context context = super.getContext();
        AppMethodBeat.o(1566);
        return context;
    }

    /* access modifiers changed from: package-private */
    public final <T> T zza(AtomicReference<T> atomicReference, long j2, String str, Runnable runnable) {
        AppMethodBeat.i(1554);
        synchronized (atomicReference) {
            try {
                zzgd().zzc(runnable);
                try {
                    atomicReference.wait(15000);
                } catch (InterruptedException e2) {
                    zzfi zzip = zzge().zzip();
                    String valueOf = String.valueOf(str);
                    zzip.log(valueOf.length() != 0 ? "Interrupted waiting for ".concat(valueOf) : new String("Interrupted waiting for "));
                    AppMethodBeat.o(1554);
                    return null;
                }
            } finally {
                AppMethodBeat.o(1554);
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            zzfi zzip2 = zzge().zzip();
            String valueOf2 = String.valueOf(str);
            zzip2.log(valueOf2.length() != 0 ? "Timed out waiting for ".concat(valueOf2) : new String("Timed out waiting for "));
        }
        return t;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final void zzab() {
        AppMethodBeat.i(1547);
        if (Thread.currentThread() != this.zzalo) {
            IllegalStateException illegalStateException = new IllegalStateException("Call expected from worker thread");
            AppMethodBeat.o(1547);
            throw illegalStateException;
        }
        AppMethodBeat.o(1547);
    }

    public final <V> Future<V> zzb(Callable<V> callable) {
        AppMethodBeat.i(1551);
        zzch();
        Preconditions.checkNotNull(callable);
        zzgj<?> zzgj = new zzgj<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzalo) {
            if (!this.zzalq.isEmpty()) {
                zzge().zzip().log("Callable skipped the worker queue.");
            }
            zzgj.run();
        } else {
            zza(zzgj);
        }
        AppMethodBeat.o(1551);
        return zzgj;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(1565);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(1565);
        return zzbt;
    }

    public final <V> Future<V> zzc(Callable<V> callable) {
        AppMethodBeat.i(1552);
        zzch();
        Preconditions.checkNotNull(callable);
        zzgj<?> zzgj = new zzgj<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzalo) {
            zzgj.run();
        } else {
            zza(zzgj);
        }
        AppMethodBeat.o(1552);
        return zzgj;
    }

    public final void zzc(Runnable runnable) {
        AppMethodBeat.i(1553);
        zzch();
        Preconditions.checkNotNull(runnable);
        zza(new zzgj<>(this, runnable, false, "Task exception on worker thread"));
        AppMethodBeat.o(1553);
    }

    public final void zzd(Runnable runnable) {
        AppMethodBeat.i(1556);
        zzch();
        Preconditions.checkNotNull(runnable);
        zzgj<?> zzgj = new zzgj<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzalu) {
            try {
                this.zzalr.add(zzgj);
                if (this.zzalp == null) {
                    this.zzalp = new zzgk(this, "Measurement Network", this.zzalr);
                    this.zzalp.setUncaughtExceptionHandler(this.zzalt);
                    this.zzalp.start();
                } else {
                    this.zzalp.zzjn();
                }
            } finally {
                AppMethodBeat.o(1556);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(1558);
        super.zzfr();
        AppMethodBeat.o(1558);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final void zzfs() {
        AppMethodBeat.i(1548);
        if (Thread.currentThread() != this.zzalp) {
            IllegalStateException illegalStateException = new IllegalStateException("Call expected from network thread");
            AppMethodBeat.o(1548);
            throw illegalStateException;
        }
        AppMethodBeat.o(1548);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(1559);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(1559);
        return zzft;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(1560);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(1560);
        return zzfu;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(1561);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(1561);
        return zzfv;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(1562);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(1562);
        return zzfw;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(1563);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(1563);
        return zzfx;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(1564);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(1564);
        return zzfy;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(1567);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(1567);
        return zzfz;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(1568);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(1568);
        return zzga;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(1569);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(1569);
        return zzgb;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(1570);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(1570);
        return zzgc;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(1571);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(1571);
        return zzgd;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(1572);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(1572);
        return zzge;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(1573);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(1573);
        return zzgf;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(1574);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(1574);
        return zzgg;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzhh
    public final boolean zzhf() {
        return false;
    }

    public final boolean zzjk() {
        AppMethodBeat.i(1550);
        if (Thread.currentThread() == this.zzalo) {
            AppMethodBeat.o(1550);
            return true;
        }
        AppMethodBeat.o(1550);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final ExecutorService zzjl() {
        ExecutorService executorService;
        AppMethodBeat.i(1557);
        synchronized (this.zzalu) {
            try {
                if (this.zzaln == null) {
                    this.zzaln = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
                }
                executorService = this.zzaln;
            } finally {
                AppMethodBeat.o(1557);
            }
        }
        return executorService;
    }
}
