package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* access modifiers changed from: package-private */
public final class zzu<TResult> extends Task<TResult> {
    private final Object mLock = new Object();
    private final zzr<TResult> zzage = new zzr<>();
    @GuardedBy("mLock")
    private boolean zzagf;
    @GuardedBy("mLock")
    private TResult zzagg;
    @GuardedBy("mLock")
    private Exception zzagh;
    private volatile boolean zzfi;

    static class zza extends LifecycleCallback {
        private final List<WeakReference<zzq<?>>> zzagi = new ArrayList();

        private zza(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            AppMethodBeat.i(13413);
            this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
            AppMethodBeat.o(13413);
        }

        public static zza zze(Activity activity) {
            AppMethodBeat.i(13412);
            LifecycleFragment fragment = getFragment(activity);
            zza zza = (zza) fragment.getCallbackOrNull("TaskOnStopCallback", zza.class);
            if (zza == null) {
                zza = new zza(fragment);
            }
            AppMethodBeat.o(13412);
            return zza;
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public void onStop() {
            AppMethodBeat.i(13415);
            synchronized (this.zzagi) {
                try {
                    for (WeakReference<zzq<?>> weakReference : this.zzagi) {
                        zzq<?> zzq = weakReference.get();
                        if (zzq != null) {
                            zzq.cancel();
                        }
                    }
                    this.zzagi.clear();
                } finally {
                    AppMethodBeat.o(13415);
                }
            }
        }

        public final <T> void zzb(zzq<T> zzq) {
            AppMethodBeat.i(13414);
            synchronized (this.zzagi) {
                try {
                    this.zzagi.add(new WeakReference<>(zzq));
                } finally {
                    AppMethodBeat.o(13414);
                }
            }
        }
    }

    zzu() {
        AppMethodBeat.i(13416);
        AppMethodBeat.o(13416);
    }

    @GuardedBy("mLock")
    private final void zzdq() {
        AppMethodBeat.i(13442);
        Preconditions.checkState(this.zzagf, "Task is not yet complete");
        AppMethodBeat.o(13442);
    }

    @GuardedBy("mLock")
    private final void zzdr() {
        AppMethodBeat.i(13443);
        Preconditions.checkState(!this.zzagf, "Task is already complete");
        AppMethodBeat.o(13443);
    }

    @GuardedBy("mLock")
    private final void zzds() {
        AppMethodBeat.i(13444);
        if (this.zzfi) {
            CancellationException cancellationException = new CancellationException("Task is already canceled.");
            AppMethodBeat.o(13444);
            throw cancellationException;
        }
        AppMethodBeat.o(13444);
    }

    private final void zzdt() {
        AppMethodBeat.i(13445);
        synchronized (this.mLock) {
            try {
                if (this.zzagf) {
                    this.zzage.zza(this);
                    AppMethodBeat.o(13445);
                }
            } finally {
                AppMethodBeat.o(13445);
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        AppMethodBeat.i(13433);
        zzg zzg = new zzg(TaskExecutors.MAIN_THREAD, onCanceledListener);
        this.zzage.zza(zzg);
        zza.zze(activity).zzb(zzg);
        zzdt();
        AppMethodBeat.o(13433);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCanceledListener(OnCanceledListener onCanceledListener) {
        AppMethodBeat.i(13431);
        Task<TResult> addOnCanceledListener = addOnCanceledListener(TaskExecutors.MAIN_THREAD, onCanceledListener);
        AppMethodBeat.o(13431);
        return addOnCanceledListener;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        AppMethodBeat.i(13432);
        this.zzage.zza(new zzg(executor, onCanceledListener));
        zzdt();
        AppMethodBeat.o(13432);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCompleteListener(Activity activity, OnCompleteListener<TResult> onCompleteListener) {
        AppMethodBeat.i(13427);
        zzi zzi = new zzi(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.zzage.zza(zzi);
        zza.zze(activity).zzb(zzi);
        zzdt();
        AppMethodBeat.o(13427);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener) {
        AppMethodBeat.i(13425);
        Task<TResult> addOnCompleteListener = addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
        AppMethodBeat.o(13425);
        return addOnCompleteListener;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        AppMethodBeat.i(13426);
        this.zzage.zza(new zzi(executor, onCompleteListener));
        zzdt();
        AppMethodBeat.o(13426);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        AppMethodBeat.i(13424);
        zzk zzk = new zzk(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.zzage.zza(zzk);
        zza.zze(activity).zzb(zzk);
        zzdt();
        AppMethodBeat.o(13424);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnFailureListener(OnFailureListener onFailureListener) {
        AppMethodBeat.i(13422);
        Task<TResult> addOnFailureListener = addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
        AppMethodBeat.o(13422);
        return addOnFailureListener;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        AppMethodBeat.i(13423);
        this.zzage.zza(new zzk(executor, onFailureListener));
        zzdt();
        AppMethodBeat.o(13423);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnSuccessListener(Activity activity, OnSuccessListener<? super TResult> onSuccessListener) {
        AppMethodBeat.i(13421);
        zzm zzm = new zzm(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.zzage.zza(zzm);
        zza.zze(activity).zzb(zzm);
        zzdt();
        AppMethodBeat.o(13421);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> onSuccessListener) {
        AppMethodBeat.i(13419);
        Task<TResult> addOnSuccessListener = addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
        AppMethodBeat.o(13419);
        return addOnSuccessListener;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnSuccessListener(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        AppMethodBeat.i(13420);
        this.zzage.zza(new zzm(executor, onSuccessListener));
        zzdt();
        AppMethodBeat.o(13420);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation) {
        AppMethodBeat.i(13428);
        Task<TContinuationResult> continueWith = continueWith(TaskExecutors.MAIN_THREAD, continuation);
        AppMethodBeat.o(13428);
        return continueWith;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        AppMethodBeat.i(13429);
        zzu zzu = new zzu();
        this.zzage.zza(new zzc(executor, continuation, zzu));
        zzdt();
        AppMethodBeat.o(13429);
        return zzu;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        AppMethodBeat.i(13430);
        Task<TContinuationResult> continueWithTask = continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
        AppMethodBeat.o(13430);
        return continueWithTask;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation) {
        AppMethodBeat.i(13434);
        zzu zzu = new zzu();
        this.zzage.zza(new zze(executor, continuation, zzu));
        zzdt();
        AppMethodBeat.o(13434);
        return zzu;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Exception getException() {
        Exception exc;
        synchronized (this.mLock) {
            exc = this.zzagh;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public final TResult getResult() {
        TResult tresult;
        AppMethodBeat.i(13417);
        synchronized (this.mLock) {
            try {
                zzdq();
                zzds();
                if (this.zzagh != null) {
                    RuntimeExecutionException runtimeExecutionException = new RuntimeExecutionException(this.zzagh);
                    AppMethodBeat.o(13417);
                    throw runtimeExecutionException;
                }
                tresult = this.zzagg;
            } finally {
                AppMethodBeat.o(13417);
            }
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <X extends Throwable> TResult getResult(Class<X> cls) {
        TResult tresult;
        AppMethodBeat.i(13418);
        synchronized (this.mLock) {
            try {
                zzdq();
                zzds();
                if (cls.isInstance(this.zzagh)) {
                    X cast = cls.cast(this.zzagh);
                    AppMethodBeat.o(13418);
                    throw cast;
                } else if (this.zzagh != null) {
                    RuntimeExecutionException runtimeExecutionException = new RuntimeExecutionException(this.zzagh);
                    AppMethodBeat.o(13418);
                    throw runtimeExecutionException;
                } else {
                    tresult = this.zzagg;
                }
            } finally {
                AppMethodBeat.o(13418);
            }
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isCanceled() {
        return this.zzfi;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isComplete() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzagf;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzagf && !this.zzfi && this.zzagh == null;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        AppMethodBeat.i(13436);
        Task<TContinuationResult> onSuccessTask = onSuccessTask(TaskExecutors.MAIN_THREAD, successContinuation);
        AppMethodBeat.o(13436);
        return onSuccessTask;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        AppMethodBeat.i(13435);
        zzu zzu = new zzu();
        this.zzage.zza(new zzo(executor, successContinuation, zzu));
        zzdt();
        AppMethodBeat.o(13435);
        return zzu;
    }

    public final void setException(Exception exc) {
        AppMethodBeat.i(13439);
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.mLock) {
            try {
                zzdr();
                this.zzagf = true;
                this.zzagh = exc;
            } catch (Throwable th) {
                AppMethodBeat.o(13439);
                throw th;
            }
        }
        this.zzage.zza(this);
        AppMethodBeat.o(13439);
    }

    public final void setResult(TResult tresult) {
        AppMethodBeat.i(13437);
        synchronized (this.mLock) {
            try {
                zzdr();
                this.zzagf = true;
                this.zzagg = tresult;
            } catch (Throwable th) {
                AppMethodBeat.o(13437);
                throw th;
            }
        }
        this.zzage.zza(this);
        AppMethodBeat.o(13437);
    }

    public final boolean trySetException(Exception exc) {
        boolean z = true;
        AppMethodBeat.i(13440);
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.mLock) {
            try {
                if (this.zzagf) {
                    z = false;
                } else {
                    this.zzagf = true;
                    this.zzagh = exc;
                    this.zzage.zza(this);
                    AppMethodBeat.o(13440);
                }
            } finally {
                AppMethodBeat.o(13440);
            }
        }
        return z;
    }

    public final boolean trySetResult(TResult tresult) {
        boolean z = true;
        AppMethodBeat.i(13438);
        synchronized (this.mLock) {
            try {
                if (this.zzagf) {
                    z = false;
                } else {
                    this.zzagf = true;
                    this.zzagg = tresult;
                    this.zzage.zza(this);
                    AppMethodBeat.o(13438);
                }
            } finally {
                AppMethodBeat.o(13438);
            }
        }
        return z;
    }

    public final boolean zzdp() {
        boolean z = true;
        AppMethodBeat.i(13441);
        synchronized (this.mLock) {
            try {
                if (this.zzagf) {
                    z = false;
                } else {
                    this.zzagf = true;
                    this.zzfi = true;
                    this.zzage.zza(this);
                    AppMethodBeat.o(13441);
                }
            } finally {
                AppMethodBeat.o(13441);
            }
        }
        return z;
    }
}
