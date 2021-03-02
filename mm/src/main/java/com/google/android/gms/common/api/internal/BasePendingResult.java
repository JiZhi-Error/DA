package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepForSdk
@KeepName
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    static final ThreadLocal<Boolean> zzez = new zzo();
    @KeepName
    private zza mResultGuardian;
    private Status mStatus;
    private R zzdm;
    private final Object zzfa;
    private final CallbackHandler<R> zzfb;
    private final WeakReference<GoogleApiClient> zzfc;
    private final CountDownLatch zzfd;
    private final ArrayList<PendingResult.StatusListener> zzfe;
    private ResultCallback<? super R> zzff;
    private final AtomicReference<zzcn> zzfg;
    private volatile boolean zzfh;
    private boolean zzfi;
    private boolean zzfj;
    private ICancelToken zzfk;
    private volatile zzch<R> zzfl;
    private boolean zzfm;

    @VisibleForTesting
    public static class CallbackHandler<R extends Result> extends Handler {
        public CallbackHandler() {
            this(Looper.getMainLooper());
            AppMethodBeat.i(11056);
            AppMethodBeat.o(11056);
        }

        public CallbackHandler(Looper looper) {
            super(looper);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.google.android.gms.common.api.ResultCallback */
        /* JADX WARN: Multi-variable type inference failed */
        public void handleMessage(Message message) {
            AppMethodBeat.i(11058);
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    ResultCallback resultCallback = (ResultCallback) pair.first;
                    Result result = (Result) pair.second;
                    try {
                        resultCallback.onResult(result);
                        AppMethodBeat.o(11058);
                        return;
                    } catch (RuntimeException e2) {
                        BasePendingResult.zzb(result);
                        AppMethodBeat.o(11058);
                        throw e2;
                    }
                case 2:
                    ((BasePendingResult) message.obj).zzb(Status.RESULT_TIMEOUT);
                    AppMethodBeat.o(11058);
                    return;
                default:
                    Log.wtf("BasePendingResult", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
                    AppMethodBeat.o(11058);
                    return;
            }
        }

        public final void zza(ResultCallback<? super R> resultCallback, R r) {
            AppMethodBeat.i(11057);
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
            AppMethodBeat.o(11057);
        }
    }

    /* access modifiers changed from: package-private */
    public final class zza {
        private zza() {
        }

        /* synthetic */ zza(BasePendingResult basePendingResult, zzo zzo) {
            this();
        }

        /* access modifiers changed from: protected */
        public final void finalize() {
            AppMethodBeat.i(11059);
            BasePendingResult.zzb(BasePendingResult.this.zzdm);
            super.finalize();
            AppMethodBeat.o(11059);
        }
    }

    @Deprecated
    BasePendingResult() {
        this.zzfa = new Object();
        this.zzfd = new CountDownLatch(1);
        this.zzfe = new ArrayList<>();
        this.zzfg = new AtomicReference<>();
        this.zzfm = false;
        this.zzfb = new CallbackHandler<>(Looper.getMainLooper());
        this.zzfc = new WeakReference<>(null);
    }

    @KeepForSdk
    @Deprecated
    protected BasePendingResult(Looper looper) {
        this.zzfa = new Object();
        this.zzfd = new CountDownLatch(1);
        this.zzfe = new ArrayList<>();
        this.zzfg = new AtomicReference<>();
        this.zzfm = false;
        this.zzfb = new CallbackHandler<>(looper);
        this.zzfc = new WeakReference<>(null);
    }

    @KeepForSdk
    protected BasePendingResult(GoogleApiClient googleApiClient) {
        this.zzfa = new Object();
        this.zzfd = new CountDownLatch(1);
        this.zzfe = new ArrayList<>();
        this.zzfg = new AtomicReference<>();
        this.zzfm = false;
        this.zzfb = new CallbackHandler<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.zzfc = new WeakReference<>(googleApiClient);
    }

    @VisibleForTesting
    @KeepForSdk
    protected BasePendingResult(CallbackHandler<R> callbackHandler) {
        this.zzfa = new Object();
        this.zzfd = new CountDownLatch(1);
        this.zzfe = new ArrayList<>();
        this.zzfg = new AtomicReference<>();
        this.zzfm = false;
        this.zzfb = (CallbackHandler) Preconditions.checkNotNull(callbackHandler, "CallbackHandler must not be null");
        this.zzfc = new WeakReference<>(null);
    }

    private final R get() {
        R r;
        boolean z = true;
        synchronized (this.zzfa) {
            if (this.zzfh) {
                z = false;
            }
            Preconditions.checkState(z, "Result has already been consumed.");
            Preconditions.checkState(isReady(), "Result is not ready.");
            r = this.zzdm;
            this.zzdm = null;
            this.zzff = null;
            this.zzfh = true;
        }
        zzcn andSet = this.zzfg.getAndSet(null);
        if (andSet != null) {
            andSet.zzc(this);
        }
        return r;
    }

    private final void zza(R r) {
        this.zzdm = r;
        this.zzfk = null;
        this.zzfd.countDown();
        this.mStatus = this.zzdm.getStatus();
        if (this.zzfi) {
            this.zzff = null;
        } else if (this.zzff != null) {
            this.zzfb.removeMessages(2);
            this.zzfb.zza(this.zzff, get());
        } else if (this.zzdm instanceof Releasable) {
            this.mResultGuardian = new zza(this, null);
        }
        ArrayList<PendingResult.StatusListener> arrayList = this.zzfe;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            PendingResult.StatusListener statusListener = arrayList.get(i2);
            i2++;
            statusListener.onComplete(this.mStatus);
        }
        this.zzfe.clear();
    }

    public static void zzb(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(result);
                new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void addStatusListener(PendingResult.StatusListener statusListener) {
        Preconditions.checkArgument(statusListener != null, "Callback cannot be null.");
        synchronized (this.zzfa) {
            if (isReady()) {
                statusListener.onComplete(this.mStatus);
            } else {
                this.zzfe.add(statusListener);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await() {
        boolean z = true;
        Preconditions.checkNotMainThread("await must not be called on the UI thread");
        Preconditions.checkState(!this.zzfh, "Result has already been consumed");
        if (this.zzfl != null) {
            z = false;
        }
        Preconditions.checkState(z, "Cannot await if then() has been called.");
        try {
            this.zzfd.await();
        } catch (InterruptedException e2) {
            zzb(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return get();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await(long j2, TimeUnit timeUnit) {
        boolean z = true;
        if (j2 > 0) {
            Preconditions.checkNotMainThread("await must not be called on the UI thread when time is greater than zero.");
        }
        Preconditions.checkState(!this.zzfh, "Result has already been consumed.");
        if (this.zzfl != null) {
            z = false;
        }
        Preconditions.checkState(z, "Cannot await if then() has been called.");
        try {
            if (!this.zzfd.await(j2, timeUnit)) {
                zzb(Status.RESULT_TIMEOUT);
            }
        } catch (InterruptedException e2) {
            zzb(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return get();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public void cancel() {
        synchronized (this.zzfa) {
            if (!this.zzfi && !this.zzfh) {
                if (this.zzfk != null) {
                    try {
                        this.zzfk.cancel();
                    } catch (RemoteException e2) {
                    }
                }
                zzb(this.zzdm);
                this.zzfi = true;
                zza(createFailedResult(Status.RESULT_CANCELED));
            }
        }
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public abstract R createFailedResult(Status status);

    @Override // com.google.android.gms.common.api.PendingResult
    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzfa) {
            z = this.zzfi;
        }
        return z;
    }

    @KeepForSdk
    public final boolean isReady() {
        return this.zzfd.getCount() == 0;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public final void setCancelToken(ICancelToken iCancelToken) {
        synchronized (this.zzfa) {
            this.zzfk = iCancelToken;
        }
    }

    @KeepForSdk
    public final void setResult(R r) {
        boolean z = true;
        synchronized (this.zzfa) {
            if (this.zzfj || this.zzfi) {
                zzb(r);
                return;
            }
            if (isReady()) {
            }
            Preconditions.checkState(!isReady(), "Results have already been set");
            if (this.zzfh) {
                z = false;
            }
            Preconditions.checkState(z, "Result has already been consumed");
            zza(r);
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        boolean z = true;
        synchronized (this.zzfa) {
            if (resultCallback == null) {
                this.zzff = null;
                return;
            }
            Preconditions.checkState(!this.zzfh, "Result has already been consumed.");
            if (this.zzfl != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot set callbacks if then() has been called.");
            if (!isCanceled()) {
                if (isReady()) {
                    this.zzfb.zza(resultCallback, get());
                } else {
                    this.zzff = resultCallback;
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j2, TimeUnit timeUnit) {
        boolean z = true;
        synchronized (this.zzfa) {
            if (resultCallback == null) {
                this.zzff = null;
                return;
            }
            Preconditions.checkState(!this.zzfh, "Result has already been consumed.");
            if (this.zzfl != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot set callbacks if then() has been called.");
            if (!isCanceled()) {
                if (isReady()) {
                    this.zzfb.zza(resultCallback, get());
                } else {
                    this.zzff = resultCallback;
                    CallbackHandler<R> callbackHandler = this.zzfb;
                    callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(2, this), timeUnit.toMillis(j2));
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> then;
        boolean z = true;
        Preconditions.checkState(!this.zzfh, "Result has already been consumed.");
        synchronized (this.zzfa) {
            Preconditions.checkState(this.zzfl == null, "Cannot call then() twice.");
            Preconditions.checkState(this.zzff == null, "Cannot call then() if callbacks are set.");
            if (this.zzfi) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot call then() if result was canceled.");
            this.zzfm = true;
            this.zzfl = new zzch<>(this.zzfc);
            then = this.zzfl.then(resultTransform);
            if (isReady()) {
                this.zzfb.zza(this.zzfl, get());
            } else {
                this.zzff = this.zzfl;
            }
        }
        return then;
    }

    public final void zza(zzcn zzcn) {
        this.zzfg.set(zzcn);
    }

    public final void zzb(Status status) {
        synchronized (this.zzfa) {
            if (!isReady()) {
                setResult(createFailedResult(status));
                this.zzfj = true;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final Integer zzo() {
        return null;
    }

    public final boolean zzw() {
        boolean isCanceled;
        synchronized (this.zzfa) {
            if (this.zzfc.get() == null || !this.zzfm) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public final void zzx() {
        this.zzfm = this.zzfm || zzez.get().booleanValue();
    }
}
