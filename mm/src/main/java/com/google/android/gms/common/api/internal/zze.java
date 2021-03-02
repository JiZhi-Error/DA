package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zze extends zzc<Void> {
    private final RegisterListenerMethod<Api.AnyClient, ?> zzdw;
    private final UnregisterListenerMethod<Api.AnyClient, ?> zzdx;

    public zze(zzbv zzbv, TaskCompletionSource<Void> taskCompletionSource) {
        super(3, taskCompletionSource);
        this.zzdw = zzbv.zzlt;
        this.zzdx = zzbv.zzlu;
    }

    @Override // com.google.android.gms.common.api.internal.zzb, com.google.android.gms.common.api.internal.zzc
    public final /* bridge */ /* synthetic */ void zza(Status status) {
        AppMethodBeat.i(11399);
        super.zza(status);
        AppMethodBeat.o(11399);
    }

    @Override // com.google.android.gms.common.api.internal.zzb, com.google.android.gms.common.api.internal.zzc
    public final /* bridge */ /* synthetic */ void zza(zzaa zzaa, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zzb, com.google.android.gms.common.api.internal.zzc
    public final /* bridge */ /* synthetic */ void zza(RuntimeException runtimeException) {
        AppMethodBeat.i(11398);
        super.zza(runtimeException);
        AppMethodBeat.o(11398);
    }

    @Override // com.google.android.gms.common.api.internal.zzc
    public final void zzb(GoogleApiManager.zza<?> zza) {
        AppMethodBeat.i(11397);
        this.zzdw.registerListener(zza.zzae(), this.zzdu);
        if (this.zzdw.getListenerKey() != null) {
            zza.zzbn().put(this.zzdw.getListenerKey(), new zzbv(this.zzdw, this.zzdx));
        }
        AppMethodBeat.o(11397);
    }
}
