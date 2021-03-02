package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public final class PendingResults {

    static final class zza<R extends Result> extends BasePendingResult<R> {
        private final R zzdl;

        public zza(R r) {
            super(Looper.getMainLooper());
            AppMethodBeat.i(11045);
            this.zzdl = r;
            AppMethodBeat.o(11045);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public final R createFailedResult(Status status) {
            AppMethodBeat.i(11046);
            if (status.getStatusCode() != this.zzdl.getStatus().getStatusCode()) {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Creating failed results is not supported");
                AppMethodBeat.o(11046);
                throw unsupportedOperationException;
            }
            R r = this.zzdl;
            AppMethodBeat.o(11046);
            return r;
        }
    }

    static final class zzb<R extends Result> extends BasePendingResult<R> {
        private final R zzdm;

        public zzb(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.zzdm = r;
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public final R createFailedResult(Status status) {
            return this.zzdm;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzc<R extends Result> extends BasePendingResult<R> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public final R createFailedResult(Status status) {
            AppMethodBeat.i(11047);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Creating failed results is not supported");
            AppMethodBeat.o(11047);
            throw unsupportedOperationException;
        }
    }

    @KeepForSdk
    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        AppMethodBeat.i(11053);
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.cancel();
        AppMethodBeat.o(11053);
        return statusPendingResult;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R r) {
        AppMethodBeat.i(11054);
        Preconditions.checkNotNull(r, "Result must not be null");
        Preconditions.checkArgument(r.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        zza zza2 = new zza(r);
        zza2.cancel();
        AppMethodBeat.o(11054);
        return zza2;
    }

    @KeepForSdk
    public static <R extends Result> PendingResult<R> immediateFailedResult(R r, GoogleApiClient googleApiClient) {
        AppMethodBeat.i(11050);
        Preconditions.checkNotNull(r, "Result must not be null");
        Preconditions.checkArgument(!r.getStatus().isSuccess(), "Status code must not be SUCCESS");
        zzb zzb2 = new zzb(googleApiClient, r);
        zzb2.setResult(r);
        AppMethodBeat.o(11050);
        return zzb2;
    }

    @KeepForSdk
    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r) {
        AppMethodBeat.i(11051);
        Preconditions.checkNotNull(r, "Result must not be null");
        zzc zzc2 = new zzc(null);
        zzc2.setResult(r);
        OptionalPendingResultImpl optionalPendingResultImpl = new OptionalPendingResultImpl(zzc2);
        AppMethodBeat.o(11051);
        return optionalPendingResultImpl;
    }

    @KeepForSdk
    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r, GoogleApiClient googleApiClient) {
        AppMethodBeat.i(11052);
        Preconditions.checkNotNull(r, "Result must not be null");
        zzc zzc2 = new zzc(googleApiClient);
        zzc2.setResult(r);
        OptionalPendingResultImpl optionalPendingResultImpl = new OptionalPendingResultImpl(zzc2);
        AppMethodBeat.o(11052);
        return optionalPendingResultImpl;
    }

    @KeepForSdk
    public static PendingResult<Status> immediatePendingResult(Status status) {
        AppMethodBeat.i(11048);
        Preconditions.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.setResult(status);
        AppMethodBeat.o(11048);
        return statusPendingResult;
    }

    @KeepForSdk
    public static PendingResult<Status> immediatePendingResult(Status status, GoogleApiClient googleApiClient) {
        AppMethodBeat.i(11049);
        Preconditions.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(googleApiClient);
        statusPendingResult.setResult(status);
        AppMethodBeat.o(11049);
        return statusPendingResult;
    }
}
