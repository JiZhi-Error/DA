package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;

public final class zzch<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    private final Object zzfa = new Object();
    private final WeakReference<GoogleApiClient> zzfc;
    private ResultTransform<? super R, ? extends Result> zzmd = null;
    private zzch<? extends Result> zzme = null;
    private volatile ResultCallbacks<? super R> zzmf = null;
    private PendingResult<R> zzmg = null;
    private Status zzmh = null;
    private final zzcj zzmi;
    private boolean zzmj = false;

    public zzch(WeakReference<GoogleApiClient> weakReference) {
        AppMethodBeat.i(11369);
        Preconditions.checkNotNull(weakReference, "GoogleApiClient reference must not be null");
        this.zzfc = weakReference;
        GoogleApiClient googleApiClient = this.zzfc.get();
        this.zzmi = new zzcj(this, googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        AppMethodBeat.o(11369);
    }

    static /* synthetic */ void zza(zzch zzch, Result result) {
        AppMethodBeat.i(11379);
        zzb(result);
        AppMethodBeat.o(11379);
    }

    static /* synthetic */ void zza(zzch zzch, Status status) {
        AppMethodBeat.i(11380);
        zzch.zzd(status);
        AppMethodBeat.o(11380);
    }

    private static void zzb(Result result) {
        AppMethodBeat.i(11378);
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
                AppMethodBeat.o(11378);
                return;
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(result);
                new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf);
            }
        }
        AppMethodBeat.o(11378);
    }

    @GuardedBy("mSyncToken")
    private final void zzcb() {
        AppMethodBeat.i(11374);
        if (this.zzmd == null && this.zzmf == null) {
            AppMethodBeat.o(11374);
            return;
        }
        GoogleApiClient googleApiClient = this.zzfc.get();
        if (!(this.zzmj || this.zzmd == null || googleApiClient == null)) {
            googleApiClient.zza(this);
            this.zzmj = true;
        }
        if (this.zzmh != null) {
            zze(this.zzmh);
            AppMethodBeat.o(11374);
            return;
        }
        if (this.zzmg != null) {
            this.zzmg.setResultCallback(this);
        }
        AppMethodBeat.o(11374);
    }

    @GuardedBy("mSyncToken")
    private final boolean zzcd() {
        AppMethodBeat.i(11377);
        GoogleApiClient googleApiClient = this.zzfc.get();
        if (this.zzmf == null || googleApiClient == null) {
            AppMethodBeat.o(11377);
            return false;
        }
        AppMethodBeat.o(11377);
        return true;
    }

    private final void zzd(Status status) {
        AppMethodBeat.i(11375);
        synchronized (this.zzfa) {
            try {
                this.zzmh = status;
                zze(this.zzmh);
            } finally {
                AppMethodBeat.o(11375);
            }
        }
    }

    private final void zze(Status status) {
        AppMethodBeat.i(11376);
        synchronized (this.zzfa) {
            try {
                if (this.zzmd != null) {
                    Status onFailure = this.zzmd.onFailure(status);
                    Preconditions.checkNotNull(onFailure, "onFailure must not return null");
                    this.zzme.zzd(onFailure);
                } else if (zzcd()) {
                    this.zzmf.onFailure(status);
                }
            } finally {
                AppMethodBeat.o(11376);
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    public final void andFinally(ResultCallbacks<? super R> resultCallbacks) {
        boolean z = true;
        AppMethodBeat.i(11371);
        synchronized (this.zzfa) {
            try {
                Preconditions.checkState(this.zzmf == null, "Cannot call andFinally() twice.");
                if (this.zzmd != null) {
                    z = false;
                }
                Preconditions.checkState(z, "Cannot call then() and andFinally() on the same TransformedResult.");
                this.zzmf = resultCallbacks;
                zzcb();
            } finally {
                AppMethodBeat.o(11371);
            }
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(R r) {
        AppMethodBeat.i(11372);
        synchronized (this.zzfa) {
            try {
                if (!r.getStatus().isSuccess()) {
                    zzd(r.getStatus());
                    zzb(r);
                } else if (this.zzmd != null) {
                    zzbw.zzbe().submit(new zzci(this, r));
                } else if (zzcd()) {
                    this.zzmf.onSuccess(r);
                }
            } finally {
                AppMethodBeat.o(11372);
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        zzch<? extends Result> zzch;
        boolean z = true;
        AppMethodBeat.i(11370);
        synchronized (this.zzfa) {
            try {
                Preconditions.checkState(this.zzmd == null, "Cannot call then() twice.");
                if (this.zzmf != null) {
                    z = false;
                }
                Preconditions.checkState(z, "Cannot call then() and andFinally() on the same TransformedResult.");
                this.zzmd = resultTransform;
                zzch = new zzch<>(this.zzfc);
                this.zzme = zzch;
                zzcb();
            } finally {
                AppMethodBeat.o(11370);
            }
        }
        return zzch;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.gms.common.api.PendingResult<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zza(PendingResult<?> pendingResult) {
        AppMethodBeat.i(11373);
        synchronized (this.zzfa) {
            try {
                this.zzmg = pendingResult;
                zzcb();
            } finally {
                AppMethodBeat.o(11373);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzcc() {
        this.zzmf = null;
    }
}
