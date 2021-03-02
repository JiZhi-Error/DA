package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

public final class Tasks {

    static final class zza implements zzb {
        private final CountDownLatch zzfd;

        private zza() {
            AppMethodBeat.i(13349);
            this.zzfd = new CountDownLatch(1);
            AppMethodBeat.o(13349);
        }

        /* synthetic */ zza(zzv zzv) {
            this();
        }

        public final void await() {
            AppMethodBeat.i(13353);
            this.zzfd.await();
            AppMethodBeat.o(13353);
        }

        public final boolean await(long j2, TimeUnit timeUnit) {
            AppMethodBeat.i(13354);
            boolean await = this.zzfd.await(j2, timeUnit);
            AppMethodBeat.o(13354);
            return await;
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public final void onCanceled() {
            AppMethodBeat.i(13352);
            this.zzfd.countDown();
            AppMethodBeat.o(13352);
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            AppMethodBeat.i(13351);
            this.zzfd.countDown();
            AppMethodBeat.o(13351);
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public final void onSuccess(Object obj) {
            AppMethodBeat.i(13350);
            this.zzfd.countDown();
            AppMethodBeat.o(13350);
        }
    }

    /* access modifiers changed from: package-private */
    public interface zzb extends OnCanceledListener, OnFailureListener, OnSuccessListener<Object> {
    }

    /* access modifiers changed from: package-private */
    public static final class zzc implements zzb {
        private final Object mLock = new Object();
        private final zzu<Void> zzafh;
        @GuardedBy("mLock")
        private Exception zzagh;
        private final int zzagl;
        @GuardedBy("mLock")
        private int zzagm;
        @GuardedBy("mLock")
        private int zzagn;
        @GuardedBy("mLock")
        private int zzago;
        @GuardedBy("mLock")
        private boolean zzagp;

        public zzc(int i2, zzu<Void> zzu) {
            AppMethodBeat.i(13355);
            this.zzagl = i2;
            this.zzafh = zzu;
            AppMethodBeat.o(13355);
        }

        @GuardedBy("mLock")
        private final void zzdu() {
            AppMethodBeat.i(13359);
            if (this.zzagm + this.zzagn + this.zzago == this.zzagl) {
                if (this.zzagh != null) {
                    zzu<Void> zzu = this.zzafh;
                    int i2 = this.zzagn;
                    zzu.setException(new ExecutionException(new StringBuilder(54).append(i2).append(" out of ").append(this.zzagl).append(" underlying tasks failed").toString(), this.zzagh));
                    AppMethodBeat.o(13359);
                    return;
                } else if (this.zzagp) {
                    this.zzafh.zzdp();
                    AppMethodBeat.o(13359);
                    return;
                } else {
                    this.zzafh.setResult(null);
                }
            }
            AppMethodBeat.o(13359);
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public final void onCanceled() {
            AppMethodBeat.i(13358);
            synchronized (this.mLock) {
                try {
                    this.zzago++;
                    this.zzagp = true;
                    zzdu();
                } finally {
                    AppMethodBeat.o(13358);
                }
            }
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            AppMethodBeat.i(13356);
            synchronized (this.mLock) {
                try {
                    this.zzagn++;
                    this.zzagh = exc;
                    zzdu();
                } finally {
                    AppMethodBeat.o(13356);
                }
            }
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public final void onSuccess(Object obj) {
            AppMethodBeat.i(13357);
            synchronized (this.mLock) {
                try {
                    this.zzagm++;
                    zzdu();
                } finally {
                    AppMethodBeat.o(13357);
                }
            }
        }
    }

    private Tasks() {
    }

    public static <TResult> TResult await(Task<TResult> task) {
        AppMethodBeat.i(13365);
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        if (task.isComplete()) {
            TResult tresult = (TResult) zzb(task);
            AppMethodBeat.o(13365);
            return tresult;
        }
        zza zza2 = new zza(null);
        zza(task, zza2);
        zza2.await();
        TResult tresult2 = (TResult) zzb(task);
        AppMethodBeat.o(13365);
        return tresult2;
    }

    public static <TResult> TResult await(Task<TResult> task, long j2, TimeUnit timeUnit) {
        AppMethodBeat.i(13366);
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            TResult tresult = (TResult) zzb(task);
            AppMethodBeat.o(13366);
            return tresult;
        }
        zza zza2 = new zza(null);
        zza(task, zza2);
        if (!zza2.await(j2, timeUnit)) {
            TimeoutException timeoutException = new TimeoutException("Timed out waiting for Task");
            AppMethodBeat.o(13366);
            throw timeoutException;
        }
        TResult tresult2 = (TResult) zzb(task);
        AppMethodBeat.o(13366);
        return tresult2;
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable) {
        AppMethodBeat.i(13363);
        Task<TResult> call = call(TaskExecutors.MAIN_THREAD, callable);
        AppMethodBeat.o(13363);
        return call;
    }

    public static <TResult> Task<TResult> call(Executor executor, Callable<TResult> callable) {
        AppMethodBeat.i(13364);
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(callable, "Callback must not be null");
        zzu zzu = new zzu();
        executor.execute(new zzv(zzu, callable));
        AppMethodBeat.o(13364);
        return zzu;
    }

    public static <TResult> Task<TResult> forCanceled() {
        AppMethodBeat.i(13362);
        zzu zzu = new zzu();
        zzu.zzdp();
        AppMethodBeat.o(13362);
        return zzu;
    }

    public static <TResult> Task<TResult> forException(Exception exc) {
        AppMethodBeat.i(13361);
        zzu zzu = new zzu();
        zzu.setException(exc);
        AppMethodBeat.o(13361);
        return zzu;
    }

    public static <TResult> Task<TResult> forResult(TResult tresult) {
        AppMethodBeat.i(13360);
        zzu zzu = new zzu();
        zzu.setResult(tresult);
        AppMethodBeat.o(13360);
        return zzu;
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> collection) {
        AppMethodBeat.i(13367);
        if (collection.isEmpty()) {
            Task<Void> forResult = forResult(null);
            AppMethodBeat.o(13367);
            return forResult;
        }
        Iterator<? extends Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (((Task) it.next()) == null) {
                NullPointerException nullPointerException = new NullPointerException("null tasks are not accepted");
                AppMethodBeat.o(13367);
                throw nullPointerException;
            }
        }
        zzu zzu = new zzu();
        zzc zzc2 = new zzc(collection.size(), zzu);
        Iterator<? extends Task<?>> it2 = collection.iterator();
        while (it2.hasNext()) {
            zza((Task) it2.next(), zzc2);
        }
        AppMethodBeat.o(13367);
        return zzu;
    }

    public static Task<Void> whenAll(Task<?>... taskArr) {
        AppMethodBeat.i(13368);
        if (taskArr.length == 0) {
            Task<Void> forResult = forResult(null);
            AppMethodBeat.o(13368);
            return forResult;
        }
        Task<Void> whenAll = whenAll(Arrays.asList(taskArr));
        AppMethodBeat.o(13368);
        return whenAll;
    }

    public static Task<List<Task<?>>> whenAllComplete(Collection<? extends Task<?>> collection) {
        AppMethodBeat.i(13371);
        Task<TContinuationResult> continueWithTask = whenAll(collection).continueWithTask(new zzx(collection));
        AppMethodBeat.o(13371);
        return continueWithTask;
    }

    public static Task<List<Task<?>>> whenAllComplete(Task<?>... taskArr) {
        AppMethodBeat.i(13372);
        Task<List<Task<?>>> whenAllComplete = whenAllComplete(Arrays.asList(taskArr));
        AppMethodBeat.o(13372);
        return whenAllComplete;
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Collection<? extends Task<?>> collection) {
        AppMethodBeat.i(13369);
        Task<TContinuationResult> continueWith = whenAll(collection).continueWith(new zzw(collection));
        AppMethodBeat.o(13369);
        return continueWith;
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Task<?>... taskArr) {
        AppMethodBeat.i(13370);
        Task<List<TResult>> whenAllSuccess = whenAllSuccess(Arrays.asList(taskArr));
        AppMethodBeat.o(13370);
        return whenAllSuccess;
    }

    private static void zza(Task<?> task, zzb zzb2) {
        AppMethodBeat.i(13374);
        task.addOnSuccessListener(TaskExecutors.zzagd, zzb2);
        task.addOnFailureListener(TaskExecutors.zzagd, zzb2);
        task.addOnCanceledListener(TaskExecutors.zzagd, zzb2);
        AppMethodBeat.o(13374);
    }

    private static <TResult> TResult zzb(Task<TResult> task) {
        AppMethodBeat.i(13373);
        if (task.isSuccessful()) {
            TResult result = task.getResult();
            AppMethodBeat.o(13373);
            return result;
        } else if (task.isCanceled()) {
            CancellationException cancellationException = new CancellationException("Task is already canceled");
            AppMethodBeat.o(13373);
            throw cancellationException;
        } else {
            ExecutionException executionException = new ExecutionException(task.getException());
            AppMethodBeat.o(13373);
            throw executionException;
        }
    }
}
