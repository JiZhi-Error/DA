package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends BasePendingResult<BatchResult> {
    private final Object mLock;
    private int zzcd;
    private boolean zzce;
    private boolean zzcf;
    private final PendingResult<?>[] zzcg;

    public static final class Builder {
        private List<PendingResult<?>> zzci = new ArrayList();
        private GoogleApiClient zzcj;

        public Builder(GoogleApiClient googleApiClient) {
            AppMethodBeat.i(10975);
            this.zzcj = googleApiClient;
            AppMethodBeat.o(10975);
        }

        public final <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            AppMethodBeat.i(10976);
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(this.zzci.size());
            this.zzci.add(pendingResult);
            AppMethodBeat.o(10976);
            return batchResultToken;
        }

        public final Batch build() {
            AppMethodBeat.i(10977);
            Batch batch = new Batch(this.zzci, this.zzcj, null);
            AppMethodBeat.o(10977);
            return batch;
        }
    }

    private Batch(List<PendingResult<?>> list, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        AppMethodBeat.i(10978);
        this.mLock = new Object();
        this.zzcd = list.size();
        this.zzcg = new PendingResult[this.zzcd];
        if (list.isEmpty()) {
            setResult(new BatchResult(Status.RESULT_SUCCESS, this.zzcg));
            AppMethodBeat.o(10978);
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            PendingResult<?> pendingResult = list.get(i2);
            this.zzcg[i2] = pendingResult;
            pendingResult.addStatusListener(new zza(this));
        }
        AppMethodBeat.o(10978);
    }

    /* synthetic */ Batch(List list, GoogleApiClient googleApiClient, zza zza) {
        this(list, googleApiClient);
    }

    static /* synthetic */ int zzb(Batch batch) {
        int i2 = batch.zzcd;
        batch.zzcd = i2 - 1;
        return i2;
    }

    static /* synthetic */ void zze(Batch batch) {
        AppMethodBeat.i(10982);
        super.cancel();
        AppMethodBeat.o(10982);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult, com.google.android.gms.common.api.PendingResult
    public final void cancel() {
        AppMethodBeat.i(10979);
        super.cancel();
        for (PendingResult<?> pendingResult : this.zzcg) {
            pendingResult.cancel();
        }
        AppMethodBeat.o(10979);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final BatchResult createFailedResult(Status status) {
        AppMethodBeat.i(10980);
        BatchResult batchResult = new BatchResult(status, this.zzcg);
        AppMethodBeat.o(10980);
        return batchResult;
    }
}
