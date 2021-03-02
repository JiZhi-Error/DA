package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzb<T> extends zzn<Status> {
    private T zzaw;
    private ListenerHolder<T> zzax;
    private zzc<T> zzay;

    private zzb(GoogleApiClient googleApiClient, T t, ListenerHolder<T> listenerHolder, zzc<T> zzc) {
        super(googleApiClient);
        AppMethodBeat.i(101043);
        this.zzaw = (T) Preconditions.checkNotNull(t);
        this.zzax = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        this.zzay = (zzc) Preconditions.checkNotNull(zzc);
        AppMethodBeat.o(101043);
    }

    static <T> PendingResult<Status> zza(GoogleApiClient googleApiClient, zzc<T> zzc, T t) {
        AppMethodBeat.i(101042);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzb(googleApiClient, t, googleApiClient.registerListener(t), zzc));
        AppMethodBeat.o(101042);
        return enqueue;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        this.zzaw = null;
        this.zzax = null;
        return status;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(101044);
        this.zzay.zza(zzhg, this, this.zzaw, this.zzax);
        this.zzaw = null;
        this.zzax = null;
        AppMethodBeat.o(101044);
    }
}
