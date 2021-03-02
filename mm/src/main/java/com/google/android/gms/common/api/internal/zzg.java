package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzg extends zzc<Boolean> {
    private final ListenerHolder.ListenerKey<?> zzea;

    public zzg(ListenerHolder.ListenerKey<?> listenerKey, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.zzea = listenerKey;
    }

    @Override // com.google.android.gms.common.api.internal.zzb, com.google.android.gms.common.api.internal.zzc
    public final /* bridge */ /* synthetic */ void zza(Status status) {
        AppMethodBeat.i(11408);
        super.zza(status);
        AppMethodBeat.o(11408);
    }

    @Override // com.google.android.gms.common.api.internal.zzb, com.google.android.gms.common.api.internal.zzc
    public final /* bridge */ /* synthetic */ void zza(zzaa zzaa, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zzb, com.google.android.gms.common.api.internal.zzc
    public final /* bridge */ /* synthetic */ void zza(RuntimeException runtimeException) {
        AppMethodBeat.i(11407);
        super.zza(runtimeException);
        AppMethodBeat.o(11407);
    }

    @Override // com.google.android.gms.common.api.internal.zzc
    public final void zzb(GoogleApiManager.zza<?> zza) {
        AppMethodBeat.i(11406);
        zzbv remove = zza.zzbn().remove(this.zzea);
        if (remove != null) {
            remove.zzlu.unregisterListener(zza.zzae(), this.zzdu);
            remove.zzlt.clearListener();
            AppMethodBeat.o(11406);
            return;
        }
        this.zzdu.trySetResult(Boolean.FALSE);
        AppMethodBeat.o(11406);
    }
}
